//���D���h���O
//CPD_ol: Class ProblemDomain_ol (�q��Ӹ`������O)
public class CPD_ol {                    
	private String OL_no;   //�ݩ�:
	private String MI_no; //�ݩ�:
	private int OL_prices; //�ݩ�:
	private int OL_number; //�ݩ�:
	private String OL_date; //�ݩ�:
	private int OL_amount; //�ݩ�:
	
    //�غc�l:���OCPD_order
    public CPD_ol(){        
        OL_no = "";
        MI_no = "";
        OL_prices = 0;
        OL_number = 0;
        OL_date = "";
        OL_amount = 0;
    }
    
    //��k:�]�w
    public void setNo(String ol_no){
    	OL_no = ol_no;
    } 
    
    //��k:�]�w
    public void setMiNo(String mi_no){
    	MI_no = mi_no;
    } 
    
    //��k:�]�w
    public void setPrices(int ol_prices){
    	OL_prices = ol_prices;
    } 
    
    //��k:�]�w
    public void setNumber(int ol_number){
    	OL_number = ol_number;
    } 
    
    //��k:�]�w
    public void setDate(String ol_date){
    	OL_date = ol_date;
    }       
       
    //��k:�]�w
    public void setAmount(int ol_amount){
    	OL_amount = ol_amount;
    }    
    
    //��k:���o
    public String getNo(){
    	return(OL_no);
    }

    //��k:���o
    public String getMiNo(){
    	return(MI_no);
    }
    
    //��k:���o
    public int getPrices(){
    	return(OL_prices);
    }
    
    //��k:���o
    public int getNumber(){
    	return(OL_number);
    }

    //��k:���o
    public String getDate(){
    	return(OL_date);
    }

    //��k:���o
    public int getAmount(){
    	return(OL_amount);
    }
  
} //end for: class CPD_ol
