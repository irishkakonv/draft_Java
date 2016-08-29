package NIIT;                                                                  //на стеке

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	String data;
	String value;
	Node prev;
	Node next;
}

class NodeList {
	private Node currentNode = null;                 //point to the last/current element (указывает на последний/текущий элемент)
	private Node root = null;                        //point to the first element (указывает на первый элемент)

	public void addNode(String data, String value) { //do list of elements which have Node type
		if (root == null) {                          //do the fist element 
			root = new Node();						 
			root.data = data;
			root.value = value;
			root.next = null;
			root.prev = null;
			currentNode = root;
		} else {
			Node tmpNode = new Node();				  //do the last element
			tmpNode.data = data;
			tmpNode.value = value;
			tmpNode.prev = currentNode;               //assign a value to the last element (говорим, что это последний элемент)
			tmpNode.next = null;                      // +

			currentNode.next = tmpNode;               //for penultimate element point to current element (предпоследнему элементу говорим, что y него есть следущий = делаем привязку указываею друга 
			currentNode = tmpNode;                    // do current element the last (теперь говорим, что последний элекент, который только создан)
		}

	}

	public void printAll(String line) {				  //print value
		Node tmp = root;
		while (line.equals(tmp.data) == false) {	  //if the entered word not equal current word, see the next word 
			tmp = tmp.next;
			if (tmp == null) {						  
				System.out.println("The world is not dictionary");
				return;
			}
		}
		if (line.equals(tmp.data) == true) {
			System.out.println(tmp.value);
		}
	}
}

public class dictionary {
	public static void main(String[] args) throws IOException {
		NodeList words = new NodeList();

		words.addNode("one", "один");
		words.addNode("two", "два");
		words.addNode("three", "три");
		words.addNode("four", "четыре");
		words.addNode("five", "пять");
		words.addNode("six", "шесть");
		words.addNode("seven", "семь");
		words.addNode("eight", "восемь");
		words.addNode("nine", "девять");
		words.addNode("ten", "десять");

		while (true) {
			System.out.println("Enter the word");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			words.printAll(line);
		}
	}
}

/* выровнять по левому краю ctr + shift +f*/

