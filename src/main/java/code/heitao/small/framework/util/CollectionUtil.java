package code.heitao.small.framework.util;


import java.util.Collection;
import java.util.Map;

/**
 * @author Aimin
 * @Title: CollectionUtil
 * @ProjectName lightFrame架构
 * @Description: 集合工具类
 * @date 2018/6/14 20:27
 */
public class CollectionUtil {

    public static boolean isEmpty(Collection<?> collection) {
        /**
         * @Description: 判断 Collection 是否为空
         * @param [collection]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 20:29
         */
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        /**
         * @Description: 判断 Collection 是否非空
         * @param [collection]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 20:29
         */
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        /**
         * @Description: 判断 Map 是否为空
         * @param [map]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 20:30
         */
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        /**
         * @Description: 判断 Map 是否非空
         * @param [map]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 20:30
         */
        return !isEmpty(map);
    }
}
