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

/** This is an auto generated class representing the Invite type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Invites")
public final class Invite implements Model {
  public static final QueryField ID = field("Invite", "id");
  public static final QueryField DOCTOR_ID = field("Invite", "doctorID");
  public static final QueryField USER_ID = field("Invite", "UserID");
  public static final QueryField MESSAGE = field("Invite", "message");
  public static final QueryField INVITE = field("Invite", "invite");
  public static final QueryField DATE = field("Invite", "date");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String doctorID;
  private final @ModelField(targetType="ID", isRequired = true) String UserID;
  private final @ModelField(targetType="String", isRequired = true) String message;
  private final @ModelField(targetType="Request", isRequired = true)
  Request invite;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  public String getId() {
      return id;
  }

  public String getDoctorId() {
      return doctorID;
  }

  public String getUserId() {
      return UserID;
  }

  public String getMessage() {
      return message;
  }

  public Request getInvite() {
      return invite;
  }

  public Temporal.DateTime getDate() {
      return date;
  }

  private Invite(String id, String doctorID, String UserID, String message, Request invite, Temporal.DateTime date) {
    this.id = id;
    this.doctorID = doctorID;
    this.UserID = UserID;
    this.message = message;
    this.invite = invite;
    this.date = date;
  }

  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Invite invite = (Invite) obj;
      return ObjectsCompat.equals(getId(), invite.getId()) &&
              ObjectsCompat.equals(getDoctorId(), invite.getDoctorId()) &&
              ObjectsCompat.equals(getUserId(), invite.getUserId()) &&
              ObjectsCompat.equals(getMessage(), invite.getMessage()) &&
              ObjectsCompat.equals(getInvite(), invite.getInvite()) &&
              ObjectsCompat.equals(getDate(), invite.getDate());
      }
  }

  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDoctorId())
      .append(getUserId())
      .append(getMessage())
      .append(getInvite())
      .append(getDate())
      .toString()
      .hashCode();
  }

  @Override
   public String toString() {
    return new StringBuilder()
      .append("Invite {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("doctorID=" + String.valueOf(getDoctorId()) + ", ")
      .append("UserID=" + String.valueOf(getUserId()) + ", ")
      .append("message=" + String.valueOf(getMessage()) + ", ")
      .append("invite=" + String.valueOf(getInvite()) + ", ")
      .append("date=" + String.valueOf(getDate()))
      .append("}")
      .toString();
  }

  public static DoctorIdStep builder() {
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
  public static Invite justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Invite(
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
      doctorID,
      UserID,
      message,
      invite,
      date);
  }
  public interface DoctorIdStep {
    UserIdStep doctorId(String doctorId);
  }


  public interface UserIdStep {
    MessageStep userId(String userId);
  }


  public interface MessageStep {
    InviteStep message(String message);
  }


  public interface InviteStep {
    DateStep invite(Request invite);
  }


  public interface DateStep {
    BuildStep date(Temporal.DateTime date);
  }


  public interface BuildStep {
    Invite build();
    BuildStep id(String id) throws IllegalArgumentException;
  }


  public static class Builder implements DoctorIdStep, UserIdStep, MessageStep, InviteStep, DateStep, BuildStep {
    private String id;
    private String doctorID;
    private String UserID;
    private String message;
    private Request invite;
    private Temporal.DateTime date;
    @Override
     public Invite build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();

        return new Invite(
          id,
          doctorID,
          UserID,
          message,
          invite,
          date);
    }

    @Override
     public UserIdStep doctorId(String doctorId) {
        Objects.requireNonNull(doctorId);
        this.doctorID = doctorId;
        return this;
    }

    @Override
     public MessageStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.UserID = userId;
        return this;
    }

    @Override
     public InviteStep message(String message) {
        Objects.requireNonNull(message);
        this.message = message;
        return this;
    }

    @Override
     public DateStep invite(Request invite) {
        Objects.requireNonNull(invite);
        this.invite = invite;
        return this;
    }

    @Override
     public BuildStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
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
    private CopyOfBuilder(String id, String doctorId, String userId, String message, Request invite, Temporal.DateTime date) {
      super.id(id);
      super.doctorId(doctorId)
        .userId(userId)
        .message(message)
        .invite(invite)
        .date(date);
    }
    
    @Override
     public CopyOfBuilder doctorId(String doctorId) {
      return (CopyOfBuilder) super.doctorId(doctorId);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder message(String message) {
      return (CopyOfBuilder) super.message(message);
    }
    
    @Override
     public CopyOfBuilder invite(Request invite) {
      return (CopyOfBuilder) super.invite(invite);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
  }
  
}
