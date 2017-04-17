#!/usr/bin/env python
# -*- coding: UTF-8
import numpy as np

# 简单选择排序
def select_sort(L):
    #依次遍历序列中的每一个元素
    for x in range(0, len(L)):
        #将当前位置的元素定义此轮循环当中的最小值
        minVal = L[x]
        #将该元素与剩下的元素依次比较寻找最小元素
        for i in range(x + 1, len(L)):
            if L[i] < minVal:
                minVal, L[i] = L[i], minVal
        #将比较后得到的真正的最小值赋值给当前位置
        L[x] = minVal
    return L
     
if __name__ == '__main__':
    nums = np.random.randint(1, 100, 10)
    nums2 = select_sort(nums)
    print "Before: "
    print nums
    print "After: "
    print nums2
    for i in range(1, len(nums2)):
        if nums[i] < nums[i - 1]:
            print "Wrong Sort!"
    print "Success!"
    