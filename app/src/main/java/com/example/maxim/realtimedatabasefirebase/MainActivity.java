package com.example.maxim.realtimedatabasefirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText loginEdit = findViewById(R.id.loginEditText);
    EditText passwordEdit = findViewById(R.id.passwordEditText);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener oclBtnReg = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textLogin = loginEdit.getText().toString();
                String textPassword = passwordEdit.getText().toString();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference().child("realtimedatabase-7ee55");
                HashMap<String, String> user = new HashMap<>();
                user.put("login", textLogin);
                databaseReference.setValue(user);
            }
        };
        Button registration = findViewById(R.id.registrationButton);
        registration.setOnClickListener(oclBtnReg);
    }
}


        /*databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot!=null && dataSnapshot.exists()){
                    HashMap<String,String> studentData=dataSnapshot.getValue(HashMap.class);
                    Log.d("Student Roll Num "," : "+studentData.get("RollNo"));
                    Log.d("Student Name "," : "+studentData.get("Name"));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("ERROR",databaseError.toString());
            }
        });*/