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


//系統主控類別
 //PRMS: Class PetRestaurantManagementSystem (寵物餐廳管理系統-SMS)
public class PRMS implements ActionListener,ListSelectionListener{

		 //建立本系統所需的各個物件
		
		CHCI_frame myFrame = new CHCI_frame(); 	  //人機互動層: 使用者介面物件(myFrame,裡面又含有:myFrame.myMenu,myFrame.myOP_pane,myFrame.myQR_pane)
	    CFD_check myCheck = new CFD_check();      //基礎層: 檢查物件(myCheck)
	    
		CPD_class myClass = new CPD_class();      //問題領域層: 餐點分類物件(myClass) 
		CPD_meal myMeal = new CPD_meal();		  //問題領域層: 餐點物件(myMeal)    
		CPD_cl myCl = new CPD_cl();		  		  //問題領域層: 廠商物件(myCl)    
		CPD_mi myMi = new CPD_mi();		          //問題領域層: 物料種類物件(myMi)    
		CPD_od myOd = new CPD_od();		          //問題領域層: 訂單細節關聯資料表物件(myOd)    
		CPD_ol myOl = new CPD_ol();		          //問題領域層: 訂單細節物件(myOl)    
		CPD_order myOrder = new CPD_order();	  //問題領域層: 訂單物件(myOrder)    
		CPD_td myTd = new CPD_td();		          //問題領域層: 交易細節關聯資料表物件(myTd)    
		CPD_tl myTl = new CPD_tl();		          //問題領域層: 交易訂單細節物件(myTl)    
		CPD_trans myTrans = new CPD_trans();	  //問題領域層: 交易訂單物件(myTrans)    

	    CDM_dbma myDBMA = new CDM_dbma();         //資料管理層: 類別,餐點資料庫操作存取物件(myDBMA)
	    CDM_BS_dbma myBS = new CDM_BS_dbma();     //資料管理層: 物料,交易資料庫操作存取物件(myBS)
	    CDM_ST_dbma myST = new CDM_ST_dbma();	  //資料管理層: 員工,打卡,預約資料庫操作存取物件(myBS)
	    
