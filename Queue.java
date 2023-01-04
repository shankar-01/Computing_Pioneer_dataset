/**
 * queue data structure
 * working: first in first out
 * class implement following interface
 * methods:
 * createQueue: re-create queue wash previous values
 * enqueue: store element on back of queue
 * dequeue: remove front element of queue
 * peek: return front element of queue
 * isempty : return true if queue has no element
 * isFull :  return true if queue is full no capacity to store further
 * display : print elements of queue on screen
 * toString : return elements of queue in string format
 * */
interface QueueI<E> {
    public void createQueue();
    public void enqueue ( E e );
    public E dequeue ();
    public E peek();
    public boolean isEmpty();
    public boolean isFull();

}
public class Queue<E> implements QueueI<E>{
    private int numberOfQueueElements = 0;
    private int front = 0;
    private int rear = -1;
    private E[] aQueue;
    Queue() {

        this.aQueue = (E[])new Object[10];
        this.numberOfQueueElements = 0;
        this.front = 0;
        this.rear = -1;
    }
    Queue( int size ) {
        if (size<=0) {
            System.out.println("Size of array not allowed");
            size = 10;
        }
        this.aQueue = (E[])new Object[size];
        this.numberOfQueueElements = 0;
        this.front = 0;
        this.rear = -1;
    }
    @Override
    public void createQueue() {
        this.aQueue = (E[])new Object[aQueue.length];
        this.numberOfQueueElements = 0;
        this.front = 0;
        this.rear = -1;
    }

    @Override
    public void enqueue(E e) {
        if ( isFull() ) {
            System.out.println(String.format("Array is full"));
        } else {
            // this.rear ++;
            this.rear = (this.rear + 1)% aQueue.length;
            this.aQueue[this.rear] = e;
            this.numberOfQueueElements ++;
        }
    }

    @Override
    public E dequeue() {
        if ( isEmpty() ) {
            throw new NullPointerException("Can't dequeue queue its Empty!!");
        } else {
            this.numberOfQueueElements --;
            E e = this.aQueue[this.front];
            // this.front ++;
            this.front = (this.front + 1)% aQueue.length;
            return e;
        }
    }

    @Override
    public E peek() {
        if ( isEmpty() )
            throw new NullPointerException("Can't peek at front item as the queue is Empty!!");
        else
            return this.aQueue[this.front];
    }

    @Override
    public boolean isEmpty() {
        return ( this.getQueueSize() == 0 );
    }

    @Override
    public boolean isFull() {
        return ( this.numberOfQueueElements == aQueue.length);
    }

    public void displayQueue() {
        System.out.println( this.toString() );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder( "\n" );
        //int tmp = this.getStackSize() - 1;
        if(isEmpty())
        {
            sb.append("The queue is Empty!!");
        }
        else
        {
            int qPos = this.front;
            for(int element = 0; element < this.numberOfQueueElements; element++) {
                sb.append( this.aQueue[ qPos ] + "\n");
                qPos = (qPos + 1)% aQueue.length;
            }
        }
        return sb.toString();
    }

    public int getQueueSize() {
        return this.numberOfQueueElements;
    }
}
