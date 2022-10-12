package com.amplifyframework.datastore.generated.model;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Doctor type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Doctors")
@Index(name = "bydoctor", fields = {"UserID"})
public final class Doctor implements Model {
  public static final QueryField ID = field("Doctor", "id");
  public static final QueryField USER_ID = field("Doctor", "UserID");
  public static final QueryField DOCTORTYPE = field("Doctor", "doctortype");
  public static final QueryField NAME = field("Doctor", "name");
  public static final QueryField ABOUT = field("Doctor", "about");
  public static final QueryField NPI = field("Doctor", "npi");
  public static final QueryField LANGUAGESSPOKEN = field("Doctor", "languagesspoken");
  public static final QueryField COUNTRY = field("Doctor", "country");
  public static final QueryField LOCALADDRESS = field("Doctor", "localaddress");
  public static final QueryField PAYCUT = field("Doctor", "paycut");
  public static final QueryField STATE = field("Doctor", "state");
  public static final QueryField ZIPCODE = field("Doctor", "zipcode");
  public static final QueryField SPECIALIZATION = field("Doctor", "specialization");
  public static final QueryField YEARSOFEXXPERIENCE = field("Doctor", "yearsofexxperience");
  public static final QueryField GENDER = field("Doctor", "gender");
  public static final QueryField STATUS = field("Doctor", "status");
  public static final QueryField INSURANCE = field("Doctor", "insurance");
  public static final QueryField OFFLINECONSULTATION = field("Doctor", "offlineconsultation");
  public static final QueryField APPOINTMENTSCOMPLETED = field("Doctor", "appointmentscompleted");
  public static final QueryField VIEWSONPROFILE = field("Doctor", "viewsonprofile");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String UserID;
  private final @ModelField(targetType="DoctorType", isRequired = true)
  DoctorType doctortype;
  private final @ModelField(targetType="String") String name;
  private final @ModelField(targetType="String") String about;
  private final @ModelField(targetType="String") String npi;
  private final @ModelField(targetType="String") String languagesspoken;
  private final @ModelField(targetType="String") String country;
  private final @ModelField(targetType="String") String localaddress;
  private final @ModelField(targetType="String", isRequired = true) String paycut;
  private final @ModelField(targetType="String") String state;
  private final @ModelField(targetType="String") String zipcode;
  private final @ModelField(targetType="String") String specialization;
  private final @ModelField(targetType="String") String yearsofexxperience;
  private final @ModelField(targetType="String") String gender;
  private final @ModelField(targetType="DoctorProfileReview", isRequired = true)
  DoctorProfileReview status;
  private final @ModelField(targetType="String") String insurance;
  private final @ModelField(targetType="Boolean") Boolean offlineconsultation;
  private final @ModelField(targetType="String", isRequired = true) String appointmentscompleted;
  private final @ModelField(targetType="String", isRequired = true) String viewsonprofile;
  private final @ModelField(targetType="Education") @HasMany(associatedWith = "doctorID", type = Education.class) List<Education> education = null;
  private final @ModelField(targetType="Experience") @HasMany(associatedWith = "doctorID", type = Experience.class) List<Experience> experience = null;
  private final @ModelField(targetType="Certificates") @HasMany(associatedWith = "doctorID", type = Certificates.class) List<Certificates> certificates = null;
  private final @ModelField(targetType="Appointment") @HasMany(associatedWith = "doctorID", type = Appointment.class) List<Appointment> appointment = null;
  private final @ModelField(targetType="Message") @HasMany(associatedWith = "DoctorsID", type = Message.class) List<Message> message = null;
  public String getId() {
      return id;
  }

  public String getUserId() {
      return UserID;
  }

  public DoctorType getDoctortype() {
      return doctortype;
  }

  public String getName() {
      return name;
  }

  public String getAbout() {
      return about;
  }

  public String getNpi() {
      return npi;
  }

  public String getLanguagesspoken() {
      return languagesspoken;
  }

  public String getCountry() {
      return country;
  }

  public String getLocaladdress() {
      return localaddress;
  }

  public String getPaycut() {
      return paycut;
  }

  public String getState() {
      return state;
  }

  public String getZipcode() {
      return zipcode;
  }

  public String getSpecialization() {
      return specialization;
  }

  public String getYearsofexxperience() {
      return yearsofexxperience;
  }

  public String getGender() {
      return gender;
  }

  public DoctorProfileReview getStatus() {
      return status;
  }

  public String getInsurance() {
      return insurance;
  }

  public Boolean getOfflineconsultation() {
      return offlineconsultation;
  }

