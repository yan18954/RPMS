import javax.swing.*;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.State;
import java.util.ArrayList;


//�H�����ʼh���O
//CHCI_AC_panel: Class HumanComputerInteraction_AddOrder_panel (�H������-[�s�W����]�ާ@�e�����O)
public class CHCI_AO_panel extends JPanel implements ActionListener{
	//�ܼƳ]�w
	String[] status={"���I��","�w�I��","�����q��","����"};
	ArrayList<String> companylist = new ArrayList<String>();
	
	int order_no[] = {0,0,0};
	String no_date="";	
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ToolCheck myTool = new ToolCheck();
	
	JPanel order_pane=new JPanel();			//JPanel�A�t�s�q��O������T	

	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("�إ߷s�q��G");
	
	JLabel nolbl=new JLabel("�q��s���G");
	JLabel datelbl=new JLabel("�q�����G");
	JLabel statelbl=new JLabel("�q�檬�A�G");	
	JLabel companylbl=new JLabel("�t�ӡG");	
	JLabel totallbl=new JLabel("�`���B�G");	
	
    //��J���
    JTextField notxt=new JTextField("");
    JTextField datetxt=new JTextField("");    
    JTextField statetxt=new JTextField("");
    JTextField totaltxt=new JTextField("");
    
    //�U�Ԧ����
    JComboBox<String> StatusCombo = new JComboBox<>(status);
    JComboBox<String> CompanyCombo = new JComboBox<>();
   
    JRadioButton[] csradio=new JRadioButton[2];
    JRadioButton[] msradio=new JRadioButton[2];
    JButton addbtn=new JButton("�s�W");
    JButton clearbtn=new JButton("����");
    
	CHCI_AO_panel(){		//�غc�l
		order_pane.setBounds(0,35,500,550);
		order_pane.setFont(new Font("������",1,16));
		order_pane.setLayout(null);
		order_pane.setOpaque(false);
		add(order_pane);

		titleiconlbl.setBounds(0,0,32,32);	
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		order_pane.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("������",1,20));	
		order_pane.add(titlelbl);			 
	 
		//�]�m�q��s��
		nolbl.setBounds(10,45,150,45);
		nolbl.setFont(new Font("������",1,16));	
		order_pane.add(nolbl);	
		//		notxt.setBounds(110,52,155,30);
		notxt.setBounds(110,52,210,30);	
		notxt.setFont(new Font("������",1,16));	
		notxt.setEnabled(false);
		setNewNo();	//�ϥ�setNewNo��k�A�۰ʳ]�w�̷s�q��s���C
		order_pane.add(notxt);	
		//�]�m�إߤ��
		datelbl.setBounds(10,90,150,45);
		datelbl.setFont(new Font("������",1,16));	
		order_pane.add(datelbl);
		datetxt.setBounds(110,97,155,30);
		datetxt.setFont(new Font("������",1,16));	
		datetxt.setEnabled(false);
		setDate();	//�ϥ�setDate��k�A�۰ʳ]�w�����ƭȡC
		order_pane.add(datetxt);		
		//�]�m�q�檬�A
		statelbl.setBounds(10,135,150,45);
		statelbl.setFont(new Font("������",1,16));	
		order_pane.add(statelbl);
		//setOrderCombo();
		
		//�]�w�q�檬�A�]�U�Ԧ����^
		 StatusCombo.setBounds(110,137,100,35);
		 StatusCombo.setFont(new Font("������",0,16));	
		 StatusCombo.setSelectedIndex(0);
		 order_pane.add(StatusCombo);
		 
		//�]�m�t�ӽs��
		companylbl.setBounds(10,180,150,45);
		companylbl.setFont(new Font("������",1,16));
		order_pane.add(companylbl);	
		
		//�]�m�t�ӿ�ܡ]�U�Ԧ����^
		//CompanyCombo.setBounds(110,187,100,35);	//��l�ƭ�
		CompanyCombo.setBounds(110,187,155,35);
		CompanyCombo.setFont(new Font("������",0,16));	
		getCompanyList();	//�s�W�t�ӤU�Ԧ��C��
		//CompanyCombo.setSelectedIndex(0);
		order_pane.add(CompanyCombo);
		
