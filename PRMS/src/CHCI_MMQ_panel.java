import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//�H�����ʼh���O
//CHCI_MMQ_panel: Class HumanComputerInteraction_ManageMealsQuery_panel (�H������-[�޲z�\�I�d��]�ާ@�e�����O)
public class CHCI_MMQ_panel extends JPanel{
	CHCI_QM_panel myQM_pane=new CHCI_QM_panel();  	 //�d���\�I���O��������(��JPanel,���t����,��r���,���s��)
	CHCI_SR_panel mySR_pane=new CHCI_SR_panel();     //��ܬd�ߵ��G���O��������(��JPanel,���t����,��r���,���s��)	
	
	CHCI_MMQ_panel(){
		myQM_pane.kindradio[0].addActionListener(ProcessFunSelection);
		myQM_pane.kindradio[1].addActionListener(ProcessFunSelection);
	    add(myQM_pane);			//�N[�d���\�I��������]�[�즹������
	    add(mySR_pane);	    	//�N[��ܬd�ߵ��G��������]�[�즹������
		setBackground(Color.blue);
	    setBounds(0,0,500,600);
	    setLayout(null);
	}
    //�ƥ��ť�{��: �B�z�\����
    public ActionListener ProcessFunSelection = new ActionListener(){
        public void actionPerformed(ActionEvent e){
       	 if(e.getSource()== myQM_pane.kindradio[0]){ //��"�d�����O"�Q���
       		 //�d�ߵ��G���
       		mySR_pane.setqueryTable();

       	 }
       	 if(e.getSource()== myQM_pane.kindradio[1]){ //��"�d���\�I"�Q���
       		 //�d�ߵ��G���
       		mySR_pane.setquery2Table();
       	 }

        }
    };
}
