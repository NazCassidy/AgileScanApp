package agilegroup6.com.agilescanapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.net.HttpURLConnection;

import agilegroup6.com.agilescanapp.models.JSONProcessor;

// created by Nathan Cassidy

public class StudentScanRequest extends AppCompatActivity
{
    private TextView signInResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_scan_request);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        signInResult = (TextView) findViewById(R.id.signInResultText);

        getIntentData();
    }

    // function to grab the data from the passed intent
    public void getIntentData()
    {
        // get the extras and place them into a bundle
        Bundle scanData = getIntent().getExtras();

        // if scan data isn't empty, then assign the data to strings for now
        if(scanData != null)
        {
            final String lectureId = scanData.getString("Content");
            final String userName = scanData.getString("UserName");

            String attendanceRequest = getString(R.string.attendance_request);

            //CODE FOR ASYNC HTTP POST ADAPTED FROM
            //stackoverflow.com/questions/7860538 by Mitsuaki Ishimoto
            //So lets get the JSON response

            JSONProcessor processor = new JSONProcessor();

            processor.setmListener(new JSONProcessor.Listener()

            {
                @Override
                public void onResult(String response)
                {
                    if(response.equals("Logged In"))
                    {
                        signInResult.setText(userName + ", signed in for lecture: " + lectureId);
                    }
                    else
                    {
                        signInResult.setText("Login attempt failed");
                    }
                }
            });

            //Execute the code
            processor.execute(attendanceRequest, lectureId, userName);
        }
    }
}