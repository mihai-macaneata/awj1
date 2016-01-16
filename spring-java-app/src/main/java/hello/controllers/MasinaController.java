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
public class MasinaController {
  private List<Masina> masini = new ArrayList<Masina>();

  MasinaController() {
    Masina p1 = new Masina(1, "Ferrari");
    Masina p2 = new Masina(2, "BMW");
    Masina p3 = new Masina(3, "Mercedes");

    masini.add(p1);
    masini.add(p2);
    masini.add(p3);
  }
    
    
    
    
    //create
    @RequestMapping(value="/masina", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Masina p) {
  masini.add(p);
      return new ResponseEntity<Masina>(p, new HttpHeaders(), HttpStatus.OK);
  }
    //
    
    
    
    
    
    
    
    ///
    
    //Update
     @RequestMapping(value="/masina", method = RequestMethod.PUT)
  public List<Masina> update(@RequestBody Masina p){
    for(Masina pers : this.masini){
      if(pers.getId() == p.getId())    {
    masini.set(masini.indexOf(pers), p);
      }
    }
    return this.masini;
  }
                
    
    
    
    
    
    //Show all
  @RequestMapping(value="/masina", method = RequestMethod.GET)
  public List<Masina> index() {
    return this.masini;  //returneaza lista masinilor
  }

    
    
    //show id
  @RequestMapping(value="/masina/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Masina p : this.masini) {
      if(p.getId() == id) {
        return new ResponseEntity<Masina>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
    
    
    
    
    //delete

  @RequestMapping(value="/masina/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Masina p : this.masini) {
      if(p.getId() == id) {
        this.masini.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}