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

/** This is an auto generated class representing the Notifications type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Notifications")
public final class Notifications implements Model {
  public static final QueryField ID = field("Notifications", "id");
  public static final QueryField MEETINGID = field("Notifications", "meetingid");
  public static final QueryField REQUEST = field("Notifications", "request");
  public static final QueryField USERID = field("Notifications", "userid");
  public static final QueryField DATE = field("Notifications", "date");
  public static final QueryField DOCTORID = field("Notifications", "doctorid");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String meetingid;
  private final @ModelField(targetType="Request", isRequired = true)
  Request request;
  private final @ModelField(targetType="ID", isRequired = true) String userid;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  private final @ModelField(targetType="ID", isRequired = true) String doctorid;
  public String getId() {
      return id;
  }

  public String getMeetingid() {
      return meetingid;
  }

  public Request getRequest() {
      return request;
  }

  public String getUserid() {
      return userid;
  }

  public Temporal.DateTime getDate() {
      return date;
  }

  public String getDoctorid() {
      return doctorid;
  }

  private Notifications(String id, String meetingid, Request request, String userid, Temporal.DateTime date, String doctorid) {
    this.id = id;
    this.meetingid = meetingid;
    this.request = request;
    this.userid = userid;
    this.date = date;
    this.doctorid = doctorid;
  }

  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Notifications notifications = (Notifications) obj;
      return ObjectsCompat.equals(getId(), notifications.getId()) &&
              ObjectsCompat.equals(getMeetingid(), notifications.getMeetingid()) &&
              ObjectsCompat.equals(getRequest(), notifications.getRequest()) &&
              ObjectsCompat.equals(getUserid(), notifications.getUserid()) &&
              ObjectsCompat.equals(getDate(), notifications.getDate()) &&
              ObjectsCompat.equals(getDoctorid(), notifications.getDoctorid());
      }
  }

  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getMeetingid())
      .append(getRequest())
      .append(getUserid())
      .append(getDate())
      .append(getDoctorid())
      .toString()
      .hashCode();
  }

  @Override
   public String toString() {
    return new StringBuilder()
      .append("Notifications {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("meetingid=" + String.valueOf(getMeetingid()) + ", ")
      .append("request=" + String.valueOf(getRequest()) + ", ")
      .append("userid=" + String.valueOf(getUserid()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("doctorid=" + String.valueOf(getDoctorid()))
      .append("}")
      .toString();
  }

  public static MeetingidStep builder() {
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
  public static Notifications justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Notifications(
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
      meetingid,
      request,
      userid,
      date,
      doctorid);
  }
  public interface MeetingidStep {
    RequestStep meetingid(String meetingid);
  }


  public interface RequestStep {
    UseridStep request(Request request);
  }


  public interface UseridStep {
    DateStep userid(String userid);
  }


  public interface DateStep {
    DoctoridStep date(Temporal.DateTime date);
  }


  public interface DoctoridStep {
    BuildStep doctorid(String doctorid);
  }


  public interface BuildStep {
    Notifications build();
    BuildStep id(String id) throws IllegalArgumentException;
  }


  public static class Builder implements MeetingidStep, RequestStep, UseridStep, DateStep, DoctoridStep, BuildStep {
    private String id;
    private String meetingid;
    private Request request;
    private String userid;
    private Temporal.DateTime date;
    private String doctorid;
    @Override
     public Notifications build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();

        return new Notifications(
          id,
          meetingid,
          request,
          userid,
          date,
          doctorid);
    }

    @Override
     public RequestStep meetingid(String meetingid) {
        Objects.requireNonNull(meetingid);
        this.meetingid = meetingid;
        return this;
    }

    @Override
     public UseridStep request(Request request) {
        Objects.requireNonNull(request);
        this.request = request;
        return this;
    }

    @Override
     public DateStep userid(String userid) {
        Objects.requireNonNull(userid);
        this.userid = userid;
        return this;
    }

    @Override
     public DoctoridStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }

    @Override
     public BuildStep doctorid(String doctorid) {
        Objects.requireNonNull(doctorid);
        this.doctorid = doctorid;
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
    private CopyOfBuilder(String id, String meetingid, Request request, String userid, Temporal.DateTime date, String doctorid) {
      super.id(id);
      super.meetingid(meetingid)
        .request(request)
        .userid(userid)
        .date(date)
        .doctorid(doctorid);
    }
    
    @Override
     public CopyOfBuilder meetingid(String meetingid) {
      return (CopyOfBuilder) super.meetingid(meetingid);
    }
    
    @Override
     public CopyOfBuilder request(Request request) {
      return (CopyOfBuilder) super.request(request);
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
     public CopyOfBuilder doctorid(String doctorid) {
      return (CopyOfBuilder) super.doctorid(doctorid);
    }
  }
  
}
