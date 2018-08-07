import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//人機互動層類別
//CHCI_EM_panel: Class HumanComputerInteraction_EditMeals_panel (人機介面-[新增分類]操作畫面類別)
public class CHCI_EM_panel extends JPanel{
	JPanel meals_pane=new JPanel();			//JPanel，含新增餐點相關資訊	
	String no_date="";
	int meal_no[]={0,0,0};
	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("編輯餐點：");
	 JLabel nolbl=new JLabel("餐點編號：");
	JLabel datelbl=new JLabel("建立日期：");
	JLabel namelbl=new JLabel("餐點名稱：");
	 JLabel kindlbl=new JLabel("餐點分類：");
	JLabel classlbl=new JLabel("餐點類別：");
	 JLabel materlbl=new JLabel("使用物料：");
	JLabel statelbl=new JLabel("餐點狀態：");
	JLabel pricelbl=new JLabel("餐點價格：");		
	JLabel mnotelbl=new JLabel("備      註：");	
	
    JTextField notxt=new JTextField("");
    JTextField datetxt=new JTextField("");
    JTextField nametxt=new JTextField("");    
    JTextField pricetxt=new JTextField("");
    
    JTextArea notetxt=new JTextArea("",3,12);
    
    JScrollPane scroll=new JScrollPane(notetxt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS 
    		, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    JRadioButton[] kindradio=new JRadioButton[2];  
    JRadioButton[] msradio=new JRadioButton[2];
    JButton addbtn=new JButton("更新");
    JButton clearbtn=new JButton("取消");
    
	String[] class_items={};
	JComboBox<String> class_jcb = new JComboBox<>(class_items);			         //餐點類別下拉式選單
	String[] material_type_items={};
	JComboBox<String> material_type_jcb = new JComboBox<>(material_type_items);	//物料種類分類下拉式選單
	String[] material_items={};
	JComboBox<String> material_jcb = new JComboBox<>(material_items);	        //物料種類下拉式選單
    boolean man_selected=true;	//用來記錄當前選取的餐點分類為主人或是寵物
    boolean use_material=false; //用來記錄餐點是否有使用物料
    String kindStr="主人";
    String stateStr="販售";
    
    Boolean getenable=false;

    CHCI_EM_panel(){
    	meals_pane.setBounds(0,0,500,550);
    	meals_pane.setFont(new Font("正黑體",1,16));
    	meals_pane.setLayout(null);
    	meals_pane.setOpaque(false);
		add(meals_pane);

		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("editmeals_icon.png")));
		meals_pane.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("正黑體",1,20));	
		meals_pane.add(titlelbl);			 
	 
		//設置建立日期
		datelbl.setBounds(10,88,150,45);
		datelbl.setFont(new Font("正黑體",1,16));	
		meals_pane.add(datelbl);
		datetxt.setBounds(110,95,155,30);
		datetxt.setFont(new Font("正黑體",1,16));	
		datetxt.setEnabled(false);
		meals_pane.add(datetxt);
//		setMealDate();
		
		//設置餐點編號
		nolbl.setBounds(10,45,150,45);
		nolbl.setFont(new Font("正黑體",1,16));	
		meals_pane.add(nolbl);	
		notxt.setBounds(110,52,180,30);
		notxt.setFont(new Font("正黑體",1,16));	
		notxt.setEnabled(false);
