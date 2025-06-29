public class HotelManagementSystem {
    public static void main(String[] args) {
        HotelManager HotelManager = new WestminsterHotelManager(100);
        boolean exit = false;
        while(!exit){
            exit = HotelManager.runMenu();
        }

    }
}