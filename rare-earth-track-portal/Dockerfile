FROM openjdk:17
ADD ./target/rare-earth-track-portal-1.0-SNAPSHOT-exec.jar /
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod","/rare-earth-track-portal-1.0-SNAPSHOT-exec.jar"]
