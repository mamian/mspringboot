## springboot+hibernate+mysql(jsp+restful)

### Build and run

+ Configurations

	Open the `application.properties` file and set your own configurations.

+ Prerequisites

	- Java 7
	- Maven > 3.0

+ From terminal

	Go on the project's root folder, then type:

    	$ mvn spring-boot:run

#### From Eclipse (Spring Tool Suite)

+ Import as *Existing Maven Project* and run it as *Spring Boot App*.


### Usage

- 首页(jsp)：`http://localhost:8080/`
- 用户详情页(jsp)：`http://localhost:8080/user/profile?email=[email]`
- 创建用户：`http://localhost:8080/user/create?email=[email]&name=[name]`
- 根据id删除用户：`http://localhost:8080/user/delete?id=[id]`
- 根据email查询用户：`http://localhost:8080/user/email?email=[email]`
- 修改用户：`http://localhost:8080/user/update?id=[id]&email=[email]&name=[name]`
