import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


//�t�ΥD�����O
 //PRMS: Class PetRestaurantManagementSystem (�d���\�U�޲z�t��-SMS)
public class PRMS implements ActionListener,ListSelectionListener{

		 //�إߥ��t�Ωһݪ��U�Ӫ���
		
		CHCI_frame myFrame = new CHCI_frame(); 	  //�H�����ʼh: �ϥΪ̤�������(myFrame,�̭��S�t��:myFrame.myMenu,myFrame.myOP_pane,myFrame.myQR_pane)
	    CFD_check myCheck = new CFD_check();      //��¦�h: �ˬd����(myCheck)
	    
		CPD_class myClass = new CPD_class();      //���D���h: �\�I��������(myClass) 
		CPD_meal myMeal = new CPD_meal();		  //���D���h: �\�I����(myMeal)    
		CPD_cl myCl = new CPD_cl();		  		  //���D���h: �t�Ӫ���(myCl)    
		CPD_mi myMi = new CPD_mi();		          //���D���h: ���ƺ�������(myMi)    
		CPD_od myOd = new CPD_od();		          //���D���h: �q��Ӹ`���p��ƪ���(myOd)    
		CPD_ol myOl = new CPD_ol();		          //���D���h: �q��Ӹ`����(myOl)    
		CPD_order myOrder = new CPD_order();	  //���D���h: �q�檫��(myOrder)    
		CPD_td myTd = new CPD_td();		          //���D���h: ����Ӹ`���p��ƪ���(myTd)    
		CPD_tl myTl = new CPD_tl();		          //���D���h: ����q��Ӹ`����(myTl)    
		CPD_trans myTrans = new CPD_trans();	  //���D���h: ����q�檫��(myTrans)    

	    CDM_dbma myDBMA = new CDM_dbma();         //��ƺ޲z�h: ���O,�\�I��Ʈw�ާ@�s������(myDBMA)
	    CDM_BS_dbma myBS = new CDM_BS_dbma();     //��ƺ޲z�h: ����,�����Ʈw�ާ@�s������(myBS)
	    CDM_ST_dbma myST = new CDM_ST_dbma();	  //��ƺ޲z�h: ���u,���d,�w����Ʈw�ާ@�s������(myBS)
	    
