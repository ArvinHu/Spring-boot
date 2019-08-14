package com.huanchuang.arvin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import com.huanchuang.arvin.simple.servlet.SecondServlet;

/**
 * web启动的入口
 * 
 * @author ARVIN
 *
 */
// 支持注解扫描servlet
@ServletComponentScan
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		// 创建应用对象
		SpringApplication app = new SpringApplication(Application.class);
		// 启动应用对象
		app.run(args);
	}

	/**
	 * 使用注解或者是下面这个方式，都能注册servlet，并能根据url完成访问
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {

		return new ServletRegistrationBean(new SecondServlet(),
				"/servlet/second");
	}

	/**
	 * servlet访问的准则是，有精确的匹配精确的，并不是符合条件的都会执行 有个问题：
	 * 32323
	 * DispatcherServlet 默认拦截“/”，MyServlet 拦截“/xs/*”，MyServlet2
	 * 拦截“/xs/myservlet”，那么在我们访问 http://localhost:8080/xs/myservlet
	 * 的时候系统会怎么处理呢？如果访问 http://localhost:8080/xs/abc
	 * 的时候又是什么结果呢？这里就不给大家卖关子了，其结果是“匹配的优先级是从精确到模糊，复合条件的Servlet并不会都执行”
	 * 
	 * 既然系统DispatcherServlet
	 * 默认拦截“/”，那么我们是否能做修改呢，答案是肯定的，我们在SpringBootSampleApplication中添加代码：
	 * 
	 * 修改DispatcherServlet默认配置
	 *
	 * @param dispatcherServlet
	 * @return
	 * @author ARVIN
	 */
	@Bean
	public ServletRegistrationBean dispatcherRegistration(
			DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				dispatcherServlet);
		registration.getUrlMappings().clear();
		registration.addUrlMappings("*.do");
		registration.addUrlMappings("*.json");
		return registration;
	}
}
