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

/** This is an auto generated class representing the CoachPrescTask type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "CoachPrescTasks")
public final class CoachPrescTask implements Model {
  public static final QueryField ID = field("CoachPrescTask", "id");
  public static final QueryField USER_ID = field("CoachPrescTask", "userID");
  public static final QueryField DOCTOR_ID = field("CoachPrescTask", "doctorID");
  public static final QueryField MEETINGID = field("CoachPrescTask", "meetingid");
  public static final QueryField WEEKDAY = field("CoachPrescTask", "weekday");
  public static final QueryField TASK = field("CoachPrescTask", "task");
  public static final QueryField DATE = field("CoachPrescTask", "date");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String userID;
  private final @ModelField(targetType="ID", isRequired = true) String doctorID;
  private final @ModelField(targetType="ID", isRequired = true) String meetingid;
  private final @ModelField(targetType="WeekDay", isRequired = true)
  WeekDay weekday;
  private final @ModelField(targetType="String", isRequired = true) String task;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  public String getId() {
      return id;
  }

  public String getUserId() {
      return userID;
  }

  public String getDoctorId() {
      return doctorID;
  }

  public String getMeetingid() {
      return meetingid;
  }

  public WeekDay getWeekday() {
      return weekday;
  }

  public String getTask() {
      return task;
  }

  public Temporal.DateTime getDate() {
      return date;
  }

  private CoachPrescTask(String id, String userID, String doctorID, String meetingid, WeekDay weekday, String task, Temporal.DateTime date) {
    this.id = id;
    this.userID = userID;
    this.doctorID = doctorID;
    this.meetingid = meetingid;
    this.weekday = weekday;
    this.task = task;
    this.date = date;
  }

  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      CoachPrescTask coachPrescTask = (CoachPrescTask) obj;
      return ObjectsCompat.equals(getId(), coachPrescTask.getId()) &&
              ObjectsCompat.equals(getUserId(), coachPrescTask.getUserId()) &&
              ObjectsCompat.equals(getDoctorId(), coachPrescTask.getDoctorId()) &&
              ObjectsCompat.equals(getMeetingid(), coachPrescTask.getMeetingid()) &&
              ObjectsCompat.equals(getWeekday(), coachPrescTask.getWeekday()) &&
              ObjectsCompat.equals(getTask(), coachPrescTask.getTask()) &&
              ObjectsCompat.equals(getDate(), coachPrescTask.getDate());
      }
  }

  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUserId())
      .append(getDoctorId())
      .append(getMeetingid())
      .append(getWeekday())
      .append(getTask())
      .append(getDate())
      .toString()
      .hashCode();
  }

  @Override
   public String toString() {
    return new StringBuilder()
      .append("CoachPrescTask {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("userID=" + String.valueOf(getUserId()) + ", ")
      .append("doctorID=" + String.valueOf(getDoctorId()) + ", ")
      .append("meetingid=" + String.valueOf(getMeetingid()) + ", ")
      .append("weekday=" + String.valueOf(getWeekday()) + ", ")
      .append("task=" + String.valueOf(getTask()) + ", ")
      .append("date=" + String.valueOf(getDate()))
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
  public static CoachPrescTask justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new CoachPrescTask(
      id,
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
      userID,
      doctorID,
      meetingid,
      weekday,
      task,
      date);
  }
  public interface UserIdStep {
    DoctorIdStep userId(String userId);
  }


  public interface DoctorIdStep {
    MeetingidStep doctorId(String doctorId);
  }


  public interface MeetingidStep {
    WeekdayStep meetingid(String meetingid);
  }


  public interface WeekdayStep {
    TaskStep weekday(WeekDay weekday);
  }


  public interface TaskStep {
    DateStep task(String task);
  }


  public interface DateStep {
    BuildStep date(Temporal.DateTime date);
  }


  public interface BuildStep {
    CoachPrescTask build();
    BuildStep id(String id) throws IllegalArgumentException;
  }


  public static class Builder implements UserIdStep, DoctorIdStep, MeetingidStep, WeekdayStep, TaskStep, DateStep, BuildStep {
    private String id;
    private String userID;
    private String doctorID;
    private String meetingid;
    private WeekDay weekday;
    private String task;
    private Temporal.DateTime date;
    @Override
     public CoachPrescTask build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();

        return new CoachPrescTask(
          id,
          userID,
          doctorID,
          meetingid,
          weekday,
          task,
          date);
    }

    @Override
     public DoctorIdStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.userID = userId;
        return this;
    }

    @Override
     public MeetingidStep doctorId(String doctorId) {
        Objects.requireNonNull(doctorId);
        this.doctorID = doctorId;
        return this;
    }

    @Override
     public WeekdayStep meetingid(String meetingid) {
        Objects.requireNonNull(meetingid);
        this.meetingid = meetingid;
        return this;
    }

    @Override
     public TaskStep weekday(WeekDay weekday) {
        Objects.requireNonNull(weekday);
        this.weekday = weekday;
        return this;
    }

    @Override
     public DateStep task(String task) {
        Objects.requireNonNull(task);
        this.task = task;
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
    private CopyOfBuilder(String id, String userId, String doctorId, String meetingid, WeekDay weekday, String task, Temporal.DateTime date) {
      super.id(id);
      super.userId(userId)
        .doctorId(doctorId)
        .meetingid(meetingid)
        .weekday(weekday)
        .task(task)
        .date(date);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder doctorId(String doctorId) {
      return (CopyOfBuilder) super.doctorId(doctorId);
    }
    
    @Override
     public CopyOfBuilder meetingid(String meetingid) {
      return (CopyOfBuilder) super.meetingid(meetingid);
    }
    
    @Override
     public CopyOfBuilder weekday(WeekDay weekday) {
      return (CopyOfBuilder) super.weekday(weekday);
    }
    
    @Override
     public CopyOfBuilder task(String task) {
      return (CopyOfBuilder) super.task(task);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
  }
  
}
