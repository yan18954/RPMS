import javax.activation.MimeType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//�H�����ʼh���O
//CHCI_AC_panel: Class HumanComputerInteraction_AddOrder_panel (�H������-[�s�W����]�ާ@�e�����O)
public class CHCI_AMA_panel extends JPanel implements ActionListener{
	String[] MiType = {"��","��","��","��","��"};
	int no[] = {0,0,0};
	String no_date="";
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ToolCheck myToolCheck = new ToolCheck();
	
	JPanel materials=new JPanel();			//JPanel�A�t�s�W���O������T	
	
	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("�إ߷s���ơG");
	//���D���
	JLabel nolbl=new JLabel("���ƽs���G");
	JLabel typelbl = new JLabel("�������O�G");
	JLabel namelbl=new JLabel("���ƦW�١G");	
	JLabel notelbl=new JLabel("��      ���G");	
	//��J���
    JTextField notxt=new JTextField("");
    JTextField nametxt=new JTextField("");    
    JTextArea notetxt=new JTextArea("",3,12);
    
    //�U�Ԧ����
    JComboBox<String> TypeCombo = new JComboBox<>(MiType);
    
    JScrollPane scroll=new JScrollPane(notetxt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS 
    		, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   
    JRadioButton[] csradio=new JRadioButton[2];
    JRadioButton[] msradio=new JRadioButton[2];
    JButton addbtn=new JButton("�s�W");
    JButton clearbtn=new JButton("����");	
	CHCI_AMA_panel(){	//�غc�l
		materials.setBounds(0,35,500,550);
		materials.setFont(new Font("������",1,16));
		materials.setLayout(null);
		materials.setOpaque(false);
		add(materials);
		
		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		materials.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("������",1,20));	
		materials.add(titlelbl);			 
	 
		//�]�m���ƽs��
		nolbl.setBounds(10,45,150,45);
		nolbl.setFont(new Font("������",1,16));	
		materials.add(nolbl);	
		//notxt.setBounds(110,52,155,30);
		notxt.setBounds(110,52,210,30);
		notxt.setFont(new Font("������",1,16));	
		notxt.setEnabled(false);
		setNewNo();
		materials.add(notxt);		
		
		//�]�m���ƦW��
		namelbl.setBounds(10,90,150,45);
		namelbl.setFont(new Font("������",1,16));	
		materials.add(namelbl);
		nametxt.setBounds(110,97,155,30);
		nametxt.setFont(new Font("������",1,16));	
		materials.add(nametxt);		
		
		//�]�m�������O
		typelbl.setBounds(10,135,150,45);
		typelbl.setFont(new Font("������",1,16));	
		materials.add(typelbl);
		//�]�w�������O�]�U�Ԧ����^
		 TypeCombo.setBounds(110,137,155,35);
		 TypeCombo.setFont(new Font("������",0,16));	
		 TypeCombo.setSelectedIndex(0);
		 materials.add(TypeCombo);
		
		//�]�m�Ƶ�
		notelbl.setBounds(10,180,150,45);
		notelbl.setFont(new Font("������",1,16));	
		materials.add(notelbl);				 
		notetxt.setFont(new Font("������",1,16));
		notetxt.setLineWrap(true);
		scroll.setBounds(110,180,250,90);
		materials.add(scroll);		
		
		//�]�m���s
		addbtn.setBounds(310,390,150,60);
		addbtn.setFont(new Font("������",1,16));
		addbtn.setBackground(Color.orange);
		addbtn.setBorderPainted(false);
		addbtn.addActionListener(this);
		materials.add(addbtn);	
		clearbtn.setBounds(10,390,150,60);
		clearbtn.setFont(new Font("������",1,16));	
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		clearbtn.addActionListener(this);
		materials.add(clearbtn);	
		setOpaque(false);
		setBounds(5,65,475,490);
		setLayout(null); 
	 }

	//�H�U����Ʈw�\��
	 //�H�U����Ʈw�\��
	 private void getLastNo(){	//���o�̫�@��order�q��s���A�ñN�y�����s�boreder[]��ư}�C��
		String last_no; 
		int count=0;
		last_no=dbma.query_lastkey_TB_mi();
      
		int len = last_no.length();  //���o�ǤJ�r�����(�s������)

       String[] sList = new String[len];   //�إߤ@�Ӫ��׬�len���r��}�C,�Ψ��x�s�r���ѫ�U�Ӧr����
       
       //�N�r���Ѧ��@�ӭӦr��,���x�s��}�C
       for(int x=0; x<len-1; x++)
           sList[x] = last_no.substring(x,x+1);

       sList[len-1] = last_no.substring(len-1);

       for(int x=len-3; x<len; x++){	//����T��Ʀr�]�y�����^
       	no[count]=Integer.valueOf(sList[x]);
       	count++;
       }
	 }
	
	 void setNewNo(){
		 setDate();
		 getLastNo();
		 if(no[2]+1>9){	//�P�_�Ӧ�ƬO�_�ݭn�i��
			 no[2]=0;
			 if(no[1]+1>9){	//�P�_�Q��ƬO�_�ݭn�i��
				 no[1]=0;
				 if(no[0]+1>9)		//�P�_�O�_�W�L999�����
	                  JOptionPane.showMessageDialog(null,"���O��ƪ�w��!");
				 else
					 no[0]++;
			 }
			 else
				 no[1]++;
		 }
		 else
			 no[2]++;
		 
		 notxt.setText("MI01"+no_date+no[0]+no[1]+no[2]);
	 }
	 
	 void setDate(){
		 Clock c1 = new Clock();
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
		 no_date = y+("")+m+("")+d; 	//�N���o������������O�s��������r��
	 }	 
	 
	 private void ClearAll(){
		 nametxt.setText(null);
		 notetxt.setText(null);
	 }

	 private void AddMi(){	//�s�W���O
		 CPD_mi commands = new CPD_mi();
		 commands.setNo(notxt.getText());
		 commands.setName(nametxt.getText());
		 commands.setState(TypeCombo.getSelectedItem().toString());
		 commands.setNote(notetxt.getText());
		 
		 dbma.insertRD_into_TB_mi(commands);
		 setNewNo();
	 }
	 
	 public void actionPerformed(ActionEvent e){		//�ƥ��ť
		 if(e.getSource() == addbtn){		//�B�z�T�{btn�Q���U
			 if(JOptionPane.showConfirmDialog(null, "�T�w�n�s�W������?","�T�{�s�W����",JOptionPane.OK_CANCEL_OPTION)	==0 ){
				 //�|���[�W�ˬd��k
				 AddMi();
				 ClearAll();
			 }
		 }
		 else if(e.getSource() == clearbtn){	//�B�z�������s�Q���U
			 ClearAll();
		 }
	 }
}
