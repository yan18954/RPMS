//���D���h���O
//CPD_order: Class ProblemDomain_order (�q�������O)
public class CPD_order {                    
	private String ORDER_no;   //�ݩ�:
	private String ORDER_date; //�ݩ�:
	private int ORDER_status; //�ݩ�:
	private String CL_no; //�ݩ�:
	private int ORDER_amount; //�ݩ�:

    //�غc�l:���OCPD_order
    public CPD_order(){        
        ORDER_no = "";
        ORDER_date = "";
        ORDER_status = 0;
        CL_no = "";
        ORDER_amount = 0;
    }
    
    //��k:�]�w
    public void setNo(String order_no){
    	ORDER_no = order_no;
    } 
    
    //��k:�]�w
    public void setDate(String order_date){
    	ORDER_date = order_date;
    }       
       
    //��k:�]�w
    public void setStatus(int order_status){
    	ORDER_status = order_status;
    }    

    //��k:�]�w
    public void setClNo(String cl_no){
    	CL_no = cl_no;
    }   
    
    //��k:�]�w
    public void setAmount(int order_amount){
    	ORDER_amount =  order_amount;
    }    
    
    //��k:���o
    public String getNo(){
    	return(ORDER_no);
    }
    //��k:���o
    public String getDate(){
    	return(ORDER_date);
    }

    //��k:���o
    public int getStatus(){
    	return(ORDER_status);
    }

    //��k:���o
    public String getClNo(){
    	return(CL_no);
    }
    
    //��k:���o
    public int getAmount(){
    	return(ORDER_amount);
    }
    
} //end for: class CPD_order
