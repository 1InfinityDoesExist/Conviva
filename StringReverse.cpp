#include<bits/stdc++.h>
using namespace std;

class Solution{
private:
public:
    Solution();
    void reverseString(string str);
};
Solution::Solution(){}
void swap(char *a, char *b)
{
    char k = *a;
    *a = *b;
    *b = k;
}
void Solution::reverseString(string str)
{
    int start = 0;
    int end = str.length()-1;
    while(start < end)
    {
        swap(&str[start++], &str[end--]);
    }
    cout << str << endl;
    return;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    Solution sol;
    sol.reverseString("Hello World!!!");
    return 0;
}
