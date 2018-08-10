#include<bits/stdc++.h>
using namespace std;
class Solution
{
private:
public:
    Solution();
    vector<int> bubbleSort(vector<int> &A);
};
Solution::Solution(){}
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}
vector<int> Solution::bubbleSort(vector<int> &A)
{
    if(A.size() == 0)
    {
        return A;
    }
    bool swapped = true;
    for(int pass = A.size()-2; pass >= 0 && swapped; pass--)
    {
        swapped = false;
        for(int iter = 0; iter <= pass; iter++)
        {
            if(A[iter] > A[iter+1])
            {
                swap(&A[iter], &A[iter+1]);
                swapped = true;
            }
        }
    }
    return A;
}
int main(){
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
        vector<int> ans = sol.bubbleSort(A);
        for(vector<int>::iterator iter = ans.begin(); iter != ans.end(); iter++)
        {
            cout << *iter << " ";
        }
        cout << endl;
    }
    return 0;
}
