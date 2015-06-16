package com.fembotdba.www.justtheweather;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Lara on 6/15/2015.
 */
public class Weather {

    public String getWeather(String location)
    {
        HttpURLConnection conn = null;
        InputStream stream = null;
        try
        {
            conn = (HttpURLConnection)(new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location)).openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.connect();
        }
        catch (Throwable error)
        {
            error.printStackTrace();
        }

        return "nothing to see here";
    }

}