		//�]�m�`���B
		totallbl.setBounds(10,225,150,45);
		totallbl.setFont(new Font("������",1,16));	
		order_pane.add(totallbl);				 
		totaltxt.setFont(new Font("������",1,16));
		totaltxt.setBounds(110,232,155,30);
		order_pane.add(totaltxt);
		//�]�m���s
		addbtn.setBounds(310,390,150,60);
		addbtn.setFont(new Font("������",1,16));
		addbtn.setBackground(Color.orange);
		addbtn.setBorderPainted(false);
		addbtn.addActionListener(this);		//���U�ƥ��ť��
		order_pane.add(addbtn);	
		clearbtn.setBounds(10,390,150,60);
		clearbtn.setFont(new Font("������",1,16));	
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		clearbtn.addActionListener(this);
		order_pane.add(clearbtn);	
		setOpaque(false);
		setBounds(5,65,475,490);
		setLayout(null); 
	 }	 
	
	public void getCompanyList() {	//���o�P��s�t�ӦC��
		CompanyCombo.removeAllItems();
		companylist = dbma.findRD_in_TB_cllist();
		for(int i=0 ;i<companylist.size() ;i++ ){
			CompanyCombo.addItem(companylist.get(i));
		}
		
	}
	
	 //�H�U����Ʈw�\��
	 private void getLastNo(){	//���o�̫�@��order�q��s���A�ñN�y�����s�boreder[]��ư}�C��
		String last_no; 
		int count=0;
		last_no=dbma.query_lastkey_TB_order();
		int len = last_no.length();  //���o�ǤJ�r�����(�s������)
        String[] sList = new String[len];   //�إߤ@�Ӫ��׬�len���r��}�C,�Ψ��x�s�r���ѫ�U�Ӧr����
        
        //�N�r���Ѧ��@�ӭӦr��,���x�s��}�C
        for(int x=0; x<len-1; x++)
            sList[x] = last_no.substring(x,x+1);
        
        sList[len-1] = last_no.substring(len-1);

        for(int x=len-3; x<len; x++){	//����T��Ʀr�]�y�����^
        	order_no[count]=Integer.valueOf(sList[x]);
        	count++;
        }
	 }
	 
	 void setNewNo(){
		 getLastNo();
		 setDate();
		 if(order_no[2]+1>9){	//�P�_�Ӧ�ƬO�_�ݭn�i��
			 order_no[2]=0;
			 if(order_no[1]+1>9){	//�P�_�Q��ƬO�_�ݭn�i��
				 order_no[1]=0;
				 if(order_no[0]+1>9)		//�P�_�O�_�W�L999�����
	                  JOptionPane.showMessageDialog(null,"���O��ƪ�w��!");
				 else
					 order_no[0]++;
			 }
			 else
				 order_no[1]++;
		 }
		 else
			 order_no[2]++;
		 
		notxt.setText("ORDER01"+no_date+order_no[0]+order_no[1]+order_no[2]);
	 }
	 
	 void setDate(){
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
		 no_date = y+("")+m+("")+d; 	//�N���o������������O�s��������r��
		 datetxt.setText(dateStr);
	 }	 
	 
	 //�N�Ҧ���J��쪺�ȲM��
	 private void ClearAll(){
		 totaltxt.setText(null);		//�`���B���M��
		 StatusCombo.setSelectedIndex(0);
		 CompanyCombo.setSelectedIndex(0);
	 }
	 	 
	 private void AddOrder(){	//�s�W�q��
		 CPD_order commands = new CPD_order();
		 commands.setNo(notxt.getText());
		 commands.setDate(datetxt.getText());
		 commands.setStatus((StatusCombo.getSelectedIndex()));	//(0)���I��  (1)�w�I�� (2)�����q�� (3)����
		 commands.setClNo(dbma.findRD_in_TB_ClColumn(CompanyCombo.getSelectedItem().toString(), "CL_company", "CL_no"));	//���o�t�ӽs��
		 commands.setAmount(Integer.parseInt(totaltxt.getText()));
		 
		 dbma.insertRD_into_TB_order(commands);
		 setNewNo();
	 }
	 
	 public void actionPerformed(ActionEvent e){	//�ƥ��ť
		 if(e.getSource() == addbtn){		//�B�z�T�{btn�Q���U
			 if(JOptionPane.showConfirmDialog(null, "�T�w�n�s�W���q��?","�T�{�s�W�q��",JOptionPane.OK_CANCEL_OPTION)	==0 ){
				 //�|���[�W�ˬd��k
				 AddOrder();
				 ClearAll();
			 }
		 }
		 else if(e.getSource() == clearbtn){	//�B�z�������s�Q���U
			 ClearAll();
		 }
	 }
}