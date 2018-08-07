import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//人機互動層類別
//CHCI_MMQ_panel: Class HumanComputerInteraction_ManageMealsQuery_panel (人機介面-[管理餐點查詢]操作畫面類別)
public class CHCI_MMQ_panel extends JPanel{
	CHCI_QM_panel myQM_pane=new CHCI_QM_panel();  	 //查詢餐點類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_SR_panel mySR_pane=new CHCI_SR_panel();     //顯示查詢結果類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)	
	
	CHCI_MMQ_panel(){
		myQM_pane.kindradio[0].addActionListener(ProcessFunSelection);
		myQM_pane.kindradio[1].addActionListener(ProcessFunSelection);
	    add(myQM_pane);			//將[查詢餐點介面物件]加到此視窗中
	    add(mySR_pane);	    	//將[顯示查詢結果介面物件]加到此視窗中
		setBackground(Color.blue);
	    setBounds(0,0,500,600);
	    setLayout(null);
	}
    //事件傾聽程式: 處理功能選按
    public ActionListener ProcessFunSelection = new ActionListener(){
        public void actionPerformed(ActionEvent e){
       	 if(e.getSource()== myQM_pane.kindradio[0]){ //當"查詢類別"被選案
       		 //查詢結果表單
       		mySR_pane.setqueryTable();

       	 }
       	 if(e.getSource()== myQM_pane.kindradio[1]){ //當"查詢餐點"被選案
       		 //查詢結果表單
       		mySR_pane.setquery2Table();
       	 }

        }
    };
}
