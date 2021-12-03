package series;

/**
 * 队列相关
 *
 * @author zyf
 * @date 2021-11-16 10:11
 */
public class QueueSeries {

  /**
   * 自己用数组实现一个循环队列
   */
  class MyQueue {
    private final Object[] elements;
    //默认数组容量
    private int DEFAULT_CAPACITY=10;
    public int size;
    public int front;
    public int rear;

    public MyQueue(int capacity) {
      elements = new Object[capacity];
      size = capacity;
    }

    public MyQueue() {
      elements = new Object[DEFAULT_CAPACITY];
      size = DEFAULT_CAPACITY;
    }

    public boolean add(Object element) {
      // 判断是否队满
      if (front == (rear + 1) % elements.length) {
        return false;
      }
      elements[rear] = element;
      // rear进行往前步进1
      rear = (rear + 1) % elements.length;
      size++;
      return true;
    }

    public Object poll() {
      // 判断是否空
      if (front == rear) {
        return null;
      }
      Object element = elements[front];
      front = (front + 1) % elements.length;
      size--;
      return  element;
    }

  }



  // 自己实现一个堵塞队列

}
