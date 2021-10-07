# Nguyên tắc KISS

## KISS - Keep It Simple, Stupid!
Hãy giữ code của bạn thật đơn giản, ngắn gọn.
<br>
"strive for simplicity - cố gắng đạt được sự đơn giản"

## how to apply KISS?
- Đặt tên variables, method, class, package, comment rõ nghĩa

	```
	- Đảm bảo variable mô tả đúng giá trị mà nó chứa
	- Đảm bảo methods đúng với mục đích của chính nó
	- comment khi cần thiết
	- Class mang 1 trách nhiệm duy nhất
	- Tránh các "global" stage và behavior càng nhiều càng tốt
	- Xóa các versions, methods or process thừa mà không được sử dụng tới
	```

- Hiểu rõ vấn đề trước khi code
- Chia nhỏ task thành các task nhỏ hơn, để code 1 cách rõ ràng
- Không lạm dụng framework, pattern
- Giới hạn line number của 1 method, thường thì 30-50 lines, và chỉ nên thực hiện 1 chức năng
- Không nên sử dụng quá nhiều câu if cho 1 method, hãy tách chúng ra thành các method khác nhau

## Benefit
- Dễ đọc, dễ bảo trì, sửa code
- Tránh được các issue phức tạp vì đã chia nhỏ issue
- Code dễ sử dụng, dễ TEST
- Nhìn vào code thì chúng giống như chính tài liệu mô tả chúng

