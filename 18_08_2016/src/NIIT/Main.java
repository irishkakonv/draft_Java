package NIIT;

//No dublicats[sorted]
interface StringContainer {
	// setters
	public void setElement(String element, int index);

	public void addElement(String element);

	// getters
	public String getElement(int index);// NOT SORTED

	public String getLast();

	public String getFirstElement();

	public boolean isExist(String element);

	public boolean isExist(int index);

	public int getIndex(String element);

	public int getSize();

	// removers
	public void removeElement(String element);

	public void removeElement(int index);

	public void removeLast();

	public void removeFirst();

	public void removeAll();
}

class Element {
	String element;
	Element prev;
	Element next;
}

class Realization implements StringContainer {
	private Element currentElement = null;
	private Element root = null;
	int count = 0;

	public void printAll() {
		Element tmpElement = root;
		while (tmpElement != null) {
			System.out.println(tmpElement.element);
			tmpElement = tmpElement.next;
		}

	}

	@Override
	public void setElement(String element_, int index_) {
		Element tmpElement = root;
		count = 0;
		
//		Element tmpElement = new Element();
		
		while (!tmpElement.element.equals(element_)) {
			while (count != index_) {
				tmpElement = tmpElement.next;
				count++;
			}

			currentElement.element = element_;
			if (tmpElement.prev == null){
				currentElement.prev = null;
				tmpElement.prev = currentElement;
				}
			else{	
				currentElement.prev = tmpElement.prev;
				tmpElement.prev.next = currentElement;
			}
			
			if(tmpElement.next == null){
				currentElement.next = tmpElement;
				tmpElement.prev = currentElement;
			}
			else{
				currentElement.next = tmpElement;
				tmpElement.next.prev = currentElement;
			}
			return;
		}
		System.out.println("The element exists already.");
	}

	@Override
	public void addElement(String element_) {
		if (root == null) {
			root = new Element();
			root.element = element_;
			root.prev = null;
			root.next = null;
			currentElement = root;
		} else {
			Element tmpElement = new Element();
			tmpElement.element = element_;
			tmpElement.prev = currentElement;
			tmpElement.next = null;
			currentElement.next = tmpElement;
			currentElement = tmpElement;
		}
	}

	@Override
	public String getElement(int index_) {
		Element tmpElement = root;
		count = 0;
		try {
			while (count != index_) {
				tmpElement = tmpElement.next;
				count++;
			}
			return tmpElement.element;
		} catch (RuntimeException ex) {
			return "The element doesn't exist.";
		}

	}

	@Override
	public int getIndex(String element_) {
		Element tmpElement = root;
		count = 0;
		try {
			while (!tmpElement.element.equals(element_)) {
				count++;
				tmpElement = tmpElement.next;
			}
			return count;
		} catch (RuntimeException ex) {
			System.err.println("This word doesn't exist in the list.");

		}
		return -1;

	}

	@Override
	public String getLast() {
		Element tmpElement = root;
		try {
			while (!tmpElement.next.equals(null)) {
				count++;
				tmpElement = tmpElement.next;
			}
		} catch (RuntimeException ex) {
		}
		return tmpElement.element;
	}

	@Override
	public String getFirstElement() {
		return root.element;
	}

	@Override
	public boolean isExist(String element_) {
		Element tmpElement = root;
		try {
			while (!tmpElement.element.equals(element_)) {
				tmpElement = tmpElement.next;
			}
			return true;
		} catch (RuntimeException ex) {
			return false;
		}
	}

	@Override
	public boolean isExist(int index_) {
		Element tmpElement = root;
		count = 0;
		try {
			while (tmpElement != null) {
				if (count == index_) {
					return true;
				}
				count++;
				tmpElement = tmpElement.next;
			}
		} catch (RuntimeException ex) {

		}
		return false;
	}

	@Override
	public int getSize() {
		Element tmpElement = root;
		count = 0;
		while (tmpElement != null) {
			count++;
			tmpElement = tmpElement.next;
		}
		return count;
	}

	@Override
	public void removeElement(String element_) {
		currentElement = root;
		try {
			while (!currentElement.element.equals(element_)) {
				currentElement = currentElement.next;
			}
			if (currentElement.prev == null) {
				currentElement = root;
				currentElement = currentElement.next;
				root = currentElement;
			}
			Element tmpElement = new Element();
			tmpElement = currentElement.next;
			currentElement = currentElement.prev;
			currentElement.next = tmpElement;
			printAll();
		} catch (RuntimeException ex) {
			System.err.println("This element doesn't find.");
		}
	}

	@Override
	public void removeElement(int index_) {
		currentElement = root;
		try {
			while (count != index_) {
				currentElement = currentElement.next;
				count++;
			}
			if (currentElement.prev == null) {
				currentElement = root;
				currentElement = currentElement.next;
				root = currentElement;
			}
			Element tmpElement = new Element();
			tmpElement = currentElement.next;
			currentElement = currentElement.prev;
			currentElement.next = tmpElement;
			printAll();
		} catch (RuntimeException ex) {
			System.err.println("This element doesn't find.");
		}
	}

	@Override
	public void removeLast() {
		currentElement = currentElement.prev;
		currentElement.next = null;
	}

	@Override
	public void removeFirst() {
		currentElement = root;
		currentElement = currentElement.next;
		root = currentElement;
	}

	@Override
	public void removeAll() {
		while (currentElement != null) {
			currentElement = root;
			currentElement = currentElement.next;
			root = currentElement;
			printAll();
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Realization el = new Realization();
		el.addElement("The first");
		el.addElement("The second");
		el.addElement("The third");
		// el.printAll();
		el.setElement("Other", 2);
		 el.printAll();
		// System.out.println("Element with this index is \"" + el.getElement(0)
		// + "\"");
		// System.out.println("The word have index " + el.getIndex("The
		// second"));
		// System.out.println("The last element is \"" + el.getLast() + "\"");
		// System.out.println("The first element is \"" + el.getFirstElement() +
		// "\"");
		// System.out.println("The list exists this word. It is " +
		// el.isExist("The first"));
		// System.out.println("The list exists this index. It is " +
		// el.isExist(3));
		// System.out.println(el.getSize());
		// el.removeFirst();
		// el.removeLast();
		// el.removeAll();
		// el.removeElement("The third");
		// el.removeElement(2);
	}
}
