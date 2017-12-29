package kmu.oop.practice.lab9.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kmu.oop.practice.lab9.user.domain.User;

public class UserDao {
	
	public User createUser(String id, String name, String password, int level, int login) {
	User user = new User();
	user.setId(id);
	user.setName(name);
	user.setPassword(password);
	user.setLevel(level);
	user.setLogin(login);
	
	return user;
}

	public void add(User user) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook?characterEncoding=UTF-8", "spring",
				"book");

		PreparedStatement ps = c.prepareStatement(
			"insert into users(id, name, password, level, login) values(?,?,?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		ps.setInt(4, user.getLevel());
		ps.setInt(5, user.getLogin());

		ps.executeUpdate();

		ps.close();
		c.close();
	}


	public User get(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook?characterEncoding=UTF-8", "spring",
				"book");
		PreparedStatement ps = c
				.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setLevel(rs.getInt("level"));
		user.setLogin(rs.getInt("login"));

		rs.close();
		ps.close();
		c.close();

		return user;
	}

	public void deleteAll() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook?characterEncoding=UTF-8", "spring",
				"book");
		PreparedStatement ps = c.prepareStatement("delete from users");
		
		int r = ps.executeUpdate();

		ps.close();
		c.close();
	}

	public void listTable() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook?characterEncoding=UTF-8", "spring",
				"book");
		PreparedStatement ps = c
				.prepareStatement("select * from users");

		ResultSet rs = ps.executeQuery();
		
//		System.out.println("");
		System.out.println("---------------------------------------------");
		System.out.println("id\tname\tpassword\tlevel\tlogin");
		System.out.println("---------------------------------------------");
		int count = 0;
		while(rs.next()) {
			count++;
			System.out.println(rs.getString("id") + "\t" + rs.getString("name") + "\t" + rs.getString("password") + "\t\t" + convertLevel(rs.getInt("level")) + "\t" + rs.getInt("login"));
		}
		if(count==0) System.out.println(" (empty)");
		System.out.println("---------------------------------------------");
		System.out.println("");

		rs.close();
		ps.close();
		c.close();
	}

	public void userProfile(User user) {

		System.out.println("(ID=" + user.getId() + ")");
		System.out.println("name: " + user.getName());
		System.out.println("password: " + user.getPassword());
		System.out.println("level: " + convertLevel(user.getLevel()));  // 1: BASIC, 2: SILVER, 3: GOLD
		System.out.println("login: " + user.getLogin());  // 1: default, 2: over 3, 3: over 5	
	}

	public String convertLevel(int level) {
	
	return (level==1) ? "BASIC" : (level==2) ? "SILVER" : (level==3) ? "GOLD" : "DATA ERROR" ;
	
	}

	
//----------------------------------------------------------------------------------------------------------
//  (Lab9) tests for login count-up, execute update level policy, change level, delete a particular user
//----------------------------------------------------------------------------------------------------------
//    - (Test1) login(String id) : increment the column<login>(the # of login action) in the table "users"
//	  - (Test2) updateLevel() : For each record in the table "users", monthly update of member level
//	               	0 <= login < 3 : BASIC(1) member
//    				3 <= login < 5 : SILVER(2) member
//    				5 <= login     : GOLD(3) member	            		   
//	  - (Test3) changeLevel(String id, int newLevel) : change the level for the user whose ID # is "id"
//	  - (Test4) delete(String id) : delete a particular user(ID # == <id>)
//-----------------------------------------------------------------------------------------------------------

	public User login(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook?characterEncoding=UTF-8", "spring",
				"book");
		
		User user = new User();
		
		PreparedStatement ps = c
				.prepareStatement("update users set login = login + 1 where id = ? ");
		ps.setString(1, id);
		ps.executeUpdate();
		ps.close();
		c.close();
		// (Lab9-Test1)
		
		return user;
	}
	
	public void updateLevel() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook?characterEncoding=UTF-8", "spring",
				"book");
		PreparedStatement ps = c.prepareStatement("select * from users");
		PreparedStatement psps = c.prepareStatement("UPDATE users SET level=? WHERE id =?");
		ResultSet rs = ps.executeQuery();
		int lev = 1;
		while(rs.next()) {
			if((rs.getInt("login")>=0)&(rs.getInt("login")<3)) {
				lev =1;
			} 
			else if((rs.getInt("login")>=3)&(rs.getInt("login")<5)) {
				lev =2;
			} 
			else if(((rs.getInt("login")>=5))) {
				lev =3;
			} 
			psps.setInt(1, lev);
			psps.setString(2, rs.getString("id"));
			psps.executeUpdate();
		}
		
		// (Lab9-Test2)
		
	
	}

	public User changeLevel(String id, int newLevel) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook?characterEncoding=UTF-8", "spring",
				"book");

		User user = new User();
		PreparedStatement ps = c
				.prepareStatement("UPDATE users SET level= ? WHERE id= ? ");
		
		ps.setInt(1, newLevel);
		ps.setString(2, id);
		ps.executeUpdate();
		ps.close();
		c.close();

