
package Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connect {
    JsonModel myDbJson;
    Statement smt = null;
    //myConn for sql statement function;
    Connect myConn=null;
    private Connection Connect(){
        //This function create Clinical table and check it is exist or not
        createJsonTable();
        
      
            // db parameters
            String url = "jdbc:sqlite:JSonDB.sqlite3";
            // create a connection to the database
            Connection conn = null;
             try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }          
        
            
        return conn;
    }
    
    public void insertJson(ArrayList<JsonModel> myDbJson){
        

 
        String sql;
        sql = "INSERT INTO Clinical(file,Age,Sex,AnatomSG,Diagnosis,DiagCT,"
                + "Melonocytic,UnDiagnosis,UnLocal,UnSite,ImageType) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = this.Connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            for (int i = 0; i < myDbJson.size(); i++) {
            //File name
           
            //Clinical object info
            pstmt.setString(1, myDbJson.get(i).getName());
            pstmt.setInt(2, myDbJson.get(i).getMeta().getClinical().getAge_approx());
            pstmt.setString(3, myDbJson.get(i).getMeta().getClinical().getSex());
            pstmt.setString(4, myDbJson.get(i).getMeta().getClinical().getAnatom_site_general());
            pstmt.setString(5, myDbJson.get(i).getMeta().getClinical().getDiagnosis());
            pstmt.setString(6, myDbJson.get(i).getMeta().getClinical().getDiagnosis_confirm_type());
            //isMelanocytic returns 1 or 0 for sql table
            pstmt.setBoolean(7, myDbJson.get(i).getMeta().getClinical().isMelanocytic());  
            //Unstructured class info
            pstmt.setString(8, myDbJson.get(i).getMeta().getUnstructured().getDiagnosis());
            pstmt.setString(9, myDbJson.get(i).getMeta().getUnstructured().getLocalization());
            pstmt.setString(10, myDbJson.get(i).getMeta().getUnstructured().getSite());
            //Image ınfo
            pstmt.setString(11, myDbJson.get(i).getMeta().getAcquisition().getImage_type());
            
            
            
            pstmt.executeUpdate();
        }
            
            pstmt.executeUpdate();
            } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }

    PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //This function create Clinical table and check it is exist or not
    public void createJsonTable(){
        
        String url = "jdbc:sqlite:JSonDB.sqlite3";
        
        String tableSQL = "CREATE TABLE `Clinical` (`file`TEXT NOT NULL UNIQUE," +
                        "`Age`	INTEGER,"+
                        "`Sex`	TEXT,"+
                        "`AnatomSG`	TEXT,"+
                        "`Diagnosis`	TEXT,"+
                        "`DiagCT`	TEXT,"+
                        "`Melonocytic`	TEXT,"+
                        "`UnDiagnosis`	TEXT,"+
                        "`UnLocal`	TEXT,"+
                        "`UnSite`	TEXT,"+
                        "`ImageType`	TEXT);";
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            //Check table already exist or not
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet table = meta.getTables(null, null, "Clinical", null);
            if(table.next()){
                System.out.println("DB Already Exist");
            }else{
                 // create a new table
                stmt.execute(tableSQL);
            }
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
        
}    
                
