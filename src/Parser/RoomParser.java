package Parser;


import Model.StudyRoom;
import Model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class RoomParser {

    public static void parse(String jsonResponse) throws JSONException {
        JSONObject object = new JSONObject(jsonResponse);
        String roomType = object.getString("RoomType");
        JSONArray buildings = object.getJSONArray("Buildings");


        if (roomType.equals("StudyRoom")) {
            parseBuildingStudyRooms(buildings);
        } else if (roomType.equals("WashRoom")) {
            perseBuildingWashRooms(buildings);
        }


    }

    private static void parseBuildingStudyRooms(JSONArray buildings) throws org.json.JSONException {


        for (int i = 0; i < buildings.length(); i++) {
            JSONObject building = buildings.getJSONObject(i);

            String buildingName = building.getString("BuildingName");
            JSONArray studyRooms = building.getJSONArray("Rooms");
            for(int x = 0; x < studyRooms.length(); x++) {

                JSONObject studyRoom = studyRooms.getJSONObject(x);

                int floorNum = studyRoom.getInt("Floor");
                String roomNum = studyRoom.getString("RoomNumber");
                int size = studyRoom.getInt("Size");
                Boolean availability = studyRoom.getBoolean("Availability");
                StudyRoom sr = new StudyRoom(BuildingManager.getInstance().getBuildingWithName(buildingName), floorNum);
                sr.setSize(size);
                sr.setRoomNumber(roomNum);
                sr.setAvailability(availability);
                BuildingManager.getInstance().getBuildingWithName(buildingName).addResource(sr);
            }
        }
    }

    private static void perseBuildingWashRooms(JSONArray buildings) throws org.json.JSONException {

        for (int i = 0; i < buildings.length(); i++) {
            JSONObject building = buildings.getJSONObject(i);

            String buildingName = building.getString("BuildingName");
            JSONArray washRooms = building.getJSONArray("Rooms");
            for (int x = 0; x < washRooms.length(); x++) {

                JSONObject washRoom = washRooms.getJSONObject(x);

                int floorNum = washRoom.getInt("Floor");
                String roomNum = washRoom.getString("RoomNumber");
                WashroomType type = WashroomType.getType(washRoom.getString("Type"));

                WashRoom ws = new WashRoom(BuildingManager.getInstance().getBuildingWithName(buildingName), floorNum, roomNum);

                ws.setWashroomType(type);
                BuildingManager.getInstance().getBuildingWithName(buildingName).addResource(ws);
            }
        }
    }

}


