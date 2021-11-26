# @Configuration

@Configuration là 1 annotation đánh đấu trên class, để SpringBoot biết đây là nơi định nghĩa ra các Bean
@Bean là 1 annotation đánh dấu trên **method** trong class có chứa @Configuration, để SpringBoot biết đây là Bean và sẽ thực hiện đưa Bean này vào context
<br><br>

Khi project bắt đầu khởi chạy thì ngoài việc đi tìm các @Component thì nó còn đi tìm các class là 
@Configuration:
- 1. Đi tìm các class @Configuration
- 2. Tạo Object từ class Configuration
- 3. Tìm các method là @Bean
- 4. Thực hiện gọi các method có đánh dấu @Bean để lấy ra các Bean và đưa vào `Context.
<br><br>

Nếu method được đánh dấu bởi @Bean có parameter, thì Spring Boot sẽ tự inject các Bean đã có trong Context vào làm tham số<br><br>
Thực chất thì @Configuration cũng là **@Component**.<br><br>
Vậy thì @Configuration và @Bean có ý nghĩa gì?<br>
--> Thực tế nếu 1 Bean có quá nhiều logic để khởi tạo và config thì chúng ta sd @Configuration vs @Bean để tự tạo Bean bằng tay.
Nhìn thế để hiểu rõ hơn là chúng ta đang config chương trình. Và thực tế trong nhiều trường hợp điều là rất cần thiết. Một Ứng dụng sẽ có nhiều class chứa @Configuration và mỗi class sẽ đảm nhận cấu hình một bộ phận gì đó trong ứng dụng.<br>
[Example for configuration and bean](https://loda.me/spring-boot-6-configuration-va-bean-loda1557885506910/)
<br><br>
