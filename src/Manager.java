public class Manager extends HotelStaff{
    private String licenceNumber;

    public Manager(String name, String surname, String licenceNumber){
        super(name, surname);
        this.licenceNumber = licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber){
        this.licenceNumber = licenceNumber;
    }

    public String getLicenceNumber(){
        return licenceNumber;
    }

    @Override
    public String toString(){
        return super.toString() + " Licence Number: " + licenceNumber + "\n";
    }
}
