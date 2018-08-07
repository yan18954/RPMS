 import javax.swing.*;
 import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//�H�����ʼh���O
//CHCI_COM_panel: Class HumanComputerInteraction_CheckOutMeals_panel (�H������-[���b�\�I]�ާ@�e�����O)
public class CHCI_COM_panel extends JPanel{
	JLabel IDlbl=new JLabel("����s���G");
	JLabel datelbl=new JLabel("����ɶ��G");
	JLabel sumlbl=new JLabel("�`���B�@�G");
	JLabel paywaylbl=new JLabel("�I�ڤ覡�G");
	JLabel servicelbl=new JLabel("�A�ȶO�@�G");
	JLabel marginlbl=new JLabel("�t�@�B�@�G");
	JLabel elselbl=new JLabel("��L���B�G");
	JLabel dealMoneylbl=new JLabel("�������B�G");
	JLabel paylbl=new JLabel("�ꦬ���B�G");
	JLabel changelbl=new JLabel("��@�s�@�G");
	
	JTextField IDTxtFd =new JTextField();
	JTextField dateTxtFd =new JTextField();
	JLabel sumTxtFd =new JLabel();
	JTextField payTxtFd =new JTextField();
	
	JLabel server_lbl=new JLabel("0");
	JLabel orther_lbl=new JLabel("0");
	JLabel amount_lbl=new JLabel("");

	
	JButton cashbtn =new JButton("�{��");
	JButton giftcerbtn =new JButton("§��");	
	JButton hunderbtn =new JButton("100");
	JButton fivehunderbtn =new JButton("500");	
	JButton thousandbtn =new JButton("1000");	
	JButton countbtn[][] =new JButton[2][5];
	JButton clearbtn=new JButton("�M��");
	JButton checkbtn=new JButton("�T�w");
	