	     //CSMS的建構子:
	     PRMS(){
	             //設定系統中相關物件是由哪一個[事件傾聽程式]負責處理其動作 
	    	 	myFrame.mySignIn_pane.btnSign.addActionListener(ProcessFunSelection);              //[登入]操作畫面的[登入]按鈕
	    	 	myFrame.mySignIn_pane.btnExit.addActionListener(ProcessFunSelection);              //[登入]操作畫面的[離開]按鈕
	    	 	myFrame.myOR_pane.manBtn.addActionListener(ProcessFunSelection);				   //[新增餐點]操作畫面的[主人點餐]按鈕
	    	    myFrame.myOR_pane.petBtn.addActionListener(ProcessFunSelection);				   //[新增餐點]操作畫面的[寵物點餐]按鈕	 
	            myFrame.myOR_pane.manBtn.addActionListener(ProcessUpdata); 						   //[新增餐點]操作畫面的[主人點餐]按鈕
	            myFrame.myOR_pane.petBtn.addActionListener(ProcessUpdata); 						   //[新增餐點]操作畫面的[寵物點餐]按鈕        
	    	    myFrame.myOR_pane.dealBtn.addActionListener(ProcessFunSelection);				   //[新增餐點]操作畫面的[結帳]按鈕
	    	    myFrame.myOR_pane.clearBtn.addActionListener(ProcessFunSelection);				   //[新增餐點]操作畫面的[清除]按鈕
	    	    myFrame.myCOM_pane.checkbtn.addActionListener(ProcessFunSelection);				   //[結帳餐點]操作畫面的[確定]按鈕
	    	    myFrame.myMenu.forwardBtn.addActionListener(ProcessFunSelection); 				   //主功能選單物件的[前台]按鈕	
	    	    myFrame.myMenu.backBtn.addActionListener(ProcessFunSelection); 				       //主功能選單物件的[後台]按鈕
	    	 	myFrame.myMenu.exitBtn.addActionListener(ProcessFunSelection);					   //主功能選單物件的[登出]按鈕
	    	    myFrame.myMenu.punBtn.addActionListener(ProcessFunSelection);				       //主功能選單物件的[員工打卡]按鈕
	    	    myFrame.myMenu.resBtn.addActionListener(ProcessFunSelection);				       //主功能選單物件的[訂位預約]按鈕
	    	    myFrame.myMenu.orderBtn.addActionListener(ProcessFunSelection);				       //主功能選單物件的[返回點餐]按鈕    	    
	    	    myFrame.myMenu.mealMBtn.addActionListener(ProcessFunSelection);				       //主功能選單物件的[管理餐點]按鈕
	    	    myFrame.myMenu.employeeMBtn.addActionListener(ProcessFunSelection); 			   //主功能選單物件的[管理員工]按鈕
	    	    myFrame.myMenu.storageMBtn.addActionListener(ProcessFunSelection); 				   //主功能選單物件的[管理物料]按鈕
	    	    myFrame.myMenu.dealMBtn.addActionListener(ProcessFunSelection); 				   //主功能選單物件的[管理交易]按鈕
	    	    myFrame.myMS_pane.myMSO_pane.addstaffbtn.addActionListener(ProcessFunSelection);   //[管理員工]操作畫面的[新類別]按鈕	 	    
	    	    myFrame.myMS_pane.myMSO_pane.revstaffbtn.addActionListener(ProcessFunSelection);   //[管理員工]操作畫面的[編輯類別]按鈕
	    	    myFrame.myMM_pane.myMMO_pane.addclassbtn.addActionListener(ProcessFunSelection);   //[管理餐點]操作畫面的[新類別]按鈕	 	   
	    	    myFrame.myMM_pane.myMMO_pane.revclassbtn.addActionListener(ProcessFunSelection);   //[管理餐點]操作畫面的[編輯類別]按鈕
	    	    myFrame.myMM_pane.myMMO_pane.addmealsbtn.addActionListener(ProcessFunSelection);   //[管理餐點]操作畫面的[新餐點]按鈕
	    	    myFrame.myMM_pane.myMMO_pane.revmealsbtn.addActionListener(ProcessFunSelection);   //[管理餐點]操作畫面的[編輯餐點]按鈕

	    	    myFrame.myMM_pane.myMMO_pane.myEC_pane.addbtn.addActionListener(ProcessReviseClassRecord);   //[管理餐點]操作畫面的[編輯類別-更新]按鈕
            //	myFrame.myMM_pane.myMMO_pane.myEC_pane.addbtn.addActionListener(ProcessReviseClassRecord);   //[管理餐點]操作畫面的[編輯類別-取消]按鈕
	    	    
	    	    myFrame.myMM_pane.myMMO_pane.myEM_pane.addbtn.addActionListener(ProcessReviseMealRecord);        //[管理餐點]操作畫面的[編輯餐點-更新]按鈕
	    	//	myFrame.myMM_pane.myMMO_pane.myEM_pane.addbtn.addActionListener(ProcessReviseMealRecord);        //[管理餐點]操作畫面的[編輯餐點-取消]按鈕

	    	    myFrame.myMM_pane.myMMQ_pane.myQM_pane.quertbtn.addActionListener(ProcessQueryClassRecord); //[管理餐點]查詢畫面的[查詢]按鈕	 	   
	    	    myFrame.myMM_pane.myMMQ_pane.myQM_pane.quertbtn.addActionListener(ProcessQueryMealRecord);  //[管理餐點]查詢畫面的[查詢]按鈕	 

	            myFrame.myMM_pane.myMMO_pane.myAC_pane.addbtn.addActionListener(ProcessSaveClassRecord);//[新增類別]操作畫面的[新增]按鈕
	            myFrame.myMM_pane.myMMO_pane.myAM_pane.addbtn.addActionListener(ProcessSaveMealRecord); //[新增餐點]操作畫面的[新增]按鈕
	         
	            //[管理餐點]操作畫面類別選單表格監聽事件
	    	    ListSelectionModel lsm=myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectionModel();
	    	    lsm.addListSelectionListener(this);  
	    	    lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	            //[管理餐點]操作畫面餐點選單表格監聽事件
	    	    ListSelectionModel lsm2=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectionModel();
	    	    lsm2.addListSelectionListener(this);  
	    	    lsm2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    	    
	    	    //[管理餐點]查詢畫面類別/餐點查詢切換圓形選擇鈕監聽事件
	    	    myFrame.myMM_pane.myMMQ_pane.myQM_pane.kindradio[0].addActionListener(ProcesskindradioRecord);
	    	    myFrame.myMM_pane.myMMQ_pane.myQM_pane.kindradio[1].addActionListener(ProcesskindradioRecord);
	    	    
	            setClassBtn(); 			//方法:更新[新增餐點]操作畫面的[餐點]按鈕
	            setClassBtnPressed();   //方法:為[新增餐點]操作畫面的[餐點]按鈕加入監聽事件addbtn
	     }
	     //事件傾聽程式: 處理主功能選單選按
	     public ActionListener ProcessFunSelection = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	 /*-登入-*/
	        	 if( e.getSource()==myFrame.mySignIn_pane.btnSign){                    //按下登入
	        		 if(myFrame.mySignIn_pane.Check_SignIn()){   //檢查帳密
	        		  myFrame.mySignIn_pane.setVisible(false);		//隱藏[登入]畫面 
	        		  myFrame.myMenu.setVisible(true);				//顯示[主功能選單資料]操作畫面
			          myFrame.myOR_pane.setVisible(true);           //顯示[新增餐點資料]操作畫面         	 
			          myFrame.mySO_pane.setVisible(true);           //顯示[顯示餐點資料]操作畫面      
                      myFrame.myMM_pane.setVisible(false);          //隱藏[管理餐點]操作畫面
	            	  myFrame.myMS_pane.setVisible(false);          //隱藏[管理員工]操作畫面
	            	  myFrame.myMMA_pane.setVisible(false);			//隱藏[管理物料]操作畫面
	            	  myFrame.myMD_pane.setVisible(false);			//隱藏[管理交易]操作畫面
                      myFrame.myMenu.punBtn.setVisible(true);       //顯示[員工打卡]按鈕
                      myFrame.myMenu.resBtn.setVisible(true);       //顯示[訂位預約]按鈕
                      myFrame.myMenu.scroll.setVisible(true);		//顯示[公告]文字區塊
                      myFrame.myMenu.mealMBtn.setVisible(false);    //隱藏[餐點管理]按鈕
                      myFrame.myMenu.storageMBtn.setVisible(false); //隱藏[物料管理]按鈕
                      myFrame.myMenu.employeeMBtn.setVisible(false);//隱藏[員工管理]按鈕
                      myFrame.myMenu.dealMBtn.setVisible(false);    //隱藏[交易管理]按鈕
                      myFrame.myMenu.forwardBtn.setVisible(false);  //隱藏[前台]按鈕
                      myFrame.myMenu.backBtn.setVisible(true);      //顯示[後台]按鈕
                      JOptionPane.showMessageDialog(null,"登入成功!"); 
	        		 }
	        	 }
	        	 /*-離開-*/
	        	 if( e.getSource()==myFrame.mySignIn_pane.btnExit){
	        		 System.exit(0);
	        	 }
	        	 /*-登出-*/
	        	 if( e.getSource()==myFrame.myMenu.exitBtn){
	            	  System.out.println("2"+myFrame.myMenu.MealIsSelected);

	        		 if(myFrame.myMenu.MealIsSelected==true)
	                      JOptionPane.showMessageDialog(null,"請先清空當前餐點！"); 
	        		 else{
		                  //跳出訊息視窗，詢問使用者是否確認[登出]
		        		 int check=JOptionPane.showConfirmDialog(null,"是否要登出本系統?","確認",
	                                JOptionPane.YES_NO_OPTION,
	                                JOptionPane.INFORMATION_MESSAGE);
		        		 if (check==JOptionPane.YES_OPTION) {
		        			  myFrame.mySignIn_pane.setVisible(true);		//顯示[登入]畫面 
			        		  myFrame.myMenu.setVisible(false);				//隱藏[主功能選單資料]操作畫面
					          myFrame.myOR_pane.setVisible(false);          //隱藏[新增餐點資料]操作畫面         	 
					          myFrame.mySO_pane.setVisible(false);          //隱藏[顯示餐點資料]操作畫面      
			                  myFrame.myMM_pane.setVisible(false);          //隱藏[管理餐點]操作畫面
				              myFrame.myMS_pane.setVisible(false);          //隱藏[管理員工]操作畫面
				              myFrame.myMMA_pane.setVisible(false);			//隱藏[管理物料]操作畫面
				              myFrame.myMD_pane.setVisible(false);			//隱藏[管理交易]操作畫面
			                  myFrame.myMenu.punBtn.setVisible(true);       //顯示[員工打卡]按鈕
		        		 }      			 
	        		 }
	        	 }	        	 
	        	 /*-前台-*/
	              if( e.getSource() == myFrame.myOR_pane.manBtn){
	            	  //紀錄選擇[主人點餐]
	              }
	              if( e.getSource() ==  myFrame.myOR_pane.petBtn){
	            	  //紀錄選擇[寵物點餐]
                  }
	              if(e.getSource() ==  myFrame.myOR_pane.dealBtn){	//[結帳]
	            	  if(myFrame.myOR_pane.Check==true){//判斷使用者是否有選取餐點
	     
	               		  //
		            	  myFrame.myOR_pane.setVisible(false);          //隱藏[新增餐點資料]操作畫面
		            	  setNewNo();
	                      myFrame.myCOM_pane.setVisible(true);          //顯示[結帳餐點資料]操作畫面       
	                      myFrame.myCOM_pane.sumTxtFd.setText( String.valueOf(myFrame.mySO_pane.mySPI_panel.total) );	//將總金額顯示在[結帳資訊]總金額欄位
	                      myFrame.myCOM_pane.amount_lbl.setText( String.valueOf(myFrame.mySO_pane.mySPI_panel.total) );	//將總金額顯示在[結帳資訊]應收金額欄位
	                     //更新結帳編號
	        	 		  
	        	 		  
	            	  }
	            	  else
	                      JOptionPane.showMessageDialog(null,"尚未選取餐點！"); 

	              }
	              if(e.getSource() ==  myFrame.myOR_pane.clearBtn){	//[清除]
            		  /*-清除交易訊息-*/
       	      	   	  //清空表格餐點
                      myFrame.mySO_pane.mySOI_panel.tm.setRowCount(0);
                      myFrame.mySO_pane.mySOI_panel.tm.fireTableDataChanged();
                      myFrame.mySO_pane.mySPI_panel.total=0;							//總金額初始化
                      myFrame.myCOM_pane.total=0;										//實收金額初始化
                      myFrame.myCOM_pane.Banknotes=false;								//布林變數,記錄使用者是否選用紙鈔
                      myFrame.myCOM_pane.Num=false;										//布林變數,紀錄使用者是否直接使用數字鈕點選金額
                      myFrame.myCOM_pane.payTxtFd.setText("");							//清空應收金額欄位
                      myFrame.myOR_pane.Check=false;									//布林變數,紀錄使用者是否有選取餐點
                      myFrame.myMenu.MealIsSelected=false;
                      myFrame.mySO_pane.mySPI_panel.set_totallbl.setText("");			//清空總金額標籤
	            	  myFrame.mySO_pane.mySPI_panel.payinfo_panel.setVisible(false);	//隱藏[結帳資訊]畫面      
	            	  myFrame.mySO_pane.mySPI_panel.welcomelbl.setVisible(true);		//顯示隱藏[歡迎]標籤      
	            	  myFrame.mySO_pane.mySPI_panel.set_totallbl.setVisible(true);		//顯示[總金額]價格標籤
	            	  myFrame.mySO_pane.mySPI_panel.totallbl.setVisible(true);			//顯示[總金額]標籤
                      myFrame.myCOM_pane.setVisible(false);           					//隱藏[結帳餐點資料]操作畫面                    
	            	  myFrame.myOR_pane.setVisible(true);             					//顯示[新增餐點資料]操作畫面  
	            	  System.out.println("1"+myFrame.myMenu.MealIsSelected);
	              }
	              if(e.getSource() ==  myFrame.myCOM_pane.checkbtn){
	            	  boolean money=false;
	            	  try{//判斷實收金額是否為空值
		        		  int check_money=Integer.parseInt( myFrame.myCOM_pane.payTxtFd.getText());		//實收金額
		        		  money=true;
	            	  }
	            	  catch(Exception e1){
	            		  JOptionPane.showMessageDialog(null,"實收金額 不得為空值！"); 
	            		  money=false;
	            	  }
	            	  if(money==true){//當實收金額不為空值
		          		  int amount_money=Integer.parseInt( myFrame.myCOM_pane.amount_lbl.getText());	//應收金額
		        		  int check_money=Integer.parseInt( myFrame.myCOM_pane.payTxtFd.getText());		//實收金額
		        		
		            	  if(check_money>=amount_money){//判斷實收金額是否大於應收金額
		            		  int Total=check_money-amount_money;	//計算找零
		            		  /*顯示相關資訊*/
			            	  myFrame.mySO_pane.mySPI_panel.payinfo_panel.setVisible(true);		//顯示[結帳資訊]畫面       
			            	  myFrame.mySO_pane.mySPI_panel.welcomelbl.setVisible(false);		//隱藏[歡迎]標籤      
			            	  myFrame.mySO_pane.mySPI_panel.set_totallbl.setVisible(false);		//隱藏[總金額]價格標籤
			            	  myFrame.mySO_pane.mySPI_panel.totallbl.setVisible(false);			//隱藏[總金額]標籤
			            	  myFrame.mySO_pane.mySPI_panel.set_dealMoneylbl.setText(String.valueOf(amount_money));	//設置[應收金額]標籤內容
			            	  myFrame.mySO_pane.mySPI_panel.set_paylbl.setText(String.valueOf(check_money));	//設置[實收金額]標籤內容
			            	  myFrame.mySO_pane.mySPI_panel.set_changelbl.setText(String.valueOf(Total));		//設置[找零]標籤內容
			            	  JOptionPane.showMessageDialog(null,"交易完成！");  				//顯示交易完成訊息
		            		  /*將交易資料存入資料庫*/
			            	  
			            	  //-將交易資料寫入資料表-//
			            	  String trans_no=myFrame.myCOM_pane.IDTxtFd.getText();
			            	  String trans_date=myFrame.myCOM_pane.dateTxtFd.getText();	//紀錄交易日期
			            	  int trans_shiff=0;
			            	  String EMPL_id="E010001";
			            	  int trans_ein=123456789;
			            	  int trans_state=0;
			            	  int trans_amount=amount_money;		//紀錄交易金額
			            	  myTrans.setNo(trans_no);
			            	  myTrans.setDate(trans_date);
			            	  myTrans.setShiff(trans_shiff);
			            	  myTrans.setEmplId(EMPL_id);
			                  myTrans.setEin(trans_ein);
			                  myTrans.setStatus(trans_state);
			                  myTrans.setAmount(trans_amount);		  
			                  myBS.insertRD_into_TB_trans(myTrans);   //

			                  //將交易細節寫入資料表
			                  int count=0;
			                  myTl.setNo(trans_no);	//設置該筆交易編號
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
			            	  
			     
			            	  
			            	  
			            	  /*-清除交易訊息-*/
		       	      	   	  //清空表格餐點
		                      myFrame.mySO_pane.mySOI_panel.tm.setRowCount(0);
		                      myFrame.mySO_pane.mySOI_panel.tm.fireTableDataChanged();
		                      myFrame.mySO_pane.mySPI_panel.total=0;//總金額初始化
		                      myFrame.myCOM_pane.total=0;			//實收金額初始化
		                      myFrame.myCOM_pane.Banknotes=false;	//布林變數,記錄使用者是否選用紙鈔
		                      myFrame.myCOM_pane.Num=false;			//布林變數,紀錄使用者是否直接使用數字鈕點選金額
		                      myFrame.myCOM_pane.payTxtFd.setText("");//清空應收金額欄位
		                      myFrame.myOR_pane.Check=false;		//布林變數,紀錄使用者是否有選取餐點
		                      myFrame.myMenu.MealIsSelected=false;
		                      myFrame.mySO_pane.mySPI_panel.set_totallbl.setText("");			//清空總金額標籤
			            	  myFrame.mySO_pane.mySPI_panel.payinfo_panel.setVisible(false);	//隱藏[結帳資訊]畫面      
			            	  myFrame.mySO_pane.mySPI_panel.welcomelbl.setVisible(true);		//顯示隱藏[歡迎]標籤      
			            	  myFrame.mySO_pane.mySPI_panel.set_totallbl.setVisible(true);		//顯示[總金額]價格標籤
			            	  myFrame.mySO_pane.mySPI_panel.totallbl.setVisible(true);			//顯示[總金額]標籤
		                      myFrame.myCOM_pane.setVisible(false);           					//隱藏[結帳餐點資料]操作畫面                    
			            	  myFrame.myOR_pane.setVisible(true);             					//顯示[新增餐點資料]操作畫面  
			            	  /*-將資料存入資料庫-*/
		            	  }
		            	  else
		            		  JOptionPane.showMessageDialog(null,"實收金額 不得小於 應收金額！");  
	            	  }


	              }  
	              //後台,預設進入[管理餐點]畫面
	              if(e.getSource() ==  myFrame.myMenu.backBtn){
			        if(myFrame.myMenu.MealIsSelected==true)
			        		JOptionPane.showMessageDialog(null,"請先清空當前餐點！"); 
			        else{
			        	myFrame.myOR_pane.setVisible(false);           //隱藏[新增餐點資料]操作畫面
	                      myFrame.mySO_pane.setVisible(false);           //隱藏[顯示餐點資料]操作畫面
	                      myFrame.myRE_pane.setVisible(false);           //隱藏[訂位預約資料]操作畫面                   
	                      myFrame.myMenu.punBtn.setVisible(false);       //隱藏[員工打卡]按鈕
	                      myFrame.myMenu.resBtn.setVisible(false);       //隱藏[訂位預約]按鈕
	                      myFrame.myMenu.orderBtn.setVisible(false);      //隱藏[返回點餐]按鈕
	                      myFrame.myMenu.scroll.setVisible(false);		 //隱藏[公告]文字區塊
	                      myFrame.myMM_pane.setVisible(true);            //顯示[管理餐點]操作畫面
	                      myFrame.myMenu.mealMBtn.setVisible(true);      //顯示[餐點管理]按鈕
	                      myFrame.myMenu.storageMBtn.setVisible(true);   //顯示[物料管理]按鈕
	                      myFrame.myMenu.employeeMBtn.setVisible(true);  //顯示[員工管理]按鈕
	                      myFrame.myMenu.dealMBtn.setVisible(true);      //顯示[交易管理]按鈕
	                      myFrame.myMenu.forwardBtn.setVisible(true);    //顯示[前台]按鈕
	                      myFrame.myMenu.backBtn.setVisible(false);      //隱藏[後台]按鈕	 
		            	  myFrame.myMM_pane.myMMO_pane.choose=0; 		 //變數紀錄"新增類別"被選取
		            	  myFrame.myMM_pane.myMMO_pane.myEC_pane.setVisible(false);   //隱藏[編輯類別]操作畫面'	            	  myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(false);   //隱藏[新增餐點]操作畫面
		            	  myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(false);   //隱藏[新增餐點]操作畫面
		            	  myFrame.myMM_pane.myMMO_pane.myEM_pane.setVisible(false);   //隱藏[編輯餐點]操作畫面

		            	  myFrame.myMM_pane.myMMO_pane.myAC_pane.setVisible(true);    //顯示[新增類別]操作畫面

	                      SelectedLastClassTable();		            	 //方法:預設JTable查詢最新十筆資料
	                      myFrame.myMM_pane.myMMQ_pane.mySR_pane.selected=false; //將表格選取判斷設為false
			        }
	            	  

	              }
	              //員工打卡
	              if( e.getSource() == myFrame.myMenu.punBtn){
	            	  PunchTimeCard Punframe= new PunchTimeCard(); 
	            	  ImageIcon img = new ImageIcon(getClass().getResource("peticon.png"));
	              	  Punframe.setIconImage(img.getImage());
                  }	 
	              //訂位預約
	              if( e.getSource() == myFrame.myMenu.resBtn){
		        	if(myFrame.myMenu.MealIsSelected==true)
		        		JOptionPane.showMessageDialog(null,"請先清空當前餐點！"); 
		        	else{
		            	 myFrame.myOR_pane.setVisible(false);           //隱藏[新增餐點資料]操作畫面
		            	 myFrame.myCOM_pane.setVisible(false);          //隱藏[結帳餐點資料]操作畫面            	 
		            	 myFrame.mySO_pane.setVisible(false);           //隱藏[顯示餐點資料]操作畫面            	 
		            	 myFrame.myRE_pane.setVisible(true);            //顯示[訂位預約資料]操作畫面     
		            	 myFrame.myMenu.orderBtn.setVisible(true);		//顯示[返回點餐]按鈕
		            	 myFrame.myMenu.resBtn.setVisible(false);		//隱藏[訂位預約]按鈕 
		        	 }

                  }	 
	              //返回點餐
	              if( e.getSource() == myFrame.myMenu.orderBtn){
		            myFrame.myOR_pane.setVisible(true);            //顯示[新增餐點資料]操作畫面         	 
		            myFrame.mySO_pane.setVisible(true);            //顯示[顯示餐點資料]操作畫面      
		            myFrame.myRE_pane.setVisible(false);           //隱藏[訂位預約資料]操作畫面     
		            myFrame.myMenu.resBtn.setVisible(true);		   //顯示[訂位預約]按鈕
	            	myFrame.myMenu.orderBtn.setVisible(false);	   //隱藏[返回點餐]按鈕            
                  }	 	              
	              /*--後台--*/
	              //前台
	              if(e.getSource() ==  myFrame.myMenu.forwardBtn){
	            	  myFrame.myOR_pane.setVisible(true);           //顯示[新增餐點資料]操作畫面
                      myFrame.mySO_pane.setVisible(true);           //顯示[顯示餐點資料]操作畫面
                      myFrame.myMM_pane.setVisible(false);          //隱藏[管理餐點]操作畫面
	            	  myFrame.myMS_pane.setVisible(false);          //隱藏[管理員工]操作畫面
	            	  myFrame.myMMA_pane.setVisible(false);			//隱藏[管理物料]操作畫面
	            	  myFrame.myMD_pane.setVisible(false);			//隱藏[管理交易]操作畫面
                      myFrame.myMenu.punBtn.setVisible(true);       //顯示[員工打卡]按鈕
                      myFrame.myMenu.resBtn.setVisible(true);       //顯示[訂位預約]按鈕
                      myFrame.myMenu.scroll.setVisible(true);		//顯示[公告]文字區塊
                      myFrame.myMenu.mealMBtn.setVisible(false);    //隱藏[餐點管理]按鈕
                      myFrame.myMenu.storageMBtn.setVisible(false); //隱藏[物料管理]按鈕
                      myFrame.myMenu.employeeMBtn.setVisible(false);//隱藏[員工管理]按鈕
                      myFrame.myMenu.dealMBtn.setVisible(false);    //隱藏[交易管理]按鈕
                      myFrame.myMenu.forwardBtn.setVisible(false);  //隱藏[前台]按鈕
                      myFrame.myMenu.backBtn.setVisible(true);      //顯示[後台]按鈕	          
                      
                      setClassBtn();								//更新前台[點餐畫面]選項
  	    	 		  myFrame.myOR_pane.man_deal = true;			//true表示主人餐點被選取

	              }
	              //管理餐點
	              if( e.getSource() == myFrame.myMenu.mealMBtn){
                      myFrame.myMM_pane.setVisible(true);           //顯示[管理餐點]查詢畫面
	            	  myFrame.myMS_pane.setVisible(false);          //隱藏[管理員工]操作畫面             
	            	  myFrame.myMMA_pane.setVisible(false);		    //隱藏[管理物料]操作畫面
	            	  myFrame.myMD_pane.setVisible(false);			//隱藏[管理交易]操作畫面				
                      myFrame.myMenu.forwardBtn.setVisible(true);   //顯示[前台]按鈕
                      myFrame.myMenu.backBtn.setVisible(false);     //隱藏[後台]按鈕
	            	  myFrame.myMM_pane.myMMO_pane.choose=0; 		//變數紀錄"新增類別"被選取
                      SelectedLastClassTable();                	    //方法:預設JTable查詢最新十筆資料
                      myFrame.myMM_pane.myMMQ_pane.mySR_pane.selected=false; //將判斷選取變數設為false

                  }	   
	              //管理員工
	              if( e.getSource() == myFrame.myMenu.employeeMBtn){
	            	  myFrame.myMS_pane.setVisible(true); 			 //顯示[管理員工]操作畫面
                      myFrame.myMM_pane.setVisible(false);           //隱藏[管理餐點]查詢畫面
	            	  myFrame.myMMA_pane.setVisible(false);			 //隱藏[管理物料]操作畫面
	            	  myFrame.myMD_pane.setVisible(false);			 //隱藏[管理交易]操作畫面	
                      myFrame.myMenu.backBtn.setVisible(false);      //隱藏[後台]按鈕	   
                      myFrame.myMenu.forwardBtn.setVisible(true);    //顯示[前台]按鈕   	  
	              }	
	              //管理物料
	              if( e.getSource() == myFrame.myMenu.storageMBtn){
	            	  myFrame.myMMA_pane.setVisible(true); 			 //顯示[管理物料]操作畫面
                      myFrame.myMM_pane.setVisible(false);           //隱藏[管理餐點]查詢畫面
	            	  myFrame.myMS_pane.setVisible(false); 			 //隱藏[管理員工]操作畫面
	            	  myFrame.myMD_pane.setVisible(false);			 //隱藏[管理交易]操作畫面	
                      myFrame.myMenu.backBtn.setVisible(false);      //隱藏[後台]按鈕	   
                      myFrame.myMenu.forwardBtn.setVisible(true);    //顯示[前台]按鈕   	  
	              }	
	              //管理交易
	              if( e.getSource() == myFrame.myMenu.dealMBtn){
	            	  myFrame.myMD_pane.setVisible(true); 	      	 //顯示[管理交易]操作畫面
	            	  myFrame.myMMA_pane.setVisible(false); 		 //隱藏[管理物料]操作畫面
                      myFrame.myMM_pane.setVisible(false);           //隱藏[管理餐點]查詢畫面
	            	  myFrame.myMS_pane.setVisible(false); 			 //隱藏[管理員工]操作畫面															 	
                      myFrame.myMenu.backBtn.setVisible(false);      //隱藏[後台]按鈕	   
                      myFrame.myMenu.forwardBtn.setVisible(true);    //顯示[前台]按鈕   	  
	              }	
	              if( e.getSource() == myFrame.myMM_pane.myMMO_pane.addclassbtn){
	            	 //管理餐點-新增類別
	            	  myFrame.myMM_pane.myMMO_pane.myAC_pane.setVisible(true);    //顯示[新增類別]操作畫面
	            	  myFrame.myMM_pane.myMMO_pane.myEC_pane.setVisible(false);   //隱藏[編輯類別]操作畫面
	            	  myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(false);   //隱藏[新增餐點]操作畫面
	            	  myFrame.myMM_pane.myMMO_pane.myEM_pane.setVisible(false);   //隱藏[編輯餐點]操作畫面
	            	  myFrame.myMM_pane.myMMO_pane.mmdef_panel.setVisible(false); //隱藏[編輯餐點]操作畫面

	            	  myFrame.myMM_pane.myMMO_pane.choose=0; 					  //變數紀錄"新增類別"被選取

	              }		
	              if( e.getSource() == myFrame.myMM_pane.myMMO_pane.revclassbtn){
	            	  //管理餐點-編輯類別
	            	  myFrame.myMM_pane.myMMO_pane.choose=1; 					  //變數紀錄"編輯類別"被選取

	            	  if(myFrame.myMM_pane.myMMQ_pane.mySR_pane.selected==true){//判斷JTable是否被選取
		            	  myFrame.myMM_pane.myMMO_pane.myEC_pane.setVisible(true);     //顯示[編輯類別]操作畫面
		            	  myFrame.myMM_pane.myMMO_pane.myAC_pane.setVisible(false);    //隱藏[新增類別]操作畫面
		            	  myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(false);    //隱藏[新增餐點]操作畫面
		            	  myFrame.myMM_pane.myMMO_pane.myEM_pane.setVisible(false);    //隱藏[編輯餐點]操作畫面
		            	  myFrame.myMM_pane.myMMO_pane.mmdef_panel.setVisible(false);  //隱藏[編輯餐點]操作畫面
		            	  myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=true;	   //編輯類別的getenable變數設為true,編輯類別欄位才可以被選取顯示
		            	  myFrame.myMM_pane.myMMO_pane.myEM_pane.getenable=false;	   //編輯餐點的getenable變數設為false,使編輯餐點欄位不可以被選取顯示
		            	//  ShowEditClassRecord();	//方法:將當前選取的表格資料顯示在右邊欄位
	            	  }
	            	  else{
	            		  System.out.print("無資料被選取");
 	                	   JOptionPane.showMessageDialog(null,"請先至左方查詢結果選取一筆資料!");
	            	  }

	              }		              
	              if( e.getSource() == myFrame.myMM_pane.myMMO_pane.addmealsbtn){
	            	  //管理餐點-新增餐點
	            	  myFrame.myMM_pane.myMMO_pane.choose=2; 					  //變數紀錄"新增類別"被選取
		    		  myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;	  //將變數設為false,當按下查詢時關閉資料顯示方法否則會出錯
		    		  myFrame.myMM_pane.myMMO_pane.myEM_pane.getenable=false;	  //將變數設為false,當按下查詢時關閉資料顯示方法否則會出錯

	            	  myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(true);    //顯示[新增餐點]操作畫面
	            	  myFrame.myMM_pane.myMMO_pane.myEC_pane.setVisible(false);   //隱藏[編輯類別]操作畫面
	            	  myFrame.myMM_pane.myMMO_pane.myAC_pane.setVisible(false);   //隱藏[新增類別]操作畫面
	            	  myFrame.myMM_pane.myMMO_pane.myEM_pane.setVisible(false);   //隱藏[編輯餐點]操作畫面
	            	  myFrame.myMM_pane.myMMO_pane.mmdef_panel.setVisible(false); //隱藏[編輯餐點]操作畫面

	            	  update_MealOfClass();										  //更新[新增餐點]之類別欄位
	            	  update_MealOfMaterials();	   								  //更新[新增餐點]之物料欄位
	            	  
	            	  myFrame.myMM_pane.myMMO_pane.choose=2; 					  //變數紀錄"新增餐點"被選取

	              }	
	              if( e.getSource() == myFrame.myMM_pane.myMMO_pane.revmealsbtn){
	            	  myFrame.myMM_pane.myMMO_pane.choose=3; 					  //變數紀錄"編輯餐點"被選取
	            	  //管理餐點-編輯餐點
	            	  if(myFrame.myMM_pane.myMMQ_pane.mySR_pane.selected==true){//判斷JTable是否被選取
		            	  myFrame.myMM_pane.myMMO_pane.myEM_pane.setVisible(true);     //顯示[編輯餐點]操作畫面
		            	  myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(false);    //隱藏[新增餐點]操作畫面
		            	  myFrame.myMM_pane.myMMO_pane.myEC_pane.setVisible(false);    //隱藏[編輯類別]操作畫面
		            	  myFrame.myMM_pane.myMMO_pane.myAC_pane.setVisible(false);    //隱藏[新增類別]操作畫面
		            	  myFrame.myMM_pane.myMMO_pane.mmdef_panel.setVisible(false);  //隱藏[編輯餐點]操作畫面
		            	  
		            	  myFrame.myMM_pane.myMMO_pane.myEM_pane.getenable=true;	   //編輯類別的getenable變數設為true,編輯餐點欄位才可以被選取顯示
		            	  myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;	   //編輯餐點的getenable變數設為false,使編輯類別欄位不可以被選取顯示
		            	//  ShowEditClassRecord();	//方法:將當前選取的表格資料顯示在右邊欄位
	            	  }
	            	  else{
	            		  System.out.print("無資料被選取");
 	                	   JOptionPane.showMessageDialog(null,"請先至左方查詢結果選取一筆資料!");
	            	  }

	            	  Edit_MealOfMaterials();										//更新[編輯餐點]之物料欄位
	              }	
	              if( e.getSource() == myFrame.myMS_pane.myMSO_pane.addstaffbtn){
	            	  //管理員工-新增員工
	            	  myFrame.myMS_pane.myMSO_pane.myAS_pane.setVisible(true);     //顯示[新增員工]操作畫面
	            	  myFrame.myMS_pane.myMSO_pane.myES_pane.setVisible(false);    //隱藏[編輯員工]操作畫面
	              }	     
	              if( e.getSource() == myFrame.myMS_pane.myMSO_pane.revstaffbtn){
	            	  //管理員工-編輯員工
	            	  myFrame.myMS_pane.myMSO_pane.myES_pane.setVisible(true);     //顯示[編輯員工]操作畫面
	            	  myFrame.myMS_pane.myMSO_pane.myAS_pane.setVisible(false);    //隱藏[新增員工]操作畫面

	              }	                 
	         }    
	     };	     

	     //事件傾聽程式: 處理類別按鈕選按
	     public ActionListener ProcessMealsSelection = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	 String[][] class_no=get_man_in_front_ClassNo();	    //取得類別編號
	        	 String[][] class_no_pet=get_pet_in_front_ClassNo();	//取得類別編號
	        	 String[][] meals;									    //用來記錄餐點
  	    	     JButton itemBtn[][]=new JButton[5][7];			        //餐點按鈕
  	    	     JPanel[] pane=new JPanel[20];
		         JPanel []pp=new JPanel[20];
	        	 int index_record=0;
	        	 String myOrder[]=new String[3];						//字串陣列,用來儲存點選餐點資訊(名稱,單價,分類)
	    		 
				 CHCI_CM_frame myCM_frame=new CHCI_CM_frame(); 			//餐點選擇視窗
	        	 ImageIcon img = new ImageIcon(getClass().getResource("peticon.png"));
	        	 myCM_frame.setIconImage(img.getImage());


	    	     //事件傾聽程式: 取得點選餐點之資料
		      	 ActionListener ProcessMealsOrderSelection = new ActionListener(){
   		    		public void actionPerformed(ActionEvent e){
   		    			for(int x=0;x<itemBtn.length;x++){
   		    				for(int y=0;y<itemBtn[0].length;y++){
   		    					if(e.getSource()==	itemBtn[x][y])
   		    					{
   		    					   //將按鈕顏色設回預設狀態
 			            		   for(int a=0;a<itemBtn.length;a++){
 		            					for(int b=0;b<itemBtn[0].length;b++){	
 		            						if((a+2)%2!=0)
 		            							itemBtn[a][b].setBackground(new Color(255, 146, 20));
 		            						else
 		            							itemBtn[a][b].setBackground(new Color(255, 87, 87));		
 		            					}
 			            		   }
 			            		   //將被選取的按鈕設置不同的顏色
   		    						itemBtn[x][y].setBackground(new Color(46, 199, 255));
   		    						//將餐點選取狀態設為true
   		    						myCM_frame.myCM_pane.myCNSI_pane.MealIsSelected=true;
   		    						System.out.println("目前點選的餐點是:"+itemBtn[x][y].getText());
   		    						String s1 = itemBtn[x][y].getText();
   		    						//判斷餐點字串是否有使用html語法
   		    						if(s1.indexOf("<")>-1){
   		    							//清除"<html>&nbsp;"字串
   	   		    						int i=s1.indexOf("<");
   	   		    						int j=s1.indexOf(";");
   	   		    					    s1=s1.substring(0, i)+s1.substring(j+1);
   	   		    					    //清除"&nbsp;"字串
   	   		    					    int k=s1.indexOf("&");
   	   		    					    int l=s1.indexOf(";");
   	   		    					    s1=s1.substring(0, k)+s1.substring(l+1);
   	   		    					    //清除"<br>"字串
   	   		    					    int m=s1.indexOf("<");
   	   		    					    int n=s1.indexOf(">");
   	   		    					    s1=s1.substring(0, m)+s1.substring(n+1);
   	   		    					    //清除"</html>"字串
   	   		    					    int o=s1.indexOf("<");
   	   		    					    int p=s1.indexOf(">");
   	   		    					    s1=s1.substring(0, o)+s1.substring(p+1);
   	   		    						System.out.println(s1);

   		    						}
   		    						else{
   	   		    						System.out.println(s1);

   		    						}
   		    						//傳入一筆餐點名稱,從資料庫抓取該餐點名稱,價格
   		    						String Order[]=myDBMA.findMeal_in_TB_meal(s1);
   		    						
   		    						myOrder[0] = Order[0]; //myOrde[0]取得將餐點名稱
   		    						myOrder[1] = Order[1]; //myOrder[1]取得將餐點價格
   		    						myOrder[2] = Order[2]; //myOrder[2]取得將餐點分類

   		    						System.out.println("名稱:"+myOrder[0]);
   		    						System.out.println("價格:"+myOrder[1]);	
   		    						//當餐點改變時,將數量初始化
   		    		    			myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.setText("");	//將數量標籤初始化
   		    		    			myCM_frame.myCM_pane.myCNSI_pane.ones_numlbl.setText("");	//將數量標籤初始化
   		    		    			myCM_frame.myCM_pane.myCNSI_pane.num=1;						//將數量紀錄變數初始化
   		    		    			myCM_frame.myCM_pane.myCNSI_pane.set_namelbl.setText(myOrder[0]);	//將餐點名稱標籤初始化
   		    		    			myCM_frame.myCM_pane.myCNSI_pane.set_pricelbl.setText(myOrder[1]);  //將餐點價格標籤初始化		 	  
   		    		    			myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText("");	//將小計標籤初始化
					   		    	myCM_frame.myCM_pane.myCNSI_pane.back_times=0;						//記錄倒退歸0

					   		    	myCM_frame.myCM_pane.myCNSI_pane.MealIsInsert=false;	//當前有選取餐點
   		    					}
   		    				}
   		    			}
   	

   		    		}	
   		    	 };
	    	     //事件傾聽程式: 顯示餐點價格小計
		      	 ActionListener ShowSubTotal = new ActionListener(){
   		    		public void actionPerformed(ActionEvent e){
   		    				if(myCM_frame.myCM_pane.myCNSI_pane.MealIsSelected==true){
   		    					int single_price=Integer.valueOf(myOrder[1]).intValue(); 

   	   		    				for(int x=0;x<myCM_frame.myCM_pane.myCNSI_pane.calBtn.length;x++){
   	   		    					for(int y=0;y<myCM_frame.myCM_pane.myCNSI_pane.calBtn[0].length;y++){
   	   		    						if( e.getSource() == myCM_frame.myCM_pane.myCNSI_pane.calBtn[x][y]){
   	   		    							if(x==3 && y==1 ){	//使用者按下[清除]
   	   	   		 	   		    				myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText("");				//清空小計標籤
   	   					   		    			break;
   	   		    							}
   	   	   		 	   		    			if( x==3 && y==2){	//使用者按下[倒退]
   	   		    								String str=myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.getText();
   	   		    								if(str=="" || myCM_frame.myCM_pane.myCNSI_pane.back_times==1){
   		   	   		 	   		    				myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText("");		    //清空小計標籤
   	   	   					   		    			myCM_frame.myCM_pane.myCNSI_pane.back_times=0;						//記錄倒退歸0

   	   		    								}
   		   	   		 	   		    			else{
   	   		    									int price_1=Integer.valueOf(myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.getText()).intValue(); 
   	   		    									String price_str2=myCM_frame.myCM_pane.myCNSI_pane.ones_numlbl.getText();
   	   		    									if(price_str2 == null){
   	   		   	   		 	   		    				myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText("");		    //清空小計標籤

   	   		    									}
   	   		    									else{
   	   		    										int subtotal=price_1*single_price;
   	   	   	   					   		    			String subtotal_str=String.valueOf(subtotal); 
   	   	   	   					   		    			myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText(subtotal_str);	//將小計價格寫入JLable   
   	   	   	   					   		    			myCM_frame.myCM_pane.myCNSI_pane.back_times++;						//記錄使用者已點選一次倒退
   	   		    									}
   	   		    									
   	   		    								} 	   					   		    		
   	   					   		    			break;
   	   		    							}
   		   		 	   		    			if(myCM_frame.myCM_pane.myCNSI_pane.num>0 ){
   		   				   		    			//即時計算總價
   		   			   							if(myCM_frame.myCM_pane.myCNSI_pane.num==1){
   		   	   		    							int price_1=Integer.parseInt(myCM_frame.myCM_pane.myCNSI_pane.calBtn[x][y].getText()); 
   		   	   		    							int subtotal=price_1*single_price;
   		   	   		    							String subtotal_str=String.valueOf(subtotal); 
   		   	   		 	   		    				myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText(subtotal_str);	//將餐小計價格稱寫入JLable

   		   			   							}
   		   			   							
   		   			   							if(myCM_frame.myCM_pane.myCNSI_pane.num==2){	
   		   					   		    			int price_1=Integer.valueOf(myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.getText()).intValue(); 
   		   	   		    							int price_2=Integer.parseInt(myCM_frame.myCM_pane.myCNSI_pane.calBtn[x][y].getText()); 
   		   						    				int subtotal=(price_1*10+price_2)*single_price;
   		   	   		    							String subtotal_str=String.valueOf(subtotal); 
   		   	   		 	   		    				myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText(subtotal_str);	//將小計價格寫入JLable
   		   			   							}
   		
   		   			   						}

   	   		    						}
   	   		    					}
   	   		    				}
   		   		    			
   		    				}
	   		    		

   		    			}
   		    	};
	    	     //事件傾聽程式: 新增餐點
		      	 ActionListener OrderCheck = new ActionListener(){
  		    		public void actionPerformed(ActionEvent e){
  		    			//當使用者按下[新增],記錄一筆餐點至前台JTable
  		    			if(e.getSource()==myCM_frame.myCM_pane.myCNSI_pane.chBtn){//使用者在餐點版面按下新增
  		    				if(myCM_frame.myCM_pane.myCNSI_pane.selectedNum==false){
  		    					JOptionPane.showMessageDialog(null,"資料輸入不完全,請再次檢查!");
  		    				}
  		    				else{
  	  		    				String subtotalStr=myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.getText();	//取得該必餐點小計
  	  		    				String numStr="";
				   		    	myFrame.mySO_pane.mySPI_panel.total+= Integer.parseInt(subtotalStr);//將當前價格加總
				   		    	myCM_frame.myCM_pane.myCNSI_pane.MealIsInsert=true;					//當前選取餐點已被新增
				   		        myFrame.myOR_pane.Check=true;										//將Check設為true,代表當前已新增可以結帳
				   		    	myFrame.mySO_pane.mySPI_panel.set_totallbl.setText( String.valueOf(myFrame.mySO_pane.mySPI_panel.total));
  	  		    				//取得餐點數量
  	  		    				if(myCM_frame.myCM_pane.myCNSI_pane.num==1){
  	  								 numStr=myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.getText(); 
  	  		    				}
  	  		    				else {
  	  		    					 String str1=myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.getText();  
  	  		    					 String str2=myCM_frame.myCM_pane.myCNSI_pane.ones_numlbl.getText();
  	  								 numStr=str1+str2;

  	  		    				}
  	  		    				
  	  		    				System.out.println("新增一筆餐點:");
  	  		    				System.out.println("名稱:"+myOrder[0]);
  	  		    				System.out.println("單價:"+myOrder[1]);
  	  		    				System.out.println("分類:"+myOrder[2]);
  	  		    				System.out.println("數量:"+numStr);
  	  		    				System.out.println("小計:"+subtotalStr);		
  		    				
		        	 			//將資料寫入JTable
  	  		    			    myFrame.mySO_pane.mySOI_panel.tm.addRow(new Object[]{myOrder[0],myOrder[2],myOrder[1],numStr,subtotalStr});	//將[查詢結果]寫入JTable
				                //更新JTable 的內容
  	  		    			    myFrame.mySO_pane.mySOI_panel.tm.fireTableDataChanged();	
			                    myFrame.mySO_pane.mySOI_panel.orderTable.updateUI();
		        	 		    
			                    
			                    //設定初始化
		    					   //將按鈕顏色設回預設狀態
			            		for(int a=0;a<itemBtn.length;a++){
		            				for(int b=0;b<itemBtn[0].length;b++){	
		            					if((a+2)%2!=0)
		            						itemBtn[a][b].setBackground(new Color(255, 146, 20));
		            					else
		            						itemBtn[a][b].setBackground(new Color(255, 87, 87));		
		            					}
			            		}
		    					
			            		//將myFrame.myMenu.MealIsSelected設為true,記錄使用者至少選取一筆餐點
			            		myFrame.myMenu.MealIsSelected=true;

		    					//將餐點選取狀態設為false
		    					myCM_frame.myCM_pane.myCNSI_pane.MealIsSelected=false;
			   		         	myCM_frame.myCM_pane.myCNSI_pane.set_namelbl.setText("");
			   		         	myCM_frame.myCM_pane.myCNSI_pane.set_pricelbl.setText("");
			   		         	myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText("");
			   		      		myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.setText("");
			   		   			myCM_frame.myCM_pane.myCNSI_pane.ones_numlbl.setText("");
			   					myCM_frame.myCM_pane.myCNSI_pane.num=1;
			   					myCM_frame.myCM_pane.myCNSI_pane.selectedNum=false;
				   		    	System.out.println("總價:"+myFrame.mySO_pane.mySPI_panel.total);

  		    				}
  		    				
  		    			}
  		    	
   	                	   
  		    		}
  		    	};
   		    	 
   		    	 
   		      //事件傾聽程式: 重選
		      	 ActionListener ProcessMealsReSelection = new ActionListener(){
   		    		public void actionPerformed(ActionEvent e){
	   		         	if(e.getSource()==myCM_frame.myCM_pane.myCNSI_pane.rechBtn){
	    					   //將按鈕顏色設回預設狀態
		            		for(int a=0;a<itemBtn.length;a++){
	            				for(int b=0;b<itemBtn[0].length;b++){	
	            					if((a+2)%2!=0)
	            						itemBtn[a][b].setBackground(new Color(255, 146, 20));
	            					else
	            						itemBtn[a][b].setBackground(new Color(255, 87, 87));		
	            					}
		            		}
			   		    	myCM_frame.myCM_pane.myCNSI_pane.MealIsInsert=true;	//當前選取餐點已被重選,不必新增

	    					//將餐點選取狀態設為false
	    					myCM_frame.myCM_pane.myCNSI_pane.MealIsSelected=false;
	    					myFrame.myMenu.MealIsSelected=false;
		   		         	myCM_frame.myCM_pane.myCNSI_pane.set_namelbl.setText("");
		   		         	myCM_frame.myCM_pane.myCNSI_pane.set_pricelbl.setText("");
		   		         	myCM_frame.myCM_pane.myCNSI_pane.set_sumlbl.setText("");
		   		      		myCM_frame.myCM_pane.myCNSI_pane.tens_numlbl.setText("");
		   		   			myCM_frame.myCM_pane.myCNSI_pane.ones_numlbl.setText("");
		   					myCM_frame.myCM_pane.myCNSI_pane.num=1;
		   					myCM_frame.myCM_pane.myCNSI_pane.selectedNum=false;
			   		        myFrame.myOR_pane.Check=true;										//將Check設為false,代表不可結帳

	   		         	}
   		    		}
   		    	};
   		    	/*--加入監聽事件--*/
  		    	 for(int x=0;x<myCM_frame.myCM_pane.myCNSI_pane.calBtn.length;x++){
		    	 		for(int y=0;y<myCM_frame.myCM_pane.myCNSI_pane.calBtn[0].length;y++){	
		    	 			myCM_frame.myCM_pane.myCNSI_pane.calBtn[x][y].addActionListener(ShowSubTotal);	//數字鍵加入監聽事件
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
	  		                    JOptionPane.showMessageDialog(null,"當前選取餐點尚未新增!");
	  		        	}
	  		        		
	  		        }
	  		    };
   		    	myCM_frame.myCM_pane.myCNSI_pane.rechBtn.addActionListener(ProcessMealsReSelection);		//為重選按鈕加入監聽事件
   		    	myCM_frame.myCM_pane.myCNSI_pane.chBtn.addActionListener(OrderCheck);	    				//為新增按鈕加入監聽事件	 
   		    	myCM_frame.myCM_pane.myCNSI_pane.backBtn.addActionListener(PressedBackbtn);	    			//為返回按鈕加入監聽事件	 

   		    	for(int x=0;x<myFrame.myOR_pane.mealBtn.length;x++){
		    	 		for(int y=0;y<myFrame.myOR_pane.mealBtn[0].length;y++){	
		    	 			if( e.getSource() == myFrame.myOR_pane.mealBtn[x][y] ){
		    	 				System.out.print(myFrame.myOR_pane.man_deal);
		    	 				if(myFrame.myOR_pane.man_deal==true){		            //true表示主人餐點被選取
		    	 				   meals=myDBMA.findMEAL_in_TB_meal(class_no[x][y]);    //查詢點選類別的餐點資料
		    	 				   changeLine(meals);	                                //餐點按鈕顯示調整
		    	 				   myCM_frame.isOpen=true;
		    	 				   myCM_frame.setVisible(true);
			            	       //頁籤更新
			            	       String []myTap=myDBMA.findClass_in_TB_class();	    //查詢所有分類為'主人'且狀態為'開啟'的類別名稱,並回傳
			            	       String []myTapCLSno=myDBMA.findClassNo_in_TB_class();//查詢所有分類為'主人'且狀態為'開啟'的類別編號,並回傳
	
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
			            	    
				            	       myCM_frame.myCM_pane.myOM_pane.item_tabpanel.addTab(myTap[z],pane[z]);	//加入頁籤

			            	       }//end for myFrame.myOR_pane.mealBtn[x][y].setEnabled(false);	//將資料庫現有類別更新到前台

			            	       //直接判斷進入的類別,取得類別編號,傳入資料庫取得名稱,將該類別頁籤餐點顯示
			            		   for(int a=0;a<itemBtn.length;a++){
		            					for(int b=0;b<itemBtn[0].length;b++){	
		            						itemBtn[a][b]=new JButton(meals[a][b]);
		            						itemBtn[a][b].setFont(new Font("正黑體",0,16));
		            						itemBtn[a][b].addActionListener(ProcessMealsOrderSelection);

		            						if((a+2)%2!=0)
		            							itemBtn[a][b].setBackground(new Color(255, 146, 20));
		            						else
		            							itemBtn[a][b].setBackground(new Color(255, 87, 87));		
		            					//	pane[x+y].add(itemBtn[a][b]);
		            					}
			            		   }

			            	       /*判斷該頁籤是否存在,若存在則移至特定頁籤,並顯示其對應餐點*/
			                       if(x==1){
			                    	   try{
			                    		   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y+4);	//選擇頁籤
					            		   for(int a=0;a<itemBtn.length;a++){
				            					for(int b=0;b<itemBtn[0].length;b++){	
				            						pane[x+y+4].add(itemBtn[a][b]);
				            					}
					            		   }
			                    	   }catch(Exception e1){
			      	                	   JOptionPane.showMessageDialog(null,"該格尚未設置類別,請至後台新增!");
			      	                 	   JOptionPane.showMessageDialog(null,">>系統將為您跳至'"+myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getTitleAt(0)+"'");		      	                 	 
					      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(0);	//選擇頁籤
					      	     
			      	                   } 
			      	           	   }
			                       else if(x==2){
			                    	   try{
			                    		   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y+8);	//選擇頁籤
					            		   for(int a=0;a<itemBtn.length;a++){
				            					for(int b=0;b<itemBtn[0].length;b++){	
				            						pane[x+y+8].add(itemBtn[a][b]);
				            					}
					            		   }
			      	                   }catch(Exception e1){
			      	                	   JOptionPane.showMessageDialog(null,"該格尚未設置類別,請至後台新增!");
			      	                 	   JOptionPane.showMessageDialog(null,">>系統將為您跳至'"+myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getTitleAt(0)+"'");		      	                 	 
					      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(0);	//選擇頁籤

			      	                   }
			      	           	   }
			                       else if(x==3){
			                    	   try{
			                    		   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y+12);	//選擇頁籤
					            		   for(int a=0;a<itemBtn.length;a++){
				            					for(int b=0;b<itemBtn[0].length;b++){	
				            						pane[x+y+12].add(itemBtn[a][b]);
				            					}
					            		   }
			                    	   }catch(Exception e1){
			      	                	   JOptionPane.showMessageDialog(null,"該格尚未設置類別,請至後台新增!");
			      	                 	   JOptionPane.showMessageDialog(null,">>系統將為您跳至'"+myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getTitleAt(0)+"'");		      	                 	 
					      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(0);	//選擇頁籤

			      	                   }
			      	           	   }
			                       else{
				      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y);	//選擇頁籤
				            		   for(int a=0;a<itemBtn.length;a++){
			            					for(int b=0;b<itemBtn[0].length;b++){	
			            						pane[x+y].add(itemBtn[a][b]);
			            					}
				            		   }
			                       }
			                       //監聽事件:偵測頁籤切換
			            	       myCM_frame.myCM_pane.myOM_pane.item_tabpanel.addChangeListener(new ChangeListener() {
			    	 			        public void stateChanged(ChangeEvent e) {
			    	 			        	int num=myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getSelectedIndex();	//取得當前選擇頁籤索引值,並用變數num紀錄
			    	 			        	String numStr=Integer.toString(num); 										//將整數num轉為字串,並設定給numStr
			    	 			        	String [][]new_meals=myDBMA.findMEAL_in_TB_meal(myTapCLSno[num]);			//傳入一筆類別編號至資料庫中的findMEAL_in_TB_meal()方法,並回傳一筆餐點名稱資料
			    	 			        	 for(int a=0;a<itemBtn.length;a++){//重新設定餐點名稱
					            					for(int b=0;b<itemBtn[0].length;b++){	
					            						System.out.println("傳入前顯示:"+new_meals[a][b]);
						            						changeLine(new_meals);	//傳入一筆餐點名稱,判斷是否需要換行						            					
						            						if(itemBtn[a][b].getText()!="")
							            						System.out.println("按鈕上顯示:"+new_meals[a][b]);
						            					itemBtn[a][b].setText(new_meals[a][b]);
					            						pp[num].add(itemBtn[a][b]);	//將按鈕加入pp(JPanel)
					            					}
			    	 			        	 }
			    	 			        	pp[num].setVisible(true);	//將pp設為顯示
						                    myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setComponentAt(num,pp[num]);//更新頁籤

			    	 			        }
			    	 			    });			      	           	   
			                    }//end if(myFrame.myOR_pane.man_deal==true)
		    	 				

		    	 				else {	//false表示寵物餐點 被選取
		    	 					   meals=myDBMA.findMEAL_in_TB_meal(class_no_pet[x][y]);//查詢點選類別的餐點資料
		    	 				       changeLine(meals);	                                //餐點按鈕顯示調整
			    	 			//	   CHCI_CM_frame myCM_frame=new CHCI_CM_frame(); 
			    	 				   myCM_frame.isOpen=true;
			    	 				   myCM_frame.setVisible(true);
				            	       String []myTap=myDBMA.findClassPet_in_TB_class();	
				            	       String []myTapCLSno_pet=myDBMA.findClassNoOfPet_in_TB_class();//查詢所有分類為'寵物'且狀態為'開啟'的類別編號,並回傳				            	       
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
			            				 		System.out.println("寵物餐點"+meals[a][b]);
			            				 		itemBtn[a][b]=new JButton(meals[a][b]);
			            				 		itemBtn[a][b].setFont(new Font("正黑體",0,16));		
			            						itemBtn[a][b].addActionListener(ProcessMealsOrderSelection);
			            				 		if((a+2)%2!=0)
			            				 			itemBtn[a][b].setBackground(new Color(255, 146, 20));
			            						else
			            							itemBtn[a][b].setBackground(new Color(255, 87, 87));		
			            						//pane[z].add(itemBtn[a][b]);
			            					}
			            			   }
			   
				            	       /*判斷該頁籤是否存在,若存在,移至特定頁籤*/
				                       if(x==1){
				                    	   try{
				                    		   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y+4);	//選擇頁籤
					            			   for(int a=0;a<itemBtn.length;a++){
					            					for(int b=0;b<itemBtn[0].length;b++){	
					            						pane[x+y+4].add(itemBtn[a][b]);
					            					}
					            			   }     
				                    	   }catch(Exception e1){
				      	                	   JOptionPane.showMessageDialog(null,"該格尚未設置類別,請至後台新增!");
				      	                 	   JOptionPane.showMessageDialog(null,">>系統將為您跳至'"+myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getTitleAt(0)+"'");		      	                 	 
						      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(0);	//選擇頁籤

				      	                   } 
				      	           	   }
				                       else if(x==2){
				                    	   try{
				                    		   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y+8);	//選擇頁籤
					            			   for(int a=0;a<itemBtn.length;a++){
					            					for(int b=0;b<itemBtn[0].length;b++){	
					            						pane[x+y+8].add(itemBtn[a][b]);
					            					}
					            			   }     
				                    	   }catch(Exception e1){
				      	                	   JOptionPane.showMessageDialog(null,"該格尚未設置類別,請至後台新增!");
				      	                 	   JOptionPane.showMessageDialog(null,">>系統將為您跳至'"+myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getTitleAt(0)+"'");		      	                 	 
						      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(0);	//選擇頁籤

				      	                   }
				      	           	   }
				                       else if(x==3){
				                    	   try{
				                    		   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y+12);	//選擇頁籤
					            			   for(int a=0;a<itemBtn.length;a++){
					            					for(int b=0;b<itemBtn[0].length;b++){	
					            						pane[x+y+12].add(itemBtn[a][b]);
					            					}
					            			   }     
				                    	   }catch(Exception e1){
				      	                	   JOptionPane.showMessageDialog(null,"該格尚未設置類別,請至後台新增!");
				      	                 	   JOptionPane.showMessageDialog(null,">>系統將為您跳至'"+myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getTitleAt(0)+"'");		      	                 	 
						      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(0);	//選擇頁籤

				      	                   }
				      	           	   }
				                       else{
					      	           	   myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setSelectedIndex(x+y);	//選擇頁籤
				            			   for(int a=0;a<itemBtn.length;a++){
				            					for(int b=0;b<itemBtn[0].length;b++){	
				            						pane[x+y].add(itemBtn[a][b]);
				            					}
				            			   }     
				                       }
				            	       myCM_frame.myCM_pane.myOM_pane.item_tabpanel.addChangeListener(new ChangeListener() {
				    	 			        public void stateChanged(ChangeEvent e) {
				    	 			        	int num=myCM_frame.myCM_pane.myOM_pane.item_tabpanel.getSelectedIndex();	//取得當前選擇頁籤索引值,並用變數num紀錄
				    	 			        	String numStr=Integer.toString(num); //將整數num轉為字串,並設定給numStr
				    	 			        	String [][]new_meals=myDBMA.findMEAL_in_TB_meal(myTapCLSno_pet[num]);//傳入一筆類別編號至資料庫中的findMEAL_in_TB_meal()方法,並回傳一筆餐點名稱資料
				    	 			        	for(int a=0;a<itemBtn.length;a++){//重新設定餐點名稱
						            					for(int b=0;b<itemBtn[0].length;b++){	
						            					//	System.out.print(new_meals[a][b]);
						            						changeLine(new_meals);	//傳入一筆餐點名稱,判斷是否需要換行
						            						itemBtn[a][b].setText(new_meals[a][b]);
						            						pp[num].add(itemBtn[a][b]);	//將按鈕加入pp(JPanel)
						            					}
				    	 			        	 }
				    	 			        	pp[num].setVisible(true);	//將pp設為顯示
							                    myCM_frame.myCM_pane.myOM_pane.item_tabpanel.setComponentAt(num,pp[num]);//更新頁籤

				    	 			        }
				    	 			    });
		    	 				}//end else
		    	 			}// end if(e.getSource()....)
		    	 		}//end mealBtn[][]....
		    	 }

	         }    
	
	     };

	     //方法:建立類別按鈕(預設顯示主人餐點)
	     void setClassBtn(){
        	 String [][]classTxt=new String[4][5];
        	 classTxt=myDBMA.findRD_in_TB_class();
	    	 for(int x=0;x<myFrame.myOR_pane.mealBtn.length;x++){
	    		 for(int y=0;y<myFrame.myOR_pane.mealBtn[0].length;y++){	
					myFrame.myOR_pane.mealBtn[x][y].setEnabled(true);							//按鈕預設為可點按
	    	 		myFrame.myOR_pane.mealBtn[x][y].setText(classTxt[x][y]);	//將資料庫現有類別更新到前台
					if(myFrame.myOR_pane.mealBtn[x][y].getText()==null)			//若類別為空,將按剩下的按鈕設為不可點按
							myFrame.myOR_pane.mealBtn[x][y].setEnabled(false);
	    	 		myFrame.myOR_pane.mealBtn[x][y].setFont(new Font("正黑體",0,16));	
	    	 	 }
	    	 }
	     }
	     //方法:取得前台主人類別之編號,並回傳
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
	     //方法:取得前台主人類別之編號,並回傳
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
	     //方法:加入類別按鈕監聽事件
	     void setClassBtnPressed(){
	    	 for(int x=0;x<myFrame.myOR_pane.mealBtn.length;x++){
	    		 for(int y=0;y<myFrame.myOR_pane.mealBtn[0].length;y++){	
	    			myFrame.myOR_pane.mealBtn[x][y].addActionListener(ProcessMealsSelection);  //[新增餐點]操作畫面的[主人餐點-餐點類別]按鈕
	    	 	 }
	    	 }
	     }

