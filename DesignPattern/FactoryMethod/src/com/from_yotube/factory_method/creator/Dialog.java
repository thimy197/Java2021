package com.from_yotube.factory_method.creator;

import com.from_yotube.factory_method.product.ButtonProduct;

// The creator class 
// declares the factory method that must 
// return an object of a product class. The creator's subclasses
// usually provide the implementation of this method.
public abstract class Dialog {

	// The creator may also provide some default implementation
    // of the factory method.
	public abstract ButtonProduct createButton();
	
	// Lưu ý rằng, mặc dù có tên như vậy nhưng trách nhiệm chính của 
	// creator không phải là tạo ra product. Nó thường chứa một số 
	// logic business cốt lõi dựa trên các đối tượng sản phẩm được trả về 
	// bởi phương thức factory. Các lớp con có thể gián tiếp thay đổi 
	// logic business đó bằng cách ghi đè phương thức factory và trả về một 
	// loại product khác với nó.	
	public void render() {
		// Call the factory method to create a product object.
		ButtonProduct button = createButton();
		// Now use the product.
		button.onClick();
		button.render();
	}
	
}
