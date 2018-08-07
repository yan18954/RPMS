 import javax.swing.*;
 import java.awt.*;

public class CHCI_CM_panel extends JPanel{
	JPanel logo_panel =new JPanel();						//含 logo標籤
	CHCI_OM_panel myOM_pane =new CHCI_OM_panel();			//點選餐廳菜單介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_CNSI_panel myCNSI_pane =new CHCI_CNSI_panel();		//計算數量與顯示資訊介面物件(為JPanel,內含標籤,文字欄位,按鈕等)	
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
