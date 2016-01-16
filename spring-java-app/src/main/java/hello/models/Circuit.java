package hello;

import java.util.List;
import java.util.ArrayList;

public class Circuit {
   private int id;
    private String name;
 

  public Circuit() {}

  public Circuit(int id, String name) {
      this.id = id;
      this.name = name;
      
  }

  public String getName() {
      return this.name;
  }
    

  public int getId() {
    return this.id;
  }
    
    public void setName(String name){
        this.name=name;
    }
     public void add(int id, String name){
        this.name=name;
        this.id=id;
    }
}
