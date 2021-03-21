.PHONY: build

build:
	docker build -t nogi-profile -f Dockerfile .
