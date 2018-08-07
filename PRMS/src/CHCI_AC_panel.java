import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//�H�����ʼh���O
//CHCI_AC_panel: Class HumanComputerInteraction_AddClass_panel (�H������-[�s�W����]�ާ@�e�����O)
public class CHCI_AC_panel extends JPanel{
	int class_no[]={0,0,0};
	String no_date="";
	JPanel class_pane=new JPanel();			//JPanel�A�t�s�W���O������T	

	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("�إ߷s�����G");
	JLabel nolbl=new JLabel("���O�s���G");
	JLabel datelbl=new JLabel("�إߤ���G");
	JLabel namelbl=new JLabel("���O�W�١G");
	JLabel kindlbl=new JLabel("��          ���G");	
	JLabel statelbl=new JLabel("���O���A�G");
	JLabel notelbl=new JLabel("��      ���G");	
	
    JTextField notxt=new JTextField("");
    JTextField datatxt=new JTextField("");
    JTextField nametxt=new JTextField("");   
  // JTextField kindtxt=new JTextField("");
    JTextField statetxt=new JTextField("");
    JTextArea notetxt=new JTextArea("",3,12);
    
    JScrollPane scroll=new JScrollPane(notetxt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS 
    		, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   
    JRadioButton[] ckradio=new JRadioButton[2];
    JRadioButton[] csradio=new JRadioButton[2];
    JButton addbtn=new JButton("�s�W");
    JButton clearbtn=new JButton("����");
    
    String kindStr="�D�H";
    String stateStr="�}��";
	 CHCI_AC_panel(){
		class_pane.setBounds(0,0,500,550);
		class_pane.setFont(new Font("������",1,16));
		class_pane.setLayout(null);
		class_pane.setOpaque(false);
		add(class_pane);

		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		class_pane.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("������",1,20));	
		class_pane.add(titlelbl);			
		
		//�]�m�إߤ��
		datelbl.setBounds(10,90,150,45);
		datelbl.setFont(new Font("������",1,16));	
		class_pane.add(datelbl);	
		datatxt.setBounds(110,97,155,30);
		datatxt.setFont(new Font("������",1,16));	
		datatxt.setEnabled(false);
		setClassDate();
		class_pane.add(datatxt);
		
		//�]�m���O�s��
		nolbl.setBounds(10,45,150,45);
		nolbl.setFont(new Font("������",1,16));	
		class_pane.add(nolbl);	
		notxt.setBounds(110,52,180,30);
		notxt.setFont(new Font("������",1,16));	
		notxt.setEnabled(false);
		setNewNo();	//�]�m���O�s��
		class_pane.add(notxt);	
	
		
		//�]�m���O�W��
		namelbl.setBounds(10,135,150,45);
		namelbl.setFont(new Font("������",1,16));	
		class_pane.add(namelbl);
		nametxt.setBounds(110,142,155,30);
		nametxt.setFont(new Font("������",1,16));	
		class_pane.add(nametxt);		
		
		//�]�m���O����
		kindlbl.setBounds(10,180,150,45);
		kindlbl.setFont(new Font("������",1,16));	
		class_pane.add(kindlbl);		
		setClassKind();		
		
		//�]�m���O���A
		statelbl.setBounds(10,225,150,45);
		statelbl.setFont(new Font("������",1,16));	
		class_pane.add(statelbl);	
		setClassState();
	
		//�]�m�Ƶ�
		notelbl.setBounds(10,270,150,45);
		notelbl.setFont(new Font("������",1,16));	
		class_pane.add(notelbl);				 
		notetxt.setFont(new Font("������",1,16));
		notetxt.setBorder(BorderFactory.createLineBorder(Color.blue));
		notetxt.setLineWrap(true);
		scroll.setBounds(110,270,250,90);
		class_pane.add(scroll);		
		
		//�]�m���s
		addbtn.setBounds(310,425,150,60);
		addbtn.setFont(new Font("������",1,16));
		addbtn.setBackground(Color.orange);
		addbtn.setBorderPainted(false);
		class_pane.add(addbtn);	
		clearbtn.setBounds(10,425,150,60);
		clearbtn.setFont(new Font("������",1,16));	
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		class_pane.add(clearbtn);	
		setOpaque(false);
		setBounds(5,65,475,490);
		setLayout(null); 
	 }
	 private void getLastNo(){
		String last_no; 
		int num,count=0;
		CDM_dbma cdm1=new CDM_dbma();
		last_no=cdm1.query_lastkey_TB_class();
       
		int len = last_no.length();  //���o�ǤJ�r�����
        String[] sList = new String[len];   //�إߤ@�Ӫ��׬�len���r��}�C,�Ψ��x�s�r���ѫ�U�Ӧr����

        
        //�N�r���Ѧ��@�ӭӦr��,���x�s��}�C
        for(int x=0; x<len-1; x++)
            sList[x] = last_no.substring(x,x+1);

        sList[len-1] = last_no.substring(len-1);

        for(int x=13; x<len; x++){//����T��Ʀr
        	class_no[count]=Integer.valueOf(sList[x]);
        	count++;
        }
       
	 }
	 
