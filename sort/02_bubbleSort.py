#!/usr/bin/env python
# -*- coding: UTF-8
import numpy as np

#冒泡排序
def bubble_sort(L):
    length = len(L)
    #序列长度为length，需要执行length-1轮交换
    for x in range(1, length):
        #对于每一轮交换，都将序列当中的左右元素进行比较
        #每轮交换当中，由于序列最后的元素一定是最大的，因此每轮循环到序列未排序的位置即可
        for i in range(0, length-x):
            if L[i] > L[i+1]:
                L[i], L[i + 1] = L[i + 1], L[i]
    return L
     
if __name__ == '__main__':
    nums = np.random.randint(1, 100, 10)
    nums2 = bubble_sort(nums)
    print "Before: "
    print nums
    print "After: "
    print nums2
    for i in range(1, len(nums2)):
        if nums[i] < nums[i - 1]:
            print "Wrong Sort!"
    print "Success!"
    