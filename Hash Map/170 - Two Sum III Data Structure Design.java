/**
 * Two sum III - Data Structure Design
 *
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 */
 public class TwoSum {
    
    Map<Integer, Integer> map;
    
    TwoSum() {
        map = new HashMap<Integer, Integer>();
    }

    public void add(int number) {
        
        Integer count = map.get(number);

        if (count != null) {
            map.put(number, count + 1);
        } else{
            map.put(number, 1);
        }

    }
    
    public boolean find(int number) {
        
        Set<Integer> keySet = map.keySet(); 
        Iterator<Integer> keySetIterator = keySet.iterator();
       
        while (keySetIterator.hasNext()) {
            int num = map.get(keySetIterator.next());
            int diff = number - num;
            
            if ((num == diff) && (map.get(num) > 1)) {
                return true;
            }
            
            if (map.containsKey(diff)) {
                return true;
            }
        
        }
        
        return false;

    }
}
