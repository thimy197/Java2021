# Multiple Requests send Spring Controller - Singleton Bean
link: [DZONE - multiple request in time on singleton](https://dzone.com/articles/how-does-singleton-bean-serve-multiple-requests-at)<br>
- Spring sẽ xử lý như thế nào nếu có nhiều request gửi tới controller cùng 1 lúc
- Liệu Spring có phải là thread-safe?<br>

Thường sẽ có 2 câu hỏi về Bean:
- Singleton Bean được tạo ra như thế nào?
- Làm thế nào mà có thể auto-wired Bean trong class khác?

Kịch bản được đưa ra như sau:
có 2 user, cùng thực hiện thao tác loginUser và createReport. 2 method này cùng sử dụng userService Bean, scope là singleton.<br>
Câu hỏi được đặt ra là các methods này sử dụng userService theo sequentially-tuần tự??? Hay là, làm thế nào mà singleton xử lý nhiều request cùng lúc

## 1. Luồng xử lý cơ bản: 
Spring Container tạo Bean trong nó. Sau khi tạo beans cần thì nó tiêm các phụ thuộc của chúng. <br>
Container sẽ lấy những hướng dẫn của nó từ file configuration (XML or annotation)<br>
Sau khi Spring container được tạo, ứng dụng của bạn sẵn sàng để sử đụng như mô tả trong hình bên dưới:<br>
![Spring container](https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/images/container-magic.png)<br>
Câu sau đây để nói với Spring Container rằng: chỉ cần tạo 1 instance trong container, còn đc gọi là singleton bean.  <br>

```
 <bean id=”accountDao” class=”…” scope=”singleton”/>
```
<br>
Sau đó, SpringContainer chỉ trả về Object này cho tất cả các request và reference.<br>
=> Dựa theo cách giải thích trên, ta biết được cùng 1 bean sẽ được sử dụng trong các class khác.

## 2. Trong Spring, mỗi request là 1 luồng xử lý riêng biệt.

Như ví dụ trên, nếu 2 user cùng login 1 lúc thì JVM sẽ tạo 2 threads. "every request is executed in a separate thread(luồng riêng biệt)". 
Mặc dù cùng 1 method như là 2 thread khác nhau. 2 thread này sử dụng chung 1 instance Bean nhưng vẫn trả về kết quả khách nhau.<br>
Để giải thích điều này, chúng ta hãy liên tưởng tới việc lưu dữ liệu trong stack và head:
- Tất cả Object được tạo trong head, Object trong Head là global - có thể truy cập bất kỳ đâu trong project. Đó là lý do mọi thread đều có thể try cập vào Object trong Head
- Nhưng Stack thì chỉ được sử dụng trong 1 luồng. 
Khi method được gọi thì 1 block được tạo ra trong stack theo thứ tự LIFO(Last In First Out). 
Block trong stack lưu các local primitive value, references tới Objects khác.
Và Stack memory không thể bị truy cập bởi luồng khác

vì thế nên khi truy cập đến singleton bean, thì lúc này sẽ xảy ra trường hợp 2 stack dùng chung 1 Object singleton trong Head trong cùng 1 time<br>
Lúc này thì compiler chỉ cần thực thi nó và lưu trữ các gái trị cụ thể trong các khối riêng biệt của stack<br>
Sẽ không có hạn chế nào xảy ra lúc này. Do các singleton bean đã được thiết kế(chính chúng ta phải thiết lập) như 1 class stateless nên nhiều luồng có thể sử dụng chung bean, hoặc thậm chí là chung method mà ko sợ bị ảnh hưởng<br>

#### References

Stateless là gì?<br>
[https://www.javacodegeeks.com/2014/08/java-concurrency-tutorial-thread-safe-designs.html](https://www.javacodegeeks.com/2014/08/java-concurrency-tutorial-thread-safe-designs.html)<br>
[https://www.baeldung.com/java-thread-safety](https://www.baeldung.com/java-thread-safety)<br> 
Theo bài viết thì: Do stateless không có state nào bị thay đổi, kết quả của luồng này không bị ảnh hưởng bởi luồng khác. Nên stateless được xem như là 1 thread-safe<br><br>

Bài viết khi 1 stateless được truy cập từ nhiều thread khác nhau -> giữa các thread sẽ không bị ảnh hưởng khi gọi chung, vì thực chất là chả có state nào được share mà ảnh hưởng đến thread khác<br>
[https://stackoverflow.com/questions/18547476/how-multiple-threads-invoke-singleton-objects-method-and-work-on-them/18547527](https://stackoverflow.com/questions/18547476/how-multiple-threads-invoke-singleton-objects-method-and-work-on-them/18547527)<br>
giải thích dễ hiểu hơn:<br>
[https://baskotasushan.wordpress.com/2020/01/31/how-are-multiple-request-handled-by-singleton-instance/](https://baskotasushan.wordpress.com/2020/01/31/how-are-multiple-request-handled-by-singleton-instance/)
<br><br>
Bài viết liên quan đến Singleton<br>
[https://www.alainschlesser.com/singletons-shared-instances/](https://www.alainschlesser.com/singletons-shared-instances/)


