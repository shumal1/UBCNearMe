package Model;

public class WashRoom extends AbstractRoom {
    private WRType wrType;
    private Boolean accessible;

    public WashRoom(Building building, int floor, String roomNumber){
        super(building, floor, roomNumber);
        wrType = null;
        accessible = null;
    }

    public void setWrType(WRType wrType){
        this.wrType = wrType;
    }

    public void setAccessible(Boolean accessible){
        this.accessible = accessible;
    }

    public Boolean isAccessible() {
        return accessible;
    }

    public WRType getWrType() {
        return wrType;
    }
}
