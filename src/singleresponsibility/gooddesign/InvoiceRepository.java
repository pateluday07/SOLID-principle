package singleresponsibility.gooddesign;

public class InvoiceRepository {

    public void save(Invoice invoice) {
        System.out.println("Saving the invoice to the database...");
    }

}