	 void setNewNo(){
		 getLastNo();
		 if(class_no[2]+1>9){//�P�_�Ӧ�ƬO�_�ݭn�i��
			 class_no[2]=0;
			 if(class_no[1]+1>9){//�P�_�Q��ƬO�_�ݭn�i��
				 class_no[1]=0;
				 if(class_no[0]+1>9)//�P�_�O�_�W�L999�����
	                  JOptionPane.showMessageDialog(null,"���O��ƪ�w��!");
				 else
					 class_no[0]++;
			 }
			 else
				 class_no[1]++;
		 }
		 else
			 class_no[2]++;
		 
		notxt.setText("CLS01"+no_date+class_no[0]+class_no[1]+class_no[2]);
	 }
	 
	 void initialize_Filed(){
		nametxt.setText("");
		notetxt.setText("");
	 }
	 
	 void setClassDate(){
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
		 datatxt.setText(dateStr);
	 }
	 
	 private void setClassKind(){
		ckradio[0]=new JRadioButton("�D   �H",true);
		ckradio[1]=new JRadioButton("�d	��");
		ButtonGroup ckgroup=new ButtonGroup();
		for(int i=0;i<ckradio.length;i++){
			ckradio[i].setBounds(110+80*i,187,100,30);
			ckradio[i].setFont(new Font("������",0,16));	
			ckradio[i].setContentAreaFilled(false);
			ckradio[i].addActionListener(ProcessPressed);
			ckgroup.add(ckradio[i]);
			class_pane.add(ckradio[i]);
		}
	 }
	 
	 private void setClassState(){
		csradio[0]=new JRadioButton("�}	��",true);
		csradio[1]=new JRadioButton("��	��");
		ButtonGroup csgroup=new ButtonGroup();
		for(int i=0;i<csradio.length;i++){
			csradio[i].setBounds(110+80*i,232,100,30);
			csradio[i].setFont(new Font("������",0,16));	
			csradio[i].setContentAreaFilled(false);
			csradio[i].addActionListener(ProcessPressed);
			csgroup.add(csradio[i]);
			class_pane.add(csradio[i]);
		}
	 }

	 //�ƥ��ť�{��: �B�z��ο����s���
     public ActionListener ProcessPressed = new ActionListener(){
         public void actionPerformed(ActionEvent e){
        	 if(e.getSource()== ckradio[0]){
        		 kindStr="�D�H";
        	 }
        	 if(e.getSource()== ckradio[1]){
        		 kindStr="�d��";
        	 }
        	 if(e.getSource() == csradio[0]){
        		 stateStr="�}��";
        	 }
        	 if(e.getSource() == csradio[1]){
        		 stateStr="����";
        	 }
         }
     };
	 
}
