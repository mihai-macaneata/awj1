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
public class PilotController {
  private List<Pilot> piloti = new ArrayList<Pilot>();

  PilotController() {
    Pilot p1 = new Pilot(1, "Johnpilot", 20);
    Pilot p2 = new Pilot(2, "Paulpilot", 50);
    Pilot p3 = new Pilot(3, "Paulpilot", 69);

    piloti.add(p1);
    piloti.add(p2);
    piloti.add(p3);
  }
    
    
    
    
    //create
    @RequestMapping(value="/pilot", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Pilot p) {
  piloti.add(p);
      return new ResponseEntity<Pilot>(p, new HttpHeaders(), HttpStatus.OK);
  }
    
    
    //Update
    @RequestMapping(value="/pilot", method = RequestMethod.PUT)
  public List<Pilot> update(@RequestBody Pilot p){
    for(Pilot pers : this.piloti){
      if(pers.getId() == p.getId())    {
    piloti.set(piloti.indexOf(pers), p);
      }
    }
    return this.piloti;
  }
                
    
    
    //Show all
  @RequestMapping(value="/pilot", method = RequestMethod.GET)
  public List<Pilot> index() {
    return this.piloti;  //returneaza lista pilotilor
  }

    
    
    //show id
  @RequestMapping(value="/pilot/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Pilot p : this.piloti) {
      if(p.getId() == id) {
        return new ResponseEntity<Pilot>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
    
    
    
    
    //delete

  @RequestMapping(value="/pilot/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Pilot p : this.piloti) {
      if(p.getId() == id) {
        this.piloti.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
    
    
    
    //test
    
    
    
    //test 
    
}