import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;



//資料管理層類別
//CDM_dbma: Class DatabaseManagement_database manipulation and acess (資料庫操作與存取類別)
class CDM_ST_dbma{                 //員工資料庫存取類別                
    Connection connection;
    Statement statement;
    //建構子:類別Cdbma
    public CDM_ST_dbma(){

         // createDB();                //建立資料庫prmsdb, 完成後請註解掉不作用,以免重複建立會出錯
    //  	createTB_staff();     	     //建立資料表staff, 完成後請註解掉不作用,以免重複建立會出錯    
    //  createTB_PTC();              //建立資料表 PTC 打卡資料表	
    //	createTB_RES();            //建立預約資料表
    }
  
    public void insertRD_into_TB_staff(String[] cmData){      //在staff資料表插入資料

        Connection connection;
        Statement statement;
        String cmdData;

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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
               JOptionPane.showMessageDialog(null,"員工新增成功!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"在prms資料庫中, 寫入一筆[員工資料]到staff資料表中發生錯誤!");
        }
} 
    
    
    
    public void insertRD_into_TB_res(String[] cmData){      //在staff資料表插入資料

        Connection connection;
        Statement statement;
        String cmdData;

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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }

        //在posdb資料庫中, 新增一筆顧客資料到資料表: customer   
        try{  
               cmdData = "INSERT INTO res(RES_no,RES_name,RES_date,RES_time,RES_telephone,RES_Mnumber,RES_Pnumber,RES_state,RES_ps)"+
                                       "VALUES('"+cmData[0]+"','"+cmData[1]+"','"+cmData[2]+"','"+
                                       			  cmData[3]+"','"+cmData[4]+"','"+cmData[5]+"','"+
                                       			  cmData[6]+"','"+cmData[7]+"','"+cmData[8]+"')";

               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               statement.executeUpdate(cmdData);
               JOptionPane.showMessageDialog(null,"在prms資料庫中, 成功寫入一筆[預約資料]到res資料表中!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"在prms資料庫中, 寫入一筆[預約資料]到res資料表中發生錯誤!");
        }
} 
  
    public void insertRD_into_TB_ptc(String[] cmData){      //在staff資料表插入資料

        Connection connection;
        Statement statement;
        String cmdData;

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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }

        //在posdb資料庫中, 新增一筆顧客資料到資料表: customer   
        try{  
               cmdData = "INSERT INTO ptc(PTC_CKin_date,PTC_CKin_time,PTC_CKout_date,PTC_CKout_time,PTC_Sid)"+
            		     "VALUES('"+cmData[0]+"','"+cmData[1]+"','"+cmData[2]+"','"+
            			            cmData[3]+"','"+cmData[4]+"')";


               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               statement.executeUpdate(cmdData);
               JOptionPane.showMessageDialog(null,"在prms資料庫中, 成功寫入一筆[打卡資料]到ptc資料表中!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"在prms資料庫中, 寫入一筆[打卡資料]到ptc資料表中發生錯誤!");
        }
} 
    
    public void updateRD_in_TB_ptc(String date, String time,String id){
    	Connection connection;
        Statement statement;
        String cmdData;
        

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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }

