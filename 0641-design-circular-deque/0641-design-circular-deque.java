class MyCircularDeque {
    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor to initialize the deque with a maximum size of k.
    public MyCircularDeque(int k) {
        deque = new int[k];
        front = 0;
        rear = 0;
        size = 0;
        capacity = k;
    }

    // Insert an item at the front of the deque.
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        size++;
        return true;
    }

    // Insert an item at the rear of the deque.
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        deque[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    // Delete an item from the front of the deque.
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    // Delete an item from the rear of the deque.
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    // Get the front item from the deque.
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[front];
    }

    // Get the rear item from the deque.
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deque[(rear - 1 + capacity) % capacity];
    }

    // Check if the deque is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the deque is full.
    public boolean isFull() {
        return size == capacity;
    }
}
