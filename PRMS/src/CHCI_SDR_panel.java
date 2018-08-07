import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//人機互動層類別
//CHCI_SDR_panel: Class HumanComputerInteraction_ShowDealsResult_panel (人機介面-[顯示查詢結果]操作畫面類別)
public class CHCI_SDR_panel extends JPanel{
	//Create elements
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ArrayList<ArrayList<String>> Alist_trans = new ArrayList<ArrayList<String>>();
	String[] Data = new String[7];	
	
	JTable TabShow = new JTable();		//JTable：用來顯示已點選餐點訊息
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{{},{},{},{},{},{},{},{},{},{}},new Object[]{"交易編號","交易日期","班　　別","銷售店員","統一編號","交易狀態","總金額"});
	//constructor
	CHCI_SDR_panel(){
		setBackground(new Color(156, 201, 222));
	    setBounds(0,100,500,500);
	    setLayout(null);
		setTabShow();
		setVisible(true);	
	}
	private void setTabShow(){
		TabShow.setRowHeight(40);
		TabShow.setModel(tm);	//指定tm作為tableA的model
		TabShow.addMouseListener(ProcessTableSelection);
		//讓tableA加入捲動軸，這是物件位置需設在捲動軸(tableA設定位置無效)
		JScrollPane Scroll = new JScrollPane(TabShow,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Scroll.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll.setFont(new Font("正黑體",1,14));
		//若要實現背景透明，則需設置Scroll以及Scroll的顯示面板，如下
		Scroll.setOpaque(false);
		Scroll.getViewport().setOpaque(false);
		this.add(Scroll);
	}
	
	public void Query_addDate(String sel_rq,String rq){
		Alist_trans = dbma.findRD_in_TB_trans(sel_rq, rq);   //查詢
		tm.setRowCount(0);      //清除上次資料
		
		for(int i=0; i<Alist_trans.get(0).size();i++){			
				tm.addRow(new Object[]{Alist_trans.get(0).get(i),Alist_trans.get(1).get(i),Alist_trans.get(2).get(i),Alist_trans.get(3).get(i),Alist_trans.get(4).get(i),Integer.valueOf(Alist_trans.get(5).get(i))>0?"正常":"作廢",Alist_trans.get(6).get(i)}); //新增table顯示
		}		
		//調用DefaultTableModel的fireTableDataChanged方法可做model刷新
		tm.fireTableDataChanged();
		TabShow.updateUI();	
	}
	
	public  String rtnSelectedId(){
	    String aId = (String) TabShow.getValueAt(TabShow.getSelectedRow(),0);
		return aId;
	}
	
	public MouseListener ProcessTableSelection = new MouseListener() {
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getClickCount()==1){
				CHCI_MD_panel.setTransData(rtnSelectedId());
			}
		}
	};
}
