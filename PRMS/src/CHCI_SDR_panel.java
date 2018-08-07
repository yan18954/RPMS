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

//�H�����ʼh���O
//CHCI_SDR_panel: Class HumanComputerInteraction_ShowDealsResult_panel (�H������-[��ܬd�ߵ��G]�ާ@�e�����O)
public class CHCI_SDR_panel extends JPanel{
	//Create elements
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ArrayList<ArrayList<String>> Alist_trans = new ArrayList<ArrayList<String>>();
	String[] Data = new String[7];	
	
	JTable TabShow = new JTable();		//JTable�G�Ψ���ܤw�I���\�I�T��
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{{},{},{},{},{},{},{},{},{},{}},new Object[]{"����s��","������","�Z�@�@�O","�P�⩱��","�Τ@�s��","������A","�`���B"});
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
		TabShow.setModel(tm);	//���wtm�@��tableA��model
		TabShow.addMouseListener(ProcessTableSelection);
		//��tableA�[�J���ʶb�A�o�O�����m�ݳ]�b���ʶb(tableA�]�w��m�L��)
		JScrollPane Scroll = new JScrollPane(TabShow,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Scroll.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll.setFont(new Font("������",1,14));
		//�Y�n��{�I���z���A�h�ݳ]�mScroll�H��Scroll����ܭ��O�A�p�U
		Scroll.setOpaque(false);
		Scroll.getViewport().setOpaque(false);
		this.add(Scroll);
	}
	
	public void Query_addDate(String sel_rq,String rq){
		Alist_trans = dbma.findRD_in_TB_trans(sel_rq, rq);   //�d��
		tm.setRowCount(0);      //�M���W�����
		
		for(int i=0; i<Alist_trans.get(0).size();i++){			
				tm.addRow(new Object[]{Alist_trans.get(0).get(i),Alist_trans.get(1).get(i),Alist_trans.get(2).get(i),Alist_trans.get(3).get(i),Alist_trans.get(4).get(i),Integer.valueOf(Alist_trans.get(5).get(i))>0?"���`":"�@�o",Alist_trans.get(6).get(i)}); //�s�Wtable���
		}		
		//�ե�DefaultTableModel��fireTableDataChanged��k�i��model��s
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
