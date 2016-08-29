package NIIT;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;

class A implements Serializable{
	private int data;
	public A(int value){
		data = value;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
}
public class Main26_1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		A a1 = new A(1);
		A a2 = new A(2);
		
		System.out.println("a1" + a1.getData());
		System.out.println("a2" + a2.getData());
		
		InputStream is = System.in;
		OutputStream os = System.out;
//		int ch;
//		while (true) {
//			
//			if ((ch = is.read(charr)) != -1) {
//				os.write(ch);
//			} else {
//				System.out.println("End of file");
//				break;
//			}
		/*	byte charr[] = new byte[10];
			 is.read(charr);
			 os.write(charr);
			 os.flush();
			 while(true);
		*/
		
		String filename = "text.txt";
		File file = new File(filename);
		if (! file.exists()) {
			System.out.println("sdg");
			file.createNewFile();
			
		}
		else{
			System.out.println("file exists");
		}
		
	/*	FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a1);
		oos.flush();
		oos.close();
		*/
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object o = ois.readObject();
		
		if (o instanceof A){
			A a = (A)o;
			System.out.println("a " + a.getData());
		}
		
		
		
		
//		FileWriter fw = new FileWriter(file);
//		FileReader fr = new FileReader(file);
		
		
//		InputStream fis = new FileInputStream(file);
//		OutputStream fos = new FileOutputStream(file, true);
//		
//		InputStreamReader isr = new InputStreamReader(is);
//		OutputStreamWriter osw = new OutputStreamWriter(fos);
//		
//		
//		
//		BufferedReader br = new BufferedReader(isr);
//		BufferedWriter bw = new BufferedWriter(osw);
//
//		String line = br.readLine();
//		bw.write(line);
//		bw.flush();
	}

}
