public class LinkedList<T> implements List<T>{
	protected int size;
	protected Node head;

	public LinkedList() { // create a new head
		head = null;
		size = 0;
	}

	public void add(T item) {//add item to the tail
		if(head==null) {//if do not have head, make this be the head
			Node curr = new Node(item);
			head = curr;
			size++;
		} else {
			Node curr = head;
			while(curr.getNext()!=null) {
				curr = curr.getNext();
			}
			Node newnode = new Node(item);
			newnode.setNext(null);
			curr.setNext(newnode);
			size++;
		}
	}

	public void add(int pos, T item){ //add item in specific position
		if(pos<0||pos>size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("illegal");
			}
		}
		if(pos==0) {//add one infront of the old head
			Node newnode = new Node(item);
			newnode.setNext(head);
			head = newnode;
			size++;
		} else {
			Node newnode = new Node(item);
			Node prev = head;
			for(int i = 0; i < pos-1; i++) {//go throught the list to the previous one
				prev = prev.getNext();
			}
			newnode.setNext(prev.getNext());
			prev.setNext(newnode);
			size++;
		}
	}

	public T get(int pos) {//return the data in that position
		if(pos<0||pos>=size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("illegal");
			}
		}
		Node curr = head;
		for(int i = 0; i<pos;i++) {// go to the position from head
			curr = curr.getNext();
		}
		return (T)curr.getData();
	}

	public int size() {//return the size of the list
		return size;
	}

	public T remove(int pos) {// remove the node in that position
		if(pos<0||pos>=size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("illegal");
			}
		}
		if(pos==0) {//remove the head
			Node curr = head;
			head = curr.getNext();
			size--;
			return (T)curr.getData();
		} else {
			Node prev = head;
			for(int i = 0; i < pos-1; i++) {
				prev = prev.getNext();
			}
			Node curr = prev.getNext();
			prev.setNext(curr.getNext());//link prev and this.next together
			size--;
			return (T)curr.getData();
		}
	}












}