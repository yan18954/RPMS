 import javax.swing.*;
 import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//人機互動層類別
//CHCI_OR_panel: Class HumanComputerInteraction_OrderMeals_panel (人機介面-[新增餐點項目]操作畫面類別)
public class CHCI_OM_panel extends JPanel{
	JTabbedPane item_tabpanel =new JTabbedPane();	//菜單頁籤，含飯、麵JPanel
	JPanel CR_panel = new JPanel();					//Class Rice:飯類
	JPanel []Class_panel = new JPanel[20];
	JButton itemBtn[][]=new JButton[5][7];			        //餐點按鈕

	CHCI_OM_panel(){
		//setBackground(Color.yellow);
		setBounds(0, 100, 700, 600);	
		setLayout(null);

		item_tabpanel.setBounds(0, 0, 700, 550);
		add(item_tabpanel);
		
		//測試
		String tabTxt1="飯類";
		item_tabpanel.setFont(new Font("正黑體",1,20));
		//item_tabpanel.addTab(tabTxt1,CR_panel);


		for(int a=0;a<Class_panel.length;a++){
			Class_panel[a] = new JPanel();
			Class_panel[a].setBounds(0,0,700,550);
			Class_panel[a].setLayout(new GridLayout(5,7));
			Class_panel[a].setBackground(Color.pink);
			for(int x=0;x<itemBtn.length;x++){
				for(int y=0;y<itemBtn[0].length;y++){	
					itemBtn[x][y]=new JButton();
					itemBtn[x][y].addActionListener(ProcessMealsSelection);
					if((x+2)%2!=0)
						itemBtn[x][y].setBackground(new Color(255, 146, 20));
					else
						itemBtn[x][y].setBackground(new Color(255, 87, 87));		
					//itemBtn[x][y].setBorder(BorderFactory.createRaisedBevelBorder());
					Class_panel[a].add(itemBtn[x][y]);
				}
			}
		}	
		

	}
	  public ActionListener ProcessMealsSelection = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	 System.out.println("zzzzzzzzz");
	         }
	  };
}
