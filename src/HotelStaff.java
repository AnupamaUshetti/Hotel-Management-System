import java.time.LocalDate;

public abstract class HotelStaff implements Comparable<HotelStaff> {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String staffID;

    public HotelStaff(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public void setStaffID(String staffID){
        this.staffID = staffID;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public String getStaffID(){
        return staffID;
    }


    @Override
    public String toString(){
        return name + " " + surname + ", Date of Birth: " + dateOfBirth + ", Staff ID: " + staffID;
    }

}
