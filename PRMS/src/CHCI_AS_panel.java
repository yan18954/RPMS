import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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

public class CHCI_AS_panel extends JPanel implements ActionListener{
		CDM_ST_dbma dbma = new CDM_ST_dbma();   //員工資料庫存取類別
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
		JLabel titlelbl=new JLabel("新增員工：");
		JPanel pane2 = new JPanel();
		JTable tableA = new JTable();
		JButton btn_submit = new JButton();
		DefaultTableModel tm = new DefaultTableModel(new Object[][]{},new Object[]{"員工編號","姓名","電話","職等"});
		JLabel lbl1 = new JLabel();
		JComboBox combo_query = new JComboBox();
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
		JButton btn_cancel = new JButton();
		JComboBox combo_level = new JComboBox();
		String[] str_level = {"主管","店長","職員"};
		
		JComboBox combo_status = new JComboBox();
		String[] str_status = {"在職","停職","離職"};
		
		JLabel lbl_gender = new JLabel();   //姓名標籤
		
		JLabel lbl_duty = new JLabel();
		
		JDateChooser jtxtfd_duty = new JDateChooser();
		JDateChooser jtxtfd_birth = new JDateChooser();
		JRadioButton[] radio_gender = new JRadioButton[2];   //員工性別rdb
		JTextField jtxtfd_telephone = new JTextField();
		

	CHCI_AS_panel(){
		pane2 = new JPanel();
		pane2.setBounds(0,0,500,550);
		pane2.setOpaque(false);
		pane2.setLayout(null);
		add(pane2);
		
		
		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addstaff_icon.png")));
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
		
	//	jtxtfd_birth = new JDateChooser();
		jtxtfd_birth.setBounds(110,97,120,30);
		jtxtfd_birth.setFont(font3);
		((JTextField)jtxtfd_birth.getDateEditor().getUiComponent()).setEditable(false);
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
		lbl_duty.setBounds(230,97,100,30);
		lbl_duty.setFont(font3);
		pane2.add(lbl_duty);
		
		jtxtfd_duty = new JDateChooser();    //到職日
		jtxtfd_duty.setBounds(300,97,120,30);
		jtxtfd_duty.setFont(font3);
		((JTextField)jtxtfd_duty.getDateEditor().getUiComponent()).setEditable(false);
		pane2.add(jtxtfd_duty);
		
		jtxtfd_address = new JTextField();  //居住地
		jtxtfd_address.setFont(font3);
		jtxtfd_address.setBounds(110,187,290,30);
		jtxtfd_address.setDocument(limitDocument4);
		pane2.add(jtxtfd_address);
		
		combo_level = new JComboBox(str_level);    //職等下拉選單
		combo_level.setFont(font3);
		combo_level.setBounds(110,232,100,30);
		combo_level.setSelectedIndex(2);
		pane2.add(combo_level);
		
		combo_status = new JComboBox(str_status);    //狀態下拉選單
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
		
		btn_add = new JButton("新增");
		btn_add.setFont(font3);
		btn_add.setBounds(310,425,150,60);
		btn_add.setBackground(Color.orange);
		btn_add.addActionListener(this);
		pane2.add(btn_add);
		
		setOpaque(false);
		setBounds(5,65,475,490);
		setLayout(null); 

	}
	
	public void actionPerformed(ActionEvent e){   //事件傾聽
		if(e.getSource() == btn_add){
			if(CheckFd()){
				if(JOptionPane.showConfirmDialog(null,"確定要新增員工資料嗎?","確認新增員工",JOptionPane.OK_CANCEL_OPTION) == 0){
					if(myTool.PID(jtxtfd_id.getText())){
						AddStaff();   //呼叫新增員工方法
					}		
				}
			}
		}
		
		
		if(e.getSource() == btn_cancel){
			ClearAll(); //按下取消
		}

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
	
	private void AddStaff(){         //新增員工
		String rq_char ="";
		if(combo_level.getSelectedIndex()==0){
			rq_char = "M";
		}
		else if(combo_level.getSelectedIndex()==1){
			rq_char = "S";
		}
		else{
			rq_char = "E";
		}
		
		String formatStr = "%04d";
		String rq_id= dbma.findMaxId_in_TB_staff(rq_char);
		int count_id = (Integer.parseInt(rq_id)+1);	
		String formatAns = String.format(formatStr,count_id);		
		String str_id = rq_char+"01"+formatAns;   //員工編號 ex: E01000
		//System.out.println("EMPL_ID="+str_id);
		
		String str_gender ="";
		if(radio_gender[0].isSelected()){
			str_gender ="男";
		}
		else{
			str_gender ="女";
		}
		/*
		System.out.println("gender="+str_gender);
		System.out.println("name="+jtxtfd_name.getText());
		System.out.println("birth="+jtxtfd_birth.getText());
		System.out.println("id="+jtxtfd_id.getText());
		System.out.println("ps="+jtxtarea.getText());
		System.out.println("combo_status="+combo_status.getSelectedItem().toString());
		System.out.println("duty="+jtxtfd_duty.getText());
		System.out.println("address="+jtxtfd_address.getText());
		System.out.println("combo_level="+combo_level.getSelectedItem().toString());
		*/
		
		
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
				jtxtarea.getText(),
				jtxtfd_id.getText()};
		//System.out.println("按下新增按鈕");
		//String[] str_test = {"1","2","3","4","5","6","7","8","9","10"};
		dbma.insertRD_into_TB_staff(aStaff);
		//System.out.print( ((JTextField)jtxtfd_birth.getDateEditor().getUiComponent()).getText()   );
		ClearAll();
	}
	
	private boolean CheckFd(){             //檢查所有欄位是否正確符合邏輯
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
	

	
	
	public void keyTyped(KeyEvent e) {  
	    // TODO Auto-generated method stub  
	    String s = jtxtfd_address.getText();  
	    if(s.length() >= 8) e.consume();  
	}  
    
}
