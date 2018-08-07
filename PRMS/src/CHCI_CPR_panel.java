import java.awt.Color;
import java.awt.Font;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//人機互動層類別
//CHCI_MMAO_panel: Class HumanComputerInteraction_PurchaseReport_panel (人機介面-[產生採購報表]操作畫面類別)
public class CHCI_CPR_panel extends JPanel{
	JPanel pane1=new JPanel();
	
	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("產生採購報表：");
	JLabel lbl1=new JLabel("起始日");
	JLabel lbl2=new JLabel("  至     ");
    pickdate_panel d1=new pickdate_panel();
    pickdate_panel d2=new pickdate_panel();
	JButton exportbtn=new JButton("匯出");
	JButton clearbtn=new JButton("清除");

	
	CHCI_CPR_panel() {
		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("正黑體",1,20));	
		add(titlelbl);
		
		pane1.setBounds(0,0, 1000, 600);
		add(pane1);

		//起始日期設置
        lbl1.setBounds(15,45,50,45);
		lbl1.setFont(new Font("正黑體",1,15));	
		pane1.add(lbl1);
		d1.setBounds(90,52,200,45);
		pane1.add(d1);
		//結束日期設置
        lbl2.setBounds(40,90,50,45);
		lbl2.setFont(new Font("正黑體",1,16));	
		pane1.add(lbl2);
		d2.setBounds(90,97,200,45);
		pane1.add(d2);
		//按鈕設置
		exportbtn.setBounds(300,50,80,80);
		exportbtn.setFont(new Font("正黑體",1,16));	
        exportbtn.setBorderPainted(false);
		exportbtn.setBackground(Color.orange);
		pane1.add(exportbtn);
		clearbtn.setBounds(390,50,80,80);
		clearbtn.setFont(new Font("正黑體",1,16));	
        clearbtn.setBorderPainted(false);
		clearbtn.setBackground(Color.pink);

		pane1.add(clearbtn);
		pane1.setLayout(null);
		pane1.setBackground(new Color(255, 242, 179));
        setBounds(0,100,1000,600);
        setLayout(null);
	}
	
	 //事件傾聽程式: 清除輸入欄位
	 //事件傾聽程式: 檢查結束日期是否大於起始日期 
}
