import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.fabric.xmlrpc.base.Struct;
//人機互動層類別
//CHCI_QP_panel: Class HumanComputerInteraction_QueryPurchase_panel (人機介面-[查詢訂單]操作畫面類別)
public class CHCI_QP_panel extends JPanel{
	JPanel Control = new JPanel();
	JPanel Control2=new JPanel();
	//Create elements
	JComboBox CbSelect = new JComboBox();
	JComboBox CbSelectLogic = new JComboBox();
	JTextField TxfKeyin = new JTextField();
	JButton BtnSearch = new JButton();
	JButton querAddtbtn= new JButton();
	JButton querDectbtn= new JButton();
	JRadioButton[] kindradio=new JRadioButton[2];	//選擇訂單查詢或訂單細節查詢
	boolean kindSelected=true;	//判斷訂單(true)或是訂單細節(false)被選擇
	
	String[] StrSearch = new String[]{"訂單編號","日期","狀態","廠商","聯絡人","電話","總金額"};
	String[] StrLogic = new String[]{"包含","不包含"};

	CHCI_QP_panel(){
		//設置JRadioButton
		kindradio[0]=new JRadioButton("查詢訂單",true);
		kindradio[1]=new JRadioButton("查詢訂單細節");
		ButtonGroup csgroup=new ButtonGroup();
		for(int i=0;i<kindradio.length;i++){
			kindradio[i].setBounds(400,69,150,25);
			kindradio[i].setFont(new Font("正黑體",0,12));	
			kindradio[i].setContentAreaFilled(false);
			kindradio[i].addActionListener(ProcessOrderSelection);
			csgroup.add(kindradio[i]);
			add(kindradio[i]);		
		}
		kindradio[0].setVisible(false);	//預設"切換訂單查詢"關閉
		
		Control.setBackground(new Color(190, 233, 228));
		Control.setBounds(0,0,500,65);
		Control.setFont(new Font("正黑體",0,14));	


		Control2.setBackground(Color.yellow);
		Control2.setBounds(0,65,500,35);
		Control2.setFont(new Font("正黑體",0,14));	
		Control2.setLayout(null);
		Control2.setVisible(false);  //隱藏[新增查詢條件]操作畫面
		
		//版面配置開始
			//Panel Layout
			Control.setLayout(null);
			Control2.setLayout(null);
			//set elements
		for(int i = 0; i < StrSearch.length; i++){
			CbSelect.addItem(StrSearch[i]);
		}
			CbSelect.setBounds(5,12,90,35);
			CbSelect.setFont(new Font("正黑體",0,14));	
		
		
		for(int i = 0; i < StrLogic.length; i++){
			CbSelectLogic.addItem(StrLogic[i]);
			CbSelectLogic.setBounds(100,12,70,35);
			CbSelectLogic.setFont(new Font("正黑體",0,14));	
		}		

		BtnSearch.setLabel("查詢");
		BtnSearch.setBounds(380,5,100,45);
		BtnSearch.setFont(new Font("正黑體",0,14));	
		BtnSearch.setIcon(new ImageIcon(getClass().getResource("search_icon.png")));


		TxfKeyin.setBounds(180,12,150,35);
		TxfKeyin.setFont(new Font("正黑體",0,14));	

		//設置加入條件按鈕
		querAddtbtn.setBounds(340,15,24,24);
		querAddtbtn.setIcon(new ImageIcon(getClass().getResource("plus_icon.png")));	
		querAddtbtn.setBorderPainted(false);
		querAddtbtn.setBackground(Color.yellow);
		//加入第二個查詢條件?
		//Control.add(querAddtbtn);

		//版面配置結束
			//add elements to Block
		//Block Control
		Control.add(CbSelect);
		Control.add(CbSelectLogic);
		Control.add(TxfKeyin);
		Control.add(BtnSearch);
		//Block STable

		
		//add Block to Panel
		this.add(Control);
		this.add(Control2);
	    setBounds(0,0,500,100);
	    setLayout(null);
	
	}
	public String getKeyin(){	//取得搜尋欄位字串
		return TxfKeyin.getText();
	}
	
	public String get_Selected_qr(){
		String rtn_sel_qr = "";
		switch (CbSelect.getSelectedItem().toString()) {
			case "訂單編號":
				rtn_sel_qr = "ORDER_no";
				break;
			case "日期":
				rtn_sel_qr = "ORDER_date";
				break;
			case "狀態":
				rtn_sel_qr = "ORDER_status";
				break;
				/*
			case "廠商":
			
				break;
			case "聯絡人":
		
				break;
			case "電話":
			
				break;
				 */
			case "總金額":
				rtn_sel_qr = "ORDER_amount";
				break;
		}
		return rtn_sel_qr;
	}
	
	public ActionListener ProcessOrderSelection = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
       	 if(e.getSource()== kindradio[0]){ //當"查詢類別"被選案
    		 kindradio[0].setSelected(true);
    		 kindSelected=true;				//kindSelected為true,表示類別被選按
    		 kindradio[0].setVisible(false);//隱藏查"查詢類別"
    		 kindradio[1].setVisible(true); //顯示查"查詢餐點"
//    		 //顯示查詢類別相關條件
//    		 setQuery1ComboBox();        	//第一個查詢條件
//    		 setQuery2ComboBox();        	//第二個查詢條件
//    		 //查詢結果表單
//    	//	 mySR_pane.setqueryTable();

    	 }
    	 if(e.getSource()== kindradio[1]){ //當"查詢餐點"被選案
 			 kindradio[1].setSelected(true);
    		 kindSelected=false;			//kindSelected為false,表示餐點被選按
    		 kindradio[1].setVisible(false);//隱藏查"查詢餐點"
    		 kindradio[0].setVisible(true); //顯示查"查詢類別"
// 			 //顯示查詢餐點相關條件
//    		 setQuery1ComboBox();           //第一個查詢條件
//    		 setQuery2ComboBox();        	//第二個查詢條件
//    		 //查詢結果表單
//    	//	 mySR_pane.setquery2Table();
    	 }
		}
	};
}
