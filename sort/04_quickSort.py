#!/usr/bin/env python
# -*- coding: UTF-8
import numpy as np


#快速排序
#L：待排序的序列；start排序的开始index,end序列末尾的index
#对于长度为length的序列：start = 0;end = length-1
def quick_sort(L, start, end):
    i, j, pivot = start, end, L[(start + end) / 2]
    while i <= j:
        #从右开始向左寻找第一个小于pivot的值
        while (L[j] > pivot):
            j -= 1
        #从左开始向右寻找第一个大于pivot的值
        while (L[i] < pivot):
            i += 1
        #将大于pivot的值移到右边
        if (i <= j):
            L[i], L[j] = L[j], L[i]
            i += 1
            j -= 1
    #左侧序列继续排序
    if end > i:
        quick_sort(L, i, end)
    #右侧序列继续排序
    if start < j:
        quick_sort(L, start, j)
    return L
     
#快速排序
#L：待排序的序列；start排序的开始index,end序列末尾的index
#对于长度为length的序列：start = 0;end = length-1
def quick_sort2(L,start,end):
    if start < end:
        i , j , pivot = start , end , L[start]
        while i < j:
            #从右开始向左寻找第一个小于pivot的值
            while (i < j) and (L[j] >= pivot):
                j = j-1
            #将小于pivot的值移到左边
            if (i < j):
                L[i] = L[j]
                i = i+1 
            #从左开始向右寻找第一个大于pivot的值
            while (i < j) and (L[i] < pivot):
                i = i+1
            #将大于pivot的值移到右边
            if (i < j):
                L[j] = L[i]
                j = j-1
        #循环结束后，说明 i=j，此时左边的值全都小于pivot,右边的值全都大于pivot
        #pivot的位置移动正确，那么此时只需对左右两侧的序列调用此函数进一步排序即可
        #递归调用函数：依次对左侧序列：从0 ~ i-1//右侧序列：从i+1 ~ end
        L[i] = pivot
        #左侧序列继续排序
        quick_sort(L, start, i - 1)
        #右侧序列继续排序
        quick_sort(L, i + 1, end)
    return L
      
if __name__ == '__main__':
    nums = np.random.randint(1, 100, 10)
    nums2 = quick_sort(nums, 0, len(nums) - 1)
    nums3 = quick_sort2(nums, 0, len(nums) - 1)
    print "Before: "
    print nums
    print "After: "
    print nums2
    for i in range(1, len(nums2)):
        if nums[i] < nums[i - 1]:
            print "Wrong Sort!"
    for i in range(1, len(nums3)):
        if nums[i] < nums[i - 1]:
            print "Wrong Sort!"
    print "Success!"
    