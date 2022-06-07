// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;


public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> implements Iterable<T>{
    private int first;   // least recently inserted item
    private int last;    // one beyond the most recently inserted item
    private T[] rb;      // buffer data

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = last = fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    @Override
    public int capacity() {return rb.length;}

    @Override
    public int fillCount() {return fillCount;}

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if (isFull()){
            throw new RuntimeException("Ring Buffer Overflow");
        }
        rb[last] = x;
        last = (last+1)%capacity; 
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new RuntimeException("Ring Buffer Underflow");
        }
        T rtn = rb[first];
        first = (first+1)%capacity;
        fillCount--;
        return rtn;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if (isEmpty()){
            throw new RuntimeException("Ring Buffer Empty");
        }
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
    public Iterator<T> iterator(){
        return new MyIterator();
    }
    private class MyIterator implements Iterator<T>{
        private int cur = 0, size = fillCount;
        MyIterator()        { cur = first; }
        public boolean hasNext()   { return size != 0; }
        public T next(){ 
            T next = rb[cur];
            cur = (cur+1)%capacity;
            size--;
            return next;
        }
    }
}
