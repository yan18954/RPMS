 import javax.swing.*;
 import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//�H�����ʼh���O
//CHCI_CNSI_panel: Class HumanComputerInteraction_ChoseNumber and ShowInfo_panel (�H������-[�p��ƶq�P��ܸ�T��������]�ާ@�e�����O)
public class CHCI_CNSI_panel extends JPanel{
	JPanel calculation_panel =new JPanel();	//�t �ƶq���s
	JPanel nowinfo_panel=new JPanel();		//�t �\�I�W�١B�\�I�ƶq�B����B�`�������
	JPanel check_panel=new JPanel();		//�t �s�W�B����B��^���s
	JButton calBtn[][]=new JButton[4][3];	//�ƶq���s
	JButton chBtn=new JButton("�s�W");		//�s�W���s
	JButton rechBtn=new JButton("����");		//������s
	JButton backBtn=new JButton("��^");		//�ƶq���s
	String[][] calBtnString={{"7","8","9"},{"4","5","6"},{"1","2","3"},{"0","�M��","�˰h"}};
	JLabel namelbl=new JLabel("�\�I�W�١G");
	JLabel set_namelbl=new JLabel("");
	JLabel pricelbl=new JLabel("��    ���G");
	JLabel set_pricelbl=new JLabel("");
	JLabel tens_numlbl=new JLabel("");	//JLable:�ΨӰO���Q��Ʀr
	JLabel ones_numlbl=new JLabel("");	//JLable:�ΨӰO���Ӧ�Ʀr
	JLabel numlbl=new JLabel("��    �q�G");	
	JLabel sumlbl=new JLabel("�p    �p�G");
	JLabel set_sumlbl=new JLabel("");	
	int num=1;	//������e�I����
	int back_times=0;
	boolean selectedNum=false;			//boolean�ܼ�:�ΨӰO���Q������O�_���Ʀr��
	boolean MealIsSelected=false;		//boolean�ܼ�:�ΨӰO���\�I�O�_�Q���
	boolean MealIsInsert=true;			//boolean�ܼ�:�ΨӰO���\�I�O�_�����s�W
	CHCI_CNSI_panel(){
		setBackground(new Color(215, 244, 242));
		setBounds(700,0,300,700);
		setLayout(null);
		/*JPanel�Gnowinfo�Ψ���ܤw��ܸ�T*/
		nowinfo_panel.setBackground(new Color(215, 244, 242));
		nowinfo_panel.setBounds(0, 0, 300, 100);
		nowinfo_panel.setBorder(BorderFactory.createEtchedBorder());
		nowinfo_panel.setLayout(null);
		add(nowinfo_panel);			
		//�]�m�W�ټ���
		namelbl.setBounds(5, 0, 80, 25);	
		namelbl.setFont(new Font("������",1,14));
		nowinfo_panel.add(namelbl);		
		set_namelbl.setBounds(90, 0, 300, 25);	
		set_namelbl.setFont(new Font("������",0,14));
		nowinfo_panel.add(set_namelbl);		
		//�]�m�������
		pricelbl.setBounds(5, 25, 70, 25);	
		pricelbl.setFont(new Font("������",1,14));
		nowinfo_panel.add(pricelbl);
		set_pricelbl.setBounds(90, 25, 300, 25);	
		set_pricelbl.setFont(new Font("������",0,14));
		nowinfo_panel.add(set_pricelbl);
		//�]�m�ƶq����
		numlbl.setBounds(5, 50, 70, 25);	
		numlbl.setFont(new Font("������",1,14));
		tens_numlbl.setBounds(90, 53, 300, 25);	
		tens_numlbl.setFont(new Font("������",1,14));		
		tens_numlbl.setForeground(Color.red);
		ones_numlbl.setBounds(98, 53, 300, 25);	
		ones_numlbl.setFont(new Font("������",1,14));	
		ones_numlbl.setForeground(Color.red);
		nowinfo_panel.add(numlbl);	
		nowinfo_panel.add(tens_numlbl);	
		nowinfo_panel.add(ones_numlbl);
		//�p�p����set_sumlbl
		sumlbl.setBounds(5, 75, 70, 25);	
		sumlbl.setFont(new Font("������",1,14));
		nowinfo_panel.add(sumlbl);	
		set_sumlbl.setBounds(90, 75, 70, 25);	
		set_sumlbl.setFont(new Font("������",1,14));
		nowinfo_panel.add(set_sumlbl);	
		/*JPanel�Gcalculation_panel�A�t�Ʀr���s*/
		//calculation_panel.setBackground(new Color(228, 26, 255));
		calculation_panel.setBounds(14, 135, 258, 350);	
		calculation_panel.setLayout(new GridLayout(4,3));
		add(calculation_panel);	
		
		for(int x=0;x<calBtn.length;x++){
			for(int y=0;y<calBtn[0].length;y++){	
				calBtn[x][y]=new JButton(calBtnString[x][y]);	
				calBtn[x][y].setFont(new Font("������",1,18));
				calBtn[x][y].setBorder(BorderFactory.createEtchedBorder());
				calBtn[x][y].addActionListener(PressedNumberbtn);
				//itemBtn[x][y].setBorder(BorderFactory.createLoweredBevelBorder());
				//itemBtn[x][y].setBorder(BorderFactory.createRaisedBevelBorder());
				calculation_panel.add(calBtn[x][y]);
			}
		}
		
		/*JPanel�Gcheck_panel�A�t�s�W�B����B��^���s*/
		check_panel.setBackground(new Color(215, 244, 242));
		check_panel.setBounds(5,500,270,150);
		check_panel.setLayout(null);
		add(check_panel);
		
		chBtn.setBounds(150,0,120,80);
		chBtn.setFont(new Font("������",1,16));
		chBtn.setForeground(Color.WHITE);		
		chBtn.setBackground(new Color(255, 112, 112));
		check_panel.add(chBtn);
		rechBtn.setBounds(0,0,120,80);
		rechBtn.setFont(new Font("������",1,16));
		rechBtn.setForeground(Color.WHITE);
		rechBtn.setBackground(new Color(126, 166, 200));
		check_panel.add(rechBtn);
		backBtn.setBounds(0,90,270,50);
		backBtn.setFont(new Font("������",1,16));
		backBtn.setBackground(new Color(243, 219, 63));
		backBtn.setBorderPainted(false);
		check_panel.add(backBtn);
		
	}

