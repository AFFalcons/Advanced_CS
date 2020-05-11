import java.util.Random;

public class HashTable {
	
	int MaxLength, Size; 
	int PCollisions, GCollisions;
	Entry[] Table;
	
	public HashTable(){
		MaxLength  = 101;
		Size = 0;
		Table = new Entry[MaxLength];
	}
	
	public HashTable(int initCap) {
		MaxLength  = initCap;
		Size = 0;
		Table = new Entry[MaxLength];
	}
	
	public Object put(Object Key, Object Value) {
		Object Hold = null;
		if(Size < MaxLength) {
			int hc = Key.hashCode();
			int index = hc % MaxLength;
			Entry Put = new Entry(Key, Value);
			Random rand = new Random(index);
			while(true) {
				if(Table[index % MaxLength] == null) {
					Table[index % MaxLength] = Put;
					Size++;
					break;
				}else {
					PCollisions++;
					if(Table[index % MaxLength].isValid) {
						if(Table[index % MaxLength].Key.equals(Key)) {
							Hold = Table[index % MaxLength].Value;
							Table[index % MaxLength] = Put;
							break;
						}else {
							index = rand.nextInt(MaxLength);
						}
					}else {
						Table[index % MaxLength] = Put;
						index = rand.nextInt(MaxLength);
						while (Table[index % MaxLength] != null) {
							if(Table[index % MaxLength].isValid) {
								if(Table[index % MaxLength].Key.equals(Key)) {
									Table[index % MaxLength].isValid = false;
									Hold = Table[index % MaxLength].Value;
									break;
								}
							}
							index = rand.nextInt(MaxLength);
						}
						Size++;
						break;
					}
				}
			}
		}
		return Hold;
	}
	
	public Object get(Object Key) {
		Object Hold = null;
		if(Size > 0) {
			int hc = Key.hashCode();
			int index = hc % MaxLength;
			Random rand = new Random(index);
			do {
				if(Table[index % MaxLength] == null)
					break;
				if(Table[index % MaxLength].Key.equals(Key) && Table[index % MaxLength].isValid) {
					Hold = Table[index % MaxLength];
					break;
				}
				index = rand.nextInt(MaxLength);
				if(index < 0)
					index = 0;
				GCollisions++;
			} while (true);
		}
		return Hold;
	}
	
	public Object remove(Object Key) {
		Object Hold = null;
		if(Size > 0) {
			int hc = Key.hashCode();
			int index = hc % MaxLength;
			Random rand = new Random(index);
			do {
				if(Table[index % MaxLength] == null)
					break;
				if(Table[index % MaxLength].Key.equals(Key) && Table[index % MaxLength].isValid) {
					Hold = Table[index % MaxLength];
					Table[index % MaxLength].isValid = false;
					Size--;
					break;
				}
				index = rand.nextInt(MaxLength);
			} while (true);
		}
		return Hold;
	}
	
	public String toString() {
		String Hold = "";
		for(int i = 0; i < MaxLength; i++) {
			if(!(Table[i] == null)) {
				if(Table[i].isValid)
					Hold += i + ": " + Table[i].toString();
				else
					Hold += i + ": Dummy ";
			}
		}
		return Hold;
	}
	
	private class Entry{
		Object Value;
		Object Key;
		boolean isValid;
		
		public Entry() {
			Value = null;
			Key = null;
			isValid = true;
		}
		
		public Entry(Object Key, Object Value) {
			this.Key = Key;
			this.Value = Value;
			isValid = true;
		}
		
		public String toString() {
			return Key + "-" + Value + " ";
		}
	}
}
