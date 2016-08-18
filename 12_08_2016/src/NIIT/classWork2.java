package NIIT;
class Node{
	private static Node begin = null;
	private String data;
	private Node previous;
	private Node next;
	private Node(String d, Node p, Node n){
		data = d;
		previous = p;
		next = n;
	}
	
	public static void addNode(String d){
		if(begin == null){
			begin = new Node(d, null, null);
		}
		else{
			begin.next = new Node(d, begin, null);
			begin = begin.next;
		}
	}
	
	public static void printNodeList(){
		Node n = begin;
		Node root = null;
		while(true){
			if(n.previous == null){
				root = n;
				break;
			}
			else {
				n = n.previous; 
			}
		}
		if(root != null) {
			System.out.println(root.data);
			while(root.next != null){
				root = root.next;
				System.out.println(root.data);
			}
		}
		else {
			System.out.println("Root not found");
		}
		
		
	}
	@Override
	public String toString() {
		return data + " p: " + previous + " n: " + next;
	}
}

public class classWork2 {
	
	public static void main(String[] args) {
		Node.addNode("first");
		Node.addNode("second");
		Node.addNode("third");
		Node.printNodeList();
		//Node first = null, second = null, third = null;
		//second = new Node("second", first, third );
		//third = new Node("third", second, null);
		//first = new Node("first", null, second);
	/*	first.data = "First element";
		first.next = second;
		first.previous = null;
		
		second.data = "Second element";
		second.next = third;
		second.previous = first;
		
		third.data = "Third element";
		third.next = null;
		third.previous = second;*/
		
		
		//Node.printNodeList(first);	
		//Node.printNodeList(second);	
		//Node.printNodeList(third);	
		
		
 		
	}

}
