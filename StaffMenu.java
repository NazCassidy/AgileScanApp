package agilegroup6.com.agilescanapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

// created by Nathan Cassidy

public class StaffMenu extends AppCompatActivity
{
    private ListView staffMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_menu);

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

        staffMenu = (ListView) findViewById(R.id.staffListMenu);

        setupMenu();
    }

    // function to store the menu setup code.
    public void setupMenu()
    {
        // custom array to be used for the adapter, will print out a liist menu
        final String[] staffOptions = new String[]
                {
                        "View class",
                        "Create class",
                        "Cancel class",
                        "Edit class",
                        "View Attendance Data",
                        "Generate QR Code"
                };

        // creates an adapter to be used alongside the staff list view
        final ArrayAdapter<String> staffMenuAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.staff_list_view, android.R.id.text1, staffOptions);

        // assign adapter to view by passing in our adapter
        staffMenu.setAdapter(staffMenuAdapter);

        staffMenu.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // takes the list item that was selected and stores it
                String userOption = String.valueOf(staffMenu.getItemAtPosition(position));

                switch(position)
                {
                    case 0:
                        // outputs a message to show what was clicked
                        Toast.makeText(getApplicationContext(), userOption, Toast.LENGTH_LONG).show();
                        break;

                    case 1:
                        // outputs a message to show what was clicked
                        Toast.makeText(getApplicationContext(), userOption, Toast.LENGTH_LONG).show();
                        break;

                    case 2:
                        // outputs a message to show what was clicked
                        Toast.makeText(getApplicationContext(), userOption, Toast.LENGTH_LONG).show();
                        break;

                    case 3:  // outputs a message to show what was clicked
                        Toast.makeText(getApplicationContext(), userOption, Toast.LENGTH_LONG).show();
                        break;

                    case 4:
                        // outputs a message to show what was clicked
                        Toast.makeText(getApplicationContext(), userOption, Toast.LENGTH_LONG).show();
                        break;

                    case 5:
                        Intent generateQRCode = new Intent(StaffMenu.this, GenerateQRCode.class);
                        startActivity(generateQRCode);
                        break;
                }
            }
        });
    }
}
