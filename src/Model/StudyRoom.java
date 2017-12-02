package Model;

public class StudyRoom extends AbstractRoom {
    private Integer size;
    private Boolean booked;

    public StudyRoom(Building building, int floor, String roomNumber){
        super(building, floor, roomNumber);
        size = null;
        booked = null;
    }

    public void setSize (Integer size){
        this.size = size;
    }

    public void setBooked(Boolean booked){
        this.booked = booked;
    }

    public Integer getSize (){
        return size;
    }

    public Boolean isBooked() {
        return booked;
    }
}
