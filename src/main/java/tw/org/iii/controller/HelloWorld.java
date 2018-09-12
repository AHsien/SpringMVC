package tw.org.iii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
	private static final String SUCCESS = "success";
	
	/**
	 * 1. 使用 @RequestMapping 註解來映射請求的 URL
	 * 2. 返回值會通過視圖解析器解析為實際的物理視圖，對於 InternalResourceViewResolver 視圖解析器，
	 *    會做如下的解析：通過 prefix前綴 + return value + suffix後綴 的方式得到實際的物理視圖，
	 *    然後轉發為操作
	 *    /WEB-INF/view/success.jsp
	 * @return
	 */
	@RequestMapping(value = "helloworld")
	public String hello() {
		System.out.println("hello world");
		return SUCCESS;
	}

}
