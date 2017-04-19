#include <iostream>
#include <string>

using namespace std;

int bfMatch(string target, string pattern) {
    int pos = -1;
    int i = 0, j = 0, k = 0;

    // 在没找到匹配pattern的子串前，遍历整个target
    while (-1 == pos && i < (int)target.length()) {

        // 将目标串和模式串逐一比对，如果有不同的则退出
        while (j < (int)pattern.length() && target[i] == pattern[j]) {
            i++;
            j++;
        }

        if (j >= (int)pattern.length()) { // 如果模式串扫描完，说明目标串中含有这个子串
            pos = k;
        } else { // 反之，没有扫描完，则从目标串的下一个字符开始重新逐一比对
            j = 0;
            k++;
            i = k;
        }
    }

    return pos;
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
    string target = "Hello World";
    string pattern = "llo";
    string pattern2 = "Woe";

    int index = bfMatch(target, pattern);
    int index2 = bfMatch(target, pattern2);
    print(target, pattern, index);
    print(target, pattern2, index2);
    return 0;
}



BF算法之C++实现