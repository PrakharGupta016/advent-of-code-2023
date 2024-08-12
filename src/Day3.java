import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day3 {
    private static int part2(ArrayList<String>arr)
    {
       return 0;
    }
    private static boolean validCharacter(char ch)
    {


        return !Character.isDigit(ch) && ch!='.';
    }
    static int[][] directions = {{1,1},{1,-1},{-1,1},{-1,-1},{1,0},{0,-1},{0,1},{-1,0}};

    private static int part1(ArrayList<String>arr)
    {
        int ans = 0 ;
        int temp = 0 ;
        boolean fine = false;
        int n = arr.size();
        int m = arr.get(0).length();
        for(int i = 0 ; i  < n ;  i++)
        {
            for(int j = 0 ; j<m; j++)
            {
                char ch = arr.get(i).charAt(j);
                if(Character.isDigit(ch))
                {
                    temp  = temp *10 + ((ch) - '0');
                    for(int x = 0; x<directions.length ; x++)
                    {
                            int newX = directions[x][0]+i;
                            int newY =  directions[x][1]+j;
                            if(newX>=0 && newX<n && newY>=0 && newY<m && validCharacter(arr.get(newX).charAt(newY)))
                            {
                                fine = true;
                            }
                    }
                }
                else
                {
                    if(fine)
                    {
                        ans+=temp;
                    }
                    temp = 0;
                    fine = false;
                }
            }
            if(fine)
            {
                ans+=temp;
            }
            temp = 0;
            fine = false;
        }
       return ans;
    }

    public static void main(String args[]){
        BufferedReader bf ;
        ArrayList<String> arr = new ArrayList<>();
        try{
            bf = new BufferedReader(new FileReader("/Users/prakhargupta/adventofcode-2023/inputs/Day3.txt"));
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
        System.out.println(ans);
    }
}
