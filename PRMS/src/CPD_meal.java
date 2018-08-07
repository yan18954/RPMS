//問題領域層類別
//CPD_meal: Class ProblemDomain_meal (餐點類別)
public class CPD_meal {
	private String MEAL_no;	  //屬性:餐點編號字串
	private String MEAL_date; //屬性:餐點日期字串
	private String MEAL_name; //屬性:餐點名稱字串
	private String MEAL_kind; //屬性:餐點分類字串
	private String CLS_no;    //屬性:餐點類別編號字串,外來鍵
	private String MI_no;	  //屬性:物料種類編號字串,外來鍵
	private String MEAL_state;//屬性:餐點狀態字串
	private int MEAL_price;	  //屬性:餐點價格整數
	private String MEAL_note; //屬性:餐點備註字串
	
	//建構子:類別CPD_meal
	public CPD_meal(){
		MEAL_no = "";
		MEAL_date = "";
		MEAL_name = "";
		MEAL_kind = "";
		CLS_no = "";
		MI_no = "";
		MEAL_state = "";
		MEAL_price = 0;
		MEAL_note ="";
	}
	
    //方法:設定餐點編號
    public void setNo(String meal_no){
    	MEAL_no = meal_no;
    } 
    
    //方法:設定餐點日期
    public void setDate(String meal_date){
    	MEAL_date = meal_date;
    }
    
    //方法:設定餐點名稱
    public void setName(String meal_name){
    	MEAL_name = meal_name;
    }
    
    //方法:設定餐點分類
    public void setKind(String meal_kind){
    	MEAL_kind = meal_kind;
    }
    /*
    //方法:設定餐點類別
    public void setClass(String meal_class){
    	MEAL_kind = meal_class;
    }*/
    
    //方法:設定餐點類別編號
    public void setCLSNo(String cls_no){
    	CLS_no = cls_no;
    }
    
    //方法:設定物料種類編號
    public void setMINo(String mi_no){
    	MI_no = mi_no;
    }
    
    //方法:設定餐點狀態
    public void setState(String meal_state){
    	MEAL_state = meal_state;
    }
    
    //方法:設定餐點價格
    public void setPrice(int meal_price){
    	MEAL_price = meal_price;
    }
    
    //方法:設定餐點備註
    public void setNote(String meal_note){
    	MEAL_note = meal_note;
    }
    
    //方法:取得餐點編號
    public String getNo(){
    	return(MEAL_no);
    }
    
    //方法:取得餐點日期
    public String getDate(){
    	return(MEAL_date);
    }
    
    //方法:取得餐點名稱
    public String getName(){
    	return(MEAL_name);
    }
    
    //方法:取得餐點分類
    public String getKind(){
    	return(MEAL_kind);
    }     
    
    //方法:取得餐點類別編號
    public String getCNo(){
    	return(CLS_no);
    }
    
    //方法:取得物料種類編號
    public String getMNo(){
    	return(MI_no);
    }
    
    //方法:取得餐點狀態
    public String getState(){
    	return(MEAL_state);
    }
    
    //方法:取得餐點價格
    public int getPrice(){
    	return(MEAL_price);
    }
    
    //方法:取得餐點備註
    public String getNote(){
    	return(MEAL_note);
    }
}
