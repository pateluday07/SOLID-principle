package interfacesegregation.baddesign;

public class SimplePrinter implements Machine {

    @Override
    public void print() {
        System.out.println("Printing document...");
    }

    @Override
    public void scan() {
        throw new UnsupportedOperationException("Printer does not support scanning");
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException("Printer does not support faxing");
    }

}
