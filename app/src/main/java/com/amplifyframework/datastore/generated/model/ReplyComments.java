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

/** This is an auto generated class representing the ReplyComments type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "ReplyComments")
public final class ReplyComments implements Model {
  public static final QueryField ID = field("ReplyComments", "id");
  public static final QueryField POST_ID = field("ReplyComments", "PostID");
  public static final QueryField USER_ID = field("ReplyComments", "UserId");
  public static final QueryField COMMENT = field("ReplyComments", "comment");
  public static final QueryField DATE = field("ReplyComments", "date");
  public static final QueryField COMMENTFROM = field("ReplyComments", "commentfrom");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String PostID;
  private final @ModelField(targetType="ID", isRequired = true) String UserId;
  private final @ModelField(targetType="String", isRequired = true) String comment;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
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

  public String getComment() {
      return comment;
  }

  public Temporal.DateTime getDate() {
      return date;
  }

  public UserType getCommentfrom() {
      return commentfrom;
  }

  private ReplyComments(String id, String PostID, String UserId, String comment, Temporal.DateTime date, UserType commentfrom) {
    this.id = id;
    this.PostID = PostID;
    this.UserId = UserId;
    this.comment = comment;
    this.date = date;
    this.commentfrom = commentfrom;
  }

  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      ReplyComments replyComments = (ReplyComments) obj;
      return ObjectsCompat.equals(getId(), replyComments.getId()) &&
              ObjectsCompat.equals(getPostId(), replyComments.getPostId()) &&
              ObjectsCompat.equals(getUserId(), replyComments.getUserId()) &&
              ObjectsCompat.equals(getComment(), replyComments.getComment()) &&
              ObjectsCompat.equals(getDate(), replyComments.getDate()) &&
              ObjectsCompat.equals(getCommentfrom(), replyComments.getCommentfrom());
      }
  }

  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getPostId())
      .append(getUserId())
      .append(getComment())
      .append(getDate())
      .append(getCommentfrom())
      .toString()
      .hashCode();
  }

  @Override
   public String toString() {
    return new StringBuilder()
      .append("ReplyComments {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("PostID=" + String.valueOf(getPostId()) + ", ")
      .append("UserId=" + String.valueOf(getUserId()) + ", ")
      .append("comment=" + String.valueOf(getComment()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
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
  public static ReplyComments justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new ReplyComments(
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
      comment,
      date,
      commentfrom);
  }
  public interface PostIdStep {
    UserIdStep postId(String postId);
  }


  public interface UserIdStep {
    CommentStep userId(String userId);
  }


  public interface CommentStep {
    DateStep comment(String comment);
  }


  public interface DateStep {
    CommentfromStep date(Temporal.DateTime date);
  }


  public interface CommentfromStep {
    BuildStep commentfrom(UserType commentfrom);
  }


  public interface BuildStep {
    ReplyComments build();
    BuildStep id(String id) throws IllegalArgumentException;
  }


  public static class Builder implements PostIdStep, UserIdStep, CommentStep, DateStep, CommentfromStep, BuildStep {
    private String id;
    private String PostID;
    private String UserId;
    private String comment;
    private Temporal.DateTime date;
    private UserType commentfrom;
    @Override
     public ReplyComments build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();

        return new ReplyComments(
          id,
          PostID,
          UserId,
          comment,
          date,
          commentfrom);
    }

    @Override
     public UserIdStep postId(String postId) {
        Objects.requireNonNull(postId);
        this.PostID = postId;
        return this;
    }

    @Override
     public CommentStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.UserId = userId;
        return this;
    }

    @Override
     public DateStep comment(String comment) {
        Objects.requireNonNull(comment);
        this.comment = comment;
        return this;
    }

    @Override
     public CommentfromStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
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
    private CopyOfBuilder(String id, String postId, String userId, String comment, Temporal.DateTime date, UserType commentfrom) {
      super.id(id);
      super.postId(postId)
        .userId(userId)
        .comment(comment)
        .date(date)
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
     public CopyOfBuilder comment(String comment) {
      return (CopyOfBuilder) super.comment(comment);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder commentfrom(UserType commentfrom) {
      return (CopyOfBuilder) super.commentfrom(commentfrom);
    }
  }
  
}
