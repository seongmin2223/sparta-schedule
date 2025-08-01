sparta-schedule🌟 프로젝트 소개Spring Boot를 활용하여 간단한 일정 관리 RESTful API를 구현한 백엔드 애플리케이션입니다. 기본적인 CRUD(Create, Read, Update, Delete) 기능을 제공하며, JPA를 통해 데이터베이스와 연동됩니다.🛠️ 기술 스택Java: 17Spring Boot: 3.xSpring Data JPA: HibernateDatabase: MySQLBuild Tool: Gradle🚀 주요 기능 및 API 명세1. 일정 등록 (Create)새로운 일정을 등록합니다.HTTP Method: POSTEndpoint: /scheduleRequest Body:{
  "title": "할 일 제목",
  "content": "할 일 내용",
  "author": "작성자명",
  "password": "비밀번호"
}
Response: 등록된 일정 정보를 반환합니다. (비밀번호 제외)2. 전체 일정 조회 (Read)등록된 모든 일정을 조회합니다.HTTP Method: GETEndpoint: /scheduleResponse: 모든 일정 목록을 반환합니다. (비밀번호 제외)3. 특정 일정 조회 (Read)특정 ID의 일정 정보를 조회합니다.HTTP Method: GETEndpoint: /findOneSchedule/{id}Response: 선택한 일정 정보를 반환합니다. (비밀번호 제외)4. 일정 수정 (Update)특정 ID의 일정 제목(title)과 작성자명(author)을 수정합니다.HTTP Method: PUTEndpoint: /updateSchedule/{id}Request Body:비밀번호가 일치해야만 수정이 가능합니다.{
  "title": "수정된 제목",
  "author": "수정된 작성자",
  "password": "기존 비밀번호"
}
Response: 수정된 일정 정보를 반환합니다. (비밀번호 제외)5. 일정 삭제 (Delete)특정 ID의 일정을 삭제합니다.HTTP Method: DELETEEndpoint: /deleteSchedule/{id}Response: 삭제 성공 메시지를 반환합니다.
