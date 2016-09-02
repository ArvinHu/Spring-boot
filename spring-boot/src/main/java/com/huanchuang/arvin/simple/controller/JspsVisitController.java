package com.huanchuang.arvin.simple.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JspsVisitController {

	// 从 application.properties 中读取配置，如取不到默认值为Hello Arvin
	@Value("${application.hell:Hello Arvin}")
	private String hello;

	/**
	 * 默认页<br/>
	 * 
	 * @RequestMapping("/") 和 @RequestMapping 是有区别的
	 *                      如果不写参数，则为全局默认页，加入输入404页面，也会自动访问到这个页面。
	 *                      如果加了参数“/”，则只认为是根页面。
	 *
	 */
	@RequestMapping(value = { "/", "/index", "/home" })
	public String index(Map<String, Object> model) {
		// 直接返回字符串，框架默认会去 spring.view.prefix 目录下的 （index拼接spring.view.suffix）页面
		// 本例为 /WEB-INF/jsp/index.jsp
		model.put("time", new Date());
		model.put("message", this.hello);
		return "index";
	}

	/**
	 * 响应到JSP页面page
	 *
	 * @return
	 * @author ARVIN
	 */
	@RequestMapping("/page1")
	public ModelAndView page1() {
		// 页面位置 /WEB-INF/jsp/page/page.jsp
		ModelAndView mav = new ModelAndView("page/page");
		mav.addObject("content", hello + "第一种");
		return mav;
	}

	/**
	 * 响应到JSP页面page1（可以直接使用Model封装内容，直接返回页面字符串）
	 *
	 * @return
	 * @author ARVIN
	 */
	@RequestMapping("/page2")
	public String page2(Model model) {
		// 页面位置 /WEB-INF/jsp/page/page.jsp
		model.addAttribute("content", hello + "（第二种）");
		return "page/page";
	}

	@RequestMapping("/page3")
	public String baidu(Model model) {
		// 重定向之后此处的model丢失
		model.addAttribute("content", hello + "（[重定向过来的！]）");
		return "redirect:page1";

	}

}
