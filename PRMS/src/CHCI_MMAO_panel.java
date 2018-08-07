import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
//�H�����ʼh���O
//CHCI_MMAO_panel: Class HumanComputerInteraction_ManageManageMAterialsOperation_panel (�H������-[�޲z����]�ާ@�e�����O)
public class CHCI_MMAO_panel extends JPanel{

	CHCI_AO_panel myAO_pane=new CHCI_AO_panel();        //�s�W�q�����O��������(��JPanel,���t����,��r���,���s��)
	CHCI_EO_panel myEO_pane=new CHCI_EO_panel();        //�s��q�椶������(��JPanel,���t����,��r���,���s��)
	CHCI_EOL_panel myEOL_pane=new CHCI_EOL_panel();     //�s��q��Ӹ`��������(��JPanel,���t����,��r���,���s��)
	CHCI_CPR_panel myCPR_pane=new CHCI_CPR_panel();     //���ͱ��ʳ���������(��JPanel,���t����,��r���,���s��)
	CHCI_AMA_panel myAMA_pane=new CHCI_AMA_panel();     //�s�W�q�����O��������(��JPanel,���t����,��r���,���s��)
	CHCI_EMA_panel myEMA_pane=new CHCI_EMA_panel();     //�s��q�椶������(��JPanel,���t����,��r���,���s��)
	CHCI_CMR_panel myCMR_pane=new CHCI_CMR_panel();     //���ͪ��Ƴ���������(��JPanel,���t����,��r���,���s��	
	CHCI_ACO_panel myACO_pane=new CHCI_ACO_panel();     //�s�W�t�Ӥ�������(��JPanel,���t����,��r���,���s��)
	CHCI_ECO_panel myECO_pane=new CHCI_ECO_panel();     //�s��t�Ӥ�������(��JPanel,���t����,��r���,���s��		
	
	
	JPanel mmabtn_panel =new JPanel();			 		//JPanel�GManageMaterialsButton�A�޲z���Ƥl���ءA�t�޲z���ʡB�޲z���ơA�޲z�t�ӵ�
	JPanel mp_panel=new JPanel();						//JPanel�G(��JPanel,���t�s�W�q��B�s��q��B���Ͷi�f������s��)
	JPanel mmk_panel=new JPanel();						//JPanel�G(��JPanel,���t�s�W���ơB�s�誫�ơB���ͪ��Ƴ�����s��)
	JPanel mco_panel=new JPanel();						//JPanel�G(��JPanel,���t�s�W�t�ӡB�s��t�ӫ��s��)
	
	JButton pmbtn = new JButton("���ʺ޲z");
    JButton mmakbtn = new JButton("���ƺ޲z");
    JButton mcbtn = new JButton("�t�Ӻ޲z");
    
    JButton addOrbtn = new JButton("�s�W�q��");
    JButton ediOrbtn = new JButton("�s��q��");
    JButton crePRfbtn = new JButton("���ͱ��ʳ���");
    JButton addMabtn = new JButton("�s�W����");
    JButton ediMabtn = new JButton("�s�誫��");
    JButton creMRfbtn = new JButton("���ͪ��Ƴ���");
    JButton addMcbtn = new JButton("�s�W�t��");
    JButton ediMcbtn = new JButton("�s��t��");   

