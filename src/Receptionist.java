public class Receptionist extends HotelStaff{

    private String shiftTiming;
    private String languageSpoken;

    public Receptionist(String name, String surname){
        super(name, surname);
    }

    public void setShiftTiming(String shiftTiming){
        this.shiftTiming = shiftTiming;
    }
    public String getShiftTiming(){
        return shiftTiming;
    }
    public void setLanguageSpoken(String languageSpoken){
        this.languageSpoken = languageSpoken;
    }
    public String getLanguageSpoken(){
        return languageSpoken;
    }

    @Override
    public String toString(){
        return super.toString() + " ShiftTiming: " + shiftTiming + " LanguageSpoken: " + languageSpoken;
    }
}
