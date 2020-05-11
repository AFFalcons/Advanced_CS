import java.util.LinkedList;

public class HashTable {
	
	int TableLength; 
	int PCollisions, GCollisions;
	LinkedList<Entry> [] Table;
	
	@SuppressWarnings("unchecked")
	public HashTable(){
		TableLength  = 101;
		Table = new LinkedList[TableLength];
	}
	
	@SuppressWarnings("unchecked")
	public HashTable(int initCap) {
		TableLength  = initCap;
		Table = new LinkedList[TableLength];
	}
	
	public Object put(Object Key, Object Value) {
		Object Hold = null;
		int hc = Key.hashCode();
		int index = hc % TableLength;
		boolean flag = false;
		Entry Put = new Entry(Key, Value);
		if(Table[index % TableLength] == null) {
			Table[index % TableLength] = new LinkedList<Entry>();
			Table[index % TableLength].add(Put);
		}else {
			PCollisions++;
			for (Entry Temp : Table[index % TableLength]) {
				if(Temp.Key == Key) {
					Temp = Put;
					flag = true;
					break;
				}
			}
			if(!flag) {
				Table[index % TableLength].add(Put);
			}
		}
		return Hold;
	}
	
	public Object get(Object Key) {
		Object Hold = null;
		int hc = Key.hashCode();
		int index = hc % TableLength;
		if(!(Table[index % TableLength] == null)) {
			for (Entry Temp : Table[index % TableLength]) {
				if(Temp.Key == Key) {
					Hold = Temp.Value;
				}
				GCollisions++;
			}
		}
		return Hold;
	}
	
	public Object remove(Object Key) {
		Object Hold = null;
		int hc = Key.hashCode();
		int index = hc % TableLength;
		if(!(Table[index % TableLength] == null)) {
			for (Entry Temp : Table[index % TableLength]) {
				if(Temp.Key == Key) {
					Hold = Temp.Value;
					Table[index % TableLength].remove(Temp);
					break;
				}
			}
		}
		return Hold;
	}
	
	public int getMaxLength() {
		int x = 1;
		for (LinkedList<Entry> linkedList : Table) {
			if(linkedList != null) {
				if (linkedList.size() > x) {
					x = linkedList.size();
				}	
			}
		}
		return x;
	}
	
	public int getAverageLength() {
		int x = 0;
		int total = 0;
		for (LinkedList<Entry> linkedList : Table) {
			if(linkedList != null) {
				total += linkedList.size();
				x++;
			}
		}
		return total / x;
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
			return Key + "-" + Value + " ";
		}
	}
}
