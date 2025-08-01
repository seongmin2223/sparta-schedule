package org.example.scheduleapp.service;

import lombok.RequiredArgsConstructor;
import org.example.scheduleapp.dto.ScheduleRequestDto;
import org.example.scheduleapp.dto.ScheduleResponseDto;
import org.example.scheduleapp.entity.Schedule;
import org.example.scheduleapp.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule(scheduleRequestDto);
        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule);
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAllSchedule() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponseDto> scheduleResponseDtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            scheduleResponseDtos.add(new ScheduleResponseDto(schedule));
        }
        return scheduleResponseDtos;
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findOneSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("해당 ID의 일정이 존재하지 않습니다: " + id)
        );
        return new ScheduleResponseDto(schedule);
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(ScheduleRequestDto scheduleRequestDto, Long id){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("해당 ID의 일정이 존재하지 않습니다." + id)
        );
        if (!schedule.getPassword().equalsIgnoreCase(scheduleRequestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀려요");
        }
        schedule.update(scheduleRequestDto);
        return new  ScheduleResponseDto(schedule);
    }

    @Transactional
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException("\"해당 ID의 일정이 존재하지 않습니다:" + id)
        );

        scheduleRepository.delete(schedule);
    }
}