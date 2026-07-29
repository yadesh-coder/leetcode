class Solution {
    public Node flatten(Node head){
        if(head==null)return null;
        Node temp=head;
        while(temp!=null)
        {
            if(temp.child!=null)
            {
                Node next=temp.next;
                temp.next=flatten(temp.child);
                temp.next.prev=temp;
                temp.child=null;
                while(temp.next!=null)
                    temp=temp.next;
                if(next!=null)
                {
                    temp.next=next;
                    next.prev=temp;
                }
            }
            else
                temp=temp.next;
        }
        return head;
    }
}