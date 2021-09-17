# CORS with Spring

Same Origin Policy là 1 tiêu chuẩn về bảo mật trên browser. Để ngăn 1 đoạn script gửi request đến 1 domain khác(ko trùng origin)
Mục đích ngăn chặn các cuộc tấn công hoặc ăn cắp thông tin từ các website khác
<br>
Nhưng hiện tại một số FE framework hiện nay đang hoạt động trên 1 domain riêng thì làm thế nào để lấy được data trên server riêng
<br>->CORS ra đời, cho phép giao tiếp giữa các cross-domain  

## Cách hoạt động

Kham khảo thêm ở đây [cors-support-in-spring-framework](https://spring.io/blog/2015/06/08/cors-support-in-spring-framework)<br>
Thông tin thêm về các config [spring-cors-configuration](https://howtodoinjava.com/spring-boot2/spring-cors-configuration/) 

## Controller method CORS configuration - @CrossOrigin

### @CrossOrigin on the methods

```
	@CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Account retrieve(@PathVariable Long id) {
        // ...
    }
```
Không có config nào trong @CrossOrigin. Nên sử dụng mặt định:

- All origins are allowed
- HTTP được cho phép theo config @RequestMapping->GET
- Thời gian phản hồi(preflight) được lưu trong cache(maxAge) là 30 phút

### @CrossOrigin on the Controller

```
@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
@RequestMapping("/account")
public class AccountController {
	//....
}
```

- Tất cả các method trong Class đều sẽ apply theo @CrossOrigin này
- Có thể config các thuộc tính trong @CrossOrigin: <i>origins, methods, allowedHeaders, exposedHeaders, allowCredentials, or maxAge</i>

### @CrossOrigin on Controller and Handler Method

Trong trường hợp này thì các methods sẽ kết hợp config CORS ở cả class và methods

## Global CORS Configuration
Thay vì config từ Controller, chúng ta có thể khai báo chúng 1 lần cho toàn bộ project

### Java Config
```
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
```
- enables CORS requests from any origin to any endpoint in the application.
- Cũng có thể config các properties ở đây: <i>allowedMethods, allowedHeaders, exposedHeaders, maxAge and allowCredentials</i>

### XML Namespace
Config như JavaConfig ở trên:

```
<mvc:cors>
    <mvc:mapping path="/**" />
</mvc:cors>
```

Custom Properties Config:

```
<mvc:cors>

    <mvc:mapping path="/api/**"
        allowed-origins="http://domain1.com, http://domain2.com"
        allowed-methods="GET, PUT"
        allowed-headers="header1, header2, header3"
        exposed-headers="header1, header2" allow-credentials="false"
        max-age="123" />

    <mvc:mapping path="/resources/**"
        allowed-origins="http://domain1.com" />

</mvc:cors>
```

### CORS With Spring Security
Nếu làm việc với Security, chúng ta bắt buộc phải thêm config CORS<br>
CORS cần phải xử lý trước, không là Spring Sercurity sẽ reject request trước khi vào các xử lý khác trong Spring

```
	@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.cors().and()...
	    }
	}
```

Mã lỗi hay gặp trong trường hợp này là <b>401<b/><br>
The .cors() method will add the Spring-provided CorsFilter to the application context which in turn bypasses the authorization checks for OPTIONS requests.(bỏ qua các kiểm tra quyền của OPTIONS request)

>