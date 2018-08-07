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
//CHCI_SCOR_panel: Class HumanComputerInteraction_ShowCompanyResult_panel (人機介面-[顯示廠商查詢結果]操作畫面類別)
public class CHCI_SCO_panel extends JPanel implements ActionListener, MouseListener{
	//Create elements
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ArrayList<ArrayList<String>> Alist_cl = new ArrayList<ArrayList<String>>();
	String[] Data = new String[5];	
	JTable TabShow = new JTable();		
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{{},{},{},{},{},{},{},{},{},{},{}},new Object[]{"廠商編號","廠商名稱","廠商聯絡人","廠商電話","備註"});
	//constructor
	CHCI_SCO_panel(){
		setBackground(new Color(156, 201, 222));
	    setBounds(0,100,500,500);
	    setLayout(null);
		setTabShow();
		setVisible(true);
		
		Query_addDate("CL_no","%");	//jtable 顯示出全部cl廠商
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
		Alist_cl = dbma.findRD_in_TB_cl(sel_rq,rq);       //查詢
		tm.setRowCount(0);      //清除上次資料
		
		for(int i=0; i<Alist_cl.get(0).size();i++){			
				tm.addRow(new Object[]{Alist_cl.get(0).get(i),Alist_cl.get(1).get(i),Alist_cl.get(2).get(i),Alist_cl.get(3).get(i),Alist_cl.get(4).get(i)}); //新增table顯示
		}		
		//調用DefaultTableModel的fireTableDataChanged方法可做model刷新
		tm.fireTableDataChanged();
		TabShow.updateUI();	
	}
	
	public  String rtnSelectedId(){
	    String aId = (String) TabShow.getValueAt(TabShow.getSelectedRow(),0);
		return aId;
	}
	
	//public void s
	
	@Override
	public void mouseClicked(MouseEvent e){		//點擊查詢
		if(e.getClickCount()==1){
			Data = dbma.findRD_in_TB_clDetail(rtnSelectedId());
			CHCI_MMA_panel.setClData(Data);
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
