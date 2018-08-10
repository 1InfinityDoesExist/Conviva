#include<bits/stdc++.h>
using namespace std;

struct LinkedList
{
    int data;
    LinkedList *next;
    LinkedList(int val) : data(val), next(NULL){}
};
class Solution{
private:
public:
    Solution();
    struct LinkedList *reverseLinkedList(struct LinkedList *head);
    struct LinkedList *addAtfirst(struct LinkedList *head ,int data);
    struct LinkedList *addAtLast(struct LinkedList *head , int data);
    struct LinkedList *addInMiddle(struct LinkedList *head , int data);
};
Solution::Solution(){}
struct LinkedList *Solution::addInMiddle(struct LinkedList *head , int data)
{
    struct LinkedList *temp = new LinkedList(data);
    if(head == NULL)
    {
        head = temp;
        return head;
    }
    int len = 0;
    struct LinkedList *ptr = head;
    while(ptr != NULL)
    {
        len++;
        ptr = ptr->next;
    }
    ptr = head;
    if(len%2 == 0)
    {
       for(int iter = 0; iter < len/2 -1; iter++)
        {
            ptr = ptr->next;
        }
    }
    else
    {
        for(int iter = 0; iter < len/2; iter++)
        {
            ptr = ptr->next;
        }
    }

    temp->next = ptr->next;
    ptr->next = temp;
    return head;
};
struct LinkedList *Solution::addAtLast(struct LinkedList *head , int data)
{
    struct LinkedList *temp = new LinkedList(data);
    if(head == NULL)
    {
        head = temp;
        return head;
    }
    struct LinkedList *ptr = head;
    while(ptr->next != NULL)
    {
        ptr = ptr->next;
    }
    ptr->next = temp;
    return head;
};
struct LinkedList *Solution::addAtfirst(struct LinkedList *head , int data)
{
    struct LinkedList *temp = new LinkedList(data);
    if(head == NULL)
    {
        head = temp;
        return head;
    }
    temp->next = head;
    head = temp;
    return head;
};
struct LinkedList *Solution::reverseLinkedList(struct LinkedList *head)
{
    if(head == NULL)
    {
        return head;
    }
    struct LinkedList *prev = NULL;
    struct LinkedList *curr = head;
    struct LinkedList *next;
    while(curr != NULL)
    {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    Solution sol;
    struct LinkedList *head = new LinkedList(5);
    head->next = new LinkedList(10);
    head->next->next = new LinkedList(100);
    head->next->next->next = new LinkedList(41);
    head->next->next->next->next = new LinkedList(2);
    head->next->next->next->next->next = new LinkedList(20);
    head->next->next->next->next->next->next = new LinkedList(15);
    head->next->next->next->next->next->next->next = new LinkedList(60);
     head->next->next->next->next->next->next->next->next = new LinkedList(70);
   // struct LinkedList * ans = sol.reverseLinkedList(head);
   // struct LinkedList *x = sol.addAtfirst(head , 4);
   //struct LinkedList *x = sol.addAtLast(head , 24);
   struct LinkedList *x = sol.addInMiddle(head , 14);
    struct LinkedList *ans = x;
    while(ans != NULL)
    {
        cout << ans->data << " ";
        ans = ans->next;
    }
    return 0;
}
