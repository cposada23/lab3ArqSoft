/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import com.udea.entities.Film;
import com.udea.entities.Language;
import com.udea.session.FilmManager;
import com.udea.session.LaguageManager;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author cposa
 */
public class FilmMBean{
    @EJB
    private LaguageManager laguageManager;
    @EJB
    private FilmManager filmManager;
    
    

    private Film film;
    private List<Film> films;
    
    /**
     * Creates a new instance of FilmMBean
     */
    public FilmMBean() {
    }
    public List<Film> getFilms(){
        refresh();
        return films;
    }
    
    public void refresh(){
        films = filmManager.getAllFilms();
    }
    
    public Film getDetails(){
        refresh();
        return film;
    }
    
    public String showDetails(Film film){
        refresh();
        this.film= film;
        return "FilmDetails";
    }
    
    public String update(){
        System.out.println("entro  ");
        refresh();
        Language la = laguageManager.getLanguageByName(film.getLanguageId().getName());
        
        
        System.out.println("Language buscado por nombre " + la.getName());
        System.out.println("Id Language buscado por nombre" + la.getLanguageId());
        
        
        film.setLanguageId(la);
        //debug---------------
        System.out.println("update");
        Language l = film.getLanguageId(); 
        System.out.println("nombreLanguageAntesUpdate "+l.getName());
        System.out.println("id Language antes "+l.getLanguageId());
        //debug --------------
        
        film = filmManager.update(film);
        
        //debug--------------
        l = film.getLanguageId();
        System.out.println("nombreLanguagedespuesUpdate "+l.getName());
        System.out.println("id Language despues "+l.getLanguageId());
        
      
        
        //debug---------------
        return "FilmList";
    }
    
    public String delete(){
        refresh();
        System.out.println("delete");
        filmManager.delete(film);
        return "FilmList";
    }
    
    public String list(){
        
        //filmManager.modRelease();
        refresh();
        return "FilmList";
    }
    
    public String add(){
        
        refresh();
        Language la = laguageManager.getLanguageByName(film.getLanguageId().getName());
        
        film.setLanguageId(la);
        
        filmManager.persist(film);
        return "FilmList";
    }
    
    
    
}
