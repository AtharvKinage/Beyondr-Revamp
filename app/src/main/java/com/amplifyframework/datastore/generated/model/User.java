package com.amplifyframework.datastore.generated.model;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the User type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Users")
public final class User implements Model {
  public static final QueryField ID = field("User", "id");
  public static final QueryField NAME = field("User", "name");
  public static final QueryField USERID = field("User", "userid");
  public static final QueryField EMAIL = field("User", "email");
  public static final QueryField AWSDATE = field("User", "awsdate");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="ID", isRequired = true) String userid;
  private final @ModelField(targetType="String", isRequired = true) String email;
  private final @ModelField(targetType="Message") @HasMany(associatedWith = "UserID", type = Message.class) List<Message> message = null;
  private final @ModelField(targetType="String", isRequired = true) String awsdate;
  private final @ModelField(targetType="Appointment") @HasMany(associatedWith = "userID", type = Appointment.class) List<Appointment> appointment = null;
  private final @ModelField(targetType="UserDatabase") @HasMany(associatedWith = "UserID", type = UserDatabase.class) List<UserDatabase> userdatabase = null;
  private final @ModelField(targetType="Doctor") @HasMany(associatedWith = "UserID", type = Doctor.class) List<Doctor> doctor = null;
  private final @ModelField(targetType="Post") @HasMany(associatedWith = "UserID", type = Post.class) List<Post> post = null;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public String getUserid() {
      return userid;
  }
  
  public String getEmail() {
      return email;
  }
  
  public List<Message> getMessage() {
      return message;
  }
  
  public String getAwsdate() {
      return awsdate;
  }
  
  public List<Appointment> getAppointment() {
      return appointment;
  }
  
  public List<UserDatabase> getUserdatabase() {
      return userdatabase;
  }
  
  public List<Doctor> getDoctor() {
      return doctor;
  }
  
  public List<Post> getPost() {
      return post;
  }
  
  private User(String id, String name, String userid, String email, String awsdate) {
    this.id = id;
    this.name = name;
    this.userid = userid;
    this.email = email;
    this.awsdate = awsdate;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      User user = (User) obj;
      return ObjectsCompat.equals(getId(), user.getId()) &&
              ObjectsCompat.equals(getName(), user.getName()) &&
              ObjectsCompat.equals(getUserid(), user.getUserid()) &&
              ObjectsCompat.equals(getEmail(), user.getEmail()) &&
              ObjectsCompat.equals(getAwsdate(), user.getAwsdate());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getUserid())
      .append(getEmail())
      .append(getAwsdate())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("User {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("userid=" + String.valueOf(getUserid()) + ", ")
      .append("email=" + String.valueOf(getEmail()) + ", ")
      .append("awsdate=" + String.valueOf(getAwsdate()))
      .append("}")
      .toString();
  }
  
  public static NameStep builder() {
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
  public static User justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new User(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      userid,
      email,
      awsdate);
  }
  public interface NameStep {
    UseridStep name(String name);
  }
  

  public interface UseridStep {
    EmailStep userid(String userid);
  }
  

  public interface EmailStep {
    AwsdateStep email(String email);
  }
  

  public interface AwsdateStep {
    BuildStep awsdate(String awsdate);
  }
  

  public interface BuildStep {
    User build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements NameStep, UseridStep, EmailStep, AwsdateStep, BuildStep {
    private String id;
    private String name;
    private String userid;
    private String email;
    private String awsdate;
    @Override
     public User build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new User(
          id,
          name,
          userid,
          email,
          awsdate);
    }
    
    @Override
     public UseridStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public EmailStep userid(String userid) {
        Objects.requireNonNull(userid);
        this.userid = userid;
        return this;
    }
    
    @Override
     public AwsdateStep email(String email) {
        Objects.requireNonNull(email);
        this.email = email;
        return this;
    }
    
    @Override
     public BuildStep awsdate(String awsdate) {
        Objects.requireNonNull(awsdate);
        this.awsdate = awsdate;
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
    private CopyOfBuilder(String id, String name, String userid, String email, String awsdate) {
      super.id(id);
      super.name(name)
        .userid(userid)
        .email(email)
        .awsdate(awsdate);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder userid(String userid) {
      return (CopyOfBuilder) super.userid(userid);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder awsdate(String awsdate) {
      return (CopyOfBuilder) super.awsdate(awsdate);
    }
  }
  
}
