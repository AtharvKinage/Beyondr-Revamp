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

/** This is an auto generated class representing the PackagesBuy type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "PackagesBuys")
public final class PackagesBuy implements Model {
  public static final QueryField ID = field("PackagesBuy", "id");
  public static final QueryField DOCTOR_ID = field("PackagesBuy", "doctorID");
  public static final QueryField USER_ID = field("PackagesBuy", "userID");
  public static final QueryField NUMBEROFAPPOINTMENTSUSED = field("PackagesBuy", "numberofappointmentsused");
  public static final QueryField CONSULTATIONFEES = field("PackagesBuy", "consultationfees");
  public static final QueryField CONULTATIONFESSCURRENCY = field("PackagesBuy", "conultationfesscurrency");
  public static final QueryField NUMOFAPPOINTMENTS = field("PackagesBuy", "numofappointments");
  public static final QueryField VALIDITY = field("PackagesBuy", "validity");
  public static final QueryField DATE = field("PackagesBuy", "date");
  public static final QueryField DOCTORTYPE = field("PackagesBuy", "doctortype");
  public static final QueryField PAYMENT_COMPLETION_STATUS = field("PackagesBuy", "PaymentCompletionStatus");
  public static final QueryField PAYMENT_MODE = field("PackagesBuy", "PaymentMode");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String doctorID;
  private final @ModelField(targetType="ID", isRequired = true) String userID;
  private final @ModelField(targetType="String", isRequired = true) String numberofappointmentsused;
  private final @ModelField(targetType="String", isRequired = true) String consultationfees;
  private final @ModelField(targetType="String", isRequired = true) String conultationfesscurrency;
  private final @ModelField(targetType="String", isRequired = true) String numofappointments;
  private final @ModelField(targetType="String", isRequired = true) String validity;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  private final @ModelField(targetType="DoctorType", isRequired = true)
  DoctorType doctortype;
  private final @ModelField(targetType="PaymentCompletionStatus", isRequired = true)
  com.amplifyframework.datastore.generated.model.PaymentCompletionStatus PaymentCompletionStatus;
  private final @ModelField(targetType="PaymentMode")
  com.amplifyframework.datastore.generated.model.PaymentMode PaymentMode;
  public String getId() {
      return id;
  }

  public String getDoctorId() {
      return doctorID;
  }

  public String getUserId() {
      return userID;
  }

  public String getNumberofappointmentsused() {
      return numberofappointmentsused;
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

  public Temporal.DateTime getDate() {
      return date;
  }

  public DoctorType getDoctortype() {
      return doctortype;
  }

  public com.amplifyframework.datastore.generated.model.PaymentCompletionStatus getPaymentCompletionStatus() {
      return PaymentCompletionStatus;
  }

  public com.amplifyframework.datastore.generated.model.PaymentMode getPaymentMode() {
      return PaymentMode;
  }

  private PackagesBuy(String id, String doctorID, String userID, String numberofappointmentsused, String consultationfees, String conultationfesscurrency, String numofappointments, String validity, Temporal.DateTime date, DoctorType doctortype, com.amplifyframework.datastore.generated.model.PaymentCompletionStatus PaymentCompletionStatus, com.amplifyframework.datastore.generated.model.PaymentMode PaymentMode) {
    this.id = id;
    this.doctorID = doctorID;
    this.userID = userID;
    this.numberofappointmentsused = numberofappointmentsused;
    this.consultationfees = consultationfees;
    this.conultationfesscurrency = conultationfesscurrency;
    this.numofappointments = numofappointments;
    this.validity = validity;
    this.date = date;
    this.doctortype = doctortype;
    this.PaymentCompletionStatus = PaymentCompletionStatus;
    this.PaymentMode = PaymentMode;
  }

  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      PackagesBuy packagesBuy = (PackagesBuy) obj;
      return ObjectsCompat.equals(getId(), packagesBuy.getId()) &&
              ObjectsCompat.equals(getDoctorId(), packagesBuy.getDoctorId()) &&
              ObjectsCompat.equals(getUserId(), packagesBuy.getUserId()) &&
              ObjectsCompat.equals(getNumberofappointmentsused(), packagesBuy.getNumberofappointmentsused()) &&
              ObjectsCompat.equals(getConsultationfees(), packagesBuy.getConsultationfees()) &&
              ObjectsCompat.equals(getConultationfesscurrency(), packagesBuy.getConultationfesscurrency()) &&
              ObjectsCompat.equals(getNumofappointments(), packagesBuy.getNumofappointments()) &&
              ObjectsCompat.equals(getValidity(), packagesBuy.getValidity()) &&
              ObjectsCompat.equals(getDate(), packagesBuy.getDate()) &&
              ObjectsCompat.equals(getDoctortype(), packagesBuy.getDoctortype()) &&
              ObjectsCompat.equals(getPaymentCompletionStatus(), packagesBuy.getPaymentCompletionStatus()) &&
              ObjectsCompat.equals(getPaymentMode(), packagesBuy.getPaymentMode());
      }
  }

  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDoctorId())
      .append(getUserId())
      .append(getNumberofappointmentsused())
      .append(getConsultationfees())
      .append(getConultationfesscurrency())
      .append(getNumofappointments())
      .append(getValidity())
      .append(getDate())
      .append(getDoctortype())
      .append(getPaymentCompletionStatus())
      .append(getPaymentMode())
      .toString()
      .hashCode();
  }

  @Override
   public String toString() {
    return new StringBuilder()
      .append("PackagesBuy {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("doctorID=" + String.valueOf(getDoctorId()) + ", ")
      .append("userID=" + String.valueOf(getUserId()) + ", ")
      .append("numberofappointmentsused=" + String.valueOf(getNumberofappointmentsused()) + ", ")
      .append("consultationfees=" + String.valueOf(getConsultationfees()) + ", ")
      .append("conultationfesscurrency=" + String.valueOf(getConultationfesscurrency()) + ", ")
      .append("numofappointments=" + String.valueOf(getNumofappointments()) + ", ")
      .append("validity=" + String.valueOf(getValidity()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("doctortype=" + String.valueOf(getDoctortype()) + ", ")
      .append("PaymentCompletionStatus=" + String.valueOf(getPaymentCompletionStatus()) + ", ")
      .append("PaymentMode=" + String.valueOf(getPaymentMode()))
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
  public static PackagesBuy justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new PackagesBuy(
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
      null,
      null
    );
  }

  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      doctorID,
      userID,
      numberofappointmentsused,
      consultationfees,
      conultationfesscurrency,
      numofappointments,
      validity,
      date,
      doctortype,
      PaymentCompletionStatus,
      PaymentMode);
  }
  public interface DoctorIdStep {
    UserIdStep doctorId(String doctorId);
  }


  public interface UserIdStep {
    NumberofappointmentsusedStep userId(String userId);
  }


  public interface NumberofappointmentsusedStep {
    ConsultationfeesStep numberofappointmentsused(String numberofappointmentsused);
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
    DateStep validity(String validity);
  }


  public interface DateStep {
    DoctortypeStep date(Temporal.DateTime date);
  }


  public interface DoctortypeStep {
    PaymentCompletionStatusStep doctortype(DoctorType doctortype);
  }


  public interface PaymentCompletionStatusStep {
    BuildStep paymentCompletionStatus(com.amplifyframework.datastore.generated.model.PaymentCompletionStatus paymentCompletionStatus);
  }


  public interface BuildStep {
    PackagesBuy build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep paymentMode(com.amplifyframework.datastore.generated.model.PaymentMode paymentMode);
  }


  public static class Builder implements DoctorIdStep, UserIdStep, NumberofappointmentsusedStep, ConsultationfeesStep, ConultationfesscurrencyStep, NumofappointmentsStep, ValidityStep, DateStep, DoctortypeStep, PaymentCompletionStatusStep, BuildStep {
    private String id;
    private String doctorID;
    private String userID;
    private String numberofappointmentsused;
    private String consultationfees;
    private String conultationfesscurrency;
    private String numofappointments;
    private String validity;
    private Temporal.DateTime date;
    private DoctorType doctortype;
    private com.amplifyframework.datastore.generated.model.PaymentCompletionStatus PaymentCompletionStatus;
    private com.amplifyframework.datastore.generated.model.PaymentMode PaymentMode;
    @Override
     public PackagesBuy build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();

        return new PackagesBuy(
          id,
          doctorID,
          userID,
          numberofappointmentsused,
          consultationfees,
          conultationfesscurrency,
          numofappointments,
          validity,
          date,
          doctortype,
          PaymentCompletionStatus,
          PaymentMode);
    }

    @Override
     public UserIdStep doctorId(String doctorId) {
        Objects.requireNonNull(doctorId);
        this.doctorID = doctorId;
        return this;
    }

    @Override
     public NumberofappointmentsusedStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.userID = userId;
        return this;
    }

    @Override
     public ConsultationfeesStep numberofappointmentsused(String numberofappointmentsused) {
        Objects.requireNonNull(numberofappointmentsused);
        this.numberofappointmentsused = numberofappointmentsused;
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
     public DateStep validity(String validity) {
        Objects.requireNonNull(validity);
        this.validity = validity;
        return this;
    }

    @Override
     public DoctortypeStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }

    @Override
     public PaymentCompletionStatusStep doctortype(DoctorType doctortype) {
        Objects.requireNonNull(doctortype);
        this.doctortype = doctortype;
        return this;
    }

    @Override
     public BuildStep paymentCompletionStatus(com.amplifyframework.datastore.generated.model.PaymentCompletionStatus paymentCompletionStatus) {
        Objects.requireNonNull(paymentCompletionStatus);
        this.PaymentCompletionStatus = paymentCompletionStatus;
        return this;
    }

    @Override
     public BuildStep paymentMode(com.amplifyframework.datastore.generated.model.PaymentMode paymentMode) {
        this.PaymentMode = paymentMode;
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
    private CopyOfBuilder(String id, String doctorId, String userId, String numberofappointmentsused, String consultationfees, String conultationfesscurrency, String numofappointments, String validity, Temporal.DateTime date, DoctorType doctortype, com.amplifyframework.datastore.generated.model.PaymentCompletionStatus paymentCompletionStatus, com.amplifyframework.datastore.generated.model.PaymentMode paymentMode) {
      super.id(id);
      super.doctorId(doctorId)
        .userId(userId)
        .numberofappointmentsused(numberofappointmentsused)
        .consultationfees(consultationfees)
        .conultationfesscurrency(conultationfesscurrency)
        .numofappointments(numofappointments)
        .validity(validity)
        .date(date)
        .doctortype(doctortype)
        .paymentCompletionStatus(paymentCompletionStatus)
        .paymentMode(paymentMode);
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
     public CopyOfBuilder numberofappointmentsused(String numberofappointmentsused) {
      return (CopyOfBuilder) super.numberofappointmentsused(numberofappointmentsused);
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
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }

    @Override
     public CopyOfBuilder doctortype(DoctorType doctortype) {
      return (CopyOfBuilder) super.doctortype(doctortype);
    }

    @Override
     public CopyOfBuilder paymentCompletionStatus(com.amplifyframework.datastore.generated.model.PaymentCompletionStatus paymentCompletionStatus) {
      return (CopyOfBuilder) super.paymentCompletionStatus(paymentCompletionStatus);
    }

    @Override
     public CopyOfBuilder paymentMode(com.amplifyframework.datastore.generated.model.PaymentMode paymentMode) {
      return (CopyOfBuilder) super.paymentMode(paymentMode);
    }
  }
  
}
