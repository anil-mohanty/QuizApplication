package anil.com.tingwork;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Signup extends Activity {

    EditText uname, name, pno, dob, location;
    //Firebase database reference
    private DatabaseReference mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        uname = (EditText) findViewById(R.id.username);
        name = (EditText) findViewById(R.id.name);
        pno = (EditText) findViewById(R.id.pnone_no);
        dob = (EditText) findViewById(R.id.dob);
        location = (EditText) findViewById(R.id.address);
        mdb = FirebaseDatabase.getInstance().getReference();
    }
    //onclick button method
    public void open(View v) {
        String username = uname.getText().toString().trim();
        String fullname = name.getText().toString().trim();
        String cno = pno.getText().toString().trim();
        String dateofbirth = dob.getText().toString().trim();
        String address = location.getText().toString().trim();

        if (username.isEmpty()) {
            uname.setError("Empty");
            uname.requestFocus();
        } else if (fullname.isEmpty()) {
            name.setError("Empty");
            name.requestFocus();

        } else if (cno.isEmpty()) {
            pno.setError("Empty");
            pno.requestFocus();
        } else if (dateofbirth.isEmpty()) {
            dob.setError("Empty");
            dob.requestFocus();
        } else if (address.isEmpty()) {
            location.setError("Empty");
            location.requestFocus();
        } else {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("uname", username);
            hm.put("name", fullname);
            hm.put("cno", cno);
            hm.put("dob", dateofbirth);
            hm.put("add", address);
            //inserting data to firebase realtime database
            mdb.setValue(hm).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Intent i = new Intent(getApplicationContext(), innermenu.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                    }
                }
            });

    }
}}
