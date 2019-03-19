NAME=$(notdir $(shell pwd))
TAG:=latest

build:
	echo "Building image $(NAME):$(TAG)"
	docker build --pull -f ./Dockerfile -t $(NAME):$(TAG) .