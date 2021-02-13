.PHONY: up clean

up:
	docker build -t nogi-profile .
	@docker-compose up --force-recreate

clean:
	@docker-compose down
	@docker volume prune --force
