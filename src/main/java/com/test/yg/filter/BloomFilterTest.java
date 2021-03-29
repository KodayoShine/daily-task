package com.test.yg.filter;

import com.google.common.collect.Lists;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 布隆过滤器
 *
 * 对一个key值进行多次的hash运算
 * 对运算后的结果做数组的取模运算
 * 将取完模的值放在对应数组上,记录成1(多次hash,会对多个位置上设置)
 *
 * 所以在判断不存在的数值时,只要有一次hash后的值为0 就返回false
 *
 * 这种方法适用于数据命中不高、数据相对固定、实时性低（通常是数据集较大）的应用场景，代码维护较为 复杂，但是缓存空间占用很少。
 *
 * @author sunshine
 */
public class BloomFilterTest {

    private List<String> keys = Lists.newArrayList("test", "yg", "project");
    /**
     * 初始化布隆过滤器
     * 1000：期望存入的数据个数，0.001：期望的误差率
     */
    BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 1000, 0.001);

    public BloomFilterTest() {
        init();
    }

    private void init() {
        keys.forEach(bloomFilter::put);
    }

    public static void main(String[] args) {
        BloomFilterTest bloomFilterTest = new BloomFilterTest();
        assert bloomFilterTest.bloomFilter.mightContain("yg");
        assert !bloomFilterTest.bloomFilter.mightContain("abc");
    }


}
