import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//人機互動層類別
//CHCI_MSO_panel: Class HumanComputerInteraction_ManageDealOperation_panel (人機介面-[管理交易]操作畫面類別)
public class CHCI_MDO_panel extends JPanel{
	CHCI_ED_panel myED_pane=new CHCI_ED_panel(); 	 //編輯交易介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_CMD_panel myCMD_pane=new CHCI_CMD_panel();  //產生交易報表類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	JPanel mdbtn_panel =new JPanel();			  	 //JPanel：ManageDealsButton，含新編輯交易、產生交易報表按鈕
    JButton revstaffbtn = new JButton("編輯交易");
	JButton cdrfbtn = new JButton("產生交易報表");

	CHCI_MDO_panel(){
		add(myED_pane);	//將[編輯交易介面物件]加到此視窗中
		myED_pane.setVisible(true);
		add(myCMD_pane); //將[產生交易報表介面物件]加到此視窗中
		myCMD_pane.setVisible(false);	
		
		/*按鈕介面設置*/
		mdbtn_panel.setBounds(0,0,500,60);
		mdbtn_panel.setLayout(new FlowLayout());
		add(mdbtn_panel);				//將[功能按鈕介面物件]加到此視窗中
		
		revstaffbtn.setBounds(0,5,100,40);
		revstaffbtn.setBackground(Color.WHITE);
		revstaffbtn.setContentAreaFilled(false);
		revstaffbtn.setIcon(new ImageIcon(getClass().getResource("editdeal_icon.png")));
		revstaffbtn.setFont(new Font("正黑體",0,12));
		revstaffbtn.addActionListener(ProcessPaneChanged);	
	//	revstaffbtn.setEnabled(false);	//[編輯交易]預設不可點選
		mdbtn_panel.add(revstaffbtn);
				
		cdrfbtn.setBounds(120,5,110,60);
		cdrfbtn.setBackground(Color.WHITE);
		cdrfbtn.setContentAreaFilled(false);
		cdrfbtn.setIcon(new ImageIcon(getClass().getResource("exportdeal_icon.png")));
		cdrfbtn.setFont(new Font("正黑體",0,12));
		cdrfbtn.addActionListener(ProcessPaneChanged);		
		mdbtn_panel.add(cdrfbtn);

	    setBackground(new Color(227, 242, 239));
	    setBounds(500,0,500,600);
	    setLayout(null);		
	}
    public ActionListener ProcessPaneChanged = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(e.getSource() ==  revstaffbtn){
            	myED_pane.setVisible(true);        //顯示[編輯交易]操作畫面	  
            	myCMD_pane.setVisible(false);	   //隱藏[產生交易報表]操作畫面
            }     
            if(e.getSource() ==  cdrfbtn){
            	myCMD_pane.setVisible(true);	   //顯示[產生交易報表]操作畫面
            	myED_pane.setVisible(false);       //隱藏[[編輯交易]操作畫面	  
            }  
        }
    };
}
