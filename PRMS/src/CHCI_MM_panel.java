import javax.swing.JPanel;
import java.awt.*;
//�H�����ʼh���O
//CHCI_MM_panel: Class HumanComputerInteraction_ManageMeals_panel (�H������-[�޲z�\�I]�ާ@�e�����O)
public class CHCI_MM_panel extends JPanel{
	CHCI_MMO_panel myMMO_pane=new CHCI_MMO_panel();  //�޲z�\�I�ާ@��������(��JPanel,���t����,��r���,���s��)
	CHCI_MMQ_panel myMMQ_pane=new CHCI_MMQ_panel();	 //�޲z�\�I�d�ߤ�������(��JPanel,���t����,��r���,���s��)
	CHCI_MM_panel(){
		add(myMMO_pane);
		add(myMMQ_pane);
        setBackground(Color.yellow);
        setBounds(0,100,1000,600);
        setLayout(null);
	}

}
