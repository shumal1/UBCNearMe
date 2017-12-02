package Model;


public abstract class AbstractResource implements IResource, Comparable<AbstractResource> {
    protected int floor;
    protected Building building;

    public AbstractResource(Building building, int floor){
        this.floor = floor;
        this.building = building;
    }


    public void setFloor(int floor){
        this.floor = floor;
    }

    public void setBuilding (Building building){
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }

    public int getFloor() {
        return floor;
    }


    public int compareTo(AbstractResource resource) {
        return this.getFloor() - resource.getFloor();
    }
}
