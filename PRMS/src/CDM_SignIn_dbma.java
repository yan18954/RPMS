import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
//��ƺ޲z�h���O
//CDM_dbma: Class DatabaseManagement_database manipulation and acess (��Ʈw�ާ@�P�s�����O)
//���ұb���K�X
class CDM_SignIn_dbma{                    

    Connection connection;
    Statement statement;
    public CDM_SignIn_dbma(){

   }
    
    
    
    
    public boolean findRD_in_TB_staffPW(String aId,String aPw){            //�d��b���K�X
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String EMPL_Id= "";
        String EMPL_Pw ="";
        String findResult = "";
        
        //��Ʈw�e�m�@�~
        try{
              Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
        }

        try{
              connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
              statement = connection.createStatement();
        } catch(SQLException e){
              JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~0!");
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
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");      
                return false;
         }
		return false;
    }
 
}


