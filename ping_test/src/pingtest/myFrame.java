package pingtest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class myFrame {
	JFrame MyFrame = new JFrame();
	JButton btn_add = new JButton();
	JButton btn_del = new JButton();
	JButton btn_front = new JButton();
	JButton btn_reflash = new JButton();
	// JButton btn_ssh = new JButton();
	JTextField txtfd = new JTextField();
	DefaultTableModel tableModel = null;
	JTable table = new JTable();
	boolean front_flag = false;
	JPopupMenu m_popupMenu = new JPopupMenu();
	
	Font font1 = new Font("微軟正黑體", Font.BOLD, 14);
	Font font2 = new Font("微軟正黑體", Font.BOLD, 10);
	Image img_lock = Toolkit.getDefaultToolkit().getImage("nail_lock.png");
	ImageIcon icon_lock = new ImageIcon(img_lock);

	Image img_unlock = Toolkit.getDefaultToolkit().getImage("nail_unlock.png");
	ImageIcon icon_unlock = new ImageIcon(img_unlock);
	String[] testServerData= {"192.168.2.221","root","tj;4u4826"}; //default service cfg info
	String BMC_IP = "";
	public void setFrame() {

		MyFrame = new JFrame("IP Status");

		// *********************panel 1 ***********************
		JPanel pane1 = new JPanel();
		pane1.setBounds(5, 5, 500, 30);
		// pane1.setBackground(Color.white);
		pane1.setLayout(null);
		MyFrame.add(pane1);

		txtfd = new JTextField();
		txtfd.setBounds(0, 0, 100, 30);
		txtfd.setFont(font1);
		txtfd.addKeyListener(adp);
		pane1.add(txtfd);

		btn_add = new JButton("add");
		btn_add.setBounds(110, 0, 70, 30);
		btn_add.addActionListener(btnPress);
		btn_add.setFont(font1);
		pane1.add(btn_add);

		btn_del = new JButton("del");
		btn_del.setBounds(180, 0, 70, 30);
		btn_del.addActionListener(btnPress);
		btn_del.setFont(font1);
		pane1.add(btn_del);
		System.out.println("gello");
		btn_front = new JButton();
		btn_front.setBounds(250, 0, 50, 30);
		btn_front.setIcon(icon_lock);
		btn_front.addActionListener(btnPress);
		// btn_front.setFont(font2);
		pane1.add(btn_front);
		// ********************panel 2 ***********************

		JPanel pane2 = new JPanel();
		pane2.setBounds(5, 40, 300, 170);
		pane2.setBackground(Color.WHITE);
		pane2.setLayout(null);
		MyFrame.add(pane2);

		// **************JTable setting*****************************
		String[] headings = new String[] { "Description","IP Address", "Status" };
		// Object[][] data = new Object[][] ;
		tableModel = new DefaultTableModel(headings, 0);
		table = new JTable(tableModel);
		table.setFont(font1);
		table.setAutoCreateRowSorter(true);
		table.addKeyListener(adp);
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            	//System.out.println("mouse click");
            }
		});
		

		JScrollPane jscp = new JScrollPane(table);
		jscp.setBounds(0, 0, 300, 170);
		pane2.add(jscp);
		
		createPopupMenu();  //add right clicked menu
		

		// ********************JFrame setting ***********************

		Image im = Toolkit.getDefaultToolkit().getImage("de_icon.jpg");
		MyFrame.setIconImage(im);
		MyFrame.setSize(320, 250);
		MyFrame.setLocation(50, 50);
		MyFrame.setLayout(null);
		MyFrame.setVisible(true);
		MyFrame.setResizable(false);
		MyFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		MyFrame.addWindowListener(new WindowHandler(MyFrame));

	}

	class WindowHandler extends WindowAdapter {
		JFrame f;

		public WindowHandler(JFrame f) {
			this.f = f;
		}

		public void windowClosing(WindowEvent e) {
			int result = JOptionPane.showConfirmDialog(f, "EXIT NOW?", "HA!HA!HA!", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				try {
					writeCfg();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		}
	}
	
	
	private void createPopupMenu() {
		int dialogButton = JOptionPane.YES_NO_OPTION;

        m_popupMenu = new JPopupMenu();
        
        JMenuItem delMenItem_on = new JMenuItem("power on");
        JMenuItem delMenItem_off = new JMenuItem("power off");
        JMenuItem delMenItem_cycle = new JMenuItem("power cycle");
        delMenItem_on.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure to perform this operation ?","Warning",dialogButton);
        		if(dialogResult == JOptionPane.YES_OPTION){
        			System.out.println("power on");
        			//System.out.println(table.getSelectedRow());
        			runCmd("plink -ssh "+testServerData[0]+" -l root -pw tj;4u4286 ipmitool -H "+BMC_IP+" -v -I lanplus -U admin -P admin chassis power on");
        			//System.out.println("plink -ssh "+testServerData[0]+" -l root -pw tj;4u4286 ipmitool -H "+BMC_IP+" -v -I lanplus -U admin -P admin chassis power on");
        		  // Saving code here
        		}
            }
        });
        
        delMenItem_off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure to perform this operation ?","Warning",dialogButton);
        		if(dialogResult == JOptionPane.YES_OPTION){
        			System.out.println("power off");
        			runCmd("plink -ssh "+testServerData[0]+" -l root -pw tj;4u4286 ipmitool -H "+BMC_IP+" -v -I lanplus -U admin -P admin chassis power off");
        		  // Saving code here
        		}
            }
        });
        
        
        delMenItem_cycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure to perform this operation ?","Warning",dialogButton);
        		if(dialogResult == JOptionPane.YES_OPTION){
        			System.out.println("power cycle");
        			runCmd("plink -ssh "+testServerData[0]+" -l root -pw tj;4u4286 ipmitool -H "+BMC_IP+" -v -I lanplus -U admin -P admin chassis power cycle");
        		  // Saving code here
        		}
            }
        });
        
        m_popupMenu.add(delMenItem_on);
        m_popupMenu.add(delMenItem_off);
        m_popupMenu.add(delMenItem_cycle);
	}
	
	
	private void table1MouseClicked(java.awt.event.MouseEvent evt) {
	       mouseRightButtonClick(evt);
	}
	
	
	
	
	
	private void mouseRightButtonClick(java.awt.event.MouseEvent evt) {
        //judge if is right click
		
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
        	System.out.println("press right");
        	try {
        		BMC_IP = tableModel.getValueAt(table.getSelectedRow(), 1).toString();
        	}catch(Exception e) {
        		
        	}
        	System.out.println("BMCIP = "+BMC_IP);
            //find click row
            int focusedRowIndex = table.rowAtPoint(evt.getPoint());
            if (focusedRowIndex == -1) {
                return;
            }
            //selected row
            table.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
            //pop up menu
            m_popupMenu.show(table, evt.getX(), evt.getY());
        }
 
    }
	
	
	

	public ActionListener btnPress = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn_add) {
				add();
			}
			if (e.getSource() == btn_reflash) {
				System.out.println("press reflash");
				reflash();
				txtfd.requestFocus();
			}
			if (e.getSource() == btn_del) { // press delete
				System.out.println("press del");
				delete();
			}
			if (e.getSource() == btn_front) {

				if (front_flag) {
					MyFrame.setAlwaysOnTop(false);
					front_flag = false;
					btn_front.setIcon(icon_lock);
					//System.out.println("O");
				} else {
					MyFrame.setAlwaysOnTop(true);
					front_flag = true;
					// btn_front.setText("拔");
					btn_front.setIcon(icon_unlock);
				}
			}	

		}
		
	};

	KeyAdapter adp = new KeyAdapter() {   
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_ENTER) {
				add();  //
			}
			if (key == KeyEvent.VK_DELETE) {
				// System.out.println("delete");
				// delete();
			}

		}
	};

	private void add() {
		if (txtfd.getText().compareTo("") != 0 && IPCheck(txtfd.getText())) {
			System.out.println("press add");
			Object rowData[] = { "",txtfd.getText(), "OFF" };
			tableModel.addRow(rowData);
			txtfd.setText("");
		}
		txtfd.requestFocus();
	}

	private void delete() {
		System.out.println("selected row : " + table.getSelectedRow());
		if (table.getSelectedRow() >= 0) {
			tableModel.removeRow(table.getSelectedRow());
		}
		txtfd.requestFocus();
	}

	public void reflash() {
		//System.out.println("Reflash");
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			tableModel.setValueAt(isOnline(tableModel.getValueAt(i, 1).toString()), i, 2);
		}
	}

	public void readCfg() throws IOException {
		try {
			FileReader fr = new FileReader("saveIP.txt");
			BufferedReader br = new BufferedReader(fr);
			String[] data = new String[2];
			while ((data = br.readLine().toString().split(",")) != null) {
				Object rowData[] = {data[0] ,data[1], "OFF" };
				tableModel.addRow(rowData);
			}
			fr.close();
		} catch (Exception e) {
			writeCfg();
		}
		reflash();
	}
	
	public void readServerCfg() throws IOException {
		try {
			FileReader fr = new FileReader("testServerCfg.txt");
			BufferedReader br = new BufferedReader(fr);
			String[] Server_data = new String[3];
			Server_data = br.readLine().toString().split(",");
			for(int data=0;data<Server_data.length;data++) {
				testServerData[data] = Server_data[data];
			}
			fr.close();
			//JOptionPane.showMessageDialog(MyFrame,"="+testServerData[0]+testServerData[1]+testServerData[2]);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(MyFrame, "Can not find testServerCfg.txt file !");
			System.out.println(e);
			//writeCfg();
		}
	}
	
	
	

	private void writeCfg() throws IOException {
		//System.out.println("write CFG");
		FileWriter fw = new FileWriter("saveIP.txt");
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			fw.write(tableModel.getValueAt(i, 0).toString()+","+tableModel.getValueAt(i, 1).toString() + "\r\n");
		}
		fw.close();
	}

	Runtime runtime = Runtime.getRuntime();
	Process process = null;
	String line = null;
	InputStream is = null;
	InputStreamReader isr = null;
	BufferedReader br = null;
	String ip = "";

	public String isOnline(String IP) {
		boolean res = false;
		try {
			ip = IP;
			//process = runtime.exec("ping -c 1 " + ip);       //for Linux 
			process = runtime.exec("ping -w 500 -n 1 " + ip);  //for dos cmd 
			// System.out.println("ping -n 1 " + ip);
			is = process.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				if (line.contains("TTL")) {
					//System.out.println(line);
					res = true;
					break;
				}
			}
			if (res) {
				//System.out.println("ON");
				return "ON";

			} else {
				//System.out.println("OFF");
				return "OFF";
			}
		} catch (IOException e) {
			System.out.println(e);
			runtime.exit(1);
		}
		return "OFF";
	}

	boolean IPCheck(String str) {
		System.out.println("IPCheck!");
		if (str.compareTo(":save") == 0) {
			try {
				writeCfg();
				txtfd.setText("");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (str != null && !str.isEmpty()) {
			String regex = "^(((\\d{1,2})|(1\\d{2})|(2[2-4]\\d)|(25[0-5]))\\.){3}((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))$";
			if (str.matches(regex)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	private void runCmd(String cmd) {   //run command
		try {
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(cmd);
			p.waitFor();
		} catch (IOException e) {
			System.out.println("IOException");

		} catch (InterruptedException f) {
			System.out.println("InterruptedExceptio");
		}
	}
	
}
