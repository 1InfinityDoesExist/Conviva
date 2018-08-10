#include<bits/stdc++.h>
using namespace std;
class Solution
{
private:
public:
    Solution();
    vector<int> bubbleSorting(vector<int> &A);
};
Solution::Solution(){}
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}
vector<int> Solution::bubbleSorting(vector<int> &A)
{
    for(int iter = 0; iter < A.size()-1; iter++)
    {
        for(int jter = iter+1; jter < A.size(); jter++)
        {
            if(A[iter] > A[jter])
            {
                swap(&A[iter],&A[jter]);
            }
        }
    }
    return A;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    Solution sol;
    int testCase;
    cin >> testCase;
    while(testCase--)
    {
        int n;
        cin >> n;
        vector<int> A;
        for(int iter = 0; iter < n; iter++)
        {
            int data;
            cin >> data;
            A.push_back(data);
        }
        vector<int> ans = sol.bubbleSorting(A);
        for(vector<int>::iterator iter = ans.begin(); iter != ans.end(); iter++)
        {
            cout << *iter << " ";
        }
        cout << endl;
    }
    return 0;
}
