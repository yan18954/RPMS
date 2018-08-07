import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//人機互動層類別
//CHCI_EC_panel: Class HumanComputerInteraction_EditClass_panel (人機介面-[編輯類別]操作畫面類別)
public class CHCI_EC_panel extends JPanel{
	int class_no[]={0,0,0};
	String no_date="";
	JPanel class_pane=new JPanel();			//JPanel，含新增類別相關資訊	

	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("編輯類別：");
	JLabel nolbl=new JLabel("類別編號：");
	JLabel datelbl=new JLabel("建立日期：");
	JLabel namelbl=new JLabel("類別名稱：");
	JLabel kindlbl=new JLabel("分          類：");	
	JLabel statelbl=new JLabel("類別狀態：");
	JLabel notelbl=new JLabel("備      註：");	
	
    JTextField notxt=new JTextField("");
    JTextField datatxt=new JTextField("");
    JTextField nametxt=new JTextField("");   
  // JTextField kindtxt=new JTextField("");
    JTextField statetxt=new JTextField("");
    JTextArea notetxt=new JTextArea("",3,12);
    
    JScrollPane scroll=new JScrollPane(notetxt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS 
    		, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   
    JRadioButton[] ckradio=new JRadioButton[2];
    JRadioButton[] csradio=new JRadioButton[2];
    JButton addbtn=new JButton("更新");
    JButton clearbtn=new JButton("取消");
    
    String kindStr="主人";
    String stateStr="開啟";
    
    Boolean getenable=false;
	CHCI_EC_panel(){
		class_pane.setBounds(0,0,500,550);
		class_pane.setFont(new Font("正黑體",1,16));
		class_pane.setLayout(null);
		class_pane.setOpaque(false);
		add(class_pane);

		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		class_pane.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("正黑體",1,20));	
		class_pane.add(titlelbl);			
		
		//設置建立日期
		datelbl.setBounds(10,90,150,45);
		datelbl.setFont(new Font("正黑體",1,16));	
		class_pane.add(datelbl);	
		datatxt.setBounds(110,97,155,30);
		datatxt.setFont(new Font("正黑體",1,16));	
		datatxt.setEnabled(false);
		setClassDate();
		class_pane.add(datatxt);
		
		//設置類別編號
		nolbl.setBounds(10,45,150,45);
		nolbl.setFont(new Font("正黑體",1,16));	
		class_pane.add(nolbl);	
		notxt.setBounds(110,52,180,30);
		notxt.setFont(new Font("正黑體",1,16));	
		notxt.setEnabled(false);
		setNewNo();	//設置類別編號
		class_pane.add(notxt);	
	
		
		//設置類別名稱
		namelbl.setBounds(10,135,150,45);
		namelbl.setFont(new Font("正黑體",1,16));	
		class_pane.add(namelbl);
		nametxt.setBounds(110,142,155,30);
		nametxt.setFont(new Font("正黑體",1,16));	
		class_pane.add(nametxt);		
		
		//設置類別分類
		kindlbl.setBounds(10,180,150,45);
		kindlbl.setFont(new Font("正黑體",1,16));	
		class_pane.add(kindlbl);		
		setClassKind();		
		
		//設置類別狀態
		statelbl.setBounds(10,225,150,45);
		statelbl.setFont(new Font("正黑體",1,16));	
		class_pane.add(statelbl);	
		setClassState();
	
		//設置備註
		notelbl.setBounds(10,270,150,45);
		notelbl.setFont(new Font("正黑體",1,16));	
		class_pane.add(notelbl);				 
		notetxt.setFont(new Font("正黑體",1,16));
		notetxt.setBorder(BorderFactory.createLineBorder(Color.blue));
		notetxt.setLineWrap(true);
		scroll.setBounds(110,270,250,90);
		class_pane.add(scroll);		
		
		//設置按鈕
		addbtn.setBounds(310,425,150,60);
		addbtn.setFont(new Font("正黑體",1,16));
		addbtn.setBackground(Color.orange);
		addbtn.setBorderPainted(false);
		class_pane.add(addbtn);	
		clearbtn.setBounds(10,425,150,60);
		clearbtn.setFont(new Font("正黑體",1,16));	
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		class_pane.add(clearbtn);	
		setOpaque(false);
		setBounds(5,65,475,490);
		setLayout(null); 
	 }
	 private void getLastNo(){
		String last_no; 
		int num,count=0;
		CDM_dbma cdm1=new CDM_dbma();
		last_no=cdm1.query_lastkey_TB_class();
       
		int len = last_no.length();  //取得傳入字串長度
        String[] sList = new String[len];   //建立一個長度為len的字串陣列,用來儲存字串拆解後各個字元用

        
        //將字串拆解成一個個字元,並儲存到陣列
        for(int x=0; x<len-1; x++)
            sList[x] = last_no.substring(x,x+1);

        sList[len-1] = last_no.substring(len-1);

        for(int x=13; x<len; x++){//取後三位數字
        	class_no[count]=Integer.valueOf(sList[x]);
        	count++;
        }
       
	 }
	 
