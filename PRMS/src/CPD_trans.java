//���D���h���O
//CPD_trans: Class ProblemDomain_trans (����q�����O)
public class CPD_trans {                    
	private String TRANS_no;   //�ݩ�:
	private String TRANS_date;	//�ݩ�:
	private int TRANS_shiff;	//�ݩ�:
	private String EMPL_id;	//�ݩ�:
	private int TRANS_ein;	//�ݩ�:
	private int TRANS_status;	//�ݩ�:
	private int TRANS_amount;	//�ݩ�:
	
    //�غc�l:���OCPD_trans
    public CPD_trans(){        
    	TRANS_no = "";
    	TRANS_date = "";
    	TRANS_shiff = 0;
    	EMPL_id = "";
    	TRANS_ein = 0;
    	TRANS_status = 0;
    	TRANS_amount = 0;
    }
    
    //��k:�]�w
    public void setNo(String trans_no){
    	TRANS_no = trans_no;
    } 
    
    //��k:�]�w
    public void setDate(String trans_date){
    	TRANS_date = trans_date;
    } 
    
    //��k:�]�w
    public void setShiff(int trans_shiff){
    	TRANS_shiff = trans_shiff;
    } 
    
    //��k:�]�w
    public void setEmplId(String empl_id){
    	EMPL_id = empl_id;
    } 
   
    //��k:�]�w
    public void setEin(int trans_ein){
    	TRANS_ein = trans_ein;
    } 
    
    //��k:�]�w
    public void setStatus(int trans_status){
    	TRANS_status = trans_status;
    } 
    
    //��k:�]�w
    public void setAmount(int trans_amount){
    	TRANS_amount = trans_amount;
    } 
    
    //��k:���o
    public String getNo(){
    	return(TRANS_no);
    }
 
    //��k:���o
    public String getDate(){
    	return(TRANS_date);
    }
    
    //��k:���o
    public int getShiff(){
    	return(TRANS_shiff);
    }
    
    //��k:���o
    public String getEmplId(){
    	return(EMPL_id);
    }
    
    //��k:���o
    public int getEin(){
    	return(TRANS_ein);
    }
    
    //��k:���o
    public int getStatus(){
    	return(TRANS_status);
    }
    
    //��k:���o
    public int getAmount(){
    	return(TRANS_amount);
    }
    
    public void ClearALll(){
    	TRANS_no = "";
    	TRANS_date = "";
    	TRANS_shiff = 0;
    	EMPL_id = "";
    	TRANS_ein = 0;
    	TRANS_status = 0;
    	TRANS_amount = 0;
    }
 
} //end for: class CPD_trans