	CHCI_MMAO_panel(){
		//���ʺ޲z���s�]�m
		pmbtn.setBounds(5,5,120,45);
		pmbtn.setBackground(Color.CYAN);
		pmbtn.setIcon(new ImageIcon(getClass().getResource("purchase_icon.png")));
		pmbtn.setFont(new Font("������",0,12));
		mmabtn_panel.add(pmbtn);
			//�[�J��ť�ƥ�
		pmbtn.addActionListener(ProcessPaneChanged);
		
		//���ƺ޲z���s�]�m
		mmakbtn.setBounds(130,5,120,45);
		mmakbtn.setBackground(Color.yellow);
		mmakbtn.setIcon(new ImageIcon(getClass().getResource("mangmaterial_icon.png")));
		mmakbtn.setFont(new Font("������",0,12));
		mmabtn_panel.add(mmakbtn);		
			//�[�J��ť�ƥ�
		mmakbtn.addActionListener(ProcessPaneChanged);
		
		//�t�Ӻ޲z���s�]�m
		mcbtn.setBounds(255,5,120,45);
		mcbtn.setBackground(Color.white);
		mcbtn.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		mcbtn.setFont(new Font("������",0,12));
		mmabtn_panel.add(mcbtn);
			//�[�J��ť�ƥ�
		mcbtn.addActionListener(ProcessPaneChanged);		
		
		
		//�[�J�l�\��ާ@���O
		add(myAO_pane);	//�N[�s�W�q�椶������]�[�즹������
		//myAO_pane.setVisible(false);
		add(myEO_pane); //�N[�s��q�椶������]�[�즹������
		myEO_pane.setVisible(false);	
		
		add(myEOL_pane); //�N[�s��q��Ӹ`��������]�[�즹������
		myEOL_pane.setVisible(false);	
		
		add(myCPR_pane); //�N[���ͱ��ʳ���������]�[�즹������		
		myCPR_pane.setVisible(false);
		add(myAMA_pane); //�N[�s�W�����`����������]�[�즹������		
		myAMA_pane.setVisible(false);	
		add(myEMA_pane); //�N[�s�誫���`����������]�[�즹������		
		myEMA_pane.setVisible(false);			
		add(myCMR_pane); //�N[���ͪ��Ƴ���������]�[�즹������		
		myCMR_pane.setVisible(false);	
		add(myACO_pane); //�N[�s�W�t���`����������]�[�즹������		
		myACO_pane.setVisible(false);	
		add(myECO_pane); //�N[�s��t���`����������]�[�즹������		
		myECO_pane.setVisible(false);	
		
		/*���s�����]�m*/
		mmabtn_panel.setBounds(0,0,500,65);
		mmabtn_panel.setLayout(null);
		//mmabtn_panel.setLayout(new FlowLayout());
		add(mmabtn_panel);						//�N[�\����s��������]�[�즹������

		//�]�mmp_panel,���t�s�W�q��B�s��q��B���Ͷi�f������s��
		mp_panel.setBounds(0,65,500,35);
		mp_panel.setVisible(true);
		mp_panel.setBackground(Color.pink);		//�N[���ʺ޲z�l������������]�[�즹������
		mp_panel.setLayout(new FlowLayout());
		add(mp_panel);
			//�N���ʺ޲z�l�\��[�Jmp_panel
		mp_panel.add(addOrbtn);
		mp_panel.add(ediOrbtn);
		mp_panel.add(crePRfbtn);
			//�[�J��ť�ƥ�
		addOrbtn.addActionListener(ProcessPaneChanged);
		ediOrbtn.addActionListener(ProcessPaneChanged);
		crePRfbtn.addActionListener(ProcessPaneChanged);
		
		//�]�mmmk_panel,���t�s�W�q��B�s��q��B���Ͷi�f������s��
		mmk_panel.setBounds(0,65,500,35);
		mmk_panel.setVisible(false);
		mmk_panel.setBackground(Color.pink);	//�N[���Ƥ����޲z�l������������]�[�즹������
		mp_panel.setLayout(new FlowLayout());
		add(mmk_panel);
			//�N�����`���޲z�l�\��[�Jmmk_panel
		mmk_panel.add(addMabtn);
		mmk_panel.add(ediMabtn);
		mmk_panel.add(creMRfbtn);
			//�[�J��ť�ƥ�
		addMabtn.addActionListener(ProcessPaneChanged);
		ediMabtn.addActionListener(ProcessPaneChanged);
		creMRfbtn.addActionListener(ProcessPaneChanged);
		
		//�]�mmco_panel,���t�s�W�t�ӡB�s��t�ӫ��s��
		mco_panel.setBounds(0,65,500,35);
		mco_panel.setVisible(false);
		mco_panel.setBackground(Color.pink);	//�N[���Ƥ����޲z�l������������]�[�즹������
		mco_panel.setLayout(new FlowLayout());
		add(mco_panel);
			//�N�t�Ӻ޲z�l�\��[�Jmmk_panel
		mco_panel.add(addMcbtn);
		mco_panel.add(ediMcbtn);
			//�[�J��ť�ƥ�
		addMcbtn.addActionListener(ProcessPaneChanged);
		ediMcbtn.addActionListener(ProcessPaneChanged);		

		setBackground(new Color(255, 242, 179));
	    setBounds(500,0,500,600);
	    setLayout(null);
	}
    public ActionListener ProcessPaneChanged = new ActionListener(){
        public void actionPerformed(ActionEvent e){
//            if(e.getSource() ==  pmbtn){
//            	mp_panel.setVisible(true);         //���[���ʺ޲z�l�ﶵ]�ާ@�e��	  
//            	myAO_pane.setVisible(true); 	   //�w�]���[���ʺ޲z-�s�W�q��]
//        		mmk_panel.setVisible(false);	   //����[�����`���޲z�l�ﶵ]�ާ@�e��
//        		mco_panel.setVisible(false);	   //����[�t�Ӻ޲z�l�ﶵ]�ާ@�e��
//
//            	myAMA_pane.setVisible(false);      //����[���ƺ޲z�l�e��]     
//            	myEMA_pane.setVisible(false);
//            	myCMR_pane.setVisible(false);
//            	myACO_pane.setVisible(false);      //����[�t�Ӻ޲z�l�e��]	  
//            	myECO_pane.setVisible(false);
//
//            }
//            if(e.getSource() ==  mmakbtn){
//        		mmk_panel.setVisible(true);	   		//���[�����`���޲z�l�ﶵ]�ާ@�e��
//        		myAMA_pane.setVisible(true);        //�w�]���[���ƺ޲z-�s�W�q��]
//            	mp_panel.setVisible(false);         //����[���ʺ޲z�l�ﶵ]�ާ@�e��	
//           		mco_panel.setVisible(false);	    //����[�t�Ӻ޲z�l�ﶵ]�ާ@�e��
//           		
//            	myAO_pane.setVisible(false);        //����[���ʺ޲z�l�e��]
//            	myEO_pane.setVisible(false);
//            	myCPR_pane.setVisible(false);
//            	myACO_pane.setVisible(false);       //����[�t�Ӻ޲z�l�e��]	  
//            	myECO_pane.setVisible(false);
//            }
//            if(e.getSource() ==  mcbtn){
//         		mco_panel.setVisible(true);	   		//���[�t�Ӻ޲z�l�ﶵ]�ާ@�e��
//            	myACO_pane.setVisible(true);        //�w�]���[�t�Ӻ޲z-�s�W�q��]
//         		mmk_panel.setVisible(false);	   	//����[�����`���޲z�l�ﶵ]�ާ@�e��
//            	mp_panel.setVisible(false);         //����[���ʺ޲z�l�ﶵ]�ާ@�e��	
//
//            	myAMA_pane.setVisible(false);       //����[���ƺ޲z�l�e��]          
//            	myEMA_pane.setVisible(false);
//            	myCMR_pane.setVisible(false);     		
//             	myAO_pane.setVisible(false);        //����[���ʺ޲z�l�e��]
//             	myEO_pane.setVisible(false);
//             	myCPR_pane.setVisible(false);
//             }
//            if(e.getSource() ==  addOrbtn){
//            	myAO_pane.setVisible(true);          //���[�s�W�q����]�ާ@�e��	  
//            	myEO_pane.setVisible(false);
//            	myCPR_pane.setVisible(false);
//            }
//            if(e.getSource() ==  ediOrbtn){	
//            	myEO_pane.setVisible(true);          //���[�s��q����]�ާ@�e��	  
//            	myAO_pane.setVisible(false);
//            	myCPR_pane.setVisible(false);
//            }
//            if(e.getSource() ==  crePRfbtn){
//            	myCPR_pane.setVisible(true);         //���[���ͱ��ʳ�����]�ާ@�e��	  
//            	myAO_pane.setVisible(false);
//            	myEO_pane.setVisible(false);
//            }
//
//            if(e.getSource() ==  addMabtn){
//            	myAMA_pane.setVisible(true);         //���[�s�W�����`�����]�ާ@�e��	  
//            	myEMA_pane.setVisible(false);
//            	myCMR_pane.setVisible(false);
//            }
//            if(e.getSource() ==  ediMabtn){
//            	myEMA_pane.setVisible(true);		 //���[�s�誫���`�����]�ާ@�e��
//            	myAMA_pane.setVisible(false); 
//            	myCMR_pane.setVisible(false);
//            	
//            }
//            if(e.getSource() ==  creMRfbtn){
//            	myCMR_pane.setVisible(true);         //���[���ͪ��Ƴ�����]�ާ@�e��	  
//            	myEMA_pane.setVisible(false);
//            	myAMA_pane.setVisible(false);
//            }
//            if(e.getSource() ==  addMcbtn){
//            	myACO_pane.setVisible(true);         //���[�s�W�t�Ӹ��]�ާ@�e��	  
//            	myECO_pane.setVisible(false);
//            }
//            if(e.getSource() ==  ediMcbtn){
//            	myECO_pane.setVisible(true);		 //���[�s��t�Ӹ��]�ާ@�e��
//            	myACO_pane.setVisible(false); 
//            }
        }
    };
}
