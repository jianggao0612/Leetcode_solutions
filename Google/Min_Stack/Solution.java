class MinStack {
    ArrayList<Integer> array = new ArrayList<Integer>();
    int count = 0;
    int min = 0;
    
    public void push(int x) {
        array.add(count, x);
        count++;
        
        if(count == 1){
            min = x;
        } else if(x < min) {
            min = x;
        }
        // printStack();
    }
    
    public void pop() {
        if(count > 0) {
            count--;
            if(count == 1) {
                min = array.get(0);
            } else if(count != 0 && min == array.get(count)) {
                findMin();
            }
        }
        // printStack();
    }
    
    public int top() {
        if(count > 0) {
            return array.get(count-1);
        }
        return -1; // assume always valid.
    }
    
    public int getMin() {
        return min;
    }
    
    private void findMin() {
        min = array.get(0);
        for(int i = 0; i < count; i++) {
            int element = array.get(i);
            if(element < min) {
                min = element;
            }
        }
    }
    
    private void printStack() {
        System.out.println("statck");
        for(int i = count-1; i >= 0; i--) {
            int element = array.get(i);
            System.out.println(element);
        }
        System.out.println("min:" + min);
    }
}
