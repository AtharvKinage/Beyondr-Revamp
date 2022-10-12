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

/** This is an auto generated class representing the Education type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Educations")
@Index(name = "byEducation", fields = {"doctorID"})
public final class Education implements Model {
  public static final QueryField ID = field("Education", "id");
  public static final QueryField DOCTOR_ID = field("Education", "doctorID");
  public static final QueryField NAMEOFUNIVERSITY = field("Education", "nameofuniversity");
  public static final QueryField FIELDOFSTUDY = field("Education", "fieldofstudy");
  public static final QueryField DOCTORTYPE = field("Education", "doctortype");
  public static final QueryField DEGREE = field("Education", "degree");
  public static final QueryField STARTDATE = field("Education", "startdate");
  public static final QueryField ENDDATE = field("Education", "enddate");
  public static final QueryField GRADEPOINT = field("Education", "gradepoint");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String doctorID;
  private final @ModelField(targetType="String", isRequired = true) String nameofuniversity;
  private final @ModelField(targetType="String", isRequired = true) String fieldofstudy;
  private final @ModelField(targetType="DoctorType", isRequired = true)
  DoctorType doctortype;
  private final @ModelField(targetType="String", isRequired = true) String degree;
  private final @ModelField(targetType="String", isRequired = true) String startdate;
  private final @ModelField(targetType="String", isRequired = true) String enddate;
  private final @ModelField(targetType="String") String gradepoint;
  public String getId() {
      return id;
  }
  
  public String getDoctorId() {
      return doctorID;
  }
  
  public String getNameofuniversity() {
      return nameofuniversity;
  }
  
  public String getFieldofstudy() {
      return fieldofstudy;
  }
  
  public DoctorType getDoctortype() {
      return doctortype;
  }
  
  public String getDegree() {
      return degree;
  }
  
  public String getStartdate() {
      return startdate;
  }
  
  public String getEnddate() {
      return enddate;
  }
  
  public String getGradepoint() {
      return gradepoint;
  }
  
  private Education(String id, String doctorID, String nameofuniversity, String fieldofstudy, DoctorType doctortype, String degree, String startdate, String enddate, String gradepoint) {
    this.id = id;
    this.doctorID = doctorID;
    this.nameofuniversity = nameofuniversity;
    this.fieldofstudy = fieldofstudy;
    this.doctortype = doctortype;
    this.degree = degree;
    this.startdate = startdate;
    this.enddate = enddate;
    this.gradepoint = gradepoint;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Education education = (Education) obj;
      return ObjectsCompat.equals(getId(), education.getId()) &&
              ObjectsCompat.equals(getDoctorId(), education.getDoctorId()) &&
              ObjectsCompat.equals(getNameofuniversity(), education.getNameofuniversity()) &&
              ObjectsCompat.equals(getFieldofstudy(), education.getFieldofstudy()) &&
              ObjectsCompat.equals(getDoctortype(), education.getDoctortype()) &&
              ObjectsCompat.equals(getDegree(), education.getDegree()) &&
              ObjectsCompat.equals(getStartdate(), education.getStartdate()) &&
              ObjectsCompat.equals(getEnddate(), education.getEnddate()) &&
              ObjectsCompat.equals(getGradepoint(), education.getGradepoint());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDoctorId())
      .append(getNameofuniversity())
      .append(getFieldofstudy())
      .append(getDoctortype())
      .append(getDegree())
      .append(getStartdate())
      .append(getEnddate())
      .append(getGradepoint())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Education {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("doctorID=" + String.valueOf(getDoctorId()) + ", ")
      .append("nameofuniversity=" + String.valueOf(getNameofuniversity()) + ", ")
      .append("fieldofstudy=" + String.valueOf(getFieldofstudy()) + ", ")
      .append("doctortype=" + String.valueOf(getDoctortype()) + ", ")
      .append("degree=" + String.valueOf(getDegree()) + ", ")
      .append("startdate=" + String.valueOf(getStartdate()) + ", ")
      .append("enddate=" + String.valueOf(getEnddate()) + ", ")
      .append("gradepoint=" + String.valueOf(getGradepoint()))
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
  public static Education justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Education(
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
      nameofuniversity,
      fieldofstudy,
      doctortype,
      degree,
      startdate,
      enddate,
      gradepoint);
  }
  public interface DoctorIdStep {
    NameofuniversityStep doctorId(String doctorId);
  }
  

  public interface NameofuniversityStep {
    FieldofstudyStep nameofuniversity(String nameofuniversity);
  }
  

  public interface FieldofstudyStep {
    DoctortypeStep fieldofstudy(String fieldofstudy);
  }
  

  public interface DoctortypeStep {
    DegreeStep doctortype(DoctorType doctortype);
  }
  

  public interface DegreeStep {
    StartdateStep degree(String degree);
  }
  

  public interface StartdateStep {
    EnddateStep startdate(String startdate);
  }
  

  public interface EnddateStep {
    BuildStep enddate(String enddate);
  }
  

  public interface BuildStep {
    Education build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep gradepoint(String gradepoint);
  }
  

  public static class Builder implements DoctorIdStep, NameofuniversityStep, FieldofstudyStep, DoctortypeStep, DegreeStep, StartdateStep, EnddateStep, BuildStep {
    private String id;
    private String doctorID;
    private String nameofuniversity;
    private String fieldofstudy;
    private DoctorType doctortype;
    private String degree;
    private String startdate;
    private String enddate;
    private String gradepoint;
    @Override
     public Education build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Education(
          id,
          doctorID,
          nameofuniversity,
          fieldofstudy,
          doctortype,
          degree,
          startdate,
          enddate,
          gradepoint);
    }
    
    @Override
     public NameofuniversityStep doctorId(String doctorId) {
        Objects.requireNonNull(doctorId);
        this.doctorID = doctorId;
        return this;
    }
    
    @Override
     public FieldofstudyStep nameofuniversity(String nameofuniversity) {
        Objects.requireNonNull(nameofuniversity);
        this.nameofuniversity = nameofuniversity;
        return this;
    }
    
    @Override
     public DoctortypeStep fieldofstudy(String fieldofstudy) {
        Objects.requireNonNull(fieldofstudy);
        this.fieldofstudy = fieldofstudy;
        return this;
    }
    
    @Override
     public DegreeStep doctortype(DoctorType doctortype) {
        Objects.requireNonNull(doctortype);
        this.doctortype = doctortype;
        return this;
    }
    
    @Override
     public StartdateStep degree(String degree) {
        Objects.requireNonNull(degree);
        this.degree = degree;
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
    
    @Override
     public BuildStep gradepoint(String gradepoint) {
        this.gradepoint = gradepoint;
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
    private CopyOfBuilder(String id, String doctorId, String nameofuniversity, String fieldofstudy, DoctorType doctortype, String degree, String startdate, String enddate, String gradepoint) {
      super.id(id);
      super.doctorId(doctorId)
        .nameofuniversity(nameofuniversity)
        .fieldofstudy(fieldofstudy)
        .doctortype(doctortype)
        .degree(degree)
        .startdate(startdate)
        .enddate(enddate)
        .gradepoint(gradepoint);
    }
    
    @Override
     public CopyOfBuilder doctorId(String doctorId) {
      return (CopyOfBuilder) super.doctorId(doctorId);
    }
    
    @Override
     public CopyOfBuilder nameofuniversity(String nameofuniversity) {
      return (CopyOfBuilder) super.nameofuniversity(nameofuniversity);
    }
    
    @Override
     public CopyOfBuilder fieldofstudy(String fieldofstudy) {
      return (CopyOfBuilder) super.fieldofstudy(fieldofstudy);
    }
    
    @Override
     public CopyOfBuilder doctortype(DoctorType doctortype) {
      return (CopyOfBuilder) super.doctortype(doctortype);
    }
    
    @Override
     public CopyOfBuilder degree(String degree) {
      return (CopyOfBuilder) super.degree(degree);
    }
    
    @Override
     public CopyOfBuilder startdate(String startdate) {
      return (CopyOfBuilder) super.startdate(startdate);
    }
    
    @Override
     public CopyOfBuilder enddate(String enddate) {
      return (CopyOfBuilder) super.enddate(enddate);
    }
    
    @Override
     public CopyOfBuilder gradepoint(String gradepoint) {
      return (CopyOfBuilder) super.gradepoint(gradepoint);
    }
  }
  
}
