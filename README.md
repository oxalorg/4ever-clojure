# 4ever-clojure

Unfortunately 4clojure is shutting down: https://twitter.com/borkdude/status/1412117420173561861

> Now that 4clojure is shutting down (thanks for all the year of hosting it!),
> perhaps it's time to consider some alternatives. - borkdude

@borkdude suggested this in his tweet:

> Another alternative would be to port it to self-hosted CLJS or sci and host it
> on Github pages and use localstorage. No need to maintain a running JVM server
> somewhere that way. Perhaps with the option to download your solutions as an
> archive.

And so I made it, using the awesome [sci](https://github.com/borkdude/sci) and special thanks to [4bb](https://github.com/porkostomus/4bb) from where I copied the problems edn.

## Live

Deployed at [https://4clojure.oxal.org/](https://4clojure.oxal.org/)

## Develop

This project uses shadow-cljs, so the easiest way to use this would be:

```
npm install # only needed once
npx shadow-cljs watch :my-build
```

If you are a fan of emacs and cider, then you can open up emacs and run
`cider-jack-in-cljs`. It will automatically start shadow-cljs in watch
mode.

shadow hosts the dev server at http://localhost:8000

## Todos

- [x] Ship a crude version
- [ ] Make it noice!
- [x] use localstorage to store solutions
- [ ] easy navigation
- [ ] scrape problem difficulty (can perhaps also get ranks data?)
- [ ] better alerts (modals?)
- [ ] show user which problems they have solved
- [ ] import /export data of the user in a .edn file
- [ ] github actions auto deployment
- [ ] create a new section of problems "community powered questions"
- [ ] add new community problems directly via github
