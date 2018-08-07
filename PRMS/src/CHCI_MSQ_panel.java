import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CHCI_MSQ_panel extends JPanel implements ActionListener{
	CHCI_QS_panel myQS_pane=new CHCI_QS_panel();      //查詢員工類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_SSR_panel mySSR_pane=new CHCI_SSR_panel();     //顯示員工查詢結果類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)	
	CHCI_MSQ_panel(){
	    add(myQS_pane);			//將[查詢餐點介面物件]加到此視窗中
	    add(mySSR_pane);	    	//將[顯示查詢結果介面物件]加到此視窗中
	    
	    
	    set_myQS();
	    
    
		setBackground(Color.blue);
	    setBounds(0,0,500,600);
	    setLayout(null);
	}
	
	private void set_myQS(){
		myQS_pane.quertbtn.addActionListener(this);
		
	}
	
	private void set_mySSR(){
		
	}
	
	public boolean myStaffQuery(){
		if(!myQS_pane.get_cond1txt().equals("")){
			mySSR_pane.Query_addDate(myQS_pane.get_selelected_qr(),myQS_pane.get_cond1txt());
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null,"請輸入查詢資料!");
			return false;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
