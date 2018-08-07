import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
//人機互動層類別
//CHCI_QM_panel: Class HumanComputerInteraction_QueryMealsclass_panel (人機介面-[查詢餐點類別]操作畫面類別)
public class CHCI_QM_panel extends JPanel{
	JPanel query_pane=new JPanel();		
	JPanel query2_pane=new JPanel();	//JPanel
	JButton quertbtn=new JButton("查詢");
	JButton querAddtbtn=new JButton();
	JButton querDectbtn=new JButton();
	JRadioButton[] kindradio=new JRadioButton[2];	//選擇類別查詢或餐點查詢
	boolean kindSelected=true;	//判斷類別(true)或是餐點(false)被選擇
	boolean second=false;		//判斷第二個條件是否被選用
	String[] items={"類別編號","類別名稱","類別分類","建立日期","類別狀態","備       註"};
	String[] items2={"餐點編號","餐點名稱","餐點類別","建立日期","餐點物料","單價","餐點狀態"};
	String[] logic={" > "," < "," = "};
	String[] logic2={"包含","不包含"};
	String[] and_or={"AND","OR"};
	JComboBox<String> qu1_class_jcb = new JComboBox<>(items);	//類別查詢條件1下拉式選單
	JComboBox<String> qu1_meal_jcb = new JComboBox<>(items2);	//餐點查詢條件1下拉式選單
	JComboBox<String> qu2_class_jcb = new JComboBox<>(items);	//類別查詢條件2下拉式選單
	JComboBox<String> qu2_meal_jcb = new JComboBox<>(items2);	//餐點查詢條件2下拉式選單
	JComboBox<String> qulog1jcb = new JComboBox<>(logic);	    //邏輯條件1下拉式選單,含>,<=
	JComboBox<String> qulog2jcb = new JComboBox<>(logic2);	    //邏輯條件1下拉式選單,含包含,不包含
	JComboBox<String> qulog3jcb = new JComboBox<>(logic);	    //邏輯條件2下拉式選單,含>,<=
	JComboBox<String> qulog4jcb = new JComboBox<>(logic2);	    //邏輯條件2下拉式選單,含包含,不包含
	JComboBox<String> quAnd_Orjcb = new JComboBox<>(and_or);	//And,Or下拉式選單

