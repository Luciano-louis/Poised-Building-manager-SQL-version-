package poisedPMS;
import java.sql.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.text.ParseException;

public class poisedPMS {
	public static void main ( String [] args )throws IOException, ParseException, SQLException {
		try {
			// Used profile: louis, password: louis.
			Connection connection = DriverManager . getConnection (
			"jdbc:mysql://localhost:3306/poisedPMS_db?useSSL=false" ,
			"louis" ,
			"louis"	);
			Statement statement = connection . createStatement ();
			while(true) {
				String User_selection = menu();
				if(User_selection.equalsIgnoreCase("View projects"))
					viewProjects(statement);
				else if(User_selection.equalsIgnoreCase("New Project"))
					newProject(statement);
				else if(User_selection.equalsIgnoreCase("View Overdue"))
					viewOverdue(statement);
				else if(User_selection.equalsIgnoreCase("View Customers"))
					viewCustomers(statement);
				else if(User_selection.equalsIgnoreCase("New Customer"))
					newCustomer(statement);
				else if(User_selection.equalsIgnoreCase("View Achitects"))
					viewArchitect(statement);
				
				else if(User_selection.equalsIgnoreCase("New Achitect"))
					newArchitect(statement);
				else if(User_selection.equalsIgnoreCase("View Contractors"))
					viewContractor(statement);
				else if(User_selection.equalsIgnoreCase("New Contractor"))
					newContractor(statement);
				else if(User_selection.equalsIgnoreCase("Finalise"))
					finalise(statement);
		}
		}
	catch ( SQLException e ) {
	e . printStackTrace ();
	}
	}
//Methods
private static String menu() {
	System.out.println("Welcome to the Poised Task Manager Main menu");
	System.out.println("Please enter:\n");
	System.out.println("View Projects		- To view and update Projects");
	System.out.println("New Project		- To add a new project");
	System.out.println("View Overdue		- To view all Overdue projects");
	System.out.println("View Customers		- To view or update all Customers details currently in the Database");
	System.out.println("New Customer		- To add a new Customer details to database");
	System.out.println("View Achitects		- To view all Achitects details currently in database");
	System.out.println("New Achitect		- To add a new Achitect details to database");
	System.out.println("View Contractors	- To view all Contractors details currently in database");
	System.out.println("New Contractor		- To add a new Contractor details to database");
	System.out.println("Finalise		- Generate a Invoice for exsiting projects");//Menu options
	System.out.println("");

	Scanner a = new Scanner(System.in);
	String User_selection = a.nextLine();
	return User_selection;
}

private static void viewProjects(Statement statement) throws SQLException {
{
	System.out.println("\nVIEW PROJECTS SELECTED");
	System.out.println("Please enter:\n");
	System.out.println("Pending		- To view Projects still in progress");
	System.out.println("Completed	- To view Projects that have been completed");
	System.out.println("Menu		- To return to the Main menu\n");
	Scanner b = new Scanner(System.in);
	String P_Type = b.nextLine();
	if(P_Type.equalsIgnoreCase("Pending")) {
		System.out.println("");
		System.out.println("The following Projects are currently listed in the data base:\n");
		printTasks (statement);
		System.out.println("End of tasks.");
		System.out.println("\nPlease enter:\n");
		System.out.println("Update	- to update any of the Projects listed");
		System.out.println("Menu	- to return to the main menu\n");		
		Scanner a = new Scanner(System.in);
		String Return = a.nextLine();
		if(Return.equalsIgnoreCase("Update")) {
			System.out.println("\nUPDATE PROJECT SELECTED");
			System.out.println("Please Enter the Project number you would like to update:\n");
			Scanner c = new Scanner(System.in);
			int p_num = c.nextInt();
			System.out.println("\nPlease enter:\n");
			System.out.println("1  - To change the name of the Project");
			System.out.println("2  - To change the building Type listed");
			System.out.println("3  - To change the address listed");
			System.out.println("4  - To change the ERF number");
			System.out.println("5  - To change the Amount the building costs");
			System.out.println("6  - To change the Amount that has been Paid to date");
			System.out.println("7  - To change the Deadline for the Project");
			System.out.println("8  - To change the Architect assigned to the project");
			System.out.println("9  - To change the Contractor assigned to the project");
			System.out.println("10 - To change the Customer name listed for this project\n");
			Scanner d = new Scanner(System.in);
			String Field = d.nextLine();
			if(Field.equals("1")) {
				System.out.println("\nCHANGE PROJECT NAME SELECTED");
				System.out.println("Please Enter the updated name:\n");
				Scanner e = new Scanner(System.in);
				String Update = e.nextLine();
				statement.executeUpdate (
						"UPDATE TASKS SET PRO_NAME='"+Update+"' WHERE PRO_NUM="+p_num
						);	
						System.out.println("\nThe Name for Project number:"+p_num+"\nhas been Changed to: "+Update);
						System.out.println("Returning to main menu.\n");
			}
			else if(Field.equals("2")) {
				System.out.println("\nCHANGE BUILDING TYPE SELECTED");
				System.out.println("Please Enter the updated building Type:\n");
				Scanner e = new Scanner(System.in);
				String Update = e.nextLine();
				statement.executeUpdate (
						"UPDATE TASKS SET BUILDING='"+Update+"' WHERE PRO_NUM="+p_num
						);	
						System.out.println("\nThe building Type for Project number:"+p_num+"\nhas been Changed to: "+Update);
						System.out.println("Returning to main menu.\n");
			}
			else if(Field.equals("3")) {
				System.out.println("\nCHANGE ADDRESS LISTED SELECTED");
				System.out.println("Please Enter the updated Address:\n");
				Scanner e = new Scanner(System.in);
				String Update = e.nextLine();
				statement.executeUpdate (
						"UPDATE TASKS SET ADDRESS='"+Update+"' WHERE PRO_NUM="+p_num
						);	
						System.out.println("\nThe Address listed for Project number:"+p_num+"\nhas been Changed to: "+Update);
						System.out.println("Returning to main menu.\n");
			}
			else if(Field.equals("4")) {
				System.out.println("\nCHANGE ERF NUMBER SELECTED");
				System.out.println("Please Enter the updated ERF number:\n");
				Scanner e = new Scanner(System.in);
				int Update = e.nextInt();
				statement.executeUpdate (
						"UPDATE TASKS SET ERF="+Update+" WHERE PRO_NUM="+p_num
						);	
						System.out.println("\nThe ERF number for Project:"+p_num+"\nhas been Changed to: "+Update);
						System.out.println("Returning to main menu.\n");
			}
			else if(Field.equals("5")) {
				System.out.println("\nCHANGE COST TO CUSTOMER SELECTED");
				System.out.println("Please Enter the updated Amount:\n");
				Scanner e = new Scanner(System.in);
				int Update = e.nextInt();
				statement.executeUpdate (
						"UPDATE TASKS SET PRICE="+Update+" WHERE PRO_NUM="+p_num
						);	
						System.out.println("\nThe Amount listed for Project:"+p_num+"\nhas been Changed to: "+Update);
						System.out.println("Returning to main menu.\n");
			}
			else if(Field.equals("6")) {
				System.out.println("\nCHANGE AMOUNT PAID THUS FAR");
				System.out.println("Please Enter the updated Amount:\n");
				Scanner e = new Scanner(System.in);
				int Update = e.nextInt();
				statement.executeUpdate (
						"UPDATE TASKS SET PAID="+Update+" WHERE PRO_NUM="+p_num
						);	
						System.out.println("\nThe Amount paid to date listed for Project:"+p_num+"\nhas been Changed to: "+Update);
						System.out.println("Returning to main menu.\n");
			}
			else if(Field.equals("7")) {
				System.out.println("\nCHANGE PROJECT DUEDATE SELECTED");
				System.out.println("Please Enter the updated Duedate:\n");
				Scanner e = new Scanner(System.in);
				String Update = e.nextLine();
				statement.executeUpdate (
						"UPDATE TASKS SET DEADLINE='"+Update+"' WHERE PRO_NUM="+p_num
						);	
						System.out.println("\nThe Duedate for Project:"+p_num+"\nhas been Changed to: "+Update);
						System.out.println("Returning to main menu.\n");
			}
			else if(Field.equals("8")) {
				System.out.println("\nCHANGE ARCHTECT SELECTED");
				System.out.println("Please Enter the new Architech:\n");
				Scanner e = new Scanner(System.in);
				String Update = e.nextLine();
				statement.executeUpdate (
						"UPDATE TASKS SET ARCHITECT='"+Update+"' WHERE PRO_NUM="+p_num
						);	
						System.out.println("\nThe Duedate for Project:"+p_num+"\nhas been Changed to: "+Update);
						System.out.println("Returning to main menu.\n");
			}
			else if(Field.equals("9")) {
				System.out.println("\nCHANGE CONTRACTOR SELECTED");
				System.out.println("Please Enter the new Contractor:\n");
				Scanner e = new Scanner(System.in);
				String Update = e.nextLine();
				statement.executeUpdate (
						"UPDATE TASKS SET CONTRACTOR='"+Update+"' WHERE PRO_NUM="+p_num
						);	
						System.out.println("\nThe Duedate for Project:"+p_num+"\nhas been Changed to: "+Update);
						System.out.println("Returning to main menu./n");
			}
			else if(Field.equals("10")) {
				System.out.println("\nCHANGE CUSTOMER SELECTED");
				System.out.println("Please Enter the new Customer:\n");
				Scanner e = new Scanner(System.in);
				String Update = e.nextLine();
				statement.executeUpdate (
						"UPDATE TASKS SET CONTRACTOR='"+Update+"' WHERE PRO_NUM="+p_num
						);	
						System.out.println("\nThe Duedate for Project:"+p_num+"\nhas been Changed to: "+Update);
						System.out.println("Returning to main menu.\n");
			}
			else {
				System.out.println("\nInvalid selection, Exiting");
				System.exit(0);
			}
		}
		else if(!Return.equalsIgnoreCase("menu") && (!Return.equalsIgnoreCase("Completed"))) {
			System.out.println("Exiting, Thank you.");
			System.exit(0);
		}
	}
	else if(P_Type.equalsIgnoreCase("Completed")){
		System.out.println("");
		System.out.println("The following Projects have been listed as Completed:\n");
		printF(statement);
		System.out.println("Returning to main menu.\n");
	}
	else if(!P_Type.equalsIgnoreCase("Completed") && !P_Type.equalsIgnoreCase("pending") && !P_Type.equalsIgnoreCase("menu")) {
		System.out.println("\nExiting");
		System.exit(0);
	}
}
}

private static void newProject(Statement statement) throws SQLException {
	{
		int rowsAffected;
	{
		System.out.println("\nNEW PROJECT SELECTED");
		System.out.println("Please type the project name: ");
		Scanner b = new Scanner(System.in);
		String Project_name = b.nextLine();
		
		System.out.println("Please type the building type: ");
		Scanner c = new Scanner(System.in);
		String Building_type = c.nextLine();
		
		System.out.println("Please type the address: ");
		Scanner d = new Scanner(System.in);
		String Physical_address = d.nextLine();

		System.out.println("Please type the Erf number: ");
		Scanner e = new Scanner(System.in);
		int Erf = e.nextInt();
		
		System.out.println("Please type the total amount charged: ");
		Scanner f = new Scanner(System.in);
		float Total_charge = f.nextFloat();
		
		System.out.println("Please type the total amount paid thus far: ");
		Scanner g = new Scanner(System.in);
		float Paid = g.nextFloat();
		
		System.out.println("Please type the project Due date(yyyy-mm-dd)");
		Scanner j = new Scanner(System.in);
		String Deadline = j.nextLine();
		
		System.out.println("Please type the Contractors name");
		Scanner h = new Scanner(System.in);
		String Contractor = h.nextLine();
		
		System.out.println("Please type the Architects name");
		Scanner i = new Scanner(System.in);
		String Architect = i.nextLine();
		
		System.out.println("Please type the Customer name");
		Scanner k = new Scanner(System.in);
		String Customer = k.nextLine();
		
		rowsAffected = statement.executeUpdate(
				"Insert into TASKS(PRO_NAME, BUILDING, ADDRESS, ERF, PRICE, PAID, DEADLINE, ARCHITECT, CONTRACTOR, CUSTOMER)"
				+"VALUES('"+Project_name + "', '"+Building_type+"', '"+Physical_address+ "', "+Erf+", "+Total_charge+", "+Paid+" , '"+ Deadline+"', '"
				+Contractor+"', '"+Architect+"' ,'"+Customer+"')"
				);
				System.out.println("\nThe following has been added to the database:");
				System.out.println("Project name: \n"+Project_name);
				System.out.println("Type of building: \n"+Building_type);
				System.out.println("Physical address of building: \n"+Physical_address);
				System.out.println("ERF number: \n"+Erf);
				System.out.println("Total amount charged: \n"+"R"+Total_charge);
				System.out.println("Total amount paid to date: \n"+"R"+Paid);
				System.out.println("Deadline set for project: \n"+Deadline);
				System.out.println("Contractor assigned to project: \n"+Contractor);
				System.out.println("Architect assigned to project: \n"+Architect);
				System.out.println("Customer for this project: \n"+Customer);
				System.out.println("");
				System.out.println("Type 'Menu' to return to the main menu");
				Scanner l = new Scanner(System.in);
				String Return = l.nextLine();
				if(!Return.equalsIgnoreCase("menu")) {
					System.out.println("Exiting, Thank you.");
					System.exit(0);
			 
		
}
}
	
}
}

private static void viewOverdue(Statement statement) throws SQLException {
{
	System.out.println("\nVIEW OVERDUE TASKS SELECTED");
	System.out.println("The following tasks are overdue:\n");
	ResultSet results = statement.executeQuery("SELECT * FROM TASKS WHERE DEADLINE <= CURDATE();");
	while(results.next()) {
		System.out.println(
				"Project Number:..................."+ results.getInt("PRO_NUM") + "\n" +
				"Project Name:....................."+ results.getString("PRO_NAME") + "\n" +
				"Type of Building:................."+ results.getString("BUILDING") + "\n" +
				"Physical Address:................."+ results.getString("ADDRESS") + "\n" +
				"ERF Number:......................."+ results.getString("ERF") + "\n" +
				"Total Amount Charged:.............R"+ results.getString("PRICE") + "\n" +
				"Total Amount Paid to date:........R"+ results.getString("PAID") + "\n" +
				"Deadline set for this Project:...."+ results.getString("DEADLINE") + "\n" +
				"Architect assigned:..............."+ results.getString("ARCHITECT") + "\n" +
				"Contractor assigned:.............."+ results.getString("CONTRACTOR") + "\n" +
				"Customer listed:.................."+ results.getString("CUSTOMER") + "\n");
		}
	
		System.out.println("End of Overdue tasks.");
		System.out.println("Enter 'Menu' to return to the Main menu");
		Scanner a = new Scanner(System.in);
		String Return = a.nextLine();
		if(!Return.equalsIgnoreCase("menu")) {
			System.out.println("Exiting, Thank you.");
			System.exit(0);
		}
	}
}

private static void viewCustomers(Statement statement) throws SQLException {
	{
		System.out.println("\nVIEW CUSTOMERS SELECTED");
		System.out.println("The following Customers are currently in the data base:\n");
		printCu(statement);
		System.out.println("End of Customers.");
		System.out.println("\nPlease enter:\n");
		System.out.println("Update	- to update any Customers information");
		System.out.println("Menu	- to return to the main menu\n");		
		Scanner a = new Scanner(System.in);
		String Return = a.nextLine();
		if(Return.equalsIgnoreCase("Update")) {
			System.out.println("\nUPDATE CUSTOMER SELECTED");
			System.out.println("Please Enter the ID of the customer you would like to update:\n");
			Scanner b = new Scanner(System.in);
			int num = b.nextInt();
			System.out.println("\nPlease enter:\n");
			System.out.println("1  - To change the customer's name");
			System.out.println("2  - To change the customer's Email address");
			System.out.println("3  - To change the customer's Physical address");
			Scanner c = new Scanner(System.in);
			String Field = c.nextLine();
			if(Field.equals("1")) {
				System.out.println("\nCHANGE CUSTOMER NAME SELECTED");
				System.out.println("Please Enter the updated name:\n");
				Scanner d = new Scanner(System.in);
				String Update = d.nextLine();
				statement.executeUpdate (
						"UPDATE CUSTOMERS SET CU_NAME='"+Update+"' WHERE CU_NUM="+num
						);	
						System.out.println("\nThe Name for Customer Id:"+num+"\nhas been Changed to: "+Update);
						System.out.println("Returning to main menu.\n");
			}
			else if(Field.equals("2")) {
				System.out.println("\nCHANGE EMAIL ADDRESS SELECTED");
				System.out.println("Please Enter the updated email address:\n");
				Scanner e = new Scanner(System.in);
				String Update = e.nextLine();
				statement.executeUpdate (
						"UPDATE CUSTOMERS SET CU_EMAIL='"+Update+"' WHERE CU_NUM="+num
						);	
						System.out.println("\nThe Email address for Customer Id:"+num+"\nhas been Changed to: "+Update);
						System.out.println("Returning to main menu.\n");
			}
			else if(Field.equals("2")) {
				System.out.println("\nCHANGE PHYSICAL ADDRESS SELECTED");
				System.out.println("Please Enter the updated address:\n");
				Scanner e = new Scanner(System.in);
				String Update = e.nextLine();
				statement.executeUpdate (
						"UPDATE CUSTOMERS SET CU_ADDRESS='"+Update+"' WHERE CU_NUM="+num
						);	
						System.out.println("\nThe address for Customer Id:"+num+"\nhas been Changed to: "+Update);
						System.out.println("Returning to main menu.\n");
			}
		
	}
	else if(!Return.equalsIgnoreCase("menu")) {
		System.out.println("Exiting, Thank you.");
		System.exit(0);
}
}
}

private static void newCustomer(Statement statement) throws SQLException {
	{
		{
			System.out.println("\nADD NEW CUSTOMER SELECTED");
			System.out.println("Please enter the Customer's name:");
			Scanner a = new Scanner(System.in);
			String Cu_name = a.nextLine();
			
			System.out.println("Please enter the Customer's Phone number:");
			Scanner d = new Scanner(System.in);
			String Cu_num = d.nextLine();

			System.out.println("Please enter the Customer's Email address:");
			Scanner b = new Scanner(System.in);
			String Cu_email = b.nextLine();
			
			System.out.println("Please enter the Customer's Physical address:");
			Scanner c = new Scanner(System.in);
			String Cu_address = c.nextLine();
			statement.executeUpdate(
					"Insert into CUSTOMERS(CU_NAME, CU_PHONE, CU_EMAIL, CU_ADDRESS)"
					+"VALUES('"+Cu_name+ "', '"+Cu_num+"', '"+Cu_email+"', '"+Cu_address+"')"
					);
					System.out.println("\nThe following has been added to the database:");
					System.out.println("Customer Name:................"+Cu_name);
					System.out.println("Phone number:................."+Cu_num);
					System.out.println("Email Address:................"+Cu_email);
					System.out.println("Physical Address:............."+Cu_address);
					System.out.println("");
					System.out.println("Type 'Menu' to return to the main menu");
					Scanner l = new Scanner(System.in);
					String Return = l.nextLine();
					if(!Return.equalsIgnoreCase("menu")) {
						System.out.println("Exiting, Thank you.");
						System.exit(0);
	}
	}
		
	}
}

private static void viewArchitect(Statement statement) throws SQLException {
	{
		{
			System.out.println("\nVIEW ARCHITECTS SELECTED");
			System.out.println("The following Architects are currently in the data base:\n");
			printAr(statement);
			System.out.println("End of Architects.");
			System.out.println("\nPlease enter:\n");
			System.out.println("Update	- to update any Architects information");
			System.out.println("Menu	- to return to the main menu\n");		
			Scanner a = new Scanner(System.in);
			String Return = a.nextLine();
			if(Return.equalsIgnoreCase("Update")) {
				System.out.println("\nUPDATE ARCHITECT SELECTED");
				System.out.println("Please Enter the ID of the architect you would like to update:\n");
				Scanner b = new Scanner(System.in);
				int num = b.nextInt();
				System.out.println("\nPlease enter:\n");
				System.out.println("1  - To change the architect's name");
				System.out.println("2  - To change the architect's Email address");
				System.out.println("3  - To change the architect's Physical address");
				Scanner c = new Scanner(System.in);
				String Field = c.nextLine();
				if(Field.equals("1")) {
					System.out.println("\nCHANGE ARCHITECT NAME SELECTED");
					System.out.println("Please Enter the updated name:\n");
					Scanner d = new Scanner(System.in);
					String Update = d.nextLine();
					statement.executeUpdate (
							"UPDATE ARCHITECTS SET AR_NAME='"+Update+"' WHERE AR_NUM="+num
							);	
							System.out.println("\nThe Name for Architect Id:"+num+"\nhas been Changed to: "+Update);
							System.out.println("Returning to main menu.\n");
				}
				else if(Field.equals("2")) {
					System.out.println("\nCHANGE EMAIL ADDRESS SELECTED");
					System.out.println("Please Enter the updated email address:\n");
					Scanner e = new Scanner(System.in);
					String Update = e.nextLine();
					statement.executeUpdate (
							"UPDATE ARCHITECTS SET AR_EMAIL='"+Update+"' WHERE AR_NUM="+num
							);	
							System.out.println("\nThe Email address for Architect Id:"+num+"\nhas been Changed to: "+Update);
							System.out.println("Returning to main menu.\n");
				}
				else if(Field.equals("2")) {
					System.out.println("\nCHANGE PHYSICAL ADDRESS SELECTED");
					System.out.println("Please Enter the updated address:\n");
					Scanner e = new Scanner(System.in);
					String Update = e.nextLine();
					statement.executeUpdate (
							"UPDATE ARCHITECTS SET AR_ADDRESS='"+Update+"' WHERE AR_NUM="+num
							);	
							System.out.println("\nThe address for Architect Id:"+num+"\nhas been Changed to: "+Update);
							System.out.println("Returning to main menu.\n");
				}
			
		}
		else if(!Return.equalsIgnoreCase("menu")) {
			System.out.println("Exiting, Thank you.");
			System.exit(0);
	}
	}
	}
}

private static void newArchitect(Statement statement) throws SQLException {
	{
				System.out.println("\nADD NEW ARCHITECT SELECTED");
				System.out.println("Please enter the Architect's name:");
				Scanner a = new Scanner(System.in);
				String Ar_name = a.nextLine();
				
				System.out.println("Please enter the Architect's Phone number:");
				Scanner d = new Scanner(System.in);
				String Ar_num = d.nextLine();

				System.out.println("Please enter the Architect's Email address:");
				Scanner b = new Scanner(System.in);
				String Ar_email = b.nextLine();
				
				System.out.println("Please enter the Architect's Physical address:");
				Scanner c = new Scanner(System.in);
				String Ar_address = c.nextLine();
				statement.executeUpdate(
						"Insert into ARCHITECTS(AR_NAME, AR_PHONE, AR_EMAIL, AR_ADDRESS)"
						+"VALUES('"+Ar_name+ "', '"+Ar_num+"', '"+Ar_email+"', '"+Ar_address+"')"
						);
						System.out.println("\nThe following has been added to the database:");
						System.out.println("Architect Name:................"+Ar_name);
						System.out.println("Phone number:................."+Ar_num);
						System.out.println("Email Address:................"+Ar_email);
						System.out.println("Physical Address:............."+Ar_address);
						System.out.println("");
						System.out.println("Type 'Menu' to return to the main menu");
						Scanner l = new Scanner(System.in);
						String Return = l.nextLine();
						if(!Return.equalsIgnoreCase("menu")) {
							System.out.println("Exiting, Thank you.");
							System.exit(0);
		}
	}
}

private static void viewContractor(Statement statement) throws SQLException {
	{
		{
			{
				System.out.println("\nVIEW CONTRACTORS SELECTED");
				System.out.println("The following Contractors are currently in the data base:\n");
				printCo(statement);
				System.out.println("End of Contractors.");
				System.out.println("\nPlease enter:\n");
				System.out.println("Update	- to update any Contractors information");
				System.out.println("Menu	- to return to the main menu\n");		
				Scanner a = new Scanner(System.in);
				String Return = a.nextLine();
				if(Return.equalsIgnoreCase("Update")) {
					System.out.println("\nUPDATE CONTRACTOR SELECTED");
					System.out.println("Please Enter the ID of the contractor you would like to update:\n");
					Scanner b = new Scanner(System.in);
					int num = b.nextInt();
					System.out.println("\nPlease enter:\n");
					System.out.println("1  - To change the contractor's name");
					System.out.println("2  - To change the contractor's Email address");
					System.out.println("3  - To change the contractor's Physical address");
					Scanner c = new Scanner(System.in);
					String Field = c.nextLine();
					if(Field.equals("1")) {
						System.out.println("\nCHANGE CONTRACTOR NAME SELECTED");
						System.out.println("Please Enter the updated name:\n");
						Scanner d = new Scanner(System.in);
						String Update = d.nextLine();
						statement.executeUpdate (
								"UPDATE CONTRACTORS SET CO_NAME='"+Update+"' WHERE CO_NUM="+num
								);	
								System.out.println("\nThe Name for Contractor Id:"+num+"\nhas been Changed to: "+Update);
								System.out.println("Returning to main menu.\n");
					}
					else if(Field.equals("2")) {
						System.out.println("\nCHANGE EMAIL ADDRESS SELECTED");
						System.out.println("Please Enter the updated email address:\n");
						Scanner e = new Scanner(System.in);
						String Update = e.nextLine();
						statement.executeUpdate (
								"UPDATE CONTRACTORS SET CO_EMAIL='"+Update+"' WHERE CO_NUM="+num
								);	
								System.out.println("\nThe Email address for Contractor Id:"+num+"\nhas been Changed to: "+Update);
								System.out.println("Returning to main menu.\n");
					}
					else if(Field.equals("2")) {
						System.out.println("\nCHANGE PHYSICAL ADDRESS SELECTED");
						System.out.println("Please Enter the updated address:\n");
						Scanner e = new Scanner(System.in);
						String Update = e.nextLine();
						statement.executeUpdate (
								"UPDATE CONTRACTORS SET CO_ADDRESS='"+Update+"' WHERE CO_NUM="+num
								);	
								System.out.println("\nThe address for Contractor Id:"+num+"\nhas been Changed to: "+Update);
								System.out.println("Returning to main menu.\n");
					}
				
			}
			else if(!Return.equalsIgnoreCase("menu")) {
				System.out.println("Exiting, Thank you.");
				System.exit(0);
		}
		}
		}
	}
}

private static void newContractor(Statement statement) throws SQLException {
	{
			System.out.println("\nADD NEW CONTRACTOR SELECTED");
			System.out.println("Please enter the Contractor's name:");
			Scanner a = new Scanner(System.in);
			String Co_name = a.nextLine();
			
			System.out.println("Please enter the Contractor's Phone number:");
			Scanner d = new Scanner(System.in);
			String Co_num = d.nextLine();

			System.out.println("Please enter the Contractor's Email address:");
			Scanner b = new Scanner(System.in);
			String Co_email = b.nextLine();
			
			System.out.println("Please enter the Contractor's Physical address:");
			Scanner c = new Scanner(System.in);
			String Co_address = c.nextLine();
			statement.executeUpdate(
					"Insert into CONTRACTORS(CO_NAME, CO_PHONE, CO_EMAIL, CO_ADDRESS)"
					+"VALUES('"+Co_name+ "', '"+Co_num+"', '"+Co_email+"', '"+Co_address+"')"
					);
					System.out.println("\nThe following has been added to the database:");
					System.out.println("Contractor Name:................"+Co_name);
					System.out.println("Phone number:................."+Co_num);
					System.out.println("Email Address:................"+Co_email);
					System.out.println("Physical Address:............."+Co_address);
					System.out.println("");
					System.out.println("Type 'Menu' to return to the main menu");
					Scanner l = new Scanner(System.in);
					String Return = l.nextLine();
					if(!Return.equalsIgnoreCase("menu")) {
						System.out.println("Exiting, Thank you.");
						System.exit(0);
	}
}
}

private static void finalise(Statement statement) throws SQLException {
	{
		System.out.println("\nFINALISE PROJECT SELECTED");
		System.out.println("Please type the project ID you would like to finalise: ");
		Scanner a = new Scanner(System.in);
		int Project_id = a.nextInt();
		ResultSet results = statement.executeQuery("SELECT PRO_NAME, BUILDING, ADDRESS, ERF, PRICE, PAID, DEADLINE, ARCHITECT, CONTRACTOR, CUSTOMER FROM TASKS WHERE PRO_NUM="+Project_id);
		while(results.next()) {
			if(results.getInt("PRICE")-results.getInt("PAID") != 0) {
				ResultSet results1 = statement.executeQuery("SELECT * FROM CUSTOMERS WHERE CU_NAME ='"+results.getString("CUSTOMER")+"'");
				System.out.println("\nCUSTOMER INVOICE\n");
				while(results1.next()) {
				System.out.println(
				"Customer ID:.............."+ results1.getInt("CU_NUM") + "\n" +
				"Name:....................."+ results1.getString("CU_NAME") + "\n" +
				"Phone number:............."+ results1.getString("CU_PHONE") + "\n" +
				"Email Address:............"+ results1.getString("CU_EMAIL") + "\n" +
				"Physical Address:........."+ results1.getString("CU_ADDRESS"));
				ResultSet results3 = statement.executeQuery("SELECT PRO_NAME, BUILDING, ADDRESS, ERF, PRICE, PAID, DEADLINE, ARCHITECT, CONTRACTOR, CUSTOMER FROM TASKS WHERE PRO_NUM="+Project_id);
				while(results3.next()) {
				System.out.println("Total amount charged:.....R"+results3.getInt("PRICE"));
				System.out.println("Total amount paid:........R"+results3.getInt("PAID"));
				System.out.println("Total amount owed:........R"+(results3.getInt("PRICE")-results3.getInt("PAID")));
				System.out.println("");
				System.out.println("End of invoice.");
				System.out.println("Type 'Menu' to return to the main menu");
				Scanner l = new Scanner(System.in);
				String Return = l.nextLine();
				if(!Return.equalsIgnoreCase("menu")) {
					System.out.println("Exiting, Thank you.");
					System.exit(0);
				}
				}
			}
			}
		else {
			statement.executeUpdate("Insert into FINALISED(PRO_NAME, BUILDING, ADDRESS, ERF, ARCHITECT, CONTRACTOR, CUSTOMER, DATE)"
					+"VALUES('"+results.getString("PRO_NAME")+ "', '"+results.getString("BUILDING")+"', '"+results.getString("ADDRESS")+ "', '"+results.getString("ERF")+"', '"
					+results.getString("ARCHITECT")+"', '"+results.getString("CONTRACTOR")+"' ,'"+results.getString("CUSTOMER")+"', CURDATE())"
					);
			statement.executeUpdate("DELETE FROM TASKS WHERE PRO_NUM="+Project_id);
			System.out.println("\nProject Id"+Project_id+ "has been moved to Finalized table and marked as completed");
			System.out.println("");
			System.out.println("Type 'Menu' to return to the main menu");
			Scanner l = new Scanner(System.in);
			String Return = l.nextLine();
			if(!Return.equalsIgnoreCase("menu")) {
				System.out.println("Exiting, Thank you.");
				System.exit(0);
}
}
}
}
}

public static void printTasks (Statement statement) throws
SQLException {
	ResultSet results = statement.executeQuery( "SELECT PRO_NUM, PRO_NAME, BUILDING, ADDRESS, ERF, PRICE, PAID, DEADLINE, ARCHITECT, CONTRACTOR, CUSTOMER FROM TASKS" );
	while(results.next()) {
		System.out.println(
		"Project Number:..................."+ results.getInt("PRO_NUM") + "\n" +
		"Project Name:....................."+ results.getString("PRO_NAME") + "\n" +
		"Type of Building:................."+ results.getString("BUILDING") + "\n" +
		"Physical Address:................."+ results.getString("ADDRESS") + "\n" +
		"ERF Number:......................."+ results.getString("ERF") + "\n" +
		"Total Amount Charged:.............R"+ results.getString("PRICE") + "\n" +
		"Total Amount Paid to date:........R"+ results.getString("PAID") + "\n" +
		"Deadline set for this Project:...."+ results.getString("DEADLINE") + "\n" +
		"Architect assigned:..............."+ results.getString("ARCHITECT") + "\n" +
		"Contractor assigned:.............."+ results.getString("CONTRACTOR") + "\n" +
		"Customer listed:.................."+ results.getString("CUSTOMER") + "\n");
		}
	}

public static void printCu(Statement statement) throws
SQLException {
	ResultSet results = statement.executeQuery( "SELECT CU_NUM, CU_NAME, CU_PHONE, CU_EMAIL, CU_ADDRESS FROM CUSTOMERS" );
	while(results.next()) {
		System.out.println(
		"Customer ID:.............."+ results.getInt("CU_NUM") + "\n" +
		"Name:....................."+ results.getString("CU_NAME") + "\n" +
		"Phone number:............."+ results.getString("CU_PHONE") + "\n" +
		"Email Address:............"+ results.getString("CU_EMAIL") + "\n" +
		"Physical Address:........."+ results.getString("CU_ADDRESS") + "\n");
		}
	}

public static void printCo(Statement statement) throws
SQLException {
	ResultSet results = statement.executeQuery( "SELECT CO_NUM, CO_NAME, CO_PHONE, CO_EMAIL, CO_ADDRESS FROM CONTRACTORS" );
	while(results.next()) {
		System.out.println(
		"Customer ID:.............."+ results.getInt("CO_NUM") + "\n" +
		"Name:....................."+ results.getString("CO_NAME") + "\n" +
		"Phone number:............."+ results.getString("CO_PHONE") + "\n" +
		"Email Address:............"+ results.getString("CO_EMAIL") + "\n" +
		"Physical Address:........."+ results.getString("CO_ADDRESS") + "\n");
		}
	}

public static void printAr(Statement statement) throws
SQLException {
	ResultSet results = statement.executeQuery( "SELECT AR_NUM, AR_NAME, AR_PHONE, AR_EMAIL, AR_ADDRESS FROM ARCHITECTS" );
	while(results.next()) {
		System.out.println(
		"Customer ID:.............."+ results.getInt("AR_NUM") + "\n" +
		"Name:....................."+ results.getString("AR_NAME") + "\n" +
		"Phone number:............."+ results.getString("AR_PHONE") + "\n" +
		"Email Address:............"+ results.getString("AR_EMAIL") + "\n" +
		"Physical Address:........."+ results.getString("AR_ADDRESS") + "\n");
		}
	}

public static void printF(Statement statement) throws
SQLException {
	ResultSet results = statement.executeQuery(" SELECT PRO_NAME, BUILDING, ADDRESS, ERF, ARCHITECT, CONTRACTOR, CUSTOMER, DATE FROM FINALISED" );
	while(results.next()) {
		System.out.println(
		"Project Name:......................."+ results.getString("PRO_NAME") + "\n" +
		"Type of building:..................."+ results.getString("BUILDING") + "\n" +
		"Address:............................"+ results.getString("ADDRESS") + "\n" +
		"ERF number:........................."+ results.getInt("ERF") + "\n" +
		"Architect assigned to Project:......"+ results.getString("ARCHITECT") + "\n" +
		"Contractor assigned to Project:....."+ results.getString("CONTRACTOR") + "\n" +
		"Customer assigned to Project:......."+ results.getString("CUSTOMER") + "\n" +
		"Project completion Date:............"+ results.getString("DATE") + "\n");
		}
	}
}
