package connectDB;

import java.sql.*;

public class ConnectAccess {

	
	public static void main(String args[]) throws Exception{
		//ConnectAccess ca = new ConnectAccess();
		//ca.ConnectAceessFile();
		
		/*
		 * ��ȡ�ļ�Ŀ¼
		 */
	  	String path = ConnectAccess.class.getClassLoader().getResource("").getPath().substring(1);
		path  = path.substring(0, path.lastIndexOf("/"));		
		path = java.net.URLDecoder.decode(path,"UTF-8"); 
		System.out.println(path);		
	}
	
	public void ConnectAceessFile() throws Exception{
		Class.forName("com.hxtt.sql.access.AccessDriver").newInstance();
		String url = "jdbc:Access:///././Data/stu_class.mdb";
		Connection con = DriverManager.getConnection(url);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from student");
		while(rs.next()){
			System.out.println("��ţ�"+rs.getString(1)+"  ������"+rs.getString(2)+"  �Ա�"+rs.getString(3)+"  �༶��"+rs.getString(4)+";");
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