/*------------------------------------*/
/*       資 料 處  理                                                      */
/*------------------------------------*/
	     //事件傾聽程式: 處理類別資料儲存
	     public ActionListener ProcessSaveClassRecord = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	              
	              boolean checkPass = true;      //用來記錄[輸入的類別資料]檢查結果
	              String noStr = myFrame.myMM_pane.myMMO_pane.myAC_pane.notxt.getText().trim();      //取得[類別編號資料]中的[編號字串]
	              String dateStr = myFrame.myMM_pane.myMMO_pane.myAC_pane.datatxt.getText().trim();  //取得[類別日期資料]中的[日期字串]
	              String nameStr = myFrame.myMM_pane.myMMO_pane.myAC_pane.nametxt.getText().trim();  //取得[輸入的類別名稱]中的[名稱字串] 
	              String kindStr = myFrame.myMM_pane.myMMO_pane.myAC_pane.kindStr;  				 //取得[輸入的類別分類]中的[分類字串]
	              String stateStr = myFrame.myMM_pane.myMMO_pane.myAC_pane.stateStr;				 //取得[輸入的類別狀態]中的[狀態字串] 
	              String noteStr = myFrame.myMM_pane.myMMO_pane.myAC_pane.notetxt.getText().trim();  //取得[輸入的類別備註]中的[備註字串] 
	              
	              if(  nameStr.length() == 0 ){    //檢查nameString是否有輸入任何字元,length()為計算字串長度方法,若長度為0則未輸入資料
	                     checkPass = false;
	                     JOptionPane.showMessageDialog(null,"[名稱] 不得為空白!","操作警訊",JOptionPane.ERROR_MESSAGE);
	              }              
	              if(  nameStr.length() > 4 ){    //檢查nameString是否超過4
	                     checkPass = false;
	                     JOptionPane.showMessageDialog(null,"[名稱] 不得大於4","操作警訊",JOptionPane.ERROR_MESSAGE);
	              }     
	              if(  noteStr.length() == 0 ){    //檢查noteStr是否有輸入任何字元,length()為計算字串長度方法,若長度為0則未輸入資料
	            	  	 noteStr = "無";		//將備註設為"無"
	              }	              
	              		if( checkPass == true ){
	                    myClass.setNo(noStr);
	                    myClass.setDate(dateStr);
	                    myClass.setName(nameStr);
	                    myClass.setKind(kindStr);
	                    myClass.setState(stateStr);
	                    myClass.setNote(noteStr);
	                    myDBMA.insertRD_into_TB_class(myClass);   //將類別物件傳入[資料庫操作存取物件(myDBMA)]的儲存類別紀錄方法(insertRD_into_TB_class())去儲存類別紀錄到資料庫
	                    System.out.print(myFrame.myMM_pane.myMMO_pane.myAC_pane.notxt.getText());     
	                    myFrame.myMM_pane.myMMO_pane.myAC_pane.setNewNo();      	//更新類別編號
	                    myFrame.myMM_pane.myMMO_pane.myAC_pane.initialize_Filed();  //初始化類別欄位
	                    myFrame.myMM_pane.myMMO_pane.myAC_pane.setClassDate();      //更新系統日期
	              }

	         }    
	     };
	     //事件傾聽程式: 處理更新/修改後,刷新前台類別資料顯示
	     public ActionListener ProcessUpdata = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	 if(e.getSource()== myFrame.myOR_pane.manBtn){
	            	 String [][]classTxt=new String[4][5];
	            	 classTxt=myDBMA.findRD_in_TB_class();
	    	    	 for(int x=0;x<myFrame.myOR_pane.mealBtn.length;x++){
	    	    		 for(int y=0;y<myFrame.myOR_pane.mealBtn[0].length;y++){	
							myFrame.myOR_pane.mealBtn[x][y].setEnabled(true);							//按鈕預設為可點按
	    	    	 		myFrame.myOR_pane.mealBtn[x][y].setText(classTxt[x][y]);					//將資料庫現有類別更新到前台
	    					if(myFrame.myOR_pane.mealBtn[x][y].getText()==null)							//若類別為空,將按剩下的按鈕設為不可點按
								myFrame.myOR_pane.mealBtn[x][y].setEnabled(false);
	    	    	 		myFrame.myOR_pane.mealBtn[x][y].setFont(new Font("正黑體",0,16));	
	    	    	 		myFrame.myOR_pane.man_deal = true;											//true表示主人餐點被選取
	    	    	 	 }
	    	    	 }
	        	 }
	        	 if(e.getSource()== myFrame.myOR_pane.petBtn){
	            	 String [][]classTxt=new String[4][5];
	            	 classTxt=myDBMA.find_PET_CLASS_in_TB_class();
	    	    	 for(int x=0;x<myFrame.myOR_pane.mealBtn.length;x++){
	    	    		 for(int y=0;y<myFrame.myOR_pane.mealBtn[0].length;y++){	
							myFrame.myOR_pane.mealBtn[x][y].setEnabled(true);							//按鈕預設為可點按
	    	    	 		myFrame.myOR_pane.mealBtn[x][y].setText(classTxt[x][y]);					//將資料庫現有類別更新到前台
	    					if(myFrame.myOR_pane.mealBtn[x][y].getText()==null)							//若類別為空,將按剩下的按鈕設為不可點按
								myFrame.myOR_pane.mealBtn[x][y].setEnabled(false);	
	    	    	 		myFrame.myOR_pane.mealBtn[x][y].setFont(new Font("正黑體",0,16));	
	    	    	 		myFrame.myOR_pane.man_deal = false;		//false表示寵物餐點被選取

	    	    		 }
	    	    	 }
	        	 }
	         }    
	     };
	     //事件傾聽程式: 處理類別查詢資料
	     public ActionListener ProcessQueryClassRecord = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	    if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.kindSelected==true){//表示"查詢類別"被選按
		        	    	System.out.println("選了查詢類別}:");
		        	 	if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.second==true){//判斷使用者是否選取第二個條件查詢 
			    		    myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;//將變數設為false,當按下查詢時關閉資料顯示方法否則會出錯
				    		myFrame.myMM_pane.myMMO_pane.myEM_pane.getenable=false;	  //將變數設為false,當按下查詢時關閉資料顯示方法否則會出錯

			    		    String query1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_class_jcb.getSelectedItem().toString();//取得[條件查詢1]中的[欄位查詢資料]
			        	 	String log1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedItem().toString();      //取得[條件查詢1]中的[邏輯查詢資料]
			        	 	String cond1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.cond1txt.getText().trim();                  //取得[條件查詢1]中的[使用者輸入欄位資料]
			        	 	String and_or=myFrame.myMM_pane.myMMQ_pane.myQM_pane.quAnd_Orjcb.getSelectedItem().toString();  //取得[條件查詢1_2]的[邏輯運算]
		 	        	 	String query2=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_class_jcb.getSelectedItem().toString();//取得[條件查詢2]中的[欄位查詢資料]
			        	 	String log2=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog3jcb.getSelectedItem().toString();      //取得[條件查詢2]中的[邏輯查詢資料]
			        	 	String cond2=myFrame.myMM_pane.myMMQ_pane.myQM_pane.cond2txt.getText().trim();                  //取得[條件查詢2]中的[使用者輸入欄位資料]
	
			        	 	//使用者條件1判斷
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
			        	 	//使用者條件2判斷
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
			        	 	//and or判斷
			        	 	if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.quAnd_Orjcb.getSelectedIndex()==0)//and
			        	 		and_or=" AND ";
			        	 	else
			        	 		and_or=" OR ";
			        	 	
			        	 	//使用多查詢條件
			        	 	if(  cond1.length() > 0 ){//如果[使用者輸入欄位資料1]長度大於0,即有輸入關鍵字資料,才進入查詢處理
				        	 	if(cond2.length() > 0 ){//如果[使用者輸入欄位資料2]長度大於0,即有輸入關鍵字資料,才進入查詢處理
				        	 		ClearClassTable();
				        	 		String [][]myQuery=myDBMA.findCLass2_in_TB_class(query1,log1,cond1,and_or,query2,log2,cond2);
				        	 		//將查詢結果寫入JTable
				        	 		for(int x=0;x<myQuery.length;x++){
				        	 			//將資料寫入JTable
						                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.addRow(new Object[]{myQuery[x][0],myQuery[x][1]
						                		,myQuery[x][2],myQuery[x][3],myQuery[x][4],myQuery[x][5]});	//將[查詢結果]寫入JTable
						                //更新JTable 的內容
						                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.fireTableDataChanged();	
					                    myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.updateUI();
				        	 		}
				        	 	}
				        	 	else JOptionPane.showMessageDialog(null,"[查詢欄位2]空白未輸入資料，請填寫後再查詢!","操作警訊",JOptionPane.ERROR_MESSAGE);
				        	 	
			        	 	}
			        	 	else JOptionPane.showMessageDialog(null,"[查詢欄位1]空白未輸入資料，請填寫後再查詢!","操作警訊",JOptionPane.ERROR_MESSAGE);
			        	 	
		        	 	}
		        	 	else{//使用者使用單一查詢條件
			        	 	String query1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_class_jcb.getSelectedItem().toString();//取得[條件查詢1]中的[欄位查詢資料]
			        	 	String log1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedItem().toString();      //取得[條件查詢1]中的[邏輯查詢資料]
			        	 	String cond1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.cond1txt.getText().trim();                  //取得[條件查詢1]中的[使用者輸入欄位資料]        	 		
			    		    myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;	//將變數設為false,當按下查詢時關閉資料顯示方法否則會出錯
				    		myFrame.myMM_pane.myMMO_pane.myEM_pane.getenable=false;	  //將變數設為false,當按下查詢時關閉資料顯示方法否則會出錯

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
			        	 		
			        	 	if(  cond1.length() > 0 ){//如果[使用者輸入欄位資料]長度大於0,即有輸入關鍵字資料,才進入查詢處理
			        	 		ClearClassTable();
			        	 		String [][]myQuery=myDBMA.findCLass_in_TB_class(query1,log1,cond1);   //呼叫[資料庫操作存取物件(myDBMA)]的查詢學生紀錄方法(findCLass_in_TB_class())去查詢類別紀錄,並回傳儲存到myQuery中
			        	 		//將查詢結果寫入JTable
			        	 		for(int x=0;x<myQuery.length;x++){
			        	 			//將資料寫入JTable
					                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.addRow(new Object[]{myQuery[x][0],myQuery[x][1]
					                		,myQuery[x][2],myQuery[x][3],myQuery[x][4],myQuery[x][5]});	//將[查詢結果]寫入JTable
					                //更新jtable 的內容
					                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.fireTableDataChanged();	
				                    myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.updateUI();
			        	 		}
			        	 	}
			        	 	else{
			                    JOptionPane.showMessageDialog(null,"[查詢欄位1]空白未輸入資料，請填寫後再查詢!","操作警訊",JOptionPane.ERROR_MESSAGE);
			        	 	}
			            }
	        	 }
	        }

	     };
	     
	     //方法:清空class表格
	     void ClearClassTable(){
	      	   try{
	    	        myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.setRowCount(0);
	    	    	myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.fireTableDataChanged();
	            }catch(Exception e1){
	            	   JOptionPane.showMessageDialog(null,"資料已更新!");	//發生不明錯誤!
	            } 
	     }
	     //方法:清空meal表格
	     void ClearMealTable(){
	      	   try{
	    	        myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.setRowCount(0);
	    	    	myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.fireTableDataChanged();
	            }catch(Exception e1){
	            	   JOptionPane.showMessageDialog(null,"資料已更新!");	//發生不明錯誤!
	            } 
	     }
	     //方法:查詢最新10筆類別資料,並顯示在class表格
	     void SelectedLastClassTable(){
 	 		ClearClassTable();
 	 		String[][] myQuery=myDBMA.find_all_CLass_in_TB_class();  //查詢前10筆資料方法()
 	 		//將查詢結果寫入JTable
 	 		for(int x=0;x<myQuery.length;x++){
 	 			//將資料寫入JTable
	                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.addRow(new Object[]{myQuery[x][0],myQuery[x][1]
	                		,myQuery[x][2],myQuery[x][3],myQuery[x][4],myQuery[x][5]});	//將[查詢結果]寫入JTable
	                //更新jtable 的內容
	                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm.fireTableDataChanged();	
                    myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.updateUI();
 	 		}
	     }
	     //方法:查詢最新10筆餐點資料,並顯示在meal表格
	     void SelectedLastMealTable(){
 			ClearMealTable();
 	 		String[][] myQuery=myDBMA.find_all_MEal_in_TB_meal();  //查詢前10筆資料方法()
 	 		//將查詢結果寫入JTable
	 		for(int x=0;x<myQuery.length;x++){
	 			//將資料寫入JTable
                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.addRow(new Object[]{myQuery[x][0],myQuery[x][1]
                		,myQuery[x][2],myQuery[x][3],myQuery[x][4],myQuery[x][5],myQuery[x][6],myQuery[x][7],myQuery[x][8]});	//將[查詢結果]寫入JTable
                //更新JTable 的內容
                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.fireTableDataChanged();	
                myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.updateUI();
	 		}
	     }
	     //方法:將當前選取的類別表格資料顯示在右邊[編輯類別]之各個欄位
	     public void ShowEditClassRecord(){
	     		 String str1,str2;
	        	 myFrame.myMM_pane.myMMO_pane.myEC_pane.notxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectedRow(), 0).toString());
	        	 //取得[建立日期]資料,顯示在欄位上
	        	 myFrame.myMM_pane.myMMO_pane.myEC_pane.datatxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectedRow(), 1).toString());
	        	 //取得[類別名稱]資料,顯示在欄位上
	        	 myFrame.myMM_pane.myMMO_pane.myEC_pane.nametxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectedRow(), 2).toString());
	        	 //取得[類別分類]資料
	        	 str1=myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(  myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectedRow(), 3).toString();
	        	 //取得[類別狀態]資料
	        	 str2=myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt( myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectedRow(), 4).toString();
	        	 if(str1.indexOf("主人")>-1){	//使用indexOf() 搜尋字串是否帶有"主人"
					str1="主人";
					myFrame.myMM_pane.myMMO_pane.myEC_pane.ckradio[0].setSelected(true);
					myFrame.myMM_pane.myMMO_pane.myEC_pane.ckradio[1].setSelected(false);		
	 		     }
				 else{
					str1="寵物";
					myFrame.myMM_pane.myMMO_pane.myEC_pane.ckradio[1].setSelected(true);
					myFrame.myMM_pane.myMMO_pane.myEC_pane.ckradio[0].setSelected(false);		
				 }
	 		     if(str2.indexOf("開啟")>-1){	//使用indexOf() 搜尋字串是否帶有"開啟"
					str2="開啟";
					myFrame.myMM_pane.myMMO_pane.myEC_pane.csradio[0].setSelected(true);
					myFrame.myMM_pane.myMMO_pane.myEC_pane.csradio[1].setSelected(false);		
	 		     }
				 else{
					str2="關閉";
					myFrame.myMM_pane.myMMO_pane.myEC_pane.csradio[1].setSelected(true);
					myFrame.myMM_pane.myMMO_pane.myEC_pane.csradio[0].setSelected(false);		
				 }
	 		     //取得[備註]資料
	        	 myFrame.myMM_pane.myMMO_pane.myEC_pane.notetxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectedRow(), 5).toString());	         
	     }
	     //方法:將當前選取的表格資料顯示在右邊欄位[編輯餐點]之各個欄位
	     public void ShowEditOfMealRecord(){
     		 String str_meal_no,str_kind,str_class,str_marterial,str_state;
     		 str_meal_no="MEAL0120151028001";
     		 str_class="CLS0120150202001";
     		 str_marterial="MI0120151003001";
     		 str_meal_no="MEAL0120151028001";
	    	 //取得[餐點編號]資料,顯示在欄位上
        	 myFrame.myMM_pane.myMMO_pane.myEM_pane.notxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 0).toString());
     		 str_meal_no=myFrame.myMM_pane.myMMO_pane.myEM_pane.notxt.getText();
     		//取得[建立日期]資料,顯示在欄位上
        	 myFrame.myMM_pane.myMMO_pane.myEM_pane.datetxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 3).toString());
        	//取得[餐點名稱]資料,顯示在欄位上
        	 myFrame.myMM_pane.myMMO_pane.myEM_pane.nametxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 1).toString());
        	 //取得[餐點類別編號]資料
        	 str_class=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 2).toString();	
        	 //取得[餐點物料名稱]資料
        	 str_marterial=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 4).toString();
        	 //取得[餐點狀態]資料
        	 str_state=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 6).toString();
        	 //取得[價格]資料
        	 myFrame.myMM_pane.myMMO_pane.myEM_pane.pricetxt.setText(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 5).toString());	  
        	 //取得[物料種類]資料
        	 str_marterial=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 7).toString();
        	 //取得[物料種類]資料
        	 str_kind=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRow(), 8).toString();
        	 //取得當前選取[餐點之類別分類](主人or寵物)
        	 //str_kind=myDBMA.findClasskind_forMeals_in_TB_class(str_meal_no);///~~~~
        	 //當前選取餐點之類別分類(主人or寵物)並設定[餐點分類]選擇鈕狀態(主人或寵物)
        	 if(str_kind.indexOf("主人")>-1){	//使用indexOf() 搜尋字串是否帶有"主人"				
				myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[0].setSelected(true);
				myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[1].setSelected(false);		
 		     }
			 else{
				myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[1].setSelected(true);
				myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[0].setSelected(false);		
			 }
        	 //取得當前選取餐點之類別分類(販售or停售)
        	// str_state=myDBMA.findMealState_forMeals_in_TB_class(str_meal_no);///~~
        	 //當前選取餐點之類別分類(販售or停售)並設定[餐點分類]選擇鈕狀態(主人或寵物)
        	 if(str_state.indexOf("販售")>-1){	//使用indexOf() 搜尋字串是否帶有"開啟"
        		 str_state="販售";
        		 myFrame.myMM_pane.myMMO_pane.myEM_pane.msradio[0].setSelected(true);
        		 myFrame.myMM_pane.myMMO_pane.myEM_pane.msradio[1].setSelected(false);		
        	 }
        	 else{
        		 str_state="停售";
        		 myFrame.myMM_pane.myMMO_pane.myEM_pane.msradio[1].setSelected(true);
        		 myFrame.myMM_pane.myMMO_pane.myEM_pane.msradio[0].setSelected(false);		
        	 } 
 		     //依據當前餐點所屬類別,顯示在下拉式選單上
 		     myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.removeAll();
 		     update_MealOfClass();//更新類別選單
 	//	     String setClassItem=myDBMA.findClassno_forMeals_in_TB_class(str_class);//a
 		     System.out.println(str_class);//999
 		     myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.setSelectedItem(str_class);
 		     myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.updateUI();
 		     
 		     //依據當前餐點所使用物料,顯示在下拉式選單上
		     	//判斷餐點是否有使用物料
		     myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.removeAll();
		     if(str_marterial.indexOf("無")>-1){	//使用indexOf() 搜尋字串是否帶有"無"		
	 		     myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.setSelectedIndex(0);	//種類下拉式選單"無"
		     }	 		     
		     else{//顯示使用物料種類type
		    	 //查詢該物料之種類字串
		    //	 String MaterialType=myDBMA.findMaterialType_in_TB_mi(str_marterial);	//取得物料種類(TYPE)
		    //	 String MaterialName=myDBMA.findMaterialName_in_TB_mi(str_marterial);
		    	 //jcb選取該物料種類下拉式選單
	 		     myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.setSelectedItem(str_marterial);
		    	 //jcb選取該物料
	 		     myFrame.myMM_pane.myMMO_pane.myEM_pane.material_jcb.setSelectedItem(str_marterial);
		     }        	 
	     }
	     
	     //事件傾聽程式: 處理類別資料修改(更新)
	     public ActionListener ProcessReviseClassRecord = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	  myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;//將變數設為false,當按下查詢時關閉資料顯示方法否則會出錯
	    		  myFrame.myMM_pane.myMMO_pane.myEM_pane.getenable=false;	  //將變數設為false,當按下查詢時關閉資料顯示方法否則會出錯

	        	  boolean checkPass = true;      //用來記錄[輸入的類別資料]檢查結果
	              String noStr = myFrame.myMM_pane.myMMO_pane.myEC_pane.notxt.getText().trim();      //取得[類別編號資料]中的[編號字串]
	              String dateStr = myFrame.myMM_pane.myMMO_pane.myEC_pane.datatxt.getText().trim();  //取得[類別日期資料]中的[日期字串]
	              String nameStr = myFrame.myMM_pane.myMMO_pane.myEC_pane.nametxt.getText().trim();  //取得[輸入的類別名稱]中的[名稱字串] 
	              String kindStr = myFrame.myMM_pane.myMMO_pane.myEC_pane.kindStr;  				 //取得[輸入的類別分類]中的[分類字串]
	              String stateStr = myFrame.myMM_pane.myMMO_pane.myEC_pane.stateStr;				 //取得[輸入的類別狀態]中的[狀態字串] 
	              String noteStr = myFrame.myMM_pane.myMMO_pane.myEC_pane.notetxt.getText().trim();  //取得[輸入的類別備註]中的[備註字串] 
	              
	              if(  nameStr.length() == 0 ){    //檢查nameString是否有輸入任何字元,length()為計算字串長度方法,若長度為0則未輸入資料
	                     checkPass = false;
	                     JOptionPane.showMessageDialog(null,"[名稱] 不得為空白!","操作警訊",JOptionPane.ERROR_MESSAGE);
	              }                         
	              if(  noteStr.length() == 0 ){    //檢查noteStr是否有輸入任何字元,length()為計算字串長度方法,若長度為0則未輸入資料
	            	  	 noteStr = "無";		//將備註設為"無"
	              }	              
	              if( checkPass == true ){
	                    myClass.setNo(noStr);
	                    myClass.setDate(dateStr);
	                    myClass.setName(nameStr);
	                    myClass.setKind(kindStr);
	                    myClass.setState(stateStr);
	                    myClass.setNote(noteStr);
	        	 		ClearClassTable();
	                    myDBMA.updateClass_in_TB_class(myClass);  //傳入一筆[類別資料]
	        	 		ClearClassTable();	//清空表格
	        	 		SelectedLastClassTable();	//更新表格
	                  //  myFrame.myMM_pane.myMMO_pane.myEC_pane.clear_field();//清空輸入欄位
	              }
	
	         }
	     };

		@Override
		//事件傾聽程式:當JTable被選取時,取得當前選取列之個欄位資訊
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			boolean dataIsSelected=true;	//紀錄當前是否有資料被選取
			System.out.println("進入valueChanged!!");
			if(myFrame.myMM_pane.myMMO_pane.choose==1){
				System.out.println("進入valueChanged-class!!");

				String[] class_info=new String[6];
				int[] rows=myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getSelectedRows();  //取得選取列上之儲存格
			    StringBuilder msg=new StringBuilder("Selected : "); 
	
			    for (int i=0; i<rows.length; i++) {//將選取資料儲存至class_info[]陣列
				    if(myFrame.myMM_pane.myMMQ_pane.mySR_pane.queryTable.getValueAt(rows[i],0)==null){
			            JOptionPane.showMessageDialog(null,"未選取資料!!!","操作警訊",JOptionPane.ERROR_MESSAGE);
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
					ShowEditClassRecord();	//方法:將當前選取的表格資料顯示在右邊欄位
			}
			if(myFrame.myMM_pane.myMMO_pane.choose==3){
				System.out.println("進入valueChanged_meal!!");
				String[] meal_info=new String[7];
				int[] rows=myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getSelectedRows();  //取得選取列上之儲存格
			    StringBuilder msg=new StringBuilder("Selected : "); 
			    for (int i=0; i<rows.length; i++) {//將選取資料儲存至class_info[]陣列
				    if(myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.getValueAt(rows[i],0)==null){
			            JOptionPane.showMessageDialog(null,"未選取資料!!!","操作警訊",JOptionPane.ERROR_MESSAGE);
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
					System.out.println("這裡要顯示餐點資訊");
					ShowEditOfMealRecord();	//方法:將當前選取的表格資料顯示在右邊欄位
				}
			}
		}
		//方法:傳入meals[][]餐點二維陣列,判斷是否需要換行
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
	        			if(meals[x][y].indexOf("html")>-1){	//使用indexOf() 搜尋字串是否已經帶有html語法字串,若有則跳出迴圈
	    					break;		
	    	 		     }
	        		//	System.out.println("餐點名稱"+meals[x][y]);
	        			if(meals[x][y].length()>4){//將餐點名稱大於4個字的進行拆解
	        				str1=html_start+(String) meals[x][y].subSequence(0,2)+br;	//取出前兩個字
	        				str2=(String) meals[x][y].subSequence(2,meals[x][y].length())+html_end;	//取出剩下的字
	        				meals[x][y]=str1+str2;
	        		//		System.out.println("新餐點名稱"+meals[x][y]);
	        			}
	        		}
	             }
	         }
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		//方法: 查詢類別資料,新增至[新增餐點]及[編輯餐點]的餐點類別下拉式選單
		void update_MealOfClass(){
			/*-預設顯示主人類別-*/
		
			String[] manClass=myDBMA.findClass_in_TB_class();			    //從資料庫取得分類為"主人"的所有類別資料,並回傳給manClass
			for(int x=0;x<manClass.length;x++){
				if(manClass[x]==null)										//當資料為空時,跳出迴圈
					break;
				myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.addItem(manClass[x]);//將類別加入JComboBox
				myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.addItem(manClass[x]);//將類別加入JComboBox

			}
			
			for(int i=0;i< myFrame.myMM_pane.myMMO_pane.myAM_pane.kindradio.length;i++){
				myFrame.myMM_pane.myMMO_pane.myAM_pane.kindradio[i].addActionListener(MealRadioBtnSelected);
				myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[i].addActionListener(MealRadioBtnSelected);
			}
			if(myFrame.myMM_pane.myMMO_pane.choose==3){ 					  //變數紀錄"編輯餐點"被選取

			//若 使用者在餐點分類點選了"主人"
        	 if(myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[0].isSelected()==true){
					String[] manClass2=myDBMA.findClass_in_TB_class();			    //從資料庫取得分類為"主人"的所有類別資料,並回傳給manClass
					for(int x=0;x<manClass2.length;x++){
						if(manClass2[x]==null)										//當資料為空時,跳出迴圈
							break;
						myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.addItem(manClass2[x]);//將類別加入JComboBox
						myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.addItem(manClass2[x]);//將類別加入JComboBox

					}
				
       	   }
			//若 使用者在餐點分類點選了"寵物"
       	   if(myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[1].isSelected()==true){
					String[] petClass=myDBMA.findClassPet_in_TB_class(); //從資料庫取得分類為"寵物"的所有類別資料,並回傳給petClass
					for(int x=0;x<petClass.length;x++){
						if(petClass[x]==null)									    //當資料為空時,跳出迴圈
							break;
						myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.addItem(petClass[x]);//將類別加入JComboBox
						myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.addItem(petClass[x]);//將類別加入JComboBox

					}
	
        	 }
			}
		}
	     //事件傾聽程式: 
	     public ActionListener MealRadioBtnSelected = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	 		    myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.removeAllItems();	//先移除JComboBox內所有items,以免重覆	
	 		    myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.removeAllItems();	//先移除JComboBox內所有items,以免重覆	
	 		    /*-新增餐點-*/
				//若 使用者在餐點分類點選了"主人"
	        	 if(e.getSource()== myFrame.myMM_pane.myMMO_pane.myAM_pane.kindradio[0]){
						String[] manClass=myDBMA.findClass_in_TB_class();			    //從資料庫取得分類為"主人"的所有類別資料,並回傳給manClass
						for(int x=0;x<manClass.length;x++){
							if(manClass[x]==null)										//當資料為空時,跳出迴圈
								break;
							myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.addItem(manClass[x]);//將類別加入JComboBox
						}
					
	        	 }
				//若 使用者在餐點分類點選了"寵物"
	        	 if(e.getSource()== myFrame.myMM_pane.myMMO_pane.myAM_pane.kindradio[1]){
						String[] petClass=myDBMA.findClassPet_in_TB_class(); //從資料庫取得分類為"寵物"的所有類別資料,並回傳給petClass
						for(int x=0;x<petClass.length;x++){
							if(petClass[x]==null)									    //當資料為空時,跳出迴圈
								break;
							myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.addItem(petClass[x]);//將類別加入JComboBox
						}
		
	        	 }
	        	 /*編輯餐點*/
					//若 使用者在餐點分類點選了"主人"
	        	 if(e.getSource()== myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[0]){
						String[] manClass=myDBMA.findClass_in_TB_class();			    //從資料庫取得分類為"主人"的所有類別資料,並回傳給manClass
						for(int x=0;x<manClass.length;x++){
							if(manClass[x]==null)										//當資料為空時,跳出迴圈
								break;
							myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.addItem(manClass[x]);//將類別加入JComboBox
						}
					
	        	 }
				//若 使用者在餐點分類點選了"寵物"
	        	 if(e.getSource()== myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[1]){
						String[] petClass=myDBMA.findClassPet_in_TB_class(); //從資料庫取得分類為"寵物"的所有類別資料,並回傳給petClass
						for(int x=0;x<petClass.length;x++){
							if(petClass[x]==null)									    //當資料為空時,跳出迴圈
								break;
							myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.addItem(petClass[x]);//將類別加入JComboBox
						}
		
	        	 }
	         }
	     };
	   //方法: 查詢物料資料,新增至[新增餐點]及[編輯餐點]的物料下拉式選單
		void update_MealOfMaterials(){
				//物料分類
				myFrame.myMM_pane.myMMO_pane.myAM_pane.material_type_jcb.removeAllItems();	//先移除JComboBox內所有items,以免重覆			
	        	myFrame.myMM_pane.myMMO_pane.myAM_pane.material_type_jcb.addItem("無");	    //加入"無"物料之item
				
	        	String[] materials_type=myDBMA.findMaterialType_in_TB_mi();			        //從資料庫取得所有物料種類資料,並回傳
	        	
				myFrame.myMM_pane.myMMO_pane.myAM_pane.material_type_jcb.addItemListener(ItemSelected);//加入事件傾聽器

				for(int x=0;x<materials_type.length;x++){
	        		if(materials_type[x]==null)										       //當資料為空時,跳出迴圈
	        			break;
	        		myFrame.myMM_pane.myMMO_pane.myAM_pane.material_type_jcb.addItem(materials_type[x]);//將物料種類分類加入JComboBox

	        	}			
		}	
        //事件傾聽程式:ItemEvent
		ItemListener ItemSelected = new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				String type;
				try{
					type=myFrame.myMM_pane.myMMO_pane.myAM_pane.material_type_jcb.getSelectedItem().toString();	//取得當前選取分類選項名稱,並轉成字串型態
				} catch(Exception e1){
					type="0";
				}				
	        	String[] getType=myDBMA.findMaterial_useType_in_TB_mi(type);//傳入當前選取的分類選項,並回傳該分類下的所有物料名稱

	        	//根據使用者選擇的分類,顯示對應物料種類
	        	if(myFrame.myMM_pane.myMMO_pane.myAM_pane.material_type_jcb.getSelectedIndex()==0)	//當使用者選擇"不使用",將物料選項設為不可見
	        		myFrame.myMM_pane.myMMO_pane.myAM_pane.material_jcb.setVisible(false);
	        	else{
			        myFrame.myMM_pane.myMMO_pane.myAM_pane.material_jcb.removeAllItems();	   //先移除JComboBox內所有items,以免重覆			
					for(int x=0;x<getType.length;x++){
						if(getType[x]==null)										           //當資料為空時,跳出迴圈
							break;
						myFrame.myMM_pane.myMMO_pane.myAM_pane.material_jcb.addItem(getType[x]);//將物料種類加入JComboBox
		        		myFrame.myMM_pane.myMMO_pane.myAM_pane.material_jcb.setVisible(true);   //將物料種類下拉式選單設為可見
					}	        		
	        	}
	        	//判斷餐點是否選用物料
	        	if(myFrame.myMM_pane.myMMO_pane.myAM_pane.material_type_jcb.getSelectedIndex()==0)
	        		myFrame.myMM_pane.myMMO_pane.myAM_pane.use_material=false;	//紀錄餐點不使用物料
	        	else
	        		myFrame.myMM_pane.myMMO_pane.myAM_pane.use_material=true;	//紀錄餐點使用物料
	        	
			}		
		 };		
		//方法: 查詢物料資料,新增至[編輯餐點]的物料下拉式選單
		void Edit_MealOfMaterials(){
				//物料分類
				myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.removeAllItems();	//先移除JComboBox內所有items,以免重覆			
	        	myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.addItem("無");	    //加入"無"物料之item
	        	String[] materials_type=myDBMA.findMaterialType_in_TB_mi();			        //從資料庫取得所有物料種類資料,並回傳
	        	
				myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.addItemListener(ItemEditSelected);//加入事件傾聽器
	        	for(int x=0;x<materials_type.length;x++){
	        		if(materials_type[x]==null)										       //當資料為空時,跳出迴圈
	        			break;
	        		myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.addItem(materials_type[x]);//將物料種類分類加入JComboBox

	        	}			
		}	
			
        //事件傾聽程式:ItemEvent
		ItemListener ItemEditSelected = new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				String type;
				try{
					type=myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.getSelectedItem().toString();	//取得當前選取分類選項名稱,並轉成字串型態

				} catch(Exception e1){
					type="0";
				}				
	        	String[] getType=myDBMA.findMaterial_useType_in_TB_mi(type);//傳入當前選取的分類選項,並回傳該分類下的所有物料名稱

	        	//根據使用者選擇的分類,顯示對應物料種類
	        	if(myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.getSelectedIndex()==0)	//當使用者選擇"不使用",將物料選項設為不可見
	        		myFrame.myMM_pane.myMMO_pane.myEM_pane.material_jcb.setVisible(false);
	        	else{
			        myFrame.myMM_pane.myMMO_pane.myEM_pane.material_jcb.removeAllItems();	   //先移除JComboBox內所有items,以免重覆			
					for(int x=0;x<getType.length;x++){
						if(getType[x]==null)										           //當資料為空時,跳出迴圈
							break;
						myFrame.myMM_pane.myMMO_pane.myEM_pane.material_jcb.addItem(getType[x]);//將物料種類加入JComboBox
		        		myFrame.myMM_pane.myMMO_pane.myEM_pane.material_jcb.setVisible(true);   //將物料種類下拉式選單設為可見
					}	        		
	        	}
	        	//判斷餐點是否選用物料
	        	if(myFrame.myMM_pane.myMMO_pane.myEM_pane.material_type_jcb.getSelectedIndex()==0)
	        		myFrame.myMM_pane.myMMO_pane.myEM_pane.use_material=false;	//紀錄餐點不使用物料
	        	else
	        		myFrame.myMM_pane.myMMO_pane.myEM_pane.use_material=true;	//紀錄餐點使用物料

			}	
		 };		
		 
	     //事件傾聽程式: 處理餐點資料儲存
	     public ActionListener ProcessSaveMealRecord = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	              
	              boolean checkPass = true;      	//用來記錄[輸入的類別資料]檢查結果
	              boolean check_price_null = false; //用來暫時記錄[輸入的價格是否為空]檢查結果
	              boolean check_price_num = false;	//用來暫時記錄[輸入的價格是否為數字]檢查結果

	              String noStr = myFrame.myMM_pane.myMMO_pane.myAM_pane.notxt.getText().trim();      //取得[類別編號資料]中的[編號字串]
	              String dateStr = myFrame.myMM_pane.myMMO_pane.myAM_pane.datetxt.getText().trim();  //取得[類別日期資料]中的[日期字串]
	              String nameStr = myFrame.myMM_pane.myMMO_pane.myAM_pane.nametxt.getText().trim();  //取得[輸入的類別名稱]中的[名稱字串] 
	              String kindStr = myFrame.myMM_pane.myMMO_pane.myAM_pane.kindStr;  				 //取得[輸入的餐點分類]中的[分類字串]
	              String stateStr = myFrame.myMM_pane.myMMO_pane.myAM_pane.stateStr;				 //取得[輸入的餐點狀態]中的[狀態字串] 
	              String priceStr = myFrame.myMM_pane.myMMO_pane.myAM_pane.pricetxt.getText().trim(); //取得[輸入的餐點價格]中的[價格字串]
	              
	              //傳入一筆類別名稱,回傳該類別名稱之類別編號
	              System.out.println("類別取得的字串是:"+myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.getSelectedItem().toString());
	              String cls_noStr=myDBMA.findClassNo_forMeals_in_TB_class(myFrame.myMM_pane.myMMO_pane.myAM_pane.class_jcb.getSelectedItem().toString());
	              System.out.println("類別的查詢結果是:"+cls_noStr);
	              String mi_noStr;
	              if(myFrame.myMM_pane.myMMO_pane.myAM_pane.use_material==false)
	            	  mi_noStr="無";
	              else{//傳入一筆物料名稱,回傳該物料名稱之物料編號
		              System.out.println("物料取得的字串是:"+myFrame.myMM_pane.myMMO_pane.myAM_pane.material_jcb.getSelectedItem().toString());
	            	  mi_noStr=myDBMA.findMiNo_in_TB_mi(myFrame.myMM_pane.myMMO_pane.myAM_pane.material_jcb.getSelectedItem().toString());
		              System.out.println("物料的查詢結果是:"+mi_noStr);
	              }
	              /*-檢查輸入資料-*/
	              if(  nameStr.length() == 0 ){    //檢查nameString是否有輸入任何字元,length()為計算字串長度方法,若長度為0則未輸入資料
	                     checkPass = false;
	                     JOptionPane.showMessageDialog(null,"[名稱] 不得為空白!","操作警訊",JOptionPane.ERROR_MESSAGE);
       
	              }   
  	              if(nameStr.length() > 10){  //檢查nameString長度是否超過10
	                    checkPass = false;
	                    JOptionPane.showMessageDialog(null,"[名稱] 最大長度為10","操作警訊",JOptionPane.ERROR_MESSAGE);
    	          }
	              if(  priceStr.length() == 0 ){    //檢查noteStr是否有輸入任何字元,length()為計算字串長度方法,若長度為0則未輸入資料
	                     checkPass = false;
	                     check_price_null=true;
	                     JOptionPane.showMessageDialog(null,"[價格] 不得為空白!","操作警訊",JOptionPane.ERROR_MESSAGE);
	              }	
	              if( check_price_null==false ){  
	                   if(myCheck.checkNumber( priceStr ) == false ){//利用檢查物件(myCheck)的checkNumber()方法,檢查priceStr是否為正確的數值格式,如:98,80,...等
	            	  	checkPass = false;
	                    check_price_num = false;
	                    JOptionPane.showMessageDialog(null,"[價格] 輸入資料錯誤!","操作警訊",JOptionPane.ERROR_MESSAGE);
	                   }
	                   else
		                    check_price_num = true;
	              }
      	          if( check_price_num==true ){ //價格確定為數字時,檢查priceStr是否為0
      	        	  if(Integer.parseInt(priceStr) == 0){
  	                    checkPass = false;
  	                    JOptionPane.showMessageDialog(null,"[價格] 不得為0","操作警訊",JOptionPane.ERROR_MESSAGE);
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
	                    myDBMA.insertRD_into_TB_meal(myMeal);   //將餐點物件傳入[資料庫操作存取物件(myDBMA)]的儲存類別紀錄方法(insertRD_into_TB_meal())去儲存類別紀錄到資料庫
	                    System.out.print(noStr+dateStr+nameStr+kindStr+cls_noStr+mi_noStr+stateStr+Integer.parseInt(priceStr));     
	                    myFrame.myMM_pane.myMMO_pane.myAM_pane.setNewNo();      	//更新餐點編號
	                    myFrame.myMM_pane.myMMO_pane.myAM_pane.initialize_Filed();  //初始化類別欄位
	                    myFrame.myMM_pane.myMMO_pane.myAM_pane.setMealDate();       //更新系統日期
	              }

	         }    
	     };	
	     
	     //事件傾聽程式: 處理餐點查詢資料
	     public ActionListener ProcessQueryMealRecord = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	    if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.kindSelected==false){//表示"查詢餐點"被選按
	        	    	System.out.println("選了查詢餐點:");
	        	    	if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.second==true){//判斷使用者是否選取第二個條件查詢 
	        	    		myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;//將變數設為false,當按下查詢時關閉資料顯示方法否則會出錯
	        	    		String query1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedItem().toString();//取得[條件查詢1]中的[欄位查詢資料]
	        	    		String log1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedItem().toString();      //取得[條件查詢1]中的[邏輯查詢資料]
	        	    		String cond1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.cond1txt.getText().trim();                  //取得[條件查詢1]中的[使用者輸入欄位資料]
	        	    		String and_or=myFrame.myMM_pane.myMMQ_pane.myQM_pane.quAnd_Orjcb.getSelectedItem().toString();  //取得[條件查詢1_2]的[邏輯運算]
	        	    		String query2=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu2_meal_jcb.getSelectedItem().toString();//取得[條件查詢2]中的[欄位查詢資料]
	        	    		String log2=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog3jcb.getSelectedItem().toString();      //取得[條件查詢2]中的[邏輯查詢資料]
	        	    		String cond2=myFrame.myMM_pane.myMMQ_pane.myQM_pane.cond2txt.getText().trim();                  //取得[條件查詢2]中的[使用者輸入欄位資料]

	        	    		//使用者條件1判斷
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
			        	 	//使用者條件2判斷
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
			        	 	//and or判斷
			        	 	if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.quAnd_Orjcb.getSelectedIndex()==0)//and
			        	 		and_or=" AND ";
			        	 	else
			        	 		and_or=" OR ";
			        	 	
			        	 	//使用多查詢條件
			        	 	if(  cond1.length() > 0 ){//如果[使用者輸入欄位資料1]長度大於0,即有輸入關鍵字資料,才進入查詢處理
			        	 		if(cond2.length()>0){//如果[使用者輸入欄位資料2]長度大於0,即有輸入關鍵字資料,才進入查詢處理
			        	 			ClearMealTable();
				        	 		String [][]myQuery=myDBMA.findMeal2_in_TB_meal(query1,log1,cond1,and_or,query2,log2,cond2);
				        	 		//將查詢結果寫入JTable
				        	 		for(int x=0;x<myQuery.length;x++){
				        	 			//將資料寫入JTable
						                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.addRow(new Object[]{myQuery[x][0],myQuery[x][1]
						                		,myQuery[x][2],myQuery[x][3],myQuery[x][4],myQuery[x][5],myQuery[x][6],myQuery[x][7],myQuery[x][8]});	//將[查詢結果]寫入JTable
						                //更新JTable 的內容
						                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.fireTableDataChanged();	
					                    myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.updateUI();
				        	 		}
				        	 	}
				        	 	else JOptionPane.showMessageDialog(null,"[查詢欄位2]空白未輸入資料，請填寫後再查詢!","操作警訊",JOptionPane.ERROR_MESSAGE);
				        	 	
			        	 	}
			        	 	else JOptionPane.showMessageDialog(null,"[查詢欄位1]空白未輸入資料，請填寫後再查詢!","操作警訊",JOptionPane.ERROR_MESSAGE);
			        	 	
		        	 	}
		        	 	else{//使用者使用單一查詢條件
		        	 		String query1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qu1_meal_jcb.getSelectedItem().toString();//取得[條件查詢1]中的[欄位查詢資料]
	        	    		String log1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.qulog1jcb.getSelectedItem().toString();      //取得[條件查詢1]中的[邏輯查詢資料]
	        	    		String cond1=myFrame.myMM_pane.myMMQ_pane.myQM_pane.cond1txt.getText().trim();                  //取得[條件查詢1]中的[使用者輸入欄位資料]
			    		    myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;	//將變數設為false,當按下查詢時關閉資料顯示方法否則會出錯
	        	    		//使用者條件1判斷
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

			        	 	if(  cond1.length() > 0 ){//如果[使用者輸入欄位資料]長度大於0,即有輸入關鍵字資料,才進入查詢處理
			        	 		ClearMealTable();
			        	 		String [][]myQuery=myDBMA.findMeal_in_TB_meal(query1,log1,cond1);   //呼叫[資料庫操作存取物件(myDBMA)]的查詢學生紀錄方法(findCLass_in_TB_class())去查詢類別紀錄,並回傳儲存到myQuery中
			        	 		//將查詢結果寫入JTable
			        	 		for(int x=0;x<myQuery.length;x++){
			        	 			//將資料寫入JTable
					                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.addRow(new Object[]{myQuery[x][0],myQuery[x][1]
					                		,myQuery[x][2],myQuery[x][3],myQuery[x][4],myQuery[x][5],myQuery[x][6],myQuery[x][7],myQuery[x][8]});	//將[查詢結果]寫入JTable
					                //更新jtable 的內容
					                myFrame.myMM_pane.myMMQ_pane.mySR_pane.tm2.fireTableDataChanged();	
				                    myFrame.myMM_pane.myMMQ_pane.mySR_pane.query2Table.updateUI();
			        	 		}
			        	 	}
			        	 	else{
			                    JOptionPane.showMessageDialog(null,"[查詢欄位1]空白未輸入資料，請填寫後再查詢!","操作警訊",JOptionPane.ERROR_MESSAGE);
			        	 	}
			            }
	        	    }
	           }
	       
	     };
	     //事件傾聽程式: 處理切換類別/餐點之查詢
	     public ActionListener ProcesskindradioRecord = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	 //若當前為"類別管理"被選取
	        	 if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.kindSelected==true){
	        			SelectedLastMealTable();	//改為"餐點管理"
	        			myFrame.myMM_pane.myMMO_pane.addclassbtn.setEnabled(false);	//將[新類別]按鈕設為不可選按				
	    	    	    myFrame.myMM_pane.myMMO_pane.revclassbtn.setEnabled(false);	//將[編輯類別]按鈕設為不可選按
	        			myFrame.myMM_pane.myMMO_pane.addmealsbtn.setEnabled(true);	//將[新餐點]按鈕設為可選按
	        			myFrame.myMM_pane.myMMO_pane.revmealsbtn.setEnabled(true);	//將[編輯餐點]按鈕設為可選按
	        			
		            	myFrame.myMM_pane.myMMO_pane.myAC_pane.setVisible(false);    //顯示[新增類別]操作畫面
		            	myFrame.myMM_pane.myMMO_pane.myEC_pane.setVisible(false);    //隱藏[編輯類別]操作畫面
		            	myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(true);     //隱藏[新增餐點]操作畫面
		            	myFrame.myMM_pane.myMMO_pane.myEM_pane.setVisible(false);    //隱藏[編輯餐點]操作畫面
		            	update_MealOfClass();										 //更新[新增餐點]之類別欄位
		            	update_MealOfMaterials();	   								 //更新[新增餐點]之物料欄位
	        	 }
	        	 //若當前為"餐點管理"被選取
	        	 if(myFrame.myMM_pane.myMMQ_pane.myQM_pane.kindSelected==false){
	        			SelectedLastClassTable();	//改為"類別管理"
	        			myFrame.myMM_pane.myMMO_pane.addmealsbtn.setEnabled(false);	//將[新餐點]按鈕設為不可選按
	        			myFrame.myMM_pane.myMMO_pane.revmealsbtn.setEnabled(false);	//將[編輯餐點]按鈕設為不可選按
	        			myFrame.myMM_pane.myMMO_pane.addclassbtn.setEnabled(true);	//將[新餐點]按鈕設為可選按	
	    	    	    myFrame.myMM_pane.myMMO_pane.revclassbtn.setEnabled(true);	//將[編輯餐點]按鈕設為可選按
	        	 
		            	myFrame.myMM_pane.myMMO_pane.myAC_pane.setVisible(true);    //顯示[新增類別]操作畫面
		            	myFrame.myMM_pane.myMMO_pane.myEC_pane.setVisible(false);   //隱藏[編輯類別]操作畫面
		            	myFrame.myMM_pane.myMMO_pane.myAM_pane.setVisible(false);   //隱藏[新增餐點]操作畫面
		            	myFrame.myMM_pane.myMMO_pane.myEM_pane.setVisible(false);   //隱藏[編輯餐點]操作畫面
		            	myFrame.myMM_pane.myMMO_pane.choose=0; 					  //變數紀錄"新增類別"被選取

		            	
	        	 }	 
	        	 
	         }
	     };
	     //事件傾聽程式: 處理餐點資料修改(更新)
	     public ActionListener ProcessReviseMealRecord = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	  myFrame.myMM_pane.myMMO_pane.myEC_pane.getenable=false;//將變數設為false,當按下查詢時關閉資料顯示方法否則會出錯
	              boolean checkPass = true;      //用來記錄[輸入的類別資料]檢查結果
	              String kindStr="",stateStr="";
	              //取得[餐點編號資料]中的[餐點字串]
	              String meal_noStr = myFrame.myMM_pane.myMMO_pane.myEM_pane.notxt.getText().trim();   
	              //取得[餐點建立日期資料]中的[日期字串]
	              String dateStr = myFrame.myMM_pane.myMMO_pane.myEM_pane.datetxt.getText().trim();     
	              //取得[餐點名稱資料]中的[名稱字串] 
	              String nameStr = myFrame.myMM_pane.myMMO_pane.myEM_pane.nametxt.getText().trim();     
	         	  //取得[分類](主人or寵物)
	              if(myFrame.myMM_pane.myMMO_pane.myEM_pane.kindradio[0].isSelected()==true)
	            	  kindStr="主人";
	              else
	            	  kindStr="寵物";
	              //取得[類別編號]
	              String cls_name=myFrame.myMM_pane.myMMO_pane.myEM_pane.class_jcb.getSelectedItem().toString();//取得類別名稱
	              String cls_noStr=myDBMA.findClassNo_in_TB_class(cls_name);
         
	              //取得[物料編號]
	              String mi_name=myFrame.myMM_pane.myMMO_pane.myEM_pane.material_jcb.getSelectedItem().toString();//取得物料名稱
	              String mi_noStr=myDBMA.findM_No_in_TB_mi(mi_name);
		          //取得[狀態](販售or停售)
	              if(myFrame.myMM_pane.myMMO_pane.myEM_pane.msradio[0].isSelected()==true)
	            	  stateStr="販售";
	              else
	            	  stateStr="停售";	  
	              //取得[價格]  
	              String priceStr = myFrame.myMM_pane.myMMO_pane.myEM_pane.pricetxt.getText().trim();    //取得[餐點價格]中的[價格字串]
	              
	              if(  nameStr.length() == 0 ){    //檢查nameString是否有輸入任何字元,length()為計算字串長度方法,若長度為0則未輸入資料
	                     checkPass = false;
	                     JOptionPane.showMessageDialog(null,"[名稱] 不得為空白!","操作警訊",JOptionPane.ERROR_MESSAGE);
	              }                         
	              if(  priceStr.length() == 0 ){    //檢查noteStr是否有輸入任何字元,length()為計算字串長度方法,若長度為0則未輸入資料
	                     checkPass = false;
	                     JOptionPane.showMessageDialog(null,"[價格] 不得為空白!","操作警訊",JOptionPane.ERROR_MESSAGE);
	              }	
	              if( myCheck.checkNumber( priceStr ) == false ){  //利用檢查物件(myCheck)的checkNumber()方法,檢查priceStr是否為正確的數值格式,如:98,80,...等
	                    checkPass = false;
	                    JOptionPane.showMessageDialog(null,"[價格] 輸入資料錯誤!","操作警訊",JOptionPane.ERROR_MESSAGE);
	              }
	              if( Integer.parseInt(priceStr) == 0 ){  //檢查priceStr是否為0
	                    checkPass = false;
	                    JOptionPane.showMessageDialog(null,"[價格] !","操作警訊",JOptionPane.ERROR_MESSAGE);
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
	                    myDBMA.updateMeal_in_TB_meal(myMeal);  //傳入一筆[類別資料]
	        	 	//	ClearMealTable();	//清空表格
	        	 		SelectedLastMealTable();	//更新表格
	        	 		
	              }

	         }
	     };

	     //交易編號設置
	 	void getLast_trans_No(){
	 			String last_no; 
	 			int num,count=0;
	 			
	 			last_no=myBS.query_lastkey_TB_class();
	 	       
	 			int len = last_no.length();  //取得傳入字串長度
	 	        String[] sList = new String[len];   //建立一個長度為len的字串陣列,用來儲存字串拆解後各個字元用

	 	        
	 	        //將字串拆解成一個個字元,並儲存到陣列
	 	        for(int x=0; x<len-1; x++)
	 	            sList[x] = last_no.substring(x,x+1);

	 	      sList[len-1] = last_no.substring(len-1);

	 	        for(int x=14; x<len; x++){//取後三位數字
	 	        	myFrame.myCOM_pane.myTrans_no[count]=Integer.valueOf(sList[x]);
	 	        	count++;
	 	        	
	 	        }
	 	       
	 		 }
	 		 
	 		 void setNewNo(){
	 			getLast_trans_No();
	 			 if(myFrame.myCOM_pane.myTrans_no[2]+1>9){//判斷個位數是否需要進位
	 				myFrame.myCOM_pane.myTrans_no[2]=0;
	 				 if(myFrame.myCOM_pane.myTrans_no[1]+1>9){//判斷十位數是否需要進位
	 					myFrame.myCOM_pane.myTrans_no[1]=0;
	 					 if(myFrame.myCOM_pane.myTrans_no[0]+1>9)//判斷是否超過999筆資料
	 		                  JOptionPane.showMessageDialog(null,"類別資料表已滿!");
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

