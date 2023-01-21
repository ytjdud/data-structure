package linear.stack;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
    static int DefaultSize = 6;

    int maxSize;
    int top; // index for top
    E [] data;

    public ArrayStack() {
        this(DefaultSize);
    }

    public ArrayStack(int size) {
        top = -1;
        data = (E[]) new Object[size];

    }
    public void clear() { top = -1; maxSize =0; }

    public void push(E item) {
        data[++top] = item;
    }

    public E pop() {
        E ret = data[top];
        data[top--] = null;
        return ret;
    }

    public E topValue() {
        return data[top];
    }
    public int length() {
        maxSize = top +1;
        return maxSize;
    }
	/*
	public static void main(String[] args) {

	    ArrayStack<Integer> myAStack = new ArrayStack<>();
		System.out.println("<Test2: Array Stack>");

		myAStack.push(12); myAStack.push(23); myAStack.push(34);
		myAStack.push(22); myAStack.pop();
		System.out.println(" myAStack: "+ Arrays.toString(myAStack.data));

		System.out.println(" topValue: "+ myAStack.topValue());
		System.out.println(" length: "+ myAStack.length());
	}
	*/


}
