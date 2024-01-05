FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY build/libs/*.jar feladat.jar
ENTRYPOINT ["java","-jar","/feladat.jar"]