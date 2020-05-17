import java.awt.Color;

public class PhotoMagic {

	public static Picture transform(Picture pic, LFSR lfsr) {
		for (int i = 0; i < pic.width(); i++) {
			for (int x = 0; x < pic.height(); x++) {
				Color color = pic.get(i, x);
				
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				
				int newRed = red ^ lfsr.generate(8);
				int newGreen = green ^ lfsr.generate(8);
				int newBlue = blue ^ lfsr.generate(8);
				
				Color newColor = new Color(newRed, newGreen, newBlue);
				
				pic.set(i, x, newColor);
			}
		}
		return pic;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Picture pic = new Picture("pipe.png");
		pic.show();
		Thread.sleep(2000);
		LFSR lfsr = new LFSR("01101000010100010000", 16);
		Picture encryption = transform(pic, lfsr);
		encryption.show();
		Thread.sleep(2000);
		lfsr = new LFSR("01101000010100010000", 16);
		Picture decryption = transform(encryption, lfsr);
		decryption.show();
	}

}
