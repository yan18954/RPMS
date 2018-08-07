import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//人機互動層類別
//CHCI_MS_panel: Class HumanComputerInteraction_ManageStaff_panel (人機介面-[管理員工]操作畫面類別)
public class CHCI_MS_panel extends JPanel implements ActionListener,MouseListener{
	static CHCI_MSO_panel myMSO_pane=new CHCI_MSO_panel();  //管理員工操作介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_MSQ_panel myMSQ_pane=new CHCI_MSQ_panel();	 //管理員工查詢介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	

	CHCI_MS_panel(){
		setAS();
		setES();
		setmyMSO();
		setmySSR();
		add(myMSO_pane);
		add(myMSQ_pane);
	
        setBackground(Color.yellow);
        setBounds(0,100,1000,600);
        setLayout(null);
	}
	private void setAS(){
		//myMSO_pane.myAS_pane.btn_cancel.addActionListener(this);
	}
	
	private void setES(){
		myMSO_pane.revstaffbtn.addActionListener(this);
		myMSO_pane.myES_pane.btn_add.addActionListener(this);
		myMSO_pane.myES_pane.btn_cancel.addActionListener(this);
	}
	
	private void setmyMSO(){
		myMSQ_pane.myQS_pane.quertbtn.addActionListener(this);
		myMSO_pane.addstaffbtn.addActionListener(this);
		myMSO_pane.revstaffbtn.addActionListener(this);
		myMSO_pane.editPassword.addActionListener(this);
		myMSO_pane.queryPassword.addActionListener(this);
		myMSO_pane.myPWQ_pane.btn_Submit.addActionListener(this);
		myMSO_pane.myPWC_pane.btn_Submit.addActionListener(this);
	}
	
	private void setmySSR(){
		myMSQ_pane.mySSR_pane.queryTable.addMouseListener(this);
	}
	
	public static void setData(String[] sendStr){
		//System.out.printf("setDate");
		myMSO_pane.myES_pane.DefaultStatus();
		myMSO_pane.myES_pane.setAllEnable();
		myMSO_pane.myES_pane.jtxtfd_name.setText(sendStr[1]);
		
		if(sendStr[2].equals("女"))myMSO_pane.myES_pane.setRDB();	    
		((JTextField) myMSO_pane.myES_pane.jtxtfd_birth.getDateEditor().getUiComponent()).setText(sendStr[3]);
		((JTextField) myMSO_pane.myES_pane.jtxtfd_duty.getDateEditor().getUiComponent()).setText(sendStr[4]);
		myMSO_pane.myES_pane.jtxtfd_id.setText(sendStr[5]);
		myMSO_pane.myES_pane.jtxtfd_telephone.setText(sendStr[6]);
		myMSO_pane.myES_pane.jtxtfd_address.setText(sendStr[7]);
		if(sendStr[8].equals("主管"))myMSO_pane.myES_pane.combo_level.setSelectedIndex(0);
		if (sendStr[8].equals("店長"))myMSO_pane.myES_pane.combo_level.setSelectedIndex(1);
		
		if(sendStr[9].equals("停職"))myMSO_pane.myES_pane.combo_status.setSelectedIndex(1);
		if(sendStr[9].equals("離職"))myMSO_pane.myES_pane.combo_status.setSelectedIndex(2);
		
		myMSO_pane.myES_pane.jtxtarea.setText(sendStr[10]);
		myMSO_pane.myES_pane.setAllDisable();				
	}
	
	private void ActFindPW(){   //按下查詢密碼的動作
		myMSO_pane.myPWQ_pane.jtxtfd_FindPW.setText(myMSO_pane.myAS_pane.dbma.findRD_in_TB_staffPassWord(myMSO_pane.myPWQ_pane.jtxtfd_StaffId.getText(),myMSO_pane.myPWQ_pane.jtxtfd_StaffNubmer.getText(),myMSO_pane.myPWQ_pane.jtxtfd_StaffPhone.getText()));	
	}
	
