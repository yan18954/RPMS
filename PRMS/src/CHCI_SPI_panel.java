import javax.swing.*;
import java.awt.*;
//�H�����ʼh���O
//CHCI_SPI_panel: Class HumanComputerInteraction_ShowPaymentInformation_panel (�H������-[��ܥI�ڸ�T]�ާ@�e�����O)
public class CHCI_SPI_panel extends JPanel{
	JPanel payinfo_panel=new JPanel();	//JPanel�A�Ψө�m�I�ڸ�T����
	JLabel welcomelbl = new JLabel(new ImageIcon(getClass().getResource("border.png")));
	JLabel homelbl = new JLabel(new ImageIcon(getClass().getResource("home.png")));

	JLabel totallbl =new JLabel("�`���B�G");
	JLabel set_totallbl =new JLabel("");
	JLabel dealMoneylbl=new JLabel("�������B�G");
	JLabel set_dealMoneylbl=new JLabel("");
	JLabel paylbl=new JLabel("�ꦬ���B�G");
	JLabel set_paylbl=new JLabel("");
	JLabel changelbl=new JLabel("��@�@�s�G");
	JLabel set_changelbl=new JLabel("");

	int total=0;
	CHCI_SPI_panel(){
		//�]�m�Ϥ�
		welcomelbl.setBounds(0,5,500,20);
	//	welcomelbl.setVisible(false);				
		add(welcomelbl);
		
		homelbl.setBounds(340,50,120,120);
		add(homelbl, new Integer(0), 0);	
		
		//�]�m��e�[�`���B
		totallbl.setBounds(50,40,200,80);
		totallbl.setFont(new Font("������",1,20));	
		add(totallbl);
		//�]�m��e�[�`���B
		set_totallbl.setBounds(400,40,200,80);
		set_totallbl.setFont(new Font("������",1,20));	
		set_totallbl.setForeground(Color.red);
		add(set_totallbl);
		add(set_totallbl, new Integer(1), 0);	

		
		//�]�mpayinfo_panel
		payinfo_panel.setBounds(0,0,500,200);
		payinfo_panel.setLayout(null);
		payinfo_panel.setBackground(new Color(255, 245, 168));
		add(payinfo_panel);								//�w�][�I�ڸ�T��Ƥ���]����   
		payinfo_panel.setVisible(false);

		//�]�m�ꦬ���B
		paylbl.setBounds(10,10,150,45);
		paylbl.setFont(new Font("������",1,20));	
	//	paylbl.setVisible(false);						//�w�][�ꦬ���B]��������    
		set_paylbl.setBounds(180,10,150,45);
		set_paylbl.setFont(new Font("������",1,20));	
	//	paylbl.setVisible(false);						//�w�][�ꦬ���B]��������    
		payinfo_panel.add(paylbl);	
		payinfo_panel.add(set_paylbl);	
		
		//�]�m�������B
		dealMoneylbl.setBounds(10,55,150,45);
		dealMoneylbl.setFont(new Font("������",1,20));	
	//	dealMoneylbl.setVisible(false);						//�w�][�������B]��������    
		set_dealMoneylbl.setBounds(180,55,150,45);
		set_dealMoneylbl.setFont(new Font("������",1,20));	
	//	set_dealMoneylbl.setVisible(false);					//�w�][�������B]��������    	
		payinfo_panel.add(dealMoneylbl);
		payinfo_panel.add(set_dealMoneylbl);

		
		//�]�m��s
		changelbl.setBounds(10,95,150,45);
		changelbl.setForeground(Color.red);
		changelbl.setFont(new Font("������",1,20));	
	//	changelbl.setVisible(false);					//�w�][��s]��������    
		set_changelbl.setBounds(180,95,150,45);
		set_changelbl.setForeground(Color.red);
		set_changelbl.setFont(new Font("������",1,20));	
	//	changelbl.setVisible(false);					//�w�][��s]��������    
		payinfo_panel.add(changelbl);
		payinfo_panel.add(set_changelbl);
		
		setBackground(new Color(201, 243, 248));
		//setBackground(new Color(.5f, .8f, .5f, .5f));
		setBounds(0, 370, 500, 180);	
		setLayout(null);
		setVisible(true);	
	}
}
