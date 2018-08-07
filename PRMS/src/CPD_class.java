//問題領域層類別
//CPD_class: Class ProblemDomain_class (餐點分類類別)
public class CPD_class {                    
	private String CLS_no;   //屬性:類別編號字串
	private String CLS_date; //屬性:類別建立日期字串
	private String CLS_name; //屬性:類別名稱字串
	private String CLS_kind; //屬性:類別分類字串
	private String CLS_state;//屬性:類別狀態字串
	private String CLS_note; //屬性:類別備註字串

    //建構子:類別CPD_class
    public CPD_class(){        
        CLS_no = "";
        CLS_date = "";
        CLS_name = "";
        CLS_kind = "";
        CLS_state= "";
        CLS_note = "";
    }
    
    //方法:設定餐點分類編號
    public void setNo(String cls_no){
    	CLS_no = cls_no;
    } 
    
    //方法:設定建立日期
    public void setDate(String cls_date){
    	CLS_date = cls_date;
    } 
    
    //方法:設定類別分類
    public void setKind(String cls_kind){
    	CLS_kind = cls_kind;
    } 
    
    //方法:設定餐點分類名稱
    public void setName(String cls_name){
    	CLS_name = cls_name;
    }    
    
    //方法:設定餐點分類狀態
    public void setState(String cls_state){
    	CLS_state = cls_state;
    }       
    
    //方法:設定餐點分類備註狀態
    public void setNote(String cls_note){
    	CLS_note = cls_note;
    }   
    
    //方法:取得餐點分類編號
    public String getNo(){
    	return(CLS_no);
    }
    //方法:取得建立日期
    public String getDate(){
    	return(CLS_date);
    }
 
    //方法:取得類別分類編號
    public String getKind(){
    	return(CLS_kind);
    }
    
    //方法:取得餐點分類名稱
    public String getName(){
    	return(CLS_name);
    }
    
    //方法:取得餐點分類狀態
    public String getState(){
    	return(CLS_state);
    }

    //方法:取得餐點分類備註
    public String getNote(){
    	return(CLS_note);
    }
    
} //end for: class CPD_class
