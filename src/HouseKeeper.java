import java.time.LocalDate;

public class HouseKeeper extends HotelStaff{
    private int yearsOfExperience;

    public HouseKeeper(String name, String surname){
        super(name, surname);
    }

    public void setYearsOfExperience(int yearsOfExperience){
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getYearsOfExperience(){
        return yearsOfExperience;
    }

    @Override
    public String toString(){
        return super.toString() + " Housekeeper - Years of Experience: " + yearsOfExperience;
    }
}
