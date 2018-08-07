import javax.swing.*;
import java.awt.*;
import javax.swing.table.*; 
//人機互動層類別
//CHCI_SOI_panel: Class HumanComputerInteraction_ShowOrderedInformation_panel (人機介面-[顯示已選擇餐點資訊]操作畫面類別)
public class CHCI_SOI_panel extends JPanel{
	JTable orderTable = new JTable();		//JTable：用來顯示已點選餐點訊息
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{},new Object[]{"餐點名稱","分類","單價","數量","小計"});
	//加入捲動軸，這是物件位置需設在捲動軸
	JScrollPane Scroll = new JScrollPane(orderTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	JLabel bg=new JLabel();
	JPanel tbpanel=new JPanel();
	CHCI_SOI_panel(){
		bg.setBounds(0,0,500,360);
		bg.setIcon(new ImageIcon(getClass().getResource("bg.jpg")));
		tbpanel.setBounds(0, 0, 500, 360);	
		tbpanel.setLayout(null);
		tbpanel.setVisible(true);
		tbpanel.setOpaque(false);
		this.add(tbpanel, new Integer(1), 0);
		this.add(bg);
		setBackground(new Color(255, 0, 0));
		setBounds(0, 0, 500, 360);	
		setLayout(null);
		setorderTable();	//呼叫setorderTable()
		setVisible(true);
	}
	
	private void setorderTable(){
		orderTable.setRowHeight(40);
		orderTable.setModel(tm);	//指定tm作為tableA的model

		Scroll.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll.setFont(new Font("正黑體",1,14));
		//若要實現背景透明，則需設置Scroll以及Scroll的顯示面板，如下
		Scroll.setOpaque(false);
		Scroll.getViewport().setOpaque(false);
		tbpanel.add(Scroll);
	}
}
