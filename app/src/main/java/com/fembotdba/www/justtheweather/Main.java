package com.fembotdba.www.justtheweather;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fembotdba.www.justtheweather.Weather;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createGreeting();
        String currentLocation = createDefaultLocation();
        Weather weather = new Weather();
        String temp = weather.getWeather(currentLocation);
        TextView tvTemp = (TextView)findViewById(R.id.tvTemp);
        tvTemp.setText(temp);
        fillCurrentWeatherGraphic();
    }

    public boolean useGPS()
    {
        SharedPreferences prefs = this.getSharedPreferences("com.fembotdba.www.justtheweather", Context.MODE_PRIVATE);
        Boolean settingsGPS = prefs.getBoolean("useGPS", false);
        return settingsGPS;
    }

    public String createDefaultLocation()
    {
        TextView tvLocation = (TextView)findViewById(R.id.tvLocation);
        //stub - get location from gps or saved location
        String currentLocation = "San Diego, CA";
        tvLocation.setText(currentLocation);
        return currentLocation.replace(" ","");
    }

    public void createGreeting()
    {
        TextView tvGreeting = (TextView)findViewById(R.id.txtGreeting);
        SimpleDateFormat simpleFormat = new SimpleDateFormat("EEEE, MMM dd, yyyy", Locale.US);
        Calendar c = Calendar.getInstance();
        String today = simpleFormat.format(c.getTime());
        tvGreeting.setText(today);
    }

    public void fillCurrentWeatherGraphic()
    {
        ImageView ivCurrentWeather = (ImageView)findViewById(R.id.imageWeatherIcon);
        ivCurrentWeather.setImageResource(R.drawable.sunrain);
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
