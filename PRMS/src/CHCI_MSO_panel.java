import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//�H�����ʼh���O
//CHCI_MSO_panel: Class HumanComputerInteraction_ManageStaffOperation_panel (�H������-[�޲z���u]�ާ@�e�����O)
public class CHCI_MSO_panel extends JPanel{
	CHCI_AS_panel myAS_pane=new CHCI_AS_panel();  //�s�W���O��������(��JPanel,���t����,��r���,���s��)
	CHCI_ES_panel myES_pane=new CHCI_ES_panel();  //�s�����O��������(��JPanel,���t����,��r���,���s��)
	CHCI_PWC_panel myPWC_pane = new CHCI_PWC_panel();  //�ק�K�X
	CHCI_PWQ_panel myPWQ_pane = new CHCI_PWQ_panel();   //�d�߱K�X
	JPanel msbtn_panel =new JPanel();			  //JPanel�GManageStaffButton�A�t�s�W���u�B�ק���u���s
	JButton addstaffbtn = new JButton("�s�W���u");
    JButton revstaffbtn = new JButton("�s����u");
    JButton editPassword = new JButton("���K�X");
    JButton queryPassword = new JButton("�d�߱K�X");
	CHCI_MSO_panel(){
		add(myAS_pane);	//�N[�s�W���u��������]�[�즹������
		myAS_pane.setVisible(true);
		add(myES_pane); //�N[�s����u��������]�[�즹������
		myES_pane.setVisible(false);	
		add(myPWC_pane);
		myPWC_pane.setVisible(false);
		add(myPWQ_pane);
		myPWQ_pane.setVisible(false);
		
		/*���s�����]�m*/
		msbtn_panel.setBounds(0,0,500,60);
		msbtn_panel.setLayout(new FlowLayout());
		add(msbtn_panel);				//�N[�\����s��������]�[�즹������
		
		//addstaffbtn.setBounds(0,5,95,40);
		addstaffbtn.setBackground(Color.WHITE);
		addstaffbtn.setContentAreaFilled(false);
		addstaffbtn.setIcon(new ImageIcon(getClass().getResource("addstaff_icon.png")));
		addstaffbtn.setFont(new Font("������",0,12));
		msbtn_panel.add(addstaffbtn);
		
		//revstaffbtn.setBounds(120,5,95,60);
		revstaffbtn.setBackground(Color.WHITE);
		revstaffbtn.setContentAreaFilled(false);
		revstaffbtn.setIcon(new ImageIcon(getClass().getResource("editstaff_icon.png")));
		revstaffbtn.setFont(new Font("������",0,12));
		revstaffbtn.setEnabled(false);
		msbtn_panel.add(revstaffbtn);
		
		//editPassword.setBound(0,5,100,80);
		editPassword.setBackground(Color.WHITE);
		editPassword.setContentAreaFilled(false);
		editPassword.setIcon(new ImageIcon(getClass().getResource("editstaff_icon.png")));
		editPassword.setFont(new Font("������",0,12));
		msbtn_panel.add(editPassword);
		
		
		queryPassword.setBackground(Color.WHITE);
		queryPassword.setContentAreaFilled(false);
		queryPassword.setIcon(new ImageIcon(getClass().getResource("editstaff_icon.png")));
		queryPassword.setFont(new Font("������",0,12));
		msbtn_panel.add(queryPassword);
		
		
		
	    setBackground(new Color(133, 255, 165));
	    setBounds(500,0,500,600);
	    setLayout(null);
	}
		
}
