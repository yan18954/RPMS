import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class ToolCheck {

	
		 public boolean PID(String id){
		  int[] num=new int[10];
		  int[] rdd={10,11,12,13,14,15,16,17,34,18,19,20,21,22,35,23,24,25,26,27,28,29,32,30,31,33};
		        id=id.toUpperCase();
		        System.out.println(id);     
		  if(id.length() != 10){
			  JOptionPane.showMessageDialog(null,"�����ҿ�J���׿��~�ά���!");
			  return false;
		  }
		  else{
		        
		  if(id.charAt(0)<'A'||id.charAt(0)>'Z'){
			  JOptionPane.showMessageDialog(null,"�����Ү榡���~�A�нT�{!");return false;
		        }
		        if(id.charAt(1)!='1' && id.charAt(1)!='2'){
		        	 JOptionPane.showMessageDialog(null,"�����Ү榡���~�A�нT�{!");return false;
		        }
		        for(int i=1;i<10;i++){
		         if(id.charAt(i)<'0'||id.charAt(i)>'9'){
		        	 JOptionPane.showMessageDialog(null,"�����Ү榡���~�A�нT�{!");return false;
		         }
		        }
		  for(int i=1;i<10;i++){
		   num[i]=(id.charAt(i)-'0');
		  }
		  num[0]=rdd[id.charAt(0)-'A'];
		  int sum=((int)num[0]/10+(num[0]%10)*9);
		  for(int i=0;i<8;i++){
		   sum+=num[i+1]*(8-i);
		  }
		  if(10-sum%10==num[9]){
		   System.out.println("�����Ҹ����T");
		   return true;}
		  else{
			  JOptionPane.showMessageDialog(null,"�����Ү榡���~�A�нT�{!");
		   return false;}
		 }
		  
		  
		 }
		 
		//�ǤJ�r��A�Y���ŭȩΪ̦��ťզr���h�^��false �Ϥ��htrue
		 public boolean CK_Not_null(String str){         
			 char sym =' ';
			 int  a = str.indexOf(sym);
			 if(str.isEmpty()){
				 JOptionPane.showMessageDialog(null,"�п���ͤ�M��¾��");
				 return false;
			 }
			 
			 if (a>=0){
				 System.out.println("���౵���ťզr��!");
				 return false;
			 }
			 System.out.println("OK");
			 return true;
		 } //CK  End
		 
		 
		//�ˬd�m�W�O�_�ŦX�W�w�A���঳�S��r���B�ťզr���B�Ʀr�A�ŦX�W�w�^��true�Ϥ�false
		 public boolean isName(String input){
			 String regex = "^[\\p{L} .'-]+$";
			 char sym =' ';
			 int  a = input.indexOf(sym);
			 boolean isName = Pattern.matches(regex,input);
			 if(input.isEmpty()){
				 JOptionPane.showMessageDialog(null,"�п�J�m�W!");
				 return false;
			 }
			 
			 if (a>=0){
				// System.out.println("�m�W���౵�����ťզr��!");
				 JOptionPane.showMessageDialog(null,"�m�W���౵���ťզr��!");
				 return false;
			 }
			 if(isName){
				 System.out.println("OK");
				 return true;	
			 }
			 else{
				 //System.out.println("�m�W���঳�S��r���Ϊť�");
				 JOptionPane.showMessageDialog(null,"�m�W���঳�Ʀr�ίS��r��");
				 return false;	
			 }		 	 			 
		 }   //isName End
		 
		 
		 
		 
		 public boolean isNumeric(String str){           //�ǤJ�r�� �A �ˬd�O�_�����Ʀr
		 
			 Pattern pattern = Pattern.compile("[0-9]*");
			 Matcher isNum = pattern.matcher(str);
			 if(str.isEmpty()){
				// System.out.println("�O�ŭ�");
				 JOptionPane.showMessageDialog(null,"�нT�{��J�A�q�ܤ��঳�ťզr���Ϊ̼Ʀr�H�~���r��");
				 return false;
			 }
			 
			 else{
				 if( !isNum.matches() )
				 {
					 JOptionPane.showMessageDialog(null,"�нT�{��J�A�q�ܤ��঳�ťզr���Ϊ̼Ʀr�H�~���r��");
					// System.out.println("�нT�{��J�A���঳�ťզr���Ϊ̼Ʀr�H�~���r��");
				 return false;
				 }
				 System.out.println("true");
				 return true;
				 }
		 }			 


		 public boolean CK_address_Not_null(String str){         
			 char sym =' ';
			 int  a = str.indexOf(sym);
			 if(str.isEmpty()){
				 JOptionPane.showMessageDialog(null,"�a�}��쥼��g!");
				 return false;
			 }
			 
			 if (a>=0){
				 JOptionPane.showMessageDialog(null,"���౵���ťզr��");
				 return false;
			 }
			 System.out.println("OK");
			 return true;
		 } //CK  End

		 public boolean CK_Date_Not_null(String str){         
			 char sym =' ';
			 int  a = str.indexOf(sym);
			 if(str.isEmpty()){
				 JOptionPane.showMessageDialog(null,"�п�����");
				 return false;
			 }
			 
			 if (a>=0){
				 System.out.println("���౵���ťզr��!");
				 return false;
			 }
			 System.out.println("OK");
			 return true;
		 } //CK  End

}
	
