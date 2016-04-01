package app.testingappnew;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView tv;
    String username = null;
    SharedPreferences prefs;

    Button btn;
    Button webbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv = (TextView) findViewById(R.id.welcomemsg);
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        username =  prefs.getString("sharedusername", username);

        btn = (Button) findViewById(R.id.btnListview);

        webbtn = (Button) findViewById(R.id.webbtn);

        //Bundle extras = getIntent().getExtras();

        //if (extras != null)
        //{
        //   username = extras.getString("username");
        //}
        tv.setText("welcome " + username);
        showToast("Welcome " + username);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intobj = new Intent(SecondActivity.this, ListActivity.class);
                startActivity(intobj);
            }
        });

        webbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intobj1 = new Intent(SecondActivity.this, Webview.class);
                startActivity(intobj1);
            }
        });
    }

    private void showAlert(String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(SecondActivity.this).create();
        alertDialog.setTitle(R.string.app_name);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    void showToast(String message)
    {
        //Show the message below just blinking
        Toast.makeText(SecondActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =  getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_share:
                //Toast.makeText(SecondActivity.this, "Menu Clicked", Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + "1234567890"));
                startActivity(callIntent);

                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
