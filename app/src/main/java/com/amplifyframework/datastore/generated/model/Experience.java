package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import java.util.Objects;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Experience type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Experiences")
@Index(name = "byexpID", fields = {"doctorID"})
public final class Experience implements Model {
  public static final QueryField ID = field("Experience", "id");
  public static final QueryField DOCTOR_ID = field("Experience", "doctorID");
  public static final QueryField TITLE = field("Experience", "Title");
  public static final QueryField COMPANY_NAME = field("Experience", "CompanyName");
  public static final QueryField LOCATION = field("Experience", "location");
  public static final QueryField DOCTORTYPE = field("Experience", "doctortype");
  public static final QueryField DESCRIPTION = field("Experience", "Description");
  public static final QueryField STARTDATE = field("Experience", "startdate");
  public static final QueryField ENDDATE = field("Experience", "enddate");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String doctorID;
  private final @ModelField(targetType="String", isRequired = true) String Title;
  private final @ModelField(targetType="String", isRequired = true) String CompanyName;
  private final @ModelField(targetType="String", isRequired = true) String location;
  private final @ModelField(targetType="DoctorType", isRequired = true)
  DoctorType doctortype;
  private final @ModelField(targetType="String", isRequired = true) String Description;
  private final @ModelField(targetType="String", isRequired = true) String startdate;
  private final @ModelField(targetType="String", isRequired = true) String enddate;
  public String getId() {
      return id;
  }
  
  public String getDoctorId() {
      return doctorID;
  }
  
  public String getTitle() {
      return Title;
  }
  
  public String getCompanyName() {
      return CompanyName;
  }
  
  public String getLocation() {
      return location;
  }
  
  public DoctorType getDoctortype() {
      return doctortype;
  }
  
  public String getDescription() {
      return Description;
  }
  
  public String getStartdate() {
      return startdate;
  }
  
  public String getEnddate() {
      return enddate;
  }
  
  private Experience(String id, String doctorID, String Title, String CompanyName, String location, DoctorType doctortype, String Description, String startdate, String enddate) {
    this.id = id;
    this.doctorID = doctorID;
    this.Title = Title;
    this.CompanyName = CompanyName;
    this.location = location;
    this.doctortype = doctortype;
    this.Description = Description;
    this.startdate = startdate;
    this.enddate = enddate;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Experience experience = (Experience) obj;
      return ObjectsCompat.equals(getId(), experience.getId()) &&
              ObjectsCompat.equals(getDoctorId(), experience.getDoctorId()) &&
              ObjectsCompat.equals(getTitle(), experience.getTitle()) &&
              ObjectsCompat.equals(getCompanyName(), experience.getCompanyName()) &&
              ObjectsCompat.equals(getLocation(), experience.getLocation()) &&
              ObjectsCompat.equals(getDoctortype(), experience.getDoctortype()) &&
              ObjectsCompat.equals(getDescription(), experience.getDescription()) &&
              ObjectsCompat.equals(getStartdate(), experience.getStartdate()) &&
              ObjectsCompat.equals(getEnddate(), experience.getEnddate());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDoctorId())
      .append(getTitle())
      .append(getCompanyName())
      .append(getLocation())
      .append(getDoctortype())
      .append(getDescription())
      .append(getStartdate())
      .append(getEnddate())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Experience {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("doctorID=" + String.valueOf(getDoctorId()) + ", ")
      .append("Title=" + String.valueOf(getTitle()) + ", ")
      .append("CompanyName=" + String.valueOf(getCompanyName()) + ", ")
      .append("location=" + String.valueOf(getLocation()) + ", ")
      .append("doctortype=" + String.valueOf(getDoctortype()) + ", ")
      .append("Description=" + String.valueOf(getDescription()) + ", ")
      .append("startdate=" + String.valueOf(getStartdate()) + ", ")
      .append("enddate=" + String.valueOf(getEnddate()))
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
  public static Experience justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Experience(
      id,
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
      Title,
      CompanyName,
      location,
      doctortype,
      Description,
      startdate,
      enddate);
  }
  public interface DoctorIdStep {
    TitleStep doctorId(String doctorId);
  }
  

