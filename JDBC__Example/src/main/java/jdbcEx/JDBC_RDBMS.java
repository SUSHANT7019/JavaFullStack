package jdbcEx;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
 
public class JDBC_RDBMS {
	 private static final String URL="jdbc:postgresql://localhost:5432/mydb";
	 private static final String USER="postgres";
	 private static final String PASSWD="123";
	
	 private static Connection getConnection() throws SQLException{
		 return DriverManager.getConnection(URL, USER, PASSWD);
	 }
	
	 public static void createTbl(String tbl,String sql) {
		 try(Connection con=JDBC_RDBMS.getConnection();){
			 Statement stmt=con.createStatement();
			 stmt.executeUpdate(sql);
			 System.out.println(tbl+" created sucessfully");
		 }
		 catch(SQLException e) {e.printStackTrace();}
	 }//createTbl
	
	
	 public static void insertData(String tblName,String name,int age,double salary) {
		 String query="INSERT INTO "+tblName+"(name,age,salary) VALUES(?,?,?)";
		 try(Connection con=JDBC_RDBMS.getConnection();
			 PreparedStatement pstm=con.prepareStatement(query);){
				pstm.setString(1,name);
				pstm.setInt(2,age);
				pstm.setDouble(3, salary);
				pstm.executeUpdate();
		 }catch(SQLException e) {e.printStackTrace();}
	 }//insertData
	
	 public static void updateData(String tblName,int id,String name,int newAge,double salary) {
		 String query="UPDATE "+tblName+" SET name=?,age=?,salary=? WHERE id=?";
		 try(Connection con=JDBC_RDBMS.getConnection();
			 PreparedStatement pstm=con.prepareStatement(query);){
			 pstm.setString(1,name);
			 pstm.setInt(2,newAge);
			 pstm.setDouble(3, salary);
			 pstm.setInt(4,id);
			 int rowAffected=pstm.executeUpdate();
		 }catch(SQLException e) {e.printStackTrace();}
	 }
	
	 public static void showTable(String tblName) {
		 String sql="select * from "+tblName;
		 try(Connection con=JDBC_RDBMS.getConnection();
			 Statement stmt=con.createStatement();
			 ResultSet rs=stmt.executeQuery(sql);){
			 System.out.println("Data from "+tblName);
			 while(rs.next()) {
				 System.out.println(rs.getInt("id")+" | "+rs.getString("name")+" | "+rs.getInt("age")+" | "+rs.getDouble("salary"));
			 }
		 }catch(SQLException e) {e.printStackTrace();}
	 }
	
	 static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		String tableName="empdetails";
		int choice;
		while(true) {
			System.out.println("1 . Create Table ");
			System.out.println("2 . Insert Data into Table ");
			System.out.println("3 . Update Table ");
			System.out.println("4 . Show Table ");
			System.out.println("5 . Exit Application");
			choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			case 1:	String sql="create table if not exists "+tableName+
					"("+"id serial primary key,"+
					"name varchar(100) not null,"+
					"age int not null,"+"salary decimal(10,2) not null)";
					JDBC_RDBMS.createTbl(tableName,sql); break;
			
			case 2: System.out.println("Enter Name :");String name=scanner.nextLine();
					System.out.println("Enter Age :");int age=scanner.nextInt();
					System.out.println("Enter Salary :");double salary=scanner.nextDouble();
					JDBC_RDBMS.insertData(tableName,name,age,salary); break;
			
			case 3:
				    System.out.println("Enter ID to update : ");int updateID =scanner.nextInt();
					System.out.println("Enter Name :");String newname=scanner.nextLine();
					System.out.println("Enter Age :");int newage=scanner.nextInt();
					System.out.println("Enter Salary :");double newsalary=scanner.nextDouble();		
			        JDBC_RDBMS.updateData(tableName, updateID, newname, newage, newsalary); break;
			case 4: JDBC_RDBMS.showTable(tableName);break;
			case 5: System.out.println("Exiting....");scanner.close();return;
			default:System.out.println("Invalid choice... select again");
			}
		}//while
        
	}//main
 
}//Class END
 
 