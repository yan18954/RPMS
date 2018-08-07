//問題領域層類別
//CPD_trans: Class ProblemDomain_trans (交易訂單類別)
public class CPD_trans {                    
	private String TRANS_no;   //屬性:
	private String TRANS_date;	//屬性:
	private int TRANS_shiff;	//屬性:
	private String EMPL_id;	//屬性:
	private int TRANS_ein;	//屬性:
	private int TRANS_status;	//屬性:
	private int TRANS_amount;	//屬性:
	
    //建構子:類別CPD_trans
    public CPD_trans(){        
    	TRANS_no = "";
    	TRANS_date = "";
    	TRANS_shiff = 0;
    	EMPL_id = "";
    	TRANS_ein = 0;
    	TRANS_status = 0;
    	TRANS_amount = 0;
    }
    
    //方法:設定
    public void setNo(String trans_no){
    	TRANS_no = trans_no;
    } 
    
    //方法:設定
    public void setDate(String trans_date){
    	TRANS_date = trans_date;
    } 
    
    //方法:設定
    public void setShiff(int trans_shiff){
    	TRANS_shiff = trans_shiff;
    } 
    
    //方法:設定
    public void setEmplId(String empl_id){
    	EMPL_id = empl_id;
    } 
   
    //方法:設定
    public void setEin(int trans_ein){
    	TRANS_ein = trans_ein;
    } 
    
    //方法:設定
    public void setStatus(int trans_status){
    	TRANS_status = trans_status;
    } 
    
    //方法:設定
    public void setAmount(int trans_amount){
    	TRANS_amount = trans_amount;
    } 
    
    //方法:取得
    public String getNo(){
    	return(TRANS_no);
    }
 
    //方法:取得
    public String getDate(){
    	return(TRANS_date);
    }
    
    //方法:取得
    public int getShiff(){
    	return(TRANS_shiff);
    }
    
    //方法:取得
    public String getEmplId(){
    	return(EMPL_id);
    }
    
    //方法:取得
    public int getEin(){
    	return(TRANS_ein);
    }
    
    //方法:取得
    public int getStatus(){
    	return(TRANS_status);
    }
    
    //方法:取得
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