	     //CSMS���غc�l:
	     PRMS(){
	             //�]�w�t�Τ���������O�ѭ��@��[�ƥ��ť�{��]�t�d�B�z��ʧ@ 
	    	 	myFrame.mySignIn_pane.btnSign.addActionListener(ProcessFunSelection);              //[�n�J]�ާ@�e����[�n�J]���s
	    	 	myFrame.mySignIn_pane.btnExit.addActionListener(ProcessFunSelection);              //[�n�J]�ާ@�e����[���}]���s
	    	 	myFrame.myOR_pane.manBtn.addActionListener(ProcessFunSelection);				   //[�s�W�\�I]�ާ@�e����[�D�H�I�\]���s
	    	    myFrame.myOR_pane.petBtn.addActionListener(ProcessFunSelection);				   //[�s�W�\�I]�ާ@�e����[�d���I�\]���s	 
	            myFrame.myOR_pane.manBtn.addActionListener(ProcessUpdata); 						   //[�s�W�\�I]�ާ@�e����[�D�H�I�\]���s
	            myFrame.myOR_pane.petBtn.addActionListener(ProcessUpdata); 						   //[�s�W�\�I]�ާ@�e����[�d���I�\]���s        
	    	    myFrame.myOR_pane.dealBtn.addActionListener(ProcessFunSelection);				   //[�s�W�\�I]�ާ@�e����[���b]���s
	    	    myFrame.myOR_pane.clearBtn.addActionListener(ProcessFunSelection);				   //[�s�W�\�I]�ާ@�e����[�M��]���s
	    	    myFrame.myCOM_pane.checkbtn.addActionListener(ProcessFunSelection);				   //[���b�\�I]�ާ@�e����[�T�w]���s
	    	    myFrame.myMenu.forwardBtn.addActionListener(ProcessFunSelection); 				   //�D�\���檫��[�e�x]���s	
	    	    myFrame.myMenu.backBtn.addActionListener(ProcessFunSelection); 				       //�D�\���檫��[��x]���s
	    	 	myFrame.myMenu.exitBtn.addActionListener(ProcessFunSelection);					   //�D�\���檫��[�n�X]���s
	    	    myFrame.myMenu.punBtn.addActionListener(ProcessFunSelection);				       //�D�\���檫��[���u���d]���s
	    	    myFrame.myMenu.resBtn.addActionListener(ProcessFunSelection);				       //�D�\���檫��[�q��w��]���s
	    	    myFrame.myMenu.orderBtn.addActionListener(ProcessFunSelection);				       //�D�\���檫��[��^�I�\]���s    	    
	    	    myFrame.myMenu.mealMBtn.addActionListener(ProcessFunSelection);				       //�D�\���檫��[�޲z�\�I]���s
	    	    myFrame.myMenu.employeeMBtn.addActionListener(ProcessFunSelection); 			   //�D�\���檫��[�޲z���u]���s
	    	    myFrame.myMenu.storageMBtn.addActionListener(ProcessFunSelection); 				   //�D�\���檫��[�޲z����]���s
	    	    myFrame.myMenu.dealMBtn.addActionListener(ProcessFunSelection); 				   //�D�\���檫��[�޲z���]���s
	    	    myFrame.myMS_pane.myMSO_pane.addstaffbtn.addActionListener(ProcessFunSelection);   //[�޲z���u]�ާ@�e����[�s���O]���s	 	    
	    	    myFrame.myMS_pane.myMSO_pane.revstaffbtn.addActionListener(ProcessFunSelection);   //[�޲z���u]�ާ@�e����[�s�����O]���s
	    	    myFrame.myMM_pane.myMMO_pane.addclassbtn.addActionListener(ProcessFunSelection);   //[�޲z�\�I]�ާ@�e����[�s���O]���s	 	   
	    	    myFrame.myMM_pane.myMMO_pane.revclassbtn.addActionListener(ProcessFunSelection);   //[�޲z�\�I]�ާ@�e����[�s�����O]���s
	    	    myFrame.myMM_pane.myMMO_pane.addmealsbtn.addActionListener(ProcessFunSelection);   //[�޲z�\�I]�ާ@�e����[�s�\�I]���s
	    	    myFrame.myMM_pane.myMMO_pane.revmealsbtn.addActionListener(ProcessFunSelection);   //[�޲z�\�I]�ާ@�e����[�s���\�I]���s

	    	    myFrame.myMM_pane.myMMO_pane.myEC_pane.addbtn.addActionListener(ProcessReviseClassRecord);   //[�޲z�\�I]�ާ@�e����[�s�����O-��s]���s
            //	myFrame.myMM_pane.myMMO_pane.myEC_pane.addbtn.addActionListener(ProcessReviseClassRecord);   //[�޲z�\�I]�ާ@�e����[�s�����O-����]���s
	    	    
	    	    myFrame.myMM_pane.myMMO_pane.myEM_pane.addbtn.addActionListener(ProcessReviseMealRecord);        //[�޲z�\�I]�ާ@�e����[�s���\�I-��s]���s
	    	//	myFrame.myMM_pane.myMMO_pane.myEM_pane.addbtn.addActionListener(ProcessReviseMealRecord);        //[�޲z�\�I]�ާ@�e����[�s���\�I-����]���s

	    	    myFrame.myMM_pane.myMMQ_pane.myQM_pane.quertbtn.addActionListener(ProcessQueryClassRecord); //[�޲z�\�I]�d�ߵe����[�d��]���s	 	   
	    	    myFrame.myMM_pane.myMMQ_pane.myQM_pane.quertbtn.addActionListener(ProcessQueryMealRecord);  //[�޲z�\�I]�d�ߵe����[�d��]���s	 

	            myFrame.myMM_pane.myMMO_pane.myAC_pane.addbtn.addActionListener(ProcessSaveClassRecord);//[�s�W���O]�ާ@�e����[�s�W]���s
	            myFrame.myMM_pane.myMMO_pane.myAM_pane.addbtn.addActionListener(ProcessSaveMealRecord); //[�s�W�\�I]�ާ@�e����[�s�W]���s
	         
	            //[�޲z�\�I]�ާ@�e�����O������ť�ƥ�
	    	    ListSelectionModel lsm=myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectionModel();
	    	    lsm.addListSelectionListener(this);  
	    	    lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	            //[�޲z�\�I]�ާ@�e���\�I������ť�ƥ�
	    	    ListSelectionModel lsm2=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectionModel();
	    	    lsm2.addListSelectionListener(this);  
	    	    lsm2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    	    
	    	    //[�޲z�\�I]�d�ߵe�����O/�\�I�d�ߤ�����ο�ܶs��ť�ƥ�
	    	    myFrame.myMM_pane.myMMQ_pane.myQM_pane.kindradio[0].addActionListener(ProcesskindradioRecord);
	    	    myFrame.myMM_pane.myMMQ_pane.myQM_pane.kindradio[1].addActionListener(ProcesskindradioRecord);
	    	    
	            setClassBtn(); 			//��k:��s[�s�W�\�I]�ާ@�e����[�\�I]���s
	            setClassBtnPressed();   //��k:��[�s�W�\�I]�ާ@�e����[�\�I]���s�[�J��ť�ƥ�addbtn
	     }
	     //�ƥ��ť�{��: �B�z�D�\������
	     public ActionListener ProcessFunSelection = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	 /*-�n�J-*/
	        	 if( e.getSource()==myFrame.mySignIn_pane.btnSign){                    //���U�n�J
	        		 if(myFrame.mySignIn_pane.Check_SignIn()){   //�ˬd�b�K
	        		  myFrame.mySignIn_pane.setVisible(false);		//����[�n�J]�e�� 
	        		  myFrame.myMenu.setVisible(true);				//���[�D�\������]�ާ@�e��
			          myFrame.myOR_pane.setVisible(true);           //���[�s�W�\�I���]�ާ@�e��         	 
			          myFrame.mySO_pane.setVisible(true);           //���[����\�I���]�ާ@�e��      
                      myFrame.myMM_pane.setVisible(false);          //����[�޲z�\�I]�ާ@�e��
	            	  myFrame.myMS_pane.setVisible(false);          //����[�޲z���u]�ާ@�e��
	            	  myFrame.myMMA_pane.setVisible(false);			//����[�޲z����]�ާ@�e��
	            	  myFrame.myMD_pane.setVisible(false);			//����[�޲z���]�ާ@�e��
                      myFrame.myMenu.punBtn.setVisible(true);       //���[���u���d]���s
                      myFrame.myMenu.resBtn.setVisible(true);       //���[�q��w��]���s
                      myFrame.myMenu.scroll.setVisible(true);		//���[���i]��r�϶�
                      myFrame.myMenu.mealMBtn.setVisible(false);    //����[�\�I�޲z]���s
                      myFrame.myMenu.storageMBtn.setVisible(false); //����[���ƺ޲z]���s
                      myFrame.myMenu.employeeMBtn.setVisible(false);//����[���u�޲z]���s
                      myFrame.myMenu.dealMBtn.setVisible(false);    //����[����޲z]���s
                      myFrame.myMenu.forwardBtn.setVisible(false);  //����[�e�x]���s
                      myFrame.myMenu.backBtn.setVisible(true);      //���[��x]���s
                      JOptionPane.showMessageDialog(null,"�n�J���\!"); 
	        		 }
	        	 }
	        	 /*-���}-*/
	        	 if( e.getSource()==myFrame.mySignIn_pane.btnExit){
	        		 System.exit(0);
	        	 }
	        	 /*-�n�X-*/
	        	 if( e.getSource()==myFrame.myMenu.exitBtn){
	            	  System.out.println("2"+myFrame.myMenu.MealIsSelected);

	        		 if(myFrame.myMenu.MealIsSelected==true)
	                      JOptionPane.showMessageDialog(null,"�Х��M�ŷ�e�\�I�I"); 
	        		 else{
		                  //���X�T�������A�߰ݨϥΪ̬O�_�T�{[�n�X]
		        		 int check=JOptionPane.showConfirmDialog(null,"�O�_�n�n�X���t��?","�T�{",
	                                JOptionPane.YES_NO_OPTION,
	                                JOptionPane.INFORMATION_MESSAGE);
		        		 if (check==JOptionPane.YES_OPTION) {
		        			  myFrame.mySignIn_pane.setVisible(true);		//���[�n�J]�e�� 
			        		  myFrame.myMenu.setVisible(false);				//����[�D�\������]�ާ@�e��
					          myFrame.myOR_pane.setVisible(false);          //����[�s�W�\�I���]�ާ@�e��         	 
					          myFrame.mySO_pane.setVisible(false);          //����[����\�I���]�ާ@�e��      
			                  myFrame.myMM_pane.setVisible(false);          //����[�޲z�\�I]�ާ@�e��
				              myFrame.myMS_pane.setVisible(false);          //����[�޲z���u]�ާ@�e��
				              myFrame.myMMA_pane.setVisible(false);			//����[�޲z����]�ާ@�e��
				              myFrame.myMD_pane.setVisible(false);			//����[�޲z���]�ާ@�e��
			                  myFrame.myMenu.punBtn.setVisible(true);       //���[���u���d]���s
		        		 }      			 
	        		 }
	        	 }	        	 
	        	 /*-�e�x-*/
	              if( e.getSource() == myFrame.myOR_pane.manBtn){
	            	  //�������[�D�H�I�\]
	              }
	              if( e.getSource() ==  myFrame.myOR_pane.petBtn){
	            	  //�������[�d���I�\]
                  }
	              if(e.getSource() ==  myFrame.myOR_pane.dealBtn){	//[���b]
	            	  if(myFrame.myOR_pane.Check==true){//�P�_�ϥΪ̬O�_������\�I
	     
	               		  //
		            	  myFrame.myOR_pane.setVisible(false);          //����[�s�W�\�I���]�ާ@�e��
		            	  setNewNo();
	                      myFrame.myCOM_pane.setVisible(true);          //���[���b�\�I���]�ާ@�e��       
	                      myFrame.myCOM_pane.sumTxtFd.setText( String.valueOf(myFrame.mySO_pane.mySPI_panel.total) );	//�N�`���B��ܦb[���b��T]�`���B���
	                      myFrame.myCOM_pane.amount_lbl.setText( String.valueOf(myFrame.mySO_pane.mySPI_panel.total) );	//�N�`���B��ܦb[���b��T]�������B���
	                     //��s���b�s��
	        	 		  
	        	 		  
	            	  }
	            	  else
	                      JOptionPane.showMessageDialog(null,"�|������\�I�I"); 

	              }
	              if(e.getSource() ==  myFrame.myOR_pane.clearBtn){	//[�M��]
            		  /*-�M������T��-*/
       	      	   	  //�M�Ū���\�I
                      myFrame.mySO_pane.mySOI_panel.tm.setRowCount(0);
                      myFrame.mySO_pane.mySOI_panel.tm.fireTableDataChanged();
                      myFrame.mySO_pane.mySPI_panel.total=0;							//�`���B��l��
                      myFrame.myCOM_pane.total=0;										//�ꦬ���B��l��
                      myFrame.myCOM_pane.Banknotes=false;								//���L�ܼ�,�O���ϥΪ̬O�_��ίȶr
                      myFrame.myCOM_pane.Num=false;										//���L�ܼ�,�����ϥΪ̬O�_�����ϥμƦr�s�I����B
                      myFrame.myCOM_pane.payTxtFd.setText("");							//�M���������B���
                      myFrame.myOR_pane.Check=false;									//���L�ܼ�,�����ϥΪ̬O�_������\�I
                      myFrame.myMenu.MealIsSelected=false;
                      myFrame.mySO_pane.mySPI_panel.set_totallbl.setText("");			//�M���`���B����
	            	  myFrame.mySO_pane.mySPI_panel.payinfo_panel.setVisible(false);	//����[���b��T]�e��      
	            	  myFrame.mySO_pane.mySPI_panel.welcomelbl.setVisible(true);		//�������[�w��]����      
	            	  myFrame.mySO_pane.mySPI_panel.set_totallbl.setVisible(true);		//���[�`���B]�������
	            	  myFrame.mySO_pane.mySPI_panel.totallbl.setVisible(true);			//���[�`���B]����
                      myFrame.myCOM_pane.setVisible(false);           					//����[���b�\�I���]�ާ@�e��                    
	            	  myFrame.myOR_pane.setVisible(true);             					//���[�s�W�\�I���]�ާ@�e��  
	            	  System.out.println("1"+myFrame.myMenu.MealIsSelected);
	              }
	              if(e.getSource() ==  myFrame.myCOM_pane.checkbtn){
	            	  boolean money=false;
	            	  try{//�P�_�ꦬ���B�O�_���ŭ�
		        		  int check_money=Integer.parseInt( myFrame.myCOM_pane.payTxtFd.getText());		//�ꦬ���B
		        		  money=true;
	            	  }
	            	  catch(Exception e1){
	            		  JOptionPane.showMessageDialog(null,"�ꦬ���B ���o���ŭȡI"); 
	            		  money=false;
	            	  }
	            	  if(money==true){//��ꦬ���B�����ŭ�
		          		  int amount_money=Integer.parseInt( myFrame.myCOM_pane.amount_lbl.getText());	//�������B
		        		  int check_money=Integer.parseInt( myFrame.myCOM_pane.payTxtFd.getText());		//�ꦬ���B
		        		
		            	  if(check_money>=amount_money){//�P�_�ꦬ���B�O�_�j���������B
		            		  int Total=check_money-amount_money;	//�p���s
		            		  /*��ܬ�����T*/
			            	  myFrame.mySO_pane.mySPI_panel.payinfo_panel.setVisible(true);		//���[���b��T]�e��       
			            	  myFrame.mySO_pane.mySPI_panel.welcomelbl.setVisible(false);		//����[�w��]����      
			            	  myFrame.mySO_pane.mySPI_panel.set_totallbl.setVisible(false);		//����[�`���B]�������
			            	  myFrame.mySO_pane.mySPI_panel.totallbl.setVisible(false);			//����[�`���B]����
			            	  myFrame.mySO_pane.mySPI_panel.set_dealMoneylbl.setText(String.valueOf(amount_money));	//�]�m[�������B]���Ҥ��e
			            	  myFrame.mySO_pane.mySPI_panel.set_paylbl.setText(String.valueOf(check_money));	//�]�m[�ꦬ���B]���Ҥ��e
			            	  myFrame.mySO_pane.mySPI_panel.set_changelbl.setText(String.valueOf(Total));		//�]�m[��s]���Ҥ��e
			            	  JOptionPane.showMessageDialog(null,"��������I");  				//��ܥ�������T��
		            		  /*�N�����Ʀs�J��Ʈw*/
			            	  
			            	  //-�N�����Ƽg�J��ƪ�-//
			            	  String trans_no=myFrame.myCOM_pane.IDTxtFd.getText();
			            	  String trans_date=myFrame.myCOM_pane.dateTxtFd.getText();	//����������
			            	  int trans_shiff=0;
			            	  String EMPL_id="E010001";
			            	  int trans_ein=123456789;
			            	  int trans_state=0;
			            	  int trans_amount=amount_money;		//����������B
			            	  myTrans.setNo(trans_no);
			            	  myTrans.setDate(trans_date);
			            	  myTrans.setShiff(trans_shiff);
			            	  myTrans.setEmplId(EMPL_id);
			                  myTrans.setEin(trans_ein);
			                  myTrans.setStatus(trans_state);
			                  myTrans.setAmount(trans_amount);		  
			                  myBS.insertRD_into_TB_trans(myTrans);   //

			                  //�N����Ӹ`�g�J��ƪ�
			                  int count=0;
			                  myTl.setNo(trans_no);	//�]�m�ӵ�����s��
			            	  while(true){
			                      try{
				            		  myTl.setMealNo(myFrame.mySO_pane.mySOI_panel.orderTable.getValueAt(count, 0).toString());
				            		  myTl.setNumber(Integer.valueOf(myFrame.mySO_pane.mySOI_panel.orderTable.getValueAt(count, 3).toString())); 
				            		  myTl.setAmount(Integer.valueOf(myFrame.mySO_pane.mySOI_panel.orderTable.getValueAt(count, 4).toString())); 
				            		  count++;
			                      } catch(Exception e1){
			                    	  count=0;
			            			  break;			                      
			            		  }
			                      	  System.out.print(myTl.getMealNo()+myTl.getNumber()+myTl.getAmount());
					            	  myBS.insertRD_into_TB_tl(myTl,trans_no);
			            	  }
			            	  
			     
			            	  
			            	  
			            	  /*-�M������T��-*/
		       	      	   	  //�M�Ū���\�I
		                      myFrame.mySO_pane.mySOI_panel.tm.setRowCount(0);
		                      myFrame.mySO_pane.mySOI_panel.tm.fireTableDataChanged();
		                      myFrame.mySO_pane.mySPI_panel.total=0;//�`���B��l��
		                      myFrame.myCOM_pane.total=0;			//�ꦬ���B��l��
		                      myFrame.myCOM_pane.Banknotes=false;	//���L�ܼ�,�O���ϥΪ̬O�_��ίȶr
		                      myFrame.myCOM_pane.Num=false;			//���L�ܼ�,�����ϥΪ̬O�_�����ϥμƦr�s�I����B
		                      myFrame.myCOM_pane.payTxtFd.setText("");//�M���������B���
		                      myFrame.myOR_pane.Check=false;		//���L�ܼ�,�����ϥΪ̬O�_������\�I
		                      myFrame.myMenu.MealIsSelected=false;
		                      myFrame.mySO_pane.mySPI_panel.set_totallbl.setText("");			//�M���`���B����
			            	  myFrame.mySO_pane.mySPI_panel.payinfo_panel.setVisible(false);	//����[���b��T]�e��      
			            	  myFrame.mySO_pane.mySPI_panel.welcomelbl.setVisible(true);		//�������[�w��]����      
			            	  myFrame.mySO_pane.mySPI_panel.set_totallbl.setVisible(true);		//���[�`���B]�������
			            	  myFrame.mySO_pane.mySPI_panel.totallbl.setVisible(true);			//���[�`���B]����
		                      myFrame.myCOM_pane.setVisible(false);           					//����[���b�\�I���]�ާ@�e��                    
			            	  myFrame.myOR_pane.setVisible(true);             					//���[�s�W�\�I���]�ާ@�e��  
			            	  /*-�N��Ʀs�J��Ʈw-*/
		            	  }
		            	  else
		            		  JOptionPane.showMessageDialog(null,"�ꦬ���B ���o�p�� �������B�I");  
	            	  }


	              }  
	              //��x,�w�]�i�J[�޲z�\�I]�e��
	              if(e.getSource() ==  myFrame.myMenu.backBtn){
			        if(myFrame.myMenu.MealIsSelected==true)
			        		JOptionPane.showMessageDialog(null,"�Х��M�ŷ�e�\�I�I"); 
			        else{
			        	myFrame.myOR_pane.setVisible(false);           //����[�s�W�\�I���]�ާ@�e��
	                      myFrame.mySO_pane.setVisible(false);           //����[����\�I���]�ާ@�e��
	                      myFrame.myRE_pane.setVisible(false);           //����[�q��w�����]�ާ@�e��                   
	                      myFrame.myMenu.punBtn.setVisible(false);       //����[���u���d]���s
	                      myFrame.myMenu.resBtn.setVisible(false);       //����[�q��w��]���s
	                      myFrame.myMenu.orderBtn.setVisible(false);      //����[��^�I�\]���s
	                      myFrame.myMenu.scroll.setVisible(false);		 //����[���i]��r�϶�
	                      myFrame.myMM_pane.setVisible(true);            //���[�޲z�\�I]�ާ@�e��
	                      myFrame.myMenu.mealMBtn.setVisible(true);      //���[�\�I�޲z]���s
	                      myFrame.myMenu.storageMBtn.setVisible(true);   //���[���ƺ޲z]���s
	                      myFrame.myMenu.employeeMBtn.setVisible(true);  //���[���u�޲z]���s
	                      myFrame.myMenu.dealMBtn.setVisible(true);      //���[����޲z]���s
	                      myFrame.myMenu.forwardBtn.setVisible(true);    //���[�e�x]���s
	                      myFrame.myMenu.backBtn.setVisible(false);      //����[��x]���s	 
		            	  myFrame.myMM_pane.myMMO_pane.choose=0; 		 //�ܼƬ���"�s�W���O"�Q���
		            	  myFrame.myMM_pane.myMMO_pane.myEC_pane.setVisible(false);   //����[�s�����O]�ާ@�e��'	            	  myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(false);   //����[�s�W�\�I]�ާ@�e��
		            	  myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(false);   //����[�s�W�\�I]�ާ@�e��
		            	  myFrame.myMM_pane.myMMO_pane.myEM_pane.setVisible(false);   //����[�s���\�I]�ާ@�e��

		            	  myFrame.myMM_pane.myMMO_pane.myAC_pane.setVisible(true);    //���[�s�W���O]�ާ@�e��

	                      SelectedLastClassTable();		            	 //��k:�w�]JTable�d�̷߳s�Q�����
	                      myFrame.myMM_pane.myMMQ_pane.mySR_pane.selected=false; //�N������P�_�]��false
			        }
	            	  

	              }
	              //���u���d
	              if( e.getSource() == myFrame.myMenu.punBtn){
	            	  PunchTimeCard Punframe= new PunchTimeCard(); 
	            	  ImageIcon img = new ImageIcon(getClass().getResource("peticon.png"));
	              	  Punframe.setIconImage(img.getImage());
                  }	 
	              //�q��w��
	              if( e.getSource() == myFrame.myMenu.resBtn){
		        	if(myFrame.myMenu.MealIsSelected==true)
		        		JOptionPane.showMessageDialog(null,"�Х��M�ŷ�e�\�I�I"); 
		        	else{
		            	 myFrame.myOR_pane.setVisible(false);           //����[�s�W�\�I���]�ާ@�e��
		            	 myFrame.myCOM_pane.setVisible(false);          //����[���b�\�I���]�ާ@�e��            	 
		            	 myFrame.mySO_pane.setVisible(false);           //����[����\�I���]�ާ@�e��            	 
		            	 myFrame.myRE_pane.setVisible(true);            //���[�q��w�����]�ާ@�e��     
		            	 myFrame.myMenu.orderBtn.setVisible(true);		//���[��^�I�\]���s
		            	 myFrame.myMenu.resBtn.setVisible(false);		//����[�q��w��]���s 
		        	 }

                  }	 
	              //��^�I�\
	              if( e.getSource() == myFrame.myMenu.orderBtn){
		            myFrame.myOR_pane.setVisible(true);            //���[�s�W�\�I���]�ާ@�e��         	 
		            myFrame.mySO_pane.setVisible(true);            //���[����\�I���]�ާ@�e��      
		            myFrame.myRE_pane.setVisible(false);           //����[�q��w�����]�ާ@�e��     
		            myFrame.myMenu.resBtn.setVisible(true);		   //���[�q��w��]���s
	            	myFrame.myMenu.orderBtn.setVisible(false);	   //����[��^�I�\]���s            
                  }	 	              
	              /*--��x--*/
	              //�e�x
	              if(e.getSource() ==  myFrame.myMenu.forwardBtn){
	            	  myFrame.myOR_pane.setVisible(true);           //���[�s�W�\�I���]�ާ@�e��
                      myFrame.mySO_pane.setVisible(true);           //���[����\�I���]�ާ@�e��
                      myFrame.myMM_pane.setVisible(false);          //����[�޲z�\�I]�ާ@�e��
	            	  myFrame.myMS_pane.setVisible(false);          //����[�޲z���u]�ާ@�e��
	            	  myFrame.myMMA_pane.setVisible(false);			//����[�޲z����]�ާ@�e��
	            	  myFrame.myMD_pane.setVisible(false);			//����[�޲z���]�ާ@�e��
                      myFrame.myMenu.punBtn.setVisible(true);       //���[���u���d]���s
                      myFrame.myMenu.resBtn.setVisible(true);       //���[�q��w��]���s
                      myFrame.myMenu.scroll.setVisible(true);		//���[���i]��r�϶�
                      myFrame.myMenu.mealMBtn.setVisible(false);    //����[�\�I�޲z]���s
                      myFrame.myMenu.storageMBtn.setVisible(false); //����[���ƺ޲z]���s
                      myFrame.myMenu.employeeMBtn.setVisible(false);//����[���u�޲z]���s
                      myFrame.myMenu.dealMBtn.setVisible(false);    //����[����޲z]���s
                      myFrame.myMenu.forwardBtn.setVisible(false);  //����[�e�x]���s
                      myFrame.myMenu.backBtn.setVisible(true);      //���[��x]���s	          
                      
                      setClassBtn();								//��s�e�x[�I�\�e��]�ﶵ
  	    	 		  myFrame.myOR_pane.man_deal = true;			//true��ܥD�H�\�I�Q���

	              }
	              //�޲z�\�I
	              if( e.getSource() == myFrame.myMenu.mealMBtn){
                      myFrame.myMM_pane.setVisible(true);           //���[�޲z�\�I]�d�ߵe��
	            	  myFrame.myMS_pane.setVisible(false);          //����[�޲z���u]�ާ@�e��             
	            	  myFrame.myMMA_pane.setVisible(false);		    //����[�޲z����]�ާ@�e��
	            	  myFrame.myMD_pane.setVisible(false);			//����[�޲z���]�ާ@�e��				
                      myFrame.myMenu.forwardBtn.setVisible(true);   //���[�e�x]���s
                      myFrame.myMenu.backBtn.setVisible(false);     //����[��x]���s
	            	  myFrame.myMM_pane.myMMO_pane.choose=0; 		//�ܼƬ���"�s�W���O"�Q���
                      SelectedLastClassTable();                	    //��k:�w�]JTable�d�̷߳s�Q�����
                      myFrame.myMM_pane.myMMQ_pane.mySR_pane.selected=false; //�N�P�_����ܼƳ]��false

                  }	   
	              //�޲z���u
	              if( e.getSource() == myFrame.myMenu.employeeMBtn){
	            	  myFrame.myMS_pane.setVisible(true); 			 //���[�޲z���u]�ާ@�e��
                      myFrame.myMM_pane.setVisible(false);           //����[�޲z�\�I]�d�ߵe��
	            	  myFrame.myMMA_pane.setVisible(false);			 //����[�޲z����]�ާ@�e��
	            	  myFrame.myMD_pane.setVisible(false);			 //����[�޲z���]�ާ@�e��	
                      myFrame.myMenu.backBtn.setVisible(false);      //����[��x]���s	   
                      myFrame.myMenu.forwardBtn.setVisible(true);    //���[�e�x]���s   	  
	              }	
	              //�޲z����
	              if( e.getSource() == myFrame.myMenu.storageMBtn){
	            	  myFrame.myMMA_pane.setVisible(true); 			 //���[�޲z����]�ާ@�e��
                      myFrame.myMM_pane.setVisible(false);           //����[�޲z�\�I]�d�ߵe��
	            	  myFrame.myMS_pane.setVisible(false); 			 //����[�޲z���u]�ާ@�e��
	            	  myFrame.myMD_pane.setVisible(false);			 //����[�޲z���]�ާ@�e��	
                      myFrame.myMenu.backBtn.setVisible(false);      //����[��x]���s	   
                      myFrame.myMenu.forwardBtn.setVisible(true);    //���[�e�x]���s   	  
	              }	
	              //�޲z���
	              if( e.getSource() == myFrame.myMenu.dealMBtn){
	            	  myFrame.myMD_pane.setVisible(true); 	      	 //���[�޲z���]�ާ@�e��
	            	  myFrame.myMMA_pane.setVisible(false); 		 //����[�޲z����]�ާ@�e��
                      myFrame.myMM_pane.setVisible(false);           //����[�޲z�\�I]�d�ߵe��
	            	  myFrame.myMS_pane.setVisible(false); 			 //����[�޲z���u]�ާ@�e��															 	
                      myFrame.myMenu.backBtn.setVisible(false);      //����[��x]���s	   
                      myFrame.myMenu.forwardBtn.setVisible(true);    //���[�e�x]���s   	  
	              }	
	              if( e.getSource() == myFrame.myMM_pane.myMMO_pane.addclassbtn){
	            	 //�޲z�\�I-�s�W���O
	            	  myFrame.myMM_pane.myMMO_pane.myAC_pane.setVisible(true);    //���[�s�W���O]�ާ@�e��
	            	  myFrame.myMM_pane.myMMO_pane.myEC_pane.setVisible(false);   //����[�s�����O]�ާ@�e��
	            	  myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(false);   //����[�s�W�\�I]�ާ@�e��
	            	  myFrame.myMM_pane.myMMO_pane.myEM_pane.setVisible(false);   //����[�s���\�I]�ާ@�e��
	            	  myFrame.myMM_pane.myMMO_pane.mmdef_panel.setVisible(false); //����[�s���\�I]�ާ@�e��

	            	  myFrame.myMM_pane.myMMO_pane.choose=0; 					  //�ܼƬ���"�s�W���O"�Q���

	              }		
	              if( e.getSource() == myFrame.myMM_pane.myMMO_pane.revclassbtn){
	            	  //�޲z�\�I-�s�����O
	            	  myFrame.myMM_pane.myMMO_pane.choose=1; 					  //�ܼƬ���"�s�����O"�Q���

	            	  if(myFrame.myMM_pane.myMMQ_pane.mySR_pane.selected==true){//�P�_JTable�O�_�Q���
		            	  myFrame.myMM_pane.myMMO_pane.myEC_pane.setVisible(true);     //���[�s�����O]�ާ@�e��
		            	  myFrame.myMM_pane.myMMO_pane.myAC_pane.setVisible(false);    //����[�s�W���O]�ާ@�e��
		            	  myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(false);    //����[�s�W�\�I]�ާ@�e��
		            	  myFrame.myMM_pane.myMMO_pane.myEM_pane.setVisible(false);    //����[�s���\�I]�ާ@�e��
		            	  myFrame.myMM_pane.myMMO_pane.mmdef_panel.setVisible(false);  //����[�s���\�I]�ާ@�e��
		            	  myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=true;	   //�s�����O��getenable�ܼƳ]��true,�s�����O���~�i�H�Q������
		            	  myFrame.myMM_pane.myMMO_pane.myEM_pane.getenable=false;	   //�s���\�I��getenable�ܼƳ]��false,�Ͻs���\�I��줣�i�H�Q������
		            	//  ShowEditClassRecord();	//��k:�N��e������������ܦb�k�����
	            	  }
	            	  else{
	            		  System.out.print("�L��ƳQ���");
 	                	   JOptionPane.showMessageDialog(null,"�Х��ܥ���d�ߵ��G����@�����!");
	            	  }

	              }		              
	              if( e.getSource() == myFrame.myMM_pane.myMMO_pane.addmealsbtn){
	            	  //�޲z�\�I-�s�W�\�I
	            	  myFrame.myMM_pane.myMMO_pane.choose=2; 					  //�ܼƬ���"�s�W���O"�Q���
		    		  myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;	  //�N�ܼƳ]��false,����U�d�߮����������ܤ�k�_�h�|�X��
		    		  myFrame.myMM_pane.myMMO_pane.myEM_pane.getenable=false;	  //�N�ܼƳ]��false,����U�d�߮����������ܤ�k�_�h�|�X��

	            	  myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(true);    //���[�s�W�\�I]�ާ@�e��
	            	  myFrame.myMM_pane.myMMO_pane.myEC_pane.setVisible(false);   //����[�s�����O]�ާ@�e��
	            	  myFrame.myMM_pane.myMMO_pane.myAC_pane.setVisible(false);   //����[�s�W���O]�ާ@�e��
	            	  myFrame.myMM_pane.myMMO_pane.myEM_pane.setVisible(false);   //����[�s���\�I]�ާ@�e��
	            	  myFrame.myMM_pane.myMMO_pane.mmdef_panel.setVisible(false); //����[�s���\�I]�ާ@�e��

	            	  update_MealOfClass();										  //��s[�s�W�\�I]�����O���
	            	  update_MealOfMaterials();	   								  //��s[�s�W�\�I]���������
	            	  
	            	  myFrame.myMM_pane.myMMO_pane.choose=2; 					  //�ܼƬ���"�s�W�\�I"�Q���

	              }	
	              if( e.getSource() == myFrame.myMM_pane.myMMO_pane.revmealsbtn){
	            	  myFrame.myMM_pane.myMMO_pane.choose=3; 					  //�ܼƬ���"�s���\�I"�Q���
	            	  //�޲z�\�I-�s���\�I
	            	  if(myFrame.myMM_pane.myMMQ_pane.mySR_pane.selected==true){//�P�_JTable�O�_�Q���
		            	  myFrame.myMM_pane.myMMO_pane.myEM_pane.setVisible(true);     //���[�s���\�I]�ާ@�e��
		            	  myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(false);    //����[�s�W�\�I]�ާ@�e��
		            	  myFrame.myMM_pane.myMMO_pane.myEC_pane.setVisible(false);    //����[�s�����O]�ާ@�e��
		            	  myFrame.myMM_pane.myMMO_pane.myAC_pane.setVisible(false);    //����[�s�W���O]�ާ@�e��
		            	  myFrame.myMM_pane.myMMO_pane.mmdef_panel.setVisible(false);  //����[�s���\�I]�ާ@�e��
		            	  
		            	  myFrame.myMM_pane.myMMO_pane.myEM_pane.getenable=true;	   //�s�����O��getenable�ܼƳ]��true,�s���\�I���~�i�H�Q������
		            	  myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;	   //�s���\�I��getenable�ܼƳ]��false,�Ͻs�����O��줣�i�H�Q������
		            	//  ShowEditClassRecord();	//��k:�N��e������������ܦb�k�����
	            	  }
	            	  else{
	            		  System.out.print("�L��ƳQ���");
 	                	   JOptionPane.showMessageDialog(null,"�Х��ܥ���d�ߵ��G����@�����!");
	            	  }

	            	  Edit_MealOfMaterials();										//��s[�s���\�I]���������
	              }	
	              if( e.getSource() == myFrame.myMS_pane.myMSO_pane.addstaffbtn){
	            	  //�޲z���u-�s�W���u
	            	  myFrame.myMS_pane.myMSO_pane.myAS_pane.setVisible(true);     //���[�s�W���u]�ާ@�e��
	            	  myFrame.myMS_pane.myMSO_pane.myES_pane.setVisible(false);    //����[�s����u]�ާ@�e��
	              }	     
	              if( e.getSource() == myFrame.myMS_pane.myMSO_pane.revstaffbtn){
	            	  //�޲z���u-�s����u
	            	  myFrame.myMS_pane.myMSO_pane.myES_pane.setVisible(true);     //���[�s����u]�ާ@�e��
	            	  myFrame.myMS_pane.myMSO_pane.myAS_pane.setVisible(false);    //����[�s�W���u]�ާ@�e��

	              }	                 
	         }    
	     };	     

	     //�ƥ��ť�{��: �B�z���O���s���
	     public ActionListener ProcessMealsSelection = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	 String[][] class_no=get_man_in_front_ClassNo();	    //���o���O�s��
	        	 String[][] class_no_pet=get_pet_in_front_ClassNo();	//���o���O�s��
	        	 String[][] meals;									    //�ΨӰO���\�I
  	    	     JButton itemBtn[][]=new JButton[5][7];			        //�\�I���s
  	    	     JPanel[] pane=new JPanel[20];
		         JPanel []pp=new JPanel[20];
	        	 int index_record=0;
	        	 String myOrder[]=new String[3];						//�r��}�C,�Ψ��x�s�I���\�I��T(�W��,���,����)
	    		 
				 CHCI_CM_frame myCM_frame=new CHCI_CM_frame(); 			//�\�I��ܵ���
	        	 ImageIcon img = new ImageIcon(getClass().getResource("peticon.png"));
	        	 myCM_frame.setIconImage(img.getImage());


	    	     //�ƥ��ť�{��: ���o�I���\�I�����
		      	 ActionListener ProcessMealsOrderSelection = new ActionListener(){
   		    		public void actionPerformed(ActionEvent e){
   		    			for(int x=0;x<itemBtn.length;x++){
   		    				for(int y=0;y<itemBtn[0].length;y++){
   		    					if(e.getSource()==	itemBtn[x][y])
   		    					{
   		    					   //�N���s�C��]�^�w�]���A
 			            		   for(int a=0;a<itemBtn.length;a++){
 		            					for(int b=0;b<itemBtn[0].length;b++){	
 		            						if((a+2)%2!=0)
 		            							itemBtn[a][b].setBackground(new Color(255, 146, 20));
 		            						else
 		            							itemBtn[a][b].setBackground(new Color(255, 87, 87));		
 		            					}
 			            		   }
 			            		   //�N�Q��������s�]�m���P���C��
   		    						itemBtn[x][y].setBackground(new Color(46, 199, 255));
   		    						//�N�\�I������A�]��true
   		    						myCM_frame.myCM_pane.myCNSI_pane.MealIsSelected=true;
   		    						System.out.println("�ثe�I�諸�\�I�O:"+itemBtn[x][y].getText());
   		    						String s1 = itemBtn[x][y].getText();
   		    						//�P�_�\�I�r��O�_���ϥ�html�y�k
   		    						if(s1.indexOf("<")>-1){
   		    							//�M��"<html>&nbsp;"�r��
   	   		    						int i=s1.indexOf("<");
   	   		    						int j=s1.indexOf(";");
   	   		    					    s1=s1.substring(0, i)+s1.substring(j+1);
   	   		    					    //�M��"&nbsp;"�r��
   	   		    					    int k=s1.indexOf("&");
   	   		    					    int l=s1.indexOf(";");
   	   		    					    s1=s1.substring(0, k)+s1.substring(l+1);
   	   		    					    //�M��"<br>"�r��
   	   		    					    int m=s1.indexOf("<");
   	   		    					    int n=s1.indexOf(">");
   	   		    					    s1=s1.substring(0, m)+s1.substring(n+1);
   	   		    					    //�M��"</html>"�r��
   	   		    					    int o=s1.indexOf("<");
   	   		    					    int p=s1.indexOf(">");
   	   		    					    s1=s1.substring(0, o)+s1.substring(p+1);
   	   		    						System.out.println(s1);

   		    						}
   		    						else{
   	   		    						System.out.println(s1);

   		    						}
   		    						//�ǤJ�@���\�I�W��,�q��Ʈw������\�I�W��,����
   		    						String Order[]=myDBMA.findMeal_in_TB_meal(s1);
   		    						
   		    						myOrder[0] = Order[0]; //myOrde[0]���o�N�\�I�W��
   		    						myOrder[1] = Order[1]; //myOrder[1]���o�N�\�I����
   		    						myOrder[2] = Order[2]; //myOrder[2]���o�N�\�I����

   		    						System.out.println("�W��:"+myOrder[0]);
   		    						System.out.println("����:"+myOrder[1]);	
   		    						//���\�I���ܮ�,�N�ƶq��l��
   		    		    			myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.setText("");	//�N�ƶq���Ҫ�l��
   		    		    			myCM_frame.myCM_pane.myCNSI_pane.ones_numlbl.setText("");	//�N�ƶq���Ҫ�l��
   		    		    			myCM_frame.myCM_pane.myCNSI_pane.num=1;						//�N�ƶq�����ܼƪ�l��
   		    		    			myCM_frame.myCM_pane.myCNSI_pane.set_namelbl.setText(myOrder[0]);	//�N�\�I�W�ټ��Ҫ�l��
   		    		    			myCM_frame.myCM_pane.myCNSI_pane.set_pricelbl.setText(myOrder[1]);  //�N�\�I������Ҫ�l��		 	  
   		    		    			myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText("");	//�N�p�p���Ҫ�l��
					   		    	myCM_frame.myCM_pane.myCNSI_pane.back_times=0;						//�O���˰h�k0

					   		    	myCM_frame.myCM_pane.myCNSI_pane.MealIsInsert=false;	//��e������\�I
   		    					}
   		    				}
   		    			}
   	

   		    		}	
   		    	 };
	    	     //�ƥ��ť�{��: ����\�I����p�p
		      	 ActionListener ShowSubTotal = new ActionListener(){
   		    		public void actionPerformed(ActionEvent e){
   		    				if(myCM_frame.myCM_pane.myCNSI_pane.MealIsSelected==true){
   		    					int single_price=Integer.valueOf(myOrder[1]).intValue(); 

   	   		    				for(int x=0;x<myCM_frame.myCM_pane.myCNSI_pane.calBtn.length;x++){
   	   		    					for(int y=0;y<myCM_frame.myCM_pane.myCNSI_pane.calBtn[0].length;y++){
   	   		    						if( e.getSource() == myCM_frame.myCM_pane.myCNSI_pane.calBtn[x][y]){
   	   		    							if(x==3 && y==1 ){	//�ϥΪ̫��U[�M��]
   	   	   		 	   		    				myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText("");				//�M�Ťp�p����
   	   					   		    			break;
   	   		    							}
   	   	   		 	   		    			if( x==3 && y==2){	//�ϥΪ̫��U[�˰h]
   	   		    								String str=myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.getText();
   	   		    								if(str=="" || myCM_frame.myCM_pane.myCNSI_pane.back_times==1){
   		   	   		 	   		    				myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText("");		    //�M�Ťp�p����
   	   	   					   		    			myCM_frame.myCM_pane.myCNSI_pane.back_times=0;						//�O���˰h�k0

   	   		    								}
   		   	   		 	   		    			else{
   	   		    									int price_1=Integer.valueOf(myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.getText()).intValue(); 
   	   		    									String price_str2=myCM_frame.myCM_pane.myCNSI_pane.ones_numlbl.getText();
   	   		    									if(price_str2 == null){
   	   		   	   		 	   		    				myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText("");		    //�M�Ťp�p����

   	   		    									}
   	   		    									else{
   	   		    										int subtotal=price_1*single_price;
   	   	   	   					   		    			String subtotal_str=String.valueOf(subtotal); 
   	   	   	   					   		    			myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText(subtotal_str);	//�N�p�p����g�JJLable   
   	   	   	   					   		    			myCM_frame.myCM_pane.myCNSI_pane.back_times++;						//�O���ϥΪ̤w�I��@���˰h
   	   		    									}
   	   		    									
   	   		    								} 	   					   		    		
   	   					   		    			break;
   	   		    							}
   		   		 	   		    			if(myCM_frame.myCM_pane.myCNSI_pane.num>0 ){
   		   				   		    			//�Y�ɭp���`��
   		   			   							if(myCM_frame.myCM_pane.myCNSI_pane.num==1){
   		   	   		    							int price_1=Integer.parseInt(myCM_frame.myCM_pane.myCNSI_pane.calBtn[x][y].getText()); 
   		   	   		    							int subtotal=price_1*single_price;
   		   	   		    							String subtotal_str=String.valueOf(subtotal); 
   		   	   		 	   		    				myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText(subtotal_str);	//�N�\�p�p����ټg�JJLable

   		   			   							}
   		   			   							
   		   			   							if(myCM_frame.myCM_pane.myCNSI_pane.num==2){	
   		   					   		    			int price_1=Integer.valueOf(myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.getText()).intValue(); 
   		   	   		    							int price_2=Integer.parseInt(myCM_frame.myCM_pane.myCNSI_pane.calBtn[x][y].getText()); 
   		   						    				int subtotal=(price_1*10+price_2)*single_price;
   		   	   		    							String subtotal_str=String.valueOf(subtotal); 
   		   	   		 	   		    				myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText(subtotal_str);	//�N�p�p����g�JJLable
   		   			   							}
   		
   		   			   						}

   	   		    						}
   	   		    					}
   	   		    				}
   		   		    			
   		    				}
	   		    		

   		    			}
   		    	};
	    	     //�ƥ��ť�{��: �s�W�\�I
		      	 ActionListener OrderCheck = new ActionListener(){
  		    		public void actionPerformed(ActionEvent e){
  		    			//��ϥΪ̫��U[�s�W],�O���@���\�I�ܫe�xJTable
  		    			if(e.getSource()==myCM_frame.myCM_pane.myCNSI_pane.chBtn){//�ϥΪ̦b�\�I�������U�s�W
  		    				if(myCM_frame.myCM_pane.myCNSI_pane.selectedNum==false){
  		    					JOptionPane.showMessageDialog(null,"��ƿ�J������,�ЦA���ˬd!");
  		    				}
  		    				else{
  	  		    				String subtotalStr=myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.getText();	//���o�ӥ��\�I�p�p
  	  		    				String numStr="";
				   		    	myFrame.mySO_pane.mySPI_panel.total+= Integer.parseInt(subtotalStr);//�N��e����[�`
				   		    	myCM_frame.myCM_pane.myCNSI_pane.MealIsInsert=true;					//��e����\�I�w�Q�s�W
				   		        myFrame.myOR_pane.Check=true;										//�NCheck�]��true,�N���e�w�s�W�i�H���b
				   		    	myFrame.mySO_pane.mySPI_panel.set_totallbl.setText( String.valueOf(myFrame.mySO_pane.mySPI_panel.total));
  	  		    				//���o�\�I�ƶq
  	  		    				if(myCM_frame.myCM_pane.myCNSI_pane.num==1){
  	  								 numStr=myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.getText(); 
  	  		    				}
  	  		    				else {
  	  		    					 String str1=myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.getText();  
  	  		    					 String str2=myCM_frame.myCM_pane.myCNSI_pane.ones_numlbl.getText();
  	  								 numStr=str1+str2;

  	  		    				}
  	  		    				
  	  		    				System.out.println("�s�W�@���\�I:");
  	  		    				System.out.println("�W��:"+myOrder[0]);
  	  		    				System.out.println("���:"+myOrder[1]);
  	  		    				System.out.println("����:"+myOrder[2]);
  	  		    				System.out.println("�ƶq:"+numStr);
  	  		    				System.out.println("�p�p:"+subtotalStr);		
  		    				
		        	 			//�N��Ƽg�JJTable
  	  		    			    myFrame.mySO_pane.mySOI_panel.tm.addRow(new Object[]{myOrder[0],myOrder[2],myOrder[1],numStr,subtotalStr});	//�N[�d�ߵ��G]�g�JJTable
				                //��sJTable �����e
  	  		    			    myFrame.mySO_pane.mySOI_panel.tm.fireTableDataChanged();	
			                    myFrame.mySO_pane.mySOI_panel.orderTable.updateUI();
		        	 		    
			                    
			                    //�]�w��l��
		    					   //�N���s�C��]�^�w�]���A
			            		for(int a=0;a<itemBtn.length;a++){
		            				for(int b=0;b<itemBtn[0].length;b++){	
		            					if((a+2)%2!=0)
		            						itemBtn[a][b].setBackground(new Color(255, 146, 20));
		            					else
		            						itemBtn[a][b].setBackground(new Color(255, 87, 87));		
		            					}
			            		}
		    					
			            		//�NmyFrame.myMenu.MealIsSelected�]��true,�O���ϥΪ̦ܤֿ���@���\�I
			            		myFrame.myMenu.MealIsSelected=true;

		    					//�N�\�I������A�]��false
		    					myCM_frame.myCM_pane.myCNSI_pane.MealIsSelected=false;
			   		         	myCM_frame.myCM_pane.myCNSI_pane.set_namelbl.setText("");
			   		         	myCM_frame.myCM_pane.myCNSI_pane.set_pricelbl.setText("");
			   		         	myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText("");
			   		      		myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.setText("");
			   		   			myCM_frame.myCM_pane.myCNSI_pane.ones_numlbl.setText("");
			   					myCM_frame.myCM_pane.myCNSI_pane.num=1;
			   					myCM_frame.myCM_pane.myCNSI_pane.selectedNum=false;
				   		    	System.out.println("�`��:"+myFrame.mySO_pane.mySPI_panel.total);

  		    				}
  		    				
  		    			}
  		    	
   	                	   
  		    		}
  		    	};
   		    	 
   		    	 
   		      //�ƥ��ť�{��: ����
		      	 ActionListener ProcessMealsReSelection = new ActionListener(){
   		    		public void actionPerformed(ActionEvent e){
	   		         	if(e.getSource()==myCM_frame.myCM_pane.myCNSI_pane.rechBtn){
	    					   //�N���s�C��]�^�w�]���A
		            		for(int a=0;a<itemBtn.length;a++){
	            				for(int b=0;b<itemBtn[0].length;b++){	
	            					if((a+2)%2!=0)
	            						itemBtn[a][b].setBackground(new Color(255, 146, 20));
	            					else
	            						itemBtn[a][b].setBackground(new Color(255, 87, 87));		
	            					}
		            		}
			   		    	myCM_frame.myCM_pane.myCNSI_pane.MealIsInsert=true;	//��e����\�I�w�Q����,�����s�W

	    					//�N�\�I������A�]��false
	    					myCM_frame.myCM_pane.myCNSI_pane.MealIsSelected=false;
	    					myFrame.myMenu.MealIsSelected=false;
		   		         	myCM_frame.myCM_pane.myCNSI_pane.set_namelbl.setText("");
		   		         	myCM_frame.myCM_pane.myCNSI_pane.set_pricelbl.setText("");
		   		         	myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText("");
		   		      		myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.setText("");
		   		   			myCM_frame.myCM_pane.myCNSI_pane.ones_numlbl.setText("");
		   					myCM_frame.myCM_pane.myCNSI_pane.num=1;
		   					myCM_frame.myCM_pane.myCNSI_pane.selectedNum=false;
			   		        myFrame.myOR_pane.Check=true;										//�NCheck�]��false,�N���i���b

	   		         	}
   		    		}
   		    	};
   		    	/*--�[�J��ť�ƥ�--*/
  		    	 for(int x=0;x<myCM_frame.myCM_pane.myCNSI_pane.calBtn.length;x++){
		    	 		for(int y=0;y<myCM_frame.myCM_pane.myCNSI_pane.calBtn[0].length;y++){	
		    	 			myCM_frame.myCM_pane.myCNSI_pane.calBtn[x][y].addActionListener(ShowSubTotal);	//�Ʀr��[�J��ť�ƥ�
		    	 		}
  		    	 }	 
	  		   	ActionListener PressedBackbtn = new ActionListener(){
	  		        public void actionPerformed(ActionEvent e){
	  		        	if(e.getSource()==myCM_frame.myCM_pane.myCNSI_pane.backBtn){
	  		        		if(myCM_frame.myCM_pane.myCNSI_pane.MealIsInsert==true){
	  		        			myCM_frame.setVisible(false);
	  		        			myCM_frame.myCM_pane.myCNSI_pane.MealIsInsert=true;
	  		  		        	System.out.println("sssss");
	  		  		        	

	  		        		}
	  		        		else
	  		                    JOptionPane.showMessageDialog(null,"��e����\�I�|���s�W!");
	  		        	}
	  		        		
	  		        }
	  		    };
   		    	myCM_frame.myCM_pane.myCNSI_pane.rechBtn.addActionListener(ProcessMealsReSelection);		//��������s�[�J��ť�ƥ�
   		    	myCM_frame.myCM_pane.myCNSI_pane.chBtn.addActionListener(OrderCheck);	    				//���s�W���s�[�J��ť�ƥ�	 
   		    	myCM_frame.myCM_pane.myCNSI_pane.backBtn.addActionListener(PressedBackbtn);	    			//����^���s�[�J��ť�ƥ�	 

   		    	for(int x=0;x<myFrame.myOR_pane.mealBtn.length;x++){
		    	 		for(int y=0;y<myFrame.myOR_pane.mealBtn[0].length;y++){	
		    	 			if( e.getSource() == myFrame.myOR_pane.mealBtn[x][y] ){
		    	 				System.out.print(myFrame.myOR_pane.man_deal);
		    	 				if(myFrame.myOR_pane.man_deal==true){		            //true��ܥD�H�\�I�Q���
		    	 				   meals=myDBMA.findMEAL_in_TB_meal(class_no[x][y]);    //�d���I�����O���\�I���
		    	 				   changeLine(meals);	                                //�\�I���s��ܽվ�
		    	 				   myCM_frame.isOpen=true;
		    	 				   myCM_frame.setVisible(true);
			            	       //���ҧ�s
			            	       String []myTap=myDBMA.findClass_in_TB_class();	    //�d�ߩҦ�������'�D�H'�B���A��'�}��'�����O�W��,�æ^��
			            	       String []myTapCLSno=myDBMA.findClassNo_in_TB_class();//�d�ߩҦ�������'�D�H'�B���A��'�}��'�����O�s��,�æ^��
	
			            	       for(int z=0;z<myTap.length;z++){
			            	    	   if(myTap[z]==null){
			            	    		   break;       
			            	    	   }
			            	    	   pane[z]=new JPanel();
			            	    	   pane[z].setBounds(0,0,700,550);
			            	    	   pane[z].setLayout(new GridLayout(5,7));
			            	    	   
			            	    	   pp[z]=new JPanel();
			            	    	   pp[z].setBounds(0,0,700,550);
			            	    	   pp[z].setLayout(new GridLayout(5,7));		
			            	    	   pp[z].setVisible(false);
			            	    
				            	       myCM_frame.myCM_pane.myOM_pane.item_tabpanel.addTab(myTap[z],pane[z]);	//�[�J����

			            	       }//end for myFrame.myOR_pane.mealBtn[x][y].setEnabled(false);	//�N��Ʈw�{�����O��s��e�x

			            	       //�����P�_�i�J�����O,���o���O�s��,�ǤJ��Ʈw���o�W��,�N�����O�����\�I���
			            		   for(int a=0;a<itemBtn.length;a++){
		            					for(int b=0;b<itemBtn[0].length;b++){	
		            						itemBtn[a][b]=new JButton(meals[a][b]);
		            						itemBtn[a][b].setFont(new Font("������",0,16));
		            						itemBtn[a][b].addActionListener(ProcessMealsOrderSelection);

		            						if((a+2)%2!=0)
		            							itemBtn[a][b].setBackground(new Color(255, 146, 20));
		            						else
		            							itemBtn[a][b].setBackground(new Color(255, 87, 87));		
		            					//	pane[x+y].add(itemBtn[a][b]);
		            					}
			            		   }

			            	       /*�P�_�ӭ��ҬO�_�s�b,�Y�s�b�h���ܯS�w����,����ܨ�����\�I*/
			                       if(x==1){
			                    	   try{
			                    		   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y+4);	//��ܭ���
					            		   for(int a=0;a<itemBtn.length;a++){
				            					for(int b=0;b<itemBtn[0].length;b++){	
				            						pane[x+y+4].add(itemBtn[a][b]);
				            					}
					            		   }
			                    	   }catch(Exception e1){
			      	                	   JOptionPane.showMessageDialog(null,"�Ӯ�|���]�m���O,�Цܫ�x�s�W!");
			      	                 	   JOptionPane.showMessageDialog(null,">>�t�αN���z����'"+myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getTitleAt(0)+"'");		      	                 	 
					      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(0);	//��ܭ���
					      	     
			      	                   } 
			      	           	   }
			                       else if(x==2){
			                    	   try{
			                    		   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y+8);	//��ܭ���
					            		   for(int a=0;a<itemBtn.length;a++){
				            					for(int b=0;b<itemBtn[0].length;b++){	
				            						pane[x+y+8].add(itemBtn[a][b]);
				            					}
					            		   }
			      	                   }catch(Exception e1){
			      	                	   JOptionPane.showMessageDialog(null,"�Ӯ�|���]�m���O,�Цܫ�x�s�W!");
			      	                 	   JOptionPane.showMessageDialog(null,">>�t�αN���z����'"+myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getTitleAt(0)+"'");		      	                 	 
					      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(0);	//��ܭ���

			      	                   }
			      	           	   }
			                       else if(x==3){
			                    	   try{
			                    		   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y+12);	//��ܭ���
					            		   for(int a=0;a<itemBtn.length;a++){
				            					for(int b=0;b<itemBtn[0].length;b++){	
				            						pane[x+y+12].add(itemBtn[a][b]);
				            					}
					            		   }
			                    	   }catch(Exception e1){
			      	                	   JOptionPane.showMessageDialog(null,"�Ӯ�|���]�m���O,�Цܫ�x�s�W!");
			      	                 	   JOptionPane.showMessageDialog(null,">>�t�αN���z����'"+myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getTitleAt(0)+"'");		      	                 	 
					      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(0);	//��ܭ���

			      	                   }
			      	           	   }
			                       else{
				      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y);	//��ܭ���
				            		   for(int a=0;a<itemBtn.length;a++){
			            					for(int b=0;b<itemBtn[0].length;b++){	
			            						pane[x+y].add(itemBtn[a][b]);
			            					}
				            		   }
			                       }
			                       //��ť�ƥ�:�������Ҥ���
			            	       myCM_frame.myCM_pane.myOM_pane.item_tabpanel.addChangeListener(new ChangeListener() {
			    	 			        public void stateChanged(ChangeEvent e) {
			    	 			        	int num=myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getSelectedIndex();	//���o��e��ܭ��ү��ޭ�,�å��ܼ�num����
			    	 			        	String numStr=Integer.toString(num); 										//�N���num�ର�r��,�ó]�w��numStr
			    	 			        	String [][]new_meals=myDBMA.findMEAL_in_TB_meal(myTapCLSno[num]);			//�ǤJ�@�����O�s���ܸ�Ʈw����findMEAL_in_TB_meal()��k,�æ^�Ǥ@���\�I�W�ٸ��
			    	 			        	 for(int a=0;a<itemBtn.length;a++){//���s�]�w�\�I�W��
					            					for(int b=0;b<itemBtn[0].length;b++){	
					            						System.out.println("�ǤJ�e���:"+new_meals[a][b]);
						            						changeLine(new_meals);	//�ǤJ�@���\�I�W��,�P�_�O�_�ݭn����						            					
						            						if(itemBtn[a][b].getText()!="")
							            						System.out.println("���s�W���:"+new_meals[a][b]);
						            					itemBtn[a][b].setText(new_meals[a][b]);
					            						pp[num].add(itemBtn[a][b]);	//�N���s�[�Jpp(JPanel)
					            					}
			    	 			        	 }
			    	 			        	pp[num].setVisible(true);	//�Npp�]�����
						                    myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setComponentAt(num,pp[num]);//��s����

			    	 			        }
			    	 			    });			      	           	   
			                    }//end if(myFrame.myOR_pane.man_deal==true)
		    	 				

		    	 				else {	//false����d���\�I �Q���
		    	 					   meals=myDBMA.findMEAL_in_TB_meal(class_no_pet[x][y]);//�d���I�����O���\�I���
		    	 				       changeLine(meals);	                                //�\�I���s��ܽվ�
			    	 			//	   CHCI_CM_frame myCM_frame=new CHCI_CM_frame(); 
			    	 				   myCM_frame.isOpen=true;
			    	 				   myCM_frame.setVisible(true);
				            	       String []myTap=myDBMA.findClassPet_in_TB_class();	
				            	       String []myTapCLSno_pet=myDBMA.findClassNoOfPet_in_TB_class();//�d�ߩҦ�������'�d��'�B���A��'�}��'�����O�s��,�æ^��				            	       
				            	       for(int z=0;z<myTap.length;z++){
				            	    	   if(myTap[z]==null)
				            	    		   break;     
				            	    	   pane[z]=new JPanel();
				            	    	   pane[z].setBounds(0,0,700,550);
				            	    	   pane[z].setLayout(new GridLayout(5,7));
				            	    	   
				            	    	   pp[z]=new JPanel();
				            	    	   pp[z].setBounds(0,0,700,550);
				            	    	   pp[z].setLayout(new GridLayout(5,7));		
				            	    	   pp[z].setVisible(false);

					            	       myCM_frame.myCM_pane.myOM_pane.item_tabpanel.addTab(myTap[z],pane[z]);
				            	       }
			            			   for(int a=0;a<itemBtn.length;a++){
			            					for(int b=0;b<itemBtn[0].length;b++){	
			            				 		System.out.println("�d���\�I"+meals[a][b]);
			            				 		itemBtn[a][b]=new JButton(meals[a][b]);
			            				 		itemBtn[a][b].setFont(new Font("������",0,16));		
			            						itemBtn[a][b].addActionListener(ProcessMealsOrderSelection);
			            				 		if((a+2)%2!=0)
			            				 			itemBtn[a][b].setBackground(new Color(255, 146, 20));
			            						else
			            							itemBtn[a][b].setBackground(new Color(255, 87, 87));		
			            						//pane[z].add(itemBtn[a][b]);
			            					}
			            			   }
			   
				            	       /*�P�_�ӭ��ҬO�_�s�b,�Y�s�b,���ܯS�w����*/
				                       if(x==1){
				                    	   try{
				                    		   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y+4);	//��ܭ���
					            			   for(int a=0;a<itemBtn.length;a++){
					            					for(int b=0;b<itemBtn[0].length;b++){	
					            						pane[x+y+4].add(itemBtn[a][b]);
					            					}
					            			   }     
				                    	   }catch(Exception e1){
				      	                	   JOptionPane.showMessageDialog(null,"�Ӯ�|���]�m���O,�Цܫ�x�s�W!");
				      	                 	   JOptionPane.showMessageDialog(null,">>�t�αN���z����'"+myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getTitleAt(0)+"'");		      	                 	 
						      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(0);	//��ܭ���

				      	                   } 
				      	           	   }
				                       else if(x==2){
				                    	   try{
				                    		   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y+8);	//��ܭ���
					            			   for(int a=0;a<itemBtn.length;a++){
					            					for(int b=0;b<itemBtn[0].length;b++){	
					            						pane[x+y+8].add(itemBtn[a][b]);
					            					}
					            			   }     
				                    	   }catch(Exception e1){
				      	                	   JOptionPane.showMessageDialog(null,"�Ӯ�|���]�m���O,�Цܫ�x�s�W!");
				      	                 	   JOptionPane.showMessageDialog(null,">>�t�αN���z����'"+myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getTitleAt(0)+"'");		      	                 	 
						      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(0);	//��ܭ���

				      	                   }
				      	           	   }
				                       else if(x==3){
				                    	   try{
				                    		   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y+12);	//��ܭ���
					            			   for(int a=0;a<itemBtn.length;a++){
					            					for(int b=0;b<itemBtn[0].length;b++){	
					            						pane[x+y+12].add(itemBtn[a][b]);
					            					}
					            			   }     
				                    	   }catch(Exception e1){
				      	                	   JOptionPane.showMessageDialog(null,"�Ӯ�|���]�m���O,�Цܫ�x�s�W!");
				      	                 	   JOptionPane.showMessageDialog(null,">>�t�αN���z����'"+myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getTitleAt(0)+"'");		      	                 	 
						      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(0);	//��ܭ���

				      	                   }
				      	           	   }
				                       else{
					      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y);	//��ܭ���
				            			   for(int a=0;a<itemBtn.length;a++){
				            					for(int b=0;b<itemBtn[0].length;b++){	
				            						pane[x+y].add(itemBtn[a][b]);
				            					}
				            			   }     
				                       }
				            	       myCM_frame.myCM_pane.myOM_pane.item_tabpanel.addChangeListener(new ChangeListener() {
				    	 			        public void stateChanged(ChangeEvent e) {
				    	 			        	int num=myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getSelectedIndex();	//���o��e��ܭ��ү��ޭ�,�å��ܼ�num����
				    	 			        	String numStr=Integer.toString(num); //�N���num�ର�r��,�ó]�w��numStr
				    	 			        	String [][]new_meals=myDBMA.findMEAL_in_TB_meal(myTapCLSno_pet[num]);//�ǤJ�@�����O�s���ܸ�Ʈw����findMEAL_in_TB_meal()��k,�æ^�Ǥ@���\�I�W�ٸ��
				    	 			        	for(int a=0;a<itemBtn.length;a++){//���s�]�w�\�I�W��
						            					for(int b=0;b<itemBtn[0].length;b++){	
						            					//	System.out.print(new_meals[a][b]);
						            						changeLine(new_meals);	//�ǤJ�@���\�I�W��,�P�_�O�_�ݭn����
						            						itemBtn[a][b].setText(new_meals[a][b]);
						            						pp[num].add(itemBtn[a][b]);	//�N���s�[�Jpp(JPanel)
						            					}
				    	 			        	 }
				    	 			        	pp[num].setVisible(true);	//�Npp�]�����
							                    myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setComponentAt(num,pp[num]);//��s����

				    	 			        }
				    	 			    });
		    	 				}//end else
		    	 			}// end if(e.getSource()....)
		    	 		}//end mealBtn[][]....
		    	 }

	         }    
	
	     };

	     //��k:�إ����O���s(�w�]��ܥD�H�\�I)
	     void setClassBtn(){
        	 String [][]classTxt=new String[4][5];
        	 classTxt=myDBMA.findRD_in_TB_class();
	    	 for(int x=0;x<myFrame.myOR_pane.mealBtn.length;x++){
	    		 for(int y=0;y<myFrame.myOR_pane.mealBtn[0].length;y++){	
					myFrame.myOR_pane.mealBtn[x][y].setEnabled(true);							//���s�w�]���i�I��
	    	 		myFrame.myOR_pane.mealBtn[x][y].setText(classTxt[x][y]);	//�N��Ʈw�{�����O��s��e�x
					if(myFrame.myOR_pane.mealBtn[x][y].getText()==null)			//�Y���O����,�N���ѤU�����s�]�����i�I��
							myFrame.myOR_pane.mealBtn[x][y].setEnabled(false);
	    	 		myFrame.myOR_pane.mealBtn[x][y].setFont(new Font("������",0,16));	
	    	 	 }
	    	 }
	     }
	     //��k:���o�e�x�D�H���O���s��,�æ^��
	     String[][] get_man_in_front_ClassNo(){
	    	 String [][]class_man_No=new String[4][5];
	    	 class_man_No=myDBMA.findClass_man_NO_in_TB_class();
	    	 for(int x=0;x<class_man_No.length;x++){
	    		 for(int y=0;y<class_man_No[0].length;y++){	
	    			 System.out.println(class_man_No[x][y]);
	    	 	 }
	    	 }
	    	 return class_man_No;
	     }
	     //��k:���o�e�x�D�H���O���s��,�æ^��
	     String[][] get_pet_in_front_ClassNo(){
	    	 String [][]class_pet_No=new String[4][5];
	    	 class_pet_No=myDBMA.findClass_pet_NO_in_TB_class();
	    	 for(int x=0;x<class_pet_No.length;x++){
	    		 for(int y=0;y<class_pet_No[0].length;y++){	
	    			 System.out.println(class_pet_No[x][y]);
	    	 	 }
	    	 }
	    	 return class_pet_No;
	     }
	     //��k:�[�J���O���s��ť�ƥ�
	     void setClassBtnPressed(){
	    	 for(int x=0;x<myFrame.myOR_pane.mealBtn.length;x++){
	    		 for(int y=0;y<myFrame.myOR_pane.mealBtn[0].length;y++){	
	    			myFrame.myOR_pane.mealBtn[x][y].addActionListener(ProcessMealsSelection);  //[�s�W�\�I]�ާ@�e����[�D�H�\�I-�\�I���O]���s
	    	 	 }
	    	 }
	     }

