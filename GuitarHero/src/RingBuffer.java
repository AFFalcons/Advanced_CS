/*************************************************************************
 * <h1>Buffer Class</h1>
 * This is a generic {@code RingBuffer} class
 * <p> 
 * The Buffer can rap around and overwrite data that has been used and is 
 * no longer being used, but if the Buffer is full it will throw an error
 * <p>
 * <h1>ToDo-</h1>
 * <pre>
 *     -Add Default Methods and Constructor 
 *     -Add Custom Exceptions
 * </pre>
 * @param <T> "T" is the type of {@code Object} that you want the Buffer to use
 * 
 * @author Matthew Horton
 * @version 1.0
 * @since September 9, 2019
 *************************************************************************/

public class RingBuffer<T> {

	//private class variables
	private int Size, First;
	private Object[] Buffer;
	
	/**
	 * Initializes the buffer with the capacity passed in by the user the 
	 * Capacity is locked to the value passed in.
	 * 
	 * @param capacity The length of buffer you want. This can't be changed later
	 * 
	 * @since Version 1.0
	 */
	public RingBuffer(int capacity) {
		Buffer = new Object[capacity];
		Size = 0;
		First = 0;
	}
	
	/**
	 * Adds {@code Item} to the Buffer if there is space and 
	 * casts the Object to "T"
	 * <p>
	 * 
	 * @throws IllegalStateException If the Buffer is full
	 * @param in The object that is being added to the Buffer
	 */
	public void enqueue(T Item) {
		if(Size == Buffer.length)
			throw new IllegalStateException();
		else {
			Buffer[(First + Size) % Buffer.length] = (T) Item;
			Size++;
		}
	}
	
	/**
	 * Returns the first Object in the Buffer The object is cast
	 * to what "T" was set to at the start. This also tells the
	 * Buffer that it can over write the data that was in 
	 * the first element.
	 * <p>
	 * 
	 * @throws IllegalStateException If the Buffer is empty
	 * @return First element in the Buffer
	 */
	@SuppressWarnings("unchecked")
	public T dequeue() {
		Object temp;
		if(Size == 0)
			throw new IllegalStateException();
		else {
			temp = Buffer[First];
			Size--;
			First = (First + 1) % Buffer.length;
		}
		return (T) temp;
	}
	
	/**
	 * Returns the first Object in the Buffer The object is cast
	 * to what "T" was set to at the start.
	 * <p>
	 * 
	 * @throws IllegalStateException If the Buffer is empty
	 * @return First element in the Buffer
	 */
	@SuppressWarnings("unchecked")
	public T peek() {
		if(Size > 0)
			return (T) Buffer[First];
		throw new IllegalStateException();
	}
	
	/**
	 * Only returns the number of values that can't be overwritten 
	 * @return Number of elements in the Buffer
	 */
	public int Size() {
		return Size;
	}
	
	/**
	 * Is the Buffer empty
	 * @return True if the Buffer is empty
	 */
	public boolean isEmpty() {
		if(Size == 0)
			return true;
		return false;
	}
	
	/**
	 * Is the Buffer full
	 * @return True if the Buffer is full
	 */
	public boolean isFull() {
		if(Size == Buffer.length)
			return true;
		return false;
	}
	
}
