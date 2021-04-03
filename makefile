.PHONY: init build run reload gs logs

define APP_RUN
	@docker exec -d nogi-profile.api /bin/sh -c - "java -jar nogi-profile-api.jar >/var/log/nogi-profile.log 2>&1"
endef

define ECLIPSE_LOAD
	@.\gradlew eclipse
endef

init:
	$(call ECLIPSE_LOAD)

build:
	docker build -t nogi-profile-api -f Dockerfile .

run:
	@docker exec nogi-profile.api sleep 5
	$(call APP_RUN)

reload:
	$(call ECLIPSE_LOAD)

gs:
	@docker exec nogi-profile.api /bin/bash bin/kill.sh

logs:
	@docker exec nogi-profile.api tail /var/log/nogi-profile.log -n 200 -f
