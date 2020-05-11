/*************************************************************************
 * <h1>Buffer Class</h1>
 * This is a generic {@code RingBuffer} class.
 * <p> 
 * The Buffer can rap around and overwrite data that has been used and is 
 * no longer being used, but if the Buffer is full it will throw an error.
 * <p>
 * @param <T> "T" is the type of {@code Object} that you want the Buffer to use
 * 
 * @author Matthew Horton
 * @version 1.1
 * @since September 14, 2019
 *************************************************************************/

public class RingBuffer<T>{

	//Private Class Variables
	private int Size, First;
	private String vals;
	private Object[] Buffer;
	
	//Private Default Variables
	private final int DEFAULT_SIZE = 100;
	
	/**
	 * Initializes the buffer with the capacity passed in by the user the 
	 * Capacity is locked to the value passed in.
	 * <p>
	 * 
	 * @param capacity The length of buffer you want. This can't be changed later
	 * 
	 * @since Version 1.0
	 */
	public RingBuffer(int capacity) {
		Buffer = new Object[capacity];
		init();
	}
	
	/**
	 * Initializes the buffer with the default size. This will crate a Buffer that can
	 * hold 100 objects. 
	 * <p>
	 * 
	 * @since Version 1.1
	 */
	public RingBuffer() {
		Buffer = new Object[DEFAULT_SIZE];
		init();
	}
	
	/**
	 * Private method used to set local 
	 * <p> 
	 * 
	 * @since Version 1.1
	 */
	private void init() { 
		Size = 0;
		First = 0;
		vals = "";
	}
	
	/**
	 * Adds {@code Item} to the Buffer if there is space and 
	 * casts the Object to "T"
	 * <p>
	 * 
	 * @throws BufferException If the Buffer is full.
	 * @param Item The object that is being added to the Buffer.
	 * @return Returns the item that was passed in. Used for debug reasons.
	 * 
	 * @since Version 1.0 
	 * @since Updated 1.1
	 */
	public T enqueue(T Item) {
		if(isFull())
			throw new IllegalStateException();
		else {
			Buffer[(First + Size) % Buffer.length] = (T) Item;
			Size++;
			return Item;
		}
	}

	
	/**
	 * Returns the first Object in the Buffer The object is cast
	 * to what "T" was set to at the start. This also tells the
	 * Buffer that it can over write the data that was in 
	 * the first element.
	 * <p>
	 * 
	 * @throws BufferException If the Buffer is empty
	 * @return First element in the Buffer
	 * 
	 * @since Version 1.0
	 * @since Updated 1.1
	 */
	@SuppressWarnings("unchecked")
	public T dequeue(){
		Object temp;
		if(isEmpty())
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
	 * @throws BufferException If the Buffer is empty
	 * @return First element in the Buffer
	 * 
	 * @since Version 1.0
	 * @since Updated 1.1
	 */
	@SuppressWarnings("unchecked")
	public T peek() {
		if(isEmpty())
			throw new IllegalStateException();
		return (T) Buffer[First];
	}
	
	/**
	 * This method will fill the entire array with new Objects
	 * clearing all data that is currently stored in the array. 
	 * <p>
	 * 
	 * @since Version 1.1
	 */
	public void reset() {
		for(int i = 0; i < Buffer.length; i++)
			Buffer[i] = new Object();
		init();
	}
	
	/**
	 * Only returns the number of values that can't be overwritten 
	 * <p>
	 * 
	 * @return Number of elements in the Buffer
	 * 
	 * @since Version 1.0
	 */
	public int Size() {
		return Size;
	}
	
	/**
	 * Is the Buffer empty
	 * <p>
	 * 
	 * @return True if the Buffer is empty
	 * 
	 * @since Version 1.0
	 */
	public boolean isEmpty() {
		return Size == 0;
	}
	
	
	/**
	 * Is the Buffer full
	 * <p>
	 * 
	 * @return True if the Buffer is full
	 * 
	 * @since Version 1.0
	 */
	public boolean isFull() {
		return Size == Buffer.length;
	}
	
	/**
	 * Used for debug reasons.
	 * <p>
	 * @return Returns string with only the active Objects 
	 * in the Buffer in the string
	 * 
	 * @since Version 1.1
	 */
	public String ToString() {
		vals = "";
		
		for(int i = First; i < First + Size; i++) {
			vals += ", " + Buffer[i % Buffer.length];
		}
		
		return vals;
	}
	/**
	 * Used for debug reasons.
	 * <p>
	 * @return Returns string with every element in the Buffer 
	 * in the string
	 * 
	 * @since Version 1.1
	 */
	public String BufferToString() {
		vals = "";
		
		for(int i = 0; i < Buffer.length; i++) {
			vals += ", " + Buffer[i];
		}
		
		return vals;
	}
}
