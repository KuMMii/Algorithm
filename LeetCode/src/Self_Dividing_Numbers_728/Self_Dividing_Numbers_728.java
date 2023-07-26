package Self_Dividing_Numbers_728;

import java.util.ArrayList;
import java.util.List;

public class Self_Dividing_Numbers_728 {

}
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> output= new ArrayList<>();

        List<String> a = new ArrayList<>();
        
        for(int i=left; i<=right;i++){
            a.add(i+"");
        }

        for(int i=0;i<a.size();i++){
        	int cnt=0;
        	for(int j=0; j<a.get(i).length();j++) {
        		int numi=Integer.parseInt(a.get(i));
        		int numj=Character.getNumericValue(a.get(i).charAt(j));
        		
        		if(numi%numj==0) {
        			cnt++;
        		}
        		
        	}
        	if(cnt==a.get(i).length()) {
        		output.add(Integer.parseInt(a.get(i)));
        	}
        }
		return output;
    }
}