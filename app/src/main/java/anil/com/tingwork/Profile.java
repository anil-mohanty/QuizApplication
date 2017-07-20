package anil.com.tingwork;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Profile extends Fragment {

    TextView t1,t2,t3,t4,t5;
    //firebase database reference
    DatabaseReference mdb,mdb1,mdb2,mdb3,mdb4;

    public Profile() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          View root=inflater.inflate(R.layout.fragment_profile, container, false);
        t1=(TextView)root.findViewById(R.id.nametext);
        t2=(TextView)root.findViewById(R.id.mobiletext);
        t3=(TextView)root.findViewById(R.id.dobtext);
        t4=(TextView)root.findViewById(R.id.addrssstext);
        t5=(TextView)root.findViewById(R.id.username);
        mdb= FirebaseDatabase.getInstance().getReference().child("name");
        mdb1= FirebaseDatabase.getInstance().getReference().child("cno");
        mdb2= FirebaseDatabase.getInstance().getReference().child("dob");
        mdb3= FirebaseDatabase.getInstance().getReference().child("add");
        mdb4= FirebaseDatabase.getInstance().getReference().child("uname");


        retrive();
        return root;

    }
        //retriving the data from firebase realtime database through database reference and displaying to textview.
   private void retrive() {
       mdb4.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               String uname = dataSnapshot.getValue().toString();
               t5.setText(uname);
           }
           @Override
           public void onCancelled(DatabaseError databaseError) {
           }
       });
        mdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue().toString();
                t1.setText(name);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
       mdb1.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               String cno = dataSnapshot.getValue().toString();
               t2.setText(cno);
           }
           @Override
           public void onCancelled(DatabaseError databaseError) {
           }
       });
       mdb2.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               String dob = dataSnapshot.getValue().toString();
               t3.setText(dob);
           }
           @Override
           public void onCancelled(DatabaseError databaseError) {
           }
       });
       mdb3.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               String address = dataSnapshot.getValue().toString();
               t4.setText(address);
           }
           @Override
           public void onCancelled(DatabaseError databaseError) {
           }
       });


    }

}
