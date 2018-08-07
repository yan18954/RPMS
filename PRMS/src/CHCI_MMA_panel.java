import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//�H�����ʼh���O
//CHCI_MMA_panel: Class HumanComputerInteraction_ManageMAterials_panel (�H������-[�޲z����]�ާ@�e�����O)
public class CHCI_MMA_panel extends JPanel implements ActionListener{
	static CHCI_MMAO_panel myMMAO_pane=new CHCI_MMAO_panel();  //�޲z���ƾާ@��������(��JPanel,���t����,��r���,���s��)
	CHCI_MMAQ_panel myMMAQ_pane=new CHCI_MMAQ_panel();  //�޲z���ƾާ@��������(��JPanel,���t����,��r���,���s��)
	static CDM_BS_dbma dbma = new CDM_BS_dbma();
	
	CHCI_MMA_panel(){
		add(myMMAO_pane);
		add(myMMAQ_pane);
		
		//�[�J��ť
    	myMMAO_pane.pmbtn.addActionListener(this);
    	myMMAO_pane.mmakbtn.addActionListener(this);
    	myMMAO_pane.mcbtn.addActionListener(this);
    	setmyMMAO();
    	setmyMMAQ();
    	
		setBackground(Color.yellow);
		setBounds(0, 100, 1000, 600);
		setLayout(null);
	}
	
	private void setmyMMAO(){
		
		myMMAO_pane.pmbtn.addActionListener(this);
		myMMAO_pane.mmakbtn.addActionListener(this);
		myMMAO_pane.mcbtn.addActionListener(this);
		
		myMMAO_pane.addOrbtn.addActionListener(this);
		myMMAO_pane.ediOrbtn.addActionListener(this);
		myMMAO_pane.crePRfbtn.addActionListener(this);
		myMMAO_pane.addMabtn.addActionListener(this);
		myMMAO_pane.ediMabtn.addActionListener(this);
		myMMAO_pane.creMRfbtn.addActionListener(this);
		myMMAO_pane.addMcbtn.addActionListener(this);
		myMMAO_pane.ediMcbtn.addActionListener(this);
		myMMAO_pane.ediOrbtn.addActionListener(this);
		
		//�s�赲���Y�ɧ�s�d�ߵ��G�A�B�z
		myMMAO_pane.myEO_pane.updatebtn.addActionListener(this);
		myMMAO_pane.myEMA_pane.updatebtn.addActionListener(this);
		myMMAO_pane.myECO_pane.updatebtn.addActionListener(this);
	}
	private void setmyMMAQ() {
		myMMAQ_pane.myQP_pane.kindradio[0].addActionListener(this);
		myMMAQ_pane.myQP_pane.kindradio[1].addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == myMMAO_pane.pmbtn) {
			myMMAQ_pane.myQP_pane.setVisible(true); // �N[�d�߭q�����O��������]�]�����
			myMMAQ_pane.mySPR_pane.setVisible(true); // �N[��ܭq��d�ߵ��G���O��������]�]�����
			myMMAQ_pane.myQMA_pane.setVisible(false); // �N[�d�ߪ��ƭq�����O��������]�]������
			myMMAQ_pane.mySMAR_pane.setVisible(false); // �N[��ܪ��Ƭd�ߵ��G���O��������]�]������
			myMMAQ_pane.myQCO_pane.setVisible(true); // �N[�d�߼t�ӭq�����O��������]�]������
			myMMAQ_pane.mySCO_pane.setVisible(true); // �N[��ܼt�Ӭd�ߵ��G���O��������]�]������
			
			//��s�t�ӦC��
			myMMAO_pane.myAO_pane.getCompanyList();
			myMMAO_pane.myEO_pane.getCompanyList();
			myMMAO_pane.myEOL_pane.getNameList();

		}
		if (e.getSource() == myMMAO_pane.mmakbtn) {
			myMMAQ_pane.myQMA_pane.setVisible(true); // �N[�d�ߪ��ƭq�����O��������]�]�����
			myMMAQ_pane.mySMAR_pane.setVisible(true); // �N[��ܪ��Ƭd�ߵ��G���O��������]�]�����
			myMMAQ_pane.myQP_pane.setVisible(false); // �N[�d�߭q�����O��������]�]������
			myMMAQ_pane.mySPR_pane.setVisible(false); // �N[��ܭq��d�ߵ��G���O��������]�]������
        	myMMAQ_pane.mySPLR_pane.setVisible(false);
			myMMAQ_pane.myQCO_pane.setVisible(true); // �N[�d�߼t�ӭq�����O��������]�]������
			myMMAQ_pane.mySCO_pane.setVisible(true); // �N[��ܼt�Ӭd�ߵ��G���O��������]�]������

		}
		if (e.getSource() == myMMAO_pane.mcbtn) {
			myMMAQ_pane.myQCO_pane.setVisible(true); // �N[�d�߼t�ӭq�����O��������]�]�����
			myMMAQ_pane.mySCO_pane.setVisible(true); // �N[��ܼt�Ӭd�ߵ��G���O��������]�]�����
			myMMAQ_pane.myQP_pane.setVisible(false); // �N[�d�߭q�����O��������]�]������
			myMMAQ_pane.mySPR_pane.setVisible(false); // �N[��ܭq��d�ߵ��G���O��������]�]������
        	myMMAQ_pane.mySPLR_pane.setVisible(false);
			myMMAQ_pane.myQMA_pane.setVisible(false); // �N[�d�ߪ��ƭq�����O��������]�]������
			myMMAQ_pane.mySMAR_pane.setVisible(false); // �N[��ܪ��Ƭd�ߵ��G���O��������]�]������

		}
		
