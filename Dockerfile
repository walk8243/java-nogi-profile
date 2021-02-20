FROM openjdk:11

WORKDIR /app
COPY mvnw .
COPY .mvn/ .mvn/
COPY pom.xml .
RUN ./mvnw install -Dmaven.test.skip=true ; echo ""
COPY src/ src/
RUN ./mvnw install -Dmaven.test.skip=true &&\
	ln -s /app/target/nogi-profile-0.0.1-SNAPSHOT.jar /app/nogi-profile.jar

CMD [ "java", "-jar", "nogi-profile.jar" ]
