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

--

# Plugin Loading

Digdag loads pluigins from Maven repositories by configuring [plugin options](https://github.com/myui/digdag-plugin-example/blob/master/sample/plugin.dig).

You can use a local Maven repository (local FS, Amazon S3) or any public Maven repository ([Maven Central](http://search.maven.org/), [Sonatype](https://www.sonatype.com/), [Bintary](https://bintray.com/), [Jitpack](https://jitpack.io/)) for the plugin artifact repository.

--

# Further reading

- [Operators](http://docs.digdag.io/operators.html) and [their implementations](https://github.com/treasure-data/digdag/tree/master/digdag-standards/src/main/java/io/digdag/standards/operator)
