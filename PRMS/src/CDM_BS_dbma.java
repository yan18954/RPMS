import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

// ��ƺ޲z�h���O
// CDM_BS_dbma: Class DatabaseManagement_database manipulation and acess
// (��Ʈw�ާ@�P�s�����O)
class CDM_BS_dbma {

	Connection connection;
	Statement statement;

	// �غc�l:���OCDM_BS_dbma
	public CDM_BS_dbma() {
//		 createDB(); // �إ߸�Ʈwprmsdb, ������е��ѱ����@��,�H�K���ƫإ߷|�X��
//		 createTB_mi(); // �إ߸�ƪ�mi, ������е��ѱ����@��,�H�K���ƫإ߷|�X��
//		 createTB_cl(); // �إ߸�ƪ�cl, ������е��ѱ����@��,�H�K���ƫإ߷|�X��
//		 createTB_order(); // �إ߸�ƪ�order, ������е��ѱ����@��,�H�K���ƫإ߷|�X��
//		 createTB_ol(); // �إ߸�ƪ�ol, ������е��ѱ����@��,�H�K���ƫإ߷|�X��
//		 createTB_od(); // �إ߸�ƪ�od, ������е��ѱ����@��,�H�K���ƫإ߷|�X��
//		 createTB_trans(); // �إ߸�ƪ�trans, ������е��ѱ����@��,�H�K���ƫإ߷|�X��
//		 createTB_tl(); // �إ߸�ƪ�tl, ������е��ѱ����@��,�H�K���ƫإ߷|�X��
//		 createTB_td(); // �إ߸�ƪ�td, ������е��ѱ����@��,�H�K���ƫإ߷|�X��
	}

