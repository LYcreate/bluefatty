package link.lycreate.bluefatty.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ListTrans
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/28 3:28
 */
public class ListTrans {
    public static Map<String,Object> listToMap(List<Map<String,Object>> list,String firstStr,String secondStr){
        Iterator iterator=list.iterator();
        Map<String,Object> map=new HashMap<>();
        while (iterator.hasNext()){
            Map<String,String> rawMap=(Map<String, String>) iterator.next();
            map.put(String.valueOf(rawMap.get(firstStr)),rawMap.get(secondStr));
        }
        return map;
    }
}
