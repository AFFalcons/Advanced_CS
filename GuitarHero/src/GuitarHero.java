public class GuitarHero {

	static String keyboard;
	static GuitarString[] strings;
	
	public static void main(String[] args) {
		keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
		strings = new GuitarString[37];
		for(int i = 0; i < strings.length; i++) {
			strings[i] = new GuitarString(440 * Math.pow(1.05956, i - 24));
		}
		
		while(true) {
			if (StdDraw.hasNextKeyTyped()) {
				 
                // the user types this character
                char key = StdDraw.nextKeyTyped();

                // pluck the corresponding string
                int string = keyboard.indexOf(key);
                
                if(string >= 0)
                	strings[string].pluck();
            }
			double sample = 0;
            
			for(int i = 0; i < strings.length; i++) {
				sample += strings[i].sample();
			}
			
			StdAudio.play(sample);
            
			for(int i = 0; i < strings.length; i++) {
				strings[i].tic();
			}
		}
	}
}
