public class ArrayDeque<T> implements Deque<T>{
    
    private T[] arrs;                  //generic type array
    private int size;          //size of valid array
    private int capacity;      //actualy maximum array tolerated length
    private int first, last;   //the index of first and last elements on arrs
    private static final int SIZE = 8;

    public ArrayDeque(){
        arrs = (T[]) new Object[SIZE];
        first = last = 0;
        capacity = arrs.length;
    }

    public ArrayDeque(T[] arrs){
        this();
        int size = arrs.length;
        if (size > capacity)    resize(size);
        this.size = size;
        System.arraycopy(arrs, 0, this.arrs, 0, size);
        first = 0; last = size-1;
    }

    private void resize(int capacity){
        T[] newarrs = (T[]) new Object[capacity];
        for (int i=0; i<size; i++){
            newarrs[i] = arrs[(first+i)%this.capacity];  //move original to new
        }
        first = 0; last = size-1;
        this.capacity = capacity;
        this.arrs = newarrs;
    }
    
    @Override
    public void addFirst(T x){    // insert x @ first-1
        if (size == 0) {
            first = last = 0; size++;
            arrs[0] = x;
            return;
        } 
        if (size == capacity)    resize(2*size);
        size++;
        if (first==0)  first = capacity;
        this.arrs[--first] = x;
    }

    @Override
    public void addLast(T x){   //insert x @ last+1
        if (size == 0) {
            first = last = 0; size++;
            arrs[0] = x;
            return;
        } 
        if (size == capacity)   resize(2*size);
        size++;
        if (last==capacity-1)     last = -1;
        this.arrs[++last] = x;
    }

    public int getFirst() {return first;}
    public int getLast() {return last;}

    @Override
    public boolean isEmpty() {return size==0;}

    @Override
    public int size() {return size;};      

    @Override
    public void printDeque(){
        for (int i=first, n=0; n<size; i++, n++){
            System.out.print(arrs[i%capacity] + " ");
        }
    }
    
    public void printIndex(){
        for (int i=first, n=0; n<size; i++, n++){
            System.out.print(i%capacity + " ");
        }
    }

    @Override
    public T get(int i){        //return item at given index
        if (i < 0 || i >= size) return null;
        return arrs[(first+i)%capacity];
    }
    
    @Override
    public T removeFirst(){     //remove x @ first
        if (size == 0) return null;
        size--;
        T x = arrs[first]; arrs[first] = null;
        if (++first == capacity) first = 0;
        if (size > 0 && size*4 < capacity) resize(size*2);
        return x;
    }

    @Override
    public T removeLast(){      //remove x @ last 
        if (size == 0) return null;
        size--;
        T x = arrs[last]; arrs[last] = null;
        if (--last == -1)   last = capacity-1;
        if (size > 0 && size*4 < capacity) resize(size*2);
        return x;
    }

    
    public static void main(String[] args) {
        String[] string = new String[]{"haha", "haxe"};
        ArrayDeque sL = new ArrayDeque<String>(string);
        System.out.println(String.format("size: %d, capacity: %d", sL.size, sL.capacity));
        Integer[] integer = new Integer[]{1,2,3,4,5,6,7,8};
        ArrayDeque iL = new ArrayDeque<Integer>(integer);
        System.out.println(String.format("size: %d, capacity: %d", iL.size, iL.capacity));
        iL.printDeque();
        
        // System.out.println(String.format("actual length: %d, size: %d", deque.arrs.length, deque.size));
    }

}
