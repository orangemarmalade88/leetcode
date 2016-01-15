# leetcode

# K Sum 小总结

一般来说 K Sum 有两种方法， Hashmap 法 和 Sort + 2pointers 法

先说 sort + 2pointers 法， 比较直观
复杂度是 sort: O(NlgN) + 2 pointers O(N^(k-1))

* TwoSumII O(N)
* ThreeSum O(N^2) 
* 以及扩展 ThreeSumClosest O(N^2) 
* ThreeSumSmaller O(N^2)
* FourSum O(N^3)  (不推荐)
都可以用这种方法做

再说 hashmap 一般存的是离target 差一个数的index，这样去重复方便
复杂度取决于存的内容和具体用法，存一个数O(N),存pair O(N^2)

* TwoSum O(N)
* TwoSumIII (data structure) O(N)
* 重点说下FourSum
* FourSum 如果把<partial sum, pair> 存在一个multi map里面 理论上可以达到 O(N^2) 
* 但最坏情况，pair 的sum 大量重合，这时取pair会有 O(N^2) 种， 复杂度 O(N^4)
* 好一点，把pair和sum存在一个array里，用法一的two pointers法来做 复杂度是 O(N^2lg(N^2))=O(N^2lgN)
* ThreeSum 如果 不允许 sort, 也可以用hashmap 做  存pairs 
* 情况和 FourSum类似 也有两种具体的办法
