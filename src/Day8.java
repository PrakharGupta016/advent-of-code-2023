import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day8 {
    static Long __gcd(Long a, Long b)
    {
        return b == 0? a:__gcd(b, a % b);
    }

    // recursive implementation
    static Long LcmOfArray(ArrayList<Long> arr, int idx)
    {

        if (idx == arr.size() - 1){
            return arr.get(idx);
        }
        Long a = arr.get(idx);
        Long b = LcmOfArray(arr, idx+1);
        return (a*b/__gcd(a,b)); //
    }
    static Long part1( HashMap<String, ArrayList<String>>  hm,HashSet<String> startingPoints,String instructions)
    {
        Long ans = 0L;
        int sz = instructions.length();

        ArrayList<Long> store = new ArrayList<>();
        for(String val:startingPoints)
        {
            int index = 0;
            String start = val;
            int temp = 0;
            while(!start.endsWith("Z"))
            {
                String left = hm.get(start).get(0);
                String right = hm.get(start).get(1);
                start = (instructions.charAt(index) == 'L')? left:right;
                index = (index+1)%sz;
                temp++;
            }
            store.add((long) temp);
        }
        ans = LcmOfArray(store,0)   ;




        return ans;
    }
    public static void main(String[] args) throws IOException {
        String[] lines = new String(Files.readAllBytes(Paths.get("/Users/prakhargupta/adventofcode-2023/inputs/Day8.txt"))).split("\\n");
        String instructions = lines[0].trim();
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        HashSet<String> startingPoints = new HashSet<>();
        for(int i = 2; i<lines.length ; i++)
        {
            String start = lines[i].split("=")[0].trim();
            String lr = lines[i].split("=")[1].trim();
            lr = lr.replaceAll("\\(","");
            lr= lr.replaceAll("\\)","");
            String left = lr.split(",")[0].trim();
            String right = lr.split(",")[1].trim();
            ArrayList<String> lrcontent = new ArrayList<>();
            lrcontent.add(left);
            lrcontent.add(right);
            if(start.endsWith("A"))
            {
                startingPoints.add(start);
            }
            hm.put(start,lrcontent);
        }

        Long ans = part1(hm,startingPoints,instructions);
        System.out.println(startingPoints);
        System.out.println(ans);

    }
}
