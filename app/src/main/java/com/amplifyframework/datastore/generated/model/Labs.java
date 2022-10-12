package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import java.util.Objects;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Labs type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Labs", authRules = {
  @AuthRule(allow = AuthStrategy.OWNER, ownerField = "owner", identityClaim = "cognito:username", operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE })
})
@Index(name = "byLabs", fields = {"UserID"})
@Index(name = "byLabsdoc", fields = {"DoctorsID"})
public final class Labs implements Model {
  public static final QueryField ID = field("Labs", "id");
  public static final QueryField NAME = field("Labs", "name");
  public static final QueryField DOCTORS_ID = field("Labs", "DoctorsID");
  public static final QueryField MEEETINGID = field("Labs", "meeetingid");
  public static final QueryField USER_ID = field("Labs", "UserID");
  public static final QueryField DOSAGE = field("Labs", "dosage");
  public static final QueryField INSTRUCTION = field("Labs", "instruction");
  public static final QueryField REASON = field("Labs", "reason");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="ID", isRequired = true) String DoctorsID;
  private final @ModelField(targetType="ID", isRequired = true) String meeetingid;
  private final @ModelField(targetType="ID", isRequired = true) String UserID;
  private final @ModelField(targetType="String", isRequired = true) String dosage;
  private final @ModelField(targetType="String", isRequired = true) String instruction;
  private final @ModelField(targetType="String", isRequired = true) String reason;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public String getDoctorsId() {
      return DoctorsID;
  }
  
  public String getMeeetingid() {
      return meeetingid;
  }
  
  public String getUserId() {
      return UserID;
  }
  
  public String getDosage() {
      return dosage;
  }
  
  public String getInstruction() {
      return instruction;
  }
  
  public String getReason() {
      return reason;
  }
  
  private Labs(String id, String name, String DoctorsID, String meeetingid, String UserID, String dosage, String instruction, String reason) {
    this.id = id;
    this.name = name;
    this.DoctorsID = DoctorsID;
    this.meeetingid = meeetingid;
    this.UserID = UserID;
    this.dosage = dosage;
    this.instruction = instruction;
    this.reason = reason;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Labs labs = (Labs) obj;
      return ObjectsCompat.equals(getId(), labs.getId()) &&
              ObjectsCompat.equals(getName(), labs.getName()) &&
              ObjectsCompat.equals(getDoctorsId(), labs.getDoctorsId()) &&
              ObjectsCompat.equals(getMeeetingid(), labs.getMeeetingid()) &&
              ObjectsCompat.equals(getUserId(), labs.getUserId()) &&
              ObjectsCompat.equals(getDosage(), labs.getDosage()) &&
              ObjectsCompat.equals(getInstruction(), labs.getInstruction()) &&
              ObjectsCompat.equals(getReason(), labs.getReason());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getDoctorsId())
      .append(getMeeetingid())
      .append(getUserId())
      .append(getDosage())
      .append(getInstruction())
      .append(getReason())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Labs {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("DoctorsID=" + String.valueOf(getDoctorsId()) + ", ")
      .append("meeetingid=" + String.valueOf(getMeeetingid()) + ", ")
      .append("UserID=" + String.valueOf(getUserId()) + ", ")
      .append("dosage=" + String.valueOf(getDosage()) + ", ")
      .append("instruction=" + String.valueOf(getInstruction()) + ", ")
      .append("reason=" + String.valueOf(getReason()))
      .append("}")
      .toString();
  }
  
  public static NameStep builder() {
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
  public static Labs justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Labs(
      id,
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
      name,
      DoctorsID,
      meeetingid,
      UserID,
      dosage,
      instruction,
      reason);
  }
  public interface NameStep {
    DoctorsIdStep name(String name);
  }
  

  public interface DoctorsIdStep {
    MeeetingidStep doctorsId(String doctorsId);
  }
  

  public interface MeeetingidStep {
    UserIdStep meeetingid(String meeetingid);
  }
  

  public interface UserIdStep {
    DosageStep userId(String userId);
  }
  

  public interface DosageStep {
    InstructionStep dosage(String dosage);
  }
  

  public interface InstructionStep {
    ReasonStep instruction(String instruction);
  }
  

  public interface ReasonStep {
    BuildStep reason(String reason);
  }
  

  public interface BuildStep {
    Labs build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements NameStep, DoctorsIdStep, MeeetingidStep, UserIdStep, DosageStep, InstructionStep, ReasonStep, BuildStep {
    private String id;
    private String name;
    private String DoctorsID;
    private String meeetingid;
    private String UserID;
    private String dosage;
    private String instruction;
    private String reason;
    @Override
     public Labs build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Labs(
          id,
          name,
          DoctorsID,
          meeetingid,
          UserID,
          dosage,
          instruction,
          reason);
    }
    
    @Override
     public DoctorsIdStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public MeeetingidStep doctorsId(String doctorsId) {
        Objects.requireNonNull(doctorsId);
        this.DoctorsID = doctorsId;
        return this;
    }
    
    @Override
     public UserIdStep meeetingid(String meeetingid) {
        Objects.requireNonNull(meeetingid);
        this.meeetingid = meeetingid;
        return this;
    }
    
    @Override
     public DosageStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.UserID = userId;
        return this;
    }
    
    @Override
     public InstructionStep dosage(String dosage) {
        Objects.requireNonNull(dosage);
        this.dosage = dosage;
        return this;
    }
    
    @Override
     public ReasonStep instruction(String instruction) {
        Objects.requireNonNull(instruction);
        this.instruction = instruction;
        return this;
    }
    
    @Override
     public BuildStep reason(String reason) {
        Objects.requireNonNull(reason);
        this.reason = reason;
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
    private CopyOfBuilder(String id, String name, String doctorsId, String meeetingid, String userId, String dosage, String instruction, String reason) {
      super.id(id);
      super.name(name)
        .doctorsId(doctorsId)
        .meeetingid(meeetingid)
        .userId(userId)
        .dosage(dosage)
        .instruction(instruction)
        .reason(reason);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder doctorsId(String doctorsId) {
      return (CopyOfBuilder) super.doctorsId(doctorsId);
    }
    
    @Override
     public CopyOfBuilder meeetingid(String meeetingid) {
      return (CopyOfBuilder) super.meeetingid(meeetingid);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder dosage(String dosage) {
      return (CopyOfBuilder) super.dosage(dosage);
    }
    
    @Override
     public CopyOfBuilder instruction(String instruction) {
      return (CopyOfBuilder) super.instruction(instruction);
    }
    
    @Override
     public CopyOfBuilder reason(String reason) {
      return (CopyOfBuilder) super.reason(reason);
    }
  }
  
}
