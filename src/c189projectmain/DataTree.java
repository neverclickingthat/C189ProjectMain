package c189projectmain;

/**
 *
 * @author Tim Nesbitt
 * 
 * Develop a tree data structure that does not use of any of the data structure 
 * classes and that includes the following:
 *
 * Note: For all insertions, deletions, and look-ups, the suggestion is to apply 
 * an upper case function to convert all letters in both the first and last name 
 * to upper case, and concatenate to form a single name string.
 *
 * 1.  An insertion function that takes the following components as input and 
 * that inserts the data element into the tree:
 * -   first name
 * -   last name
 * -   e-mail address
 * -   phone number
 * 2.  A deletion function that takes the following components as input and that 
 * deletes the data element from the tree:
 * -   first name
 * -   last name
 * 3.  A look-up function that takes the following components as input and that 
 * returns the data element from the tree:
 * -   first name
 * -   last name
 */
public class DataTree {
 
    DataTreeListing root;
    
    // TN: Add a listing to the phone book:
    
    DataTreeListing insert(String firstName, String lastName, 
            String phoneNumber, String emailAddress) {
        
        DataTreeListing newDataTreeListing = new DataTreeListing(firstName, 
            lastName, phoneNumber, emailAddress);
                              
            // TN: Adds the node to the root should the tree be empty:
        
            if (root == null) {
                
                root = newDataTreeListing;
                System.out.println("ADD SUCCESSFUL: " 
                        + newDataTreeListing.fullName + " was added to "
                        + "as the root");
            }
            
            // TN: If the tree has entries "compareTo" is employed to 
            // determine if the node should live on the right or left of the 
            // node being analysed - called the "pivotListing".  Then, should
            // null space be found at that location, the node is placed:
            
            else {
                
                DataTreeListing pivotListing = root;
                DataTreeListing parent;
                
                while(true) {
                    parent = pivotListing;
                    
                    if(newDataTreeListing.key.compareTo(pivotListing.key) < 0) {
                        pivotListing = pivotListing.leftChild;
                        
                        if (pivotListing == null) {
                            parent.leftChild = newDataTreeListing;
                            System.out.println("ADD SUCCESSFUL: " 
                                    + newDataTreeListing.fullName + " was"
                                    + " added as the Left Child of " 
                                    + parent.fullName);
                            return null;
                        }
                    }
                
                    else {
                         pivotListing = pivotListing.rightChild;

                    if(pivotListing == null){
                        parent.rightChild = newDataTreeListing;
                        System.out.println("ADD SUCCESSFUL: " 
                                + newDataTreeListing.fullName + " was "
                                + "added as the Right Child of " 
                                + parent.fullName);
                        return null;
                    }
                        
                }
                
            }

        }
    return null; 
    }
    
    // TN: Lookup function for the data tree using first and last name:
    
    DataTreeListing lookup(String firstname, String lastname) {
        
        String name = firstname + " " + lastname;
        String newKey = name.toUpperCase();
        DataTreeListing pivotListing = root;
                  
        // TN: Uses "compareTo" while the listing being searched for doesn't
        // match the entry being analysed to determind whether to move to
        // the right or next node next:
        
        while(!pivotListing.key.equals(newKey)){

            if(newKey.compareTo(pivotListing.key) < 0){
                pivotListing= pivotListing.leftChild;
            }
            else{
                pivotListing = pivotListing.rightChild;
            }

            // TN: Returns an error should null space be reached;
            
            if(pivotListing == null){
                System.out.println("SEARCH FAILED: " + name + " was not found in "
                        + "the phone book");
                return null;
            }
        }
            
            // If a match is found returns a success message:
        
            System.out.println("SEARCH SUCCESSFUL: "+ name + " was found in "
            + "the phone book. \n   "
            + "Phone Number: " + pivotListing.phoneNumber + "\n   "
            + "Email Address: " + pivotListing.emailAddress);            
            return null;
        }
    
    // TN: Delete functions using first and last name which address each binary
    // search tree situation: no children, right only, left only, and two 
    // children:
    
    public boolean delete(String firstname, String lastname) {
    
        String name = firstname + " " + lastname;
        String newKey = name.toUpperCase();
        DataTreeListing pivotListing = root;
        DataTreeListing parent = root;
        boolean leftChildStatus = true;
        
        // TN: Search for the node comparing key values.  Tracking the 
        // "left child status" will allow simple modification of the
        // nodes parents "leftChild" or "rightChild" values for deletions.
        
        while (!pivotListing.key.equals(newKey)) {
            
            parent = pivotListing;
            
            if (newKey.compareTo(pivotListing.key) < 0) {
                
                leftChildStatus = true;
                pivotListing = pivotListing.leftChild;
                
            }
            else {
                
                leftChildStatus = false;
                pivotListing = pivotListing.rightChild;
            }
            
            if (pivotListing == null) {
                System.out.println("DELETE FAILED: " + name + " was not found in"
                + " the phone book.");
                return false;
            }
            
        }
        
        // TN: Deletion case for a childless node:
        
        if (pivotListing.leftChild == null && pivotListing.rightChild == null) {
            
            if (leftChildStatus)
                parent.leftChild = null;
            
            else
                parent.rightChild = null;
            
        }
        
        // TN: Deletion case for left child but no right child:
        
        else if (pivotListing.rightChild == null) {
            
            // TN: Move the deleted node's left child node up to the
            // deleted node's parent:
            
            if (leftChildStatus)
                parent.leftChild = pivotListing.leftChild;
            
            else
                parent.rightChild = pivotListing.leftChild;
        }
        
        // TN: Deletion case for right child but no left child:
        
        else if (pivotListing.leftChild == null) {
            
            // TN: Move the deleted node's right child node up to the
            // deleted node's parent:
            
            if (leftChildStatus)
                parent.leftChild = pivotListing.rightChild;
            
            else
                parent.rightChild = pivotListing.rightChild;
            
        }
        
        // TN: Deletion case for a node with two children:
        
        else {
            
            // TN: Find the smallest value under the deletion candidate's right
            // child node (the in-order successor) 
            
            DataTreeListing replacement = 
                    findSmallestNode(pivotListing.rightChild);
            
            // TN: Set the value of the deletion candidate to the in-order 
            // successor:
        
            pivotListing.fullName = replacement.fullName;
            pivotListing.phoneNumber = replacement.phoneNumber;
            pivotListing.emailAddress = replacement.emailAddress;
            
            // TN: Remove the in-order successor by setting it NULL or 
            // replacing it with the right child:
            
            removeSmallestNode (pivotListing.rightChild);            
        }
        
        System.out.println("DELETE SUCCESSFUL: " + name + " was deleted "
                        + "from the phone book.");
        return true;
    }
    
    // TN: Recursive method to locate the smallest node under a specified node:
    
    private DataTreeListing findSmallestNode(DataTreeListing node) {
        
        if (node.leftChild != null) {
            
            node = this.findSmallestNode(node.leftChild);
            
        }
        
        return node;
             
    }    
    
    // TN: Method to again locate the smalled node - this time replacing it
    // with its right child and reassigning its parent righChild pointer: 
    
    private DataTreeListing removeSmallestNode(DataTreeListing node) {
                
        DataTreeListing parent = node;
        
        while(node.leftChild != null) {
                   
            if (node.leftChild != null) {
            
                parent = node;
                node = node.leftChild;
                
            }
            
            else {
            
                parent.rightChild = node;
                node = node.rightChild;
                
            }
           
        }
        return node;
        
    }
}
