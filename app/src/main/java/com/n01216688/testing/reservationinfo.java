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
    FirebaseDatabase database, database2;
    DatabaseReference myref, myref2;
    DataStructure_ReservationInfo mData;
    EditText name, phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservationinfo);
        final NumberPicker tableno = (NumberPicker) findViewById(R.id.picker7);
        NumberPicker month = (NumberPicker) findViewById(R.id.picker2);
        NumberPicker day = (NumberPicker) findViewById(R.id.picker3);
        NumberPicker hour = (NumberPicker) findViewById(R.id.picker4);
        NumberPicker min = (NumberPicker) findViewById(R.id.picker5);
        final NumberPicker howMany = (NumberPicker) findViewById(R.id.picker6);
        name = (EditText) findViewById(R.id.reName);
        phone = (EditText) findViewById(R.id.rePhone);
        Button book = (Button) findViewById(R.id.Book);

        getSupportActionBar().setTitle("Reservation Page");

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
        hour.setMaxValue(23);
        hour.setDisplayedValues(new String[]{

               "0", "1", "2", "3", "4", "5", "6", "7",

                "8", "9", "10", "11", "12", "13", "14",

                "15", "16", "17", "18", "19", "20", "21", "22", "23" });
        hour.setWrapSelectorWheel(false);


        min.setMinValue(00);
        min.setMaxValue(59);
        min.setWrapSelectorWheel(false);

        howMany.setMinValue(0);
        howMany.setMaxValue(4);
        howMany.setDisplayedValues(new String[]{"1", "2", "3", "4", "more than 4"});
        howMany.setWrapSelectorWheel(false);

        tableno.setMinValue(0);
        tableno.setMaxValue(100);
        tableno.setWrapSelectorWheel(false);

        final String realdate = String.valueOf(month) + "/" + String.valueOf(day);
        final String realtime = String.valueOf(hour) + ":" + String.valueOf(min);

        getDatabase();

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeData(name.getText(), phone.getText(), String.valueOf(realdate), String.valueOf(realtime), String.valueOf(howMany), String.valueOf(tableno));
            }
        });
    }

    private void getDatabase() {
        database = FirebaseDatabase.getInstance();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        String path = "reservationdata/";
        myref = database.getReference(path);
    }



    private void writeData(Editable cname, Editable cphone, String cdate, String ctime, String csize, String ctable){
        DataStructure_ReservationInfo mData = createData(cname,cphone,cdate,ctime,csize,ctable);
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

    private DataStructure_ReservationInfo createData(Editable cname, Editable cphone, String cdate, String ctime, String csize, String ctable){
        return new DataStructure_ReservationInfo(String.valueOf(cname)
        , String.valueOf(cphone), String.valueOf(cdate),
                String.valueOf(ctime), String.valueOf(csize),
                String.valueOf(ctable));
    }
}

