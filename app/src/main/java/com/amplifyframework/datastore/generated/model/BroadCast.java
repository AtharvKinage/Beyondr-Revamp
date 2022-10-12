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

/** This is an auto generated class representing the BroadCast type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "BroadCasts")
public final class BroadCast implements Model {
  public static final QueryField ID = field("BroadCast", "id");
  public static final QueryField DOCTOR_ID = field("BroadCast", "doctorID");
  public static final QueryField DATE = field("BroadCast", "date");
  public static final QueryField NAME = field("BroadCast", "name");
  public static final QueryField DESCRIPTION = field("BroadCast", "description");
  public static final QueryField DOCTORTYPE = field("BroadCast", "doctortype");
  public static final QueryField BROAD_CAST_STATUS = field("BroadCast", "BroadCastStatus");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String doctorID;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="String", isRequired = true) String description;
  private final @ModelField(targetType="DoctorType", isRequired = true)
  DoctorType doctortype;
  private final @ModelField(targetType="BroadCastStatus", isRequired = true)
  com.amplifyframework.datastore.generated.model.BroadCastStatus BroadCastStatus;
  public String getId() {
      return id;
  }

  public String getDoctorId() {
      return doctorID;
  }

  public Temporal.DateTime getDate() {
      return date;
  }

  public String getName() {
      return name;
  }

  public String getDescription() {
      return description;
  }

  public DoctorType getDoctortype() {
      return doctortype;
  }

  public com.amplifyframework.datastore.generated.model.BroadCastStatus getBroadCastStatus() {
      return BroadCastStatus;
  }

  private BroadCast(String id, String doctorID, Temporal.DateTime date, String name, String description, DoctorType doctortype, com.amplifyframework.datastore.generated.model.BroadCastStatus BroadCastStatus) {
    this.id = id;
    this.doctorID = doctorID;
    this.date = date;
    this.name = name;
    this.description = description;
    this.doctortype = doctortype;
    this.BroadCastStatus = BroadCastStatus;
  }

  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      BroadCast broadCast = (BroadCast) obj;
      return ObjectsCompat.equals(getId(), broadCast.getId()) &&
              ObjectsCompat.equals(getDoctorId(), broadCast.getDoctorId()) &&
              ObjectsCompat.equals(getDate(), broadCast.getDate()) &&
              ObjectsCompat.equals(getName(), broadCast.getName()) &&
              ObjectsCompat.equals(getDescription(), broadCast.getDescription()) &&
              ObjectsCompat.equals(getDoctortype(), broadCast.getDoctortype()) &&
              ObjectsCompat.equals(getBroadCastStatus(), broadCast.getBroadCastStatus());
      }
  }

  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDoctorId())
      .append(getDate())
      .append(getName())
      .append(getDescription())
      .append(getDoctortype())
      .append(getBroadCastStatus())
      .toString()
      .hashCode();
  }

  @Override
   public String toString() {
    return new StringBuilder()
      .append("BroadCast {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("doctorID=" + String.valueOf(getDoctorId()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("description=" + String.valueOf(getDescription()) + ", ")
      .append("doctortype=" + String.valueOf(getDoctortype()) + ", ")
      .append("BroadCastStatus=" + String.valueOf(getBroadCastStatus()))
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
  public static BroadCast justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new BroadCast(
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
      doctorID,
      date,
      name,
      description,
      doctortype,
      BroadCastStatus);
  }
  public interface DoctorIdStep {
    DateStep doctorId(String doctorId);
  }


  public interface DateStep {
    NameStep date(Temporal.DateTime date);
  }


  public interface NameStep {
    DescriptionStep name(String name);
  }


  public interface DescriptionStep {
    DoctortypeStep description(String description);
  }


  public interface DoctortypeStep {
    BroadCastStatusStep doctortype(DoctorType doctortype);
  }


  public interface BroadCastStatusStep {
    BuildStep broadCastStatus(com.amplifyframework.datastore.generated.model.BroadCastStatus broadCastStatus);
  }


  public interface BuildStep {
    BroadCast build();
    BuildStep id(String id) throws IllegalArgumentException;
  }


  public static class Builder implements DoctorIdStep, DateStep, NameStep, DescriptionStep, DoctortypeStep, BroadCastStatusStep, BuildStep {
    private String id;
    private String doctorID;
    private Temporal.DateTime date;
    private String name;
    private String description;
    private DoctorType doctortype;
    private com.amplifyframework.datastore.generated.model.BroadCastStatus BroadCastStatus;
    @Override
     public BroadCast build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();

        return new BroadCast(
          id,
          doctorID,
          date,
          name,
          description,
          doctortype,
          BroadCastStatus);
    }

    @Override
     public DateStep doctorId(String doctorId) {
        Objects.requireNonNull(doctorId);
        this.doctorID = doctorId;
        return this;
    }

    @Override
     public NameStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }

    @Override
     public DescriptionStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }

    @Override
     public DoctortypeStep description(String description) {
        Objects.requireNonNull(description);
        this.description = description;
        return this;
    }

    @Override
     public BroadCastStatusStep doctortype(DoctorType doctortype) {
        Objects.requireNonNull(doctortype);
        this.doctortype = doctortype;
        return this;
    }

    @Override
     public BuildStep broadCastStatus(com.amplifyframework.datastore.generated.model.BroadCastStatus broadCastStatus) {
        Objects.requireNonNull(broadCastStatus);
        this.BroadCastStatus = broadCastStatus;
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
    private CopyOfBuilder(String id, String doctorId, Temporal.DateTime date, String name, String description, DoctorType doctortype, com.amplifyframework.datastore.generated.model.BroadCastStatus broadCastStatus) {
      super.id(id);
      super.doctorId(doctorId)
        .date(date)
        .name(name)
        .description(description)
        .doctortype(doctortype)
        .broadCastStatus(broadCastStatus);
    }

    @Override
     public CopyOfBuilder doctorId(String doctorId) {
      return (CopyOfBuilder) super.doctorId(doctorId);
    }

    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }

    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }

    @Override
     public CopyOfBuilder description(String description) {
      return (CopyOfBuilder) super.description(description);
    }

    @Override
     public CopyOfBuilder doctortype(DoctorType doctortype) {
      return (CopyOfBuilder) super.doctortype(doctortype);
    }

    @Override
     public CopyOfBuilder broadCastStatus(com.amplifyframework.datastore.generated.model.BroadCastStatus broadCastStatus) {
      return (CopyOfBuilder) super.broadCastStatus(broadCastStatus);
    }
  }
  
}
