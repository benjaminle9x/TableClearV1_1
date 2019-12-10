package com.n01216688.testing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class reservationinfo extends AppCompatActivity {

    FirebaseDatabase database, database2;
    DatabaseReference myref, myref2;
    DataStructure_ReservationInfo mData;
    EditText name, phone, rname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservationinfo);
        final NumberPicker tableno = (NumberPicker) findViewById(R.id.picker7);
        final NumberPicker month = (NumberPicker) findViewById(R.id.picker2);
        final NumberPicker day = (NumberPicker) findViewById(R.id.picker3);
        final NumberPicker hour = (NumberPicker) findViewById(R.id.picker4);
        final NumberPicker min = (NumberPicker) findViewById(R.id.picker5);
        final NumberPicker howMany = (NumberPicker) findViewById(R.id.picker6);
        name = (EditText) findViewById(R.id.reName);
        phone = (EditText) findViewById(R.id.rePhone);
        rname = (EditText) findViewById(R.id.reRes);
        Button book = (Button) findViewById(R.id.Book);

        getSupportActionBar().setTitle("Reservation Page");

        month.setMinValue(1);

        month.setMaxValue(12);

        month.setDisplayedValues(new String[]{

                "1", "2", "3", "4", "5", "6",

                "7", "8", "9", "10", "11", "12"});
        month.setWrapSelectorWheel(false);


        day.setMinValue(1);
        day.setMaxValue(31);
        day.setWrapSelectorWheel(false);


        hour.setMinValue(0);
        hour.setMaxValue(23);
        hour.setDisplayedValues(new String[]{

               "0", "1", "2", "3", "4", "5", "6", "7",

                "8", "9", "10", "11", "12", "13", "14",

                "15", "16", "17", "18", "19", "20", "21", "22", "23" });
        hour.setWrapSelectorWheel(false);


        min.setMinValue(00);
        min.setMaxValue(59);
        min.setWrapSelectorWheel(false);

        howMany.setMinValue(1);
        howMany.setMaxValue(5);
        howMany.setDisplayedValues(new String[]{"1", "2", "3", "4", "5"});
        howMany.setWrapSelectorWheel(false);

        tableno.setMinValue(1);
        tableno.setMaxValue(100);
        tableno.setWrapSelectorWheel(false);

        getDatabase();
        
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeData(name.getText(), phone.getText(), month.getValue() + "/" + day.getValue(),
                        Integer.toString(hour.getValue()) + ":" + Integer.toString(min.getValue()),
                        Integer.toString(howMany.getValue()), Integer.toString(tableno.getValue()), rname.getText());
            }
        });
    }

    private void getDatabase() {
        database = FirebaseDatabase.getInstance();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        String path = "reservationdata/";
        myref = database.getReference(path);
    }



    private void writeData(Editable cname, Editable cphone, String cdate, String ctime, String csize, String ctable, Editable rname){
        DataStructure_ReservationInfo mData = createData(cname,cphone,cdate,ctime,csize,ctable,rname);
        myref.push().setValue(mData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), "Table has been booked", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Booking failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    private DataStructure_ReservationInfo createData(Editable cname, Editable cphone, String cdate, String ctime, String csize, String ctable, Editable rname){
        return new DataStructure_ReservationInfo(String.valueOf(cname)
        , String.valueOf(cphone), String.valueOf(cdate),
                String.valueOf(ctime), String.valueOf(csize),
                String.valueOf(ctable), String.valueOf(rname));
    }

}

