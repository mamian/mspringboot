## <center>springboot+hibernate+mysql(thymeleaf+restful)</center>

### 功能
+ entity、dao、service、controller
+ thymeleaf模板页面
+ dubbo rpc 系统间通信
+ shiro

### Build and run

+ Configurations

	Open the `application.properties` file and set your own configurations.
	The default config: mysql.schema = nina

+ Prerequisites

	- Java 7
	- Maven > 3.0

+ From terminal

	`Go on the project's root folder`, then type:

    	$ mvn spring-boot:run

	`You can also run mspringboot like this`
	
		$ mvn package
		$ java -jar target/mspringboot-0.0.1-SNAPSHOT
		
		
#### From Eclipse (Spring Tool Suite)

+ Import as *Existing Maven Project* and run it as *Spring Boot App*.


### Usage

- 首页(jsp)：
	- get
	- `http://localhost:18000/`
- 用户详情页(jsp)：
	- get
	- `http://localhost:18000/user/profile?loginName=[loginName]`
- 创建用户：
	- post
	- `http://localhost:18000/user/create`
	- param: mobile=[mobile]&name=[name]
- 根据id删除用户：
	- post
	- `http://localhost:18000/user/delete/[userId]`
- 根据mobile查询用户：
	- get
	- `http://localhost:18000/user/mobile?mobile=[mobile]`
- 修改用户：
	- post
	- `http://localhost:18000/user/update`
	- param: id=[id]&mobile=[mobile]&name=[name]
- 用户注册：
	- post
	- `http://localhost:18000/user/register`
	- param: loginName=[loginName]&password=[password]
- 用户登录：
	- post
	- `http://localhost:18000/user/login`
	- param: loginName=[loginName]&password=[password]
	
### dubbo

+ zookeeper
	- sudo ./zookeeper/bin/zkServer.sh start
+ provider
	- switch branch `master`
	- mvn package
	- java -jar XX.jar
+ consumer
	- switch branch `dubboConsumer`
	- mvn package
	- java -jar XX.jar
	- http://127.0.0.1:18001/dubbo