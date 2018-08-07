import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.toedter.calendar.JDateChooser;

//CHCI_AR_panel: Class HumanComputerInteraction_AddResevation_panel (�H������-[�s�W�w��]�ާ@�e�����O)
public class CHCI_AR_panel extends JPanel implements ActionListener{
	CDM_ST_dbma dbma = new CDM_ST_dbma();
	LimitedDocument limitDocument1 = new LimitedDocument(10);
	LimitedDocument limitDocument2 = new LimitedDocument(10);
	LimitedDocument limitDocument4 = new LimitedDocument(300);
	ToolCheck myTool = new ToolCheck();
	JDateChooser dateChooser = new JDateChooser();
	SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
	
	JPanel addres_pane=new JPanel();			//JPanel�A�t�s�W�w��������T	

	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("�إ߷s�w���G");
	JLabel namelbl=new JLabel("�m�@�@�W�G");
	JLabel datelbl=new JLabel("��@�@���G");
	JLabel timelbl=new JLabel("�ɡ@�@���G");	
	JLabel tellbl=new JLabel("�q�@�@�ܡG");
	JLabel sumlbl=new JLabel("�H�@�@�ơG");	
	JLabel mnotelbl=new JLabel("��      ���G");	
	
    
    JTextField nametxt=new JTextField("");
    JTextField timetxt=new JTextField("");
    JTextField teltxt=new JTextField("");
    JTextField sumtetxt=new JTextField("");
    JTextArea mnotetxt=new JTextArea("",3,12);
    
    pickdate_panel d1=new pickdate_panel();
    
