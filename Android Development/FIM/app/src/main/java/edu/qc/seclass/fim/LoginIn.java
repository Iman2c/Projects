package edu.qc.seclass.fim;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

//Search Function Imports

public class LoginIn extends AppCompatActivity {

    private static final String TAG = "Floor";
    Button button;

    App App = (App) this.getApplication();
    List<Floors> floorList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;

    // creating variables for
    // our ui components.
    private RecyclerView floorRv;

    // variable for our adapter
    // class and array list
    private RecycleViewAdapter adapter;
    private List<Floors> floorModalList;

    private String selectedFilter = "all";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);

        floorList = edu.qc.seclass.fim.App.getFloorList();

        TextView tvNoData = findViewById(R.id.tvNoData);

        Log.d(TAG, "onCreate: " + floorList.toString());
        button = findViewById(R.id.btnAdd);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // set variable for employee status
                boolean employeeStatus = Boolean.valueOf(ParseUser.getCurrentUser().getBoolean("isEmployee"));

                // if an employee clicks on the button, change the activity
                if(employeeStatus) {
                    Intent intent = new Intent(LoginIn.this, AddEdit.class);
                    startActivity(intent);
                }

                // otherwise, throw an error
                else {
                    Toast.makeText(getApplicationContext(), "Access Denied.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        recyclerView = findViewById(R.id.rvfloorLayout);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Adapter = new RecycleViewAdapter(floorList, this);
        recyclerView.setAdapter(Adapter);

        // initializing our variables
        floorRv = findViewById(R.id.rvfloorLayout);

        // calling method to
        // build recycler view.
        buildRecyclerView();
    }
    // calling on create option menu
    // layout to inflate our menu file.




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // below line is to get our inflater
        MenuInflater inflater = getMenuInflater();

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_menu, menu);

        // below line is to get our menu item.
        MenuItem searchItem = menu.findItem(R.id.actionSearch);

        // getting search view of our item.
        SearchView searchView = (SearchView) searchItem.getActionView();

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return false;
            }
        });
        return true;
    }
    private void filter(String text) {

        // creating a new array list to filter our data.
        ArrayList<Floors> filteredlist = new ArrayList<>();

        // create an string array for the input text
        String[] searchTerms = text.split(" ");

        // running a for loop to compare elements.
        for (Floors item : floorList) {
            // checking if the entered string matched with any item of our recycler view.
            // search of floorCategory or floorType

            /**
             // below is faulty logic, can't get to search by category then type just either or
             final String floorCategory = item.getFloorType().toLowerCase() + ",";
             final String floorType = item.getType().toLowerCase();
             if ((item.getId()==3) && item.getType().toLowerCase().contains(floorType)) {
             filteredlist.add(item);
             }
             **/

            //if one of the search terms is given
            if ((item.getFloorType().toLowerCase().contains(text.toLowerCase()) || item.getType().toLowerCase().contains(text.toLowerCase()))) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }

            //if both of the search terms are given
            if (searchTerms.length > 1) {
                // clear the list
                filteredlist.clear();

                // check first term for type or category and second term for type and category
                if ((item.getFloorType().toLowerCase().contains(searchTerms[0].toLowerCase()) || item.getType().toLowerCase().contains(searchTerms[0].toLowerCase()))
                        && (item.getFloorType().toLowerCase().contains(searchTerms[1].toLowerCase()) || item.getType().toLowerCase().contains(searchTerms[1].toLowerCase()))) {
                    filteredlist.add(item);
                }
            }

            /**
             for(String i : searchTerms) {

             //handling if there is one search term given
             while(i.length() == 1){
             if ((item.getFloorType().toLowerCase().contains(i.toLowerCase()) || item.getType().toLowerCase().contains(i.toLowerCase()))) {
             // if the item is matched we are
             // adding it to our filtered list.
             filteredlist.add(item);
             }
             }
             }
             **/
        }
        // at last we are passing that filtered
        // list to our adapter class.

        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            findViewById(R.id.tvNoData).setVisibility(View.VISIBLE);
