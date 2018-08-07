import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

//人機互動層類別
//CHCI_MS_panel: Class HumanComputerInteraction_ManageDeal_panel (人機介面-[管理交易]操作畫面類別)
public class CHCI_MD_panel extends JPanel{
	ArrayList<String> tdList = new ArrayList<String>();
	static CDM_BS_dbma dbma = new CDM_BS_dbma();
	static CHCI_MDO_panel myMDO_pane=new CHCI_MDO_panel();  //管理交易操作介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	static CHCI_MDQ_panel myMDQ_pane=new CHCI_MDQ_panel();	 //管理交易查詢介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_MD_panel(){
		add(myMDO_pane);
		add(myMDQ_pane);
        setBackground(Color.yellow);
        setBounds(0,100,1000,600);
        setLayout(null);
	}
	
	public static void setTransData(String no){		//SDR使用
		myMDO_pane.myED_pane.Query_addDate(dbma.findRD_in_TB_td(no),no);
	}
}
