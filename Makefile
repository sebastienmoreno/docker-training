SUBDIRS := disco sleep pull

build:
	for dockerproject in $(SUBDIRS) ; do cd "$${dockerproject}" && make build; cd ../; done
