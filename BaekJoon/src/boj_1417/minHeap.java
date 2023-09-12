package boj_1417;

public class minHeap {
	
	private int[] Heap;
	private int size;
	private int maxsize;
	
	//Initializing front as static with unity
	private static final int FRONT=1;

	public minHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size=0;
		
		Heap=new int[this.maxsize+1];
		Heap[0]=Integer.MIN_VALUE;
	}//constructor
	
	
	//Returning the position of the parent for the node currently at pos
	private int parent(int pos) {
		return pos/2;
	}
	
	//Returning the position of the left child for the node currently at pos
	private int leftChild(int pos) {
		return (2*pos);
	}
	
	//Returning the position of the right child for the node currently at pos
	private int rightChild(int pos) {
		return (2*pos)+1;
	}
	
	
	
	//Returning true if the passed node is a leaf node
	private boolean isLeaf(int pos) {
		if(pos>(size/2)) return true;
		return false;
	}
	
	
	//to swap two nodes of the heap
	private void swap(int fpos, int spos) {
		int tmp=Heap[fpos];
		Heap[fpos]=Heap[spos];
		Heap[spos]=tmp;
	}
	
	
	//To heapify the node at pos
	private void minHeapify(int pos) {
		if(!isLeaf(pos)) {
			int swapPos=pos;
			//swap with the minimum of the two children to check if right child exists.
			//Otherwise default value will be '0' and that will be swapped with parent code
			if(rightChild(pos)<=size) {
				swapPos=Heap[leftChild(pos)]<Heap[rightChild(pos)] ? leftChild(pos):rightChild(pos);
			}else {
				swapPos=leftChild(pos);
			}
			
			if(Heap[pos]>Heap[leftChild(pos)] || Heap[pos]>Heap[rightChild(pos)] ) {
				swap(pos, swapPos);
				minHeapify(swapPos);
			}
		}
	}
	
	//To insert a node into the heap
	public void insert(int element) {
		if(size>=maxsize) return;
		
		Heap[++size]=element;
		int current =size;
		
		while(Heap[current]<Heap[parent(current)]) {
			swap(current, parent(current));
			current=parent(current);
		}
	}
	
	public void print() {
		for(int i=1; i<=size/2; i++) {
			System.out.print(
	                " PARENT : " + Heap[i]
	                + " LEFT CHILD : " + Heap[2 * i]
	                + " RIGHT CHILD :" + Heap[2 * i + 1]);
			
			System.out.println();
		}
	}
	
	
	//To remove and return the minimum element from the heap
	public int remove() {
		
		int popped =Heap[FRONT];
		Heap[FRONT]=Heap[size--];
		minHeapify(FRONT);
		
		return popped;
	}
	
	
	
	public static void main(String[] args) {
		
		minHeap heap=new minHeap(15);
		
		  heap.insert(5);
	      heap.insert(3);
	      heap.insert(17);
	      heap.insert(10);
	      heap.insert(84);
	      heap.insert(19);
	      heap.insert(6);
	      heap.insert(22);
	      heap.insert(9);
		
	    heap.print();
		
	    System.out.println("The Min val is "
                + heap.remove());
	    
	    heap.print();
	    System.out.println("The Min val is "
	    		+ heap.remove());
	}
	
	
	
}//class minHeap
