
package c189projectmain;

// TN: Constructor to build a "listing" structure for the data tree.  These 
// nodes will track the left and right child nodes should they exist:

public class DataTreeListing {
    
    String fullName;
    String phoneNumber;
    String emailAddress;
    String key;

    DataTreeListing leftChild;
    DataTreeListing rightChild;

    DataTreeListing(String firstName, String lastName, String phoneNumber, 
            String emailAddress) {

        this.fullName = firstName + " " + lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.key = fullName.toUpperCase();

    }

}