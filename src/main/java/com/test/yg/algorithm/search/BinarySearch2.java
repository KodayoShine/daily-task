package com.test.yg.algorithm.search;

/**
 * 着眼于掌握核心思想，而不该去纠结二分的几种写法的区别，这样会让自己更乱；
 * <p>
 * 在面对问题的时候，主要精力花在 如何分析，利用单调性或者题目本身蕴含的可以逐渐缩小问题规模的特性解决问题，而不应该纠结在「二分查找」该怎么写。
 * <p>
 * 二分查找算法就一种思想：减而治之（逐渐缩小问题规模）。
 * 应该先了解算法的设计思想，想清楚为什么算法这样设计，然后再模仿，最后是练习和总结。
 * 在遇到问题的时候，一定需要耐心调试，
 * 把变量打印出来看一下，是远比「光对着代码看」「在脑子里想」要好很多的调试方法，
 * 我们编码能力也就是在这样看似不起眼的技巧中的得到了提升。
 * 一定不可以在还没有理解算法思想的基础上「生搬硬套」自己没有理解到位的代码模板。
 * <p>
 * **我们总是在区间 [left..right] 里查找元素目标。**
 * 注意是左闭右闭区间。
 * 为什么不是「左闭右开」呢？
 * 「左闭右开」当然可以，
 * 但是我们不想把精力花在「右边界是不是可以取到」这件事情上，
 * 并且 任意一个「左闭右开」区间一定唯一对应一个「左闭右闭」区间，
 * 所以到底是开区间还是闭区间，保持一致就可以。
 * 根据 mid 位置是不是目标元素，进
 * 而判断 mid 的左边是否存在目标元素，
 * mid 的右边是否存在目标元素，只把搜索区间分为两个部分。
 *
 *
 * 两种写法
 *
 * while(left < right) 与 left = mid + 1 、 right = mid 的搭配； ******* 最常使用的方式
 * while(left < right) 与 left = mid 、 right = mid - 1 的搭配；
 *
 * 根据看到的中间位置的元素的值 nums[mid] 可以把待搜索区间分为两个部分：
 *
 * * *一定不存在 目标元素的区间：
 *              下一轮搜索的时候，不用考虑它；
 * * * 可能存在 目标元素的区间：
 *              下一轮搜索的时候，需要考虑它。
 *
 * 由于 mid 只可能被分到这两个区间的其中一个，即：while 里面的 if 和 else 就两种写法：
 *
 *      如果 mid 分到左边区间，即区间分成 [left..mid] 与 [mid + 1..right]，
 *                  此时分别设置 right = mid 与 left = mid + 1；
 *
 *      如果 mid 分到右边区间，即区间分成 [left..mid - 1] 与 [mid..right]，
 *                  此时分别设置 right = mid - 1 与 left = mid。
 *
 * 并且把 循环可以继续的条件 写成 while (left < right)。在上面把待搜索区间分成两个部分的划分下，退出循环以后一定会有 left == right 成立，因此我们在退出循环以后，就不需要考虑到底返回 left 还是返回 right。
 *
 *
 * https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
 *
 *
 *
 *
 *
 *
 * @author sunshine
 */
public class BinarySearch2 {


}
