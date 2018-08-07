import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
//人機互動層類別
//CHCI_QMA_panel: Class HumanComputerInteraction_QueryCompanyspanel (人機介面-[查詢廠商]操作畫面類別)
public class CHCI_QCO_panel extends JPanel{
	JPanel Control = new JPanel();
	JPanel Control2=new JPanel();
	//Create elements
	JComboBox CbSelect = new JComboBox();
	JComboBox CbSelectLogic = new JComboBox();
	JTextField TxfKeyin = new JTextField();
	JButton BtnSearch = new JButton();
	JButton querAddtbtn= new JButton();


	String[] StrSearch = new String[]{"廠商編號","廠商名稱","廠商聯絡人","廠商電話"};
	String[] StrLogic = new String[]{"包含","不包含"};
	
	CHCI_QCO_panel(){
		
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
			CbSelect.setBounds(5,12,90,35);
			CbSelect.setFont(new Font("正黑體",0,14));	
		}
		
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
			case "廠商編號":
				rtn_sel_qr = "CL_no";
				break;
			case "廠商名稱":
				rtn_sel_qr = "CL_company";
				break;
			case "廠商聯絡人":
				rtn_sel_qr = "CL_contact";
				break;
			case "廠商電話":
				rtn_sel_qr = "CL_cpmtactphone";
				break;
		}
		return rtn_sel_qr;
	}
}
