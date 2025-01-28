package InnerClass;

public class HotelBooking {
    String hotelName;
    int numberOfRooms;
    int reservedRooms;

    HotelBooking(String name, int totalRooms, int reservedRooms){
        this.hotelName = name;
        this.numberOfRooms = totalRooms;
        this.reservedRooms = reservedRooms;
    }

    public void reserveRoom(String guestName, int rooms){

        class ReservationValidation{
            public boolean validate(){
                if(guestName == null || guestName.isBlank()){
                    System.out.println("Please insert guest name!");
                    return false;
                }else if(rooms < 1){
                    System.out.println("Please insert valid number of rooms for reservation!");
                    return false;
                }
                else if(rooms + reservedRooms > numberOfRooms){
                    System.out.println("Required Rooms not available!, only "+ (numberOfRooms-reservedRooms)+ " rooms available");
                    return false;
                }
                return true;
            }
        }

        ReservationValidation validation = new ReservationValidation();
        if(validation.validate()){
            reservedRooms += rooms;
            System.out.println("Reservation done on behalf of "+guestName+ " for "+rooms+ " rooms!");
        }else{
            System.out.println("Reservation failed!!");
        }
    }
}
