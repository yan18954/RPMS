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
//�H�����ʼh���O
//CHCI_QM_panel: Class HumanComputerInteraction_QueryMealsclass_panel (�H������-[�d���\�I���O]�ާ@�e�����O)
public class CHCI_QM_panel extends JPanel{
	JPanel query_pane=new JPanel();		
	JPanel query2_pane=new JPanel();	//JPanel
	JButton quertbtn=new JButton("�d��");
	JButton querAddtbtn=new JButton();
	JButton querDectbtn=new JButton();
	JRadioButton[] kindradio=new JRadioButton[2];	//������O�d�ߩ��\�I�d��
	boolean kindSelected=true;	//�P�_���O(true)�άO�\�I(false)�Q���
	boolean second=false;		//�P�_�ĤG�ӱ���O�_�Q���
	String[] items={"���O�s��","���O�W��","���O����","�إߤ��","���O���A","��       ��"};
	String[] items2={"�\�I�s��","�\�I�W��","�\�I���O","�إߤ��","�\�I����","���","�\�I���A"};
	String[] logic={" > "," < "," = "};
	String[] logic2={"�]�t","���]�t"};
	String[] and_or={"AND","OR"};
	JComboBox<String> qu1_class_jcb = new JComboBox<>(items);	//���O�d�߱���1�U�Ԧ����
	JComboBox<String> qu1_meal_jcb = new JComboBox<>(items2);	//�\�I�d�߱���1�U�Ԧ����
	JComboBox<String> qu2_class_jcb = new JComboBox<>(items);	//���O�d�߱���2�U�Ԧ����
	JComboBox<String> qu2_meal_jcb = new JComboBox<>(items2);	//�\�I�d�߱���2�U�Ԧ����
	JComboBox<String> qulog1jcb = new JComboBox<>(logic);	    //�޿����1�U�Ԧ����,�t>,<=
	JComboBox<String> qulog2jcb = new JComboBox<>(logic2);	    //�޿����1�U�Ԧ����,�t�]�t,���]�t
	JComboBox<String> qulog3jcb = new JComboBox<>(logic);	    //�޿����2�U�Ԧ����,�t>,<=
	JComboBox<String> qulog4jcb = new JComboBox<>(logic2);	    //�޿����2�U�Ԧ����,�t�]�t,���]�t
	JComboBox<String> quAnd_Orjcb = new JComboBox<>(and_or);	//And,Or�U�Ԧ����

