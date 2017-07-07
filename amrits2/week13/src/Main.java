/**
 * Created by amrits2 on 2/2/2017.
 */
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        /**
         * accounts for difference if argument takes a number of movies that is not a multiple of 20 (i.e someone wants to choose from 35 movies, so they get only 35 instead of 40)
         */

        int numMovies = Integer.parseInt(args[0]);
        int finalPgNum = numMovies / 20 + 1;
        numMovies = numMovies % 20;

        int option = Integer.parseInt(args[1]);
        double id = 0;
        double rating = 0;
        double popularity = 0;

        if (option == 2) {
            id = Double.parseDouble(args[2]);
        }

        if (option == 3) {
            rating = Double.parseDouble(args[2]);
        }

        if (option == 4) {
            popularity = Double.parseDouble(args[2]);
        }

        for (int pageNum = 1; pageNum < finalPgNum; pageNum++) {

            /**
             * fetches data from DB
             */

            URL url = new URL("https://api.themoviedb.org/3/movie/popular?api_key=" + MovieParserExtension.APIKey + "&page=" + pageNum);
            InputStream inStream = url.openStream();
            InputStreamReader reader = new InputStreamReader(inStream, Charset.forName("UTF-8"));

            JsonReader jsonReader = new JsonReader(reader);
            Gson gson = new Gson();
            MovieCollection movieCollection = gson.fromJson(jsonReader, MovieCollection.class);

            /**
             * handles case when user does not pick movies that are multiple of 20. goes to the last page and picks whatever fraction of 20 is required.
             */

            if (pageNum == finalPgNum) {
                if (option == 1) {
                    System.out.println(movieCollection.getTitles(numMovies));
                }
                if (option == 2) {
                    System.out.println(movieCollection.getTitlesByGenre(id, numMovies));
                }
                if (option == 3) {
                    System.out.println(movieCollection.getTitlesByVoteAverage(rating, numMovies));
                }
                if (option == 4) {
                    System.out.println(movieCollection.getPopularTitles(popularity, numMovies));
                }

                /**
                 * picks out movies from previous pages before the last page when partial pages must be considered.
                 */

            } else {
                if (option == 1) {
                    System.out.println(movieCollection.getTitles(20));
                }
                if (option == 2) {
                    System.out.println(movieCollection.getTitlesByGenre(id, 20));
                }
                if (option == 3) {
                    System.out.println(movieCollection.getTitlesByVoteAverage(rating, 20));
                }
                if (option == 4) {
                    System.out.println(movieCollection.getPopularTitles(popularity, 20));
                }
            }
        }
    }
}

