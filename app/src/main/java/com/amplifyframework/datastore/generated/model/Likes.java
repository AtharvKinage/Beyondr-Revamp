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

/** This is an auto generated class representing the Likes type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Likes")
@Index(name = "byLikes", fields = {"PostID"})
public final class Likes implements Model {
  public static final QueryField ID = field("Likes", "id");
  public static final QueryField POST_ID = field("Likes", "PostID");
  public static final QueryField DATE = field("Likes", "date");
  public static final QueryField USER_ID = field("Likes", "UserId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String PostID;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  private final @ModelField(targetType="ID", isRequired = true) String UserId;
  public String getId() {
      return id;
  }
  
  public String getPostId() {
      return PostID;
  }
  
  public Temporal.DateTime getDate() {
      return date;
  }
  
  public String getUserId() {
      return UserId;
  }
  
  private Likes(String id, String PostID, Temporal.DateTime date, String UserId) {
    this.id = id;
    this.PostID = PostID;
    this.date = date;
    this.UserId = UserId;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Likes likes = (Likes) obj;
      return ObjectsCompat.equals(getId(), likes.getId()) &&
              ObjectsCompat.equals(getPostId(), likes.getPostId()) &&
              ObjectsCompat.equals(getDate(), likes.getDate()) &&
              ObjectsCompat.equals(getUserId(), likes.getUserId());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getPostId())
      .append(getDate())
      .append(getUserId())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Likes {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("PostID=" + String.valueOf(getPostId()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("UserId=" + String.valueOf(getUserId()))
      .append("}")
      .toString();
  }
  
  public static PostIdStep builder() {
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
  public static Likes justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Likes(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      PostID,
      date,
      UserId);
  }
  public interface PostIdStep {
    DateStep postId(String postId);
  }
  

  public interface DateStep {
    UserIdStep date(Temporal.DateTime date);
  }
  

  public interface UserIdStep {
    BuildStep userId(String userId);
  }
  

  public interface BuildStep {
    Likes build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements PostIdStep, DateStep, UserIdStep, BuildStep {
    private String id;
    private String PostID;
    private Temporal.DateTime date;
    private String UserId;
    @Override
     public Likes build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Likes(
          id,
          PostID,
          date,
          UserId);
    }
    
    @Override
     public DateStep postId(String postId) {
        Objects.requireNonNull(postId);
        this.PostID = postId;
        return this;
    }
    
    @Override
     public UserIdStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }
    
    @Override
     public BuildStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.UserId = userId;
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
    private CopyOfBuilder(String id, String postId, Temporal.DateTime date, String userId) {
      super.id(id);
      super.postId(postId)
        .date(date)
        .userId(userId);
    }
    
    @Override
     public CopyOfBuilder postId(String postId) {
      return (CopyOfBuilder) super.postId(postId);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
  }
  
}
