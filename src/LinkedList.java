class Node<T extends Comparable<T>>
{
    private T value;
    private Node<T> next;
    private Node<T> previous;

    public Node(T value)
    {
        this.value = value;
    }

    public Node(T value, Node next)
    {
        this.value = value;
        this.next = next;
    }

    public Node(T value, Node next, Node previous)
    {
        this.value = value;
        this.next = next;
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public Node<T> getPrevious() {
        return this.previous;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class LinkedList<T extends Comparable<T>>
{
    private Node<T> head;

    public LinkedList(Node<T> head)
    {
        this.head = head;
    }

    public void add(T value)
    {
        Node<T> current = this.head;

        if(current.getNext() == null)
        {
            Node<T> newN =  new Node<T>(value, null, current);
            current.setNext(newN);
        }

        else
        {
            while(current.getNext() != null)
            {
                current = current.getNext();
            }

            Node<T> newN =  new Node<T>(value, null, current);

            current.setNext(newN);
        }
    }

    public void delete(T value)
    {
        //this is if the head is the value to be deleted. If this is the case, we dont change the value of the head node
        //we change what is represents but making the next node after it the head
        if(head.getValue()== value)
        {
            this.head = this.head.getNext();
            return;
        }

        else{
            Node<T> current = this.head;
            Node<T> prev = this.head.getNext();

            while(current!= null)
            {
                prev = current;
                current= current.getNext();

                //if at end
                if(current.getValue()== value)
                {
                    if(current.getNext() == null)
                    {
                        //its a doubly linked list so we want the previous and next nodes to be specified
                        prev.setNext(null);
                        current.setPrevious(null);
                        return;
                    }
                    else
                    {
                        Node<T> next = current.getNext();
                        current.setPrevious(null);
                        current.setNext(null);
                        prev.setNext(next);
                        next.setPrevious(prev);
                        return;
                    }
                }
            }
        }
    }
}