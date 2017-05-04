###分治算法题目汇总
1. merge sort 	
	    注意递归和非递归两种写法，查看我的[github](https://github.com/XingxingHuang/Code_Practice/tree/master/sort)中的代码。或者本目录下[code](./code)
	
2. quick sort	
		注意多重写法，查看我的[github](https://github.com/XingxingHuang/Code_Practice/tree/master/sort)中代码.	。或者本目录下[code](./code)
		双指针，[partition模板](./code/partition.java)
		
3. binary tree相关操作		
   		树的[递归遍历](./code/Tree_7_02_print.java)	
		树的[非递归遍历](./code/Tree_7_03_noRecursive.java)	
		树的[按层遍历](./code/Tree_7_03_noRecursive.java)	
		   		
		树的遍历	
		二叉树深度	
		平衡二叉树		
	
4. 二分法相关问题			
		大多数二分搜素比较容易。需要注意指针的边界情况处理，建议采用[二分法模板](./code/BinarySearch.java)。
		
5. 大数据题目中很多包含分治思想		
		其核心是排序算法。以及HashMap的应用的相关知识。
		例如：
		
		有一个包含20亿全是32位整数的大文件，在其中找到出现次数最多的数。内存限制2G 使用hash函数进行分流。
		
--
###leetcode 4 [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/#/description)
参考代码请看 [code](./code/4_Median_Two_Sorted_Arrays.java)	
也可以参考每日一题微信号上的[总结](./[每日一题]4.pdf)

1. 暴力方法：包含合并数组求解，双指针顺序求解。但是时间复杂度均为O(m + n)量级。	
2. 分治方法：减少了冗余查找，时间复杂度降低到 O(log m+n)。优化思路在于对有序数组里面查找元素的敏感度。

```java
// calculate the mid
int mid1 = nums1[lo1 + k/2 - 1];
int mid2 = nums2[lo2 + k/2 - 1];
if (mid1 < mid2) {
    return findKth(nums1, lo1 + k/2, nums2, lo2, k - k/2);
} 
return findKth(nums1, lo1, nums2, lo2 + k/2, k - k/2);
```
我们要找合并数组中的第k个元素，那么可以查看两个数组中k/2的元素的值。如果mid1 < mid2，那么中值会在数组1的右部分，或者数组2的左部分，搜索长度减半。mid1 > mid2的情况正好相反。如果mid1 = mid2，那么返回结果可能是mid1 (mid2)，或者他们的下一个元素，这种情况可以跟上面两种情况可以合并考虑。需要读者自己去计算边界思考为什么。

这种指针的边界条件主要是指针加减1，或者比较时大于号和大于等于号的差异，需要写算法之前，对具体问题认识清楚。对于常用问题，例如二分法，快排，集中边界条件处理是很好的方法。

该方法也可以改写成非递归算法实现。非递归算法通过指针的移动来求解。可以对应partition的模板代码来分析。

> 解题难点：	
> 边界条件，递归实现。奇偶长度数组求中值。指针边界判断。

> 解题技巧：
> 奇偶长度数组求中值可以转化为统一公式求解。减少边界条件判断

--
###leetcode 312 [Burst Balloons](https://leetcode.com/problems/burst-balloons/#/description)	
参考代码请看 [code](./code/312_Burst_Balloons.java)

通过分析暴力解法，可以发现重复的构造，这时候就能够用记忆化搜索算法来解决。记忆化搜索时机上就是dp的递归形式，往往能改写成直接动态规划的解法。动态规划的策略稍微复杂一点无法直接想出来。实际上都是通过优化过程一步步总结而来。可以查看参考代码来加深理解。

难点在于，原始问题中计算每个位置的分数时，该位置左右元素是没法确定的。因此需要解题者思考出如何计算出每个位置旁边出现不同元素时是如何求解的。

> 解题难点：	
> 如何分解成子问题。递归。自顶向下的问题。	

> 解题要点：
> 理解记忆化搜索的本质。划分子问题敏感度。
> 自顶向下思考方法，自底向上思考方法。

--
###直播问题汇总
1. 刷题相关		
 
多刷多总结。有多想刷题就能有多少动力。		
 
 初入刷题，可以刷，排序算法，剑指offer，cc150。已经开始找面试刷leetcode，lintcode。面试快到了，其实你也知道干什么，不需要太多指导。刷面经，看总结，继续刷leetcode。	
 
 刷题是一件慢慢积累的事情，需要坚持。刷完100题就会入门。请教时多问具体问题，少问假大空。充分利用身边人力物力资源。
 
2. 如何练习递归。

排序算法里面很多递归，二叉树遍历里面有递归，这些算法刷完多总结。结合其他人的博客可以容易入门。

3. 刷题提不起精神怎么办

加入每日一题微信群分享心得。加我微信push你。
 

