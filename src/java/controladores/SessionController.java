import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ismael
 */
@Named(value = "sessionController")
@SessionScoped//Para que permanezca el idioma seleccionado durante la sesión debe usar el SessionScoped.
public class SessionController implements Serializable {

    private Locale languageSelected;
    private Locale spanishLanguague = new Locale("es");
    private Locale defaultLanguage = new Locale("es");

    
    
    
    public Locale getDefaultLanguage() {
        return defaultLanguage;
    }

    /**
     * Creates a new instance of SessionController
     */
    public void setDefaultLanguage(Locale defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public SessionController() {
    }

    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        Locale idiomaUsuario = ec.getRequestLocale();
        boolean support = false;
        for (Locale l : getSupportLanguages()) {
            if (l.getLanguage().equals(idiomaUsuario.getLanguage())) {
                support = true;
                break;
            }
        }
        languageSelected = (support) ? idiomaUsuario : new Locale("es");

    }

    public Locale getLanguageSelected() {
        return languageSelected;
    }

    public Locale getSpanishLanguague() {
        return spanishLanguague;
    }

    public void setSpanishLanguague(Locale spanishLanguague) {
        this.spanishLanguague = spanishLanguague;
    }
   
 

    public void setLanguageSelected(Locale languageSelected) {
        this.languageSelected = languageSelected;
    }
     public Locale getLanguagueToChange() {
 Locale  languague = spanishLanguague;
        Locale currentLanguague = (getLanguageSelected());
       
        if (currentLanguague.equals(Locale.ENGLISH)) {
            languague = spanishLanguague;
        } else {
            languague = Locale.ENGLISH;
        }
        return languague/* = Locale.ENGLISH*/;
    }

    public List<Locale> getSupportLanguages() {
        List<Locale> idiomas = new ArrayList<>();
        Iterator<Locale> it = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
        while (it.hasNext()) {
            idiomas.add(it.next());
        }
        return idiomas;
    }

    public String cambiarIdioma(Locale idioma) {
        if (idioma != null) {
            this.languageSelected = idioma;
            FacesContext.getCurrentInstance().getViewRoot().setLocale(languageSelected);
            defaultLanguage = languageSelected;
        }
        return "";
    }

}
