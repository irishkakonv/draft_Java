package NIIT;                                                                  //�� �����

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
	private Node currentNode = null;                 //point to the last/current element (��������� �� ���������/������� �������)
	private Node root = null;                        //point to the first element (��������� �� ������ �������)

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
			tmpNode.prev = currentNode;               //assign a value to the last element (�������, ��� ��� ��������� �������)
			tmpNode.next = null;                      // +

			currentNode.next = tmpNode;               //for penultimate element point to current element (�������������� �������� �������, ��� y ���� ���� �������� = ������ �������� ��������� ����� 
			currentNode = tmpNode;                    // do current element the last (������ �������, ��� ��������� �������, ������� ������ ������)
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

		words.addNode("one", "����");
		words.addNode("two", "���");
		words.addNode("three", "���");
		words.addNode("four", "������");
		words.addNode("five", "����");
		words.addNode("six", "�����");
		words.addNode("seven", "����");
		words.addNode("eight", "������");
		words.addNode("nine", "������");
		words.addNode("ten", "������");

		while (true) {
			System.out.println("Enter the word");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			words.printAll(line);
		}
	}
}

/* ��������� �� ������ ���� ctr + shift +f*/

