import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
//�H�����ʼh���O
//CHCI_MDQ_panel: Class HumanComputerInteraction_ManageDealsQuery_panel (�H������-[�޲z�\�I�d��]�ާ@�e�����O)
public class CHCI_MDQ_panel extends JPanel{
	CHCI_QD_panel myQD_pane=new CHCI_QD_panel();  	 //�d�ߥ�����O��������(��JPanel,���t����,��r���,���s��)
	CHCI_SDR_panel mySDR_pane=new CHCI_SDR_panel();     //��ܥ���d�ߵ��G���O��������(��JPanel,���t����,��r���,���s��)	
	CHCI_MDQ_panel(){
		myQD_pane.quertbtn.addActionListener(SelectEvent);
		
	    add(myQD_pane);				//�N[�d���\�I��������]�[�즹������
	    add(mySDR_pane);	    	//�N[��ܬd�ߵ��G��������]�[�즹������
		setBackground(Color.blue);
	    setBounds(0,0,500,600);
	    setLayout(null);
	}
	public ActionListener SelectEvent = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == myQD_pane.quertbtn){
					if(!myQD_pane.getKeyin().equals("")){
						mySDR_pane.Query_addDate(myQD_pane.get_Selected_qr(), myQD_pane.getKeyin());
					}
					else{
						mySDR_pane.Query_addDate("TRANS_no", "%");
					}
			}
		}
	};
	
	
}
