import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

// 資料管理層類別
// CDM_BS_dbma: Class DatabaseManagement_database manipulation and acess
// (資料庫操作與存取類別)
class CDM_BS_dbma {

	Connection connection;
	Statement statement;

	// 建構子:類別CDM_BS_dbma
	public CDM_BS_dbma() {
//		 createDB(); // 建立資料庫prmsdb, 完成後請註解掉不作用,以免重複建立會出錯
//		 createTB_mi(); // 建立資料表mi, 完成後請註解掉不作用,以免重複建立會出錯
//		 createTB_cl(); // 建立資料表cl, 完成後請註解掉不作用,以免重複建立會出錯
//		 createTB_order(); // 建立資料表order, 完成後請註解掉不作用,以免重複建立會出錯
//		 createTB_ol(); // 建立資料表ol, 完成後請註解掉不作用,以免重複建立會出錯
//		 createTB_od(); // 建立資料表od, 完成後請註解掉不作用,以免重複建立會出錯
//		 createTB_trans(); // 建立資料表trans, 完成後請註解掉不作用,以免重複建立會出錯
//		 createTB_tl(); // 建立資料表tl, 完成後請註解掉不作用,以免重複建立會出錯
//		 createTB_td(); // 建立資料表td, 完成後請註解掉不作用,以免重複建立會出錯
	}

