import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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

//人機互動層類別
//CHCI_ECO_panel: Class HumanComputerInteraction_EditCOmpany_panel (人機介面-[編輯廠商]操作畫面類別)
public class CHCI_ECO_panel extends JPanel implements ActionListener {
	CDM_BS_dbma dbma = new CDM_BS_dbma();

	JPanel company_pane = new JPanel(); // JPanel，含新訂單別相關資訊

	JLabel titleiconlbl = new JLabel();
	JLabel titlelbl = new JLabel("編輯廠商：");

	JLabel nolbl = new JLabel("廠商編號：");
	JLabel namelbl = new JLabel("廠商名稱：");
	JLabel contactlbl = new JLabel("廠商聯絡人：");
	JLabel tellbl = new JLabel("廠商電話：");
	JLabel notelbl = new JLabel("廠商備註：");

	JTextField notxt = new JTextField("");
	JTextField nametxt = new JTextField("");
	JTextField contacttxt = new JTextField("");
	JTextField teltxt = new JTextField("");
	JTextArea notetext = new JTextArea("");
	JScrollPane scroll = new JScrollPane(notetext, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	JRadioButton[] csradio = new JRadioButton[2];
	JRadioButton[] msradio = new JRadioButton[2];
	JButton editbtn = new JButton("編輯");
	JButton updatebtn = new JButton("更新");
	JButton clearbtn = new JButton("取消");

	CHCI_ECO_panel() {
		DefaultStatus(); // 設定各欄位初始狀態
		
		company_pane.setBounds(0, 35, 500, 550);
		company_pane.setFont(new Font("正黑體", 1, 16));
		company_pane.setLayout(null);
		company_pane.setOpaque(false);
		add(company_pane);

		titleiconlbl.setBounds(0, 0, 32, 32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		company_pane.add(titleiconlbl);
		titlelbl.setBounds(32, 0, 150, 50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("正黑體", 1, 20));
		company_pane.add(titlelbl);

		// 設置廠商編號
		nolbl.setBounds(10, 45, 150, 45);
		nolbl.setFont(new Font("正黑體", 1, 16));
		company_pane.add(nolbl);
		// notxt.setBounds(110,52,155,30);
		notxt.setBounds(110, 52, 210, 30);
		notxt.setFont(new Font("正黑體", 1, 16));
		notxt.setEnabled(false);
		company_pane.add(notxt);
		// 設置廠商名稱
		namelbl.setBounds(10, 90, 150, 45);
		namelbl.setFont(new Font("正黑體", 1, 16));
		company_pane.add(namelbl);
		nametxt.setBounds(110, 97, 155, 30);
		nametxt.setFont(new Font("正黑體", 1, 16));
		company_pane.add(nametxt);
		// 設置廠商聯絡人
		contactlbl.setBounds(10, 135, 150, 45);
		contactlbl.setFont(new Font("正黑體", 1, 16));
		company_pane.add(contactlbl);
		contacttxt.setBounds(110, 142, 155, 30);
		contacttxt.setFont(new Font("正黑體", 1, 16));
		company_pane.add(contacttxt);
		// 設置廠商連絡電話
		tellbl.setBounds(10, 180, 150, 45);
		tellbl.setFont(new Font("正黑體", 1, 16));
		company_pane.add(tellbl);
		teltxt.setBounds(110, 187, 155, 30);
		teltxt.setFont(new Font("正黑體", 1, 16));
		company_pane.add(teltxt);
		// 設置廠商備註
		notelbl.setBounds(10, 225, 150, 45);
		notelbl.setFont(new Font("正黑體", 1, 16));
		company_pane.add(notelbl);
		notetext.setFont(new Font("正黑體", 1, 16));
		notetext.setBorder(BorderFactory.createLineBorder(Color.blue));
		notetext.setLineWrap(true);
		scroll.setBounds(110, 232, 250, 90);
		company_pane.add(scroll);

		// 設置按鈕
		editbtn.setBounds(310, 390, 150, 60); // 編輯按鈕
		editbtn.setFont(new Font("正黑體", 1, 16));
		editbtn.setBackground(Color.orange);
		editbtn.setBorderPainted(false);
		editbtn.addActionListener(this);
		company_pane.add(editbtn);
		updatebtn.setBounds(310, 390, 150, 60); // 更新按鈕
		updatebtn.setFont(new Font("正黑體", 1, 16));
		updatebtn.setBackground(Color.orange);
		updatebtn.setBorderPainted(false);
		updatebtn.addActionListener(this);
		company_pane.add(updatebtn);
		clearbtn.setBounds(10, 390, 150, 60); // 取消按鈕
		clearbtn.setFont(new Font("正黑體", 1, 16));
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		clearbtn.addActionListener(this);
		company_pane.add(clearbtn);
		setOpaque(false);
		setBounds(5, 65, 475, 490);
		setLayout(null);
	}

	// 取得編號使用狀態
	public boolean getClStatus() {
		if (notxt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "無任何廠商資料");
			return false;
		} else {
			System.out.printf(notxt.getText());
			return true;
		}
	}

	private void updateCl() { // 更新廠商
		CPD_cl commands = new CPD_cl();
		commands.setNo(notxt.getText());
		commands.setCompany(nametxt.getText());
		commands.setContact(contacttxt.getText());
		commands.setContactphone(teltxt.getText());
		commands.setNote(notetext.getText());

		dbma.updateCl_in_TB_cl(commands);
	}

	// 將全部輸入欄位設定為不可編輯
	public void setAllDisable() {
		nametxt.setEditable(false);
		contacttxt.setEditable(false);
		teltxt.setEditable(false);
		notetext.setEditable(false);
	}

	// 將全部輸入欄位設定為可編輯
	public void setAllEnable() {
		nametxt.setEditable(true);
		contacttxt.setEditable(true);
		teltxt.setEditable(true);
		notetext.setEditable(true);
	}

	// 預設編輯畫面狀態
	public void DefaultStatus() {
		editbtn.setVisible(true);
		updatebtn.setVisible(false);
		// ClearAll();
		setAllDisable();
	}

	// 將所有輸入欄位的值清空
	private void ClearAll() {
		notxt.setText(null);
		nametxt.setText(null);
		contacttxt.setText(null);
		teltxt.setText(null);
		notetext.setText(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 事件傾聽
		if (e.getSource() == editbtn) { // 處理編輯btn被按下
			if (getClStatus()) {
				editbtn.setVisible(false); // 隱藏編輯按鈕
				updatebtn.setVisible(true); // 顯示更新按鈕
				setAllEnable();
			}
		} else if (e.getSource() == clearbtn) { // 處理取消按鈕被按下
			ClearAll();
			setAllDisable();
		} else if (e.getSource() == updatebtn) { // 處理更新按鈕被按下
			updateCl();
			setAllDisable();
			editbtn.setVisible(true);
			updatebtn.setVisible(false);
		}
	}
}
