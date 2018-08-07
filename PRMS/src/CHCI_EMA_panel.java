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
	String[] MiType = { "��", "��", "��", "��", "��" };
	CDM_BS_dbma dbma = new CDM_BS_dbma();

	JPanel materials = new JPanel(); // JPanel�A�t�s�W���O������T

	JLabel titleiconlbl = new JLabel();
	JLabel titlelbl = new JLabel("�s�誫�ơG");

	JLabel nolbl = new JLabel("���ƽs���G");
	JLabel namelbl = new JLabel("���ƦW�١G");
	JLabel typelbl = new JLabel("�������O�G");
	JLabel notelbl = new JLabel("��      ���G");

	JTextField notxt = new JTextField("");
	JTextField datatxt = new JTextField("");
	JTextField nametxt = new JTextField("");
	JTextField pricetxt = new JTextField("");
	JTextArea notetxt = new JTextArea("", 3, 12);

	// �U�Ԧ����
	JComboBox<String> TypeCombo = new JComboBox<>(MiType);

	JScrollPane scroll = new JScrollPane(notetxt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	JRadioButton[] csradio = new JRadioButton[2];
	JRadioButton[] msradio = new JRadioButton[2];
	JButton editbtn = new JButton("�s��");
	JButton updatebtn = new JButton("��s");
	JButton clearbtn = new JButton("����");

	CHCI_EMA_panel() {
		DefaultStatus(); // �]�w�U����l���A
		
		materials.setBounds(0, 35, 500, 550);
		materials.setFont(new Font("������", 1, 16));
		materials.setLayout(null);
		materials.setOpaque(false);
		add(materials);

		titleiconlbl.setBounds(0, 0, 32, 32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		materials.add(titleiconlbl);
		titlelbl.setBounds(32, 0, 150, 50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("������", 1, 20));
		materials.add(titlelbl);

		// �]�m���ƽs��
		nolbl.setBounds(10, 45, 150, 45);
		nolbl.setFont(new Font("������", 1, 16));
		materials.add(nolbl);
		// notxt.setBounds(110,52,155,30);
		notxt.setBounds(110, 52, 210, 30);
		notxt.setFont(new Font("������", 1, 16));
		notxt.setEnabled(false);
		materials.add(notxt);

		// �]�m���ƦW��
		namelbl.setBounds(10, 90, 150, 45);
		namelbl.setFont(new Font("������", 1, 16));
		materials.add(namelbl);
		nametxt.setBounds(110, 97, 155, 30);
		nametxt.setFont(new Font("������", 1, 16));
		materials.add(nametxt);

		// �]�m�������O
		typelbl.setBounds(10, 135, 150, 45);
		typelbl.setFont(new Font("������", 1, 16));
		materials.add(typelbl);
		// �]�w�������O�]�U�Ԧ����^
		TypeCombo.setBounds(110, 137, 155, 35);
		TypeCombo.setFont(new Font("������", 0, 16));
		TypeCombo.setSelectedItem(null);;
		materials.add(TypeCombo);

		// �]�m�Ƶ�
		notelbl.setBounds(10, 180, 150, 45);
		notelbl.setFont(new Font("������", 1, 16));
		materials.add(notelbl);
		notetxt.setFont(new Font("������", 1, 16));
		notetxt.setLineWrap(true);
		scroll.setBounds(110, 180, 250, 90);
		materials.add(scroll);

		// �]�m���s
		editbtn.setBounds(310, 390, 150, 60);
		editbtn.setFont(new Font("������", 1, 16));
		editbtn.setBackground(Color.orange);
		editbtn.setBorderPainted(false);
		editbtn.addActionListener(this);
		materials.add(editbtn);
		updatebtn.setBounds(310, 390, 150, 60);
		updatebtn.setFont(new Font("������", 1, 16));
		updatebtn.setBackground(Color.orange);
		updatebtn.setBorderPainted(false);
		updatebtn.addActionListener(this);
		materials.add(updatebtn);
		clearbtn.setBounds(10, 390, 150, 60);
		clearbtn.setFont(new Font("������", 1, 16));
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		clearbtn.addActionListener(this);
		materials.add(clearbtn);
		setOpaque(false);
		setBounds(5, 65, 475, 490);
		setLayout(null);
	}

	private void updateMi() { // ��s����
		CPD_mi commands = new CPD_mi();
		commands.setNo(notxt.getText());
		commands.setName(nametxt.getText());
		commands.setState(TypeCombo.getSelectedItem().toString());
		commands.setNote(notetxt.getText());
		dbma.updateMi_in_TB_mi(commands);
	}

	// ���o�s���ϥΪ��A
	public boolean getMiStatus() {
		if (notxt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "�L���󪫮Ƹ��");
			return false;
		} else {
			return true;
		}
	}

	// �N������J���]�w�����i�s��
	public void setAllDisable() {
		nametxt.setEditable(false);
		TypeCombo.setEnabled(false); // jcombobox
		notetxt.setEditable(false);
	}

	// �N������J���]�w���i�s��
	public void setAllEnable() {
		nametxt.setEditable(true);
		TypeCombo.setEnabled(true); // jcombobox
		notetxt.setEditable(true);
	}

	// �w�]�s��e�����A
	public void DefaultStatus() {
		editbtn.setVisible(true);
		updatebtn.setVisible(false);
		setAllDisable();
	}

	// �N�Ҧ���J��쪺�ȲM��
	private void ClearAll() {
		notxt.setText(null);
		nametxt.setText(null);
		TypeCombo.setSelectedItem(null);
		notetxt.setText(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // �ƥ��ť
		if (e.getSource() == editbtn) { // �B�z�s��btn�Q���U
			if (getMiStatus()) {
				editbtn.setVisible(false); // ���ýs����s
				updatebtn.setVisible(true); // ��ܧ�s���s
				setAllEnable();
			}
		} else if (e.getSource() == clearbtn) { // �B�z�������s�Q���U
			ClearAll();
			setAllDisable();
		} else if (e.getSource() == updatebtn) { // �B�z��s���s�Q���U
			updateMi();
			setAllDisable();
			editbtn.setVisible(true);
			updatebtn.setVisible(false);
		}
	}
}
