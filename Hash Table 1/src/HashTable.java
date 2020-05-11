public class HashTable {
	
	int size;
	Entry[] Table;
	
	public HashTable(){
		size = 101;
		Table = new Entry[size];
	}
	
	public HashTable(int initCap) {
		size = initCap;
		Table = new Entry[size];
	}
	
	public Object put(Object Key, Object Value) {
		int hc = Key.hashCode();
		int index = hc % size;
		Entry Put = new Entry(Key, Value);
		if(Table[index] == null) {
			Table[index] = Put;
			return null;
		}
		Object Temp = Table[index].Value;
		Table[index] = Put;
		return Temp;
	}
	
	public Object get(Object Key) {
		int hc = Key.hashCode();
		int index = hc % size;
		return Table[index].Value;
	}
	
	public String toString() {
		String Hold = "";
		for(int i = 0; i < size; i++) {
			if(!(Table[i] == null)) {
				Hold += Table[i].toString();
			}
		}
		return Hold;
	}
	
	private class Entry{
		Object Value;
		Object Key;
		
		public Entry() {
			Value = null;
			Key = null;
		}
		
		public Entry(Object Key, Object Value) {
			this.Key = Key;
			this.Value = Value;
		}
		
		public String toString() {
			return Key + "-" + Value + ", ";
		}
	}
}
