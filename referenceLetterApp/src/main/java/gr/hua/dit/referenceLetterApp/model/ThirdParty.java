package gr.hua.dit.referenceLetterApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="third_Party")
public class ThirdParty {
    @Id
    @Column(name="email")
    private String email;
    @Column(name="name")
    private String name;
    @Column(name="field")
    private String field;

    public ThirdParty(String email, String name, String field) {
        this.email = email;
        this.name = name;
        this.field = field;
    }
    public ThirdParty(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
