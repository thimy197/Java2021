
public class Variables {

	/*
	 * This is instance variable:
	 * + Khởi tạo trong class và ngoài method
	 * + Không cần khởi tạo giá trị mặt định, dựa vào type -> giá trị mặt định (int->0)
	 * + Có access-modifiers
	 * + Lưu trong HEAD
	 */
	public int id;
	
	/*
	 * This is static variable:
	 * + Khai báo ở class
	 * + khởi tạo 1 lần trong suốt CT
	 * + Không cần khởi tạo giá trị mặt định
	 * + Gọi thông qua class: Variables.DEFAULT_FLOAT
	 * + Method có static mới sử dụng được biến static
	 * + Lưu trong bộ nhớ STATIC
	 */
	public static float DEFAULT_FLOAT;
	
//	bắt buộc phải khởi tạo giá trị nếu có final
//	public static final int DEFAULT_STRING; //error
	public static final float PI = 3.14f;
	
	public static void main(String[] args) {
		/*
		 * this is local variable
		 *  + Khai báo trong method, contructor, block
		 *  + Không có access-modifier
		 *  + Lưu trong STACK
		 */
		int i;
//		bắt buộc phải gán giá trị trước khi sử dụng
//		System.out.println(i); // error
		i = 10;
		System.out.println(i);
		
//		Gọi biến static
		System.out.println(Variables.DEFAULT_FLOAT);
		
	}
	
	public void getStaticVariable() {
		System.out.println(DEFAULT_FLOAT);
	}

}
