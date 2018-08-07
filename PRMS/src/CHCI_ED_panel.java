import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//�H�����ʼh���O
//CHCI_EC_panel: Class HumanComputerInteraction_EditDeals_panel (�H������-[�s����]�@�e�����O)
public class CHCI_ED_panel extends JPanel{
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ArrayList<ArrayList<String>> Alist_cd = new ArrayList<ArrayList<String>>();
	String TRANS_no;
	CPD_trans TransData = new CPD_trans();
	
	JPanel deal_pane=new JPanel();			//JPanel�A�t�s�����O������T	
	JPanel detail_panel=new JPanel();		//JPanel�A�t����Ӹ`������T	
	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("�s�����G");
	JLabel nolbl=new JLabel("����s���G");
	JLabel statelbl=new JLabel("������A�G");
    JTextField notxt=new JTextField("");   
    JRadioButton[] dsradio=new JRadioButton[2];
    JButton editbtn=new JButton("��s");
    JButton cancelbtn=new JButton("����");
    
	JTable TabShow = new JTable();		//JTable�G�Ψ���ܤw�I���\�I�T��
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{{},{},{},{},{},{}},new Object[]{"����s��","�\�@�@�I","�\�I�ƶq","�`���B"});
	
	CHCI_ED_panel(){
		deal_pane.setBounds(0,0,500,550);
		deal_pane.setFont(new Font("������",1,16));
		deal_pane.setLayout(null);
		deal_pane.setOpaque(false);
		add(deal_pane);

		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("editclass_icon.png")));
		deal_pane.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("������",1,20));	
		deal_pane.add(titlelbl);			 
	 
		//�]�m������A
		statelbl.setBounds(10,45,150,45);
		statelbl.setFont(new Font("������",1,16));	
		deal_pane.add(statelbl);	
		setDealState();
		
		//�]�m����Ӷ����
		setDealDetail();
		detail_panel.setBounds(10,90,470,280);
		detail_panel.setFont(new Font("������",1,16));	
		deal_pane.add(detail_panel);	
		
		//�]�m���s
		editbtn.setBounds(310,425,150,60);
		editbtn.setFont(new Font("������",1,16));
		editbtn.setBackground(Color.orange);
		editbtn.setBorderPainted(false);
		editbtn.addActionListener(BtnEvent);
		deal_pane.add(editbtn);	
		cancelbtn.setBounds(10,425,150,60);
		cancelbtn.setFont(new Font("������",1,16));	
		cancelbtn.setBackground(new Color(0, 148, 141));
		cancelbtn.setBorderPainted(false);
		cancelbtn.addActionListener(BtnEvent);
		deal_pane.add(cancelbtn);			
		
		setOpaque(false);
		setBounds(5,65,475,490);
		setLayout(null); 
	}
	 private void setDealState(){
		dsradio[0]=new JRadioButton("��  �`",true);
		dsradio[0].addActionListener(BtnEvent);
		dsradio[1]=new JRadioButton("�@  �o");
		dsradio[1].addActionListener(BtnEvent);
		ButtonGroup csgroup=new ButtonGroup();
		for(int i=0;i<dsradio.length;i++){
			dsradio[i].setBounds(110+80*i,52,100,30);
			dsradio[i].setFont(new Font("������",0,16));	
			dsradio[i].setContentAreaFilled(false);
			csgroup.add(dsradio[i]);
			deal_pane.add(dsradio[i]);
		}
	 }
	 
	//����Ӹ`���
	private void setDealDetail(){
		TabShow.setRowHeight(40);
		TabShow.setModel(tm);	//���wtm�@��tableA��model
		//��tableA�[�J���ʶb�A�o�O�����m�ݳ]�b���ʶb(tableA�]�w��m�L��)
		JScrollPane Scroll = new JScrollPane(TabShow,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Scroll.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll.setFont(new Font("������",1,14));
		//�I���z��
		Scroll.setOpaque(true);
		Scroll.getViewport().setOpaque(true);
		
		detail_panel.add(Scroll);
	}	 
	
	public void Query_addDate(ArrayList<String> TLList,String TRANS_no){
		String[] TLdata;
		
		tm.setRowCount(0);      //�M���W�����
		for(int i=0; i < TLList.size(); i++){
			TLdata = dbma.findRD_in_TB_TLList(TLList.get(i));
			tm.addRow(new Object[]{TLdata[0],TLdata[1],TLdata[2],TLdata[3]}); //�s�Wtable���			//�ե�DefaultTableModel��fireTableDataChanged��k�i��model��s
		}

		tm.fireTableDataChanged();
		TabShow.updateUI();
		setTransValues(dbma.findRD_in_TB_transDetail(TRANS_no));
	}
	
	public void setTransValues(String[] aTrans){
		System.out.println(aTrans[0]);
		TransData.setNo(aTrans[0]);
		TransData.setDate(aTrans[1]);
		TransData.setShiff(Integer.valueOf(aTrans[2]));
		TransData.setEmplId(aTrans[3]);
		TransData.setEin(Integer.valueOf(aTrans[4]));
		TransData.setStatus(Integer.valueOf(aTrans[5]));
		TransData.setAmount(Integer.valueOf(aTrans[6]));
	}
	
	public ActionListener BtnEvent = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �۰ʲ��ͪ���k Stub
			if(e.getSource() == editbtn){
				if(!TransData.getNo().equals(""))
				dbma.updateTrans_in_TB_trans(TransData);
				else{
					JOptionPane.showMessageDialog(null, "�Х��I��q��");
				}
			}
			else if(e.getSource() == cancelbtn){
				if(!TransData.getNo().equals(""))
					TransData.ClearALll();
				else{
					JOptionPane.showMessageDialog(null, "�Х��I��q��");
				}
			}
			else if(e.getSource() == dsradio[0]){
				if(!TransData.getNo().equals(""))
					TransData.setStatus(1);
				else{
					JOptionPane.showMessageDialog(null, "�Х��I��q��");
				}
			}else if (e.getSource() == dsradio[1]) {
				if(!TransData.getNo().equals(""))
					TransData.setStatus(0);
				else{
					JOptionPane.showMessageDialog(null, "�Х��I��q��");
				}
			}
		}
	};
}
