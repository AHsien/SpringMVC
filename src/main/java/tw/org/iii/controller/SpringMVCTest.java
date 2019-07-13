package tw.org.iii.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import tw.org.iii.entity.User;

@SessionAttributes(value = "user", types = String.class)
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
	public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookie) {
		System.out.println("testCookieValue JSESSIONID = " + cookie);
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
	
	/**
	 * 可以使用 Servlet 原生 API 作為目標方法的參數，具體支持以下類型
	 * HttpServletRequest
	 * HttpServletResponse
	 * HttpSession
	 * java.security.Principal
	 * Locale InputStream
	 * OutputStream
	 * Reader
	 * Writer
	 */
	@RequestMapping(value = "/testServletAPI")
	public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
		System.out.println("testServletAPI = " + request + response);
		out.write("hello springmvc");
//		return SUCCESS;
	}
	
	/**
	 * 目標方法的返回值可以是 ModelAndView 類型
	 * 其中可以包含視圖和模型信息
	 * SpringMVC 會把 ModelAndView 的 model 中數據放到 request 域 (requestScope) 對象中
	 */
	@RequestMapping(value = "/testModelAndView")
	public ModelAndView testModelAndView() {
		String viewName = SUCCESS;
		ModelAndView modelAndView = new ModelAndView(viewName);
		
		//添加模型數據到 ModelAndView 中
		modelAndView.addObject("time", new Date());
		return modelAndView;
	}
	
	/*
	 * 目標方法可以添加 Map 類型 (實際上也可以是 Model 類型或 ModelMap 類型) 的參數
	 * 
	 */
	@RequestMapping(value = "/testMap")
	public String testMap(Map<String, Object> map) {
		map.put("names", Arrays.asList("Djokovic", "Federer", "Nadal", "Murray"));
		return SUCCESS;
	}
	
	/*
	 * @SessionAttributes 只能放在類別(Class)上，不能放在方法(method)上
	 * 除了可以通過屬性名指定需要放到會話中的屬性外 - 實際上使用的是 value 屬性值，
	 * 還可以通過模型屬性的對象類型(.class) - 實際上使用的是 types 屬性值
	 * 指定哪些模型屬性需要放到會話中
	 */
	@RequestMapping(value = "/testSessionAttributes")
	public String testSessionAttributes(Map<String, Object> map) {
		User user = new User("user", "user", "user@gmail.com", 35);
		map.put("user", user);
		map.put("gender", "Male");
		return SUCCESS;
	}
	
	/*
	 * 運行流程:
	 * 1. 執行 @ModelAttribute 註解修飾的方法 : 
	 * 	  從數據庫中取出對象，將對象放進 Map，key為 user
	 * 2. SpringMVC 從 MAP 中取出 User 對象，並把表單的請求參數賦予該 User 對象的對應屬性
	 * 3. SpringMVC 將上述對象傳入目標方法的參數
	 * 
	 * 注意: 在 @ModelAttribute 修飾的方法中，放到 Map 時的 key，
	 *      需要和目標方法傳入參數的第一個字母小寫的字串一致
	 *      
	 * SpringMVC 確定目標方法 POJO 類型入參的過程
	 * 1. 確定一個 key:
	 * 1). 若目標方法的 POJO 類型的參數沒有使用 @ModelAttribute 作為修飾，則 key 為 POJO類名第一個字母的小寫
	 * 2). 若使用了 @ModelAttribute 來修飾，則 key 為 @ModelAttribute 註解的 value 屬性值
	 * 2. 在 implicitModel 中查找 key 對應的對象，若存在，則作為入參傳入
	 * 1). 若在 @ModelAttribute 標記的方法中在 Map 中保存過，且 key 和 1 確定的 key 一致，則會獲取到
	 * 3. 若 implicitModel 中不存在 key 對應的對象，則檢查當前的 Handler 是否使用 @SessionAttributes 註解修飾,
	 *    若使用了該註解，且 @SessionAttributes 註解的 value 屬性值中包含了 key，則會從 HttpSession 中來獲取 key
	 *    所對應的 value 值，若存在則直接傳入到方法的入參中，若不存在則將拋出異常
	 * 4. 若 Handler 沒有標識 @SessionAttributes 註解或 @SessionAttributes 註解的 value 值中不包含 key，
	 * 	  則會通過反射來創建 POJO 類型的參數，傳入為目標方法的參數
	 * 5. SpringMVC 會把 key 和 POJO 類型的對象保存到 implicitModel 中，進而會保存到 request 中
	 */
	@RequestMapping(value = "/testModelAttribute")
	// 如果 MAP 放入的 key 與傳入參數類型 User 相同 時，
	// @ModelAttribute 可以不用標註
	// 預設會使用 傳入參數類型 User 轉換成 user 來做比對
	public String testModelAttribute(@ModelAttribute("abc")User user) {  
		System.out.println("修改 : " + user);
		return SUCCESS;
	}
	
	/*
	 * 1. 有 @ModelAttribute 標記的方法，會在每個目標方法執行前被 SpringMVC 調用
	 * 2. @ModelAttribute 註解也可以來修飾目標方法 POJO 類型的入參，其 value 屬性值有如下的作用:
	 * 1). SpringMVC 會使用 value 屬性值在 implicitModel 中查找對應的對象，若存在則會直接傳入到目標方法的入參中
	 * 2). SpringMVC 會以 value 為 key， POJO 類型的對象為 value，存入到 request 中
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id", required=false) Integer id,
			Map<String, Object> map) {
		if(id != null) {
			//模擬從數據庫中獲取對象
			User user = new User(1, "Tom", "123456", "tom@gmail.com", 12);
			System.out.println("從數據庫中獲取一個對象 : " + user);
			
			map.put("abc", user);
		}
	}
	
	@RequestMapping(value = "/testViewAndViewResolver")
	public String testViewAndViewResolver() {
		System.out.println("testViewAndViewResolver");
		return SUCCESS;
	}
	
	@RequestMapping(value = "/testView")
	public String testView() {
		System.out.println("testView");
		return "helloView";
	}
	
	@RequestMapping(value = "/testRedirect")
	public String testRedirect() {
		System.out.println("testRedirect");
		return "redirect:/springmvc/testView";
	}
}
