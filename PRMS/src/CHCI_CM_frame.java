import java.awt.Color;
import javax.swing.*;

public class CHCI_CM_frame extends JFrame{
	CHCI_CM_panel  myCM_pane = new CHCI_CM_panel();			//����\�I��������(��JPanel,���t����,��r���,���s��) 
	boolean isOpen=false;
	public CHCI_CM_frame(){
		myCM_pane.setBounds(0,0,1000,700);
		add(myCM_pane);

        setTitle("����\�I����-CMI(ChoseMealsInterface)");
        setBounds(0,0,1000,700);   
        setLocationRelativeTo(null);//�e���m��        
        setLayout(null);
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}