    //�ƥ��ť�{��: �B�z�Ʀr���s�I��
    public ActionListener PressedNumberbtn = new ActionListener(){
        public void actionPerformed(ActionEvent e){
        	if(MealIsSelected==true){
            	selectedNum=true;				    //�NselectedNum�ܼƪ�l�Ƭ�true
                if(e.getSource()==calBtn[3][1])     //[�M��]�Q���
                {
                	selectedNum=false;			    //�O���D�Ʀr��Q���			
                	ones_numlbl.setText("");	    //�N�Ӧ�Ʀr�M��
                	tens_numlbl.setText("");	    //�N�Q��Ʀr�M��
                	num=1;					        //�Nnum�]�^1,��ܨϥΪ̱N�q�Q��Ʀr���s���

                }
                if(e.getSource()==calBtn[3][2])     //[�˰h]�Q���
                {            	
//                	selectedNum=false;			    //�O���D�Ʀr��Q���			
                	if(ones_numlbl.getText()==""){  //��ϥΪ̥u�I��@�ӼƦr��
                		tens_numlbl.setText("");    //�N��Q��Ʀr����(���ɬ��Ӧ��)�M��
                    	num=1;					    //�Nnum�]�^1,��ܨϥΪ̥i�H�q�Q��Ʀr���s���	
                	}
                	else{
                	   	ones_numlbl.setText("");	//�N�Ӧ�Ʀr�M��
                    	num=2;					    //�Nnum�]�^2,��ܨϥΪ̥i�H�q�Ӧ�Ʀr���s���
                	}
                }           
            	if(num==3 && selectedNum==true)
                    JOptionPane.showMessageDialog(null,"�浧�\�I�̤j�ƶq��99!");
               	if(num==2){
                    if(e.getSource()==calBtn[3][0])  //�Ʀr[0]�Q���
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "0");
                    	num++;
                    }
                    if(e.getSource()==calBtn[2][0]) //�Ʀr[1]�Q���
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "1");
                    	num++;
                    }
                    if(e.getSource()==calBtn[2][1]) //�Ʀr[2]�Q���
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "2");
                    	num++;
                    }
                    if(e.getSource()==calBtn[2][2]) //�Ʀr[3]�Q���
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "3");
                    	num++;
                    }
                    if(e.getSource()==calBtn[1][0]) //�Ʀr[4]�Q���
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "4");
                    	num++;
                    }
                    if(e.getSource()==calBtn[1][1]) //�Ʀr[5]�Q���
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "5");
                    	num++;
                    }
                    if(e.getSource()==calBtn[1][2]) //�Ʀr[6]�Q���
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "6");
                    	num++;
                    }
                    if(e.getSource()==calBtn[0][0]) //�Ʀr[7]�Q���
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "7");
                    	num++;
                    }
                    if(e.getSource()==calBtn[0][1]) //�Ʀr[8]�Q���
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "8");
                    	num++;
                    }
                    if(e.getSource()==calBtn[0][2]) //�Ʀr[9]�Q���
                    {
                    	ones_numlbl.setText(ones_numlbl.getText() + "9");
                    	num++;
                    }
            	}
            	if(num==1){
                    if(e.getSource()==calBtn[3][0]) //�Ʀr[0]�Q���
                    {
                        JOptionPane.showMessageDialog(null,"�Ĥ@�ӼƦr���o��0!");
                    	num=1;
                    }
                    if(e.getSource()==calBtn[2][0]) //�Ʀr[1]�Q���
                    {
                    	tens_numlbl.setText("1");
                    	num++;
                    }
                    if(e.getSource()==calBtn[2][1]) //�Ʀr[2]�Q���
                    {
                    	tens_numlbl.setText("2");
                    	num++;
                    }
                    if(e.getSource()==calBtn[2][2]) //�Ʀr[3]�Q���
                    {
                    	tens_numlbl.setText("3");
                    	num++;
                    }
                    if(e.getSource()==calBtn[1][0]) //�Ʀr[4]�Q���
                    {
                    	tens_numlbl.setText("4");
                    	num++;
                    }
                    if(e.getSource()==calBtn[1][1]) //�Ʀr[5]�Q���
                    {
                    	tens_numlbl.setText("5");
                    	num++;
                    }
                    if(e.getSource()==calBtn[1][2]) //�Ʀr[6]�Q���
                    {
                    	tens_numlbl.setText("6");
                    	num++;
                    }
                    if(e.getSource()==calBtn[0][0]) //�Ʀr[7]�Q���
                    {
                    	tens_numlbl.setText("7");
                    	num++;
                    }
                    if(e.getSource()==calBtn[0][1]) //�Ʀr[8]�Q���
                    {
                    	tens_numlbl.setText("8");
                    	num++;
                    }
                    if(e.getSource()==calBtn[0][2]) //�Ʀr[9]�Q���
                    {
                    	tens_numlbl.setText("9");
                    	num++;
                    }
            	}
        
           
        	}
        	else
           	   JOptionPane.showMessageDialog(null,"�Х��ܥ������@���\�I!");


        }
    };
}
