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
//�H�����ʼh���O
//CHCI_SR_panel: Class HumanComputerInteraction_ShowResult_panel (�H������-[��ܬd�ߵ��G]�ާ@�e�����O)
public class CHCI_SR_panel extends JPanel{
	JTable queryTable = new JTable();		//JTable�G�Ψ���ܤw�I���\�I�T��
	JTable query2Table = new JTable();		//JTable�G�Ψ���ܤw�I���\�I�T��

	DefaultTableModel tm = new DefaultTableModel(new Object[][]{},new Object[]{"���O�s��","�إߤ��","���O�W��","���O����","���O���A","�Ƶ�"});
	DefaultTableModel tm2 = new DefaultTableModel(new Object[][]{},new Object[]{"�\�I�s��","�\�I�W��","�\�I���O","�إߤ��","�\�I����","���","�\�I���A","���Ƥ���","�\�I����"});
	
	//��tableA�[�J���ʶb�A�o�O�����m�ݳ]�b���ʶb(tableA�]�w��m�L��)
	JScrollPane Scroll = new JScrollPane(queryTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	//��tableA�[�J���ʶb�A�o�O�����m�ݳ]�b���ʶb(tableA�]�w��m�L��)
	JScrollPane Scroll2 = new JScrollPane(query2Table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	boolean selected=false;					//boolean:�P�_Jtable�O�_�Q���
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
		queryTable.setModel(tm);	//���wtm�@��tableA��model
		queryTable.getTableHeader().setReorderingAllowed(false);	//�NJTable���]�����i�즲
		Scroll.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll.setFont(new Font("������",1,14));
		Scroll.setOpaque(false);
		Scroll.getViewport().setOpaque(false);
		this.add(Scroll);
	}
	protected void setquery2Table(){
		Scroll.setVisible(false);
		Scroll2.setVisible(true);
		query2Table.setRowHeight(40);
		query2Table.setModel(tm2);	//���wtm�@��tableA��model
		query2Table.getTableHeader().setReorderingAllowed(false);	//�NJTable���]�����i�즲
		Scroll2.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll2.setFont(new Font("������",1,14));
		Scroll2.setOpaque(false);
		Scroll2.getViewport().setOpaque(false);
		this.add(Scroll2);
	}


}
