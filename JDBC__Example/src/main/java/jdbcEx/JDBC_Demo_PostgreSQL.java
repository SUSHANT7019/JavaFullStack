package jdbcEx;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
public class JDBC_Demo_PostgreSQL {
private static final String URL="jdbc:postgresql://localhost:5432/mydb";
private static final String USER="postgres";
private static final String PASSWD="root123";
 
private static Connection getConnection() throws SQLException{
	 return DriverManager.getConnection(URL, USER, PASSWD);
}
 
public static void createTbl(String tbl,String sql) {
	 try(Connection con=JDBC_Demo_PostgreSQL.getConnection()){
		 Statement stmt=con.createStatement();
		 stmt.executeUpdate(sql);
		 System.out.println(tbl+" created sucessfully");
	 }
	 catch(SQLException e) {e.printStackTrace();}
}//createTbl
 
public static void insertTblRow(String tblName,Collection<Data> dataCollection,String query) throws SQLException{
	 try(Connection con=JDBC_Demo_PostgreSQL.getConnection()){
		PreparedStatement pstm=con.prepareStatement(query);
		for(Data d:dataCollection) {
			pstm.setInt(1,d.getId());
			pstm.setString(2,d.getName());
			pstm.setInt(3, d.getAge());
			pstm.setFloat(4, d.getSalary());
			pstm.addBatch();
		}//for
		int[] rowInserted=pstm.executeBatch();
		System.out.println(rowInserted.length+" rows inserted sucessfully into "+tblName);
	 }
}//insertTblRow
 
public static List<Data> readAllRows(String tbl,String sql){
	 List dlist=new ArrayList<>();
	 try(Connection con =getConnection();
			 PreparedStatement stm=con.prepareStatement(sql);
			 ResultSet rs=stm.executeQuery();){
		
		 while(rs.next()) {
			 Data data=new Data(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getFloat("salary"));
			 dlist.add(data);
			  }
		
	 }
	 catch(SQLException e) {e.printStackTrace();}
	 return dlist;
}//readAllRows




public static void updateTable(String tbl,int id,String name, int age , double d){

	 String sql="UPDATE "+tbl+" SET name=?,age=?,salary=? WHERE id=?";
		 try(Connection con =getConnection();
			 PreparedStatement stm=con.prepareStatement(sql);){
			 stm.setString(1,name);
			 stm.setInt(2,age);
			 stm.setDouble(3, d);
			 stm.setInt(4,id);
			 stm.executeUpdate();
	 }
	 catch(SQLException e) {e.printStackTrace();}
}//updateTable


public static void removeRow(String tableName,int id) {
	String sql = "DELETE FROM "+tableName+" where id=?";
	
	 try(Connection con =getConnection();
			 PreparedStatement stm=con.prepareStatement(sql);){
			 stm.setInt(1,id);
			 stm.executeUpdate();
	 }
	 catch(SQLException e) {e.printStackTrace();}
}//removeRow



public static void main(String[] args) {
		//create
		String table="empdetails";
		String query="create table if not exists "+table+
				"("+"id serial primary key,"+
				"name varchar(100) not null,"+
				"age int not null,"+"salary decimal(10,2) not null)"; 
		JDBC_Demo_PostgreSQL.createTbl(table,query);
		
		//insert
		Collection<Data> dataCollection=new ArrayList<>();
		dataCollection.add(new Data(2,"Anirudha",40,200000));
		dataCollection.add(new Data(3,"Dinesh",30,20000));
		dataCollection.add(new Data(4,"Priyanka",50,250000));
		String sql="insert into "+table+" values(?,?,?,?)";
		try {
			JDBC_Demo_PostgreSQL.insertTblRow(table,dataCollection,sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//select OR show table
		String q="select * from "+table;
		List<Data> emp=readAllRows(table,q);	
		emp.forEach(System.out::println);
		System.out.println();
		//update
		JDBC_Demo_PostgreSQL.updateTable(table, 2, "SUSHANT", 18, 100000.00);
		
		//select OR show table
		 emp=readAllRows(table,q);	
		 emp.forEach(System.out::println);
			System.out.println();		
			JDBC_Demo_PostgreSQL.removeRow(table, 3);
		
			//select OR show table
			 emp=readAllRows(table,q);	
			 emp.forEach(System.out::println);
			
	}
 
}//JDBC_Demo_PostgreSQL
 
 
class Data{
	private int id;
	private String name;
	private int age;
	private float salary;
	public Data(int id, String name, int age, float salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	
}//Data
 
 
 