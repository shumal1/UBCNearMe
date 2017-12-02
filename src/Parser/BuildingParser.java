package Parser;

import Model.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class BuildingParser {

    public static void parseBuilding(String jsonResponse) throws org.json.JSONException {
        JSONArray buildings = new JSONArray(jsonResponse);
        for (int i = 0; i < buildings.length(); i++) {
            JSONObject cs = buildings.getJSONObject(i);
            String name = cs.getString("Name");
            Double lat = cs.getDouble("Latitude");
            Double lon = cs.getDouble("Longitude");
            String hours = cs.getString("Hours");


           BuildingManager.getInstance().getBuilding(hours,lat,lon,name);

        }
    }
}
