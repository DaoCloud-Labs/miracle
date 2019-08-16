# Miracle Service

## 如何构建 Docker 镜像
> 推荐容器化部署，直接构建 Docker 镜像
```bash
docker build .
```

## 如何用 mvn 打包并推送到私有 Nexus
> 若不选择容器化部署，只是想推送到私有 maven 仓库，直接使用 jar，可以参考以下步骤
#### 1. 修改 pom.xml
- 将 repository/url 改为私有 maven 仓库地址
```xml
<groupId>io.daocloud</groupId>
<artifactId>miracle</artifactId>
...
<distributionManagement>
  <repository>
    <id>nexus-maven</id>
    <name>Nexus Maven</name>
    <url>http://${MAVEN-SERVER}:${PORT}/repository/maven-releases/</url>
  </repository>
</distributionManagement>
```
#### 2. 修改 settings.xml
- 将 server/id 保持与 pom 中的 repository/id 一致，并在 server/username 和 server/password 中填入私有 maven 仓库的账号密码
- 将 repositories/repository/url 和 pluginRepositories/pluginRepository/url 都改成私有 maven 仓库地址
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
    <url>http://${MAVEN-SERVER}:${PORT}/repository/maven-releases/</url>
...
<pluginRepositories>
  <pluginRepository>
    <id>nexus</id>
    <url>http://${MAVEN-SERVER}:${PORT}/repository/maven-releases/</url>
```
#### 3. 打包并推送
```bash
mvn --settings settings.xml deploy
```

## 如何部署
#### 1. 通过 DCS 部署应用实例到 DCE
用部署类项目中的 YAML 文件通过 DCS 部署 miracle 和 miracle-frontend。若不会编写部署 YAML 文件，可以利用 DCS 部署时在线生成 YAML 模板的功能。
#### 2. 健康检查
```bash
curl ${IP}:8080/health # 返回success的字符串说明启动成功
```
#### 3. 浏览器访问页面
```bash
http://${IP}:8080/index
```

## 如何修改代码实现切换页面
将 src/main/java/io/daocloud/miracle/controller/MainController.java 下的如下代码
```java
    Resource cpr = new ClassPathResource("static/indexA.jpg");
```
改为
```java
    Resource cpr = new ClassPathResource("static/indexB.jpg");
```

