package com.hebo.java.overload;

/**
 * Created by hebo on 2018/7/27.
 */
public class Animal {

    static {
        System.out.println("初始化父类静态块");
    }

    public Animal(){
        System.out.println("初始化父类构造");
    }
    public void eat(){
        System.out.println("动物可以吃");
    }


    public void move(){
        System.out.println("动物可以移动");
    }

  static class Dog extends Animal{
        public void move(){
            System.out.println("狗可以跑和走");
        }

      public void eat(){
          System.out.println("狗可以吃");
      }


      public static void main(String args[]){
            Animal a = new Animal(); // Animal 对象
            Animal b = new Dog(); // Dog 对象

            a.move();// 执行 Animal 类的方法

            b.move();//执行 Dog 类的方法
            b.eat();
        }
    }


}
