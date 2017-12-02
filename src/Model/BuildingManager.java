package Model;

import java.util.HashMap;
import java.util.Map;

public class BuildingManager {
    private static BuildingManager instance = new BuildingManager();


    private Map<String, Building > buildingMap;

    private static final double lat = 42;
    private static final double lon = -123;

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
           building = new Building(null,lat,lon,name);
       }
       return building;
    }

    public int getNumBulding(){
        return buildingMap.size();
    }

    







}
