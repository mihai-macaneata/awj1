package hello;

import java.util.List;
import java.util.ArrayList;

public class Circuit {
  private String name;
  private int id;

  public Circuit() {}

  public Circuit(int id, String name) {
      this.name = name;
      this.id = id;
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
