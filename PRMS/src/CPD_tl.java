//問題領域層類別
//CPD_tl: Class ProblemDomain_tl (交易細節類別)
public class CPD_tl {                    
	private String TL_no;   //屬性:
	private String MEAL_no;		//屬性:
	private int TL_number;	//屬性:
	private int TL_amount;	//屬性:

    //建構子:類別CPD_tl
    public CPD_tl(){        
    	TL_no = "";
    	MEAL_no = "";
    	TL_number = 0;
    	TL_amount = 0;
    }
    
    //方法:設定
    public void setNo(String tl_no){
    	TL_no = tl_no;
    } 
    
    //方法:設定
    public void setMealNo(String meal_no){
    	MEAL_no = meal_no;
    } 
    
    //方法:設定
    public void setNumber(int tl_number){
    	TL_number = tl_number;
    } 
    
    //方法:設定
    public void setAmount(int tl_amount){
    	TL_amount = tl_amount;
    } 
    
    //方法:取得
    public String getNo(){
    	return(TL_no);
    }
 
    //方法:取得
    public String getMealNo(){
    	return(MEAL_no);
    }
    
    //方法:取得
    public int getNumber(){
    	return(TL_number);
    }
    
    //方法:取得
    public int getAmount(){
    	return(TL_amount);
    }
} //end for: class CPD_tl
