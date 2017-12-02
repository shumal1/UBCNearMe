package Model;

public class WashRoom extends AbstractRoom {
    private WRType wrType;
    private String roomnum;

    public WashRoom(Building building, int floor, String roomNumber){
        super(building, floor);
        wrType = null;
        this.roomnum = roomNumber;

    }

    public void setWrType(WRType wrType){
        this.wrType = wrType;
    }

    public WRType getWrType() {
        return wrType;
    }
}
