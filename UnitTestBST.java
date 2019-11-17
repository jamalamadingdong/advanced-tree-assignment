/**************************
* AUTHOR: ONG MING HANG   *
* PROGRAM: UnitTestBST    *
* DATE: 13/05/2019        *
***************************/
import java.util.*;

public class UnitTestBST
{
    public static void main (String [] args)
    {
        long start, est;
        BinarySearchTree tree = null;
        String find = "", file = "";
        Object value;
        int passed = 0;
        int order;
        Scanner sc = new Scanner (System.in);
        System.out.println("Testing Binary-Tree\n==================================");
        //TEST 1: TESTING BINARY-TREE CONSTRUCTOR
        try
        {
            System.out.println("[Testing Binary-Tree File Insertion]");
            file = strInput("Enter the file:");
            System.out.print("Status: ");
            if(file.equals(null)||file.equals(""))
            {
                throw new IllegalArgumentException ("FAILED");
            }
            else
            {
                start = System.nanoTime();
                tree = new BinarySearchTree(file);
                est = (System.nanoTime() - start)/tree.getSize();
                System.out.println("passed");
                System.out.println("Average time for insertion per node: " + est + " nanoseconds");
                passed++;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());    
        }
        //TEST 2: TESTING BINARY-TREE INSERT METHOD
        try
        {
            System.out.println("[Testing Binary-Tree insert()]");
            start = System.nanoTime();
            String key = "ZZZ";
            StockClass stock = new StockClass ("ZZZ", 20190218, 0.095, 0.005, 0.67, 0.69, 420);
            System.out.print("Status: ");
            if(tree == null)
            {
                throw new IllegalArgumentException ("FAILED"); 
            }
            else
            {
                tree.insert(key, stock);
                est = (System.nanoTime() - start);
                System.out.println("passed");
                passed++;
                System.out.println("Average time for insertion: " + est + " nanoseconds");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());    
        }
        //TEST 3: TESTING BINARY-TREE FIND METHOD
        try
        {
            System.out.println("[Testing Binary-Tree find()]");
            System.out.print("Status: ");
            if(tree == null)
            {
                throw new IllegalArgumentException ("FAILED"); 
            }
            else
            {
                start = System.nanoTime();
                value = tree.find("88E");
                System.out.println(((StockClass)value).status());
                est = (System.nanoTime() - start);
                passed++;
                System.out.println("passed");
                System.out.println("Average time for find: " + est + " nanoseconds");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());    
        }
        //TEST 4: TESTING BINARY-TREE DELETE METHOD
        try
        {
            System.out.println("[Testing Binary-Tree delete()]");
            System.out.print("Status: ");
            if(tree == null)
            {
                throw new IllegalArgumentException ("FAILED"); 
            }
            else
            {
                start = System.nanoTime();
                tree.delete("88E");
                est = (System.nanoTime() - start);
                passed++;
                System.out.println("passed");
                System.out.println("Average time for deletion: " + est + " nanoseconds");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());    
        }
        //TEST 5: TESTING BINARY-TREE GETSIZE METHOD
        try
        {
            System.out.println("[Testing Binary-Tree getSize()]");
            System.out.print("Status: ");
            if(tree == null)
            {
                throw new IllegalArgumentException ("FAILED"); 
            }
            else
            {
                if(tree.getHeight() != 0)
                {
                    System.out.println("passed");
                    System.out.println("Tree size: " + tree.getSize());
                    passed++;
                }
                else
                {
                    throw new IllegalArgumentException ("FAILED"); 
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());    
        }
        //TEST 6: TESTING BINARY-TREE GETHEIGHT METHOD
        try
        {
            System.out.println("[Testing Binary-Tree getHeight()]");
            System.out.print("Status: ");
            if(tree == null)
            {
                throw new IllegalArgumentException ("FAILED"); 
            }
            else
            {   
                if(tree.getHeight() != 0)
                {
                    System.out.println("passed");
                    System.out.println("Tree height: " + tree.getHeight());
                    passed++;
                }
                else
                {
                    throw new IllegalArgumentException ("FAILED"); 
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());    
        }
        System.out.println("Number of test passed: [" + passed + "/6]");
    }
    /**************************************************************************
    *Submodule: strInput
    *Import: prompt (String)
    *Export: str (String)
    *Assertion: Allows user to input string in peace        
    **************************************************************************/
    public static String strInput (String prompt)
    {
        String str;
        Scanner sc = new Scanner (System.in);
        System.out.println(prompt);
        str = sc.nextLine();
        return str;
    }
}
