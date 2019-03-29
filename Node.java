public class Node<T> {//node is one single part of linked list
	protected Node next;
	protected T data;

	public Node(T item) {
		data = item;
	}

	public Node getNext() {
		return next;
	}

	public T getData() {
		return data;
	}

	public void setNext(Node a) {
		next = a;
	}

}