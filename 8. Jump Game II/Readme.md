<h1>Idea</h1>

The basic idea is this: 
> at each step, we store count till current step can reach. 

> The nature of the problem  is that for an index there are multiple ways to reach it but we have to store minimum out of those.

<h1>Approach</h1>

- We create extra array let suppose `res` to store number of minimum steps to reach that point or index and is same length as given array. 

- Step taken to reach 0 index is 0 and store it in res.

- We now iterate over given array.

- for current index `i`, we again iterate from current index + 1 to nums.length or where current index + value at current index in given array is less

- inside this iteration, we will store number of step in res where we find if value in res for given index is less or value = res at i + 1.

- return res[nums.length - 1]