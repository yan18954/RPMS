import javax.swing.*;
import java.awt.*;
import javax.swing.table.*; 
//�H�����ʼh���O
//CHCI_SOI_panel: Class HumanComputerInteraction_ShowOrderedInformation_panel (�H������-[��ܤw����\�I��T]�ާ@�e�����O)
public class CHCI_SOI_panel extends JPanel{
	JTable orderTable = new JTable();		//JTable�G�Ψ���ܤw�I���\�I�T��
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{},new Object[]{"�\�I�W��","����","���","�ƶq","�p�p"});
	//�[�J���ʶb�A�o�O�����m�ݳ]�b���ʶb
	JScrollPane Scroll = new JScrollPane(orderTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	JLabel bg=new JLabel();
	JPanel tbpanel=new JPanel();
	CHCI_SOI_panel(){
		bg.setBounds(0,0,500,360);
		bg.setIcon(new ImageIcon(getClass().getResource("bg.jpg")));
		tbpanel.setBounds(0, 0, 500, 360);	
		tbpanel.setLayout(null);
		tbpanel.setVisible(true);
		tbpanel.setOpaque(false);
		this.add(tbpanel, new Integer(1), 0);
		this.add(bg);
		setBackground(new Color(255, 0, 0));
		setBounds(0, 0, 500, 360);	
		setLayout(null);
		setorderTable();	//�I�ssetorderTable()
		setVisible(true);
	}
	
	private void setorderTable(){
		orderTable.setRowHeight(40);
		orderTable.setModel(tm);	//���wtm�@��tableA��model

		Scroll.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll.setFont(new Font("������",1,14));
		//�Y�n��{�I���z���A�h�ݳ]�mScroll�H��Scroll����ܭ��O�A�p�U
		Scroll.setOpaque(false);
		Scroll.getViewport().setOpaque(false);
		tbpanel.add(Scroll);
	}
}
