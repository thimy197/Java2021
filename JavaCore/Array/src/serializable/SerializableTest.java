/**
 * Java program to illustrate Serializable interface
 */
package serializable;

import java.io.*;

public class SerializableTest {

	public static void main(String[] args)
			throws IOException, ClassNotFoundException
	{
		A a = new A(25, "My");

		// Serializing 'a'
		FileOutputStream fos = new FileOutputStream("files/xyz.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a);

		// De-serializing 'a'
		FileInputStream fis = new FileInputStream("files/xyz.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		A b = (A)ois.readObject();//down-casting object

		System.out.println(b.toString());

		// closing streams
		oos.close();
		ois.close();
	}

}

//By implementing Serializable interface
//we make sure that state of instances of class A
//can be saved in a file.
class A implements Serializable
{
	int i;
	String s;

	public A(int i, String s)
	{
		this.i = i;
		this.s = s;
	}
	
	@Override
	public String toString() {
		return i+" "+s;
	}
}