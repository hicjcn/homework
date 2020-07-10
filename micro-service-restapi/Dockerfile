FROM java:8

MAINTAINER hicjcn hicjcn@gmail

VOLUME /app

ADD ./target/micro-service-restapi-1.0.0.jar app.jar

RUN bash -c 'touch /app.jar'

EXPOSE 80

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar", "--spring.profiles.active=pro"]
