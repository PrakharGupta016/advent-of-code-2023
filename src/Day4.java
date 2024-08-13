import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;


public class Day4 {
    private static int part2(ArrayList<String>arr)
    {
        int ans = 0;

        HashMap<Integer,Integer> cnt = new HashMap<>();
        for(int i = 1 ; i<=arr.size() ; i++)
        {

            cnt.put(i,1);
        }

        int idx = 1;
        for(String s:arr)
        {
            String[] splits = s.split(":");
            String content = splits[1];
            String[] lists = content.split("\\|");
            String list1 =  lists[0];
            String list2 =  lists[1];
            String[] arr1 = list1.split(" ");
            String[] arr2 = list2.split(" ");
            HashSet<Integer> s1 = new HashSet<>();
            HashSet<Integer> s2 = new HashSet<>();
            for(String val:arr1)
            {
                if(!val.isEmpty())
                {
                    s1.add(Integer.valueOf(val));
                }
            }
            for(String val:arr2)
            {
                if(!val.isEmpty())
                {
                    s2.add(Integer.valueOf(val));
                }
            }

            s1.retainAll(s2);

            int sz = s1.size();
            for(int i = 1 ; i <=sz ;i++) {
                int val = cnt.getOrDefault(i + idx, 0);
                int tot = val+ cnt.get(idx);
                cnt.put(i + idx,tot);
            }
            idx++;
        }
        for(Map.Entry<Integer,Integer> val: cnt.entrySet())
        {
            ans+=val.getValue();
        }

        return ans;
    }

    private static int part1(ArrayList<String>arr)
    {
        int ans = 0;
        for(String s:arr)
        {
            String[] splits = s.split(":");
            String content = splits[1];
            String[] lists = content.split("\\|");
            String list1 =  lists[0];
            String list2 =  lists[1];
            String[] arr1 = list1.split(" ");
            String[] arr2 = list2.split(" ");
            HashSet<Integer> s1 = new HashSet<>();
            HashSet<Integer> s2 = new HashSet<>();
            for(String val:arr1)
            {
                if(!val.isEmpty())
                {
                    s1.add(Integer.valueOf(val));
                }
            }
            for(String val:arr2)
            {
                if(!val.isEmpty())
                {
                    s2.add(Integer.valueOf(val));
                }
            }
            s1.retainAll(s2);
            int sz = s1.size();
            ans+= (sz == 0)? 0:Math.pow(2,sz-1);

        }
        return ans;
    }

    public static void main(String args[]){
        BufferedReader bf ;
        ArrayList<String> arr = new ArrayList<>();
        try{
            bf = new BufferedReader(new FileReader("/Users/prakhargupta/adventofcode-2023/inputs/Day4.txt"));
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
