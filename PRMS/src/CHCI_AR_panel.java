import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import com.toedter.calendar.JDateChooser;

//CHCI_AR_panel: Class HumanComputerInteraction_AddResevation_panel (人機介面-[新增預約]操作畫面類別)
public class CHCI_AR_panel extends JPanel implements ActionListener{
	CDM_ST_dbma dbma = new CDM_ST_dbma();
	LimitedDocument limitDocument1 = new LimitedDocument(10);
	LimitedDocument limitDocument2 = new LimitedDocument(10);
	LimitedDocument limitDocument4 = new LimitedDocument(300);
	ToolCheck myTool = new ToolCheck();
	JDateChooser dateChooser = new JDateChooser();
	SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
	
	JPanel addres_pane=new JPanel();			//JPanel，含新增預約相關資訊	

	JLabel titleiconlbl=new JLabel();
	JLabel titlelbl=new JLabel("建立新預約：");
	JLabel namelbl=new JLabel("姓　　名：");
	JLabel datelbl=new JLabel("日　　期：");
	JLabel timelbl=new JLabel("時　　間：");	
	JLabel tellbl=new JLabel("電　　話：");
	JLabel sumlbl=new JLabel("人　　數：");	
	JLabel mnotelbl=new JLabel("備      註：");	
	
    
    JTextField nametxt=new JTextField("");
    JTextField timetxt=new JTextField("");
    JTextField teltxt=new JTextField("");
    JTextField sumtetxt=new JTextField("");
    JTextArea mnotetxt=new JTextArea("",3,12);
    
    pickdate_panel d1=new pickdate_panel();
    
