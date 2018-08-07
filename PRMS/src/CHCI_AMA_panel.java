import javax.activation.MimeType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//人機互動層類別
//CHCI_AC_panel: Class HumanComputerInteraction_AddOrder_panel (人機介面-[新增物料]操作畫面類別)
public class CHCI_AMA_panel extends JPanel implements ActionListener{
	String[] MiType = {"麵","飯","粥","湯","餃"};
	int no[] = {0,0,0};
	String no_date="";
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ToolCheck myToolCheck = new ToolCheck();
	
	JPanel materials=new JPanel();			//JPanel，含新增類別相關資訊	
	
	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("建立新物料：");
	//標題欄位
	JLabel nolbl=new JLabel("物料編號：");
	JLabel typelbl = new JLabel("物料類別：");
	JLabel namelbl=new JLabel("物料名稱：");	
	JLabel notelbl=new JLabel("備      註：");	
	//輸入欄位
    JTextField notxt=new JTextField("");
    JTextField nametxt=new JTextField("");    
    JTextArea notetxt=new JTextArea("",3,12);
    
    //下拉式欄位
    JComboBox<String> TypeCombo = new JComboBox<>(MiType);
    
    JScrollPane scroll=new JScrollPane(notetxt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS 
    		, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   
    JRadioButton[] csradio=new JRadioButton[2];
    JRadioButton[] msradio=new JRadioButton[2];
    JButton addbtn=new JButton("新增");
    JButton clearbtn=new JButton("取消");	
	CHCI_AMA_panel(){	//建構子
		materials.setBounds(0,35,500,550);
		materials.setFont(new Font("正黑體",1,16));
		materials.setLayout(null);
		materials.setOpaque(false);
		add(materials);
		
		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		materials.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("正黑體",1,20));	
		materials.add(titlelbl);			 
	 
		//設置物料編號
		nolbl.setBounds(10,45,150,45);
		nolbl.setFont(new Font("正黑體",1,16));	
		materials.add(nolbl);	
		//notxt.setBounds(110,52,155,30);
		notxt.setBounds(110,52,210,30);
		notxt.setFont(new Font("正黑體",1,16));	
		notxt.setEnabled(false);
		setNewNo();
		materials.add(notxt);		
		
		//設置物料名稱
		namelbl.setBounds(10,90,150,45);
		namelbl.setFont(new Font("正黑體",1,16));	
		materials.add(namelbl);
		nametxt.setBounds(110,97,155,30);
		nametxt.setFont(new Font("正黑體",1,16));	
		materials.add(nametxt);		
		
		//設置物料類別
		typelbl.setBounds(10,135,150,45);
		typelbl.setFont(new Font("正黑體",1,16));	
		materials.add(typelbl);
		//設定物料類別（下拉式選單）
		 TypeCombo.setBounds(110,137,155,35);
		 TypeCombo.setFont(new Font("正黑體",0,16));	
		 TypeCombo.setSelectedIndex(0);
		 materials.add(TypeCombo);
		
		//設置備註
		notelbl.setBounds(10,180,150,45);
		notelbl.setFont(new Font("正黑體",1,16));	
		materials.add(notelbl);				 
		notetxt.setFont(new Font("正黑體",1,16));
		notetxt.setLineWrap(true);
		scroll.setBounds(110,180,250,90);
		materials.add(scroll);		
		
		//設置按鈕
		addbtn.setBounds(310,390,150,60);
		addbtn.setFont(new Font("正黑體",1,16));
		addbtn.setBackground(Color.orange);
		addbtn.setBorderPainted(false);
		addbtn.addActionListener(this);
		materials.add(addbtn);	
		clearbtn.setBounds(10,390,150,60);
		clearbtn.setFont(new Font("正黑體",1,16));	
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		clearbtn.addActionListener(this);
		materials.add(clearbtn);	
		setOpaque(false);
		setBounds(5,65,475,490);
		setLayout(null); 
	 }

	//以下為資料庫功能
	 //以下為資料庫功能
	 private void getLastNo(){	//取得最後一筆order訂單編號，並將流水號存在oreder[]整數陣列內
		String last_no; 
		int count=0;
		last_no=dbma.query_lastkey_TB_mi();
      
		int len = last_no.length();  //取得傳入字串長度(編號長度)

       String[] sList = new String[len];   //建立一個長度為len的字串陣列,用來儲存字串拆解後各個字元用
       
       //將字串拆解成一個個字元,並儲存到陣列
       for(int x=0; x<len-1; x++)
           sList[x] = last_no.substring(x,x+1);

       sList[len-1] = last_no.substring(len-1);

       for(int x=len-3; x<len; x++){	//取後三位數字（流水號）
       	no[count]=Integer.valueOf(sList[x]);
       	count++;
       }
	 }
	
	 void setNewNo(){
		 setDate();
		 getLastNo();
		 if(no[2]+1>9){	//判斷個位數是否需要進位
			 no[2]=0;
			 if(no[1]+1>9){	//判斷十位數是否需要進位
				 no[1]=0;
				 if(no[0]+1>9)		//判斷是否超過999筆資料
	                  JOptionPane.showMessageDialog(null,"類別資料表已滿!");
				 else
					 no[0]++;
			 }
			 else
				 no[1]++;
		 }
		 else
			 no[2]++;
		 
		 notxt.setText("MI01"+no_date+no[0]+no[1]+no[2]);
	 }
	 
	 void setDate(){
		 Clock c1 = new Clock();
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
		 no_date = y+("")+m+("")+d; 	//將取得的日期給予類別編號的日期字串
	 }	 
	 
	 private void ClearAll(){
		 nametxt.setText(null);
		 notetxt.setText(null);
	 }

	 private void AddMi(){	//新增類別
		 CPD_mi commands = new CPD_mi();
		 commands.setNo(notxt.getText());
		 commands.setName(nametxt.getText());
		 commands.setState(TypeCombo.getSelectedItem().toString());
		 commands.setNote(notetxt.getText());
		 
		 dbma.insertRD_into_TB_mi(commands);
		 setNewNo();
	 }
	 
	 public void actionPerformed(ActionEvent e){		//事件傾聽
		 if(e.getSource() == addbtn){		//處理確認btn被按下
			 if(JOptionPane.showConfirmDialog(null, "確定要新增此物料?","確認新增物料",JOptionPane.OK_CANCEL_OPTION)	==0 ){
				 //尚未加上檢查方法
				 AddMi();
				 ClearAll();
			 }
		 }
		 else if(e.getSource() == clearbtn){	//處理取消按鈕被按下
			 ClearAll();
		 }
	 }
}
