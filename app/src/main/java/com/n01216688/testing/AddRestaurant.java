package com.n01216688.testing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddRestaurant extends AppCompatActivity {

    FirebaseDatabase database1;
    DatabaseReference myref1;
    DataStructure_Restaurantinfo mData1;
    EditText name, phone, address;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        add = findViewById(R.id.add);
        name = findViewById(R.id.restaurant_name);
        phone = findViewById(R.id.restaurant_phone);
        address = findViewById(R.id.restaurant_address);

        getDatabase();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeData(name.getText(), phone.getText(), address.getText());
            }
        });
    }


    private void getDatabase() {
        database1 = FirebaseDatabase.getInstance();
       //FirebaseAuth mAuth = FirebaseAuth.getInstance();

        String path = "restaurantdata";
        myref1 = database1.getReference(path);
    }

    private DataStructure_Restaurantinfo createData(Editable name, Editable phone, Editable address){
      //  Long time = System.currentTimeMillis()/1000;
      //  String timestamp = time.toString();
        return new DataStructure_Restaurantinfo(String.valueOf(name),
                String.valueOf(phone),
                String.valueOf(address));
    }

    private void writeData(Editable name, Editable phone, Editable address) {
        DataStructure_Restaurantinfo mData1 = createData(name,phone,address);
        myref1.push().setValue(mData1).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), "New Restaurant added", Toast.LENGTH_LONG).show();
                openCustomerPage();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Added failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void openCustomerPage() {
        Intent i = new Intent(this,CustomerPage.class);
        startActivity(i);
    }
}
