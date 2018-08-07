import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CHCI_PWC_panel extends JPanel implements ActionListener{	
	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("�ק�K�X�G");
	JPanel pane2 = new JPanel();
	Font font3 = new Font("������",1,16);  //�Ʀr�j����
	JTextField jtxtfd_StaffId = new JTextField();   //���u�s��
	JPasswordField jtxtfd_StaffOldPW = new JPasswordField();  //�±K�X
	JPasswordField jtxtfd_StaffNewPW1 = new JPasswordField();  //�K�X�@
	JPasswordField jtxtfd_StaffNewPW2 = new JPasswordField();  //�K�X�G
	
	JButton btn_Submit = new JButton();
	JButton btn_Cancel = new JButton();
	
	
	JLabel[] lbl2 = new JLabel[4];
	String[] str_lbl2 = {"���u�s��:","�±K�X:","�s�K�X:","�T�{�s�K�X:"};
	
	CHCI_PWC_panel(){
		
		setEditPW();
		setBtn();
		add(btn_Cancel);
		add(btn_Submit);
		
		pane2 = new JPanel();
		pane2.setBounds(0,0,500,550);
		pane2.setOpaque(false);
		pane2.setLayout(null);
		add(pane2);
		
		
		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("editstaff_icon.png")));
		pane2.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("������",1,20));	
		pane2.add(titlelbl);
		
		
		
		for(int i=0;i<lbl2.length;i++){
			lbl2[i] = new JLabel(str_lbl2[i]);
			lbl2[i].setBounds(10,45+i*45,150,45);
			lbl2[i].setFont(font3);
			pane2.add(lbl2[i]);	
		}
		
		setOpaque(false);
		setBounds(5,65,475,490);
		setLayout(null); 
	}

	
	
	
	private void setEditPW(){
		
		jtxtfd_StaffId = new JTextField();
		jtxtfd_StaffId.setBounds(110,52, 100,30);
		jtxtfd_StaffId.setFont(font3);
		//jtxtfd_StaffId
		add(jtxtfd_StaffId);
		
		jtxtfd_StaffOldPW = new JPasswordField();  //�±K�X
		jtxtfd_StaffOldPW.setBounds(110,97,150,30);
		jtxtfd_StaffOldPW.setEchoChar('*');
		jtxtfd_StaffOldPW.setFont(font3);
		add(jtxtfd_StaffOldPW);
		
		jtxtfd_StaffNewPW1 = new JPasswordField();
		jtxtfd_StaffNewPW1.setBounds(110,142,150,30);
		jtxtfd_StaffNewPW1.setEchoChar('*');
		jtxtfd_StaffNewPW1.setFont(font3);
		add(jtxtfd_StaffNewPW1);
		
		jtxtfd_StaffNewPW2 = new JPasswordField();
		jtxtfd_StaffNewPW2.setBounds(110,187,150,30);
		jtxtfd_StaffNewPW2.setEchoChar('*');
		jtxtfd_StaffNewPW2.setFont(font3);
		add(jtxtfd_StaffNewPW2);	
		
	}
	
	
	private void setBtn(){
		btn_Cancel = new JButton("����");
		btn_Cancel.setFont(font3);
		btn_Cancel.setBounds(10,425,150,60);
		btn_Cancel.setBackground(new Color(0, 148, 141));
		btn_Cancel.addActionListener(this);
		
		btn_Submit = new JButton("�T�w");
		btn_Submit.setFont(font3);
		btn_Submit.setBounds(310,425,150,60);
		btn_Submit.setBackground(Color.orange);
		btn_Submit.addActionListener(this);	
	}
	

	//@SuppressWarnings("deprecation")
	public boolean checkPW(){       //�T�{�K�X
		//System.out.println("����= "+jtxtfd_StaffNewPW1.getText().length());
		if(jtxtfd_StaffNewPW1.getPassword().length>=8 ){     //�T�{�K�X�j��8�Ӧr
			if(jtxtfd_StaffNewPW1.getText().equals(jtxtfd_StaffNewPW2.getText())){   //�T�{������K�X�O�_�ۦP
				return true;						
			}
			JOptionPane.showMessageDialog(null,"�нT�{�s�K�X�O�_��J���T");
			return false;
		}
		
		else{
			JOptionPane.showMessageDialog(null,"�K�X�����j��8�Ӧr");
			return false;
		}		
	}
	
	public  void ClearAll(){
		jtxtfd_StaffId.setText("");
		jtxtfd_StaffOldPW.setText("");
		jtxtfd_StaffNewPW1.setText("");
		jtxtfd_StaffNewPW2.setText("");
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn_Cancel){
			ClearAll();
		}
		
	}
	
}
