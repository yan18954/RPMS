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
import javax.swing.table.DefaultTableModel;

//人機互動層類別
//CHCI_SMAR_panel: Class HumanComputerInteraction_ShowMAtericalsResult_panel (人機介面-[顯示物料查詢結果]操作畫面類別)
public class CHCI_SMAR_panel extends JPanel implements ActionListener, MouseListener{
	//Create elements
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ArrayList<ArrayList<String>> Alist_mi = new ArrayList<ArrayList<String>>();
	String[] Data = new String[4];
	
	JTable TabShow = new JTable();		
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{{},{},{},{},{},{},{},{},{},{},{}},new Object[]{"物料編號","品名","種類","備註"});
	//constructor
	CHCI_SMAR_panel(){
		setBackground(new Color(156, 201, 222));
	    setBounds(0,100,500,500);
	    setLayout(null);
		setTabShow();
		setVisible(true);
		
		Query_addDate("MI_no","%");	//jtable 顯示出全部mi物料
	}
	private void setTabShow(){
		TabShow.setRowHeight(33);
		TabShow.setModel(tm);	//指定tm作為tableA的model
		TabShow.addMouseListener(this); 	//增加滑鼠事件
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
		Alist_mi = dbma.findRD_in_TB_mi(sel_rq,rq);       //查詢
		tm.setRowCount(0);      //清除上次資料
		
		for(int i=0; i<Alist_mi.get(0).size();i++){		
				tm.addRow(new Object[]{Alist_mi.get(0).get(i),Alist_mi.get(1).get(i),Alist_mi.get(2).get(i),Alist_mi.get(3).get(i)}); //新增table顯示
		}		
		//調用DefaultTableModel的fireTableDataChanged方法可做model刷新
		tm.fireTableDataChanged();
		TabShow.updateUI();	
	}
	
	public  String rtnSelectedId(){
	    String aId = (String) TabShow.getValueAt(TabShow.getSelectedRow(),0);
	   // System.out.println("rtn ID = "+aId);
		return aId;
	}
	
	@Override
	public void mouseClicked(MouseEvent e){		//點擊查詢
		if(e.getClickCount()==1){
			Data = dbma.findRD_in_TB_miDetail(rtnSelectedId());
			CHCI_MMA_panel.setMiData(Data);
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