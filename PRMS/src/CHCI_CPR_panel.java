import java.awt.Color;
import java.awt.Font;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//�H�����ʼh���O
//CHCI_MMAO_panel: Class HumanComputerInteraction_PurchaseReport_panel (�H������-[���ͱ��ʳ���]�ާ@�e�����O)
public class CHCI_CPR_panel extends JPanel{
	JPanel pane1=new JPanel();
	
	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("���ͱ��ʳ���G");
	JLabel lbl1=new JLabel("�_�l��");
	JLabel lbl2=new JLabel("  ��     ");
    pickdate_panel d1=new pickdate_panel();
    pickdate_panel d2=new pickdate_panel();
	JButton exportbtn=new JButton("�ץX");
	JButton clearbtn=new JButton("�M��");

	
	CHCI_CPR_panel() {
		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("������",1,20));	
		add(titlelbl);
		
		pane1.setBounds(0,0, 1000, 600);
		add(pane1);

		//�_�l����]�m
        lbl1.setBounds(15,45,50,45);
		lbl1.setFont(new Font("������",1,15));	
		pane1.add(lbl1);
		d1.setBounds(90,52,200,45);
		pane1.add(d1);
		//��������]�m
        lbl2.setBounds(40,90,50,45);
		lbl2.setFont(new Font("������",1,16));	
		pane1.add(lbl2);
		d2.setBounds(90,97,200,45);
		pane1.add(d2);
		//���s�]�m
		exportbtn.setBounds(300,50,80,80);
		exportbtn.setFont(new Font("������",1,16));	
        exportbtn.setBorderPainted(false);
		exportbtn.setBackground(Color.orange);
		pane1.add(exportbtn);
		clearbtn.setBounds(390,50,80,80);
		clearbtn.setFont(new Font("������",1,16));	
        clearbtn.setBorderPainted(false);
		clearbtn.setBackground(Color.pink);

		pane1.add(clearbtn);
		pane1.setLayout(null);
		pane1.setBackground(new Color(255, 242, 179));
        setBounds(0,100,1000,600);
        setLayout(null);
	}
	
	 //�ƥ��ť�{��: �M����J���
	 //�ƥ��ť�{��: �ˬd��������O�_�j��_�l��� 
}
