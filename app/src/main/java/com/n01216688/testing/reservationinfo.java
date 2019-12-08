package com.n01216688.testing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class reservationinfo extends AppCompatActivity {

    Button reservation;
    FirebaseDatabase database;
    DatabaseReference myref;
    DataStructure mData;
    EditText name, phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservationinfo);
        NumberPicker year = (NumberPicker) findViewById(R.id.picker1);
        NumberPicker month = (NumberPicker) findViewById(R.id.picker2);
        NumberPicker day = (NumberPicker) findViewById(R.id.picker3);
        NumberPicker hour = (NumberPicker) findViewById(R.id.picker4);
        NumberPicker min = (NumberPicker) findViewById(R.id.picker5);
        NumberPicker howMany = (NumberPicker) findViewById(R.id.picker6);
        name = (EditText) findViewById(R.id.reName);
        phone = (EditText) findViewById(R.id.rePhone);

        year.setMinValue(2019);
        year.setMaxValue(2025);
        year.setWrapSelectorWheel(false);

        month.setMinValue(0);

        month.setMaxValue(11);

        month.setDisplayedValues(new String[]{

                "Jan", "Feb", "Mar", "Apr", "May", "June",

                "July", "Aug", "Sep", "Oct", "Nov", "Dec"});
        month.setWrapSelectorWheel(false);


        day.setMinValue(1);
        day.setMaxValue(31);
        day.setWrapSelectorWheel(false);


        hour.setMinValue(0);
        hour.setMaxValue(11);
        hour.setDisplayedValues(new String[]{

                "11", "12", "1", "2", "3", "4", "5",

                "6", "7", "8", "9", "10"});
        hour.setWrapSelectorWheel(false);


        min.setMinValue(0);
        min.setMaxValue(1);
        min.setDisplayedValues(new String[]{"00", "30"});

        howMany.setMinValue(0);
        howMany.setMaxValue(4);
        howMany.setDisplayedValues(new String[]{"1", "2", "3", "4", "more than 4"});
        howMany.setWrapSelectorWheel(false);
    }



}

