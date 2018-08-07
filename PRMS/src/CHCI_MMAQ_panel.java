import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CHCI_MMAQ_panel extends JPanel implements ActionListener{
	CHCI_QP_panel myQP_pane=new CHCI_QP_panel();  	      //�d�߱��ʭq�����O��������(��JPanel,���t����,��r���,���s��)
	CHCI_SPR_panel mySPR_pane=new CHCI_SPR_panel();       //��ܭq��d�ߵ��G���O��������(��JPanel,���t����,��r���,���s��)	
	CHCI_SPR_panel mySPLR_pane=new CHCI_SPR_panel();       //��ܭq��Ӹ`�d�ߵ��G���O��������(��JPanel,���t����,��r���,���s��)	
	CHCI_QMA_panel myQMA_pane=new CHCI_QMA_panel();       //�d�ߪ������O��������(��JPanel,���t����,��r���,���s��)	
	CHCI_SMAR_panel mySMAR_pane=new CHCI_SMAR_panel();    //��ܪ��Ƭd�ߵ��G���O��������(��JPanel,���t����,��r���,���s��)	
	CHCI_QCO_panel myQCO_pane=new CHCI_QCO_panel();       //�d�߼t�Ӥ�������(��JPanel,���t����,��r���,���s��)	
	CHCI_SCO_panel mySCO_pane=new CHCI_SCO_panel();    //��ܼt�Ӭd�ߵ��G���O��������(��JPanel,���t����,��r���,���s��)	
	CHCI_MMAQ_panel(){
		myQP_pane.BtnSearch.addActionListener(this);
		myQMA_pane.BtnSearch.addActionListener(this);
		myQCO_pane.BtnSearch.addActionListener(this);
		

		
	    add(myQP_pane);			//�N[�d�߭q�椶������]�[�즹������
	    add(mySPR_pane);	   	//�N[��ܭq��d�ߵ��G��������]�[�즹������
	    add(mySPLR_pane);
	    add(myQMA_pane);	   	//�N[�d�ߪ��ƭq�����O��������]�[�즹������
	    add(mySMAR_pane);	   	//�N[��ܪ��Ƭd�ߵ��G���O��������]�[�즹������   
	    add(myQCO_pane);	   	//�N[�d�߼t�����O��������]�[�즹������
	    add(mySCO_pane);	   	//�N[�d�߼t�����O��������]�[�즹������   
	    
	    myQMA_pane.setVisible(false);	//�N[�d�ߪ��ƭq�����O��������]�w�]������
	    mySMAR_pane.setVisible(false);  //�N[��ܪ��Ƭd�ߵ��G���O��������]�w�]������ 
	    myQCO_pane.setVisible(false);	//�N[�d�߼t�ӭq�����O��������]�w�]������
	    mySCO_pane.setVisible(false);   //�N[��ܼt�Ӭd�ߵ��G���O��������]�w�]������   
	    
		setBackground(Color.blue);
	    setBounds(0,0,500,600);
	    setLayout(null);
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO �۰ʲ��ͪ���k Stub
//		if(e.getSource() == myQP_pane.BtnSearch){
//			if(!myQP_pane.getKeyin().equals("")){
//				mySPR_pane.Query_addDate(myQP_pane.get_Selected_qr(), myQP_pane.getKeyin());
//			}
//			else{
//				showError();
//			}
//		}
//		if(e.getSource() == myQMA_pane.BtnSearch){
//			if (!myQMA_pane.getKeyin().equals("")) {
//				mySMAR_pane.Query_addDate(myQMA_pane.get_Selected_qr(), myQMA_pane.getKeyin());	
//			}
//			else{
//				showError();
//			}
//		}
//		if (e.getSource() == myQCO_pane.BtnSearch) {
//			if (!myQCO_pane.getKeyin().equals("")) {
//				mySCO_pane.Query_addDate(myQCO_pane.get_Selected_qr(), myQCO_pane.getKeyin());	
//			}
//			else{
//				showError();
//			}
//		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �۰ʲ��ͪ���k Stub
			if(e.getSource() == myQP_pane.BtnSearch){
				if(!myQP_pane.getKeyin().equals("")){
					mySPR_pane.Query_addDate(myQP_pane.get_Selected_qr(), myQP_pane.getKeyin());
				}
				else{
					mySPR_pane.Query_addDate("ORDER_no", "%");
				}
			}
			if(e.getSource() == myQMA_pane.BtnSearch){
				if (!myQMA_pane.getKeyin().equals("")) {
					mySMAR_pane.Query_addDate(myQMA_pane.get_Selected_qr(), myQMA_pane.getKeyin());	
				}
				else{
					mySMAR_pane.Query_addDate("MI_no", "%");	
				}
			}
			if (e.getSource() == myQCO_pane.BtnSearch) {
				if (!myQCO_pane.getKeyin().equals("")) {
					mySCO_pane.Query_addDate(myQCO_pane.get_Selected_qr(), myQCO_pane.getKeyin());	
				}
				else{
					mySCO_pane.Query_addDate("CL_no", "%");	
				}
			}
		

	}
	private  void showError() {
		JOptionPane.showMessageDialog(null, "�п�J�d�߸��");
	}
}
