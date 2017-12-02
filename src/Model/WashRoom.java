package Model;

public class WashRoom extends AbstractRoom {
    private WashroomType washroomType;

    public WashRoom(Building building, int floor, String roomNumber){
        super(building, floor);
        washroomType = null;
        this.roomNumber = roomNumber;

    }

    public void setWashroomType(WashroomType washroomType){
        this.washroomType = washroomType;
    }

    public WashroomType getWashroomType() {
        return washroomType;
    }


}
