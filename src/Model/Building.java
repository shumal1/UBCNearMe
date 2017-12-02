package Model;

import java.util.*;


public class Building {
    private String hours;
    private double lat;
    private double lon;
    private String name;
    private boolean accessible;
    private Set<IResource> resources;

    public Building(String hours, double lat, double lon, String name){
        this.hours = hours;
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        resources = new HashSet<>();
    }


    public boolean isAccessible(){
        return accessible;
    }

    public String getHours(){
        return hours;
    }

    public String getName(){
        return name;
    }

    public double getLat(){
        return lat;
    }

    public double getLon(){
        return lon;
    }

    public List<AbstractRoom> getRooms(){
        List<AbstractRoom> rooms = new ArrayList<>();
        for (IResource resource : resources) {
            if(resource instanceof AbstractRoom){
                rooms.add((AbstractRoom)resource);
            }
        }
        return Collections.unmodifiableList(rooms);
    }

    public List<Fountain> getFountains(){
        List<Fountain> fountains = new ArrayList<>();
        for (IResource resource : resources) {
            if(resource instanceof Fountain){
                fountains.add((Fountain)resource);
            }
        }
        return Collections.unmodifiableList(fountains) ;
    }

    public Set<IResource> resources(){
        return Collections.unmodifiableSet(resources);
    }

    public void addResource(IResource iResource){
        resources.add(iResource);
    }

    public void clearResource(){
        resources.clear();
    }

    public void setResource(Set<IResource> resources){
        this.resources = resources;
    }



}
