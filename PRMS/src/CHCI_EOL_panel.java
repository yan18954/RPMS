import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CHCI_EOL_panel extends JPanel implements ActionListener {
	// 變數設定
	ArrayList<String> name = new ArrayList<String>();

	CDM_BS_dbma dbma = new CDM_BS_dbma();

	JPanel order_pane = new JPanel(); // JPanel，含新訂單別相關資訊

	JLabel titleiconlbl = new JLabel();
	JLabel titlelbl = new JLabel("編輯訂單細節：");

	JLabel nolbl = new JLabel("訂單編號：");
	JLabel namelbl = new JLabel("物料名稱：");
	JLabel pricelbl = new JLabel("單價：");
	JLabel amountlbl = new JLabel("購買數量：");
	JLabel datelbl = new JLabel("進貨日期：");
	JLabel otalbl = new JLabel("總金額");

	// 輸入欄位
	JTextField notxt = new JTextField("");
	JTextField nametxt = new JTextField("");
	JTextField pricetxt = new JTextField("");
	JTextField amounttxt = new JTextField("");
	JTextField datetxt = new JTextField("");
	JTextField totaltxt = new JTextField("");

	// 下拉式欄位
	JComboBox<String> nameCombo = new JComboBox<>();

	JRadioButton[] csradio = new JRadioButton[2];
	JRadioButton[] msradio = new JRadioButton[2];
	JButton editbtn = new JButton("編輯");
	JButton updatebtn = new JButton("更新");
	JButton clearbtn = new JButton("取消");

	CHCI_EOL_panel() {
		DefaultStatus(); // 設定各欄位初始狀態

		order_pane.setBounds(0, 35, 500, 550);
		order_pane.setFont(new Font("正黑體", 1, 16));
		order_pane.setLayout(null);
		order_pane.setOpaque(false);
		add(order_pane);

		titleiconlbl.setBounds(0, 0, 32, 32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		order_pane.add(titleiconlbl);
		titlelbl.setBounds(32, 0, 150, 50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("正黑體", 1, 20));
		order_pane.add(titlelbl);
		// 設置訂單編號
		nolbl.setBounds(10, 45, 210, 45);
		nolbl.setFont(new Font("正黑體", 1, 16));
		order_pane.add(nolbl);
		notxt.setBounds(110, 52, 210, 30);
		notxt.setFont(new Font("正黑體", 1, 16));
		notxt.setEnabled(false);
		order_pane.add(notxt);
		// 設置物料名稱
		namelbl.setBounds(10, 90, 150, 45);
		namelbl.setFont(new Font("正黑體", 1, 16));
		order_pane.add(namelbl);
		nameCombo.setBounds(110, 97, 150, 30);		//（下拉式選單）
		nameCombo.setFont(new Font("正黑體", 0, 16));
		nameCombo.setSelectedItem(null);
		order_pane.add(nameCombo);
		//設置物料單價
		pricelbl.setBounds(10, 135, 150, 30);
		pricelbl.setFont(new Font("正黑體", 0, 16));
		order_pane.add(pricelbl);
		pricetxt.setBounds(110, 142, 155, 30);
		pricetxt.setFont(new Font("正黑體", 0, 16));
		order_pane.add(pricetxt);
		//設置購買數量
		amountlbl.setBounds(10, 180, 150, 30);
		amountlbl.setFont(new Font("正黑體", 0, 16));
		order_pane.add(amountlbl);
		amounttxt.setBounds(110, 187, 155, 30);
		amounttxt.setFont(new Font("正黑體", 0, 16));
		order_pane.add(amounttxt);
		//設置購買日期
		datelbl.setBounds(10, 225, 150, 30);
		datelbl.setFont(new Font("正黑體", 0, 16));
		order_pane.add(datelbl);
		datetxt.setBounds(110, 232, 155, 30);
		datetxt.setFont(new Font("正黑體", 0, 16));
		order_pane.add(datetxt);
		//設置總金額
		otalbl.setBounds(10, 270, 150, 30);
		otalbl.setFont(new Font("正黑體", 0, 16));
		order_pane.add(otalbl);
		totaltxt.setBounds(110, 277, 155, 30);
		totaltxt.setFont(new Font("正黑體", 0, 16));
		order_pane.add(totaltxt);
		
		// 設置按鈕
		editbtn.setBounds(310, 390, 150, 60); // 編輯按鈕
		editbtn.setFont(new Font("正黑體", 1, 16));
		editbtn.setBackground(Color.orange);
		editbtn.setBorderPainted(false);
		editbtn.addActionListener(this);
		order_pane.add(editbtn);
		updatebtn.setBounds(310, 390, 150, 60); // 更新按鈕
		updatebtn.setFont(new Font("正黑體", 1, 16));
		updatebtn.setBackground(Color.orange);
		updatebtn.setBorderPainted(false);
		updatebtn.addActionListener(this);
		order_pane.add(updatebtn);
		clearbtn.setBounds(10, 390, 150, 60); // 取消按鈕
		clearbtn.setFont(new Font("正黑體", 1, 16));
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		clearbtn.addActionListener(this);
		order_pane.add(clearbtn);
		setOpaque(false);
		setBounds(5, 65, 475, 490);
		setLayout(null);
	}

	public void getNameList() {	//取得與更新廠商列表
		nameCombo.removeAllItems();
		name = dbma.findRD_in_TB_milist();
		for(int i=0 ;i<name.size() ;i++ ){
			nameCombo.addItem(name.get(i));
		}
		nameCombo.setSelectedItem(null);
	}

	// 取得編號使用狀態
	public boolean getOrderStatus() {
		if (notxt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "無任何訂單資料");
			return false;
		} else {
			System.out.printf(notxt.getText());
			return true;
		}
	}

	private void updateOrder() { // 更新訂單
		CPD_order commands = new CPD_order();
		commands.setNo(notxt.getText());
		commands.setDate(datetxt.getText());
		//commands.setStatus((StatusCombo.getSelectedIndex()));
		commands.setClNo(dbma.findRD_in_TB_ClColumn(nameCombo.getSelectedItem().toString(), "CL_company", "CL_no"));
		commands.setAmount(Integer.parseInt(totaltxt.getText()));

		dbma.updateOrder_in_TB_order(commands);
	}

	// 將全部輸入欄位設定為不可編輯
	public void setAllDisable() {
		datetxt.setEditable(false);
		nameCombo.setEnabled(false); // jconbobox
		totaltxt.setEditable(false);
	}

	// 將全部輸入欄位設定為可編輯
	public void setAllEnable() {
		datetxt.setEditable(true);
		nameCombo.setEnabled(true); // jcombobox
		totaltxt.setEditable(true);
	}

	// 預設編輯畫面狀態
	public void DefaultStatus() {
		editbtn.setVisible(true);
		updatebtn.setVisible(false);
		setAllDisable();
	}

	// 將所有輸入欄位的值清空
	private void ClearAll() {
		notxt.setText(null);
		datetxt.setText(null);
		//StatusCombo.setSelectedItem(null);
		nameCombo.setSelectedItem(null);;
		totaltxt.setText(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 事件傾聽
		if (e.getSource() == editbtn) { // 處理編輯btn被按下
			if (getOrderStatus()) {
				editbtn.setVisible(false); // 隱藏編輯按鈕
				updatebtn.setVisible(true); // 顯示更新按鈕
				setAllEnable();
			}
		} else if (e.getSource() == clearbtn) { // 處理取消按鈕被按下
			ClearAll();
			setAllDisable();
		} else if (e.getSource() == updatebtn) { // 處理更新按鈕被按下
			updateOrder();
			setAllDisable();
			editbtn.setVisible(true);
			updatebtn.setVisible(false);
		}
	}
}