	/*----------------------------------------------------*/
	/*--                資料庫建立                                                             --*/
	/*----------------------------------------------------*/
	// 方法:建立資料庫prmsdb
	public void createDB() {

		// 安裝MySQL驅動程式, 與建立資料庫prmsdb
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		// 建立 prmsdb資料庫
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/" + "?user=root&password=mysql");
			statement = connection.createStatement();
			String createDB = "CREATE DATABASE  prmsdb";
			statement.executeUpdate(createDB);
			JOptionPane.showMessageDialog(null, "prmsdb資料庫建立成功!");
			statement.close();
			System.exit(0);
		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "prmsdb資料庫已存在,可正常使用!");
			else
				JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

	} // end for: public void createDB()

	/*----------------------------------------------------*/
	/*--                資料表建立                                                             --*/
	/*----------------------------------------------------*/

	// 建立資料庫prmsdb中的資料表:mi(物料種類資料表 Materials Inventory)
	public void createTB_mi() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE mi(";
			createTB += "MI_no             VARCHAR(15) PRIMARY KEY, "; // 物料編號
			createTB += "MI_type           VARCHAR(15), "; // 物料分類
			createTB += "MI_name           VARCHAR(15), "; // 餐點名稱
			createTB += "MI_note           VARCHAR(30))"; // 餐點分類

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "mi資料表建立成功!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "mi資料表已存在,可正常使用!");
			else
				JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
	}

	// 建立資料庫prmsdb中的資料表:cl(廠商資料表 CompanyList)
	public void createTB_cl() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE cl(";
			createTB += "CL_no				VARCHAR(15) PRIMARY KEY, "; // 廠商編號,主鍵
			createTB += "CL_company			VARCHAR(30) , "; // 廠商名稱
			createTB += "CL_contact			VARCHAR(15) , "; // 廠商聯絡人
			createTB += "CL_contactphone	VARCHAR(10) , "; // 廠商連絡電話
			createTB += "CL_note			VARCHAR(30))"; // 廠商備註

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "cl資料表建立成功!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "cl資料表已存在,可正常使用!");
			else
				JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
	}

	// 建立資料庫prmsdb中的資料表:order(訂單資料表 order)
	public void createTB_order() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE `order`(";
			createTB += "ORDER_no			VARCHAR(18) PRIMARY KEY, "; // 訂單編號,主鍵
			createTB += "ORDER_date			VARCHAR(10) , "; // 訂單日期
			createTB += "ORDER_status		INT , "; // 訂單狀態
			createTB += "CL_no				VARCHAR(15) NOT NULL, "; // 訂單廠商編號,外來鍵
			createTB += "ORDER_amount		INT , "; // 訂單總金額
			createTB += "FOREIGN KEY (CL_no) REFERENCES cl (CL_no))"; // 將CL_no設為外來鍵

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "order資料表建立成功!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "order資料表已存在,可正常使用!");
			else
				JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
	}

	// 建立資料庫prmsdb中的資料表:ol(訂單細節資料表 OrderList)
	public void createTB_ol() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE ol(";
			createTB += "OL_no				VARCHAR(15) PRIMARY KEY, "; // 訂單編號,主鍵
			createTB += "MI_no				VARCHAR(15) NOT NULL, "; // 物料編號,外來鍵
			createTB += "OL_prices			INT , "; // 該品項單價
			createTB += "OL_number			INT , "; // 購買數量
			createTB += "OL_date			VARCHAR(10) , "; // 進貨日期
			createTB += "OL_amount			INT , "; // 總金額
			createTB += "FOREIGN KEY (MI_no) REFERENCES mi (MI_no))"; // 將MI_no設為外來鍵

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "ol資料表建立成功!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "ol資料表已存在,可正常使用!");
			else
				JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
	}

	// 建立資料庫prmsdb中的資料表:od(訂單資料表_訂單細節資料表Order Detail)
	public void createTB_od() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE `od`(";
			createTB += "ORDER_no				VARCHAR(18) NOT NULL, "; // 訂單編號,外來鍵
			createTB += "OL_no					VARCHAR(15) NOT NULL, "; // 訂單細節編號,外來鍵
			createTB += "FOREIGN KEY (ORDER_no) REFERENCES `order` (ORDER_no), "; // 將ORDER_no設為外來鍵
			createTB += "FOREIGN KEY (OL_no) 	REFERENCES ol (OL_no)) "; // 將OL_no設為外來鍵

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "od資料表建立成功!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "od資料表已存在,可正常使用!");
			else
				JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
	}

	// 建立資料庫prmsdb中的資料表:TRANS(交易訂單資料表 Transaction)
	public void createTB_trans() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE trans(";
			createTB += "TRANS_no				VARCHAR(18) PRIMARY KEY, "; // 交易編號,主鍵
			createTB += "TRANS_date				VARCHAR(10) , "; // 交易日期
			createTB += "TRANS_shiff			INT , "; // 班別
			createTB += "EMPL_id				VARCHAR(17) , "; // 銷售店員,外來鍵
			createTB += "TRANS_ein				INT , "; // 統一編號
			createTB += "TRANS_status			INT , "; // 交易狀態
			createTB += "TRANS_amount			INT , "; // 總交易金額
			createTB += "FOREIGN KEY (EMPL_id) REFERENCES staff(EMPL_id))"; // 將EMPL_id設為外來鍵

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "trans資料表建立成功!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "trans資料表已存在,可正常使用!");
			else
				JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
	}

	// 建立資料庫prmsdb中的資料表:TL(交易訂單細節資料表 Transaction List)
	public void createTB_tl() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE tl(";
			createTB += "TL_no				VARCHAR(15) PRIMARY KEY, "; // 交易細節編號,主鍵
			createTB += "MEAL_no			VARCHAR(17) , "; // 餐點編號,外來鍵
			createTB += "TL_number			INT , "; // 點餐數量
			createTB += "TL_amount			INT , "; // 總金額
			createTB += "FOREIGN KEY (MEAL_no) REFERENCES meal(MEAL_no))"; // 將MEAL_no設為外來鍵

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "tl資料表建立成功!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "tl資料表已存在,可正常使用!");
			else
				JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
	}

	// 建立資料庫prmsdb中的資料表:td(訂單資料表_訂單細節資料表Transaction Detail)
	public void createTB_td() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE td(";
			createTB += "TRANS_no				VARCHAR(18) , "; // 交易編號,外來鍵
			createTB += "TL_no					VARCHAR(15) , "; // 訂單細節編號,外來鍵
			createTB += "FOREIGN KEY (TRANS_no) REFERENCES trans(TRANS_no),"; // 將OTRANS_no設為外來鍵
			createTB += "FOREIGN KEY (TL_no) 	REFERENCES tl(TL_no))"; // 將TL_no設為外來鍵

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "td資料表建立成功!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "td資料表已存在,可正常使用!");
			else
				JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
	}

	/*----------------------------------------------------*/
	/*--                資料插入                                                                  --*/
	/*----------------------------------------------------*/

	// 傳入物料類別物件資料(aMi),然後將此資料存入資料庫的mi資料表中
	public void insertRD_into_TB_mi(CPD_mi aMi) {

		Connection connection;
		Statement statement;
		String cmdData;

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		// 在prmsdb資料庫中, 新增一筆物料資料到資料表: mi
		try {
			cmdData = "INSERT INTO mi(MI_no,MI_type,MI_name,MI_note)" + "VALUES('" + aMi.getNo() + "','" + aMi.getType()
					+ "','" + aMi.getName() + "','" + aMi.getNote() + "')";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 成功寫入一筆[物料類別]到mi資料表中!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中,寫入一筆[物料類別]到mi資料表中發生錯誤!");
		}
	}

	// 傳入訂單資料物件資料(aOrder),然後將此資料存入資料庫的order資料表中
	public void insertRD_into_TB_order(CPD_order aOrder) {

		Connection connection;
		Statement statement;
		String cmdData;

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		// 在prmsdb資料庫中, 新增一筆物料資料到資料表: order
		try {
			cmdData = "INSERT INTO `order`(ORDER_no,ORDER_date,ORDER_status,CL_no,ORDER_amount)" + "VALUES('"
					+ aOrder.getNo() + "','" + aOrder.getDate() + "','" + aOrder.getStatus() + "','" + aOrder.getClNo()
					+ "','" + aOrder.getAmount() + "')";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 成功寫入一筆[訂單]到order資料表中!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 寫入一筆[訂單]到order資料表中發生錯誤!");
		}
	}

	// 傳入廠商資料物件資料(aCl),然後將此資料存入資料庫的cl資料表中
	public void insertRD_into_TB_cl(CPD_cl aCl) {

		Connection connection;
		Statement statement;
		String cmdData;

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		// 在prmsdb資料庫中, 新增一筆物料資料到資料表: cl
		try {
			cmdData = "INSERT INTO cl(CL_no,CL_company,CL_contact,CL_contactphone,CL_note)" + "VALUES('" + aCl.getNo()
					+ "','" + aCl.getCompany() + "','" + aCl.getContact() + "','" + aCl.getContactphone() + "','"
					+ aCl.getNote() + "')";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 成功寫入一筆[廠商資料]到cl資料表中!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 寫入一筆[廠商資料]到cl資料表中發生錯誤!");
		}
	}

	// 傳入訂單細節物件資料(aOl),然後將此資料存入資料庫的ol資料表中
	public void insertRD_into_TB_ol(CPD_ol aOl) {

		Connection connection;
		Statement statement;
		String cmdData;

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		// 在prmsdb資料庫中, 新增一筆物料資料到資料表: ol
		try {
			cmdData = "INSERT INTO ol(OL_no,MI_no,OL_prices,OL_number,OL_date,OL_amount)" + "VALUES('" + aOl.getNo()
					+ "','" + aOl.getMiNo() + "','" + aOl.getPrices() + "','" + aOl.getNumber() + "','" + aOl.getDate()
					+ "','" + aOl.getAmount() + "')";
			System.out.println(cmdData);
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 成功寫入一筆[訂單細節]到ol資料表中!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 寫入一筆[訂單細節]到ol資料表中發生錯誤!");
		}
	}
	


	// 關聯資料表！！
	// 傳入關聯資料表物件資料(aOd),然後將此資料存入資料庫的od資料表中
	public void insertRD_into_TB_od(CPD_od aOd) {

		Connection connection;
		Statement statement;
		String cmdData;

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		// 在prmsdb資料庫中, 新增一筆物料資料到資料表: od
		try {
			cmdData = "INSERT INTO od(ORDER_no,OL_no)" + "VALUES('" + aOd.getOrderNo() + "','" + aOd.getOlNo() + "')";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中,成功寫入一筆[訂單與訂單細節關聯資料表]到od資料表中!");
			statement.close();
			
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 寫入一筆[訂單與訂單關聯資料表]到od資料表中發生錯誤!");
		}
	}

	// 傳入交易訂單物件資料(aTrans),然後將此資料存入資料庫的trans資料表中
	public void insertRD_into_TB_trans(CPD_trans aTrans) {

		Connection connection;
		Statement statement;
		String cmdData;

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		// 在prmsdb資料庫中, 新增一筆交易訂單資料到資料表: trans
		try {
			cmdData = "INSERT INTO trans(TRANS_no,TRANS_date,TRANS_shiff,EMPL_id,TRANS_ein,TRANS_status,TRANS_amount)"
					+ "VALUES('" + aTrans.getNo() + "','" + aTrans.getDate() + "','" + aTrans.getShiff() + "','"
					+ aTrans.getEmplId() + "','" + aTrans.getEin() + "','" + aTrans.getStatus() + "','"
					+ aTrans.getAmount() + "')";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 成功寫入一筆[交易訂單]到trans資料表中!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 寫入一筆[交易訂單]到trans資料表中發生錯誤!");
		}
	}

	// 傳入交易訂單細節物件資料(aTl),然後將此資料存入資料庫的tl資料表中
	public void insertRD_into_TB_tl(CPD_tl aTl,String TransNo) {

		Connection connection;
		Statement statement;
		String cmdData;

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		// 在prmsdb資料庫中, 新增一筆物料資料到資料表: tl
		try {
			cmdData = "INSERT INTO tl(TL_no,MEAL_no,TL_number,TL_amount)" + "VALUES('" + aTl.getNo() + "','"
					+ aTl.getMealNo() + "','" + aTl.getNumber() + "','" + aTl.getAmount() + "')";
			System.out.print("aaa"+aTl.getNo()+aTl.getMealNo()+ aTl.getNumber()+ aTl.getAmount());
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
	//		JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 成功寫入一筆[交易訂單細節]到tl資料表中!");
			statement.close();
			
		//	insertRD_into_TB_td(aTl.getNo(),TransNo);	

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 寫入一筆[交易訂單細節]到tl資料表中發生錯誤!");
		}
	}

	// 傳入交易訂單細節物件資料(aTd),然後將此資料存入資料庫的td資料表中
	public void insertRD_into_TB_td(String aTrans,String aTl) {

		Connection connection;
		Statement statement;
		String cmdData;

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		// 在prmsdb資料庫中, 新增一筆物料資料到資料表: td
		try {
			cmdData = "INSERT INTO tl(TRANS_no,TL_no)" + "VALUES('" + aTrans + "','" + aTl + "')";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 成功寫入一筆[訂單關聯資料表]到td資料表中!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 寫入一筆[訂單關聯資料表]到td資料表中發生錯誤!");
		}
	}
	/*----------------------------------------------------*/
	/*--                資料查詢                                                                  --*/
	/*----------------------------------------------------*/

	// 查詢最新後新增的訂單編號
	public String query_lastkey_TB_order() {
		String no = "ORDER0120151028001";
		Connection connection;
		Statement statement;
		String cmdData;
		ResultSet result;
		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
		}

		// 在prmsdb資料庫中, 取得最後一筆新增的值
		try {
			cmdData = "select * from `order` order by ORDER_no desc LIMIT 1";// 將class表單由大到小排序後，取得第一筆資料的所有欄位
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeQuery(cmdData);
			result = statement.executeQuery(cmdData);
			result.next();
			no = result.getString("ORDER_no");// 取得最新的ORDER_no編號
			statement.close();

		} catch (SQLException e) {
			System.out.println("尚未有資料可以查詢");
		}
		return no;
	}

	// 查詢最新後新增的類別編號
	public String query_lastkey_TB_mi() {
		String no = "MI0120151028001";
		Connection connection;
		Statement statement;
		String cmdData;
		ResultSet result;
		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
		}

		// 在prmsdb資料庫中, 取得最後一筆新增的值
		try {
			cmdData = "select * from `mi` order by MI_no desc LIMIT 1";// 將class表單由大到小排序後，取得第一筆資料的所有欄位
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeQuery(cmdData);
			result = statement.executeQuery(cmdData);
			result.next();
			no = result.getString("MI_no");// 取得最新的MI_no編號
			statement.close();

		} catch (SQLException e) {
			System.out.println("尚未有資料可以查詢");
		}
		return no;
	}

	// 查詢最新後新增的廠商編號
	public String query_lastkey_TB_cl() {
		String no = "CL0120151028001";
		Connection connection;
		Statement statement;
		String cmdData;
		ResultSet result;
		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
		}

		// 在prmsdb資料庫中, 取得最後一筆新增的值
		try {
			cmdData = "select * from `cl` order by CL_no desc LIMIT 1";// 將cl表單由大到小排序後，取得第一筆資料的所有欄位
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeQuery(cmdData);
			result = statement.executeQuery(cmdData);
			result.next();
			no = result.getString("CL_no");// 取得最新的CL_no編號
			statement.close();

		} catch (SQLException e) {
			System.out.println("尚未有資料可以查詢");
		}
		return no;
	}
	
	// 查詢最新後新增的交易編號
	public String query_lastkey_TB_trans() {
		String no = "TRANS0120151028001";
		Connection connection;
		Statement statement;
		String cmdData;
		ResultSet result;
		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
		}

		// 在prmsdb資料庫中, 取得最後一筆新增的值
		try {
			cmdData = "select * from `trans` order by TRANS_no desc LIMIT 1";// 將class表單由大到小排序後，取得第一筆資料的所有欄位
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeQuery(cmdData);
			result = statement.executeQuery(cmdData);
			result.next();
			no = result.getString("TRANS_no");// 取得最新的TRANS_no編號
			statement.close();

		} catch (SQLException e) {
			System.out.println("尚未有資料可以查詢");
		}
		return no;
	}
	
	// 查詢最新後新增的訂單細節編號
	public String query_lastkey_TB_orderlist() {
		String no = "OL0120151028001";
		Connection connection;
		Statement statement;
		String cmdData;
		ResultSet result;
		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
		}

		// 在prmsdb資料庫中, 取得最後一筆新增的值
		try {
			cmdData = "select * from `ol` order by OL_no desc LIMIT 1";// 將class表單由大到小排序後，取得第一筆資料的所有欄位
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeQuery(cmdData);
			result = statement.executeQuery(cmdData);
			result.next();
			no = result.getString("OL_no");// 取得最新的ORDER_no編號
			statement.close();

		} catch (SQLException e) {
			System.out.println("尚未有資料可以查詢");
		}
		return no;
	}
	
	public ArrayList<ArrayList<String>> findRD_in_TB_order(String sel_rq, String rq) { // 訂單
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		ArrayList<ArrayList<String>> Alist = new ArrayList<ArrayList<String>>();

		ArrayList<String> List_no = new ArrayList<String>();
		ArrayList<String> List_date = new ArrayList<String>();
		ArrayList<String> List_status = new ArrayList<String>();
		ArrayList<String> List_Cl_no = new ArrayList<String>();
		ArrayList<String> List_amount = new ArrayList<String>();
		Alist.add(List_no);
		Alist.add(List_date);
		Alist.add(List_status);
		Alist.add(List_Cl_no);
		Alist.add(List_amount);

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT * FROM `order` WHERE " + sel_rq + " LIKE '%" + rq + "%'";
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);

			while (result.next()) {
				List_no.add(result.getString("ORDER_no"));
				List_date.add(result.getString("ORDER_date"));
				List_status.add(result.getString("ORDER_status"));
				List_Cl_no.add(result.getString("CL_no"));
				List_amount.add(result.getString("ORDER_amount"));
			}

			statement.close();
			System.out.println("sel_rq=" + sel_rq);
			System.out.println("rq=" + rq);
			System.out.println(cmdData);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return Alist;
	}

	public String[] findRD_in_TB_orderDetail(String aNo) {
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;
		String[] rtnOrderDetail = new String[5]; // 欄位數
		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {

			cmdData = "SELECT * FROM `order` WHERE ORDER_no ='" + aNo + "' ";
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);

			while (result.next()) {
				rtnOrderDetail[0] = result.getString("ORDER_no");
				rtnOrderDetail[1] = result.getString("ORDER_date");
				rtnOrderDetail[2] = result.getString("ORDER_status");
				rtnOrderDetail[3] = result.getString("CL_no");
				rtnOrderDetail[4] = result.getString("ORDER_amount");
			}

			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return rtnOrderDetail;
	}
	
	public ArrayList<ArrayList<String>> findRD_in_TB_orderlist(String sel_rq, String rq) { // 訂單
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		ArrayList<ArrayList<String>> Alist = new ArrayList<ArrayList<String>>();

		ArrayList<String> List_no = new ArrayList<String>();
		ArrayList<String> List_mino = new ArrayList<String>();
		ArrayList<String> List_prices = new ArrayList<String>();
		ArrayList<String> List_number = new ArrayList<String>();
		ArrayList<String> List_date = new ArrayList<String>();
		ArrayList<String> List_amount = new ArrayList<String>();
		Alist.add(List_no);
		Alist.add(List_mino);
		Alist.add(List_prices);
		Alist.add(List_number);
		Alist.add(List_date);
		Alist.add(List_amount);

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT * FROM `ol` WHERE " + sel_rq + " LIKE '%" + rq + "%'";
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);

			while (result.next()) {
				List_no.add(result.getString("OL_no"));
				List_mino.add(result.getString("MI_no"));
				List_prices.add(result.getString("OL_prices"));
				List_number.add(result.getString("OL_number"));
				List_date.add(result.getString("OL_date"));
				List_amount.add(result.getString("OL_amount"));
			}

			statement.close();
			System.out.println("sel_rq=" + sel_rq);
			System.out.println("rq=" + rq);
			System.out.println(cmdData);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return Alist;
	}
	
	public String[] findRD_in_TB_orderListDetail(String aNo) {
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;
		String[] rtnOrderDetail = new String[6]; // 欄位數
		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {

			cmdData = "SELECT * FROM `ol` WHERE OL_no ='" + aNo + "' ";
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);

			while (result.next()) {
				rtnOrderDetail[0] = result.getString("OL_no");
				rtnOrderDetail[1] = result.getString("MI_no");
				rtnOrderDetail[2] = result.getString("OL_prices");
				rtnOrderDetail[3] = result.getString("OL_number");
				rtnOrderDetail[4] = result.getString("OL_date");
				rtnOrderDetail[5] = result.getString("OL_amount");
			}

			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return rtnOrderDetail;
	}
	
	public String[] findRD_in_TB_OLList(String OLlist) { //交易細節
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		String[] olData = new String[6];

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT * FROM `ol` WHERE  OL_no LIKE '%" + OLlist + "%'";
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);


			while (result.next()) {
				olData[0]=result.getString("OL_no");
				olData[1]=result.getString("MI_no");
				olData[2]=result.getString("OL_prices");
				olData[3]=result.getString("OL_number");
				olData[4]=result.getString("OL_date");
				olData[5]=result.getString("OL_amount");
			}

			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return olData;
	}
	
	public ArrayList<String> findRD_in_TB_od(String rq) { //訂單細節
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		ArrayList<String> Alist = new ArrayList<String>();

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT OL_no FROM `od` WHERE ORDER_no LIKE '" + rq + "'";
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);

			while (result.next()) {
				Alist.add(result.getString("OL_no"));
			}

			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return Alist;	//回傳一維動態陣列，值為相對應的交易細節編號
	}
	

	public ArrayList<ArrayList<String>> findRD_in_TB_mi(String sel_rq, String rq) { // 物料
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		ArrayList<ArrayList<String>> Alist = new ArrayList<ArrayList<String>>();

		ArrayList<String> List_no = new ArrayList<String>();
		ArrayList<String> List_type = new ArrayList<String>();
		ArrayList<String> List_name = new ArrayList<String>();
		ArrayList<String> List_note = new ArrayList<String>();
		Alist.add(List_no);
		Alist.add(List_type);
		Alist.add(List_name);
		Alist.add(List_note);

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT * FROM `mi` WHERE " + sel_rq + " LIKE '%" + rq + "%'";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);

			while (result.next()) {
				List_no.add(result.getString("MI_no"));
				List_type.add(result.getString("MI_type"));
				List_name.add(result.getString("MI_name"));
				List_note.add(result.getString("MI_note"));
			}

			statement.close();
			System.out.println("sel_rq=" + sel_rq);
			System.out.println("rq=" + rq);
			System.out.println(cmdData);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return Alist;
	}
	
	public String[] findRD_in_TB_miDetail(String aNo) {
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;
		String[] rtnMiDetail = new String[4]; // 欄位數
		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {

			cmdData = "SELECT * FROM `mi` WHERE MI_no ='" + aNo + "' ";
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);

			while (result.next()) {
				rtnMiDetail[0] = result.getString("MI_no");
				rtnMiDetail[2] = result.getString("MI_type");
				rtnMiDetail[1] = result.getString("MI_name");
				rtnMiDetail[3] = result.getString("MI_note");
			}

			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return rtnMiDetail;
	}
	
	public ArrayList<String> findRD_in_TB_milist() { //物料列表 #EOL下拉式列表使用
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		ArrayList<String> List_name = new ArrayList<String>();

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT MI_name FROM `mi`";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);

			while (result.next()) {
				List_name.add(result.getString("MI_name"));
			}

			statement.close();
			System.out.println(cmdData);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return List_name;
	}
	
	public String findRD_in_TB_MiColumn(String rq,String where ,String select ) { 	//取得廠商個別欄位資料 #CHCI_MMA,CHCI_AO
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		String MI_data = new String();

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT "+ select +" FROM `mi` WHERE " + where +" LIKE '" + rq + "'";
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);
	
			while(result.next()){
				MI_data=result.getString(select);				
			}

			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		
		return MI_data;
	}

	public ArrayList<ArrayList<String>> findRD_in_TB_cl(String sel_rq, String rq) { // 廠商
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		ArrayList<ArrayList<String>> Alist = new ArrayList<ArrayList<String>>();

		ArrayList<String> List_no = new ArrayList<String>();
		ArrayList<String> List_company = new ArrayList<String>();
		ArrayList<String> List_contact = new ArrayList<String>();
		ArrayList<String> List_contactphone = new ArrayList<String>();
		ArrayList<String> List_note = new ArrayList<String>();
		Alist.add(List_no);
		Alist.add(List_company);
		Alist.add(List_contact);
		Alist.add(List_contactphone);
		Alist.add(List_note);

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT * FROM `cl` WHERE " + sel_rq + " LIKE '%" + rq + "%'";
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);

			while (result.next()) {
				List_no.add(result.getString("CL_no"));
				List_company.add(result.getString("CL_company"));
				List_contact.add(result.getString("CL_contact"));
				List_contactphone.add(result.getString("CL_contactphone"));
				List_note.add(result.getString("CL_note"));
			}

			statement.close();
			System.out.println("sel_rq=" + sel_rq);
			System.out.println("rq=" + rq);
			System.out.println(cmdData);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return Alist;
	}
	
	public String[] findRD_in_TB_clDetail(String aNo) {
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;
		String[] rtnClDetail = new String[5]; // 欄位數
		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {

			cmdData = "SELECT * FROM `cl` WHERE CL_no ='" + aNo + "' ";
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);

			while (result.next()) {
				rtnClDetail[0] = result.getString("CL_no");
				rtnClDetail[1] = result.getString("CL_company");
				rtnClDetail[2] = result.getString("CL_contact");
				rtnClDetail[3] = result.getString("CL_contactphone");
				rtnClDetail[4] = result.getString("CL_note");
			}

			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return rtnClDetail;
	}

	public ArrayList<String> findRD_in_TB_cllist() { //廠商列表 #CFD_AO,CFD_EO下拉式列表使用
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		ArrayList<String> List_company = new ArrayList<String>();

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT CL_company FROM `cl`";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);

			while (result.next()) {
				List_company.add(result.getString("CL_company"));
			}

			statement.close();
			System.out.println(cmdData);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return List_company;
	}
	
	public String findRD_in_TB_ClColumn(String rq,String where ,String select ) { 	//取得廠商個別欄位資料 #CHCI_MMA,CHCI_AO
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		String CL_data = new String();

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT "+ select +" FROM `cl` WHERE " + where +" LIKE '" + rq + "'";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);
			
			while(result.next()){
				CL_data=result.getString(select);				
			}


			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return CL_data;
	}
	
	public String[] findRD_in_TB_Cldata(String aNo) { 	//取得廠商資料，回傳公司名稱、聯絡人、聯絡人電話  #CFD_SPR使用
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;
		String[] data = new String[3];
	

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT CL_company,CL_contact,CL_contactphone FROM `cl` WHERE CL_no LIKE '" + aNo + "'";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);
			result.next();
			
			data[0]=result.getString("CL_company");
			data[1]=result.getString("CL_contact");
			data[2]=result.getString("CL_contactphone");
			
			statement.close();
			System.out.println(cmdData);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return data;
	}
	
	public ArrayList<ArrayList<String>> findRD_in_TB_trans(String sel_rq, String rq) { // 物料
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		ArrayList<ArrayList<String>> Alist = new ArrayList<ArrayList<String>>();

		ArrayList<String> List_no = new ArrayList<String>();
		ArrayList<String> List_date = new ArrayList<String>();
		ArrayList<String> List_shiff = new ArrayList<String>();
		ArrayList<String> List_EMPL_id = new ArrayList<String>();
		ArrayList<String> List_ein = new ArrayList<String>();
		ArrayList<String> List_status = new ArrayList<String>();
		ArrayList<String> List_amount = new ArrayList<String>();
		Alist.add(List_no);
		Alist.add(List_date);
		Alist.add(List_shiff);
		Alist.add(List_EMPL_id);
		Alist.add(List_ein);
		Alist.add(List_status);
		Alist.add(List_amount);

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT * FROM `trans` WHERE " + sel_rq + " LIKE '%" + rq + "%'";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);

			while (result.next()) {
				List_no.add(result.getString("TRANS_no"));
				List_date.add(result.getString("TRANS_date"));
				List_shiff.add(result.getString("TRANS_shiff"));
				List_EMPL_id.add(result.getString("EMPL_id"));
				List_ein.add(result.getString("TRANS_ein"));
				List_status.add(result.getString("TRANS_status"));
				List_amount.add(result.getString("TRANS_amount"));
			}

			statement.close();
			System.out.println("sel_rq=" + sel_rq);
			System.out.println("rq=" + rq);
			System.out.println(cmdData);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return Alist;
	}
	
	public String[] findRD_in_TB_transDetail(String aNo) {
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;
		String[] rtnTransDetail = new String[7]; // 欄位數
		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {

			cmdData = "SELECT * FROM `trans` WHERE TRANS_no ='" + aNo + "' ";
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);


			while (result.next()) {
				rtnTransDetail[0] = result.getString("TRANS_no");
				rtnTransDetail[1]= result.getString("TRANS_date");
				rtnTransDetail[2] = result.getString("TRANS_shiff");
				rtnTransDetail[3] = result.getString("EMPL_id");
				rtnTransDetail[4] = result.getString("TRANS_ein");
				rtnTransDetail[5] = result.getString("TRANS_status");
				rtnTransDetail[6] = result.getString("TRANS_amount");
			}

			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		return rtnTransDetail;
	}
	

	
	public ArrayList<ArrayList<String>> findRD_in_TB_tl(String sel_rq, String rq) { //交易細節
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		ArrayList<ArrayList<String>> Alist = new ArrayList<ArrayList<String>>();

		ArrayList<String> TL_no = new ArrayList<String>();
		ArrayList<String> MEAL_no = new ArrayList<String>();
		ArrayList<String> TL_number = new ArrayList<String>();
		ArrayList<String> TL_amount = new ArrayList<String>();
		Alist.add(TL_no);
		Alist.add(MEAL_no);
		Alist.add(TL_amount);
		Alist.add(TL_amount);

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT * FROM `tl` WHERE " + sel_rq + " LIKE '%" + rq + "%'";
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);

			while (result.next()) {
				TL_no.add(result.getString("TL_no"));
				MEAL_no.add(result.getString("MEAL_no"));
				TL_number.add(result.getString("TL_number"));
				TL_amount.add(result.getString("TL_amount"));
			}

			statement.close();
			System.out.println("sel_rq=" + sel_rq);
			System.out.println("rq=" + rq);
			System.out.println(cmdData);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return Alist;
	}
	
	public String[] findRD_in_TB_TLList(String TLlist) { //交易細節
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		String[] tlData = new String[4];

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT * FROM `tl` WHERE  TL_no LIKE '%" + TLlist + "%'";
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);


			while (result.next()) {
				tlData[0]=result.getString("TL_no");
				tlData[1]=result.getString("MEAL_no");
				tlData[2]=result.getString("TL_number");
				tlData[3]=result.getString("TL_amount");
			}

			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return tlData;
	}
	
	public ArrayList<String> findRD_in_TB_td(String rq) { //交易細節
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		ArrayList<String> Alist = new ArrayList<String>();

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		try {
			cmdData = "SELECT TL_no FROM `td` WHERE TRANS_no LIKE '" + rq + "'";
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			result = statement.executeQuery(cmdData);

			while (result.next()) {
				Alist.add(result.getString("TL_no"));
			}

			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}
		return Alist;	//回傳一維動態陣列，值為相對應的交易細節編號
	}
	

	/*----------------------------------------------------*/
	/*--                其他資料操作                                                              --*/
	/*----------------------------------------------------*/
	// 更新訂單欄位
	public void updateOrder_in_TB_order(CPD_order aOrder) {

		Connection connection;
		Statement statement;
		String cmdData;

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		// 在prmsdb資料庫中, 新增一筆類別資料到資料表: order
		try {
			cmdData = "UPDATE `order` SET ORDER_no='" + aOrder.getNo() + "',ORDER_date='" + aOrder.getDate()
					+ "',ORDER_status='" + aOrder.getStatus() + "',CL_no='" + aOrder.getClNo() + "',ORDER_amount='"
					+ aOrder.getAmount() + "'";
			System.out.println(cmdData);
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "訂單資料更新成功!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 更新一筆[訂單]到order資料表中發生錯誤!");
		}
	}

	// 更新物料欄位
	public void updateMi_in_TB_mi(CPD_mi aMi) {

		Connection connection;
		Statement statement;
		String cmdData;

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		// 在prmsdb資料庫中, 新增一筆類別資料到資料表: mi
		try {
			cmdData = "UPDATE mi SET MI_no='" + aMi.getNo() + "',MI_type='" + aMi.getType() + "',MI_name='"
					+ aMi.getName() + "',MI_note='" + aMi.getNote() + "'";
			
			System.out.println(cmdData);
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "物料資料更新成功!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 更新一筆[物料]到mi資料表中發生錯誤!");
		}
	}

	// 更新廠商欄位
	public void updateCl_in_TB_cl(CPD_cl aCl) {

		Connection connection;
		Statement statement;
		String cmdData;

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		// 在prmsdb資料庫中, 新增一筆類別資料到資料表: cl
		try {	//因廠商資料與其他資料有鏈結關係，故無法隨意更新，則藉由設定外來鍵並同時刪除和新增替代更新資料的效果
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			
			statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");	//設定外來鍵失效
			
			//將該筆資料刪除
			cmdData = "DELETE FROM cl WHERE CL_no='" + aCl.getNo() +"'";
			statement.executeUpdate(cmdData);
			
			//將該筆資料新增回資料庫
			cmdData = "INSERT INTO cl(CL_no,CL_company,CL_contact,CL_contactphone,CL_note)" + "VALUES('" + aCl.getNo()
			+ "','" + aCl.getCompany() + "','" + aCl.getContact() + "','" + aCl.getContactphone() + "','"
			+ aCl.getNote() + "')";
			statement.executeUpdate(cmdData);
			
			statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");	//設定恢復外來鍵
			
			JOptionPane.showMessageDialog(null, "廠商資料更新成功!");
			statement.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 更新一筆[廠商]到資料表中發生錯誤!");
		}
	}
	
	
	public void updateTrans_in_TB_trans(CPD_trans aTrans) {

		Connection connection;
		Statement statement;
		String cmdData;

		// 資料庫前置作業
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL驅動程式安裝失敗!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL無法啟動!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "資料庫操作發生其他錯誤!");
		}

		// 在prmsdb資料庫中, 新增一筆類別資料到資料表: trans
		try {
			cmdData = "UPDATE `trans` SET TRANS_no='" + aTrans.getNo() + "',TRANS_date='" + aTrans.getDate()
					+ "',TRANS_shiff=" + aTrans.getShiff() + ",EMPL_id='" + aTrans.getEmplId() + "',TRANS_ein="
					+ aTrans.getEin() + ",TRANS_status=" + aTrans.getStatus() + ",TRANS_amount=" + aTrans.getAmount() + "";
			System.out.println(cmdData);
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "交易資料更新成功!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "在prmsdb資料庫中, 更新一筆[訂單]到trans資料表中發生錯誤!");
		}
	}
    //查詢最新後新增的類別編號
    public String query_lastkey_TB_class(){
    	    String no = "";
            Connection connection;
            Statement statement;
            String cmdData;
			ResultSet result;
            //資料庫前置作業
            try{
                  Class.forName("com.mysql.jdbc.Driver");
            } catch(Exception e){
                  JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
            }

            try{
                  connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                  statement = connection.createStatement();
            } catch(SQLException e){
                  JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
            } catch(Exception e){
            }

            //在prmsdb資料庫中, 取得最後一筆新增的值
            try{  
                   cmdData = "select * from trans order by TRANS_no desc LIMIT 1";//將class表單由大到小排序後，取得第一筆資料的所有欄位
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();            
				   statement.executeQuery(cmdData);		
                   result = statement.executeQuery(cmdData);		
				   result.next();
				   no = result.getString("TRANS_no");//取得最新的c_mo編號
                   statement.close();
				   System.out.println(no);
					
            } catch(SQLException e){
					System.out.println("尚未有資料可以查詢");
            }
			return no;		 

	} //

} // end for: class CDM_BS_dbma
