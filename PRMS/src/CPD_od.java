//���D���h���O
//CPD_od: Class ProblemDomain_od (�q�����p������O)
public class CPD_od {                    
	private String ORDER_no;   //�ݩ�:
	private String OL_no; //�ݩ�:
		
    //�غc�l:���OCPD_order
    public CPD_od(){        
        ORDER_no = "";
        OL_no = "";
    }
    
    //��k:�]�w
    public void setOrderNo(String order_no){
    	ORDER_no = order_no;
    } 
    
    //��k:�]�w
    public void setOlNo(String ol_no){
    	OL_no = ol_no;
    } 

    //��k:���o
    public String getOrderNo(){
    	return(ORDER_no);
    }

    //��k:���o
    public String getOlNo(){
    	return(OL_no);
    }
 
} //end for: class CPD_od
