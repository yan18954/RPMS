import javax.swing.*;
import java.awt.*;
//人機互動層類別
//CHCI_SO_panel: Class HumanComputerInteraction_ShowOrder_panel (人機介面-[顯示點餐]操作畫面類別)
public class CHCI_SO_panel extends JPanel{
	CHCI_SOI_panel mySOI_panel=new CHCI_SOI_panel();	//顯示餐點資訊介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_SPI_panel mySPI_panel=new CHCI_SPI_panel();	//顯示付款資訊介面物件(為JPanel,內含標籤,文字欄位,按鈕等)

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
