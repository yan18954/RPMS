import javax.swing.*;
import java.awt.*;
//人機互動層類別
//CHCI_SPI_panel: Class HumanComputerInteraction_ShowPaymentInformation_panel (人機介面-[顯示付款資訊]操作畫面類別)
public class CHCI_SPI_panel extends JPanel{
	JPanel payinfo_panel=new JPanel();	//JPanel，用來放置付款資訊標籤
	JLabel welcomelbl = new JLabel(new ImageIcon(getClass().getResource("border.png")));
	JLabel homelbl = new JLabel(new ImageIcon(getClass().getResource("home.png")));

	JLabel totallbl =new JLabel("總金額：");
	JLabel set_totallbl =new JLabel("");
	JLabel dealMoneylbl=new JLabel("應收金額：");
	JLabel set_dealMoneylbl=new JLabel("");
	JLabel paylbl=new JLabel("實收金額：");
	JLabel set_paylbl=new JLabel("");
	JLabel changelbl=new JLabel("找　　零：");
	JLabel set_changelbl=new JLabel("");

	int total=0;
	CHCI_SPI_panel(){
		//設置圖片
		welcomelbl.setBounds(0,5,500,20);
	//	welcomelbl.setVisible(false);				
		add(welcomelbl);
		
		homelbl.setBounds(340,50,120,120);
		add(homelbl, new Integer(0), 0);	
		
		//設置當前加總金額
		totallbl.setBounds(50,40,200,80);
		totallbl.setFont(new Font("正黑體",1,20));	
		add(totallbl);
		//設置當前加總金額
		set_totallbl.setBounds(400,40,200,80);
		set_totallbl.setFont(new Font("正黑體",1,20));	
		set_totallbl.setForeground(Color.red);
		add(set_totallbl);
		add(set_totallbl, new Integer(1), 0);	

		
		//設置payinfo_panel
		payinfo_panel.setBounds(0,0,500,200);
		payinfo_panel.setLayout(null);
		payinfo_panel.setBackground(new Color(255, 245, 168));
		add(payinfo_panel);								//預設[付款資訊資料介面]隱藏   
		payinfo_panel.setVisible(false);

		//設置實收金額
		paylbl.setBounds(10,10,150,45);
		paylbl.setFont(new Font("正黑體",1,20));	
	//	paylbl.setVisible(false);						//預設[實收金額]標籤隱藏    
		set_paylbl.setBounds(180,10,150,45);
		set_paylbl.setFont(new Font("正黑體",1,20));	
	//	paylbl.setVisible(false);						//預設[實收金額]標籤隱藏    
		payinfo_panel.add(paylbl);	
		payinfo_panel.add(set_paylbl);	
		
		//設置應收金額
		dealMoneylbl.setBounds(10,55,150,45);
		dealMoneylbl.setFont(new Font("正黑體",1,20));	
	//	dealMoneylbl.setVisible(false);						//預設[應收金額]標籤隱藏    
		set_dealMoneylbl.setBounds(180,55,150,45);
		set_dealMoneylbl.setFont(new Font("正黑體",1,20));	
	//	set_dealMoneylbl.setVisible(false);					//預設[應收金額]標籤隱藏    	
		payinfo_panel.add(dealMoneylbl);
		payinfo_panel.add(set_dealMoneylbl);

		
		//設置找零
		changelbl.setBounds(10,95,150,45);
		changelbl.setForeground(Color.red);
		changelbl.setFont(new Font("正黑體",1,20));	
	//	changelbl.setVisible(false);					//預設[找零]標籤隱藏    
		set_changelbl.setBounds(180,95,150,45);
		set_changelbl.setForeground(Color.red);
		set_changelbl.setFont(new Font("正黑體",1,20));	
	//	changelbl.setVisible(false);					//預設[找零]標籤隱藏    
		payinfo_panel.add(changelbl);
		payinfo_panel.add(set_changelbl);
		
		setBackground(new Color(201, 243, 248));
		//setBackground(new Color(.5f, .8f, .5f, .5f));
		setBounds(0, 370, 500, 180);	
		setLayout(null);
		setVisible(true);	
	}
}
