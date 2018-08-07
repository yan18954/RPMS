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

//�H�����ʼh���O
//CHCI_SSRM_panel: Class HumanComputerInteraction_ShowPurchaseResult_panel (�H������-[��ܱ��ʭq��d�ߵ��G]�ާ@�e�����O)
public class CHCI_SPR_panel extends JPanel implements ActionListener, MouseListener{	
	//Create elements
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ArrayList<ArrayList<String>> Alist_order = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> Alist_cl = new ArrayList<ArrayList<String>>();
	String[] Data = new String[5];
	
	JTable OrderTabShow = new JTable();	//��ܭq��T��		
	JTable OrderListTabShow = new JTable();	//��ܭq��T��		
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{{},{},{},{},{},{},{},{},{},{},{},{},{},{}},new Object[]{"�q��s��","���","���A","�t��","�p���H","�q��","�`���B"});
	DefaultTableModel tm2 = new DefaultTableModel(new Object[][]{{},{},{},{},{},{},{},{},{},{},{},{},{},{}},new Object[]{"�q��s��","����","���","�ƶq","�i�f���","�`���B"});
	
	//��tableA�[�J���ʶb�A�o�O�����m�ݳ]�b���ʶb(tableA�]�w��m�L��)
	JScrollPane Scroll = new JScrollPane(OrderTabShow,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	//��tableA�[�J���ʶb�A�o�O�����m�ݳ]�b���ʶb(tableA�]�w��m�L��)
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
		
		//Query_addDate("ORDER_no","%");	//jtable �{���}�l�ɧY��ܥX����order�q��
	}
	private void setOrderTabShow(){
		OrderTabShow.setRowHeight(33);
		OrderTabShow.setModel(tm);	//���wtm�@��tableA��model
		OrderTabShow.addMouseListener(this); 	//�W�[�ƹ��ƥ�


		Scroll.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll.setFont(new Font("������",1,14));
		//�Y�n��{�I���z���A�h�ݳ]�mScroll�H��Scroll����ܭ��O�A�p�U
		Scroll.setOpaque(false);
		Scroll.getViewport().setOpaque(false);
		
		this.add(Scroll);
	}
	
	private void setOrderListTabShow(){
		OrderListTabShow.setRowHeight(33);
		OrderListTabShow.setModel(tm2);	//���wtm�@��tableA��model
		OrderListTabShow.addMouseListener(this); 	//�W�[�ƹ��ƥ�


		Scroll2.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll2.setFont(new Font("������",1,14));
		//�Y�n��{�I���z���A�h�ݳ]�mScroll�H��Scroll����ܭ��O�A�p�U
		Scroll2.setOpaque(false);
		Scroll2.getViewport().setOpaque(false);
		
		Scroll2.setVisible(false);
		this.add(Scroll2);
	}
	
	public void Query_addDate(String sel_rq,String rq){
		Alist_order = dbma.findRD_in_TB_order(sel_rq,rq);       //�d��
		tm.setRowCount(0);      //�M���W�����
		
		for(int i=0; i<Alist_order.get(0).size();i++){
				String[] data_cl = new String[3];	//�x�sCL��� CL_company,CL_contact,CL_contactphone
				data_cl = dbma.findRD_in_TB_Cldata(Alist_order.get(3).get(i));
				
				tm.addRow(new Object[]{Alist_order.get(0).get(i),Alist_order.get(1).get(i),data_cl[0],data_cl[1],data_cl[2],Alist_order.get(4).get(i)}); //�s�Wtable���
		}		
		//�ե�DefaultTableModel��fireTableDataChanged��k�i��model��s
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
	public void mouseClicked(MouseEvent e){		//�I���d��
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
