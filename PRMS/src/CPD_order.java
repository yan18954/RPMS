//問題領域層類別
//CPD_order: Class ProblemDomain_order (訂單資料類別)
public class CPD_order {                    
	private String ORDER_no;   //屬性:
	private String ORDER_date; //屬性:
	private int ORDER_status; //屬性:
	private String CL_no; //屬性:
	private int ORDER_amount; //屬性:

    //建構子:類別CPD_order
    public CPD_order(){        
        ORDER_no = "";
        ORDER_date = "";
        ORDER_status = 0;
        CL_no = "";
        ORDER_amount = 0;
    }
    
    //方法:設定
    public void setNo(String order_no){
    	ORDER_no = order_no;
    } 
    
    //方法:設定
    public void setDate(String order_date){
    	ORDER_date = order_date;
    }       
       
    //方法:設定
    public void setStatus(int order_status){
    	ORDER_status = order_status;
    }    

    //方法:設定
    public void setClNo(String cl_no){
    	CL_no = cl_no;
    }   
    
    //方法:設定
    public void setAmount(int order_amount){
    	ORDER_amount =  order_amount;
    }    
    
    //方法:取得
    public String getNo(){
    	return(ORDER_no);
    }
    //方法:取得
    public String getDate(){
    	return(ORDER_date);
    }

    //方法:取得
    public int getStatus(){
    	return(ORDER_status);
    }

    //方法:取得
    public String getClNo(){
    	return(CL_no);
    }
    
    //方法:取得
    public int getAmount(){
    	return(ORDER_amount);
    }
    
} //end for: class CPD_order
