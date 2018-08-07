import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//�H�����ʼh���O
//CHCI_MSO_panel: Class HumanComputerInteraction_ManageDealOperation_panel (�H������-[�޲z���]�ާ@�e�����O)
public class CHCI_MDO_panel extends JPanel{
	CHCI_ED_panel myED_pane=new CHCI_ED_panel(); 	 //�s������������(��JPanel,���t����,��r���,���s��)
	CHCI_CMD_panel myCMD_pane=new CHCI_CMD_panel();  //���ͥ���������O��������(��JPanel,���t����,��r���,���s��)
	JPanel mdbtn_panel =new JPanel();			  	 //JPanel�GManageDealsButton�A�t�s�s�����B���ͥ��������s
    JButton revstaffbtn = new JButton("�s����");
	JButton cdrfbtn = new JButton("���ͥ������");

	CHCI_MDO_panel(){
		add(myED_pane);	//�N[�s������������]�[�즹������
		myED_pane.setVisible(true);
		add(myCMD_pane); //�N[���ͥ������������]�[�즹������
		myCMD_pane.setVisible(false);	
		
		/*���s�����]�m*/
		mdbtn_panel.setBounds(0,0,500,60);
		mdbtn_panel.setLayout(new FlowLayout());
		add(mdbtn_panel);				//�N[�\����s��������]�[�즹������
		
		revstaffbtn.setBounds(0,5,100,40);
		revstaffbtn.setBackground(Color.WHITE);
		revstaffbtn.setContentAreaFilled(false);
		revstaffbtn.setIcon(new ImageIcon(getClass().getResource("editdeal_icon.png")));
		revstaffbtn.setFont(new Font("������",0,12));
		revstaffbtn.addActionListener(ProcessPaneChanged);	
	//	revstaffbtn.setEnabled(false);	//[�s����]�w�]���i�I��
		mdbtn_panel.add(revstaffbtn);
				
		cdrfbtn.setBounds(120,5,110,60);
		cdrfbtn.setBackground(Color.WHITE);
		cdrfbtn.setContentAreaFilled(false);
		cdrfbtn.setIcon(new ImageIcon(getClass().getResource("exportdeal_icon.png")));
		cdrfbtn.setFont(new Font("������",0,12));
		cdrfbtn.addActionListener(ProcessPaneChanged);		
		mdbtn_panel.add(cdrfbtn);

	    setBackground(new Color(227, 242, 239));
	    setBounds(500,0,500,600);
	    setLayout(null);		
	}
    public ActionListener ProcessPaneChanged = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(e.getSource() ==  revstaffbtn){
            	myED_pane.setVisible(true);        //���[�s����]�ާ@�e��	  
            	myCMD_pane.setVisible(false);	   //����[���ͥ������]�ާ@�e��
            }     
            if(e.getSource() ==  cdrfbtn){
            	myCMD_pane.setVisible(true);	   //���[���ͥ������]�ާ@�e��
            	myED_pane.setVisible(false);       //����[[�s����]�ާ@�e��	  
            }  
        }
    };
}
