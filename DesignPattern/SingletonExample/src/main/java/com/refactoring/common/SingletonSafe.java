package com.refactoring.common;

public class SingletonSafe {

	// The field must be declared volatile(bay hơi) so that double check lock would work
    // correctly.
	private static volatile SingletonSafe singletonSafe;
	private String value;
	
	private SingletonSafe(String value) {
		this.value = value;
	}
	
	public static SingletonSafe getSingletonSafe(String value) {
		// The approach(cách tiếp cận) taken here is called double-checked locking (DCL). 
		// Nó tồn tại để ngăn chặn tình trạng nhiều threads khi đang cố gắng 
		// lấy instance singleton trong cùng 1 thời điểm. Vì cùng lấy trong 1 thời điểm
		// , nên chúng tạo ra những instance khác nhau
        //
        // Có vẻ như việc có biến 'result' ở đây là hoàn toàn vô nghĩa. 
		// Tuy nhiên, có một lưu ý rất quan trọng khi triển khai 
		// double-checked locking trong Java, 
		// được giải quyết bằng cách đưa vào biến cục bộ này.
        //
        // You can read more info DCL issues in Java here:
        // https://refactoring.guru/java-dcl-issue
		SingletonSafe result = singletonSafe;
        if (result != null) {
            return result;
        }
        synchronized(SingletonSafe.class) {
            if (singletonSafe == null) {
            	singletonSafe = new SingletonSafe(value);
            }
            return singletonSafe;
        }
	}
	
	public String getValue() {
		return this.value;
	}
}
