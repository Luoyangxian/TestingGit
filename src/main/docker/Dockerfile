FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD eurekaclient1-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eurekaclient1-0.0.1-SNAPSHOT.jar"]