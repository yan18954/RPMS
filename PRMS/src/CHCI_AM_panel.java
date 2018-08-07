import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//�H�����ʼh���O
//CHCI_AM_panel: Class HumanComputerInteraction_AddMeals_panel (�H������-[�s�W�\�I]�ާ@�e�����O)
public class CHCI_AM_panel extends JPanel{
	JPanel meals_pane=new JPanel();			//JPanel�A�t�s�W�\�I������T	
	String no_date="";
	int meal_no[]={0,0,0};
	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("�إ߷s�\�I�G");
	 JLabel nolbl=new JLabel("�\�I�s���G");
	JLabel datelbl=new JLabel("�إߤ���G");
	JLabel namelbl=new JLabel("�\�I�W�١G");
	 JLabel kindlbl=new JLabel("�\�I�����G");
	JLabel classlbl=new JLabel("�\�I���O�G");
	 JLabel materlbl=new JLabel("�ϥΪ��ơG");
	JLabel statelbl=new JLabel("�\�I���A�G");
	JLabel pricelbl=new JLabel("�\�I����G");		
	JLabel mnotelbl=new JLabel("��      ���G");	
	
    JTextField notxt=new JTextField("");
    JTextField datetxt=new JTextField("");
    JTextField nametxt=new JTextField("");    
    JTextField pricetxt=new JTextField("");
    
    JTextArea notetxt=new JTextArea("",3,12);
    
    JScrollPane scroll=new JScrollPane(notetxt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS 
    		, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    JRadioButton[] kindradio=new JRadioButton[2];  
    JRadioButton[] msradio=new JRadioButton[2];
    JButton addbtn=new JButton("�s�W");
    JButton clearbtn=new JButton("����");
    
	String[] class_items={};
	JComboBox<String> class_jcb = new JComboBox<>(class_items);			         //�\�I���O�U�Ԧ����
	String[] material_type_items={};
	JComboBox<String> material_type_jcb = new JComboBox<>(material_type_items);	//���ƺ��������U�Ԧ����
	String[] material_items={};
	JComboBox<String> material_jcb = new JComboBox<>(material_items);	        //���ƺ����U�Ԧ����
    boolean man_selected=true;	//�ΨӰO����e������\�I�������D�H�άO�d��
    boolean use_material=false; //�ΨӰO���\�I�O�_���ϥΪ���
    String kindStr="�D�H";
    String stateStr="�c��";
    
    CHCI_AM_panel(){
    	meals_pane.setBounds(0,0,500,550);
    	meals_pane.setFont(new Font("������",1,16));
    	meals_pane.setLayout(null);
    	meals_pane.setOpaque(false);
		add(meals_pane);

		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addmeals_icon.png")));
		meals_pane.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("������",1,20));	
		meals_pane.add(titlelbl);			 
	 
		//�]�m�إߤ��
		datelbl.setBounds(10,88,150,45);
		datelbl.setFont(new Font("������",1,16));	
		meals_pane.add(datelbl);
		datetxt.setBounds(110,95,155,30);
		datetxt.setFont(new Font("������",1,16));	
		datetxt.setEnabled(false);
		meals_pane.add(datetxt);
		setMealDate();
		
		//�]�m�\�I�s��
		nolbl.setBounds(10,45,150,45);
		nolbl.setFont(new Font("������",1,16));	
		meals_pane.add(nolbl);	
		notxt.setBounds(110,52,180,30);
		notxt.setFont(new Font("������",1,16));	
		notxt.setEnabled(false);
		setNewNo();	//�]�m�\�I�s��
		meals_pane.add(notxt);
		
		//�]�m�\�I�W��
		namelbl.setBounds(10,133,150,45);
		namelbl.setFont(new Font("������",1,16));	
		meals_pane.add(namelbl);	
		nametxt.setBounds(110,140,155,30);
		nametxt.setFont(new Font("������",1,16));	
		meals_pane.add(nametxt);	
		
		//�]�m�\�I����
		kindlbl.setBounds(10,178,150,45);
		kindlbl.setFont(new Font("������",1,16));	
		meals_pane.add(kindlbl);	
			//�]�m��ο�ܫ��s
		setMealKind();
		//�]�m�\�I���O
		classlbl.setBounds(10,228,150,45);
		classlbl.setFont(new Font("������",1,16));	
		meals_pane.add(classlbl);	
			//�]�m�U�Ԧ����
		setClassCombo();
		//�]�m�ϥΪ���
		materlbl.setBounds(10,278,150,45);
		materlbl.setFont(new Font("������",1,16));	
		meals_pane.add(materlbl);		
			//�]�m�U�Ԧ����
		setMaterCombo();
		//�]�m�\�I���A
		statelbl.setBounds(10,328,150,45);
		statelbl.setFont(new Font("������",1,16));	
		meals_pane.add(statelbl);		
			//�]�m��ο�ܶs
		setMealState();
		//�]�m�\�I����
		pricelbl.setBounds(10,378,150,45);
		pricelbl.setFont(new Font("������",1,16));	
		meals_pane.add(pricelbl);	
		pricetxt.setBounds(110,385,100,30);
		pricetxt.setFont(new Font("������",1,16));	
		meals_pane.add(pricetxt);		
		//�]�m���s
		addbtn.setBounds(310,427,150,60);
		addbtn.setFont(new Font("������",1,16));
		addbtn.setBackground(Color.orange);
		addbtn.setBorderPainted(false);
		meals_pane.add(addbtn);	
		clearbtn.setBounds(10,427,150,60);
		clearbtn.setFont(new Font("������",1,16));	
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		meals_pane.add(clearbtn);	
		setOpaque(false);
		setBounds(5,65,475,490);
		setLayout(null); 
	 }

