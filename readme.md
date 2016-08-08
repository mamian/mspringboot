## <center>springboot+hibernate+mysql(jsp+restful)</center>

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

#### From Eclipse (Spring Tool Suite)

+ Import as *Existing Maven Project* and run it as *Spring Boot App*.


### Usage

- 首页(jsp)：
	- get
	- `http://localhost:8080/`
- 用户详情页(jsp)：
	- get
	- `http://localhost:8080/user/profile?email=[email]`
- 创建用户：
	- post
	- `http://localhost:8080/user/create`
	- param: email=[email]&name=[name]
- 根据id删除用户：
	- post
	- `http://localhost:8080/user/delete`
	- param: id=[id]
- 根据email查询用户：
	- get
	- `http://localhost:8080/user/email?email=[email]`
- 修改用户：
	- post
	- `http://localhost:8080/user/update`
	- param: id=[id]&email=[email]&name=[name]
	
	
---------
### 使用thymeleaf代替jsp
+ 使用mvn package打jar
+ java -jar target/XX.jar 即可运行
