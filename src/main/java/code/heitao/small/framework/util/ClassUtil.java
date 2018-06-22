package code.heitao.small.framework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author Aimin
 * @Title: ClassUtil
 * @ProjectName lightFrame架构
 * @Description: 类加载器
 * @date 2018/6/21 10:50
 */
@Slf4j
public class ClassUtil {

    public static ClassLoader getClassLoader() {
        /**
         * @Description: 获取类加载器
         * @param []
         * @return java.lang.ClassLoader
         * @author Aimin
         * @date 2018/6/21 16:36
         */
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className, Boolean isInitialized) {
        /**
         * @Description: 根据类名加载类
         * @param [className, isInitialized]
         * @return java.lang.Class<?>
         * @author Aimin
         * @date 2018/6/21 16:48
         */
        Class<?> aClass;
        try {
            aClass = Class.forName(className, isInitialized, getClassLoader());
        } catch (ClassNotFoundException e) {
            log.error("load class failure", e);
            throw new RuntimeException(e);
        }
        return aClass;
    }

    public static Class<?> loadClass(String className) {
        /**
         * @Description: 通过类名加载类，是否初始化类的标识初始化默认值为true，表示默认加载类中的静态代码块
         * @param [className]
         * @return java.lang.Class<?>
         * @author Aimin
         * @date 2018/6/21 16:51
         */
        return loadClass(className, true);

    }

    public static Set<Class<?>> getAllClassByPackageName(String packageName) {
        /**
         * @Description: 获取指定包名下的所有类
         * @param [packageName]
         * @return java.util.Set<java.lang.Class<?>>
         * @author Aimin
         * @date 2018/6/21 16:59
         */
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        Enumeration<URL> urls;
        try {
            urls = getClassLoader().getResources(packageName.replace(".", "/"));
            //读取转换包后的路径下的类名
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (null != url) {
                    String protocol = url.getProtocol();
                    if ("file".equals(protocol)) {
                        //转换序列化后的%20为空格
                        String packagePath = url.getPath().replaceAll("%20", " ");
                        //读取路径下的文件class类名存到Set中
                        addClass(classSet, packagePath, packageName);
                    } else if ("jar".equals(protocol)) {
                        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                        if (null != jarURLConnection) {
                            JarFile jarFile = jarURLConnection.getJarFile();
                            if (null != jarFile) {
                                Enumeration<JarEntry> jarEntryEnumeration = jarFile.entries();
                                while (jarEntryEnumeration.hasMoreElements()) {
                                    JarEntry jarEntry = jarEntryEnumeration.nextElement();
                                    String jarEntryName = jarEntry.getName();
                                    if (jarEntryName.endsWith(".class")) {
                                        String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replaceAll("/", ".");
                                        doAddClass(classSet, className);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            log.error("get class set failure", e);
            throw new RuntimeException(e);
        }
        return classSet;
    }


    private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {
        /**
         * @Description: 读取路径下的文件class类名存到Set中
         * @param [classSet, subPackagePath, subPackageName]
         * @return void
         * @author Aimin
         * @date 2018/6/21 18:20
         */
        File[] files = new File(packagePath).listFiles(new FileFilter() {
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });
        for (File file : files) {
            String fileName = file.getName();
            if (file.isFile()) {
                String className = fileName.substring(0, fileName.lastIndexOf("."));
                if (StringUtil.isNotEmpty(packageName)) {
                    className = packageName + "." + className;
                }
                doAddClass(classSet, className);
            } else {
                String subPackagePath = fileName;
                if (StringUtil.isNotEmpty(packagePath)) {
                    subPackagePath = packagePath + "/" + subPackagePath;
                }
                String subPackageName = fileName;
                if (StringUtil.isNotEmpty(packageName)) {
                    subPackageName = packageName + "." + subPackageName;
                }
                //递归
                addClass(classSet, subPackagePath, subPackageName);
            }
        }

    }

    private static void doAddClass(Set<Class<?>> classSet, String className) {
        /**
         * @Description: 根据类名生成Class类塞到集合Set中
         * @param [classSet, className]
         * @return void
         * @author Aimin
         * @date 2018/6/21 18:25
         */
        Class<?> aClass = loadClass(className, false);
        classSet.add(aClass);
    }
}
