/** Class that implements the Queue data structure
 * 
 * @author Ryan Koepke
 * @param <T> data type
 */
package dataStructure;
import interfaces.*;
public class MyQueue<T> implements QueueInterface<T> {
	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private int arraySize;
	private static final int DEFAULT_CAPACITY = 50;
	
	/**
	 * Default constructor set to the default capacity.
	 */
	public MyQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructor that initialized the queue capacity to a specified value.
	 * @param capacity Queue capacity size.
	 */
	public MyQueue(int capacity) {
		@SuppressWarnings("unchecked")
		T[] queueStack = (T[]) new Object[capacity + 1];
		queue = queueStack;
		frontIndex = 0;
		backIndex = capacity;
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return frontIndex == ((backIndex +1) % queue.length);
	}

	/**
	 * Determines of the Queue is Full.
	 * @return true if Queue is full, false if not.
	 */
	@Override
	public boolean isFull() {
		return frontIndex == ((backIndex +2) % queue.length);
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	@Override
	public T dequeue() {
		T front = queue[frontIndex];
		queue[frontIndex] = null;
		frontIndex = (frontIndex+1) % queue.length;
		return front;

	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		int count = 0;
		for(int i = 0; i < queue.length; i++)
			if(queue[i] != null) {
				count ++;
			}
		return count;
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean enqueue(T e) {
		if(!isFull()) {
			backIndex = (backIndex +1) % queue.length;
			queue[backIndex] = e;
			return true;
		}else {
			return false;
		}
	} 
	
	/**
	 * Returns the elements of the Queue in an array, [0] is front of Queue, [1] is next in Queue, etc.
	 * @return an array of the Object elements in the Queue
	 */
	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[queue.length];
		for(int i = 0; i < queue.length; i ++) {
			result[i] = queue[(i + frontIndex) % queue.length];
		}	
		return result;
	}
	
	public int getArraySize() {
		return arraySize;
	}
}