  public String getAppointmentscompleted() {
      return appointmentscompleted;
  }

  public String getViewsonprofile() {
      return viewsonprofile;
  }

  public List<Education> getEducation() {
      return education;
  }

  public List<Experience> getExperience() {
      return experience;
  }

  public List<Certificates> getCertificates() {
      return certificates;
  }

  public List<Appointment> getAppointment() {
      return appointment;
  }

  public List<Message> getMessage() {
      return message;
  }

  private Doctor(String id, String UserID, DoctorType doctortype, String name, String about, String npi, String languagesspoken, String country, String localaddress, String paycut, String state, String zipcode, String specialization, String yearsofexxperience, String gender, DoctorProfileReview status, String insurance, Boolean offlineconsultation, String appointmentscompleted, String viewsonprofile) {
    this.id = id;
    this.UserID = UserID;
    this.doctortype = doctortype;
    this.name = name;
    this.about = about;
    this.npi = npi;
    this.languagesspoken = languagesspoken;
    this.country = country;
    this.localaddress = localaddress;
    this.paycut = paycut;
    this.state = state;
    this.zipcode = zipcode;
    this.specialization = specialization;
    this.yearsofexxperience = yearsofexxperience;
    this.gender = gender;
    this.status = status;
    this.insurance = insurance;
    this.offlineconsultation = offlineconsultation;
    this.appointmentscompleted = appointmentscompleted;
    this.viewsonprofile = viewsonprofile;
  }

  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Doctor doctor = (Doctor) obj;
      return ObjectsCompat.equals(getId(), doctor.getId()) &&
              ObjectsCompat.equals(getUserId(), doctor.getUserId()) &&
              ObjectsCompat.equals(getDoctortype(), doctor.getDoctortype()) &&
              ObjectsCompat.equals(getName(), doctor.getName()) &&
              ObjectsCompat.equals(getAbout(), doctor.getAbout()) &&
              ObjectsCompat.equals(getNpi(), doctor.getNpi()) &&
              ObjectsCompat.equals(getLanguagesspoken(), doctor.getLanguagesspoken()) &&
              ObjectsCompat.equals(getCountry(), doctor.getCountry()) &&
              ObjectsCompat.equals(getLocaladdress(), doctor.getLocaladdress()) &&
              ObjectsCompat.equals(getPaycut(), doctor.getPaycut()) &&
              ObjectsCompat.equals(getState(), doctor.getState()) &&
              ObjectsCompat.equals(getZipcode(), doctor.getZipcode()) &&
              ObjectsCompat.equals(getSpecialization(), doctor.getSpecialization()) &&
              ObjectsCompat.equals(getYearsofexxperience(), doctor.getYearsofexxperience()) &&
              ObjectsCompat.equals(getGender(), doctor.getGender()) &&
              ObjectsCompat.equals(getStatus(), doctor.getStatus()) &&
              ObjectsCompat.equals(getInsurance(), doctor.getInsurance()) &&
              ObjectsCompat.equals(getOfflineconsultation(), doctor.getOfflineconsultation()) &&
              ObjectsCompat.equals(getAppointmentscompleted(), doctor.getAppointmentscompleted()) &&
              ObjectsCompat.equals(getViewsonprofile(), doctor.getViewsonprofile());
      }
  }

  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUserId())
      .append(getDoctortype())
      .append(getName())
      .append(getAbout())
      .append(getNpi())
      .append(getLanguagesspoken())
      .append(getCountry())
      .append(getLocaladdress())
      .append(getPaycut())
      .append(getState())
      .append(getZipcode())
      .append(getSpecialization())
      .append(getYearsofexxperience())
      .append(getGender())
      .append(getStatus())
      .append(getInsurance())
      .append(getOfflineconsultation())
      .append(getAppointmentscompleted())
      .append(getViewsonprofile())
      .toString()
      .hashCode();
  }

  @Override
   public String toString() {
    return new StringBuilder()
      .append("Doctor {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("UserID=" + String.valueOf(getUserId()) + ", ")
      .append("doctortype=" + String.valueOf(getDoctortype()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("about=" + String.valueOf(getAbout()) + ", ")
      .append("npi=" + String.valueOf(getNpi()) + ", ")
      .append("languagesspoken=" + String.valueOf(getLanguagesspoken()) + ", ")
      .append("country=" + String.valueOf(getCountry()) + ", ")
      .append("localaddress=" + String.valueOf(getLocaladdress()) + ", ")
      .append("paycut=" + String.valueOf(getPaycut()) + ", ")
      .append("state=" + String.valueOf(getState()) + ", ")
      .append("zipcode=" + String.valueOf(getZipcode()) + ", ")
      .append("specialization=" + String.valueOf(getSpecialization()) + ", ")
      .append("yearsofexxperience=" + String.valueOf(getYearsofexxperience()) + ", ")
      .append("gender=" + String.valueOf(getGender()) + ", ")
      .append("status=" + String.valueOf(getStatus()) + ", ")
      .append("insurance=" + String.valueOf(getInsurance()) + ", ")
      .append("offlineconsultation=" + String.valueOf(getOfflineconsultation()) + ", ")
      .append("appointmentscompleted=" + String.valueOf(getAppointmentscompleted()) + ", ")
      .append("viewsonprofile=" + String.valueOf(getViewsonprofile()))
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
  public static Doctor justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Doctor(
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
      UserID,
      doctortype,
      name,
      about,
      npi,
      languagesspoken,
      country,
      localaddress,
      paycut,
      state,
      zipcode,
      specialization,
      yearsofexxperience,
      gender,
      status,
      insurance,
      offlineconsultation,
      appointmentscompleted,
      viewsonprofile);
  }
  public interface UserIdStep {
    DoctortypeStep userId(String userId);
  }


  public interface DoctortypeStep {
    PaycutStep doctortype(DoctorType doctortype);
  }


  public interface PaycutStep {
    StatusStep paycut(String paycut);
  }


  public interface StatusStep {
    AppointmentscompletedStep status(DoctorProfileReview status);
  }


  public interface AppointmentscompletedStep {
    ViewsonprofileStep appointmentscompleted(String appointmentscompleted);
  }


  public interface ViewsonprofileStep {
    BuildStep viewsonprofile(String viewsonprofile);
  }


  public interface BuildStep {
    Doctor build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep name(String name);
    BuildStep about(String about);
    BuildStep npi(String npi);
    BuildStep languagesspoken(String languagesspoken);
    BuildStep country(String country);
    BuildStep localaddress(String localaddress);
    BuildStep state(String state);
    BuildStep zipcode(String zipcode);
    BuildStep specialization(String specialization);
    BuildStep yearsofexxperience(String yearsofexxperience);
    BuildStep gender(String gender);
    BuildStep insurance(String insurance);
    BuildStep offlineconsultation(Boolean offlineconsultation);
  }


  public static class Builder implements UserIdStep, DoctortypeStep, PaycutStep, StatusStep, AppointmentscompletedStep, ViewsonprofileStep, BuildStep {
    private String id;
    private String UserID;
    private DoctorType doctortype;
    private String paycut;
    private DoctorProfileReview status;
    private String appointmentscompleted;
    private String viewsonprofile;
    private String name;
    private String about;
    private String npi;
    private String languagesspoken;
    private String country;
    private String localaddress;
    private String state;
    private String zipcode;
    private String specialization;
    private String yearsofexxperience;
    private String gender;
    private String insurance;
    private Boolean offlineconsultation;
    @Override
     public Doctor build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();

        return new Doctor(
          id,
          UserID,
          doctortype,
          name,
          about,
          npi,
          languagesspoken,
          country,
          localaddress,
          paycut,
          state,
          zipcode,
          specialization,
          yearsofexxperience,
          gender,
          status,
          insurance,
          offlineconsultation,
          appointmentscompleted,
          viewsonprofile);
    }

    @Override
     public DoctortypeStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.UserID = userId;
        return this;
    }

    @Override
     public PaycutStep doctortype(DoctorType doctortype) {
        Objects.requireNonNull(doctortype);
        this.doctortype = doctortype;
        return this;
    }

    @Override
     public StatusStep paycut(String paycut) {
        Objects.requireNonNull(paycut);
        this.paycut = paycut;
        return this;
    }

    @Override
     public AppointmentscompletedStep status(DoctorProfileReview status) {
        Objects.requireNonNull(status);
        this.status = status;
        return this;
    }

    @Override
     public ViewsonprofileStep appointmentscompleted(String appointmentscompleted) {
        Objects.requireNonNull(appointmentscompleted);
        this.appointmentscompleted = appointmentscompleted;
        return this;
    }

    @Override
     public BuildStep viewsonprofile(String viewsonprofile) {
        Objects.requireNonNull(viewsonprofile);
        this.viewsonprofile = viewsonprofile;
        return this;
    }

    @Override
     public BuildStep name(String name) {
        this.name = name;
        return this;
    }

    @Override
     public BuildStep about(String about) {
        this.about = about;
        return this;
    }

    @Override
     public BuildStep npi(String npi) {
        this.npi = npi;
        return this;
    }

    @Override
     public BuildStep languagesspoken(String languagesspoken) {
        this.languagesspoken = languagesspoken;
        return this;
    }

    @Override
     public BuildStep country(String country) {
        this.country = country;
        return this;
    }

    @Override
     public BuildStep localaddress(String localaddress) {
        this.localaddress = localaddress;
        return this;
    }

    @Override
     public BuildStep state(String state) {
        this.state = state;
        return this;
    }

    @Override
     public BuildStep zipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    @Override
     public BuildStep specialization(String specialization) {
        this.specialization = specialization;
        return this;
    }

    @Override
     public BuildStep yearsofexxperience(String yearsofexxperience) {
        this.yearsofexxperience = yearsofexxperience;
        return this;
    }

    @Override
     public BuildStep gender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
     public BuildStep insurance(String insurance) {
        this.insurance = insurance;
        return this;
    }

    @Override
     public BuildStep offlineconsultation(Boolean offlineconsultation) {
        this.offlineconsultation = offlineconsultation;
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
    private CopyOfBuilder(String id, String userId, DoctorType doctortype, String name, String about, String npi, String languagesspoken, String country, String localaddress, String paycut, String state, String zipcode, String specialization, String yearsofexxperience, String gender, DoctorProfileReview status, String insurance, Boolean offlineconsultation, String appointmentscompleted, String viewsonprofile) {
      super.id(id);
      super.userId(userId)
        .doctortype(doctortype)
        .paycut(paycut)
        .status(status)
        .appointmentscompleted(appointmentscompleted)
        .viewsonprofile(viewsonprofile)
        .name(name)
        .about(about)
        .npi(npi)
        .languagesspoken(languagesspoken)
        .country(country)
        .localaddress(localaddress)
        .state(state)
        .zipcode(zipcode)
        .specialization(specialization)
        .yearsofexxperience(yearsofexxperience)
        .gender(gender)
        .insurance(insurance)
        .offlineconsultation(offlineconsultation);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder doctortype(DoctorType doctortype) {
      return (CopyOfBuilder) super.doctortype(doctortype);
    }
    
    @Override
     public CopyOfBuilder paycut(String paycut) {
      return (CopyOfBuilder) super.paycut(paycut);
    }
    
    @Override
     public CopyOfBuilder status(DoctorProfileReview status) {
      return (CopyOfBuilder) super.status(status);
    }
    
    @Override
     public CopyOfBuilder appointmentscompleted(String appointmentscompleted) {
      return (CopyOfBuilder) super.appointmentscompleted(appointmentscompleted);
    }
    
    @Override
     public CopyOfBuilder viewsonprofile(String viewsonprofile) {
      return (CopyOfBuilder) super.viewsonprofile(viewsonprofile);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder about(String about) {
      return (CopyOfBuilder) super.about(about);
    }
    
    @Override
     public CopyOfBuilder npi(String npi) {
      return (CopyOfBuilder) super.npi(npi);
    }
    
    @Override
     public CopyOfBuilder languagesspoken(String languagesspoken) {
      return (CopyOfBuilder) super.languagesspoken(languagesspoken);
    }
    
    @Override
     public CopyOfBuilder country(String country) {
      return (CopyOfBuilder) super.country(country);
    }
    
    @Override
     public CopyOfBuilder localaddress(String localaddress) {
      return (CopyOfBuilder) super.localaddress(localaddress);
    }
    
    @Override
     public CopyOfBuilder state(String state) {
      return (CopyOfBuilder) super.state(state);
    }
    
    @Override
     public CopyOfBuilder zipcode(String zipcode) {
      return (CopyOfBuilder) super.zipcode(zipcode);
    }
    
    @Override
     public CopyOfBuilder specialization(String specialization) {
      return (CopyOfBuilder) super.specialization(specialization);
    }
    
    @Override
     public CopyOfBuilder yearsofexxperience(String yearsofexxperience) {
      return (CopyOfBuilder) super.yearsofexxperience(yearsofexxperience);
    }
    
    @Override
     public CopyOfBuilder gender(String gender) {
      return (CopyOfBuilder) super.gender(gender);
    }
    
    @Override
     public CopyOfBuilder insurance(String insurance) {
      return (CopyOfBuilder) super.insurance(insurance);
    }
    
    @Override
     public CopyOfBuilder offlineconsultation(Boolean offlineconsultation) {
      return (CopyOfBuilder) super.offlineconsultation(offlineconsultation);
    }
  }
  
}
