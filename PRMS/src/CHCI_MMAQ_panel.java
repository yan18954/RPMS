import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CHCI_MMAQ_panel extends JPanel implements ActionListener{
	CHCI_QP_panel myQP_pane=new CHCI_QP_panel();  	      //查詢採購訂單類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_SPR_panel mySPR_pane=new CHCI_SPR_panel();       //顯示訂單查詢結果類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)	
	CHCI_SPR_panel mySPLR_pane=new CHCI_SPR_panel();       //顯示訂單細節查詢結果類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)	
	CHCI_QMA_panel myQMA_pane=new CHCI_QMA_panel();       //查詢物料類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)	
	CHCI_SMAR_panel mySMAR_pane=new CHCI_SMAR_panel();    //顯示物料查詢結果類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)	
	CHCI_QCO_panel myQCO_pane=new CHCI_QCO_panel();       //查詢廠商介面物件(為JPanel,內含標籤,文字欄位,按鈕等)	
	CHCI_SCO_panel mySCO_pane=new CHCI_SCO_panel();    //顯示廠商查詢結果類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)	
	CHCI_MMAQ_panel(){
		myQP_pane.BtnSearch.addActionListener(this);
		myQMA_pane.BtnSearch.addActionListener(this);
		myQCO_pane.BtnSearch.addActionListener(this);
		

		
	    add(myQP_pane);			//將[查詢訂單介面物件]加到此視窗中
	    add(mySPR_pane);	   	//將[顯示訂單查詢結果介面物件]加到此視窗中
	    add(mySPLR_pane);
	    add(myQMA_pane);	   	//將[查詢物料訂單類別介面物件]加到此視窗中
	    add(mySMAR_pane);	   	//將[顯示物料查詢結果類別介面物件]加到此視窗中   
	    add(myQCO_pane);	   	//將[查詢廠商類別介面物件]加到此視窗中
	    add(mySCO_pane);	   	//將[查詢廠商類別介面物件]加到此視窗中   
	    
	    myQMA_pane.setVisible(false);	//將[查詢物料訂單類別介面物件]預設為隱藏
	    mySMAR_pane.setVisible(false);  //將[顯示物料查詢結果類別介面物件]預設為隱藏 
	    myQCO_pane.setVisible(false);	//將[查詢廠商訂單類別介面物件]預設為隱藏
	    mySCO_pane.setVisible(false);   //將[顯示廠商查詢結果類別介面物件]預設為隱藏   
	    
		setBackground(Color.blue);
	    setBounds(0,0,500,600);
	    setLayout(null);
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO 自動產生的方法 Stub
//		if(e.getSource() == myQP_pane.BtnSearch){
//			if(!myQP_pane.getKeyin().equals("")){
//				mySPR_pane.Query_addDate(myQP_pane.get_Selected_qr(), myQP_pane.getKeyin());
//			}
//			else{
//				showError();
//			}
//		}
//		if(e.getSource() == myQMA_pane.BtnSearch){
//			if (!myQMA_pane.getKeyin().equals("")) {
//				mySMAR_pane.Query_addDate(myQMA_pane.get_Selected_qr(), myQMA_pane.getKeyin());	
//			}
//			else{
//				showError();
//			}
//		}
//		if (e.getSource() == myQCO_pane.BtnSearch) {
//			if (!myQCO_pane.getKeyin().equals("")) {
//				mySCO_pane.Query_addDate(myQCO_pane.get_Selected_qr(), myQCO_pane.getKeyin());	
//			}
//			else{
//				showError();
//			}
//		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動產生的方法 Stub
			if(e.getSource() == myQP_pane.BtnSearch){
				if(!myQP_pane.getKeyin().equals("")){
					mySPR_pane.Query_addDate(myQP_pane.get_Selected_qr(), myQP_pane.getKeyin());
				}
				else{
					mySPR_pane.Query_addDate("ORDER_no", "%");
				}
			}
			if(e.getSource() == myQMA_pane.BtnSearch){
				if (!myQMA_pane.getKeyin().equals("")) {
					mySMAR_pane.Query_addDate(myQMA_pane.get_Selected_qr(), myQMA_pane.getKeyin());	
				}
				else{
					mySMAR_pane.Query_addDate("MI_no", "%");	
				}
			}
			if (e.getSource() == myQCO_pane.BtnSearch) {
				if (!myQCO_pane.getKeyin().equals("")) {
					mySCO_pane.Query_addDate(myQCO_pane.get_Selected_qr(), myQCO_pane.getKeyin());	
				}
				else{
					mySCO_pane.Query_addDate("CL_no", "%");	
				}
			}
		

	}
	private  void showError() {
		JOptionPane.showMessageDialog(null, "請輸入查詢資料");
	}
}
