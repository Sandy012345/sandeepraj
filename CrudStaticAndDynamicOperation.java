import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CrudStaticAndDynamicOperation
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Connection connection=null;
		Statement statement=null;
		System.out.println("Enter your choice"+"\n"+"1.Static Operation"+"\n"+"2.Dyanamic Operation")
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
		       try {
					FileInputStream file= new FileInputStream("directory.properties");
					Properties properties= new Properties();
					properties.load(file);
					String driver=properties.getProperty("driver");
					String dburl=properties.getProperty("dburl");
					String user=properties.getProperty("user");
					String password=properties.getProperty("password");
					String query=properties.getProperty("UpdateOpe");
					Class.forName(driver);
					connection = DriverManager.getConnection(dburl, user, password);
					statement=connection.createStatement();
					System.out.println("Enter your choice"+"\n"+"a.Insert Operation"+"\n"+"b.Select Operation"+"\n"+"c.Update Operation"+"\n"+"d.Delete Operation");
					char staticchoice= sc.next().charAt(0);
					switch(staticchoice)
					{
						case a:
							int result=statement.executeUpdate(query);			
							if (result!=0) 
								{
								System.out.println(result+" no of rows affected");
								System.out.println("Data inserted successfully");
								}
								break;
						case b:
							ResultSet resultSet=statement.executeQuery(query);
							while (resultSet.next()) 
							{
								System.out.println("ID: " + resultSet.getInt(1));
								System.out.println("Name: " + resultSet.getString(2));
								System.out.println("Date: " + resultSet.getString(3));
								System.out.println("Address: " + resultSet.getString(4));
							}
							break;
						case c:
							int result=statement.executeUpdate(query);
							if (result!=0) 
							{
								System.out.println(result+" no of rows affected");
								System.out.println("Data Updated successfully");
							}
							break;
						case d:
							int result=statement.executeUpdate(query);
							if (result!=0)
							{
								System.out.println(result+" no of rows affected");
								System.out.println("Data Deleted successfully");
							}
							break;
						default:
							System.out.println("Invalid Choice can't perform any Operation");
					}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
			{
			try 
				{
				if (connection != null)
					connection.close();
				
				if (statement!=null)
					statement.close();
			    } 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		}
		case 2:
			try {
					FileInputStream file= new FileInputStream("directory.properties");
					Properties properties= new Properties();
					properties.load(file);
					String driver=properties.getProperty("driver");
					String dburl=properties.getProperty("dburl");
					String user=properties.getProperty("user");
					String password=properties.getProperty("password");
					String query=properties.getProperty("UpdateOpe");
					Class.forName(driver);
					connection = DriverManager.getConnection(dburl, user, password);
					System.out.println("Enter your choice"+"\n"+"a.Insert Operation"+"\n"+"b.Select Operation"+"\n"+"c.Update Operation"+"\n"+"d.Delete Operation");
					char dynamicchoice= sc.next().charAt(0);
					switch(dynamicchoice)
					{	
						case a:
							 String query="insert into employees values(?,?,?,?)"; 
							 PreparedStatement pst = con.prepareStatement(query); 
							 Scanner sc = new Scanner(System.in);
							 while(true) 
							 { 
							 System.out.println("student id:"); 
							 int eno=sc.nextInt(); 
							 System.out.println("student Name:"); 
							 String ename=sc.next(); 
							 System.out.println("student marks:"); 
							 double esal=sc.nextDouble(); 
							 System.out.println("student Address:"); 
							 String eaddr=sc.next(); 
							 pst.setInt(1,sid); 
							 pst.setString(2,sname); 
							 pst.setDouble(3,smarks); 
							 pst.setString(4,saddr); 
							 pst.executeUpdate(); 
							 System.out.println("Record Inserted Successfully");
							 }
							 break;
						case b:
							  String query ="delete from student where ename=?"; 
							  PreparedStatement pst = con.prepareStatement(query);
							  ResultSet rs =st.executeQuery("select * from student"); 
							  break;
						case c: 
							String query ="delete from student where ename=?"; 
							PreparedStatement pst = con.prepareStatement(query); 
							System.out.println("Enter the details to be updated");
						    char choice = sc.next().charAt(0);
							if (choice.charAt(0)=='n') 
							  {
								System.out.println("Enter the updated id: ");
								int name=sc.nextInt();
								String query=properties.getProperty("queryUpdateDynamicName");
								prepare=connection.prepareStatement(query);
								prepare.setInt(1, sid);
								prepare.setString(2, sname);
							 }
							else if(choice.charAt(0)=='n') 
							{
								System.out.println("Enter the updated name: ");
								String name=sc.next();
								String query=properties.getProperty("queryUpdateDynamicStd");
								prepare=connection.prepareStatement(query);
								prepare.setInt(1, sid);
								prepare.setString(2,sname);
							}
							else if(choice.charAt(0)=='m')
							{
								System.out.println("Enter the updated marks: ");
								double marks=sc.nextDouble();
								String query=properties.getProperty("queryUpdateDynamicMk");
								prepare=connection.prepareStatement(query);
								prepare.setInt(1, id);
								prepare.setDouble(3, smarks);
							}
							else if(choice.charAt(0)=='a') {
								System.out.println("Enter the updated contact number ");
								String address=sc.nextLine();
								String query=properties.getProperty("queryUpdateDynamicDate");
								prepare=connection.prepareStatement(query);
								prepare.setInt(1, sid);
								prepare.setLong(1, address);
							}
							else 
							{
								System.out.println("Invalid Choice.... Nothing is updated");
							}
							int result=prepare.executeUpdate();
							
							if (result!=0)
							{
								System.out.println("Data Updated successfully");
							}
							break
					    case d:
							String query ="delete from employees where ename=?"; 
							PreparedStatement pst = con.prepareStatement(query); 
							pst.setString(1,"Mallika"); 
							int updateCount=pst.executeUpdate(); 
							System.out.println("The number of rows deleted :"+updateCount);
							break;

					    default :
							System.out.println("Invalid Choice can't perform any Operation");
					}
					default : ("Invalid user choice");
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
				{
				if (connection != null)
					connection.close();
				
				if (statement!=null)
					statement.close();
			    } 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		}
		}
	}
}






