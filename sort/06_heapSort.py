#!/usr/bin/env python
# -*- coding: UTF-8
import numpy as np

#-------------------------堆排序--------------------------------
#**********获取左右叶子节点**********
def LEFT(i):
    return 2*i + 1
def RIGHT(i):
    return 2*i + 2
    
#********** 调整大顶堆 **********
#L:待调整序列 length: 序列长度 i:需要调整的结点
def adjust_max_heap(L,length,i):
    #定义一个int值保存当前序列最大值的下标
    largest = i
    #执行循环操作：两个任务：1 寻找最大值的下标；2.最大值与父节点交换
    while (1):
        #获得序列左右叶子节点的下标
        left, right = LEFT(i), RIGHT(i)
        #当左叶子节点的下标小于序列长度 并且 左叶子节点的值大于父节点时，将左叶子节点的下标赋值给largest
        if (left < length) and (L[left] > L[i]):
            largest = left
            print('左叶子节点')
        else:
            largest = i
        #当右叶子节点的下标小于序列长度 并且 右叶子节点的值大于父节点时，将右叶子节点的下标值赋值给largest
        if (right < length) and (L[right] > L[largest]):
            largest = right
            print('右叶子节点')
        #如果largest不等于i 说明当前的父节点不是最大值，需要交换值
        if (largest != i):
            L[i], L[largest] = L[largest], L[i]
            i = largest
            print(largest)
            continue
        else:
            break
            
#********** 建立大顶堆 **********
def build_max_heap(L):
    length = len(L)
    for x in range((int)((length-1)/2),-1,-1):
        adjust_max_heap(L,length,x)
        
#********** 堆排序 **********
def heap_sort(L):
    #先建立大顶堆，保证最大值位于根节点；并且父节点的值大于叶子结点
    build_max_heap(L)
    #i：当前堆中序列的长度.初始化为序列的长度
    i = len(L)
    #执行循环：1. 每次取出堆顶元素置于序列的最后(len-1,len-2,len-3...)
    #         2. 调整堆，使其继续满足大顶堆的性质，注意实时修改堆中序列的长度
    while (i > 0):
        L[0], L[i - 1] = L[i - 1], L[0]
        #堆中序列长度减1
        i = i-1
        #调整大顶堆
        adjust_max_heap(L,i,0)
    return L
     
if __name__ == '__main__':
    nums = np.random.randint(1, 100, 10)
    nums2 = heap_sort(nums)
    print "Before: "
    print nums
    print "After: "
    print nums2
    for i in range(1, len(nums2)):
        if nums[i] < nums[i - 1]:
            print "Wrong Sort!"
    print "Success!"
    