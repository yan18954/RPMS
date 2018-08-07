import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;
//人機互動層類別
//CHCI_OR_panel: Class HumanComputerInteraction_REserve_panel (人機介面-[訂位預約]操作畫面類別)
public class CHCI_RE_panel extends JPanel implements ActionListener, MouseListener{
		
	ArrayList<ArrayList<String>> Alist = new ArrayList<ArrayList<String>>();  //二為動態陣列
	//String[] receiveData = new String[9];
	//左半部
	JPanel pane1 = new JPanel();
	CHCI_QR_panel myQR=new CHCI_QR_panel();
	CHCI_SRE_panel mySRE=new CHCI_SRE_panel();
	//右半部
	JPanel pane2 = new JPanel();
	CHCI_AR_panel myAR=new CHCI_AR_panel();
	CHCI_ER_panel myER=new CHCI_ER_panel();
		//右半部上方功能選單
	CHCI_REmenu_panel myREmenu=new CHCI_REmenu_panel();
	
	

	CHCI_RE_panel(){

		
		setQR();
		setER();
 		setSRE();
		setREmenu();
		
		pane1 = new JPanel();    //左邊容器
		pane1.setBounds(0,0,500,600);
		pane1.setBackground(Color.yellow);
		pane1.setLayout(null);
		add(pane1);
		pane1.add(myQR);//加入查詢條件
		pane1.add(mySRE);//加入查詢結果
		
				
		
		pane2 = new JPanel();       //右邊容器
		pane2.setBounds(500,0,500,600);
		pane2.setBackground(new Color(174, 184, 249));
		pane2.setLayout(null);
		add(pane2);
		pane2.add(myREmenu);	//[功能選項介面]
		pane2.add(myAR);		//[新增預約介面]
		pane2.add(myER);		//[修改預約介面]
		myER.setVisible(false);	//將[修改預約介面]隱藏
		
		
		setLayout(null);
		setBackground(Color.green);
		setBounds(0,100,1000,600);
	}

	
	private void setQR(){
		myQR.quertbtn.addActionListener(this);
	}
	private void setER(){
		myER.editbtn.addActionListener(this);
		myER.submitbtn.addActionListener(this);
		myER.clearbtn.addActionListener(this);
	}
	private void setSRE(){
		mySRE.queryTable.addMouseListener(this);
	}
	
	private void setREmenu(){
		myREmenu.addresbtn.addActionListener(this);
		myREmenu.revresbtn.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == myREmenu.addresbtn){
			myAR.setVisible(true);
			myER.setVisible(false);
		}
		
		if(e.getSource() == myREmenu.revresbtn){
			myAR.setVisible(false);
			myER.setVisible(true);
		}
		
		
		// TODO Auto-generated method stub
		if(e.getSource() == myQR.quertbtn){
			System.out.printf("按下預約查尋\n");
			myREmenu.revresbtn.setEnabled(false);
			myER.editbtn.setVisible(true);
			myER.submitbtn.setVisible(false);
			myER.setEnabledTorF(false);
			myER.setVisible(false);
			myAR.setVisible(true);
			myREmenu.revresbtn.setEnabled(false);
			myER.ClearAll();
			Query_addDate();
			//System.out.println(myQR.getSelectedQRStr());
		}
		
		if(e.getSource() == myER.submitbtn){
			System.out.printf("按下預約修改\n");
			updateRes();
		}
		
		if(e.getSource()== myER.clearbtn){    //按下取消
			myER.setVisible(false);
			myAR.setVisible(true);
			myREmenu.revresbtn.setEnabled(false);
		}
		
	}
	
	
	
	public void Query_addDate(){        //查詢預約並顯示解果在jtable上
		Alist = myAR.dbma.findRD_in_TB_res(myQR.getSelectedQRStr(),myQR.cond1txt.getText());       //查詢
		mySRE.tm.setRowCount(0);      //清除上次資料
		
		for(int i=0; i<Alist.get(0).size();i++){
				mySRE.tm.addRow(new Object[]{Alist.get(0).get(i),Alist.get(1).get(i),Alist.get(2).get(i),Alist.get(3).get(i)}); //新增table顯示
			}			
		//調用DefaultTableModel的fireTableDataChanged方法可做model刷新
		mySRE.tm.fireTableDataChanged();
		mySRE.queryTable.updateUI();	
	}
	
	
	private String getClickedValue(){
	    String aID = Alist.get(4).get(mySRE.queryTable.getSelectedRow());
		//System.out.println(Alist.get(3).get(mySRE.queryTable.getSelectedRow()));
	    return aID;
	}
	


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getClickCount()==1){
			//JOptionPane.showMessageDialog(null,"查詢成功!");
			myER.editbtn.setVisible(true);
			myER.submitbtn.setVisible(false);
			myER.setEnabledTorF(false);
			myREmenu.revresbtn.setEnabled(true);
			myER.setResData(myAR.dbma.findRD_in_TB_ResDetail(getClickedValue()));
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
	
	
	private void updateRes(){
		//String[] data = myER.getResData(getClickedValue());
		if(myER.checkFd()){
			if(JOptionPane.showConfirmDialog(null,"確定要修改預約資料嗎?","確認修改預約",JOptionPane.OK_CANCEL_OPTION) == 0){
					myAR.dbma.updateRD_in_TB_res(getClickedValue(), myER.getResData(getClickedValue()));
					myER.setEnabledTorF(false);
			}
			else{
				myER.setEnabledTorF(false);
			}
		}
		
	}
	
}
