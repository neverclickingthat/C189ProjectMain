/*
 * TN: Assignment:
 *
 * Scenario:
 * Your employer is developing an online phone book that stores names, phone numbers, and e-mail addresses. 
 * Your boss has asked you to build a prototype in Java to help decide on the best data structures to use for 
 * the implementation. You will need to implement and test a single application that has two implementations 
 * of the address book built in so that the data may be stored using each design.
 *
 * 
 * Develop an application that tests the following functions:
 *
 * Note: Applications copied from another student or other source may not be 
 * submitted and are not eligible for passing the assessment.
 *
 * 1.  insertion function for the hash table
 * 2.  deletion function for the hash table
 * 3.  look-up function for the hash table
 * 4.  insertion function for the tree data structure
 * 5.  deletion function for the tree data structure
 * 6.  look-up function for the tree data structure
 *
 * Use the attached test cases to verify that the hash table and tree data 
 * structure run correctly by providing one screenshot that demonstrates successful 
 * test execution for each of the following:
 *
 * Note: Test execution screenshots copied from another student or other source 
 * may not be submitted and are not eligible for passing the assessment.
 *
 * 1.  insert function for the hash table
 * 2.  delete function for the hash table
 * 3.  look-up function for the hash table
 * 4.  insert function for the tree data structure
 * 5.  delete function for the tree data structure
 * 6.  look-up function for the tree data structure
 *
 */
 
package c189projectmain;

public class C189ProjectMain {
  
    public static void main(String[] args) {
        
        testHashTable();
        testDataTree();
    }
   
    // TN: Data test case for hash table:
    
public static void testHashTable() {
    
        // TN: Assign 13 buckets:
        
        HashTable phoneBook = new HashTable(13);

        System.out.println("\n*************************************************");
        System.out.println("    Hash Table Insert, Delete and Look-up Test");
        System.out.println("************************************************* \n");
        
        phoneBook.insert("Bob", "Smith", "555-235-1111", 
                "bsmith@somewhere.com");
        phoneBook.insert("Jane", "Williams", "555-235-1112", 
                "jw@something.com");
        phoneBook.insert("Mohammed", "al-Salam", "555-235-1113", 
                "mas@someplace.com");
        phoneBook.insert("Pat", "Jones", "555-235-1114", 
                "pjones@homesweethome.com");
        phoneBook.insert("Billy", "Kidd", "555-235-1115", 
                "billy_the_kid@nowhere.com");
        phoneBook.insert("H.", "Houdini", "555-235-1116", 
                "houdini@noplace.com");
        phoneBook.insert("Jack", "Jones", "555-235-1117", "jjones@hill.com" );
        phoneBook.insert("Jill", "Jones", "555-235-1118", "jillj@hill.com");
        phoneBook.insert("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
        phoneBook.insert("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
        phoneBook.lookup("Pat", "Jones");
        phoneBook.lookup("Billy", "Kidd");
        phoneBook.delete("John", "Doe");
        phoneBook.insert("Test", "Case", "555-235-1121", 
                "Test_Case@testcase.com");
        phoneBook.insert("Nadezhda", "Kanachekhovskaya", "555-235-1122", 
                "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        phoneBook.insert("Jo", "Wu", "555-235-1123", "wu@h.com");
        phoneBook.insert("Millard", "Fillmore", "555-235-1124", 
                "millard@theactualwhitehouse.us");
        phoneBook.insert("Bob", "vanDyke", "555-235-1125", 
                "vandyke@nodomain.com");
        phoneBook.insert("Upside", "Down", "555-235-1126", 
                "upsidedown@rightsideup.com");
        phoneBook.lookup("Jack", "Jones");
        phoneBook.lookup("Nadezhda", "Kanachekhovskaya");
        phoneBook.lookup("Millard", "Fillmore");
        phoneBook.delete("Jill", "Jones");
        phoneBook.delete("John", "Doe");
        phoneBook.lookup("Jill", "Jones");
        phoneBook.lookup("John", "Doe");
       
    }
    
        // TN: Data test case for data tree:

public static void testDataTree() {
        DataTree binaryBook = new DataTree();

        System.out.println("\n*************************************************");
        System.out.println("    Data Tree Insert, Delete and Look-up Test");
        System.out.println("************************************************* \n");
        
        binaryBook.insert("Bob", "Smith", "555-235-1111", 
                "bsmith@somewhere.com");
        binaryBook.insert("Jane", "Williams", "555-235-1112", 
                "jw@something.com");
        binaryBook.insert("Mohammed", "al-Salam", "555-235-1113", 
                "mas@someplace.com");
        binaryBook.insert("Pat", "Jones", "555-235-1114", 
                "pjones@homesweethome.com");
        binaryBook.insert("Billy", "Kidd", "555-235-1115", 
                "billy_the_kid@nowhere.com");
        binaryBook.insert("H.", "Houdini", "555-235-1116", 
                "houdini@noplace.com");
        binaryBook.insert("Jack", "Jones", "555-235-1117", "jjones@hill.com" );
        binaryBook.insert("Jill", "Jones", "555-235-1118", "jillj@hill.com");
        binaryBook.insert("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
        binaryBook.insert("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
        binaryBook.lookup("Pat", "Jones");
        binaryBook.lookup("Billy", "Kidd");
        binaryBook.delete("John", "Doe");
        binaryBook.insert("Test", "Case", "555-235-1121", 
                "Test_Case@testcase.com");
        binaryBook.insert("Nadezhda", "Kanachekhovskaya", "555-235-1122", 
                "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        binaryBook.insert("Jo", "Wu", "555-235-1123", "wu@h.com");
        binaryBook.insert("Millard", "Fillmore", "555-235-1124", 
                "millard@theactualwhitehouse.us");
        binaryBook.insert("Bob", "vanDyke", "555-235-1125", 
                "vandyke@nodomain.com");
        binaryBook.insert("Upside", "Down", "555-235-1126", 
                "upsidedown@rightsideup.com");
        binaryBook.lookup("Jack", "Jones");
        binaryBook.lookup("Nadezhda", "Kanachekhovskaya");
        binaryBook.lookup("Millard", "Fillmore");
        binaryBook.delete("Jill", "Jones");
        binaryBook.delete("John", "Doe");
        binaryBook.lookup("Jill", "Jones");
        binaryBook.lookup("John", "Doe");
       
    }


    }
    
