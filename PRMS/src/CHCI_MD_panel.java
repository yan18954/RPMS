import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

//�H�����ʼh���O
//CHCI_MS_panel: Class HumanComputerInteraction_ManageDeal_panel (�H������-[�޲z���]�ާ@�e�����O)
public class CHCI_MD_panel extends JPanel{
	ArrayList<String> tdList = new ArrayList<String>();
	static CDM_BS_dbma dbma = new CDM_BS_dbma();
	static CHCI_MDO_panel myMDO_pane=new CHCI_MDO_panel();  //�޲z����ާ@��������(��JPanel,���t����,��r���,���s��)
	static CHCI_MDQ_panel myMDQ_pane=new CHCI_MDQ_panel();	 //�޲z����d�ߤ�������(��JPanel,���t����,��r���,���s��)
	CHCI_MD_panel(){
		add(myMDO_pane);
		add(myMDQ_pane);
        setBackground(Color.yellow);
        setBounds(0,100,1000,600);
        setLayout(null);
	}
	
	public static void setTransData(String no){		//SDR�ϥ�
		myMDO_pane.myED_pane.Query_addDate(dbma.findRD_in_TB_td(no),no);
	}
}
