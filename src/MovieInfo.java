/**
 * Created by 1998a on 1/31/2017.
 */

//Creates "MovieInfo" object that is referenced in "MovieCollection" class
public class MovieInfo {

    private String title;
    private double vote_average;
    private int [] genre_ids;
    private double popularity;

    //getter methods
    public String getTitle(){
        return title;
    }

    public double getVote_average(){
        return vote_average;
    }

    public int[] getGenre_ids(){
        return genre_ids;
    }

    public double getPopularity(){
        return popularity;
    }



}
