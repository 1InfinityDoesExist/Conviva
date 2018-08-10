#include<bits/stdc++.h>
using namespace std;

class Solution{
private:
public:
    Solution();
    vector<int> mergeSort(vector<int> &A);
    void merge(vector<int> &A, int low, int high);
    void merging(vector<int> &A, int low, int mid, int high);
};
Solution::Solution(){}
void Solution::merging(vector<int> &A, int low, int mid, int high)
{
    int left_len = mid-low+1;
    int right_len = high-mid;
    int *left = (int *)malloc(sizeof(int) * left_len);
    int *right = (int *)malloc(sizeof(int) *right_len);

    for(int iter = 0; iter < left_len; iter++)
    {
        left[iter] = A[low+iter];
    }
    for(int iter = 0; iter < right_len; iter++)
    {
        right[iter] = A[mid+iter+1];
    }
    int iter = 0;
    int jter = 0;
    int kter = low;
    while(iter < left_len && jter < right_len)
    {
        if(left[iter] <= right[jter])
        {
            A[kter] = left[iter];
            iter++;
        }
        else{
            A[kter] = right[jter];
            jter++;
        }
        kter++;
    }
    while(iter < left_len)
    {
        A[kter] = left[iter];
        iter++;
        kter++;
    }
    while(jter < right_len)
    {
        A[kter] = right[jter];
        jter++;
        kter++;
    }
    return;
}
void Solution::merge(vector<int> &A, int low, int high)
{
    if(low < high)
    {
        int mid = low + (high-low)/2;
        merge(A, low, mid);
        merge(A, mid+1, high);
        merging(A, low, mid, high);
    }
}
vector<int> Solution::mergeSort(vector<int> &A)
{
    int low = 0;
    int high = A.size()-1;
    merge(A, low, high);
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
        sol.mergeSort(A);
        for(vector<int>::iterator iter = A.begin(); iter != A.end(); iter++)
        {
            cout << *iter << " ";
        }
        cout << endl;
    }
    return 0;
}
