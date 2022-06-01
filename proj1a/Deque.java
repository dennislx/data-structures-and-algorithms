public interface Deque<T> {
    public void addFirst(T item);       //add item to front of deque
    public void addLast(T item);        //add item to last of deque
    public boolean isEmpty();           //check if deque is empty
    public int size();                  //return number of elements in deque (constant)
    public T get(int i);                //get the item at given index, 0 is the front
    public void printDeque();           //print items from first to last, seperated by space
    public T removeFirst();             //remove and return the item at the front of deque, return null if not exists
    public T removeLast();             //remove and return the item at the end of deque, return null if not exists
}   