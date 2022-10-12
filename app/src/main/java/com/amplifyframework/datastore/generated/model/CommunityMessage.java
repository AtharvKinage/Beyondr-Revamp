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

/** This is an auto generated class representing the CommunityMessage type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "CommunityMessages")
public final class CommunityMessage implements Model {
  public static final QueryField ID = field("CommunityMessage", "id");
  public static final QueryField COMMUNITYID = field("CommunityMessage", "communityid");
  public static final QueryField MESSAGEFROM = field("CommunityMessage", "messagefrom");
  public static final QueryField DATE = field("CommunityMessage", "date");
  public static final QueryField CONTENT = field("CommunityMessage", "content");
  public static final QueryField MESSAGETYPE = field("CommunityMessage", "messagetype");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String communityid;
  private final @ModelField(targetType="ID", isRequired = true) String messagefrom;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  private final @ModelField(targetType="String", isRequired = true) String content;
  private final @ModelField(targetType="MessageType", isRequired = true)
  MessageType messagetype;
  public String getId() {
      return id;
  }
  
  public String getCommunityid() {
      return communityid;
  }
  
  public String getMessagefrom() {
      return messagefrom;
  }
  
  public Temporal.DateTime getDate() {
      return date;
  }
  
  public String getContent() {
      return content;
  }
  
  public MessageType getMessagetype() {
      return messagetype;
  }
  
  private CommunityMessage(String id, String communityid, String messagefrom, Temporal.DateTime date, String content, MessageType messagetype) {
    this.id = id;
    this.communityid = communityid;
    this.messagefrom = messagefrom;
    this.date = date;
    this.content = content;
    this.messagetype = messagetype;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      CommunityMessage communityMessage = (CommunityMessage) obj;
      return ObjectsCompat.equals(getId(), communityMessage.getId()) &&
              ObjectsCompat.equals(getCommunityid(), communityMessage.getCommunityid()) &&
              ObjectsCompat.equals(getMessagefrom(), communityMessage.getMessagefrom()) &&
              ObjectsCompat.equals(getDate(), communityMessage.getDate()) &&
              ObjectsCompat.equals(getContent(), communityMessage.getContent()) &&
              ObjectsCompat.equals(getMessagetype(), communityMessage.getMessagetype());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getCommunityid())
      .append(getMessagefrom())
      .append(getDate())
      .append(getContent())
      .append(getMessagetype())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("CommunityMessage {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("communityid=" + String.valueOf(getCommunityid()) + ", ")
      .append("messagefrom=" + String.valueOf(getMessagefrom()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("content=" + String.valueOf(getContent()) + ", ")
      .append("messagetype=" + String.valueOf(getMessagetype()))
      .append("}")
      .toString();
  }
  
  public static CommunityidStep builder() {
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
  public static CommunityMessage justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new CommunityMessage(
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
      communityid,
      messagefrom,
      date,
      content,
      messagetype);
  }
  public interface CommunityidStep {
    MessagefromStep communityid(String communityid);
  }
  

  public interface MessagefromStep {
    DateStep messagefrom(String messagefrom);
  }
  

  public interface DateStep {
    ContentStep date(Temporal.DateTime date);
  }
  

  public interface ContentStep {
    MessagetypeStep content(String content);
  }
  

  public interface MessagetypeStep {
    BuildStep messagetype(MessageType messagetype);
  }
  

  public interface BuildStep {
    CommunityMessage build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements CommunityidStep, MessagefromStep, DateStep, ContentStep, MessagetypeStep, BuildStep {
    private String id;
    private String communityid;
    private String messagefrom;
    private Temporal.DateTime date;
    private String content;
    private MessageType messagetype;
    @Override
     public CommunityMessage build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new CommunityMessage(
          id,
          communityid,
          messagefrom,
          date,
          content,
          messagetype);
    }
    
    @Override
     public MessagefromStep communityid(String communityid) {
        Objects.requireNonNull(communityid);
        this.communityid = communityid;
        return this;
    }
    
    @Override
     public DateStep messagefrom(String messagefrom) {
        Objects.requireNonNull(messagefrom);
        this.messagefrom = messagefrom;
        return this;
    }
    
    @Override
     public ContentStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }
    
    @Override
     public MessagetypeStep content(String content) {
        Objects.requireNonNull(content);
        this.content = content;
        return this;
    }
    
    @Override
     public BuildStep messagetype(MessageType messagetype) {
        Objects.requireNonNull(messagetype);
        this.messagetype = messagetype;
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
    private CopyOfBuilder(String id, String communityid, String messagefrom, Temporal.DateTime date, String content, MessageType messagetype) {
      super.id(id);
      super.communityid(communityid)
        .messagefrom(messagefrom)
        .date(date)
        .content(content)
        .messagetype(messagetype);
    }
    
    @Override
     public CopyOfBuilder communityid(String communityid) {
      return (CopyOfBuilder) super.communityid(communityid);
    }
    
    @Override
     public CopyOfBuilder messagefrom(String messagefrom) {
      return (CopyOfBuilder) super.messagefrom(messagefrom);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder content(String content) {
      return (CopyOfBuilder) super.content(content);
    }
    
    @Override
     public CopyOfBuilder messagetype(MessageType messagetype) {
      return (CopyOfBuilder) super.messagetype(messagetype);
    }
  }
  
}
