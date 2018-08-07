import java.awt.Color;
import javax.swing.*;

public class CHCI_CM_frame extends JFrame{
	CHCI_CM_panel  myCM_pane = new CHCI_CM_panel();			//選擇餐點介面物件(為JPanel,內含標籤,文字欄位,按鈕等) 
	boolean isOpen=false;
	public CHCI_CM_frame(){
		myCM_pane.setBounds(0,0,1000,700);
		add(myCM_pane);

        setTitle("選擇餐點介面-CMI(ChoseMealsInterface)");
        setBounds(0,0,1000,700);   
        setLocationRelativeTo(null);//畫面置中        
        setLayout(null);
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}
