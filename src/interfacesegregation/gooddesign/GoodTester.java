package interfacesegregation.gooddesign;

public class GoodTester {

    public static void main(String[] args) {
        SimplePrinter simplePrinter = new SimplePrinter();
        simplePrinter.print();

        SimpleScanner simpleScanner = new SimpleScanner();
        simpleScanner.scan();

        SimpleFax simpleFax = new SimpleFax();
        simpleFax.fax();

        MultiFunctionPrinter multiFunctionPrinter = new MultiFunctionPrinter();
        multiFunctionPrinter.print();
        multiFunctionPrinter.scan();
        multiFunctionPrinter.fax();
    }
}
