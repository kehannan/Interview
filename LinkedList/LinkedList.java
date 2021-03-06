import java.util.*;

public class LinkedList{
	private LinkedListNode head;
	private int size;
	public LinkedList(){
		this.head = null;
		this.size = 0;

}
	public void reverse(){
		LinkedListNode current, next, loop;
		current = head; next = current.getNext(); loop = null;
		while (next != null){
			current.setNext(loop);
			loop = current;
			current = next;
			next = next.getNext();
		}
		head = current;
		head.setNext(loop);
	}
	public void add(Object s){
		LinkedListNode temp = new LinkedListNode(s);
		if (this.size == 0){
			head = temp;
			this.size++;
		}
		else{
			LinkedListNode current  = head;
			while (current.getNext() != null){
				current = current.getNext();
		}
		current.setNext(temp);
		this.size++;
	}
}
	public void insert(Object s, int index){
		LinkedListNode temp = new LinkedListNode(s);

		//Invalid index.It also can be treated as a head.
		if (index < 0 ){
			temp.setNext(head);
			head = temp;	
			this.size ++;
		}
		//Any index exceeds the size will be appended to the tail.
		else if (index > size){
			this.add(s);
		}
		else{
			LinkedListNode current = head;
			LinkedListNode previous = null;
			for( int i = 0; i < index - 1 && current.getNext() != null ; i++){
			current = current.getNext();

			}
		previous = current;
		current = current.getNext();
		previous.setNext(temp);
		temp.setNext(current);
		this.size++;
		}
}
	public Object get(int index){
		if (index < 0 || index > this.size){
			return null;
}
		LinkedListNode current = head;
		for (int i = 1 ; i <= index ; i++){
			current = current.getNext();
		
		}
		return current.getValue();
}
	public boolean remove(Object s){
		LinkedListNode current = head;
		LinkedListNode previous = null;
		while(current != null){
			if (current.getValue().equals(s)){
				previous.setNext(current.getNext());
				this.size --;
				return true;
			}
			previous = current;
			current = current.getNext();
	}
		return false;
}
	public void removeDuplicates(){
		LinkedListNode current, previous;
		current = head;
		previous = null;
		HashSet table = new HashSet();
		while (current != null){
			if (table.contains(current.getValue())) {
				previous.setNext(current.getNext());
		}
			else{
				previous = current;
				table.add(current.getValue());
		}
			current = current.getNext();
			
	}
}

	 public String toString(){
			LinkedListNode current = this.head;
			String output ="The elements are ";
			while (current != null){
				output += " " + current.getValue();
				current = current.getNext();
			}
			return output;

	}

	public int getSize(){
		return this.size;
}
	public LinkedListNode getHead(){
		return this.head;
	}

		public static void main(String[] args){
		LinkedList l = new LinkedList();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.insert(6,2);
		System.out.println(l.remove(3));

		l.reverse();
		System.out.println(l.toString());

}
public int count = 0;
	public void removeDupNoHashset(){
		if (head == null) return;
		LinkedListNode current, previous;
		LinkedListNode runner;
		previous = head;
		current = previous.getNext();
		
		while (current != null){
			runner = head;	//Look backward to find duplicates.
			while ( runner != current){
				if (runner.getValue() == current.getValue()){
						LinkedListNode temp = current.getNext();
						previous.setNext(temp);
						current = temp;
						break;
				}
				count ++;
				runner = runner.getNext();

			}

			if (runner == current){
				previous = current;
				current = current.getNext();
				count ++;
			}
		}		
	}
	
public LinkedListNode returnKth(int k){
	if ((k < 0)||(k > this.size)){
		return null;
	}
	int index = 0;
	LinkedListNode current = this.head;
	while (current != null){
		if (index == (this.size-k)){
			return current;
		}
		index ++;
		current = current.getNext();

	}
	return null;
}

private class IntWrapper{
	public int value = 0;
}
public LinkedListNode returnKth2(LinkedListNode node , int k, IntWrapper i){
	if ((node == null)|| k < 0) return null;
	LinkedListNode n = returnKth2(node.getNext(),k, i);
	i.value = i.value + 1;	
	 if ( i.value == k){
	 	return node;
	 }
	return n;
}
//Iteratively return the last Kth element.
public LinkedListNode returnKth3(int k){
	LinkedListNode p1 = head;
	LinkedListNode p2 = head;
	for (int i = 0 ; i < k ; i++){
		p2 = p2.getNext();
	}
	while (p2 != null){
		p2 = p2.getNext();
		p1 = p1.getNext();
	}
	return p1;

}
	public void deleteMidEle(Object s){
		LinkedListNode newS = new LinkedListNode(s);
		LinkedListNode temp = newS.getNext();
		try{
			newS.setValue(temp.getValue());
			newS.setNext(temp.getNext());
			this.size --;

			}
		catch (NullPointerException e){
			System.out.println("This may be the last element.");	
	}
}
}