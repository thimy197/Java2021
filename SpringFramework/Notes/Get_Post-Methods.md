# Get vs Post 
are two different types of HTTP request methods

## GET Request - default HTTP method
1. Get thường dùng để truy xuất tài nguyên
2. Thông tin gửi đi được hiển thị trên URL
3. Giới hạn độ dài của URL(tùy vào browser mà có limit max khác nhau, theo w3school là 2047)
4. Kém an toàn, do thông tin được hiển thị trên URL --> có thể bookmark
5. Có thể lưu vào cacheable
6. Thực thi nhanh hơn POST
7. Không gửi đc nhị phân

## POST Request
1. Post thường dùng ghi data, hay xử lý tài nguyên được chỉ định
2. Thông tin gửi đi được ẩn dưới Header
3. Không giới hạn nội dung được gửi đi dưới header
4. An toàn hơn vì nó không được lưu trong lịch sử browser or server log --> không thể bookmark
5. Không thể lưu vào cacheable
6. Thực thi chậm hơn GET
7. Có thể sử dụng để gửi ASCII cũng như dữ liệu nhị phân

####Notes:

- Post gửi thông tin trong Header, ngoài việc che giấu dữ liệu, nó còn đc bảo mật hơn nếu được sử dụng giao thức HTTP/HTTPs
- Ngoài Get, Post còn một số Http method khác: 
	<br>+ GET, 
	<br>+ POST, 
	<br>+ PUT(create/update): update toàn bộ các field, thay thế hoàn toàn 1 resource
	<br>+ PATH: chỉ update những field cần thay đổi, cập nhập 1 phần resource
	<br>+ DELETE, 
	<br>+ HEAD: giống GET, nhưng không có response body
	<br>+ OPTIONS: vô tả tùy chọn giao tiếp với resource
