package agilegroup6.com.agilescanapp.models;

import android.os.AsyncTask;

import javax.net.ssl.HttpsURLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
/**
 * Created by Liam on 25/02/2016.
 */
public class HTTPPoster extends AsyncTask<String,String,String>
{
    public String doInBackground(String... Params)
    {
        try
        {
            return makeLoginPost();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    //Variables that will be used to POST
    private URL url;
    private String login;
    private String password;
    private String email;
    private String lectureid;

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setLectureid(String lectureid)
    {
        this.lectureid = lectureid;
    }

    //Accessor methods
    public void setUrl(URL url)
    {
        this.url = url;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public HTTPPoster()
    {

    }

    public String makeLoginPost()throws Exception
    {
        //Create HTTPSurlConnection object
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        //Set the request method
        connection.setRequestMethod("POST");

        //Build the parameter string needed
        String postdata = "dualLogin=Submit&logindetail="+login+"&password="+password;

        //Send post the post request
        connection.setDoOutput(true);

        //Create the output stream
        DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());

        //Write to the output stream
        outstream.writeBytes(postdata);

        //Flush the  output stream
        outstream.flush();

        //And then close it..
        outstream.close();

        //New buffered reader object that reads the response
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        //String that we will use to read the reply line by line
        String lineReader;

        //String buffer that we use to buffer the response
        StringBuffer response = new StringBuffer();

        //While each line isn't null
        while((lineReader = br.readLine()) != null)
        {
            response.append(lineReader);
        }
        //Close the buffered reader
        br.close();

        //Return the response
        return response.toString();
    }

    // MADE BY NATHAN (copy of Liams code above, need to look at refactoring as it's almost exact duplicates aside from variables being passed)
    public String makeAttendancePost()throws Exception
    {
        //Create HTTPSurlConnection object
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        //Set the request method
        connection.setRequestMethod("POST");

        //Build the parameter string needed
        String postdata = "submitAttendance=Submit&lectureid="+lectureid+"&email="+email;

        //Send post the post request
        connection.setDoOutput(true);

        //Create the output stream
        DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());

        //Write to the output stream
        outstream.writeBytes(postdata);

        //Flush the  output stream
        outstream.flush();

        //And then close it..
        outstream.close();

        //New buffered reader object that reads the response
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        //String that we will use to read the reply line by line
        String lineReader;

        //String buffer that we use to buffer the response
        StringBuffer response = new StringBuffer();

        //While each line isn't null
        while((lineReader = br.readLine()) != null)
        {
            response.append(lineReader);
        }
        //Close the buffered reader
        br.close();

        //Return the response
        return response.toString();
    }
}