//		User user = new User();
		
		// (Lab9-Test3)
		
		return user;
	}
	
	public void delete(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook?characterEncoding=UTF-8", "spring",
				"book");
		PreparedStatement ps = c
				.prepareStatement("Delete from users where id = ?");
		
		ps.setString(1, id);
		ps.executeUpdate();
		ps.close();
		c.close();
		// (Lab9-Test4)
		
		
	}

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		UserDao dao = new UserDao();
		
//------------------------------------------------------------------------------------------------------
//      (Lab8) tests for the basic DB operations(delete all, create record, print table, print a record
//------------------------------------------------------------------------------------------------------
//        - (Test1) deleteAll() : deletes all records in the table "users"
//		  - (Test2) createUser(String id, String name, String password, int level, int login) :
//						create object User from the user information(id, name, password, level, login)
//		  - (Test3) listTable() : print out all records in the table "users"
//		  - (Test4) userProfile(User user) : prints out the information of one particular user
//-------------------------------------------------------------------------------------------------------

		System.out.println("\n=================== (Lab8) =====================");
		
		// (Test1 & Test3)
		System.out.println("\n(Lab8/Test1&3)");
		dao.deleteAll();
		
		dao.listTable();
		
		// (Test2 & Test3)
		System.out.println("\n(Lab8/Test2&3)");
		User user1 = dao.createUser("mhchoi", "최명호", "lightho", 1, 0);
		dao.add(user1);
		User user2 = dao.createUser("sjoh", "오수정", "crystal", 1, 0);
		dao.add(user2);
		User user3 = dao.createUser("ngkim", "김남길", "ruby", 1, 0);
		dao.add(user3);
			
		dao.listTable();
		
		// (Test4)
		System.out.println("\n(Lab8/Test4)");
		User user99 = dao.get("sjoh");
		dao.userProfile(user99);
		
		
//----------------------------------------------------------------------------------------------------------
//      (Lab9) tests for login count-up, execute update level policy, change level, delete a particular user
//----------------------------------------------------------------------------------------------------------
//        - (Test1) login(String id) : increment the column<login>(the # of login action) in the table "users"
//		  - (Test2) updateLevel() : For each record in the table "users", monthly update of member level
//		               	0 <= login < 3 : BASIC(1) member
//        				3 <= login < 5 : SILVER(2) member
//        				5 <= login     : GOLD(3) member	            		   
//		  - (Test3) changeLevel(String id, int newLevel) : change the level for the user whose ID # is "id"
//		  - (Test4) delete(String id) : delete a particular user(ID # == <id>)
//-----------------------------------------------------------------------------------------------------------

		System.out.println("\n\n=================== (Lab9) =====================");
				
		// (Test1)
		System.out.println("\n(Lab9/Test1)");
		user99 = dao.login("sjoh");
		user99 = dao.login("sjoh");
		user99 = dao.login("sjoh");
		
		user99 = dao.login("ngkim");
		user99 = dao.login("ngkim");
		user99 = dao.login("ngkim");
		user99 = dao.login("ngkim");
		user99 = dao.login("ngkim");
		user99 = dao.login("ngkim");
		
		dao.listTable();

		
		// (Test2)
		System.out.println("\n(Lab9/Test2)");
		dao.updateLevel();		
		dao.listTable();

		
		// (Test3)
		System.out.println("\n(Lab9/Test3)");
		dao.changeLevel("sjoh", 1);		
		dao.listTable();

		
		// (Test4)
		System.out.println("\n(Lab9/Test4)");
		dao.delete("sjoh");		
		dao.listTable();
		
		
/*  ( main() execution result )
 
=================== (Lab8) =====================

(Lab8/Test1&3)
---------------------------------------------
id		name	password	level	login
---------------------------------------------
 (empty)
---------------------------------------------


(Lab8/Test2&3)
---------------------------------------------
id		name	password	level	login
---------------------------------------------
mhchoi	최명호		lightho		BASIC	0
ngkim	김남길		ruby		BASIC	0
sjoh	오수정		crystal		BASIC	0
---------------------------------------------


(Lab8/Test4)
(ID=sjoh)
name: 오수정
password: crystal
level: BASIC
login: 0


=================== (Lab9) =====================

(Lab9/Test1)
---------------------------------------------
id		name	password	level	login
---------------------------------------------
mhchoi	최명호		lightho		BASIC	0
ngkim	김남길		ruby		BASIC	6
sjoh	오수정		crystal		BASIC	3
---------------------------------------------


(Lab9/Test2)
---------------------------------------------
id		name	password	level	login
---------------------------------------------
mhchoi	최명호		lightho		BASIC	0
ngkim	김남길		ruby		GOLD	6
sjoh	오수정		crystal		SILVER	3
---------------------------------------------


(Lab9/Test3)
---------------------------------------------
id		name	password	level	login
---------------------------------------------
mhchoi	최명호		lightho		BASIC	0
ngkim	김남길		ruby		GOLD	6
sjoh	오수정		crystal		BASIC	3
---------------------------------------------


(Lab9/Test4)
---------------------------------------------
id		name	password	level	login
---------------------------------------------
mhchoi	최명호		lightho		BASIC	0
ngkim	김남길		ruby		GOLD	6
---------------------------------------------
 
*/

	}

}
