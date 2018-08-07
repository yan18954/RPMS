import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
//�H�����ʼh���O
//CHCI_QMA_panel: Class HumanComputerInteraction_QueryMaterialspanel (�H������-[�d�ߪ���]�ާ@�e�����O)
public class CHCI_QMA_panel extends JPanel{
	JPanel Control = new JPanel();
	JPanel Control2=new JPanel();
	//Create elements
	JComboBox CbSelect = new JComboBox();
	JComboBox CbSelectLogic = new JComboBox();
	JTextField TxfKeyin = new JTextField();
	JButton BtnSearch = new JButton();
	JButton querAddtbtn= new JButton();


	String[] StrSearch = new String[]{"���ƽs��","�~�W","����"};
	String[] StrLogic = new String[]{"�]�t","���]�t"};
	
	CHCI_QMA_panel(){
		
		Control.setBackground(new Color(190, 233, 228));
		Control.setBounds(0,0,500,65);
		Control.setFont(new Font("������",0,14));	


		Control2.setBackground(Color.yellow);
		Control2.setBounds(0,65,500,35);
		Control2.setFont(new Font("������",0,14));	
		Control2.setLayout(null);
		Control2.setVisible(false);  //����[�s�W�d�߱���]�ާ@�e��
		
		//�����t�m�}�l
			//Panel Layout
			Control.setLayout(null);
			Control2.setLayout(null);
			//set elements
		for(int i = 0; i < StrSearch.length; i++){
			CbSelect.addItem(StrSearch[i]);
			CbSelect.setBounds(5,12,90,35);
			CbSelect.setFont(new Font("������",0,14));	
		}
		
		for(int i = 0; i < StrLogic.length; i++){
			CbSelectLogic.addItem(StrLogic[i]);
			CbSelectLogic.setBounds(100,12,70,35);
			CbSelectLogic.setFont(new Font("������",0,14));	
		}		

		BtnSearch.setLabel("�d��");
		BtnSearch.setBounds(380,5,100,45);
		BtnSearch.setFont(new Font("������",0,14));	
		BtnSearch.setIcon(new ImageIcon(getClass().getResource("search_icon.png")));


		TxfKeyin.setBounds(180,12,150,35);
		TxfKeyin.setFont(new Font("������",0,14));	

		//�]�m�[�J������s
		querAddtbtn.setBounds(340,15,24,24);
		querAddtbtn.setIcon(new ImageIcon(getClass().getResource("plus_icon.png")));	
		querAddtbtn.setBorderPainted(false);
		querAddtbtn.setBackground(Color.yellow);
		//�[�J�ĤG�Ӭd�߱���?
		//Control.add(querAddtbtn);

		//�����t�m����
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
	
	public String getKeyin(){	//���o�j�M���r��
		return TxfKeyin.getText();
	}
	
	public String get_Selected_qr(){
		String rtn_sel_qr = "";
		switch (CbSelect.getSelectedItem().toString()) {
			case "���ƽs��":
				rtn_sel_qr = "MI_no";
				break;
			case "�~�W":
				rtn_sel_qr = "MI_name";
				break;
			case "����":
				rtn_sel_qr = "MI_type";
				break;
		}
		return rtn_sel_qr;
	}
}
