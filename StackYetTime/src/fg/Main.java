package fg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
	String data;
	Node prev;
	Node next;
}
class NodeList{
	private  Node currentNode = null;// указывает на последний/текущий элемент
	private  Node root = null; // указывает на первый элемент
	public  void addNode(String data){
		if(root == null){
			root = new Node();
			root.data = data;
			root.next = null;
			root.prev = null;
			currentNode = root;
		}
		else{
			Node tmpNode = new Node();
			tmpNode.data = data;
			tmpNode.prev = currentNode; //говорим, что это  последний элемент
			tmpNode.next = null;					//+
			
			currentNode.next = tmpNode; //предпоследнему элементу говорим, что у него есть следущий = делаем привязку указываею друга 
			
			currentNode = tmpNode;   //теперь говорим, что последний элекент, который только создан
		}
			
	}
		public  void printAll(){
			Node tmp = root;
			while (tmp != null){
				System.out.println(tmp.data);
				tmp = tmp.next;
			}
			
		}
}

public class Main {
	public static void main(String[] args) throws IOException {
		NodeList animals = new NodeList();
		NodeList plants = new NodeList();
		
		animals.addNode("Cat");
		animals.addNode("Dog");
		animals.addNode("Pig");
		
		plants.addNode("Oak");
		plants.addNode("apple");
		plants.addNode("pine");
		
		animals.printAll();
		plants.printAll();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String line = br.readLine();
		
		String line2 = "abcd";
		if(line.equals(line2)){
			System.out.println("OK");
		}
		else{
			System.out.println("NOT OK");
		}
		System.out.println(line);
	}
}
