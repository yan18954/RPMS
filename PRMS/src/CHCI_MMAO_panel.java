import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
//人機互動層類別
//CHCI_MMAO_panel: Class HumanComputerInteraction_ManageManageMAterialsOperation_panel (人機介面-[管理物料]操作畫面類別)
public class CHCI_MMAO_panel extends JPanel{

	CHCI_AO_panel myAO_pane=new CHCI_AO_panel();        //新增訂單類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_EO_panel myEO_pane=new CHCI_EO_panel();        //編輯訂單介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_EOL_panel myEOL_pane=new CHCI_EOL_panel();     //編輯訂單細節介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_CPR_panel myCPR_pane=new CHCI_CPR_panel();     //產生採購報表介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_AMA_panel myAMA_pane=new CHCI_AMA_panel();     //新增訂單類別介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_EMA_panel myEMA_pane=new CHCI_EMA_panel();     //編輯訂單介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_CMR_panel myCMR_pane=new CHCI_CMR_panel();     //產生物料報表介面物件(為JPanel,內含標籤,文字欄位,按鈕等	
	CHCI_ACO_panel myACO_pane=new CHCI_ACO_panel();     //新增廠商介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
	CHCI_ECO_panel myECO_pane=new CHCI_ECO_panel();     //編輯廠商介面物件(為JPanel,內含標籤,文字欄位,按鈕等		
	
	
	JPanel mmabtn_panel =new JPanel();			 		//JPanel：ManageMaterialsButton，管理物料子項目，含管理採購、管理物料，管理廠商等
	JPanel mp_panel=new JPanel();						//JPanel：(為JPanel,內含新增訂單、編輯訂單、產生進貨報表按鈕等)
	JPanel mmk_panel=new JPanel();						//JPanel：(為JPanel,內含新增物料、編輯物料、產生物料報表按鈕等)
	JPanel mco_panel=new JPanel();						//JPanel：(為JPanel,內含新增廠商、編輯廠商按鈕等)
	
	JButton pmbtn = new JButton("採購管理");
    JButton mmakbtn = new JButton("物料管理");
    JButton mcbtn = new JButton("廠商管理");
    
    JButton addOrbtn = new JButton("新增訂單");
    JButton ediOrbtn = new JButton("編輯訂單");
    JButton crePRfbtn = new JButton("產生採購報表");
    JButton addMabtn = new JButton("新增物料");
    JButton ediMabtn = new JButton("編輯物料");
    JButton creMRfbtn = new JButton("產生物料報表");
    JButton addMcbtn = new JButton("新增廠商");
    JButton ediMcbtn = new JButton("編輯廠商");   

