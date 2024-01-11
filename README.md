### start-spring [스프링 입문]

#### 프로젝트 생성
버전 수정 <br>
[File] - [Settings] 이동 <br>
gradle 검색 <br>
Run IntelliJ로 수정 <br>

#### 빌드하고 실행하기
SNAPSHOT.jar는 실행가능한 아카이브이고, SNAPSHOT-plain.jar는 실행이 불가능한 일반 아카이브이다.<br>
스프링부트 2.5부터 빌드시 기본적으로 2가지 파일이 떨어지게 되었는데, 빌드시 plain.jar를 생성하지 않으려면 build.gradle에 아래 내용을 추가해주면 된다.<br>
jar {
      enabled = false
  }

#### JPA
- Member.java 수정 <br>
@GeneratedValue(strategy = GenerationType.SEQUENCE) <br>
- application.properties 수정 <br>
spring.jpa.hibernate.ddl-auto=create <br>


### basic-spring [스프링 핵심 원리 - 기본편]
