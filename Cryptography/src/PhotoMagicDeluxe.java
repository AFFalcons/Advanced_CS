
public class PhotoMagicDeluxe {

	public static void main(String[] args) {
		String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		String bits = "";
		String password = "OPENSESAME";
		for(int i = 0; i < password.length(); i++) {
			String temp = Integer.toBinaryString(base64.indexOf(password.charAt(i)));
			if(!(temp.length() == 6)) {
				int x = temp.length();
				String add = "";
				for(int j = 0; j < 6 - x; j++) {
					add += "0";
				}
				add += temp;
				bits += add;
			} else {
				bits += temp;
			}	
		}
		Picture pic = new Picture("mystery.png");
		LFSR lfsr = new LFSR(bits, 58);
		
		Picture test = PhotoMagic.transform(pic, lfsr);
		test.show();
	}

}
