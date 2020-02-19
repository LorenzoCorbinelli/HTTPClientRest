package httpclientrest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient 
{
    private URL url;
    private HttpURLConnection conn;
    private BufferedReader br;
    private OutputStream os;
    private String output;
    private String input;
    
    public RestClient()
    {
        try
        {
            url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
            conn = (HttpURLConnection) url.openConnection();
            br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            os = conn.getOutputStream();
        }catch(Exception e){}
    }
    
    public void get()
    {
        try
        {
            conn.connect();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.getResponseCode();
            output = br.readLine();
            while(output!=null)
            {
                System.out.println(output);
                output = br.readLine();
            }
            conn.disconnect();
        }catch(Exception e){System.out.println(e);}
    }
    
    public void post()
    {
        try
        {
            conn.connect();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            input = "{ \"employeeId\": 10,\"firstName\": \"mario\",\"lastName\": \"rossi\", \"email\": \"mario@rossi.com\", \"phone\": \"3568945\" }";
            os.write(input.getBytes());
            os.flush();
            conn.getResponseCode();
            
            output = br.readLine();
            while(output!=null)
            {
                System.out.println(output);
                output = br.readLine();
            }
            conn.disconnect();
        }catch(Exception e){}
    }
}
