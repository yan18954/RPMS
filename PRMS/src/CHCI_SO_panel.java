import javax.swing.*;
import java.awt.*;
//�H�����ʼh���O
//CHCI_SO_panel: Class HumanComputerInteraction_ShowOrder_panel (�H������-[����I�\]�ާ@�e�����O)
public class CHCI_SO_panel extends JPanel{
	CHCI_SOI_panel mySOI_panel=new CHCI_SOI_panel();	//����\�I��T��������(��JPanel,���t����,��r���,���s��)
	CHCI_SPI_panel mySPI_panel=new CHCI_SPI_panel();	//��ܥI�ڸ�T��������(��JPanel,���t����,��r���,���s��)

	CHCI_SO_panel(){
		add(mySOI_panel);
		add(mySPI_panel);
		

        setBackground(new Color(162, 225, 226));
        setLocation(0,100);
        setSize(500,600);
        setLayout(null);
        setVisible(true);		
	}
}
