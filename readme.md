# pom.xml
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
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
mvn --setting settings.xml deploy
```

# 访问页面

启动后访问 localhost:8080 即可

# 切换页面

将 MainController 下的如下代码

```java
  @RequestMapping("/")
  public String one(){
    return "index_a.html";
  }

  @RequestMapping("/another")
  public String two(){
    return "index_b.html";
  }
```

改为

```java

  @RequestMapping("/another")
  public String one(){
    return "index_a.html";
  }

  @RequestMapping("/")
  public String two(){
    return "index_b.html";
  }

```
即可