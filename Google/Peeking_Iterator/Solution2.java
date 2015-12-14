/**
 * This solution uses a pointer to point to the next val in the iterator
 */
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextVal = null;
    
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if(this.iterator.hasNext()){
            nextVal = this.iterator.next();
        }
    }
    
    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextVal;
    }
    
    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(hasNext()){
            Integer temp = new Integer(nextVal);
            if(this.iterator.hasNext()) {
                nextVal = this.iterator.next();
            } else {
                nextVal = null;
            }
            return temp;
        } else {
            return null;
        }
    }
    
    @Override
    public boolean hasNext() {
        return nextVal != null;
    }
}