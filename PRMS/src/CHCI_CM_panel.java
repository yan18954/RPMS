 import javax.swing.*;
 import java.awt.*;

public class CHCI_CM_panel extends JPanel{
	JPanel logo_panel =new JPanel();						//�t logo����
	CHCI_OM_panel myOM_pane =new CHCI_OM_panel();			//�I���\�U��椶������(��JPanel,���t����,��r���,���s��)
	CHCI_CNSI_panel myCNSI_pane =new CHCI_CNSI_panel();		//�p��ƶq�P��ܸ�T��������(��JPanel,���t����,��r���,���s��)	
	JLabel logo = new JLabel(new ImageIcon(getClass().getResource("menu.png")));	

	
	CHCI_CM_panel (){
		add(myOM_pane);
		add(myCNSI_pane);	
		setLayout(null);
		setBackground(Color.black);
		logo.setBounds(0, 0, 700, 100);
		//logo_panel.setBackground(Color.pink);
		logo_panel.setBounds(0, 0, 700, 100);	
		logo_panel.setLayout(null);
		add(logo_panel);
		logo_panel.add(logo);
		

		

	}
}
