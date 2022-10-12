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

/** This is an auto generated class representing the WellnessPost type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "WellnessPosts")
public final class WellnessPost implements Model {
  public static final QueryField ID = field("WellnessPost", "id");
  public static final QueryField TITLE = field("WellnessPost", "title");
  public static final QueryField IMAGE = field("WellnessPost", "image");
  public static final QueryField DATE = field("WellnessPost", "date");
  public static final QueryField DESCRIPTION = field("WellnessPost", "description");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String title;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean image;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  private final @ModelField(targetType="String", isRequired = true) String description;
  public String getId() {
      return id;
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
  
  private WellnessPost(String id, String title, Boolean image, Temporal.DateTime date, String description) {
    this.id = id;
    this.title = title;
    this.image = image;
    this.date = date;
    this.description = description;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      WellnessPost wellnessPost = (WellnessPost) obj;
      return ObjectsCompat.equals(getId(), wellnessPost.getId()) &&
              ObjectsCompat.equals(getTitle(), wellnessPost.getTitle()) &&
              ObjectsCompat.equals(getImage(), wellnessPost.getImage()) &&
              ObjectsCompat.equals(getDate(), wellnessPost.getDate()) &&
              ObjectsCompat.equals(getDescription(), wellnessPost.getDescription());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getTitle())
      .append(getImage())
      .append(getDate())
      .append(getDescription())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("WellnessPost {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("title=" + String.valueOf(getTitle()) + ", ")
      .append("image=" + String.valueOf(getImage()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("description=" + String.valueOf(getDescription()))
      .append("}")
      .toString();
  }
  
  public static TitleStep builder() {
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
  public static WellnessPost justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new WellnessPost(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      title,
      image,
      date,
      description);
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
    BuildStep description(String description);
  }
  

  public interface BuildStep {
    WellnessPost build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements TitleStep, ImageStep, DateStep, DescriptionStep, BuildStep {
    private String id;
    private String title;
    private Boolean image;
    private Temporal.DateTime date;
    private String description;
    @Override
     public WellnessPost build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new WellnessPost(
          id,
          title,
          image,
          date,
          description);
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
    private CopyOfBuilder(String id, String title, Boolean image, Temporal.DateTime date, String description) {
      super.id(id);
      super.title(title)
        .image(image)
        .date(date)
        .description(description);
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
  }
  
}
