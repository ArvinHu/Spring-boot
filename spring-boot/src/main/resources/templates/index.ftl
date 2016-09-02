在pom.xml中，添加一下依赖，表示可以解析FreeMarker <br/>
此时，在application.properties中需要把解析jsp的配置注释掉
<p>
<!-- 支持FreeMarker依赖 -->
<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-freemarker</artifactId>
</dependency>
</p>