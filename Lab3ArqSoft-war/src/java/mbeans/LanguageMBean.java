/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import com.udea.entities.Language;
import com.udea.session.LaguageManager;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author camilo.posadaa
 */
public class LanguageMBean {
    @EJB
    private LaguageManager languageManager;
    
    private Language language;
    private List<Language> languages;

    /**
     * Creates a new instance of LaguageMBean
     */
    public LanguageMBean() {
    }
    
    public List<Language> getLanguages(){
        refresh();
        return languages;
    }
    public void refresh(){
    
        languages = languageManager.gelAllLanguages();
    }
    
    
    public Language getDetails(){
        refresh();
        return language;
    }
    
    public Language getLanguage(short languageId){
        refresh();
        return languageManager.getLanguage(languageId);
    }
    
    public String showDetails(Language language){
        refresh();
        this.language=language;
        return "LanguageDetails";
    }
    
    public String update(){
        refresh();
       language = languageManager.update(language);
       return "LanguageList";
    }
    
    public String list(){
        refresh();
        return "LanguageList";
    }
    
}
