#include<bits/stdc++.h>
using namespace std;

struct TreeNode
{
    int data;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int val) : data(val), left(NULL), right(NULL){}
};
class Solution
{
    private:
    public:
        Solution();
        bool _heightBalancedTreeCheck(struct TreeNode *root);
        int height(struct TreeNode *root);
};
Solution::Solution(){}
int Solution::height(struct TreeNode *root)
{
    if(root == NULL)
    {
        return 0;
    }
    queue<struct TreeNode *> q;
    q.push(root);
    int h (0);
    while(1)
    {
        int s = q.size();
        if(s == 0)
        {
            return h;
        }
        h++;
        while(s--)
        {
            struct TreeNode *node = q.front();
            q.pop();
            if(node->left)
            {
                q.push(node->left);
            }
            if(node->right)
            {
                q.push(node->right);
            }
        }
    }
    return h;
}
 bool Solution::_heightBalancedTreeCheck(struct TreeNode *root)
 {
     if(root == NULL)
     {
         return true;
     }
     int lh = height(root->left);
     int rh = height(root->right);

     if(abs(lh-rh) <= 1 && _heightBalancedTreeCheck(root->left) &&_heightBalancedTreeCheck(root->right))
     {
         return true;
     }
     return false;
 }
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    Solution sol;
    TreeNode *root = new TreeNode(8);
    root->left = new TreeNode(5);
    root->right = new TreeNode(10);
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(6);
    root->right->left = new TreeNode(9);
    root->right->right = new TreeNode(12);

    if(sol._heightBalancedTreeCheck(root))
    {
        cout << "Yes it's height balanced" <<endl;
    }
    else{
        cout << "No it's not height balanced" <<endl;
    }
    return 0;
}