	private void ActChangePW(){
		if(myMSO_pane.myPWC_pane.checkPW()){
		//myMSO_pane.myAS_pane.dbma.updateRD_in_TB_StaffPW(myMSO_pane.myPWC_pane.jtxtfd_StaffId.getText(),(myMSO_pane.myPWC_pane.jtxtfd_StaffOldPW.getText()),(myMSO_pane.myPWC_pane.jtxtfd_StaffNewPW1.getText()));
			if(JOptionPane.showConfirmDialog(null,"確定要更改密碼嗎?","更改密碼",JOptionPane.OK_CANCEL_OPTION)==0){
				if(myMSO_pane.myAS_pane.dbma.updateRD_in_TB_StaffPW(myMSO_pane.myPWC_pane.jtxtfd_StaffId.getText(),(myMSO_pane.myPWC_pane.jtxtfd_StaffOldPW.getText()),(myMSO_pane.myPWC_pane.jtxtfd_StaffNewPW1.getText()))==1){
					myMSO_pane.myPWC_pane.ClearAll();
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == myMSQ_pane.myQS_pane.quertbtn){     //按下查詢
			if(myMSQ_pane.myStaffQuery()){
				myMSO_pane.revstaffbtn.setEnabled(false);
				myMSO_pane.myPWC_pane.setVisible(false);
				myMSO_pane.myAS_pane.setVisible(true);
				myMSO_pane.myES_pane.setVisible(false);
				myMSO_pane.myPWQ_pane.setVisible(false);
			}
		}
		
		
		if(e.getSource() ==myMSO_pane.revstaffbtn){	  //System.out.printf("按下了編輯員工\n");
			//myMSO_pane.myPWC_pane
			myMSO_pane.myPWC_pane.setVisible(false);
			myMSO_pane.myPWQ_pane.setVisible(false);
			myMSO_pane.myAS_pane.setVisible(false);
			myMSO_pane.myES_pane.setVisible(true);
			
			if(myMSO_pane.myES_pane.getjtxtfdnameTxt()){
				myMSO_pane.myES_pane.setAllDisable();
				myMSO_pane.myES_pane.DefaultStatus();
			}
	
		}
		
		if(e.getSource()== myMSO_pane.editPassword){  //按下修改密碼
			myMSO_pane.myPWC_pane.setVisible(true);
			myMSO_pane.myAS_pane.setVisible(false);
			myMSO_pane.myES_pane.setVisible(false);
			myMSO_pane.myPWQ_pane.setVisible(false);
		}
		
		if(e.getSource() == myMSO_pane.addstaffbtn){   //按下新增員工
			//System.out.println("myMSO_pane.addstaffbtn 新增員工");
			myMSO_pane.myPWC_pane.setVisible(false);
			myMSO_pane.myAS_pane.setVisible(true);
			myMSO_pane.myES_pane.setVisible(false);
			myMSO_pane.myPWQ_pane.setVisible(false);
		}
		
		if(e.getSource() == myMSO_pane.queryPassword){     //按下查詢密碼
			
			myMSO_pane.myPWC_pane.setVisible(false);
			myMSO_pane.myAS_pane.setVisible(false);
			myMSO_pane.myES_pane.setVisible(false);
			myMSO_pane.myPWQ_pane.setVisible(true);
		}
		
		if(e.getSource() == myMSO_pane.myPWQ_pane.btn_Submit){  //按下密碼查詢
			ActFindPW();
		}
		
		if(e.getSource() == myMSO_pane.myPWC_pane.btn_Submit){
		    ActChangePW();
		}
		
		
		if(e.getSource() == myMSO_pane.myES_pane.btn_add){
			if(myMSO_pane.myES_pane.CheckFd()){
				if(JOptionPane.showConfirmDialog(null,"確定要更新員工資料嗎?","確認更新員工",JOptionPane.OK_CANCEL_OPTION)==0){
					myMSQ_pane.mySSR_pane.dbma.updateRD_in_TB_staff(myMSQ_pane.mySSR_pane.rtnSelectedId(), myMSO_pane.myES_pane.getAllDate(myMSQ_pane.mySSR_pane.rtnSelectedId()));
					myMSO_pane.myES_pane.btn_add.setVisible(false);
					myMSO_pane.myES_pane.btn_edit.setVisible(true);
					myMSQ_pane.myStaffQuery();
					myMSO_pane.myES_pane.setAllDisable();
				}
				else{
					myMSO_pane.myES_pane.btn_add.setVisible(false);
					myMSO_pane.myES_pane.btn_edit.setVisible(true);
					myMSO_pane.myES_pane.setAllDisable();
				}
			//String[] recieve = myMSO_pane.myES_pane.getAllDate(myMSQ_pane.mySSR_pane.rtnSelectedId());
			}
		}
		if(e.getSource() == myMSO_pane.myES_pane.btn_cancel){  //按下新增員工的取消鍵
			myMSO_pane.myPWC_pane.setVisible(false);
			myMSO_pane.myAS_pane.setVisible(true);
			myMSO_pane.myES_pane.setVisible(false);
			myMSO_pane.myPWQ_pane.setVisible(false);
			myMSO_pane.revstaffbtn.setEnabled(false);
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getClickCount()==1){
			myMSO_pane.revstaffbtn.setEnabled(true);
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
