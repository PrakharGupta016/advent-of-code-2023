import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day9 {

    static Long part1(List<List<Long>> list)
    {
        Long ans=  0L;
        for(List<Long> row:list)
        {
            List<Long> store  = row;
            while(store.stream().anyMatch(val->val!=0))
            {
                List<Long> temp = new ArrayList<>();
                ans+=store.get(store.size()-1);
                for(int i = 0 ; i <store.size() - 1 ; i++)
                {
                    Long diff = (store.get(i+1)-store.get(i));
                    temp.add(diff);
                }
                store = temp;
            }
        }
        return ans;
    }

    static Long part2(List<List<Long>> list)
    {
        Long ans=  0L;

        for(List<Long> row:list)
        {
            List<Long> constants = new ArrayList<>();
            List<Long> store  = row;

            while(store.stream().anyMatch(val->val!=0))
            {
                constants.add(store.get(0));
                List<Long> temp = new ArrayList<>();
                for(int i = 0 ; i <store.size() - 1 ; i++)
                {
                    Long diff = (store.get(i+1)-store.get(i));
                    temp.add(diff);
                }
                store = temp;
            }
            // solving linear eq
            Long rowAns = 0L;
            for(int i = constants.size()-1 ; i>=0 ; i--)
            {
                rowAns = constants.get(i) - rowAns;

            }
            ans+=rowAns;

        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        String[] lines = new String(Files.readAllBytes(Paths.get("/Users/prakhargupta/adventofcode-2023/inputs/Day9.txt"))).split("\\n");
        List<List<Long>> list = new ArrayList<>();
        for(int i = 0 ; i <lines.length ; i++)
        {
            List<Long> row=  Arrays.stream(lines[i].split(" ")).map(Long::valueOf).toList();
            list.add(row);
        }
        Long ans1 = part1(list);
        Long ans2 = part2(list);
        System.out.println(ans2);
    }

}
