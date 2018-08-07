import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//�H�����ʼh���O
//CHCI_ACO_panel: Class HumanComputerInteraction_AddCOmpany_panel (�H������-[�s�W�t��]�ާ@�e�����O)
public class CHCI_ACO_panel extends JPanel implements ActionListener{
	int[] no = {0,0,0};
	String no_date="";
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ToolCheck myToolCheck = new ToolCheck();
	
	JPanel company_pane=new JPanel();			//JPanel�A�t�s�q��O������T	

	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("�إ߷s�t�ӡG");
	
	JLabel nolbl=new JLabel("�t�ӽs���G");
	JLabel namelbl=new JLabel("�t�ӦW�١G");
	JLabel contactlbl=new JLabel("�t���p���H�G");	
	JLabel tellbl=new JLabel("�t�ӹq�ܡG");
	JLabel notelbl=new JLabel("�t�ӳƵ��G");

    JTextField notxt=new JTextField("");
    JTextField nametxt=new JTextField("");  
    JTextField contacttxt=new JTextField("");
    JTextField teltxt=new JTextField("");
    JTextArea notetext=new JTextArea("");
    JScrollPane scroll=new JScrollPane(notetext, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS 
    		, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    JRadioButton[] csradio=new JRadioButton[2];
    JRadioButton[] msradio=new JRadioButton[2];
    JButton addbtn=new JButton("�s�W");
    JButton clearbtn=new JButton("����");
    
	CHCI_ACO_panel(){
		company_pane.setBounds(0,35,500,550);
		company_pane.setFont(new Font("������",1,16));
		company_pane.setLayout(null);
		company_pane.setOpaque(false);
		add(company_pane);

		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		company_pane.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("������",1,20));	
		company_pane.add(titlelbl);			 
	 
		//�]�m�t�ӽs��
		nolbl.setBounds(10,45,150,45);
		nolbl.setFont(new Font("������",1,16));	
		company_pane.add(nolbl);	
		//notxt.setBounds(110,52,155,30);
		notxt.setBounds(110,52,210,30);
		notxt.setFont(new Font("������",1,16));	
		notxt.setEnabled(false);
		setNewNo();
		company_pane.add(notxt);	
		//�]�m�t�ӦW��
		namelbl.setBounds(10,90,150,45);
		namelbl.setFont(new Font("������",1,16));	
		company_pane.add(namelbl);
		nametxt.setBounds(110,97,155,30);
		nametxt.setFont(new Font("������",1,16));	
		company_pane.add(nametxt);		
		//�]�m�t���p���H
		contactlbl.setBounds(10,135,150,45);
		contactlbl.setFont(new Font("������",1,16));	
		company_pane.add(contactlbl);
		contacttxt.setBounds(110,142,155,30);
		contacttxt.setFont(new Font("������",1,16));	
		company_pane.add(contacttxt);	
		//�]�m�t�ӳs���q��
		tellbl.setBounds(10,180,150,45);
		tellbl.setFont(new Font("������",1,16));	
		company_pane.add(tellbl);	
		teltxt.setBounds(110,187,155,30);
		teltxt.setFont(new Font("������",1,16));	
		company_pane.add(teltxt);	
		//�]�m�t�ӳƵ�
		notelbl.setBounds(10,225,150,45);
		notelbl.setFont(new Font("������",1,16));	
		company_pane.add(notelbl);	
		notetext.setFont(new Font("������",1,16));
		notetext.setBorder(BorderFactory.createLineBorder(Color.blue));
		notetext.setLineWrap(true);
		scroll.setBounds(110,232,250,90);
		company_pane.add(scroll);		

		//�]�m���s
		addbtn.setBounds(310,390,150,60);
		addbtn.setFont(new Font("������",1,16));
		addbtn.setBackground(Color.orange);
		addbtn.setBorderPainted(false);
		addbtn.addActionListener(this);
		company_pane.add(addbtn);	
		clearbtn.setBounds(10,390,150,60);
		clearbtn.setFont(new Font("������",1,16));	
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		clearbtn.addActionListener(this);
		company_pane.add(clearbtn);	
		setOpaque(false);
		setBounds(5,65,475,490);
		setLayout(null); 
	 }
	
	//�H�U����Ʈw�\��
	private void getLastNo(){	//���o�̫�@��cl�t�ӽs���A�ñN�y�����s�bcl[]��ư}�C��
		String last_no; 
		int count=0;
		last_no=dbma.query_lastkey_TB_cl();
       
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
		 getLastNo();
		 setDate();
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
		 
		notxt.setText("CL01"+no_date+no[0]+no[1]+no[2]);
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
	 
	 //�N�Ҧ���J��쪺�ȲM��
	 private void ClearAll(){
		 nametxt.setText(null);
		 contacttxt.setText(null);
		 teltxt.setText(null);
		 notetext.setText(null);
	 }
	 
	 private void AddCl(){	//�s�W�q��
		 CPD_cl commands = new CPD_cl();
		 commands.setNo(notxt.getText());
		 commands.setCompany(nametxt.getText());
		 commands.setContact(contacttxt.getText());
		 commands.setContactphone(teltxt.getText());
		 commands.setNote(notetext.getText());
		 
		 dbma.insertRD_into_TB_cl(commands);
		 setNewNo();
	 }
	
	public void actionPerformed(ActionEvent e){	//�ƥ��ť
		if(e.getSource() == addbtn){		//�B�z�T�{btn�Q���U
			 if(JOptionPane.showConfirmDialog(null, "�T�w�n�s�W���t��?","�T�{�s�W�t��",JOptionPane.OK_CANCEL_OPTION)	==0 ){
				 //�|���[�W�ˬd��k
				 AddCl();
				 ClearAll();
			 }
		 }
		 else if(e.getSource() == clearbtn){	//�B�z�������s�Q���U
			 ClearAll();
		 }
	 }
}
