package com.huanchuang.arvin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * web启动的入口
 * 
 * @author ARVIN
 *
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		// 创建应用对象
		SpringApplication app = new SpringApplication(Application.class);
		// 启动应用对象
		app.run(args);
	}
}
