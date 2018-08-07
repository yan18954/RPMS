 import javax.swing.*;
 import java.awt.*;

//人機互動層類別
 //CHCI_menu: Class HumanComputerInteraction_menu (人機介面-主功能選單類別)
public class CHCI_menu extends JPanel{
    JButton forwardBtn = new JButton("前台");
    JButton backBtn = new JButton("後台");
    JButton punBtn = new JButton("員工打卡");
    JButton resBtn = new JButton("訂位預約");
    JButton orderBtn = new JButton("返回點餐");
    JButton mealMBtn = new JButton("餐點管理");
    JButton storageMBtn = new JButton("物料管理"); 
    JButton employeeMBtn = new JButton("員工管理"); 
    JButton dealMBtn = new JButton("交易管理");                  
    JButton exitBtn = new JButton("登出");  
    
    //測試
    JTextArea notetxt=new JTextArea("營業時間:9:00~22:00\n電      話:(07)71111-556",3,5);
    JScrollPane scroll=new JScrollPane(notetxt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS 
    		, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    boolean MealIsSelected=false;
    //建構子:類別CHCI_menu
    public CHCI_menu(){

    	forwardBtn.setBounds(10,20,80,60);
    	forwardBtn.setBackground(new Color(0, 148, 141));
    	forwardBtn.setFont(new Font("正黑體",0,16));
    	forwardBtn.setBorderPainted(false);
        add(forwardBtn);
        forwardBtn.setVisible(false);		 //預設[前台]按鈕隱藏
        
        backBtn.setBounds(10,20,80,60);
        backBtn.setBackground(new Color(0, 148, 141));
        backBtn.setFont(new Font("正黑體",0,16));
        backBtn.setBorderPainted(false);
        add(backBtn);      
    
        punBtn.setBounds(500,20,180,60);
        punBtn.setBackground(new Color(155, 232, 23));
        punBtn.setFont(new Font("正黑體",0,16));
        punBtn.setIcon(new ImageIcon(getClass().getResource("punch_icon.png")));
        punBtn.setBorderPainted(false);
        add(punBtn); 
        
        resBtn.setBounds(700,20,180,60);
        resBtn.setBackground(new Color(155, 232, 23));
        resBtn.setFont(new Font("正黑體",0,16));
        resBtn.setIcon(new ImageIcon(getClass().getResource("reservation_icon.png")));
        resBtn.setBorderPainted(false); 
        add(resBtn);       
        
        orderBtn.setBounds(700,20,180,60);
        orderBtn.setBackground(new Color(255, 158, 158));
        orderBtn.setFont(new Font("正黑體",0,16));
        orderBtn.setIcon(new ImageIcon(getClass().getResource("ordermeal_icon.png")));
        orderBtn.setBorderPainted(false); 
        add(orderBtn);
        orderBtn.setVisible(false);		 //預設[返回點餐]按鈕隱藏
        
        //測試
		notetxt.setFont(new Font("正黑體",0,16));
		notetxt.setBorder(BorderFactory.createLineBorder(Color.yellow));
		notetxt.setLineWrap(true);
		scroll.setBounds(100,20,380,60);
		scroll.setVisible(true);
		add(scroll);	
        
        mealMBtn.setBounds(100,20,180,60);
        mealMBtn.setBackground(new Color(155, 232, 23));
        mealMBtn.setFont(new Font("正黑體",0,16));
        mealMBtn.setIcon(new ImageIcon(getClass().getResource("meal_icon.png")));
        mealMBtn.setBorderPainted(false);
        add(mealMBtn);
        mealMBtn.setVisible(false);		 //預設[餐點管理]按鈕隱藏
        
        storageMBtn.setBounds(300,20,180,60);
        storageMBtn.setBackground(new Color(155, 232, 23));
        storageMBtn.setFont(new Font("正黑體",0,16));
        storageMBtn.setIcon(new ImageIcon(getClass().getResource("storeage_icon.png")));
        storageMBtn.setBorderPainted(false); 
        add(storageMBtn);
        storageMBtn.setVisible(false);		 //預設[物料管理]按鈕隱藏
        
        employeeMBtn.setBounds(500,20,180,60);
        employeeMBtn.setBackground(new Color(155, 232, 23));
        employeeMBtn.setFont(new Font("正黑體",0,16));        
        employeeMBtn.setIcon(new ImageIcon(getClass().getResource("employee_icon.png")));
        employeeMBtn.setBorderPainted(false);     
        add(employeeMBtn);
        employeeMBtn.setVisible(false);		 //預設[員工管理]按鈕隱藏
        
        dealMBtn.setBounds(700,20,180,60);
        dealMBtn.setBackground(new Color(155, 232, 23));
        dealMBtn.setFont(new Font("正黑體",0,16));   
        dealMBtn.setIcon(new ImageIcon(getClass().getResource("deal_icon.png")));
        dealMBtn.setBorderPainted(false);    
        add(dealMBtn);
        dealMBtn.setVisible(false);		 //預設[交易管理]按鈕隱藏
        
        exitBtn.setBounds(895,20,80,60);
        exitBtn.setBackground(Color.orange);
        exitBtn.setFont(new Font("正黑體",0,16));     
    //    exitBtn.setIcon(new ImageIcon(getClass().getResource("exit_icon.png")));
        exitBtn.setBorderPainted(false);    
        add(exitBtn);

        setBackground(Color.WHITE);//測試
        setLocation(0,0);
        setSize(1000,100);
        setLayout(null);
        setVisible(true);

    }
}
