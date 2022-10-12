package com.amplifyframework.datastore.generated.model;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Post type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Posts")
@Index(name = "byPost", fields = {"UserID"})
public final class Post implements Model {
  public static final QueryField ID = field("Post", "id");
  public static final QueryField USER_ID = field("Post", "UserID");
  public static final QueryField POSTIDREFERENCE = field("Post", "postidreference");
  public static final QueryField POST_TYPE = field("Post", "PostType");
  public static final QueryField TITLE = field("Post", "title");
  public static final QueryField IMAGE = field("Post", "image");
  public static final QueryField DATE = field("Post", "date");
  public static final QueryField DESCRIPTION = field("Post", "description");
  public static final QueryField NUMBEROFLIKES = field("Post", "numberoflikes");
  public static final QueryField IMAGETYPE = field("Post", "imagetype");
  public static final QueryField DOCTOR_TYPE = field("Post", "DoctorType");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String UserID;
  private final @ModelField(targetType="ID", isRequired = true) String postidreference;
  private final @ModelField(targetType="PostType", isRequired = true)
  com.amplifyframework.datastore.generated.model.PostType PostType;
  private final @ModelField(targetType="String", isRequired = true) String title;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean image;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  private final @ModelField(targetType="String", isRequired = true) String description;
  private final @ModelField(targetType="String", isRequired = true) String numberoflikes;
  private final @ModelField(targetType="VideoType")
  VideoType imagetype;
  private final @ModelField(targetType="DoctorType")
  com.amplifyframework.datastore.generated.model.DoctorType DoctorType;
  private final @ModelField(targetType="Likes") @HasMany(associatedWith = "PostID", type = Likes.class) List<Likes> likedbyusers = null;
  private final @ModelField(targetType="Comments") @HasMany(associatedWith = "PostID", type = Comments.class) List<Comments> comments = null;
  public String getId() {
      return id;
  }
  
  public String getUserId() {
      return UserID;
  }
  
  public String getPostidreference() {
      return postidreference;
  }
  
  public com.amplifyframework.datastore.generated.model.PostType getPostType() {
      return PostType;
  }
  
  public String getTitle() {
      return title;
  }
  
  public Boolean getImage() {
      return image;
  }
  
  public Temporal.DateTime getDate() {
      return date;
  }
  
  public String getDescription() {
      return description;
  }
  
  public String getNumberoflikes() {
      return numberoflikes;
  }
  
  public VideoType getImagetype() {
      return imagetype;
  }
  
  public com.amplifyframework.datastore.generated.model.DoctorType getDoctorType() {
      return DoctorType;
  }
  
  public List<Likes> getLikedbyusers() {
      return likedbyusers;
  }
  
  public List<Comments> getComments() {
      return comments;
  }
  
