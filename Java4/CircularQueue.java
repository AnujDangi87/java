class CircularQueue
{   
    int []queue;                //Decleartion of queue array and rear and front variable.
    int rear;                   //Rear hold the index of array where we have to enqueue the new element.
    int front;              //Front hold the index of array from where we have to dequeue the element.

    CircularQueue(int size){            //Constructor to take size as input and allocate memory to queue and set front, rear at 0.

        queue = new int[size];
       
        rear=front=0;
    }

    boolean isEmpty()           //Method to return true if queue is Empty otherwise false.
    {
        if(front == rear && (front == 0 || front==queue.length))
        {
            return true;
        }
            return false;
    }

    boolean isFull()            //Method to return true if queue is Full otherwise false.
    {
        if ((front == 0 && rear == queue.length) || (front == rear && rear !=0))
        {
            return true;
        }
        else
            return false;
    }

   void enqueue(int element)            //Method to enter element at the rear index value of array.
   {
        if (isFull())
        {
            System.out.println("Queue is Full!");
            return;
        }
        if (front != 0 && rear == queue.length)         //Checking if staring indices value are empty or not.
        {
            rear=0;             //If yes then intializing rear to 0.
            queue[rear] = element;
        }
        else
            queue[rear] = element;
        if (rear == queue.length-1)
        {
            if (front != 0)
            {
                rear = 0;
            }
            else
                rear++;
        }
        else
            rear++;
        
   }

   int dequeue()                //Method to remove the element at rear index.
   {    int value;
        if(isEmpty())
        {
            front = 0;
            rear = 0;
            return -1;
        }

        if ( front == queue.length-1)           //Checking if rear is shefted before the front index.
        {
            if (rear  == queue.length)
            {
                return queue[front++];
            }
            else
                value = queue[front];
                front = 0;
                return value;
        }
        else
            return queue[front++];
   }

   void display()               //Mehod to display the content of queue.
   {    
            if (front < rear)
            {
                for(int i=front;i<rear;i++)
                {   
                        if (i ==front)
                            System.out.print("Queue elements : ");
                        System.out.print(queue[i]+" ");
                }
                System.out.println("");
            }
            else
            {
                for(int i=front;i<queue.length;i++)
                {   
                        if (i ==front)
                            System.out.print("Queue elements : ");
                        System.out.print(queue[i]+" ");
                }
                for(int i=0;i<rear;i++)
                    System.out.print(queue[i]+" ");
                System.out.println("");
            }
   }
}