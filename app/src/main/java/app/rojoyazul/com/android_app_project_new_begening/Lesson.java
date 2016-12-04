package app.rojoyazul.com.android_app_project_new_begening;

/**
 * Created by Moises on 04/12/2016.
 */

public class Lesson {
    private String code;
    private String title;
    private String subject_code;
    private String content;

    public Lesson() {
    }

    public Lesson(String code, String title, String subject_code, String content) {
        this.code = code;
        this.title = title;
        this.subject_code = subject_code;
        this.content = content;
    }

    //getter and setters

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

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //to string

    @Override
    public String toString() {
        return "Lesson{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", subject_code='" + subject_code + '\'' +
                ", content='" + content + '\'' +
                '}';
    }//fin del metodo
}//fin de la clase
