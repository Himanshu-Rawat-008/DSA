<h1>Idea</h1>

The basic idea is this: 
> at each step, we keep track of the furthest reachable index. 

> The nature of the problem (eg. maximal jumps where you can hit a range of targets instead of singular jumps where you can only hit one target) is that for an index to be reachable, each of the previous indices have to be reachable.

<h1>Approach</h1>

```Hence, it suffices that we iterate over each index, and If we ever encounter an index that is not reachable, we abort and return false. By the end, we will have iterated to the last index. If the loop finishes, then the last index is reachable.```