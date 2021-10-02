/**
* @author Sebastian Duenas Jr
* @written 03/25/2021
* @description: A java program that prompts the user
*               for an absolute path on a computer's
*               drive. The program also displays
*               the file structure in a nested format.
*    Algorithm: 
*     1). Prompt the user with input on a particular path.
*     2). Create a file object used to read the user's input
*     3). Create an if-else statement 
*           A). If the certain file object is a directory
*               then create an array that will be listed
*               in the object and move the object to a 
*               method called showDirectory.
*           B). If the certain file object is not a 
*               directory then print a statement that
*               informs the user that the particular
*               path is not in the drive.
*     4). Create a private method called showDirectory
*         that will accept an argument.
*           A). Generate a for loop that for each time
*               the array called fileArray is iterated
*           B). Inside the for-each loop, generate a
*               if-else statement.
*                 I). If the certain variable created
*                     from the for-each loop, which
*                     was produced by the user's file
*                     path response, exists then 
*                     recursion kicks in until their
*                     are no more directories inside
*                     of the file path.
*                II). If the certain variable does not
*                     have any more directories left
*                     then it will generate every file
*                     inside.
*           C). The end result of the method will produce
*               every file nested inside of their particular
*               directory. The output will also be indented
*               for each file inside of a directory using
*               the indent method. 
**/
import java.io.File;  // Needed for the file class
import java.util.Scanner; // Needed for the scanner class
public class FileDirectory
{
   public static void main (String [] args)
   {
      // Create a Scanner object to read input.
      Scanner sc = new Scanner(System.in);
      
      System.out.print("Enter file path: ");
      String promptFile = sc.nextLine();
   
      // Create a File object to read the particular input.
      File index = new File(promptFile);
      
      /* Determines whether the file path is a directory or not
         and if so, it will pass the file array that will hold
         several files
      */
      if(index.isDirectory())
      {
         File [] fileArray = index.listFiles();
         showDirectory(fileArray);
      } else {
         System.out.println("Their is no particular directory, please try again.");
      }
   }
   
   /**
   * The showDirectory method accepts an argument and determines
   * based on decision structure and recursion, if the certain
   * file is a directory or a file inside of folder. 
   *
   * @param fileArray   The user's file path response
   **/
   private static void showDirectory(File[] fileArray)
   {
      for(File file : fileArray)
      {
         if(file.isDirectory())
         {
            System.out.println(file.getName());
            showDirectory(file.listFiles());
         } else {
            String input = file.getName();
            String output = input.indent(1);
            System.out.print(output);
          }
       }
    }
}
    
      