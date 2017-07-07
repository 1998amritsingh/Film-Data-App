/**
 * Created by amrits2 on 1/18/2017.
 */
public class WordBuddies {

    //method is used to compare two words for having characters in the same place

    public static String CompareWord(String x, String y){
        int length;
        int count=0;
        String tempStr="";

        // accounts for words of different lengths and sets the default length for the for loop as the length for the shortest word.

        if (x.length()<y.length())
            length=x.length();
        else
            length=y.length();
        for (int i = 0; i <length ; i++) {
            if(x.charAt(i)==y.charAt(i)){
                tempStr+=x.charAt(i);
                count++;

            }
        }

        //must match in at least two positions for the words to be considered buddies


        if(count>=2)
            return tempStr;
        else
            return null;
    }
    //compares each string element in the full array by comparing the first element to the 2nd, 3rd, 4th, etc. and then the second elemnt to the 3rd 4th 5th and so on until all elements have been checked for similarity


    public static String[]CompareArray(String [] args){
        String [] arr = new String [args.length];
        for (int i = 0; i <args.length ; i++) {
            for (int j = i+1; j <args.length ; j++) {
                arr[i]=CompareWord(args[i],args[i+1]);
                arr[j]=CompareWord(args[i],args[i+1]);

            }
        }
        //if none of the array elements are "buddies", their common elements wont be updated in the array and the array will remain null

        if (arr==null)
            System.out.print("Not Buddies");
        return arr;

    }
    //"toString" method

    public static String printArray(String [] arr){
        String emptyStr="";


        for (int i = 0; i <arr.length ; i++) {
            emptyStr += arr[i]+" ";

        }
        return emptyStr;
    }

    public static void main(String[] args) {
        System.out.print(printArray(CompareArray(args)));


    }
}
