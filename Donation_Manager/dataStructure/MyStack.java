/** 
 *  Stack data structure class.
 * 
 * @author Ryan Koepke
 * @param <T> data type
 */
package dataStructure;
import interfaces.StackInterface;

public class MyStack<T> implements StackInterface<T> {
	private T[] stack;
	private int topIndex;
	private static final int DEFAULT_CAPACITY = 100;
	
	/**
	 * Default constructor set to default capacity.
	 */
	public MyStack() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructor that initialized the stack capacity to a specified value.
	 * @param capacity Queue capacity size.
	 */
	public MyStack(int capacity) {
		@SuppressWarnings("unchecked")
		T[] arr = (T[])new Object[capacity];
		stack = arr;
		topIndex = -1;
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		if(topIndex == stack.length -1) {
			return true;
		}else {
			return false;
		}	
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T pop() {
		T top = stack[topIndex];
		stack[topIndex] = null;
		topIndex--;
		return top;
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return stack.length;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean push(T e) {
		if(!isFull()) {
			stack[topIndex + 1] = e;
			topIndex++;
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Returns the elements of the Stack in an array, [0] is top of Stack, [1] is next in Stack, etc.
	 * @return an array of the Objects in the Stack
	 */
	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[topIndex + 1];
		for(int index = 0; index < result.length; index ++) {
			result[index] = stack[index];
		}
	return result;
	}
}

