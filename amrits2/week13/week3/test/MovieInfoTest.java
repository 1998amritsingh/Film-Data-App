import static org.junit.Assert.*;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by 1998a on 1/31/2017.
 */
public class MovieInfoTest {

    public static final String exampleMovie = "{\n" +
            "\"poster_path\": \"/WLQN5aiQG8wc9SeKwixW7pAR8K.jpg\",\n" +
            "\"adult\": false,\n" +
            "\"overview\": \"The quiet life of a terrier named Max is upended when his owner takes in Duke, a stray whom Max instantly dislikes.\",\n" +
            "\"release_date\": \"2016-06-18\",\n" +
            "\"genre_ids\": [\n" +
            "12,\n" +
            "16,\n" +
            "35,\n" +
            "10751\n" +
            "],\n" +
            "\"id\": 328111,\n" +
            "\"original_title\": \"The Secret Life of Pets\",\n" +
            "\"original_language\": \"en\",\n" +
            "\"title\": \"The Secret Life of Pets\",\n" +
            "\"backdrop_path\": \"/lubzBMQLLmG88CLQ4F3TxZr2Q7N.jpg\",\n" +
            "\"popularity\": 271.747181,\n" +
            "\"vote_count\": 1960,\n" +
            "\"video\": false,\n" +
            "\"vote_average\": 5.8\n" +
            "}";
    Gson gson = new Gson();
    MovieInfo movieInfo;

    @Before
    public void parseJson(){
        movieInfo=gson.fromJson(exampleMovie,MovieInfo.class);
    }

    @Test
    public void getTitle() throws Exception {
        assertEquals(movieInfo.getTitle(),"The Secret Life of Pets");

    }

    @Test
    public void getVote_average() throws Exception {
        assertTrue(movieInfo.getVote_average()==5.8);

    }

    @Test
    public void getGenre_ids() throws Exception {
        assertArrayEquals(movieInfo.getGenre_ids(), new int[]{12,16,35,10751});

    }

    @Test
    public void getPopularity() throws Exception {
        assertTrue(movieInfo.getPopularity()==271.747181);

    }

}