 import javax.swing.*;
 import java.awt.*;
//�H�����ʼh���O
//CHCI_OR_panel: Class HumanComputerInteraction_ORder_panel (�H������-[�s�W�\�I]�ާ@�e�����O)
public class CHCI_OR_panel extends JPanel{
	boolean man_deal = true;				//���L�ܼ�,�ΨӰO����e������O[�D�H�\�I]�٬O[�d���\�I]
	JPanel clear_panel =new JPanel();		//�t���b�B�M�����s
	JPanel meal_panel =new JPanel();		//�t �D�H�I�\�B�d���I�\��chose_panel	
	JPanel chose_panel =new JPanel();		//�t �I�\���s
    JButton manBtn = new JButton("�D�H�I�\");
    JButton petBtn = new JButton("�d���I�\");
    JButton clearBtn =new JButton("�M��");
    JButton dealBtn =new JButton("���b");
    JButton[][] mealBtn=new JButton[4][5];
	boolean Check=false;					//������e���A�O�_�i�H���b
	CHCI_OR_panel(){

		clear_panel.setBackground(Color.pink);
		clear_panel.setBounds(0, 470, 500, 100);	
		clear_panel.setLayout(null);
		add(clear_panel);
	//	meal_panel.setBackground(Color.blue);
		meal_panel.setBounds(0, 100, 490, 380);		
		meal_panel.setLayout(null);
		add(meal_panel);
	//	chose_panel.setBackground(Color.black);
		chose_panel.setBounds(5, 5, 475, 350);	
		chose_panel.setLayout(new GridLayout(4,5));
		meal_panel.add(chose_panel);	
		
		manBtn.setBounds(10,10,210,80);
		manBtn.setBackground(Color.WHITE);
		//manBtn.setContentAreaFilled(false);
		manBtn.setIcon(new ImageIcon(getClass().getResource("man_icon.png")));
		manBtn.setFont(new Font("������",1,16));
		add(manBtn);
		petBtn.setBounds(260,10,210,80);
		petBtn.setBackground(Color.WHITE);		
	//	petBtn.setContentAreaFilled(false);		
		petBtn.setIcon(new ImageIcon(getClass().getResource("pet_icon.png")));
		petBtn.setFont(new Font("������",1,16));
		add(petBtn);		
		
		//�M���P���b���s
		clearBtn.setBounds(10,5,210,80);
		clearBtn.setBackground(Color.blue);
		clearBtn.setForeground(Color.WHITE);	
		clearBtn.setFont(new Font("������",0,16));
		clear_panel.add(clearBtn);	
		dealBtn.setBounds(260,5,210,80);
		dealBtn.setBackground(Color.red);
		dealBtn.setForeground(Color.WHITE);
		dealBtn.setFont(new Font("������",0,16));
		clear_panel.add(dealBtn);			
		//�إ��\�I���s
		for(int x=0;x<mealBtn.length;x++){
			for(int y=0;y<mealBtn[0].length;y++){	
				mealBtn[x][y]=new JButton();
				if((x+2)%2!=0)
					mealBtn[x][y].setBackground(new Color(255, 162, 0));
				else
					mealBtn[x][y].setBackground(new Color(187, 255, 0));					
				mealBtn[x][y].setBorder(BorderFactory.createRaisedBevelBorder());
				chose_panel.add(mealBtn[x][y]);
			}
		}
		
        setBackground(Color.pink);
        setLocation(500,100);
        setSize(500,600);
        setLayout(null);
        setVisible(true);		
	}
}