//		setNewNo();	//設置餐點編號
		meals_pane.add(notxt);
		
		//設置餐點名稱
		namelbl.setBounds(10,133,150,45);
		namelbl.setFont(new Font("正黑體",1,16));	
		meals_pane.add(namelbl);	
		nametxt.setBounds(110,140,155,30);
		nametxt.setFont(new Font("正黑體",1,16));	
		meals_pane.add(nametxt);	
		
		//設置餐點分類
		kindlbl.setBounds(10,178,150,45);
		kindlbl.setFont(new Font("正黑體",1,16));	
		meals_pane.add(kindlbl);	
			//設置圓形選擇按鈕
		setMealKind();
		//設置餐點類別
		classlbl.setBounds(10,228,150,45);
		classlbl.setFont(new Font("正黑體",1,16));	
		meals_pane.add(classlbl);	
			//設置下拉式選單
		setClassCombo();
		//設置使用物料
		materlbl.setBounds(10,278,150,45);
		materlbl.setFont(new Font("正黑體",1,16));	
		meals_pane.add(materlbl);		
			//設置下拉式選單
		setMaterCombo();
		//設置餐點狀態
		statelbl.setBounds(10,328,150,45);
		statelbl.setFont(new Font("正黑體",1,16));	
		meals_pane.add(statelbl);		
			//設置圓形選擇鈕
		setMealState();
		//設置餐點價格
		pricelbl.setBounds(10,378,150,45);
		pricelbl.setFont(new Font("正黑體",1,16));	
		meals_pane.add(pricelbl);	
		pricetxt.setBounds(110,385,100,30);
		pricetxt.setFont(new Font("正黑體",1,16));	
		meals_pane.add(pricetxt);		
		//設置按鈕
		addbtn.setBounds(310,427,150,60);
		addbtn.setFont(new Font("正黑體",1,16));
		addbtn.setBackground(Color.orange);
		addbtn.setBorderPainted(false);
		meals_pane.add(addbtn);	
		clearbtn.setBounds(10,427,150,60);
		clearbtn.setFont(new Font("正黑體",1,16));	
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		meals_pane.add(clearbtn);	
		setOpaque(false);
		setBounds(5,65,475,490);
		setLayout(null); 
	 }

	 private void setMealKind(){
		kindradio[0]=new JRadioButton("主	人",true);
		kindradio[1]=new JRadioButton("寵	物");
		ButtonGroup kindgroup=new ButtonGroup();
		for(int i=0;i<kindradio.length;i++){
			kindradio[i].setBounds(110+80*i,185,100,30);
			kindradio[i].setFont(new Font("正黑體",0,16));	
			kindradio[i].setContentAreaFilled(false);
			kindradio[i].addActionListener(ProcessPressed);
			kindgroup.add(kindradio[i]);
			meals_pane.add(kindradio[i]);
		}
    }
	 private void setClassCombo(){//設置類別下拉式選單
		 class_jcb.setBounds(110,235,100,35);
		 class_jcb.setFont(new Font("正黑體",0,16));	
		 meals_pane.add(class_jcb);
	 }	
	 private void setMaterCombo(){//設置物料下拉式選單
		 //設置物料分類
		 material_type_jcb.setBounds(110,283,100,35);
		 material_type_jcb.setFont(new Font("正黑體",0,16));	
		 meals_pane.add(material_type_jcb);	
		 //設置物料種類
		 material_jcb.setBounds(220,283,180,35);
		 material_jcb.setFont(new Font("正黑體",0,16));	
		 material_jcb.setVisible(false);
		 meals_pane.add(material_jcb);	 
	 }	 
	 private void setMealState(){
		msradio[0]=new JRadioButton("販	售",true);
		msradio[1]=new JRadioButton("停	售");
		ButtonGroup msgroup=new ButtonGroup();
		for(int i=0;i<msradio.length;i++){
			msradio[i].setBounds(110+80*i,333,100,30);
			msradio[i].setFont(new Font("正黑體",0,16));	
			msradio[i].setContentAreaFilled(false);
			msradio[i].addActionListener(ProcessPressed);
			msgroup.add(msradio[i]);
			meals_pane.add(msradio[i]);
		}
     }
/*	 void setMealDate(){
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
		 no_date = y+("")+m+("")+d;   //將取得的日期給予餐點編號的日期字串
		 datetxt.setText(dateStr);
	 }
*/
/*	 private void getLastNo(){
		String last_no; 
		int num,count=0;
		CDM_dbma cdm1=new CDM_dbma();
		last_no=cdm1.query_lastkey_TB_meal();
       
		int len = last_no.length();  //取得傳入字串長度
        String[] sList = new String[len];   //建立一個長度為len的字串陣列,用來儲存字串拆解後各個字元用

        
        //將字串拆解成一個個字元,並儲存到陣列
        for(int x=0; x<len-1; x++)
            sList[x] = last_no.substring(x,x+1);

        sList[len-1] = last_no.substring(len-1);

        for(int x=14; x<len; x++){//取後三位數字
        	meal_no[count]=Integer.valueOf(sList[x]);
        	count++;
        }
       
	 }
*/
/*	 
	 void setNewNo(){
		 getLastNo();
		 if(meal_no[2]+1>9){//判斷個位數是否需要進位
			 meal_no[2]=0;
			 if(meal_no[1]+1>9){//判斷十位數是否需要進位
				 meal_no[1]=0;
				 if(meal_no[0]+1>9)//判斷是否超過999筆資料
	                  JOptionPane.showMessageDialog(null,"類別資料表已滿!");
				 else
					 meal_no[0]++;
			 }
			 else
				 meal_no[1]++;
		 }
		 else
			 meal_no[2]++;
		 
		notxt.setText("MEAL01"+no_date+meal_no[0]+meal_no[1]+meal_no[2]);
	 }	 
*/	 
	 void initialize_Filed(){
		nametxt.setText("");
		notetxt.setText("");
		pricetxt.setText("");
	 }
	 //事件傾聽程式: 處理圓形選單按鈕選按
     public ActionListener ProcessPressed = new ActionListener(){
         public void actionPerformed(ActionEvent e){
        	 if(e.getSource()== kindradio[0]){
        		 kindStr="主人";
        		 man_selected=true;
        	 }
        	 if(e.getSource()== kindradio[1]){
        		 kindStr="寵物";
        		 man_selected=false;
        	 }
        	 if(e.getSource() == msradio[0]){
        		 stateStr="販售";
        	 }
        	 if(e.getSource() == msradio[1]){
        		 stateStr="停售";
        	 }
         }
     };
}
