package sunshine.com.sunshine;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Subham Mishra on 23-07-2016.
 */

public class MainActivity extends AppCompatActivity {

    String[] forecastArray1 = {"","","","","","",""};
    Integer[] imageId={
            R.drawable.img,
            R.drawable.img,
            R.drawable.img,
            R.drawable.img,
            R.drawable.img,
            R.drawable.img,
            R.drawable.img
    };

    List<Integer> images;
    ArrayList<String> weekForecast1;
    CustomAdapter adapter;

    public void onClick(View v){
        int id=v.getId();

        if(id==R.id.button){
            for(int i=0;i<10;i++){
                images.add(R.drawable.img);
                weekForecast1.add("");
            }
            adapter.notifyDataSetChanged(images, weekForecast1);
        }
    }
    public void list() {
        ListView listView = (ListView) findViewById(R.id.listview_forecast);
        FrameLayout footerLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.footerview, null);
        listView.addFooterView(footerLayout);
         images = new ArrayList<>(Arrays.asList(imageId));
         weekForecast1 = new ArrayList<>(Arrays.asList(forecastArray1));
        adapter = new
                CustomAdapter(MainActivity.this,weekForecast1 ,images);
        listView.setAdapter(adapter);
        listView.addFooterView(footerLayout);
        //onClick();
        //listView.setAdapter(mForecastAdapter1);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //imageId=new Integer[8];
        //forecastArray=new String[8];

        /**for (int i=0;i<7;i++)
        {
            imageId[i]=R.drawable.img;
            forecastArray[i]=i+"";
        }**/

        list();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}