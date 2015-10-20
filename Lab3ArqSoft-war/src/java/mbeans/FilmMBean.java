/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import com.udea.entities.Film;
import com.udea.entities.Language;
import com.udea.session.FilmManager;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author cposa
 */
public class FilmMBean{
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
        refresh();
        
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
        refresh();
        return "FilmList";
    }
    
}
