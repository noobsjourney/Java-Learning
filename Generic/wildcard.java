package Generic;

import java.util.ArrayList;
import java.util.List;

/**
 *  about: 泛型编程中的通配符（wildcard)
 *  <? extends T>
 *  <? super T>
 *  motivation: java中泛型不能直接支持继承关系(需要保证类型安全/类型擦除)
 */

public class wildcard {
  public static void feedAnimal(List<? extends Animal> list1){
    for (Animal animal : list1) {
      animal.eat(); 
    }
  }

  public static void addCats(List<? super Cat> list1){
    list1.add(new Cat());
  }

  public static void addDogs(List<? super Dog> list1){
    list1.add(new Dog());
  }

  public static void main(String[] args)
  {
    // 1. 协变 适用于读取对象 并不关心集合中具体是那种动物
    List<Cat> cats = new ArrayList<>();
    cats.add(new Cat());
    feedAnimal(cats);
    // 2. 逆变 适用于添加/写入对象
    List<Animal> animals = new ArrayList<>();
    addCats(animals);
    addDogs(animals);
    feedAnimal(animals);
  }
}


class Animal{
  public void eat(){
    System.out.println("animal is eating...");
  }
}

class Dog extends Animal{
  @Override
  public void eat(){
    System.out.println("dog is eating..."); 
  }
}

class Cat extends Animal{
  @Override
  public void eat(){
    System.out.println("cat is eating...");
  
  }
}
