### math vs DP

Find how many ways from A to B;
![](./image/25353.png)
math method:	
	A->P C(6, 2) = 15	
	P->B C(6, 3) = 20	
	A->p->B  15 * 20 = 300	
total: 	
	C(12, 5) - 300 = 492
	
Dynamic program method
![](./image/25353_.png)