 import javax.swing.*;
 import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//人機互動層類別
//CHCI_CNSI_panel: Class HumanComputerInteraction_ChoseNumber and ShowInfo_panel (人機介面-[計算數量與顯示資訊介面物件]操作畫面類別)
public class CHCI_CNSI_panel extends JPanel{
	JPanel calculation_panel =new JPanel();	//含 數量按鈕
	JPanel nowinfo_panel=new JPanel();		//含 餐點名稱、餐點數量、價格、總價格標籤
	JPanel check_panel=new JPanel();		//含 新增、重選、返回按鈕
	JButton calBtn[][]=new JButton[4][3];	//數量按鈕
	JButton chBtn=new JButton("新增");		//新增按鈕
	JButton rechBtn=new JButton("重選");		//重選按鈕
	JButton backBtn=new JButton("返回");		//數量按鈕
	String[][] calBtnString={{"7","8","9"},{"4","5","6"},{"1","2","3"},{"0","清除","倒退"}};
	JLabel namelbl=new JLabel("餐點名稱：");
	JLabel set_namelbl=new JLabel("");
	JLabel pricelbl=new JLabel("單    價：");
	JLabel set_pricelbl=new JLabel("");
	JLabel tens_numlbl=new JLabel("");	//JLable:用來記錄十位數字
	JLabel ones_numlbl=new JLabel("");	//JLable:用來記錄個位數字
	JLabel numlbl=new JLabel("數    量：");	
	JLabel sumlbl=new JLabel("小    計：");
	JLabel set_sumlbl=new JLabel("");	
	int num=1;	//紀錄當前點選位數
	int back_times=0;
	boolean selectedNum=false;			//boolean變數:用來記錄被選取的是否為數字鍵
	boolean MealIsSelected=false;		//boolean變數:用來記錄餐點是否被選取
	boolean MealIsInsert=true;			//boolean變數:用來記錄餐點是否完成新增
	CHCI_CNSI_panel(){
		setBackground(new Color(215, 244, 242));
		setBounds(700,0,300,700);
		setLayout(null);
		/*JPanel：nowinfo用來顯示已選擇資訊*/
		nowinfo_panel.setBackground(new Color(215, 244, 242));
		nowinfo_panel.setBounds(0, 0, 300, 100);
		nowinfo_panel.setBorder(BorderFactory.createEtchedBorder());
		nowinfo_panel.setLayout(null);
		add(nowinfo_panel);			
		//設置名稱標籤
		namelbl.setBounds(5, 0, 80, 25);	
		namelbl.setFont(new Font("正黑體",1,14));
		nowinfo_panel.add(namelbl);		
		set_namelbl.setBounds(90, 0, 300, 25);	
		set_namelbl.setFont(new Font("正黑體",0,14));
		nowinfo_panel.add(set_namelbl);		
		//設置價格標籤
		pricelbl.setBounds(5, 25, 70, 25);	
		pricelbl.setFont(new Font("正黑體",1,14));
		nowinfo_panel.add(pricelbl);
		set_pricelbl.setBounds(90, 25, 300, 25);	
		set_pricelbl.setFont(new Font("正黑體",0,14));
		nowinfo_panel.add(set_pricelbl);
		//設置數量標籤
		numlbl.setBounds(5, 50, 70, 25);	
		numlbl.setFont(new Font("正黑體",1,14));
		tens_numlbl.setBounds(90, 53, 300, 25);	
		tens_numlbl.setFont(new Font("正黑體",1,14));		
		tens_numlbl.setForeground(Color.red);
		ones_numlbl.setBounds(98, 53, 300, 25);	
		ones_numlbl.setFont(new Font("正黑體",1,14));	
		ones_numlbl.setForeground(Color.red);
		nowinfo_panel.add(numlbl);	
		nowinfo_panel.add(tens_numlbl);	
		nowinfo_panel.add(ones_numlbl);
		//小計標籤set_sumlbl
		sumlbl.setBounds(5, 75, 70, 25);	
		sumlbl.setFont(new Font("正黑體",1,14));
		nowinfo_panel.add(sumlbl);	
		set_sumlbl.setBounds(90, 75, 70, 25);	
		set_sumlbl.setFont(new Font("正黑體",1,14));
		nowinfo_panel.add(set_sumlbl);	
		/*JPanel：calculation_panel，含數字按鈕*/
		//calculation_panel.setBackground(new Color(228, 26, 255));
		calculation_panel.setBounds(14, 135, 258, 350);	
		calculation_panel.setLayout(new GridLayout(4,3));
		add(calculation_panel);	
		
		for(int x=0;x<calBtn.length;x++){
			for(int y=0;y<calBtn[0].length;y++){	
				calBtn[x][y]=new JButton(calBtnString[x][y]);	
				calBtn[x][y].setFont(new Font("正黑體",1,18));
				calBtn[x][y].setBorder(BorderFactory.createEtchedBorder());
				calBtn[x][y].addActionListener(PressedNumberbtn);
				//itemBtn[x][y].setBorder(BorderFactory.createLoweredBevelBorder());
				//itemBtn[x][y].setBorder(BorderFactory.createRaisedBevelBorder());
				calculation_panel.add(calBtn[x][y]);
			}
		}
		
		/*JPanel：check_panel，含新增、重選、返回按鈕*/
		check_panel.setBackground(new Color(215, 244, 242));
		check_panel.setBounds(5,500,270,150);
		check_panel.setLayout(null);
		add(check_panel);
		
		chBtn.setBounds(150,0,120,80);
		chBtn.setFont(new Font("正黑體",1,16));
		chBtn.setForeground(Color.WHITE);		
		chBtn.setBackground(new Color(255, 112, 112));
		check_panel.add(chBtn);
		rechBtn.setBounds(0,0,120,80);
		rechBtn.setFont(new Font("正黑體",1,16));
		rechBtn.setForeground(Color.WHITE);
		rechBtn.setBackground(new Color(126, 166, 200));
		check_panel.add(rechBtn);
		backBtn.setBounds(0,90,270,50);
		backBtn.setFont(new Font("正黑體",1,16));
		backBtn.setBackground(new Color(243, 219, 63));
		backBtn.setBorderPainted(false);
		check_panel.add(backBtn);
		
	}

