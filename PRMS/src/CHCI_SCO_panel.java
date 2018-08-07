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
//CHCI_SCOR_panel: Class HumanComputerInteraction_ShowCompanyResult_panel (�H������-[��ܼt�Ӭd�ߵ��G]�ާ@�e�����O)
public class CHCI_SCO_panel extends JPanel implements ActionListener, MouseListener{
	//Create elements
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ArrayList<ArrayList<String>> Alist_cl = new ArrayList<ArrayList<String>>();
	String[] Data = new String[5];	
	JTable TabShow = new JTable();		
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{{},{},{},{},{},{},{},{},{},{},{}},new Object[]{"�t�ӽs��","�t�ӦW��","�t���p���H","�t�ӹq��","�Ƶ�"});
	//constructor
	CHCI_SCO_panel(){
		setBackground(new Color(156, 201, 222));
	    setBounds(0,100,500,500);
	    setLayout(null);
		setTabShow();
		setVisible(true);
		
		Query_addDate("CL_no","%");	//jtable ��ܥX����cl�t��
	}
	private void setTabShow(){
		
		TabShow.setRowHeight(33);
		TabShow.setModel(tm);	//���wtm�@��tableA��model
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
	
	public void Query_addDate(String sel_rq,String rq){
		Alist_cl = dbma.findRD_in_TB_cl(sel_rq,rq);       //�d��
		tm.setRowCount(0);      //�M���W�����
		
		for(int i=0; i<Alist_cl.get(0).size();i++){			
				tm.addRow(new Object[]{Alist_cl.get(0).get(i),Alist_cl.get(1).get(i),Alist_cl.get(2).get(i),Alist_cl.get(3).get(i),Alist_cl.get(4).get(i)}); //�s�Wtable���
		}		
		//�ե�DefaultTableModel��fireTableDataChanged��k�i��model��s
		tm.fireTableDataChanged();
		TabShow.updateUI();	
	}
	
	public  String rtnSelectedId(){
	    String aId = (String) TabShow.getValueAt(TabShow.getSelectedRow(),0);
		return aId;
	}
	
	//public void s
	
	@Override
	public void mouseClicked(MouseEvent e){		//�I���d��
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
