import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
//資料管理層類別
//CDM_dbma: Class DatabaseManagement_database manipulation and acess (資料庫操作與存取類別)
class CDM_dbma{                    

    Connection connection;
    Statement statement;
   
    //建構子:類別Cdbma
    public CDM_dbma(){
    //	createDB();                //建立資料庫prmsdb, 完成後請註解掉不作用,以免重複建立會出錯
    //	createTB_class();          //建立資料表class, 完成後請註解掉不作用,以免重複建立會出錯
    //    createTB_meal();           //建立資料表meal, 完成後請註解掉不作用,以免重複建立會出錯    	
   
    }
/*----------------------------------------------------*/
/*--                資料庫建立                                                             --*/
/*----------------------------------------------------*/    
    //方法:建立資料庫prmsdb
    public void createDB(){

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
    
/*----------------------------------------------------*/
/*--                資料表建立                                                             --*/
/*----------------------------------------------------*/
    //建立資料庫prmsdb中的資料表:class
    public void createTB_class(){

           try{
                connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb"+"?user=root&password=mysql");
                statement = connection.createStatement();

                String createTB = "CREATE TABLE class(";
                createTB += "CLS_no             VARCHAR(16) PRIMARY KEY, ";      //類別編號
                createTB += "CLS_date           VARCHAR(10), ";    				//建立日期       
                createTB += "CLS_name           VARCHAR(10), ";    				//類別名稱
                createTB += "CLS_kind           VARCHAR(4),";   				//類別分類
                createTB += "CLS_state          VARCHAR(4),";             		//類別狀態
                createTB += "CLS_note           VARCHAR(30))";     				//類別備註

                statement.executeUpdate(createTB);
                JOptionPane.showMessageDialog(null,"class資料表建立成功!");
                statement.close();
      
           } catch(SQLException e){
                if(statement != null) 
                      JOptionPane.showMessageDialog(null,"class資料表已存在,可正常使用!"); 
                else
                      JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
          } catch(Exception e){
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
          }  
    } 

    //建立資料庫prmsdb中的資料表:meal
    public void createTB_meal(){

        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb"+"?user=root&password=mysql");
             statement = connection.createStatement();

             String createTB = "CREATE TABLE meal(";
             createTB += "MEAL_no             VARCHAR(17) PRIMARY KEY, "; //餐點編號
             createTB += "MEAL_date           VARCHAR(10), ";     		  //餐點日期
             createTB += "MEAL_name           VARCHAR(16), ";    		  //餐點名稱               
             createTB += "MEAL_kind           VARCHAR(4), ";           	  //餐點分類    
             createTB += "CLS_no              VARCHAR(16) not null, ";	  //餐點類別編號,外來鍵    
             createTB += "MI_no               VARCHAR(15) , ";            //物料總類編號,外來鍵    
             createTB += "MEAL_state          VARCHAR(4),";            	  //餐點狀態
             createTB += "MEAL_price          INT,";            		  //餐點價格
       //      createTB += "MEAL_note           VARCHAR(30),";    		  //餐點備註
    		 createTB += "FOREIGN KEY (CLS_no) REFERENCES class(CLS_no),";   //將CLS_no設為外來鍵
    		 createTB += "FOREIGN KEY (MI_no) REFERENCES mi(MI_no))";//將MI_no設為外來鍵
             statement.executeUpdate(createTB);
             JOptionPane.showMessageDialog(null,"meal資料表建立成功!");
             statement.close();
   
        } catch(SQLException e){
             if(statement != null) 
                   JOptionPane.showMessageDialog(null,"meal資料表已存在,可正常使用!"); 
             else
                   JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
       } catch(Exception e){
          JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
       }  
    } 
    
/*----------------------------------------------------*/
/*--                資料插入                                                                  --*/
/*----------------------------------------------------*/
    
    //傳入完整的一筆餐點類別物件資料(aClass),然後將此資料存入資料庫的class資料表中
    public void insertRD_into_TB_class(CPD_class aClass){

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

            //在prmsdb資料庫中, 新增一筆類別資料到資料表: class   
            try{  	                   

            	  cmdData = "INSERT INTO class(CLS_no,CLS_date,CLS_name,CLS_kind,CLS_state,CLS_note)"+
                        "VALUES('"+aClass.getNo()+"','"+aClass.getDate()+"','"+aClass.getName()+"','"+aClass.getKind()+"','"+aClass.getState()+"','"+aClass.getNote()+"')";
                	
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   statement.executeUpdate(cmdData);
                   JOptionPane.showMessageDialog(null,"新增類別成功!");
                   statement.close();

            } catch(SQLException e){
                   JOptionPane.showMessageDialog(null,"在prmsdb資料庫中, 寫入一筆[類別紀錄]到class資料表中發生錯誤!");
            }   
    }
    
 
    
