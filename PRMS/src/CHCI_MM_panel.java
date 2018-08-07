import javax.swing.JPanel;
import java.awt.*;
//人機互動層類別
//CHCI_MM_panel: Class HumanComputerInteraction_ManageMeals_panel (人機介面-[管理餐點]操作畫面類別)
public class CHCI_MM_panel extends JPanel{
	CHCI_MMO_panel myMMO_pane=new CHCI_MMO_panel();  //管理餐點操作介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_MMQ_panel myMMQ_pane=new CHCI_MMQ_panel();	 //管理餐點查詢介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_MM_panel(){
		add(myMMO_pane);
		add(myMMQ_pane);
        setBackground(Color.yellow);
        setBounds(0,100,1000,600);
        setLayout(null);
	}

}
