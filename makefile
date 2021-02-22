.PHONY: up run gs logs down clean build

up: build
	docker-compose up --detach --force-recreate
	@docker exec nogi-profile.web sleep 5
	@make run

run:
	@docker exec -d nogi-profile.web /bin/sh -c - "java -jar nogi-profile.jar >/var/log/nogi-profile.log 2>&1"

gs:
	@docker exec nogi-profile.web /bin/bash bin/kill.sh

logs:
	@docker exec nogi-profile.web tail /var/log/nogi-profile.log -n 30 -f

down:
	docker-compose stop --timeout 1

clean:
	docker-compose down
	docker volume prune --force

build:
	docker build -t nogi-profile -f Dockerfile .
	docker build -t nogi-profile-mysql -f docker/mysql/Dockerfile .
