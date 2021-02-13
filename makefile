.PHONY: up down clean build

up: build
	docker-compose up --detach --force-recreate

down:
	docker-compose stop

clean:
	docker-compose down
	docker volume prune --force

build:
	docker build -t nogi-profile .
	docker build -t nogi-profile-mysql -f ddl/Dockerfile .
