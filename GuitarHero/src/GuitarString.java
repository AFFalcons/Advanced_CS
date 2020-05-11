import java.util.Random;

public class GuitarString {

	@SuppressWarnings("rawtypes")
	RingBuffer buffer;
	int time;
	
	@SuppressWarnings("unchecked")
	public GuitarString(double frequency) {
		buffer = new RingBuffer<Double>((int) (44100/frequency));
		for(int i = 0; i < (int) (44100/frequency); i++) {
			buffer.enqueue(0.0);
		}
	}
	
	@SuppressWarnings("unchecked")
	public GuitarString(double[] init) {
		buffer = new RingBuffer<Double>((init.length));
		for(int i = 0; i < init.length; i++) {
			buffer.enqueue(init[i]);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void pluck() {
		Random rand = new Random();
		for(int i = 0; i < buffer.Size(); i++) {
			buffer.dequeue();
			buffer.enqueue(rand.nextDouble() - .5);
		}
	}
	@SuppressWarnings("unchecked")
	public void tic() {
		double a1 = (double) buffer.dequeue();
		double a2 = (double) buffer.peek();
		buffer.enqueue(.994 * (.5 * (a1 + a2)));
		time++;
	}
	public double sample() {
		return (double) buffer.peek();
	}
	
	/**
	 * 
	 * @return number of tics
	 */
	public int time() {
		return time;
	}
}
