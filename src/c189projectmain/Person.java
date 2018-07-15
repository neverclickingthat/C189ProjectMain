package c189projectmain;


public class Person {
    
    String firstName;
    String lastName;
    String phoneNumber;
    String emailAddress;
    
   
    // TN: Constructor for "Person" data type:
    
    Person(String firstName, String lastName, String phoneNumber, 
            String emailAddress) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        
    }
}