import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
//��ƺ޲z�h���O
//CDM_dbma: Class DatabaseManagement_database manipulation and acess (��Ʈw�ާ@�P�s�����O)
class CDM_dbma{                    

    Connection connection;
    Statement statement;
   
    //�غc�l:���OCdbma
    public CDM_dbma(){
    //	createDB();                //�إ߸�Ʈwprmsdb, ������е��ѱ����@��,�H�K���ƫإ߷|�X��
    //	createTB_class();          //�إ߸�ƪ�class, ������е��ѱ����@��,�H�K���ƫإ߷|�X��
    //    createTB_meal();           //�إ߸�ƪ�meal, ������е��ѱ����@��,�H�K���ƫإ߷|�X��    	
   
    }
/*----------------------------------------------------*/
/*--                ��Ʈw�إ�                                                             --*/
/*----------------------------------------------------*/    
    //��k:�إ߸�Ʈwprmsdb
    public void createDB(){

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
    
/*----------------------------------------------------*/
/*--                ��ƪ�إ�                                                             --*/
/*----------------------------------------------------*/
    //�إ߸�Ʈwprmsdb������ƪ�:class
    public void createTB_class(){

           try{
                connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb"+"?user=root&password=mysql");
                statement = connection.createStatement();

                String createTB = "CREATE TABLE class(";
                createTB += "CLS_no             VARCHAR(16) PRIMARY KEY, ";      //���O�s��
                createTB += "CLS_date           VARCHAR(10), ";    				//�إߤ��       
                createTB += "CLS_name           VARCHAR(10), ";    				//���O�W��
                createTB += "CLS_kind           VARCHAR(4),";   				//���O����
                createTB += "CLS_state          VARCHAR(4),";             		//���O���A
                createTB += "CLS_note           VARCHAR(30))";     				//���O�Ƶ�

                statement.executeUpdate(createTB);
                JOptionPane.showMessageDialog(null,"class��ƪ�إߦ��\!");
                statement.close();
      
           } catch(SQLException e){
                if(statement != null) 
                      JOptionPane.showMessageDialog(null,"class��ƪ�w�s�b,�i���`�ϥ�!"); 
                else
                      JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
          } catch(Exception e){
             JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
          }  
    } 

    //�إ߸�Ʈwprmsdb������ƪ�:meal
    public void createTB_meal(){

        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb"+"?user=root&password=mysql");
             statement = connection.createStatement();

             String createTB = "CREATE TABLE meal(";
             createTB += "MEAL_no             VARCHAR(17) PRIMARY KEY, "; //�\�I�s��
             createTB += "MEAL_date           VARCHAR(10), ";     		  //�\�I���
             createTB += "MEAL_name           VARCHAR(16), ";    		  //�\�I�W��               
             createTB += "MEAL_kind           VARCHAR(4), ";           	  //�\�I����    
             createTB += "CLS_no              VARCHAR(16) not null, ";	  //�\�I���O�s��,�~����    
             createTB += "MI_no               VARCHAR(15) , ";            //�����`���s��,�~����    
             createTB += "MEAL_state          VARCHAR(4),";            	  //�\�I���A
             createTB += "MEAL_price          INT,";            		  //�\�I����
       //      createTB += "MEAL_note           VARCHAR(30),";    		  //�\�I�Ƶ�
    		 createTB += "FOREIGN KEY (CLS_no) REFERENCES class(CLS_no),";   //�NCLS_no�]���~����
    		 createTB += "FOREIGN KEY (MI_no) REFERENCES mi(MI_no))";//�NMI_no�]���~����
             statement.executeUpdate(createTB);
             JOptionPane.showMessageDialog(null,"meal��ƪ�إߦ��\!");
             statement.close();
   
        } catch(SQLException e){
             if(statement != null) 
                   JOptionPane.showMessageDialog(null,"meal��ƪ�w�s�b,�i���`�ϥ�!"); 
             else
                   JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
       } catch(Exception e){
          JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
       }  
    } 
    
/*----------------------------------------------------*/
/*--                ��ƴ��J                                                                  --*/
/*----------------------------------------------------*/
    