	JTextField cond1txt=new JTextField();						//關鍵字1
	JTextField cond2txt=new JTextField();                       //關鍵字2
	CHCI_QM_panel(){
		//設置JRadioButton
		kindradio[0]=new JRadioButton("查詢類別",true);
		kindradio[1]=new JRadioButton("查詢餐點");
		ButtonGroup csgroup=new ButtonGroup();
		for(int i=0;i<kindradio.length;i++){
			kindradio[i].setBounds(420,69,80,25);
			kindradio[i].setFont(new Font("正黑體",0,12));	
			kindradio[i].setContentAreaFilled(false);
			kindradio[i].addActionListener(ProcessFunSelection);
			csgroup.add(kindradio[i]);
			add(kindradio[i]);		
		}
		kindradio[0].setVisible(false);	//預設"切換類別"關閉
		
		query_pane.setBackground(new Color(190, 233, 228));
		query_pane.setBounds(0,0,500,65);
		query_pane.setFont(new Font("正黑體",0,14));	
		query_pane.setLayout(null);
		add(query_pane);

		query2_pane.setBackground(Color.yellow);
		query2_pane.setBounds(0,65,500,35);
		query2_pane.setFont(new Font("正黑體",0,14));	
		query2_pane.setLayout(null);
		add(query2_pane);
		query2_pane.setVisible(false);  //隱藏[新增查詢條件]操作畫面
		
		
		setQuery1ComboBox();//設置第一個條件查詢
		setQueryLogic1ComboBox();//設置第一個邏輯
		
		//設置查詢按鈕
		quertbtn.setBounds(380,5,100,45);
		quertbtn.setFont(new Font("正黑體",0,14));	
		quertbtn.setIcon(new ImageIcon(getClass().getResource("search_icon.png")));
		query_pane.add(quertbtn);	
		
		setQueryCond1();//設置條件一
		
		//設置加入條件按鈕
		querAddtbtn.setBounds(340,15,24,24);
		querAddtbtn.setIcon(new ImageIcon(getClass().getResource("plus_icon.png")));	
		querAddtbtn.setBorderPainted(false);
		querAddtbtn.setBackground(Color.yellow);
	    querAddtbtn.addActionListener(ProcessFunSelection);   //[操作查詢]操作畫面的[增加]按鈕
		query_pane.add(querAddtbtn);	

		setQuerAnd_OrComboBox();//設置and,or條件
		setQuery2ComboBox();//設置第二個查詢條件
		setQueryLogic3ComboBox();//設置第二個邏輯條件
		setQueryCond2();//設置第二個查詢條件
		
		//設置減少條件按鈕
		querDectbtn.setBounds(380,5,24,24);
		querDectbtn.setBackground(Color.white);
		querDectbtn.setIcon(new ImageIcon(getClass().getResource("decrease_icon.png")));	
		querDectbtn.setBorderPainted(false);
		querDectbtn.addActionListener(ProcessFunSelection);   //[操作查詢]操作畫面的[減少]按鈕
		query2_pane.add(querDectbtn);
		
	    setBounds(0,0,500,100);
	    setLayout(null);
	}
	 /*第一個查詢條件設置*/
	 public void setQuery1ComboBox(){
		 if(kindSelected==true){
			 qu1_class_jcb.setBounds(5,12,90,35);
			 qu1_class_jcb.setFont(new Font("正黑體",0,14));	
			 qu1_class_jcb.setVisible(true);
			 qu1_meal_jcb.setVisible(false);	//隱藏[查詢餐點]相關條件
			 qu1_class_jcb.addActionListener(ProcessFunSelection);
			 query_pane.add(qu1_class_jcb);		 
		 }
		 else{
			 qu1_meal_jcb.setBounds(5,12,90,35);
			 qu1_meal_jcb.setFont(new Font("正黑體",0,14));	
			 qu1_meal_jcb.setVisible(true);
			 qu1_class_jcb.setVisible(false);	//隱藏[查詢類別]相關條件
			 qu1_meal_jcb.addActionListener(ProcessFunSelection);
			 query_pane.add(qu1_meal_jcb);	 
		 }
	 }
	 private void setQueryLogic1ComboBox(){
			//預設,類別編號邏輯條件
		    qulog1jcb.setBounds(100,12,70,35);
			qulog1jcb.setFont(new Font("正黑體",0,14));	
			query_pane.add(qulog1jcb);
	 }
	 private void setQueryCond1(){
		 //關鍵字欄位1
		 cond1txt.setBounds(180,12,150,35);
		 cond1txt.setFont(new Font("正黑體",0,14));	
		 query_pane.add(cond1txt);
	 }
	 /*第二個查詢條件設置*/
	 private void setQuerAnd_OrComboBox(){
		 quAnd_Orjcb.setBounds(5,5,70,25);
		 quAnd_Orjcb.setFont(new Font("正黑體",0,14));	
		 query2_pane.add(quAnd_Orjcb);
	 }
	 private void setQuery2ComboBox(){
		 if(kindSelected==true){
			 qu2_class_jcb.setBounds(80,5,100,25);
			 qu2_class_jcb.setFont(new Font("正黑體",0,14));	
			 qu2_class_jcb.setVisible(true);
			 qu2_meal_jcb.setVisible(false);	//隱藏[查詢餐點]相關條件
			 qu2_class_jcb.addActionListener(ProcessFunSelection);
			 query2_pane.add(qu2_class_jcb);		 
		 }
		 else{
			 qu2_meal_jcb.setBounds(80,5,100,25);
			 qu2_meal_jcb.setFont(new Font("正黑體",0,14));	
			 qu2_meal_jcb.setVisible(true);
			 qu2_class_jcb.setVisible(false);	//隱藏[查詢類別]相關條件
			 qu2_meal_jcb.addActionListener(ProcessFunSelection);
			 query2_pane.add(qu2_meal_jcb);	 
		 }
	 }
	 private void setQueryLogic3ComboBox(){
		 //預設,類別編號邏輯條件
		 qulog3jcb.setBounds(190,5,70,25);
		 qulog3jcb.setFont(new Font("正黑體",0,14));	
		 query2_pane.add(qulog3jcb);
	 }
	 private void setQueryCond2(){
		 //關鍵字欄位2 
		 cond2txt.setBounds(270,5,100,25);
		 cond2txt.setFont(new Font("正黑體",0,14));	
		 query2_pane.add(cond2txt);
	 }

