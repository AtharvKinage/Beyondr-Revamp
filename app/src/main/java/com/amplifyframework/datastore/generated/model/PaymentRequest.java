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

/** This is an auto generated class representing the PaymentRequest type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "PaymentRequests")
public final class PaymentRequest implements Model {
  public static final QueryField ID = field("PaymentRequest", "id");
  public static final QueryField PAYMENT_REQUEST_TYPE = field("PaymentRequest", "PaymentRequestType");
  public static final QueryField DOCTOR_ID = field("PaymentRequest", "doctorID");
  public static final QueryField DATE = field("PaymentRequest", "date");
  public static final QueryField APPOINTMENTID = field("PaymentRequest", "appointmentid");
  public static final QueryField REQUEST = field("PaymentRequest", "request");
  public static final QueryField PAIDTODOCTORDATE = field("PaymentRequest", "paidtodoctordate");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="PaymentRequestType", isRequired = true)
  com.amplifyframework.datastore.generated.model.PaymentRequestType PaymentRequestType;
  private final @ModelField(targetType="ID", isRequired = true) String doctorID;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  private final @ModelField(targetType="ID", isRequired = true) String appointmentid;
  private final @ModelField(targetType="PaymenttoDoctor", isRequired = true)
  PaymenttoDoctor request;
  private final @ModelField(targetType="AWSDateTime") Temporal.DateTime paidtodoctordate;
  public String getId() {
      return id;
  }

  public com.amplifyframework.datastore.generated.model.PaymentRequestType getPaymentRequestType() {
      return PaymentRequestType;
  }

  public String getDoctorId() {
      return doctorID;
  }

  public Temporal.DateTime getDate() {
      return date;
  }

  public String getAppointmentid() {
      return appointmentid;
  }

  public PaymenttoDoctor getRequest() {
      return request;
  }

  public Temporal.DateTime getPaidtodoctordate() {
      return paidtodoctordate;
  }

  private PaymentRequest(String id, com.amplifyframework.datastore.generated.model.PaymentRequestType PaymentRequestType, String doctorID, Temporal.DateTime date, String appointmentid, PaymenttoDoctor request, Temporal.DateTime paidtodoctordate) {
    this.id = id;
    this.PaymentRequestType = PaymentRequestType;
    this.doctorID = doctorID;
    this.date = date;
    this.appointmentid = appointmentid;
    this.request = request;
    this.paidtodoctordate = paidtodoctordate;
  }

  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      PaymentRequest paymentRequest = (PaymentRequest) obj;
      return ObjectsCompat.equals(getId(), paymentRequest.getId()) &&
              ObjectsCompat.equals(getPaymentRequestType(), paymentRequest.getPaymentRequestType()) &&
              ObjectsCompat.equals(getDoctorId(), paymentRequest.getDoctorId()) &&
              ObjectsCompat.equals(getDate(), paymentRequest.getDate()) &&
              ObjectsCompat.equals(getAppointmentid(), paymentRequest.getAppointmentid()) &&
              ObjectsCompat.equals(getRequest(), paymentRequest.getRequest()) &&
              ObjectsCompat.equals(getPaidtodoctordate(), paymentRequest.getPaidtodoctordate());
      }
  }

  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getPaymentRequestType())
      .append(getDoctorId())
      .append(getDate())
      .append(getAppointmentid())
      .append(getRequest())
      .append(getPaidtodoctordate())
      .toString()
      .hashCode();
  }

  @Override
   public String toString() {
    return new StringBuilder()
      .append("PaymentRequest {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("PaymentRequestType=" + String.valueOf(getPaymentRequestType()) + ", ")
      .append("doctorID=" + String.valueOf(getDoctorId()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("appointmentid=" + String.valueOf(getAppointmentid()) + ", ")
      .append("request=" + String.valueOf(getRequest()) + ", ")
      .append("paidtodoctordate=" + String.valueOf(getPaidtodoctordate()))
      .append("}")
      .toString();
  }

  public static PaymentRequestTypeStep builder() {
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
  public static PaymentRequest justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new PaymentRequest(
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
      PaymentRequestType,
      doctorID,
      date,
      appointmentid,
      request,
      paidtodoctordate);
  }
  public interface PaymentRequestTypeStep {
    DoctorIdStep paymentRequestType(com.amplifyframework.datastore.generated.model.PaymentRequestType paymentRequestType);
  }


  public interface DoctorIdStep {
    DateStep doctorId(String doctorId);
  }


  public interface DateStep {
    AppointmentidStep date(Temporal.DateTime date);
  }


  public interface AppointmentidStep {
    RequestStep appointmentid(String appointmentid);
  }


  public interface RequestStep {
    BuildStep request(PaymenttoDoctor request);
  }


  public interface BuildStep {
    PaymentRequest build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep paidtodoctordate(Temporal.DateTime paidtodoctordate);
  }


  public static class Builder implements PaymentRequestTypeStep, DoctorIdStep, DateStep, AppointmentidStep, RequestStep, BuildStep {
    private String id;
    private com.amplifyframework.datastore.generated.model.PaymentRequestType PaymentRequestType;
    private String doctorID;
    private Temporal.DateTime date;
    private String appointmentid;
    private PaymenttoDoctor request;
    private Temporal.DateTime paidtodoctordate;
    @Override
     public PaymentRequest build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();

        return new PaymentRequest(
          id,
          PaymentRequestType,
          doctorID,
          date,
          appointmentid,
          request,
          paidtodoctordate);
    }

    @Override
     public DoctorIdStep paymentRequestType(com.amplifyframework.datastore.generated.model.PaymentRequestType paymentRequestType) {
        Objects.requireNonNull(paymentRequestType);
        this.PaymentRequestType = paymentRequestType;
        return this;
    }

    @Override
     public DateStep doctorId(String doctorId) {
        Objects.requireNonNull(doctorId);
        this.doctorID = doctorId;
        return this;
    }

    @Override
     public AppointmentidStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }

    @Override
     public RequestStep appointmentid(String appointmentid) {
        Objects.requireNonNull(appointmentid);
        this.appointmentid = appointmentid;
        return this;
    }

    @Override
     public BuildStep request(PaymenttoDoctor request) {
        Objects.requireNonNull(request);
        this.request = request;
        return this;
    }

    @Override
     public BuildStep paidtodoctordate(Temporal.DateTime paidtodoctordate) {
        this.paidtodoctordate = paidtodoctordate;
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
    private CopyOfBuilder(String id, com.amplifyframework.datastore.generated.model.PaymentRequestType paymentRequestType, String doctorId, Temporal.DateTime date, String appointmentid, PaymenttoDoctor request, Temporal.DateTime paidtodoctordate) {
      super.id(id);
      super.paymentRequestType(paymentRequestType)
        .doctorId(doctorId)
        .date(date)
        .appointmentid(appointmentid)
        .request(request)
        .paidtodoctordate(paidtodoctordate);
    }

    @Override
     public CopyOfBuilder paymentRequestType(com.amplifyframework.datastore.generated.model.PaymentRequestType paymentRequestType) {
      return (CopyOfBuilder) super.paymentRequestType(paymentRequestType);
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
     public CopyOfBuilder appointmentid(String appointmentid) {
      return (CopyOfBuilder) super.appointmentid(appointmentid);
    }
    
    @Override
     public CopyOfBuilder request(PaymenttoDoctor request) {
      return (CopyOfBuilder) super.request(request);
    }
    
    @Override
     public CopyOfBuilder paidtodoctordate(Temporal.DateTime paidtodoctordate) {
      return (CopyOfBuilder) super.paidtodoctordate(paidtodoctordate);
    }
  }
  
}