/*------------------------------------*/
/*       �� �� �B  �z                                                      */
/*------------------------------------*/
	     //�ƥ��ť�{��: �B�z���O����x�s
	     public ActionListener ProcessSaveClassRecord = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	              
	              boolean checkPass = true;      //�ΨӰO��[��J�����O���]�ˬd���G
	              String noStr = myFrame.myMM_pane.myMMO_pane.myAC_pane.notxt.getText().trim();      //���o[���O�s�����]����[�s���r��]
	              String dateStr = myFrame.myMM_pane.myMMO_pane.myAC_pane.datatxt.getText().trim();  //���o[���O������]����[����r��]
	              String nameStr = myFrame.myMM_pane.myMMO_pane.myAC_pane.nametxt.getText().trim();  //���o[��J�����O�W��]����[�W�٦r��] 
	              String kindStr = myFrame.myMM_pane.myMMO_pane.myAC_pane.kindStr;  				 //���o[��J�����O����]����[�����r��]
	              String stateStr = myFrame.myMM_pane.myMMO_pane.myAC_pane.stateStr;				 //���o[��J�����O���A]����[���A�r��] 
	              String noteStr = myFrame.myMM_pane.myMMO_pane.myAC_pane.notetxt.getText().trim();  //���o[��J�����O�Ƶ�]����[�Ƶ��r��] 
	              
	              if(  nameStr.length() == 0 ){    //�ˬdnameString�O�_����J����r��,length()���p��r����פ�k,�Y���׬�0�h����J���
	                     checkPass = false;
	                     JOptionPane.showMessageDialog(null,"[�W��] ���o���ť�!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
	              }              
	              if(  nameStr.length() > 4 ){    //�ˬdnameString�O�_�W�L4
	                     checkPass = false;
	                     JOptionPane.showMessageDialog(null,"[�W��] ���o�j��4","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
	              }     
	              if(  noteStr.length() == 0 ){    //�ˬdnoteStr�O�_����J����r��,length()���p��r����פ�k,�Y���׬�0�h����J���
	            	  	 noteStr = "�L";		//�N�Ƶ��]��"�L"
	              }	              
	              		if( checkPass == true ){
	                    myClass.setNo(noStr);
	                    myClass.setDate(dateStr);
	                    myClass.setName(nameStr);
	                    myClass.setKind(kindStr);
	                    myClass.setState(stateStr);
	                    myClass.setNote(noteStr);
	                    myDBMA.insertRD_into_TB_class(myClass);   //�N���O����ǤJ[��Ʈw�ާ@�s������(myDBMA)]���x�s���O������k(insertRD_into_TB_class())�h�x�s���O�������Ʈw
	                    System.out.print(myFrame.myMM_pane.myMMO_pane.myAC_pane.notxt.getText());     
	                    myFrame.myMM_pane.myMMO_pane.myAC_pane.setNewNo();      	//��s���O�s��
	                    myFrame.myMM_pane.myMMO_pane.myAC_pane.initialize_Filed();  //��l�����O���
	                    myFrame.myMM_pane.myMMO_pane.myAC_pane.setClassDate();      //��s�t�Τ��
	              }

	         }    
	     };
	     //�ƥ��ť�{��: �B�z��s/�ק��,��s�e�x���O������
	     public ActionListener ProcessUpdata = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	 if(e.getSource()== myFrame.myOR_pane.manBtn){
	            	 String [][]classTxt=new String[4][5];
	            	 classTxt=myDBMA.findRD_in_TB_class();
	    	    	 for(int x=0;x<myFrame.myOR_pane.mealBtn.length;x++){
	    	    		 for(int y=0;y<myFrame.myOR_pane.mealBtn[0].length;y++){	
							myFrame.myOR_pane.mealBtn[x][y].setEnabled(true);							//���s�w�]���i�I��
	    	    	 		myFrame.myOR_pane.mealBtn[x][y].setText(classTxt[x][y]);					//�N��Ʈw�{�����O��s��e�x
	    					if(myFrame.myOR_pane.mealBtn[x][y].getText()==null)							//�Y���O����,�N���ѤU�����s�]�����i�I��
								myFrame.myOR_pane.mealBtn[x][y].setEnabled(false);
	    	    	 		myFrame.myOR_pane.mealBtn[x][y].setFont(new Font("������",0,16));	
	    	    	 		myFrame.myOR_pane.man_deal = true;											//true��ܥD�H�\�I�Q���
	    	    	 	 }
	    	    	 }
	        	 }
	        	 if(e.getSource()== myFrame.myOR_pane.petBtn){
	            	 String [][]classTxt=new String[4][5];
	            	 classTxt=myDBMA.find_PET_CLASS_in_TB_class();
	    	    	 for(int x=0;x<myFrame.myOR_pane.mealBtn.length;x++){
	    	    		 for(int y=0;y<myFrame.myOR_pane.mealBtn[0].length;y++){	
							myFrame.myOR_pane.mealBtn[x][y].setEnabled(true);							//���s�w�]���i�I��
	    	    	 		myFrame.myOR_pane.mealBtn[x][y].setText(classTxt[x][y]);					//�N��Ʈw�{�����O��s��e�x
	    					if(myFrame.myOR_pane.mealBtn[x][y].getText()==null)							//�Y���O����,�N���ѤU�����s�]�����i�I��
								myFrame.myOR_pane.mealBtn[x][y].setEnabled(false);	
	    	    	 		myFrame.myOR_pane.mealBtn[x][y].setFont(new Font("������",0,16));	
	    	    	 		myFrame.myOR_pane.man_deal = false;		//false����d���\�I�Q���

	    	    		 }
	    	    	 }
	        	 }
	         }    
	     };
	     //�ƥ��ť�{��: �B�z���O�d�߸��
	     public ActionListener ProcessQueryClassRecord = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	    if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.kindSelected==true){//���"�d�����O"�Q���
		        	    	System.out.println("��F�d�����O}:");
		        	 	if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.second==true){//�P�_�ϥΪ̬O�_����ĤG�ӱ���d�� 
			    		    myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;//�N�ܼƳ]��false,����U�d�߮����������ܤ�k�_�h�|�X��
				    		myFrame.myMM_pane.myMMO_pane.myEM_pane.getenable=false;	  //�N�ܼƳ]��false,����U�d�߮����������ܤ�k�_�h�|�X��

			    		    String query1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_class_jcb.getSelectedItem().toString();//���o[����d��1]����[���d�߸��]
			        	 	String log1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedItem().toString();      //���o[����d��1]����[�޿�d�߸��]
			        	 	String cond1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.cond1txt.getText().trim();                  //���o[����d��1]����[�ϥΪ̿�J�����]
			        	 	String and_or=myFrame.myMM_pane.myMMQ_pane.myQM_pane.quAnd_Orjcb.getSelectedItem().toString();  //���o[����d��1_2]��[�޿�B��]
		 	        	 	String query2=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_class_jcb.getSelectedItem().toString();//���o[����d��2]����[���d�߸��]
			        	 	String log2=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog3jcb.getSelectedItem().toString();      //���o[����d��2]����[�޿�d�߸��]
			        	 	String cond2=myFrame.myMM_pane.myMMQ_pane.myQM_pane.cond2txt.getText().trim();                  //���o[����d��2]����[�ϥΪ̿�J�����]
	
			        	 	//�ϥΪ̱���1�P�_
			        	 	if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_class_jcb.getSelectedIndex()==1){
			        	 		query1="CLS_name";
			        	 		int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
				        	 	if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
				        	 	if(  log1_num==1)	log1="<>";
				        	
			        	 	}
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_class_jcb.getSelectedIndex()==2){
			        	 		query1="CLS_Kind";
			        	 		int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
				        	 	if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
				        	 	if(  log1_num==1)	log1="<>";
			        	 	}
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_class_jcb.getSelectedIndex()==3){
			        	 		query1="CLS_Date";
			        	 		int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedIndex();	
				        	 	if(  log1_num==0 )	log1=">";
				        	 	if(  log1_num==1)	log1="<";
				        	 	if(  log1_num==2)	log1="=";        	 	
			        	 	}
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_class_jcb.getSelectedIndex()==4){
			        	 		query1="CLS_State";
			        	 		int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
				        	 	if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
				        	 	if(  log1_num==1)	log1="<>";
			        	 	}	 
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_class_jcb.getSelectedIndex()==5){
			        	 		query1="CLS_Note";
			        	 		int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
				        	 	if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
				        	 	if(  log1_num==1)	log1="<>";
			        	 	}
			        	 	else{
			        	 		query1="CLS_No";
			        	 		int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedIndex();	
				        	 	if(  log1_num==0 )	log1=">";
				        	 	if(  log1_num==1)	log1="<";
				        	 	if(  log1_num==2)	log1="=";    
			        	 	}
			        	 	//�ϥΪ̱���2�P�_
			        	 	if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_class_jcb.getSelectedIndex()==1){
			        	 		query2="CLS_name";
			        	 		int log2_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog4jcb.getSelectedIndex();	
				        	 	if(  log2_num==0 )	{log2=" like"; cond2="%"+cond2+"%";}
				        	 	if(  log2_num==1)	log2="<>";
				        	
			        	 	}
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_class_jcb.getSelectedIndex()==2){
			        	 		query2="CLS_Kind";
			        	 		int log2_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog4jcb.getSelectedIndex();	
				        	 	if(  log2_num==0 )	{log2=" like"; cond2="%"+cond2+"%";}
				        	 	if(  log2_num==1)	log2="<"+">";
			        	 	}
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_class_jcb.getSelectedIndex()==3){
			        	 		query2="CLS_Date";
			        	 		int log2_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog3jcb.getSelectedIndex();	
				        	 	if(  log2_num==0 )	log2=">";
				        	 	if(  log2_num==1)	log2="<";
				        	 	if(  log2_num==2)	log2="=";        	 	
			        	 	}
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_class_jcb.getSelectedIndex()==4){
			        	 		query2="CLS_State";
			        	 		int log2_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog4jcb.getSelectedIndex();	
				        	 	if(  log2_num==0 )	{log2=" like"; cond2="%"+cond2+"%";}
				        	 	if(  log2_num==1)	log2="<>";
			        	 	}	 
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_class_jcb.getSelectedIndex()==5){
			        	 		query2="CLS_Note";
			        	 		int log2_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog4jcb.getSelectedIndex();	
				        	 	if(  log2_num==0 )	{log2=" like"; cond2="%"+cond2+"%";}
				        	 	if(  log2_num==1)	log2="<>";
			        	 	}
			        	 	else{
			        	 		query2="CLS_No";
			        	 		int log2_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog3jcb.getSelectedIndex();	
				        	 	if(  log2_num==0 )	log2=">";
				        	 	if(  log2_num==1)	log2="<";
				        	 	if(  log2_num==2)	log2="=";    
			        	 	}
			        	 	//and or�P�_
			        	 	if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.quAnd_Orjcb.getSelectedIndex()==0)//and
			        	 		and_or=" AND ";
			        	 	else
			        	 		and_or=" OR ";
			        	 	
			        	 	//�ϥΦh�d�߱���
			        	 	if(  cond1.length() > 0 ){//�p�G[�ϥΪ̿�J�����1]���פj��0,�Y����J����r���,�~�i�J�d�߳B�z
				        	 	if(cond2.length() > 0 ){//�p�G[�ϥΪ̿�J�����2]���פj��0,�Y����J����r���,�~�i�J�d�߳B�z
				        	 		ClearClassTable();
				        	 		String [][]myQuery=myDBMA.findCLass2_in_TB_class(query1,log1,cond1,and_or,query2,log2,cond2);
				        	 		//�N�d�ߵ��G�g�JJTable
				        	 		for(int x=0;x<myQuery.length;x++){
				        	 			//�N��Ƽg�JJTable
						                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.addRow(new Object[]{myQuery[x][0],myQuery[x][1]
						                		,myQuery[x][2],myQuery[x][3],myQuery[x][4],myQuery[x][5]});	//�N[�d�ߵ��G]�g�JJTable
						                //��sJTable �����e
						                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.fireTableDataChanged();	
					                    myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.updateUI();
				        	 		}
				        	 	}
				        	 	else JOptionPane.showMessageDialog(null,"[�d�����2]�ťե���J��ơA�ж�g��A�d��!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
				        	 	
			        	 	}
			        	 	else JOptionPane.showMessageDialog(null,"[�d�����1]�ťե���J��ơA�ж�g��A�d��!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
			        	 	
		        	 	}
		        	 	else{//�ϥΪ̨ϥγ�@�d�߱���
			        	 	String query1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_class_jcb.getSelectedItem().toString();//���o[����d��1]����[���d�߸��]
			        	 	String log1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedItem().toString();      //���o[����d��1]����[�޿�d�߸��]
			        	 	String cond1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.cond1txt.getText().trim();                  //���o[����d��1]����[�ϥΪ̿�J�����]        	 		
			    		    myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;	//�N�ܼƳ]��false,����U�d�߮����������ܤ�k�_�h�|�X��
				    		myFrame.myMM_pane.myMMO_pane.myEM_pane.getenable=false;	  //�N�ܼƳ]��false,����U�d�߮����������ܤ�k�_�h�|�X��

			    		    if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_class_jcb.getSelectedIndex()==1){
			        	 		query1="CLS_name";
			        	 		int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
				        	 	if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
				        	 	if(  log1_num==1)	log1="<>";
				        	
			        	 	}
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_class_jcb.getSelectedIndex()==2){
			        	 		query1="CLS_Kind";
			        	 		int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
				        	 	if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
				        	 	if(  log1_num==1)	log1="<>";
			        	 	}
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_class_jcb.getSelectedIndex()==3){
			        	 		query1="CLS_Date";
			        	 		int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedIndex();	
				        	 	if(  log1_num==0 )	log1=">";
				        	 	if(  log1_num==1)	log1="<";
				        	 	if(  log1_num==2)	log1="=";        	 	
			        	 	}
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_class_jcb.getSelectedIndex()==4){
			        	 		query1="CLS_State";
			        	 		int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
				        	 	if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
				        	 	if(  log1_num==1)	log1="<>";
			        	 	}	 
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_class_jcb.getSelectedIndex()==5){
			        	 		query1="CLS_Note";
			        	 		int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
				        	 	if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
				        	 	if(  log1_num==1)	log1="<>";
			        	 	}
			        	 	else{
			        	 		query1="CLS_No";
			        	 		int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedIndex();	
				        	 	if(  log1_num==0 )	log1=">";
				        	 	if(  log1_num==1)	log1="<";
				        	 	if(  log1_num==2)	log1="=";    
			        	 	}
			        	 		
			        	 	if(  cond1.length() > 0 ){//�p�G[�ϥΪ̿�J�����]���פj��0,�Y����J����r���,�~�i�J�d�߳B�z
			        	 		ClearClassTable();
			        	 		String [][]myQuery=myDBMA.findCLass_in_TB_class(query1,log1,cond1);   //�I�s[��Ʈw�ާ@�s������(myDBMA)]���d�߾ǥͬ�����k(findCLass_in_TB_class())�h�d�����O����,�æ^���x�s��myQuery��
			        	 		//�N�d�ߵ��G�g�JJTable
			        	 		for(int x=0;x<myQuery.length;x++){
			        	 			//�N��Ƽg�JJTable
					                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.addRow(new Object[]{myQuery[x][0],myQuery[x][1]
					                		,myQuery[x][2],myQuery[x][3],myQuery[x][4],myQuery[x][5]});	//�N[�d�ߵ��G]�g�JJTable
					                //��sjtable �����e
					                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.fireTableDataChanged();	
				                    myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.updateUI();
			        	 		}
			        	 	}
			        	 	else{
			                    JOptionPane.showMessageDialog(null,"[�d�����1]�ťե���J��ơA�ж�g��A�d��!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
			        	 	}
			            }
	        	 }
	        }

	     };
	     
	     //��k:�M��class���
	     void ClearClassTable(){
	      	   try{
	    	        myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.setRowCount(0);
	    	    	myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.fireTableDataChanged();
	            }catch(Exception e1){
	            	   JOptionPane.showMessageDialog(null,"��Ƥw��s!");	//�o�ͤ������~!
	            } 
	     }
	     //��k:�M��meal���
	     void ClearMealTable(){
	      	   try{
	    	        myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.setRowCount(0);
	    	    	myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.fireTableDataChanged();
	            }catch(Exception e1){
	            	   JOptionPane.showMessageDialog(null,"��Ƥw��s!");	//�o�ͤ������~!
	            } 
	     }
	     //��k:�d�̷߳s10�����O���,����ܦbclass���
	     void SelectedLastClassTable(){
 	 		ClearClassTable();
 	 		String[][] myQuery=myDBMA.find_all_CLass_in_TB_class();  //�d�߫e10����Ƥ�k()
 	 		//�N�d�ߵ��G�g�JJTable
 	 		for(int x=0;x<myQuery.length;x++){
 	 			//�N��Ƽg�JJTable
	                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.addRow(new Object[]{myQuery[x][0],myQuery[x][1]
	                		,myQuery[x][2],myQuery[x][3],myQuery[x][4],myQuery[x][5]});	//�N[�d�ߵ��G]�g�JJTable
	                //��sjtable �����e
	                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.fireTableDataChanged();	
                    myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.updateUI();
 	 		}
	     }
	     //��k:�d�̷߳s10���\�I���,����ܦbmeal���
	     void SelectedLastMealTable(){
 			ClearMealTable();
 	 		String[][] myQuery=myDBMA.find_all_MEal_in_TB_meal();  //�d�߫e10����Ƥ�k()
 	 		//�N�d�ߵ��G�g�JJTable
	 		for(int x=0;x<myQuery.length;x++){
	 			//�N��Ƽg�JJTable
                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.addRow(new Object[]{myQuery[x][0],myQuery[x][1]
                		,myQuery[x][2],myQuery[x][3],myQuery[x][4],myQuery[x][5],myQuery[x][6],myQuery[x][7],myQuery[x][8]});	//�N[�d�ߵ��G]�g�JJTable
                //��sJTable �����e
                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.fireTableDataChanged();	
                myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.updateUI();
	 		}
	     }
	     //��k:�N��e��������O�������ܦb�k��[�s�����O]���U�����
	     public void ShowEditClassRecord(){
	     		 String str1,str2;
	        	 myFrame.myMM_pane.myMMO_pane.myEC_pane.notxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectedRow(), 0).toString());
	        	 //���o[�إߤ��]���,��ܦb���W
	        	 myFrame.myMM_pane.myMMO_pane.myEC_pane.datatxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectedRow(), 1).toString());
	        	 //���o[���O�W��]���,��ܦb���W
	        	 myFrame.myMM_pane.myMMO_pane.myEC_pane.nametxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectedRow(), 2).toString());
	        	 //���o[���O����]���
	        	 str1=myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(  myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectedRow(), 3).toString();
	        	 //���o[���O���A]���
	        	 str2=myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt( myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectedRow(), 4).toString();
	        	 if(str1.indexOf("�D�H")>-1){	//�ϥ�indexOf() �j�M�r��O�_�a��"�D�H"
					str1="�D�H";
					myFrame.myMM_pane.myMMO_pane.myEC_pane.ckradio[0].setSelected(true);
					myFrame.myMM_pane.myMMO_pane.myEC_pane.ckradio[1].setSelected(false);		
	 		     }
				 else{
					str1="�d��";
					myFrame.myMM_pane.myMMO_pane.myEC_pane.ckradio[1].setSelected(true);
					myFrame.myMM_pane.myMMO_pane.myEC_pane.ckradio[0].setSelected(false);		
				 }
	 		     if(str2.indexOf("�}��")>-1){	//�ϥ�indexOf() �j�M�r��O�_�a��"�}��"
					str2="�}��";
					myFrame.myMM_pane.myMMO_pane.myEC_pane.csradio[0].setSelected(true);
					myFrame.myMM_pane.myMMO_pane.myEC_pane.csradio[1].setSelected(false);		
	 		     }
				 else{
					str2="����";
					myFrame.myMM_pane.myMMO_pane.myEC_pane.csradio[1].setSelected(true);
					myFrame.myMM_pane.myMMO_pane.myEC_pane.csradio[0].setSelected(false);		
				 }
	 		     //���o[�Ƶ�]���
	        	 myFrame.myMM_pane.myMMO_pane.myEC_pane.notetxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectedRow(), 5).toString());	         
	     }
	     //��k:�N��e������������ܦb�k�����[�s���\�I]���U�����
	     public void ShowEditOfMealRecord(){
     		 String str_meal_no,str_kind,str_class,str_marterial,str_state;
     		 str_meal_no="MEAL0120151028001";
     		 str_class="CLS0120150202001";
     		 str_marterial="MI0120151003001";
     		 str_meal_no="MEAL0120151028001";
	    	 //���o[�\�I�s��]���,��ܦb���W
        	 myFrame.myMM_pane.myMMO_pane.myEM_pane.notxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 0).toString());
     		 str_meal_no=myFrame.myMM_pane.myMMO_pane.myEM_pane.notxt.getText();
     		//���o[�إߤ��]���,��ܦb���W
        	 myFrame.myMM_pane.myMMO_pane.myEM_pane.datetxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 3).toString());
        	//���o[�\�I�W��]���,��ܦb���W
        	 myFrame.myMM_pane.myMMO_pane.myEM_pane.nametxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 1).toString());
        	 //���o[�\�I���O�s��]���
        	 str_class=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 2).toString();	
        	 //���o[�\�I���ƦW��]���
        	 str_marterial=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 4).toString();
        	 //���o[�\�I���A]���
        	 str_state=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 6).toString();
        	 //���o[����]���
        	 myFrame.myMM_pane.myMMO_pane.myEM_pane.pricetxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 5).toString());	  
        	 //���o[���ƺ���]���
        	 str_marterial=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 7).toString();
        	 //���o[���ƺ���]���
        	 str_kind=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 8).toString();
        	 //���o��e���[�\�I�����O����](�D�Hor�d��)
        	 //str_kind=myDBMA.findClasskind_forMeals_in_TB_class(str_meal_no);///~~~~
        	 //��e����\�I�����O����(�D�Hor�d��)�ó]�w[�\�I����]��ܶs���A(�D�H���d��)
        	 if(str_kind.indexOf("�D�H")>-1){	//�ϥ�indexOf() �j�M�r��O�_�a��"�D�H"				
				myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[0].setSelected(true);
				myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[1].setSelected(false);		
 		     }
			 else{
				myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[1].setSelected(true);
				myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[0].setSelected(false);		
			 }
        	 //���o��e����\�I�����O����(�c��or����)
        	// str_state=myDBMA.findMealState_forMeals_in_TB_class(str_meal_no);///~~
        	 //��e����\�I�����O����(�c��or����)�ó]�w[�\�I����]��ܶs���A(�D�H���d��)
        	 if(str_state.indexOf("�c��")>-1){	//�ϥ�indexOf() �j�M�r��O�_�a��"�}��"
        		 str_state="�c��";
        		 myFrame.myMM_pane.myMMO_pane.myEM_pane.msradio[0].setSelected(true);
        		 myFrame.myMM_pane.myMMO_pane.myEM_pane.msradio[1].setSelected(false);		
        	 }
        	 else{
        		 str_state="����";
        		 myFrame.myMM_pane.myMMO_pane.myEM_pane.msradio[1].setSelected(true);
        		 myFrame.myMM_pane.myMMO_pane.myEM_pane.msradio[0].setSelected(false);		
        	 } 
 		     //�̾ڷ�e�\�I�������O,��ܦb�U�Ԧ����W
 		     myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.removeAll();
 		     update_MealOfClass();//��s���O���
 	//	     String setClassItem=myDBMA.findClassno_forMeals_in_TB_class(str_class);//a
 		     System.out.println(str_class);//999
 		     myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.setSelectedItem(str_class);
 		     myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.updateUI();
 		     
 		     //�̾ڷ�e�\�I�ҨϥΪ���,��ܦb�U�Ԧ����W
		     	//�P�_�\�I�O�_���ϥΪ���
		     myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.removeAll();
		     if(str_marterial.indexOf("�L")>-1){	//�ϥ�indexOf() �j�M�r��O�_�a��"�L"		
	 		     myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.setSelectedIndex(0);	//�����U�Ԧ����"�L"
		     }	 		     
		     else{//��ܨϥΪ��ƺ���type
		    	 //�d�߸Ӫ��Ƥ������r��
		    //	 String MaterialType=myDBMA.findMaterialType_in_TB_mi(str_marterial);	//���o���ƺ���(TYPE)
		    //	 String MaterialName=myDBMA.findMaterialName_in_TB_mi(str_marterial);
		    	 //jcb����Ӫ��ƺ����U�Ԧ����
	 		     myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.setSelectedItem(str_marterial);
		    	 //jcb����Ӫ���
	 		     myFrame.myMM_pane.myMMO_pane.myEM_pane.material_jcb.setSelectedItem(str_marterial);
		     }        	 
	     }
	     
	     //�ƥ��ť�{��: �B�z���O��ƭק�(��s)
	     public ActionListener ProcessReviseClassRecord = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	  myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;//�N�ܼƳ]��false,����U�d�߮����������ܤ�k�_�h�|�X��
	    		  myFrame.myMM_pane.myMMO_pane.myEM_pane.getenable=false;	  //�N�ܼƳ]��false,����U�d�߮����������ܤ�k�_�h�|�X��

	        	  boolean checkPass = true;      //�ΨӰO��[��J�����O���]�ˬd���G
	              String noStr = myFrame.myMM_pane.myMMO_pane.myEC_pane.notxt.getText().trim();      //���o[���O�s�����]����[�s���r��]
	              String dateStr = myFrame.myMM_pane.myMMO_pane.myEC_pane.datatxt.getText().trim();  //���o[���O������]����[����r��]
	              String nameStr = myFrame.myMM_pane.myMMO_pane.myEC_pane.nametxt.getText().trim();  //���o[��J�����O�W��]����[�W�٦r��] 
	              String kindStr = myFrame.myMM_pane.myMMO_pane.myEC_pane.kindStr;  				 //���o[��J�����O����]����[�����r��]
	              String stateStr = myFrame.myMM_pane.myMMO_pane.myEC_pane.stateStr;				 //���o[��J�����O���A]����[���A�r��] 
	              String noteStr = myFrame.myMM_pane.myMMO_pane.myEC_pane.notetxt.getText().trim();  //���o[��J�����O�Ƶ�]����[�Ƶ��r��] 
	              
	              if(  nameStr.length() == 0 ){    //�ˬdnameString�O�_����J����r��,length()���p��r����פ�k,�Y���׬�0�h����J���
	                     checkPass = false;
	                     JOptionPane.showMessageDialog(null,"[�W��] ���o���ť�!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
	              }                         
	              if(  noteStr.length() == 0 ){    //�ˬdnoteStr�O�_����J����r��,length()���p��r����פ�k,�Y���׬�0�h����J���
	            	  	 noteStr = "�L";		//�N�Ƶ��]��"�L"
	              }	              
	              if( checkPass == true ){
	                    myClass.setNo(noStr);
	                    myClass.setDate(dateStr);
	                    myClass.setName(nameStr);
	                    myClass.setKind(kindStr);
	                    myClass.setState(stateStr);
	                    myClass.setNote(noteStr);
	        	 		ClearClassTable();
	                    myDBMA.updateClass_in_TB_class(myClass);  //�ǤJ�@��[���O���]
	        	 		ClearClassTable();	//�M�Ū��
	        	 		SelectedLastClassTable();	//��s���
	                  //  myFrame.myMM_pane.myMMO_pane.myEC_pane.clear_field();//�M�ſ�J���
	              }
	
	         }
	     };

		@Override
		//�ƥ��ť�{��:��JTable�Q�����,���o��e����C��������T
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			boolean dataIsSelected=true;	//������e�O�_����ƳQ���
			System.out.println("�i�JvalueChanged!!");
			if(myFrame.myMM_pane.myMMO_pane.choose==1){
				System.out.println("�i�JvalueChanged-class!!");

				String[] class_info=new String[6];
				int[] rows=myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectedRows();  //���o����C�W���x�s��
			    StringBuilder msg=new StringBuilder("Selected : "); 
	
			    for (int i=0; i<rows.length; i++) {//�N�������x�s��class_info[]�}�C
				    if(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(rows[i],0)==null){
			            JOptionPane.showMessageDialog(null,"��������!!!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
			            dataIsSelected=false;
			            break;
				    }
			        class_info[0]=myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(rows[i],0).toString();
			    	class_info[1]=myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(rows[i],1).toString();
			       	class_info[2]=myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(rows[i],2).toString();
			       	class_info[3]=myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(rows[i],3).toString();
			       	class_info[4]=myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(rows[i],4).toString();
			       	class_info[5]=myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(rows[i],5).toString();			    	
			    }
			    myFrame.myMM_pane.myMMQ_pane.mySR_pane.selected=true;
			    System.out.println("qqqq:"+dataIsSelected);
				if(dataIsSelected==true && myFrame.myMM_pane.myMMO_pane.choose==1 && myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable==true)
					ShowEditClassRecord();	//��k:�N��e������������ܦb�k�����
			}
			if(myFrame.myMM_pane.myMMO_pane.choose==3){
				System.out.println("�i�JvalueChanged_meal!!");
				String[] meal_info=new String[7];
				int[] rows=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRows();  //���o����C�W���x�s��
			    StringBuilder msg=new StringBuilder("Selected : "); 
			    for (int i=0; i<rows.length; i++) {//�N�������x�s��class_info[]�}�C
				    if(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(rows[i],0)==null){
			            JOptionPane.showMessageDialog(null,"��������!!!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
			            dataIsSelected=false;
			            break;
				    }
				    meal_info[0]=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(rows[i],0).toString();
				    meal_info[1]=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(rows[i],1).toString();
				    meal_info[2]=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(rows[i],2).toString();
				    meal_info[3]=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(rows[i],3).toString();
				    meal_info[4]=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(rows[i],4).toString();
				    meal_info[5]=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(rows[i],5).toString();
				    meal_info[6]=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(rows[i],6).toString();
			    }
			    myFrame.myMM_pane.myMMQ_pane.mySR_pane.selected=true;
				if(dataIsSelected==true && myFrame.myMM_pane.myMMO_pane.choose==3 && myFrame.myMM_pane.myMMO_pane.myEM_pane.getenable==true){
					System.out.println("�o�̭n����\�I��T");
					ShowEditOfMealRecord();	//��k:�N��e������������ܦb�k�����
				}
			}
		}
		//��k:�ǤJmeals[][]�\�I�G���}�C,�P�_�O�_�ݭn����
		public void changeLine(String[][] meals){
			 String str1,str2;
			 String html_start="<html>&nbsp;&nbsp;";
			 String br="<br>";
			 String html_end="</html>";
	         for(int x=0;x<meals.length;x++){
	        	 for(int y=0;y<meals[0].length;y++){
	        		if(meals[x][y]==null)
	        			break;
	        		else{
	        			if(meals[x][y].indexOf("html")>-1){	//�ϥ�indexOf() �j�M�r��O�_�w�g�a��html�y�k�r��,�Y���h���X�j��
	    					break;		
	    	 		     }
	        		//	System.out.println("�\�I�W��"+meals[x][y]);
	        			if(meals[x][y].length()>4){//�N�\�I�W�٤j��4�Ӧr���i����
	        				str1=html_start+(String) meals[x][y].subSequence(0,2)+br;	//���X�e��Ӧr
	        				str2=(String) meals[x][y].subSequence(2,meals[x][y].length())+html_end;	//���X�ѤU���r
	        				meals[x][y]=str1+str2;
	        		//		System.out.println("�s�\�I�W��"+meals[x][y]);
	        			}
	        		}
	             }
	         }
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		//��k: �d�����O���,�s�W��[�s�W�\�I]��[�s���\�I]���\�I���O�U�Ԧ����
		void update_MealOfClass(){
			/*-�w�]��ܥD�H���O-*/
		
			String[] manClass=myDBMA.findClass_in_TB_class();			    //�q��Ʈw���o������"�D�H"���Ҧ����O���,�æ^�ǵ�manClass
			for(int x=0;x<manClass.length;x++){
				if(manClass[x]==null)										//���Ƭ��Ů�,���X�j��
					break;
				myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.addItem(manClass[x]);//�N���O�[�JJComboBox
				myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.addItem(manClass[x]);//�N���O�[�JJComboBox

			}
			
			for(int i=0;i< myFrame.myMM_pane.myMMO_pane.myAM_pane.kindradio.length;i++){
				myFrame.myMM_pane.myMMO_pane.myAM_pane.kindradio[i].addActionListener(MealRadioBtnSelected);
				myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[i].addActionListener(MealRadioBtnSelected);
			}
			if(myFrame.myMM_pane.myMMO_pane.choose==3){ 					  //�ܼƬ���"�s���\�I"�Q���

			//�Y �ϥΪ̦b�\�I�����I��F"�D�H"
        	 if(myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[0].isSelected()==true){
					String[] manClass2=myDBMA.findClass_in_TB_class();			    //�q��Ʈw���o������"�D�H"���Ҧ����O���,�æ^�ǵ�manClass
					for(int x=0;x<manClass2.length;x++){
						if(manClass2[x]==null)										//���Ƭ��Ů�,���X�j��
							break;
						myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.addItem(manClass2[x]);//�N���O�[�JJComboBox
						myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.addItem(manClass2[x]);//�N���O�[�JJComboBox

					}
				
       	   }
			//�Y �ϥΪ̦b�\�I�����I��F"�d��"
       	   if(myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[1].isSelected()==true){
					String[] petClass=myDBMA.findClassPet_in_TB_class(); //�q��Ʈw���o������"�d��"���Ҧ����O���,�æ^�ǵ�petClass
					for(int x=0;x<petClass.length;x++){
						if(petClass[x]==null)									    //���Ƭ��Ů�,���X�j��
							break;
						myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.addItem(petClass[x]);//�N���O�[�JJComboBox
						myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.addItem(petClass[x]);//�N���O�[�JJComboBox

					}
	
        	 }
			}
		}
	     //�ƥ��ť�{��: 
	     public ActionListener MealRadioBtnSelected = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	 		    myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.removeAllItems();	//������JComboBox���Ҧ�items,�H�K����	
	 		    myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.removeAllItems();	//������JComboBox���Ҧ�items,�H�K����	
	 		    /*-�s�W�\�I-*/
				//�Y �ϥΪ̦b�\�I�����I��F"�D�H"
	        	 if(e.getSource()== myFrame.myMM_pane.myMMO_pane.myAM_pane.kindradio[0]){
						String[] manClass=myDBMA.findClass_in_TB_class();			    //�q��Ʈw���o������"�D�H"���Ҧ����O���,�æ^�ǵ�manClass
						for(int x=0;x<manClass.length;x++){
							if(manClass[x]==null)										//���Ƭ��Ů�,���X�j��
								break;
							myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.addItem(manClass[x]);//�N���O�[�JJComboBox
						}
					
	        	 }
				//�Y �ϥΪ̦b�\�I�����I��F"�d��"
	        	 if(e.getSource()== myFrame.myMM_pane.myMMO_pane.myAM_pane.kindradio[1]){
						String[] petClass=myDBMA.findClassPet_in_TB_class(); //�q��Ʈw���o������"�d��"���Ҧ����O���,�æ^�ǵ�petClass
						for(int x=0;x<petClass.length;x++){
							if(petClass[x]==null)									    //���Ƭ��Ů�,���X�j��
								break;
							myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.addItem(petClass[x]);//�N���O�[�JJComboBox
						}
		
	        	 }
	        	 /*�s���\�I*/
					//�Y �ϥΪ̦b�\�I�����I��F"�D�H"
	        	 if(e.getSource()== myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[0]){
						String[] manClass=myDBMA.findClass_in_TB_class();			    //�q��Ʈw���o������"�D�H"���Ҧ����O���,�æ^�ǵ�manClass
						for(int x=0;x<manClass.length;x++){
							if(manClass[x]==null)										//���Ƭ��Ů�,���X�j��
								break;
							myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.addItem(manClass[x]);//�N���O�[�JJComboBox
						}
					
	        	 }
				//�Y �ϥΪ̦b�\�I�����I��F"�d��"
	        	 if(e.getSource()== myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[1]){
						String[] petClass=myDBMA.findClassPet_in_TB_class(); //�q��Ʈw���o������"�d��"���Ҧ����O���,�æ^�ǵ�petClass
						for(int x=0;x<petClass.length;x++){
							if(petClass[x]==null)									    //���Ƭ��Ů�,���X�j��
								break;
							myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.addItem(petClass[x]);//�N���O�[�JJComboBox
						}
		
	        	 }
	         }
	     };
	   //��k: �d�ߪ��Ƹ��,�s�W��[�s�W�\�I]��[�s���\�I]�����ƤU�Ԧ����
		void update_MealOfMaterials(){
				//���Ƥ���
				myFrame.myMM_pane.myMMO_pane.myAM_pane.material_type_jcb.removeAllItems();	//������JComboBox���Ҧ�items,�H�K����			
	        	myFrame.myMM_pane.myMMO_pane.myAM_pane.material_type_jcb.addItem("�L");	    //�[�J"�L"���Ƥ�item
				
	        	String[] materials_type=myDBMA.findMaterialType_in_TB_mi();			        //�q��Ʈw���o�Ҧ����ƺ������,�æ^��
	        	
				myFrame.myMM_pane.myMMO_pane.myAM_pane.material_type_jcb.addItemListener(ItemSelected);//�[�J�ƥ��ť��

				for(int x=0;x<materials_type.length;x++){
	        		if(materials_type[x]==null)										       //���Ƭ��Ů�,���X�j��
	        			break;
	        		myFrame.myMM_pane.myMMO_pane.myAM_pane.material_type_jcb.addItem(materials_type[x]);//�N���ƺ��������[�JJComboBox

	        	}			
		}	
        //�ƥ��ť�{��:ItemEvent
		ItemListener ItemSelected = new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				String type;
				try{
					type=myFrame.myMM_pane.myMMO_pane.myAM_pane.material_type_jcb.getSelectedItem().toString();	//���o��e��������ﶵ�W��,���ন�r�ꫬ�A
				} catch(Exception e1){
					type="0";
				}				
	        	String[] getType=myDBMA.findMaterial_useType_in_TB_mi(type);//�ǤJ��e����������ﶵ,�æ^�ǸӤ����U���Ҧ����ƦW��

	        	//�ھڨϥΪ̿�ܪ�����,��ܹ������ƺ���
	        	if(myFrame.myMM_pane.myMMO_pane.myAM_pane.material_type_jcb.getSelectedIndex()==0)	//��ϥΪ̿��"���ϥ�",�N���ƿﶵ�]�����i��
	        		myFrame.myMM_pane.myMMO_pane.myAM_pane.material_jcb.setVisible(false);
	        	else{
			        myFrame.myMM_pane.myMMO_pane.myAM_pane.material_jcb.removeAllItems();	   //������JComboBox���Ҧ�items,�H�K����			
					for(int x=0;x<getType.length;x++){
						if(getType[x]==null)										           //���Ƭ��Ů�,���X�j��
							break;
						myFrame.myMM_pane.myMMO_pane.myAM_pane.material_jcb.addItem(getType[x]);//�N���ƺ����[�JJComboBox
		        		myFrame.myMM_pane.myMMO_pane.myAM_pane.material_jcb.setVisible(true);   //�N���ƺ����U�Ԧ����]���i��
					}	        		
	        	}
	        	//�P�_�\�I�O�_��Ϊ���
	        	if(myFrame.myMM_pane.myMMO_pane.myAM_pane.material_type_jcb.getSelectedIndex()==0)
	        		myFrame.myMM_pane.myMMO_pane.myAM_pane.use_material=false;	//�����\�I���ϥΪ���
	        	else
	        		myFrame.myMM_pane.myMMO_pane.myAM_pane.use_material=true;	//�����\�I�ϥΪ���
	        	
			}		
		 };		
		//��k: �d�ߪ��Ƹ��,�s�W��[�s���\�I]�����ƤU�Ԧ����
		void Edit_MealOfMaterials(){
				//���Ƥ���
				myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.removeAllItems();	//������JComboBox���Ҧ�items,�H�K����			
	        	myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.addItem("�L");	    //�[�J"�L"���Ƥ�item
	        	String[] materials_type=myDBMA.findMaterialType_in_TB_mi();			        //�q��Ʈw���o�Ҧ����ƺ������,�æ^��
	        	
				myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.addItemListener(ItemEditSelected);//�[�J�ƥ��ť��
	        	for(int x=0;x<materials_type.length;x++){
	        		if(materials_type[x]==null)										       //���Ƭ��Ů�,���X�j��
	        			break;
	        		myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.addItem(materials_type[x]);//�N���ƺ��������[�JJComboBox

	        	}			
		}	
			
        //�ƥ��ť�{��:ItemEvent
		ItemListener ItemEditSelected = new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				String type;
				try{
					type=myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.getSelectedItem().toString();	//���o��e��������ﶵ�W��,���ন�r�ꫬ�A

				} catch(Exception e1){
					type="0";
				}				
	        	String[] getType=myDBMA.findMaterial_useType_in_TB_mi(type);//�ǤJ��e����������ﶵ,�æ^�ǸӤ����U���Ҧ����ƦW��

	        	//�ھڨϥΪ̿�ܪ�����,��ܹ������ƺ���
	        	if(myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.getSelectedIndex()==0)	//��ϥΪ̿��"���ϥ�",�N���ƿﶵ�]�����i��
	        		myFrame.myMM_pane.myMMO_pane.myEM_pane.material_jcb.setVisible(false);
	        	else{
			        myFrame.myMM_pane.myMMO_pane.myEM_pane.material_jcb.removeAllItems();	   //������JComboBox���Ҧ�items,�H�K����			
					for(int x=0;x<getType.length;x++){
						if(getType[x]==null)										           //���Ƭ��Ů�,���X�j��
							break;
						myFrame.myMM_pane.myMMO_pane.myEM_pane.material_jcb.addItem(getType[x]);//�N���ƺ����[�JJComboBox
		        		myFrame.myMM_pane.myMMO_pane.myEM_pane.material_jcb.setVisible(true);   //�N���ƺ����U�Ԧ����]���i��
					}	        		
	        	}
	        	//�P�_�\�I�O�_��Ϊ���
	        	if(myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.getSelectedIndex()==0)
	        		myFrame.myMM_pane.myMMO_pane.myEM_pane.use_material=false;	//�����\�I���ϥΪ���
	        	else
	        		myFrame.myMM_pane.myMMO_pane.myEM_pane.use_material=true;	//�����\�I�ϥΪ���

			}	
		 };		
		 
	     //�ƥ��ť�{��: �B�z�\�I����x�s
	     public ActionListener ProcessSaveMealRecord = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	              
	              boolean checkPass = true;      	//�ΨӰO��[��J�����O���]�ˬd���G
	              boolean check_price_null = false; //�ΨӼȮɰO��[��J������O�_����]�ˬd���G
	              boolean check_price_num = false;	//�ΨӼȮɰO��[��J������O�_���Ʀr]�ˬd���G

	              String noStr = myFrame.myMM_pane.myMMO_pane.myAM_pane.notxt.getText().trim();      //���o[���O�s�����]����[�s���r��]
	              String dateStr = myFrame.myMM_pane.myMMO_pane.myAM_pane.datetxt.getText().trim();  //���o[���O������]����[����r��]
	              String nameStr = myFrame.myMM_pane.myMMO_pane.myAM_pane.nametxt.getText().trim();  //���o[��J�����O�W��]����[�W�٦r��] 
	              String kindStr = myFrame.myMM_pane.myMMO_pane.myAM_pane.kindStr;  				 //���o[��J���\�I����]����[�����r��]
	              String stateStr = myFrame.myMM_pane.myMMO_pane.myAM_pane.stateStr;				 //���o[��J���\�I���A]����[���A�r��] 
	              String priceStr = myFrame.myMM_pane.myMMO_pane.myAM_pane.pricetxt.getText().trim(); //���o[��J���\�I����]����[����r��]
	              
	              //�ǤJ�@�����O�W��,�^�Ǹ����O�W�٤����O�s��
	              System.out.println("���O���o���r��O:"+myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.getSelectedItem().toString());
	              String cls_noStr=myDBMA.findClassNo_forMeals_in_TB_class(myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.getSelectedItem().toString());
	              System.out.println("���O���d�ߵ��G�O:"+cls_noStr);
	              String mi_noStr;
	              if(myFrame.myMM_pane.myMMO_pane.myAM_pane.use_material==false)
	            	  mi_noStr="�L";
	              else{//�ǤJ�@�����ƦW��,�^�ǸӪ��ƦW�٤����ƽs��
		              System.out.println("���ƨ��o���r��O:"+myFrame.myMM_pane.myMMO_pane.myAM_pane.material_jcb.getSelectedItem().toString());
	            	  mi_noStr=myDBMA.findMiNo_in_TB_mi(myFrame.myMM_pane.myMMO_pane.myAM_pane.material_jcb.getSelectedItem().toString());
		              System.out.println("���ƪ��d�ߵ��G�O:"+mi_noStr);
	              }
	              /*-�ˬd��J���-*/
	              if(  nameStr.length() == 0 ){    //�ˬdnameString�O�_����J����r��,length()���p��r����פ�k,�Y���׬�0�h����J���
	                     checkPass = false;
	                     JOptionPane.showMessageDialog(null,"[�W��] ���o���ť�!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
       
	              }   
  	              if(nameStr.length() > 10){  //�ˬdnameString���׬O�_�W�L10
	                    checkPass = false;
	                    JOptionPane.showMessageDialog(null,"[�W��] �̤j���׬�10","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
    	          }
	              if(  priceStr.length() == 0 ){    //�ˬdnoteStr�O�_����J����r��,length()���p��r����פ�k,�Y���׬�0�h����J���
	                     checkPass = false;
	                     check_price_null=true;
	                     JOptionPane.showMessageDialog(null,"[����] ���o���ť�!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
	              }	
	              if( check_price_null==false ){  
	                   if(myCheck.checkNumber( priceStr ) == false ){//�Q���ˬd����(myCheck)��checkNumber()��k,�ˬdpriceStr�O�_�����T���ƭȮ榡,�p:98,80,...��
	            	  	checkPass = false;
	                    check_price_num = false;
	                    JOptionPane.showMessageDialog(null,"[����] ��J��ƿ��~!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
	                   }
	                   else
		                    check_price_num = true;
	              }
      	          if( check_price_num==true ){ //����T�w���Ʀr��,�ˬdpriceStr�O�_��0
      	        	  if(Integer.parseInt(priceStr) == 0){
  	                    checkPass = false;
  	                    JOptionPane.showMessageDialog(null,"[����] ���o��0","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
      	        	  }
      	          }
                   
	              if( checkPass == true ){
	                    myMeal.setNo(noStr);
	                    myMeal.setDate(dateStr);
	                    myMeal.setName(nameStr);
	                    myMeal.setKind(kindStr);
	                    myMeal.setCLSNo(cls_noStr);
	   	                myMeal.setMINo(mi_noStr);
	                    myMeal.setState(stateStr);
	                    myMeal.setPrice(Integer.parseInt(priceStr));
	                    myDBMA.insertRD_into_TB_meal(myMeal);   //�N�\�I����ǤJ[��Ʈw�ާ@�s������(myDBMA)]���x�s���O������k(insertRD_into_TB_meal())�h�x�s���O�������Ʈw
	                    System.out.print(noStr+dateStr+nameStr+kindStr+cls_noStr+mi_noStr+stateStr+Integer.parseInt(priceStr));     
	                    myFrame.myMM_pane.myMMO_pane.myAM_pane.setNewNo();      	//��s�\�I�s��
	                    myFrame.myMM_pane.myMMO_pane.myAM_pane.initialize_Filed();  //��l�����O���
	                    myFrame.myMM_pane.myMMO_pane.myAM_pane.setMealDate();       //��s�t�Τ��
	              }

	         }    
	     };	
	     
	     //�ƥ��ť�{��: �B�z�\�I�d�߸��
	     public ActionListener ProcessQueryMealRecord = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	    if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.kindSelected==false){//���"�d���\�I"�Q���
	        	    	System.out.println("��F�d���\�I:");
	        	    	if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.second==true){//�P�_�ϥΪ̬O�_����ĤG�ӱ���d�� 
	        	    		myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;//�N�ܼƳ]��false,����U�d�߮����������ܤ�k�_�h�|�X��
	        	    		String query1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedItem().toString();//���o[����d��1]����[���d�߸��]
	        	    		String log1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedItem().toString();      //���o[����d��1]����[�޿�d�߸��]
	        	    		String cond1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.cond1txt.getText().trim();                  //���o[����d��1]����[�ϥΪ̿�J�����]
	        	    		String and_or=myFrame.myMM_pane.myMMQ_pane.myQM_pane.quAnd_Orjcb.getSelectedItem().toString();  //���o[����d��1_2]��[�޿�B��]
	        	    		String query2=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_meal_jcb.getSelectedItem().toString();//���o[����d��2]����[���d�߸��]
	        	    		String log2=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog3jcb.getSelectedItem().toString();      //���o[����d��2]����[�޿�d�߸��]
	        	    		String cond2=myFrame.myMM_pane.myMMQ_pane.myQM_pane.cond2txt.getText().trim();                  //���o[����d��2]����[�ϥΪ̿�J�����]

	        	    		//�ϥΪ̱���1�P�_
	        	    		if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedIndex()==1){
	        	    			query1="MEAL_name";
	        	    			int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
	        	    			if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
	        	    			if(  log1_num==1)	log1="<>";
			        	
	        	    		}
	        	    		else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedIndex()==2){
	        	    			query1="CLS_no";
	        	    			int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
	        	    			if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
	        	    			if(  log1_num==1)	log1="<>";
	        	    		}
	        	    		else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedIndex()==3){
	        	    			query1="MEAL_Date";
	        	    			int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedIndex();	
	        	    			if(  log1_num==0 )	log1=">";
			        	 		if(  log1_num==1)	log1="<";
			        	 		if(  log1_num==2)	log1="=";        	 	
	        	    		}
	        	    		else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedIndex()==4){
	        	    			query1="MI_no";
	        	    			int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
		        	 			if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
		        	 			if(  log1_num==1)	log1="<>";
	        	    		}	 
	        	    		else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedIndex()==5){
	        	    			query1="MEAL_price";
	        	    			int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
	        	    			if(  log1_num==0 )	log1=">";
			        	 		if(  log1_num==1)	log1="<";
			        	 		if(  log1_num==2)	log1="=";     
			        	 	}
	        	    		else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedIndex()==6){
	        	    			query1="MEAL_state";
	        	    			int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
		        	 			if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
		        	 			if(  log1_num==1)	log1="<>";  
			        	 	}
			        	 	else{
			        	 		query1="MEAL_No";
			        	 		int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedIndex();	
				        	 	if(  log1_num==0 )	log1=">";
				        	 	if(  log1_num==1)	log1="<";
				        	 	if(  log1_num==2)	log1="=";    
			        	 	}
			        	 	//�ϥΪ̱���2�P�_
			        	 	if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_meal_jcb.getSelectedIndex()==1){
			        	 		query2="MEAL_name";
			        	 		int log2_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog4jcb.getSelectedIndex();	
				        	 	if(  log2_num==0 )	{log2=" like"; cond2="%"+cond2+"%";}
				        	 	if(  log2_num==1)	log2="<>";
				        	
			        	 	}
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_meal_jcb.getSelectedIndex()==2){
			        	 		query2="CLS_no";
			        	 		int log2_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog4jcb.getSelectedIndex();	
				        	 	if(  log2_num==0 )	{log2=" like"; cond2="%"+cond2+"%";}
				        	 	if(  log2_num==1)	log2="<"+">";
			        	 	}
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_meal_jcb.getSelectedIndex()==3){
			        	 		query2="MEAL_Date";
			        	 		int log2_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog3jcb.getSelectedIndex();	
				        	 	if(  log2_num==0 )	log2=">";
				        	 	if(  log2_num==1)	log2="<";
				        	 	if(  log2_num==2)	log2="=";        	 	
			        	 	}
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_meal_jcb.getSelectedIndex()==4){
			        	 		query2="MI_no";
			        	 		int log2_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog4jcb.getSelectedIndex();	
				        	 	if(  log2_num==0 )	{log2=" like"; cond2="%"+cond2+"%";}
				        	 	if(  log2_num==1)	log2="<>";
			        	 	}	 
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_meal_jcb.getSelectedIndex()==5){
			        	 		query2="MEAL_price";
			        	 		int log2_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog3jcb.getSelectedIndex();	
				        	 	if(  log2_num==0 )	log2=">";
				        	 	if(  log2_num==1)	log2="<";
				        	 	if(  log2_num==2)	log2="=";   
			        	 	}
			        	 	else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_meal_jcb.getSelectedIndex()==6){
			        	 		query2="MI_state";
			        	 		int log2_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog4jcb.getSelectedIndex();	
				        	 	if(  log2_num==0 )	{log2=" like"; cond2="%"+cond2+"%";}
				        	 	if(  log2_num==1)	log2="<>";
			        	 	}	 
			        	 	else{
			        	 		query2="MEAL_No";
			        	 		int log2_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog3jcb.getSelectedIndex();	
				        	 	if(  log2_num==0 )	log2=">";
				        	 	if(  log2_num==1)	log2="<";
				        	 	if(  log2_num==2)	log2="=";    
			        	 	}
			        	 	//and or�P�_
			        	 	if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.quAnd_Orjcb.getSelectedIndex()==0)//and
			        	 		and_or=" AND ";
			        	 	else
			        	 		and_or=" OR ";
			        	 	
			        	 	//�ϥΦh�d�߱���
			        	 	if(  cond1.length() > 0 ){//�p�G[�ϥΪ̿�J�����1]���פj��0,�Y����J����r���,�~�i�J�d�߳B�z
			        	 		if(cond2.length()>0){//�p�G[�ϥΪ̿�J�����2]���פj��0,�Y����J����r���,�~�i�J�d�߳B�z
			        	 			ClearMealTable();
				        	 		String [][]myQuery=myDBMA.findMeal2_in_TB_meal(query1,log1,cond1,and_or,query2,log2,cond2);
				        	 		//�N�d�ߵ��G�g�JJTable
				        	 		for(int x=0;x<myQuery.length;x++){
				        	 			//�N��Ƽg�JJTable
						                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.addRow(new Object[]{myQuery[x][0],myQuery[x][1]
						                		,myQuery[x][2],myQuery[x][3],myQuery[x][4],myQuery[x][5],myQuery[x][6],myQuery[x][7],myQuery[x][8]});	//�N[�d�ߵ��G]�g�JJTable
						                //��sJTable �����e
						                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.fireTableDataChanged();	
					                    myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.updateUI();
				        	 		}
				        	 	}
				        	 	else JOptionPane.showMessageDialog(null,"[�d�����2]�ťե���J��ơA�ж�g��A�d��!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
				        	 	
			        	 	}
			        	 	else JOptionPane.showMessageDialog(null,"[�d�����1]�ťե���J��ơA�ж�g��A�d��!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
			        	 	
		        	 	}
		        	 	else{//�ϥΪ̨ϥγ�@�d�߱���
		        	 		String query1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedItem().toString();//���o[����d��1]����[���d�߸��]
	        	    		String log1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedItem().toString();      //���o[����d��1]����[�޿�d�߸��]
	        	    		String cond1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.cond1txt.getText().trim();                  //���o[����d��1]����[�ϥΪ̿�J�����]
			    		    myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;	//�N�ܼƳ]��false,����U�d�߮����������ܤ�k�_�h�|�X��
	        	    		//�ϥΪ̱���1�P�_
	        	    		if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedIndex()==1){
	        	    			query1="MEAL_name";
	        	    			int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
	        	    			if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
	        	    			if(  log1_num==1)	log1="<>";
			        	
	        	    		}
	        	    		else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedIndex()==2){
	        	    			query1="CLS_no";
	        	    			int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
	        	    			if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
	        	    			if(  log1_num==1)	log1="<>";
	        	    		}
	        	    		else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedIndex()==3){
	        	    			query1="MEAL_Date";
	        	    			int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedIndex();	
	        	    			if(  log1_num==0 )	log1=">";
			        	 		if(  log1_num==1)	log1="<";
			        	 		if(  log1_num==2)	log1="=";
			        	 		
	        	    		}
	        	    		else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedIndex()==4){
	        	    			query1="MI_no";
	        	    			int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
		        	 			if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
		        	 			if(  log1_num==1)	log1="<>";
	        	    		}	 
	        	    		else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedIndex()==5){
	        	    			query1="MEAL_price";
	        	    			int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedIndex();	
	        	    			if(  log1_num==0 )	log1=">";
			        	 		if(  log1_num==1)	log1="<";
			        	 		if(  log1_num==2)	log1="=";     
			        	 	}
	        	    		else if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedIndex()==6){
	        	    			query1="MEAL_state";
	        	    			int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog2jcb.getSelectedIndex();	
		        	 			if(  log1_num==0 )	{log1=" like"; cond1="%"+cond1+"%";}
		        	 			if(  log1_num==1)	log1="<>";  
			        	 	}
			        	 	else{
			        	 		query1="MEAL_No";
			        	 		int log1_num=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedIndex();	
				        	 	if(  log1_num==0 )	log1=">";
				        	 	if(  log1_num==1)	log1="<";
				        	 	if(  log1_num==2)	log1="=";    
			        	 	} 		
	                      	System.out.println(query1+cond1+log1);

			        	 	if(  cond1.length() > 0 ){//�p�G[�ϥΪ̿�J�����]���פj��0,�Y����J����r���,�~�i�J�d�߳B�z
			        	 		ClearMealTable();
			        	 		String [][]myQuery=myDBMA.findMeal_in_TB_meal(query1,log1,cond1);   //�I�s[��Ʈw�ާ@�s������(myDBMA)]���d�߾ǥͬ�����k(findCLass_in_TB_class())�h�d�����O����,�æ^���x�s��myQuery��
			        	 		//�N�d�ߵ��G�g�JJTable
			        	 		for(int x=0;x<myQuery.length;x++){
			        	 			//�N��Ƽg�JJTable
					                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.addRow(new Object[]{myQuery[x][0],myQuery[x][1]
					                		,myQuery[x][2],myQuery[x][3],myQuery[x][4],myQuery[x][5],myQuery[x][6],myQuery[x][7],myQuery[x][8]});	//�N[�d�ߵ��G]�g�JJTable
					                //��sjtable �����e
					                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.fireTableDataChanged();	
				                    myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.updateUI();
			        	 		}
			        	 	}
			        	 	else{
			                    JOptionPane.showMessageDialog(null,"[�d�����1]�ťե���J��ơA�ж�g��A�d��!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
			        	 	}
			            }
	        	    }
	           }
	       
	     };
	     //�ƥ��ť�{��: �B�z�������O/�\�I���d��
	     public ActionListener ProcesskindradioRecord = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	 //�Y��e��"���O�޲z"�Q���
	        	 if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.kindSelected==true){
	        			SelectedLastMealTable();	//�אּ"�\�I�޲z"
	        			myFrame.myMM_pane.myMMO_pane.addclassbtn.setEnabled(false);	//�N[�s���O]���s�]�����i���				
	    	    	    myFrame.myMM_pane.myMMO_pane.revclassbtn.setEnabled(false);	//�N[�s�����O]���s�]�����i���
	        			myFrame.myMM_pane.myMMO_pane.addmealsbtn.setEnabled(true);	//�N[�s�\�I]���s�]���i���
	        			myFrame.myMM_pane.myMMO_pane.revmealsbtn.setEnabled(true);	//�N[�s���\�I]���s�]���i���
	        			
		            	myFrame.myMM_pane.myMMO_pane.myAC_pane.setVisible(false);    //���[�s�W���O]�ާ@�e��
		            	myFrame.myMM_pane.myMMO_pane.myEC_pane.setVisible(false);    //����[�s�����O]�ާ@�e��
		            	myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(true);     //����[�s�W�\�I]�ާ@�e��
		            	myFrame.myMM_pane.myMMO_pane.myEM_pane.setVisible(false);    //����[�s���\�I]�ާ@�e��
		            	update_MealOfClass();										 //��s[�s�W�\�I]�����O���
		            	update_MealOfMaterials();	   								 //��s[�s�W�\�I]���������
	        	 }
	        	 //�Y��e��"�\�I�޲z"�Q���
	        	 if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.kindSelected==false){
	        			SelectedLastClassTable();	//�אּ"���O�޲z"
	        			myFrame.myMM_pane.myMMO_pane.addmealsbtn.setEnabled(false);	//�N[�s�\�I]���s�]�����i���
	        			myFrame.myMM_pane.myMMO_pane.revmealsbtn.setEnabled(false);	//�N[�s���\�I]���s�]�����i���
	        			myFrame.myMM_pane.myMMO_pane.addclassbtn.setEnabled(true);	//�N[�s�\�I]���s�]���i���	
	    	    	    myFrame.myMM_pane.myMMO_pane.revclassbtn.setEnabled(true);	//�N[�s���\�I]���s�]���i���
	        	 
		            	myFrame.myMM_pane.myMMO_pane.myAC_pane.setVisible(true);    //���[�s�W���O]�ާ@�e��
		            	myFrame.myMM_pane.myMMO_pane.myEC_pane.setVisible(false);   //����[�s�����O]�ާ@�e��
		            	myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(false);   //����[�s�W�\�I]�ާ@�e��
		            	myFrame.myMM_pane.myMMO_pane.myEM_pane.setVisible(false);   //����[�s���\�I]�ާ@�e��
		            	myFrame.myMM_pane.myMMO_pane.choose=0; 					  //�ܼƬ���"�s�W���O"�Q���

		            	
	        	 }	 
	        	 
	         }
	     };
	     //�ƥ��ť�{��: �B�z�\�I��ƭק�(��s)
	     public ActionListener ProcessReviseMealRecord = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	  myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;//�N�ܼƳ]��false,����U�d�߮����������ܤ�k�_�h�|�X��
	              boolean checkPass = true;      //�ΨӰO��[��J�����O���]�ˬd���G
	              String kindStr="",stateStr="";
	              //���o[�\�I�s�����]����[�\�I�r��]
	              String meal_noStr = myFrame.myMM_pane.myMMO_pane.myEM_pane.notxt.getText().trim();   
	              //���o[�\�I�إߤ�����]����[����r��]
	              String dateStr = myFrame.myMM_pane.myMMO_pane.myEM_pane.datetxt.getText().trim();     
	              //���o[�\�I�W�ٸ��]����[�W�٦r��] 
	              String nameStr = myFrame.myMM_pane.myMMO_pane.myEM_pane.nametxt.getText().trim();     
	         	  //���o[����](�D�Hor�d��)
	              if(myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[0].isSelected()==true)
	            	  kindStr="�D�H";
	              else
	            	  kindStr="�d��";
	              //���o[���O�s��]
	              String cls_name=myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.getSelectedItem().toString();//���o���O�W��
	              String cls_noStr=myDBMA.findClassNo_in_TB_class(cls_name);
         
	              //���o[���ƽs��]
	              String mi_name=myFrame.myMM_pane.myMMO_pane.myEM_pane.material_jcb.getSelectedItem().toString();//���o���ƦW��
	              String mi_noStr=myDBMA.findM_No_in_TB_mi(mi_name);
		          //���o[���A](�c��or����)
	              if(myFrame.myMM_pane.myMMO_pane.myEM_pane.msradio[0].isSelected()==true)
	            	  stateStr="�c��";
	              else
	            	  stateStr="����";	  
	              //���o[����]  
	              String priceStr = myFrame.myMM_pane.myMMO_pane.myEM_pane.pricetxt.getText().trim();    //���o[�\�I����]����[����r��]
	              
	              if(  nameStr.length() == 0 ){    //�ˬdnameString�O�_����J����r��,length()���p��r����פ�k,�Y���׬�0�h����J���
	                     checkPass = false;
	                     JOptionPane.showMessageDialog(null,"[�W��] ���o���ť�!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
	              }                         
	              if(  priceStr.length() == 0 ){    //�ˬdnoteStr�O�_����J����r��,length()���p��r����פ�k,�Y���׬�0�h����J���
	                     checkPass = false;
	                     JOptionPane.showMessageDialog(null,"[����] ���o���ť�!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
	              }	
	              if( myCheck.checkNumber( priceStr ) == false ){  //�Q���ˬd����(myCheck)��checkNumber()��k,�ˬdpriceStr�O�_�����T���ƭȮ榡,�p:98,80,...��
	                    checkPass = false;
	                    JOptionPane.showMessageDialog(null,"[����] ��J��ƿ��~!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
	              }
	              if( Integer.parseInt(priceStr) == 0 ){  //�ˬdpriceStr�O�_��0
	                    checkPass = false;
	                    JOptionPane.showMessageDialog(null,"[����] !","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
	              }
	              if( checkPass == true ){
	                    myMeal.setNo(meal_noStr);
	                    myMeal.setDate(dateStr);
	                    myMeal.setName(nameStr);
	                    myMeal.setKind(kindStr);
	                    myMeal.setCLSNo(cls_noStr);
	   	                myMeal.setMINo(mi_noStr);
	                    myMeal.setState(stateStr);
	                    myMeal.setPrice(Integer.parseInt(priceStr));
	        	 		//ClearClassTable();
	                    myDBMA.updateMeal_in_TB_meal(myMeal);  //�ǤJ�@��[���O���]
	        	 	//	ClearMealTable();	//�M�Ū��
	        	 		SelectedLastMealTable();	//��s���
	        	 		
	              }

	         }
	     };

	     //����s���]�m
	 	void getLast_trans_No(){
	 			String last_no; 
	 			int num,count=0;
	 			
	 			last_no=myBS.query_lastkey_TB_class();
	 	       
	 			int len = last_no.length();  //���o�ǤJ�r�����
	 	        String[] sList = new String[len];   //�إߤ@�Ӫ��׬�len���r��}�C,�Ψ��x�s�r���ѫ�U�Ӧr����

	 	        
	 	        //�N�r���Ѧ��@�ӭӦr��,���x�s��}�C
	 	        for(int x=0; x<len-1; x++)
	 	            sList[x] = last_no.substring(x,x+1);

	 	      sList[len-1] = last_no.substring(len-1);

	 	        for(int x=14; x<len; x++){//����T��Ʀr
	 	        	myFrame.myCOM_pane.myTrans_no[count]=Integer.valueOf(sList[x]);
	 	        	count++;
	 	        	
	 	        }
	 	       
	 		 }
	 		 
	 		 void setNewNo(){
	 			getLast_trans_No();
	 			 if(myFrame.myCOM_pane.myTrans_no[2]+1>9){//�P�_�Ӧ�ƬO�_�ݭn�i��
	 				myFrame.myCOM_pane.myTrans_no[2]=0;
	 				 if(myFrame.myCOM_pane.myTrans_no[1]+1>9){//�P�_�Q��ƬO�_�ݭn�i��
	 					myFrame.myCOM_pane.myTrans_no[1]=0;
	 					 if(myFrame.myCOM_pane.myTrans_no[0]+1>9)//�P�_�O�_�W�L999�����
	 		                  JOptionPane.showMessageDialog(null,"���O��ƪ�w��!");
	 					 else
	 						myFrame.myCOM_pane.myTrans_no[0]++;
	 				 }
	 				 else
	 					myFrame.myCOM_pane.myTrans_no[1]++;
	 			 }
	 			 else
	 				myFrame.myCOM_pane.myTrans_no[2]++;
	 			 
	 			myFrame.myCOM_pane.IDTxtFd.setText("TRAN01"+myFrame.myCOM_pane.no_date+myFrame.myCOM_pane.myTrans_no[0]+myFrame.myCOM_pane.myTrans_no[1]+myFrame.myCOM_pane.myTrans_no[2]);
	 		 }
	 		 
	 	
}

