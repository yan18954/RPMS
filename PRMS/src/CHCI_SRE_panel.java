import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//�H�����ʼh���O
//CHCI_SR_panel: Class HumanComputerInteraction_ShowResult_panel (�H������-[��ܬd�ߵ��G]�ާ@�e�����O)
public class CHCI_SRE_panel extends JPanel{
	//JTable queryTable = new JTable();		//JTable�G�Ψ���ܤw�s�W�w��
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{},new Object[]{"�m�W","�q��","���","�ɶ�"});
	JTable queryTable=new JTable(tm){
	     public boolean isCellEditable(int row, int column) {
	     return false;
	 }
};
	CHCI_SRE_panel(){

		setBackground(new Color(156, 201, 222));
	    setBounds(0,100,500,500);
	    setLayout(null);
		setqueryTable();
		setVisible(true);
	}
	
	private void setqueryTable(){
		queryTable.setRowHeight(40);
		queryTable.setModel(tm);	//���wtm�@��tableA��model
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
		
}