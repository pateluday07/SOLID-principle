package interfacesegregation.baddesign;

public class SimplePrinter implements MultifunctionDevice {

    @Override
    public void print() {
        System.out.println("Printing document...");
    }

    @Override
    public void scan() {
        throw new UnsupportedOperationException("Scanning is not supported by SimplePrinter");
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException("Faxing is not supported by SimplePrinter");
    }

}
