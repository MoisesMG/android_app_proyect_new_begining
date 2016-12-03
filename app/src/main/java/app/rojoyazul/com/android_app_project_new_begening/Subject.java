package app.rojoyazul.com.android_app_project_new_begening;

/**
 * Created by Moises on 03/12/2016.
 */

public class Subject {
    private String code;
    private String level_code;
    private String Title;

    //contructores
    public Subject(String code, String level_code, String title) {
        this.code = code;
        this.level_code = level_code;
        Title = title;
    }

    public Subject() {
    }

    //getter and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevel_code() {
        return level_code;
    }

    public void setLevel_code(String level_code) {
        this.level_code = level_code;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    //to string

    @Override
    public String toString() {
        return "Subjects{" +
                "code='" + code + '\'' +
                ", level_code='" + level_code + '\'' +
                ", Title='" + Title + '\'' +
                '}';
    }//fin del metodo
}//fin de la clase
