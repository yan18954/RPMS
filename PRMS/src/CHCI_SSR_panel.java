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

//�H�����ʼh���O
//CHCI_SSRM_panel: Class HumanComputerInteraction_ShowStaffResult_panel (�H������-[��ܬd�ߵ��G]�ާ@�e�����O)
public class CHCI_SSR_panel extends JPanel implements ActionListener, MouseListener{
	CDM_ST_dbma dbma = new CDM_ST_dbma();
	//JTable queryTable = new JTable();		//JTable�G�Ψ���ܬd�߭��u�T��
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{},new Object[]{"���u�s��","�m�W","�q��","¾��"});
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
		queryTable.setModel(tm);	//���wtm�@��tableA��model
		queryTable.addMouseListener(this); //�[�J�ƹ��ƥ�
		
		//��tableA�[�J���ʶb�A�o�O�����m�ݳ]�b���ʶb(tableA�]�w��m�L��)
		JScrollPane Scroll = new JScrollPane(queryTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Scroll.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll.setFont(new Font("������",1,14));
		//�Y�n��{�I���z���A�h�ݳ]�mScroll�H��Scroll����ܭ��O�A�p�U
		Scroll.setOpaque(false);
		Scroll.getViewport().setOpaque(false);
		this.add(Scroll);
	}
	
	public void Query_addDate(String sel_rq,String rq){
		Alist = dbma.findRD_in_TB_staff(sel_rq,rq);       //�d��
		tm.setRowCount(0);      //�M���W�����
		
		for(int i=0; i<Alist.get(0).size();i++){
				tm.addRow(new Object[]{Alist.get(1).get(i),Alist.get(0).get(i),Alist.get(2).get(i),Alist.get(3).get(i)}); //�s�Wtable���
			}			
		//�ե�DefaultTableModel��fireTableDataChanged��k�i��model��s
		tm.fireTableDataChanged();
		queryTable.updateUI();	
	}
	
	public  String rtnSelectedId(){
	    String aId = (String) queryTable.getValueAt(queryTable.getSelectedRow(),0);
	   // System.out.println("rtn ID = "+aId);
		return aId;
	}
	
	public void mouseClicked(MouseEvent e) {          //�I���d��
		String sst = "";
		if(e.getClickCount()==1){
			//JOptionPane.showMessageDialog(null, "�A�I��tableB����"+queryTable.getSelectedRow()+"�C","�A�I���F���",JOptionPane.INFORMATION_MESSAGE);
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
