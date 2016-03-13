package agilegroup6.com.agilescanapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

// Created by Nathan Cassidy

public class GenerateQRCode extends AppCompatActivity
{
    // STANDARD BLANK ACTIVITY CODE
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qrcode);

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

        generateCode();
    }

    // Function which generates code by using the zxing libraries/3rd party app
    // Refer to main activity for reference to this particular open source project.
    public void generateCode()
    {
        String lectureId = "10";

        // Passes an intent to the zxing client, this is attached with data to be encrypted into a QR code.
        Intent intent = new Intent("com.google.zxing.client.android.ENCODE");
        intent.putExtra("ENCODE_FORMAT", "QR_CODE");
        intent.putExtra("ENCODE_TYPE", "TEXT_TYPE");
        intent.putExtra("ENCODE_DATA", lectureId);

        // try catch block to try passing the intent to the 3rd party app (referenced in main).
        try
        {
            startActivityForResult(intent,0);
        }
        catch (ActivityNotFoundException e)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "com.google.zxing.client.android")));
        }
    }
}