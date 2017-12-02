package Model;

import java.util.HashMap;
import java.util.Map;

public class BuildingManager {
    private static BuildingManager instance = new BuildingManager();

    private Building selected;

    private Map<String, Building > buildingMap;

    private static final double DEFAULT_LAT = 42;
    private static final double DEFAULT_LON = -123;
    private static final String DEFAULT_HOURS = "10AM-5PM";

    private BuildingManager() {
        this.buildingMap = new HashMap<>();
    }


    public static BuildingManager getInstance() {
        if(instance == null){
            instance = new BuildingManager();
        }
        return instance;
    }


    public Building getBuildingWithName(String name){
       Building building = buildingMap.get(name);
       if(building != null){
           return building;
       }else{
           building = new Building(DEFAULT_HOURS,DEFAULT_LAT,DEFAULT_LON,name);
       }
       buildingMap.put(name,building);
       return building;
    }

    public Building getBuilding(String hours, double lat, double lon, String name){
        Building building = buildingMap.get(name);
        if(building != null){
            return building;
        }else{
            building = new Building(hours,lat,lon,name);
        }
        buildingMap.put(name,building);
        return building;
    }




    public int getNumBuldings(){
        return buildingMap.size();
    }


    public void setSelected(Building building){
        if(buildingMap.containsKey(building.getName())){
            selected = building;
        }
    }

    public void clearSelected(){
        selected = null;
    }

    public Building getSelected(){
        return selected;
    }







}
