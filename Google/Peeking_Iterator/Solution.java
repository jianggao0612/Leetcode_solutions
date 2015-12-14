// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private ArrayList<Integer> array;
    private int pos = -1;
    private int size = 0;
    
    public PeekingIterator(Iterator<Integer> iterator) {
        this.array = new ArrayList<Integer>();
        // initialize any member here.
        while(iterator.hasNext()) {
            this.array.add(iterator.next());
        }
        
        this.size = array.size();
    }
    
    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        
        // System.out.println("enter peek");
        if(hasNext()) {
            return array.get(pos+1);
        } else {
            return null;
        }
    }
    
    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        
        // System.out.println("enter next");
        if(hasNext()) {
            return array.get(++pos);
        } else {
            return null;
        }
    }
    
    @Override
    public boolean hasNext() {
        // System.out.println("enter hasnext");
        return pos < (size - 1);
    }
}