# 1) build

```sh
./gradlew package
```

Artifacts are build on local repos: `.build/repo`.

# 2) run an example

```sh
digdag selfupdate

digdag run --project sample plugin.dig -p repos=`pwd`/build/repo
```

You'll find the result of the task in `./sample/example.out`.
