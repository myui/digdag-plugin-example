# 1) build

```sh
./gradlew package
```

You can optionally create Eclipse/Idea project files as follows:
```sh
gradle eclipse
gradle idea
```

Artifacts are build on local repos: `.build/repo`.

# 2) run an example

```sh
digdag selfupdate

digdag run --project sample plugin.dig -p repos=`pwd`/build/repo
```

You'll find the result of the task in `./sample/example.out`.

---

# Further reading

- [Operators](http://docs.digdag.io/operators.html) and [their implementations](https://github.com/treasure-data/digdag/tree/master/digdag-standards/src/main/java/io/digdag/standards/operator)