    JScrollPane scroll=new JScrollPane(mnotetxt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS 
    		, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
	JComboBox combo_hour = new JComboBox();
	JComboBox combo_minute = new JComboBox();
	JComboBox combo_query = new JComboBox();
	JComboBox combo_num = new JComboBox();
	JComboBox combo_pet = new JComboBox();
	String[] combo_str = {"�q��","�m�W","���"};
	String[] str_combopet = {"1�d","2�d","3�d","4�d","5�d","6�d","7�d","8�d","9�d","10�d","11�d","12�d","13�d","14�d","15�d","16�d","17�d","18�d","19�d","20�d"};
	String[] str_comboNum = {"1�H","2�H","3�H","4�H","5�H","6�H","7�H","8�H","9�H","10�H","11�H","12�H","13�H","14�H","15�H","16�H","17�H","18�H","19�H","20�H"};
	String[] str_hour = {"�W��10�I","�W��11�I","����12�I","�U��01�I","�U��02�I","�U��03�I","�U��04�I","�U��05�I","�U��06�I","�߶�07�I","�߶�08�I","�߶�09�I"};
	//String[] str_range = {"�W��","�U��"};
	String[] str_minute = {"00��","15��","30��","45��"};
	//JComboBox combo_range = new JComboBox();
	//JComboBox combo_range = new JComboBox()
   
    JRadioButton[] csradio=new JRadioButton[2];
    JRadioButton[] msradio=new JRadioButton[2];
    JButton addbtn=new JButton("�s�W");
    JButton clearbtn=new JButton("����");
	CHCI_AR_panel(){
		

	    
		addres_pane.setBounds(0,0,500,550);
		addres_pane.setFont(new Font("������",1,16));
		addres_pane.setLayout(null);
		addres_pane.setOpaque(false);
		add(addres_pane);

		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		addres_pane.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("������",1,20));	
		addres_pane.add(titlelbl);			 
	 
		//�]�m�m�W
		namelbl.setBounds(10,45,100,45);
		namelbl.setFont(new Font("������",1,16));	
		addres_pane.add(namelbl);	
		nametxt.setBounds(110,52,155,30);
		nametxt.setFont(new Font("������",1,16));	
		nametxt.setDocument(limitDocument1);
		//nametxt.setEnabled(false);
		addres_pane.add(nametxt);	
		//�]�m���
		datelbl.setBounds(10,90,150,45);
		datelbl.setFont(new Font("������",1,16));	
		addres_pane.add(datelbl);
			//�]�m�����ܾ�
		dateChooser.setBounds(110,97,160,30);
		dateChooser.setFont(new Font("������",1,16));
		//dateChooser.setEnabled(false);
		((JTextField)dateChooser.getDateEditor().getUiComponent()).setEditable(false);
		addres_pane.add(dateChooser);		
		//�]�m�ɶ�
		timelbl.setBounds(10,135,150,45);
		timelbl.setFont(new Font("������",1,16));	
		addres_pane.add(timelbl);	
			//�]�m�ɶ��U�Ԧ����
		combo_hour = new JComboBox(str_hour);  //�p�ɤU�Կ��
		combo_hour.setFont(new Font("������",1,16));	
		combo_hour.setBounds(110,142,110,30);
		addres_pane.add(combo_hour);
		
		combo_minute = new JComboBox(str_minute);    //�����U�Կ��
		combo_minute.setFont(new Font("������",1,16));	
		combo_minute.setBounds(225,142,80,30);
		addres_pane.add(combo_minute);

		//�]�m�q��
		tellbl.setBounds(10,180,150,45);
		tellbl.setFont(new Font("������",1,16));	
		addres_pane.add(tellbl);	
		teltxt.setBounds(110,187,155,30);
		teltxt.setDocument(limitDocument2);
		teltxt.setFont(new Font("������",1,16));	
		addres_pane.add(teltxt);	
		//�]�m�H��
		sumlbl.setBounds(10,225,150,45);
		sumlbl.setFont(new Font("������",1,16));	
		addres_pane.add(sumlbl);	
			//�]�m�H�ƤU�Ԧ����
		combo_num = new JComboBox(str_comboNum);     //�H�ƤU�Կ��
		combo_num.setFont(new Font("������",1,16));	
		combo_num.setBounds(110,232,90,30);
		addres_pane.add(combo_num);
		
		combo_pet = new JComboBox(str_combopet);     //�d���ƤU�Կ��
		combo_pet.setFont(new Font("������",1,16));	
		combo_pet.setBounds(220,232,90,30);
		addres_pane.add(combo_pet);
		
		//�]�m�Ƶ�
		mnotelbl.setBounds(10,270,150,45);
		mnotelbl.setFont(new Font("������",1,16));	
		addres_pane.add(mnotelbl);				 
		mnotetxt.setFont(new Font("������",1,16));
		mnotetxt.setBorder(BorderFactory.createLineBorder(Color.blue));
		mnotetxt.setLineWrap(true);
		mnotetxt.setDocument(limitDocument4);
		scroll.setBounds(110,277,250,90);
		addres_pane.add(scroll);		
		//�]�m���s
		addbtn.setBounds(310,425,150,60);
		addbtn.setFont(new Font("������",1,16));
		addbtn.setBackground(Color.orange);
		addbtn.setBorderPainted(false);
		addbtn.addActionListener(this);
		addres_pane.add(addbtn);	
		
		clearbtn.setBounds(10,425,150,60);
		clearbtn.setFont(new Font("������",1,16));	
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		clearbtn.addActionListener(this);
		addres_pane.add(clearbtn);	
		setOpaque(false);
		setBounds(5,65,475,490);
		//setVisible(false);
		setLayout(null); 
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addbtn){
			if(checkFd()){
				if(JOptionPane.showConfirmDialog(null,"�T�w�n�s�W�w����?","�T�{�s�W�w��",JOptionPane.OK_CANCEL_OPTION) == 0){
					AddRes();
				}
			}
		}
		if(e.getSource()==clearbtn){
			ClearAll();
		}
		
			
	}
	
	private void ClearAll (){
		nametxt.setText(null);
		((JTextField)dateChooser.getDateEditor().getUiComponent()).setText("");
		teltxt.setText(null);
		mnotetxt.setText(null);
	}
	
	public boolean checkFd(){
		if(myTool.isName(nametxt.getText())){
			if(myTool.CK_Date_Not_null(((JTextField)dateChooser.getDateEditor().getUiComponent()).getText())){
				if(myTool.isNumeric(teltxt.getText())){
					return true;
				}
			}
				
		}
		return false;
	}
	
	
	
	public void AddRes(){
		String time = combo_hour.getSelectedItem().toString()+combo_minute.getSelectedItem().toString();   //�p�� + ����
		String Rid ="R"+sdf.format(new Date());	
		String[] aRes = {Rid,
				nametxt.getText(),
				((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(),
				time,
				teltxt.getText(),
				combo_num.getSelectedItem().toString(),
				combo_pet.getSelectedItem().toString(),
				"�w����",
				mnotetxt.getText()};
		
	        	dbma.insertRD_into_TB_res(aRes);
	        	ClearAll();
		}
	}
