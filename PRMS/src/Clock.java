import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock
{
   static Label lab=new Label("");
   static Calendar calendar = new GregorianCalendar();  //�إߤ@�� Calendar
   

     
    public Clock()
    {
        lab.setBounds(80,40,400,20);     			  // �]�w���Ҫ���m
		lab.setBackground(Color.black);    // �]�w���Ҫ��C��  
		lab.setFont(new Font("������",1,14));

    }
    
    private void setTime()  //�]�w�t�ήɶ�
    {
        calendar.setTimeInMillis( System.currentTimeMillis() );
    }
    
    public int getYear()  //���o�~
    {
        return calendar.get(Calendar.YEAR);
    }
    
    public int getMonth()  //���o��
    {
        return (calendar.get(Calendar.MONTH)+1);
    }
    
    public int getDate()  //���o��
    {
        return calendar.get(Calendar.DATE);
    }
    
    public int getHour()  //���o�p��
    {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
    
    public int getMinute()  //���o����
    {
        return calendar.get(Calendar.MINUTE);
    }
        
    public int getSecond()  //���o���
    {
        return calendar.get(Calendar.SECOND);
    }
    
    public void showCurrentTime()  //��ܥثe�ɶ�
    {
        while(true)
        {
            setTime();
            lab.setText(getYear()+"�~"+getMonth()+"��"+
                            getDate()+"��"+getHour()+"��"+
                            getMinute()+"��"+getSecond()+"��");
        }
    }
  

}