	CHCI_MMAO_panel(){
		//採購管理按鈕設置
		pmbtn.setBounds(5,5,120,45);
		pmbtn.setBackground(Color.CYAN);
		pmbtn.setIcon(new ImageIcon(getClass().getResource("purchase_icon.png")));
		pmbtn.setFont(new Font("正黑體",0,12));
		mmabtn_panel.add(pmbtn);
			//加入監聽事件
		pmbtn.addActionListener(ProcessPaneChanged);
		
		//物料管理按鈕設置
		mmakbtn.setBounds(130,5,120,45);
		mmakbtn.setBackground(Color.yellow);
		mmakbtn.setIcon(new ImageIcon(getClass().getResource("mangmaterial_icon.png")));
		mmakbtn.setFont(new Font("正黑體",0,12));
		mmabtn_panel.add(mmakbtn);		
			//加入監聽事件
		mmakbtn.addActionListener(ProcessPaneChanged);
		
		//廠商管理按鈕設置
		mcbtn.setBounds(255,5,120,45);
		mcbtn.setBackground(Color.white);
		mcbtn.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		mcbtn.setFont(new Font("正黑體",0,12));
		mmabtn_panel.add(mcbtn);
			//加入監聽事件
		mcbtn.addActionListener(ProcessPaneChanged);		
		
		
		//加入子功能操作面板
		add(myAO_pane);	//將[新增訂單介面物件]加到此視窗中
		//myAO_pane.setVisible(false);
		add(myEO_pane); //將[編輯訂單介面物件]加到此視窗中
		myEO_pane.setVisible(false);	
		
		add(myEOL_pane); //將[編輯訂單細節介面物件]加到此視窗中
		myEOL_pane.setVisible(false);	
		
		add(myCPR_pane); //將[產生採購報表介面物件]加到此視窗中		
		myCPR_pane.setVisible(false);
		add(myAMA_pane); //將[新增物料總類介面物件]加到此視窗中		
		myAMA_pane.setVisible(false);	
		add(myEMA_pane); //將[編輯物料總類介面物件]加到此視窗中		
		myEMA_pane.setVisible(false);			
		add(myCMR_pane); //將[產生物料報表介面物件]加到此視窗中		
		myCMR_pane.setVisible(false);	
		add(myACO_pane); //將[新增廠商總類介面物件]加到此視窗中		
		myACO_pane.setVisible(false);	
		add(myECO_pane); //將[編輯廠商總類介面物件]加到此視窗中		
		myECO_pane.setVisible(false);	
		
		/*按鈕介面設置*/
		mmabtn_panel.setBounds(0,0,500,65);
		mmabtn_panel.setLayout(null);
		//mmabtn_panel.setLayout(new FlowLayout());
		add(mmabtn_panel);						//將[功能按鈕介面物件]加到此視窗中

		//設置mp_panel,內含新增訂單、編輯訂單、產生進貨報表按鈕等
		mp_panel.setBounds(0,65,500,35);
		mp_panel.setVisible(true);
		mp_panel.setBackground(Color.pink);		//將[採購管理子分類介面物件]加到此視窗中
		mp_panel.setLayout(new FlowLayout());
		add(mp_panel);
			//將採購管理子功能加入mp_panel
		mp_panel.add(addOrbtn);
		mp_panel.add(ediOrbtn);
		mp_panel.add(crePRfbtn);
			//加入監聽事件
		addOrbtn.addActionListener(ProcessPaneChanged);
		ediOrbtn.addActionListener(ProcessPaneChanged);
		crePRfbtn.addActionListener(ProcessPaneChanged);
		
		//設置mmk_panel,內含新增訂單、編輯訂單、產生進貨報表按鈕等
		mmk_panel.setBounds(0,65,500,35);
		mmk_panel.setVisible(false);
		mmk_panel.setBackground(Color.pink);	//將[物料分類管理子分類介面物件]加到此視窗中
		mp_panel.setLayout(new FlowLayout());
		add(mmk_panel);
			//將物料總類管理子功能加入mmk_panel
		mmk_panel.add(addMabtn);
		mmk_panel.add(ediMabtn);
		mmk_panel.add(creMRfbtn);
			//加入監聽事件
		addMabtn.addActionListener(ProcessPaneChanged);
		ediMabtn.addActionListener(ProcessPaneChanged);
		creMRfbtn.addActionListener(ProcessPaneChanged);
		
		//設置mco_panel,內含新增廠商、編輯廠商按鈕等
		mco_panel.setBounds(0,65,500,35);
		mco_panel.setVisible(false);
		mco_panel.setBackground(Color.pink);	//將[物料分類管理子分類介面物件]加到此視窗中
		mco_panel.setLayout(new FlowLayout());
		add(mco_panel);
			//將廠商管理子功能加入mmk_panel
		mco_panel.add(addMcbtn);
		mco_panel.add(ediMcbtn);
			//加入監聽事件
		addMcbtn.addActionListener(ProcessPaneChanged);
		ediMcbtn.addActionListener(ProcessPaneChanged);		

		setBackground(new Color(255, 242, 179));
	    setBounds(500,0,500,600);
	    setLayout(null);
	}
    public ActionListener ProcessPaneChanged = new ActionListener(){
        public void actionPerformed(ActionEvent e){
//            if(e.getSource() ==  pmbtn){
//            	mp_panel.setVisible(true);         //顯示[採購管理子選項]操作畫面	  
//            	myAO_pane.setVisible(true); 	   //預設顯示[採購管理-新增訂單]
//        		mmk_panel.setVisible(false);	   //隱藏[物料總類管理子選項]操作畫面
//        		mco_panel.setVisible(false);	   //隱藏[廠商管理子選項]操作畫面
//
//            	myAMA_pane.setVisible(false);      //隱藏[物料管理子畫面]     
//            	myEMA_pane.setVisible(false);
//            	myCMR_pane.setVisible(false);
//            	myACO_pane.setVisible(false);      //隱藏[廠商管理子畫面]	  
//            	myECO_pane.setVisible(false);
//
//            }
//            if(e.getSource() ==  mmakbtn){
//        		mmk_panel.setVisible(true);	   		//顯示[物料總類管理子選項]操作畫面
//        		myAMA_pane.setVisible(true);        //預設顯示[物料管理-新增訂單]
//            	mp_panel.setVisible(false);         //隱藏[採購管理子選項]操作畫面	
//           		mco_panel.setVisible(false);	    //隱藏[廠商管理子選項]操作畫面
//           		
//            	myAO_pane.setVisible(false);        //隱藏[採購管理子畫面]
//            	myEO_pane.setVisible(false);
//            	myCPR_pane.setVisible(false);
//            	myACO_pane.setVisible(false);       //隱藏[廠商管理子畫面]	  
//            	myECO_pane.setVisible(false);
//            }
//            if(e.getSource() ==  mcbtn){
//         		mco_panel.setVisible(true);	   		//顯示[廠商管理子選項]操作畫面
//            	myACO_pane.setVisible(true);        //預設顯示[廠商管理-新增訂單]
//         		mmk_panel.setVisible(false);	   	//隱藏[物料總類管理子選項]操作畫面
//            	mp_panel.setVisible(false);         //隱藏[採購管理子選項]操作畫面	
//
//            	myAMA_pane.setVisible(false);       //隱藏[物料管理子畫面]          
//            	myEMA_pane.setVisible(false);
//            	myCMR_pane.setVisible(false);     		
//             	myAO_pane.setVisible(false);        //隱藏[採購管理子畫面]
//             	myEO_pane.setVisible(false);
//             	myCPR_pane.setVisible(false);
//             }
//            if(e.getSource() ==  addOrbtn){
//            	myAO_pane.setVisible(true);          //顯示[新增訂單資料]操作畫面	  
//            	myEO_pane.setVisible(false);
//            	myCPR_pane.setVisible(false);
//            }
//            if(e.getSource() ==  ediOrbtn){	
//            	myEO_pane.setVisible(true);          //顯示[編輯訂單資料]操作畫面	  
//            	myAO_pane.setVisible(false);
//            	myCPR_pane.setVisible(false);
//            }
//            if(e.getSource() ==  crePRfbtn){
//            	myCPR_pane.setVisible(true);         //顯示[產生採購報表資料]操作畫面	  
//            	myAO_pane.setVisible(false);
//            	myEO_pane.setVisible(false);
//            }
//
//            if(e.getSource() ==  addMabtn){
//            	myAMA_pane.setVisible(true);         //顯示[新增物料總類資料]操作畫面	  
//            	myEMA_pane.setVisible(false);
//            	myCMR_pane.setVisible(false);
//            }
//            if(e.getSource() ==  ediMabtn){
//            	myEMA_pane.setVisible(true);		 //顯示[編輯物料總類資料]操作畫面
//            	myAMA_pane.setVisible(false); 
//            	myCMR_pane.setVisible(false);
//            	
//            }
//            if(e.getSource() ==  creMRfbtn){
//            	myCMR_pane.setVisible(true);         //顯示[產生物料報表資料]操作畫面	  
//            	myEMA_pane.setVisible(false);
//            	myAMA_pane.setVisible(false);
//            }
//            if(e.getSource() ==  addMcbtn){
//            	myACO_pane.setVisible(true);         //顯示[新增廠商資料]操作畫面	  
//            	myECO_pane.setVisible(false);
//            }
//            if(e.getSource() ==  ediMcbtn){
//            	myECO_pane.setVisible(true);		 //顯示[編輯廠商資料]操作畫面
//            	myACO_pane.setVisible(false); 
//            }
        }
    };
}
