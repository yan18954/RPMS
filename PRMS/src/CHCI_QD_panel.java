import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

//人機互動層類別
//CHCI_QD_panel: Class HumanComputerInteraction_QueryDeals_panel (人機介面-[查詢交易]操作畫面類別)
public class CHCI_QD_panel extends JPanel{
	JPanel query_pane=new JPanel();		
	JPanel query2_pane=new JPanel();	
	JButton quertbtn=new JButton("查詢");
	JButton querAddtbtn=new JButton();
	JButton querDectbtn=new JButton();
	
	 String[] items={"交易編號","交易日期","班　　別","銷售店員","統一編號","總金額","交易狀態"};
	 JComboBox<String> qu1jcb = new JComboBox<>(items);
	 JTextField cond1txt =new JTextField();		//設置搜尋輸入欄位
	CHCI_QD_panel(){
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
		
		 cond1txt.setBounds(180,12,150,35);
		 cond1txt.setFont(new Font("正黑體",0,14));	
		 query_pane.add(cond1txt);
		//設置第一個條件查詢
//		setQuery1ComboBox();
		 qu1jcb.setBounds(5,12,90,35);
		 qu1jcb.setFont(new Font("正黑體",0,14));	
		 query_pane.add(qu1jcb);
		//設置第一個邏輯
		setQueryLogic1ComboBox();
		quertbtn.setBounds(380,5,100,45);
		quertbtn.setFont(new Font("正黑體",0,14));	
		quertbtn.setIcon(new ImageIcon(getClass().getResource("search_icon.png")));
		query_pane.add(quertbtn);	
		//設置條件一
		//setQueryCond1();
		//設置加入條件按鈕
		querAddtbtn.setBounds(340,15,24,24);
		querAddtbtn.setIcon(new ImageIcon(getClass().getResource("plus_icon.png")));	
		querAddtbtn.setBorderPainted(false);
		querAddtbtn.setBackground(Color.yellow);
		querAddtbtn.addActionListener(ProcessFunSelection);   //[操作查詢]操作畫面的[增加]按鈕
		query_pane.add(querAddtbtn);	

		//設置條件邏輯運算
		setQueryLogic2ComboBox();
		//設置第二個查詢條件
		setQuery2ComboBox();
		//設置第二個邏輯條件
		setQueryLogic3ComboBox();
		//設置第二個查詢條件
		setQueryCond2();
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
//	 private void setQuery1ComboBox(){
//		 String[] items={"交易編號","交易日期","班　　別","銷售店員","統一編號","總金額","交易狀態"};
//		 JComboBox<String> qu1jcb = new JComboBox<>(items);
//		 qu1jcb.setBounds(5,12,90,35);
//		 qu1jcb.setFont(new Font("正黑體",0,14));	
//		 query_pane.add(qu1jcb);
//	 }
	 private void setQueryLogic1ComboBox(){
		 String[] logic={"包含","不包含"};
		 JComboBox<String> qulog1jcb = new JComboBox<>(logic);
		 qulog1jcb.setBounds(100,12,70,35);
		 qulog1jcb.setFont(new Font("正黑體",0,14));	
		 query_pane.add(qulog1jcb);
	 }
//	 private void setQueryCond1(){
//		 //做判斷，決定出現甚麼
//		 
//		 //輸入文字
//		 JTextField cond1txt=new JTextField();
//		 cond1txt.setBounds(180,12,150,35);
//		 cond1txt.setFont(new Font("正黑體",0,14));	
//		 query_pane.add(cond1txt);
//	 }
	 private void setQueryLogic2ComboBox(){
		 String[] logic2={"AND","OR"};
		 JComboBox<String> qulog2jcb = new JComboBox<>(logic2);
		 qulog2jcb.setBounds(5,5,70,25);
		 qulog2jcb.setFont(new Font("正黑體",0,14));	
		 query2_pane.add(qulog2jcb);
	 }
	 private void setQuery2ComboBox(){
		 String[] items2={"交易編號","交易日期","班　　別","銷售店員","統一編號","總金額","交易狀態"};
		 JComboBox<String> qu2jcb = new JComboBox<>(items2);
		 qu2jcb.setBounds(80,5,100,25);
		 qu2jcb.setFont(new Font("正黑體",0,14));	
		 query2_pane.add(qu2jcb);
	 }
	 private void setQueryLogic3ComboBox(){
		 String[] logic3={"包含","不包含"};
		 JComboBox<String> qulog3jcb = new JComboBox<>(logic3);
		 qulog3jcb.setBounds(190,5,70,25);
		 qulog3jcb.setFont(new Font("正黑體",0,14));	
		 query2_pane.add(qulog3jcb);
	 }
	 private void setQueryCond2(){

		 JTextField cond2txt=new JTextField();
		 cond2txt.setBounds(270,5,100,25);
		 cond2txt.setFont(new Font("正黑體",0,14));	
		 query2_pane.add(cond2txt);
	 }
	 
		public String getKeyin(){	//取得搜尋欄位字串
			return cond1txt.getText();
		}
	 
		public String get_Selected_qr(){
			switch (qu1jcb.getSelectedItem().toString()) {
				case "交易編號":
					return "TRANS_no";
				case "交易日期":
					return "TRANS_date";
				case "班別":
					return "TRANS_shiff";
				case "銷售店員":
					return "EMPL_id";
				case "統一編號":
					return "TRANS_ein";
				case "總金額":
					return "TRANS_status";
				case "交易狀態":
					return "TRANS_amount";			
			}
			return "";
		}
	 
     //事件傾聽程式: 處理功能選按
     public ActionListener ProcessFunSelection = new ActionListener(){
         public void actionPerformed(ActionEvent e){
             if( e.getSource() == querAddtbtn){
            	 query2_pane.setVisible(true); //顯示[新增查詢條件]操作畫面
             }	
             if( e.getSource() == querDectbtn){
            	 query2_pane.setVisible(false); //隱藏[新增查詢條件]操作畫面
             }	
         }
     };
}
