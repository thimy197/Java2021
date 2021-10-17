
public class CloneableMethod {

	// throws for test2 and test3
	public static void main(String[] args) throws CloneNotSupportedException{

		/**
		 * Test1 to demonstrate that assignment operator
		 * only creates a new reference to same object
		 */
		System.out.println("======reference to same object========");
		Test ob1 = new Test();

		System.out.println(ob1.x + " " + ob1.y);

		// Creating a new reference variable ob2
		// pointing to same address as ob1
		Test ob2 = ob1;

		// Any change made in ob2 will
		// be reflected in ob1
		ob2.x = 100;

		System.out.println(ob1.toString());
		System.out.println(ob2.toString());

		// chúng cùng chung bộ nhớ
		System.out.println(ob1.hashCode());
		System.out.println(ob2.hashCode());

		System.out.println("ob1 == ob2: "+ (ob1 == ob2));
		System.out.println("ob1 equals ob2: "+ (ob1.equals(ob2)));

		/**
		 * Test2 to demonstrate
		 * shallow copy using clone()
		 */
		System.out.println("======shallow copy========");
		Test2 t1 = new Test2();
		t1.a = 10;
		t1.b = 20;
		t1.test.x = 30;
		t1.test.y = 40;

		Test2 t2 = (Test2)t1.clone();

		// Creating a copy of object t1
		// and passing it to t2
		t2.a = 100;

		// Change in primitive type of t2 will
		// not be reflected in t1 field
		t2.test.x = 300;

		// Change in object type field will be
		// reflected in both t2 and t1(shallow copy)
		System.out.println(t1.toString());
		System.out.println(t2.toString());

		// chúng khác bộ nhớ ở Test2, nhưng chung bộ nhớ ở Test
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		System.out.println(t1.test.hashCode());
		System.out.println(t2.test.hashCode());

		/**
		 * Test3 to demonstrate
		 * deep copy using clone()
		 * 
		 * Trong trường hợp deep copy này, phải thực hiện tạo tay mới Object test
		 * không thể sử dụng clone() method trong Test đc
		 */
		System.out.println("======deep copy========");
		Test3 t3 = new Test3();
		t3.a = 10;
		t3.b = 20;
		t3.test.x = 30;
		t3.test.y = 40;
 
        Test3 t3Clone = (Test3)t3.clone();
        t3Clone.a = 100;
 
        // Change in primitive type of t2 will
        // not be reflected in t1 field
        t3Clone.test.x = 300;
 
        // Change in object type field of t2 will
        // not be reflected in t1(deep copy)
        System.out.println(t3.toString());
        System.out.println(t3Clone.toString());
        
        // chúng khác bộ nhớ ở Test3, nhưng chung bộ nhớ ở Test3Clone
 		System.out.println(t3.hashCode());
 		System.out.println(t3Clone.hashCode());
 		System.out.println(t3.test.hashCode());
 		System.out.println(t3Clone.test.hashCode());
	}

}

//A test class whose objects are cloned
class Test{
	int x, y;
	Test()
	{
		x = 10;
		y = 20;
	}
	
	@Override
	public String toString() {
		return x+" "+y;
	}
}

// Contains a reference of Test and
// implements clone with shallow copy.
class Test2 implements Cloneable {
	int a;
	int b;
	Test test = new Test();

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public String toString() {
		return a+" "+b+" "+test.toString();
	}
}

//Contains a reference of Test and
//implements clone with deep copy.
class Test3 implements Cloneable {
	int a, b;

	Test test = new Test();

	public Object clone() throws CloneNotSupportedException
	{
		// Assign the shallow copy to
		// new reference variable t
		Test3 t = (Test3)super.clone();

		// Creating a deep copy for c
		t.test = new Test();
		t.test.x = test.x;
		t.test.y = test.y;

		// Create a new object for the field c
		// and assign it to shallow copy obtained,
		// to make it a deep copy
		return t;
	}
	@Override
	public String toString() {
		return a+" "+b+" "+test.toString();
	}
}