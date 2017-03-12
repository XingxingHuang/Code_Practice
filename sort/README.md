quick sort 

[JAVA 示范](http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html)

###二叉树相关	
[基本遍历方法](BinaryTree.java)	
[按层遍历](BinaryTree_tranverse.java)		
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

