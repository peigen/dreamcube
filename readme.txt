svn 地址：http://code.google.com/p/yayavsi/source/checkout

svn checkout https://yayavsi.googlecode.com/svn/trunk/ yayavsi --username peigen123


密码：EP4XY5hd9Nd3

mvn clean package jetty:run-war
mvn package
mvn jetty:run-war

运行：DreamCubeBootstrap.java
访问：
http://localhost:8080/dreamcube/enrollment/helloworld.html


mvn archetype:create -DgroupId=com.dreamcube -DartifactId=dreamcube-squad-core-domain -Dversion=1.0-SNAPSHOT
mvn archetype:create -DgroupId=com.dreamcube -DartifactId=dreamcube-squad-biz -Dversion=1.0-SNAPSHOT
mvn archetype:create -DgroupId=com.dreamcube -DartifactId=dreamcube-squad-web -Dversion=1.0-SNAPSHOT
mvn archetype:create -DgroupId=com.dreamcube -DartifactId=dreamcube-core-common -Dversion=1.0-SNAPSHOT


打包，先mvn clean下，eclipse  clean project   mvn install

启动mongodb
打算把一些系统配置缓存放到里面去
#!/bin/bash
pkill mongodb
/home/peigen/soft/java/mongodb/bin/mongod --dbpath /tmp/ --logpath /tmp/mongodb.log --logappend --port 1983
