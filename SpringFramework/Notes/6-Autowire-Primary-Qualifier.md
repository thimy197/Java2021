# Phát sinh vấn đề từ @Autowire
Ở phần 5 ta đã biết qua @Autowire hiểu là tự động inject bean vào vị trí tương ứng.
<br><br>
Nếu 1 class được đánh dấu @Component, và có Inject bằng @autowire. Thì quá trình Inject Bean như sau:
- Nếu có constructor, thì sẽ inject bằng param của thuộc tính đó trong constructor
- Nếu không tìm thấy Constructor thoả mãn, nó sẽ thông qua setter
- Nếu ko có constructor hay setter -> Sd <b>java reflection</b> để đưa đối tượng vào thuộc tính có @Autowire
<br><br>
-> Có thể gán @Autowire trên thuộc tính hoặc method

#### Vấn đề
Giả sử 2 @Component kế thừa từ 1 interface chung -> 2 bean cùng 1 loại interface <br>
Nếu thực hiện Inject bằng interface thì sẽ không biết là bean nào được inject trong 2 bean được tạo ra ở trên<br>

<b>Cách giải quyết:</b><br>

#### @Primary
@Primary là annotation đánh dấu Bean(@Component) đó được ưu tiên được chọn nếu có nhiều Bean cùng loại

```
@Component
@Primary
public class Naked implements Outfit {
	// ...
}
```

#### @Qualifier
@Qualifier là annotation chỉ định trực tiếp tên của Bean được Inject

```
@Component
public class Girl {

    Outfit outfit;

    // Đánh dấu để Spring inject một đối tượng Outfit vào đây
    public Girl(@Qualifier("naked") Outfit outfit) {
        // Spring sẽ inject outfit thông qua Constructor đầu tiên
        // Ngoài ra, nó sẽ tìm Bean có @Qualifier("naked") trong context để inject
        this.outfit = outfit;
    }
}
```