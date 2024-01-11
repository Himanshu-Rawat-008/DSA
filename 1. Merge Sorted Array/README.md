[Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150)

So the approach I used is bit tacky. I did what we use for merging two sorted array.

But what I learnt, since this is a problem where we want to use same array. We can start from last index of both arrays and in this way we wont lose any of the numbers and because it is sorted you will just enter elements in sorted array.

Example:
Compare indexes and update at final index.

| Final Index | 1st Array | 1st index  | 2nd Array  | 2nd index  |
| --- | --- | --- | --- | --- |
|5    | [1,2,3,0,0,0] | 2 | [2,4,5] | 2 |
|4    | [1,2,3,0,0,5] | 2 | [2,4,5] | 1 |
|3    | [1,2,3,0,4,5] | 2 | [2,4,5] | 0 |
|2    | [1,2,3,3,4,5] | 1 | [2,4,5] | 0 |
|1    | [1,2,2,3,4,5] | 1 | [2,4,5] | -1 |




