//���D���h���O
//CPD_cl: Class ProblemDomain_cl (�t�Ӹ�����O)
public class CPD_cl {                    
	private String CL_no;   //�ݩ�:
	private String CL_company; //�ݩ�:
	private String CL_contact; //�ݩ�:
	private String CL_contactphone; //�ݩ�:
	private String CL_note; //�ݩ�:

    //�غc�l:���OCPD_cl
    public CPD_cl(){        
        CL_no = "";
        CL_company = "";
        CL_contact = "";
        CL_contactphone = "";
        CL_note = "";
    }
    
    //��k:�]�w
    public void setNo(String cl_no){
    	CL_no = cl_no;
    } 
    
    //��k:�]�w
    public void setCompany(String cl_company){
    	CL_company = cl_company;
    }       
       
    //��k:�]�w
    public void setContact(String cl_contact){
    	CL_contact = cl_contact;
    }    

    //��k:�]�w
    public void setContactphone(String cl_contactphone){
    	CL_contactphone = cl_contactphone;
    }   
    
    //��k:�]�w
    public void setNote(String cl_note){
    	CL_note =  cl_note;
    }    
    
    //��k:���o
    public String getNo(){
    	return(CL_no);
    }
    //��k:���o
    public String getCompany(){
    	return(CL_company);
    }

    //��k:���o
    public String getContact(){
    	return(CL_contact);
    }

    //��k:���o
    public String getContactphone(){
    	return(CL_contactphone);
    }
    
    //��k:���o
    public String getNote(){
    	return(CL_note);
    }
    
} //end for: class CPD_cl
