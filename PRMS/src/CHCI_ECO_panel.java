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

//�H�����ʼh���O
//CHCI_ECO_panel: Class HumanComputerInteraction_EditCOmpany_panel (�H������-[�s��t��]�ާ@�e�����O)
public class CHCI_ECO_panel extends JPanel implements ActionListener {
	CDM_BS_dbma dbma = new CDM_BS_dbma();

	JPanel company_pane = new JPanel(); // JPanel�A�t�s�q��O������T

	JLabel titleiconlbl = new JLabel();
	JLabel titlelbl = new JLabel("�s��t�ӡG");

	JLabel nolbl = new JLabel("�t�ӽs���G");
	JLabel namelbl = new JLabel("�t�ӦW�١G");
	JLabel contactlbl = new JLabel("�t���p���H�G");
	JLabel tellbl = new JLabel("�t�ӹq�ܡG");
	JLabel notelbl = new JLabel("�t�ӳƵ��G");

	JTextField notxt = new JTextField("");
	JTextField nametxt = new JTextField("");
	JTextField contacttxt = new JTextField("");
	JTextField teltxt = new JTextField("");
	JTextArea notetext = new JTextArea("");
	JScrollPane scroll = new JScrollPane(notetext, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	JRadioButton[] csradio = new JRadioButton[2];
	JRadioButton[] msradio = new JRadioButton[2];
	JButton editbtn = new JButton("�s��");
	JButton updatebtn = new JButton("��s");
	JButton clearbtn = new JButton("����");

	CHCI_ECO_panel() {
		DefaultStatus(); // �]�w�U����l���A
		
		company_pane.setBounds(0, 35, 500, 550);
		company_pane.setFont(new Font("������", 1, 16));
		company_pane.setLayout(null);
		company_pane.setOpaque(false);
		add(company_pane);

		titleiconlbl.setBounds(0, 0, 32, 32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		company_pane.add(titleiconlbl);
		titlelbl.setBounds(32, 0, 150, 50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("������", 1, 20));
		company_pane.add(titlelbl);

		// �]�m�t�ӽs��
		nolbl.setBounds(10, 45, 150, 45);
		nolbl.setFont(new Font("������", 1, 16));
		company_pane.add(nolbl);
		// notxt.setBounds(110,52,155,30);
		notxt.setBounds(110, 52, 210, 30);
		notxt.setFont(new Font("������", 1, 16));
		notxt.setEnabled(false);
		company_pane.add(notxt);
		// �]�m�t�ӦW��
		namelbl.setBounds(10, 90, 150, 45);
		namelbl.setFont(new Font("������", 1, 16));
		company_pane.add(namelbl);
		nametxt.setBounds(110, 97, 155, 30);
		nametxt.setFont(new Font("������", 1, 16));
		company_pane.add(nametxt);
		// �]�m�t���p���H
		contactlbl.setBounds(10, 135, 150, 45);
		contactlbl.setFont(new Font("������", 1, 16));
		company_pane.add(contactlbl);
		contacttxt.setBounds(110, 142, 155, 30);
		contacttxt.setFont(new Font("������", 1, 16));
		company_pane.add(contacttxt);
		// �]�m�t�ӳs���q��
		tellbl.setBounds(10, 180, 150, 45);
		tellbl.setFont(new Font("������", 1, 16));
		company_pane.add(tellbl);
		teltxt.setBounds(110, 187, 155, 30);
		teltxt.setFont(new Font("������", 1, 16));
		company_pane.add(teltxt);
		// �]�m�t�ӳƵ�
		notelbl.setBounds(10, 225, 150, 45);
		notelbl.setFont(new Font("������", 1, 16));
		company_pane.add(notelbl);
		notetext.setFont(new Font("������", 1, 16));
		notetext.setBorder(BorderFactory.createLineBorder(Color.blue));
		notetext.setLineWrap(true);
		scroll.setBounds(110, 232, 250, 90);
		company_pane.add(scroll);

		// �]�m���s
		editbtn.setBounds(310, 390, 150, 60); // �s����s
		editbtn.setFont(new Font("������", 1, 16));
		editbtn.setBackground(Color.orange);
		editbtn.setBorderPainted(false);
		editbtn.addActionListener(this);
		company_pane.add(editbtn);
		updatebtn.setBounds(310, 390, 150, 60); // ��s���s
		updatebtn.setFont(new Font("������", 1, 16));
		updatebtn.setBackground(Color.orange);
		updatebtn.setBorderPainted(false);
		updatebtn.addActionListener(this);
		company_pane.add(updatebtn);
		clearbtn.setBounds(10, 390, 150, 60); // �������s
		clearbtn.setFont(new Font("������", 1, 16));
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		clearbtn.addActionListener(this);
		company_pane.add(clearbtn);
		setOpaque(false);
		setBounds(5, 65, 475, 490);
		setLayout(null);
	}

	// ���o�s���ϥΪ��A
	public boolean getClStatus() {
		if (notxt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "�L����t�Ӹ��");
			return false;
		} else {
			System.out.printf(notxt.getText());
			return true;
		}
	}

	private void updateCl() { // ��s�t��
		CPD_cl commands = new CPD_cl();
		commands.setNo(notxt.getText());
		commands.setCompany(nametxt.getText());
		commands.setContact(contacttxt.getText());
		commands.setContactphone(teltxt.getText());
		commands.setNote(notetext.getText());

		dbma.updateCl_in_TB_cl(commands);
	}

	// �N������J���]�w�����i�s��
	public void setAllDisable() {
		nametxt.setEditable(false);
		contacttxt.setEditable(false);
		teltxt.setEditable(false);
		notetext.setEditable(false);
	}

	// �N������J���]�w���i�s��
	public void setAllEnable() {
		nametxt.setEditable(true);
		contacttxt.setEditable(true);
		teltxt.setEditable(true);
		notetext.setEditable(true);
	}

	// �w�]�s��e�����A
	public void DefaultStatus() {
		editbtn.setVisible(true);
		updatebtn.setVisible(false);
		// ClearAll();
		setAllDisable();
	}

	// �N�Ҧ���J��쪺�ȲM��
	private void ClearAll() {
		notxt.setText(null);
		nametxt.setText(null);
		contacttxt.setText(null);
		teltxt.setText(null);
		notetext.setText(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // �ƥ��ť
		if (e.getSource() == editbtn) { // �B�z�s��btn�Q���U
			if (getClStatus()) {
				editbtn.setVisible(false); // ���ýs����s
				updatebtn.setVisible(true); // ��ܧ�s���s
				setAllEnable();
			}
		} else if (e.getSource() == clearbtn) { // �B�z�������s�Q���U
			ClearAll();
			setAllDisable();
		} else if (e.getSource() == updatebtn) { // �B�z��s���s�Q���U
			updateCl();
			setAllDisable();
			editbtn.setVisible(true);
			updatebtn.setVisible(false);
		}
	}
}
