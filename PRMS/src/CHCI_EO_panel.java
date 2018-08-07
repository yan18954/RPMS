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

public class CHCI_EO_panel extends JPanel implements ActionListener {
	// 變數設定
	String[] status = { "未付款", "已付款", "取消訂單", "結單" };
	ArrayList<String> companylist = new ArrayList<String>();

	CDM_BS_dbma dbma = new CDM_BS_dbma();

	JPanel order_pane = new JPanel(); // JPanel，含新訂單別相關資訊

	JLabel titleiconlbl = new JLabel();
	JLabel titlelbl = new JLabel("編輯訂單：");

	JLabel nolbl = new JLabel("訂單編號：");
	JLabel datelbl = new JLabel("訂單日期：");
	JLabel statelbl = new JLabel("訂單狀態：");
	JLabel companylbl = new JLabel("廠商：");
	JLabel totallbl = new JLabel("總金額：");

	// 輸入欄位
	JTextField notxt = new JTextField("");
	JTextField datetxt = new JTextField("");
	JTextField statetxt = new JTextField("");
	JTextField totaltxt = new JTextField("");

	// 下拉式欄位
	JComboBox<String> StatusCombo = new JComboBox<>(status);
	JComboBox<String> CompanyCombo = new JComboBox<>();

	JRadioButton[] csradio = new JRadioButton[2];
	JRadioButton[] msradio = new JRadioButton[2];
	JButton editbtn = new JButton("編輯");
	JButton updatebtn = new JButton("更新");
	JButton clearbtn = new JButton("取消");
	
	CHCI_EO_panel() {
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
		nolbl.setBounds(10, 45, 150, 45);
		nolbl.setFont(new Font("正黑體", 1, 16));
		order_pane.add(nolbl);
		notxt.setBounds(110, 52, 210, 30);
		notxt.setFont(new Font("正黑體", 1, 16));
		notxt.setEnabled(false);
		order_pane.add(notxt);
		// 設置建立日期
		datelbl.setBounds(10, 90, 150, 45);
		datelbl.setFont(new Font("正黑體", 1, 16));
		order_pane.add(datelbl);
		datetxt.setBounds(110, 97, 155, 30);
		datetxt.setFont(new Font("正黑體", 1, 16));
		datetxt.setEditable(false);
		order_pane.add(datetxt);
		// 設置訂單狀態
		statelbl.setBounds(10, 135, 150, 45);
		statelbl.setFont(new Font("正黑體", 1, 16));
		order_pane.add(statelbl);

		// 設定訂單狀態（下拉式選單）
		StatusCombo.setBounds(110, 137, 100, 35);
		StatusCombo.setFont(new Font("正黑體", 0, 16));
		StatusCombo.setSelectedItem(null);
		order_pane.add(StatusCombo);

		// 設置廠商編號
		// CompanyCombo.setBounds(110,187,100,35); //初始數值
		CompanyCombo.setBounds(110, 187, 155, 35);
		companylbl.setBounds(10, 180, 150, 45);
		companylbl.setFont(new Font("正黑體", 1, 16));
		getCompanyList(); // 設定廠商下拉式列表
		order_pane.add(companylbl);
		// setCompanyNOCombo();

		// 設置廠商選擇（下拉式選單）
		// CompanyCombo.setBounds(110,187,100,35); //初始數值
		CompanyCombo.setBounds(110, 187, 155, 35);
		CompanyCombo.setFont(new Font("正黑體", 0, 16));
		CompanyCombo.setSelectedItem(null);
		order_pane.add(CompanyCombo);

		// 設置總金額
		totallbl.setBounds(10, 225, 150, 45);
		totallbl.setFont(new Font("正黑體", 1, 16));
		order_pane.add(totallbl);
		totaltxt.setFont(new Font("正黑體", 1, 16));
		totaltxt.setBounds(110, 232, 155, 30);
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

	public void getCompanyList() {	//取得與更新廠商列表
		CompanyCombo.removeAllItems();
		companylist = dbma.findRD_in_TB_cllist();
		for(int i=0 ;i<companylist.size() ;i++ ){
			CompanyCombo.addItem(companylist.get(i));
		}
		
		CompanyCombo.setSelectedItem(null);
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
		commands.setStatus((StatusCombo.getSelectedIndex()));
		commands.setClNo(dbma.findRD_in_TB_ClColumn(CompanyCombo.getSelectedItem().toString(), "CL_company", "CL_no"));
		commands.setAmount(Integer.parseInt(totaltxt.getText()));

		dbma.updateOrder_in_TB_order(commands);
	}

	// 將全部輸入欄位設定為不可編輯
	public void setAllDisable() {
		datetxt.setEditable(false);
		StatusCombo.setEnabled(false); // jcombobox
		CompanyCombo.setEnabled(false); // jconbobox
		totaltxt.setEditable(false);
	}

	// 將全部輸入欄位設定為可編輯
	public void setAllEnable() {
		datetxt.setEditable(true);
		StatusCombo.setEnabled(true); // jcombobox
		CompanyCombo.setEnabled(true); // jcombobox
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
		StatusCombo.setSelectedItem(null);
		CompanyCombo.setSelectedItem(null);;
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
