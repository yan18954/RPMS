//管理物料種類

//package Pack.model;

import java.lang.*;
import java.awt.*;
//import java.awt.event.*;	//not yet used
import javax.swing.*;

//主類別
public class ManageMaterialInventory extends JFrame{
	public static void main(String[] argc){
		CFrame Frame = new CFrame();	
	}
}

//整合類別 ＊top & left & right Panel
class CFrame extends JFrame{
	//create Panel
	CTPanel TPanel = new CTPanel();
	CLPanel LPanel = new CLPanel();
	CRPanel RPanel = new CRPanel();

	//Constructor
	CFrame(){
		this.setBounds(100,100,1000,700);	//set Panel Size
		this.setLayout(null);
		
		TPanel.setLocation(0,0);	//set Panel Location
		LPanel.setLocation(0,100);
		RPanel.setLocation(500,100);

		//add Panel to Frame
		this.add(TPanel);
		this.add(LPanel);
		this.add(RPanel);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
//Left Panel start===================================================
class CLPanel extends JPanel{
	//Create Block
	JPanel Control = new JPanel();	//Create Control Block
	JPanel STable = new JPanel();	//Create ShowTable Block
	
	//Create search list elements
	JComboBox CbSelect = new JComboBox();
	JTextField TxfKeyin = new JTextField();
	JButton BtnSearch = new JButton();	//search button	

	//Create Table elemets
	String[] StrTab = new String[]{"物料編號","品名","種類","備註"};	//create puduct list
	Object[][] Data = new Object[40][6];
	JTable TabShow = new JTable(Data,StrTab);
	JScrollPane ScrPane = new JScrollPane(TabShow);

	String[] StrTableItem = StrTab;
	String[] StrSearch = StrTab;
	//constructor
	public CLPanel(){
		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		this.setSize(500,600);

		Control.setPreferredSize(new Dimension(460,40));	//set Block Size
		STable.setPreferredSize(new Dimension(460,500));
		
		//版面配置開始
			//Panel Layout
		Control.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
		STable.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

			//set elements
		for(int i = 0; i < StrSearch.length; i++)
			CbSelect.addItem(StrSearch[i]);
		BtnSearch.setLabel("搜尋");
		TabShow.setPreferredScrollableViewportSize(new Dimension(440,480));	//Dimension(450,500)

		CbSelect.setPreferredSize(new Dimension(90,40));
		TxfKeyin.setPreferredSize(new Dimension(250,40));
		BtnSearch.setPreferredSize(new Dimension(80,40));

		//版面配置結束
			//add elements to Block
		//Block Control
		Control.add(CbSelect);
		Control.add(TxfKeyin);
		Control.add(BtnSearch);
		//Block STable
		STable.add(ScrPane);
		
		//add Block to Panel
		this.add(Control);
		this.add(STable);
	}
}
//Left Panel over===================================================

//Right Panel start===================================================
class CRPanel extends JPanel{	
	//Create Block
	JPanel Detail = new JPanel();
	JPanel Confirm = new JPanel();	

	//Create elements
	JLabel[] LbName = new JLabel[4];	//item name
	JButton BtnExport = new JButton();
	JButton BtnModify = new JButton();
	JButton BtnCancle = new JButton();
	JTextField[] TxfKeyin = new JTextField[4];
	JTextArea TxaNote = new JTextArea();
	Font FontLabel = new Font("微軟正黑體",Font.BOLD,24);	//字型

	String[] StrName = new String[]{"物料編號： ","品名： ","種類： ","備註： "};
	//Constructor
	CRPanel(){
		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		this.setSize(500,600);

		Detail.setPreferredSize(new Dimension(460,490));	//set Block Size
		Confirm.setPreferredSize(new Dimension(460,50));
		
			//版面配置開始
		//panel layout
		Detail.setLayout(null);
		Confirm.setLayout(new FlowLayout(FlowLayout.CENTER,50,0));

		//set elements
	//Block Detail
		for(int i = 0; i < LbName.length; i++){
			LbName[i] = new JLabel(StrName[i]);
			LbName[i].setBounds(0,0+(i * 70),100,50);
		}
		for(int i =0; i < TxfKeyin.length; i++){
			TxfKeyin[i] = new JTextField();
			TxfKeyin[i].setBounds(120,0+(i * 70),300,50);
		}
		TxfKeyin[3].setBounds(120,210,300,250);
		//TxaNote.setBounds(120,280,300,400);

	//Block Confirm
		BtnModify.setLabel("新增物料種類");
		BtnModify.setPreferredSize(new Dimension(130,50));
		BtnExport.setLabel("編輯物料種類");
		BtnExport.setPreferredSize(new Dimension(130,50));
		BtnCancle.setLabel("取消");
		BtnCancle.setPreferredSize(new Dimension(130,50));
		
			//版面配置結束
		
		//add elements to block
	//Block Detail
		Detail.add(LbName[0]);
		Detail.add(TxfKeyin[0]);
		Detail.add(LbName[1]);
		Detail.add(TxfKeyin[1]);
		Detail.add(LbName[2]);
		Detail.add(TxfKeyin[2]);
		Detail.add(LbName[3]);
		Detail.add(TxfKeyin[3]);
		//Detail.add(TxaNote);
	//Block Confirm
		Confirm.add(BtnModify);
		Confirm.add(BtnExport);

		//add block to Panel
		this.add(Detail);
		this.add(Confirm);

	}
}
//Right Panel over===================================================

//Top Panel start===================================================

class CTPanel extends JPanel{	//頂端功能區塊（暫時不動）

	//Constructor
	CTPanel(){
		this.setBackground(Color.gray);
		this.setLayout(null);
		this.setSize(1000,100);
	}
}
//Top Panel over===================================================
