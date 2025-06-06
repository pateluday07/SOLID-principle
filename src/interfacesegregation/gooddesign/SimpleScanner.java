package interfacesegregation.gooddesign;

public class SimpleScanner implements Scanner {

    @Override
    public void scan() {
        System.out.println("Scanning document...");
    }

}
