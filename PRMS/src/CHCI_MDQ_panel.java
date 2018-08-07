import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
//人機互動層類別
//CHCI_MDQ_panel: Class HumanComputerInteraction_ManageDealsQuery_panel (人機介面-[管理餐點查詢]操作畫面類別)
public class CHCI_MDQ_panel extends JPanel{
	CHCI_QD_panel myQD_pane=new CHCI_QD_panel();  	 //查詢交易類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_SDR_panel mySDR_pane=new CHCI_SDR_panel();     //顯示交易查詢結果類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)	
	CHCI_MDQ_panel(){
		myQD_pane.quertbtn.addActionListener(SelectEvent);
		
	    add(myQD_pane);				//將[查詢餐點介面物件]加到此視窗中
	    add(mySDR_pane);	    	//將[顯示查詢結果介面物件]加到此視窗中
		setBackground(Color.blue);
	    setBounds(0,0,500,600);
	    setLayout(null);
	}
	public ActionListener SelectEvent = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == myQD_pane.quertbtn){
					if(!myQD_pane.getKeyin().equals("")){
						mySDR_pane.Query_addDate(myQD_pane.get_Selected_qr(), myQD_pane.getKeyin());
					}
					else{
						mySDR_pane.Query_addDate("TRANS_no", "%");
					}
			}
		}
	};
	
	
}