    //�ǤJ���㪺�@���\�I���O������(aClass),�M��N����Ʀs�J��Ʈw��class��ƪ�
    public void insertRD_into_TB_class(CPD_class aClass){

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

            //�bprmsdb��Ʈw��, �s�W�@�����O��ƨ��ƪ�: class   
            try{  	                   

            	  cmdData = "INSERT INTO class(CLS_no,CLS_date,CLS_name,CLS_kind,CLS_state,CLS_note)"+
                        "VALUES('"+aClass.getNo()+"','"+aClass.getDate()+"','"+aClass.getName()+"','"+aClass.getKind()+"','"+aClass.getState()+"','"+aClass.getNote()+"')";
                	
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   statement.executeUpdate(cmdData);
                   JOptionPane.showMessageDialog(null,"�s�W���O���\!");
                   statement.close();

            } catch(SQLException e){
                   JOptionPane.showMessageDialog(null,"�bprmsdb��Ʈw��, �g�J�@��[���O����]��class��ƪ��o�Ϳ��~!");
            }   
    }
    
 
    
    //�ǤJ���㪺�@���\�I������(aMeal),�M��N����Ʀs�J��Ʈw��meal��ƪ�
    public void insertRD_into_TB_meal(CPD_meal aMeal){

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

            //�bprmsdb��Ʈw��, �s�W�@���U�ȸ�ƨ��ƪ�: meal  
            try{  
                System.out.print("��Ʈw:"+aMeal.getNo()+aMeal.getDate()+aMeal.getName()+aMeal.getKind()+aMeal.getCNo()+aMeal.getMNo()+aMeal.getState()+aMeal.getPrice());     
                   cmdData = "INSERT INTO meal(MEAL_no,MEAL_date,MEAL_name,MEAL_kind,CLS_no,MI_no,MEAL_state,MEAL_price)"+
                             "VALUES('"+aMeal.getNo()+"','"+aMeal.getDate()+"','"+aMeal.getName()+"','"+aMeal.getKind()+"','"+aMeal.getCNo()+"','"+aMeal.getMNo()+"','"+aMeal.getState()+"',"+aMeal.getPrice()+")";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   statement.executeUpdate(cmdData);
                   JOptionPane.showMessageDialog(null,"�s�W�\�I���\!");
                   statement.close();

            } catch(SQLException e){
                   JOptionPane.showMessageDialog(null,"�bprmsdb��Ʈw��, �g�J�@��[�\�I����]��meal��ƪ��o�Ϳ��~!");
            }
    } 
    
/*----------------------------------------------------*/
/*--                ��Ƭd��                                                                 --*/
/*----------------------------------------------------*/
    //�d�߸�Ʈw�Ҧ��D�H�\�I���O�W��,�æ^�ǤG���}�C
    public String[][] findRD_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[][] myName=new String[4][5];
            String[][] myResult = new String[4][5];
            int x=0,y=0;
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
                   cmdData = "SELECT * FROM class where CLS_kind='�D�H' and CLS_state='�}��' order by CLS_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
              	     if(x==0){//�Ĥ@�C
                           myName[x][y++]= result.getString("CLS_name");
                           if(y==5){	//��y=5�ɪ�ܸӦC�w��,���ܤU�@�C
                          	 x++;
                          	 y=0;
                           }
              	     }
              	     else{
                           if(x==1){//�ĤG�C
                               myName[x][y++]= result.getString("CLS_name");
                               if(y==5){
                              	 x++;
                              	 y=0;
                               }     
                           }
                           else{
                               if(x==2){//�ĤT�C
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
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 

            for(x=0;x<myResult.length;x++){
            	for(y=0;y<myResult[0].length;y++){
            		myResult[x][y]=myName[x][y];

            	}
            }
            return( myResult );            
    }   
    //1104
    //�d�߸�Ʈw�Ҧ��D�H�\�I���O�W�ٽs��,�æ^�ǤG���}�C
    public String[][] findClass_man_NO_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[][] myName=new String[4][5];
            String[][] myResult = new String[4][5];
            int x=0,y=0;
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
                   cmdData = "SELECT * FROM class where CLS_kind='�D�H' and CLS_state='�}��' order by CLS_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
              	     if(x==0){//�Ĥ@�C
                           myName[x][y++]= result.getString("CLS_no");
                           if(y==5){	//��y=5�ɪ�ܸӦC�w��,���ܤU�@�C
                          	 x++;
                          	 y=0;
                           }
              	     }
              	     else{
                           if(x==1){//�ĤG�C
                               myName[x][y++]= result.getString("CLS_no");
                               if(y==5){
                              	 x++;
                              	 y=0;
                               }     
                           }
                           else{
                               if(x==2){//�ĤT�C
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
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 

            for(x=0;x<myResult.length;x++){
            	for(y=0;y<myResult[0].length;y++){
            		myResult[x][y]=myName[x][y];

            	}
            }
            return( myResult );            
    }   
    //
    //�d�߸�Ʈw�Ҧ��D�H�\�I���O�W�ٽs��,�æ^�ǤG���}�C
    public String[][] findClass_pet_NO_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[][] myName=new String[4][5];
            String[][] myResult = new String[4][5];
            int x=0,y=0;
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
                   cmdData = "SELECT * FROM class where CLS_kind='�d��' and CLS_state='�}��' order by CLS_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
              	     if(x==0){//�Ĥ@�C
                           myName[x][y++]= result.getString("CLS_no");
                           if(y==5){	//��y=5�ɪ�ܸӦC�w��,���ܤU�@�C
                          	 x++;
                          	 y=0;
                           }
              	     }
              	     else{
                           if(x==1){//�ĤG�C
                               myName[x][y++]= result.getString("CLS_no");
                               if(y==5){
                              	 x++;
                              	 y=0;
                               }     
                           }
                           else{
                               if(x==2){//�ĤT�C
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
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 

            for(x=0;x<myResult.length;x++){
            	for(y=0;y<myResult[0].length;y++){
            		myResult[x][y]=myName[x][y];

            	}
            }
            return( myResult );            
    }       
    //�d�߸�Ʈw�Ҧ��d���\�I���O�W��,�æ^�ǤG���}�C
    public String[][] find_PET_CLASS_in_TB_class(){

        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;

        String[][] myName=new String[4][5];
        String[][] myResult = new String[4][5];
        int x=0,y=0;
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
               cmdData = "SELECT * FROM class where CLS_kind='�d��' and CLS_state='�}��' order by CLS_no asc";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
     
               while( result.next() ){
          	     if(x==0){//�Ĥ@�C
                       myName[x][y++]= result.getString("CLS_name");
                       if(y==5){	//��y=5�ɪ�ܸӦC�w��,���ܤU�@�C
                      	 x++;
                      	 y=0;
                       }
          	     }
          	     else{
                       if(x==1){//�ĤG�C
                           myName[x][y++]= result.getString("CLS_name");
                           if(y==5){
                          	 x++;
                          	 y=0;
                           }     
                       }
                       else{
                           if(x==2){//�ĤT�C
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
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         } 

        for(x=0;x<myResult.length;x++){
        	for(y=0;y<myResult[0].length;y++){
        		myResult[x][y]=myName[x][y];

        	}
        }
        return( myResult );            
    }      
    //�d�߸�Ʈw�Ҧ�"�D�H"�\�I���O�W��,�æ^�Ǥ@���}�C����
    public String[] findClass_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[] myResult = new String[20];
            String[] myTab=new String[20];
            int x=0;
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
                   cmdData = "SELECT * FROM class where CLS_kind='�D�H' and CLS_state='�}��' order by CLS_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	     myTab[x]=result.getString("CLS_name");
                	     x++;
                    }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 


            	for(x=0;x<myResult.length;x++){
            		myResult[x]=myTab[x];
            	}
            
            return( myResult );            
    }   
    //�d�߸�Ʈw�Ҧ�"�D�H"�\�I���O�s��,�æ^�Ǥ@���}�C����
    public String[] findClassNo_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[] myResult = new String[20];
            String[] myTab=new String[20];
            int x=0;
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
                   cmdData = "SELECT * FROM class where CLS_kind='�D�H' and CLS_state='�}��' order by CLS_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	     myTab[x]=result.getString("CLS_no");
                	     x++;
                    }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 


            	for(x=0;x<myResult.length;x++){
            		myResult[x]=myTab[x];
            	}
            
            return( myResult );            
    }      
    //�d�߸�Ʈw�Ҧ�"�d��"�\�I���O�W��,�æ^�Ǥ@���}�C����
    public String[] findClassPet_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[] myResult = new String[20];
            String[] myTab=new String[20];
            int x=0;
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
                   cmdData = "SELECT * FROM class where CLS_kind='�d��' and CLS_state='�}��' order by CLS_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	     myTab[x]=result.getString("CLS_name");
                	     x++;
                    }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 


            	for(x=0;x<myResult.length;x++){
            		myResult[x]=myTab[x];
            	}
            
            return( myResult );            
    }   
    //�d�߸�Ʈw�Ҧ�"�d��"�\�I���O�s��,�æ^�Ǥ@���}�C����
    public String[] findClassNoOfPet_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[] myResult = new String[20];
            String[] myTab=new String[20];
            int x=0;
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
                   cmdData = "SELECT * FROM class where CLS_kind='�d��' and CLS_state='�}��' order by CLS_no asc";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
                	     myTab[x]=result.getString("CLS_no");
                	     x++;
                    }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 


            	for(x=0;x<myResult.length;x++){
            		myResult[x]=myTab[x];
            	}
            
            return( myResult );            
    }        
    //��x-�d�����O:�ǤJ�@���d�߱�����
    public String[][] findCLass_in_TB_class(String aQuery1,String aLog1,String aCond1){//String[] classData
        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String myNo="",myName="",myKind="",myDate="",myState="",myNote="";
        int x=0;
        String[][] myResult = new String[20][6];

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
                       JOptionPane.showMessageDialog(null,"�d�߸�ƶW�L100��,���Y�p�d�߽d��!");
            		   break;
            	   }

              }
               statement.close();
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~2!");
         } 
        return myResult;
    } // end findCLass_in_TB_class()
    
    //��x-�d�����O:�ǤJ�h���d�߱�����
    public String[][] findCLass2_in_TB_class(String aQuery1,String aLog1,String aCond1,String aCon,String aQuery2,String aLog2,String aCond2){//String[] classData
        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String[][] myResult = new String[20][6];
        int x=0;
        
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
                           JOptionPane.showMessageDialog(null,"�d�߸�ƶW�L100��,���Y�p�d�߽d��!");
                		   break;
                	   }

                  
                }
                statement.close();
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~2!");
         } 
         
         return myResult;
    } // end findCLass2_in_TB_class()
    
    //��x-�d�����O:���d��(��̷s10��)
    public String[][] find_all_CLass_in_TB_class(){//String[] classData
        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String[][] myResult = new String[10][6];
        int x=0;
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
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         } 
    
        return myResult;
    } //
    //��x-�d�����O:���d��(��̷s10��)
    public String[][] find_all_MEal_in_TB_meal(){//String[] classData
        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String[][] myResult = new String[10][9];
        int x=0;
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
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         } 
    
        return myResult;
    } //
    //��x-�d�����O:�ǤJ�@���d�߱�����
    public String[][] findMeal_in_TB_meal(String aQuery1,String aLog1,String aCond1){//String[] classData
        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        int x=0;
        String[][] myResult = new String[20][9];
     
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
                       JOptionPane.showMessageDialog(null,"�d�߸�ƶW�L100��,���Y�p�d�߽d��!");
            		   break;
            	   }

              }
               statement.close();
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~2!");
         } 
        return myResult;
    } // end findCLass_in_TB_class()    
    
    //��x-�d�����O:�ǤJ�h���d�߱�����
    public String[][] findMeal2_in_TB_meal(String aQuery1,String aLog1,String aCond1,String aCon,String aQuery2,String aLog2,String aCond2){//String[] classData
        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;
        String[][] myResult = new String[20][9];
        int x=0;
        
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
                           JOptionPane.showMessageDialog(null,"�d�߸�ƶW�L100��,���Y�p�d�߽d��!");
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
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~2!");
         } 
         
         return myResult;
    } // end findCLass2_in_TB_class()
           
