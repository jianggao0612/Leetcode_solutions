/**
 *
 * Implement Stack using Queues
 *
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 */
 class MyStack {

    LinkedList<Integer> queueOne = new LinkedList<Integer>();
    LinkedList<Integer> queueTwo = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        if (queueOne.size() == 0) {
            queueTwo.addLast(x);
        } else {
            queueOne.addLast(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {

        int sizeOne = queueOne.size();
        int sizeTwo = queueTwo.size();

        if (sizeOne == 0) {
            for (int i = 0; i < sizeTwo - 1; i++) {
                queueOne.addLast(queueTwo.pollFirst());
            }
            queueTwo.pollFirst();
        } else {
            for (int i = 0; i < sizeOne - 1; i++) {
                queueTwo.addLast(queueOne.pollFirst());
            }
            queueOne.pollFirst();
        }
    }

    // Get the top element.
    public int top() {

        int sizeOne = queueOne.size();
        int sizeTwo = queueTwo.size();
        int result;

        if (sizeOne == 0) {
            for (int i = 0; i < sizeTwo - 1; i++) {
                queueOne.addLast(queueTwo.pollFirst());
            }
            result = queueTwo.pollFirst();
            queueOne.addLast(result);
        } else {
            for (int i = 0; i < sizeOne - 1; i++) {
                queueTwo.addLast(queueOne.pollFirst());
            }
            result = queueOne.pollFirst();
            queueTwo.addLast(result);
        }

        return result;
    }
    

    // Return whether the stack is empty.
    public boolean empty() {

        return queueOne.size() == 0 && queueTwo.size() == 0;

    }
}
