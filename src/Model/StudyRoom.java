package Model;

public class StudyRoom extends AbstractRoom {
    private Integer size;
    private Boolean availability;

    public StudyRoom(Building building, int floor){
        super(building, floor);
        size = null;
        availability = null;
    }

    public void setSize (Integer size){
        this.size = size;
    }

    public void setAvailability(Boolean available){
        this.availability = available;
    }

    public Integer getSize (){
        return size;
    }

    public Boolean isAvailable() {
        return availability;
    }
}
