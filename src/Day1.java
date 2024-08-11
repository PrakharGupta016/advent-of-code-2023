import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day1 {

    static Long part1(ArrayList<String> arr)
    {
        Long ans = 0l;
        for(String it:arr)
        {
            String temp = null;
            char one = 0;
            char two = 0;
            for(int i = 0 ; i<it.length(); i++)
            {
                char ch = it.charAt(i);
                if(ch<='9' && ch>='0')
                {
                    if(one == 0)
                    {
                        one = ch;
                        two = ch;
                    }
                    else
                    {
                        two = ch;
                    }
                }
            }
            String res = Character.toString(one)+Character.toString(two);
            ans+=Integer.valueOf(res);
        }
        return ans;
    }
    static Long part2(ArrayList<String> arr)
    {
        Long ans = 0l;
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("one","1");
        hashMap.put("two","2");
        hashMap.put("three","3");
        hashMap.put("four","4");
        hashMap.put("five","5");
        hashMap.put("six","6");
        hashMap.put("seven","7");
        hashMap.put("eight","8");
        hashMap.put("nine","9");
        for(String s:arr)
        {
            Character one = null;
            Character two = null;
            for(Map.Entry<String,String> entry : hashMap.entrySet())
            {

                s = s.replaceAll(entry.getKey(), entry.getKey()+entry.getValue()+entry.getKey());
            }
            for(int i = 0 ; i <s.length() ; i++)
            {


                if(s.charAt(i)>='0' && s.charAt(i)<='9')
                {
                    if(one  == null)
                    {
                        one = s.charAt(i);
                        two =  s.charAt(i);
                    }
                    else {
                        two = s.charAt(i);
                    }
                }

            }
            String res = Character.toString(one)+Character.toString(two);
            ans+=Integer.valueOf(res);
        }

        return ans;

    }


    public static void main(String args[])  {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("/Users/prakhargupta/adventofcode-2023/inputs/Day1.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> arr = new ArrayList<>();
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while(line!=null)
        {
            arr.add(line);
            try {
                line  = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Long ans1 = part1(arr);
        Long ans2 = part2(arr);
        System.out.println(ans1);
        System.out.println(ans2);

    }

}
