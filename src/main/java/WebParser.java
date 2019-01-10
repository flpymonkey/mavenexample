import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WebParser {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.cs.utexas.edu/~ans/classes/cs439/index.html");

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(url.openStream())) ) {
            String columnNames = br.readLine(); // ONLY do this if it exists
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // TODO parse each line
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // or log error
        }

    }
}
