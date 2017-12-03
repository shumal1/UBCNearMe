package ui;



import Parser.BuildingParser;
import com.teamdev.jxmaps.*;
import com.teamdev.jxmaps.javafx.MapView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.json.JSONException;


public class nearME extends Application{
    // Creation of a JavaFX map view
    final static MapView mapView = new MapView();

    @Override
    public void start(final Stage primaryStage) throws JSONException {

        // Setting of a ready handler to MapView object. onMapReady will be called when map initialization is done and
        // the map object is ready to use. Current implementation of onMapReady customizes the map object.
        mapView.setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                // Check if the map is loaded correctly
                if (status == MapStatus.MAP_STATUS_OK) {
                    // Getting the associated map object
                    final Map map = mapView.getMap();
                    // Creating a map options object
                    MapOptions options = new MapOptions();
                    // Creating a map type control options object
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    // Changing position of the map type control
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    // Setting map type control options
                    options.setMapTypeControlOptions(controlOptions);
                    // Setting map options
                    map.setOptions(options);
                    // Setting the map center
                    map.setCenter(new LatLng(49.261178, -123.248804));
                    // Setting initial zoom value
                    map.setZoom(17.0);
                    setMarker();
                }
            }
        }
        );

        Scene scene = new Scene(new BorderPane(mapView), 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();



    }

    public void setMarker(){
        Marker marker = new Marker(mapView.getMap());

        Symbol symbol = new Symbol();
        symbol.setFillColor("Red");

        marker.setPosition(new LatLng(49.261178, -123.248804));
        marker.setIcon(symbol);

        marker.setClickable(true);
        marker.dispose();

        marker.addEventListener("click", new MapMouseEvent() {
            @Override
            public void onEvent(MouseEvent mouseEvent) {
                InfoWindow infoWindow = new InfoWindow(mapView.getMap());
                String studyRoomNames = "Study Rooms";

                infoWindow.setContent(studyRoomNames);

                infoWindow.setPosition(new LatLng(49.261178, -123.248804));
                infoWindow.open(mapView.getMap());
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
