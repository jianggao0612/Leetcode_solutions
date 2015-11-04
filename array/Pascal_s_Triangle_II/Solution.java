// This solution is based on the equation of (x+y)^n = Cn-1(0)x^n + Cn-1(1)x^(n-1)y + .... + C(n-1)(n-1)y^n;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex + 1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(rowIndex < 1) {
            return result;
        }
        if(rowIndex == 1) {
            result.add(1);
            return result;
        }
        
        int base = rowIndex - 1;
        int count = (rowIndex + 1)/2;
        System.out.println(count);
        for(int i = 0; i < count; i++) {
            result.add(combination(base, i));
        }
        
        if(rowIndex % 2 == 0) {
            result.add(result.get(count-1));
        }
        count-=2;
        while(count >= 0) {
            result.add(result.get(count--));
        }
        return result;
    }
    
    public int combination(int base, int i) {
        if(base == 0) {
            return 1;
        }
        if(i == 0) {
            return 1;
        }
        
        double bottom = 1;
        double top = base;
        int j = 1;
        for(j = 1; j <= i-1; j++) {
            top = top * (base - j);
        }
        
        for(j = 1; j <= i; j++) {
            bottom = bottom * j;
        }
        
        return (int)Math.floor(top/bottom + 0.5d);
        // return (int)(top / bottom);
    }
}
