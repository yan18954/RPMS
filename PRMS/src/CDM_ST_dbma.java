import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;



//��ƺ޲z�h���O
//CDM_dbma: Class DatabaseManagement_database manipulation and acess (��Ʈw�ާ@�P�s�����O)
class CDM_ST_dbma{                 //���u��Ʈw�s�����O                
    Connection connection;
    Statement statement;
    //�غc�l:���OCdbma
    public CDM_ST_dbma(){

         // createDB();                //�إ߸�Ʈwprmsdb, ������е��ѱ����@��,�H�K���ƫإ߷|�X��
    //  	createTB_staff();     	     //�إ߸�ƪ�staff, ������е��ѱ����@��,�H�K���ƫإ߷|�X��    
    //  createTB_PTC();              //�إ߸�ƪ� PTC ���d��ƪ�	
    //	createTB_RES();            //�إ߹w����ƪ�
    }
  
    public void insertRD_into_TB_staff(String[] cmData){      //�bstaff��ƪ��J���

        Connection connection;
        Statement statement;
        String cmdData;

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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        
        try{  
               cmdData = "INSERT INTO staff(EMPL_id,EMPL_name,EMPL_gender,EMPL_birth,EMPL_duty,EMPL_number,EMPL_telephone,EMPL_address,EMPL_level,EMPL_state,EMPL_ps,EMPL_password)"+
                                       "VALUES('"+cmData[0]+"','"+cmData[1]+"','"+cmData[2]+"','"+
                                       			  cmData[3]+"','"+cmData[4]+"','"+cmData[5]+"','"+
                                       			  cmData[6]+"','"+cmData[7]+"','"+cmData[8]+"','"+
                                       			  cmData[9]+"','"+cmData[10]+"','"+cmData[11]+"')";

               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               statement.executeUpdate(cmdData);
               JOptionPane.showMessageDialog(null,"���u�s�W���\!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"�bprms��Ʈw��, �g�J�@��[���u���]��staff��ƪ��o�Ϳ��~!");
        }
} 
    
    
    
    public void insertRD_into_TB_res(String[] cmData){      //�bstaff��ƪ��J���

        Connection connection;
        Statement statement;
        String cmdData;

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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        //�bposdb��Ʈw��, �s�W�@���U�ȸ�ƨ��ƪ�: customer   
        try{  
               cmdData = "INSERT INTO res(RES_no,RES_name,RES_date,RES_time,RES_telephone,RES_Mnumber,RES_Pnumber,RES_state,RES_ps)"+
                                       "VALUES('"+cmData[0]+"','"+cmData[1]+"','"+cmData[2]+"','"+
                                       			  cmData[3]+"','"+cmData[4]+"','"+cmData[5]+"','"+
                                       			  cmData[6]+"','"+cmData[7]+"','"+cmData[8]+"')";

               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               statement.executeUpdate(cmdData);
               JOptionPane.showMessageDialog(null,"�bprms��Ʈw��, ���\�g�J�@��[�w�����]��res��ƪ�!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"�bprms��Ʈw��, �g�J�@��[�w�����]��res��ƪ��o�Ϳ��~!");
        }
} 
  
    public void insertRD_into_TB_ptc(String[] cmData){      //�bstaff��ƪ��J���

        Connection connection;
        Statement statement;
        String cmdData;

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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        //�bposdb��Ʈw��, �s�W�@���U�ȸ�ƨ��ƪ�: customer   
        try{  
               cmdData = "INSERT INTO ptc(PTC_CKin_date,PTC_CKin_time,PTC_CKout_date,PTC_CKout_time,PTC_Sid)"+
            		     "VALUES('"+cmData[0]+"','"+cmData[1]+"','"+cmData[2]+"','"+
            			            cmData[3]+"','"+cmData[4]+"')";


               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               statement.executeUpdate(cmdData);
               JOptionPane.showMessageDialog(null,"�bprms��Ʈw��, ���\�g�J�@��[���d���]��ptc��ƪ�!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"�bprms��Ʈw��, �g�J�@��[���d���]��ptc��ƪ��o�Ϳ��~!");
        }
} 
    
    public void updateRD_in_TB_ptc(String date, String time,String id){
    	Connection connection;
        Statement statement;
        String cmdData;
        

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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        try{  
              cmdData = "UPDATE ptc SET PTC_CKout_date='"+date+"',PTC_CKout_time='"+time+"' WHERE PTC_Sid='"+id+"'";
              connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
              statement = connection.createStatement();
              statement.executeUpdate(cmdData);
              JOptionPane.showMessageDialog(null,"�w����[���d]���ȧ�s!");
              statement.close();
        } catch(SQLException e){
           JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }           
    }
    
    public String findMaxId_in_TB_staff(String rq_char){//�d�߭��u�s���̤j�ȫ�^��

    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
       // String name="",address="",telephone="",grade="",state="";
        String id="";
        String defaultID ="0000";

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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        try{
               cmdData = "SELECT MAX(SUBSTR(EMPL_id,4)) FROM staff WHERE EMPL_id LIKE '"+rq_char+"%'";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
               
              // id = result.getString("EMPL_id");
               
               while( result.next() ){
            	   	 id = result.getString("MAX(SUBSTR(EMPL_id,4))");
                }
               if(id==null){
            	   return defaultID;
               }
                statement.close();
                //String findResult = "�d�ߵ��G:"+id+","+name+","+telephone+","+grade+","+state;
               // JOptionPane.showMessageDialog(null,findResult); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         }
		return id;             
}

    
    public String findExistId_in_TB_staff(String aid){
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String id = "";

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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        try{
               cmdData = "SELECT EMPL_id FROM staff WHERE EMPL_id ='"+aid+"' ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
               
              // id = result.getString("EMPL_id");
               
               while( result.next() ){
            	   	 id = result.getString("EMPL_id");
                }
               
                statement.close();
               // String findResult = "�d�ߵ��G:"+id+","+name+","+telephone+","+grade+","+state;
              //  JOptionPane.showMessageDialog(null,id); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         }
		return id;
    }
    
      
    
    public ArrayList<ArrayList<String>> findRD_in_TB_staff(String sel_rq,String rq){
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        //String id = "";
        ArrayList<ArrayList<String>> Alist = new ArrayList<ArrayList<String>>();
        
        ArrayList<String> List_id = new ArrayList<String>();
        ArrayList<String> List_name = new ArrayList<String>();
        ArrayList<String> List_phone = new ArrayList<String>();
        ArrayList<String> List_level = new ArrayList<String>();
        Alist.add(List_name);
        Alist.add(List_id);
        Alist.add(List_phone);
        Alist.add(List_level);
      
       

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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        try{
              cmdData = "SELECT * FROM staff WHERE "+sel_rq+" LIKE '%"+rq+"%'";
        	//  cmdData = "SELECT * FROM staff WHERE EMPL_name ='"+rq+"' ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
               
              // id = result.getString("EMPL_id");
               
               while( result.next() ){
            	    List_id.add(result.getString("EMPL_id"));
            	    List_name.add(result.getString("EMPL_name"));
            	    List_phone.add(result.getString("EMPL_telephone"));
            	    List_level.add(result.getString("EMPL_level"));
                }
               	
                statement.close();
                System.out.println("sel_rq="+sel_rq);
                System.out.println("rq="+rq);
                System.out.println(cmdData);
               // String findResult = "�d�ߵ��G:"+id+","+name+","+telephone+","+grade+","+state;
              //  JOptionPane.showMessageDialog(null,id); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         }
		return Alist;
    }
    
 
    public String[] findRD_in_TB_staffDetail(String aid){
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String[] rtnStaffDetail = new String[11];
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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        try{
            
        	   cmdData = "SELECT * FROM staff WHERE EMPL_id ='"+aid+"' ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
               
              // id = result.getString("EMPL_id");
               
               while( result.next() ){
            	   rtnStaffDetail[0] = result.getString("EMPL_id");
            	   rtnStaffDetail[1] = result.getString("EMPL_name");
            	   rtnStaffDetail[2] = result.getString("EMPL_gender");
            	   rtnStaffDetail[3] = result.getString("EMPL_birth");
            	   rtnStaffDetail[4] = result.getString("EMPL_duty");
            	   rtnStaffDetail[5] = result.getString("EMPL_number");
            	   rtnStaffDetail[6] = result.getString("EMPL_telephone");
            	   rtnStaffDetail[7] = result.getString("EMPL_address");
            	   rtnStaffDetail[8] = result.getString("EMPL_level");
            	   rtnStaffDetail[9] = result.getString("EMPL_state");
            	   rtnStaffDetail[10] =result.getString("EMPL_ps");
            
                }
               	
                statement.close();
        
               // String findResult = "�d�ߵ��G:"+id+","+name+","+telephone+","+grade+","+state;
              //  JOptionPane.showMessageDialog(null,id); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         }
		return rtnStaffDetail;
    }
 
    
    
    public String[] findPTC_in_TB_PTC(String aid){      //�ΨӽT�{�W�U�Z�O�_�ŦX�޿�
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String id = "";
        String ckin="";
        String ckout="";
        String[] rq ;


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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        try{
        	
               cmdData = "SELECT * from ptc WHERE PTC_Sid ='"+aid+"' ORDER BY PTC_CKin_date DESC LIMIT 1 ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);              
              // id = result.getString("EMPL_id");      
               while( result.next() ){
            	   	 id = result.getString("PTC_Sid");
            	   	 ckin = result.getString("PTC_CKin_date");
            	   	 ckout = result.getString("PTC_CKout_date");
                }
               
                statement.close();
              
               JOptionPane.showMessageDialog(null,"���u�s��:"+id+"�̷s�W�Z���:"+ckin+"�̷s�U�Z�ɶ�"+ckout); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         }
        rq =new String[]{id,ckin,ckout};
		return rq;
    }
    
    
    public ArrayList<ArrayList<String>> findRD_in_TB_res(String sel_rq,String rq){   //�d�߹w��
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        //String id = "";
        ArrayList<ArrayList<String>> Alist = new ArrayList<ArrayList<String>>();
        
        ArrayList<String> List_no = new ArrayList<String>();
        ArrayList<String> List_name = new ArrayList<String>();
        ArrayList<String> List_phone = new ArrayList<String>();
        ArrayList<String> List_date = new ArrayList<String>();
        ArrayList<String> List_time = new ArrayList<String>();
        Alist.add(List_name);
        Alist.add(List_phone);
        Alist.add(List_date);
        Alist.add(List_time);
        Alist.add(List_no);
       

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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        try{
              cmdData = "SELECT * FROM res WHERE "+sel_rq+" LIKE '%"+rq+"%'";
        	//  cmdData = "SELECT * FROM staff WHERE EMPL_name ='"+rq+"' ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
               
              // id = result.getString("EMPL_id");
               
               while( result.next() ){
            	    List_no.add(result.getString("RES_no"));
            	    List_name.add(result.getString("RES_name"));
            	    List_phone.add(result.getString("RES_telephone"));
            	    List_date.add(result.getString("RES_date"));
            	    List_time.add(result.getString("RES_time"));
                }
               	
                statement.close();
                /*
                System.out.println("sel_rq="+sel_rq);
                System.out.println("rq="+rq);
                System.out.println(cmdData);
               // String findResult = "�d�ߵ��G:"+id+","+name+","+telephone+","+grade+","+state;
              //  JOptionPane.showMessageDialog(null,id); 
                System.out.printf("�w���d��!\n");
                */
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         }
		return Alist;
    }
    
    public String[] findRD_in_TB_ResDetail(String aid){
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String[] rtnResDetail = new String[9];
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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        try{
            
        	   cmdData = "SELECT * FROM res WHERE RES_no ='"+aid+"' ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
               
              // id = result.getString("EMPL_id");
               
               while( result.next() ){
            	   rtnResDetail[0] = result.getString("RES_no");
            	   rtnResDetail[1] = result.getString("RES_name");
            	   rtnResDetail[2] = result.getString("RES_date");
            	   rtnResDetail[3] = result.getString("RES_time");
            	   rtnResDetail[4] = result.getString("RES_telephone");
            	   rtnResDetail[5] = result.getString("RES_Mnumber");
            	   rtnResDetail[6] = result.getString("RES_Pnumber");
            	   rtnResDetail[7] = result.getString("RES_state");
            	   rtnResDetail[8] = result.getString("RES_ps");
                }
               	
                statement.close();
        
               // String findResult = "�d�ߵ��G:"+id+","+name+","+telephone+","+grade+","+state;
              //  JOptionPane.showMessageDialog(null,id); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         }
		return rtnResDetail;
    }


    
    public void updateRD_in_TB_staff(String aNo, String[] update){

        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        try{  
              cmdData = "UPDATE staff SET EMPL_id ='"+update[0]+
              			                   "',EMPL_name='"+update[1]+
              			                   "',EMPL_gender='"+update[2]+
              			                   "',EMPL_birth='"+update[3]+
              			                   "',EMPL_duty='"+update[4]+
              			                   "',EMPL_number='"+update[5]+
              			                   "',EMPL_telephone='"+update[6]+
              			                   "',EMPL_address='"+update[7]+
              			                   "',EMPL_level='"+update[8]+
              			                   "',EMPL_state='"+update[9]+
              			                   "',EMPL_ps='"+update[10]+
              			                   "' WHERE EMPL_id='"+aNo+"'";
              connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
              statement = connection.createStatement();
              statement.executeUpdate(cmdData);
              
              System.out.println(cmdData);
              JOptionPane.showMessageDialog(null,"�w�������u��Ƨ�s!");
              statement.close();
        } catch(SQLException e){
           JOptionPane.showMessageDialog(null,"��s����!");
        }           
}
    
    
    public void updateRD_in_TB_res(String aNo, String[] update){

        Connection connection;
        Statement statement;
       // ResultSet result;
        String cmdData;
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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        try{  
              cmdData = "UPDATE RES SET RES_no ='"+update[0]+
              			                   "',RES_name='"+update[1]+
              			                   "',RES_date='"+update[2]+
              			                   "',RES_time='"+update[3]+
              			                   "',RES_telephone='"+update[4]+
              			                   "',RES_Mnumber='"+update[5]+
              			                   "',RES_Pnumber='"+update[6]+
              			                   "',RES_state='"+update[7]+
              			                   "',RES_ps='"+update[8]+
              			                   "' WHERE RES_no='"+aNo+"'";
              connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
              statement = connection.createStatement();
              statement.executeUpdate(cmdData);
              
              System.out.println(cmdData);
              JOptionPane.showMessageDialog(null,"�w�����w����Ƨ�s!");
              statement.close();
        } catch(SQLException e){
           JOptionPane.showMessageDialog(null,"�w����s����!");
        }           
}
    
    
    public String findRD_in_TB_staffPassWord(String aid,String anumber,String atel){                //�d�߭��u�K�X
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String rtn = "";
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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        try{
            
        	   cmdData = "SELECT EMPL_password FROM staff WHERE EMPL_id ='"+aid+"' AND EMPL_number = '"+anumber+"' AND EMPL_telephone = '"+atel+"'";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
               
              // id = result.getString("EMPL_id");
               
               while( result.next() ){
            	   
            	   rtn =result.getString("EMPL_password");
            
                }
               
               if(rtn.equals("")){
            	   JOptionPane.showMessageDialog(null,"�d�L���!�нT�{��J!");
               }
               	
                statement.close();
                  System.out.println(cmdData);
               // String findResult = "�d�ߵ��G:"+id+","+name+","+telephone+","+grade+","+state;
              //  JOptionPane.showMessageDialog(null,id); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         }
		return rtn;
    }
    
    
    public int updateRD_in_TB_StaffPW(String aId, String oldPW,String newPW){           //��s���u�K�X

        Connection connection;
        Statement statement;
        int result;
        String cmdData;
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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        try{  
              cmdData = "UPDATE staff SET EMPL_password ='"+newPW+"' WHERE EMPL_id='"+aId+"' AND EMPL_password = '"+oldPW+"' ";
             // findPW = "SELECT EMPL_password FROM staff WHERE EMPL_id = '"+aId+"' ";
              connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
              statement = connection.createStatement();
             result = statement.executeUpdate(cmdData);
              //result = statement.executeQuery(findPW);
              if(result == 0){
            	  JOptionPane.showMessageDialog(null,"��s����!�нT�{��J!");
            	  return 0;
              }
              else if(result == 1){
            	  JOptionPane.showMessageDialog(null,"��s���\!");
            	  return 1;
              }
    
              statement.close();
        } catch(SQLException e){
           JOptionPane.showMessageDialog(null,"�w����s����!");
        }
		return 3;   
}
    
    
    
    public void createTB_staff(){     //�إ߸�Ʈwprmsdb������ƪ�:staff

        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb"+"?user=root&password=mysql");
             statement = connection.createStatement();

             String createTB = "CREATE TABLE staff(";
             createTB += "EMPL_id             VARCHAR(20) PRIMARY KEY, "; //���u�s��  ex:cm010000
             createTB += "EMPL_name           VARCHAR(15), "; //�m�W
             createTB += "EMPL_gender         VARCHAR(8),";      //�ʧO 
             createTB += "EMPL_birth          VARCHAR(15), "; //�X�ͤ��    ex:1994/02/01
             createTB += "EMPL_duty           VARCHAR(15), "; //��¾��   ex:2012/09/16
             createTB += "EMPL_number         VARCHAR(15), ";       //�����Ҹ� ex:A123456789 
             createTB += "EMPL_telephone      VARCHAR(15),  ";    //���u�q�ܸ��X
             createTB += "EMPL_address        VARCHAR(50),";   //�a�}
             createTB += "EMPL_level          VARCHAR(8),";   //¾��:�����B���u
             createTB += "EMPL_state          VARCHAR(8),";   //���A:�b¾�B��¾�B��¾ 
             createTB += "EMPL_ps             VARCHAR(100),";  //�Ƶ�
             createTB += "EMPL_password       VARCHAR(100))";    //���u�K�X

             statement.executeUpdate(createTB);
             JOptionPane.showMessageDialog(null,"staff��ƪ�إߦ��\!");
             statement.close();
   
        } catch(SQLException e){
             if(statement != null) 
                   JOptionPane.showMessageDialog(null,"staff��ƪ�w�s�b,�i���`�ϥ�!"); 
             else
                   JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
       } catch(Exception e){
          JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
       }  
 }  //end
       
    public void createTB_PTC(){        //�إߥ��d��ƪ�

        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb"+"?user=root&password=mysql");
             statement = connection.createStatement();

             String createTB = "CREATE TABLE ptc(";
             createTB += "PTC_CKin_date        VARCHAR(20),"; //�W�Z���
             createTB += "PTC_CKin_time        VARCHAR(20),"; //�W�Z�ɶ�
             createTB += "PTC_CKout_date       VARCHAR(20),"; //�U�Z���
             createTB += "PTC_CKout_time       VARCHAR(20),"; //�U�Z�ɶ�
             createTB += "PTC_Sid              VARCHAR(20) NOT NULL,"; //���u�s��
             createTB += "FOREIGN KEY (PTC_Sid) REFERENCES staff (EMPL_id))"; //���u�s�����~����
             
             statement.executeUpdate(createTB);
             JOptionPane.showMessageDialog(null,"ptc��ƪ�إߦ��\!");
             statement.close();
   
        } catch(SQLException e){
             if(statement != null) 
                   JOptionPane.showMessageDialog(null,"ptc��ƪ�w�s�b,�i���`�ϥ�!"); 
             else
                   JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
       } catch(Exception e){
          JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
       }  
 }  //end

    public void createTB_RES(){        //�إߩw��s����ƪ�
    	

        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb"+"?user=root&password=mysql");
             statement = connection.createStatement();

             String createTB = "CREATE TABLE res(";
             createTB += "RES_no              VARCHAR(20) PRIMARY KEY,"; //�w��s��
             createTB += "RES_name            VARCHAR(20) NOT NULL,"; //�w��m�W
             createTB += "RES_date            VARCHAR(20),"; //�q����
             createTB += "RES_time            VARCHAR(20),"; //�q��ɶ�
             createTB += "RES_telephone       VARCHAR(20),"; //�q��q��
             createTB += "RES_Mnumber         VARCHAR(20),"; //�q��H��
             createTB += "RES_Pnumber         VARCHAR(20),"; //�d����
             createTB += "RES_state           VARCHAR(20),"; //���A:�w�����B�w��ȡB�w�L���B����   
             createTB += "RES_ps              VARCHAR(150))"; 
             
             statement.executeUpdate(createTB);
             JOptionPane.showMessageDialog(null,"res��ƪ�إߦ��\!");
             statement.close();
   
        } catch(SQLException e){
             if(statement != null) 
                   JOptionPane.showMessageDialog(null,"res��ƪ�w�s�b,�i���`�ϥ�!"); 
             else
                   JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
       } catch(Exception e){
          JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
       }  
 }  //end
    
    
    
    
    public void createDB(){      //�إ߸�Ʈw

        //�w��MySQL�X�ʵ{��, �P�إ߸�Ʈwprmsdb
        try{
             Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
             JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
        }

        //�إ� prmsdb��Ʈw
        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost/"+
                                                      "?user=root&password=mysql");
             statement = connection.createStatement();
             String createDB = "CREATE DATABASE  prmsdb";
             statement.executeUpdate(createDB);
             JOptionPane.showMessageDialog(null,"prmsdb��Ʈw�إߦ��\!");
             statement.close();
             
        } catch(SQLException e){
             if(statement != null) 
                 JOptionPane.showMessageDialog(null,"prmsdb��Ʈw�w�s�b,�i���`�ϥ�!");
             else
                 JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
        } catch(Exception e){
             JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }
    } //end for: public void createDB()
        
    
    
    public String getRESid(String name){
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String id = "";
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
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }

        try{
            
        	   cmdData = "SELECT * FROM res WHERE RES_name ='"+name+"' ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
               
              // id = result.getString("EMPL_id");
               
               while( result.next() ){
            	   id = result.getString("RES_no");
            	   
                }
               	
                statement.close();
        
               // String findResult = "�d�ߵ��G:"+id+","+name+","+telephone+","+grade+","+state;
              //  JOptionPane.showMessageDialog(null,id); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         }
		return id;
    }


} //end for: class CDM_dbma