//���D���h���O
//CPD_td: Class ProblemDomain_td (����q�����p���O)
public class CPD_td {                    
	private String TRANS_no;   //�ݩ�:
	private String TL_no;		//�ݩ�:

    //�غc�l:���OCPD_td
    public CPD_td(){        
    	TRANS_no = "";
    	TL_no = "";
    }
    
    //��k:�]�w
    public void setTransNo(String trans_no){
    	TRANS_no = trans_no;
    } 
    
    //��k:�]�w
    public void setTlNo(String tl_no){
    	TL_no = tl_no;
    } 
    
    //��k:���o
    public String getTransNo(){
    	return(TRANS_no);
    }
 
    //��k:���o
    public String getTlNo(){
    	return(TL_no);
    }
    
} //end for: class CPD_td
