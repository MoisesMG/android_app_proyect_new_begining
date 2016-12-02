package app.rojoyazul.com.android_app_project_new_begening;

/**
 * Created by Moises on 30/11/2016.
 */

public class Level {
    public String code;
    public String title;

    public Level(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Level{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}//fin de la clase
