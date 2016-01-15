package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @RequestMapping(value="/circuit/{id>},{nume}", method = RequestMethod.POST)
  public ResponseEntity create(@PathVariable("id") int id,@PathVariable("nume") String nume) {
   this.circuite.add (new Circuit (id, "Nume"));
      Circuit p = new Circuit(id,nume);
      this.circuite.add(p);
      return new ResponseEntity<Circuit>(p, new HttpHeaders(), HttpStatus.OK);
  }
    
    
    //Update
    @RequestMapping(value="/circuit/{id>},{nume}", method = RequestMethod. PUT)
    public ResponseEntity update(@PathVariable("id") int id,@PathVariable("nume") String nume) {
        for(Circuit p: this.circuite) {
            if(p.getId() == id) {
                p.setName(nume);
         return new ResponseEntity<Circuit>(p, new HttpHeaders(), HttpStatus.OK);        
            }
        } return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);

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