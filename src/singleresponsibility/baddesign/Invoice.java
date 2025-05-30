package singleresponsibility.baddesign;

public class Invoice {

    public void calculateTotal() {
        System.out.println("Calculating total for the invoice...");
    }

    public void printInvoice() {
        System.out.println("Printing the invoice...");
    }

    public void saveToDatabase() {
        System.out.println("Saving the invoice to the database...");
    }

}
