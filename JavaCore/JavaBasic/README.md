# Tóm tắt Java core
"WRITE ONCE, RUN ANYWHERE"

1. Tính năng nổi bật:<br>
	- OPP<br>
	- Bảo mật<br>
	- Độc lập nền tảng<br>
	- Đa nhiệm (multi-threaded)<br>
	<br>
2. Ứng dụng:<br>
		![Application](./images/Application.PNG)<br>
	- Java SE(Java System Edition): application, mạng, giao diện control<br>
	- Java EE(Java Enterprise Edition): web<br>
	- Java ME(Java Mobile Edition): game, app mobile
	<br><br>
3. Thành phần:<br>
	- JVM(Java virtual machine): môi trường thực thi mã Java Bytecode<br>
		![Compile](./images/JVM_compile.PNG)
		![Runtime](./images/JVM_runtime.PNG)<br>
	<br>
	- JRE(Java runtime environment): JVM + Libs<br>
	- JDK(Java development kit): JRE + development tools<br>
	<br>
4. Variables:<br>
	Variable là tên của vùng nhớ, lưu giá trị<br>
	<strong>- Local variable:</strong><br> 
		+ Được khai báo trong <b><i>methods, contructor, block</i></b>. Thực thi xong methods, contructor, block thì biến cũng được giải phóng(destroyed)<br>
		+ <b>KHÔNG</b> access-modifier<br>
		+ Không tự khởi tạo giá trị, nên phải khai báo kèm giá trị<br>
		+ Lưu trong <b>STACK</b>
	<br><br>
	<strong>- Instance variable:</strong><br> 
		+ Biến ở level <b><i>class</i></b><br>
		+ Instance variable được tạo, khi Object được tạo với từ khóa <b>new</b><br>
		+ CÓ “access-modifier” (mặc định là default)<br>
		+ Có gán giá trị default nếu không khởi tạo giá trị<br>
		+ Lưu trong <b>HEAD</b><br>
		<br>
	<strong>- Static variable:</strong><br>
		+ Biến ở level <b>class</b><br>
		+ Được tạo khi bắt đầu, và destroyed khi kết thúc program -> <b>chỉ khởi tạo 1 lần</b><br>
		+ Có gán giá trị default nếu không khởi tạo giá trị<br>
		+ Truy cập bằng cách: <b>TenClass.TenBien</b><br>
		+ Được lưu trong bộ nhớ <b>STATIC</b><br>
		+ Thường được sử dụng với final -> hằng số
		<br><br>
	<strong>- Const:</strong><br>
		+ Là giá trị bất biến trong program<br>
		+ Phải tự gán giá trị khởi tạo<br>
		+ Thường sử dụng vs static: public/private static final<br>
		+ Là const thì tên biến phải viết hoa, từ cách từ bằng "_"<br><br>

5. Modifiers:<br>
	<strong>- Access Modifiers:</strong><br>
		sử dụng ở: classes, variables, methods and constructors<br>
		+ package -> default<br>
		+ class only -> private<br>
		+ world -> public<br>
		+ package + all subclasses -> protected<br><br>
		<br>
	<strong>- Non-Access Modifiers:</strong><br>
		+ <b>static</b> modifier: class, methods and variables.<br>
		+ <b>final</b> modifier: classes, methods, and variables.<br>
		+ <b>abstract</b> modifier: abstract classes and methods.<br>
		+ <b>synchronized</b> and <b>volatile</b> modifiers, which are used for <i>threads</i>.<br>
	
