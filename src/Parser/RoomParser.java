package Parser;

import Model.Building;
import Model.StudyRoom;
import Model.WashRoom;
import Model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class RoomParser {

    public static void parse(String jsonResponse) throws JSONException {
        JSONObject object = new JSONObject(jsonResponse);
        String roomType = object.getString("RoomType");
        JSONArray rooms = object.getJSONArray("Rooms");


        if (roomType.equals("StudyRoom")) {
            parseStudyRooms(rooms);
        } else if (roomType.equals("WashRoom")) {
            parseWashRoom(rooms);
        }


    }


    public static void parseStudyRooms(JSONArray studyRooms) throws org.json.JSONException {

        for (int i = 0; i < studyRooms.length(); i++) {
            JSONObject studyRoom = studyRooms.getJSONObject(i);

            String building = studyRoom.getString("Building");
            int floorNum = studyRoom.getInt("Floor");
            String roomNum = studyRoom.getString("RoomNum");
            int size = studyRoom.getInt("Size");
            Boolean availability = studyRoom.getBoolean("Availability");
            StudyRoom sr = new StudyRoom(BuildingManager.getInstance().getBuildingWithName(building), floorNum);
            sr.setSize(size);
            sr.setRoomNumber(roomNum);
            sr.setAvailability(availability);
            BuildingManager.getInstance().getBuildingWithName(building).addResource(sr);

        }
    }

    public static void parseWashRoom(JSONArray washRooms) throws org.json.JSONException {

        for (int i = 0; i < washRooms.length(); i++) {
            JSONObject washRoom = washRooms.getJSONObject(i);

            String building = washRoom.getString("Building");
            int floorNum = washRoom.getInt("Floor");
            String roomNum = washRoom.getString("RoomNum");
            String gender = washRoom.getString("Type");
            WashRoom wr = new WashRoom(BuildingManager.getInstance().getBuildingWithName(building), floorNum, roomNum);
            WashroomType ws = WashroomType.getType(gender);
            wr.setWashroomType(ws);
            BuildingManager.getInstance().getBuildingWithName(building).addResource(wr);
        }
    }

}


