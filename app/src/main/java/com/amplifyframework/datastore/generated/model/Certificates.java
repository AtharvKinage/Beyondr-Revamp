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

/** This is an auto generated class representing the Certificates type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Certificates")
@Index(name = "byCertificatesdoc", fields = {"doctorID"})
public final class Certificates implements Model {
  public static final QueryField ID = field("Certificates", "id");
  public static final QueryField DOCTOR_ID = field("Certificates", "doctorID");
  public static final QueryField IMAGEURL = field("Certificates", "imageurl");
  public static final QueryField DESCRIPTION = field("Certificates", "description");
  public static final QueryField DOCTORTYPE = field("Certificates", "doctortype");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String doctorID;
  private final @ModelField(targetType="String", isRequired = true) String imageurl;
  private final @ModelField(targetType="String", isRequired = true) String description;
  private final @ModelField(targetType="DoctorType", isRequired = true)
  DoctorType doctortype;
  public String getId() {
      return id;
  }

  public String getDoctorId() {
      return doctorID;
  }

  public String getImageurl() {
      return imageurl;
  }

  public String getDescription() {
      return description;
  }

  public DoctorType getDoctortype() {
      return doctortype;
  }

  private Certificates(String id, String doctorID, String imageurl, String description, DoctorType doctortype) {
    this.id = id;
    this.doctorID = doctorID;
    this.imageurl = imageurl;
    this.description = description;
    this.doctortype = doctortype;
  }

  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Certificates certificates = (Certificates) obj;
      return ObjectsCompat.equals(getId(), certificates.getId()) &&
              ObjectsCompat.equals(getDoctorId(), certificates.getDoctorId()) &&
              ObjectsCompat.equals(getImageurl(), certificates.getImageurl()) &&
              ObjectsCompat.equals(getDescription(), certificates.getDescription()) &&
              ObjectsCompat.equals(getDoctortype(), certificates.getDoctortype());
      }
  }

  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDoctorId())
      .append(getImageurl())
      .append(getDescription())
      .append(getDoctortype())
      .toString()
      .hashCode();
  }

  @Override
   public String toString() {
    return new StringBuilder()
      .append("Certificates {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("doctorID=" + String.valueOf(getDoctorId()) + ", ")
      .append("imageurl=" + String.valueOf(getImageurl()) + ", ")
      .append("description=" + String.valueOf(getDescription()) + ", ")
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
  public static Certificates justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Certificates(
      id,
      null,
      null,
      null,
      null
    );
  }

  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      doctorID,
      imageurl,
      description,
      doctortype);
  }
  public interface DoctorIdStep {
    ImageurlStep doctorId(String doctorId);
  }


  public interface ImageurlStep {
    DescriptionStep imageurl(String imageurl);
  }


  public interface DescriptionStep {
    DoctortypeStep description(String description);
  }


  public interface DoctortypeStep {
    BuildStep doctortype(DoctorType doctortype);
  }


  public interface BuildStep {
    Certificates build();
    BuildStep id(String id) throws IllegalArgumentException;
  }


  public static class Builder implements DoctorIdStep, ImageurlStep, DescriptionStep, DoctortypeStep, BuildStep {
    private String id;
    private String doctorID;
    private String imageurl;
    private String description;
    private DoctorType doctortype;
    @Override
     public Certificates build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();

        return new Certificates(
          id,
          doctorID,
          imageurl,
          description,
          doctortype);
    }

    @Override
     public ImageurlStep doctorId(String doctorId) {
        Objects.requireNonNull(doctorId);
        this.doctorID = doctorId;
        return this;
    }

    @Override
     public DescriptionStep imageurl(String imageurl) {
        Objects.requireNonNull(imageurl);
        this.imageurl = imageurl;
        return this;
    }

    @Override
     public DoctortypeStep description(String description) {
        Objects.requireNonNull(description);
        this.description = description;
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
    private CopyOfBuilder(String id, String doctorId, String imageurl, String description, DoctorType doctortype) {
      super.id(id);
      super.doctorId(doctorId)
        .imageurl(imageurl)
        .description(description)
        .doctortype(doctortype);
    }
    
    @Override
     public CopyOfBuilder doctorId(String doctorId) {
      return (CopyOfBuilder) super.doctorId(doctorId);
    }
    
    @Override
     public CopyOfBuilder imageurl(String imageurl) {
      return (CopyOfBuilder) super.imageurl(imageurl);
    }
    
    @Override
     public CopyOfBuilder description(String description) {
      return (CopyOfBuilder) super.description(description);
    }
    
    @Override
     public CopyOfBuilder doctortype(DoctorType doctortype) {
      return (CopyOfBuilder) super.doctortype(doctortype);
    }
  }
  
}
