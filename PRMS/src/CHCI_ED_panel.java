import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//人機互動層類別
//CHCI_EC_panel: Class HumanComputerInteraction_EditDeals_panel (人機介面-[編輯交易]作畫面類別)
public class CHCI_ED_panel extends JPanel{
	CDM_BS_dbma dbma = new CDM_BS_dbma();
	ArrayList<ArrayList<String>> Alist_cd = new ArrayList<ArrayList<String>>();
	String TRANS_no;
	CPD_trans TransData = new CPD_trans();
	
	JPanel deal_pane=new JPanel();			//JPanel，含編輯類別相關資訊	
	JPanel detail_panel=new JPanel();		//JPanel，含交易細節相關資訊	
	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("編輯交易：");
	JLabel nolbl=new JLabel("交易編號：");
	JLabel statelbl=new JLabel("交易狀態：");
    JTextField notxt=new JTextField("");   
    JRadioButton[] dsradio=new JRadioButton[2];
    JButton editbtn=new JButton("更新");
    JButton cancelbtn=new JButton("取消");
    
	JTable TabShow = new JTable();		//JTable：用來顯示已點選餐點訊息
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{{},{},{},{},{},{}},new Object[]{"交易編號","餐　　點","餐點數量","總金額"});
	
	CHCI_ED_panel(){
		deal_pane.setBounds(0,0,500,550);
		deal_pane.setFont(new Font("正黑體",1,16));
		deal_pane.setLayout(null);
		deal_pane.setOpaque(false);
		add(deal_pane);

		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("editclass_icon.png")));
		deal_pane.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("正黑體",1,20));	
		deal_pane.add(titlelbl);			 
	 
		//設置交易狀態
		statelbl.setBounds(10,45,150,45);
		statelbl.setFont(new Font("正黑體",1,16));	
		deal_pane.add(statelbl);	
		setDealState();
		
		//設置交易細項表格
		setDealDetail();
		detail_panel.setBounds(10,90,470,280);
		detail_panel.setFont(new Font("正黑體",1,16));	
		deal_pane.add(detail_panel);	
		
		//設置按鈕
		editbtn.setBounds(310,425,150,60);
		editbtn.setFont(new Font("正黑體",1,16));
		editbtn.setBackground(Color.orange);
		editbtn.setBorderPainted(false);
		editbtn.addActionListener(BtnEvent);
		deal_pane.add(editbtn);	
		cancelbtn.setBounds(10,425,150,60);
		cancelbtn.setFont(new Font("正黑體",1,16));	
		cancelbtn.setBackground(new Color(0, 148, 141));
		cancelbtn.setBorderPainted(false);
		cancelbtn.addActionListener(BtnEvent);
		deal_pane.add(cancelbtn);			
		
		setOpaque(false);
		setBounds(5,65,475,490);
		setLayout(null); 
	}
	 private void setDealState(){
		dsradio[0]=new JRadioButton("正  常",true);
		dsradio[0].addActionListener(BtnEvent);
		dsradio[1]=new JRadioButton("作  廢");
		dsradio[1].addActionListener(BtnEvent);
		ButtonGroup csgroup=new ButtonGroup();
		for(int i=0;i<dsradio.length;i++){
			dsradio[i].setBounds(110+80*i,52,100,30);
			dsradio[i].setFont(new Font("正黑體",0,16));	
			dsradio[i].setContentAreaFilled(false);
			csgroup.add(dsradio[i]);
			deal_pane.add(dsradio[i]);
		}
	 }
	 
	//交易細節表單
	private void setDealDetail(){
		TabShow.setRowHeight(40);
		TabShow.setModel(tm);	//指定tm作為tableA的model
		//讓tableA加入捲動軸，這是物件位置需設在捲動軸(tableA設定位置無效)
		JScrollPane Scroll = new JScrollPane(TabShow,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Scroll.setBounds(0, 0, this.getWidth(), this.getHeight());
		Scroll.setFont(new Font("正黑體",1,14));
		//背景透明
		Scroll.setOpaque(true);
		Scroll.getViewport().setOpaque(true);
		
		detail_panel.add(Scroll);
	}	 
	
	public void Query_addDate(ArrayList<String> TLList,String TRANS_no){
		String[] TLdata;
		
		tm.setRowCount(0);      //清除上次資料
		for(int i=0; i < TLList.size(); i++){
			TLdata = dbma.findRD_in_TB_TLList(TLList.get(i));
			tm.addRow(new Object[]{TLdata[0],TLdata[1],TLdata[2],TLdata[3]}); //新增table顯示			//調用DefaultTableModel的fireTableDataChanged方法可做model刷新
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
			// TODO 自動產生的方法 Stub
			if(e.getSource() == editbtn){
				if(!TransData.getNo().equals(""))
				dbma.updateTrans_in_TB_trans(TransData);
				else{
					JOptionPane.showMessageDialog(null, "請先點選訂單");
				}
			}
			else if(e.getSource() == cancelbtn){
				if(!TransData.getNo().equals(""))
					TransData.ClearALll();
				else{
					JOptionPane.showMessageDialog(null, "請先點選訂單");
				}
			}
			else if(e.getSource() == dsradio[0]){
				if(!TransData.getNo().equals(""))
					TransData.setStatus(1);
				else{
					JOptionPane.showMessageDialog(null, "請先點選訂單");
				}
			}else if (e.getSource() == dsradio[1]) {
				if(!TransData.getNo().equals(""))
					TransData.setStatus(0);
				else{
					JOptionPane.showMessageDialog(null, "請先點選訂單");
				}
			}
		}
	};
}
