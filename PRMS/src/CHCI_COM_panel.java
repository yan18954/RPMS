 import javax.swing.*;
 import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//人機互動層類別
//CHCI_COM_panel: Class HumanComputerInteraction_CheckOutMeals_panel (人機介面-[結帳餐點]操作畫面類別)
public class CHCI_COM_panel extends JPanel{
	JLabel IDlbl=new JLabel("交易編號：");
	JLabel datelbl=new JLabel("交易時間：");
	JLabel sumlbl=new JLabel("總金額　：");
	JLabel paywaylbl=new JLabel("付款方式：");
	JLabel servicelbl=new JLabel("服務費　：");
	JLabel marginlbl=new JLabel("差　額　：");
	JLabel elselbl=new JLabel("其他金額：");
	JLabel dealMoneylbl=new JLabel("應收金額：");
	JLabel paylbl=new JLabel("實收金額：");
	JLabel changelbl=new JLabel("找　零　：");
	
	JTextField IDTxtFd =new JTextField();
	JTextField dateTxtFd =new JTextField();
	JLabel sumTxtFd =new JLabel();
	JTextField payTxtFd =new JTextField();
	
	JLabel server_lbl=new JLabel("0");
	JLabel orther_lbl=new JLabel("0");
	JLabel amount_lbl=new JLabel("");

	
	JButton cashbtn =new JButton("現金");
	JButton giftcerbtn =new JButton("禮券");	
	JButton hunderbtn =new JButton("100");
	JButton fivehunderbtn =new JButton("500");	
	JButton thousandbtn =new JButton("1000");	
	JButton countbtn[][] =new JButton[2][5];
	JButton clearbtn=new JButton("清除");
	JButton checkbtn=new JButton("確定");
	
