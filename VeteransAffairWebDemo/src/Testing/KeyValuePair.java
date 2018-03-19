package Testing;

import java.util.LinkedList;
import java.util.List;

public class KeyValuePair{

	List<KeyValue> keyValues; 
	
	public KeyValuePair() {
		keyValues = new LinkedList<KeyValue>(); 
	}
	
	public KeyValuePair(String key, Object value) {
		
	}
		
	public void addKeyValue(String key, Object value) {
		for(KeyValue k : keyValues) {
			if(k.getKey().equals(key)) {
				k.setValue(value);
			}
		}
		KeyValue k = new KeyValue(key, value); 
		keyValues.add(k);
	}
		
	public List<String> getKeyList(){
		List<String> keys = new LinkedList<String>(); 
		for(KeyValue key : keyValues) {
			keys.add(key.getKey());
		}
		return keys; 
	}
	
	public Object getValue(String key) {
		for(KeyValue k : keyValues) {
			if(key.equals(k.getKey())) {
				return k.getValue();
			}
		}
		return null; 
	}
	
	protected class KeyValue{
		String key; 
		Object value;
		
		public KeyValue(String key, Object value) {
			this.key = key;
			this.value = value; 
		}
				
		public void setValue(Object value) {
			this.value = value;
		}
		
		public Object getValue() {
			return value;
		}
		
		public String getKey() {
			return key;
		}
	}
}