	 private void setMealKind(){
		kindradio[0]=new JRadioButton("�D	�H",true);
		kindradio[1]=new JRadioButton("�d	��");
		ButtonGroup kindgroup=new ButtonGroup();
		for(int i=0;i<kindradio.length;i++){
			kindradio[i].setBounds(110+80*i,185,100,30);
			kindradio[i].setFont(new Font("������",0,16));	
			kindradio[i].setContentAreaFilled(false);
			kindradio[i].addActionListener(ProcessPressed);
			kindgroup.add(kindradio[i]);
			meals_pane.add(kindradio[i]);
		}
    }
	 private void setClassCombo(){//�]�m���O�U�Ԧ����
		 class_jcb.setBounds(110,235,100,35);
		 class_jcb.setFont(new Font("������",0,16));	
		 meals_pane.add(class_jcb);
	 }	
	 private void setMaterCombo(){//�]�m���ƤU�Ԧ����
		 //�]�m���Ƥ���
		 material_type_jcb.setBounds(110,283,100,35);
		 material_type_jcb.setFont(new Font("������",0,16));	
		 meals_pane.add(material_type_jcb);	
		 //�]�m���ƺ���
		 material_jcb.setBounds(220,283,180,35);
		 material_jcb.setFont(new Font("������",0,16));	
		 material_jcb.setVisible(false);
		 meals_pane.add(material_jcb);	 
	 }	 
	 private void setMealState(){
		msradio[0]=new JRadioButton("�c	��",true);
		msradio[1]=new JRadioButton("��	��");
		ButtonGroup msgroup=new ButtonGroup();
		for(int i=0;i<msradio.length;i++){
			msradio[i].setBounds(110+80*i,333,100,30);
			msradio[i].setFont(new Font("������",0,16));	
			msradio[i].setContentAreaFilled(false);
			msradio[i].addActionListener(ProcessPressed);
			msgroup.add(msradio[i]);
			meals_pane.add(msradio[i]);
		}
     }
	 void setMealDate(){
		 Clock c1 = new Clock();
		 String dateStr;
		 int year,month,date;
		 year = c1.getYear();	//���o[�t�η�e�~�����]
		 month = c1.getMonth(); //���o[�t�η�e������]
		 date = c1.getDate();   //���o[�t�η�e�ѼƸ��]
		 String y,m,d;
		 y=String.valueOf(year);
		 m=String.valueOf(month);
		 if(m.length()==1)
			 m="0"+m;
		 d=String.valueOf(date);
		 if(d.length()==1)
			 d="0"+d;
		 dateStr = y+("/")+m+("/")+d; //�N���o�������ƥH"yyyy/mm/dd"�榡�s�JdateStr�r��
		 no_date = y+("")+m+("")+d;   //�N���o����������\�I�s��������r��
		 datetxt.setText(dateStr);
	 }
	 private void getLastNo(){
		String last_no; 
		int num,count=0;
		CDM_dbma cdm1=new CDM_dbma();
		last_no=cdm1.query_lastkey_TB_meal();
       
		int len = last_no.length();  //���o�ǤJ�r�����
        String[] sList = new String[len];   //�إߤ@�Ӫ��׬�len���r��}�C,�Ψ��x�s�r���ѫ�U�Ӧr����

        
        //�N�r���Ѧ��@�ӭӦr��,���x�s��}�C
        for(int x=0; x<len-1; x++)
            sList[x] = last_no.substring(x,x+1);

        sList[len-1] = last_no.substring(len-1);

        for(int x=14; x<len; x++){//����T��Ʀr
        	meal_no[count]=Integer.valueOf(sList[x]);
        	count++;
        }
       
	 }
	 
	 void setNewNo(){
		 getLastNo();
		 if(meal_no[2]+1>9){//�P�_�Ӧ�ƬO�_�ݭn�i��
			 meal_no[2]=0;
			 if(meal_no[1]+1>9){//�P�_�Q��ƬO�_�ݭn�i��
				 meal_no[1]=0;
				 if(meal_no[0]+1>9)//�P�_�O�_�W�L999�����
	                  JOptionPane.showMessageDialog(null,"���O��ƪ�w��!");
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
	 void initialize_Filed(){
		nametxt.setText("");
		notetxt.setText("");
		pricetxt.setText("");
	 }
	 //�ƥ��ť�{��: �B�z��ο����s���
     public ActionListener ProcessPressed = new ActionListener(){
         public void actionPerformed(ActionEvent e){
        	 if(e.getSource()== kindradio[0]){
        		 kindStr="�D�H";
        		 man_selected=true;
        	 }
        	 if(e.getSource()== kindradio[1]){
        		 kindStr="�d��";
        		 man_selected=false;
        	 }
        	 if(e.getSource() == msradio[0]){
        		 stateStr="�c��";
        	 }
        	 if(e.getSource() == msradio[1]){
        		 stateStr="����";
        	 }
         }
     };
}
