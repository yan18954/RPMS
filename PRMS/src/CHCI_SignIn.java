import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//人機互動層類別
//CHCI_SI_panel: Class HumanComputerInteraction_SignIn_panel (人機介面-[登入介面]操作畫面類別)
public class CHCI_SignIn extends JPanel implements ActionListener{
	CDM_SignIn_dbma SG_dbma = new CDM_SignIn_dbma();
	JLayeredPane lpane = new JLayeredPane();
	JPanel right_pane=new JPanel();
	JPanel left_pane=new JPanel();
	
	JTextField txtAc=new JTextField();
	JPasswordField txtPw=new JPasswordField ();
	JButton btnSign =new JButton("登 入");
	JButton btnExit =new JButton("離 開");
	
	
	
	CHCI_SignIn(){
		//設置JPanel
		
		txtAc=new JTextField();
		txtPw=new JPasswordField ();
		setRightpane();
		setLeftpane();
		
		lpane.setBounds(0, 0, 1000, 700);
		//將登入JPanel設置在圖片JPanel之前
        lpane.add(right_pane, new Integer(1), 0);	
        lpane.add(left_pane, new Integer(0), 0);
		
        add(lpane);
        
        setBackground(Color.pink);
        setSize(1000,700);
        setLayout(null);
        setVisible(true);		
	}
	
	//method
	//設置右邊panel
	private void setRightpane(){
		
		JLabel lbltit=new JLabel("寵物餐廳管理系統");
		JLabel lblsubtit=new JLabel("PetRestaurantManagementSystem");
		JLabel lblaccount=new JLabel("帳號");
		JLabel lblpassword=new JLabel("密碼");		
		
		//設置標題
		lbltit.setBounds(60,50,250,80);
		lbltit.setFont(new Font("繁黑體",1,25));
		right_pane.add(lbltit);
		lblsubtit.setBounds(45,100,300,75);
		lblsubtit.setFont(new Font("繁黑體",0,16));
		right_pane.add(lblsubtit);
		
		//
		
		//設置帳號密碼欄位
		lblaccount.setBounds(20,250,100,80);
		lblaccount.setFont(new Font("繁黑體",1,22));
		right_pane.add(lblaccount);		
		txtAc.setBounds(80,275,200,30);
		txtAc.setBorder(BorderFactory.createLoweredBevelBorder());
		right_pane.add(txtAc);

		lblpassword.setBounds(20,310,100,80);
		lblpassword.setFont(new Font("繁黑體",1,22));
		right_pane.add(lblpassword);	
		txtPw.setBounds(80,335,200,30);
		txtPw.setBorder(BorderFactory.createLoweredBevelBorder());
		right_pane.add(txtPw);

		//設置登入和離開按鈕
		btnSign.setBounds(50,400,100,60);
		btnSign.setFont(new Font("繁黑體",1,16));
		btnSign.addActionListener(this);
	//	btnSign.setBorder(null);
	//	btnSign.setBackground(new Color(219,236,240));
		right_pane.add(btnSign);
		
		btnExit.setBounds(180, 400, 100, 60);
		btnExit.setFont(new Font("繁黑體",1,16));
		right_pane.add(btnExit);
		
		right_pane.setLayout(null);
		right_pane.setBounds(650,0,350,700);
		right_pane.setBackground(Color.yellow);
		right_pane.setBackground(new Color(.5f, .8f, .5f, .5f));
		add(right_pane);
	}
	
	//設置左邊panel
	//left_pane:用來顯示背景圖片
	void setLeftpane(){
		showPhoto sp=new showPhoto();	//JPanel:可連續播放照片
		left_pane.add(sp);
		//JLabel lblphoto=new JLabel("");
	/*
		ImageIcon icon1=new ImageIcon(getClass().getResource("welcom_photo.jpg"));
		lblphoto.setBounds(0,0,1000,700);
		lblphoto.setIcon(icon1);
		left_pane.add(lblphoto);
		*/
		left_pane.setLayout(null);
		left_pane.setBounds(0,0,1000,700);
		left_pane.setBackground(Color.blue);	
		add(left_pane);
	}
	
	
	
	public boolean Check_SignIn(){
		System.out.println("txtac = "+txtAc.getText());
		if(SG_dbma.findRD_in_TB_staffPW(txtAc.getText(),txtPw.getText())){
			return true;
		}
		JOptionPane.showMessageDialog(null,"帳號或密碼錯誤");
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
