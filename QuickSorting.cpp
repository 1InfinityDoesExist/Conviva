#include<bits/stdc++.h>
using namespace std;

class Solution{
private:
public:
    Solution();
    vector<int> quickSorting(vector<int> &A);
    void quickSort(vector<int> &A, int low, int high);
    int partition(vector<int> &A, int low, int high);
};
Solution::Solution(){}
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}
int Solution::partition(vector<int> &A, int low, int high)
{
    int pivot = A[high];
    int iter = low-1;
    for(int jter = low; jter < high; jter++)
    {
        if(A[jter] <= pivot)
        {
            iter++;
            swap(A[iter], A[jter]);
        }
    }
    swap(A[iter+1], A[high]);
    return iter+1;
}
void Solution::quickSort(vector<int> &A, int low, int high)
{
    if(low < high)
    {
        int pi = partition(A, low, high);
        quickSort(A, low, pi-1);
        quickSort(A, pi+1, high);
    }
}
vector<int> Solution::quickSorting(vector<int> &A)
{
    int low = 0;
    int high = A.size()-1;
    quickSort(A, low, high);
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
        vector<int> v;
        for(int iter = 0; iter < n; iter++)
        {
            int data;
            cin >> data;
            v.push_back(data);
        }
        vector<int> ans = sol.quickSorting(v);
        for(vector<int>::iterator iter = ans.begin(); iter != ans.end(); iter++)
        {
            cout << *iter << " ";
        }
        cout << endl;
    }
    return 0;
}
