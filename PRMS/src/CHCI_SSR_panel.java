import java.awt.Color;
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
//CHCI_SSRM_panel: Class HumanComputerInteraction_ShowStaffResult_panel (人機介面-[顯示查詢結果]操作畫面類別)
public class CHCI_SSR_panel extends JPanel implements ActionListener, MouseListener{
	CDM_ST_dbma dbma = new CDM_ST_dbma();
	//JTable queryTable = new JTable();		//JTable：用來顯示查詢員工訊息
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{},new Object[]{"員工編號","姓名","電話","職等"});
	ArrayList<ArrayList<String>> Alist = new ArrayList<ArrayList<String>>();
	String[] profileDate = new String[11];
	//JTable queryTable = new JTable();
	
	JTable queryTable=new JTable(tm){
		     public boolean isCellEditable(int row, int column) {
		     return false;
		 }
    };
	
	CHCI_SSR_panel(){
		
		setBackground(new Color(156, 201, 222));
	    setBounds(0,100,500,500);
	    setLayout(null);
		setqueryTable();
		setVisible(true);
	}
	
	
   
	
	private void setqueryTable(){
		
		queryTable.setRowHeight(40);
		queryTable.setModel(tm);	//指定tm作為tableA的model
		queryTable.addMouseListener(this); //加入滑鼠事件
		
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
	
	public void Query_addDate(String sel_rq,String rq){
		Alist = dbma.findRD_in_TB_staff(sel_rq,rq);       //查詢
		tm.setRowCount(0);      //清除上次資料
		
		for(int i=0; i<Alist.get(0).size();i++){
				tm.addRow(new Object[]{Alist.get(1).get(i),Alist.get(0).get(i),Alist.get(2).get(i),Alist.get(3).get(i)}); //新增table顯示
			}			
		//調用DefaultTableModel的fireTableDataChanged方法可做model刷新
		tm.fireTableDataChanged();
		queryTable.updateUI();	
	}
	
	public  String rtnSelectedId(){
	    String aId = (String) queryTable.getValueAt(queryTable.getSelectedRow(),0);
	   // System.out.println("rtn ID = "+aId);
		return aId;
	}
	
	public void mouseClicked(MouseEvent e) {          //點集查詢
		String sst = "";
		if(e.getClickCount()==1){
			//JOptionPane.showMessageDialog(null, "你點按tableB的第"+queryTable.getSelectedRow()+"列","你點按了表格",JOptionPane.INFORMATION_MESSAGE);
			//JOptionPane.showMessageDialog(null, "ID="+queryTable.getValueAt(queryTable.getSelectedRow(),0),null, JOptionPane.INFORMATION_MESSAGE);
			rtnSelectedId();
			profileDate = dbma.findRD_in_TB_staffDetail(rtnSelectedId());
			CHCI_MS_panel.setData(profileDate);
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
