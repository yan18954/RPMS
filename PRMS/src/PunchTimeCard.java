import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;
import java.text.*;
//���d����
class SimpleTask extends TimerTask{            //�t�ήɶ�
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
	public void run(){
		//System.out.println(sdf.format(new Date()));
		PunchTimeCard.lbl_SystemTime.setText(sdf.format(new Date()));
	}
}

class PunchTimeCard extends JFrame implements ActionListener{
	boolean click = true;
	SimpleTask myTask = new SimpleTask();
	CDM_ST_dbma dbma = new CDM_ST_dbma();
	Timer timer = new Timer();
	Font font1 = new Font("�L�n������",Font.BOLD,38);  //�j��
	Font font2 = new Font("�L�n������",Font.BOLD,18);  //�q�� ���s��
	Font font3 = new Font("�L�n������",Font.BOLD,30);  //�Ʀr�j����
	Font font4 = new Font("�L�n������",Font.BOLD,20);  //�U����s��
	public static JLabel lbl_SystemTime = new JLabel();
	JLabel lbl[] = new JLabel[2];
	JTextField txtfd_StaffId = new JTextField();
	JButton btn_Check_In = new JButton();
	JButton btn_Check_Out = new JButton();
	JButton btn_Submit = new JButton();
	JButton btn_Cancel = new JButton();
	JPanel pane = new JPanel();
	PunchTimeCard(){
		
		timer.schedule(new SimpleTask(),0, 1000);
		
		
		pane = new JPanel();
		pane.setBounds(0,0,500,350);
		pane.setLayout(null);
		//pane.setBackground(Color.pink);
		add(pane);
		
		lbl_SystemTime = new JLabel();
		lbl_SystemTime.setBounds(220,170,200,40);
		lbl_SystemTime.setFont(font2);
		pane.add(lbl_SystemTime);
		
		
		
		for(int i=0;i<lbl.length;i++){
			lbl[i] = new JLabel();	
			lbl[i].setFont(font4);
			pane.add(lbl[i]);
		}
		lbl[0].setText("�t�ήɶ�");
		lbl[0].setBounds(50,170,150,40);
		
		lbl[1].setText("���u�s��");
		lbl[1].setBounds(50,100,150,50);
		txtfd_StaffId = new JTextField();
		txtfd_StaffId.setFont(font4);
		txtfd_StaffId.setBounds(220,110,200,40);
		
		pane.add(txtfd_StaffId);
		
		btn_Check_In = new JButton("�W�Z");
		btn_Check_In.setBounds(50,30,170,50);
		btn_Check_In.setFont(font4);
		btn_Check_In.setBorder(BorderFactory.createLineBorder(Color.red,3));
		btn_Check_In.addActionListener(this);
		//btn_Check_In.setBorder(BorderFactory.createRaisedBevelBorder()); 
		pane.add(btn_Check_In);
		
		btn_Check_Out = new JButton("�U�Z");
		btn_Check_Out.setBounds(250,30,170,50);
		btn_Check_Out.setFont(font4);
		btn_Check_Out.addActionListener(this);
		pane.add(btn_Check_Out);
		
		btn_Submit = new JButton("�T�{�W�Z");
		btn_Submit.setBounds(250,230,170,50);
		btn_Submit.setFont(font4);
		btn_Submit.addActionListener(this);
		//btn_Submit.setContentAreaFilled(false);
		pane.add(btn_Submit);
		
		btn_Cancel = new JButton("����");
		btn_Cancel.setBounds(50,230,170,50);
		btn_Cancel.setFont(font4);
		btn_Cancel.addActionListener(this);
		pane.add(btn_Cancel);
		
	
		setTitle("���u���d");
		setLayout(null);
		setBounds(10,10,500,350);
        setLocationRelativeTo(null);//�e���m��       
		setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){            // ActionPerformed
			if(e.getSource()==btn_Check_In){   //���W�Z�d
				click = true;
				btn_Check_In.setBorder(BorderFactory.createLineBorder(Color.red,3));
				btn_Check_Out.setBorder(null);
				btn_Submit.setText("�T�{�W�Z");
			}
	
			if(e.getSource()==btn_Check_Out){   //���U�Z�d
				click = false;
				btn_Check_Out.setBorder(BorderFactory.createLineBorder(Color.red,3));
				btn_Check_In.setBorder(null);
				btn_Submit.setText("�T�{�U�Z");

			}
			if(e.getSource()==btn_Cancel){   //�I������
				dispose();      
			}
			
			if(e.getSource()==btn_Submit){
				String[] str_ptc = {myTask.date.format(new Date()),myTask.time.format(new Date()),"N/A","N/A",txtfd_StaffId.getText()};
				//System.out.println("�{�b���:"+myTask.date.format(new Date()));
				//System.out.println("�{�b�ɶ�:"+myTask.time.format(new Date()));				
				//check();
				if(click){                  //�W�Z�d�y�{
					//System.out.printf("�W�Z�d");
					if(check()){
						//0checkPTC_in();
						if(checkPTC_in()){
							dbma.insertRD_into_TB_ptc(str_ptc); //���J�W�Z�d��Ʀ�PTC��ƪ�
						}
						
						}
				}
				
				
				
				else{                      //�U�Z�d�y�{
					//System.out.printf("�U�Z�d");
					if(check()){
						if(checkPTC_out()){
							dbma.updateRD_in_TB_ptc(myTask.date.format(new Date()), myTask.time.format(new Date()),txtfd_StaffId.getText());
						}
						//System.out.printf("�W�Z�d�b�����T");
						
					}
					
					
				}
				
				
			
			}
			
		}
	
	
	private boolean check (){         //�ˬd���d�O�_���T �ܸ�Ʈw�T�{���u�s�� �T�{�W�Z�U�Z�d�O�_�ŦX�޿�
		//System.out.printf("�I�s�Fcheck��k!\n");
		String rc = dbma.findExistId_in_TB_staff(txtfd_StaffId.getText());
		if(rc==""){
			JOptionPane.showMessageDialog(null,"�d�L���b��!");
			return false;
		}
		else{
			//System.out.println("�b�����T:" +rc);
			return true;
		}
	}
	
	private boolean checkPTC_in(){
		String[] rq = dbma.findPTC_in_TB_PTC(txtfd_StaffId.getText());
		//System.out.print(rq[1]);
		if(rq[1].equals(myTask.date.format(new Date()))){
			JOptionPane.showMessageDialog(null,"���Ѥw�g���L�W�Z�d�o!");
			return false;
		}
		else{
			return true;
		}
			
			

	}
	
	private boolean checkPTC_out(){
		String[] rq = dbma.findPTC_in_TB_PTC(txtfd_StaffId.getText());
		if(rq[2].equals(myTask.date.format(new Date()))){
			JOptionPane.showMessageDialog(null,"���Ѥw�g���L�U�Z�d�o!");
			return false;
		}
		
		else if(rq[1].equals(myTask.date.format(new Date())) == false ){
			JOptionPane.showMessageDialog(null,"���d�ߨ�W�Z�d!");
			return false;
		}
		else {
			return true;
		}
		
	}
	
	
	
}

