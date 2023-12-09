package Self_Dividing_Numbers_728;

import java.util.ArrayList;
import java.util.List;


public class Self_Dividing_Numbers_728_better {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<>();

        for(int i=left; i<=right; i++){
            String str=i+"";
            int cnt=0;
            for(int j=0; j<str.length();j++){
                if(str.charAt(j)!='0' && i%Character.getNumericValue(str.charAt(j))==0){
                    cnt++;
                }
            }
            if(cnt==str.length()){
                list.add(i);
            }
        }
        return list;
    }
}