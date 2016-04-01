package app.testingappnew;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView listview;
    Adapter adapter;
    ArrayList<String>   arrayList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        listview = (ListView) findViewById(R.id.listviewdata);
        DoBackGround backGround = new DoBackGround();
        backGround.execute();
    }
    class DoBackGround extends AsyncTask<Void,Void, Boolean>{
        boolean status = true;

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(ListActivity.this);
            progressDialog.setMessage("Please wait . . .");
        }

        @Override
        protected Boolean doInBackground(Void... params)
        {
            for (int i=0; i< 100; i++){
                arrayList.add("Hello World");
            }

            return status;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            adapter = new Adapter(ListActivity.this,arrayList);
            listview.setAdapter(adapter);
            progressDialog.dismiss();
        }
    }
}
