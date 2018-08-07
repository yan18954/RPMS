import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
//資料管理層類別
//CDM_dbma: Class DatabaseManagement_database manipulation and acess (資料庫操作與存取類別)
//驗證帳號密碼
class CDM_SignIn_dbma{                    

    Connection connection;
    Statement statement;
    public CDM_SignIn_dbma(){

   }
    
    
    
    
    public boolean findRD_in_TB_staffPW(String aId,String aPw){            //查找帳號密碼
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String EMPL_Id= "";
        String EMPL_Pw ="";
        String findResult = "";
        
        //資料庫前置作業
        try{
              Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
        }

        try{
              connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
              statement = connection.createStatement();
        } catch(SQLException e){
              JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤0!");
        }

        try{
            
        	   cmdData = "SELECT EMPL_password FROM staff WHERE EMPL_id = '"+aId+"' ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
               
               while( result.next() ){
            	  EMPL_Pw =	result.getString("EMPL_Password");
                }
                statement.close();
                
                if(aPw.equals(EMPL_Pw) && !EMPL_Pw.equals("")){
                	return true;
                }        
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");      
                return false;
         }
		return false;
    }
 
}


