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

/** This is an auto generated class representing the Message type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Messages")
@Index(name = "byMessagesUsers", fields = {"UserID"})
@Index(name = "byMessagesdoctors", fields = {"DoctorsID"})
public final class Message implements Model {
  public static final QueryField ID = field("Message", "id");
  public static final QueryField DOCTORS_ID = field("Message", "DoctorsID");
  public static final QueryField USER_ID = field("Message", "UserID");
  public static final QueryField MESSAGETYPE = field("Message", "messagetype");
  public static final QueryField CONTENT = field("Message", "content");
  public static final QueryField CURRENTMESSAGE = field("Message", "currentmessage");
  public static final QueryField READBYDOCTOR = field("Message", "readbydoctor");
  public static final QueryField IMAGEBOOLEAN = field("Message", "imageboolean");
  public static final QueryField READBYUSER = field("Message", "readbyuser");
  public static final QueryField DATE = field("Message", "date");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String DoctorsID;
  private final @ModelField(targetType="ID", isRequired = true) String UserID;
  private final @ModelField(targetType="MessageType", isRequired = true)
  MessageType messagetype;
  private final @ModelField(targetType="String") String content;
  private final @ModelField(targetType="ID", isRequired = true) String currentmessage;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean readbydoctor;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean imageboolean;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean readbyuser;
  private final @ModelField(targetType="AWSDateTime") Temporal.DateTime date;
  public String getId() {
      return id;
  }

  public String getDoctorsId() {
      return DoctorsID;
  }

  public String getUserId() {
      return UserID;
  }

  public MessageType getMessagetype() {
      return messagetype;
  }

  public String getContent() {
      return content;
  }

  public String getCurrentmessage() {
      return currentmessage;
  }

  public Boolean getReadbydoctor() {
      return readbydoctor;
  }

  public Boolean getImageboolean() {
      return imageboolean;
  }

  public Boolean getReadbyuser() {
      return readbyuser;
  }

  public Temporal.DateTime getDate() {
      return date;
  }

  private Message(String id, String DoctorsID, String UserID, MessageType messagetype, String content, String currentmessage, Boolean readbydoctor, Boolean imageboolean, Boolean readbyuser, Temporal.DateTime date) {
    this.id = id;
    this.DoctorsID = DoctorsID;
    this.UserID = UserID;
    this.messagetype = messagetype;
    this.content = content;
    this.currentmessage = currentmessage;
    this.readbydoctor = readbydoctor;
    this.imageboolean = imageboolean;
    this.readbyuser = readbyuser;
    this.date = date;
  }

  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Message message = (Message) obj;
      return ObjectsCompat.equals(getId(), message.getId()) &&
              ObjectsCompat.equals(getDoctorsId(), message.getDoctorsId()) &&
              ObjectsCompat.equals(getUserId(), message.getUserId()) &&
              ObjectsCompat.equals(getMessagetype(), message.getMessagetype()) &&
              ObjectsCompat.equals(getContent(), message.getContent()) &&
              ObjectsCompat.equals(getCurrentmessage(), message.getCurrentmessage()) &&
              ObjectsCompat.equals(getReadbydoctor(), message.getReadbydoctor()) &&
              ObjectsCompat.equals(getImageboolean(), message.getImageboolean()) &&
              ObjectsCompat.equals(getReadbyuser(), message.getReadbyuser()) &&
              ObjectsCompat.equals(getDate(), message.getDate());
      }
  }

  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDoctorsId())
      .append(getUserId())
      .append(getMessagetype())
      .append(getContent())
      .append(getCurrentmessage())
      .append(getReadbydoctor())
      .append(getImageboolean())
      .append(getReadbyuser())
      .append(getDate())
      .toString()
      .hashCode();
  }

  @Override
   public String toString() {
    return new StringBuilder()
      .append("Message {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("DoctorsID=" + String.valueOf(getDoctorsId()) + ", ")
      .append("UserID=" + String.valueOf(getUserId()) + ", ")
      .append("messagetype=" + String.valueOf(getMessagetype()) + ", ")
      .append("content=" + String.valueOf(getContent()) + ", ")
      .append("currentmessage=" + String.valueOf(getCurrentmessage()) + ", ")
      .append("readbydoctor=" + String.valueOf(getReadbydoctor()) + ", ")
      .append("imageboolean=" + String.valueOf(getImageboolean()) + ", ")
      .append("readbyuser=" + String.valueOf(getReadbyuser()) + ", ")
      .append("date=" + String.valueOf(getDate()))
      .append("}")
      .toString();
  }

  public static DoctorsIdStep builder() {
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
  public static Message justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Message(
      id,
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
      DoctorsID,
      UserID,
      messagetype,
      content,
      currentmessage,
      readbydoctor,
      imageboolean,
      readbyuser,
      date);
  }
  public interface DoctorsIdStep {
    UserIdStep doctorsId(String doctorsId);
  }


  public interface UserIdStep {
    MessagetypeStep userId(String userId);
  }


  public interface MessagetypeStep {
    CurrentmessageStep messagetype(MessageType messagetype);
  }


  public interface CurrentmessageStep {
    ReadbydoctorStep currentmessage(String currentmessage);
  }


  public interface ReadbydoctorStep {
    ImagebooleanStep readbydoctor(Boolean readbydoctor);
  }


  public interface ImagebooleanStep {
    ReadbyuserStep imageboolean(Boolean imageboolean);
  }


  public interface ReadbyuserStep {
    BuildStep readbyuser(Boolean readbyuser);
  }


  public interface BuildStep {
    Message build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep content(String content);
    BuildStep date(Temporal.DateTime date);
  }


  public static class Builder implements DoctorsIdStep, UserIdStep, MessagetypeStep, CurrentmessageStep, ReadbydoctorStep, ImagebooleanStep, ReadbyuserStep, BuildStep {
    private String id;
    private String DoctorsID;
    private String UserID;
    private MessageType messagetype;
    private String currentmessage;
    private Boolean readbydoctor;
    private Boolean imageboolean;
    private Boolean readbyuser;
    private String content;
    private Temporal.DateTime date;
    @Override
     public Message build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();

        return new Message(
          id,
          DoctorsID,
          UserID,
          messagetype,
          content,
          currentmessage,
          readbydoctor,
          imageboolean,
          readbyuser,
          date);
    }

    @Override
     public UserIdStep doctorsId(String doctorsId) {
        Objects.requireNonNull(doctorsId);
        this.DoctorsID = doctorsId;
        return this;
    }

    @Override
     public MessagetypeStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.UserID = userId;
        return this;
    }

    @Override
     public CurrentmessageStep messagetype(MessageType messagetype) {
        Objects.requireNonNull(messagetype);
        this.messagetype = messagetype;
        return this;
    }

    @Override
     public ReadbydoctorStep currentmessage(String currentmessage) {
        Objects.requireNonNull(currentmessage);
        this.currentmessage = currentmessage;
        return this;
    }

    @Override
     public ImagebooleanStep readbydoctor(Boolean readbydoctor) {
        Objects.requireNonNull(readbydoctor);
        this.readbydoctor = readbydoctor;
        return this;
    }

    @Override
     public ReadbyuserStep imageboolean(Boolean imageboolean) {
        Objects.requireNonNull(imageboolean);
        this.imageboolean = imageboolean;
        return this;
    }

    @Override
     public BuildStep readbyuser(Boolean readbyuser) {
        Objects.requireNonNull(readbyuser);
        this.readbyuser = readbyuser;
        return this;
    }

    @Override
     public BuildStep content(String content) {
        this.content = content;
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
    private CopyOfBuilder(String id, String doctorsId, String userId, MessageType messagetype, String content, String currentmessage, Boolean readbydoctor, Boolean imageboolean, Boolean readbyuser, Temporal.DateTime date) {
      super.id(id);
      super.doctorsId(doctorsId)
        .userId(userId)
        .messagetype(messagetype)
        .currentmessage(currentmessage)
        .readbydoctor(readbydoctor)
        .imageboolean(imageboolean)
        .readbyuser(readbyuser)
        .content(content)
        .date(date);
    }
    
    @Override
     public CopyOfBuilder doctorsId(String doctorsId) {
      return (CopyOfBuilder) super.doctorsId(doctorsId);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder messagetype(MessageType messagetype) {
      return (CopyOfBuilder) super.messagetype(messagetype);
    }
    
    @Override
     public CopyOfBuilder currentmessage(String currentmessage) {
      return (CopyOfBuilder) super.currentmessage(currentmessage);
    }
    
    @Override
     public CopyOfBuilder readbydoctor(Boolean readbydoctor) {
      return (CopyOfBuilder) super.readbydoctor(readbydoctor);
    }
    
    @Override
     public CopyOfBuilder imageboolean(Boolean imageboolean) {
      return (CopyOfBuilder) super.imageboolean(imageboolean);
    }
    
    @Override
     public CopyOfBuilder readbyuser(Boolean readbyuser) {
      return (CopyOfBuilder) super.readbyuser(readbyuser);
    }
    
    @Override
     public CopyOfBuilder content(String content) {
      return (CopyOfBuilder) super.content(content);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
  }
  
}
