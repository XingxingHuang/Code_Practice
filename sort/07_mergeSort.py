#!/usr/bin/env python
# -*- coding: UTF-8
import numpy as np

# 归并排序
#这是合并的函数
# 将序列L[first...mid]与序列L[mid+1...last]进行合并
def mergearray(L,first,mid,last,temp):
#对i,j,k分别进行赋值
  i,j,k = first,mid+1,0
#当左右两边都有数时进行比较，取较小的数
  while (i <= mid) and (j <= last):
      if L[i] <= L[j]:
          temp[k] = L[i]
          i = i+1
          k = k+1
      else:
          temp[k] = L[j]
          j = j+1
          k = k+1
#如果左边序列还有数
  while (i <= mid):
      temp[k] = L[i]
      i = i+1
      k = k+1
#如果右边序列还有数
  while (j <= last):
      temp[k] = L[j]
      j = j+1
      k = k+1
#将temp当中该段有序元素赋值给L待排序列使之部分有序
  for x in range(0,k):
      L[first+x] = temp[x]
# 这是分组的函数
def merge_sort(L,first,last,temp):
  if first < last:
      mid = (int)((first + last) / 2)
#使左边序列有序
      merge_sort(L,first,mid,temp)
#使右边序列有序
      merge_sort(L,mid+1,last,temp)
#将两个有序序列合并
      mergearray(L,first,mid,last,temp)
# 归并排序的函数
def merge_sort_array(L):
#声明一个长度为len(L)的空列表
  temp = len(L)*[None]
#调用归并排序
  merge_sort(L,0,len(L)-1,temp)
  return L
     
if __name__ == '__main__':
    nums = np.random.randint(1, 100, 10)
    nums2 = merge_sort_array(nums)
    print "Before: "
    print nums
    print "After: "
    print nums2
    for i in range(1, len(nums2)):
        if nums[i] < nums[i - 1]:
            print "Wrong Sort!"
    print "Success!"
    