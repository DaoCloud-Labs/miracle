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