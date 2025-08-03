import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int count = Integer.parseInt(s[0]);
        int length = Integer.parseInt(s[1]);
        
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            if (input.length() < length) continue;
            
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        List<String> words = new ArrayList<>(map.keySet());

        Collections.sort(words, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(Integer.compare(map.get(o1), map.get(o2))!=0){
                    return Integer.compare(map.get(o2), map.get(o1));
                }

                if(o1.length()!=o2.length()){
                    return Integer.compare(o2.length(), o1.length());
                }

                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String str : words) {
            sb.append(str + "\n");
        }
        System.out.println(sb);
}
}