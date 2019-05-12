FROM java:8
VOLUME /tmp
ADD sys-core-1.0-SNAPSHOT.jar sys-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/sys-server.jar"]
EXPOSE 8761