	String [][]countStr={{"1","3","5","7","9"},{"2","4","6","8","0"}};
	String no_date;
	int myTrans_no[]={0,0,0};
	int total=0;
	int temp=0;
	boolean Banknotes=false;	//���L�ܼ�,�O���ϥΪ̬O�_��ίȶr
	boolean Num=false;			//���L�ܼ�,�����ϥΪ̬O�_�����ϥμƦr�s�I����B
//	boolean check=false;		//���L�ܼ�,�����O�_�i�H���b
	CHCI_COM_panel(){
		
		//�]�m����s��
		IDlbl.setBounds(10,5,90,40);
		IDlbl.setFont(new Font("������",1,16));
		IDTxtFd.setBounds(100,8,130,30);
		IDTxtFd.setFont(new Font("������",1,15));		
		IDTxtFd.setBorder(BorderFactory.createLoweredBevelBorder());
		IDTxtFd.setEnabled(false);
		add(IDlbl);
		add(IDTxtFd);		
		//�]�m����ɶ�		
		datelbl.setBounds(250,5,90,40);
		datelbl.setFont(new Font("������",1,16));
		dateTxtFd.setBounds(350,8,120,30);
		dateTxtFd.setFont(new Font("������",1,18));	
		dateTxtFd.setBorder(BorderFactory.createLoweredBevelBorder());
		dateTxtFd.setEnabled(false);
		add(datelbl);		
		add(dateTxtFd);	
		setClassDate();
		//�]�m�`���B
		sumlbl.setBounds(10,45,90,45);
		sumlbl.setFont(new Font("������",1,16));
		sumTxtFd.setBounds(100,50,120,30);
		sumTxtFd.setFont(new Font("������",1,18));	
		sumTxtFd.setForeground(Color.red);
		sumTxtFd.setBorder(BorderFactory.createLoweredBevelBorder());	
		//sumTxtFd.setEnabled(false);	
		add(sumlbl);		
		add(sumTxtFd);		
		//�]�m�I�ڤ覡
		paywaylbl.setBounds(10,85,90,45);
		paywaylbl.setFont(new Font("������",1,16));
		cashbtn.setBounds(100,88,120,45);
		cashbtn.setFont(new Font("������",0,16));	
		giftcerbtn.setBounds(250,88,120,45);
		giftcerbtn.setFont(new Font("������",0,16));	
		add(paywaylbl);		
		add(cashbtn);	
		add(giftcerbtn);			
		
		//�]�m�A�ȶO�A�{��
		servicelbl.setBounds(10,130,90,45);
		servicelbl.setFont(new Font("������",1,16));	
		server_lbl.setBounds(100,138,120,30);
		server_lbl.setFont(new Font("������",1,16));	
		add(server_lbl);		
		add(servicelbl);		
		
		//�]�m�t�B�A§��
		marginlbl.setBounds(10,170,90,45);
		marginlbl.setFont(new Font("������",1,16));	
		giftcerbtn.setEnabled(false);
		add(marginlbl);		
		marginlbl.setVisible(false);
		//�]�m��L���B
		elselbl.setBounds(10,170,90,45);
		elselbl.setFont(new Font("������",1,16));	
		orther_lbl.setBounds(100,178,120,30);
		orther_lbl.setFont(new Font("������",1,16));	
		add(elselbl);	
		add(orther_lbl);	

		//�]�m�������B
		dealMoneylbl.setBounds(10,210,90,45);
		dealMoneylbl.setFont(new Font("������",1,16));	
		amount_lbl.setBounds(100,210,90,45);
		amount_lbl.setFont(new Font("������",1,18));	
		amount_lbl.setForeground(Color.red);
		add(amount_lbl);
		add(dealMoneylbl);
		
		//�]�m�ꦬ���B
		paylbl.setBounds(10,250,90,45);
		paylbl.setFont(new Font("������",1,16));	
		add(paylbl);	
		payTxtFd.setBounds(100,254,120,30);
		payTxtFd.setFont(new Font("������",0,16));	
		payTxtFd.setBorder(BorderFactory.createLoweredBevelBorder());	
		add(payTxtFd);		
		
		//�]�m�{��
		for(int x=0;x<countbtn.length;x++){
			for(int y=0;y<countbtn[0].length;y++){	
				countbtn[x][y]=new JButton(countStr[x][y]);
				countbtn[x][y].setFont(new Font("������",1,16));	
				countbtn[x][y].setBackground(Color.orange);
				countbtn[x][y].setBounds(10+78*y,360+x*78,75,75);
				countbtn[x][y].setBorderPainted(false);
				countbtn[x][y].addActionListener(ProcessMoneyBtn);
				add(countbtn[x][y]);
			}
		}
		
		clearbtn.setBounds(400,360,75,75);
		clearbtn.setFont(new Font("������",1,16));	
		clearbtn.setBorderPainted(false);
		clearbtn.setBackground(new Color(255, 243, 138));
		clearbtn.addActionListener(ProcessMoneyBtn);
		add(clearbtn);	
		checkbtn.setBounds(400,438,75,75);
		checkbtn.setFont(new Font("������",1,16));	
		checkbtn.setForeground(Color.white);
		checkbtn.setBackground(Color.red);
		checkbtn.addActionListener(ProcessMoneyBtn);
		add(checkbtn);		
		
		
		
		hunderbtn.setBounds(10,290,100,60);
		hunderbtn.setBackground(new Color(237, 121, 115));
		hunderbtn.setFont(new Font("������",1,16));	
		hunderbtn.setBorderPainted(false);
		hunderbtn.addActionListener(ProcessMoneyBtn);
		add(hunderbtn);	
		fivehunderbtn.setBounds(120,290,100,60);
		fivehunderbtn.setBackground(new Color(203, 152, 114));
		fivehunderbtn.setFont(new Font("������",1,16));	
		fivehunderbtn.setBorderPainted(false);
		fivehunderbtn.addActionListener(ProcessMoneyBtn);
		add(fivehunderbtn);	
		thousandbtn.setBounds(240,290,100,60);
		thousandbtn.setBackground(new Color(85, 140, 195));
		thousandbtn.setFont(new Font("������",1,16));	
		thousandbtn.setBorderPainted(false);
		thousandbtn.addActionListener(ProcessMoneyBtn);
		add(thousandbtn);	
		
		
      //  setBackground(Color.pink);
        setLocation(500,100);
        setSize(500,600);
        setLayout(null);
	}
    //�ƥ��ť�{��: �B�z���Ȫ��B���
    public ActionListener ProcessMoneyBtn = new ActionListener(){
        public void actionPerformed(ActionEvent e){
        	if(e.getSource()==clearbtn){//[�M��]���s
        		payTxtFd.setText("");
        		total=0;					//�N�`���B��l�Ƭ�0
            	Banknotes=false;
            	Num=false;
        	}
        	if(e.getSource()==checkbtn){//�T�w���s


        	}
        	if(e.getSource()==hunderbtn){//100
        		total+=100;
            	payTxtFd.setText( String.valueOf(total));
            	Banknotes=true;

        	}
        	if(e.getSource()==fivehunderbtn){//500
        		total+=500;
            	payTxtFd.setText( String.valueOf(total));
            	Banknotes=true;

        	}
        	if(e.getSource()==thousandbtn){//1000
        		total+=1000;
            	payTxtFd.setText( String.valueOf(total));
            	Banknotes=true;

        	}
        	for(int x=0;x<countbtn.length;x++){
        		for(int y=0;y<countbtn[0].length;y++){
        			if(Banknotes==true){//�Y�ϥΪ��I��ȶr,�Ʀr����]�����i�I��
    					countbtn[x][y].setEnabled(false);
    				}
        			else
    					countbtn[x][y].setEnabled(true);

        				if(e.getSource()==countbtn[x][y]){
        					if(payTxtFd.getText().length()>5)
        	                      JOptionPane.showMessageDialog(null,"�浧������B�W���� 99 �U�I"); 
        					else{
        						Num=true;
            					if(x==0 && y==0)
            						payTxtFd.setText(payTxtFd.getText()+"1");
            					if(x==0 && y==1)
            						payTxtFd.setText(payTxtFd.getText()+"3");
            					if(x==0 && y==2)
            						payTxtFd.setText(payTxtFd.getText()+"5");
            					if(x==0 && y==3)
            						payTxtFd.setText(payTxtFd.getText()+"7");
            					if(x==0 && y==4)
            						payTxtFd.setText(payTxtFd.getText()+"9");
            					if(x==1 && y==0)
            						payTxtFd.setText(payTxtFd.getText()+"2");
            					if(x==1 && y==1)
            						payTxtFd.setText(payTxtFd.getText()+"4");
            					if(x==1 && y==2)
            						payTxtFd.setText(payTxtFd.getText()+"6");
            					if(x==1 && y==3)
            						payTxtFd.setText(payTxtFd.getText()+"8");
            					if(x==1 && y==4)
            						payTxtFd.setText(payTxtFd.getText()+"0");
            
        					}

        	            //	payTxtFd.setText( String.valueOf(total)); //��s�`���B
        				}
        				if(Num==true){
        					hunderbtn.setEnabled(false);
        					fivehunderbtn.setEnabled(false);
        					thousandbtn.setEnabled(false);
        				}
        				else{
        					hunderbtn.setEnabled(true);
        					fivehunderbtn.setEnabled(true);
        					thousandbtn.setEnabled(true);	
        				}
        			}
        		
        	}
        	
        	
        	
        	
        }
    };
	//��k:�]�m��e���
	 void setClassDate(){
		 Clock c1 = new Clock();
		 String dateStr;
		 int year,month,date;
		 year = c1.getYear();	//���o[�t�η�e�~�����]
		 month = c1.getMonth(); //���o[�t�η�e������]
		 date = c1.getDate();   //���o[�t�η�e�ѼƸ��]
		 String y,m,d;
		 y=String.valueOf(year);
		 m=String.valueOf(month);
		 if(m.length()==1)
			 m="0"+m;
		 d=String.valueOf(date);
		 if(d.length()==1)
			 d="0"+d;
		 dateStr = y+("/")+m+("/")+d; //�N���o�������ƥH"yyyy/mm/dd"�榡�s�JdateStr�r��
		 no_date = y+("")+m+("")+d; 	//�N���o������������O�s��������r��
		 dateTxtFd.setText(dateStr);
	 }

}
