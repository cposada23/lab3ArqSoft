/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import com.udea.entities.Film;
import com.udea.session.FilmManager;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author cposa
 */
public class FilmMBean {
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
        if(films==null|| films.isEmpty())refresh();
        return films;
    }
    
    public void refresh(){
        films = filmManager.getAllFilms();
    }
    
    public Film getDetails(){
        return film;
    }
    
    public String showDetails(Film film){
        this.film= film;
        return "FilmDetails";
    }
    
    public String update(){
        System.out.println("update");
        film = filmManager.update(film);
        return "FilmList";
    }
    
    public String list(){
        return "FilmList";
    }
    
}
