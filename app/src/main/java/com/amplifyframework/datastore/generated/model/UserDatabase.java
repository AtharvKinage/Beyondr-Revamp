package com.amplifyframework.datastore.generated.model;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.Objects;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the UserDatabase type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "UserDatabases")
@Index(name = "byUserDatabase", fields = {"UserID"})
public final class UserDatabase implements Model {
  public static final QueryField ID = field("UserDatabase", "id");
  public static final QueryField USER_ID = field("UserDatabase", "UserID");
  public static final QueryField NAME = field("UserDatabase", "name");
  public static final QueryField LASTNAME = field("UserDatabase", "lastname");
  public static final QueryField SEX = field("UserDatabase", "sex");
  public static final QueryField BIRTHDAY = field("UserDatabase", "birthday");
  public static final QueryField HIEGHT = field("UserDatabase", "hieght");
  public static final QueryField WEIGHT = field("UserDatabase", "weight");
  public static final QueryField EMAILADDRESS = field("UserDatabase", "emailaddress");
  public static final QueryField PHONENUMBER = field("UserDatabase", "phonenumber");
  public static final QueryField EMERGENCYCONTACT = field("UserDatabase", "emergencycontact");
  public static final QueryField STREETADDRESS = field("UserDatabase", "streetaddress");
  public static final QueryField CITY = field("UserDatabase", "city");
  public static final QueryField ZIPCODE = field("UserDatabase", "zipcode");
  public static final QueryField SMOKE = field("UserDatabase", "smoke");
  public static final QueryField ALCHOL = field("UserDatabase", "alchol");
  public static final QueryField DATE = field("UserDatabase", "date");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String UserID;
  private final @ModelField(targetType="String") String name;
  private final @ModelField(targetType="String") String lastname;
  private final @ModelField(targetType="String") String sex;
  private final @ModelField(targetType="String") String birthday;
  private final @ModelField(targetType="String") String hieght;
  private final @ModelField(targetType="String") String weight;
  private final @ModelField(targetType="String") String emailaddress;
  private final @ModelField(targetType="String") String phonenumber;
  private final @ModelField(targetType="String") String emergencycontact;
  private final @ModelField(targetType="String") String streetaddress;
  private final @ModelField(targetType="String") String city;
  private final @ModelField(targetType="String") String zipcode;
  private final @ModelField(targetType="String") String smoke;
  private final @ModelField(targetType="String") String alchol;
  private final @ModelField(targetType="AWSDateTime") Temporal.DateTime date;
  public String getId() {
      return id;
  }
  
  public String getUserId() {
      return UserID;
  }
  
  public String getName() {
      return name;
  }
  
  public String getLastname() {
      return lastname;
  }
  
  public String getSex() {
      return sex;
  }
  
  public String getBirthday() {
      return birthday;
  }
  
  public String getHieght() {
      return hieght;
  }
  
  public String getWeight() {
      return weight;
  }
  
  public String getEmailaddress() {
      return emailaddress;
  }
  
  public String getPhonenumber() {
      return phonenumber;
  }
  
  public String getEmergencycontact() {
      return emergencycontact;
  }
  
  public String getStreetaddress() {
      return streetaddress;
  }
  
  public String getCity() {
      return city;
  }
  
  public String getZipcode() {
      return zipcode;
  }
  
  public String getSmoke() {
      return smoke;
  }
  
  public String getAlchol() {
      return alchol;
  }
  
  public Temporal.DateTime getDate() {
      return date;
  }
  