  public interface TitleStep {
    CompanyNameStep title(String title);
  }
  

  public interface CompanyNameStep {
    LocationStep companyName(String companyName);
  }
  

  public interface LocationStep {
    DoctortypeStep location(String location);
  }
  

  public interface DoctortypeStep {
    DescriptionStep doctortype(DoctorType doctortype);
  }
  

  public interface DescriptionStep {
    StartdateStep description(String description);
  }
  

  public interface StartdateStep {
    EnddateStep startdate(String startdate);
  }
  

  public interface EnddateStep {
    BuildStep enddate(String enddate);
  }
  

  public interface BuildStep {
    Experience build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements DoctorIdStep, TitleStep, CompanyNameStep, LocationStep, DoctortypeStep, DescriptionStep, StartdateStep, EnddateStep, BuildStep {
    private String id;
    private String doctorID;
    private String Title;
    private String CompanyName;
    private String location;
    private DoctorType doctortype;
    private String Description;
    private String startdate;
    private String enddate;
    @Override
     public Experience build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Experience(
          id,
          doctorID,
          Title,
          CompanyName,
          location,
          doctortype,
          Description,
          startdate,
          enddate);
    }
    
    @Override
     public TitleStep doctorId(String doctorId) {
        Objects.requireNonNull(doctorId);
        this.doctorID = doctorId;
        return this;
    }
    
    @Override
     public CompanyNameStep title(String title) {
        Objects.requireNonNull(title);
        this.Title = title;
        return this;
    }
    
    @Override
     public LocationStep companyName(String companyName) {
        Objects.requireNonNull(companyName);
        this.CompanyName = companyName;
        return this;
    }
    
    @Override
     public DoctortypeStep location(String location) {
        Objects.requireNonNull(location);
        this.location = location;
        return this;
    }
    
    @Override
     public DescriptionStep doctortype(DoctorType doctortype) {
        Objects.requireNonNull(doctortype);
        this.doctortype = doctortype;
        return this;
    }
    
    @Override
     public StartdateStep description(String description) {
        Objects.requireNonNull(description);
        this.Description = description;
        return this;
    }
    
    @Override
     public EnddateStep startdate(String startdate) {
        Objects.requireNonNull(startdate);
        this.startdate = startdate;
        return this;
    }
    
    @Override
     public BuildStep enddate(String enddate) {
        Objects.requireNonNull(enddate);
        this.enddate = enddate;
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
    private CopyOfBuilder(String id, String doctorId, String title, String companyName, String location, DoctorType doctortype, String description, String startdate, String enddate) {
      super.id(id);
      super.doctorId(doctorId)
        .title(title)
        .companyName(companyName)
        .location(location)
        .doctortype(doctortype)
        .description(description)
        .startdate(startdate)
        .enddate(enddate);
    }
    
    @Override
     public CopyOfBuilder doctorId(String doctorId) {
      return (CopyOfBuilder) super.doctorId(doctorId);
    }
    
    @Override
     public CopyOfBuilder title(String title) {
      return (CopyOfBuilder) super.title(title);
    }
    
    @Override
     public CopyOfBuilder companyName(String companyName) {
      return (CopyOfBuilder) super.companyName(companyName);
    }
    
    @Override
     public CopyOfBuilder location(String location) {
      return (CopyOfBuilder) super.location(location);
    }
    
    @Override
     public CopyOfBuilder doctortype(DoctorType doctortype) {
      return (CopyOfBuilder) super.doctortype(doctortype);
    }
    
    @Override
     public CopyOfBuilder description(String description) {
      return (CopyOfBuilder) super.description(description);
    }
    
    @Override
     public CopyOfBuilder startdate(String startdate) {
      return (CopyOfBuilder) super.startdate(startdate);
    }
    
    @Override
     public CopyOfBuilder enddate(String enddate) {
      return (CopyOfBuilder) super.enddate(enddate);
    }
  }
  
}
