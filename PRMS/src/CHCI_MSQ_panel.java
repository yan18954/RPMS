import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CHCI_MSQ_panel extends JPanel implements ActionListener{
	CHCI_QS_panel myQS_pane=new CHCI_QS_panel();      //�d�߭��u���O��������(��JPanel,���t����,��r���,���s��)
	CHCI_SSR_panel mySSR_pane=new CHCI_SSR_panel();     //��ܭ��u�d�ߵ��G���O��������(��JPanel,���t����,��r���,���s��)	
	CHCI_MSQ_panel(){
	    add(myQS_pane);			//�N[�d���\�I��������]�[�즹������
	    add(mySSR_pane);	    	//�N[��ܬd�ߵ��G��������]�[�즹������
	    
	    
	    set_myQS();
	    
    
		setBackground(Color.blue);
	    setBounds(0,0,500,600);
	    setLayout(null);
	}
	
	private void set_myQS(){
		myQS_pane.quertbtn.addActionListener(this);
		
	}
	
	private void set_mySSR(){
		
	}
	
	public boolean myStaffQuery(){
		if(!myQS_pane.get_cond1txt().equals("")){
			mySSR_pane.Query_addDate(myQS_pane.get_selelected_qr(),myQS_pane.get_cond1txt());
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null,"�п�J�d�߸��!");
			return false;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
