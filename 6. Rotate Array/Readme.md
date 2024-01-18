For this let focus these points :-

> If k > n, where k is given steps and n is length of given array, then after n steps array is at same starting position. So will get absolute number steps by k%n.

> We can actually rotate array but 180 which is reverse it. why lets see how

``` 
[1,2,3,4,5,6,7] k = 3

Output = [5,6,7,1,2,3,4]

if we see here this array is actually reverse

Original Array = [1,2,3,4,5,6,7]
After reversing = [7,6,5,4,3,2,1]

Now if we again reverse it from range [0, k-1] and [k, n-1];

Result = [5,6,7,1,2,3,4]

```