package Model;

public abstract class AbstractRoom extends AbstractResource  {
    protected String roomNumber;


    public AbstractRoom (Building building, Integer floor){
        super(building, floor);
        roomNumber = null;
    }

    public void setRoomNumber (String roomNumber){
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber (){
        return roomNumber;
    }



}
