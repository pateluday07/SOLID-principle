package interfacesegregation.gooddesign;

public class SimplePrinter implements Printer {

    @Override
    public void print() {
        System.out.println("Printing document...");
    }

}
