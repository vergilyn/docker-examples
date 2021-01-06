# (docker-maven) Google Jib

+ [GoogleContainerTools/jib](https://github.com/GoogleContainerTools/jib)

- [加速和简化构建Docker(基于Google jib)](https://www.cnblogs.com/jpfss/p/10931218.html)

## Examples
The [examples](https://github.com/GoogleContainerTools/jib/blob/master/examples) directory includes the following examples (and more).
- [helloworld](https://github.com/GoogleContainerTools/jib/blob/master/examples/helloworld)
- [Spring Boot](https://github.com/GoogleContainerTools/jib/blob/master/examples/spring-boot)
- [Micronaut](https://github.com/GoogleContainerTools/jib/blob/master/examples/micronaut)
- [Multi-module project](https://github.com/GoogleContainerTools/jib/blob/master/examples/multi-module)
- [Spark Java using Java Agent](https://github.com/GoogleContainerTools/jib/blob/master/examples/java-agent)

##
+ [Credential - Using Maven Settings](https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin#using-maven-settings)

> **If you're considering putting credentials in Maven, we highly recommend using [maven password encryption](https://maven.apache.org/guides/mini/guide-encryption.html).**

Example maven `settings.xml`:
```XML
<settings>
  ...
  <servers>
    ...
    <server>
      <id>MY_REGISTRY</id>
      <username>MY_USERNAME</username>
      <password>{MY_SECRET}</password>
    </server>
  </servers>
</settings>
```

