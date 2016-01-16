package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
public class CircuitController {
  private List<Circuit> circuite = new ArrayList<Circuit>();

  CircuitController() {
    Circuit p1 = new Circuit (1, "Las Palmas");
    Circuit p2 = new Circuit(2, "Monaco");
    Circuit p3 = new Circuit(3, "Transfagarasan");

    circuite.add(p1);
    circuite.add(p2);
    circuite.add(p3);
  }
    
    
    
    
    //create
    @RequestMapping(value="/circuit", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Circuit p) {
   circuite.add(p);
      return new ResponseEntity<Circuit>(p, new HttpHeaders(), HttpStatus.OK);
  }
    
    
    //Update
    @RequestMapping(value="/circuit", method = RequestMethod.PUT)
  public List<Circuit> update(@RequestBody Circuit p){
    for(Circuit pers : this.circuite){
      if(pers.getId() == p.getId())    {
    circuite.set(circuite.indexOf(pers), p);
      }
    }
    return this.circuite;
  }
                
    
    
    
    
    //Show all
  @RequestMapping(value="/circuit", method = RequestMethod.GET)
  public List<Circuit> index() {
    return this.circuite;  //returneaza lista circuitelor
  }

    
    
    //show id
  @RequestMapping(value="/circuit/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Circuit p : this.circuite) {
      if(p.getId() == id) {
        return new ResponseEntity<Circuit>(p, new HttpHeaders(), HttpStatus.OK);
      }
    } return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
   
  }
    
    
    
    
    //delete

  @RequestMapping(value="/circuit/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Circuit p : this.circuite) {
      if(p.getId() == id) {
        this.circuite.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}