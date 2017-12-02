package Model;

public abstract class AbstractResource implements IResource {
    protected Integer floor;
    protected Building building;

    public AbstractResource(Building building, Integer floor){
        this.floor = floor;
        this.building = building;
    }

    public void setFloor(Integer floor){
        this.floor = floor;
    }

    public void setBuilding (Building building){
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }

    public Integer getFloor() {
        return floor;
    }
}
