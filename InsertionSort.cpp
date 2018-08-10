#include<bits/stdc++.h>
using namespace std;

class Solution{
private:
public:
    Solution();
    vector<int> insertionSort(vector<int> &A);
};
Solution::Solution(){}
vector<int> Solution::insertionSort(vector<int> &A)
{
    if(A.size() == 0)
    {
        return A;
    }
    for(int iter = 1; iter < A.size(); iter++)
    {
        int key = A[iter];
        int jter = iter-1;
        while(jter >= 0 && A[jter] > key)
        {
            A[jter+1] = A[jter];
            jter--;
        }
        A[jter+1] = key;
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
        vector<int> ans = sol.insertionSort(A);
        for(vector<int>::iterator iter = ans.begin(); iter != ans.end(); iter++)
        {
            cout << *iter << " ";
        }
        cout << endl;
    }
    return 0;
}
