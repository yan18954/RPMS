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

//�H�����ʼh���O
//CHCI_SSRM_panel: Class HumanComputerInteraction_ShowPurchaseResult_panel (�H������-[��ܱ��ʭq��d�ߵ��G]�ާ@�e�����O)
public class CHCI_SPLR_panel extends JPanel implements ActionListener, MouseListener{	
	//Create elements
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ArrayList<ArrayList<String>> Alist_order = new ArrayList<ArrayList<String>>();
	//String[] Data = new String[5];
	
	JTable TabShow = new JTable();	//��ܭq��T��		
	DefaultTableModel tm2 = new DefaultTableModel(new Object[][]{},new Object[]{"�q��s��","����","���","�ƶq","�i�f���","�`���B"});
	//constructor
	CHCI_SPLR_panel(){
		setBackground(new Color(156, 201, 222));
	    setBounds(0,100,500,500);
	    setLayout(null);
		setTabShow();
		setVisible(true);
		
//		Query_addDate("ORDER_no","%");	//jtable �{���}�l�ɧY��ܥX����order�q��
	}
	private void setTabShow(){
		TabShow.setRowHeight(33);
		TabShow.setModel(tm2);	//���wtm�@��tableA��model
		TabShow.addMouseListener(this); 	//�W�[�ƹ��ƥ�
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
	
//	public void Query_addDate(String sel_rq,String rq){
//		Alist_order = dbma.findRD_in_TB_order(sel_rq,rq);       //�d��
//		tm.setRowCount(0);      //�M���W�����
//		
//		for(int i=0; i<Alist_order.get(0).size();i++){
//				String[] data_cl = new String[3];	//�x�sCL��� CL_company,CL_contact,CL_contactphone
//				data_cl = dbma.findRD_in_TB_Cldata(Alist_order.get(3).get(i));
//				
//				tm.addRow(new Object[]{Alist_order.get(0).get(i),Alist_order.get(1).get(i),data_cl[0],data_cl[1],data_cl[2],Alist_order.get(4).get(i)}); //�s�Wtable���
//		}		
//		//�ե�DefaultTableModel��fireTableDataChanged��k�i��model��s
//		tm.fireTableDataChanged();
//		TabShow.updateUI();	
//	}
	
	public  String rtnSelectedId(){
	    String aId = (String) TabShow.getValueAt(TabShow.getSelectedRow(),0);
	   // System.out.println("rtn ID = "+aId);
		return aId;
	}
	
	@Override
	public void mouseClicked(MouseEvent e){		//�I���d��
//		if(e.getClickCount()==1){
//			Data = dbma.findRD_in_TB_orderDetail(rtnSelectedId());
//			CHCI_MMA_panel.setOrderData(Data);
//		}
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
