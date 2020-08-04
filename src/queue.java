class LinkedListQueue
{
    Node front;
    Node back;

    private class Node
    {
        int value;
        Node next;

        Node(int value)
        {
            this.value = value;
        }
    }
//linked list operations
    public void insertLast(int value)
    {
        Node newN = new Node(value);
        if(isEmpty())
        {
            front = newN;
        }
        else
        {
            back.next= newN;
        }
        back = newN;
    }

    public int removeFront()
    {
        int temp = front.value;
        if(front.next == null)
        {
            back = null;
        }
        front = front.next;
        return temp;
    }

    public void displayNodes()
    {
        Node current = front;
        while(current != null)
        {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public int getFrontData()
    {
        return front.value;
    }

    public boolean isEmpty()
    {
        if(front==null)
        {
            return true;
        }
        else
        {
            return false;
        }

        // or return front==null;
    }

    //queue operations

    public void insertValue(int value)
    {
        insertLast(value);
    }

    public int remove()
    {
        if(isEmpty())
        {
            throw new RuntimeException("Queue is empty");
        }
        return removeFront();
    }

    public int peek()
    {
        if(isEmpty()){throw new RuntimeException("Queue is empty");}
        return front.value;
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.insertValue(3);
        queue.insertValue(6);
        System.out.println("-- Displaying Queue data--");
        queue.displayNodes();
        System.out.println("Item peeked- " + queue.peek());
        System.out.println("-- Removing Queue elements--");
        System.out.println("Item removed- " + queue.remove());
        System.out.println("Item removed- " + queue.remove());
    }
}