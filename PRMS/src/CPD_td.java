//問題領域層類別
//CPD_td: Class ProblemDomain_td (交易訂單關聯類別)
public class CPD_td {                    
	private String TRANS_no;   //屬性:
	private String TL_no;		//屬性:

    //建構子:類別CPD_td
    public CPD_td(){        
    	TRANS_no = "";
    	TL_no = "";
    }
    
    //方法:設定
    public void setTransNo(String trans_no){
    	TRANS_no = trans_no;
    } 
    
    //方法:設定
    public void setTlNo(String tl_no){
    	TL_no = tl_no;
    } 
    
    //方法:取得
    public String getTransNo(){
    	return(TRANS_no);
    }
 
    //方法:取得
    public String getTlNo(){
    	return(TL_no);
    }
    
} //end for: class CPD_td
