public class ArrayList<T> implements List<T>{
	protected int size = 10; //default size is 10
	protected T [] arr;
	protected int tail;

	public ArrayList() {
		arr = (T[]) new Object[size]; // create an array
		tail = 0; // zero items in array, the next place to add is index 0;
	}

	public void add(T item) { // add item to the tail
		if(tail == arr.length) {//grow array length if full
			grow_array();
		}
		arr[tail] = item;
		tail++;
	}

	public void add(int pos, T item) {//add item into specific position
		if(pos<0||pos>tail) {//throw exception if out of index
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("illegal");
			}
		}
		if(tail == arr.length) {
			grow_array();
		}
		for(int i = tail; i>pos;i--) { //everythign after that move backward;
			arr[i] = arr[i-1];
		}
		arr[pos]=item;
		tail++;
	}

	public T get(int pos) {//return data in that position
		if(pos<0||pos>tail) {
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("illegal");
			}
		}
		return arr[pos];
	}

	public T remove(int pos) {//delete data in that postion
		if(pos<0||pos>=tail) {
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("illegal");
			}
		}
		T a = arr[pos];
		for(int i = pos;i<tail;i++){
			arr[i] = arr[i+1];
		}
		tail--;
		return a;
	}

	public int size() {//return the amout of items in the list
		return tail;
	}

	public void grow_array() { // double the array length
		T [] temp = (T[]) new Object[arr.length*2];
		for(int i = 0;i < arr.length; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}

}