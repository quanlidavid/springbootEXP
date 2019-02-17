Spring Boot2 的学习笔记
====
## 环境相关
#### Maven安装

解压apache-maven-3.6.0 到/Users/quanli，加入maven的path
```
export PATH="/Users/quanli/apache-maven-3.6.0/bin:$PATH"
```
在IDEA 界面中【Settings 】,在出现的窗口中找到Maven 选项，
分别把【Maven home directoy】【User settings file】【Local repositoy 】设置为自己Maven的相关目录.

#### 在settings文件里加入阿里的镜像
```xml
   <mirror>
      <id>alimaven</id>
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
      <mirrorOf>central</mirrorOf>        
    </mirror>
```
#### 安装Maven Helper插件
【Settings 】→【Plugins 】在搜索框中输入【Maven Helper】， 然后单击【Install 】安装即可

## 语法相关

### 基本语法


## 项目相关

## 学习资料

## 快捷键
Python Console
+ ^+p: 上一个命令
+ ^+n: 下一个命令
PyCharm
+ 

## Cheat Sheet
