package Model;

public class AbstractRoom extends AbstractResource {
    protected Building building;
    protected int floor;
    protected String roomNumber;


    public AbstractRoom (Building building, int floor, String roomNumber){
        this.building = building;
        this.floor = floor;
        this.roomNumber = roomNumber;
    }

    public void setBuilding(Building building){
        this.building = building;
    }

    public void setFloor (int floor){
        this.floor = floor;
    }

    public void setRoomNumber (String roomNumber){
        this.roomNumber = roomNumber;
    }

    public int getFloor(){
        return floor;
    }

    public String getRoomNumber (){
        return roomNumber;
    }

    //TODO: get Building

}
