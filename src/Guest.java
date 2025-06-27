public class Guest {

    private String name;
    private String surname;
    private int roomNumber;
    private int nightStayed;

    public Guest (String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }
    public void setNightSayed(int nightStayed){
        this.nightStayed = nightStayed;
    }

    public int getRoomNumber(){
        return roomNumber;
    }
    public int getNightStayed(){
        return nightStayed;
    }

    @Override
    public String toString(){
        return name + " " + surname + " " + roomNumber + " " + nightStayed;
    }
}
