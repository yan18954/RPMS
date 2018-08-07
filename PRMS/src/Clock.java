import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock
{
   static Label lab=new Label("");
   static Calendar calendar = new GregorianCalendar();  //建立一個 Calendar
   

     
    public Clock()
    {
        lab.setBounds(80,40,400,20);     			  // 設定標籤的位置
		lab.setBackground(Color.black);    // 設定標籤的顏色  
		lab.setFont(new Font("正黑體",1,14));

    }
    
    private void setTime()  //設定系統時間
    {
        calendar.setTimeInMillis( System.currentTimeMillis() );
    }
    
    public int getYear()  //取得年
    {
        return calendar.get(Calendar.YEAR);
    }
    
    public int getMonth()  //取得月
    {
        return (calendar.get(Calendar.MONTH)+1);
    }
    
    public int getDate()  //取得日
    {
        return calendar.get(Calendar.DATE);
    }
    
    public int getHour()  //取得小時
    {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
    
    public int getMinute()  //取得分鐘
    {
        return calendar.get(Calendar.MINUTE);
    }
        
    public int getSecond()  //取得秒數
    {
        return calendar.get(Calendar.SECOND);
    }
    
    public void showCurrentTime()  //顯示目前時間
    {
        while(true)
        {
            setTime();
            lab.setText(getYear()+"年"+getMonth()+"月"+
                            getDate()+"日"+getHour()+"時"+
                            getMinute()+"分"+getSecond()+"秒");
        }
    }
  

}