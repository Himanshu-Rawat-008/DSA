[Remove Element](https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150)

What i did is taking two pointers, say i and j

>  1. if both are not equal to val, increment both i and j
>  1. if element at i is val and element at j is not, swap both, increment both i and j
>  1. if element at i is val, increment only j

To optimize this approach,
    
    If j is increment in all the cases, it means we can run a loop till nums.length

```java
while(j<nums.length) {
    if(nums[i] != val && nums[j] != val) {
                i++;
    } else if(nums[i] == val && nums[j] != val) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
    }
    j++; 
}
```
---
---
    A/c to first point, we can remove third condition on our previous approach

```java
while(j<nums.length) {
    if(nums[i] != val && nums[j] != val) {
        i++;
    } else if(nums[i] == val && nums[j] != val) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
    }
    j++;
}
```

---
---

    For 2nd point in our approach, we dont actually have to swap we can just enter element at i, which is at j

```java
while(j<nums.length) {
    if(nums[i] != val && nums[j] != val) {
        i++;
    } else if(nums[i] == val && nums[j] != val) {
        nums[i] = nums[j];
        i++;
    }
    j++;
}
```
---
---
    Now if you see it does not matter if element at index i is equal to val or not, it will keep incrementing, but the second condition is common so now,

```java
while(j<nums.length) {
   if(nums[j] != val) {
        nums[i] = nums[j];
        i++;
    }
    j++;
}
```

Now that is the most optimized solution.