    //事件傾聽程式: 處理數字按鈕點按
    public ActionListener PressedNumberbtn = new ActionListener(){
        public void actionPerformed(ActionEvent e){
        	if(MealIsSelected==true){
            	selectedNum=true;				    //將selectedNum變數初始化為true
                if(e.getSource()==calBtn[3][1])     //[清除]被選按
                {
                	selectedNum=false;			    //記錄非數字鍵被選取			
                	ones_numlbl.setText("");	    //將個位數字清除
                	tens_numlbl.setText("");	    //將十位數字清除
                	num=1;					        //將num設回1,表示使用者將從十位數字重新選擇

                }
                if(e.getSource()==calBtn[3][2])     //[倒退]被選按
                {            	
//                	selectedNum=false;			    //記錄非數字鍵被選取			
                	if(ones_numlbl.getText()==""){  //當使用者只點選一個數字時
                		tens_numlbl.setText("");    //將原十位數字標籤(此時為個位數)清除
                    	num=1;					    //將num設回1,表示使用者可以從十位數字重新選擇	
                	}
                	else{
                	   	ones_numlbl.setText("");	//將個位數字清除
                    	num=2;					    //將num設回2,表示使用者可以從個位數字重新選擇
                	}
                }           
            	if(num==3 && selectedNum==true)
                    JOptionPane.showMessageDialog(null,"單筆餐點最大數量為99!");
               	if(num==2){
                    if(e.getSource()==calBtn[3][0])  //數字[0]被選按
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "0");
                    	num++;
                    }
                    if(e.getSource()==calBtn[2][0]) //數字[1]被選按
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "1");
                    	num++;
                    }
                    if(e.getSource()==calBtn[2][1]) //數字[2]被選按
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "2");
                    	num++;
                    }
                    if(e.getSource()==calBtn[2][2]) //數字[3]被選按
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "3");
                    	num++;
                    }
                    if(e.getSource()==calBtn[1][0]) //數字[4]被選按
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "4");
                    	num++;
                    }
                    if(e.getSource()==calBtn[1][1]) //數字[5]被選按
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "5");
                    	num++;
                    }
                    if(e.getSource()==calBtn[1][2]) //數字[6]被選按
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "6");
                    	num++;
                    }
                    if(e.getSource()==calBtn[0][0]) //數字[7]被選按
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "7");
                    	num++;
                    }
                    if(e.getSource()==calBtn[0][1]) //數字[8]被選按
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "8");
                    	num++;
                    }
                    if(e.getSource()==calBtn[0][2]) //數字[9]被選按
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "9");
                    	num++;
                    }
            	}
            	if(num==1){
                    if(e.getSource()==calBtn[3][0]) //數字[0]被選按
                    {
                        JOptionPane.showMessageDialog(null,"第一個數字不得為0!");
                    	num=1;
                    }
                    if(e.getSource()==calBtn[2][0]) //數字[1]被選按
                    {
                    	tens_numlbl.setText("1");
                    	num++;
                    }
                    if(e.getSource()==calBtn[2][1]) //數字[2]被選按
                    {
                    	tens_numlbl.setText("2");
                    	num++;
                    }
                    if(e.getSource()==calBtn[2][2]) //數字[3]被選按
                    {
                    	tens_numlbl.setText("3");
                    	num++;
                    }
                    if(e.getSource()==calBtn[1][0]) //數字[4]被選按
                    {
                    	tens_numlbl.setText("4");
                    	num++;
                    }
                    if(e.getSource()==calBtn[1][1]) //數字[5]被選按
                    {
                    	tens_numlbl.setText("5");
                    	num++;
                    }
                    if(e.getSource()==calBtn[1][2]) //數字[6]被選按
                    {
                    	tens_numlbl.setText("6");
                    	num++;
                    }
                    if(e.getSource()==calBtn[0][0]) //數字[7]被選按
                    {
                    	tens_numlbl.setText("7");
                    	num++;
                    }
                    if(e.getSource()==calBtn[0][1]) //數字[8]被選按
                    {
                    	tens_numlbl.setText("8");
                    	num++;
                    }
                    if(e.getSource()==calBtn[0][2]) //數字[9]被選按
                    {
                    	tens_numlbl.setText("9");
                    	num++;
                    }
            	}
        
           
        	}
        	else
           	   JOptionPane.showMessageDialog(null,"請先至左方選取一筆餐點!");


        }
    };
}
