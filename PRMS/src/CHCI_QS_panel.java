import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

//�H�����ʼh���O
//CHCI_QS_panel: Class HumanComputerInteraction_QueryStaff_panel (�H������-[�d���\�I]�ާ@�e�����O)
public class CHCI_QS_panel extends JPanel{
	JPanel query_pane=new JPanel();		
	JPanel query2_pane=new JPanel();	//JPanel
	JButton quertbtn=new JButton("�d��");
	JButton querAddtbtn=new JButton();
	JButton querDectbtn=new JButton();
	JTextField cond1txt=new JTextField();
	JComboBox<String> qu1jcb = new JComboBox<>();
    JComboBox<String> qu2jcb = new JComboBox<>();
	CHCI_QS_panel(){
		query_pane.setBackground(new Color(190, 233, 228));
		query_pane.setBounds(0,0,500,65);
		query_pane.setFont(new Font("������",0,14));	
		query_pane.setLayout(null);
		add(query_pane);

		query2_pane.setBackground(Color.yellow);
		query2_pane.setBounds(0,65,500,35);
		query2_pane.setFont(new Font("������",0,14));	
		query2_pane.setLayout(null);
		add(query2_pane);
		query2_pane.setVisible(false);  //����[�s�W�d�߱���]�ާ@�e��
		
		//�]�m�Ĥ@�ӱ���d��
		setQuery1ComboBox();
		//�]�m�Ĥ@���޿�
		setQueryLogic1ComboBox();
		quertbtn.setBounds(380,5,100,45);
		quertbtn.setFont(new Font("������",0,14));	
		quertbtn.setIcon(new ImageIcon(getClass().getResource("search_icon.png")));
		query_pane.add(quertbtn);	
		//�]�m����@
		setQueryCond1();
		//�]�m�[�J������s
		querAddtbtn.setBounds(340,15,24,24);
		querAddtbtn.setIcon(new ImageIcon(getClass().getResource("plus_icon.png")));	
		querAddtbtn.setBorderPainted(false);
		querAddtbtn.setBackground(Color.yellow);
		query_pane.add(querAddtbtn);	

		//�]�m�����޿�B��
		setQueryLogic2ComboBox();
		//�]�m�ĤG�Ӭd�߱���
		setQuery2ComboBox();
		//�]�m�ĤG���޿����
		setQueryLogic3ComboBox();
		//�]�m�ĤG�Ӭd�߱���
		setQueryCond2();
		//�]�m��ֱ�����s
		querDectbtn.setBounds(380,5,24,24);
		querDectbtn.setBackground(Color.white);
		querDectbtn.setIcon(new ImageIcon(getClass().getResource("decrease_icon.png")));	
		querDectbtn.setBorderPainted(false);
		query2_pane.add(querDectbtn);
		
	//	setBackground(Color.yellow);
	    setBounds(0,0,500,100);
	    setLayout(null);
	}
	 private void setQuery1ComboBox(){
		 String[] items={"�����Ҹ�","���u�m�W","���u�q��"};
		 qu1jcb = new JComboBox<>(items);
		 qu1jcb.setBounds(5,12,90,35);
		 qu1jcb.setFont(new Font("������",0,14));	
		 query_pane.add(qu1jcb);
	 }
	 private void setQueryLogic1ComboBox(){
		 String[] logic={"�]�t","���]�t"};
		 JComboBox<String> qulog1jcb = new JComboBox<>(logic);
		 qulog1jcb.setBounds(100,12,70,35);
		 qulog1jcb.setFont(new Font("������",0,14));	
		 query_pane.add(qulog1jcb);
	 }
	 private void setQueryCond1(){
		 //���P�_�A�M�w�X�{�ƻ�
		 
		 //��J��r
		 //JTextField cond1txt=new JTextField("cond1txt");
		 cond1txt.setBounds(180,12,150,35);
		 cond1txt.setFont(new Font("������",0,14));	
		 query_pane.add(cond1txt);
	 }
	 private void setQueryLogic2ComboBox(){
		 String[] logic2={"AND","OR"};
		 JComboBox<String> qulog2jcb = new JComboBox<>(logic2);
		 qulog2jcb.setBounds(5,5,70,25);
		 qulog2jcb.setFont(new Font("������",0,14));	
		 query2_pane.add(qulog2jcb);
	 }
	 
	 private void setQuery2ComboBox(){
		 String[] items2={"�����Ҹ�","���u�m�W","���u�q��"};
		 JComboBox<String> qu2jcb = new JComboBox<>();
		 qu2jcb.setBounds(80,5,100,25);
		 qu2jcb.setFont(new Font("������",0,14));	
		 query2_pane.add(qu2jcb);
	 }
	 
	 private void setQueryLogic3ComboBox(){
		 String[] logic3={"�]�t","���]�t"};
		 JComboBox<String> qulog3jcb = new JComboBox<>(logic3);
		 qulog3jcb.setBounds(190,5,70,25);
		 qulog3jcb.setFont(new Font("������",0,14));	
		 query2_pane.add(qulog3jcb);
	 }
	 private void setQueryCond2(){
		 //���P�_�A�M�w�X�{�ƻ�
		 //��J��r
		 JTextField cond2txt=new JTextField();
		 cond2txt.setBounds(270,5,100,25);
		 cond2txt.setFont(new Font("������",0,14));	
		 query2_pane.add(cond2txt);
	 }
	 
	 public String get_cond1txt(){
		 String txt = cond1txt.getText();
		 return txt;
	 }
	 
	 public String get_selelected_qr(){
		 String rtn_sel_qr="123";
		 if(qu1jcb.getSelectedIndex()==0){
			 rtn_sel_qr ="EMPL_number";
		 }
		 else if(qu1jcb.getSelectedIndex()==1){
			 rtn_sel_qr ="EMPL_name";
		 }
		 else if(qu1jcb.getSelectedIndex()==2){
			 rtn_sel_qr ="EMPL_telephone";
		 }
		 
		 return rtn_sel_qr;
	 }
}