  private Post(String id, String UserID, String postidreference, com.amplifyframework.datastore.generated.model.PostType PostType, String title, Boolean image, Temporal.DateTime date, String description, String numberoflikes, VideoType imagetype, com.amplifyframework.datastore.generated.model.DoctorType DoctorType) {
    this.id = id;
    this.UserID = UserID;
    this.postidreference = postidreference;
    this.PostType = PostType;
    this.title = title;
    this.image = image;
    this.date = date;
    this.description = description;
    this.numberoflikes = numberoflikes;
    this.imagetype = imagetype;
    this.DoctorType = DoctorType;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Post post = (Post) obj;
      return ObjectsCompat.equals(getId(), post.getId()) &&
              ObjectsCompat.equals(getUserId(), post.getUserId()) &&
              ObjectsCompat.equals(getPostidreference(), post.getPostidreference()) &&
              ObjectsCompat.equals(getPostType(), post.getPostType()) &&
              ObjectsCompat.equals(getTitle(), post.getTitle()) &&
              ObjectsCompat.equals(getImage(), post.getImage()) &&
              ObjectsCompat.equals(getDate(), post.getDate()) &&
              ObjectsCompat.equals(getDescription(), post.getDescription()) &&
              ObjectsCompat.equals(getNumberoflikes(), post.getNumberoflikes()) &&
              ObjectsCompat.equals(getImagetype(), post.getImagetype()) &&
              ObjectsCompat.equals(getDoctorType(), post.getDoctorType());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUserId())
      .append(getPostidreference())
      .append(getPostType())
      .append(getTitle())
      .append(getImage())
      .append(getDate())
      .append(getDescription())
      .append(getNumberoflikes())
      .append(getImagetype())
      .append(getDoctorType())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Post {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("UserID=" + String.valueOf(getUserId()) + ", ")
      .append("postidreference=" + String.valueOf(getPostidreference()) + ", ")
      .append("PostType=" + String.valueOf(getPostType()) + ", ")
      .append("title=" + String.valueOf(getTitle()) + ", ")
      .append("image=" + String.valueOf(getImage()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("description=" + String.valueOf(getDescription()) + ", ")
      .append("numberoflikes=" + String.valueOf(getNumberoflikes()) + ", ")
      .append("imagetype=" + String.valueOf(getImagetype()) + ", ")
      .append("DoctorType=" + String.valueOf(getDoctorType()))
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
  public static Post justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Post(
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
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      UserID,
      postidreference,
      PostType,
      title,
      image,
      date,
      description,
      numberoflikes,
      imagetype,
      DoctorType);
  }
  public interface UserIdStep {
    PostidreferenceStep userId(String userId);
  }
  

  public interface PostidreferenceStep {
    PostTypeStep postidreference(String postidreference);
  }
  

  public interface PostTypeStep {
    TitleStep postType(com.amplifyframework.datastore.generated.model.PostType postType);
  }
  

  public interface TitleStep {
    ImageStep title(String title);
  }
  

  public interface ImageStep {
    DateStep image(Boolean image);
  }
  

  public interface DateStep {
    DescriptionStep date(Temporal.DateTime date);
  }
  

  public interface DescriptionStep {
    NumberoflikesStep description(String description);
  }
  

  public interface NumberoflikesStep {
    BuildStep numberoflikes(String numberoflikes);
  }
  

  public interface BuildStep {
    Post build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep imagetype(VideoType imagetype);
    BuildStep doctorType(com.amplifyframework.datastore.generated.model.DoctorType doctorType);
  }
  

  public static class Builder implements UserIdStep, PostidreferenceStep, PostTypeStep, TitleStep, ImageStep, DateStep, DescriptionStep, NumberoflikesStep, BuildStep {
    private String id;
    private String UserID;
    private String postidreference;
    private com.amplifyframework.datastore.generated.model.PostType PostType;
    private String title;
    private Boolean image;
    private Temporal.DateTime date;
    private String description;
    private String numberoflikes;
    private VideoType imagetype;
    private com.amplifyframework.datastore.generated.model.DoctorType DoctorType;
    @Override
     public Post build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Post(
          id,
          UserID,
          postidreference,
          PostType,
          title,
          image,
          date,
          description,
          numberoflikes,
          imagetype,
          DoctorType);
    }
    
    @Override
     public PostidreferenceStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.UserID = userId;
        return this;
    }
    
    @Override
     public PostTypeStep postidreference(String postidreference) {
        Objects.requireNonNull(postidreference);
        this.postidreference = postidreference;
        return this;
    }
    
    @Override
     public TitleStep postType(com.amplifyframework.datastore.generated.model.PostType postType) {
        Objects.requireNonNull(postType);
        this.PostType = postType;
        return this;
    }
    
    @Override
     public ImageStep title(String title) {
        Objects.requireNonNull(title);
        this.title = title;
        return this;
    }
    
    @Override
     public DateStep image(Boolean image) {
        Objects.requireNonNull(image);
        this.image = image;
        return this;
    }
    
    @Override
     public DescriptionStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }
    
    @Override
     public NumberoflikesStep description(String description) {
        Objects.requireNonNull(description);
        this.description = description;
        return this;
    }
    
    @Override
     public BuildStep numberoflikes(String numberoflikes) {
        Objects.requireNonNull(numberoflikes);
        this.numberoflikes = numberoflikes;
        return this;
    }
    
    @Override
     public BuildStep imagetype(VideoType imagetype) {
        this.imagetype = imagetype;
        return this;
    }
    
    @Override
     public BuildStep doctorType(com.amplifyframework.datastore.generated.model.DoctorType doctorType) {
        this.DoctorType = doctorType;
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
    private CopyOfBuilder(String id, String userId, String postidreference, com.amplifyframework.datastore.generated.model.PostType postType, String title, Boolean image, Temporal.DateTime date, String description, String numberoflikes, VideoType imagetype, com.amplifyframework.datastore.generated.model.DoctorType doctorType) {
      super.id(id);
      super.userId(userId)
        .postidreference(postidreference)
        .postType(postType)
        .title(title)
        .image(image)
        .date(date)
        .description(description)
        .numberoflikes(numberoflikes)
        .imagetype(imagetype)
        .doctorType(doctorType);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder postidreference(String postidreference) {
      return (CopyOfBuilder) super.postidreference(postidreference);
    }
    
    @Override
     public CopyOfBuilder postType(com.amplifyframework.datastore.generated.model.PostType postType) {
      return (CopyOfBuilder) super.postType(postType);
    }
    
    @Override
     public CopyOfBuilder title(String title) {
      return (CopyOfBuilder) super.title(title);
    }
    
    @Override
     public CopyOfBuilder image(Boolean image) {
      return (CopyOfBuilder) super.image(image);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder description(String description) {
      return (CopyOfBuilder) super.description(description);
    }
    
    @Override
     public CopyOfBuilder numberoflikes(String numberoflikes) {
      return (CopyOfBuilder) super.numberoflikes(numberoflikes);
    }
    
    @Override
     public CopyOfBuilder imagetype(VideoType imagetype) {
      return (CopyOfBuilder) super.imagetype(imagetype);
    }
    
    @Override
     public CopyOfBuilder doctorType(com.amplifyframework.datastore.generated.model.DoctorType doctorType) {
      return (CopyOfBuilder) super.doctorType(doctorType);
    }
  }
  
}
