NAME=$(notdir $(shell pwd))
TAG:=latest

build:
	echo "Building image $(NAME):$(TAG)"
	docker build --pull -f src/main/docker/Dockerfile -t $(NAME):$(TAG) binary