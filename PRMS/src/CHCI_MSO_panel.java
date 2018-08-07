import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//人機互動層類別
//CHCI_MSO_panel: Class HumanComputerInteraction_ManageStaffOperation_panel (人機介面-[管理員工]操作畫面類別)
public class CHCI_MSO_panel extends JPanel{
	CHCI_AS_panel myAS_pane=new CHCI_AS_panel();  //新增類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_ES_panel myES_pane=new CHCI_ES_panel();  //編輯類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_PWC_panel myPWC_pane = new CHCI_PWC_panel();  //修改密碼
	CHCI_PWQ_panel myPWQ_pane = new CHCI_PWQ_panel();   //查詢密碼
	JPanel msbtn_panel =new JPanel();			  //JPanel：ManageStaffButton，含新增員工、修改員工按鈕
	JButton addstaffbtn = new JButton("新增員工");
    JButton revstaffbtn = new JButton("編輯員工");
    JButton editPassword = new JButton("更改密碼");
    JButton queryPassword = new JButton("查詢密碼");
	CHCI_MSO_panel(){
		add(myAS_pane);	//將[新增員工介面物件]加到此視窗中
		myAS_pane.setVisible(true);
		add(myES_pane); //將[編輯員工介面物件]加到此視窗中
		myES_pane.setVisible(false);	
		add(myPWC_pane);
		myPWC_pane.setVisible(false);
		add(myPWQ_pane);
		myPWQ_pane.setVisible(false);
		
		/*按鈕介面設置*/
		msbtn_panel.setBounds(0,0,500,60);
		msbtn_panel.setLayout(new FlowLayout());
		add(msbtn_panel);				//將[功能按鈕介面物件]加到此視窗中
		
		//addstaffbtn.setBounds(0,5,95,40);
		addstaffbtn.setBackground(Color.WHITE);
		addstaffbtn.setContentAreaFilled(false);
		addstaffbtn.setIcon(new ImageIcon(getClass().getResource("addstaff_icon.png")));
		addstaffbtn.setFont(new Font("正黑體",0,12));
		msbtn_panel.add(addstaffbtn);
		
		//revstaffbtn.setBounds(120,5,95,60);
		revstaffbtn.setBackground(Color.WHITE);
		revstaffbtn.setContentAreaFilled(false);
		revstaffbtn.setIcon(new ImageIcon(getClass().getResource("editstaff_icon.png")));
		revstaffbtn.setFont(new Font("正黑體",0,12));
		revstaffbtn.setEnabled(false);
		msbtn_panel.add(revstaffbtn);
		
		//editPassword.setBound(0,5,100,80);
		editPassword.setBackground(Color.WHITE);
		editPassword.setContentAreaFilled(false);
		editPassword.setIcon(new ImageIcon(getClass().getResource("editstaff_icon.png")));
		editPassword.setFont(new Font("正黑體",0,12));
		msbtn_panel.add(editPassword);
		
		
		queryPassword.setBackground(Color.WHITE);
		queryPassword.setContentAreaFilled(false);
		queryPassword.setIcon(new ImageIcon(getClass().getResource("editstaff_icon.png")));
		queryPassword.setFont(new Font("正黑體",0,12));
		msbtn_panel.add(queryPassword);
		
		
		
	    setBackground(new Color(133, 255, 165));
	    setBounds(500,0,500,600);
	    setLayout(null);
	}
		
}
