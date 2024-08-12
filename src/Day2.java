import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class Day2 {
    private static int part2(ArrayList<String>arr)
    {
        int ans = 0;
        for(String s:arr){
            int maxRed = 0;
            int maxBlue = 0 ;
            int maxGreen = 0;
            String[] spl =  s.split(":");

            String gameInfo = spl[0];
            String content = spl[1];
            String[] detials = gameInfo.split(" ");
            int index = Integer.valueOf(detials[1]);

            String[] sets = content.split(";");
            for(int i = 0 ; i <sets.length ; i++)
            {
                String[] showed = sets[i].split(",");
                for(int j = 0 ; j<showed.length ; j++)
                {
                    String[] singleSet = showed[j].split(" ");
                    if(singleSet[2].equals("blue"))
                    {
                        maxBlue = Math.max(maxBlue,Integer.valueOf(singleSet[1]));
                    }
                    else if(singleSet[2].equals("green"))
                    {
                        maxGreen = Math.max(maxGreen,Integer.valueOf(singleSet[1]));
                    }
                    else if(singleSet[2].equals("red"))
                    {
                        maxRed = Math.max(maxRed,Integer.valueOf(singleSet[1]));
                    }
                }
            }

            ans+= maxBlue*maxGreen*maxRed;

        }
        return ans;
    }
    private static int part1(ArrayList<String>arr)
    {
        int ans = 0;
        for(String s:arr){
            int maxRed = 0;
            int maxBlue = 0 ;
            int maxGreen = 0;
             String[] spl =  s.split(":");

             String gameInfo = spl[0];
             String content = spl[1];
             String[] detials = gameInfo.split(" ");
             int index = Integer.valueOf(detials[1]);

             String[] sets = content.split(";");
             for(int i = 0 ; i <sets.length ; i++)
             {
                 String[] showed = sets[i].split(",");
                 for(int j = 0 ; j<showed.length ; j++)
                 {
                     String[] singleSet = showed[j].split(" ");
                     if(singleSet[2].equals("blue"))
                     {
                         maxBlue = Math.max(maxBlue,Integer.valueOf(singleSet[1]));
                     }
                     else if(singleSet[2].equals("green"))
                     {
                         maxGreen = Math.max(maxGreen,Integer.valueOf(singleSet[1]));
                     }
                     else if(singleSet[2].equals("red"))
                     {
                         maxRed = Math.max(maxRed,Integer.valueOf(singleSet[1]));
                     }
                 }
             }

             if(maxBlue<=14 && maxRed<=12 && maxGreen<=13)
             {
                 ans+=index;
             }

        }
        return ans;
    }

    public static void main(String args[]){
        BufferedReader bf ;
        ArrayList<String> arr = new ArrayList<>();
        try{
            bf = new BufferedReader(new FileReader("/Users/prakhargupta/adventofcode-2023/inputs/Day2.txt"));
            String line  = bf.readLine();
            while(line!=null)
            {
                arr.add(line);
                line  = bf.readLine();
            }

        }
        catch (Exception e)
        {

        }
        int ans = part1(arr);
        int ans2 = part2(arr);
        System.out.println(ans2);
    }
}
