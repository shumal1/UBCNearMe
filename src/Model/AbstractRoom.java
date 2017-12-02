package Model;

public class AbstractRoom extends AbstractResource {
    protected Building building;
    protected int floor;
    protected String roomNumber;


    public AbstractRoom (){
        building = null;
        floor = 0;
        roomNumber = "";
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

}
