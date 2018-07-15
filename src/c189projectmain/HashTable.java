
package c189projectmain;

/**
 *
 * @author Tim Nesbitt
 * 
 * Develop a hash table data structure from the ground up that does not use 
 * any of the data structure classes and that includes the following:
 *
 * Note: For all insertions, deletions, and look-ups, the suggestion is to apply 
 * an upper case function to convert all letters in both the first 
 * and last name to upper case and concatenate to form a single name string.
 * 
 * 1.  An insertion function that takes the following components as input and 
 *          that inserts the data element into the hash table:
 *          -   first name
 *          -   last name
 *          -   e-mail address
 *          -   phone number
 * 2.  A deletion function that takes the following components as input and that 
 *          deletes the corresponding data element from the hash table:
 *          -   first name
 *          -   last name
 * 3.  A look-up function that takes the following components as input and that 
 *          returns the corresponding data element:
 *          -   first name
 *          -   last name
 * 4.  Implementation of 13 buckets in the bucket hash structure.
 * 
 * Note: The hash function used for the hash table may call the Java native 
 *          method hashCode() as part of its implementation.
 */

class HashTable {
    
    // TN: Using an Array Dictionary for the hash table:
   
    private Listing<String, Person>[] phoneBook;

    // TN: Array size will be dictated in Main method:
    
    HashTable(int size) {
        
        phoneBook = new Listing[size];
        
    }

    // TN: Creates the index using hashCode and the Math.abs function:
    
    private Integer getIndex(String fullName) {
        
        String nameCaps = fullName.toUpperCase();
        Integer index = nameCaps.hashCode() % phoneBook.length;
        index = Math.abs(index);
    
        return index;
    }

    // TN: Concatenater for first and last name, adds a space:
   
    private static String concatenate(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    // TN: Inserts new listing into phonebook:    
    
    Person insert(String firstName, String lastName, String phoneNumber, 
            String emailAddress) {
        
        Person person = new Person(firstName, lastName, phoneNumber, 
                emailAddress);
        
        String fullName = concatenate(firstName, lastName);
        
        int index = getIndex(fullName);

        Listing<String, Person> node = new Listing(index, fullName, person, 
                phoneBook[index]);
        
        phoneBook[index] = node;

        System.out.println("ADD SUCCESSFUL: " + fullName + " was inserted into "
                + "the phone book at " + "Position " + index + "." );

                return person;
    }

   
    // TN: Lookup function using first and last name:
    
    Person lookup(String firstName, String lastName) {
        String name = concatenate(firstName, lastName);
        int index = getIndex(name);

        // TN: Searches nodes until the name matches a name in a node or null
        // is found:
        
        for (Listing<String, Person> node = phoneBook[index]; node != null; 
                node = node.next) {
            
            if (name.equals(node.name)) {
                System.out.println("SEARCH SUCCESSFUL: "+ name + " was found in "
                        + "the phone book. \n   "
                        + "Phone Number: " + node.person.phoneNumber + "\n   "
                        + "Email Address: " + node.person.emailAddress);

                return node.person;
            }
        }
            
        // TN: Prints a failed message should the search run into null:
        
        System.out.println("SEARCH FAILED: " + name + " was not found in the "
                + "phone book.");

        return null;
    }

    // TN: Delete function using first and last name:
    
    Boolean delete(String firstName, String lastName) {
        String name = concatenate(firstName, lastName);
        int index = getIndex(name);
        Listing<String, Person> checked = null;

        for (Listing<String, Person> node = phoneBook[index]; node != null; 
                node = node.next) {
    
            // TN: Ensures the correct node is deleted in the found index's list 
            // of nodes:        
    
            if (index == node.index && name.equals(node.name)) {
                if (checked == null) {
                    phoneBook[index] = node.next;
                } else {
                    checked.next = node.next;
                }

                System.out.println("DELETE SUCCESSFUL: " + name + " was deleted "
                        + "from the phone book.");

                return true;
            }

            checked = node;
        }
        
        // TN: Prints a failes message should the value to be deleted not be 
        // found:
        
        System.out.println("DELETE FAILED: " + name + " was not found in the "
                + "phone book.");

        return false;
    }
    
 
}
