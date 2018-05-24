## disconf-auto是一个自动化上传disconf配置文件的可执行jar。

## 使用
```
java -Ddeploy.list.path=E:/deploy_list.txt -Djar.dir=E:/IdeaProjects/fcbox-ad/fcbox-ad-gateway/target -Ddisconf.host.user.name.pwd=10.204.49.37@admin:admin; -jar disconf-auto-1.0.jar
```

```
-Ddeploy.list.path 是指定的发布文件路径，文件内容是发布包的名称（例如：cn-store-service-3.5.war）一行一个名称，多个就是多行。
-Djar.dir          是发布包文件的所在目录。
-Ddisconf.host.user.name.pwd 是disconf控制台的访问IP或者域名加账号密码（组成：disconf控制台访问IP或域名 @ 用户名：密码），多个使用英文分号（;）进行分割。
```                             

## jar、war包配置
```properties
#是否开启自动上传（true、false）
enable.auto.upload=true
#是否自动覆盖现有配置（true、false）
enable.auto.override=true
```

在disconf.properties文件中进行配置。

## disconf文件存放要求
disconf文件、或者配置项必须以如下结构存放

```java
-src
  -main
    -resources
      -config
        -disconf
          -rd
            watchConfFile.properties
            sysConfig.properties
            redisConfig.properties
          -qa
            watchConfFile.properties
            sysConfig.properties
            redisConfig.properties
          -online
            watchConfFile.properties
            sysConfig.properties
            redisConfig.properties
```

其中 
```
 -disconf
    -rd
    -qa
    -online
```
这个目录结构是不能改变的因为disconf-auto是按照这个目录结构加载配置的，disconf文件夹名称不能变，
下面的环境（rd、qa、online）文件夹可根据你的环境名称而变，watch配置项的watchConfFile.properties文件名称是不能改变的，
disconf-auto是到这个名称的文件中加载disconf的watche配置项的。 

本地开发可结合maven插件disconf-auto-maven-plugin使用：https://github.com/wjwei/disconf-auto-maven-plugin

