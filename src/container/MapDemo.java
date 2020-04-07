package container;

import java.util.HashMap;
import java.util.Map;

public class MapDemo{

    //   map（一个个键值对） map常用方法练习
    public static void main(String[] args){
        //泛型参数有两个，第一个是key类型，第二个是value类型。目的是可以根据key找到相对应的value
        Map<String,String> map=new HashMap<>();//注意其声明格式
        System.out.println(map.size());//获取map键值对个数
        System.out.println(map.isEmpty());//判断map是否为空
        System.out.println(map.get("作者"));//根据key找到value
        map.put("作者","王维");//指定k-v放入map里面
        //根据指定的k找到对应的v，若没有找到则用默认值替代
        System.out.println(map.getOrDefault("人名","今何在"));//输出今何在
        System.out.println(map.getOrDefault("作者","今何在"));//输出王维
        System.out.println(map.containsKey("作者"));//查找是否存在key
        System.out.println(map.containsValue("今何在"));//查找是否包含value
        map.put("标题","山居秋暝");
        map.put("朝代","唐");
        map.put("标题","相思");//key值重复则覆盖原值
        map.put("类型","七言绝句");
        System.out.println(map.size());//3
        System.out.println(map.isEmpty());//false
        for (Map.Entry<String,String> entry:map.entrySet() ) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println(map);//可直接输出map，无需遍历
        //map中的元素顺序与插入顺序无关，取决于具体的实现方式
    }

}
