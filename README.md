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

---

# Writing your own plugin

1. You need to implement [a Plugin class](https://github.com/myui/digdag-plugin-example/blob/master/src/main/java/io/digdag/plugin/example/ExamplePlugin.java) that implements `io.digdag.spi.Plugin`.

2. Then, list it on [io.digdag.spi.Plugin](https://github.com/myui/digdag-plugin-example/blob/master/src/main/resources/META-INF/services/io.digdag.spi.Plugin). The listed plugins are loaded by Digdag.

You can optionally create Eclipse/Idea project files as follows:
```sh
gradle eclipse
gradle idea
```

*Note:* _It's better to change the dependencies from `provided` to `compile` in [build.gradle](https://github.com/myui/digdag-plugin-example/blob/master/build.gradle) for creating idea/eclipse project config._

# Plugin Loading

Digdag loads pluigins from Maven repositories by configuring [plugin options](https://github.com/myui/digdag-plugin-example/blob/master/sample/plugin.dig).

You can use a local Maven repository (local FS, Amazon S3) or any public Maven repository ([Maven Central](http://search.maven.org/), [Sonatype](https://www.sonatype.com/), [Bintary](https://bintray.com/), [Jitpack](https://jitpack.io/)) for the plugin artifact repository.

# Further reading

- [Operators](http://docs.digdag.io/operators.html) and [their implementations](https://github.com/treasure-data/digdag/tree/master/digdag-standards/src/main/java/io/digdag/standards/operator)
