// two pointer
// quick sort 
public int partition(int[] nums, int l, int r) {
    // 初始双指针 和 pivot
    int left = l;
    int right = r;
    int pivot = nums[left];
    while (left < right) {
        // 右边小与的移动到左边
        while (left < right && num[right] >= pivot) {
            right--;
        }
        nums[left] = nums[right];
        // 左边小于的移动到右边
        while (left < right && nums[left] <= pivot) {
            left++;
        }
        nums[right] = nums[left];
    }
    // 注意这一句！！ pivot归位。
    nums[left] = pivot;
    return left
}