import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
//�H�����ʼh���O
//CHCI_MMO_panel: Class HumanComputerInteraction_ManageMealsOperation_panel (�H������-[�޲z�\�I]�ާ@�e�����O)
public class CHCI_MMO_panel extends JPanel{
	CHCI_AC_panel myAC_pane=new CHCI_AC_panel();  //�s�W���O��������(��JPanel,���t����,��r���,���s��)
	CHCI_EC_panel myEC_pane=new CHCI_EC_panel();  //�s�����O��������(��JPanel,���t����,��r���,���s��)
	CHCI_AM_panel myAM_pane=new CHCI_AM_panel();  //�s�W�\�I��������(��JPanel,���t����,��r���,���s��)
	CHCI_EM_panel myEM_pane=new CHCI_EM_panel();  //�s���\�I��������(��JPanel,���t����,��r���,���s��)
	JPanel mmdef_panel=new JPanel();			  //JPanel�G�w�]�e���A�t����
	JPanel mmbtn_panel =new JPanel();			  //JPanel�GManageMealsButton�A�޲z�\�I�l���ءA�t�s�W���O�B�ק����O�B�s�W�\�I�B�ק��\�I���s
	JButton addclassbtn = new JButton("�s���O");
    JButton revclassbtn = new JButton("�s�����O");
    JButton addmealsbtn = new JButton("�s�\�I");
    JButton revmealsbtn = new JButton("�s���\�I");
    JLabel introlbl =new JLabel();
    int choose=0;
	CHCI_MMO_panel(){	
		add(myAC_pane);	//�N[�s�W���O��������]�[�즹������
		myAC_pane.setVisible(false);
		add(myEC_pane); //�N[�s�����O��������]�[�즹������
		myEC_pane.setVisible(false);	
		add(myAM_pane); //�N[�s�W�\�I��������]�[�즹������		
		myAM_pane.setVisible(false);
		add(myEM_pane);	//�N[�s���\�I��������]�[�즹������
		myEM_pane.setVisible(false);
		
		/*�w�]����*/
	//	introlbl.setBounds(0,0,500,540);
	//	introlbl.setIcon(new ImageIcon(getClass().getResource("intro_photo.png")));
	//	mmdef_panel.add(introlbl);
		mmdef_panel.setBounds(0,60,500,540);
		mmdef_panel.setBackground(new Color(255, 242, 179));
		mmdef_panel.setLayout(null); 
		add(mmdef_panel);				//�N[�Ӷ��w�]��������]�[�즹������
	//	mmdef_panel.setVisible(false);

		/*���s�����]�m*/
		mmbtn_panel.setBounds(0,0,500,60);
		mmbtn_panel.setLayout(new FlowLayout());
		add(mmbtn_panel);				//�N[�\����s��������]�[�즹������
	
		addclassbtn.setBounds(0,5,100,40);
		addclassbtn.setBackground(Color.WHITE);
		addclassbtn.setContentAreaFilled(false);
		addclassbtn.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		addclassbtn.setFont(new Font("������",0,12));
		mmbtn_panel.add(addclassbtn);
		
		revclassbtn.setBounds(120,5,110,60);
		revclassbtn.setBackground(Color.WHITE);
		revclassbtn.setContentAreaFilled(false);
		revclassbtn.setIcon(new ImageIcon(getClass().getResource("editclass_icon.png")));
		revclassbtn.setFont(new Font("������",0,12));
		//revclassbtn.setEnabled(false);
		mmbtn_panel.add(revclassbtn);
		
		addmealsbtn.setBounds(235,5,110,60);		
		addmealsbtn.setBackground(Color.WHITE);
		addmealsbtn.setContentAreaFilled(false);
		addmealsbtn.setIcon(new ImageIcon(getClass().getResource("addmeals_icon.png")));
		addmealsbtn.setFont(new Font("������",0,12));
		addmealsbtn.setEnabled(false);
		mmbtn_panel.add(addmealsbtn);	
		
		revmealsbtn.setBounds(350,5,110,60);
		revmealsbtn.setBackground(Color.WHITE);
		revmealsbtn.setContentAreaFilled(false);
		revmealsbtn.setIcon(new ImageIcon(getClass().getResource("editmeals_icon.png")));
		revmealsbtn.setFont(new Font("������",0,12));
		revmealsbtn.setEnabled(false);
		mmbtn_panel.add(revmealsbtn);
		
	    setBackground(new Color(255, 242, 179));
	    setBounds(500,0,500,600);
	    setLayout(null);
	}
}
