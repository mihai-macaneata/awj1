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
public class SpectatorController {
  private List<Spectator> spectatori = new ArrayList<Spectator>();

  SpectatorController() {
    Spectator p1 = new Spectator(1, "Ion");
    Spectator p2 = new Spectator(2, "Paula");
    Spectator p3 = new Spectator(3, "Paul");

    spectatori.add(p1);
    spectatori.add(p2);
    spectatori.add(p3);
  }
    
    
    
    
    //create
    @RequestMapping(value="/spectator/{id>},{nume}", method = RequestMethod.POST)
  public ResponseEntity create(@PathVariable("id") int id,@PathVariable("nume") String nume) {
   this.spectatori.add (new Spectator (id, "Nume"));
      Spectator p = new Spectator(id,nume);
      this.spectatori.add(p);
      return new ResponseEntity<Spectator>(p, new HttpHeaders(), HttpStatus.OK);
  }
    
    
    //Update
    @RequestMapping(value="/spectator/{id>},{nume}", method = RequestMethod. PUT)
    public ResponseEntity update(@PathVariable("id") int id,@PathVariable("nume") String nume) {
        for(Spectator p: this.spectatori) {
            if(p.getId() == id) {
                p.setName(nume);
                 return new ResponseEntity<Spectator>(p, new HttpHeaders(), HttpStatus.OK);
            }
        }return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    
    
    
    
    
    //Show all
  @RequestMapping(value="/spectator", method = RequestMethod.GET)
  public List<Spectator> index() {
    return this.spectatori;  //returneaza lista spectatorilor
  }

    
    
    //show id
  @RequestMapping(value="/spectator/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Spectator p : this.spectatori) {
      if(p.getId() == id) {
        return new ResponseEntity<Spectator>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
    
    
    
    
    //delete

  @RequestMapping(value="/spectator/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Spectator p : this.spectatori) {
      if(p.getId() == id) {
        this.spectatori.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}