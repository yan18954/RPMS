//���D���h���O
//CPD_mi: Class ProblemDomain_mi (�������O)
public class CPD_mi {                    
	private String MI_no;   //�ݩ�:���O�s���r��
	private String MI_type; //�ݩ�:���O�إߤ���r��
	private String MI_name; //�ݩ�:���O�W�٦r��
	private String MI_note; //�ݩ�:���O�����r��

    //�غc�l:���OCPD_mi
    public CPD_mi(){        
        MI_no = "";
        MI_type = "";
        MI_name = "";
        MI_note = "";
    }
    
    //��k:�]�w�\�I�����s��
    public void setNo(String mi_no){
    	MI_no = mi_no;
    } 
    
    //��k:�]�w�\�I�������A
    public void setState(String mi_type){
    	MI_type = mi_type;
    }       
       
    //��k:�]�w�\�I�����W��
    public void setName(String mi_name){
    	MI_name = mi_name;
    }    

    //��k:�]�w�\�I�����Ƶ����A
    public void setNote(String mi_note){
    	MI_note = mi_note;
    }   
    
    //��k:���o�\�I�����s��
    public String getNo(){
    	return(MI_no);
    }
    //��k:���o�إߤ��
    public String getType(){
    	return(MI_type);
    }

    //��k:���o�\�I�����W��
    public String getName(){
    	return(MI_name);
    }

    //��k:���o�\�I�����Ƶ�
    public String getNote(){
    	return(MI_note);
    }
    
} //end for: class CPD_mi
