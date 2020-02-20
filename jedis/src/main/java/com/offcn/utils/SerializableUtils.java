package com.offcn.utils;

import java.io.*;

public class SerializableUtils {

    public static byte[] serializable(Object object) {

        try {
            //        字节数组输出流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //        对象输出流
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }

    public static Object unSerializable(byte[] bytes){
        if (bytes==null){
            return null;
        }
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
