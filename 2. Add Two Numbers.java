/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return l1;
        }
        ListNode sum = new ListNode(0);
        boolean carry = false;
        boolean head = true;
        ListNode prev = sum;
        while(l1 != null || l2 != null){
            
            ListNode temp = new ListNode(0);
            int l1Val = 0;
            int l2Val = 0;
            if(l1 != null){
                l1Val = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                l2Val = l2.val;
                l2 = l2.next;
            }
            if(head){
                head = false;
                if(l1Val + l2Val > 9){
                    carry = true;
                }
                sum.val = (l1Val + l2Val) % 10;
                sum.next = null;
                prev = sum;
            }else{
                if(carry){
                    int s = l1Val + l2Val +1;
                    if(s > 9){
                        carry  = true;
                        
                    }else{
                        carry = false;
                        
                    }
                    temp.val = s%10;
                    
                }else{
                    int s = l1Val + l2Val;
                    if(s > 9){
                       carry  = true;
                    }else{
                        carry = false;
                    }
                    temp.val = s%10;
                }
                
                temp.next = null;
                prev.next = temp;
                prev = prev.next;
                
            }
            
            
        }
        if(carry){
            ListNode temp = new ListNode(1);
            temp.next = null;
            prev.next = temp;
            prev = prev.next;
        }
        return sum;
    }
}