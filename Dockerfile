FROM openjdk:11

WORKDIR /app
COPY mvnw .
COPY .mvn/ .mvn/
COPY pom.xml .
RUN ./mvnw install -Dmaven.test.skip=true ; echo ""
COPY src/ src/
RUN ./mvnw install -Dmaven.test.skip=true

CMD [ "./mvnw", "spring-boot:run" ]
