import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


class Container{
    String hand;
    Long bid;
    int rank;

    public Container(Long bid, String hand,int rank) {
        this.bid = bid;
        this.hand = hand;
        this.rank = rank;
    }

}
public class Day7 {


    static Long part1(List<Container> arr)
    {
        arr.sort((Container a,Container b)->{
            if(a.rank == b.rank)
            {
                for(int i = 0  ;i<5 ;i++)
                {
                    if(mp.get(a.hand.charAt(i))<mp.get(b.hand.charAt(i)))
                    {
                        return 1;
                    }
                    else if(mp.get(a.hand.charAt(i))>mp.get(b.hand.charAt(i))) {
                        return -1;
                    }
                }
                return -1;

            }
            else
            {
                if(a.rank>b.rank)
                {
                    return 1;
                }
                else
                    return -1;
            }
        });
        Long ans = 0l;
        for(int i = 0 ; i<arr.size() ; i++)
        {
            System.out.println(arr.get(i).hand);
            Container val = arr.get(i);
            ans+= val.bid * (i+1);
        }
        return ans;
    }

    static HashMap<Character,Integer> mp = new HashMap<>();

    public static void main(String[] args) throws IOException {

        String[] lines = new String(Files.readAllBytes(Paths.get("/Users/prakhargupta/adventofcode-2023/inputs/Day7.txt"))).split("\\n");
        List<Container> list = new ArrayList<>();
        //edited for part2
        char[] arr={'A', 'K', 'Q', 'T', '9', '8', '7', '6', '5', '4', '3', '2','J'};
        for(int i =  0 ; i <arr.length ; i++)
        {
            mp.put(arr[i],i);
        }

        for(int i = 0 ; i <lines.length ; i++)
        {
            String[] content = lines[i].split(" ");
            HashMap<Character,Integer> hm = new HashMap<>();
            for(int j= 0  ;  j < content[0].length()  ; j++)
            {
                hm.put(content[0].charAt(j),hm.getOrDefault(content[0].charAt(j),0)+1);
            }
            int rank = hm.size();
            if(hm.containsKey('J'))
            {
                int mx = 0;
                Character ch = null;
                for(Map.Entry<Character,Integer> entries: hm.entrySet())
                {
                    if(entries.getKey()!='J')
                    {
                        if(entries.getValue()>mx)
                        {
                            mx = entries.getValue();
                            ch = entries.getKey();
                        }
                    }
                }
                hm.remove(ch);
                hm.put('J',mx+hm.get('J'));
                rank = hm.size();

                if(rank == 5)
                {
                    rank = 1;
                }
                else if(rank == 4)
                {
                    rank =2;
                }
                else if(rank == 3)
                {
                    Collection<Integer>  valSet =  hm.values();
                    if(valSet.contains(3))
                    {
                        rank  = 4;
                    }
                    else{
                        rank = 3;
                    }


                }
                else if(rank == 2)
                {
                    Collection<Integer>  valSet =  hm.values();
                    if(valSet.contains(4))
                    {
                        rank  = 6;
                    }
                    else{
                        rank = 5;
                    }
                }
                else if(rank == 1)
                {
                    rank = 7;
                }
            }
            else {
                if(rank == 5)
                {
                    rank = 1;
                }
                else if(rank == 4)
                {
                    rank =2;
                }
                else if(rank == 3)
                {
                    Collection<Integer>  valSet =  hm.values();
                    if(valSet.contains(3))
                    {
                        rank  = 4;
                    }
                    else{
                        rank = 3;
                    }


                }
                else if(rank == 2)
                {
                    Collection<Integer>  valSet =  hm.values();
                    if(valSet.contains(4))
                    {
                        rank  = 6;
                    }
                    else{
                        rank = 5;
                    }
                }
                else if(rank == 1)
                {
                    rank = 7;
                }
            }
            list.add(new Container(Long.parseLong(content[1]), content[0],rank));
        }

        Long ans = part1(list);
        System.out.println(ans);


    }

}
