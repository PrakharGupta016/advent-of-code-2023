import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day6 {


    static Long part1(List<Long> distanceValues, List<Long> timeValues)
    {
        Long ans =1l;

        for(int i = 0 ; i< timeValues.size() ; i++)
        {
            Long time = timeValues.get(i);
            Long temp = 0l;
            for(Long j = 0l  ; j <=time ; j++)
            {
                if(j*(time-j)>distanceValues.get(i))
                {
                    temp++;
                }
            }

            ans*=temp;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        String[] lines = new String(Files.readAllBytes(Paths.get("/Users/prakhargupta/adventofcode-2023/inputs/Day6.txt"))).split("\\n");
        String[] time = lines[0].split(":")[1].trim().split(" ");
        String[] distance = lines[1].split(":")[1].trim().split(" ");
        StringBuffer timeBuffer = new StringBuffer();
        StringBuffer distBuffer = new StringBuffer();

        List<Long> timeValues  = new ArrayList<>();
        List<Long> distanceValues = new ArrayList<>();
        for(String val:time)
        {
            if(!val.isEmpty())
            {
                timeBuffer.append(val);
            }
        }
        for(String val:distance)
        {
            if(!val.isEmpty())
            {
                distBuffer.append(val);
            }
        }
        timeValues.add(Long.valueOf(String.valueOf(timeBuffer)));
        distanceValues.add(Long.valueOf(String.valueOf(distBuffer)));
        Long ans = part1(distanceValues,timeValues);
        System.out.println(ans);

    }

}
