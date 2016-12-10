package app.rojoyazul.com.android_app_project_new_begening;

/**
 * Created by Moises on 09/12/2016.
 */

public class Suggestion {
    private String name;
    private String email;
    private String suggest;

    public Suggestion() {
    }//fin del metodo

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    //to String
    @Override
    public String toString() {
        return "Suggestion{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", suggest='" + suggest + '\'' +
                '}';
    }
}//fin de la clase
