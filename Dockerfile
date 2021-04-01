FROM openjdk:11 AS worker

SHELL ["/bin/bash", "-c"]

WORKDIR /usr/local/src
RUN apt update && apt install zip unzip -y &&\
	/bin/bash -c "curl -s \"https://get.sdkman.io\" | bash && source \"/root/.sdkman/bin/sdkman-init.sh\" && sdk install gradle"
ENV PATH=~/.sdkman/candidates/gradle/current/bin:$PATH

WORKDIR /app
COPY build.gradle .
COPY settings.gradle .
RUN gradle build -x bootJar
COPY src/ src/
RUN gradle build -x test &&\
	cp build/libs/nogi-profile-api-*.jar nogi-profile-api.jar

FROM openjdk:11

WORKDIR /app
COPY --from=worker /app/nogi-profile-api.jar .
COPY docker/ .

CMD [ "java", "-jar", "nogi-profile-api.jar" ]
