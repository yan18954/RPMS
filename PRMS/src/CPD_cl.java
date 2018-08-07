//問題領域層類別
//CPD_cl: Class ProblemDomain_cl (廠商資料類別)
public class CPD_cl {                    
	private String CL_no;   //屬性:
	private String CL_company; //屬性:
	private String CL_contact; //屬性:
	private String CL_contactphone; //屬性:
	private String CL_note; //屬性:

    //建構子:類別CPD_cl
    public CPD_cl(){        
        CL_no = "";
        CL_company = "";
        CL_contact = "";
        CL_contactphone = "";
        CL_note = "";
    }
    
    //方法:設定
    public void setNo(String cl_no){
    	CL_no = cl_no;
    } 
    
    //方法:設定
    public void setCompany(String cl_company){
    	CL_company = cl_company;
    }       
       
    //方法:設定
    public void setContact(String cl_contact){
    	CL_contact = cl_contact;
    }    

    //方法:設定
    public void setContactphone(String cl_contactphone){
    	CL_contactphone = cl_contactphone;
    }   
    
    //方法:設定
    public void setNote(String cl_note){
    	CL_note =  cl_note;
    }    
    
    //方法:取得
    public String getNo(){
    	return(CL_no);
    }
    //方法:取得
    public String getCompany(){
    	return(CL_company);
    }

    //方法:取得
    public String getContact(){
    	return(CL_contact);
    }

    //方法:取得
    public String getContactphone(){
    	return(CL_contactphone);
    }
    
    //方法:取得
    public String getNote(){
    	return(CL_note);
    }
    
} //end for: class CPD_cl