	/*----------------------------------------------------*/
	/*--                ��Ʈw�إ�                                                             --*/
	/*----------------------------------------------------*/
	// ��k:�إ߸�Ʈwprmsdb
	public void createDB() {

		// �w��MySQL�X�ʵ{��, �P�إ߸�Ʈwprmsdb
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		// �إ� prmsdb��Ʈw
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/" + "?user=root&password=mysql");
			statement = connection.createStatement();
			String createDB = "CREATE DATABASE  prmsdb";
			statement.executeUpdate(createDB);
			JOptionPane.showMessageDialog(null, "prmsdb��Ʈw�إߦ��\!");
			statement.close();
			System.exit(0);
		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "prmsdb��Ʈw�w�s�b,�i���`�ϥ�!");
			else
				JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}

	} // end for: public void createDB()

	/*----------------------------------------------------*/
	/*--                ��ƪ�إ�                                                             --*/
	/*----------------------------------------------------*/

	// �إ߸�Ʈwprmsdb������ƪ�:mi(���ƺ�����ƪ� Materials Inventory)
	public void createTB_mi() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE mi(";
			createTB += "MI_no             VARCHAR(15) PRIMARY KEY, "; // ���ƽs��
			createTB += "MI_type           VARCHAR(15), "; // ���Ƥ���
			createTB += "MI_name           VARCHAR(15), "; // �\�I�W��
			createTB += "MI_note           VARCHAR(30))"; // �\�I����

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "mi��ƪ�إߦ��\!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "mi��ƪ�w�s�b,�i���`�ϥ�!");
			else
				JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
	}

	// �إ߸�Ʈwprmsdb������ƪ�:cl(�t�Ӹ�ƪ� CompanyList)
	public void createTB_cl() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE cl(";
			createTB += "CL_no				VARCHAR(15) PRIMARY KEY, "; // �t�ӽs��,�D��
			createTB += "CL_company			VARCHAR(30) , "; // �t�ӦW��
			createTB += "CL_contact			VARCHAR(15) , "; // �t���p���H
			createTB += "CL_contactphone	VARCHAR(10) , "; // �t�ӳs���q��
			createTB += "CL_note			VARCHAR(30))"; // �t�ӳƵ�

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "cl��ƪ�إߦ��\!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "cl��ƪ�w�s�b,�i���`�ϥ�!");
			else
				JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
	}

	// �إ߸�Ʈwprmsdb������ƪ�:order(�q���ƪ� order)
	public void createTB_order() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE `order`(";
			createTB += "ORDER_no			VARCHAR(18) PRIMARY KEY, "; // �q��s��,�D��
			createTB += "ORDER_date			VARCHAR(10) , "; // �q����
			createTB += "ORDER_status		INT , "; // �q�檬�A
			createTB += "CL_no				VARCHAR(15) NOT NULL, "; // �q��t�ӽs��,�~����
			createTB += "ORDER_amount		INT , "; // �q���`���B
			createTB += "FOREIGN KEY (CL_no) REFERENCES cl (CL_no))"; // �NCL_no�]���~����

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "order��ƪ�إߦ��\!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "order��ƪ�w�s�b,�i���`�ϥ�!");
			else
				JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
	}

	// �إ߸�Ʈwprmsdb������ƪ�:ol(�q��Ӹ`��ƪ� OrderList)
	public void createTB_ol() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE ol(";
			createTB += "OL_no				VARCHAR(15) PRIMARY KEY, "; // �q��s��,�D��
			createTB += "MI_no				VARCHAR(15) NOT NULL, "; // ���ƽs��,�~����
			createTB += "OL_prices			INT , "; // �ӫ~�����
			createTB += "OL_number			INT , "; // �ʶR�ƶq
			createTB += "OL_date			VARCHAR(10) , "; // �i�f���
			createTB += "OL_amount			INT , "; // �`���B
			createTB += "FOREIGN KEY (MI_no) REFERENCES mi (MI_no))"; // �NMI_no�]���~����

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "ol��ƪ�إߦ��\!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "ol��ƪ�w�s�b,�i���`�ϥ�!");
			else
				JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
	}

	// �إ߸�Ʈwprmsdb������ƪ�:od(�q���ƪ�_�q��Ӹ`��ƪ�Order Detail)
	public void createTB_od() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE `od`(";
			createTB += "ORDER_no				VARCHAR(18) NOT NULL, "; // �q��s��,�~����
			createTB += "OL_no					VARCHAR(15) NOT NULL, "; // �q��Ӹ`�s��,�~����
			createTB += "FOREIGN KEY (ORDER_no) REFERENCES `order` (ORDER_no), "; // �NORDER_no�]���~����
			createTB += "FOREIGN KEY (OL_no) 	REFERENCES ol (OL_no)) "; // �NOL_no�]���~����

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "od��ƪ�إߦ��\!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "od��ƪ�w�s�b,�i���`�ϥ�!");
			else
				JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
	}

	// �إ߸�Ʈwprmsdb������ƪ�:TRANS(����q���ƪ� Transaction)
	public void createTB_trans() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE trans(";
			createTB += "TRANS_no				VARCHAR(18) PRIMARY KEY, "; // ����s��,�D��
			createTB += "TRANS_date				VARCHAR(10) , "; // ������
			createTB += "TRANS_shiff			INT , "; // �Z�O
			createTB += "EMPL_id				VARCHAR(17) , "; // �P�⩱��,�~����
			createTB += "TRANS_ein				INT , "; // �Τ@�s��
			createTB += "TRANS_status			INT , "; // ������A
			createTB += "TRANS_amount			INT , "; // �`������B
			createTB += "FOREIGN KEY (EMPL_id) REFERENCES staff(EMPL_id))"; // �NEMPL_id�]���~����

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "trans��ƪ�إߦ��\!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "trans��ƪ�w�s�b,�i���`�ϥ�!");
			else
				JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
	}

	// �إ߸�Ʈwprmsdb������ƪ�:TL(����q��Ӹ`��ƪ� Transaction List)
	public void createTB_tl() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE tl(";
			createTB += "TL_no				VARCHAR(15) PRIMARY KEY, "; // ����Ӹ`�s��,�D��
			createTB += "MEAL_no			VARCHAR(17) , "; // �\�I�s��,�~����
			createTB += "TL_number			INT , "; // �I�\�ƶq
			createTB += "TL_amount			INT , "; // �`���B
			createTB += "FOREIGN KEY (MEAL_no) REFERENCES meal(MEAL_no))"; // �NMEAL_no�]���~����

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "tl��ƪ�إߦ��\!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "tl��ƪ�w�s�b,�i���`�ϥ�!");
			else
				JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
	}

	// �إ߸�Ʈwprmsdb������ƪ�:td(�q���ƪ�_�q��Ӹ`��ƪ�Transaction Detail)
	public void createTB_td() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();

			String createTB = "CREATE TABLE td(";
			createTB += "TRANS_no				VARCHAR(18) , "; // ����s��,�~����
			createTB += "TL_no					VARCHAR(15) , "; // �q��Ӹ`�s��,�~����
			createTB += "FOREIGN KEY (TRANS_no) REFERENCES trans(TRANS_no),"; // �NOTRANS_no�]���~����
			createTB += "FOREIGN KEY (TL_no) 	REFERENCES tl(TL_no))"; // �NTL_no�]���~����

			statement.executeUpdate(createTB);
			JOptionPane.showMessageDialog(null, "td��ƪ�إߦ��\!");
			statement.close();

		} catch (SQLException e) {
			if (statement != null)
				JOptionPane.showMessageDialog(null, "td��ƪ�w�s�b,�i���`�ϥ�!");
			else
				JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
	}

	/*----------------------------------------------------*/
	/*--                ��ƴ��J                                                                  --*/
	/*----------------------------------------------------*/

	// �ǤJ�������O������(aMi),�M��N����Ʀs�J��Ʈw��mi��ƪ�
	public void insertRD_into_TB_mi(CPD_mi aMi) {

		Connection connection;
		Statement statement;
		String cmdData;

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}

		// �bprmsdb��Ʈw��, �s�W�@�����Ƹ�ƨ��ƪ�: mi
		try {
			cmdData = "INSERT INTO mi(MI_no,MI_type,MI_name,MI_note)" + "VALUES('" + aMi.getNo() + "','" + aMi.getType()
					+ "','" + aMi.getName() + "','" + aMi.getNote() + "')";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, ���\�g�J�@��[�������O]��mi��ƪ�!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��,�g�J�@��[�������O]��mi��ƪ��o�Ϳ��~!");
		}
	}

	// �ǤJ�q���ƪ�����(aOrder),�M��N����Ʀs�J��Ʈw��order��ƪ�
	public void insertRD_into_TB_order(CPD_order aOrder) {

		Connection connection;
		Statement statement;
		String cmdData;

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}

		// �bprmsdb��Ʈw��, �s�W�@�����Ƹ�ƨ��ƪ�: order
		try {
			cmdData = "INSERT INTO `order`(ORDER_no,ORDER_date,ORDER_status,CL_no,ORDER_amount)" + "VALUES('"
					+ aOrder.getNo() + "','" + aOrder.getDate() + "','" + aOrder.getStatus() + "','" + aOrder.getClNo()
					+ "','" + aOrder.getAmount() + "')";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, ���\�g�J�@��[�q��]��order��ƪ�!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, �g�J�@��[�q��]��order��ƪ��o�Ϳ��~!");
		}
	}

	// �ǤJ�t�Ӹ�ƪ�����(aCl),�M��N����Ʀs�J��Ʈw��cl��ƪ�
	public void insertRD_into_TB_cl(CPD_cl aCl) {

		Connection connection;
		Statement statement;
		String cmdData;

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}

		// �bprmsdb��Ʈw��, �s�W�@�����Ƹ�ƨ��ƪ�: cl
		try {
			cmdData = "INSERT INTO cl(CL_no,CL_company,CL_contact,CL_contactphone,CL_note)" + "VALUES('" + aCl.getNo()
					+ "','" + aCl.getCompany() + "','" + aCl.getContact() + "','" + aCl.getContactphone() + "','"
					+ aCl.getNote() + "')";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, ���\�g�J�@��[�t�Ӹ��]��cl��ƪ�!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, �g�J�@��[�t�Ӹ��]��cl��ƪ��o�Ϳ��~!");
		}
	}

	// �ǤJ�q��Ӹ`������(aOl),�M��N����Ʀs�J��Ʈw��ol��ƪ�
	public void insertRD_into_TB_ol(CPD_ol aOl) {

		Connection connection;
		Statement statement;
		String cmdData;

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}

		// �bprmsdb��Ʈw��, �s�W�@�����Ƹ�ƨ��ƪ�: ol
		try {
			cmdData = "INSERT INTO ol(OL_no,MI_no,OL_prices,OL_number,OL_date,OL_amount)" + "VALUES('" + aOl.getNo()
					+ "','" + aOl.getMiNo() + "','" + aOl.getPrices() + "','" + aOl.getNumber() + "','" + aOl.getDate()
					+ "','" + aOl.getAmount() + "')";
			System.out.println(cmdData);
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, ���\�g�J�@��[�q��Ӹ`]��ol��ƪ�!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, �g�J�@��[�q��Ӹ`]��ol��ƪ��o�Ϳ��~!");
		}
	}
	


	// ���p��ƪ�I�I
	// �ǤJ���p��ƪ�����(aOd),�M��N����Ʀs�J��Ʈw��od��ƪ�
	public void insertRD_into_TB_od(CPD_od aOd) {

		Connection connection;
		Statement statement;
		String cmdData;

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}

		// �bprmsdb��Ʈw��, �s�W�@�����Ƹ�ƨ��ƪ�: od
		try {
			cmdData = "INSERT INTO od(ORDER_no,OL_no)" + "VALUES('" + aOd.getOrderNo() + "','" + aOd.getOlNo() + "')";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��,���\�g�J�@��[�q��P�q��Ӹ`���p��ƪ�]��od��ƪ�!");
			statement.close();
			
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, �g�J�@��[�q��P�q�����p��ƪ�]��od��ƪ��o�Ϳ��~!");
		}
	}

	// �ǤJ����q�檫����(aTrans),�M��N����Ʀs�J��Ʈw��trans��ƪ�
	public void insertRD_into_TB_trans(CPD_trans aTrans) {

		Connection connection;
		Statement statement;
		String cmdData;

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}

		// �bprmsdb��Ʈw��, �s�W�@������q���ƨ��ƪ�: trans
		try {
			cmdData = "INSERT INTO trans(TRANS_no,TRANS_date,TRANS_shiff,EMPL_id,TRANS_ein,TRANS_status,TRANS_amount)"
					+ "VALUES('" + aTrans.getNo() + "','" + aTrans.getDate() + "','" + aTrans.getShiff() + "','"
					+ aTrans.getEmplId() + "','" + aTrans.getEin() + "','" + aTrans.getStatus() + "','"
					+ aTrans.getAmount() + "')";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, ���\�g�J�@��[����q��]��trans��ƪ�!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, �g�J�@��[����q��]��trans��ƪ��o�Ϳ��~!");
		}
	}

	// �ǤJ����q��Ӹ`������(aTl),�M��N����Ʀs�J��Ʈw��tl��ƪ�
	public void insertRD_into_TB_tl(CPD_tl aTl,String TransNo) {

		Connection connection;
		Statement statement;
		String cmdData;

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}

		// �bprmsdb��Ʈw��, �s�W�@�����Ƹ�ƨ��ƪ�: tl
		try {
			cmdData = "INSERT INTO tl(TL_no,MEAL_no,TL_number,TL_amount)" + "VALUES('" + aTl.getNo() + "','"
					+ aTl.getMealNo() + "','" + aTl.getNumber() + "','" + aTl.getAmount() + "')";
			System.out.print("aaa"+aTl.getNo()+aTl.getMealNo()+ aTl.getNumber()+ aTl.getAmount());
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
	//		JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, ���\�g�J�@��[����q��Ӹ`]��tl��ƪ�!");
			statement.close();
			
		//	insertRD_into_TB_td(aTl.getNo(),TransNo);	

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, �g�J�@��[����q��Ӹ`]��tl��ƪ��o�Ϳ��~!");
		}
	}

	// �ǤJ����q��Ӹ`������(aTd),�M��N����Ʀs�J��Ʈw��td��ƪ�
	public void insertRD_into_TB_td(String aTrans,String aTl) {

		Connection connection;
		Statement statement;
		String cmdData;

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}

		// �bprmsdb��Ʈw��, �s�W�@�����Ƹ�ƨ��ƪ�: td
		try {
			cmdData = "INSERT INTO tl(TRANS_no,TL_no)" + "VALUES('" + aTrans + "','" + aTl + "')";

			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, ���\�g�J�@��[�q�����p��ƪ�]��td��ƪ�!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, �g�J�@��[�q�����p��ƪ�]��td��ƪ��o�Ϳ��~!");
		}
	}
	/*----------------------------------------------------*/
	/*--                ��Ƭd��                                                                  --*/
	/*----------------------------------------------------*/

	// �d�̷߳s��s�W���q��s��
	public String query_lastkey_TB_order() {
		String no = "ORDER0120151028001";
		Connection connection;
		Statement statement;
		String cmdData;
		ResultSet result;
		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
		}

		// �bprmsdb��Ʈw��, ���o�̫�@���s�W����
		try {
			cmdData = "select * from `order` order by ORDER_no desc LIMIT 1";// �Nclass���Ѥj��p�Ƨǫ�A���o�Ĥ@����ƪ��Ҧ����
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeQuery(cmdData);
			result = statement.executeQuery(cmdData);
			result.next();
			no = result.getString("ORDER_no");// ���o�̷s��ORDER_no�s��
			statement.close();

		} catch (SQLException e) {
			System.out.println("�|������ƥi�H�d��");
		}
		return no;
	}

	// �d�̷߳s��s�W�����O�s��
	public String query_lastkey_TB_mi() {
		String no = "MI0120151028001";
		Connection connection;
		Statement statement;
		String cmdData;
		ResultSet result;
		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
		}

		// �bprmsdb��Ʈw��, ���o�̫�@���s�W����
		try {
			cmdData = "select * from `mi` order by MI_no desc LIMIT 1";// �Nclass���Ѥj��p�Ƨǫ�A���o�Ĥ@����ƪ��Ҧ����
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeQuery(cmdData);
			result = statement.executeQuery(cmdData);
			result.next();
			no = result.getString("MI_no");// ���o�̷s��MI_no�s��
			statement.close();

		} catch (SQLException e) {
			System.out.println("�|������ƥi�H�d��");
		}
		return no;
	}

	// �d�̷߳s��s�W���t�ӽs��
	public String query_lastkey_TB_cl() {
		String no = "CL0120151028001";
		Connection connection;
		Statement statement;
		String cmdData;
		ResultSet result;
		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
		}

		// �bprmsdb��Ʈw��, ���o�̫�@���s�W����
		try {
			cmdData = "select * from `cl` order by CL_no desc LIMIT 1";// �Ncl���Ѥj��p�Ƨǫ�A���o�Ĥ@����ƪ��Ҧ����
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeQuery(cmdData);
			result = statement.executeQuery(cmdData);
			result.next();
			no = result.getString("CL_no");// ���o�̷s��CL_no�s��
			statement.close();

		} catch (SQLException e) {
			System.out.println("�|������ƥi�H�d��");
		}
		return no;
	}
	
	// �d�̷߳s��s�W������s��
	public String query_lastkey_TB_trans() {
		String no = "TRANS0120151028001";
		Connection connection;
		Statement statement;
		String cmdData;
		ResultSet result;
		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
		}

		// �bprmsdb��Ʈw��, ���o�̫�@���s�W����
		try {
			cmdData = "select * from `trans` order by TRANS_no desc LIMIT 1";// �Nclass���Ѥj��p�Ƨǫ�A���o�Ĥ@����ƪ��Ҧ����
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeQuery(cmdData);
			result = statement.executeQuery(cmdData);
			result.next();
			no = result.getString("TRANS_no");// ���o�̷s��TRANS_no�s��
			statement.close();

		} catch (SQLException e) {
			System.out.println("�|������ƥi�H�d��");
		}
		return no;
	}
	
	// �d�̷߳s��s�W���q��Ӹ`�s��
	public String query_lastkey_TB_orderlist() {
		String no = "OL0120151028001";
		Connection connection;
		Statement statement;
		String cmdData;
		ResultSet result;
		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
		}

		// �bprmsdb��Ʈw��, ���o�̫�@���s�W����
		try {
			cmdData = "select * from `ol` order by OL_no desc LIMIT 1";// �Nclass���Ѥj��p�Ƨǫ�A���o�Ĥ@����ƪ��Ҧ����
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeQuery(cmdData);
			result = statement.executeQuery(cmdData);
			result.next();
			no = result.getString("OL_no");// ���o�̷s��ORDER_no�s��
			statement.close();

		} catch (SQLException e) {
			System.out.println("�|������ƥi�H�d��");
		}
		return no;
	}
	
	public ArrayList<ArrayList<String>> findRD_in_TB_order(String sel_rq, String rq) { // �q��
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

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return Alist;
	}

	public String[] findRD_in_TB_orderDetail(String aNo) {
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;
		String[] rtnOrderDetail = new String[5]; // ����
		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return rtnOrderDetail;
	}
	
	public ArrayList<ArrayList<String>> findRD_in_TB_orderlist(String sel_rq, String rq) { // �q��
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

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return Alist;
	}
	
	public String[] findRD_in_TB_orderListDetail(String aNo) {
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;
		String[] rtnOrderDetail = new String[6]; // ����
		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return rtnOrderDetail;
	}
	
	public String[] findRD_in_TB_OLList(String OLlist) { //����Ӹ`
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		String[] olData = new String[6];

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return olData;
	}
	
	public ArrayList<String> findRD_in_TB_od(String rq) { //�q��Ӹ`
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		ArrayList<String> Alist = new ArrayList<String>();

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return Alist;	//�^�Ǥ@���ʺA�}�C�A�Ȭ��۹���������Ӹ`�s��
	}
	

	public ArrayList<ArrayList<String>> findRD_in_TB_mi(String sel_rq, String rq) { // ����
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

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return Alist;
	}
	
	public String[] findRD_in_TB_miDetail(String aNo) {
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;
		String[] rtnMiDetail = new String[4]; // ����
		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return rtnMiDetail;
	}
	
	public ArrayList<String> findRD_in_TB_milist() { //���ƦC�� #EOL�U�Ԧ��C��ϥ�
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		ArrayList<String> List_name = new ArrayList<String>();

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return List_name;
	}
	
	public String findRD_in_TB_MiColumn(String rq,String where ,String select ) { 	//���o�t�ӭӧO����� #CHCI_MMA,CHCI_AO
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		String MI_data = new String();

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		
		return MI_data;
	}

	public ArrayList<ArrayList<String>> findRD_in_TB_cl(String sel_rq, String rq) { // �t��
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

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return Alist;
	}
	
	public String[] findRD_in_TB_clDetail(String aNo) {
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;
		String[] rtnClDetail = new String[5]; // ����
		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return rtnClDetail;
	}

	public ArrayList<String> findRD_in_TB_cllist() { //�t�ӦC�� #CFD_AO,CFD_EO�U�Ԧ��C��ϥ�
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		ArrayList<String> List_company = new ArrayList<String>();

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return List_company;
	}
	
	public String findRD_in_TB_ClColumn(String rq,String where ,String select ) { 	//���o�t�ӭӧO����� #CHCI_MMA,CHCI_AO
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		String CL_data = new String();

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return CL_data;
	}
	
	public String[] findRD_in_TB_Cldata(String aNo) { 	//���o�t�Ӹ�ơA�^�Ǥ��q�W�١B�p���H�B�p���H�q��  #CFD_SPR�ϥ�
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;
		String[] data = new String[3];
	

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return data;
	}
	
	public ArrayList<ArrayList<String>> findRD_in_TB_trans(String sel_rq, String rq) { // ����
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

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return Alist;
	}
	
	public String[] findRD_in_TB_transDetail(String aNo) {
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;
		String[] rtnTransDetail = new String[7]; // ����
		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}

		return rtnTransDetail;
	}
	

	
	public ArrayList<ArrayList<String>> findRD_in_TB_tl(String sel_rq, String rq) { //����Ӹ`
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

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return Alist;
	}
	
	public String[] findRD_in_TB_TLList(String TLlist) { //����Ӹ`
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		String[] tlData = new String[4];

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return tlData;
	}
	
	public ArrayList<String> findRD_in_TB_td(String rq) { //����Ӹ`
		Connection connection;
		Statement statement;
		ResultSet result;
		String cmdData;

		ArrayList<String> Alist = new ArrayList<String>();

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
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
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}
		return Alist;	//�^�Ǥ@���ʺA�}�C�A�Ȭ��۹���������Ӹ`�s��
	}
	

	/*----------------------------------------------------*/
	/*--                ��L��ƾާ@                                                              --*/
	/*----------------------------------------------------*/
	// ��s�q�����
	public void updateOrder_in_TB_order(CPD_order aOrder) {

		Connection connection;
		Statement statement;
		String cmdData;

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}

		// �bprmsdb��Ʈw��, �s�W�@�����O��ƨ��ƪ�: order
		try {
			cmdData = "UPDATE `order` SET ORDER_no='" + aOrder.getNo() + "',ORDER_date='" + aOrder.getDate()
					+ "',ORDER_status='" + aOrder.getStatus() + "',CL_no='" + aOrder.getClNo() + "',ORDER_amount='"
					+ aOrder.getAmount() + "'";
			System.out.println(cmdData);
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "�q���Ƨ�s���\!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, ��s�@��[�q��]��order��ƪ��o�Ϳ��~!");
		}
	}

	// ��s�������
	public void updateMi_in_TB_mi(CPD_mi aMi) {

		Connection connection;
		Statement statement;
		String cmdData;

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}

		// �bprmsdb��Ʈw��, �s�W�@�����O��ƨ��ƪ�: mi
		try {
			cmdData = "UPDATE mi SET MI_no='" + aMi.getNo() + "',MI_type='" + aMi.getType() + "',MI_name='"
					+ aMi.getName() + "',MI_note='" + aMi.getNote() + "'";
			
			System.out.println(cmdData);
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "���Ƹ�Ƨ�s���\!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, ��s�@��[����]��mi��ƪ��o�Ϳ��~!");
		}
	}

	// ��s�t�����
	public void updateCl_in_TB_cl(CPD_cl aCl) {

		Connection connection;
		Statement statement;
		String cmdData;

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}

		// �bprmsdb��Ʈw��, �s�W�@�����O��ƨ��ƪ�: cl
		try {	//�]�t�Ӹ�ƻP��L��Ʀ��쵲���Y�A�G�L�k�H�N��s�A�h�ǥѳ]�w�~����æP�ɧR���M�s�W���N��s��ƪ��ĪG
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			
			statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");	//�]�w�~���䥢��
			
			//�N�ӵ���ƧR��
			cmdData = "DELETE FROM cl WHERE CL_no='" + aCl.getNo() +"'";
			statement.executeUpdate(cmdData);
			
			//�N�ӵ���Ʒs�W�^��Ʈw
			cmdData = "INSERT INTO cl(CL_no,CL_company,CL_contact,CL_contactphone,CL_note)" + "VALUES('" + aCl.getNo()
			+ "','" + aCl.getCompany() + "','" + aCl.getContact() + "','" + aCl.getContactphone() + "','"
			+ aCl.getNote() + "')";
			statement.executeUpdate(cmdData);
			
			statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");	//�]�w��_�~����
			
			JOptionPane.showMessageDialog(null, "�t�Ӹ�Ƨ�s���\!");
			statement.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, ��s�@��[�t��]���ƪ��o�Ϳ��~!");
		}
	}
	
	
	public void updateTrans_in_TB_trans(CPD_trans aTrans) {

		Connection connection;
		Statement statement;
		String cmdData;

		// ��Ʈw�e�m�@�~
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL�X�ʵ{���w�˥���!");
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "MySQL�L�k�Ұ�!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��Ʈw�ާ@�o�ͨ�L���~!");
		}

		// �bprmsdb��Ʈw��, �s�W�@�����O��ƨ��ƪ�: trans
		try {
			cmdData = "UPDATE `trans` SET TRANS_no='" + aTrans.getNo() + "',TRANS_date='" + aTrans.getDate()
					+ "',TRANS_shiff=" + aTrans.getShiff() + ",EMPL_id='" + aTrans.getEmplId() + "',TRANS_ein="
					+ aTrans.getEin() + ",TRANS_status=" + aTrans.getStatus() + ",TRANS_amount=" + aTrans.getAmount() + "";
			System.out.println(cmdData);
			connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
			statement = connection.createStatement();
			statement.executeUpdate(cmdData);
			JOptionPane.showMessageDialog(null, "�����Ƨ�s���\!");
			statement.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�bprmsdb��Ʈw��, ��s�@��[�q��]��trans��ƪ��o�Ϳ��~!");
		}
	}
    //�d�̷߳s��s�W�����O�s��
    public String query_lastkey_TB_class(){
    	    String no = "";
            Connection connection;
            Statement statement;
            String cmdData;
			ResultSet result;
            //��Ʈw�e�m�@�~
            try{
                  Class.forName("com.mysql.jdbc.Driver");
            } catch(Exception e){
                  JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
            }

            try{
                  connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                  statement = connection.createStatement();
            } catch(SQLException e){
                  JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
            } catch(Exception e){
            }

            //�bprmsdb��Ʈw��, ���o�̫�@���s�W����
            try{  
                   cmdData = "select * from trans order by TRANS_no desc LIMIT 1";//�Nclass���Ѥj��p�Ƨǫ�A���o�Ĥ@����ƪ��Ҧ����
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/prmsdb" + "?user=root&password=mysql");
                   statement = connection.createStatement();            
				   statement.executeQuery(cmdData);		
                   result = statement.executeQuery(cmdData);		
				   result.next();
				   no = result.getString("TRANS_no");//���o�̷s��c_mo�s��
                   statement.close();
				   System.out.println(no);
					
            } catch(SQLException e){
					System.out.println("�|������ƥi�H�d��");
            }
			return no;		 

	} //

} // end for: class CDM_BS_dbma
