# Session vs Cookie

## Session - Phiên làm việc
Lưu giữ thông tin tạm thời và là cách giao tiếp giữa client vs server<br>
<br>
Một session bắt đầu khi client bắt đầu gửi request đến server, nó tồn tại xuyên suốt từ page đến page khác, sẽ kết thúc nếu hết tg timeout hoặc khi bạn đóng ứng dụng.<br>
<br>
Session được lưu trong 1 file trên server. Nên nếu sài vô tội vạ sẽ khiến server phải lưu nhiều. Nếu lượng user lớn thì ảnh hưởng rất nặng.<br>
<br>
Mỗi session sẽ đc cấp 1 sessionID suốt quá trình, và khi kết thúc session đó thì sẽ đc cấp lại 1 session với ID mới<br>
<br>
Thế thì dựa vào đâu mà server có thể phân biệt session nào là của user nào?<br>
-> Với mỗi session được tạo ra thì ứng với nó sẽ có 1 cookie được lưu ở client(browser)

## Cookie
Lưu giữ thông tin tạm thời. Và cũng có tg timeout do dev thiết lập. Nên sẽ rất dễ nhầm lần giữ 2 khái niệm này. Những thông tin được lưu vào cookie ví dụ như, thao tác người dùng, tần xuất ghé thăm website, thời gian truy cập...<br>
<br>
Khi truy cập vào ứn dụng, server sẽ gửi 1 cookie tới browser và được lưu lại trên máy tính của client. Mỗi khi client truy cập thì browser sẽ gửi thông tin cookie để thông báo cho ứng dụng về hoạt động trước đó của bạn<br>
-> Chính vì cookie nên nhiều ứng dụng khác lợi dụng để chạy quảng cáo, xây dựng hệ thống recommendation,... <br>
Chú ý đừng bao giờ lưu trữ những thông tin quan trọng, bảo mật cao vào cookie. Nó hoàn toàn có thể bị chỉnh sửa, đánh cắp, thậm chí lợi dụng để tấn công website của bạn<br>

## Cache
Nó khác với cookie ở chỗ thông tin lưu trữ ở đây là các tài liệu web, các hình ảnh, các video, HTML, .... để giảm tải băng thông, tăng tốc độ load, truy cập web<br>
Bộ nhớ cache sẽ được lưu trữ cho đến khi bạn tự tay xóa nó đi. Do đó đừng dại mà xóa cache khi không cần thiết nhé. <br>
Bộ nhớ cache chính là nơi trình duyệt của bạn lưu trữ những file copy để bạn không phải tải lại lần nữa khi duyệt web
