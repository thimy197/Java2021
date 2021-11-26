<b>Spring tạo ra 1 container chứa các Dependency cho chúng ta</b>
<br>
SpringApplication là câu lệnh tạo container(ApplicationContext), sau đó tìm toàn bộ các dependency(Bean) trong project và đưa vào đó

<br><br>
Vậy làm sao để nhận biết các Dependency -> dựa vào @Component 

# @Component
@Component là 1 Annotation đánh dấu các class để giúp Spring biết đây là Bean
<br>
Sau khi chương trình được khởi động thì Spring sẽ scan các package để tìm các class có đánh dấu là @component và nó sẽ tạo 1 instance và đưa vào applicationContext để quản lý
<br>

# @Autowire
Khi 1 thuộc tính được đánh dấu là @autowire. Điều này nói với Spring rằng hãy tự tiêm 1 instance của class này vào thuộc tính này khi class chứa thuộc tính được khởi tạo
<br>

# Singleton
<b>Các Bean trong applicationContext đều là Singleton</b>
<br>
Nghĩa là các Bean này được tạo 1 lần duy nhất, và khi có class yêu cầu bằng @autowire thì nó sẽ lấy instance có sẵn trong context để inject vào
<br>
Nếu muốn khởi tạo bean mới trong mỗi lần gọi thì có thể config @component đó bằng @scope("prototype")

# Dependency Injection
DI là design pattern... Nên được hiểu là phương pháp/thiết kế giúp việc lập trình đạt hiệu quả cao hơn
<br>
Example: Khi 1 class có chứa thuộc tính là 1 class khác -> class thuộc tính đó đang tồn tại mang ý nghĩa dependency(phụ thuộc) của class chứa nó.
<br>
Vì sao là phụ thuộc? Đó là vì nếu class thuộc tính đó bị hư/gặp trục trặt/muốn thay đổi thuộc tính khác thì class chính sẽ bị ảnh hưởng theo. Đây chính là tạo ra 1 nút thắt
<br>
Và nguyên tắc được ra đời:

```
Các class chính không nên phụ thuộc vào các class cấp thấp, mà nên phụ thuộc vào Abstract class và chi tiết của chúng sẽ được inject vào đối tượng lúc Runtime.
```
--> tách sự phuộc thuộc giữa 2 class. Tăng tính tùy biến và linh hoạt bằng abstract class -> dễ mở rộng code

Thế thì Dependency Injection là gì?

```
Dependency Injection (DI) trong Spring là một mẫu thiết kế được sử dụng để loại bỏ sự phụ thuộc giữa các mã chương trình, giúp cho việc quản lý và kiểm thử ứng dụng dễ dàng hơn
```

# Inversion Of Control

DI thật là thần kỳ. Nhưng Khi class main của chúng ta cần rất nhiều abstract class cùng lúc thì chúng ta phải tự tay Inject từng 
cái -> rất mất tg, khó khăn trong quá trình code, quản lý code và dependency

```
public static void main(String[] args) {
    Outfit bikini = new Bikini();
    Accessories gucci = new GucciAccessories();
    HairStyle hair = new KoreanHairStyle();
    Girl ngocTrinh = new Girl(bikini, gucci, hair);// khởi tạo và inject các dependency mỏi tay
}
```
Và giải pháp được tìm ra cho trường hợp này đó là:

```
Tạo 1 cái kho và tống tất cả dependency vào kho và giao cho 1 thèn framework quản lý. Bất cứ class nào khi được khởi tạo mà cần bất cứ dependency nào thì framework sẽ tìm trong kho và tự inject vào cho chúng ta 
--> IOC là 1 nguyên tắc lập trình, ở đó các flow of control không bị control ở tầng application mà sẽ bị control bởi framework 
--> IoC Container trong Spring: sẽ tạo ra các đối tượng, nối chúng lại với nhau, cấu hình chúng, và quản lý vòng đời của chúng từ khi tạo ra đến khi bị hủy
```



