import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class CHCI_ES_panel extends JPanel implements ActionListener{
	ToolCheck myTool = new ToolCheck();
	LimitedDocument limitDocument1 = new LimitedDocument(10);
	LimitedDocument limitDocument2 = new LimitedDocument(10);
	LimitedDocument limitDocument3 = new LimitedDocument(10);
	LimitedDocument limitDocument4 = new LimitedDocument(300);
	
	
	Font font1 = new Font("微軟正黑體",Font.BOLD,38);  //大標
	Font font2 = new Font("微軟正黑體",Font.BOLD,18);  //通用 按鈕類
	Font font3 = new Font("正黑體",1,16);  //數字大按鍵
	Font font4 = new Font("微軟正黑體",Font.BOLD,28);  //下方按鈕類
	
	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("編輯員工：");
	
	JPanel pane2 = new JPanel();
	JTable tableA = new JTable();
	JButton btn_submit = new JButton();
	DefaultTableModel tm = new DefaultTableModel(new Object[][]{},new Object[]{"員工編號","姓名","電話","職等"});
	JLabel lbl1 = new JLabel();
	JComboBox<?> combo_query = new JComboBox<Object>();
	String[] combo_str ={"身分證號","員工姓名","員工電話"};
	JTextField jtxtfd_query = new JTextField();
	
	JLabel[] lbl2 = new JLabel[7];
	String[] str_lbl2 = {"員工姓名:","員工生日:","身分證號:","居住地址:","職等:","狀態:","備註:"};
	JLabel title = new JLabel();
	JTextArea jtxtarea = new JTextArea("");
	
	JTextField jtxtfd_name = new JTextField();
	JTextField jtxtfd_id = new JTextField();
	JTextField jtxtfd_address = new JTextField();
	JButton btn_add = new JButton();
	JButton btn_edit = new JButton();
	
	JComboBox<?> combo_level = new JComboBox<Object>();
	String[] str_level = {"主管","店長","職員"};
	
	JComboBox<?> combo_status = new JComboBox<Object>();
	String[] str_status = {"在職","停職","離職"};
	
	JLabel lbl_gender = new JLabel();   //姓名標籤
	JDateChooser jtxtfd_birth = new JDateChooser();
	
	JLabel lbl_duty = new JLabel();
	
	JDateChooser jtxtfd_duty = new JDateChooser();
	JRadioButton[] radio_gender = new JRadioButton[2];   //員工性別rdb
	JTextField jtxtfd_telephone = new JTextField();
	
	JButton btn_cancel = new JButton();

	CHCI_ES_panel(){
		pane2 = new JPanel();
		pane2.setBounds(0,0,500,550);
		pane2.setOpaque(false);
		pane2.setLayout(null);
		add(pane2);
		
		
		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("editstaff_icon.png")));
		pane2.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("正黑體",1,20));	
		pane2.add(titlelbl);	
		
		for(int i=0;i<lbl2.length;i++){
			lbl2[i] = new JLabel(str_lbl2[i]);
			lbl2[i].setBounds(10,45+i*45,150,45);
			lbl2[i].setFont(font3);
			pane2.add(lbl2[i]);	
		}

		
		jtxtfd_name = new JTextField();           //員工姓名文字方塊
		jtxtfd_name.setFont(font3);
		jtxtfd_name.setBounds(110,52,100,30);;
		jtxtfd_name.setDocument(limitDocument1);
		pane2.add(jtxtfd_name);
		
		lbl_gender = new JLabel("性別:");
		lbl_gender.setFont(font3);
		lbl_gender.setBounds(230,52,50,30);
		pane2.add(lbl_gender);
		
		jtxtfd_birth = new JDateChooser();
		jtxtfd_birth.setBounds(110,97,120,30);
		jtxtfd_birth.setFont(font3);
		pane2.add(jtxtfd_birth);
		
		
		
		radio_gender = new JRadioButton[2];   //員工性別rdb
		
		radio_gender[0] = new JRadioButton("男");
		radio_gender[0].setSelected(true);
		radio_gender[1] = new JRadioButton("女");
		ButtonGroup group_gender = new ButtonGroup();
		for(int i=0;i<radio_gender.length;i++){
			group_gender.add(radio_gender[i]);
			radio_gender[i].setFont(font2);
			radio_gender[i].setBackground(Color.green);
			radio_gender[i].setContentAreaFilled(false);
			pane2.add(radio_gender[i]);
		}
		radio_gender[0].setBounds(280,52,50,30);
		radio_gender[1].setBounds(330,52,50,30);

		jtxtfd_id = new JTextField();       //身分證號文字方塊
		jtxtfd_id.setFont(font3);
		jtxtfd_id.setBounds(110,142,100,30);
		jtxtfd_id.setDocument(limitDocument2);
		pane2.add(jtxtfd_id);
		
		JLabel lbl_tel = new JLabel("電話:");
		lbl_tel.setFont(font3);
		lbl_tel.setBounds(230,142,50,30);
		pane2.add(lbl_tel);
		jtxtfd_telephone = new JTextField();
		jtxtfd_telephone.setBounds(300, 142, 100, 30);
		jtxtfd_telephone.setFont(font3);
		jtxtfd_telephone.setDocument(limitDocument3);
		pane2.add(jtxtfd_telephone);
		
		// here
		lbl_duty = new JLabel("到職日:");
		lbl_duty.setBounds(230,97,70,30);
		lbl_duty.setFont(font3);
		pane2.add(lbl_duty);
		
		jtxtfd_duty = new JDateChooser();
		jtxtfd_duty.setBounds(300,97,120,30);
		jtxtfd_duty.setFont(font3);
		pane2.add(jtxtfd_duty);
		
		jtxtfd_address = new JTextField();  //居住地
		jtxtfd_address.setFont(font3);
		jtxtfd_address.setBounds(110,187,290,30);
		jtxtfd_address.setDocument(limitDocument4);
		pane2.add(jtxtfd_address);
		
		combo_level = new JComboBox<Object>(str_level);    //職等下拉選單
		combo_level.setFont(font3);
		combo_level.setBounds(110,232,100,30);
		combo_level.setSelectedIndex(2);
		pane2.add(combo_level);
		
		combo_status = new JComboBox<Object>(str_status);    //狀態下拉選單
		combo_status.setFont(font3);
		combo_status.setBounds(110,277,155,30);
		pane2.add(combo_status);
		
		jtxtarea = new JTextArea("");
		jtxtarea.setLineWrap(true);
		jtxtarea.setFont(font2);
		JScrollPane span = new JScrollPane(jtxtarea,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
													ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		span.setBounds(110,322,290,80);
		//span.setFont(font2);
		pane2.add(span);

		btn_cancel = new JButton("取消");
		btn_cancel.setFont(font3);
		btn_cancel.setBounds(10,425,150,60);
		btn_cancel.setBackground(new Color(0, 148, 141));
		btn_cancel.addActionListener(this);
		pane2.add(btn_cancel);
		
		
		btn_add = new JButton("更新");
		btn_add.setFont(font3);
		btn_add.setBounds(310,425,150,60);
		btn_add.setBackground(Color.orange);
		btn_add.setVisible(false);
		btn_add.addActionListener(this);
		pane2.add(btn_add);
		
		
		btn_edit = new JButton("編輯");
		btn_edit.setFont(font3);
		btn_edit.setBounds(310,425,150,60);
		btn_edit.setBackground(Color.orange);
		btn_edit.setVisible(true);
		btn_edit.addActionListener(this);
	//	btn_edit.setEnabled(false);
		pane2.add(btn_edit);
		
		
		setOpaque(false);
		setBounds(5,65,475,490);
		setLayout(null); 
		
		
		
	}
	
	public boolean getjtxtfdnameTxt(){
		if(jtxtfd_name.getText().equals("")){
			JOptionPane.showMessageDialog(null,"無任何員工資料");
			return false;			
		}
		else{
			System.out.printf(jtxtfd_name.getText());
			return true;
		}
	}
	
	
	public String[] getAllDate(String str_id){
		
		String str_gender ="";
		if(radio_gender[0].isSelected()){
			str_gender ="男";
		}
		else{
			str_gender ="女";
		}
		String[] aStaff = {str_id,
				jtxtfd_name.getText(),
				str_gender,
				((JTextField)jtxtfd_birth.getDateEditor().getUiComponent()).getText(),
				((JTextField)jtxtfd_duty.getDateEditor().getUiComponent()).getText(),
				jtxtfd_id.getText(),
				jtxtfd_telephone.getText(),
				jtxtfd_address.getText(),
				combo_level.getSelectedItem().toString(),
				combo_status.getSelectedItem().toString(),
				jtxtarea.getText()};
		
		
		return aStaff;	
	}
	
	
	public void setRDB(){
		radio_gender[1].setSelected(true);
	}
	
	

    public void setAllDisable(){
    	jtxtfd_name.setEditable(false);
    	jtxtfd_duty.setEnabled(false);
    	jtxtfd_birth.setEnabled(false);
    	jtxtfd_address.setEditable(false);
    	jtxtfd_telephone.setEditable(false);
    	jtxtfd_id.setEditable(false);
    	combo_status.setEnabled(false);
    	combo_level.setEnabled(false);
    	jtxtarea.setEditable(false);
    	radio_gender[0].setEnabled(false);
    	radio_gender[1].setEnabled(false);
    }
    
    
    public void setAllEnable(){
    	jtxtfd_name.setEditable(true);
    	jtxtfd_duty.setEnabled(true);
    	jtxtfd_birth.setEnabled(true);
    	jtxtfd_address.setEditable(true);
    	jtxtfd_telephone.setEditable(true);
    	jtxtfd_id.setEditable(true);
    	combo_status.setEnabled(true);
    	combo_level.setEnabled(true);
    	jtxtarea.setEditable(true);
    	radio_gender[0].setEnabled(true);
    	radio_gender[1].setEnabled(true);
    }
    
    private void ClearAll(){    //清除所有欄位 預設值
		jtxtfd_id.setText(null);
		jtxtfd_name.setText(null);
		jtxtfd_address.setText(null);
		((JTextField)jtxtfd_birth.getDateEditor().getUiComponent()).setText("");
		((JTextField)jtxtfd_duty.getDateEditor().getUiComponent()).setText("");
		jtxtarea.setText(null);
		radio_gender[0].setSelected(true);
		jtxtfd_telephone.setText(null);
		
	}

    public void DefaultStatus(){
    	btn_add.setVisible(false);
		btn_edit.setVisible(true);
		//ClearAll();
		setAllDisable();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn_edit){
			if(getjtxtfdnameTxt()){
				btn_add.setVisible(true);
				btn_edit.setVisible(false);
				setAllEnable();
				
			}
		}
		/*
		if(e.getSource() == btn_add){
			btn_add.setVisible(false);
			btn_edit.setVisible(true);
			setAllDisable();
		}
		*/
		
		if(e.getSource() == btn_cancel){
			DefaultStatus();
			ClearAll();
		}
		
	}
	
	public boolean CheckFd(){             //檢查所有欄位是否正確符合邏輯
		if(myTool.isName(jtxtfd_name.getText())){
			if(myTool.CK_Not_null(((JTextField)jtxtfd_birth.getDateEditor().getUiComponent()).getText())){
				if(myTool.CK_Not_null(((JTextField)jtxtfd_duty.getDateEditor().getUiComponent()).getText())){
					if(myTool.PID(jtxtfd_id.getText())){
						if(myTool.isNumeric(jtxtfd_telephone.getText())){
							if(myTool.CK_address_Not_null(jtxtfd_address.getText())){
								return true;
							}
						}
					}
				}
			}
			
		}
		return false;
	}
    




}
