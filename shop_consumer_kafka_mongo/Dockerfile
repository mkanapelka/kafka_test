FROM openjdk:11-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} consumer.jar
ENTRYPOINT ["java", "-Xms4G", "-Xmx4G", "-XX:MaxMetaspaceSize=256M", "-XX:+UseG1GC", "-Dfile.encoding=UTF8", "-jar", "consumer.jar"]