    //傳入完整的一筆餐點物件資料(aMeal),然後將此資料存入資料庫的meal資料表中
    public void insertRD_into_TB_meal(CPD_meal aMeal){

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

            //在prmsdb資料庫中, 新增一筆顧客資料到資料表: meal  
            try{  
                System.out.print("資料庫:"+aMeal.getNo()+aMeal.getDate()+aMeal.getName()+aMeal.getKind()+aMeal.getCNo()+aMeal.getMNo()+aMeal.getState()+aMeal.getPrice());     
                   cmdData = "INSERT INTO meal(MEAL_no,MEAL_date,MEAL_name,MEAL_kind,CLS_no,MI_no,MEAL_state,MEAL_price)"+
                             "VALUES('"+aMeal.getNo()+"','"+aMeal.getDate()+"','"+aMeal.getName()+"','"+aMeal.getKind()+"','"+aMeal.getCNo()+"','"+aMeal.getMNo()+"','"+aMeal.getState()+"',"+aMeal.getPrice()+")";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   statement.executeUpdate(cmdData);
                   JOptionPane.showMessageDialog(null,"新增餐點成功!");
                   statement.close();

            } catch(SQLException e){
                   JOptionPane.showMessageDialog(null,"在prmsdb資料庫中, 寫入一筆[餐點紀錄]到meal資料表中發生錯誤!");
            }
    } 
    
/*----------------------------------------------------*/
/*--                資料查詢                                                                 --*/
/*----------------------------------------------------*/
    //查詢資料庫所有主人餐點類別名稱,並回傳二維陣列
    public String[][] findRD_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[][] myName=new String[4][5];
            String[][] myResult = new String[4][5];
            int x=0,y=0;
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
                   cmdData = "SELECT * FROM class where CLS_kind='主人' and CLS_state='開啟' order by CLS_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
              	     if(x==0){//第一列
                           myName[x][y++]= result.getString("CLS_name");
                           if(y==5){	//當y=5時表示該列已滿,跳至下一列
                          	 x++;
                          	 y=0;
                           }
              	     }
              	     else{
                           if(x==1){//第二列
                               myName[x][y++]= result.getString("CLS_name");
                               if(y==5){
                              	 x++;
                              	 y=0;
                               }     
                           }
                           else{
                               if(x==2){//第三列
                                   myName[x][y++]= result.getString("CLS_name");
                                   if(y==5){
                                  	 x++;
                                  	 y=0;
                                   }
                               }
                               else{
                                   if(x==3){
                                       myName[x][y++]= result.getString("CLS_name");
                                       if(y==5){
                                      	 x++;
                                      	 y=0;
                                       }
                                   }
                               }
                           }

                       }


                  }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 

            for(x=0;x<myResult.length;x++){
            	for(y=0;y<myResult[0].length;y++){
            		myResult[x][y]=myName[x][y];

            	}
            }
            return( myResult );            
    }   
    //1104
    //查詢資料庫所有主人餐點類別名稱編號,並回傳二維陣列
    public String[][] findClass_man_NO_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[][] myName=new String[4][5];
            String[][] myResult = new String[4][5];
            int x=0,y=0;
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
                   cmdData = "SELECT * FROM class where CLS_kind='主人' and CLS_state='開啟' order by CLS_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
              	     if(x==0){//第一列
                           myName[x][y++]= result.getString("CLS_no");
                           if(y==5){	//當y=5時表示該列已滿,跳至下一列
                          	 x++;
                          	 y=0;
                           }
              	     }
              	     else{
                           if(x==1){//第二列
                               myName[x][y++]= result.getString("CLS_no");
                               if(y==5){
                              	 x++;
                              	 y=0;
                               }     
                           }
                           else{
                               if(x==2){//第三列
                                   myName[x][y++]= result.getString("CLS_no");
                                   if(y==5){
                                  	 x++;
                                  	 y=0;
                                   }
                               }
                               else{
                                   if(x==3){
                                       myName[x][y++]= result.getString("CLS_no");
                                       if(y==5){
                                      	 x++;
                                      	 y=0;
                                       }
                                   }
                               }
                           }

                       }


                  }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 

            for(x=0;x<myResult.length;x++){
            	for(y=0;y<myResult[0].length;y++){
            		myResult[x][y]=myName[x][y];

            	}
            }
            return( myResult );            
    }   
    //
    //查詢資料庫所有主人餐點類別名稱編號,並回傳二維陣列
    public String[][] findClass_pet_NO_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[][] myName=new String[4][5];
            String[][] myResult = new String[4][5];
            int x=0,y=0;
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
                   cmdData = "SELECT * FROM class where CLS_kind='寵物' and CLS_state='開啟' order by CLS_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
              	     if(x==0){//第一列
                           myName[x][y++]= result.getString("CLS_no");
                           if(y==5){	//當y=5時表示該列已滿,跳至下一列
                          	 x++;
                          	 y=0;
                           }
              	     }
              	     else{
                           if(x==1){//第二列
                               myName[x][y++]= result.getString("CLS_no");
                               if(y==5){
                              	 x++;
                              	 y=0;
                               }     
                           }
                           else{
                               if(x==2){//第三列
                                   myName[x][y++]= result.getString("CLS_no");
                                   if(y==5){
                                  	 x++;
                                  	 y=0;
                                   }
                               }
                               else{
                                   if(x==3){
                                       myName[x][y++]= result.getString("CLS_no");
                                       if(y==5){
                                      	 x++;
                                      	 y=0;
                                       }
                                   }
                               }
                           }

                       }


                  }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 

            for(x=0;x<myResult.length;x++){
            	for(y=0;y<myResult[0].length;y++){
            		myResult[x][y]=myName[x][y];

            	}
            }
            return( myResult );            
    }       
    //查詢資料庫所有寵物餐點類別名稱,並回傳二維陣列
    public String[][] find_PET_CLASS_in_TB_class(){

        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;

        String[][] myName=new String[4][5];
        String[][] myResult = new String[4][5];
        int x=0,y=0;
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
               cmdData = "SELECT * FROM class where CLS_kind='寵物' and CLS_state='開啟' order by CLS_no asc";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
     
               while( result.next() ){
          	     if(x==0){//第一列
                       myName[x][y++]= result.getString("CLS_name");
                       if(y==5){	//當y=5時表示該列已滿,跳至下一列
                      	 x++;
                      	 y=0;
                       }
          	     }
          	     else{
                       if(x==1){//第二列
                           myName[x][y++]= result.getString("CLS_name");
                           if(y==5){
                          	 x++;
                          	 y=0;
                           }     
                       }
                       else{
                           if(x==2){//第三列
                               myName[x][y++]= result.getString("CLS_name");
                               if(y==5){
                              	 x++;
                              	 y=0;
                               }
                           }
                           else{
                               if(x==3){
                                   myName[x][y++]= result.getString("CLS_name");
                                   if(y==5){
                                  	 x++;
                                  	 y=0;
                                   }
                               }
                           }
                       }

                   }
              }
                statement.close();
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         } 

        for(x=0;x<myResult.length;x++){
        	for(y=0;y<myResult[0].length;y++){
        		myResult[x][y]=myName[x][y];

        	}
        }
        return( myResult );            
    }      
    //查詢資料庫所有"主人"餐點類別名稱,並回傳一維陣列物件
    public String[] findClass_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[] myResult = new String[20];
            String[] myTab=new String[20];
            int x=0;
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
                   cmdData = "SELECT * FROM class where CLS_kind='主人' and CLS_state='開啟' order by CLS_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	     myTab[x]=result.getString("CLS_name");
                	     x++;
                    }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 


            	for(x=0;x<myResult.length;x++){
            		myResult[x]=myTab[x];
            	}
            
            return( myResult );            
    }   
    //查詢資料庫所有"主人"餐點類別編號,並回傳一維陣列物件
    public String[] findClassNo_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[] myResult = new String[20];
            String[] myTab=new String[20];
            int x=0;
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
                   cmdData = "SELECT * FROM class where CLS_kind='主人' and CLS_state='開啟' order by CLS_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	     myTab[x]=result.getString("CLS_no");
                	     x++;
                    }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 


            	for(x=0;x<myResult.length;x++){
            		myResult[x]=myTab[x];
            	}
            
            return( myResult );            
    }      
    //查詢資料庫所有"寵物"餐點類別名稱,並回傳一維陣列物件
    public String[] findClassPet_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[] myResult = new String[20];
            String[] myTab=new String[20];
            int x=0;
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
                   cmdData = "SELECT * FROM class where CLS_kind='寵物' and CLS_state='開啟' order by CLS_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	     myTab[x]=result.getString("CLS_name");
                	     x++;
                    }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 


            	for(x=0;x<myResult.length;x++){
            		myResult[x]=myTab[x];
            	}
            
            return( myResult );            
    }   
    //查詢資料庫所有"寵物"餐點類別編號,並回傳一維陣列物件
    public String[] findClassNoOfPet_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[] myResult = new String[20];
            String[] myTab=new String[20];
            int x=0;
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
                   cmdData = "SELECT * FROM class where CLS_kind='寵物' and CLS_state='開啟' order by CLS_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	     myTab[x]=result.getString("CLS_no");
                	     x++;
                    }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 


            	for(x=0;x<myResult.length;x++){
            		myResult[x]=myTab[x];
            	}
            
            return( myResult );            
    }        
    //後台-查詢類別:傳入一筆查詢條件資料
    public String[][] findCLass_in_TB_class(String aQuery1,String aLog1,String aCond1){//String[] classData
        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String myNo="",myName="",myKind="",myDate="",myState="",myNote="";
        int x=0;
        String[][] myResult = new String[20][6];

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

        		System.out.print("SELECT * FROM class WHERE "+aQuery1+""+aLog1+"'"+aCond1+"'");
               cmdData = "SELECT * FROM class WHERE "+aQuery1+""+aLog1+"'"+aCond1+"'";

               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);

               while( result.next() ){
            	   if(result==null)
            		   break;
            	 
            		   
            	   myResult[x][0]= result.getString("CLS_no");
            	   myResult[x][1]= result.getString("CLS_date");
            	   myResult[x][2]= result.getString("CLS_name");
            	   myResult[x][3]= result.getString("CLS_kind");
            	   myResult[x][4]= result.getString("CLS_state");
            	   myResult[x][5]= result.getString("CLS_note");           		   
            	   x++;
            	   if(x==100){
                       JOptionPane.showMessageDialog(null,"查詢資料超過100筆,請縮小查詢範圍!");
            		   break;
            	   }

              }
               statement.close();
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤2!");
         } 
        return myResult;
    } // end findCLass_in_TB_class()
    
    //後台-查詢類別:傳入多筆查詢條件資料
    public String[][] findCLass2_in_TB_class(String aQuery1,String aLog1,String aCond1,String aCon,String aQuery2,String aLog2,String aCond2){//String[] classData
        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String[][] myResult = new String[20][6];
        int x=0;
        
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

	 		System.out.println(aQuery1+aLog1+aCond1+aCon+aQuery2+aLog2+aCond2);

               cmdData = "SELECT * FROM class WHERE "+aQuery1+""+aLog1+"'"+aCond1+"'"+aCon+""+aQuery2+""+aLog2+"'"+aCond2+"'";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
               while( result.next() ){
                	   if(result==null)
                		   break;
    
                	   myResult[x][0]= result.getString("CLS_no");
                	   myResult[x][1]= result.getString("CLS_date");
                	   myResult[x][2]= result.getString("CLS_name");
                	   myResult[x][3]= result.getString("CLS_kind");
                	   myResult[x][4]= result.getString("CLS_state");
                	   myResult[x][5]= result.getString("CLS_note");           		   
                	   x++;
                	   if(x==100){
                           JOptionPane.showMessageDialog(null,"查詢資料超過100筆,請縮小查詢範圍!");
                		   break;
                	   }

                  
                }
                statement.close();
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤2!");
         } 
         
         return myResult;
    } // end findCLass2_in_TB_class()
    
    //後台-查詢類別:全查詢(抓最新10筆)
    public String[][] find_all_CLass_in_TB_class(){//String[] classData
        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String[][] myResult = new String[10][6];
        int x=0;
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
               cmdData = "SELECT * FROM class order by CLS_no desc LIMIT 10 ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
               while( result.next() ){  			
            	   if(result==null)
            		   break;

            	   myResult[x][0]= result.getString("CLS_no");
            	   myResult[x][1]= result.getString("CLS_date");
            	   myResult[x][2]= result.getString("CLS_name");
            	   myResult[x][3]= result.getString("CLS_kind");
            	   myResult[x][4]= result.getString("CLS_state");
            	   myResult[x][5]= result.getString("CLS_note");           		   
            	   x++;

                }
                statement.close();
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         } 
    
        return myResult;
    } //
    //後台-查詢類別:全查詢(抓最新10筆)
    public String[][] find_all_MEal_in_TB_meal(){//String[] classData
        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String[][] myResult = new String[10][9];
        int x=0;
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
              // cmdData = "SELECT * FROM meal order by MEAL_no desc LIMIT 10 ";
        	//
        	
            cmdData = " SELECT MEAL_no, MEAL_name,CLS_name, MEAL_date,MI_name ,MEAL_price, MEAL_state,MI_type,MEAL_kind FROM meal,class,mi where meal.CLS_no=class.CLS_no and meal.MI_no=mi.MI_no order by MEAL_no desc LIMIT 10";

           // cmdData = " SELECT MEAL_no, MEAL_name,CLS_name, MEAL_date,MI_no ,MEAL_price, MEAL_state FROM meal,class where meal.CLS_no=class.CLS_no order by MEAL_no desc LIMIT 10";
          /*
    		 cmdData = "SELECT MEAL_no, MEAL_name,CLS_name, MEAL_date,MI_no ,MEAL_price, MEAL_state"
            		+ " FROM meal,class "
            		+ "where meal.CLS_no=class.CLS_no"
            		+ "order by MEAL_no desc LIMIT 10";*/

               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
               while( result.next() ){  			
            	   if(result==null)
            		   break;

            	   myResult[x][0]= result.getString("MEAL_no");
            	   myResult[x][1]= result.getString("MEAL_name");
            	//   myResult[x][2]= result.getString("CLS_no"); 
            	   myResult[x][2]= result.getString("CLS_name");
            	   myResult[x][3]= result.getString("MEAL_date");
            	   myResult[x][4]= result.getString("MI_name");    
            	   myResult[x][5]= result.getString("MEAL_price");           		   
            	   myResult[x][6]= result.getString("MEAL_state");    
            	   myResult[x][7]= result.getString("MI_type");    
            	   myResult[x][8]= result.getString("MEAL_kind");  
            	   System.out.print(myResult[x][0]+myResult[x][1]+myResult[x][2]+myResult[x][3]+ myResult[x][4]+myResult[x][5]+myResult[x][6]+myResult[x][7]);
            	   x++;

                }
                statement.close();
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         } 
    
        return myResult;
    } //
    //後台-查詢類別:傳入一筆查詢條件資料
    public String[][] findMeal_in_TB_meal(String aQuery1,String aLog1,String aCond1){//String[] classData
        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        int x=0;
        String[][] myResult = new String[20][9];
     
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
 
               cmdData = "SELECT * FROM meal,class,mi WHERE "+aQuery1+""+aLog1+"'"+aCond1+"'AND meal.CLS_no=class.CLS_no AND meal.MI_no=mi.MI_no";
               
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);

               while( result.next() ){
            	   if(result==null)
            		   break;
            	 
            		   
            	   myResult[x][0]= result.getString("MEAL_no");
            	   myResult[x][1]= result.getString("MEAL_name");
            	   myResult[x][2]= result.getString("CLS_name");
            	   myResult[x][3]= result.getString("MEAL_date");
            	   myResult[x][4]= result.getString("MI_name");    
            	   myResult[x][5]= result.getString("MEAL_price");           		   
            	   myResult[x][6]= result.getString("MEAL_state");    
            	   myResult[x][7]= result.getString("MI_type");    
            	   myResult[x][8]= result.getString("MEAL_kind");    

            	   x++;
            	   if(x==100){
                       JOptionPane.showMessageDialog(null,"查詢資料超過100筆,請縮小查詢範圍!");
            		   break;
            	   }

              }
               statement.close();
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤2!");
         } 
        return myResult;
    } // end findCLass_in_TB_class()    
    
    //後台-查詢類別:傳入多筆查詢條件資料
    public String[][] findMeal2_in_TB_meal(String aQuery1,String aLog1,String aCond1,String aCon,String aQuery2,String aLog2,String aCond2){//String[] classData
        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String[][] myResult = new String[20][9];
        int x=0;
        
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

	 		   System.out.println(aQuery1+aLog1+aCond1+aCon+aQuery2+aLog2+aCond2);

               cmdData = "SELECT * FROM meal,class,mi WHERE "+aQuery1+""+aLog1+"'"+aCond1+"'"+aCon+""+aQuery2+""+aLog2+"'"+aCond2+"' AND meal.CLS_no=class.CLS_no AND meal.MI_no=mi.MI_no";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
               while( result.next() ){
                	   if(result==null)
                		   break;
    
                	   myResult[x][0]= result.getString("MEAL_no");
                	   myResult[x][1]= result.getString("MEAL_name");
                	   myResult[x][2]= result.getString("CLS_name");
                	   myResult[x][3]= result.getString("MEAL_date");
                	   myResult[x][4]= result.getString("MI_name");    
                	   myResult[x][5]= result.getString("MEAL_price");           		   
                	   myResult[x][6]= result.getString("MEAL_state");    
                	   myResult[x][7]= result.getString("MI_type");  
                	   myResult[x][8]= result.getString("MEAL_kind");  
                	   x++;
                	   if(x==100){
                           JOptionPane.showMessageDialog(null,"查詢資料超過100筆,請縮小查詢範圍!");
                		   break;
                	   }                  
                }
                statement.close();
         for(int a=0;a<myResult.length;a++){
        	 for(int y=0;y<myResult[0].length;y++){
        		 System.out.println(myResult[a][y]);
        	 }
         }
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤2!");
         } 
         
         return myResult;
    } // end findCLass2_in_TB_class()
           
