import javax.swing.*;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.State;
import java.util.ArrayList;


//人機互動層類別
//CHCI_AC_panel: Class HumanComputerInteraction_AddOrder_panel (人機介面-[新增物料]操作畫面類別)
public class CHCI_AO_panel extends JPanel implements ActionListener{
	//變數設定
	String[] status={"未付款","已付款","取消訂單","結單"};
	ArrayList<String> companylist = new ArrayList<String>();
	
	int order_no[] = {0,0,0};
	String no_date="";	
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ToolCheck myTool = new ToolCheck();
	
	JPanel order_pane=new JPanel();			//JPanel，含新訂單別相關資訊	

	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("建立新訂單：");
	
	JLabel nolbl=new JLabel("訂單編號：");
	JLabel datelbl=new JLabel("訂單日期：");
	JLabel statelbl=new JLabel("訂單狀態：");	
	JLabel companylbl=new JLabel("廠商：");	
	JLabel totallbl=new JLabel("總金額：");	
	
    //輸入欄位
    JTextField notxt=new JTextField("");
    JTextField datetxt=new JTextField("");    
    JTextField statetxt=new JTextField("");
    JTextField totaltxt=new JTextField("");
    
    //下拉式欄位
    JComboBox<String> StatusCombo = new JComboBox<>(status);
    JComboBox<String> CompanyCombo = new JComboBox<>();
   
    JRadioButton[] csradio=new JRadioButton[2];
    JRadioButton[] msradio=new JRadioButton[2];
    JButton addbtn=new JButton("新增");
    JButton clearbtn=new JButton("取消");
    
	CHCI_AO_panel(){		//建構子
		order_pane.setBounds(0,35,500,550);
		order_pane.setFont(new Font("正黑體",1,16));
		order_pane.setLayout(null);
		order_pane.setOpaque(false);
		add(order_pane);

		titleiconlbl.setBounds(0,0,32,32);	
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		order_pane.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("正黑體",1,20));	
		order_pane.add(titlelbl);			 
	 
		//設置訂單編號
		nolbl.setBounds(10,45,150,45);
		nolbl.setFont(new Font("正黑體",1,16));	
		order_pane.add(nolbl);	
		//		notxt.setBounds(110,52,155,30);
		notxt.setBounds(110,52,210,30);	
		notxt.setFont(new Font("正黑體",1,16));	
		notxt.setEnabled(false);
		setNewNo();	//使用setNewNo方法，自動設定最新訂單編號。
		order_pane.add(notxt);	
		//設置建立日期
		datelbl.setBounds(10,90,150,45);
		datelbl.setFont(new Font("正黑體",1,16));	
		order_pane.add(datelbl);
		datetxt.setBounds(110,97,155,30);
		datetxt.setFont(new Font("正黑體",1,16));	
		datetxt.setEnabled(false);
		setDate();	//使用setDate方法，自動設定該欄位數值。
		order_pane.add(datetxt);		
		//設置訂單狀態
		statelbl.setBounds(10,135,150,45);
		statelbl.setFont(new Font("正黑體",1,16));	
		order_pane.add(statelbl);
		//setOrderCombo();
		
		//設定訂單狀態（下拉式選單）
		 StatusCombo.setBounds(110,137,100,35);
		 StatusCombo.setFont(new Font("正黑體",0,16));	
		 StatusCombo.setSelectedIndex(0);
		 order_pane.add(StatusCombo);
		 
		//設置廠商編號
		companylbl.setBounds(10,180,150,45);
		companylbl.setFont(new Font("正黑體",1,16));
		order_pane.add(companylbl);	
		
		//設置廠商選擇（下拉式選單）
		//CompanyCombo.setBounds(110,187,100,35);	//初始數值
		CompanyCombo.setBounds(110,187,155,35);
		CompanyCombo.setFont(new Font("正黑體",0,16));	
		getCompanyList();	//新增廠商下拉式列表
		//CompanyCombo.setSelectedIndex(0);
		order_pane.add(CompanyCombo);
		