        try{  
              cmdData = "UPDATE ptc SET PTC_CKout_date='"+date+"',PTC_CKout_time='"+time+"' WHERE PTC_Sid='"+id+"'";
              connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
              statement = connection.createStatement();
              statement.executeUpdate(cmdData);
              JOptionPane.showMessageDialog(null,"已完成[打卡]欄位值更新!");
              statement.close();
        } catch(SQLException e){
           JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }           
    }
    
    public String findMaxId_in_TB_staff(String rq_char){//查詢員工編號最大值後回傳

    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
       // String name="",address="",telephone="",grade="",state="";
        String id="";
        String defaultID ="0000";

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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
                //String findResult = "查詢結果:"+id+","+name+","+telephone+","+grade+","+state;
               // JOptionPane.showMessageDialog(null,findResult); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         }
		return id;             
}

    
    public String findExistId_in_TB_staff(String aid){
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String id = "";

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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
               // String findResult = "查詢結果:"+id+","+name+","+telephone+","+grade+","+state;
              //  JOptionPane.showMessageDialog(null,id); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
               // String findResult = "查詢結果:"+id+","+name+","+telephone+","+grade+","+state;
              //  JOptionPane.showMessageDialog(null,id); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         }
		return Alist;
    }
    
 
    public String[] findRD_in_TB_staffDetail(String aid){
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String[] rtnStaffDetail = new String[11];
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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
        
               // String findResult = "查詢結果:"+id+","+name+","+telephone+","+grade+","+state;
              //  JOptionPane.showMessageDialog(null,id); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         }
		return rtnStaffDetail;
    }
 
    
    
    public String[] findPTC_in_TB_PTC(String aid){      //用來確認上下班是否符合邏輯
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String id = "";
        String ckin="";
        String ckout="";
        String[] rq ;


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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
              
               JOptionPane.showMessageDialog(null,"員工編號:"+id+"最新上班日期:"+ckin+"最新下班時間"+ckout); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         }
        rq =new String[]{id,ckin,ckout};
		return rq;
    }
    
    
    public ArrayList<ArrayList<String>> findRD_in_TB_res(String sel_rq,String rq){   //查詢預約
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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
               // String findResult = "查詢結果:"+id+","+name+","+telephone+","+grade+","+state;
              //  JOptionPane.showMessageDialog(null,id); 
                System.out.printf("預約查詢!\n");
                */
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         }
		return Alist;
    }
    
    public String[] findRD_in_TB_ResDetail(String aid){
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String[] rtnResDetail = new String[9];
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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
        
               // String findResult = "查詢結果:"+id+","+name+","+telephone+","+grade+","+state;
              //  JOptionPane.showMessageDialog(null,id); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         }
		return rtnResDetail;
    }


    
    public void updateRD_in_TB_staff(String aNo, String[] update){

        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
              JOptionPane.showMessageDialog(null,"已完成員工資料更新!");
              statement.close();
        } catch(SQLException e){
           JOptionPane.showMessageDialog(null,"更新失敗!");
        }           
}
    
    
    public void updateRD_in_TB_res(String aNo, String[] update){

        Connection connection;
        Statement statement;
       // ResultSet result;
        String cmdData;
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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
              JOptionPane.showMessageDialog(null,"已完成預約資料更新!");
              statement.close();
        } catch(SQLException e){
           JOptionPane.showMessageDialog(null,"預約更新失敗!");
        }           
}
    
    
    public String findRD_in_TB_staffPassWord(String aid,String anumber,String atel){                //查詢員工密碼
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String rtn = "";
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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
            	   JOptionPane.showMessageDialog(null,"查無資料!請確認輸入!");
               }
               	
                statement.close();
                  System.out.println(cmdData);
               // String findResult = "查詢結果:"+id+","+name+","+telephone+","+grade+","+state;
              //  JOptionPane.showMessageDialog(null,id); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         }
		return rtn;
    }
    
    
    public int updateRD_in_TB_StaffPW(String aId, String oldPW,String newPW){           //更新員工密碼

        Connection connection;
        Statement statement;
        int result;
        String cmdData;
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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }

        try{  
              cmdData = "UPDATE staff SET EMPL_password ='"+newPW+"' WHERE EMPL_id='"+aId+"' AND EMPL_password = '"+oldPW+"' ";
             // findPW = "SELECT EMPL_password FROM staff WHERE EMPL_id = '"+aId+"' ";
              connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
              statement = connection.createStatement();
             result = statement.executeUpdate(cmdData);
              //result = statement.executeQuery(findPW);
              if(result == 0){
            	  JOptionPane.showMessageDialog(null,"更新失敗!請確認輸入!");
            	  return 0;
              }
              else if(result == 1){
            	  JOptionPane.showMessageDialog(null,"更新成功!");
            	  return 1;
              }
    
              statement.close();
        } catch(SQLException e){
           JOptionPane.showMessageDialog(null,"預約更新失敗!");
        }
		return 3;   
}
    
    
    
    public void createTB_staff(){     //建立資料庫prmsdb中的資料表:staff

        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb"+"?user=root&password=mysql");
             statement = connection.createStatement();

             String createTB = "CREATE TABLE staff(";
             createTB += "EMPL_id             VARCHAR(20) PRIMARY KEY, "; //員工編號  ex:cm010000
             createTB += "EMPL_name           VARCHAR(15), "; //姓名
             createTB += "EMPL_gender         VARCHAR(8),";      //性別 
             createTB += "EMPL_birth          VARCHAR(15), "; //出生日期    ex:1994/02/01
             createTB += "EMPL_duty           VARCHAR(15), "; //到職日   ex:2012/09/16
             createTB += "EMPL_number         VARCHAR(15), ";       //身分證號 ex:A123456789 
             createTB += "EMPL_telephone      VARCHAR(15),  ";    //員工電話號碼
             createTB += "EMPL_address        VARCHAR(50),";   //地址
             createTB += "EMPL_level          VARCHAR(8),";   //職等:店長、員工
             createTB += "EMPL_state          VARCHAR(8),";   //狀態:在職、停職、離職 
             createTB += "EMPL_ps             VARCHAR(100),";  //備註
             createTB += "EMPL_password       VARCHAR(100))";    //員工密碼

             statement.executeUpdate(createTB);
             JOptionPane.showMessageDialog(null,"staff資料表建立成功!");
             statement.close();
   
        } catch(SQLException e){
             if(statement != null) 
                   JOptionPane.showMessageDialog(null,"staff資料表已存在,可正常使用!"); 
             else
                   JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
       } catch(Exception e){
          JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
       }  
 }  //end
       
    public void createTB_PTC(){        //建立打卡資料表

        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb"+"?user=root&password=mysql");
             statement = connection.createStatement();

             String createTB = "CREATE TABLE ptc(";
             createTB += "PTC_CKin_date        VARCHAR(20),"; //上班日期
             createTB += "PTC_CKin_time        VARCHAR(20),"; //上班時間
             createTB += "PTC_CKout_date       VARCHAR(20),"; //下班日期
             createTB += "PTC_CKout_time       VARCHAR(20),"; //下班時間
             createTB += "PTC_Sid              VARCHAR(20) NOT NULL,"; //員工編號
             createTB += "FOREIGN KEY (PTC_Sid) REFERENCES staff (EMPL_id))"; //員工編號為外來鍵
             
             statement.executeUpdate(createTB);
             JOptionPane.showMessageDialog(null,"ptc資料表建立成功!");
             statement.close();
   
        } catch(SQLException e){
             if(statement != null) 
                   JOptionPane.showMessageDialog(null,"ptc資料表已存在,可正常使用!"); 
             else
                   JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
       } catch(Exception e){
          JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
       }  
 }  //end

    public void createTB_RES(){        //建立定位編號資料表
    	

        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb"+"?user=root&password=mysql");
             statement = connection.createStatement();

             String createTB = "CREATE TABLE res(";
             createTB += "RES_no              VARCHAR(20) PRIMARY KEY,"; //定位編號
             createTB += "RES_name            VARCHAR(20) NOT NULL,"; //定位姓名
             createTB += "RES_date            VARCHAR(20),"; //訂位日期
             createTB += "RES_time            VARCHAR(20),"; //訂位時間
             createTB += "RES_telephone       VARCHAR(20),"; //訂位電話
             createTB += "RES_Mnumber         VARCHAR(20),"; //訂位人數
             createTB += "RES_Pnumber         VARCHAR(20),"; //寵物數
             createTB += "RES_state           VARCHAR(20),"; //狀態:預約中、已到客、已過期、取消   
             createTB += "RES_ps              VARCHAR(150))"; 
             
             statement.executeUpdate(createTB);
             JOptionPane.showMessageDialog(null,"res資料表建立成功!");
             statement.close();
   
        } catch(SQLException e){
             if(statement != null) 
                   JOptionPane.showMessageDialog(null,"res資料表已存在,可正常使用!"); 
             else
                   JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
       } catch(Exception e){
          JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
       }  
 }  //end
    
    
    
    
    public void createDB(){      //建立資料庫

        //安裝MySQL驅動程式, 與建立資料庫prmsdb
        try{
             Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
             JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
        }

        //建立 prmsdb資料庫
        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost/"+
                                                      "?user=root&password=mysql");
             statement = connection.createStatement();
             String createDB = "CREATE DATABASE  prmsdb";
             statement.executeUpdate(createDB);
             JOptionPane.showMessageDialog(null,"prmsdb資料庫建立成功!");
             statement.close();
             
        } catch(SQLException e){
             if(statement != null) 
                 JOptionPane.showMessageDialog(null,"prmsdb資料庫已存在,可正常使用!");
             else
                 JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
        } catch(Exception e){
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }
    } //end for: public void createDB()
        
    
    
    public String getRESid(String name){
    	Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String id = "";
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
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
        
               // String findResult = "查詢結果:"+id+","+name+","+telephone+","+grade+","+state;
              //  JOptionPane.showMessageDialog(null,id); 
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         }
		return id;
    }


} //end for: class CDM_dbma