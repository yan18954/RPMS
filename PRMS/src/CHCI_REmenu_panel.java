import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//�H�����ʼh���O
//CHCI_MR_panel: Class HumanComputerInteraction_MakeReseration_panel (�H������-[�q��w��]�ާ@�e�����O)

public class CHCI_REmenu_panel extends JPanel implements ActionListener{
	JPanel mrbtn_panel =new JPanel();			  //JPanel�G�t�s�W�w��. �ק�w�����s
	
	JButton addresbtn = new JButton("�s�W�w��");
    JButton revresbtn = new JButton("�ק�w��");
    CHCI_REmenu_panel(){
		mrbtn_panel.setBounds(0,0,500,60);
		mrbtn_panel.setLayout(new FlowLayout());
		add(mrbtn_panel);				//�[�JJPanel,���t�s�W�w��. �ק�w�����s
		
		addresbtn.setBounds(5,5,120,45);
		addresbtn.setBackground(Color.WHITE);
		addresbtn.setContentAreaFilled(false);
		addresbtn.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		addresbtn.setFont(new Font("������",0,12));
		addresbtn.addActionListener(this);
		mrbtn_panel.add(addresbtn);
		
		revresbtn.setBounds(130,5,120,45);
		//revresbtn.setEnabled(false);
		revresbtn.setBackground(Color.WHITE);
		revresbtn.setContentAreaFilled(false);
		revresbtn.setIcon(new ImageIcon(getClass().getResource("editclass_icon.png")));
		revresbtn.setFont(new Font("������",0,12));
		revresbtn.addActionListener(this);
		mrbtn_panel.add(revresbtn);
		
		setBounds(0,0,500,60);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
}
