/**
 * Java program to illustrate Serializable interface
 */
package serializable;

import java.io.*;

public class SerializableTest {

	public static void main(String[] args)
	{
		A a = new A(25, "My");

		try {
			/* Serializing 'a' */		
			// Saving of object in a file
			File file = new File("files/xyz.txt");
			if(!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// Method for serialization of object
			oos.writeObject(a);
			// closing streams
			oos.close();
			fos.close();
			System.out.println("Object has been serialized");

			/* De-serializing 'a' */
			// Reading the object from a file
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			// Method for deserialization of object
			A b = (A)ois.readObject();//down-casting object
			// closing streams
			ois.close();
			fis.close();
			System.out.println("Object has been deserialized ");

			System.out.println(b.toString());

		}catch(IOException ex){
			System.out.println("IOException is caught");
		}
		catch(ClassNotFoundException ex){ // of readObject()
			System.out.println("ClassNotFoundException is caught");
		}

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