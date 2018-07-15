
package c189projectmain;

// TN: Hash table node implementation with pointer to next node to facilitate 
//     a linked list:

public class Listing<string, Person> {
    
    int index;
    string name;
    Person person;
    Listing<string, Person> next;

    Listing(int index, string name, Person person, Listing<string, Person> next) 
                {
        this.index = index;
        this.name = name;
        this.person = person;
        this.next = next;
    }
}