import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
//人機互動層類別
//CHCI_SR_panel: Class HumanComputerInteraction_ShowResult_panel (人機介面-[顯示查詢結果]操作畫面類別)
public class CHCI_SR_panel extends JPanel{
	JTable queryTable = new JTable();		//JTable：用來顯示已點選餐點訊息
	JTable query2Table = new JTable();		//JTable：用來顯示已點選餐點訊息

	DefaultTableModel tm = new DefaultTableModel(new Object[][]{},new Object[]{"類別編號","建立日期","類別名稱","類別分類","類別狀態","備註"});
	DefaultTableModel tm2 = new DefaultTableModel(new Object[][]{},new Object[]{"餐點編號","餐點名稱","餐點類別","建立日期","餐點物料","單價","餐點狀態","物料分類","餐點分類"});
	
	//讓tableA加入捲動軸，這是物件位置需設在捲動軸(tableA設定位置無效)
	JScrollPane Scroll = new JScrollPane(queryTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	//讓tableA加入捲動軸，這是物件位置需設在捲動軸(tableA設定位置無效)
	JScrollPane Scroll2 = new JScrollPane(query2Table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	boolean selected=false;					//boolean:判斷Jtable是否被選取
	String[] class_info=new String[6];
	String trmp_type;
	CHCI_SR_panel(){
		setBackground(new Color(156, 201, 222));
	    setBounds(0,100,500,500);
	    setLayout(null);
	    setqueryTable();
		setVisible(true);
	}
	
	protected void setqueryTable(){
		Scroll2.setVisible(false);
		Scroll.setVisible(true);
		queryTable.setRowHeight(40);
		queryTable.setModel(tm);	//指定tm作為tableA的model
		queryTable.getTableHeader().setReorderingAllowed(false);	//將JTable欄位設為不可拖曳
		Scroll.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll.setFont(new Font("正黑體",1,14));
		Scroll.setOpaque(false);
		Scroll.getViewport().setOpaque(false);
		this.add(Scroll);
	}
	protected void setquery2Table(){
		Scroll.setVisible(false);
		Scroll2.setVisible(true);
		query2Table.setRowHeight(40);
		query2Table.setModel(tm2);	//指定tm作為tableA的model
		query2Table.getTableHeader().setReorderingAllowed(false);	//將JTable欄位設為不可拖曳
		Scroll2.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll2.setFont(new Font("正黑體",1,14));
		Scroll2.setOpaque(false);
		Scroll2.getViewport().setOpaque(false);
		this.add(Scroll2);
	}


}
