# Authentication(Xác thực) vs Authorization(Phân quyền)

Spring Security thực sự chỉ là một loạt các bộ lọc servlet giúp bạn thêm authentication và authorization vào ứng dụng web của mình.


## Authentication
Xác minh ai đó có nằm trong phạm vi của ứng dụng mình không, thường được thực hiện bằng kiểm tra username và password.

## Authorization
Trong các ứng dụng đơn giản hơn, chỉ cần authenticate là đủ. Nhưng thực tế authentication đơn thuần không nói lên gì về việc họ được phép làm gì trong hệ thống của bạn. Do đó, bạn cũng cần phải kiểm tra các quyền của user đã được authenticate, tức là bạn cần <i>cấp quyền</i> cho người dùng đó.

