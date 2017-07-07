import org.junit.Before;
import org.junit.Test;
import java.net.URL;
import com.google.gson.stream.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import com.google.gson.Gson;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;


/**
 * Created by amrits2 on 2/7/2017.
 */
public class MovieParserTest {

    MovieInfo movieInfo;

    @Before
    public void parseJSON() throws Exception {

        URL	url	= new URL("https://api.themoviedb.org/3/movie/popular?api_key=" + MovieParserExtension.APIKey+"&page=1");
        InputStream inStream = url.openStream();
        InputStreamReader reader = new InputStreamReader(inStream, Charset.forName("UTF-8"));
        Gson gson = new Gson();
        JsonReader jsonReader =	new JsonReader(reader);
        MovieCollection movieCollection = gson.fromJson(jsonReader, MovieCollection.class);
        movieInfo = movieCollection.getResults()[0];

    }

    @Test
    public void getTitle() throws Exception {
        assertEquals(movieInfo.getTitle(),"The Secret Life of Pets");

    }

    @Test
    public void getVote_average() throws Exception {
        assertTrue(movieInfo.getVote_average() == 5.8);

    }

    @Test
    public void getGenre_ids() throws Exception {
        assertArrayEquals(movieInfo.getGenre_ids(), new int[]{12,16,35,10751});

    }

    @Test
    public void getPopularity() throws Exception {
        assertEquals(movieInfo.getPopularity(), 123.537721,0);

    }

}