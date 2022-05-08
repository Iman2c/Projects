package edu.qc.seclass.fim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AddEdit extends AppCompatActivity {

    Button btnOk;
    Button btnCancel;
    List<Floors> floorList;
    List<Floors>floorModalList;
    App App = (App)this.getApplication();
    EditText etFloorType;
    EditText etColor;
    EditText etSize;
    EditText etBrand;
    EditText etType;
    EditText etPrice;
    EditText etStock;
    EditText etSpecies;
    EditText etWaterResistant;
    EditText etWaterproof;
    EditText etImageUrl;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        floorList = edu.qc.seclass.fim.App.getFloorList();

        btnOk = findViewById(R.id.btnOK);
        btnOk.setOnClickListener(view -> {
                //create Floor object
            int nextId = edu.qc.seclass.fim.App.getNextID();
            if (id>0){
                //edit
                Floors updatedFloor = new Floors(etFloorType.getText().toString(),etColor.getText().toString(),
                        etSize.getText().toString(), etBrand.getText().toString(), etType.getText().toString(), etPrice.getText().toString(),
                        etStock.getText().toString(), etSpecies.getText().toString(),etWaterResistant.getText().toString(),etWaterproof.getText().toString(), etImageUrl.getText().toString(), nextId);
                floorList.set(nextId,updatedFloor);

            }
            else{
                //new floor

                floorList.add(new Floors(etFloorType.getText().toString(),etColor.getText().toString(),
                        etSize.getText().toString(), etBrand.getText().toString(), etType.getText().toString(), etPrice.getText().toString(),
                        etStock.getText().toString(), etSpecies.getText().toString(),etWaterResistant.getText().toString(),etWaterproof.getText().toString(), etImageUrl.getText().toString(), nextId));
                App.setNextID(nextId++);
                nextId++;
            }



//                Floors newFloor = new Floors (etImageUrl.getText().toString(),etFloorType.getText().toString(),etColor.getText().toString(),
//                        Double.parseDouble(etSize.getText().toString()), etBrand.getText().toString(), etType.getText().toString(), Double.parseDouble(etPrice.getText().toString()),
//                        etStock.getText().toString(), etSpecies.getText().toString(),etWaterResistant.getText().toString(),etWaterproof.getText().toString(), nextId);
                //adds object to list


                //go back to loginin activity
                Intent intent = new Intent(AddEdit.this, LoginIn.class);
                startActivity(intent);
        });

        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(view ->{
                    Intent intent = new Intent(AddEdit.this, LoginIn.class);
                    startActivity(intent);

    });
        btnOk = findViewById(R.id.btnOK);
        btnCancel = findViewById(R.id.btnCancel);
        etImageUrl = findViewById(R.id.etImageUrl);
        etFloorType = findViewById(R.id.etFloorType);
        etColor = findViewById(R.id.etColor);
        etSize = findViewById(R.id.etSize);
        etBrand = findViewById(R.id.etBrand);
        etType = findViewById(R.id.etType);
        etPrice = findViewById(R.id.etPrice);
        etStock = findViewById(R.id.etStock);
        etSpecies = findViewById(R.id.etSpecies);
        etWaterResistant = findViewById(R.id.etWaterResistant);
        etWaterproof = findViewById(R.id.etWaterproof);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        Floors floor = null;

        if (id >= 0){
            //edit floor
            for (Floors f : floorList){
                if (f.getId()==id) {
                    floor = f;
                }
            }
            etImageUrl.setText(floor.getImageUrl());
            etFloorType.setText(floor.getFloorType());
            etColor.setText(floor.getColor());
            etSize.setText(floor.getSize());
            etBrand.setText(floor.getBrand());
            etType.setText(floor.getType());
            etPrice.setText(floor.getPrice());
            etStock.setText(floor.getStock());
            etSpecies.setText(floor.getSpecies());
            etWaterResistant.setText(floor.getWaterResistant());
            etWaterproof.setText(floor.getWaterproof());

        }
        else {

        }
}
}