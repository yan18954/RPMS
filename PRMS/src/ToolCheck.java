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
			  JOptionPane.showMessageDialog(null,"身分證輸入長度錯誤或為空!");
			  return false;
		  }
		  else{
		        
		  if(id.charAt(0)<'A'||id.charAt(0)>'Z'){
			  JOptionPane.showMessageDialog(null,"身分證格式錯誤，請確認!");return false;
		        }
		        if(id.charAt(1)!='1' && id.charAt(1)!='2'){
		        	 JOptionPane.showMessageDialog(null,"身分證格式錯誤，請確認!");return false;
		        }
		        for(int i=1;i<10;i++){
		         if(id.charAt(i)<'0'||id.charAt(i)>'9'){
		        	 JOptionPane.showMessageDialog(null,"身分證格式錯誤，請確認!");return false;
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
		   System.out.println("身分證號正確");
		   return true;}
		  else{
			  JOptionPane.showMessageDialog(null,"身分證格式錯誤，請確認!");
		   return false;}
		 }
		  
		  
		 }
		 
		//傳入字串，若為空值或者有空白字元則回傳false 反之則true
		 public boolean CK_Not_null(String str){         
			 char sym =' ';
			 int  a = str.indexOf(sym);
			 if(str.isEmpty()){
				 JOptionPane.showMessageDialog(null,"請選取生日和到職日");
				 return false;
			 }
			 
			 if (a>=0){
				 System.out.println("不能接受空白字元!");
				 return false;
			 }
			 System.out.println("OK");
			 return true;
		 } //CK  End
		 
		 
		//檢查姓名是否符合規定，不能有特殊字元、空白字元、數字，符合規定回傳true反之false
		 public boolean isName(String input){
			 String regex = "^[\\p{L} .'-]+$";
			 char sym =' ';
			 int  a = input.indexOf(sym);
			 boolean isName = Pattern.matches(regex,input);
			 if(input.isEmpty()){
				 JOptionPane.showMessageDialog(null,"請輸入姓名!");
				 return false;
			 }
			 
			 if (a>=0){
				// System.out.println("姓名不能接受有空白字元!");
				 JOptionPane.showMessageDialog(null,"姓名不能接受空白字元!");
				 return false;
			 }
			 if(isName){
				 System.out.println("OK");
				 return true;	
			 }
			 else{
				 //System.out.println("姓名不能有特殊字元或空白");
				 JOptionPane.showMessageDialog(null,"姓名不能有數字或特殊字元");
				 return false;	
			 }		 	 			 
		 }   //isName End
		 
		 
		 
		 
		 public boolean isNumeric(String str){           //傳入字串 ， 檢查是否都為數字
		 
			 Pattern pattern = Pattern.compile("[0-9]*");
			 Matcher isNum = pattern.matcher(str);
			 if(str.isEmpty()){
				// System.out.println("是空值");
				 JOptionPane.showMessageDialog(null,"請確認輸入，電話不能有空白字元或者數字以外的字元");
				 return false;
			 }
			 
			 else{
				 if( !isNum.matches() )
				 {
					 JOptionPane.showMessageDialog(null,"請確認輸入，電話不能有空白字元或者數字以外的字元");
					// System.out.println("請確認輸入，不能有空白字元或者數字以外的字元");
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
				 JOptionPane.showMessageDialog(null,"地址欄位未填寫!");
				 return false;
			 }
			 
			 if (a>=0){
				 JOptionPane.showMessageDialog(null,"不能接受空白字元");
				 return false;
			 }
			 System.out.println("OK");
			 return true;
		 } //CK  End

		 public boolean CK_Date_Not_null(String str){         
			 char sym =' ';
			 int  a = str.indexOf(sym);
			 if(str.isEmpty()){
				 JOptionPane.showMessageDialog(null,"請選取日期");
				 return false;
			 }
			 
			 if (a>=0){
				 System.out.println("不能接受空白字元!");
				 return false;
			 }
			 System.out.println("OK");
			 return true;
		 } //CK  End

}
	
