import numpy as np

def quickSort(nums, low, high):
    i = low
    j = high
    pivot = nums[(low + high) / 2]
    while (i <= j):
        while (nums[i] < pivot):
            i += 1
        while (nums[j] > pivot):
            j -= 1
        if (i <= j):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            i += 1
            j -= 1
    if (i < high):
        quickSort(nums, i, high)
    if (j > low):
        quickSort(nums, low, j)
    return nums
    
if __name__ == "__main__":
    nums = np.random.randint(0, 999, size = 10)
    result = quickSort(nums, 0, len(nums) - 1)
    print 'Before:  '
    print nums
    print 'After: '
    print result
    
    
# def quicksort(data, start, end):
#     pivot = data[(start + end) / 2]   
#     i = start
#     j = end 
#     while (start < end):
#         while (data[start] < pivot):
#             start += 1
#         while (data[end] > pivot):
#             end -= 1
#         data = swap(data, start, end)
#         start += 1
#         end -= 1
#     if (end > i):    
#         quicksort(data, i, end)
#     if (start < j):
#         quicksort(data, start, j)
#     return data

# def swap(data, start, end):
#     temp = data[start]
#     data[start] = data[end]
#     data[end] = temp 
#     return data    
        
# if __name__ == '__main__':
#     data = [3, 1, 2, 9, 3, 4]
#     quicksort(data, 0, len(data) - 1)
#     print data
    
#     