package com.amplifyframework.datastore.generated.model;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.Objects;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the ContactUs type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Contactuses")
public final class ContactUs implements Model {
  public static final QueryField ID = field("ContactUs", "id");
  public static final QueryField USERID = field("ContactUs", "userid");
  public static final QueryField DATE = field("ContactUs", "date");
  public static final QueryField TITLE = field("ContactUs", "title");
  public static final QueryField DESCRIPTION = field("ContactUs", "description");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String userid;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  private final @ModelField(targetType="String", isRequired = true) String title;
  private final @ModelField(targetType="String", isRequired = true) String description;
  public String getId() {
      return id;
  }
  
  public String getUserid() {
      return userid;
  }
  
  public Temporal.DateTime getDate() {
      return date;
  }
  
  public String getTitle() {
      return title;
  }
  
  public String getDescription() {
      return description;
  }
  
  private ContactUs(String id, String userid, Temporal.DateTime date, String title, String description) {
    this.id = id;
    this.userid = userid;
    this.date = date;
    this.title = title;
    this.description = description;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      ContactUs contactUs = (ContactUs) obj;
      return ObjectsCompat.equals(getId(), contactUs.getId()) &&
              ObjectsCompat.equals(getUserid(), contactUs.getUserid()) &&
              ObjectsCompat.equals(getDate(), contactUs.getDate()) &&
              ObjectsCompat.equals(getTitle(), contactUs.getTitle()) &&
              ObjectsCompat.equals(getDescription(), contactUs.getDescription());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUserid())
      .append(getDate())
      .append(getTitle())
      .append(getDescription())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("ContactUs {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("userid=" + String.valueOf(getUserid()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("title=" + String.valueOf(getTitle()) + ", ")
      .append("description=" + String.valueOf(getDescription()))
      .append("}")
      .toString();
  }
  
  public static UseridStep builder() {
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
  public static ContactUs justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new ContactUs(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      userid,
      date,
      title,
      description);
  }
  public interface UseridStep {
    DateStep userid(String userid);
  }
  

  public interface DateStep {
    TitleStep date(Temporal.DateTime date);
  }
  

  public interface TitleStep {
    DescriptionStep title(String title);
  }
  

  public interface DescriptionStep {
    BuildStep description(String description);
  }
  

  public interface BuildStep {
    ContactUs build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements UseridStep, DateStep, TitleStep, DescriptionStep, BuildStep {
    private String id;
    private String userid;
    private Temporal.DateTime date;
    private String title;
    private String description;
    @Override
     public ContactUs build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new ContactUs(
          id,
          userid,
          date,
          title,
          description);
    }
    
    @Override
     public DateStep userid(String userid) {
        Objects.requireNonNull(userid);
        this.userid = userid;
        return this;
    }
    
    @Override
     public TitleStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }
    
    @Override
     public DescriptionStep title(String title) {
        Objects.requireNonNull(title);
        this.title = title;
        return this;
    }
    
    @Override
     public BuildStep description(String description) {
        Objects.requireNonNull(description);
        this.description = description;
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
    private CopyOfBuilder(String id, String userid, Temporal.DateTime date, String title, String description) {
      super.id(id);
      super.userid(userid)
        .date(date)
        .title(title)
        .description(description);
    }
    
    @Override
     public CopyOfBuilder userid(String userid) {
      return (CopyOfBuilder) super.userid(userid);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder title(String title) {
      return (CopyOfBuilder) super.title(title);
    }
    
    @Override
     public CopyOfBuilder description(String description) {
      return (CopyOfBuilder) super.description(description);
    }
  }
  
}