	JTextField cond1txt=new JTextField();						//����r1
	JTextField cond2txt=new JTextField();                       //����r2
	CHCI_QM_panel(){
		//�]�mJRadioButton
		kindradio[0]=new JRadioButton("�d�����O",true);
		kindradio[1]=new JRadioButton("�d���\�I");
		ButtonGroup csgroup=new ButtonGroup();
		for(int i=0;i<kindradio.length;i++){
			kindradio[i].setBounds(420,69,80,25);
			kindradio[i].setFont(new Font("������",0,12));	
			kindradio[i].setContentAreaFilled(false);
			kindradio[i].addActionListener(ProcessFunSelection);
			csgroup.add(kindradio[i]);
			add(kindradio[i]);		
		}
		kindradio[0].setVisible(false);	//�w�]"�������O"����
		
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
		
		
		setQuery1ComboBox();//�]�m�Ĥ@�ӱ���d��
		setQueryLogic1ComboBox();//�]�m�Ĥ@���޿�
		
		//�]�m�d�߫��s
		quertbtn.setBounds(380,5,100,45);
		quertbtn.setFont(new Font("������",0,14));	
		quertbtn.setIcon(new ImageIcon(getClass().getResource("search_icon.png")));
		query_pane.add(quertbtn);	
		
		setQueryCond1();//�]�m����@
		
		//�]�m�[�J������s
		querAddtbtn.setBounds(340,15,24,24);
		querAddtbtn.setIcon(new ImageIcon(getClass().getResource("plus_icon.png")));	
		querAddtbtn.setBorderPainted(false);
		querAddtbtn.setBackground(Color.yellow);
	    querAddtbtn.addActionListener(ProcessFunSelection);   //[�ާ@�d��]�ާ@�e����[�W�[]���s
		query_pane.add(querAddtbtn);	

		setQuerAnd_OrComboBox();//�]�mand,or����
		setQuery2ComboBox();//�]�m�ĤG�Ӭd�߱���
		setQueryLogic3ComboBox();//�]�m�ĤG���޿����
		setQueryCond2();//�]�m�ĤG�Ӭd�߱���
		
		//�]�m��ֱ�����s
		querDectbtn.setBounds(380,5,24,24);
		querDectbtn.setBackground(Color.white);
		querDectbtn.setIcon(new ImageIcon(getClass().getResource("decrease_icon.png")));	
		querDectbtn.setBorderPainted(false);
		querDectbtn.addActionListener(ProcessFunSelection);   //[�ާ@�d��]�ާ@�e����[���]���s
		query2_pane.add(querDectbtn);
		
	    setBounds(0,0,500,100);
	    setLayout(null);
	}
	 /*�Ĥ@�Ӭd�߱���]�m*/
	 public void setQuery1ComboBox(){
		 if(kindSelected==true){
			 qu1_class_jcb.setBounds(5,12,90,35);
			 qu1_class_jcb.setFont(new Font("������",0,14));	
			 qu1_class_jcb.setVisible(true);
			 qu1_meal_jcb.setVisible(false);	//����[�d���\�I]��������
			 qu1_class_jcb.addActionListener(ProcessFunSelection);
			 query_pane.add(qu1_class_jcb);		 
		 }
		 else{
			 qu1_meal_jcb.setBounds(5,12,90,35);
			 qu1_meal_jcb.setFont(new Font("������",0,14));	
			 qu1_meal_jcb.setVisible(true);
			 qu1_class_jcb.setVisible(false);	//����[�d�����O]��������
			 qu1_meal_jcb.addActionListener(ProcessFunSelection);
			 query_pane.add(qu1_meal_jcb);	 
		 }
	 }
	 private void setQueryLogic1ComboBox(){
			//�w�],���O�s���޿����
		    qulog1jcb.setBounds(100,12,70,35);
			qulog1jcb.setFont(new Font("������",0,14));	
			query_pane.add(qulog1jcb);
	 }
	 private void setQueryCond1(){
		 //����r���1
		 cond1txt.setBounds(180,12,150,35);
		 cond1txt.setFont(new Font("������",0,14));	
		 query_pane.add(cond1txt);
	 }
	 /*�ĤG�Ӭd�߱���]�m*/
	 private void setQuerAnd_OrComboBox(){
		 quAnd_Orjcb.setBounds(5,5,70,25);
		 quAnd_Orjcb.setFont(new Font("������",0,14));	
		 query2_pane.add(quAnd_Orjcb);
	 }
	 private void setQuery2ComboBox(){
		 if(kindSelected==true){
			 qu2_class_jcb.setBounds(80,5,100,25);
			 qu2_class_jcb.setFont(new Font("������",0,14));	
			 qu2_class_jcb.setVisible(true);
			 qu2_meal_jcb.setVisible(false);	//����[�d���\�I]��������
			 qu2_class_jcb.addActionListener(ProcessFunSelection);
			 query2_pane.add(qu2_class_jcb);		 
		 }
		 else{
			 qu2_meal_jcb.setBounds(80,5,100,25);
			 qu2_meal_jcb.setFont(new Font("������",0,14));	
			 qu2_meal_jcb.setVisible(true);
			 qu2_class_jcb.setVisible(false);	//����[�d�����O]��������
			 qu2_meal_jcb.addActionListener(ProcessFunSelection);
			 query2_pane.add(qu2_meal_jcb);	 
		 }
	 }
	 private void setQueryLogic3ComboBox(){
		 //�w�],���O�s���޿����
		 qulog3jcb.setBounds(190,5,70,25);
		 qulog3jcb.setFont(new Font("������",0,14));	
		 query2_pane.add(qulog3jcb);
	 }
	 private void setQueryCond2(){
		 //����r���2 
		 cond2txt.setBounds(270,5,100,25);
		 cond2txt.setFont(new Font("������",0,14));	
		 query2_pane.add(cond2txt);
	 }

