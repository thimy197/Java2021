# Nguyên lý SOLID
- code dễ đọc, dễ test, rõ ràng hơn
- <b>maintainace code sẽ dễ hơn rất nhiều</b>
<br><br>
5 nguyên lý sau:

```
	1. Single responsibility principle: 1 class/function chỉ nên chịu 1 chức năng duy nhất
	2. Open/closed principle: Nên mở rộng class bằng class con thay vì sửa lại nó
	3. Liskov substitution principle: A is B, nhưng không có nghĩa là class A nên kế thừa class B
	4. Interface segregation principle: Chia nhỏ interface với nhiều mục đích khác nhau
	5. Dependency inversion principle: các module cấp cao ko nên phụ thuộc vào module cấp thấp, chúng nên phụ thuộc vào abstraction
```

[Example at here](https://toidicodedao.com/2015/03/24/solid-la-gi-ap-dung-cac-nguyen-ly-solid-de-tro-thanh-lap-trinh-vien-code-cung/)<br>

Về bản chất, ***nguyên lý chỉ là nguyên lý***, nó chỉ là hướng dẫn chứ <i>không phải</i> là quy tắc tuyệt đối bất di bất dịch.

## 1. Single responsibility principle(Nguyên lý Đơn Trách Nhiệm)

```
Một class chỉ nên giữ 1 trách nhiệm duy nhất 
(Chỉ có thể sửa đổi class với 1 lý do duy nhất)
```

--> Có thể giải quyết bằng việc tách class nhỏ. Tuy class nhiều hơn nhưng việc sửa chữa sẽ đơn giản hơn, class ngắn hơn, ít bug hơn

<br><br>
Một class có quá nhiều chức năng cũng sẽ trở nên cồng kềnh và phức tạp. Trong ngành IT, requirement rất hay thay đổi, dẫn tới sự thay đổi code. Nếu một class có quá nhiều chức năng, quá cồng kềnh, việc thay đổi code sẽ rất khó khăn, mất nhiều thời gian, còn dễ gây ảnh hưởng tới các module đang hoạt động khác.
<br><br>
Lưu ý: Không phải lúc nào cũng nên áp dụng nguyên lý này vào code. Một trường hợp hay gặp là các class dạng Helper hay Utilities – các class này vi phạm SRP 1 cách trắng trợn. Nếu số lượng hàm ít, ta vẫn có thể cho tất cả các hàm này vào 1 class, xét cho cùng, toàn bộ các hàm trong helper đều có chức năng xử lý các tác vụ nho nhỏ.

## 2. Open/closed principle(nguyên tắt Mở/Đóng)

```
Có thể thoải mái mở rộng 1 class, nhưng không được sửa đổi bên trong class đó 
(open for extension but closed for modification).
```

- Dễ mở rộng: Có thể dễ dàng nâng cấp, mở rộng, thêm tính năng mới cho một module khi có yêu cầu.
- Khó sửa đổi: Hạn chế hoặc cấm việc sửa đổi source code của module sẵn có.

--> Thêm feature -> class mới mở rộng cho class cũ(kế thừa or sở hữu class cũ). Không nên đụng chạm/sửa chữa class cũ

## 3. Liskov Substitution Principle(Nguyên tắt thay thế Liskov)

```
Trong một chương trình, các object của class con có thể thay thế class cha mà không làm thay đổi tính đúng đắn của chương trình
“Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it.”
```
Đây là nguyên lý dễ vi phạm<br>
Trong đời sống, A là B (hình vuông là hình chữ nhật, chim cánh cụt là chim) không có nghĩa là class A nên kế thừa class B. Chỉ cho class A kế thừa class B khi class A thay thế được cho class B.<br>
Pin con ó là pin nhưng không thay thế được cho pin, chim cánh cụt là chim nhưng không thay thế được cho chim, do đó 2 ví dụ này vi phạm LSP.

## 4. Interface segregation principle(Nguyên tắc phân tách giao diện)

```
Thay vì dùng 1 interface lớn, ta nên tách thành nhiều interface nhỏ, với nhiều mục đích cụ thể
```

--> Khi tách interface ra thành nhiều interface nhỏ, gồm các method liên quan tới nhau. Làm hệ thống linh hoạt hơn, việc implement và quản lý sẽ dễ hơn, đồng thời giảm thiểu code thừa (do phải implement những tính năng không cần thiết)
<br><br>
 Tuy nhiên, đôi khi việc tách ra nhiều interface có thể làm <i>tăng số lượng interface, tăng số lượng class</i>, ta cần cân nhắc lợi hại trước khi áp dụng nhé.

## 5. Dependency inversion principle(Nguyên tắc nghịch đảo phụ thuộc)

```
1. Các module cấp cao không nên phụ thuộc vào các modules cấp thấp. 
   Cả 2 nên phụ thuộc vào abstraction.
2. Interface (abstraction) không nên phụ thuộc vào chi tiết, mà ngược lại.
( Các class giao tiếp với nhau thông qua interface, không phải thông qua implementation.)
```

- Với cách code thông thường, các module cấp cao sẽ gọi các module cấp thấp. Module cấp cao sẽ phụ thuộc và module cấp thấp, điều đó tạo ra các dependency. Khi module cấp thấp thay đổi, module cấp cao phải thay đổi theo. Một thay đổi sẽ kéo theo hàng loạt thay đổi, giảm khả năng bảo trì của code.



