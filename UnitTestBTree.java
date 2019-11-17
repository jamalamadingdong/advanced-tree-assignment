/**************************
* AUTHOR: ONG MING HANG   *
* PROGRAM: UnitTestBTree  *
* DATE: 13/05/2019        *
***************************/
import java.util.*;

public class UnitTestBTree
{
    public static void main (String [] args)
    {
        long start, est;
        BlockTree tree = null;
        String find = "", file = "";
        Object value;
        int passed = 0;
        int order;
        Scanner sc = new Scanner (System.in);
        System.out.println("Testing B-Tree\n==================================");
        //TEST 1: TESTING B-TREE CONSTRUCTOR
        try
        {
            System.out.println("[Testing B-Tree File Input]");
            file = strInput("Enter the file:");
            System.out.print("Status: ");
            if(file.equals(null)||file.equals(""))
            {
                throw new IllegalArgumentException ("FAILED");
            }
            else
            {
                System.out.println("Passed");
                passed++;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());    
        }
        //TEST 2: TESTING B-TREE
        try
        {
            System.out.println("[Testing B-Tree File Insertion]");
            System.out.println("Enter the order of the tree [e.g. > 2]");
            order = sc.nextInt();
            System.out.print("Status: ");
            if(order < 2)
            {
                throw new IllegalArgumentException ("FAILED");
            }
            else
            {
                start = System.nanoTime();
                tree = new BlockTree(order, file);
                est = (System.nanoTime() - start)/tree.getSize();
                passed++;
                System.out.println("passed");
                System.out.println("Average time for insertion per node: " + est + " nanoseconds");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());    
        }
        //TEST 3: TESTING B-TREE INSERT METHOD
        try
        {
            System.out.println("[Testing B-Tree insert()]");
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
                System.out.println("passed");
                tree.insert(key, stock);
                est = (System.nanoTime() - start);
                passed++;
                System.out.println("Average time for insertion: " + est + " nanoseconds");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());    
        }
        //TEST 4: TESTING B-TREE FIND METHOD
        try
        {
            System.out.println("[Testing B-Tree find()]");
            start = System.nanoTime();
            System.out.print("Status: ");
            if(tree == null)
            {
                throw new IllegalArgumentException ("FAILED"); 
            }
            else
            {
                System.out.println("passed");
                value = tree.find("88E");
                est = (System.nanoTime() - start);
                System.out.println(((StockClass)value).status());
                passed++;
                System.out.println("Average time for find: " + est + " nanoseconds");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());    
        }
        //TEST 5: TESTING B-TREE GETSIZE METHOD
        try
        {
            System.out.println("[Testing B-Tree getSize()]");
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
        //TEST 6: TESTING B-TREE GETHEIGHT METHOD
        try
        {
            System.out.println("[Testing B-Tree getHeight()]");
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
