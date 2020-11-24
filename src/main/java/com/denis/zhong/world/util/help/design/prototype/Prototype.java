package com.denis.zhong.world.util.help.design.prototype;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

public class Prototype implements Cloneable {

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /***
     * 浅拷贝 拷贝对象中的引用，则原型和拷贝对用公用一个引用
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "desc='" + desc + '\'' +
                '}';
    }

    /***
     * 深拷贝
     * @return
     */
    public Prototype deepClone(){
        try(ByteArrayOutputStream bos =new ByteArrayOutputStream();
            ObjectOutputStream oos= new ObjectOutputStream(bos);
           ){
            oos.writeObject(this);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            return (Prototype)ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            return null;
        }
    }
}
