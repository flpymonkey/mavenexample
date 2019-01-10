import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WebParser {
    public static void main(String[] args) throws MalformedURLException {
        parseCSVURL("https://vincentarelbundock.github.io/Rdatasets/csv/boot/acme.csv");
        parseImageUrl("https://i.imgur.com/tK4vvBf.jpg");
    }

    public static void parseImageUrl(String url) throws MalformedURLException{
        URL url_obj = new URL(url);
        try {
            BufferedImage img = ImageIO.read(url_obj);
            int height = img.getHeight(null);
            int width = img.getWidth(null);
            int[][] data = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int rgb = img.getRGB(i, j); // negative integers
                    data[i][j] = rgb;
                    System.out.println(rgb);
                }
            }
        } catch (IOException e) {
            // handle exception
            System.out.println("Error!");
        }

    }

    public static void parseCSVURL(String url) throws MalformedURLException{
        URL url_obj = new URL(url);

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(url_obj.openStream())) ) {
            String columnNames = br.readLine(); // ONLY do this if it exists
            String line;
            while ((line = br.readLine()) != null) {
                /* parse each line */
                CSVParser parser = CSVParser.parse(line, CSVFormat.RFC4180);
                for(CSVRecord cr : parser) {
                    String one = cr.get(1); // columns start at 1 not 0 !!!
                    String two = cr.get(2);
                    String three = cr.get(3);
                    //String four = cr.get(4);
                    System.out.println("======");
                    System.out.println("Column One: " + one);
                    System.out.println("Column Two: " + two);
                    System.out.println("Column Three: " + three);
                    //System.out.println("Column Four: " + four);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // or log error
        }
    }
}
