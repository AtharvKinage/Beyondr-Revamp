package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import java.util.Objects;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Slots type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Slots")
public final class Slots implements Model {
  public static final QueryField ID = field("Slots", "id");
  public static final QueryField DOCTOR_ID = field("Slots", "doctorID");
  public static final QueryField CONSULTTIME = field("Slots", "consulttime");
  public static final QueryField STARTTIME = field("Slots", "starttime");
  public static final QueryField ENDTIME = field("Slots", "endtime");
  public static final QueryField CONSULTATIONFEES = field("Slots", "consultationfees");
  public static final QueryField CONULTATIONFESSCURRENCY = field("Slots", "conultationfesscurrency");
  public static final QueryField VIDEOCONSULTATIONS = field("Slots", "videoconsultations");
  public static final QueryField INPERSONCONSULTATION = field("Slots", "inpersonconsultation");
  public static final QueryField VIDEOANDINPERSONCONSULTATION = field("Slots", "videoandinpersonconsultation");
  public static final QueryField CONSULTATIONTIMEEDIT = field("Slots", "consultationtimeedit");
  public static final QueryField MONDAY = field("Slots", "monday");
  public static final QueryField TUESDAY = field("Slots", "tuesday");
  public static final QueryField WEDNESDAY = field("Slots", "wednesday");
  public static final QueryField THURSDAY = field("Slots", "thursday");
  public static final QueryField FRIDAY = field("Slots", "friday");
  public static final QueryField SATURDAY = field("Slots", "saturday");
  public static final QueryField SUNDAY = field("Slots", "sunday");
  public static final QueryField ACTIVEINACTIVE = field("Slots", "activeinactive");
  public static final QueryField DOCTORTYPE = field("Slots", "doctortype");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String doctorID;
  private final @ModelField(targetType="String", isRequired = true) String consulttime;
  private final @ModelField(targetType="String", isRequired = true) String starttime;
  private final @ModelField(targetType="String", isRequired = true) String endtime;
  private final @ModelField(targetType="String", isRequired = true) String consultationfees;
  private final @ModelField(targetType="String", isRequired = true) String conultationfesscurrency;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean videoconsultations;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean inpersonconsultation;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean videoandinpersonconsultation;
  private final @ModelField(targetType="String", isRequired = true) String consultationtimeedit;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean monday;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean tuesday;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean wednesday;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean thursday;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean friday;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean saturday;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean sunday;
  private final @ModelField(targetType="SlotActiveInactive")
  SlotActiveInactive activeinactive;
  private final @ModelField(targetType="DoctorType", isRequired = true)
  DoctorType doctortype;
  public String getId() {
      return id;
  }

  public String getDoctorId() {
      return doctorID;
  }

  public String getConsulttime() {
      return consulttime;
  }

  public String getStarttime() {
      return starttime;
  }

  public String getEndtime() {
      return endtime;
  }

  public String getConsultationfees() {
      return consultationfees;
  }

  public String getConultationfesscurrency() {
      return conultationfesscurrency;
  }

  public Boolean getVideoconsultations() {
      return videoconsultations;
  }

  public Boolean getInpersonconsultation() {
      return inpersonconsultation;
  }

  public Boolean getVideoandinpersonconsultation() {
      return videoandinpersonconsultation;
  }

  public String getConsultationtimeedit() {
      return consultationtimeedit;
  }

  public Boolean getMonday() {
      return monday;
  }

  public Boolean getTuesday() {
      return tuesday;
  }

  public Boolean getWednesday() {
      return wednesday;
  }

  public Boolean getThursday() {
      return thursday;
  }

  public Boolean getFriday() {
      return friday;
  }

  public Boolean getSaturday() {
      return saturday;
  }

  public Boolean getSunday() {
      return sunday;
  }

  public SlotActiveInactive getActiveinactive() {
      return activeinactive;
  }

  public DoctorType getDoctortype() {
      return doctortype;
  }

