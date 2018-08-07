import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Scrollable;
import javax.swing.table.DefaultTableModel;

//人機互動層類別
//CHCI_SSRM_panel: Class HumanComputerInteraction_ShowPurchaseResult_panel (人機介面-[顯示採購訂單查詢結果]操作畫面類別)
public class CHCI_SPR_panel extends JPanel implements ActionListener, MouseListener{	
	//Create elements
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ArrayList<ArrayList<String>> Alist_order = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> Alist_cl = new ArrayList<ArrayList<String>>();
	String[] Data = new String[5];
	
	JTable OrderTabShow = new JTable();	//顯示訂單訊息		
	JTable OrderListTabShow = new JTable();	//顯示訂單訊息		
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{{},{},{},{},{},{},{},{},{},{},{},{},{},{}},new Object[]{"訂單編號","日期","狀態","廠商","聯絡人","電話","總金額"});
	DefaultTableModel tm2 = new DefaultTableModel(new Object[][]{{},{},{},{},{},{},{},{},{},{},{},{},{},{}},new Object[]{"訂單編號","物料","單價","數量","進貨日期","總金額"});
	
	//讓tableA加入捲動軸，這是物件位置需設在捲動軸(tableA設定位置無效)
	JScrollPane Scroll = new JScrollPane(OrderTabShow,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	//讓tableA加入捲動軸，這是物件位置需設在捲動軸(tableA設定位置無效)
	JScrollPane Scroll2 = new JScrollPane(OrderListTabShow,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	//constructor
	CHCI_SPR_panel(){
		setBackground(new Color(156, 201, 222));
	    setBounds(0,100,500,500);
	    setLayout(null);
		setOrderTabShow();
		setOrderListTabShow();
		setVisible(true);
		
		//Query_addDate("ORDER_no","%");	//jtable 程式開始時即顯示出全部order訂單
	}
	private void setOrderTabShow(){
		OrderTabShow.setRowHeight(33);
		OrderTabShow.setModel(tm);	//指定tm作為tableA的model
		OrderTabShow.addMouseListener(this); 	//增加滑鼠事件


		Scroll.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll.setFont(new Font("正黑體",1,14));
		//若要實現背景透明，則需設置Scroll以及Scroll的顯示面板，如下
		Scroll.setOpaque(false);
		Scroll.getViewport().setOpaque(false);
		
		this.add(Scroll);
	}
	
	private void setOrderListTabShow(){
		OrderListTabShow.setRowHeight(33);
		OrderListTabShow.setModel(tm2);	//指定tm作為tableA的model
		OrderListTabShow.addMouseListener(this); 	//增加滑鼠事件


		Scroll2.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll2.setFont(new Font("正黑體",1,14));
		//若要實現背景透明，則需設置Scroll以及Scroll的顯示面板，如下
		Scroll2.setOpaque(false);
		Scroll2.getViewport().setOpaque(false);
		
		Scroll2.setVisible(false);
		this.add(Scroll2);
	}
	
	public void Query_addDate(String sel_rq,String rq){
		Alist_order = dbma.findRD_in_TB_order(sel_rq,rq);       //查詢
		tm.setRowCount(0);      //清除上次資料
		
		for(int i=0; i<Alist_order.get(0).size();i++){
				String[] data_cl = new String[3];	//儲存CL表單 CL_company,CL_contact,CL_contactphone
				data_cl = dbma.findRD_in_TB_Cldata(Alist_order.get(3).get(i));
				
				tm.addRow(new Object[]{Alist_order.get(0).get(i),Alist_order.get(1).get(i),data_cl[0],data_cl[1],data_cl[2],Alist_order.get(4).get(i)}); //新增table顯示
		}		
		//調用DefaultTableModel的fireTableDataChanged方法可做model刷新
		tm.fireTableDataChanged();
		OrderTabShow.updateUI();	
	}
	
	public  String rtnSelectedId(){
	    String aId = (String) OrderTabShow.getValueAt(OrderTabShow.getSelectedRow(),0);
	   // System.out.println("rtn ID = "+aId);
		return aId;
	}
	
	public void ShowOrderTable(){
		Scroll.setVisible(true);
		Scroll2.setVisible(false);
	}
	
	public void ShowOrderListTable(){
		Scroll.setVisible(false);
		Scroll2.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e){		//點擊查詢
		if(e.getClickCount()==1){
			Data = dbma.findRD_in_TB_orderDetail(rtnSelectedId());
			CHCI_MMA_panel.setOrderData(Data);
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