     //�ƥ��ť�{��: �B�z�\����
     public ActionListener ProcessFunSelection = new ActionListener(){
         public void actionPerformed(ActionEvent e){
        	 if(e.getSource()== kindradio[0]){ //��"�d�����O"�Q���
        		 kindradio[0].setSelected(true);
        		 kindSelected=true;				//kindSelected��true,������O�Q���
        		 kindradio[0].setVisible(false);//���ìd"�d�����O"
        		 kindradio[1].setVisible(true); //��ܬd"�d���\�I"
        		 //��ܬd�����O��������
        		 setQuery1ComboBox();        	//�Ĥ@�Ӭd�߱���
        		 setQuery2ComboBox();        	//�ĤG�Ӭd�߱���
        		 //�d�ߵ��G���
        	//	 mySR_pane.setqueryTable();

        	 }
        	 if(e.getSource()== kindradio[1]){ //��"�d���\�I"�Q���
     			 kindradio[1].setSelected(true);
        		 kindSelected=false;			//kindSelected��false,����\�I�Q���
        		 kindradio[1].setVisible(false);//���ìd"�d���\�I"
        		 kindradio[0].setVisible(true); //��ܬd"�d�����O"
     			 //��ܬd���\�I��������
        		 setQuery1ComboBox();           //�Ĥ@�Ӭd�߱���
        		 setQuery2ComboBox();        	//�ĤG�Ӭd�߱���
        		 //�d�ߵ��G���
        	//	 mySR_pane.setquery2Table();
        	 }
             if( e.getSource() == querAddtbtn){
            	 query2_pane.setVisible(true); //���[�s�W�d�߱���]�ާ@�e��
            	 second=true;				   //�����ĤG�Ӭd�߱���Q���
             }	
             if( e.getSource() == querDectbtn){
            	 query2_pane.setVisible(false); //����[�s�W�d�߱���]�ާ@�e��
            	 second=false;				    //�����ĤG�Ӭd�߱���S�Q���
             }	
			 if(qu1_class_jcb.getSelectedIndex()==0 || qu1_class_jcb.getSelectedIndex()==3
					|| qu1_meal_jcb.getSelectedIndex()==0 ||qu1_meal_jcb.getSelectedIndex()==3 ||qu1_meal_jcb.getSelectedIndex()==5){
				 //���O�s��,�إߤ���޿����>,<,=
				 qulog2jcb.setVisible(false);	//�����޿����2���U�Ԧ����
				 qulog1jcb.setVisible(true);	//����޿����1���U�Ԧ����
				 qulog1jcb.setBounds(100,12,70,35);
				 qulog1jcb.setFont(new Font("������",0,14));	
				 query_pane.add(qulog1jcb);
			 }
			 if(qu1_class_jcb.getSelectedIndex()==1 || qu1_class_jcb.getSelectedIndex()==2 
					 || qu1_class_jcb.getSelectedIndex()==4 || qu1_class_jcb.getSelectedIndex()==5
					 || qu1_meal_jcb.getSelectedIndex()==1 || qu1_meal_jcb.getSelectedIndex()==2 || qu1_meal_jcb.getSelectedIndex()==4
					 || qu1_meal_jcb.getSelectedIndex()==6){
				 //���O�W��,����,���A,�Ƶ��޿����]�t,���]�t
				 qulog1jcb.setVisible(false);	//�����޿����2���U�Ԧ����
				 qulog2jcb.setVisible(true);	//����޿����1���U�Ԧ����
				 qulog2jcb.setBounds(100,12,70,35);
				 qulog2jcb.setFont(new Font("������",0,14));	
				 query_pane.add(qulog2jcb);
			 }
			 if(qu2_class_jcb.getSelectedIndex()==0 || qu2_class_jcb.getSelectedIndex()==3
						|| qu2_meal_jcb.getSelectedIndex()==0 ||qu2_meal_jcb.getSelectedIndex()==3 ||qu2_meal_jcb.getSelectedIndex()==5){
				 //���O�s��,�إߤ���޿����>,<,=
				 qulog4jcb.setVisible(false);	//�����޿����2���U�Ԧ����
				 qulog3jcb.setVisible(true);	//����޿����1���U�Ԧ����
				 qulog3jcb.setBounds(190,5,70,25);
				 qulog3jcb.setFont(new Font("������",0,14));	
				 query2_pane.add(qulog3jcb);
				 if(qu2_class_jcb.getSelectedIndex()==3){
					// cond2txt.setForeground(Color.LIGHT_GRAY);
					 //cond2txt.setText("�榡:'2016/01/01'");
				 } 
			 }
			 if(qu2_class_jcb.getSelectedIndex()==1 || qu2_class_jcb.getSelectedIndex()==2 
					 || qu2_class_jcb.getSelectedIndex()==4 || qu2_class_jcb.getSelectedIndex()==5
					 || qu2_meal_jcb.getSelectedIndex()==1 || qu2_meal_jcb.getSelectedIndex()==2 || qu2_meal_jcb.getSelectedIndex()==4
					 || qu2_meal_jcb.getSelectedIndex()==6){
				 //���O�W��,����,���A,�Ƶ��޿����]�t,���]�t
				 qulog3jcb.setVisible(false);	//�����޿����2���U�Ԧ����
				 qulog4jcb.setVisible(true);	//����޿����1���U�Ԧ����
				 qulog4jcb.setBounds(190,5,70,25);
				 qulog2jcb.setFont(new Font("������",0,14));	
				 query2_pane.add(qulog4jcb);
			 }
         }
     };
}
