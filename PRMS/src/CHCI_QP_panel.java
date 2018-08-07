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
//�H�����ʼh���O
//CHCI_QP_panel: Class HumanComputerInteraction_QueryPurchase_panel (�H������-[�d�߭q��]�ާ@�e�����O)
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
	JRadioButton[] kindradio=new JRadioButton[2];	//��ܭq��d�ߩέq��Ӹ`�d��
	boolean kindSelected=true;	//�P�_�q��(true)�άO�q��Ӹ`(false)�Q���
	
	String[] StrSearch = new String[]{"�q��s��","���","���A","�t��","�p���H","�q��","�`���B"};
	String[] StrLogic = new String[]{"�]�t","���]�t"};

	CHCI_QP_panel(){
		//�]�mJRadioButton
		kindradio[0]=new JRadioButton("�d�߭q��",true);
		kindradio[1]=new JRadioButton("�d�߭q��Ӹ`");
		ButtonGroup csgroup=new ButtonGroup();
		for(int i=0;i<kindradio.length;i++){
			kindradio[i].setBounds(400,69,150,25);
			kindradio[i].setFont(new Font("������",0,12));	
			kindradio[i].setContentAreaFilled(false);
			kindradio[i].addActionListener(ProcessOrderSelection);
			csgroup.add(kindradio[i]);
			add(kindradio[i]);		
		}
		kindradio[0].setVisible(false);	//�w�]"�����q��d��"����
		
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
		}
			CbSelect.setBounds(5,12,90,35);
			CbSelect.setFont(new Font("������",0,14));	
		
		
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
			case "�q��s��":
				rtn_sel_qr = "ORDER_no";
				break;
			case "���":
				rtn_sel_qr = "ORDER_date";
				break;
			case "���A":
				rtn_sel_qr = "ORDER_status";
				break;
				/*
			case "�t��":
			
				break;
			case "�p���H":
		
				break;
			case "�q��":
			
				break;
				 */
			case "�`���B":
				rtn_sel_qr = "ORDER_amount";
				break;
		}
		return rtn_sel_qr;
	}
	
	public ActionListener ProcessOrderSelection = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
       	 if(e.getSource()== kindradio[0]){ //��"�d�����O"�Q���
    		 kindradio[0].setSelected(true);
    		 kindSelected=true;				//kindSelected��true,������O�Q���
    		 kindradio[0].setVisible(false);//���ìd"�d�����O"
    		 kindradio[1].setVisible(true); //��ܬd"�d���\�I"
//    		 //��ܬd�����O��������
//    		 setQuery1ComboBox();        	//�Ĥ@�Ӭd�߱���
//    		 setQuery2ComboBox();        	//�ĤG�Ӭd�߱���
//    		 //�d�ߵ��G���
//    	//	 mySR_pane.setqueryTable();

    	 }
    	 if(e.getSource()== kindradio[1]){ //��"�d���\�I"�Q���
 			 kindradio[1].setSelected(true);
    		 kindSelected=false;			//kindSelected��false,����\�I�Q���
    		 kindradio[1].setVisible(false);//���ìd"�d���\�I"
    		 kindradio[0].setVisible(true); //��ܬd"�d�����O"
// 			 //��ܬd���\�I��������
//    		 setQuery1ComboBox();           //�Ĥ@�Ӭd�߱���
//    		 setQuery2ComboBox();        	//�ĤG�Ӭd�߱���
//    		 //�d�ߵ��G���
//    	//	 mySR_pane.setquery2Table();
    	 }
		}
	};
}
