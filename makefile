.PHONY: build

build:
	docker build -t nogi-profile-api -f Dockerfile .
