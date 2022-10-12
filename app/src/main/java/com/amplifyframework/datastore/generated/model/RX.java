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

/** This is an auto generated class representing the RX type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "RXES", authRules = {
  @AuthRule(allow = AuthStrategy.OWNER, ownerField = "owner", identityClaim = "cognito:username", operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE })
})
@Index(name = "byRX", fields = {"UserID"})
@Index(name = "byRXdoc", fields = {"DoctorsID"})
public final class RX implements Model {
  public static final QueryField ID = field("RX", "id");
  public static final QueryField NAME = field("RX", "name");
  public static final QueryField DOCTORS_ID = field("RX", "DoctorsID");
  public static final QueryField USER_ID = field("RX", "UserID");
  public static final QueryField MEEETINGID = field("RX", "meeetingid");
  public static final QueryField DOSAGE = field("RX", "dosage");
  public static final QueryField INSTRUCTION = field("RX", "instruction");
  public static final QueryField REASON = field("RX", "reason");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="ID", isRequired = true) String DoctorsID;
  private final @ModelField(targetType="ID", isRequired = true) String UserID;
  private final @ModelField(targetType="ID", isRequired = true) String meeetingid;
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
  
  public String getUserId() {
      return UserID;
  }
  
  public String getMeeetingid() {
      return meeetingid;
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
  
  private RX(String id, String name, String DoctorsID, String UserID, String meeetingid, String dosage, String instruction, String reason) {
    this.id = id;
    this.name = name;
    this.DoctorsID = DoctorsID;
    this.UserID = UserID;
    this.meeetingid = meeetingid;
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
      RX rx = (RX) obj;
      return ObjectsCompat.equals(getId(), rx.getId()) &&
              ObjectsCompat.equals(getName(), rx.getName()) &&
              ObjectsCompat.equals(getDoctorsId(), rx.getDoctorsId()) &&
              ObjectsCompat.equals(getUserId(), rx.getUserId()) &&
              ObjectsCompat.equals(getMeeetingid(), rx.getMeeetingid()) &&
              ObjectsCompat.equals(getDosage(), rx.getDosage()) &&
              ObjectsCompat.equals(getInstruction(), rx.getInstruction()) &&
              ObjectsCompat.equals(getReason(), rx.getReason());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getDoctorsId())
      .append(getUserId())
      .append(getMeeetingid())
      .append(getDosage())
      .append(getInstruction())
      .append(getReason())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("RX {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("DoctorsID=" + String.valueOf(getDoctorsId()) + ", ")
      .append("UserID=" + String.valueOf(getUserId()) + ", ")
      .append("meeetingid=" + String.valueOf(getMeeetingid()) + ", ")
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
  public static RX justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new RX(
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
      UserID,
      meeetingid,
      dosage,
      instruction,
      reason);
  }
  public interface NameStep {
    DoctorsIdStep name(String name);
  }
  

  public interface DoctorsIdStep {
    UserIdStep doctorsId(String doctorsId);
  }
  

  public interface UserIdStep {
    MeeetingidStep userId(String userId);
  }
  

  public interface MeeetingidStep {
    DosageStep meeetingid(String meeetingid);
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
    RX build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements NameStep, DoctorsIdStep, UserIdStep, MeeetingidStep, DosageStep, InstructionStep, ReasonStep, BuildStep {
    private String id;
    private String name;
    private String DoctorsID;
    private String UserID;
    private String meeetingid;
    private String dosage;
    private String instruction;
    private String reason;
    @Override
     public RX build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new RX(
          id,
          name,
          DoctorsID,
          UserID,
          meeetingid,
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
     public UserIdStep doctorsId(String doctorsId) {
        Objects.requireNonNull(doctorsId);
        this.DoctorsID = doctorsId;
        return this;
    }
    
    @Override
     public MeeetingidStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.UserID = userId;
        return this;
    }
    
    @Override
     public DosageStep meeetingid(String meeetingid) {
        Objects.requireNonNull(meeetingid);
        this.meeetingid = meeetingid;
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
    private CopyOfBuilder(String id, String name, String doctorsId, String userId, String meeetingid, String dosage, String instruction, String reason) {
      super.id(id);
      super.name(name)
        .doctorsId(doctorsId)
        .userId(userId)
        .meeetingid(meeetingid)
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
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder meeetingid(String meeetingid) {
      return (CopyOfBuilder) super.meeetingid(meeetingid);
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
