To condition that are very important in question are :-

1. majority element will definitely appear more than n/2 times (n is length of given array)

1. Majority element will always exists.

Test Cases :-

> [1, 2, 2, 3] => 2

> [1, 2, 3] => Invalid Array, it does not satisfy 2<sup>nd</sup> condition.

> [1, 1, 2, 2, 3, 3, 3] => Invalid Array, 3 here appears 3 times but it does not satisfy 1<sup>st</sup> condition. 

So simple logic that is optimized here is.

Any element that is in mid of given array is definitely in majority because there will always be element that appears more than n/2 times.