//            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            findViewById(R.id.tvNoData).setVisibility(View.INVISIBLE);
        }

        adapter.filterList(filteredlist);
    }

    public void allFilter(View view){
        filter("");
    }
    public void tileFilter(View view){
        filter("Tile");
    }


    public void stoneFilter(View view){
        filter("Stone");
    }

    public void woodFilter(View view){
        filter("Wood");
    }

    public void laminateFilter(View view){
        filter("Laminate");
    }

    public void vinylFilter(View view){
        filter("Vinyl");
    }


    private void buildRecyclerView() {

        // below line we are creating a new array list

//    }

        // below line is to add data to our array list.
        floorList.add(new Floors("wood", "brown", "10.0", "Queens", "Solid", "9.99", "101.5", "Oak", "N/A", "N/A", "https://freesvg.org/img/material-wood.png", 1));
        floorList.add(new Floors("wood", "dark brown", "10.0", "Queens", "Engineered", "9.99", "500.0", "Hickory", "N/A", "N/A", "https://freesvg.org/img/material-wood.png", 2));
        floorList.add(new Floors("Wood","Brown","10.0","Queens","Solid","9.99","101.20","Oak","Yes","Yes","https://parsefiles.back4app.com/OEY0Wls5ko61tRZS8VLC36ve9ZscOoQDW6snPK6v/21d35484863a80b64844823bba72375a_wood.jpg",3));
        floorList.add(new Floors("Laminate","Light-Brown","10.0","John Jay","Engineered","15.99","101.20","Cherry","Yes","Yes","https://parsefiles.back4app.com/OEY0Wls5ko61tRZS8VLC36ve9ZscOoQDW6snPK6v/21d35484863a80b64844823bba72375a_wood.jpg",4));
        floorList.add(new Floors("Wood","Dark-Brown","10.0","Hunter","Bamboo","25.99","45.34","Maple","No","No","https://parsefiles.back4app.com/OEY0Wls5ko61tRZS8VLC36ve9ZscOoQDW6snPK6v/21d35484863a80b64844823bba72375a_wood.jpg",5));
        floorList.add(new Floors("wood", "brown", "10.0", "Queens", "Solid", "9.99", "101.5", "Oak", "N/A", "N/A", "https://freesvg.org/img/material-wood.png", 6));
        floorList.add(new Floors("wood", "dark brown", "10.0", "Queens", "Engineered", "9.99", "500.0", "Hickory", "N/A", "N/A", "https://freesvg.org/img/material-wood.png", 7));
        floorList.add(new Floors("wood", "light brown", "10.0", "Queens", "Bamboo", "9.99", "102", "Maple", "N/A", "N/A", "https://freesvg.org/img/material-wood.png ", 8));
        floorList.add(new Floors("Stone", "Blue", "11.0", "Baruch", "Marble", "9.99", "101.5", "N/A", "no", "no", "https://freesvg.org/storage/img/thumb/stroked-tile.png", 9));
        floorList.add(new Floors("Stone", "Brown", "12.0", "Hunter", "Pebble", "11.99", "64.5", "N/A", "no", "no", "https://freesvg.org/storage/img/thumb/stone-pack-3.png", 10));
        floorList.add(new Floors("Stone", "Gray", "11.0", "Queens", "Slate", "7.99", "64.0", "N/A", "no", "no", "https://freesvg.org/storage/img/thumb/Brick%20texture%20floor.png", 11));
        floorList.add(new Floors("Stone", "Green", "10.0", "Queens", "Marble", "9.99", "75.5", "N/A", "no", "no", "https://freesvg.org/storage/img/thumb/FloweryPattern2.png", 12));
        floorList.add(new Floors("Stone", "Dark Blue", "8.0", "Hunter", "Slate", "9.99", "85.0", "N/A", "no", "no", "https://freesvg.org/storage/img/thumb/Paving6.png", 13));
        floorList.add(new Floors("Tile", "Red", "8.0", "Queens", "Porcelain", "14.99", "95.0", "N/A", "yes", "yes", "https://freesvg.org/storage/img/thumb/Carpet2.png", 14));
        floorList.add(new Floors("Tile", "Brown", "14.0", "Baruch", "Ceramic", "14.99", "48.0", "N/A", "yes", "yes", "https://freesvg.org/storage/img/thumb/PineLaminate.png", 15));
        floorList.add(new Floors("Tile", "Dark Brown", "12.0", "Baruch", "Resin", "14.99", "37.0", "N/A", "yes", "no", "https://freesvg.org/storage/img/thumb/rocks-seamless-details.png", 16));
        floorList.add(new Floors("Tile", "Green", "10.0", "Queens", "Resin", "12.99", "26.0", "N/A", "no", "no", "https://freesvg.org/storage/img/thumb/StoneWall2.png", 17));
        floorList.add(new Floors("Tile", "Blue", "10.0", "Hunter", "Ceramic", "9.99", "16.0", "N/A", "yes", "no", "https://freesvg.org/storage/img/thumb/BackgroundPattern226Colour2.png", 18));
        String vinyl_png = "https://freesvg.org/img/Flooring-material-01.png";
        floorList.add(new Floors("Vinyl", "Light-Grey", "20.0", "Queens", "N/A", "9.99", "101.5", "N/A", "Yes", "No", vinyl_png, 19));
        floorList.add(new Floors("Vinyl", "Brown", "10.0", "Brooklyn", "N/A", "9.99", "500.0", "N/A", "No", "Yes", vinyl_png, 20));
        floorList.add(new Floors("Vinyl","Grey","15.0","Queens","N/A","9.99","101.20","N/A","No","Yes",vinyl_png,21));
        floorList.add(new Floors("Vinyl","Light-Brown","12.0","City","N/A","15.99","101.20","N/A","No","Yes", vinyl_png,22));
        floorList.add(new Floors("Vinyl","Dark-Brown","10.0","Hunter","N/A","25.99","45.34","N/A","Yes","No",vinyl_png,23));
        String laminate_png = "https://freesvg.org/img/wg-9.png";
        floorList.add(new Floors("Laminate", "Brown", "20.0", "York", "Resistant", "9.99", "101.5", "N/A", "Yes", "N/A", laminate_png, 24));
        floorList.add(new Floors("Laminate", "Auburn", "10.0", "Stonybrook", "Resistant", "9.99", "500.0", "N/A", "Yes", "N/A", laminate_png, 25));
        floorList.add(new Floors("Laminate","Chestnut","15.0","LaGuardia","Regular","12.99","301.20","N/A","No","N/A",laminate_png,26));
        floorList.add(new Floors("Laminate","Dark-Brown","12.0","Queens","Regular","13.99","101.20","N/A","No","N/A", laminate_png,27));
        floorList.add(new Floors("Laminate","Grey","20.0","Hunter","Regular","25.99","45.34","N/A","No","N/A",laminate_png,28));

        // initializing our adapter class.
        adapter = new RecycleViewAdapter(floorList, LoginIn.this);

        // adding layout manager to our recycler view.
        LinearLayoutManager manager = new LinearLayoutManager(this);
        floorRv.setHasFixedSize(true);

        // setting layout manager
        // to our recycler view.
        floorRv.setLayoutManager(manager);

        // setting adapter to
        // our recycler view.
        floorRv.setAdapter(adapter);
    }

}