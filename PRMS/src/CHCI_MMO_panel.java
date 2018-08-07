import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
//人機互動層類別
//CHCI_MMO_panel: Class HumanComputerInteraction_ManageMealsOperation_panel (人機介面-[管理餐點]操作畫面類別)
public class CHCI_MMO_panel extends JPanel{
	CHCI_AC_panel myAC_pane=new CHCI_AC_panel();  //新增類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_EC_panel myEC_pane=new CHCI_EC_panel();  //編輯類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_AM_panel myAM_pane=new CHCI_AM_panel();  //新增餐點介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_EM_panel myEM_pane=new CHCI_EM_panel();  //編輯餐點介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	JPanel mmdef_panel=new JPanel();			  //JPanel：預設畫面，含標籤
	JPanel mmbtn_panel =new JPanel();			  //JPanel：ManageMealsButton，管理餐點子項目，含新增類別、修改類別、新增餐點、修改餐點按鈕
	JButton addclassbtn = new JButton("新類別");
    JButton revclassbtn = new JButton("編輯類別");
    JButton addmealsbtn = new JButton("新餐點");
    JButton revmealsbtn = new JButton("編輯餐點");
    JLabel introlbl =new JLabel();
    int choose=0;
	CHCI_MMO_panel(){	
		add(myAC_pane);	//將[新增類別介面物件]加到此視窗中
		myAC_pane.setVisible(false);
		add(myEC_pane); //將[編輯類別介面物件]加到此視窗中
		myEC_pane.setVisible(false);	
		add(myAM_pane); //將[新增餐點介面物件]加到此視窗中		
		myAM_pane.setVisible(false);
		add(myEM_pane);	//將[編輯餐點介面物件]加到此視窗中
		myEM_pane.setVisible(false);
		
		/*預設介面*/
	//	introlbl.setBounds(0,0,500,540);
	//	introlbl.setIcon(new ImageIcon(getClass().getResource("intro_photo.png")));
	//	mmdef_panel.add(introlbl);
		mmdef_panel.setBounds(0,60,500,540);
		mmdef_panel.setBackground(new Color(255, 242, 179));
		mmdef_panel.setLayout(null); 
		add(mmdef_panel);				//將[細項預設介面物件]加到此視窗中
	//	mmdef_panel.setVisible(false);

		/*按鈕介面設置*/
		mmbtn_panel.setBounds(0,0,500,60);
		mmbtn_panel.setLayout(new FlowLayout());
		add(mmbtn_panel);				//將[功能按鈕介面物件]加到此視窗中
	
		addclassbtn.setBounds(0,5,100,40);
		addclassbtn.setBackground(Color.WHITE);
		addclassbtn.setContentAreaFilled(false);
		addclassbtn.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		addclassbtn.setFont(new Font("正黑體",0,12));
		mmbtn_panel.add(addclassbtn);
		
		revclassbtn.setBounds(120,5,110,60);
		revclassbtn.setBackground(Color.WHITE);
		revclassbtn.setContentAreaFilled(false);
		revclassbtn.setIcon(new ImageIcon(getClass().getResource("editclass_icon.png")));
		revclassbtn.setFont(new Font("正黑體",0,12));
		//revclassbtn.setEnabled(false);
		mmbtn_panel.add(revclassbtn);
		
		addmealsbtn.setBounds(235,5,110,60);		
		addmealsbtn.setBackground(Color.WHITE);
		addmealsbtn.setContentAreaFilled(false);
		addmealsbtn.setIcon(new ImageIcon(getClass().getResource("addmeals_icon.png")));
		addmealsbtn.setFont(new Font("正黑體",0,12));
		addmealsbtn.setEnabled(false);
		mmbtn_panel.add(addmealsbtn);	
		
		revmealsbtn.setBounds(350,5,110,60);
		revmealsbtn.setBackground(Color.WHITE);
		revmealsbtn.setContentAreaFilled(false);
		revmealsbtn.setIcon(new ImageIcon(getClass().getResource("editmeals_icon.png")));
		revmealsbtn.setFont(new Font("正黑體",0,12));
		revmealsbtn.setEnabled(false);
		mmbtn_panel.add(revmealsbtn);
		
	    setBackground(new Color(255, 242, 179));
	    setBounds(500,0,500,600);
	    setLayout(null);
	}
}
