package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import java.util.Objects;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Communities type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Communities")
public final class Communities implements Model {
  public static final QueryField ID = field("Communities", "id");
  public static final QueryField COMMUNITYNAME = field("Communities", "communityname");
  public static final QueryField COMMUNITYOWNER = field("Communities", "communityowner");
  public static final QueryField DESCRIPTION = field("Communities", "description");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String communityname;
  private final @ModelField(targetType="ID", isRequired = true) String communityowner;
  private final @ModelField(targetType="String", isRequired = true) String description;
  public String getId() {
      return id;
  }
  
  public String getCommunityname() {
      return communityname;
  }
  
  public String getCommunityowner() {
      return communityowner;
  }
  
  public String getDescription() {
      return description;
  }
  
  private Communities(String id, String communityname, String communityowner, String description) {
    this.id = id;
    this.communityname = communityname;
    this.communityowner = communityowner;
    this.description = description;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Communities communities = (Communities) obj;
      return ObjectsCompat.equals(getId(), communities.getId()) &&
              ObjectsCompat.equals(getCommunityname(), communities.getCommunityname()) &&
              ObjectsCompat.equals(getCommunityowner(), communities.getCommunityowner()) &&
              ObjectsCompat.equals(getDescription(), communities.getDescription());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getCommunityname())
      .append(getCommunityowner())
      .append(getDescription())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Communities {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("communityname=" + String.valueOf(getCommunityname()) + ", ")
      .append("communityowner=" + String.valueOf(getCommunityowner()) + ", ")
      .append("description=" + String.valueOf(getDescription()))
      .append("}")
      .toString();
  }
  
  public static CommunitynameStep builder() {
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
  public static Communities justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Communities(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      communityname,
      communityowner,
      description);
  }
  public interface CommunitynameStep {
    CommunityownerStep communityname(String communityname);
  }
  

  public interface CommunityownerStep {
    DescriptionStep communityowner(String communityowner);
  }
  

  public interface DescriptionStep {
    BuildStep description(String description);
  }
  

  public interface BuildStep {
    Communities build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements CommunitynameStep, CommunityownerStep, DescriptionStep, BuildStep {
    private String id;
    private String communityname;
    private String communityowner;
    private String description;
    @Override
     public Communities build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Communities(
          id,
          communityname,
          communityowner,
          description);
    }
    
    @Override
     public CommunityownerStep communityname(String communityname) {
        Objects.requireNonNull(communityname);
        this.communityname = communityname;
        return this;
    }
    
    @Override
     public DescriptionStep communityowner(String communityowner) {
        Objects.requireNonNull(communityowner);
        this.communityowner = communityowner;
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
    private CopyOfBuilder(String id, String communityname, String communityowner, String description) {
      super.id(id);
      super.communityname(communityname)
        .communityowner(communityowner)
        .description(description);
    }
    
    @Override
     public CopyOfBuilder communityname(String communityname) {
      return (CopyOfBuilder) super.communityname(communityname);
    }
    
    @Override
     public CopyOfBuilder communityowner(String communityowner) {
      return (CopyOfBuilder) super.communityowner(communityowner);
    }
    
    @Override
     public CopyOfBuilder description(String description) {
      return (CopyOfBuilder) super.description(description);
    }
  }
  
}
