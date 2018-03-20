package Testing;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.driver.OracleDriver;

//Some comment to change the file
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static String username = "Black"; 
	static String password = "Black"; 
	static String dataBase = "Local"; 
	
    public Test() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doTestJson(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doTestJson(request, response); 
	}
	
	private void doTestJson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParamMap params = new ParamMap(request); 
		if(params.containsKey("JSONTEST")) {
			String JSONCase = params.getFirstValue("JSONTEST");
			if(JSONCase.equals("def")) {
				writePage(response, "{\r\n" + 
								"	\"North America\": \"_nam\",\r\n" + 
								"	\"Europe\": \"_eur\",\r\n" + 
								"	\"Asia\": \"_asi\",\r\n" + 
								"	\"Africa\": \"_afr\",\r\n" + 
								"	\"Antarctica\": \"_ant\"	\r\n" + 
								"}");
			} else if(JSONCase.equals("_jpn")) {
					writePage(response, "{\r\n" + 
							"	\"Hiroshima\": \"_jp1\",\r\n" + 
							"	\"Kyoto\": \"_jp2\"\r\n" + 
							"}");
			} else if(JSONCase.equals("_can")) {
					writePage(response, "{\r\n" + 
							"	\"Ontario\": \"_ca1\",\r\n" + 
							"	\"Alberta\": \"_ca2\",\r\n" + 
							"	\"British Columbia\": \"_ca3\"\r\n" + 
							"}");
			} else if(JSONCase.equals("_rus")) {
					writePage(response, "{\r\n" + 
							"	\"United States of Siberia\": \"_ru1\",\r\n" + 
							"	\"Nenestsia\": \"_ru2\",\r\n" + 
							"	\"Muscovia\": \"_ru3\"\r\n" + 
							"}");
			} else if(JSONCase.equals("_chi")) {
					writePage(response, "{\r\n" + 
							"	\"Tibet\": \"_ch1\",\r\n" + 
							"	\"Xinjiang\": \"_ch2\",\r\n" + 
							"	\"Gansu\": \"_ch3\"\r\n" + 
							"}");
			} else if(JSONCase.equals("_uk")) {
				writePage(response, "{\r\n" + 
						"	\"East Anglia\": \"_uk1\",\r\n" + 
						"	\"Wessex\": \"_uk2\",\r\n" + 
						"	\"Essex\": \"_uk3\"\r\n" + 
						"}");
			} else if(JSONCase.equals("_ind")) {
				writePage(response, "{\r\n" + 
						"	\"Orissa\": \"_in1\",\r\n" + 
						"	\"Gujarat\": \"_in2\",\r\n" + 
						"	\"Bihar\": \"_in3\"\r\n" + 
						"}");
			} else if(JSONCase.equals("_chd")) {
				writePage(response, "{\r\n" + 
						"	\"Tibesti\": \"_ch1\",\r\n" + 
						"	\"Sila\": \"_ch2\",\r\n" + 
						"	\"Batha\": \"_ch3\"\r\n" + 
						"}");
			} else if(JSONCase.equals("_ngr")) {
				writePage(response, "{\r\n" + 
						"	\"Northwestern State\": \"_ni1\",\r\n" + 
						"	\"Kano\": \"_ni2\",\r\n" + 
						"	\"Kwara\": \"_ni3\"\r\n" + 
						"}");
			} else if(JSONCase.equals("_saf")) {
				writePage(response, "{\r\n" + 
						"	\"Northern Cape\": \"_sa1\"\r\n" + 
						"}");
			} else if(JSONCase.equals("_nam")) {
				writePage(response, "{\r\n" + 
						"	\"The United States\": \"_usa\",\r\n" + 
						"	\"Canada\": \"_cnd\"\r\n" + 
						"}");
			}  else if(JSONCase.equals("_asi")) {
				writePage(response, "{\r\n" + 
						"	\"Japan\": \"_jpn\",\r\n" + 
						"	\"China\": \"_chi\",\r\n" + 
						"	\"India\": \"_ind\"\r\n" + 
						"}");
			}  else if(JSONCase.equals("_eur")) {
				writePage(response, "{\r\n" + 
						"	\"Russian Federation\": \"_rus\",\r\n" + 
						"	\"Germany\": \"_ger\",\r\n" + 
						"	\"The United Kingdom\": \"_tuk\",\r\n" + 
						"	\"France\": \"_frn\"\r\n" + 
						"}");
			}  else if(JSONCase.equals("_afr")) {
				writePage(response, "{\r\n" + 
						"	\"Chad\": \"_chd\",\r\n" + 
						"	\"Somolia\": \"_som\",\r\n" + 
						"	\"Madagascar\": \"_mad\",\r\n" + 
						"	\"South Africa\": \"_saf\",\r\n" + 
						"	\"Nigeria\": \"_ngr\"	\r\n" + 
						"}");
			}
		}
	}
	
	private void writePage(HttpServletResponse response, String content) {
		Writer w;
		try {
			w = response.getWriter();
			w.append(content); 
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void doPage(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		Writer w = response.getWriter();
		//w.append("Hello to you"); 
		try {
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Black", "Black");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Black", "Black");
			Statement stat = null; 
			String SQLStatement = "SELECT * FROM user_baisc"; 
			stat = conn.createStatement(); 
			ResultSet rs = stat.executeQuery(SQLStatement);
			ResultSetMetaData meta = rs.getMetaData(); 
			
			KeyValuePair tableColumns = new KeyValuePair();
			
			for(int x = 1; x <= meta.getColumnCount(); x++) {
				tableColumns.addKeyValue(meta.getColumnName(x), meta.getColumnTypeName(x));
			}
			
			while(rs.next()) {
				for(String s : tableColumns.getKeyList()) {
					Object o = rs.getObject(s);
				}
			}
			BlacksBodaciousJsonWriter jsonWriter = new BlacksBodaciousJsonWriter(w);
			jsonWriter.writeJSON(true);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w.flush();
		w.close(); 
	}

}