		if(e.getSource() == myMMAO_pane.myEO_pane.updatebtn){	//�B�z�s�誫�����O�A��s���s���U
			System.out.println("�B�z�s�誫�����O�A��s���s���U");
			if(!myMMAQ_pane.myQP_pane.getKeyin().equals("")){
				System.out.println("�B�z�s�誫�����O�A��s���s���U1");
				myMMAQ_pane.mySPR_pane.Query_addDate(myMMAQ_pane.myQP_pane.get_Selected_qr(),myMMAQ_pane.myQP_pane.getKeyin());
			}
			else{
				System.out.println("�B�z�s�誫�����O�A��s���s���U2");
				myMMAQ_pane.mySPR_pane.Query_addDate(myMMAQ_pane.myQP_pane.get_Selected_qr(),"");
			}
		}
		if(e.getSource() == myMMAO_pane.myEMA_pane.updatebtn){	//�B�z�s�誫�����O�A��s���s���U
			System.out.println("�B�z�s�誫�����O�A��s���s���U");
			if(!myMMAQ_pane.myQMA_pane.getKeyin().equals("")){
				myMMAQ_pane.mySMAR_pane.Query_addDate(myMMAQ_pane.myQMA_pane.get_Selected_qr(),myMMAQ_pane.myQMA_pane.getKeyin());
			}
			else{
				myMMAQ_pane.mySMAR_pane.Query_addDate(myMMAQ_pane.myQMA_pane.get_Selected_qr(),"");
			}	
		}
		if(e.getSource() == myMMAO_pane.myECO_pane.updatebtn){	//�B�z�s��t�����O�A��s���s���U
			if(!myMMAQ_pane.myQCO_pane.getKeyin().equals("")){
				myMMAQ_pane.mySCO_pane.Query_addDate(myMMAQ_pane.myQCO_pane.get_Selected_qr(),myMMAQ_pane.myQCO_pane.getKeyin());
			}
			else{
				myMMAQ_pane.mySCO_pane.Query_addDate(myMMAQ_pane.myQCO_pane.get_Selected_qr(),"");
			}
		}

	
		
