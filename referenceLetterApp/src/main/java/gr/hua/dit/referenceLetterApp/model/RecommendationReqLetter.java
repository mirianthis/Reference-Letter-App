package gr.hua.dit.referenceLetterApp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="referral_Req")
public class RecommendationReqLetter {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="age")
    private int age;
    @Column(name="createdBy")
    private String createdBy;
    @Column(name="field")
    private String field;
    @Column(name="sendTo")
    private String sendTo;
    @Column(name="status")
    private String status;

    public RecommendationReqLetter(){

    }
    public RecommendationReqLetter(String firstName, String lastName, int age, String createdBy, String field, String sendTo,String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.createdBy = createdBy;
        this.field = field;
        this.sendTo = sendTo;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }


}
