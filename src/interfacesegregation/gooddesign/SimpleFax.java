package interfacesegregation.gooddesign;

public class SimpleFax implements Fax {

    @Override
    public void fax() {
        System.out.println("Faxing document...");
    }

}
