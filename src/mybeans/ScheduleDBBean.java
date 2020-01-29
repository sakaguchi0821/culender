package mybeans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class ScheduleDBBean implements Serializable {
	private String name;
	private String date;
	private String schedule;
	//柳元追記
	private ArrayList<ArrayList> data;
	private ArrayList<String> colname;
	private ArrayList<String> lowdata;


	public ScheduleDBBean() {

	}

	public void insertdata() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			//データベースへの接続
			// Create a variable for the connection string.
			String connectionUrl = "jdbc:sqlserver://user14:1433;databaseName=group_da;user=groupda;password=groupda";
			Connection cn = DriverManager.getConnection(connectionUrl);

			//問い合わせの準備
			DatabaseMetaData dm = cn.getMetaData();
			ResultSet tb = dm.getTables(null, null, "予定表", null);
			//メッセージ送り
			Statement st = cn.createStatement();

			String qry1 = "INSERT INTO 予定表 VALUES ('" + name + "', " + date + ", '" + schedule + "')";
			st.executeUpdate(qry1);

			//ｊｓｐで表示させるデータの取得
			String qry2 = "SELECT * FROM 予定表;";
			ResultSet rs2 = st.executeQuery(qry2);
			 ResultSetMetaData rm = rs2.getMetaData();

			 int cnum = rm.getColumnCount();
	         //retumeihozon
	         colname = new ArrayList<String>(cnum);

	         //gyouの取得
	         for(int i=1; i<=cnum; i++){
	            colname.add(rm.getColumnName(i).toString());
	         }

	      	 data = new ArrayList<ArrayList>();
	         while(rs2.next()){
	            ArrayList<String> rowdata = new ArrayList<String>();
	            for(int i=1; i<=cnum; i++){
	                rowdata.add(rs2.getObject(i).toString());
	            }
	            data.add(rowdata);
	          }

			//接続のクローズ
			rs2.close();
			st.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//送るデータ
	public String getName() {
		return name;
	}

	public void setName(String Aname) {
		name = Aname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String Adate) {
		date = Adate;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String Aschedule) {
		schedule = Aschedule;
	}
	 public ArrayList getData()
	   {
	      return data;
	   }
	   public ArrayList getColname()
	   {
	      return colname;
	   }

}