.PHONY: up run log down clean build

up: build
	docker-compose up --detach --force-recreate
	@docker exec web sleep 5
	@make run

run:
	@docker exec -d web /bin/sh -c - "java -jar nogi-profile.jar >/var/log/nogi-profile.log 2>&1"
	@docker exec web ps ax

log:
	@docker exec web tail /var/log/nogi-profile.log -n 30 -f

down:
	docker-compose stop --timeout 1

clean:
	docker-compose down
	docker volume prune --force

build:
	docker build -t nogi-profile .
	docker build -t nogi-profile-mysql -f ddl/Dockerfile .
