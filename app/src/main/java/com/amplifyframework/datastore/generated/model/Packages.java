package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import java.util.Objects;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Packages type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Packages")
public final class Packages implements Model {
  public static final QueryField ID = field("Packages", "id");
  public static final QueryField DOCTOR_ID = field("Packages", "doctorID");
  public static final QueryField CONSULTATIONFEES = field("Packages", "consultationfees");
  public static final QueryField CONULTATIONFESSCURRENCY = field("Packages", "conultationfesscurrency");
  public static final QueryField NUMOFAPPOINTMENTS = field("Packages", "numofappointments");
  public static final QueryField VALIDITY = field("Packages", "validity");
  public static final QueryField DOCTORTYPE = field("Packages", "doctortype");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String doctorID;
  private final @ModelField(targetType="String", isRequired = true) String consultationfees;
  private final @ModelField(targetType="String", isRequired = true) String conultationfesscurrency;
  private final @ModelField(targetType="String", isRequired = true) String numofappointments;
  private final @ModelField(targetType="String", isRequired = true) String validity;
  private final @ModelField(targetType="DoctorType", isRequired = true)
  DoctorType doctortype;
  public String getId() {
      return id;
  }

  public String getDoctorId() {
      return doctorID;
  }

  public String getConsultationfees() {
      return consultationfees;
  }

  public String getConultationfesscurrency() {
      return conultationfesscurrency;
  }

  public String getNumofappointments() {
      return numofappointments;
  }

  public String getValidity() {
      return validity;
  }

  public DoctorType getDoctortype() {
      return doctortype;
  }

  private Packages(String id, String doctorID, String consultationfees, String conultationfesscurrency, String numofappointments, String validity, DoctorType doctortype) {
    this.id = id;
    this.doctorID = doctorID;
    this.consultationfees = consultationfees;
    this.conultationfesscurrency = conultationfesscurrency;
    this.numofappointments = numofappointments;
    this.validity = validity;
    this.doctortype = doctortype;
  }

  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Packages packages = (Packages) obj;
      return ObjectsCompat.equals(getId(), packages.getId()) &&
              ObjectsCompat.equals(getDoctorId(), packages.getDoctorId()) &&
              ObjectsCompat.equals(getConsultationfees(), packages.getConsultationfees()) &&
              ObjectsCompat.equals(getConultationfesscurrency(), packages.getConultationfesscurrency()) &&
              ObjectsCompat.equals(getNumofappointments(), packages.getNumofappointments()) &&
              ObjectsCompat.equals(getValidity(), packages.getValidity()) &&
              ObjectsCompat.equals(getDoctortype(), packages.getDoctortype());
      }
  }

  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDoctorId())
      .append(getConsultationfees())
      .append(getConultationfesscurrency())
      .append(getNumofappointments())
      .append(getValidity())
      .append(getDoctortype())
      .toString()
      .hashCode();
  }

  @Override
   public String toString() {
    return new StringBuilder()
      .append("Packages {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("doctorID=" + String.valueOf(getDoctorId()) + ", ")
      .append("consultationfees=" + String.valueOf(getConsultationfees()) + ", ")
      .append("conultationfesscurrency=" + String.valueOf(getConultationfesscurrency()) + ", ")
      .append("numofappointments=" + String.valueOf(getNumofappointments()) + ", ")
      .append("validity=" + String.valueOf(getValidity()) + ", ")
      .append("doctortype=" + String.valueOf(getDoctortype()))
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
  public static Packages justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Packages(
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
      consultationfees,
      conultationfesscurrency,
      numofappointments,
      validity,
      doctortype);
  }
  public interface DoctorIdStep {
    ConsultationfeesStep doctorId(String doctorId);
  }


  public interface ConsultationfeesStep {
    ConultationfesscurrencyStep consultationfees(String consultationfees);
  }


  public interface ConultationfesscurrencyStep {
    NumofappointmentsStep conultationfesscurrency(String conultationfesscurrency);
  }


  public interface NumofappointmentsStep {
    ValidityStep numofappointments(String numofappointments);
  }


  public interface ValidityStep {
    DoctortypeStep validity(String validity);
  }


  public interface DoctortypeStep {
    BuildStep doctortype(DoctorType doctortype);
  }


  public interface BuildStep {
    Packages build();
    BuildStep id(String id) throws IllegalArgumentException;
  }


  public static class Builder implements DoctorIdStep, ConsultationfeesStep, ConultationfesscurrencyStep, NumofappointmentsStep, ValidityStep, DoctortypeStep, BuildStep {
    private String id;
    private String doctorID;
    private String consultationfees;
    private String conultationfesscurrency;
    private String numofappointments;
    private String validity;
    private DoctorType doctortype;
    @Override
     public Packages build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();

        return new Packages(
          id,
          doctorID,
          consultationfees,
          conultationfesscurrency,
          numofappointments,
          validity,
          doctortype);
    }

    @Override
     public ConsultationfeesStep doctorId(String doctorId) {
        Objects.requireNonNull(doctorId);
        this.doctorID = doctorId;
        return this;
    }

    @Override
     public ConultationfesscurrencyStep consultationfees(String consultationfees) {
        Objects.requireNonNull(consultationfees);
        this.consultationfees = consultationfees;
        return this;
    }

    @Override
     public NumofappointmentsStep conultationfesscurrency(String conultationfesscurrency) {
        Objects.requireNonNull(conultationfesscurrency);
        this.conultationfesscurrency = conultationfesscurrency;
        return this;
    }

    @Override
     public ValidityStep numofappointments(String numofappointments) {
        Objects.requireNonNull(numofappointments);
        this.numofappointments = numofappointments;
        return this;
    }

    @Override
     public DoctortypeStep validity(String validity) {
        Objects.requireNonNull(validity);
        this.validity = validity;
        return this;
    }

    @Override
     public BuildStep doctortype(DoctorType doctortype) {
        Objects.requireNonNull(doctortype);
        this.doctortype = doctortype;
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
    private CopyOfBuilder(String id, String doctorId, String consultationfees, String conultationfesscurrency, String numofappointments, String validity, DoctorType doctortype) {
      super.id(id);
      super.doctorId(doctorId)
        .consultationfees(consultationfees)
        .conultationfesscurrency(conultationfesscurrency)
        .numofappointments(numofappointments)
        .validity(validity)
        .doctortype(doctortype);
    }
    
    @Override
     public CopyOfBuilder doctorId(String doctorId) {
      return (CopyOfBuilder) super.doctorId(doctorId);
    }
    
    @Override
     public CopyOfBuilder consultationfees(String consultationfees) {
      return (CopyOfBuilder) super.consultationfees(consultationfees);
    }
    
    @Override
     public CopyOfBuilder conultationfesscurrency(String conultationfesscurrency) {
      return (CopyOfBuilder) super.conultationfesscurrency(conultationfesscurrency);
    }
    
    @Override
     public CopyOfBuilder numofappointments(String numofappointments) {
      return (CopyOfBuilder) super.numofappointments(numofappointments);
    }
    
    @Override
     public CopyOfBuilder validity(String validity) {
      return (CopyOfBuilder) super.validity(validity);
    }
    
    @Override
     public CopyOfBuilder doctortype(DoctorType doctortype) {
      return (CopyOfBuilder) super.doctortype(doctortype);
    }
  }
  
}
