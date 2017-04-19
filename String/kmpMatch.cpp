#include <iostream>
#include <string>

using namespace std;

const int MAX = 100;
int next[MAX] = {0};

// 计算部分匹配表
void getNext(string pattern) {
    int j = 0, k = -1;
    next[0] = -1;
    while (j < (int)pattern.length() - 1) {
        if (-1 == k || pattern[j] == pattern[k]) {
            j++;
            k++;
            next[j] = k;
        } else {
            k = next[k];
        }
    }
    return;
}

// KMP算法
int kmpMatch(string target, string pattern) {
    int i = 0, j = 0, index = 0;
    getNext(pattern); // 计算部分匹配表

    while (i < (int)target.length() && j < (int)pattern.length()) {
        if (-1 == j || target[i] == pattern[j]) {
            i++;
            j++;
        } else {
            j = next[j]; // 如果出现部分不匹配，获取跳过的位置
        }
    }

    if (j >= (int)pattern.length())
        index = i - pattern.length(); // 匹配成功，返回匹配子串的首字符下标
    else
        index = -1; // 匹配失败

    return index;

}

void print(string target, string pattern, int index) {
    if (-1 != index) {
        cout << "[" << pattern << "] is in the Pos = " << index << " of [" << target << "]" << endl;
    } else {
        cout << "[" << pattern << "] is not in the [" << target << "]" << endl;
    }
}

int main()
{
    string target = "ababcabcacbab";
    string pattern = "abcac";
    int index = kmpMatch(target, pattern);
    print(target, pattern, index);
    return 0;
}



KMP算法之C++实现