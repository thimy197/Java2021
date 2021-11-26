# application.properties

Trong SpringBoot thì các thông tin cấu hình mặt định được lấy từ file **resources/application.properties**

## @Value
Trong trường hợp cần config một số thông tin riêng và cần lấy những thông tin này thì SpringBoot có hỗ trợ @Value annotation
<br>
@Value được sử dụng trên thuộc tính của class, Có nhiệm vụ lấy thông tin từ file properties và gán vào biến.


```
#application.properties
mysql.url=jdbc:mysql://host1:33060/abc
```

```
public class AppConfig {
    // Lấy giá trị config từ file application.properties
    @Value("${mysql.url}")
    String mysqlUrl;
}
```

