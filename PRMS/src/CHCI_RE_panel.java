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
//�H�����ʼh���O
//CHCI_OR_panel: Class HumanComputerInteraction_REserve_panel (�H������-[�q��w��]�ާ@�e�����O)
public class CHCI_RE_panel extends JPanel implements ActionListener, MouseListener{
		
	ArrayList<ArrayList<String>> Alist = new ArrayList<ArrayList<String>>();  //�G���ʺA�}�C
	//String[] receiveData = new String[9];
	//���b��
	JPanel pane1 = new JPanel();
	CHCI_QR_panel myQR=new CHCI_QR_panel();
	CHCI_SRE_panel mySRE=new CHCI_SRE_panel();
	//�k�b��
	JPanel pane2 = new JPanel();
	CHCI_AR_panel myAR=new CHCI_AR_panel();
	CHCI_ER_panel myER=new CHCI_ER_panel();
		//�k�b���W��\����
	CHCI_REmenu_panel myREmenu=new CHCI_REmenu_panel();
	
	

	CHCI_RE_panel(){

		
		setQR();
		setER();
 		setSRE();
		setREmenu();
		
		pane1 = new JPanel();    //����e��
		pane1.setBounds(0,0,500,600);
		pane1.setBackground(Color.yellow);
		pane1.setLayout(null);
		add(pane1);
		pane1.add(myQR);//�[�J�d�߱���
		pane1.add(mySRE);//�[�J�d�ߵ��G
		
				
		
		pane2 = new JPanel();       //�k��e��
		pane2.setBounds(500,0,500,600);
		pane2.setBackground(new Color(174, 184, 249));
		pane2.setLayout(null);
		add(pane2);
		pane2.add(myREmenu);	//[�\��ﶵ����]
		pane2.add(myAR);		//[�s�W�w������]
		pane2.add(myER);		//[�ק�w������]
		myER.setVisible(false);	//�N[�ק�w������]����
		
		
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
			System.out.printf("���U�w���d�M\n");
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
			System.out.printf("���U�w���ק�\n");
			updateRes();
		}
		
		if(e.getSource()== myER.clearbtn){    //���U����
			myER.setVisible(false);
			myAR.setVisible(true);
			myREmenu.revresbtn.setEnabled(false);
		}
		
	}
	
	
	
	public void Query_addDate(){        //�d�߹w������ܸѪG�bjtable�W
		Alist = myAR.dbma.findRD_in_TB_res(myQR.getSelectedQRStr(),myQR.cond1txt.getText());       //�d��
		mySRE.tm.setRowCount(0);      //�M���W�����
		
		for(int i=0; i<Alist.get(0).size();i++){
				mySRE.tm.addRow(new Object[]{Alist.get(0).get(i),Alist.get(1).get(i),Alist.get(2).get(i),Alist.get(3).get(i)}); //�s�Wtable���
			}			
		//�ե�DefaultTableModel��fireTableDataChanged��k�i��model��s
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
			//JOptionPane.showMessageDialog(null,"�d�ߦ��\!");
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
			if(JOptionPane.showConfirmDialog(null,"�T�w�n�ק�w����ƶ�?","�T�{�ק�w��",JOptionPane.OK_CANCEL_OPTION) == 0){
					myAR.dbma.updateRD_in_TB_res(getClickedValue(), myER.getResData(getClickedValue()));
					myER.setEnabledTorF(false);
			}
			else{
				myER.setEnabledTorF(false);
			}
		}
		
	}
	
}