  private UserDatabase(String id, String UserID, String name, String lastname, String sex, String birthday, String hieght, String weight, String emailaddress, String phonenumber, String emergencycontact, String streetaddress, String city, String zipcode, String smoke, String alchol, Temporal.DateTime date) {
    this.id = id;
    this.UserID = UserID;
    this.name = name;
    this.lastname = lastname;
    this.sex = sex;
    this.birthday = birthday;
    this.hieght = hieght;
    this.weight = weight;
    this.emailaddress = emailaddress;
    this.phonenumber = phonenumber;
    this.emergencycontact = emergencycontact;
    this.streetaddress = streetaddress;
    this.city = city;
    this.zipcode = zipcode;
    this.smoke = smoke;
    this.alchol = alchol;
    this.date = date;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      UserDatabase userDatabase = (UserDatabase) obj;
      return ObjectsCompat.equals(getId(), userDatabase.getId()) &&
              ObjectsCompat.equals(getUserId(), userDatabase.getUserId()) &&
              ObjectsCompat.equals(getName(), userDatabase.getName()) &&
              ObjectsCompat.equals(getLastname(), userDatabase.getLastname()) &&
              ObjectsCompat.equals(getSex(), userDatabase.getSex()) &&
              ObjectsCompat.equals(getBirthday(), userDatabase.getBirthday()) &&
              ObjectsCompat.equals(getHieght(), userDatabase.getHieght()) &&
              ObjectsCompat.equals(getWeight(), userDatabase.getWeight()) &&
              ObjectsCompat.equals(getEmailaddress(), userDatabase.getEmailaddress()) &&
              ObjectsCompat.equals(getPhonenumber(), userDatabase.getPhonenumber()) &&
              ObjectsCompat.equals(getEmergencycontact(), userDatabase.getEmergencycontact()) &&
              ObjectsCompat.equals(getStreetaddress(), userDatabase.getStreetaddress()) &&
              ObjectsCompat.equals(getCity(), userDatabase.getCity()) &&
              ObjectsCompat.equals(getZipcode(), userDatabase.getZipcode()) &&
              ObjectsCompat.equals(getSmoke(), userDatabase.getSmoke()) &&
              ObjectsCompat.equals(getAlchol(), userDatabase.getAlchol()) &&
              ObjectsCompat.equals(getDate(), userDatabase.getDate());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUserId())
      .append(getName())
      .append(getLastname())
      .append(getSex())
      .append(getBirthday())
      .append(getHieght())
      .append(getWeight())
      .append(getEmailaddress())
      .append(getPhonenumber())
      .append(getEmergencycontact())
      .append(getStreetaddress())
      .append(getCity())
      .append(getZipcode())
      .append(getSmoke())
      .append(getAlchol())
      .append(getDate())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("UserDatabase {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("UserID=" + String.valueOf(getUserId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("lastname=" + String.valueOf(getLastname()) + ", ")
      .append("sex=" + String.valueOf(getSex()) + ", ")
      .append("birthday=" + String.valueOf(getBirthday()) + ", ")
      .append("hieght=" + String.valueOf(getHieght()) + ", ")
      .append("weight=" + String.valueOf(getWeight()) + ", ")
      .append("emailaddress=" + String.valueOf(getEmailaddress()) + ", ")
      .append("phonenumber=" + String.valueOf(getPhonenumber()) + ", ")
      .append("emergencycontact=" + String.valueOf(getEmergencycontact()) + ", ")
      .append("streetaddress=" + String.valueOf(getStreetaddress()) + ", ")
      .append("city=" + String.valueOf(getCity()) + ", ")
      .append("zipcode=" + String.valueOf(getZipcode()) + ", ")
      .append("smoke=" + String.valueOf(getSmoke()) + ", ")
      .append("alchol=" + String.valueOf(getAlchol()) + ", ")
      .append("date=" + String.valueOf(getDate()))
      .append("}")
      .toString();
  }
  
