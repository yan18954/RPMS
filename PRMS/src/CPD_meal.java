//���D���h���O
//CPD_meal: Class ProblemDomain_meal (�\�I���O)
public class CPD_meal {
	private String MEAL_no;	  //�ݩ�:�\�I�s���r��
	private String MEAL_date; //�ݩ�:�\�I����r��
	private String MEAL_name; //�ݩ�:�\�I�W�٦r��
	private String MEAL_kind; //�ݩ�:�\�I�����r��
	private String CLS_no;    //�ݩ�:�\�I���O�s���r��,�~����
	private String MI_no;	  //�ݩ�:���ƺ����s���r��,�~����
	private String MEAL_state;//�ݩ�:�\�I���A�r��
	private int MEAL_price;	  //�ݩ�:�\�I������
	private String MEAL_note; //�ݩ�:�\�I�Ƶ��r��
	
	//�غc�l:���OCPD_meal
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
	
    //��k:�]�w�\�I�s��
    public void setNo(String meal_no){
    	MEAL_no = meal_no;
    } 
    
    //��k:�]�w�\�I���
    public void setDate(String meal_date){
    	MEAL_date = meal_date;
    }
    
    //��k:�]�w�\�I�W��
    public void setName(String meal_name){
    	MEAL_name = meal_name;
    }
    
    //��k:�]�w�\�I����
    public void setKind(String meal_kind){
    	MEAL_kind = meal_kind;
    }
    /*
    //��k:�]�w�\�I���O
    public void setClass(String meal_class){
    	MEAL_kind = meal_class;
    }*/
    
    //��k:�]�w�\�I���O�s��
    public void setCLSNo(String cls_no){
    	CLS_no = cls_no;
    }
    
    //��k:�]�w���ƺ����s��
    public void setMINo(String mi_no){
    	MI_no = mi_no;
    }
    
    //��k:�]�w�\�I���A
    public void setState(String meal_state){
    	MEAL_state = meal_state;
    }
    
    //��k:�]�w�\�I����
    public void setPrice(int meal_price){
    	MEAL_price = meal_price;
    }
    
    //��k:�]�w�\�I�Ƶ�
    public void setNote(String meal_note){
    	MEAL_note = meal_note;
    }
    
    //��k:���o�\�I�s��
    public String getNo(){
    	return(MEAL_no);
    }
    
    //��k:���o�\�I���
    public String getDate(){
    	return(MEAL_date);
    }
    
    //��k:���o�\�I�W��
    public String getName(){
    	return(MEAL_name);
    }
    
    //��k:���o�\�I����
    public String getKind(){
    	return(MEAL_kind);
    }     
    
    //��k:���o�\�I���O�s��
    public String getCNo(){
    	return(CLS_no);
    }
    
    //��k:���o���ƺ����s��
    public String getMNo(){
    	return(MI_no);
    }
    
    //��k:���o�\�I���A
    public String getState(){
    	return(MEAL_state);
    }
    
    //��k:���o�\�I����
    public int getPrice(){
    	return(MEAL_price);
    }
    
    //��k:���o�\�I�Ƶ�
    public String getNote(){
    	return(MEAL_note);
    }
}
