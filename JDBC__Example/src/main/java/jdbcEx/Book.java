package jdbcEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Book {
	private static final String URL="jdbc:postgresql://localhost:5432/mydb";
	private static final String USER="postgres";
	private static final String PASSWD="root123";
	public static  Scanner sc = new Scanner(System.in); 
	 
	private static Connection getConnection() throws SQLException{
		 return DriverManager.getConnection(URL, USER, PASSWD);
	}
	public static void createTbl() {
		
		String users = "create table if not exists users (order_id SERIAL primary key , email Varchar(100) unique , password varchar(20)  )";
		String orders =  "create table if not exists orders (order_id int references users(order_id),order_item varchar(100))";
		
		String books = "create table if not exists books(book_id SERIAL primary key, book_name Varchar(100), auther_name varchar(100), price decimal(10,2))";
		String Auther= "create table if not exists auther (book_id int references books(book_id) ,  auther_name varchar(20))";
		String catagary= "create table if not exists catagary (book_id int references books(book_id), catagary varchar(100) )";
		
		 try(Connection con=Book.getConnection()){
			 Statement stmt=con.createStatement();
			 stmt.executeUpdate(users);
			 
			 stmt.executeUpdate(orders);

			 stmt.executeUpdate(books);

			 stmt.executeUpdate(Auther);

			 stmt.executeUpdate(catagary);

		 }
		 catch(SQLException e) {e.printStackTrace();}
	}//createTbl
	
	public static void insertBook()
	{

		System.out.println("Enter Book id :");
		int book_id= sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter Book Name :");
		String book_name= sc.nextLine();
		
		System.out.println("Enter Auther Name : ");
		String auther_name= sc.nextLine();
		
		System.out.println("Enter catagary : ");
		String catagary= sc.nextLine();
		
		System.out.println("Enter price : ");
		double price= sc.nextDouble();
		
		 String query="INSERT INTO books(book_id,book_name,auther_name,price) VALUES(?,?,?,?)";
		 try(Connection con=Book.getConnection();
			 PreparedStatement pstm=con.prepareStatement(query);){
			 	pstm.setInt(1, book_id);
				pstm.setString(2,book_name);
				pstm.setString(3,auther_name);
				pstm.setDouble(4, price);
				pstm.executeUpdate();
		 }catch(SQLException e) {e.printStackTrace();}
		
		 query="INSERT INTO auther(book_id,auther_name) VALUES(?,?)";
		 try(Connection con=Book.getConnection();
			 PreparedStatement pstm=con.prepareStatement(query);){
				pstm.setInt(1, book_id);
			 	pstm.setString(2,auther_name);
				
				pstm.executeUpdate();
		 }catch(SQLException e) {e.printStackTrace();}
		

		 query="INSERT INTO catagary(book_id,catagary) VALUES(?,?)";
		 try(Connection con=Book.getConnection();
			 PreparedStatement pstm=con.prepareStatement(query);){
				pstm.setInt(1, book_id);
			 	pstm.setString(2,catagary);
				pstm.executeUpdate();
		 }catch(SQLException e) {e.printStackTrace();}
		 System.out.println("Book inserted Successfuly");
	}//insert book
	
	 public static void orderBook() {
		 System.out.println("Enter Email: ");
		 String email = sc.nextLine();
		 System.out.println("Enter Password: ");
		 String password = sc.nextLine();
		 System.out.println("enter book name :");
		 String book_name=sc.nextLine();
		 System.out.println("Enter Order Id:");
		 int order_id= sc.nextInt();
		 
		 
		 String  query="INSERT INTO users(order_id,email,password) VALUES(?,?,?)";
		 try(Connection con=Book.getConnection();
				 PreparedStatement pstm=con.prepareStatement(query);){
					pstm.setInt(1, order_id);
				 	pstm.setString(2,email);
				 	pstm.setString(3,password);
					pstm.executeUpdate();
			 }catch(SQLException e) {e.printStackTrace();}
		
		 
		 query="INSERT INTO orders(order_id,order_item) VALUES(?,?)";
		 try(Connection con=Book.getConnection();
				 PreparedStatement pstm=con.prepareStatement(query);){
					pstm.setInt(1, order_id);
				 	pstm.setString(2,book_name);
					pstm.executeUpdate();
			 }catch(SQLException e) {e.printStackTrace();}
		
		 System.out.println("Book ordered successfuly");
	 }//orderBook
	 
	 public static void showBooks() {
		 String sql="select * from books";
		 try(Connection con=Book.getConnection();
			 Statement stmt=con.createStatement();
			 ResultSet rs=stmt.executeQuery(sql);){
			 System.out.println("Books Avaliable :");
			 System.out.println("===========================================================");
			System.out.println("Book id|Book name|auther name|price");
			 while(rs.next()) {
				 System.out.println(rs.getInt("book_id")+"      |"+rs.getString("book_name")+"      | "+rs.getString("auther_name")+"       | "+rs.getDouble("price"));
			 }
		 }catch(SQLException e) {e.printStackTrace();}
	 }
	public static void main(String[] args) {
		Book.createTbl();
		int choice;
		while(true) {
			System.out.println("\n===========================================================\n");
			System.out.println("Enter 1 for show Books");
			System.out.println("Enter 2 for order Books");
			System.out.println("Enter 3 for insert Books");
			System.out.println("Enter any other number to exit : ");
			choice = sc.nextInt();
			sc.nextLine();
			if(choice==1) {
				Book.showBooks();
			}else if(choice ==2) {
				Book.orderBook();
			}else if(choice ==3) {
				Book.insertBook();
			}else {
				System.out.println("Exit successful");
				sc.close();
				return;
			}
			
		}
	}
}
