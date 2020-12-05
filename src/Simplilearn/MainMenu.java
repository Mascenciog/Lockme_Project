package Simplilearn;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class MainMenu {
	 public static void main(String args[]) throws IOException
	  {
	    Scanner localScanner = new Scanner(System.in);
	    String str1 = "";
	    
	    String str2 = "";
	    
	    do
	    {
	      System.out.println("*** Welcome To File Management System ***");	
	      System.out.println("**********************************************");
	      System.out.println("1. View all Files in the Application");	
	      System.out.println("2. To view more options");
	      System.out.println("3. Close the Application");
	      System.out.println("**********************************************");
	      System.out.println("Please enter your choice:");
	      str1 = localScanner.next();
	        

	      localScanner = new Scanner(System.in);
	      String str4; Object localObject;
	      switch (str1) {
	      
	      	case "1":
	      		str4 ="./user/";
	            if (str4.isEmpty())
	            {
	              System.out.println("\nInvalid input..!\n");

	            }
	            else
	            {
	              localObject = new File(str4);
	              FileUtility.viewDirectory((File)localObject);
	            }
	            break;
	      
	      	case "2":
	     
	      		do {
	      	      System.out.println("1. Create file");
	      	      System.out.println("2. Search file");
	      	      System.out.println("3. Delete file");
	      	      System.out.println("4. Return to MainContext");
	              System.out.println("Please enter your choice:");
	              str2  = localScanner.next();
	              String str3="";
	              Scanner s = new Scanner(System.in);
	              switch(str2) {
			            case "1": 
			            System.out.println("Enter the file path where you want to create the file ");
			             str3 = s.nextLine();
			            System.out.println(str3);
			            if (str3.isEmpty())
			            {
			              System.out.println("\nInvalid input..!\n");
			            }
			            else
			            {
			            	str3="./user/"+str3;	
			              System.out.println("Enter the content :");
			              str4 = s.nextLine();
			              FileUtility.createFile(str3, str4);
			            }
			            
			            break;
			          
			    
			          case "2": 
			            System.out.println("Enter the path of the file where you want to search ");
			            str3 = s.nextLine();
			            if (str3.isEmpty())
			            {
			              System.out.println("\nInvalid input..!\n");
			            }
			            else
			            {
			            str3="./user/"+str3;
			              FileUtility.search(str3, str3);
			            }
			            break;
			          
			          case "3": 
			            System.out.println("Enter the path of the file which you want to delete ");
			            str3 = s.nextLine();
			          
			            if (str3.isEmpty())
			            {
			              System.out.println("\nInvalid input..!\n");
			            }
			            else
			            {
			            	str3="./user/"+str3;
			              FileUtility.deleteFile(str3);
			            }
			            break;
			          case "4":
			        	System.out.println("Welcome back to Main Context!");  
			        	break;
			          default: 
			              System.out.print("\nInvalid Choice\n ");
	              }
	      			
	      		}while(str2.compareTo("4")!=0);
	      		break;
	      	case "3": 
	      		System.out.println("Thanks for using the Application!");
	            break;
	         
	        default: 
	            System.out.print("\nInvalid Choice\n ");
	      }
	      }while(str1.compareTo("3")!=0);
	    
	    }

}