	String [][]countStr={{"1","3","5","7","9"},{"2","4","6","8","0"}};
	String no_date;
	int myTrans_no[]={0,0,0};
	int total=0;
	int temp=0;
	boolean Banknotes=false;	//布林變數,記錄使用者是否選用紙鈔
	boolean Num=false;			//布林變數,紀錄使用者是否直接使用數字鈕點選金額
//	boolean check=false;		//布林變數,紀錄是否可以結帳
	CHCI_COM_panel(){
		
		//設置交易編號
		IDlbl.setBounds(10,5,90,40);
		IDlbl.setFont(new Font("正黑體",1,16));
		IDTxtFd.setBounds(100,8,130,30);
		IDTxtFd.setFont(new Font("正黑體",1,15));		
		IDTxtFd.setBorder(BorderFactory.createLoweredBevelBorder());
		IDTxtFd.setEnabled(false);
		add(IDlbl);
		add(IDTxtFd);		
		//設置交易時間		
		datelbl.setBounds(250,5,90,40);
		datelbl.setFont(new Font("正黑體",1,16));
		dateTxtFd.setBounds(350,8,120,30);
		dateTxtFd.setFont(new Font("正黑體",1,18));	
		dateTxtFd.setBorder(BorderFactory.createLoweredBevelBorder());
		dateTxtFd.setEnabled(false);
		add(datelbl);		
		add(dateTxtFd);	
		setClassDate();
		//設置總金額
		sumlbl.setBounds(10,45,90,45);
		sumlbl.setFont(new Font("正黑體",1,16));
		sumTxtFd.setBounds(100,50,120,30);
		sumTxtFd.setFont(new Font("正黑體",1,18));	
		sumTxtFd.setForeground(Color.red);
		sumTxtFd.setBorder(BorderFactory.createLoweredBevelBorder());	
		//sumTxtFd.setEnabled(false);	
		add(sumlbl);		
		add(sumTxtFd);		
		//設置付款方式
		paywaylbl.setBounds(10,85,90,45);
		paywaylbl.setFont(new Font("正黑體",1,16));
		cashbtn.setBounds(100,88,120,45);
		cashbtn.setFont(new Font("正黑體",0,16));	
		giftcerbtn.setBounds(250,88,120,45);
		giftcerbtn.setFont(new Font("正黑體",0,16));	
		add(paywaylbl);		
		add(cashbtn);	
		add(giftcerbtn);			
		
		//設置服務費，現金
		servicelbl.setBounds(10,130,90,45);
		servicelbl.setFont(new Font("正黑體",1,16));	
		server_lbl.setBounds(100,138,120,30);
		server_lbl.setFont(new Font("正黑體",1,16));	
		add(server_lbl);		
		add(servicelbl);		
		
		//設置差額，禮券
		marginlbl.setBounds(10,170,90,45);
		marginlbl.setFont(new Font("正黑體",1,16));	
		giftcerbtn.setEnabled(false);
		add(marginlbl);		
		marginlbl.setVisible(false);
		//設置其他金額
		elselbl.setBounds(10,170,90,45);
		elselbl.setFont(new Font("正黑體",1,16));	
		orther_lbl.setBounds(100,178,120,30);
		orther_lbl.setFont(new Font("正黑體",1,16));	
		add(elselbl);	
		add(orther_lbl);	

		//設置應收金額
		dealMoneylbl.setBounds(10,210,90,45);
		dealMoneylbl.setFont(new Font("正黑體",1,16));	
		amount_lbl.setBounds(100,210,90,45);
		amount_lbl.setFont(new Font("正黑體",1,18));	
		amount_lbl.setForeground(Color.red);
		add(amount_lbl);
		add(dealMoneylbl);
		
		//設置實收金額
		paylbl.setBounds(10,250,90,45);
		paylbl.setFont(new Font("正黑體",1,16));	
		add(paylbl);	
		payTxtFd.setBounds(100,254,120,30);
		payTxtFd.setFont(new Font("正黑體",0,16));	
		payTxtFd.setBorder(BorderFactory.createLoweredBevelBorder());	
		add(payTxtFd);		
		
		//設置現金
		for(int x=0;x<countbtn.length;x++){
			for(int y=0;y<countbtn[0].length;y++){	
				countbtn[x][y]=new JButton(countStr[x][y]);
				countbtn[x][y].setFont(new Font("正黑體",1,16));	
				countbtn[x][y].setBackground(Color.orange);
				countbtn[x][y].setBounds(10+78*y,360+x*78,75,75);
				countbtn[x][y].setBorderPainted(false);
				countbtn[x][y].addActionListener(ProcessMoneyBtn);
				add(countbtn[x][y]);
			}
		}
		
		clearbtn.setBounds(400,360,75,75);
		clearbtn.setFont(new Font("正黑體",1,16));	
		clearbtn.setBorderPainted(false);
		clearbtn.setBackground(new Color(255, 243, 138));
		clearbtn.addActionListener(ProcessMoneyBtn);
		add(clearbtn);	
		checkbtn.setBounds(400,438,75,75);
		checkbtn.setFont(new Font("正黑體",1,16));	
		checkbtn.setForeground(Color.white);
		checkbtn.setBackground(Color.red);
		checkbtn.addActionListener(ProcessMoneyBtn);
		add(checkbtn);		
		
		
		
		hunderbtn.setBounds(10,290,100,60);
		hunderbtn.setBackground(new Color(237, 121, 115));
		hunderbtn.setFont(new Font("正黑體",1,16));	
		hunderbtn.setBorderPainted(false);
		hunderbtn.addActionListener(ProcessMoneyBtn);
		add(hunderbtn);	
		fivehunderbtn.setBounds(120,290,100,60);
		fivehunderbtn.setBackground(new Color(203, 152, 114));
		fivehunderbtn.setFont(new Font("正黑體",1,16));	
		fivehunderbtn.setBorderPainted(false);
		fivehunderbtn.addActionListener(ProcessMoneyBtn);
		add(fivehunderbtn);	
		thousandbtn.setBounds(240,290,100,60);
		thousandbtn.setBackground(new Color(85, 140, 195));
		thousandbtn.setFont(new Font("正黑體",1,16));	
		thousandbtn.setBorderPainted(false);
		thousandbtn.addActionListener(ProcessMoneyBtn);
		add(thousandbtn);	
		
		
      //  setBackground(Color.pink);
        setLocation(500,100);
        setSize(500,600);
        setLayout(null);
	}
    //事件傾聽程式: 處理收銀金額選按
    public ActionListener ProcessMoneyBtn = new ActionListener(){
        public void actionPerformed(ActionEvent e){
        	if(e.getSource()==clearbtn){//[清除]按鈕
        		payTxtFd.setText("");
        		total=0;					//將總金額初始化為0
            	Banknotes=false;
            	Num=false;
        	}
        	if(e.getSource()==checkbtn){//確定按鈕


        	}
        	if(e.getSource()==hunderbtn){//100
        		total+=100;
            	payTxtFd.setText( String.valueOf(total));
            	Banknotes=true;

        	}
        	if(e.getSource()==fivehunderbtn){//500
        		total+=500;
            	payTxtFd.setText( String.valueOf(total));
            	Banknotes=true;

        	}
        	if(e.getSource()==thousandbtn){//1000
        		total+=1000;
            	payTxtFd.setText( String.valueOf(total));
            	Banknotes=true;

        	}
        	for(int x=0;x<countbtn.length;x++){
        		for(int y=0;y<countbtn[0].length;y++){
        			if(Banknotes==true){//若使用者點選紙鈔,數字按鍵設為不可點按
    					countbtn[x][y].setEnabled(false);
    				}
        			else
    					countbtn[x][y].setEnabled(true);

        				if(e.getSource()==countbtn[x][y]){
        					if(payTxtFd.getText().length()>5)
        	                      JOptionPane.showMessageDialog(null,"單筆交易金額上限為 99 萬！"); 
        					else{
        						Num=true;
            					if(x==0 && y==0)
            						payTxtFd.setText(payTxtFd.getText()+"1");
            					if(x==0 && y==1)
            						payTxtFd.setText(payTxtFd.getText()+"3");
            					if(x==0 && y==2)
            						payTxtFd.setText(payTxtFd.getText()+"5");
            					if(x==0 && y==3)
            						payTxtFd.setText(payTxtFd.getText()+"7");
            					if(x==0 && y==4)
            						payTxtFd.setText(payTxtFd.getText()+"9");
            					if(x==1 && y==0)
            						payTxtFd.setText(payTxtFd.getText()+"2");
            					if(x==1 && y==1)
            						payTxtFd.setText(payTxtFd.getText()+"4");
            					if(x==1 && y==2)
            						payTxtFd.setText(payTxtFd.getText()+"6");
            					if(x==1 && y==3)
            						payTxtFd.setText(payTxtFd.getText()+"8");
            					if(x==1 && y==4)
            						payTxtFd.setText(payTxtFd.getText()+"0");
            
        					}

        	            //	payTxtFd.setText( String.valueOf(total)); //更新總金額
        				}
        				if(Num==true){
        					hunderbtn.setEnabled(false);
        					fivehunderbtn.setEnabled(false);
        					thousandbtn.setEnabled(false);
        				}
        				else{
        					hunderbtn.setEnabled(true);
        					fivehunderbtn.setEnabled(true);
        					thousandbtn.setEnabled(true);	
        				}
        			}
        		
        	}
        	
        	
        	
        	
        }
    };
	//方法:設置當前日期
	 void setClassDate(){
		 Clock c1 = new Clock();
		 String dateStr;
		 int year,month,date;
		 year = c1.getYear();	//取得[系統當前年份資料]
		 month = c1.getMonth(); //取得[系統當前月份資料]
		 date = c1.getDate();   //取得[系統當前天數資料]
		 String y,m,d;
		 y=String.valueOf(year);
		 m=String.valueOf(month);
		 if(m.length()==1)
			 m="0"+m;
		 d=String.valueOf(date);
		 if(d.length()==1)
			 d="0"+d;
		 dateStr = y+("/")+m+("/")+d; //將取得的日期資料以"yyyy/mm/dd"格式存入dateStr字串
		 no_date = y+("")+m+("")+d; 	//將取得的日期給予類別編號的日期字串
		 dateTxtFd.setText(dateStr);
	 }

}