/*----------------------------------------------------*/
/*--                其他資料操作                                                         --*/
/*----------------------------------------------------*/
 
    //查詢最新後新增的類別編號
    public String query_lastkey_TB_class(){
    	    String no = "CLS0120150202001";
            Connection connection;
            Statement statement;
            String cmdData;
			ResultSet result;
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
            }

            //在prmsdb資料庫中, 取得最後一筆新增的值
            try{  
                   cmdData = "select * from class order by CLS_no desc LIMIT 1";//將class表單由大到小排序後，取得第一筆資料的所有欄位
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();            
				   statement.executeQuery(cmdData);		
                   result = statement.executeQuery(cmdData);		
				   result.next();
				   no = result.getString("CLS_no");//取得最新的c_mo編號
                   statement.close();
					
					
            } catch(SQLException e){
					System.out.println("尚未有資料可以查詢");
            }
			return no;		 

	} //
    
    //更新類別欄位
    public void updateClass_in_TB_class(CPD_class aClass){

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

        //在prmsdb資料庫中, 新增一筆類別資料到資料表: class   
        try{  
        	  cmdData = "UPDATE class SET CLS_date='"+aClass.getDate()+"',CLS_name='"+aClass.getName()+"',CLS_kind='"+aClass.getKind()+"',CLS_state='"+aClass.getState()+"',CLS_note='"+aClass.getNote()+"'WHERE CLS_no='"+aClass.getNo()+"'";
                    
			//	cmdData = "UPDATE customer SET cm_name='"+cmData[1]+"',cm_sex='"+cmData[2]+"',cm_age='"+cmData[3]+"',cm_telephone='"+cmData[4]+"',cm_address='"+cmData[5]+"',cm_email='"+cmData[6]+"' WHERE cm_no='"+cmData[0]+"'";						
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               statement.executeUpdate(cmdData);
               JOptionPane.showMessageDialog(null,"資料更新成功!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"在prmsdb資料庫中, 寫入一筆[類別紀錄]到class資料表中發生錯誤!");
        }    
    } 
    //MEMO
    //查詢資料庫該餐點類別之餐點,並回傳二維陣列
    public String[][] findMEAL_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[][] myName=new String[5][7];
            String[][] myResult = new String[5][7];
            int x=0,y=0;
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
                   cmdData = "SELECT * FROM meal ";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
              	     if(x==0){//第一列
                           myName[x][y++]= result.getString("MEAL_name");
                           if(y==7){	//當y=5時表示該列已滿,跳至下一列
                          	 x++;
                          	 y=0;
                           }
              	     }
              	     else{
                           if(x==1){//第二列
                               myName[x][y++]= result.getString("MEAL_name");
                               if(y==7){
                              	 x++;
                              	 y=0;
                               }     
                           }
                           else{
                               if(x==2){//第三列
                                   myName[x][y++]= result.getString("MEAL_name");
                                   if(y==7){
                                  	 x++;
                                  	 y=0;
                                   }
                               }
                               else{
                                   if(x==3){
                                       myName[x][y++]= result.getString("MEAL_name");
                                       if(y==7){
                                      	 x++;
                                      	 y=0;
                                       }
                                   }
                                   else{//第四列
                                	   if(x==4){
                                		   myName[x][y++]= result.getString("MEAL_name");
                                           if(y==7){
                                          	 x++;
                                          	 y=0;
                                           }  
                                	   }
                                	   else{//第五列
                                		   if(x==5){
                                			   myName[x][y++]= result.getString("MEAL_name");
                                               if(y==7){
                                              	 x++;
                                              	 y=0;
                                               }
                                		   }
                                		   else
                                               JOptionPane.showMessageDialog(null,"頁面餐點已滿!"); 
                                	   }
                                   }
                               }
                           }

                       }


                  }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 

            for(x=0;x<myResult.length;x++){
            	for(y=0;y<myResult[0].length;y++){
            		myResult[x][y]=myName[x][y];
            		System.out.println(myName[x][y]);
            	}
            }
            return( myResult );            
    }   
    //傳入類別編號,查出該類別對應的餐點
    public String[][] findMEAL_in_TB_meal(String aCSL_no){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[][] myName=new String[5][7];
            String[][] myResult = new String[5][7];
            int x=0,y=0;
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
            	  //System.out.println(aCSL_no);
                   cmdData = "SELECT MEAL_name,MEAL_price FROM meal where CLS_no='"+aCSL_no+"'";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
              	     if(x==0){//第一列
                           myName[x][y++]= result.getString("MEAL_name");
                           if(y==7){	//當y=5時表示該列已滿,跳至下一列
                          	 x++;
                          	 y=0;
                           }
              	     }
              	     else{
                           if(x==1){//第二列
                               myName[x][y++]= result.getString("MEAL_name");
                               if(y==7){
                              	 x++;
                              	 y=0;
                               }     
                           }
                           else{
                               if(x==2){//第三列
                                   myName[x][y++]= result.getString("MEAL_name");
                                   if(y==7){
                                  	 x++;
                                  	 y=0;
                                   }
                               }
                               else{
                                   if(x==3){
                                       myName[x][y++]= result.getString("MEAL_name");
                                       if(y==7){
                                      	 x++;
                                      	 y=0;
                                       }
                                   }
                                   else{//第四列
                                	   if(x==4){
                                		   myName[x][y++]= result.getString("MEAL_name");
                                           if(y==7){
                                          	 x++;
                                          	 y=0;
                                           }  
                                	   }
                                	   else{//第五列
                                		   if(x==5){
                                			   myName[x][y++]= result.getString("MEAL_name");
                                               if(y==7){
                                              	 x++;
                                              	 y=0;
                                               }
                                		   }
                                		   else
                                               JOptionPane.showMessageDialog(null,"頁面餐點已滿!"); 
                                	   }
                                   }
                               }
                           }

                       }


                  }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 

            for(x=0;x<myResult.length;x++){
            	for(y=0;y<myResult[0].length;y++){
            		myResult[x][y]=myName[x][y];
            		System.out.println("該餐點類別有:"+myName[x][y]);
            	}
            }
            return( myResult );            
    }  
    //查詢資料庫所有物料種類名稱,並回傳一維陣列物件
    public String[] findMaterialType_in_TB_mi(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[] myResult = new String[20];
            String[] myTab=new String[20];
            int x=0;
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
                   cmdData = "SELECT DISTINCT MI_type FROM mi order by MI_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	     myTab[x]=result.getString("MI_type");
                	     x++;
                    }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 


            	for(x=0;x<myResult.length;x++){
            		myResult[x]=myTab[x];
            	}
            
            return( myResult );            
    }           
    //查詢資料庫所有物料種類名稱,並回傳一維陣列物件
    public String[] findMaterial_in_TB_mi(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[] myResult = new String[20];
            String[] myTab=new String[20];
            int x=0;
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
                   cmdData = "SELECT * FROM mi order by MI_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	     myTab[x]=result.getString("MI_name");
                	     x++;
                    }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 


            	for(x=0;x<myResult.length;x++){
            		myResult[x]=myTab[x];
            	}
            
            return( myResult );            
    }       
    //傳入一筆查詢資料庫物料分類字串該分類所有物料種類名稱,並回傳一維陣列物件
    public String[] findMaterial_useType_in_TB_mi(String aType){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[] myResult = new String[20];
            String[] myTab=new String[20];
            int x=0;
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
                   cmdData = "SELECT * FROM mi where MI_type= '"+aType+"' order by MI_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
                   while( result.next() ){
                	     myTab[x]=result.getString("MI_name");
                	     x++;
                    }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 


            	for(x=0;x<myResult.length;x++){
            		myResult[x]=myTab[x];
            	}
            
            return( myResult );            
    }
    //傳入類別編號,查出該類別對應的餐點
    public String findClassNo_forMeals_in_TB_class(String aCSL_name){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String myCLS_no="";
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
            	  //System.out.println(aCSL_no);
                   cmdData = "SELECT CLS_no FROM class where CLS_name='"+aCSL_name+"'";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	  myCLS_no=result.getString("CLS_no");

                   }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 
            return( myCLS_no );            
    }  
    //傳入類別編號,查出該類別對應的餐點
    public String findMiNo_in_TB_mi(String aMI_name){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String myMI_no="";
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
            	  //System.out.println(aCSL_no);
                   cmdData = "SELECT MI_no FROM mi where MI_name='"+aMI_name+"'";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	  myMI_no=result.getString("MI_no");

                   }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 
            return( myMI_no );            
    }
    //查詢最新後新增的類別編號
    public String query_lastkey_TB_meal(){
    	    String no = "MEAL0120151028001";
            Connection connection;
            Statement statement;
            String cmdData;
			ResultSet result;
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
            }

            //在prmsdb資料庫中, 取得最後一筆新增的值
            try{  
                   cmdData = "select * from meal order by MEAL_no desc LIMIT 1";//將class表單由大到小排序後，取得第一筆資料的所有欄位
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();            
				   statement.executeQuery(cmdData);		
                   result = statement.executeQuery(cmdData);		
				   result.next();
				   no = result.getString("MEAL_no");//取得最新的MEAL_mo編號
                   statement.close();
					
					
            } catch(SQLException e){
					System.out.println("尚未有資料可以查詢");
            }
			return no;		 

	} //
    //更新類別欄位
    public void updateMeal_in_TB_meal(CPD_meal aMeal){

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

        //在prmsdb資料庫中, 新增一筆類別資料到資料表: class   
        try{  
        	  cmdData = "UPDATE meal SET MEAL_date='"+aMeal.getDate()+"',MEAL_name='"+aMeal.getName()+"',MEAL_kind='"+aMeal.getKind()+"',CLS_no='"+aMeal.getCNo()+"',MI_no='"+aMeal.getMNo()+"',MEAL_state='"+aMeal.getState()+"',MEAL_price='"+aMeal.getPrice()+"'WHERE MEAL_no='"+aMeal.getNo()+"'";
            //cmdData = "INSERT INTO meal(MEAL_no,MEAL_date,MEAL_name,MEAL_kind,CLS_no,MI_no,MEAL_state,MEAL_price)"+
             // "VALUES('"+aMeal.getNo()+"','"+aMeal.getDate()+"','"+aMeal.getName()+"','"+aMeal.getKind()+"','"+aMeal.getCNo()+"','"+aMeal.getMNo()+"','"+aMeal.getState()+"',"+aMeal.getPrice()+")";        
			//	cmdData = "UPDATE customer SET cm_name='"+cmData[1]+"',cm_sex='"+cmData[2]+"',cm_age='"+cmData[3]+"',cm_telephone='"+cmData[4]+"',cm_address='"+cmData[5]+"',cm_email='"+cmData[6]+"' WHERE cm_no='"+cmData[0]+"'";						
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               statement.executeUpdate(cmdData);
               JOptionPane.showMessageDialog(null,"資料更新成功!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"在prmsdb資料庫中, 寫入一筆[類別紀錄]到class資料表中發生錯誤!");
        }    
    } 
    //傳入餐點編號,查出該餐點分類
    public String findClasskind_forMeals_in_TB_class(String aMEAL_no){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;
            String myMEAL_kind="";
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
                  System.out.println("findClasskind_forMeals_in_TB_class-1傳入編號"+aMEAL_no+"種類:"+myMEAL_kind);

            } catch(Exception e){
                  JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
                  System.out.println("findClasskind_forMeals_in_TB_class-2傳入編號"+aMEAL_no+"種類:"+myMEAL_kind);

            }

            try{
            	  //System.out.println(aCSL_no);
                   cmdData = "SELECT MEAL_kind FROM meal where MEAL_no='"+aMEAL_no+"'";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	   myMEAL_kind=result.getString("MEAL_kind");

                   }
                    statement.close();
                    
             } catch(SQLException e){
                 System.out.println("3傳入編號"+aMEAL_no+"種類:"+myMEAL_kind);
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 
            return( myMEAL_kind );            
    }  
    //傳入類別編號,查出該餐點分類
    public String findMealState_forMeals_in_TB_class(String aMEAL_no){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;
            String MEAL_state="";
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
                  System.out.println("findMealState_forMeals_in_TB_class_1 出錯+"+aMEAL_no);
            } catch(Exception e){
                  JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
                  System.out.println("findMealState_forMeals_in_TB_class_2 出錯");

            }

            try{
            	  //System.out.println(aCSL_no);
                   cmdData = "SELECT MEAL_state FROM meal where MEAL_no='"+aMEAL_no+"'";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	   MEAL_state=result.getString("MEAL_state");

                   }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 
            return( MEAL_state );            
    }  
    //傳入類別編號,查出該類別名稱
    public String findClassno_forMeals_in_TB_class(String aCLS_no){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;
            String CLS_name="";
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
                  System.out.print("findClassno_forMeals_in_TB_class_1錯誤+"+aCLS_no);
            } catch(Exception e){
                  JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
                  System.out.print("findClassno_forMeals_in_TB_class_2錯誤");

            }

            try{
            	  //System.out.println(aCSL_no);
                   cmdData = "SELECT CLS_name FROM class where CLS_no='"+aCLS_no+"'";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	   CLS_name=result.getString("CLS_name");

                   }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 
            return( CLS_name );            
    } 
    public String findMaterialName_in_TB_mi(String aMI_no){

        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;

        String myMIname="";

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
              System.out.println("findMaterialName_in_TB_mi_1錯誤");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
              System.out.println("findMaterialName_in_TB_mi_2錯誤");

        }

        try{
               cmdData = "SELECT MI_name FROM mi where MI_no='"+aMI_no+"'";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
     
               while( result.next() ){
            	   myMIname=result.getString("MI_name");

                }
                statement.close();
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         } 
        
        return( myMIname );            
    }       
    public String findClassNo_in_TB_class(String aCLS_name){

        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;

        String myCLS_no="";

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
               cmdData = "SELECT CLS_no FROM class where CLS_name='"+aCLS_name+"'";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);

               while( result.next() ){
            	   myCLS_no=result.getString("CLS_no");

                }
                statement.close();
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         } 
        
        return( myCLS_no );            
    }
    //傳入類別名稱,找出該類別編號
    public String findM_No_in_TB_mi(String aMI_name){

        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;

        String myMI_no="";

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
               cmdData = "SELECT MI_no FROM mi where MI_name='"+aMI_name+"'";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
	              System.out.println("打錯了");

               while( result.next() ){
            	   myMI_no=result.getString("MI_no");

                }
                statement.close();
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         } 
        
        return( myMI_no );            
    }
    //傳入一筆物料編號,回傳物料種類字串
    public String findMaterialType_in_TB_mi(String aMI_no){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;
            String MI_type="";
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
                  System.out.print("findMaterialType_in_TB_mi_1錯誤");
            } catch(Exception e){
                  JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
                  System.out.print("findMaterialType_in_TB_mi_2錯誤");

            }

            try{
            	  //System.out.println(aCSL_no);
                   cmdData = "SELECT MI_type FROM mi where MI_no='"+aMI_no+"'";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	   MI_type=result.getString("MI_type");

                   }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 
            return( MI_type );            
    } 
    //傳入一筆餐點名稱,查詢其餐點名稱,價格
    public String[] findMeal_in_TB_meal(String aMeal_name){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;
            String[] myOrder=new String[3];
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
            	  //System.out.println(aCSL_no);
                   cmdData = "SELECT MEAL_name,MEAL_price,MEAL_kind FROM meal where MEAL_name='"+aMeal_name+"'";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	   myOrder[0]=result.getString("MEAL_name");
                	   myOrder[1]=result.getString("MEAL_price");
                	   myOrder[2]=result.getString("MEAL_kind");

                   }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             } 
            return( myOrder );            
    } 
} //end for: class CDM_dbma


