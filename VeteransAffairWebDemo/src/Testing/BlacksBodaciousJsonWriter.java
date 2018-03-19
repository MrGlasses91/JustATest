package Testing;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

class BlacksBodaciousJsonWriter{
	
	KeyValuePair tableResults; 
	Writer w; 
	
	public BlacksBodaciousJsonWriter(Writer w) {
		tableResults = new KeyValuePair(); 
		this.w = w;
	}

	public void addTable(String tableName, List<KeyValuePair> tableContents) {
		tableResults.addKeyValue(tableName, tableContents); 
	}
	
	public void writeJSON(boolean writeMeta) throws IOException {		
		if(writeMeta) {
			w.append("{\n\t\"meta\":[");
			for(String s : tableResults.getKeyList()) {
				w.append("{\n\t\ttable" + "\"" + s + "\"");
			}
			w.write("\n]}");		
		}else {
			w.append("{\n\t\"data\":[");
			w.write("\n]}");
		}
	}
}