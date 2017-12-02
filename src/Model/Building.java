package Model;

import java.util.*;


public class Building {
    private String hours;
    private double lat;
    private double lon;
    private String name;
    private boolean accessible;
    private Set<IResource> resources;

    public Building(String hours, double lat, double lon, String name) {
        this.hours = hours;
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        resources = new HashSet<>();
    }


    public boolean isAccessible() {
        return accessible;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLatLon(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public List<AbstractRoom> getRooms() {
        List<AbstractRoom> rooms = new ArrayList<>();
        for (IResource resource : resources) {
            if (resource instanceof AbstractRoom) {
                rooms.add((AbstractRoom) resource);
            }
        }
        return Collections.unmodifiableList(rooms);
    }

    public List<WashRoom> getWashRooms() {
        List<WashRoom> washRooms = new ArrayList<>();
        for (IResource resource : resources) {
            if (resource instanceof WashRoom) {
                washRooms.add((WashRoom) resource);
            }
        }
        return Collections.unmodifiableList(washRooms);
    }

    public List<StudyRoom> getStudyRooms() {
        List<StudyRoom> studyRooms = new ArrayList<>();
        for (IResource resource : resources) {
            if (resource instanceof StudyRoom) {
                studyRooms.add((StudyRoom) resource);
            }
        }
        return Collections.unmodifiableList(studyRooms);
    }


    public List<Fountain> getFountains() {
        List<Fountain> fountains = new ArrayList<>();
        for (IResource resource : resources) {
            if (resource instanceof Fountain) {
                fountains.add((Fountain) resource);
            }
        }
        return Collections.unmodifiableList(fountains);
    }

    private List<AbstractResource> rankResources(List<AbstractResource> resources) {

        resources.sort((Comparator<? super AbstractResource>) resources);
        return resources;
    }

    public Set<IResource> resources() {
        return Collections.unmodifiableSet(resources);
    }

    public void addResource(IResource iResource) {
        resources.add(iResource);
    }

    public void clearResource() {
        resources.clear();
    }

    public void setResource(Set<IResource> resources) {
        this.resources = resources;
    }


}
