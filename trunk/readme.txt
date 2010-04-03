svn 地址：http://code.google.com/p/yayavsi/source/checkout

svn checkout https://yayavsi.googlecode.com/svn/trunk/ yayavsi --username peigen123


密码：EP4XY5hd9Nd3

mvn clean package jetty:run-war
mvn package
mvn jetty:run-war

运行：DreamCubeBootstrap.java
访问：
http://127.0.0.1:8080/dreamcube/enrollment/helloworld.html


mvn archetype:create -DgroupId=com.dreamcube -DartifactId=dreamcube-squad-core-domain -Dversion=1.0-SNAPSHOT
mvn archetype:create -DgroupId=com.dreamcube -DartifactId=dreamcube-squad-biz -Dversion=1.0-SNAPSHOT
mvn archetype:create -DgroupId=com.dreamcube -DartifactId=dreamcube-squad-web -Dversion=1.0-SNAPSHOT
