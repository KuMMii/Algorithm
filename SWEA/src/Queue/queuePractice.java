package Queue;

import java.util.Arrays;

public class queuePractice {

	public static String[] queue = new String[5];
	public static int front=-1, rear=-1; //front: out , rear : in
	
	public static void main(String[] args) {
		enQueue("s");
		System.out.println(Arrays.toString(queue));
		enQueue("s");
		System.out.println(Arrays.toString(queue));
		enQueue("s");
		System.out.println(Arrays.toString(queue));
		System.out.println(front);
		System.out.println(rear);
		System.out.println("---------------remove--------");
		deQueue();
		System.out.println(Arrays.toString(queue));
		System.out.println(front);
		System.out.println(rear);
		
	}//main
	
	
	//front==rear 이면 공백
	public static boolean isEmpty() {
		if(front==rear)	System.out.println("empty");
		return front==rear;
	}
	
	//isFull -> rear==queue.length=1이면 포화
	public static boolean isFull() {
		System.out.println("full");
		return rear==queue.length-1;
	}
	
	//add
	public static void enQueue(String str) {
		if(isFull()) {
			return;
		}
		queue[++rear]=str;
	}
	
	//remove
	public static String deQueue() {
		if(isEmpty()) {
			return null;
		}
//		return queue[front++];//이건 배열을 계속 앞으로 안할때
		
		//이건 배열을 앞으로 땡길때
		
		String tmp=queue[++front]; //front값 우선 상승시켜줘서 리턴값 저장
		
		for(int i=front+1;i<queue.length-1;i++ ) {
			queue[i-1]=queue[i];
		}//하나씩 땡겨서 값 넣기
		queue[rear--]=null; //마지막 부분은 비워줘야해서 null로 두고 rear값 줄이기
		front=0; //이제 front는 0아님 -1밖에 없으니까 
		return tmp;
	}
	
	
}//class
