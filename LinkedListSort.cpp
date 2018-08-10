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
    struct LinkedList *sortedList(struct LinkedList *head);
};
Solution::Solution(){}
void swap(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}
struct LinkedList *Solution::sortedList(struct LinkedList *head)
{
    for(struct LinkedList *current = head; current->next != NULL; current = current->next)
    {
        for(struct LinkedList *selection = current->next; selection != NULL; selection = selection->next)
        {
            if(current->data > selection->data)
            {
                swap(&current->data , &selection->data);
            }
        }
    }
    return head;
};
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

   struct LinkedList *x = sol.sortedList(head);
    struct LinkedList *ans = x;
    while(ans != NULL)
    {
        cout << ans->data << " ";
        ans = ans->next;
    }
    return 0;
}
