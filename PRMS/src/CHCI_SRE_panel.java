import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//人機互動層類別
//CHCI_SR_panel: Class HumanComputerInteraction_ShowResult_panel (人機介面-[顯示查詢結果]操作畫面類別)
public class CHCI_SRE_panel extends JPanel{
	//JTable queryTable = new JTable();		//JTable：用來顯示已新增預約
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{},new Object[]{"姓名","電話","日期","時間"});
	JTable queryTable=new JTable(tm){
	     public boolean isCellEditable(int row, int column) {
	     return false;
	 }
};
	CHCI_SRE_panel(){

		setBackground(new Color(156, 201, 222));
	    setBounds(0,100,500,500);
	    setLayout(null);
		setqueryTable();
		setVisible(true);
	}
	
	private void setqueryTable(){
		queryTable.setRowHeight(40);
		queryTable.setModel(tm);	//指定tm作為tableA的model
		//讓tableA加入捲動軸，這是物件位置需設在捲動軸(tableA設定位置無效)
		JScrollPane Scroll = new JScrollPane(queryTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Scroll.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll.setFont(new Font("正黑體",1,14));
		//若要實現背景透明，則需設置Scroll以及Scroll的顯示面板，如下
		Scroll.setOpaque(false);
		Scroll.getViewport().setOpaque(false);
		this.add(Scroll);
	}
		
}