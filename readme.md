## <center>dubbo consumer</center>

### Build and run

+ Prerequisites

	- Java 7
	- Maven > 3.0

+ From terminal

	`Go on the project's root folder`, then type:

    	$ mvn spring-boot:run

	`You can also run mspringboot like this`
	
		$ mvn package
		$ java -jar target/mySpringboot-0.0.1-SNAPSHOT
		
		
#### From Eclipse (Spring Tool Suite)

+ Import as *Existing Maven Project* and run it as *Spring Boot App*.

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