import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCore {

	String IN;
	public Node Start;
	private HashMap<Character, Integer> Freq;
	private HashMap<Character, String> CodesString;
	private HashMap<Character, Integer> CodesBit;
	private HashMap<Integer, Character> CodesChar;
	private String text;

	public HuffmanCore(String S, String file) throws Exception {
		IN = S;
		Freq = getFreq(S);
		Start = findStart();
		CodesString = new HashMap<Character, String>();
		CodesChar = new HashMap<Integer, Character>();
		CodesBit = new HashMap<Character, Integer>();
		CodesLoop(Start, "", 0);
		toFile("Hold/" + file + ".mhout");
		decode("Hold/" + file + ".mhout");
		writeFinalToFile("OutPut/" + file + ".txt");
	}

	private HashMap<Character, Integer> getFreq(String FreqS) {
		HashMap<Character, Integer> Table = new HashMap<Character, Integer>();
		
		for (int i = 0; i < FreqS.length(); i++) {
			char C = FreqS.charAt(i);
			if(!Table.containsKey(C))
				Table.put(C, 1);
			else
				Table.put(C, Table.get(C) + 1);
		}
		
		return Table;
	}
	
	private Node findStart() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(Character key : Freq.keySet()) {
			int value = Freq.get(key);
			
			pq.add(new Node(key, value, null, null));
		}
		pq.add(new Node('\0', 1, null, null, true));
		
		while(pq.size() > 1) {
			Node Left = pq.poll();
			Node Right = pq.poll();
			
			int sum = Left.freq + Right.freq;
			
			pq.add(new Node('\0', sum, Left, Right));
		}
		
		return pq.poll();
	}
	
	private void CodesLoop(Node Start, String str, int bit) {
		if(Start == null)
			return;
		
		if(Start.Left == null && Start.Right == null) {
			CodesString.put(Start.data, str);
			CodesBit.put(Start.data, bit);
			CodesChar.put(bit, Start.data);
		}
		
		int LeftBit = bit << 1;
		int RightBit = (bit << 1) | 1;
		
		CodesLoop(Start.Left, str + "0", LeftBit);
		CodesLoop(Start.Right, str + "1", RightBit);
		
	}
	
	public void toFile(String FileN) {
		BitOutputStream WriteFile = new BitOutputStream(FileN);
		
		for(int i = 0; i < IN.length(); i++) {	
			char c = IN.charAt(i);
			WriteFile.writeBits(CodesString.get(c).length(), CodesBit.get(c));
		}
		
		WriteFile.writeBits(CodesString.get('\0').length(), CodesBit.get('\0'));
		WriteFile.flush();
		WriteFile.close();
	}
	
	public void decode(String fileName) throws Exception {
		BitInputStream fin = new BitInputStream(fileName);
		
		StringBuilder decodedString = new StringBuilder();
		
		while (decode(Start, fin, decodedString)) {
			int i = 0;
		}
		
		//System.out.println();
		//System.out.println(decodedString.toString());
		text = decodedString.toString();
	}
	
	private boolean decode(Node root, BitInputStream fin, StringBuilder str) throws IOException {
		
		if(root.Left == null && root.Right == null) {
			if(root.data == '\0') {
				return false;
			}
			else {
				str.append(root.data);
				return true;
			}
		}
		
		int bit = fin.readBits(1);
		
		if(bit == 0) {
			//System.out.print("0");
			return decode(root.Left, fin, str);
		}
		else {
			//System.out.print("1");
			return decode(root.Right, fin, str);
		}
		
	}
	
	public void writeFinalToFile(String fileName) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		
		writer.write(text);
		writer.flush();
		writer.close();
	}
	
	private class Node implements Comparable {
		char data;
		
		int freq;
		Node Right, Left;
		
		boolean EOF;
		
		Node(char data, int freq, Node Left, Node Right) {
			this(data, freq, Left, Right, false);
		}
		Node(char data, int freq, Node Left, Node Right, boolean EOF) {
			this.data = data;
			this.freq = freq;
			this.Left = Left;
			this.Right= Right;
			this.EOF = EOF;
		}
		
		public int compareTo(Object o) {
			return freq - ((Node) o).freq;
		}
	}	
}