  public static UserIdStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static UserDatabase justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new UserDatabase(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      UserID,
      name,
      lastname,
      sex,
      birthday,
      hieght,
      weight,
      emailaddress,
      phonenumber,
      emergencycontact,
      streetaddress,
      city,
      zipcode,
      smoke,
      alchol,
      date);
  }
  public interface UserIdStep {
    BuildStep userId(String userId);
  }
  

  public interface BuildStep {
    UserDatabase build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep name(String name);
    BuildStep lastname(String lastname);
    BuildStep sex(String sex);
    BuildStep birthday(String birthday);
    BuildStep hieght(String hieght);
    BuildStep weight(String weight);
    BuildStep emailaddress(String emailaddress);
    BuildStep phonenumber(String phonenumber);
    BuildStep emergencycontact(String emergencycontact);
    BuildStep streetaddress(String streetaddress);
    BuildStep city(String city);
    BuildStep zipcode(String zipcode);
    BuildStep smoke(String smoke);
    BuildStep alchol(String alchol);
    BuildStep date(Temporal.DateTime date);
  }
  

  public static class Builder implements UserIdStep, BuildStep {
    private String id;
    private String UserID;
    private String name;
    private String lastname;
    private String sex;
    private String birthday;
    private String hieght;
    private String weight;
    private String emailaddress;
    private String phonenumber;
    private String emergencycontact;
    private String streetaddress;
    private String city;
    private String zipcode;
    private String smoke;
    private String alchol;
    private Temporal.DateTime date;
    @Override
     public UserDatabase build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new UserDatabase(
          id,
          UserID,
          name,
          lastname,
          sex,
          birthday,
          hieght,
          weight,
          emailaddress,
          phonenumber,
          emergencycontact,
          streetaddress,
          city,
          zipcode,
          smoke,
          alchol,
          date);
    }
    
    @Override
     public BuildStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.UserID = userId;
        return this;
    }
    
    @Override
     public BuildStep name(String name) {
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep lastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
    
    @Override
     public BuildStep sex(String sex) {
        this.sex = sex;
        return this;
    }
    
    @Override
     public BuildStep birthday(String birthday) {
        this.birthday = birthday;
        return this;
    }
    
    @Override
     public BuildStep hieght(String hieght) {
        this.hieght = hieght;
        return this;
    }
    
    @Override
     public BuildStep weight(String weight) {
        this.weight = weight;
        return this;
    }
    
    @Override
     public BuildStep emailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
        return this;
    }
    
    @Override
     public BuildStep phonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }
    
    @Override
     public BuildStep emergencycontact(String emergencycontact) {
        this.emergencycontact = emergencycontact;
        return this;
    }
    
    @Override
     public BuildStep streetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
        return this;
    }
    
    @Override
     public BuildStep city(String city) {
        this.city = city;
        return this;
    }
    
    @Override
     public BuildStep zipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }
    
    @Override
     public BuildStep smoke(String smoke) {
        this.smoke = smoke;
        return this;
    }
    
    @Override
     public BuildStep alchol(String alchol) {
        this.alchol = alchol;
        return this;
    }
    
    @Override
     public BuildStep date(Temporal.DateTime date) {
        this.date = date;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String userId, String name, String lastname, String sex, String birthday, String hieght, String weight, String emailaddress, String phonenumber, String emergencycontact, String streetaddress, String city, String zipcode, String smoke, String alchol, Temporal.DateTime date) {
      super.id(id);
      super.userId(userId)
        .name(name)
        .lastname(lastname)
        .sex(sex)
        .birthday(birthday)
        .hieght(hieght)
        .weight(weight)
        .emailaddress(emailaddress)
        .phonenumber(phonenumber)
        .emergencycontact(emergencycontact)
        .streetaddress(streetaddress)
        .city(city)
        .zipcode(zipcode)
        .smoke(smoke)
        .alchol(alchol)
        .date(date);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder lastname(String lastname) {
      return (CopyOfBuilder) super.lastname(lastname);
    }
    
    @Override
     public CopyOfBuilder sex(String sex) {
      return (CopyOfBuilder) super.sex(sex);
    }
    
    @Override
     public CopyOfBuilder birthday(String birthday) {
      return (CopyOfBuilder) super.birthday(birthday);
    }
    
    @Override
     public CopyOfBuilder hieght(String hieght) {
      return (CopyOfBuilder) super.hieght(hieght);
    }
    
    @Override
     public CopyOfBuilder weight(String weight) {
      return (CopyOfBuilder) super.weight(weight);
    }
    
    @Override
     public CopyOfBuilder emailaddress(String emailaddress) {
      return (CopyOfBuilder) super.emailaddress(emailaddress);
    }
    
    @Override
     public CopyOfBuilder phonenumber(String phonenumber) {
      return (CopyOfBuilder) super.phonenumber(phonenumber);
    }
    
    @Override
     public CopyOfBuilder emergencycontact(String emergencycontact) {
      return (CopyOfBuilder) super.emergencycontact(emergencycontact);
    }
    
    @Override
     public CopyOfBuilder streetaddress(String streetaddress) {
      return (CopyOfBuilder) super.streetaddress(streetaddress);
    }
    
    @Override
     public CopyOfBuilder city(String city) {
      return (CopyOfBuilder) super.city(city);
    }
    
    @Override
     public CopyOfBuilder zipcode(String zipcode) {
      return (CopyOfBuilder) super.zipcode(zipcode);
    }
    
    @Override
     public CopyOfBuilder smoke(String smoke) {
      return (CopyOfBuilder) super.smoke(smoke);
    }
    
    @Override
     public CopyOfBuilder alchol(String alchol) {
      return (CopyOfBuilder) super.alchol(alchol);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
  }
  
}