  private Slots(String id, String doctorID, String consulttime, String starttime, String endtime, String consultationfees, String conultationfesscurrency, Boolean videoconsultations, Boolean inpersonconsultation, Boolean videoandinpersonconsultation, String consultationtimeedit, Boolean monday, Boolean tuesday, Boolean wednesday, Boolean thursday, Boolean friday, Boolean saturday, Boolean sunday, SlotActiveInactive activeinactive, DoctorType doctortype) {
    this.id = id;
    this.doctorID = doctorID;
    this.consulttime = consulttime;
    this.starttime = starttime;
    this.endtime = endtime;
    this.consultationfees = consultationfees;
    this.conultationfesscurrency = conultationfesscurrency;
    this.videoconsultations = videoconsultations;
    this.inpersonconsultation = inpersonconsultation;
    this.videoandinpersonconsultation = videoandinpersonconsultation;
    this.consultationtimeedit = consultationtimeedit;
    this.monday = monday;
    this.tuesday = tuesday;
    this.wednesday = wednesday;
    this.thursday = thursday;
    this.friday = friday;
    this.saturday = saturday;
    this.sunday = sunday;
    this.activeinactive = activeinactive;
    this.doctortype = doctortype;
  }

  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Slots slots = (Slots) obj;
      return ObjectsCompat.equals(getId(), slots.getId()) &&
              ObjectsCompat.equals(getDoctorId(), slots.getDoctorId()) &&
              ObjectsCompat.equals(getConsulttime(), slots.getConsulttime()) &&
              ObjectsCompat.equals(getStarttime(), slots.getStarttime()) &&
              ObjectsCompat.equals(getEndtime(), slots.getEndtime()) &&
              ObjectsCompat.equals(getConsultationfees(), slots.getConsultationfees()) &&
              ObjectsCompat.equals(getConultationfesscurrency(), slots.getConultationfesscurrency()) &&
              ObjectsCompat.equals(getVideoconsultations(), slots.getVideoconsultations()) &&
              ObjectsCompat.equals(getInpersonconsultation(), slots.getInpersonconsultation()) &&
              ObjectsCompat.equals(getVideoandinpersonconsultation(), slots.getVideoandinpersonconsultation()) &&
              ObjectsCompat.equals(getConsultationtimeedit(), slots.getConsultationtimeedit()) &&
              ObjectsCompat.equals(getMonday(), slots.getMonday()) &&
              ObjectsCompat.equals(getTuesday(), slots.getTuesday()) &&
              ObjectsCompat.equals(getWednesday(), slots.getWednesday()) &&
              ObjectsCompat.equals(getThursday(), slots.getThursday()) &&
              ObjectsCompat.equals(getFriday(), slots.getFriday()) &&
              ObjectsCompat.equals(getSaturday(), slots.getSaturday()) &&
              ObjectsCompat.equals(getSunday(), slots.getSunday()) &&
              ObjectsCompat.equals(getActiveinactive(), slots.getActiveinactive()) &&
              ObjectsCompat.equals(getDoctortype(), slots.getDoctortype());
      }
  }

  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDoctorId())
      .append(getConsulttime())
      .append(getStarttime())
      .append(getEndtime())
      .append(getConsultationfees())
      .append(getConultationfesscurrency())
      .append(getVideoconsultations())
      .append(getInpersonconsultation())
      .append(getVideoandinpersonconsultation())
      .append(getConsultationtimeedit())
      .append(getMonday())
      .append(getTuesday())
      .append(getWednesday())
      .append(getThursday())
      .append(getFriday())
      .append(getSaturday())
      .append(getSunday())
      .append(getActiveinactive())
      .append(getDoctortype())
      .toString()
      .hashCode();
  }

  @Override
   public String toString() {
    return new StringBuilder()
      .append("Slots {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("doctorID=" + String.valueOf(getDoctorId()) + ", ")
      .append("consulttime=" + String.valueOf(getConsulttime()) + ", ")
      .append("starttime=" + String.valueOf(getStarttime()) + ", ")
      .append("endtime=" + String.valueOf(getEndtime()) + ", ")
      .append("consultationfees=" + String.valueOf(getConsultationfees()) + ", ")
      .append("conultationfesscurrency=" + String.valueOf(getConultationfesscurrency()) + ", ")
      .append("videoconsultations=" + String.valueOf(getVideoconsultations()) + ", ")
      .append("inpersonconsultation=" + String.valueOf(getInpersonconsultation()) + ", ")
      .append("videoandinpersonconsultation=" + String.valueOf(getVideoandinpersonconsultation()) + ", ")
      .append("consultationtimeedit=" + String.valueOf(getConsultationtimeedit()) + ", ")
      .append("monday=" + String.valueOf(getMonday()) + ", ")
      .append("tuesday=" + String.valueOf(getTuesday()) + ", ")
      .append("wednesday=" + String.valueOf(getWednesday()) + ", ")
      .append("thursday=" + String.valueOf(getThursday()) + ", ")
      .append("friday=" + String.valueOf(getFriday()) + ", ")
      .append("saturday=" + String.valueOf(getSaturday()) + ", ")
      .append("sunday=" + String.valueOf(getSunday()) + ", ")
      .append("activeinactive=" + String.valueOf(getActiveinactive()) + ", ")
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
  public static Slots justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Slots(
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
      null
    );
  }

  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      doctorID,
      consulttime,
      starttime,
      endtime,
      consultationfees,
      conultationfesscurrency,
      videoconsultations,
      inpersonconsultation,
      videoandinpersonconsultation,
      consultationtimeedit,
      monday,
      tuesday,
      wednesday,
      thursday,
      friday,
      saturday,
      sunday,
      activeinactive,
      doctortype);
  }
  public interface DoctorIdStep {
    ConsulttimeStep doctorId(String doctorId);
  }


  public interface ConsulttimeStep {
    StarttimeStep consulttime(String consulttime);
  }


  public interface StarttimeStep {
    EndtimeStep starttime(String starttime);
  }


  public interface EndtimeStep {
    ConsultationfeesStep endtime(String endtime);
  }


  public interface ConsultationfeesStep {
    ConultationfesscurrencyStep consultationfees(String consultationfees);
  }


  public interface ConultationfesscurrencyStep {
    VideoconsultationsStep conultationfesscurrency(String conultationfesscurrency);
  }


  public interface VideoconsultationsStep {
    InpersonconsultationStep videoconsultations(Boolean videoconsultations);
  }


  public interface InpersonconsultationStep {
    VideoandinpersonconsultationStep inpersonconsultation(Boolean inpersonconsultation);
  }


  public interface VideoandinpersonconsultationStep {
    ConsultationtimeeditStep videoandinpersonconsultation(Boolean videoandinpersonconsultation);
  }


  public interface ConsultationtimeeditStep {
    MondayStep consultationtimeedit(String consultationtimeedit);
  }


  public interface MondayStep {
    TuesdayStep monday(Boolean monday);
  }


  public interface TuesdayStep {
    WednesdayStep tuesday(Boolean tuesday);
  }


  public interface WednesdayStep {
    ThursdayStep wednesday(Boolean wednesday);
  }


  public interface ThursdayStep {
    FridayStep thursday(Boolean thursday);
  }


  public interface FridayStep {
    SaturdayStep friday(Boolean friday);
  }


  public interface SaturdayStep {
    SundayStep saturday(Boolean saturday);
  }


  public interface SundayStep {
    DoctortypeStep sunday(Boolean sunday);
  }


  public interface DoctortypeStep {
    BuildStep doctortype(DoctorType doctortype);
  }


  public interface BuildStep {
    Slots build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep activeinactive(SlotActiveInactive activeinactive);
  }


  public static class Builder implements DoctorIdStep, ConsulttimeStep, StarttimeStep, EndtimeStep, ConsultationfeesStep, ConultationfesscurrencyStep, VideoconsultationsStep, InpersonconsultationStep, VideoandinpersonconsultationStep, ConsultationtimeeditStep, MondayStep, TuesdayStep, WednesdayStep, ThursdayStep, FridayStep, SaturdayStep, SundayStep, DoctortypeStep, BuildStep {
    private String id;
    private String doctorID;
    private String consulttime;
    private String starttime;
    private String endtime;
    private String consultationfees;
    private String conultationfesscurrency;
    private Boolean videoconsultations;
    private Boolean inpersonconsultation;
    private Boolean videoandinpersonconsultation;
    private String consultationtimeedit;
    private Boolean monday;
    private Boolean tuesday;
    private Boolean wednesday;
    private Boolean thursday;
    private Boolean friday;
    private Boolean saturday;
    private Boolean sunday;
    private DoctorType doctortype;
    private SlotActiveInactive activeinactive;
    @Override
     public Slots build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();

        return new Slots(
          id,
          doctorID,
          consulttime,
          starttime,
          endtime,
          consultationfees,
          conultationfesscurrency,
          videoconsultations,
          inpersonconsultation,
          videoandinpersonconsultation,
          consultationtimeedit,
          monday,
          tuesday,
          wednesday,
          thursday,
          friday,
          saturday,
          sunday,
          activeinactive,
          doctortype);
    }

    @Override
     public ConsulttimeStep doctorId(String doctorId) {
        Objects.requireNonNull(doctorId);
        this.doctorID = doctorId;
        return this;
    }

    @Override
     public StarttimeStep consulttime(String consulttime) {
        Objects.requireNonNull(consulttime);
        this.consulttime = consulttime;
        return this;
    }

    @Override
     public EndtimeStep starttime(String starttime) {
        Objects.requireNonNull(starttime);
        this.starttime = starttime;
        return this;
    }

    @Override
     public ConsultationfeesStep endtime(String endtime) {
        Objects.requireNonNull(endtime);
        this.endtime = endtime;
        return this;
    }

    @Override
     public ConultationfesscurrencyStep consultationfees(String consultationfees) {
        Objects.requireNonNull(consultationfees);
        this.consultationfees = consultationfees;
        return this;
    }

    @Override
     public VideoconsultationsStep conultationfesscurrency(String conultationfesscurrency) {
        Objects.requireNonNull(conultationfesscurrency);
        this.conultationfesscurrency = conultationfesscurrency;
        return this;
    }

    @Override
     public InpersonconsultationStep videoconsultations(Boolean videoconsultations) {
        Objects.requireNonNull(videoconsultations);
        this.videoconsultations = videoconsultations;
        return this;
    }

    @Override
     public VideoandinpersonconsultationStep inpersonconsultation(Boolean inpersonconsultation) {
        Objects.requireNonNull(inpersonconsultation);
        this.inpersonconsultation = inpersonconsultation;
        return this;
    }

    @Override
     public ConsultationtimeeditStep videoandinpersonconsultation(Boolean videoandinpersonconsultation) {
        Objects.requireNonNull(videoandinpersonconsultation);
        this.videoandinpersonconsultation = videoandinpersonconsultation;
        return this;
    }

    @Override
     public MondayStep consultationtimeedit(String consultationtimeedit) {
        Objects.requireNonNull(consultationtimeedit);
        this.consultationtimeedit = consultationtimeedit;
        return this;
    }

    @Override
     public TuesdayStep monday(Boolean monday) {
        Objects.requireNonNull(monday);
        this.monday = monday;
        return this;
    }

    @Override
     public WednesdayStep tuesday(Boolean tuesday) {
        Objects.requireNonNull(tuesday);
        this.tuesday = tuesday;
        return this;
    }

    @Override
     public ThursdayStep wednesday(Boolean wednesday) {
        Objects.requireNonNull(wednesday);
        this.wednesday = wednesday;
        return this;
    }

    @Override
     public FridayStep thursday(Boolean thursday) {
        Objects.requireNonNull(thursday);
        this.thursday = thursday;
        return this;
    }

    @Override
     public SaturdayStep friday(Boolean friday) {
        Objects.requireNonNull(friday);
        this.friday = friday;
        return this;
    }

    @Override
     public SundayStep saturday(Boolean saturday) {
        Objects.requireNonNull(saturday);
        this.saturday = saturday;
        return this;
    }

    @Override
     public DoctortypeStep sunday(Boolean sunday) {
        Objects.requireNonNull(sunday);
        this.sunday = sunday;
        return this;
    }

    @Override
     public BuildStep doctortype(DoctorType doctortype) {
        Objects.requireNonNull(doctortype);
        this.doctortype = doctortype;
        return this;
    }

    @Override
     public BuildStep activeinactive(SlotActiveInactive activeinactive) {
        this.activeinactive = activeinactive;
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
    private CopyOfBuilder(String id, String doctorId, String consulttime, String starttime, String endtime, String consultationfees, String conultationfesscurrency, Boolean videoconsultations, Boolean inpersonconsultation, Boolean videoandinpersonconsultation, String consultationtimeedit, Boolean monday, Boolean tuesday, Boolean wednesday, Boolean thursday, Boolean friday, Boolean saturday, Boolean sunday, SlotActiveInactive activeinactive, DoctorType doctortype) {
      super.id(id);
      super.doctorId(doctorId)
        .consulttime(consulttime)
        .starttime(starttime)
        .endtime(endtime)
        .consultationfees(consultationfees)
        .conultationfesscurrency(conultationfesscurrency)
        .videoconsultations(videoconsultations)
        .inpersonconsultation(inpersonconsultation)
        .videoandinpersonconsultation(videoandinpersonconsultation)
        .consultationtimeedit(consultationtimeedit)
        .monday(monday)
        .tuesday(tuesday)
        .wednesday(wednesday)
        .thursday(thursday)
        .friday(friday)
        .saturday(saturday)
        .sunday(sunday)
        .doctortype(doctortype)
        .activeinactive(activeinactive);
    }
    
    @Override
     public CopyOfBuilder doctorId(String doctorId) {
      return (CopyOfBuilder) super.doctorId(doctorId);
    }
    
    @Override
     public CopyOfBuilder consulttime(String consulttime) {
      return (CopyOfBuilder) super.consulttime(consulttime);
    }
    
    @Override
     public CopyOfBuilder starttime(String starttime) {
      return (CopyOfBuilder) super.starttime(starttime);
    }
    
    @Override
     public CopyOfBuilder endtime(String endtime) {
      return (CopyOfBuilder) super.endtime(endtime);
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
     public CopyOfBuilder videoconsultations(Boolean videoconsultations) {
      return (CopyOfBuilder) super.videoconsultations(videoconsultations);
    }
    
    @Override
     public CopyOfBuilder inpersonconsultation(Boolean inpersonconsultation) {
      return (CopyOfBuilder) super.inpersonconsultation(inpersonconsultation);
    }
    
    @Override
     public CopyOfBuilder videoandinpersonconsultation(Boolean videoandinpersonconsultation) {
      return (CopyOfBuilder) super.videoandinpersonconsultation(videoandinpersonconsultation);
    }
    
    @Override
     public CopyOfBuilder consultationtimeedit(String consultationtimeedit) {
      return (CopyOfBuilder) super.consultationtimeedit(consultationtimeedit);
    }
    
    @Override
     public CopyOfBuilder monday(Boolean monday) {
      return (CopyOfBuilder) super.monday(monday);
    }
    
    @Override
     public CopyOfBuilder tuesday(Boolean tuesday) {
      return (CopyOfBuilder) super.tuesday(tuesday);
    }
    
    @Override
     public CopyOfBuilder wednesday(Boolean wednesday) {
      return (CopyOfBuilder) super.wednesday(wednesday);
    }
    
    @Override
     public CopyOfBuilder thursday(Boolean thursday) {
      return (CopyOfBuilder) super.thursday(thursday);
    }
    
    @Override
     public CopyOfBuilder friday(Boolean friday) {
      return (CopyOfBuilder) super.friday(friday);
    }
    
    @Override
     public CopyOfBuilder saturday(Boolean saturday) {
      return (CopyOfBuilder) super.saturday(saturday);
    }
    
    @Override
     public CopyOfBuilder sunday(Boolean sunday) {
      return (CopyOfBuilder) super.sunday(sunday);
    }
    
    @Override
     public CopyOfBuilder doctortype(DoctorType doctortype) {
      return (CopyOfBuilder) super.doctortype(doctortype);
    }
    
    @Override
     public CopyOfBuilder activeinactive(SlotActiveInactive activeinactive) {
      return (CopyOfBuilder) super.activeinactive(activeinactive);
    }
  }
  
}
