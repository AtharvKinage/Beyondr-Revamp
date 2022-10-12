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

/** This is an auto generated class representing the Appointment type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Appointments")
@Index(name = "byAppointment", fields = {"userID"})
@Index(name = "byAppointmentID", fields = {"doctorID"})
public final class Appointment implements Model {
  public static final QueryField ID = field("Appointment", "id");
  public static final QueryField USER_ID = field("Appointment", "userID");
  public static final QueryField DOCTOR_ID = field("Appointment", "doctorID");
  public static final QueryField PAYMENT_MODE = field("Appointment", "paymentMode");
  public static final QueryField PACKAGEBUYID = field("Appointment", "packagebuyid");
  public static final QueryField CONSULTATIONFEES = field("Appointment", "consultationfees");
  public static final QueryField PAYMENT_COMPLETION_STATUS = field("Appointment", "PaymentCompletionStatus");
  public static final QueryField CONULTATIONFESSCURRENCY = field("Appointment", "conultationfesscurrency");
  public static final QueryField STARTTIME = field("Appointment", "starttime");
  public static final QueryField SLOTTIME = field("Appointment", "slottime");
  public static final QueryField DATE = field("Appointment", "date");
  public static final QueryField MEETINGID = field("Appointment", "meetingid");
  public static final QueryField STATUS = field("Appointment", "status");
  public static final QueryField REQUEST = field("Appointment", "request");
  public static final QueryField MESSAGE = field("Appointment", "message");
  public static final QueryField PERSONAL_CONSULT = field("Appointment", "personalConsult");
  public static final QueryField VIDEOCONSULT = field("Appointment", "videoconsult");
  public static final QueryField CANCELLEDBYUSER = field("Appointment", "cancelledbyuser");
  public static final QueryField CANCELLATIONDATE = field("Appointment", "cancellationdate");
  public static final QueryField CANCELLEDBYDOCTOR = field("Appointment", "cancelledbydoctor");
  public static final QueryField DOCTORTYPE = field("Appointment", "doctortype");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String userID;
  private final @ModelField(targetType="ID", isRequired = true) String doctorID;
  private final @ModelField(targetType="PaymentMode")
  PaymentMode paymentMode;
  private final @ModelField(targetType="ID") String packagebuyid;
  private final @ModelField(targetType="String", isRequired = true) String consultationfees;
  private final @ModelField(targetType="PaymentCompletionStatus", isRequired = true)
  com.amplifyframework.datastore.generated.model.PaymentCompletionStatus PaymentCompletionStatus;
  private final @ModelField(targetType="String", isRequired = true) String conultationfesscurrency;
  private final @ModelField(targetType="String", isRequired = true) String starttime;
  private final @ModelField(targetType="String", isRequired = true) String slottime;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  private final @ModelField(targetType="ID", isRequired = true) String meetingid;
  private final @ModelField(targetType="Status", isRequired = true)
  Status status;
  private final @ModelField(targetType="Request", isRequired = true)
  Request request;
  private final @ModelField(targetType="String") String message;
  private final @ModelField(targetType="Boolean") Boolean personalConsult;
  private final @ModelField(targetType="Boolean") Boolean videoconsult;
  private final @ModelField(targetType="Boolean") Boolean cancelledbyuser;
  private final @ModelField(targetType="AWSDateTime") Temporal.DateTime cancellationdate;
  private final @ModelField(targetType="Boolean") Boolean cancelledbydoctor;
  private final @ModelField(targetType="DoctorType", isRequired = true)
  DoctorType doctortype;
  public String getId() {
      return id;
  }

  public String getUserId() {
      return userID;
  }

  public String getDoctorId() {
      return doctorID;
  }

  public PaymentMode getPaymentMode() {
      return paymentMode;
  }

  public String getPackagebuyid() {
      return packagebuyid;
  }

  public String getConsultationfees() {
      return consultationfees;
  }

  public com.amplifyframework.datastore.generated.model.PaymentCompletionStatus getPaymentCompletionStatus() {
      return PaymentCompletionStatus;
  }

  public String getConultationfesscurrency() {
      return conultationfesscurrency;
  }

  public String getStarttime() {
      return starttime;
  }

  public String getSlottime() {
      return slottime;
  }

  public Temporal.DateTime getDate() {
      return date;
  }

  public String getMeetingid() {
      return meetingid;
  }

  public Status getStatus() {
      return status;
  }

  public Request getRequest() {
      return request;
  }

  public String getMessage() {
      return message;
  }

  public Boolean getPersonalConsult() {
      return personalConsult;
  }

  public Boolean getVideoconsult() {
      return videoconsult;
  }

  public Boolean getCancelledbyuser() {
      return cancelledbyuser;
  }

  public Temporal.DateTime getCancellationdate() {
      return cancellationdate;
  }

  public Boolean getCancelledbydoctor() {
      return cancelledbydoctor;
  }

  public DoctorType getDoctortype() {
      return doctortype;
  }

  private Appointment(String id, String userID, String doctorID, PaymentMode paymentMode, String packagebuyid, String consultationfees, com.amplifyframework.datastore.generated.model.PaymentCompletionStatus PaymentCompletionStatus, String conultationfesscurrency, String starttime, String slottime, Temporal.DateTime date, String meetingid, Status status, Request request, String message, Boolean personalConsult, Boolean videoconsult, Boolean cancelledbyuser, Temporal.DateTime cancellationdate, Boolean cancelledbydoctor, DoctorType doctortype) {
    this.id = id;
    this.userID = userID;
    this.doctorID = doctorID;
    this.paymentMode = paymentMode;
    this.packagebuyid = packagebuyid;
    this.consultationfees = consultationfees;
    this.PaymentCompletionStatus = PaymentCompletionStatus;
    this.conultationfesscurrency = conultationfesscurrency;
    this.starttime = starttime;
    this.slottime = slottime;
    this.date = date;
    this.meetingid = meetingid;
    this.status = status;
    this.request = request;
    this.message = message;
    this.personalConsult = personalConsult;
    this.videoconsult = videoconsult;
    this.cancelledbyuser = cancelledbyuser;
    this.cancellationdate = cancellationdate;
    this.cancelledbydoctor = cancelledbydoctor;
    this.doctortype = doctortype;
  }

  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Appointment appointment = (Appointment) obj;
      return ObjectsCompat.equals(getId(), appointment.getId()) &&
              ObjectsCompat.equals(getUserId(), appointment.getUserId()) &&
              ObjectsCompat.equals(getDoctorId(), appointment.getDoctorId()) &&
              ObjectsCompat.equals(getPaymentMode(), appointment.getPaymentMode()) &&
              ObjectsCompat.equals(getPackagebuyid(), appointment.getPackagebuyid()) &&
              ObjectsCompat.equals(getConsultationfees(), appointment.getConsultationfees()) &&
              ObjectsCompat.equals(getPaymentCompletionStatus(), appointment.getPaymentCompletionStatus()) &&
              ObjectsCompat.equals(getConultationfesscurrency(), appointment.getConultationfesscurrency()) &&
              ObjectsCompat.equals(getStarttime(), appointment.getStarttime()) &&
              ObjectsCompat.equals(getSlottime(), appointment.getSlottime()) &&
              ObjectsCompat.equals(getDate(), appointment.getDate()) &&
              ObjectsCompat.equals(getMeetingid(), appointment.getMeetingid()) &&
              ObjectsCompat.equals(getStatus(), appointment.getStatus()) &&
              ObjectsCompat.equals(getRequest(), appointment.getRequest()) &&
              ObjectsCompat.equals(getMessage(), appointment.getMessage()) &&
              ObjectsCompat.equals(getPersonalConsult(), appointment.getPersonalConsult()) &&
              ObjectsCompat.equals(getVideoconsult(), appointment.getVideoconsult()) &&
              ObjectsCompat.equals(getCancelledbyuser(), appointment.getCancelledbyuser()) &&
              ObjectsCompat.equals(getCancellationdate(), appointment.getCancellationdate()) &&
              ObjectsCompat.equals(getCancelledbydoctor(), appointment.getCancelledbydoctor()) &&
              ObjectsCompat.equals(getDoctortype(), appointment.getDoctortype());
      }
  }

  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUserId())
      .append(getDoctorId())
      .append(getPaymentMode())
      .append(getPackagebuyid())
      .append(getConsultationfees())
      .append(getPaymentCompletionStatus())
      .append(getConultationfesscurrency())
      .append(getStarttime())
      .append(getSlottime())
      .append(getDate())
      .append(getMeetingid())
      .append(getStatus())
      .append(getRequest())
      .append(getMessage())
      .append(getPersonalConsult())
      .append(getVideoconsult())
      .append(getCancelledbyuser())
      .append(getCancellationdate())
      .append(getCancelledbydoctor())
      .append(getDoctortype())
      .toString()
      .hashCode();
  }

  @Override
   public String toString() {
    return new StringBuilder()
      .append("Appointment {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("userID=" + String.valueOf(getUserId()) + ", ")
      .append("doctorID=" + String.valueOf(getDoctorId()) + ", ")
      .append("paymentMode=" + String.valueOf(getPaymentMode()) + ", ")
      .append("packagebuyid=" + String.valueOf(getPackagebuyid()) + ", ")
      .append("consultationfees=" + String.valueOf(getConsultationfees()) + ", ")
      .append("PaymentCompletionStatus=" + String.valueOf(getPaymentCompletionStatus()) + ", ")
      .append("conultationfesscurrency=" + String.valueOf(getConultationfesscurrency()) + ", ")
      .append("starttime=" + String.valueOf(getStarttime()) + ", ")
      .append("slottime=" + String.valueOf(getSlottime()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("meetingid=" + String.valueOf(getMeetingid()) + ", ")
      .append("status=" + String.valueOf(getStatus()) + ", ")
      .append("request=" + String.valueOf(getRequest()) + ", ")
      .append("message=" + String.valueOf(getMessage()) + ", ")
      .append("personalConsult=" + String.valueOf(getPersonalConsult()) + ", ")
      .append("videoconsult=" + String.valueOf(getVideoconsult()) + ", ")
      .append("cancelledbyuser=" + String.valueOf(getCancelledbyuser()) + ", ")
      .append("cancellationdate=" + String.valueOf(getCancellationdate()) + ", ")
      .append("cancelledbydoctor=" + String.valueOf(getCancelledbydoctor()) + ", ")
      .append("doctortype=" + String.valueOf(getDoctortype()))
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
  public static Appointment justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Appointment(
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
      userID,
      doctorID,
      paymentMode,
      packagebuyid,
      consultationfees,
      PaymentCompletionStatus,
      conultationfesscurrency,
      starttime,
      slottime,
      date,
      meetingid,
      status,
      request,
      message,
      personalConsult,
      videoconsult,
      cancelledbyuser,
      cancellationdate,
      cancelledbydoctor,
      doctortype);
  }
  public interface UserIdStep {
    DoctorIdStep userId(String userId);
  }


  public interface DoctorIdStep {
    ConsultationfeesStep doctorId(String doctorId);
  }


  public interface ConsultationfeesStep {
    PaymentCompletionStatusStep consultationfees(String consultationfees);
  }


  public interface PaymentCompletionStatusStep {
    ConultationfesscurrencyStep paymentCompletionStatus(com.amplifyframework.datastore.generated.model.PaymentCompletionStatus paymentCompletionStatus);
  }


  public interface ConultationfesscurrencyStep {
    StarttimeStep conultationfesscurrency(String conultationfesscurrency);
  }


  public interface StarttimeStep {
    SlottimeStep starttime(String starttime);
  }


  public interface SlottimeStep {
    DateStep slottime(String slottime);
  }


  public interface DateStep {
    MeetingidStep date(Temporal.DateTime date);
  }


  public interface MeetingidStep {
    StatusStep meetingid(String meetingid);
  }


  public interface StatusStep {
    RequestStep status(Status status);
  }


  public interface RequestStep {
    DoctortypeStep request(Request request);
  }


  public interface DoctortypeStep {
    BuildStep doctortype(DoctorType doctortype);
  }


  public interface BuildStep {
    Appointment build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep paymentMode(PaymentMode paymentMode);
    BuildStep packagebuyid(String packagebuyid);
    BuildStep message(String message);
    BuildStep personalConsult(Boolean personalConsult);
    BuildStep videoconsult(Boolean videoconsult);
    BuildStep cancelledbyuser(Boolean cancelledbyuser);
    BuildStep cancellationdate(Temporal.DateTime cancellationdate);
    BuildStep cancelledbydoctor(Boolean cancelledbydoctor);
  }


  public static class Builder implements UserIdStep, DoctorIdStep, ConsultationfeesStep, PaymentCompletionStatusStep, ConultationfesscurrencyStep, StarttimeStep, SlottimeStep, DateStep, MeetingidStep, StatusStep, RequestStep, DoctortypeStep, BuildStep {
    private String id;
    private String userID;
    private String doctorID;
    private String consultationfees;
    private com.amplifyframework.datastore.generated.model.PaymentCompletionStatus PaymentCompletionStatus;
    private String conultationfesscurrency;
    private String starttime;
    private String slottime;
    private Temporal.DateTime date;
    private String meetingid;
    private Status status;
    private Request request;
    private DoctorType doctortype;
    private PaymentMode paymentMode;
    private String packagebuyid;
    private String message;
    private Boolean personalConsult;
    private Boolean videoconsult;
    private Boolean cancelledbyuser;
    private Temporal.DateTime cancellationdate;
    private Boolean cancelledbydoctor;
    @Override
     public Appointment build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();

        return new Appointment(
          id,
          userID,
          doctorID,
          paymentMode,
          packagebuyid,
          consultationfees,
          PaymentCompletionStatus,
          conultationfesscurrency,
          starttime,
          slottime,
          date,
          meetingid,
          status,
          request,
          message,
          personalConsult,
          videoconsult,
          cancelledbyuser,
          cancellationdate,
          cancelledbydoctor,
          doctortype);
    }

    @Override
     public DoctorIdStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.userID = userId;
        return this;
    }

    @Override
     public ConsultationfeesStep doctorId(String doctorId) {
        Objects.requireNonNull(doctorId);
        this.doctorID = doctorId;
        return this;
    }

    @Override
     public PaymentCompletionStatusStep consultationfees(String consultationfees) {
        Objects.requireNonNull(consultationfees);
        this.consultationfees = consultationfees;
        return this;
    }

    @Override
     public ConultationfesscurrencyStep paymentCompletionStatus(com.amplifyframework.datastore.generated.model.PaymentCompletionStatus paymentCompletionStatus) {
        Objects.requireNonNull(paymentCompletionStatus);
        this.PaymentCompletionStatus = paymentCompletionStatus;
        return this;
    }

    @Override
     public StarttimeStep conultationfesscurrency(String conultationfesscurrency) {
        Objects.requireNonNull(conultationfesscurrency);
        this.conultationfesscurrency = conultationfesscurrency;
        return this;
    }

    @Override
     public SlottimeStep starttime(String starttime) {
        Objects.requireNonNull(starttime);
        this.starttime = starttime;
        return this;
    }

    @Override
     public DateStep slottime(String slottime) {
        Objects.requireNonNull(slottime);
        this.slottime = slottime;
        return this;
    }

    @Override
     public MeetingidStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }

    @Override
     public StatusStep meetingid(String meetingid) {
        Objects.requireNonNull(meetingid);
        this.meetingid = meetingid;
        return this;
    }

    @Override
     public RequestStep status(Status status) {
        Objects.requireNonNull(status);
        this.status = status;
        return this;
    }

    @Override
     public DoctortypeStep request(Request request) {
        Objects.requireNonNull(request);
        this.request = request;
        return this;
    }

    @Override
     public BuildStep doctortype(DoctorType doctortype) {
        Objects.requireNonNull(doctortype);
        this.doctortype = doctortype;
        return this;
    }

    @Override
     public BuildStep paymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
        return this;
    }

    @Override
     public BuildStep packagebuyid(String packagebuyid) {
        this.packagebuyid = packagebuyid;
        return this;
    }

    @Override
     public BuildStep message(String message) {
        this.message = message;
        return this;
    }

    @Override
     public BuildStep personalConsult(Boolean personalConsult) {
        this.personalConsult = personalConsult;
        return this;
    }

    @Override
     public BuildStep videoconsult(Boolean videoconsult) {
        this.videoconsult = videoconsult;
        return this;
    }

    @Override
     public BuildStep cancelledbyuser(Boolean cancelledbyuser) {
        this.cancelledbyuser = cancelledbyuser;
        return this;
    }

    @Override
     public BuildStep cancellationdate(Temporal.DateTime cancellationdate) {
        this.cancellationdate = cancellationdate;
        return this;
    }

    @Override
     public BuildStep cancelledbydoctor(Boolean cancelledbydoctor) {
        this.cancelledbydoctor = cancelledbydoctor;
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
    private CopyOfBuilder(String id, String userId, String doctorId, PaymentMode paymentMode, String packagebuyid, String consultationfees, com.amplifyframework.datastore.generated.model.PaymentCompletionStatus paymentCompletionStatus, String conultationfesscurrency, String starttime, String slottime, Temporal.DateTime date, String meetingid, Status status, Request request, String message, Boolean personalConsult, Boolean videoconsult, Boolean cancelledbyuser, Temporal.DateTime cancellationdate, Boolean cancelledbydoctor, DoctorType doctortype) {
      super.id(id);
      super.userId(userId)
        .doctorId(doctorId)
        .consultationfees(consultationfees)
        .paymentCompletionStatus(paymentCompletionStatus)
        .conultationfesscurrency(conultationfesscurrency)
        .starttime(starttime)
        .slottime(slottime)
        .date(date)
        .meetingid(meetingid)
        .status(status)
        .request(request)
        .doctortype(doctortype)
        .paymentMode(paymentMode)
        .packagebuyid(packagebuyid)
        .message(message)
        .personalConsult(personalConsult)
        .videoconsult(videoconsult)
        .cancelledbyuser(cancelledbyuser)
        .cancellationdate(cancellationdate)
        .cancelledbydoctor(cancelledbydoctor);
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
     public CopyOfBuilder consultationfees(String consultationfees) {
      return (CopyOfBuilder) super.consultationfees(consultationfees);
    }
    
    @Override
     public CopyOfBuilder paymentCompletionStatus(com.amplifyframework.datastore.generated.model.PaymentCompletionStatus paymentCompletionStatus) {
      return (CopyOfBuilder) super.paymentCompletionStatus(paymentCompletionStatus);
    }
    
    @Override
     public CopyOfBuilder conultationfesscurrency(String conultationfesscurrency) {
      return (CopyOfBuilder) super.conultationfesscurrency(conultationfesscurrency);
    }
    
    @Override
     public CopyOfBuilder starttime(String starttime) {
      return (CopyOfBuilder) super.starttime(starttime);
    }
    
    @Override
     public CopyOfBuilder slottime(String slottime) {
      return (CopyOfBuilder) super.slottime(slottime);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder meetingid(String meetingid) {
      return (CopyOfBuilder) super.meetingid(meetingid);
    }
    
    @Override
     public CopyOfBuilder status(Status status) {
      return (CopyOfBuilder) super.status(status);
    }
    
    @Override
     public CopyOfBuilder request(Request request) {
      return (CopyOfBuilder) super.request(request);
    }
    
    @Override
     public CopyOfBuilder doctortype(DoctorType doctortype) {
      return (CopyOfBuilder) super.doctortype(doctortype);
    }
    
    @Override
     public CopyOfBuilder paymentMode(PaymentMode paymentMode) {
      return (CopyOfBuilder) super.paymentMode(paymentMode);
    }
    
    @Override
     public CopyOfBuilder packagebuyid(String packagebuyid) {
      return (CopyOfBuilder) super.packagebuyid(packagebuyid);
    }
    
    @Override
     public CopyOfBuilder message(String message) {
      return (CopyOfBuilder) super.message(message);
    }
    
    @Override
     public CopyOfBuilder personalConsult(Boolean personalConsult) {
      return (CopyOfBuilder) super.personalConsult(personalConsult);
    }
    
    @Override
     public CopyOfBuilder videoconsult(Boolean videoconsult) {
      return (CopyOfBuilder) super.videoconsult(videoconsult);
    }
    
    @Override
     public CopyOfBuilder cancelledbyuser(Boolean cancelledbyuser) {
      return (CopyOfBuilder) super.cancelledbyuser(cancelledbyuser);
    }
    
    @Override
     public CopyOfBuilder cancellationdate(Temporal.DateTime cancellationdate) {
      return (CopyOfBuilder) super.cancellationdate(cancellationdate);
    }
    
    @Override
     public CopyOfBuilder cancelledbydoctor(Boolean cancelledbydoctor) {
      return (CopyOfBuilder) super.cancelledbydoctor(cancelledbydoctor);
    }
  }
  
}
