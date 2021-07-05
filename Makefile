.PHONY=release deploy

release:
	npx shadow-cljs release :my-build

deploy: release
	rsync -a public/ ark:/srv/ox/4clojure