		//設置總金額
		totallbl.setBounds(10,225,150,45);
		totallbl.setFont(new Font("正黑體",1,16));	
		order_pane.add(totallbl);				 
		totaltxt.setFont(new Font("正黑體",1,16));
		totaltxt.setBounds(110,232,155,30);
		order_pane.add(totaltxt);
		//設置按鈕
		addbtn.setBounds(310,390,150,60);
		addbtn.setFont(new Font("正黑體",1,16));
		addbtn.setBackground(Color.orange);
		addbtn.setBorderPainted(false);
		addbtn.addActionListener(this);		//註冊事件傾聽器
		order_pane.add(addbtn);	
		clearbtn.setBounds(10,390,150,60);
		clearbtn.setFont(new Font("正黑體",1,16));	
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		clearbtn.addActionListener(this);
		order_pane.add(clearbtn);	
		setOpaque(false);
		setBounds(5,65,475,490);
		setLayout(null); 
	 }	 
	
	public void getCompanyList() {	//取得與更新廠商列表
		CompanyCombo.removeAllItems();
		companylist = dbma.findRD_in_TB_cllist();
		for(int i=0 ;i<companylist.size() ;i++ ){
			CompanyCombo.addItem(companylist.get(i));
		}
		
	}
	
	 //以下為資料庫功能
	 private void getLastNo(){	//取得最後一筆order訂單編號，並將流水號存在oreder[]整數陣列內
		String last_no; 
		int count=0;
		last_no=dbma.query_lastkey_TB_order();
		int len = last_no.length();  //取得傳入字串長度(編號長度)
        String[] sList = new String[len];   //建立一個長度為len的字串陣列,用來儲存字串拆解後各個字元用
        
        //將字串拆解成一個個字元,並儲存到陣列
        for(int x=0; x<len-1; x++)
            sList[x] = last_no.substring(x,x+1);
        
        sList[len-1] = last_no.substring(len-1);

        for(int x=len-3; x<len; x++){	//取後三位數字（流水號）
        	order_no[count]=Integer.valueOf(sList[x]);
        	count++;
        }
	 }
	 
	 void setNewNo(){
		 getLastNo();
		 setDate();
		 if(order_no[2]+1>9){	//判斷個位數是否需要進位
			 order_no[2]=0;
			 if(order_no[1]+1>9){	//判斷十位數是否需要進位
				 order_no[1]=0;
				 if(order_no[0]+1>9)		//判斷是否超過999筆資料
	                  JOptionPane.showMessageDialog(null,"類別資料表已滿!");
				 else
					 order_no[0]++;
			 }
			 else
				 order_no[1]++;
		 }
		 else
			 order_no[2]++;
		 
		notxt.setText("ORDER01"+no_date+order_no[0]+order_no[1]+order_no[2]);
	 }
	 
	 void setDate(){
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
		 datetxt.setText(dateStr);
	 }	 
	 
	 //將所有輸入欄位的值清空
	 private void ClearAll(){
		 totaltxt.setText(null);		//總金額欄位清空
		 StatusCombo.setSelectedIndex(0);
		 CompanyCombo.setSelectedIndex(0);
	 }
	 	 
	 private void AddOrder(){	//新增訂單
		 CPD_order commands = new CPD_order();
		 commands.setNo(notxt.getText());
		 commands.setDate(datetxt.getText());
		 commands.setStatus((StatusCombo.getSelectedIndex()));	//(0)未付款  (1)已付款 (2)取消訂單 (3)結單
		 commands.setClNo(dbma.findRD_in_TB_ClColumn(CompanyCombo.getSelectedItem().toString(), "CL_company", "CL_no"));	//取得廠商編號
		 commands.setAmount(Integer.parseInt(totaltxt.getText()));
		 
		 dbma.insertRD_into_TB_order(commands);
		 setNewNo();
	 }
	 
	 public void actionPerformed(ActionEvent e){	//事件傾聽
		 if(e.getSource() == addbtn){		//處理確認btn被按下
			 if(JOptionPane.showConfirmDialog(null, "確定要新增此訂單?","確認新增訂單",JOptionPane.OK_CANCEL_OPTION)	==0 ){
				 //尚未加上檢查方法
				 AddOrder();
				 ClearAll();
			 }
		 }
		 else if(e.getSource() == clearbtn){	//處理取消按鈕被按下
			 ClearAll();
		 }
	 }
}