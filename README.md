# Venture Professionals
* A Spring Hibernate WebApp

# What
* TODO need to write
# How
* TODO need to write
# Why
* TODO need to write

# Requirements
* Strict Java 1.8 (JDK and JRE)
* Apache Tomcat 7
* Eclipse Neon
* Mysql Server 5 (using JNDI)
* Postman (for manually testing services)

# Frameworks
* Spring Framework > 4
* Hibernate Framework > 5
* Redis (an in-memory-cache)

# Project Configuration
* Cloning the repository in to local.
```bash
git clone https://github.com/shubhamjain1991/vp.git
cd vp
mvn clean install -Plocal
```
* Setting up Apache Tomcat 
```bash
cd /home/${user}/Utilities/apache-tomcat-7.0.79/conf
vim server.xml
```
Add the below line 
```xml
<Context path="/vp" docBase="/home/${user}/Documents/vp/target/vp" debug="0" reloadable="true"/>
```
```bash
vim context.xml
```
Add the below line 
```xml
<Resource name="jdbc/master" auth="Container"
        type="javax.sql.DataSource" maxActive="100"
        validationQuery="select 1" testOnBorrw="true"
        testWhileIdle="true" removeAbandoned="true"
        removeAbandonedTimeout="300" logAbandoned="true"
        username="root" password="root"
        driverClassName="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/vp?noAccessToProcedureBodies=true" />
<Resource name="jdbc/slave" auth="Container"
        type="javax.sql.DataSource" maxActive="100"
        validationQuery="select 1" testOnBorrw="true"
        testWhileIdle="true" removeAbandoned="true"
        removeAbandonedTimeout="300" logAbandoned="true"
        username="root" password="root"
        driverClassName="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/vp?noAccessToProcedureBodies=true" />
```
* Starting Application
```bash
cd /home/${user}/Utilities/apache-tomcat-7.0.79/bin
./restart-tomcat.sh
```
It should show the below logs
```log
Mar 20, 2018 5:26:28 PM org.apache.coyote.AbstractProtocol init
INFO: Initializing ProtocolHandler ["http-bio-8080"]
Mar 20, 2018 5:26:28 PM org.apache.coyote.AbstractProtocol init
INFO: Initializing ProtocolHandler ["ajp-bio-8009"]
Mar 20, 2018 5:26:28 PM org.apache.catalina.startup.Catalina load
INFO: Initialization processed in 691 ms
Mar 20, 2018 5:26:28 PM org.apache.catalina.core.StandardService startInternal
INFO: Starting service Catalina
Mar 20, 2018 5:26:28 PM org.apache.catalina.core.StandardEngine startInternal
INFO: Starting Servlet Engine: Apache Tomcat/7.0.79
Mar 20, 2018 5:26:29 PM org.apache.catalina.startup.TldConfig execute
INFO: At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
LOCAL :: 2018-03-20 17:26:30 [localhost-startStop-1] (LogHelper.java:31) - HHH000204: Processing PersistenceUnitInfo [
	name: spring-jpa-unit
	...]
LOCAL :: 2018-03-20 17:26:30 [localhost-startStop-1] (Version.java:37) - HHH000412: Hibernate Core {5.1.4.Final}
LOCAL :: 2018-03-20 17:26:30 [localhost-startStop-1] (Environment.java:213) - HHH000206: hibernate.properties not found
LOCAL :: 2018-03-20 17:26:30 [localhost-startStop-1] (Environment.java:317) - HHH000021: Bytecode provider name : javassist
LOCAL :: 2018-03-20 17:26:30 [localhost-startStop-1] (JavaReflectionManager.java:66) - HCANN000001: Hibernate Commons Annotations {5.0.1.Final}
LOCAL :: 2018-03-20 17:26:31 [localhost-startStop-1] (Dialect.java:156) - HHH000400: Using dialect: org.hibernate.dialect.MySQL5InnoDBDialect
LOCAL :: 2018-03-20 17:26:31 [localhost-startStop-1] (Init.java:16) - Inittializing Application With Environment :::: local
Mar 20, 2018 5:26:32 PM org.apache.coyote.AbstractProtocol start
INFO: Starting ProtocolHandler ["http-bio-8080"]
Mar 20, 2018 5:26:32 PM org.apache.coyote.AbstractProtocol start
INFO: Starting ProtocolHandler ["ajp-bio-8009"]
Mar 20, 2018 5:26:32 PM org.apache.catalina.startup.Catalina start
INFO: Server startup in 3894 ms
```
* Test
hit https://localhost:8080/vp/sample/example in browser, it will print logs following and you will get output as "Hurray! You First Spring JPA(Hibernate) Web Service Is Working Just Fine."
```log
LOCAL :: 2018-03-20 17:29:13 [http-bio-8080-exec-2] (SampleController.java:20) - In SampleController Calling example Method
LOCAL :: 2018-03-20 17:29:13 [http-bio-8080-exec-2] (SampleController.java:21) - Environment :::: local
LOCAL :: 2018-03-20 17:29:13 [http-bio-8080-exec-2] (SampleController.java:22) - Master DB :::: master
LOCAL :: 2018-03-20 17:29:13 [http-bio-8080-exec-2] (SampleController.java:23) - Slave DB :::: slave
```


