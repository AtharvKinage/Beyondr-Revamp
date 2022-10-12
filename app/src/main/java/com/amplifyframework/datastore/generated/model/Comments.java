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

/** This is an auto generated class representing the Comments type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Comments")
@Index(name = "byComments", fields = {"PostID"})
public final class Comments implements Model {
  public static final QueryField ID = field("Comments", "id");
  public static final QueryField POST_ID = field("Comments", "PostID");
  public static final QueryField USER_ID = field("Comments", "UserId");
  public static final QueryField DATE = field("Comments", "date");
  public static final QueryField COMMENT = field("Comments", "comment");
  public static final QueryField COMMENTFROM = field("Comments", "commentfrom");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String PostID;
  private final @ModelField(targetType="ID", isRequired = true) String UserId;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  private final @ModelField(targetType="String", isRequired = true) String comment;
  private final @ModelField(targetType="UserType", isRequired = true)
  UserType commentfrom;
  public String getId() {
      return id;
  }
  
  public String getPostId() {
      return PostID;
  }
  
  public String getUserId() {
      return UserId;
  }
  
  public Temporal.DateTime getDate() {
      return date;
  }
  
  public String getComment() {
      return comment;
  }
  
  public UserType getCommentfrom() {
      return commentfrom;
  }
  
  private Comments(String id, String PostID, String UserId, Temporal.DateTime date, String comment, UserType commentfrom) {
    this.id = id;
    this.PostID = PostID;
    this.UserId = UserId;
    this.date = date;
    this.comment = comment;
    this.commentfrom = commentfrom;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Comments comments = (Comments) obj;
      return ObjectsCompat.equals(getId(), comments.getId()) &&
              ObjectsCompat.equals(getPostId(), comments.getPostId()) &&
              ObjectsCompat.equals(getUserId(), comments.getUserId()) &&
              ObjectsCompat.equals(getDate(), comments.getDate()) &&
              ObjectsCompat.equals(getComment(), comments.getComment()) &&
              ObjectsCompat.equals(getCommentfrom(), comments.getCommentfrom());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getPostId())
      .append(getUserId())
      .append(getDate())
      .append(getComment())
      .append(getCommentfrom())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Comments {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("PostID=" + String.valueOf(getPostId()) + ", ")
      .append("UserId=" + String.valueOf(getUserId()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("comment=" + String.valueOf(getComment()) + ", ")
      .append("commentfrom=" + String.valueOf(getCommentfrom()))
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
  public static Comments justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Comments(
      id,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      PostID,
      UserId,
      date,
      comment,
      commentfrom);
  }
  public interface PostIdStep {
    UserIdStep postId(String postId);
  }
  

  public interface UserIdStep {
    DateStep userId(String userId);
  }
  

  public interface DateStep {
    CommentStep date(Temporal.DateTime date);
  }
  

  public interface CommentStep {
    CommentfromStep comment(String comment);
  }
  

  public interface CommentfromStep {
    BuildStep commentfrom(UserType commentfrom);
  }
  

  public interface BuildStep {
    Comments build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements PostIdStep, UserIdStep, DateStep, CommentStep, CommentfromStep, BuildStep {
    private String id;
    private String PostID;
    private String UserId;
    private Temporal.DateTime date;
    private String comment;
    private UserType commentfrom;
    @Override
     public Comments build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Comments(
          id,
          PostID,
          UserId,
          date,
          comment,
          commentfrom);
    }
    
    @Override
     public UserIdStep postId(String postId) {
        Objects.requireNonNull(postId);
        this.PostID = postId;
        return this;
    }
    
    @Override
     public DateStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.UserId = userId;
        return this;
    }
    
    @Override
     public CommentStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }
    
    @Override
     public CommentfromStep comment(String comment) {
        Objects.requireNonNull(comment);
        this.comment = comment;
        return this;
    }
    
    @Override
     public BuildStep commentfrom(UserType commentfrom) {
        Objects.requireNonNull(commentfrom);
        this.commentfrom = commentfrom;
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
    private CopyOfBuilder(String id, String postId, String userId, Temporal.DateTime date, String comment, UserType commentfrom) {
      super.id(id);
      super.postId(postId)
        .userId(userId)
        .date(date)
        .comment(comment)
        .commentfrom(commentfrom);
    }
    
    @Override
     public CopyOfBuilder postId(String postId) {
      return (CopyOfBuilder) super.postId(postId);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder comment(String comment) {
      return (CopyOfBuilder) super.comment(comment);
    }
    
    @Override
     public CopyOfBuilder commentfrom(UserType commentfrom) {
      return (CopyOfBuilder) super.commentfrom(commentfrom);
    }
  }
  
}
