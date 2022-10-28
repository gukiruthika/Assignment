import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
    List<String> list = new ArrayList<String>();
    Set<Integer> set = new HashSet<Integer>();
    int value=0;
    char t='-';
    for(int i=0;i<s.length();i++){
        if(t==s.charAt(i)){
            value+=(s.charAt(i)-'a'+1);
            set.add(value);
        }
        else{
        value=(s.charAt(i)-'a'+1);
        set.add(value);
        t=s.charAt(i);
        }
        
    }
    for(int v:queries){
        if(set.contains(v))
            list.add("Yes");
        else
            list.add("No");
    }
    return list;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<String> result = Result.weightedUniformStrings(s, queries);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