	 void setNewNo(){
		 getLastNo();
		 if(class_no[2]+1>9){//判斷個位數是否需要進位
			 class_no[2]=0;
			 if(class_no[1]+1>9){//判斷十位數是否需要進位
				 class_no[1]=0;
				 if(class_no[0]+1>9)//判斷是否超過999筆資料
	                  JOptionPane.showMessageDialog(null,"類別資料表已滿!");
				 else
					 class_no[0]++;
			 }
			 else
				 class_no[1]++;
		 }
		 else
			 class_no[2]++;
		 
		notxt.setText("CLS01"+no_date+class_no[0]+class_no[1]+class_no[2]);
	 }
	 
	 void initialize_Filed(){
		nametxt.setText("");
		notetxt.setText("");
	 }
	 
	 void setClassDate(){
		 Clock c1 = new Clock();
		 String dateStr;
		 int year,month,date;
		 year = c1.getYear();	//取得[系統當前年份資料]
		 month = c1.getMonth(); //取得[系統當前月份資料]
		 date = c1.getDate();   //取得[系統當前天數資料]
		 dateStr = year+("/")+month+("/")+date; //將取得的日期資料以"yyyy/mm/dd"格式存入dateStr字串
		 no_date = year+("")+month+("")+date; 	//將取得的日期給予類別編號的日期字串
		 datatxt.setText(dateStr);
	 }
	 
	 private void setClassKind(){
		ckradio[0]=new JRadioButton("主   人",true);
		ckradio[1]=new JRadioButton("寵	物");
		ButtonGroup ckgroup=new ButtonGroup();
		for(int i=0;i<ckradio.length;i++){
			ckradio[i].setBounds(110+80*i,187,100,30);
			ckradio[i].setFont(new Font("正黑體",0,16));	
			ckradio[i].setContentAreaFilled(false);
			ckradio[i].addActionListener(ProcessPressed);
			ckgroup.add(ckradio[i]);
			class_pane.add(ckradio[i]);
		}
	 }
	 
	 private void setClassState(){
		csradio[0]=new JRadioButton("開	啟",true);
		csradio[1]=new JRadioButton("關	閉");
		ButtonGroup csgroup=new ButtonGroup();
		for(int i=0;i<csradio.length;i++){
			csradio[i].setBounds(110+80*i,232,100,30);
			csradio[i].setFont(new Font("正黑體",0,16));	
			csradio[i].setContentAreaFilled(false);
			csradio[i].addActionListener(ProcessPressed);
			csgroup.add(csradio[i]);
			class_pane.add(csradio[i]);
		}
	 }
	 public void clear_field(){
		 notxt.setText("");
		 datatxt.setText("");
		 nametxt.setText("");
		 statetxt.setText("");
		 notetxt.setText("");
	 }
	 //事件傾聽程式: 處理圓形選單按鈕選按
     public ActionListener ProcessPressed = new ActionListener(){
         public void actionPerformed(ActionEvent e){
        	 if(e.getSource()== ckradio[0]){
        		 kindStr="主人";
        	 }
        	 if(e.getSource()== ckradio[1]){
        		 kindStr="寵物";
        	 }
        	 if(e.getSource() == csradio[0]){
        		 stateStr="開啟";
        	 }
        	 if(e.getSource() == csradio[1]){
        		 stateStr="關閉";
        	 }
         }
     };
	 
}
