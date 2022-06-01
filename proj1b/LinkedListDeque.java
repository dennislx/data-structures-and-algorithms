public class LinkedListDeque<T> implements Deque<T>  {

    private class Node {
		T item; Node next; Node prev;

        Node(T x, Node p, Node n) {
			item = x; next = n; prev = p;
		}
        Node(T x){
            this(x, null, null);
        }
	} 

    private Node sentinel;
    private int size;

    public LinkedListDeque(){ 
        sentinel = new Node(null);
        size = 0;
        sentinel.prev = sentinel; 
        sentinel.next = sentinel;
    }   // constructor

    public LinkedListDeque(T x){
        sentinel = new Node(null, null, null);
        size = 1;
        sentinel.next = new Node(x, sentinel, sentinel);
        sentinel.prev = sentinel;
    }   // constructor with argument, s(0) <-> x <-> s(0)

    @Override
    public void addFirst(T item){
        size += 1;
        Node old_next = sentinel.next;
        sentinel.next = new Node(item, sentinel, sentinel.next); //s(0) -> x
        old_next.prev = sentinel.next; // x <- s(0)
    }

    @Override
    public void addLast(T item){
        size += 1;
        Node old_prev = sentinel.prev;
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        old_prev.next = sentinel.prev;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        for (Node p=sentinel.next; p!=sentinel; p=p.next){
            System.out.print(p.item + " ");
        }
    }

    public T removeFirst(){
        if (size == 0) return null;
        else {
            size -= 1;
            Node first = sentinel.next;
            sentinel.next = first.next;
            sentinel.next.prev = sentinel;
            return first.item;
        }
    }

    public T removeLast(){
        if (size == 0) return null;
        else {
            size -= 1;
            Node last = sentinel.prev;
            sentinel.prev = last.prev;
            sentinel.prev.next = sentinel;
            return last.item;
        }
    }

    public T get(int i){ //return item at index i
        if (i >= size || i < 0) return null;
        Node cur;
        for (cur=sentinel; i>0; i--){
            cur = cur.next;
        }
        return cur.next.item;
    }

    private T getRecursiveHelper(int i, Node n){
        if (i==0) return n.item;
        return getRecursiveHelper(i-1, n.next);
    }

    public T getRecursive(int i){
        if (i >= size || i < 0) return null;
        return getRecursiveHelper(i, sentinel.next);
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<Integer>();
        L.addFirst(2); L.addLast(3); L.addFirst(2);
        System.out.println(L.get(1));
    }
}
