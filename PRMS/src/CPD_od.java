//問題領域層類別
//CPD_od: Class ProblemDomain_od (訂單關聯資料類別)
public class CPD_od {                    
	private String ORDER_no;   //屬性:
	private String OL_no; //屬性:
		
    //建構子:類別CPD_order
    public CPD_od(){        
        ORDER_no = "";
        OL_no = "";
    }
    
    //方法:設定
    public void setOrderNo(String order_no){
    	ORDER_no = order_no;
    } 
    
    //方法:設定
    public void setOlNo(String ol_no){
    	OL_no = ol_no;
    } 

    //方法:取得
    public String getOrderNo(){
    	return(ORDER_no);
    }

    //方法:取得
    public String getOlNo(){
    	return(OL_no);
    }
 
} //end for: class CPD_od
