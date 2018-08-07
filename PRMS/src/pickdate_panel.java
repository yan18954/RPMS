
import java.awt.Font;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class pickdate_panel extends JPanel{
	
	pickdate_panel(){
		this.setOpaque(false);
		GUI();
	}
	void GUI(){
       // JPanel p1 = new JPanel();
        UtilDateModel model = new UtilDateModel();
        //model.setDate(20,04,2014);		
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
//		datePanel.setBounds(0,0,300,300);
		this.add(datePicker);
	}
}
