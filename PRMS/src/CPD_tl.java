//���D���h���O
//CPD_tl: Class ProblemDomain_tl (����Ӹ`���O)
public class CPD_tl {                    
	private String TL_no;   //�ݩ�:
	private String MEAL_no;		//�ݩ�:
	private int TL_number;	//�ݩ�:
	private int TL_amount;	//�ݩ�:

    //�غc�l:���OCPD_tl
    public CPD_tl(){        
    	TL_no = "";
    	MEAL_no = "";
    	TL_number = 0;
    	TL_amount = 0;
    }
    
    //��k:�]�w
    public void setNo(String tl_no){
    	TL_no = tl_no;
    } 
    
    //��k:�]�w
    public void setMealNo(String meal_no){
    	MEAL_no = meal_no;
    } 
    
    //��k:�]�w
    public void setNumber(int tl_number){
    	TL_number = tl_number;
    } 
    
    //��k:�]�w
    public void setAmount(int tl_amount){
    	TL_amount = tl_amount;
    } 
    
    //��k:���o
    public String getNo(){
    	return(TL_no);
    }
 
    //��k:���o
    public String getMealNo(){
    	return(MEAL_no);
    }
    
    //��k:���o
    public int getNumber(){
    	return(TL_number);
    }
    
    //��k:���o
    public int getAmount(){
    	return(TL_amount);
    }
} //end for: class CPD_tl
