# hello-spring [스프링 입문]

### ch 01. 강의 소개

### ch 02. 프로젝트 환경 설정

#### 프로젝트 생성
버전 수정 <br>
[File] - [Settings] 이동 <br>
gradle 검색 <br>
Run IntelliJ로 수정 <br>

#### 라이브러리 살펴보기
spring-boot-starter-web<br>
spring-boot-starter-thymeleaf<br>
spring-boot-starter<br>

#### 빌드하고 실행하기
SNAPSHOT.jar는 실행가능한 아카이브이고, SNAPSHOT-plain.jar는 실행이 불가능한 일반 아카이브이다.
스프링부트 2.5부터 빌드시 기본적으로 2가지 파일이 떨어지게 되었는데, 빌드시 plain.jar를 생성하지 않으려면 build.gradle에 아래 내용을 추가해주면 된다.<br>
jar {
      enabled = false
  }

### ch 03. 스프링 웹 개발 기초
#### 정적 컨텐츠
(껐다가 다시 실행하는건 저장의 개념인가?)
#### MVC와 템플릿 엔진
MVC: Model, View, Controller <br>
localhost:8080/hello-mvc?name=spring!
#### API


### ch 06. 스프링 DB 접근 기술
#### JPA
@GeneratedValue(strategy = GenerationType.SEQUENCE)
