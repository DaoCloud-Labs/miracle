# pom.xml
```xml
<groupId>io.daocloud</groupId>
<artifactId>miracle</artifactId>
...
<distributionManagement>
  <repository>
    <id>nexus-maven</id>
    <name>Nexus Maven</name>
    <url>http://172.16.111.31:30081/repository/maven-releases/</url>
  </repository>
</distributionManagement>
```

# settings.xml
```xml
<server>
  <id>nexus-maven</id>
  <username>admin</username>
  <password>admin123</password>
</server>
...
<repositories>
  <repository>
    <id>nexus</id>
    <url>http://172.16.111.31:30081/repository/maven-releases/</url>
...
<pluginRepositories>
  <pluginRepository>
    <id>nexus</id>
    <url>http://172.16.111.31:30081/repository/maven-releases/</url>
```

# 构建
```bash
mvn --settings settings.xml deploy
```

# 访问页面

启动后访问 {ip}:8080/index

# 切换页面

将 MainController 下的如下代码

```java
  @GetMapping(value = "/index", produces = MediaType.IMAGE_JPEG_VALUE)
  @ResponseBody
  public String indexA() throws IOException {
    Resource cpr = new ClassPathResource("static/indexA.jpg");
    //for test
    BASE64Encoder encoder = new BASE64Encoder();
    return encoder.encode(FileCopyUtils.copyToByteArray(cpr.getInputStream()));
  }
```

改为

```java

  @GetMapping(value = "/index", produces = MediaType.IMAGE_JPEG_VALUE)
  @ResponseBody
  public String indexA() throws IOException {
    Resource cpr = new ClassPathResource("static/indexB.jpg");
    //for test
    BASE64Encoder encoder = new BASE64Encoder();
    return encoder.encode(FileCopyUtils.copyToByteArray(cpr.getInputStream()));
  }

```