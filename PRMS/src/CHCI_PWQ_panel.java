import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CHCI_PWQ_panel extends JPanel implements ActionListener{	
	Font font3 = new Font("正黑體",1,16);  //數字大按鍵
	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("查詢密碼：");
	JPanel pane2 = new JPanel();
	
	JTextField jtxtfd_StaffId = new JTextField();
	JTextField jtxtfd_StaffNubmer = new JTextField();
	JTextField jtxtfd_StaffPhone = new JTextField();
	JTextField jtxtfd_FindPW = new JTextField();
	
	
	JButton btn_Submit = new JButton();
	JButton btn_Cancel = new JButton();
	JLabel[] lbl2 = new JLabel[4];
	String[] str_lbl2 = {"員工編號:","身分證號:","電話號碼:","密碼為:"};
	
	CHCI_PWQ_panel(){
		setBtn();
		add(btn_Submit);
		add(btn_Cancel);
		setEditPW();
		
		
		
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
		titlelbl.setFont(new Font("正黑體",1,20));	
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
		
		jtxtfd_StaffId = new JTextField();        //員工編號
		jtxtfd_StaffId.setBounds(110,52, 100,30);
		jtxtfd_StaffId.setFont(font3);
		add(jtxtfd_StaffId);
		
		jtxtfd_StaffNubmer = new JTextField();  //身分證號
		jtxtfd_StaffNubmer.setBounds(110,97,100,30);
		jtxtfd_StaffNubmer.setFont(font3);
		add(jtxtfd_StaffNubmer);
		
		jtxtfd_StaffPhone = new JTextField();   //電話號碼
		jtxtfd_StaffPhone.setBounds(110,142,100,30);
		jtxtfd_StaffPhone.setFont(font3);
		add(jtxtfd_StaffPhone);
		
		jtxtfd_FindPW = new JTextField();  //密碼為
		jtxtfd_FindPW.setBounds(110,187,150,30);
		jtxtfd_FindPW.setFont(font3);
		jtxtfd_FindPW.setEditable(false);
		add(jtxtfd_FindPW);	
		
	}
	
	
	private void setBtn(){
		btn_Cancel = new JButton("取消");
		btn_Cancel.setFont(font3);
		btn_Cancel.setBounds(10,425,150,60);
		btn_Cancel.setBackground(new Color(0, 148, 141));
		btn_Cancel.addActionListener(this);
		
		btn_Submit = new JButton("查詢");
		btn_Submit.setFont(font3);
		btn_Submit.setBounds(310,425,150,60);
		btn_Submit.setBackground(Color.orange);
		//btn_Submit.addActionListener(this);	
	}
	
	private void ClearAll(){
		jtxtfd_StaffId.setText("");		
		jtxtfd_StaffNubmer.setText("");		
		jtxtfd_StaffPhone.setText("");
		jtxtfd_FindPW.setText("");		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn_Cancel){
			ClearAll();
		}
		
	}

	



}
