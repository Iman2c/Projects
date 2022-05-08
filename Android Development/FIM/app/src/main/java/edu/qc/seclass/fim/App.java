
package edu.qc.seclass.fim;

import com.parse.Parse;
import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        );
    }

    private static List<Floors> floorList = new ArrayList<Floors>();
    private static int nextID = 6;
//    public App() {
//        fillFloorList();
//    }

    public static List<Floors> getFloorList() {
        return floorList;
    }

    public static void setFloorList(List<Floors> floorList) {
        App.floorList = floorList;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        App.nextID = nextID;
    }

//    private void fillFloorList() {
//        Floors woodFloor1 = new Floors("wood", "brown", 10.0, "Queens", "Solid", 9.99, 101.5, "Oak", "N/A", "N/A", "https://freesvg.org/img/material-wood.png", 1);
//        Floors woodFloor2 = new Floors("wood", "dark brown", 10.0, "Queens", "Engineered", 9.99, 500.0, "Hickory", "N/A", "N/A", "https://freesvg.org/img/material-wood.png", 2);
//
//        floorList.addAll(Arrays.asList(new Floors[]{woodFloor1, woodFloor2}));
//    }
}
