 import javax.swing.*;
 import java.awt.*;

//�H�����ʼh���O
 //CHCI_menu: Class HumanComputerInteraction_menu (�H������-�D�\�������O)
public class CHCI_menu extends JPanel{
    JButton forwardBtn = new JButton("�e�x");
    JButton backBtn = new JButton("��x");
    JButton punBtn = new JButton("���u���d");
    JButton resBtn = new JButton("�q��w��");
    JButton orderBtn = new JButton("��^�I�\");
    JButton mealMBtn = new JButton("�\�I�޲z");
    JButton storageMBtn = new JButton("���ƺ޲z"); 
    JButton employeeMBtn = new JButton("���u�޲z"); 
    JButton dealMBtn = new JButton("����޲z");                  
    JButton exitBtn = new JButton("�n�X");  
    
    //����
    JTextArea notetxt=new JTextArea("��~�ɶ�:9:00~22:00\n�q      ��:(07)71111-556",3,5);
    JScrollPane scroll=new JScrollPane(notetxt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS 
    		, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    boolean MealIsSelected=false;
    //�غc�l:���OCHCI_menu
    public CHCI_menu(){

    	forwardBtn.setBounds(10,20,80,60);
    	forwardBtn.setBackground(new Color(0, 148, 141));
    	forwardBtn.setFont(new Font("������",0,16));
    	forwardBtn.setBorderPainted(false);
        add(forwardBtn);
        forwardBtn.setVisible(false);		 //�w�][�e�x]���s����
        
        backBtn.setBounds(10,20,80,60);
        backBtn.setBackground(new Color(0, 148, 141));
        backBtn.setFont(new Font("������",0,16));
        backBtn.setBorderPainted(false);
        add(backBtn);      
    
        punBtn.setBounds(500,20,180,60);
        punBtn.setBackground(new Color(155, 232, 23));
        punBtn.setFont(new Font("������",0,16));
        punBtn.setIcon(new ImageIcon(getClass().getResource("punch_icon.png")));
        punBtn.setBorderPainted(false);
        add(punBtn); 
        
        resBtn.setBounds(700,20,180,60);
        resBtn.setBackground(new Color(155, 232, 23));
        resBtn.setFont(new Font("������",0,16));
        resBtn.setIcon(new ImageIcon(getClass().getResource("reservation_icon.png")));
        resBtn.setBorderPainted(false); 
        add(resBtn);       
        
        orderBtn.setBounds(700,20,180,60);
        orderBtn.setBackground(new Color(255, 158, 158));
        orderBtn.setFont(new Font("������",0,16));
        orderBtn.setIcon(new ImageIcon(getClass().getResource("ordermeal_icon.png")));
        orderBtn.setBorderPainted(false); 
        add(orderBtn);
        orderBtn.setVisible(false);		 //�w�][��^�I�\]���s����
        
        //����
		notetxt.setFont(new Font("������",0,16));
		notetxt.setBorder(BorderFactory.createLineBorder(Color.yellow));
		notetxt.setLineWrap(true);
		scroll.setBounds(100,20,380,60);
		scroll.setVisible(true);
		add(scroll);	
        
        mealMBtn.setBounds(100,20,180,60);
        mealMBtn.setBackground(new Color(155, 232, 23));
        mealMBtn.setFont(new Font("������",0,16));
        mealMBtn.setIcon(new ImageIcon(getClass().getResource("meal_icon.png")));
        mealMBtn.setBorderPainted(false);
        add(mealMBtn);
        mealMBtn.setVisible(false);		 //�w�][�\�I�޲z]���s����
        
        storageMBtn.setBounds(300,20,180,60);
        storageMBtn.setBackground(new Color(155, 232, 23));
        storageMBtn.setFont(new Font("������",0,16));
        storageMBtn.setIcon(new ImageIcon(getClass().getResource("storeage_icon.png")));
        storageMBtn.setBorderPainted(false); 
        add(storageMBtn);
        storageMBtn.setVisible(false);		 //�w�][���ƺ޲z]���s����
        
        employeeMBtn.setBounds(500,20,180,60);
        employeeMBtn.setBackground(new Color(155, 232, 23));
        employeeMBtn.setFont(new Font("������",0,16));        
        employeeMBtn.setIcon(new ImageIcon(getClass().getResource("employee_icon.png")));
        employeeMBtn.setBorderPainted(false);     
        add(employeeMBtn);
        employeeMBtn.setVisible(false);		 //�w�][���u�޲z]���s����
        
        dealMBtn.setBounds(700,20,180,60);
        dealMBtn.setBackground(new Color(155, 232, 23));
        dealMBtn.setFont(new Font("������",0,16));   
        dealMBtn.setIcon(new ImageIcon(getClass().getResource("deal_icon.png")));
        dealMBtn.setBorderPainted(false);    
        add(dealMBtn);
        dealMBtn.setVisible(false);		 //�w�][����޲z]���s����
        
        exitBtn.setBounds(895,20,80,60);
        exitBtn.setBackground(Color.orange);
        exitBtn.setFont(new Font("������",0,16));     
    //    exitBtn.setIcon(new ImageIcon(getClass().getResource("exit_icon.png")));
        exitBtn.setBorderPainted(false);    
        add(exitBtn);

        setBackground(Color.WHITE);//����
        setLocation(0,0);
        setSize(1000,100);
        setLayout(null);
        setVisible(true);

    }
}
