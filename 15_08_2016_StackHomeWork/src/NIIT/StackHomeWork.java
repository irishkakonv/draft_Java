package NIIT;

class Node{
	int value;
	Node prev;
	Node next;
}

interface Stack{
	void push(int value);
	int pop();
}

class Container implements Stack{
	private Node currentNode = null;
	private Node root = null;
	
	@Override
	public void push(int value){
		//throw new UnsupportedOperationException("Not supported yet.");
		if(root == null){
			root = new Node();
			root.value = value;
			root.prev = null;
			root.next = null;
			currentNode = root;
		}
		else{
			Node tmpNode = new Node();				  
			tmpNode.value = value;
			tmpNode.prev = currentNode;              
			tmpNode.next = null;                      
			currentNode.next = tmpNode;              
			currentNode = tmpNode;                 
		}
	}
	
	@Override
	public int pop(){
		//throw new UnsupportedOperationException("Not supported yet.");
		Node lastElement = new Node();
		try{
			lastElement.value = currentNode.value;
			currentNode = currentNode.prev;
		}
		catch(NullPointerException ex){
			System.err.println("Stack is empty");
		}
		return lastElement.value;		
	}
}


public class StackHomeWork{
	public static void main(String[] args){
		Stack s = new Container();
		s.push(2);
		s.push(6);
		s.push(7);
		s.push(11);
		System.out.println("The last element is " + s.pop());
		System.out.println("The last element is " + s.pop());
		System.out.println("The last element is " + s.pop());
		System.out.println("The last element is " + s.pop());
		System.out.println("The last element is " + s.pop());
	}
}	