    JScrollPane scroll=new JScrollPane(mnotetxt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS 
    		, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
	JComboBox combo_hour = new JComboBox();
	JComboBox combo_minute = new JComboBox();
	JComboBox combo_query = new JComboBox();
	JComboBox combo_num = new JComboBox();
	JComboBox combo_pet = new JComboBox();
	String[] combo_str = {"電話","姓名","日期"};
	String[] str_combopet = {"1寵","2寵","3寵","4寵","5寵","6寵","7寵","8寵","9寵","10寵","11寵","12寵","13寵","14寵","15寵","16寵","17寵","18寵","19寵","20寵"};
	String[] str_comboNum = {"1人","2人","3人","4人","5人","6人","7人","8人","9人","10人","11人","12人","13人","14人","15人","16人","17人","18人","19人","20人"};
	String[] str_hour = {"上午10點","上午11點","中午12點","下午01點","下午02點","下午03點","下午04點","下午05點","下午06點","晚間07點","晚間08點","晚間09點"};
	//String[] str_range = {"上午","下午"};
	String[] str_minute = {"00分","15分","30分","45分"};
	//JComboBox combo_range = new JComboBox();
	//JComboBox combo_range = new JComboBox()
   
    JRadioButton[] csradio=new JRadioButton[2];
    JRadioButton[] msradio=new JRadioButton[2];
    JButton addbtn=new JButton("新增");
    JButton clearbtn=new JButton("重填");
	CHCI_AR_panel(){
		

	    
		addres_pane.setBounds(0,0,500,550);
		addres_pane.setFont(new Font("正黑體",1,16));
		addres_pane.setLayout(null);
		addres_pane.setOpaque(false);
		add(addres_pane);

		titleiconlbl.setBounds(0,0,32,32);
		titleiconlbl.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		addres_pane.add(titleiconlbl);	
		titlelbl.setBounds(32,0,150,50);
		titlelbl.setForeground(Color.red);
		titlelbl.setFont(new Font("正黑體",1,20));	
		addres_pane.add(titlelbl);			 
	 
		//設置姓名
		namelbl.setBounds(10,45,100,45);
		namelbl.setFont(new Font("正黑體",1,16));	
		addres_pane.add(namelbl);	
		nametxt.setBounds(110,52,155,30);
		nametxt.setFont(new Font("正黑體",1,16));	
		nametxt.setDocument(limitDocument1);
		//nametxt.setEnabled(false);
		addres_pane.add(nametxt);	
		//設置日期
		datelbl.setBounds(10,90,150,45);
		datelbl.setFont(new Font("正黑體",1,16));	
		addres_pane.add(datelbl);
			//設置日期選擇器
		dateChooser.setBounds(110,97,160,30);
		dateChooser.setFont(new Font("正黑體",1,16));
		//dateChooser.setEnabled(false);
		((JTextField)dateChooser.getDateEditor().getUiComponent()).setEditable(false);
		addres_pane.add(dateChooser);		
		//設置時間
		timelbl.setBounds(10,135,150,45);
		timelbl.setFont(new Font("正黑體",1,16));	
		addres_pane.add(timelbl);	
			//設置時間下拉式選單
		combo_hour = new JComboBox(str_hour);  //小時下拉選單
		combo_hour.setFont(new Font("正黑體",1,16));	
		combo_hour.setBounds(110,142,110,30);
		addres_pane.add(combo_hour);
		
		combo_minute = new JComboBox(str_minute);    //分鐘下拉選單
		combo_minute.setFont(new Font("正黑體",1,16));	
		combo_minute.setBounds(225,142,80,30);
		addres_pane.add(combo_minute);

		//設置電話
		tellbl.setBounds(10,180,150,45);
		tellbl.setFont(new Font("正黑體",1,16));	
		addres_pane.add(tellbl);	
		teltxt.setBounds(110,187,155,30);
		teltxt.setDocument(limitDocument2);
		teltxt.setFont(new Font("正黑體",1,16));	
		addres_pane.add(teltxt);	
		//設置人數
		sumlbl.setBounds(10,225,150,45);
		sumlbl.setFont(new Font("正黑體",1,16));	
		addres_pane.add(sumlbl);	
			//設置人數下拉式選單
		combo_num = new JComboBox(str_comboNum);     //人數下拉選單
		combo_num.setFont(new Font("正黑體",1,16));	
		combo_num.setBounds(110,232,90,30);
		addres_pane.add(combo_num);
		
		combo_pet = new JComboBox(str_combopet);     //寵物數下拉選單
		combo_pet.setFont(new Font("正黑體",1,16));	
		combo_pet.setBounds(220,232,90,30);
		addres_pane.add(combo_pet);
		
		//設置備註
		mnotelbl.setBounds(10,270,150,45);
		mnotelbl.setFont(new Font("正黑體",1,16));	
		addres_pane.add(mnotelbl);				 
		mnotetxt.setFont(new Font("正黑體",1,16));
		mnotetxt.setBorder(BorderFactory.createLineBorder(Color.blue));
		mnotetxt.setLineWrap(true);
		mnotetxt.setDocument(limitDocument4);
		scroll.setBounds(110,277,250,90);
		addres_pane.add(scroll);		
		//設置按鈕
		addbtn.setBounds(310,425,150,60);
		addbtn.setFont(new Font("正黑體",1,16));
		addbtn.setBackground(Color.orange);
		addbtn.setBorderPainted(false);
		addbtn.addActionListener(this);
		addres_pane.add(addbtn);	
		
		clearbtn.setBounds(10,425,150,60);
		clearbtn.setFont(new Font("正黑體",1,16));	
		clearbtn.setBackground(new Color(0, 148, 141));
		clearbtn.setBorderPainted(false);
		clearbtn.addActionListener(this);
		addres_pane.add(clearbtn);	
		setOpaque(false);
		setBounds(5,65,475,490);
		//setVisible(false);
		setLayout(null); 
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addbtn){
			if(checkFd()){
				if(JOptionPane.showConfirmDialog(null,"確定要新增預約嗎?","確認新增預約",JOptionPane.OK_CANCEL_OPTION) == 0){
					AddRes();
				}
			}
		}
		if(e.getSource()==clearbtn){
			ClearAll();
		}
		
			
	}
	
	private void ClearAll (){
		nametxt.setText(null);
		((JTextField)dateChooser.getDateEditor().getUiComponent()).setText("");
		teltxt.setText(null);
		mnotetxt.setText(null);
	}
	
	public boolean checkFd(){
		if(myTool.isName(nametxt.getText())){
			if(myTool.CK_Date_Not_null(((JTextField)dateChooser.getDateEditor().getUiComponent()).getText())){
				if(myTool.isNumeric(teltxt.getText())){
					return true;
				}
			}
				
		}
		return false;
	}
	
	
	
	public void AddRes(){
		String time = combo_hour.getSelectedItem().toString()+combo_minute.getSelectedItem().toString();   //小時 + 分鐘
		String Rid ="R"+sdf.format(new Date());	
		String[] aRes = {Rid,
				nametxt.getText(),
				((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(),
				time,
				teltxt.getText(),
				combo_num.getSelectedItem().toString(),
				combo_pet.getSelectedItem().toString(),
				"預約中",
				mnotetxt.getText()};
		
	        	dbma.insertRD_into_TB_res(aRes);
	        	ClearAll();
		}
	}

