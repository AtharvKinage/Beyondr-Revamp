package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import java.util.Objects;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Allergies type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Allergies")
public final class Allergies implements Model {
  public static final QueryField ID = field("Allergies", "id");
  public static final QueryField USERID = field("Allergies", "userid");
  public static final QueryField ALLERGYNAME = field("Allergies", "allergyname");
  public static final QueryField DESCRIPTION = field("Allergies", "description");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String userid;
  private final @ModelField(targetType="String", isRequired = true) String allergyname;
  private final @ModelField(targetType="String", isRequired = true) String description;
  public String getId() {
      return id;
  }
  
  public String getUserid() {
      return userid;
  }
  
  public String getAllergyname() {
      return allergyname;
  }
  
  public String getDescription() {
      return description;
  }
  
  private Allergies(String id, String userid, String allergyname, String description) {
    this.id = id;
    this.userid = userid;
    this.allergyname = allergyname;
    this.description = description;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Allergies allergies = (Allergies) obj;
      return ObjectsCompat.equals(getId(), allergies.getId()) &&
              ObjectsCompat.equals(getUserid(), allergies.getUserid()) &&
              ObjectsCompat.equals(getAllergyname(), allergies.getAllergyname()) &&
              ObjectsCompat.equals(getDescription(), allergies.getDescription());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUserid())
      .append(getAllergyname())
      .append(getDescription())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Allergies {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("userid=" + String.valueOf(getUserid()) + ", ")
      .append("allergyname=" + String.valueOf(getAllergyname()) + ", ")
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
  public static Allergies justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Allergies(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      userid,
      allergyname,
      description);
  }
  public interface UseridStep {
    AllergynameStep userid(String userid);
  }
  

  public interface AllergynameStep {
    DescriptionStep allergyname(String allergyname);
  }
  

  public interface DescriptionStep {
    BuildStep description(String description);
  }
  

  public interface BuildStep {
    Allergies build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements UseridStep, AllergynameStep, DescriptionStep, BuildStep {
    private String id;
    private String userid;
    private String allergyname;
    private String description;
    @Override
     public Allergies build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Allergies(
          id,
          userid,
          allergyname,
          description);
    }
    
    @Override
     public AllergynameStep userid(String userid) {
        Objects.requireNonNull(userid);
        this.userid = userid;
        return this;
    }
    
    @Override
     public DescriptionStep allergyname(String allergyname) {
        Objects.requireNonNull(allergyname);
        this.allergyname = allergyname;
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
    private CopyOfBuilder(String id, String userid, String allergyname, String description) {
      super.id(id);
      super.userid(userid)
        .allergyname(allergyname)
        .description(description);
    }
    
    @Override
     public CopyOfBuilder userid(String userid) {
      return (CopyOfBuilder) super.userid(userid);
    }
    
    @Override
     public CopyOfBuilder allergyname(String allergyname) {
      return (CopyOfBuilder) super.allergyname(allergyname);
    }
    
    @Override
     public CopyOfBuilder description(String description) {
      return (CopyOfBuilder) super.description(description);
    }
  }
  
}
