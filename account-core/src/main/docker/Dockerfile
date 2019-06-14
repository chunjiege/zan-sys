FROM java:8
VOLUME /tmp
ADD account-core-1.0-SNAPSHOT.jar account-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/account-server.jar"]
EXPOSE 8761
