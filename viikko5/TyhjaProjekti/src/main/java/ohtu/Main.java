package ohtu;

<<<<<<< HEAD
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr;
        if (args.length > 0) {
            studentNr = args[0];
        } else {
            studentNr = new Scanner(System.in).nextLine();
        }

        String url = "http://ohtustats-2015.herokuapp.com/students/" + studentNr + "/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream =  method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        System.out.println("opiskelijanumero " + studentNr + "\n");
        
        int tunteja = 0;
        int tehtyja_tehtavia = 0;
        
        for (Submission submission : subs) {
            tunteja += submission.getHours();
            tehtyja_tehtavia += submission.getCompletedExercises();
            System.out.println(submission);
        }
        System.out.println("\nyhteensä: " + tehtyja_tehtavia + " tehtävää " + tunteja + " tuntia.");

    }
}
=======
public class Main {

    public static void main(String[] args) {
    }
}
>>>>>>> mluukkai-lokaali
