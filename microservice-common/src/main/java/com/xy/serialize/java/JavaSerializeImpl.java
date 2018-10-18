package com.xy.serialize.java;

import java.io.*;

/**
 * @Auther: zanhonglei
 * @Date: 2018/10/18 11:06
 * @Description: java内置的序列化方式实现对象的序列化和反序列化
 */
public class JavaSerializeImpl {


    /**
     * 序列化
     * @param object
     * @return
     * @throws IOException
     */
    public static byte[] serialize(Object object) throws IOException {
        //定义一个字节数组输出流
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        //对象输出流
        ObjectOutputStream out = new ObjectOutputStream(os);

        //将对象写入到字节数组输出，进行序列化
        out.writeObject(object);

        return os.toByteArray();
    }

    /**
     * 反序列化
     * @param bytes
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        //字节数组输入流
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);

        //执行反序列化，从流中读取对象
        ObjectInputStream in = new ObjectInputStream(is);

        return in.readObject();

    }

    /**
     * 必须实现 Serializable
     * 要不报错 : java.io.NotSerializableException: com.xy.serialize.java.JavaSerializeImpl$Person
     */
    public static class Person implements Serializable{
        private String name;
        private String age;
        public Person(String name,String age){
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return this.name + "," +this.age;
        }
    }


    /**
     * 测试
     * 通过java.io包下的ObjectOutputStream的writeObject方法，将Person类的实例zhangsan序列化为字节数组，
     * 然后再通过ObjectInputStream的readObject方法，讲字节数组反序列化为Person对象。
     * @param args
     */
    public static void main(String[] args) {
        ///////////////////////序列化 开始///////////////////////////////
        Person person = new Person("zhangsan", "26");
        byte[] bytes = null;
        try {
            bytes = serialize(person);
            System.out.println(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ///////////////////////序列化 结束///////////////////////////////


        ///////////////////////反序列化 开始///////////////////////////////
        try {
            Person newPerson = (Person) deserialize(bytes);
            System.out.println(newPerson.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ///////////////////////反序列化 结束///////////////////////////////
    }



}
