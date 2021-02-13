up:
	docker build -t nogi-profile .
	docker-compose up --detach --force-recreate

down:
	docker-compose stop

clean:
	docker-compose down
	docker volume prune --force
