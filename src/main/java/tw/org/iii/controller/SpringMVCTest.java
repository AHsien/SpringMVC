package tw.org.iii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.org.iii.entity.User;

@RequestMapping(value = "springmvc")
@Controller
public class SpringMVCTest {
	private static final String SUCCESS = "success";

	/**
	 * 1. @RequestMapping 除了修飾方法，還可以修飾class 2. (1)類定義處：提供初步的請求映射信息，相對於 WEB 應用的根目錄
	 * (2)方法處：提供進一步的細分映射信息，相對於類定義處的 URL， 若類定義處未標註 @RequestMapping，則方法處標記的 URL 相對於
	 * WEB 應用的根目錄
	 * 
	 * @return
	 */
	@RequestMapping(value = "/testRequestMapping")
	public String testRequestMapping() {
		System.out.println("testRequestMapping");
		return SUCCESS;
	}

	/**
	 * 使用 method 屬性來指定請求方式
	 * 
	 * @return
	 */
	@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
	public String testMethod() {
		System.out.println("testMethod()");
		return SUCCESS;
	}

	/**
	 * 可以使用 params 和 headers 更加精確的映射請求，params 和 headers 支持簡單的表達式
	 * 
	 * @return
	 */
	@RequestMapping(value = "/testParamsAndHeads", params = { "user", "age=10" }, headers = {
			"Accept-Language=zh-US,zh;q=0.9,en-US;q=0.8,en;q=0.7,zh-CN;q=0.6" })
	public String testParamsAndHeads() {
		System.out.println("testParamsAndHeads");
		return SUCCESS;
	}

	/**
	 * @RequestMapping Ant 風格資源地址支持3種匹配符： (1)?：匹配文件名中的一個字符 (2)*：匹配文件名中的任意字符 (3)**：匹配多層路徑
	 * @return
	 */
	@RequestMapping(value = "/testAntPath/*/123?")
	public String testAntPath() {
		System.out.println("testAntPath");
		return SUCCESS;
	}

	/**
	 * @PathVariable 可以映射 URL 中的佔位符到目標方法的參數中
	 * @PathVariable內的value是默認屬性可以不用寫
	 * 可改成@PathVairable("id")
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/testPathVariable/{id}")
	public String testPathVariable(@PathVariable(value = "id") int id) {
		System.out.println("testPathVariable" + "id = " + id);
		return SUCCESS;
	}
	
	/**
	 * REST 風格 GET
	 * 查詢： /testRest/1 GET
	 */
	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
	public String testRestGet(@PathVariable("id") int id) {
		System.out.println("testRest Get" + id);
		return SUCCESS;
	}
	
	/**
	 * REST 風格 POST
	 * 新增： /testRest POST
	 */
	@RequestMapping(value = "/testRest", method = RequestMethod.POST)
	public String testRestPost() {
		System.out.println("testRest POST");
		return SUCCESS;
	}
	
	/**
	 * REST 風格 PUT
	 * 修改： /testRest/1 PUT
	 * 
	 * 發送 PUT and DELETE 請求 需要：
	 * 1. 配置 HiddenHttpMethodFilter
	 * 2. 發送 POST 請求
	 * 3. 發送 POST 請求時攜帶一個
	 * 	  input type="hidden" name="_method" value="PUT"
	 */
	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") int id) {
		System.out.println("testRest Put" + id);
		return SUCCESS;
	}
	
	/**
	 * REST 風格 DELETE
	 * 刪除： /testRest/1 DELETE
	 * 
	 * 發送 PUT and DELETE 請求 需要：
	 * 1. 配置 HiddenHttpMethodFilter
	 * 2. 發送 POST 請求
	 * 3. 發送 POST 請求時攜帶一個
	 * 	  input type="hidden" name="_method" value="PUT"
	 */
	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
	public String testRestDelete(@PathVariable("id") int id) {
		System.out.println("testRest Delete" + id);
		return SUCCESS;
	}
	
	/**
	 * @RequestParam 來映射請求參數
	 * value 值即請求參數的參數名
	 * required 該參數是否必須。默認為true
	 * defaultValue 請求參數的默認值
	 */
	@RequestMapping(value = "/testRequestParam")
	public String testRequestParam(@RequestParam("user") String user,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age) {
		System.out.println("testRequestParam user = " + user + ", age = " + age);
		return SUCCESS;
	}
	
	/**
	 * 映射請求信息
	 * 用法同 @RequestParam
	 */
	@RequestMapping(value = "/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value = "Host") String host) {
		System.out.println("testRequestHeader Host = " + host);
		return SUCCESS;
	}
	
	/**
	 * 映射一個 Cookie 值, 屬性同 @RequestParam
	 */
	@RequestMapping(value = "/testCookieValue")
	public String testCookieValue(@CookieValue(value = "afterLogin") String cookie) {
		System.out.println("testCookieValue afterLogin = " + cookie);
		return SUCCESS;
	}
	
	/**
	 * Spring MVC 會按請求參數名稱和 POJO 屬性名稱進行自動匹配
	 * 自動為該對象填充屬性值，支持級聯屬性
	 * 如：dept.deptID, dept.address.tel 等
	 */
	@RequestMapping(value = "/testPojo")
	public String testPojo(User user) {
		System.out.println("testPojo user = " + user);
		return SUCCESS;
	}
}
