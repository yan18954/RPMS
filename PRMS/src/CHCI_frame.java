import javax.swing.ImageIcon;
import javax.swing.JFrame;

//人機互動層類別
//CHCI_frame: Class HumanComputerInteraction_frame (人機介面-前台框架類別)
class CHCI_frame extends JFrame{	//系統視窗
	/*-登入-*/
	CHCI_SignIn mySignIn_pane = new CHCI_SignIn();		  //登入畫面(為JPanel,內含標籤,文字欄位,按鈕等)
	/*--主選單--*/
    CHCI_menu  myMenu = new CHCI_menu();                  //主功能選單物件(為JPanel,內含6個按鈕)     
    /*--前台--*/
    CHCI_OR_panel  myOR_pane = new CHCI_OR_panel();       //新增餐點介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
    CHCI_COM_panel myCOM_pane = new CHCI_COM_panel();     //結帳餐點介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
    CHCI_SO_panel  mySO_pane = new CHCI_SO_panel();       //顯示餐點介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
    CHCI_RE_panel  myRE_pane = new CHCI_RE_panel();		  //訂位預約介面物件(為JPanel,內含標籤,文字欄位,按鈕等)
    /*--後台--*/
    CHCI_MM_panel myMM_pane=new CHCI_MM_panel(); 		  //管理餐點介面物件(為JPanel,內含JPanel)  
    CHCI_MS_panel myMS_pane=new CHCI_MS_panel();		  //管理員工介面物件(為JPanel,內含JPanel) 
    CHCI_MMA_panel myMMA_pane=new CHCI_MMA_panel();		  //管理物料介面物件(為JPanel,內含JPanel)
    CHCI_MD_panel myMD_pane=new CHCI_MD_panel();		  //管理交易介面物件(為JPanel,內含JPanel) 

    //
    ImageIcon img = new ImageIcon(getClass().getResource("peticon.png"));
	
 
    //建構子:類別CHCI_frame 
    public CHCI_frame(){
    	setIconImage(img.getImage());
    	add(mySignIn_pane); //將[登入畫面]加到此視窗中
        add(myMenu);        //將[主功能選單物件]加到此視窗中
        add(myOR_pane);     //將[新增餐點介面物件]加到此視窗中
        add(mySO_pane);     //將[顯示餐點介面物件]加到此視窗中      
        add(myCOM_pane);	//將[結帳訂單介面物件]加到此視窗中      
        add(myRE_pane);	    //將[訂位預約介面物件]加到此視窗中             
        add(myMM_pane);     //將[管理餐點介面物件]加到此視窗中      
        add(myMS_pane);     //將[管理員工介面物件]加到此視窗中   
        add(myMMA_pane);	//將[管理物料介面物件]加到此視窗中
        add(myMD_pane);	    //將[管理交易介面物件]加到此視窗中   

        myMenu.setVisible(false);	    //預設[主功能選單物件]畫面隱藏           
        myOR_pane.setVisible(false);	//預設[新增餐點介面物件]畫面隱藏   
        mySO_pane.setVisible(false);	//預設[顯示餐點介面物件]畫面隱藏          
        myCOM_pane.setVisible(false);	//預設[結帳訂單介面物件]畫面隱藏   
        myRE_pane.setVisible(false);	//預設[訂位預約介面物件]畫面隱藏   
        myMM_pane.setVisible(false);	//預設[管理餐點介面物件]畫面隱藏    
        myMS_pane.setVisible(false);    //預設[管理員工介面物件]畫面隱藏    
        myMMA_pane.setVisible(false);	//預設[管理物料介面物件]畫面隱藏    
        myMD_pane.setVisible(false);	//預設[管理交易介面物件]畫面隱藏    
        

        //系統視窗的基本設定
        setTitle("寵物餐廳管理系統-PRMS(PetRestaurantManagementSystem)");
        setBounds(0,0,1000,700);   
        setLocationRelativeTo(null);//畫面置中        
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }    
}
//end for: class CHCI_frame
