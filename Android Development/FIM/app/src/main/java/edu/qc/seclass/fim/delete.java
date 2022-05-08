package edu.qc.seclass.fim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.util.List;

public class delete extends AppCompatActivity {
    List<Floors> floorList;
    Button deleteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        floorList = edu.qc.seclass.fim.App.getFloorList();
        deleteBtn = findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(view ->{
           // floorList.remove();
        });
    }
}