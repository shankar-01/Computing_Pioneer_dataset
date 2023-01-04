/**
 * Stack data structure
 * working : last in first out
 * class implement following interface
 * methods:
 * push item : store item
 * pop item : remove top item
 * peek item : return top item (not remove)
 * isempty : return true if stack has no element
 * isFull :  return true if stack is full no capacity to store further
 * createStack : re-create stack means wash previous values
 * getStackSize : return stack total capacity
 * display : print elements of stack on screen
 * toString : return elements of stack in string format
 * */
interface StackI<E> {
    public void createStack();
    public void push ( E e );
    public E pop ();
    public E peek();
    public boolean isEmpty();
    public boolean isFull();

}

public class Stack<E> implements StackI<E>{
    private int numberOfStackElements = 0;
    private int top = -1;
    private E[] aStack;

    /**
     * Default constructor
     */
    Stack() {

        this.aStack = (E[])new Object[10];
        this.numberOfStackElements = 0;
        this.top = -1;
    }
    Stack( int size ) {
        if ( size <=0) {
            System.out.println("Size of array not allowed!");
            size = 10;
        }

        this.aStack = (E[])new Object[size];
        this.numberOfStackElements = 0;
        this.top = -1;
    }
    @Override
    public void createStack() {
        this.aStack = (E[])new Object[aStack.length];
        this.numberOfStackElements = 0;
        this.top = -1;
    }

    @Override
    public void push(E e) {
        if ( isFull() ) {
            System.out.println(String.format("Array is full."));
        } else {
            this.top ++;
            this.aStack[this.top] = e;
            this.numberOfStackElements ++;
        }
    }

    @Override
    public E pop() {
        if ( isEmpty() ) {
            throw new NullPointerException("Can't pop stack its Empty!!");
        } else {
            this.numberOfStackElements --;
            E e = this.aStack[this.top];
            this.top --;
            return e;
        }
    }

    @Override
    public E peek() {
        if ( isEmpty() )
            throw new NullPointerException("Can't peek at top item as the stack is Empty!!");
        else
            return this.aStack[this.top];
    }

    @Override
    public boolean isEmpty() {
        return ( this.getStackSize() == 0 );
    }

    @Override
    public boolean isFull() {
        return ( this.numberOfStackElements == aStack.length);
    }

    public void displayStack() {
        System.out.println( this.toString() );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder( "\n" );
        int tmp = this.getStackSize() - 1;
        if(isEmpty())
        {
            sb.append("The stack is Empty!!");
        }
        else
        {
            while (tmp > -1) {
                sb.append( this.aStack[ tmp ] + "\n");
                tmp --;
            }
        }
        return sb.toString();
    }

    public int getStackSize() {
        return this.numberOfStackElements;
    }

}