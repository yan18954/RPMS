import javax.swing.ImageIcon;
import javax.swing.JFrame;

//�H�����ʼh���O
//CHCI_frame: Class HumanComputerInteraction_frame (�H������-�e�x�ج[���O)
class CHCI_frame extends JFrame{	//�t�ε���
	/*-�n�J-*/
	CHCI_SignIn mySignIn_pane = new CHCI_SignIn();		  //�n�J�e��(��JPanel,���t����,��r���,���s��)
	/*--�D���--*/
    CHCI_menu  myMenu = new CHCI_menu();                  //�D�\���檫��(��JPanel,���t6�ӫ��s)     
    /*--�e�x--*/
    CHCI_OR_panel  myOR_pane = new CHCI_OR_panel();       //�s�W�\�I��������(��JPanel,���t����,��r���,���s��)
    CHCI_COM_panel myCOM_pane = new CHCI_COM_panel();     //���b�\�I��������(��JPanel,���t����,��r���,���s��)
    CHCI_SO_panel  mySO_pane = new CHCI_SO_panel();       //����\�I��������(��JPanel,���t����,��r���,���s��)
    CHCI_RE_panel  myRE_pane = new CHCI_RE_panel();		  //�q��w����������(��JPanel,���t����,��r���,���s��)
    /*--��x--*/
    CHCI_MM_panel myMM_pane=new CHCI_MM_panel(); 		  //�޲z�\�I��������(��JPanel,���tJPanel)  
    CHCI_MS_panel myMS_pane=new CHCI_MS_panel();		  //�޲z���u��������(��JPanel,���tJPanel) 
    CHCI_MMA_panel myMMA_pane=new CHCI_MMA_panel();		  //�޲z���Ƥ�������(��JPanel,���tJPanel)
    CHCI_MD_panel myMD_pane=new CHCI_MD_panel();		  //�޲z�����������(��JPanel,���tJPanel) 

    //
    ImageIcon img = new ImageIcon(getClass().getResource("peticon.png"));
	
 
    //�غc�l:���OCHCI_frame 
    public CHCI_frame(){
    	setIconImage(img.getImage());
    	add(mySignIn_pane); //�N[�n�J�e��]�[�즹������
        add(myMenu);        //�N[�D�\���檫��]�[�즹������
        add(myOR_pane);     //�N[�s�W�\�I��������]�[�즹������
        add(mySO_pane);     //�N[����\�I��������]�[�즹������      
        add(myCOM_pane);	//�N[���b�q�椶������]�[�즹������      
        add(myRE_pane);	    //�N[�q��w����������]�[�즹������             
        add(myMM_pane);     //�N[�޲z�\�I��������]�[�즹������      
        add(myMS_pane);     //�N[�޲z���u��������]�[�즹������   
        add(myMMA_pane);	//�N[�޲z���Ƥ�������]�[�즹������
        add(myMD_pane);	    //�N[�޲z�����������]�[�즹������   

        myMenu.setVisible(false);	    //�w�][�D�\���檫��]�e������           
        myOR_pane.setVisible(false);	//�w�][�s�W�\�I��������]�e������   
        mySO_pane.setVisible(false);	//�w�][����\�I��������]�e������          
        myCOM_pane.setVisible(false);	//�w�][���b�q�椶������]�e������   
        myRE_pane.setVisible(false);	//�w�][�q��w����������]�e������   
        myMM_pane.setVisible(false);	//�w�][�޲z�\�I��������]�e������    
        myMS_pane.setVisible(false);    //�w�][�޲z���u��������]�e������    
        myMMA_pane.setVisible(false);	//�w�][�޲z���Ƥ�������]�e������    
        myMD_pane.setVisible(false);	//�w�][�޲z�����������]�e������    
        

        //�t�ε������򥻳]�w
        setTitle("�d���\�U�޲z�t��-PRMS(PetRestaurantManagementSystem)");
        setBounds(0,0,1000,700);   
        setLocationRelativeTo(null);//�e���m��        
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }    
}
//end for: class CHCI_frame
