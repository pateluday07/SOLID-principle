package interfacesegregation.baddesign;

public class BadTester {

    public static void main(String[] args) {
        SimplePrinter simplePrinter = new SimplePrinter();
        simplePrinter.print();
        simplePrinter.scan();
        simplePrinter.fax();
    }
}
