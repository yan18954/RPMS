//問題領域層類別
//CPD_ol: Class ProblemDomain_ol (訂單細節資料類別)
public class CPD_ol {                    
	private String OL_no;   //屬性:
	private String MI_no; //屬性:
	private int OL_prices; //屬性:
	private int OL_number; //屬性:
	private String OL_date; //屬性:
	private int OL_amount; //屬性:
	
    //建構子:類別CPD_order
    public CPD_ol(){        
        OL_no = "";
        MI_no = "";
        OL_prices = 0;
        OL_number = 0;
        OL_date = "";
        OL_amount = 0;
    }
    
    //方法:設定
    public void setNo(String ol_no){
    	OL_no = ol_no;
    } 
    
    //方法:設定
    public void setMiNo(String mi_no){
    	MI_no = mi_no;
    } 
    
    //方法:設定
    public void setPrices(int ol_prices){
    	OL_prices = ol_prices;
    } 
    
    //方法:設定
    public void setNumber(int ol_number){
    	OL_number = ol_number;
    } 
    
    //方法:設定
    public void setDate(String ol_date){
    	OL_date = ol_date;
    }       
       
    //方法:設定
    public void setAmount(int ol_amount){
    	OL_amount = ol_amount;
    }    
    
    //方法:取得
    public String getNo(){
    	return(OL_no);
    }

    //方法:取得
    public String getMiNo(){
    	return(MI_no);
    }
    
    //方法:取得
    public int getPrices(){
    	return(OL_prices);
    }
    
    //方法:取得
    public int getNumber(){
    	return(OL_number);
    }

    //方法:取得
    public String getDate(){
    	return(OL_date);
    }

    //方法:取得
    public int getAmount(){
    	return(OL_amount);
    }
  
} //end for: class CPD_ol
