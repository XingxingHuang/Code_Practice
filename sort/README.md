### 排序相关
quick sort 

[JAVA 示范](http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html)
[Python动图讲解](http://www.jianshu.com/p/7d037c332a9d)

--
### 二叉树相关	
[基本遍历方法](BinaryTree_tranverse01.java)	
[按层遍历](BinaryTree_tranverse02.java)		
>等于图的宽度优先搜索的应用。		
> * last: 表示正在打印当前行的最右节点，初始化为root		
> * nlast：表示下一行的最右节点，初始化为root	
> * queue：存放某一层的节点，初始化为root		
> 当queue不为空的时：		
> ---- 每次依次弹出节点打印，并且将左右孩子加入队列，	
> ---- nlast随着加入移动更新。	
> ---- 打印到last指定元素时终止。
> ---- 更新last为nlast，可以加入height更新。	

[序列化和反序列化]
> str = "12!3!#!#!"
> values = ["12", "3", "#", "#", "#"]	
>  		12	
> 	3	null	 
> null null	

--
### 字符串相关
检查旋转词 
> 看是str2 是否存在str1 + str1 中。	

将句子中的字符串按照空格隔开的次序翻转	
> 完成一个逆序函数，单词逆序，然后整个逆序	

将字符串左边的n个字符完全移动到右边
> 前n逆序，后m逆序，整体逆序

将N个字符串拼接成字典顺序最小的字符串
> 实际上是一个排序，排序比较的是str1 + str2 和 str2 + str1 字符串的字典顺序