		//=======================================================================
        if(e.getSource() ==  myMMAO_pane.pmbtn){
        	myMMAO_pane.mp_panel.setVisible(true);         //���[���ʺ޲z�l�ﶵ]�ާ@�e��	  
        	myMMAO_pane.myAO_pane.setVisible(true); 	   //�w�]���[���ʺ޲z-�s�W�q��]
        	myMMAO_pane.mmk_panel.setVisible(false);	   //����[�����`���޲z�l�ﶵ]�ާ@�e��
        	myMMAO_pane.mco_panel.setVisible(false);	   //����[�t�Ӻ޲z�l�ﶵ]�ާ@�e��

        	myMMAO_pane.myAMA_pane.setVisible(false);      //����[���ƺ޲z�l�e��]     
        	myMMAO_pane.myEMA_pane.setVisible(false);
        	myMMAO_pane.myCMR_pane.setVisible(false);
        	myMMAO_pane.myACO_pane.setVisible(false);      //����[�t�Ӻ޲z�l�e��]	  
        	myMMAO_pane.myECO_pane.setVisible(false);

        }
        if(e.getSource() ==  myMMAO_pane.mmakbtn){
        	myMMAO_pane.mmk_panel.setVisible(true);	   		//���[�����`���޲z�l�ﶵ]�ާ@�e��
        	myMMAO_pane.myAMA_pane.setVisible(true);        //�w�]���[���ƺ޲z-�s�W�q��]
        	myMMAO_pane.mp_panel.setVisible(false);         //����[���ʺ޲z�l�ﶵ]�ާ@�e��	
        	myMMAO_pane.mco_panel.setVisible(false);	    //����[�t�Ӻ޲z�l�ﶵ]�ާ@�e��
       		
        	myMMAO_pane.myAO_pane.setVisible(false);        //����[���ʺ޲z�l�e��]
        	myMMAO_pane.myEO_pane.setVisible(false);
        	myMMAO_pane.myEOL_pane.setVisible(false);
        	myMMAO_pane.myCPR_pane.setVisible(false);
        	myMMAO_pane.myACO_pane.setVisible(false);       //����[�t�Ӻ޲z�l�e��]	  
        	myMMAO_pane.myECO_pane.setVisible(false);
        }
        if(e.getSource() ==  myMMAO_pane.mcbtn){
        	myMMAO_pane.mco_panel.setVisible(true);	   		//���[�t�Ӻ޲z�l�ﶵ]�ާ@�e��
        	myMMAO_pane.myACO_pane.setVisible(true);        //�w�]���[�t�Ӻ޲z-�s�W�q��]
        	myMMAO_pane.mmk_panel.setVisible(false);	   	//����[�����`���޲z�l�ﶵ]�ާ@�e��
        	myMMAO_pane.mp_panel.setVisible(false);         //����[���ʺ޲z�l�ﶵ]�ާ@�e��	

        	myMMAO_pane.myAMA_pane.setVisible(false);       //����[���ƺ޲z�l�e��]          
        	myMMAO_pane.myEMA_pane.setVisible(false);
        	myMMAO_pane.myCMR_pane.setVisible(false);     		
        	myMMAO_pane.myAO_pane.setVisible(false);        //����[���ʺ޲z�l�e��]
        	myMMAO_pane.myEO_pane.setVisible(false);
        	myMMAO_pane.myEOL_pane.setVisible(false);
        	myMMAO_pane.myCPR_pane.setVisible(false);
         }
        if(e.getSource() ==  myMMAO_pane.addOrbtn){
        	myMMAO_pane.myAO_pane.setVisible(true);          //���[�s�W�q����]�ާ@�e��	  
        	myMMAO_pane.myEO_pane.setVisible(false);
        	myMMAO_pane.myEOL_pane.setVisible(false);
        	myMMAO_pane.myCPR_pane.setVisible(false);
        }
        if(e.getSource() ==  myMMAO_pane.ediOrbtn){	//���[�s��q����]�ާ@�e��	  
        	if(myMMAQ_pane.myQP_pane.kindSelected){
    			myMMAO_pane.myEO_pane.setVisible(true);
    			myMMAO_pane.myEOL_pane.setVisible(false);
        	}
        	else{
    			myMMAO_pane.myEO_pane.setVisible(false);
    			myMMAO_pane.myEOL_pane.setVisible(true);
        	}      
        	myMMAO_pane.myAO_pane.setVisible(false);
        	myMMAO_pane.myCPR_pane.setVisible(false);
        }
        
//        if(e.getSource() ==  myMMAO_pane.ediOrbtn){	
//        	myMMAO_pane.myEO_pane.setVisible(true);          //���[�s��q����]�ާ@�e��	  
//        	myMMAO_pane.myAO_pane.setVisible(false);
//        	myMMAO_pane.myCPR_pane.setVisible(false);
//        }
        if(e.getSource() ==  myMMAO_pane.crePRfbtn){
        	myMMAO_pane.myCPR_pane.setVisible(true);         //���[���ͱ��ʳ�����]�ާ@�e��	  
        	myMMAO_pane.myAO_pane.setVisible(false);
        	myMMAO_pane.myEO_pane.setVisible(false);
        	myMMAO_pane.myEOL_pane.setVisible(false);
        }

