import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//人機互動層類別
//CHCI_MR_panel: Class HumanComputerInteraction_MakeReseration_panel (人機介面-[訂位預約]操作畫面類別)

public class CHCI_REmenu_panel extends JPanel implements ActionListener{
	JPanel mrbtn_panel =new JPanel();			  //JPanel：含新增預約. 修改預約按鈕
	
	JButton addresbtn = new JButton("新增預約");
    JButton revresbtn = new JButton("修改預約");
    CHCI_REmenu_panel(){
		mrbtn_panel.setBounds(0,0,500,60);
		mrbtn_panel.setLayout(new FlowLayout());
		add(mrbtn_panel);				//加入JPanel,內含新增預約. 修改預約按鈕
		
		addresbtn.setBounds(5,5,120,45);
		addresbtn.setBackground(Color.WHITE);
		addresbtn.setContentAreaFilled(false);
		addresbtn.setIcon(new ImageIcon(getClass().getResource("addclass_icon.png")));
		addresbtn.setFont(new Font("正黑體",0,12));
		addresbtn.addActionListener(this);
		mrbtn_panel.add(addresbtn);
		
		revresbtn.setBounds(130,5,120,45);
		//revresbtn.setEnabled(false);
		revresbtn.setBackground(Color.WHITE);
		revresbtn.setContentAreaFilled(false);
		revresbtn.setIcon(new ImageIcon(getClass().getResource("editclass_icon.png")));
		revresbtn.setFont(new Font("正黑體",0,12));
		revresbtn.addActionListener(this);
		mrbtn_panel.add(revresbtn);
		
		setBounds(0,0,500,60);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
}
