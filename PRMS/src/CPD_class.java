//���D���h���O
//CPD_class: Class ProblemDomain_class (�\�I�������O)
public class CPD_class {                    
	private String CLS_no;   //�ݩ�:���O�s���r��
	private String CLS_date; //�ݩ�:���O�إߤ���r��
	private String CLS_name; //�ݩ�:���O�W�٦r��
	private String CLS_kind; //�ݩ�:���O�����r��
	private String CLS_state;//�ݩ�:���O���A�r��
	private String CLS_note; //�ݩ�:���O�Ƶ��r��

    //�غc�l:���OCPD_class
    public CPD_class(){        
        CLS_no = "";
        CLS_date = "";
        CLS_name = "";
        CLS_kind = "";
        CLS_state= "";
        CLS_note = "";
    }
    
    //��k:�]�w�\�I�����s��
    public void setNo(String cls_no){
    	CLS_no = cls_no;
    } 
    
    //��k:�]�w�إߤ��
    public void setDate(String cls_date){
    	CLS_date = cls_date;
    } 
    
    //��k:�]�w���O����
    public void setKind(String cls_kind){
    	CLS_kind = cls_kind;
    } 
    
    //��k:�]�w�\�I�����W��
    public void setName(String cls_name){
    	CLS_name = cls_name;
    }    
    
    //��k:�]�w�\�I�������A
    public void setState(String cls_state){
    	CLS_state = cls_state;
    }       
    
    //��k:�]�w�\�I�����Ƶ����A
    public void setNote(String cls_note){
    	CLS_note = cls_note;
    }   
    
    //��k:���o�\�I�����s��
    public String getNo(){
    	return(CLS_no);
    }
    //��k:���o�إߤ��
    public String getDate(){
    	return(CLS_date);
    }
 
    //��k:���o���O�����s��
    public String getKind(){
    	return(CLS_kind);
    }
    
    //��k:���o�\�I�����W��
    public String getName(){
    	return(CLS_name);
    }
    
    //��k:���o�\�I�������A
    public String getState(){
    	return(CLS_state);
    }

    //��k:���o�\�I�����Ƶ�
    public String getNote(){
    	return(CLS_note);
    }
    
} //end for: class CPD_class