        if(e.getSource() ==  myMMAO_pane.addMabtn){
        	myMMAO_pane.myAMA_pane.setVisible(true);         //���[�s�W�����`�����]�ާ@�e��	  
        	myMMAO_pane.myEMA_pane.setVisible(false);
        	myMMAO_pane.myCMR_pane.setVisible(false);
        }
        if(e.getSource() ==  myMMAO_pane.ediMabtn){
        	myMMAO_pane.myEMA_pane.setVisible(true);		 //���[�s�誫���`�����]�ާ@�e��
        	myMMAO_pane.myAMA_pane.setVisible(false); 
        	myMMAO_pane.myCMR_pane.setVisible(false);
        	
        }
        if(e.getSource() ==  myMMAO_pane.creMRfbtn){
        	myMMAO_pane.myCMR_pane.setVisible(true);         //���[���ͪ��Ƴ�����]�ާ@�e��	  
        	myMMAO_pane.myEMA_pane.setVisible(false);
        	myMMAO_pane.myAMA_pane.setVisible(false);
        }
        if(e.getSource() ==  myMMAO_pane.addMcbtn){
        	myMMAO_pane.myACO_pane.setVisible(true);         //���[�s�W�t�Ӹ��]�ާ@�e��	  
        	myMMAO_pane.myECO_pane.setVisible(false);
        }
        if(e.getSource() ==  myMMAO_pane.ediMcbtn){
        	myMMAO_pane.myECO_pane.setVisible(true);		 //���[�s��t�Ӹ��]�ާ@�e��
        	myMMAO_pane.myACO_pane.setVisible(false); 
        }
        
        
        if(e.getSource() == myMMAQ_pane.myQP_pane.kindradio[0]){	//�B�z�I�������e��
        	myMMAQ_pane.mySPR_pane.ShowOrderTable();
        	if(myMMAO_pane.myEOL_pane.isVisible()){
    			myMMAO_pane.myEO_pane.setVisible(true);
    			myMMAO_pane.myEOL_pane.setVisible(false);
        	}
        }
        if(e.getSource() == myMMAQ_pane.myQP_pane.kindradio[1]){
        	myMMAQ_pane.mySPR_pane.ShowOrderListTable();
        	if(myMMAO_pane.myEO_pane.isVisible()){
    			myMMAO_pane.myEO_pane.setVisible(false);
    			myMMAO_pane.myEOL_pane.setVisible(true);       		
        	}
        }
	}
    
	
	public static void setOrderData(String[] sendStr){
		//System.out.printf("setOrderData");
		myMMAO_pane.myEO_pane.DefaultStatus();
		myMMAO_pane.myEO_pane.setAllEnable();
		myMMAO_pane.myEO_pane.notxt.setText(sendStr[0]);
		myMMAO_pane.myEO_pane.datetxt.setText(sendStr[1]);
		myMMAO_pane.myEO_pane.StatusCombo.setSelectedIndex(Integer.parseInt(sendStr[2]));
		myMMAO_pane.myEO_pane.CompanyCombo.setSelectedIndex(getClListIndex(dbma.findRD_in_TB_ClColumn(sendStr[3], "CL_no", "CL_company")));
		myMMAO_pane.myEO_pane.totaltxt.setText(sendStr[4]);
		myMMAO_pane.myEO_pane.setAllDisable();				
		
		myMMAO_pane.myEOL_pane.notxt.setText(sendStr[0]);
	}
	
	public static void setMiData(String[] sendStr){
		myMMAO_pane.myEMA_pane.DefaultStatus();
		myMMAO_pane.myEMA_pane.setAllEnable();
		myMMAO_pane.myEMA_pane.notxt.setText(sendStr[0]);
		myMMAO_pane.myEMA_pane.nametxt.setText(sendStr[1]);
		myMMAO_pane.myEMA_pane.TypeCombo.setSelectedIndex(0);	
		myMMAO_pane.myEMA_pane.notetxt.setText(sendStr[3]);
		myMMAO_pane.myEMA_pane.setAllDisable();				
	}
	
	public static void setClData(String[] sendStr){
		myMMAO_pane.myECO_pane.DefaultStatus();
		myMMAO_pane.myECO_pane.setAllEnable();
		myMMAO_pane.myECO_pane.notxt.setText(sendStr[0]);
		myMMAO_pane.myECO_pane.nametxt.setText(sendStr[1]);
		myMMAO_pane.myECO_pane.contacttxt.setText(sendStr[2]);
		myMMAO_pane.myECO_pane.teltxt.setText(sendStr[3]);
		myMMAO_pane.myECO_pane.notetext.setText(sendStr[4]);
		myMMAO_pane.myECO_pane.setAllDisable();
	}
	
	public static int getClListIndex(String Company) {
		int i;
		System.out.print("Company ="+Company);
		
		for(i = 0; i <myMMAO_pane.myEO_pane.CompanyCombo.getItemCount(); i++){
			if( myMMAO_pane.myEO_pane.CompanyCombo.getItemAt(i).toString().equals(Company)){
				break;
			}
		}
		return i;
	}
}
