package hello;

import java.util.List;
import java.util.ArrayList;

public class Pilot {
  private int id;
    private String name;
    private int age;
 

  public Pilot() {}

  public Pilot(int id, String name, int age) {
      this.id = id;
      this.name = name;
      this.age= age;
  }

  public String getName() {
      return this.name;
  }
    

  public int getId() {
    return this.id;
  }
    
    public int getAge(){
    
    return this.age;
    }
    
    
    
    public void setName(String nume){
        this.name=nume;
    }
    
     public void setAge(int age){
        this.age=age;
    }
}
