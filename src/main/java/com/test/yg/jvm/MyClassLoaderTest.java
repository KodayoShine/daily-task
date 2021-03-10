package com.test.yg.jvm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoaderTest {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class MyClassLoader extends ClassLoader {
        private String classPath;


        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            byte[] data = new byte[0];
            try {
                data = loadByte(name);
            } catch (IOException e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
            return defineClass(name, data, 0, data.length);
        }

        private byte[] loadByte(String name) throws IOException {
            String replaceName = name.replaceAll("\\.", "/");
            try (FileInputStream fileInputStream = new FileInputStream(classPath + "/" + replaceName + ".class")) {
                int len = fileInputStream.available();
                byte[] bytes = new byte[len];
                fileInputStream.read(bytes);
                return bytes;
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader classLoader = new MyClassLoader("D:/test");
        Class<?> clazz = classLoader.loadClass("com.test.yg.User");
        Object obj = clazz.newInstance();
        System.out.println(clazz.getClassLoader().getClass().getName());
    }

}
