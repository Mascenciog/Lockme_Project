package Simplilearn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtility {
	public static void createFile(String paramString1, String paramString2)
		    throws IOException
		  {
		    try
		    {
		      File localFile = new File(paramString1);
		      
		      if (!localFile.exists())
		      {
		        localFile.createNewFile();
		      }
		      
		      FileWriter localFileWriter = new FileWriter(paramString1);
		      BufferedWriter localBufferedWriter = new BufferedWriter(localFileWriter);
		      localBufferedWriter.write(paramString2);
		      localBufferedWriter.flush();
		      localBufferedWriter.close();
		      
		      System.out.println("\nFile " + paramString1 + " has been created successfully..!\n");

		    }
		    catch (IOException localIOException)
		    {
		      localIOException.printStackTrace();
		    }
		  }
		  
		  public static void search(String paramString1, String paramString2)
		  {
		    File localFile1 = new File(paramString1);
		    
		    if (localFile1.isFile())
		    {
		      String str = localFile1.getParent();
		      File localFile2 = new File(str + "\\" + paramString2);
		      if (localFile1.renameTo(localFile2))
		      {
		        System.out.println("\n File Found..!\n");
		      }
		      else
		      {
		    	  System.out.println("\n File Found..!\n");
		      }
		    }
		    else
		    {
		      System.out.println("\nFile not found\n");
		    }
		  }
		  
		  public static void deleteFile(String paramString)
		  {
		    File localFile = new File(paramString);
		    
		    if (localFile.isFile())
		    {
		      if (localFile.delete())
		      {
		        System.out.println("\nFile successfully deleted..!\n");
		      }
		      else
		      {
		        System.out.println("\nThere is some issue deleting the file\n");
		      }
		      
		    }
		    else {
		      System.out.println("\nFile not found\n");
		    }
		  }
		  
		  public static void createDirectory(String paramString)
		  {
		    File localFile = new File(paramString);
		    if (localFile.exists())
		    {
		      System.out.println("\nDirectory already exists\n");
		    }
		    else
		    {
		      localFile.mkdirs();
		      System.out.println("\nDirectory created successfully..!\n");
		    }
		  }
		  
		  public static void reNameDirectory(String paramString1, String paramString2)
		  {
		    File localFile1 = new File(paramString1);
		    if (localFile1.isDirectory())
		    {
		      if (localFile1.exists())
		      {
		        String str = localFile1.getParent();
		        File localFile2 = new File(str + "\\" + paramString2);
		        if (!localFile2.exists())
		        {
		          localFile1.renameTo(localFile2);
		          System.out.println("\nDirectory renamed successfully..!\n");

		        }
		        else
		        {
		          System.out.println("\nDirectory already exists..!\n");
		        }
		        
		      }
		      else
		      {
		        System.out.println("\nDirectory does not exists..!\n");
		      }
		      
		    }
		    else {
		      System.out.println("\nInvalid Directory..!\n");
		    }
		  }
		  
		  public static int deleteDirectory(File paramFile)
		  {
		    if (paramFile.isDirectory())
		    {
		      File[] arrayOfFile1 = paramFile.listFiles();
		      if (arrayOfFile1 != null)
		      {
		        for (File localFile : arrayOfFile1)
		        {
		          int k = deleteDirectory(localFile);
		        }
		      }
		      paramFile.delete();
		      System.out.println("\n\n");
		    }
		    else
		    {
		      System.out.println("\nInvalid Directory..!\n");
		    }
		    return 1;
		  }
		  
		  public static void viewDirectory(File paramFile)
		  {
		    if (paramFile.isDirectory())
		    {
		      File[] arrayOfFile1 = paramFile.listFiles();
		      System.out.println("Directory Name: " + paramFile.getName());
		      if(arrayOfFile1.length==0) {
		    	  System.out.println("No fill added to the Application so far.\n\n");
		    	  return;
		      }
		      if (arrayOfFile1 != null)
		      {
		    	 ArrayList<String> files = new ArrayList<String>();
		        for (File localFile : arrayOfFile1)
		        {
		        	files.add(localFile.getName());
		        //  System.out.println("\t->" + localFile.getName());
		        }
		        for (String f : files) {
		        	   System.out.println("\t->" + f);
		        }       	
		        System.out.println("\n");
		      }
		      else
		      {
		        System.out.println("\nNo Sub-Folders..!\n");
		      }
		    }
		    else
		    {
		      System.out.println("\nInvalid Directory..!\n");
		    }
		  }
		  
		  public static void copyFile(String paramString)
		    throws IOException
		  {
		    File localFile1 = new File(paramString + ".txt");
		    if ((localFile1.isFile()) && (localFile1.exists()))
		    {
		      File localFile2 = new File(paramString + " - Copy.txt");
		      localFile2.createNewFile();
		      
		      FileWriter localFileWriter = new FileWriter(localFile2);
		      FileReader localFileReader = new FileReader(localFile1);
		      try
		      {
		        int i;
		        while ((i = localFileReader.read()) != -1)
		        {
		          localFileWriter.write(i);
		        }
		        localFileReader.close();
		        localFileWriter.close();
		      }
		      catch (Exception localException)
		      {
		        System.out.println(localException);
		      }
		      System.out.println("\nFile copied successfully..!\n");
		    }
		    else
		    {
		      System.out.println("\nInvalid File..!\n");
		    }
		  }
		  
		  public static void copyDirectory(String paramString1, String paramString2) throws IOException
		  {
		    File localFile1 = new File(paramString1);
		    File localFile2 = new File(paramString2 + "(COPY)");
		    localFile2.mkdir();
		    File[] arrayOfFile = localFile1.listFiles();
		    
		    for (int i = 0; i < arrayOfFile.length; i++)
		    {
		      File localFile3 = new File(paramString2 + "(COPY)\\" + arrayOfFile[i].getName());
		      localFile3.createNewFile();
		      
		      FileWriter localFileWriter = new FileWriter(localFile3);
		      FileReader localFileReader = new FileReader(arrayOfFile[i]);
		      
		      try
		      {
		        while ((i = localFileReader.read()) != -1)
		        {
		          localFileWriter.write(i);
		        }
		        localFileReader.close();
		        localFileWriter.close();
		      }
		      catch (Exception localException)
		      {
		        System.out.println(localException);
		      }
		    }
		    

		    System.out.println("\nFolder copied successfully..!\n");
		  }
		  

}
