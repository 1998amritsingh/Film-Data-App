/**
 * Created by 1998a on 1/31/2017.
 */
public class MovieCollection {

    private int total_results;
    private MovieInfo [] results;
    private int total_pages;

    //getter Methods for above private variables.
    public int getTotal_results(){
        return total_results;
    }

    public MovieInfo [] getResults(){
        return results;
    }

    public int getTotal_pages(){
        return total_pages;
    }


    //returns all titles from the list
    public String getTitles(int numOfTitles){
        String titles="";
        for (int i = 0; i < numOfTitles; i++) {
            titles+=results[i].getTitle() + "\n";
        }
        return titles;

    }

    //returns titles that match a specific genreID
    public String getTitlesByGenre(double genreId, int numOfTitles){
        String genredTitles="";
        for (int i = 0; i < numOfTitles; i++) {
            for (int j = 0; j <results[i].getGenre_ids().length ; j++) {
                if (results[i].getGenre_ids()[j] == genreId){
                    genredTitles+=results[i].getTitle() + "\n ";
                }
            }
        }
        return genredTitles;

    }

    //returns all titles above a minimum vote Average
    public String getTitlesByVoteAverage(double minAv, int numOfTitles){
        String validTitles="";
        for (int i = 0; i < numOfTitles; i++){
            if (results[i].getVote_average() > minAv){
                validTitles+=results[i].getTitle() + "\n ";
            }
        }
        return validTitles;
    }

    //returns titles that are above a minimum popularity rating
    public String getPopularTitles(double minPop, int numOfTitles){
        String popTitles="";
        for (int i = 0; i < numOfTitles; i++){
            if (results[i].getPopularity() > minPop){
                popTitles+=results[i].getTitle() + "\n ";
            }

        }
        return popTitles;

    }









}
