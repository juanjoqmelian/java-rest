FROM maven:latest
MAINTAINER Juan Quintana <juan.quintana@luxuriem.com> 
ADD . /build/users
WORKDIR /build/users
RUN mvn clean package
RUN ls target
CMD java -jar target/users-java-0.0.1-SNAPSHOT.jar
