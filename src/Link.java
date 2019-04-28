
//Class that creates a list of Links and adds methods for adding, removing and displaying data from links
class LinkedList {
    Link firstLink;

    LinkedList () {
        firstLink = null;
    }
    //Check if List is empty
    boolean isEmpty (){
        return firstLink == null;
    }
    //Checks if the link with given String exists
    Link findLink (String d) {
        Link theLink = firstLink;
        if (!isEmpty()) {

            while (theLink.data != d) {
                if (theLink.next == null) {
                    return null;
                }
                else {
                    theLink = theLink.next;
                }
            }
        }
        else {
            System.out.println("The List is empty");
        }
        return theLink;
    }


    //Removes the link by given String
    Link removeLink (String d) {
        Link currentLink = firstLink;
        Link previousLink = firstLink;
        while (currentLink.data != d) {
            if (currentLink.next == null) {
                return null;
            }
            else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        if (currentLink == firstLink) {
            firstLink = firstLink.next;
        }
        else {
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }


    //Inserts a new link
    void insertNewLink (String d) {
        Link newLink = new Link(d);
        newLink.next = firstLink;
        firstLink = newLink;
    }

    //Displays all links in reverse order they were entered
    void display () {
        Link theLink = firstLink;
        while (theLink != null) {
            theLink.display();
            theLink = theLink.next;
        }
    }
}


//Class defining a single Link with one String and a reference to the next Link
public class Link {
    String data;
    //Constructor
    Link (String d) {
        this.data = d;
    }
    Link next;
    //Prints the data from the Link
    void display () {
        System.out.println(this.data + "\n");
    }
    public static void main (String[] args) {
        LinkedList d = new LinkedList();
        d.insertNewLink("1");
        d.insertNewLink("2");
        d.insertNewLink("3");
        d.insertNewLink("4");
        d.removeLink("3");
        d.display();

    }
}
