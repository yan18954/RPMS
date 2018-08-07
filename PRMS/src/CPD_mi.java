//問題領域層類別
//CPD_mi: Class ProblemDomain_mi (物料類別)
public class CPD_mi {                    
	private String MI_no;   //屬性:類別編號字串
	private String MI_type; //屬性:類別建立日期字串
	private String MI_name; //屬性:類別名稱字串
	private String MI_note; //屬性:類別分類字串

    //建構子:類別CPD_mi
    public CPD_mi(){        
        MI_no = "";
        MI_type = "";
        MI_name = "";
        MI_note = "";
    }
    
    //方法:設定餐點分類編號
    public void setNo(String mi_no){
    	MI_no = mi_no;
    } 
    
    //方法:設定餐點分類狀態
    public void setState(String mi_type){
    	MI_type = mi_type;
    }       
       
    //方法:設定餐點分類名稱
    public void setName(String mi_name){
    	MI_name = mi_name;
    }    

    //方法:設定餐點分類備註狀態
    public void setNote(String mi_note){
    	MI_note = mi_note;
    }   
    
    //方法:取得餐點分類編號
    public String getNo(){
    	return(MI_no);
    }
    //方法:取得建立日期
    public String getType(){
    	return(MI_type);
    }

    //方法:取得餐點分類名稱
    public String getName(){
    	return(MI_name);
    }

    //方法:取得餐點分類備註
    public String getNote(){
    	return(MI_note);
    }
    
} //end for: class CPD_mi