/*----------------------------------------------------*/
/*--                ��L��ƾާ@                                                         --*/
/*----------------------------------------------------*/
 
    //�d�̷߳s��s�W�����O�s��
    public String query_lastkey_TB_class(){
    	    String no = "CLS0120150202001";
            Connection connection;
            Statement statement;
            String cmdData;
			ResultSet result;
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
            }

            //�bprmsdb��Ʈw��, ���o�̫�@���s�W����
            try{  
                   cmdData = "select * from class order by CLS_no desc LIMIT 1";//�Nclass���Ѥj��p�Ƨǫ�A���o�Ĥ@����ƪ��Ҧ����
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();            
				   statement.executeQuery(cmdData);		
                   result = statement.executeQuery(cmdData);		
				   result.next();
				   no = result.getString("CLS_no");//���o�̷s��c_mo�s��
                   statement.close();
					
					
            } catch(SQLException e){
					System.out.println("�|������ƥi�H�d��");
            }
			return no;		 

	} //
    
    //��s���O���
    public void updateClass_in_TB_class(CPD_class aClass){

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

        //�bprmsdb��Ʈw��, �s�W�@�����O��ƨ��ƪ�: class   
        try{  
        	  cmdData = "UPDATE class SET CLS_date='"+aClass.getDate()+"',CLS_name='"+aClass.getName()+"',CLS_kind='"+aClass.getKind()+"',CLS_state='"+aClass.getState()+"',CLS_note='"+aClass.getNote()+"'WHERE CLS_no='"+aClass.getNo()+"'";
                    
			//	cmdData = "UPDATE customer SET cm_name='"+cmData[1]+"',cm_sex='"+cmData[2]+"',cm_age='"+cmData[3]+"',cm_telephone='"+cmData[4]+"',cm_address='"+cmData[5]+"',cm_email='"+cmData[6]+"' WHERE cm_no='"+cmData[0]+"'";						
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               statement.executeUpdate(cmdData);
               JOptionPane.showMessageDialog(null,"��Ƨ�s���\!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"�bprmsdb��Ʈw��, �g�J�@��[���O����]��class��ƪ��o�Ϳ��~!");
        }    
    } 
    //MEMO
    //�d�߸�Ʈw���\�I���O���\�I,�æ^�ǤG���}�C
    public String[][] findMEAL_in_TB_class(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[][] myName=new String[5][7];
            String[][] myResult = new String[5][7];
            int x=0,y=0;
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
                   cmdData = "SELECT * FROM meal ";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
              	     if(x==0){//�Ĥ@�C
                           myName[x][y++]= result.getString("MEAL_name");
                           if(y==7){	//��y=5�ɪ�ܸӦC�w��,���ܤU�@�C
                          	 x++;
                          	 y=0;
                           }
              	     }
              	     else{
                           if(x==1){//�ĤG�C
                               myName[x][y++]= result.getString("MEAL_name");
                               if(y==7){
                              	 x++;
                              	 y=0;
                               }     
                           }
                           else{
                               if(x==2){//�ĤT�C
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
                                   else{//�ĥ|�C
                                	   if(x==4){
                                		   myName[x][y++]= result.getString("MEAL_name");
                                           if(y==7){
                                          	 x++;
                                          	 y=0;
                                           }  
                                	   }
                                	   else{//�Ĥ��C
                                		   if(x==5){
                                			   myName[x][y++]= result.getString("MEAL_name");
                                               if(y==7){
                                              	 x++;
                                              	 y=0;
                                               }
                                		   }
                                		   else
                                               JOptionPane.showMessageDialog(null,"�����\�I�w��!"); 
                                	   }
                                   }
                               }
                           }

                       }


                  }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 

            for(x=0;x<myResult.length;x++){
            	for(y=0;y<myResult[0].length;y++){
            		myResult[x][y]=myName[x][y];
            		System.out.println(myName[x][y]);
            	}
            }
            return( myResult );            
    }   
    //�ǤJ���O�s��,�d�X�����O�������\�I
    public String[][] findMEAL_in_TB_meal(String aCSL_no){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[][] myName=new String[5][7];
            String[][] myResult = new String[5][7];
            int x=0,y=0;
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
            	  //System.out.println(aCSL_no);
                   cmdData = "SELECT MEAL_name,MEAL_price FROM meal where CLS_no='"+aCSL_no+"'";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();
                   result = statement.executeQuery(cmdData);
         
                   while( result.next() ){
              	     if(x==0){//�Ĥ@�C
                           myName[x][y++]= result.getString("MEAL_name");
                           if(y==7){	//��y=5�ɪ�ܸӦC�w��,���ܤU�@�C
                          	 x++;
                          	 y=0;
                           }
              	     }
              	     else{
                           if(x==1){//�ĤG�C
                               myName[x][y++]= result.getString("MEAL_name");
                               if(y==7){
                              	 x++;
                              	 y=0;
                               }     
                           }
                           else{
                               if(x==2){//�ĤT�C
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
                                   else{//�ĥ|�C
                                	   if(x==4){
                                		   myName[x][y++]= result.getString("MEAL_name");
                                           if(y==7){
                                          	 x++;
                                          	 y=0;
                                           }  
                                	   }
                                	   else{//�Ĥ��C
                                		   if(x==5){
                                			   myName[x][y++]= result.getString("MEAL_name");
                                               if(y==7){
                                              	 x++;
                                              	 y=0;
                                               }
                                		   }
                                		   else
                                               JOptionPane.showMessageDialog(null,"�����\�I�w��!"); 
                                	   }
                                   }
                               }
                           }

                       }


                  }
                    statement.close();
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 

            for(x=0;x<myResult.length;x++){
            	for(y=0;y<myResult[0].length;y++){
            		myResult[x][y]=myName[x][y];
            		System.out.println("���\�I���O��:"+myName[x][y]);
            	}
            }
            return( myResult );            
    }  
    //�d�߸�Ʈw�Ҧ����ƺ����W��,�æ^�Ǥ@���}�C����
    public String[] findMaterialType_in_TB_mi(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[] myResult = new String[20];
            String[] myTab=new String[20];
            int x=0;
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
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 


            	for(x=0;x<myResult.length;x++){
            		myResult[x]=myTab[x];
            	}
            
            return( myResult );            
    }           
    //�d�߸�Ʈw�Ҧ����ƺ����W��,�æ^�Ǥ@���}�C����
    public String[] findMaterial_in_TB_mi(){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[] myResult = new String[20];
            String[] myTab=new String[20];
            int x=0;
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
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 


            	for(x=0;x<myResult.length;x++){
            		myResult[x]=myTab[x];
            	}
            
            return( myResult );            
    }       
    //�ǤJ�@���d�߸�Ʈw���Ƥ����r��Ӥ����Ҧ����ƺ����W��,�æ^�Ǥ@���}�C����
    public String[] findMaterial_useType_in_TB_mi(String aType){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String[] myResult = new String[20];
            String[] myTab=new String[20];
            int x=0;
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
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 


            	for(x=0;x<myResult.length;x++){
            		myResult[x]=myTab[x];
            	}
            
            return( myResult );            
    }
    //�ǤJ���O�s��,�d�X�����O�������\�I
    public String findClassNo_forMeals_in_TB_class(String aCSL_name){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String myCLS_no="";
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
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 
            return( myCLS_no );            
    }  
    //�ǤJ���O�s��,�d�X�����O�������\�I
    public String findMiNo_in_TB_mi(String aMI_name){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;

            String myMI_no="";
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
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 
            return( myMI_no );            
    }
    //�d�̷߳s��s�W�����O�s��
    public String query_lastkey_TB_meal(){
    	    String no = "MEAL0120151028001";
            Connection connection;
            Statement statement;
            String cmdData;
			ResultSet result;
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
            }

            //�bprmsdb��Ʈw��, ���o�̫�@���s�W����
            try{  
                   cmdData = "select * from meal order by MEAL_no desc LIMIT 1";//�Nclass���Ѥj��p�Ƨǫ�A���o�Ĥ@����ƪ��Ҧ����
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();            
				   statement.executeQuery(cmdData);		
                   result = statement.executeQuery(cmdData);		
				   result.next();
				   no = result.getString("MEAL_no");//���o�̷s��MEAL_mo�s��
                   statement.close();
					
					
            } catch(SQLException e){
					System.out.println("�|������ƥi�H�d��");
            }
			return no;		 

	} //
    //��s���O���
    public void updateMeal_in_TB_meal(CPD_meal aMeal){

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

        //�bprmsdb��Ʈw��, �s�W�@�����O��ƨ��ƪ�: class   
        try{  
        	  cmdData = "UPDATE meal SET MEAL_date='"+aMeal.getDate()+"',MEAL_name='"+aMeal.getName()+"',MEAL_kind='"+aMeal.getKind()+"',CLS_no='"+aMeal.getCNo()+"',MI_no='"+aMeal.getMNo()+"',MEAL_state='"+aMeal.getState()+"',MEAL_price='"+aMeal.getPrice()+"'WHERE MEAL_no='"+aMeal.getNo()+"'";
            //cmdData = "INSERT INTO meal(MEAL_no,MEAL_date,MEAL_name,MEAL_kind,CLS_no,MI_no,MEAL_state,MEAL_price)"+
             // "VALUES('"+aMeal.getNo()+"','"+aMeal.getDate()+"','"+aMeal.getName()+"','"+aMeal.getKind()+"','"+aMeal.getCNo()+"','"+aMeal.getMNo()+"','"+aMeal.getState()+"',"+aMeal.getPrice()+")";        
			//	cmdData = "UPDATE customer SET cm_name='"+cmData[1]+"',cm_sex='"+cmData[2]+"',cm_age='"+cmData[3]+"',cm_telephone='"+cmData[4]+"',cm_address='"+cmData[5]+"',cm_email='"+cmData[6]+"' WHERE cm_no='"+cmData[0]+"'";						
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               statement.executeUpdate(cmdData);
               JOptionPane.showMessageDialog(null,"��Ƨ�s���\!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"�bprmsdb��Ʈw��, �g�J�@��[���O����]��class��ƪ��o�Ϳ��~!");
        }    
    } 
    //�ǤJ�\�I�s��,�d�X���\�I����
    public String findClasskind_forMeals_in_TB_class(String aMEAL_no){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;
            String myMEAL_kind="";
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
                  System.out.println("findClasskind_forMeals_in_TB_class-1�ǤJ�s��"+aMEAL_no+"����:"+myMEAL_kind);

            } catch(Exception e){
                  JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
                  System.out.println("findClasskind_forMeals_in_TB_class-2�ǤJ�s��"+aMEAL_no+"����:"+myMEAL_kind);

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
                 System.out.println("3�ǤJ�s��"+aMEAL_no+"����:"+myMEAL_kind);
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 
            return( myMEAL_kind );            
    }  
    //�ǤJ���O�s��,�d�X���\�I����
    public String findMealState_forMeals_in_TB_class(String aMEAL_no){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;
            String MEAL_state="";
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
                  System.out.println("findMealState_forMeals_in_TB_class_1 �X��+"+aMEAL_no);
            } catch(Exception e){
                  JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
                  System.out.println("findMealState_forMeals_in_TB_class_2 �X��");

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
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 
            return( MEAL_state );            
    }  
    //�ǤJ���O�s��,�d�X�����O�W��
    public String findClassno_forMeals_in_TB_class(String aCLS_no){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;
            String CLS_name="";
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
                  System.out.print("findClassno_forMeals_in_TB_class_1���~+"+aCLS_no);
            } catch(Exception e){
                  JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
                  System.out.print("findClassno_forMeals_in_TB_class_2���~");

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
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 
            return( CLS_name );            
    } 
    public String findMaterialName_in_TB_mi(String aMI_no){

        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;

        String myMIname="";

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
              System.out.println("findMaterialName_in_TB_mi_1���~");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
              System.out.println("findMaterialName_in_TB_mi_2���~");

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
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         } 
        
        return( myMIname );            
    }       
    public String findClassNo_in_TB_class(String aCLS_name){

        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;

        String myCLS_no="";

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
               cmdData = "SELECT CLS_no FROM class where CLS_name='"+aCLS_name+"'";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);

               while( result.next() ){
            	   myCLS_no=result.getString("CLS_no");

                }
                statement.close();
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         } 
        
        return( myCLS_no );            
    }
    //�ǤJ���O�W��,��X�����O�s��
    public String findM_No_in_TB_mi(String aMI_name){

        Connection connection;
        Statement statement;
        ResultSet result;
        String cmdData;

        String myMI_no="";

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
               cmdData = "SELECT MI_no FROM mi where MI_name='"+aMI_name+"'";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
               statement = connection.createStatement();
               result = statement.executeQuery(cmdData);
	              System.out.println("�����F");

               while( result.next() ){
            	   myMI_no=result.getString("MI_no");

                }
                statement.close();
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         } 
        
        return( myMI_no );            
    }
    //�ǤJ�@�����ƽs��,�^�Ǫ��ƺ����r��
    public String findMaterialType_in_TB_mi(String aMI_no){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;
            String MI_type="";
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
                  System.out.print("findMaterialType_in_TB_mi_1���~");
            } catch(Exception e){
                  JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
                  System.out.print("findMaterialType_in_TB_mi_2���~");

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
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 
            return( MI_type );            
    } 
    //�ǤJ�@���\�I�W��,�d�ߨ��\�I�W��,����
    public String[] findMeal_in_TB_meal(String aMeal_name){

            Connection connection;
            Statement statement;
            ResultSet result;
            String cmdData;
            String[] myOrder=new String[3];
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
                    JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
             } 
            return( myOrder );            
    } 
} //end for: class CDM_dbma