     //事件傾聽程式: 處理功能選按
     public ActionListener ProcessFunSelection = new ActionListener(){
         public void actionPerformed(ActionEvent e){
        	 if(e.getSource()== kindradio[0]){ //當"查詢類別"被選案
        		 kindradio[0].setSelected(true);
        		 kindSelected=true;				//kindSelected為true,表示類別被選按
        		 kindradio[0].setVisible(false);//隱藏查"查詢類別"
        		 kindradio[1].setVisible(true); //顯示查"查詢餐點"
        		 //顯示查詢類別相關條件
        		 setQuery1ComboBox();        	//第一個查詢條件
        		 setQuery2ComboBox();        	//第二個查詢條件
        		 //查詢結果表單
        	//	 mySR_pane.setqueryTable();

        	 }
        	 if(e.getSource()== kindradio[1]){ //當"查詢餐點"被選案
     			 kindradio[1].setSelected(true);
        		 kindSelected=false;			//kindSelected為false,表示餐點被選按
        		 kindradio[1].setVisible(false);//隱藏查"查詢餐點"
        		 kindradio[0].setVisible(true); //顯示查"查詢類別"
     			 //顯示查詢餐點相關條件
        		 setQuery1ComboBox();           //第一個查詢條件
        		 setQuery2ComboBox();        	//第二個查詢條件
        		 //查詢結果表單
        	//	 mySR_pane.setquery2Table();
        	 }
             if( e.getSource() == querAddtbtn){
            	 query2_pane.setVisible(true); //顯示[新增查詢條件]操作畫面
            	 second=true;				   //紀錄第二個查詢條件被選用
             }	
             if( e.getSource() == querDectbtn){
            	 query2_pane.setVisible(false); //隱藏[新增查詢條件]操作畫面
            	 second=false;				    //紀錄第二個查詢條件沒被選用
             }	
			 if(qu1_class_jcb.getSelectedIndex()==0 || qu1_class_jcb.getSelectedIndex()==3
					|| qu1_meal_jcb.getSelectedIndex()==0 ||qu1_meal_jcb.getSelectedIndex()==3 ||qu1_meal_jcb.getSelectedIndex()==5){
				 //類別編號,建立日期邏輯條件>,<,=
				 qulog2jcb.setVisible(false);	//隱藏邏輯條件2的下拉式選單
				 qulog1jcb.setVisible(true);	//顯示邏輯條件1的下拉式選單
				 qulog1jcb.setBounds(100,12,70,35);
				 qulog1jcb.setFont(new Font("正黑體",0,14));	
				 query_pane.add(qulog1jcb);
			 }
			 if(qu1_class_jcb.getSelectedIndex()==1 || qu1_class_jcb.getSelectedIndex()==2 
					 || qu1_class_jcb.getSelectedIndex()==4 || qu1_class_jcb.getSelectedIndex()==5
					 || qu1_meal_jcb.getSelectedIndex()==1 || qu1_meal_jcb.getSelectedIndex()==2 || qu1_meal_jcb.getSelectedIndex()==4
					 || qu1_meal_jcb.getSelectedIndex()==6){
				 //類別名稱,分類,狀態,備註邏輯條件包含,不包含
				 qulog1jcb.setVisible(false);	//隱藏邏輯條件2的下拉式選單
				 qulog2jcb.setVisible(true);	//顯示邏輯條件1的下拉式選單
				 qulog2jcb.setBounds(100,12,70,35);
				 qulog2jcb.setFont(new Font("正黑體",0,14));	
				 query_pane.add(qulog2jcb);
			 }
			 if(qu2_class_jcb.getSelectedIndex()==0 || qu2_class_jcb.getSelectedIndex()==3
						|| qu2_meal_jcb.getSelectedIndex()==0 ||qu2_meal_jcb.getSelectedIndex()==3 ||qu2_meal_jcb.getSelectedIndex()==5){
				 //類別編號,建立日期邏輯條件>,<,=
				 qulog4jcb.setVisible(false);	//隱藏邏輯條件2的下拉式選單
				 qulog3jcb.setVisible(true);	//顯示邏輯條件1的下拉式選單
				 qulog3jcb.setBounds(190,5,70,25);
				 qulog3jcb.setFont(new Font("正黑體",0,14));	
				 query2_pane.add(qulog3jcb);
				 if(qu2_class_jcb.getSelectedIndex()==3){
					// cond2txt.setForeground(Color.LIGHT_GRAY);
					 //cond2txt.setText("格式:'2016/01/01'");
				 } 
			 }
			 if(qu2_class_jcb.getSelectedIndex()==1 || qu2_class_jcb.getSelectedIndex()==2 
					 || qu2_class_jcb.getSelectedIndex()==4 || qu2_class_jcb.getSelectedIndex()==5
					 || qu2_meal_jcb.getSelectedIndex()==1 || qu2_meal_jcb.getSelectedIndex()==2 || qu2_meal_jcb.getSelectedIndex()==4
					 || qu2_meal_jcb.getSelectedIndex()==6){
				 //類別名稱,分類,狀態,備註邏輯條件包含,不包含
				 qulog3jcb.setVisible(false);	//隱藏邏輯條件2的下拉式選單
				 qulog4jcb.setVisible(true);	//顯示邏輯條件1的下拉式選單
				 qulog4jcb.setBounds(190,5,70,25);
				 qulog2jcb.setFont(new Font("正黑體",0,14));	
				 query2_pane.add(qulog4jcb);
			 }
         }
     };
}
