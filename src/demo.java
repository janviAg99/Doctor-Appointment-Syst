import java.sql.*;
import java.util.Scanner;

public class demo {
	public static void clearscreen() throws Exception{
	    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
	}
    public static void addcustomer() throws Exception
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.print("\t\t\t\t  Enter Customer id:-");
        System.out.print("\t\t\t\t");
		String c_id=sc.nextLine();
		System.out.println("\t\t\t\t Enter Customer name:-");
		System.out.println("\t\t\t\t");
		String c_name= sc.nextLine();
		System.out.println("\t\t\t\t Enter Customer Contact:-");
		System.out.println("\t\t\t\t");
		String c_contact=sc.nextLine();
		System.out.println("\t\t\t\t Enter Customer Address:-");
		System.out.println("\t\t\t\t");
		String c_Address=sc.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/demo", "root","root");
		Statement st=con.createStatement();
		String insertQuery="insert into cust "
				+ "values('"+c_id+"','"+c_name+"','"+c_contact+"','"+c_Address+"')";
		int res=st.executeUpdate(insertQuery);
		
		if(res == 0) {
			System.out.println("\t\t\t\tRecored not inserted");
		}else {
			System.out.println("\t\t\t\tRecored inserted succesfully");
		}
		st.close();
		con.close();
    }
    
    public static void deletecustomer() throws Exception
    {
    	Scanner t=new Scanner(System.in);
    	System.out.print("\t\t\t\t  Enter Customer id:-");
        System.out.print("\t\t\t\t");
		String id=t.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/demo", "root","root");
		String insertQuery="delete from cust where c_id =?";
		PreparedStatement st=con.prepareStatement(insertQuery);
         st.setString(1, id);
		int res=st.executeUpdate();
		if(res == 0) {
			System.out.println("\t\t\t\tRecord not deleted");
		}else {
			System.out.println("\t\t\t\tRecord deleted");
		}
		st.close();
		con.close();
    }
    public static void modifycust() throws Exception
    {
    	Scanner dt=new Scanner(System.in);
    	System.out.println("\t\t\t\t1. Customer Name");
        System.out.println("\t\t\t\t2. Customer Contact");
        System.out.println("\t\t\t\t3. Address");
        System.out.println("\t\t\t\t0. Exit");	
        String gt=dt.nextLine();
        if(gt.equals("1"))
        {
        	System.out.print("\t\t\t\t  Enter Customer id:-");
            System.out.print("\t\t\t\t");
    		String c_id=dt.nextLine();
    		System.out.println("\t\t\t\t Enter Customer name:-");
    		System.out.println("\t\t\t\t");
    		String c_name= dt.nextLine();
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con=DriverManager.getConnection
    				("jdbc:mysql://localhost:3306/demo", "root","root");
    		String insertQuery="update cust set c_name=? where c_id =?";
    		PreparedStatement st=con.prepareStatement(insertQuery);
             st.setString(1, c_name);
             st.setString(2, c_id);
    		int res=st.executeUpdate();
    		if(res==1)
    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
    		else
    			System.out.print("\t\t\t\t Row not Updated!");

    		st.close();
    		con.close();
        }
        else if(gt.equals("3"))
        {
        	System.out.print("\t\t\t\t  Enter Customer id:-");
            System.out.print("\t\t\t\t");
    		String c_id=dt.nextLine();
    		System.out.println("\t\t\t\t Enter Customer Address:-");
    		System.out.println("\t\t\t\t");
    		String c_name= dt.nextLine();
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con=DriverManager.getConnection
    				("jdbc:mysql://localhost:3306/demo", "root","root");
    		String insertQuery="update cust set c_Address=? where c_id =?";
    		PreparedStatement st=con.prepareStatement(insertQuery);
             st.setString(1, c_name);
             st.setString(2, c_id);
    		int res=st.executeUpdate();
    		if(res==1)
    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
    		else
    			System.out.print("\t\t\t\t Row not Updated!");

    		st.close();
    		con.close();
        }
        else if(gt.equals("2"))
        {
        	System.out.print("\t\t\t\t  Enter Customer id:-");
            System.out.print("\t\t\t\t");
    		String c_id=dt.nextLine();
    		System.out.println("\t\t\t\t Enter Customer Contact:-");
    		System.out.println("\t\t\t\t");
    		String c_name= dt.nextLine();
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con=DriverManager.getConnection
    				("jdbc:mysql://localhost:3306/demo", "root","root");
    		String insertQuery="update cust set c_contact=? where c_id =?";
    		PreparedStatement st=con.prepareStatement(insertQuery);
             st.setString(1, c_name);
             st.setString(2, c_id);
    		int res=st.executeUpdate();
    		if(res==1)
    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
    		else
    			System.out.print("\t\t\t\t Row not Updated!");

    		st.close();
    		con.close();
        }
        else if(gt.equals("0"))
        {
        	System.out.println("Thankyou!!!!"); 
        }
        else
        {
        	System.out.println("Wrong Entry Re-run The Application");
        }
        
    }
    public static void viewcustomer() throws Exception
    {
    	

    	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/demo", "root","root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from cust");
		while(rs.next())
		{
			System.out.println("\t\t\t\t");
			System.out.println("\t\t\t\tID:-"+rs.getString("c_id")+" "+
			"Name:-"+rs.getString("c_name")+" "+"Contact:-"+rs.getString("c_contact")
			+" "+"Address:-"+rs.getString("c_Address"));
		}
		st.close();
		con.close();
    }
    public static void addappointment() throws Exception
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.print("\t\t\t\t  Enter Appointment id:-");
        System.out.print("\t\t\t\t");
		String c_id=sc.nextLine();
		System.out.println("\t\t\t\t Enter Pateint name:-");
		System.out.println("\t\t\t\t");
		String c_name= sc.nextLine();
		System.out.println("\t\t\t\t Enter  Contact:-");
		System.out.println("\t\t\t\t");
		String c_contact=sc.nextLine();
		System.out.println("\t\t\t\t Enter Age:-");
		System.out.println("\t\t\t\t");
		String c_age=sc.nextLine();
		System.out.println("\t\t\t\t Enter Doctor name:-");
		System.out.println("\t\t\t\t");
		String dname=sc.nextLine();
		System.out.println("\t\t\t\t Enter Time of Appointment:-");
		System.out.println("\t\t\t\t");
		String c_tm=sc.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/demo", "root","root");
		Statement st=con.createStatement();
		String insertQuery="insert into appoint "
				+ "values('"+c_id+"','"+c_name+"','"+c_contact+"','"+c_age+"','"+dname+"','"+c_tm+"')";
		int res=st.executeUpdate(insertQuery);
		
		if(res == 0) {
			System.out.println("\t\t\t\tRecored not inserted");
		}else {
			System.out.println("\t\t\t\tRecored inserted succesfully");
		}
		st.close();
		con.close();
    }
    public static void deleteappointment() throws Exception
    {
    	Scanner t=new Scanner(System.in);
    	System.out.print("\t\t\t\t  Enter Appointment id:-");
        System.out.print("\t\t\t\t");
		String id=t.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/demo", "root","root");
		String insertQuery="delete from appoint where c_id =?";
		PreparedStatement st=con.prepareStatement(insertQuery);
         st.setString(1, id);
		int res=st.executeUpdate();
		if(res == 0) {
			System.out.println("\t\t\t\tRecord not deleted");
		}else {
			System.out.println("\t\t\t\tRecord deleted");
		}
		st.close();
		con.close();
    }
    public static void modifyappointment() throws Exception
    {
    	Scanner dt=new Scanner(System.in);
    	System.out.println("\t\t\t\t1. Customer Age");
        System.out.println("\t\t\t\t2. Customer Contact");
        System.out.println("\t\t\t\t3. Doctor Name");
        System.out.println("\t\t\t\t4. Appointment Time");
        System.out.println("\t\t\t\t0. Exit");	
        String gt=dt.nextLine();
        if(gt.equals("1"))
        {
        	System.out.print("\t\t\t\t  Enter Appointment id:-");
            System.out.print("\t\t\t\t");
    		String c_id=dt.nextLine();
    		System.out.println("\t\t\t\t Enter Customer Age:-");
    		System.out.println("\t\t\t\t");
    		String c_age= dt.nextLine();
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con=DriverManager.getConnection
    				("jdbc:mysql://localhost:3306/demo", "root","root");
    		String insertQuery="update appoint set c_Age=? where c_id =?";
    		PreparedStatement st=con.prepareStatement(insertQuery);
             st.setString(1, c_age);
             st.setString(2, c_id);
    		int res=st.executeUpdate();
    		if(res==1)
    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
    		else
    			System.out.print("\t\t\t\t Row not Updated!");

    		st.close();
    		con.close();
        }
        else if(gt.equals("3"))
        {
        	System.out.print("\t\t\t\t  Enter Customer id:-");
            System.out.print("\t\t\t\t");
    		String c_id=dt.nextLine();
    		System.out.println("\t\t\t\t Enter Doctor Name:-");
    		System.out.println("\t\t\t\t");
    		String dname= dt.nextLine();
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con=DriverManager.getConnection
    				("jdbc:mysql://localhost:3306/demo", "root","root");
    		String insertQuery="update appoint set dnames=? where c_id =?";
    		PreparedStatement st=con.prepareStatement(insertQuery);
             st.setString(1, dname);
             st.setString(2, c_id);
    		int res=st.executeUpdate();
    		if(res==1)
    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
    		else
    			System.out.print("\t\t\t\t Row not Updated!");

    		st.close();
    		con.close();
        }
        else if(gt.equals("2"))
        {
        	System.out.print("\t\t\t\t  Enter Customer id:-");
            System.out.print("\t\t\t\t");
    		String c_id=dt.nextLine();
    		System.out.println("\t\t\t\t Enter Customer Contact:-");
    		System.out.println("\t\t\t\t");
    		String c_name= dt.nextLine();
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con=DriverManager.getConnection
    				("jdbc:mysql://localhost:3306/demo", "root","root");
    		String insertQuery="update appoint set c_contact=? where c_id =?";
    		PreparedStatement st=con.prepareStatement(insertQuery);
             st.setString(1, c_name);
             st.setString(2, c_id);
    		int res=st.executeUpdate();
    		if(res==1)
    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
    		else
    			System.out.print("\t\t\t\t Row not Updated!");

    		st.close();
    		con.close();
        }
        else if(gt.equals("4"))
        {
        	System.out.print("\t\t\t\t  Enter Customer id:-");
            System.out.print("\t\t\t\t");
    		String c_id=dt.nextLine();
    		System.out.println("\t\t\t\t Enter New Appointment Time:-");
    		System.out.println("\t\t\t\t");
    		String dname= dt.nextLine();
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con=DriverManager.getConnection
    				("jdbc:mysql://localhost:3306/demo", "root","root");
    		String insertQuery="update appoint set c_tm=? where c_id =?";
    		PreparedStatement st=con.prepareStatement(insertQuery);
             st.setString(1, dname);
             st.setString(2, c_id);
    		int res=st.executeUpdate();
    		if(res==1)
    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
    		else
    			System.out.print("\t\t\t\t Row not Updated!");

    		st.close();
    		con.close();
        }
        else if(gt.equals("0"))
        {
        	System.out.println("Thankyou!!!!"); 
        }
        else
        {
        	System.out.println("Wrong Entry Re-run The Application");
        }
    }
    public static void viewappointment() throws Exception
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/demo", "root","root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from appoint");
		while(rs.next())
		{
			System.out.println("\t\t\t\t");
			System.out.println("\t\t\t\tID:-"+rs.getString("c_id")+" "+
			"Name:-"+rs.getString("c_name")+" "+"Contact:-"+rs.getString("c_contact")
			+" "+"Age:-"+rs.getString("c_age")+" Doctor Name :-"+rs.getString("dname")+" Time:-"+rs.getString("c_tm"));
		}
		st.close();
		con.close();
    }
    public static void docdet() throws Exception
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/demo", "root","root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from doc");
		int i=1;
		while(rs.next())
		{
            System.out.println("\t\t\t\t------------------------------------------");
			System.out.println("\t\t\t\t DOCTOR - "+i);
            System.out.println("\t\t\t\t------------------------------------------");
			System.out.println("\t\t\t\t DOCTOR'S ID :- "+rs.getString("d_id")+" ");
			System.out.println("\t\t\t\t DOCTOR'S NAME :- "+rs.getString("d_name")+" ");
			System.out.println("\t\t\t\t DOCTOR'S SPECIFICATION :- "+rs.getString("d_spec")+" ");
			System.out.println("\t\t\t\t DOCTOR'S TIMINGS :- "+rs.getString("d_tim")+" ");
			System.out.println("\t\t\t\t DOCTOR'S CONTACT :- "+rs.getString("d_contact")+" ");
			System.out.println("\t\t\t\t DOCTOR'S CABIN ADDRESS :- "+rs.getString("d_add")+" ");
			i++;
            System.out.println("\t\t\t\t------------------------------------------");
            System.out.println();
		}
		st.close();
		con.close();
    }
	public static void main(String[] args) throws Exception {
		Scanner st=new Scanner(System.in);
		int ch;
		int flag=1;
		while(flag==1)
		{
			clearscreen();
			System.out.print("\n\n\n\n\n");
            System.out.println("\t\t\t\t------------------------------------------");
            System.out.println("\t\t\t\tWELCOME TO DOCTOR APPOINTMENT BOOKING SYSTEM");
            System.out.println("\t\t\t\t------------------------------------------");
            System.out.println("\t\t\t\t1. Customer Panel");
            System.out.println("\t\t\t\t2. Doctor Panel");
            System.out.println("\t\t\t\t3. Appointment Panel");
            System.out.println("\t\t\t\t0. Exit");
            System.out.println("\t\t\t\t------------------------------------------");
            System.out.println("\t\t\t\tEnter your Choice...:");
            System.out.print("\t\t\t\t");
            ch=st.nextInt();
            if(ch==0)
             {
            	flag=0;
            	clearscreen();
                System.out.print("\n\n\n\n\n\n");
                System.out.println("\t\t\t\t\t--------------------------------------------");
                System.out.println("\t\t\t\t\t\tTHANK YOU FOR USING ........!!!!");
            }
            else if(ch==1)
            {
            	int ch1;
            	int flag1=1;
                while(flag1==1)
                {
                    clearscreen();
                    System.out.print("\n\n\n\n");
                    System.out.println("\t\t\t\t------------------------------------------");
                    System.out.println("\t\t\t\tWELCOME TO DOCTOR APPOINTMENT BOOKING SYSTEM");
                    System.out.println("\t\t\t\t------------------------------------------");
                    System.out.println("\t\t\t\tCUSTOMER MENU....");
                    System.out.println();
                    System.out.println("\t\t\t\t1. REGISTER CUSTOMER");
                    System.out.println("\t\t\t\t2. MODIFY CUSTOMER DETAILS");
                    System.out.println("\t\t\t\t3. DELETE CUSTOMER REGISTRATION");
                    System.out.println("\t\t\t\t4. VIEW CUSTOMER REGISTRATION");
                    System.out.println("\t\t\t\t5. Back");
                    System.out.println("\t\t\t\t0. Exit");
                    System.out.println("\t\t\t\t------------------------------------------");
                    System.out.println("\t\t\t\tEnter your Choice...:");
                    System.out.print("\t\t\t\t");
                    ch1=st.nextInt();
                    if(ch1==5)
                    { 
                    	clearscreen();
                    	flag1=0;
                    }
                    else if(ch1==1)
                    {
                    	addcustomer();
                    	
                    }
                    else if(ch1==4)
                    {
                    	viewcustomer();
                    }
                    else if(ch1==3)
                    {
                    	deletecustomer();
                    }
                    else if(ch1==2)
                    {
                    	modifycust();
                    }
                    else if(ch1==0)
                    	{
                    	   System.exit(0);
                    	}
                    else 
                    {
                    	 clearscreen();
                         System.out.println("\n\n\n\n\t\t\t\t------------------------");
                         System.out.println("\t\t\t\tEnter a VALID CHOICE....");
                         System.out.println("\t\t\t\t------------------------");
                         clearscreen();
                    }
                }
            }
            else if(ch==2)
            {
            	docdet();
            }
            else if(ch==3)
            {
            	int ch2;
            	int flag1=1;
                while(flag1==1)
                {
                    clearscreen();
                    System.out.print("\n\n\n\n");
                    System.out.println("\t\t\t\t------------------------------------------");
                    System.out.println("\t\t\t\tWELCOME TO DOCTOR APPOINTMENT BOOKING SYSTEM");
                    System.out.println("\t\t\t\t------------------------------------------");
                    System.out.println("\t\t\t\tAPPOINTMENT MENU....");
                    System.out.println();
                    System.out.println("\t\t\t\t1. REGISTER APPOINTMENT");
                    System.out.println("\t\t\t\t2. MODIFY APPOINTMENT DETAILS");
                    System.out.println("\t\t\t\t3. DELETE APPOINTMENT");
                    System.out.println("\t\t\t\t4. VIEW APPOINTMENT DETAILS");
                    System.out.println("\t\t\t\t5. Back");
                    System.out.println("\t\t\t\t0. Exit");
                    System.out.println("\t\t\t\t------------------------------------------");
                    System.out.println("\t\t\t\tEnter your Choice...:");
                    System.out.print("\t\t\t\t");
                    ch2=st.nextInt();
                    clearscreen();
                    if(ch2==5)
                    { 
                    	clearscreen();
                    	flag1=0;
                    }
                    else if(ch2==1)
                    {
                    	addappointment();
                    	
                    }
                    else if(ch2==4)
                    {
                    	viewappointment();
                    } 
                    else if(ch2==3)
                    {
                    	deleteappointment();
                    }
                    else if(ch2==2)
                    {
                    	modifyappointment();
                    }
                    else if(ch2==0)
                    	{
                    	   System.exit(0);
                    	}
                    else 
                    {
                    	 clearscreen();
                         System.out.println("\n\n\n\n\t\t\t\t------------------------");
                         System.out.println("\t\t\t\tEnter a VALID CHOICE....");
                         System.out.println("\t\t\t\t------------------------");
                         clearscreen();
                    }
                }
            }
            else
            {
            	 clearscreen();
                 System.out.println("\n\n\n\n\t\t\t\t------------------------");
                 System.out.println("\t\t\t\tEnter a VALID CHOICE....");
                 System.out.println("\t\t\t\t------------------------");
                 flag=0;
            }
		}
		

	}
}
