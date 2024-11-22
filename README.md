# properties 설정
## 파일 생성
src/resources/application.properties<br/>
src/resources/application-oauth.properties<br/>

위의 경로에 파일 생성

## application.properties
```properties
spring.application.name=oauth

# MySQL 설정 {}에 실제 환경의 값 넣기
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://{host_ip}:{host_port}/{database_name}
spring.datasource.username={database_username}
spring.datasource.password={database_password}

# ---------------------------------------------------------------
#JPA 설정

# JPA Query 확인
spring.jpa.show-sql=true

spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.format_sql=true
# ---------------------------------------------------------------
# OAuth2 설정파일 불러오기
spring.profiles.include=oauth
```
## application-oauth.properties
```properties
# Google Oauth2 설정 {}에 실제 환경값 넣기
spring.security.oauth2.client.registration.google.client-id={google_client_id}
spring.security.oauth2.client.registration.google.client-secret={google_client_secret}
spring.security.oauth2.client.registration.google.scope=profile,email
```