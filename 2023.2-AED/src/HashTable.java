
public class HashTable {

	private HashTableEntry[] table;
	private int size;
	
	public HashTable() {
		this.table = new HashTableEntry[10];
		this.size = 0;
	}
	
	public void add(String key, String value) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % this.table.length;
		System.out.println("KEY: " + key + " INDEX: " + index);
		
		HashTableEntry currentEntry = this.table[index];
		while(currentEntry != null) {
			index++;
			if (index >= this.table.length) {
				index = 0;
			}
			currentEntry = this.table[index];
		}
		this.table[index] = new HashTableEntry(key, value);
		this.size++;
	}
	
	public String get(String key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % this.table.length;
		
		HashTableEntry currentEntry = this.table[index];
		while(currentEntry != null) {
			if (currentEntry.key.equals(key)) {
				return currentEntry.value;
			}
			
			index++;
					
			if (index >= this.table.length) {
				index = 0;
			}
			
			currentEntry = this.table[index];
		}
		
		throw new RuntimeException("Elemento não está presente.");
	}
	
	private class HashTableEntry{
		String key;
		String value;
		
		public HashTableEntry(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	
	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		hashTable.add("10", "0");
		hashTable.add("kamila", "adriel");
		hashTable.add("carro", "cavalo");
		hashTable.add("algoritmos e estruturas de dados", "AMO!!!!!");
		hashTable.add("javascript", "666");
		hashTable.add("python", ";");
		hashTable.add("C++", ";");
		hashTable.add("boi", "voador");
		hashTable.add("IFPE", "morcego");
		
		
		System.out.println(hashTable.get("kamila"));
		System.out.println(hashTable.get("10"));
		System.out.println(hashTable.get("bruno"));
	}
	
}
