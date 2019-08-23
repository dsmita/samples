package com.debs.sample;

public class CustomPriorityQueue {
	
	private Task[] heap; 
    private int heapSize, capacity;
    
    public CustomPriorityQueue(int capacity)
    {    
        this.capacity = capacity + 1;
        heap = new Task[this.capacity];
        heapSize = 0;
    }
    
    public void clear()
    {
        heap = new Task[capacity];
        heapSize = 0;
    }
    
    public boolean isEmpty()
    {
        return heapSize == 0;
    }
    
    public boolean isFull()
    {
        return heapSize == capacity - 1;
    }
    
    public int size()
    {
        return heapSize;
    }
    
    public void insert(String job, int priority){
    	Task newJob = new Task(job, priority);
    	heapSize = heapSize++;
    	heap[heapSize]=newJob;
    	int pos = heapSize;
        while (pos != 1 && newJob.priority > heap[pos/2].priority)
        {
            heap[pos] = heap[pos/2];
            pos =pos/2;
        }
    }
    
    public Task remove()
    {
        int parent, child;
        Task item, temp;
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
            return null;
        }
 
        item = heap[1];
        temp = heap[heapSize--];
 
        parent = 1;
        child = 2;
        while (child <= heapSize)
        {
            if (child < heapSize && heap[child].priority < heap[child + 1].priority)
                child++;
            if (temp.priority >= heap[child].priority)
                break;
 
            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;
 
        return item;
    }

}
