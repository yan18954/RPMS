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
	// �ܼƳ]�w
	String[] status = { "���I��", "�w�I��", "�����q��", "����" };
	ArrayList<String> companylist = new ArrayList<String>();

	CDM_BS_dbma dbma = new CDM_BS_dbma();

	JPanel order_pane = new JPanel(); // JPanel�A�t�s�q��O������T

	JLabel titleiconlbl = new JLabel();
	JLabel titlelbl = new JLabel("�s��q��G");

	JLabel nolbl = new JLabel("�q��s���G");
	JLabel datelbl = new JLabel("�q�����G");
	JLabel statelbl = new JLabel("�q�檬�A�G");
	JLabel companylbl = new JLabel("�t�ӡG");
	JLabel totallbl = new JLabel("�`���B�G");

	// ��J���
	JTextField notxt = new JTextField("");
	JTextField datetxt = new JTextField("");
	JTextField statetxt = new JTextField("");
	JTextField totaltxt = new JTextField("");

	// �U�Ԧ����
	JComboBox<String> StatusCombo = new JComboBox<>(status);
	JComboBox<String> CompanyCombo = new JComboBox<>();

	JRadioButton[] csradio = new JRadioButton[2];
	JRadioButton[] msradio = new JRadioButton[2];
	JButton editbtn = new JButton("�s��");
	JButton updatebtn = new JButton("��s");
	JButton clearbtn = new JButton("����");
	
	CHCI_EO_panel() {
		DefaultStatus(); // �]�w�U����l���A

		order_pane.setBounds(0, 35, 500, 550);
		order_pane.setFont(new Font("������", 1, 16));
		order_pane.setLayout(null);
		order_pane.setOpaque(false);
		add(order_pane);

		titleiconlbl.setBounds(0, 0, 32, 32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		order_pane.add(titleiconlbl);
		titlelbl.setBounds(32, 0, 150, 50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("������", 1, 20));
		order_pane.add(titlelbl);

		// �]�m�q��s��
		nolbl.setBounds(10, 45, 150, 45);
		nolbl.setFont(new Font("������", 1, 16));
		order_pane.add(nolbl);
		notxt.setBounds(110, 52, 210, 30);
		notxt.setFont(new Font("������", 1, 16));
		notxt.setEnabled(false);
		order_pane.add(notxt);
		// �]�m�إߤ��
		datelbl.setBounds(10, 90, 150, 45);
		datelbl.setFont(new Font("������", 1, 16));
		order_pane.add(datelbl);
		datetxt.setBounds(110, 97, 155, 30);
		datetxt.setFont(new Font("������", 1, 16));
		datetxt.setEditable(false);
		order_pane.add(datetxt);
		// �]�m�q�檬�A
		statelbl.setBounds(10, 135, 150, 45);
		statelbl.setFont(new Font("������", 1, 16));
		order_pane.add(statelbl);

		// �]�w�q�檬�A�]�U�Ԧ����^
		StatusCombo.setBounds(110, 137, 100, 35);
		StatusCombo.setFont(new Font("������", 0, 16));
		StatusCombo.setSelectedItem(null);
		order_pane.add(StatusCombo);

		// �]�m�t�ӽs��
		// CompanyCombo.setBounds(110,187,100,35); //��l�ƭ�
		CompanyCombo.setBounds(110, 187, 155, 35);
		companylbl.setBounds(10, 180, 150, 45);
		companylbl.setFont(new Font("������", 1, 16));
		getCompanyList(); // �]�w�t�ӤU�Ԧ��C��
		order_pane.add(companylbl);
		// setCompanyNOCombo();

		// �]�m�t�ӿ�ܡ]�U�Ԧ����^
		// CompanyCombo.setBounds(110,187,100,35); //��l�ƭ�
		CompanyCombo.setBounds(110, 187, 155, 35);
		CompanyCombo.setFont(new Font("������", 0, 16));
		CompanyCombo.setSelectedItem(null);
		order_pane.add(CompanyCombo);

		// �]�m�`���B
		totallbl.setBounds(10, 225, 150, 45);
		totallbl.setFont(new Font("������", 1, 16));
		order_pane.add(totallbl);
		totaltxt.setFont(new Font("������", 1, 16));
		totaltxt.setBounds(110, 232, 155, 30);
		order_pane.add(totaltxt);
		// �]�m���s
		editbtn.setBounds(310, 390, 150, 60); // �s����s
		editbtn.setFont(new Font("������", 1, 16));
		editbtn.setBackground(Color.orange);
		editbtn.setBorderPainted(false);
		editbtn.addActionListener(this);
		order_pane.add(editbtn);
		updatebtn.setBounds(310, 390, 150, 60); // ��s���s
		updatebtn.setFont(new Font("������", 1, 16));
		updatebtn.setBackground(Color.orange);
		updatebtn.setBorderPainted(false);
		updatebtn.addActionListener(this);
		order_pane.add(updatebtn);
		clearbtn.setBounds(10, 390, 150, 60); // �������s
		clearbtn.setFont(new Font("������", 1, 16));
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		clearbtn.addActionListener(this);
		order_pane.add(clearbtn);
		setOpaque(false);
		setBounds(5, 65, 475, 490);
		setLayout(null);
	}

	public void getCompanyList() {	//���o�P��s�t�ӦC��
		CompanyCombo.removeAllItems();
		companylist = dbma.findRD_in_TB_cllist();
		for(int i=0 ;i<companylist.size() ;i++ ){
			CompanyCombo.addItem(companylist.get(i));
		}
		
		CompanyCombo.setSelectedItem(null);
	}

	// ���o�s���ϥΪ��A
	public boolean getOrderStatus() {
		if (notxt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "�L����q����");
			return false;
		} else {
			System.out.printf(notxt.getText());
			return true;
		}
	}

	private void updateOrder() { // ��s�q��
		CPD_order commands = new CPD_order();
		commands.setNo(notxt.getText());
		commands.setDate(datetxt.getText());
		commands.setStatus((StatusCombo.getSelectedIndex()));
		commands.setClNo(dbma.findRD_in_TB_ClColumn(CompanyCombo.getSelectedItem().toString(), "CL_company", "CL_no"));
		commands.setAmount(Integer.parseInt(totaltxt.getText()));

		dbma.updateOrder_in_TB_order(commands);
	}

	// �N������J���]�w�����i�s��
	public void setAllDisable() {
		datetxt.setEditable(false);
		StatusCombo.setEnabled(false); // jcombobox
		CompanyCombo.setEnabled(false); // jconbobox
		totaltxt.setEditable(false);
	}

	// �N������J���]�w���i�s��
	public void setAllEnable() {
		datetxt.setEditable(true);
		StatusCombo.setEnabled(true); // jcombobox
		CompanyCombo.setEnabled(true); // jcombobox
		totaltxt.setEditable(true);
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
		datetxt.setText(null);
		StatusCombo.setSelectedItem(null);
		CompanyCombo.setSelectedItem(null);;
		totaltxt.setText(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // �ƥ��ť
		if (e.getSource() == editbtn) { // �B�z�s��btn�Q���U
			if (getOrderStatus()) {
				editbtn.setVisible(false); // ���ýs����s
				updatebtn.setVisible(true); // ��ܧ�s���s
				setAllEnable();
			}
		} else if (e.getSource() == clearbtn) { // �B�z�������s�Q���U
			ClearAll();
			setAllDisable();
		} else if (e.getSource() == updatebtn) { // �B�z��s���s�Q���U
			updateOrder();
			setAllDisable();
			editbtn.setVisible(true);
			updatebtn.setVisible(false);
		}
	}
}
