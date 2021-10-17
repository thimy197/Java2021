
public class CloneableTest {

	public static void main(String[] args) throws CloneNotSupportedException{

		A a = new A(1, "string");
		
		// cloning 'a' and holding
        // new cloned object reference in b
		
		// down-casting as clone() return type is Object
        A b = (A)a.clone();
        
        System.out.println(b.i);
        System.out.println(b.str);
	}

}

class A implements Cloneable{
	int i;
	String str;
	
	public A(int i, String str) {
		this.i = i;
		this.str = str;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}