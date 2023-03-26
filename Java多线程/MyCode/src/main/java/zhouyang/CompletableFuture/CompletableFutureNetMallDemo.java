package zhouyang.CompletableFuture;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @auther lcy
 * @create 2021-03-08 15:28
 *
 * 需求说明：电商比价需求
 * 1 同一款产品，同时搜索出同款产品在各大电商的售价;
 * 2 同一款产品，同时搜索出本产品在某一个电商平台下，各个入驻门店的售价是多少
 *
 * 出来结果希望是同款产品的在不同地方的价格清单列表，返回一个List<String>
 * 《mysql》 in jd price is 88.05
 * 《mysql》 in pdd price is 86.11
 * 《mysql》 in taobao price is 90.43
 *
 * 3 要求深刻理解
 *   3.1 函数式编程
 *   3.2 链式编程
 *   3.3 Stream流式计算
 */
public class CompletableFutureNetMallDemo {
    // Arrays.asList 将数组转换为列表
    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("pdd"),
            new NetMall("taobao"),
            new NetMall("dangdangwang"),
            new NetMall("tmall")
    );

    //同步 ，step by step

    /**
     * List<NetMall>  ---->   List<String>
     * 一家商店一家商店计算商品价格
     * @param list
     * @param productName
     * @return 返回商品在各大商店得售价
     */
    public static List<String> getPriceByStep(List<NetMall> list,String productName)
    {
        return list.stream().
                map(netMall -> String.format(productName + " in %s price is %.2f", netMall.getMallName(), netMall.calcPrice(productName)))
                .collect(Collectors.toList());
    }
    //异步 ，多箭齐发

    /**
     * List<NetMall>  ---->List<CompletableFuture<String>> --->   List<String>
     *     异步线程 获取价格
     * @param list
     * @param productName
     * @return
     */
    public static List<String> getPriceByASync(List<NetMall> list,String productName)
    {
        return list
                .stream()
                .map(netMall -> CompletableFuture.supplyAsync(() -> String.format(productName + " is %s price is %.2f", netMall.getMallName(), netMall.calcPrice(productName))))
                .collect(Collectors.toList())
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        /**
         * 一家网站一家网站上去找
         */
        long startTime = System.currentTimeMillis();
        List<String> list1 = getPriceByStep(list, "mysql");
        for (String element : list1) {
            System.out.println(element);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("一家商店一家商店查询商品价格----costTime: "+(endTime - startTime) +" 毫秒");

        System.out.println();

        /**
         * 同时几个线程异步去查找
         */
        long startTime2 = System.currentTimeMillis();
        List<String> list2 = getPriceByASync(list, "mysql");
        for (String element : list2) {
            System.out.println(element);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("同时几个网站异步去查找 ----costTime: "+(endTime2 - startTime2) +" 毫秒");

    }
}

class NetMall
{
    @Getter  // lombox中的注解 自动生成get方法
    private String mallName;

    public NetMall(String mallName)
    {
        this.mallName = mallName;
    }

    /**
     * 根据商品名称计算商品价格
     * @param productName 商品名称
     * @return
     */
    public double calcPrice(String productName) {
        // 检索需要1秒钟
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        // nextDouble() 表示当前线程产生一个随机数 大于等于0 小于等于1  productName 这个是一个字符串 productName.charAt(0)返回值是一个 m表示返回的商品价格
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }
}