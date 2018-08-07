import java.awt.Color;
import java.awt.Font;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class CHCI_EMA_panel extends JPanel implements ActionListener {
	String[] MiType = { "麵", "飯", "粥", "湯", "餃" };
	CDM_BS_dbma dbma = new CDM_BS_dbma();

	JPanel materials = new JPanel(); // JPanel，含新增類別相關資訊

	JLabel titleiconlbl = new JLabel();
	JLabel titlelbl = new JLabel("編輯物料：");

	JLabel nolbl = new JLabel("物料編號：");
	JLabel namelbl = new JLabel("物料名稱：");
	JLabel typelbl = new JLabel("物料類別：");
	JLabel notelbl = new JLabel("備      註：");

	JTextField notxt = new JTextField("");
	JTextField datatxt = new JTextField("");
	JTextField nametxt = new JTextField("");
	JTextField pricetxt = new JTextField("");
	JTextArea notetxt = new JTextArea("", 3, 12);

	// 下拉式欄位
	JComboBox<String> TypeCombo = new JComboBox<>(MiType);

	JScrollPane scroll = new JScrollPane(notetxt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	JRadioButton[] csradio = new JRadioButton[2];
	JRadioButton[] msradio = new JRadioButton[2];
	JButton editbtn = new JButton("編輯");
	JButton updatebtn = new JButton("更新");
	JButton clearbtn = new JButton("取消");

	CHCI_EMA_panel() {
		DefaultStatus(); // 設定各欄位初始狀態
		
		materials.setBounds(0, 35, 500, 550);
		materials.setFont(new Font("正黑體", 1, 16));
		materials.setLayout(null);
		materials.setOpaque(false);
		add(materials);

		titleiconlbl.setBounds(0, 0, 32, 32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		materials.add(titleiconlbl);
		titlelbl.setBounds(32, 0, 150, 50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("正黑體", 1, 20));
		materials.add(titlelbl);

		// 設置物料編號
		nolbl.setBounds(10, 45, 150, 45);
		nolbl.setFont(new Font("正黑體", 1, 16));
		materials.add(nolbl);
		// notxt.setBounds(110,52,155,30);
		notxt.setBounds(110, 52, 210, 30);
		notxt.setFont(new Font("正黑體", 1, 16));
		notxt.setEnabled(false);
		materials.add(notxt);

		// 設置物料名稱
		namelbl.setBounds(10, 90, 150, 45);
		namelbl.setFont(new Font("正黑體", 1, 16));
		materials.add(namelbl);
		nametxt.setBounds(110, 97, 155, 30);
		nametxt.setFont(new Font("正黑體", 1, 16));
		materials.add(nametxt);

		// 設置物料類別
		typelbl.setBounds(10, 135, 150, 45);
		typelbl.setFont(new Font("正黑體", 1, 16));
		materials.add(typelbl);
		// 設定物料類別（下拉式選單）
		TypeCombo.setBounds(110, 137, 155, 35);
		TypeCombo.setFont(new Font("正黑體", 0, 16));
		TypeCombo.setSelectedItem(null);;
		materials.add(TypeCombo);

		// 設置備註
		notelbl.setBounds(10, 180, 150, 45);
		notelbl.setFont(new Font("正黑體", 1, 16));
		materials.add(notelbl);
		notetxt.setFont(new Font("正黑體", 1, 16));
		notetxt.setLineWrap(true);
		scroll.setBounds(110, 180, 250, 90);
		materials.add(scroll);

		// 設置按鈕
		editbtn.setBounds(310, 390, 150, 60);
		editbtn.setFont(new Font("正黑體", 1, 16));
		editbtn.setBackground(Color.orange);
		editbtn.setBorderPainted(false);
		editbtn.addActionListener(this);
		materials.add(editbtn);
		updatebtn.setBounds(310, 390, 150, 60);
		updatebtn.setFont(new Font("正黑體", 1, 16));
		updatebtn.setBackground(Color.orange);
		updatebtn.setBorderPainted(false);
		updatebtn.addActionListener(this);
		materials.add(updatebtn);
		clearbtn.setBounds(10, 390, 150, 60);
		clearbtn.setFont(new Font("正黑體", 1, 16));
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		clearbtn.addActionListener(this);
		materials.add(clearbtn);
		setOpaque(false);
		setBounds(5, 65, 475, 490);
		setLayout(null);
	}

	private void updateMi() { // 更新物料
		CPD_mi commands = new CPD_mi();
		commands.setNo(notxt.getText());
		commands.setName(nametxt.getText());
		commands.setState(TypeCombo.getSelectedItem().toString());
		commands.setNote(notetxt.getText());
		dbma.updateMi_in_TB_mi(commands);
	}

	// 取得編號使用狀態
	public boolean getMiStatus() {
		if (notxt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "無任何物料資料");
			return false;
		} else {
			return true;
		}
	}

	// 將全部輸入欄位設定為不可編輯
	public void setAllDisable() {
		nametxt.setEditable(false);
		TypeCombo.setEnabled(false); // jcombobox
		notetxt.setEditable(false);
	}

	// 將全部輸入欄位設定為可編輯
	public void setAllEnable() {
		nametxt.setEditable(true);
		TypeCombo.setEnabled(true); // jcombobox
		notetxt.setEditable(true);
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
		nametxt.setText(null);
		TypeCombo.setSelectedItem(null);
		notetxt.setText(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 事件傾聽
		if (e.getSource() == editbtn) { // 處理編輯btn被按下
			if (getMiStatus()) {
				editbtn.setVisible(false); // 隱藏編輯按鈕
				updatebtn.setVisible(true); // 顯示更新按鈕
				setAllEnable();
			}
		} else if (e.getSource() == clearbtn) { // 處理取消按鈕被按下
			ClearAll();
			setAllDisable();
		} else if (e.getSource() == updatebtn) { // 處理更新按鈕被按下
			updateMi();
			setAllDisable();
			editbtn.setVisible(true);
			updatebtn.setVisible(false);
		}
	}
}
