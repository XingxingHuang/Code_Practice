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
    
