package ui;


import Model.BuildingManager;

import Parser.BuildingParser;
import com.teamdev.jxmaps.*;
import com.teamdev.jxmaps.javafx.MapView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONException;

import javax.xml.crypto.Data;
import java.io.*;



public class nearME extends Application{
    // Creation of a JavaFX map view

    final static MapView mapView = new MapView();

    @Override
    public void start(final Stage primaryStage) throws JSONException {

    private BorderPane border;
    private VBox selectionPanel;

    private static final String DATA_SOURCE = "./data/BuildingResource";
    private BuildingManager bm = BuildingManager.getInstance();

    @Override
    public void start(final Stage primaryStage) {
        parseResources();

        border = new BorderPane();
        selectionPanel = new VBox();

        primaryStage.setTitle("UBCNearMe");


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

        selectionPanel = new VBox();
        selectionPanel.setPadding(new Insets(10));
        selectionPanel.setSpacing(8);

        Text title = new Text("Resources");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        selectionPanel.getChildren().add(title);

        CheckBox options[] = new CheckBox[]{
                new CheckBox("Washroom"),
                new CheckBox("Water Fountain"),
                new CheckBox("Study Room"),
                new CheckBox("Vending Machine")
        };

        for (int i=0; i<4; i++) {
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            selectionPanel.getChildren().add(options[i]);
        }

        border.setCenter(mapView);
        border.setRight(selectionPanel);

        Scene scene = new Scene(border, 700, 500);
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

    private void parseResources() {
        try {
            InputStream is = new FileInputStream(DATA_SOURCE);
            String jsonData = readSource(is);
            BuildingParser bp = new BuildingParser();
            bp.parseBuilding(jsonData);
        } catch (IOException e) {
            System.out.println("Error reading file...");
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("Error parsing JSON data");
            e.printStackTrace();
        }
    }

    private String readSource(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;

        while((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }

        br.close();

        return sb.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
