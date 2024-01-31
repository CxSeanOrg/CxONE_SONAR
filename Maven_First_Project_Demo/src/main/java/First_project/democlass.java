// package First_project;

// public class democlass {
	
// 	public String demo() {
		
// 		return "hello";
// 	}

// }
package First_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class democlass {

    public String demo(String userProvidedInput) {
        String response = "";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "user", "password");
            Statement stmt = con.createStatement();
            // Vulnerable to SQL Injection
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE name = '" + userProvidedInput + "'");

            while (rs.next()) {
                response += rs.getString(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}

