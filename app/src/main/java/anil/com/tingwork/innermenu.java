package anil.com.tingwork;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class innermenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Questions ques= new Questions();

    private TextView score,questionview;
    private Button ch1,ch2,ch3;

    private String mAnswer;
    private  int mscore=0;
    private  int questionnumber=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innermenu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        score=(TextView)findViewById(R.id.score);
        questionview=(TextView)findViewById(R.id.question);
        ch1=(Button)findViewById(R.id.choice1);
        ch2=(Button)findViewById(R.id.choice2);
        ch3=(Button)findViewById(R.id.choice3);

        updateQuestion();
            //on choice selected
        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ch1.getText()== mAnswer)
                {
                    mscore=mscore+1;
                    updatescore(mscore);
                    updateQuestion();
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"InCorrect",Toast.LENGTH_LONG).show();
                    updateQuestion();
                }
            }
        });
        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ch2.getText()==mAnswer)
                {
                    mscore=mscore+1;
                    updatescore(mscore);
                    updateQuestion();
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"InCorrect",Toast.LENGTH_LONG).show();
                    updateQuestion();
                }
            }
        });
        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ch3.getText()==mAnswer)
                {
                    mscore=mscore+1;
                    updatescore(mscore);
                    updateQuestion();
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"InCorrect",Toast.LENGTH_LONG).show();
                    updateQuestion();
                }
            }
        });

    }
    private void updateQuestion()
    {
        questionview.setText(ques.getquestion(questionnumber));
        ch1.setText(ques.getchoice1(questionnumber));
        ch2.setText(ques.getchoice2(questionnumber));
        ch3.setText(ques.getchoice3(questionnumber));

        mAnswer= ques.getCorrectAnswer(questionnumber);
        questionnumber++;

    }
    private void updatescore(int p)
    {
        score.setText(""+mscore);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile) {
            // Handle the profile action
            Profile pro=new Profile();
            FragmentManager manager= getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.questionlayout,pro).commit();

        } else if (id == R.id.exit) {
            //close the application
            System.exit(0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
