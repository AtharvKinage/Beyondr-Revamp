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

/** This is an auto generated class representing the Report type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Reports")
public final class Report implements Model {
  public static final QueryField ID = field("Report", "id");
  public static final QueryField USER_ID = field("Report", "userID");
  public static final QueryField DOCTOR_ID = field("Report", "doctorID");
  public static final QueryField MEETINGID = field("Report", "meetingid");
  public static final QueryField REOPORTTYPE = field("Report", "reoporttype");
  public static final QueryField DATE = field("Report", "date");
  public static final QueryField SUMMNARYNAME = field("Report", "summnaryname");
  public static final QueryField SUMMARYDOSAGE = field("Report", "summarydosage");
  public static final QueryField SUMMNARYINSTR = field("Report", "summnaryinstr");
  public static final QueryField SUMMNARYREASON = field("Report", "summnaryreason");
  public static final QueryField RXNAME = field("Report", "rxname");
  public static final QueryField RXDOSAGE = field("Report", "rxdosage");
  public static final QueryField RXINSTR = field("Report", "rxinstr");
  public static final QueryField RXREASON = field("Report", "rxreason");
  public static final QueryField LABSNAME = field("Report", "labsname");
  public static final QueryField LABSDOSAGE = field("Report", "labsdosage");
  public static final QueryField LABSINSTR = field("Report", "labsinstr");
  public static final QueryField LABSREASON = field("Report", "labsreason");
  public static final QueryField VISITNOTES = field("Report", "visitnotes");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String userID;
  private final @ModelField(targetType="ID") String doctorID;
  private final @ModelField(targetType="ID") String meetingid;
  private final @ModelField(targetType="ReportType", isRequired = true)
  ReportType reoporttype;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  private final @ModelField(targetType="String") String summnaryname;
  private final @ModelField(targetType="String") String summarydosage;
  private final @ModelField(targetType="String") String summnaryinstr;
  private final @ModelField(targetType="String") String summnaryreason;
  private final @ModelField(targetType="String") String rxname;
  private final @ModelField(targetType="String") String rxdosage;
  private final @ModelField(targetType="String") String rxinstr;
  private final @ModelField(targetType="String") String rxreason;
  private final @ModelField(targetType="String") String labsname;
  private final @ModelField(targetType="String") String labsdosage;
  private final @ModelField(targetType="String") String labsinstr;
  private final @ModelField(targetType="String") String labsreason;
  private final @ModelField(targetType="String") String visitnotes;
  public String getId() {
      return id;
  }
  
  public String getUserId() {
      return userID;
  }
  
  public String getDoctorId() {
      return doctorID;
  }
  
  public String getMeetingid() {
      return meetingid;
  }
  
  public ReportType getReoporttype() {
      return reoporttype;
  }
  
  public Temporal.DateTime getDate() {
      return date;
  }
  
  public String getSummnaryname() {
      return summnaryname;
  }
  
  public String getSummarydosage() {
      return summarydosage;
  }
  
  public String getSummnaryinstr() {
      return summnaryinstr;
  }
  
  public String getSummnaryreason() {
      return summnaryreason;
  }
  
  public String getRxname() {
      return rxname;
  }
  
  public String getRxdosage() {
      return rxdosage;
  }
  
  public String getRxinstr() {
      return rxinstr;
  }
  
  public String getRxreason() {
      return rxreason;
  }
  
  public String getLabsname() {
      return labsname;
  }
  
  public String getLabsdosage() {
      return labsdosage;
  }
  
  public String getLabsinstr() {
      return labsinstr;
  }
  
  public String getLabsreason() {
      return labsreason;
  }
  
  public String getVisitnotes() {
      return visitnotes;
  }
  
  private Report(String id, String userID, String doctorID, String meetingid, ReportType reoporttype, Temporal.DateTime date, String summnaryname, String summarydosage, String summnaryinstr, String summnaryreason, String rxname, String rxdosage, String rxinstr, String rxreason, String labsname, String labsdosage, String labsinstr, String labsreason, String visitnotes) {
    this.id = id;
    this.userID = userID;
    this.doctorID = doctorID;
    this.meetingid = meetingid;
    this.reoporttype = reoporttype;
    this.date = date;
    this.summnaryname = summnaryname;
    this.summarydosage = summarydosage;
    this.summnaryinstr = summnaryinstr;
    this.summnaryreason = summnaryreason;
    this.rxname = rxname;
    this.rxdosage = rxdosage;
    this.rxinstr = rxinstr;
    this.rxreason = rxreason;
    this.labsname = labsname;
    this.labsdosage = labsdosage;
    this.labsinstr = labsinstr;
    this.labsreason = labsreason;
    this.visitnotes = visitnotes;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Report report = (Report) obj;
      return ObjectsCompat.equals(getId(), report.getId()) &&
              ObjectsCompat.equals(getUserId(), report.getUserId()) &&
              ObjectsCompat.equals(getDoctorId(), report.getDoctorId()) &&
              ObjectsCompat.equals(getMeetingid(), report.getMeetingid()) &&
              ObjectsCompat.equals(getReoporttype(), report.getReoporttype()) &&
              ObjectsCompat.equals(getDate(), report.getDate()) &&
              ObjectsCompat.equals(getSummnaryname(), report.getSummnaryname()) &&
              ObjectsCompat.equals(getSummarydosage(), report.getSummarydosage()) &&
              ObjectsCompat.equals(getSummnaryinstr(), report.getSummnaryinstr()) &&
              ObjectsCompat.equals(getSummnaryreason(), report.getSummnaryreason()) &&
              ObjectsCompat.equals(getRxname(), report.getRxname()) &&
              ObjectsCompat.equals(getRxdosage(), report.getRxdosage()) &&
              ObjectsCompat.equals(getRxinstr(), report.getRxinstr()) &&
              ObjectsCompat.equals(getRxreason(), report.getRxreason()) &&
              ObjectsCompat.equals(getLabsname(), report.getLabsname()) &&
              ObjectsCompat.equals(getLabsdosage(), report.getLabsdosage()) &&
              ObjectsCompat.equals(getLabsinstr(), report.getLabsinstr()) &&
              ObjectsCompat.equals(getLabsreason(), report.getLabsreason()) &&
              ObjectsCompat.equals(getVisitnotes(), report.getVisitnotes());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUserId())
      .append(getDoctorId())
      .append(getMeetingid())
      .append(getReoporttype())
      .append(getDate())
      .append(getSummnaryname())
      .append(getSummarydosage())
      .append(getSummnaryinstr())
      .append(getSummnaryreason())
      .append(getRxname())
      .append(getRxdosage())
      .append(getRxinstr())
      .append(getRxreason())
      .append(getLabsname())
      .append(getLabsdosage())
      .append(getLabsinstr())
      .append(getLabsreason())
      .append(getVisitnotes())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Report {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("userID=" + String.valueOf(getUserId()) + ", ")
      .append("doctorID=" + String.valueOf(getDoctorId()) + ", ")
      .append("meetingid=" + String.valueOf(getMeetingid()) + ", ")
      .append("reoporttype=" + String.valueOf(getReoporttype()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("summnaryname=" + String.valueOf(getSummnaryname()) + ", ")
      .append("summarydosage=" + String.valueOf(getSummarydosage()) + ", ")
      .append("summnaryinstr=" + String.valueOf(getSummnaryinstr()) + ", ")
      .append("summnaryreason=" + String.valueOf(getSummnaryreason()) + ", ")
      .append("rxname=" + String.valueOf(getRxname()) + ", ")
      .append("rxdosage=" + String.valueOf(getRxdosage()) + ", ")
      .append("rxinstr=" + String.valueOf(getRxinstr()) + ", ")
      .append("rxreason=" + String.valueOf(getRxreason()) + ", ")
      .append("labsname=" + String.valueOf(getLabsname()) + ", ")
      .append("labsdosage=" + String.valueOf(getLabsdosage()) + ", ")
      .append("labsinstr=" + String.valueOf(getLabsinstr()) + ", ")
      .append("labsreason=" + String.valueOf(getLabsreason()) + ", ")
      .append("visitnotes=" + String.valueOf(getVisitnotes()))
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
  public static Report justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Report(
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
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      userID,
      doctorID,
      meetingid,
      reoporttype,
      date,
      summnaryname,
      summarydosage,
      summnaryinstr,
      summnaryreason,
      rxname,
      rxdosage,
      rxinstr,
      rxreason,
      labsname,
      labsdosage,
      labsinstr,
      labsreason,
      visitnotes);
  }
  public interface UserIdStep {
    ReoporttypeStep userId(String userId);
  }
  

  public interface ReoporttypeStep {
    DateStep reoporttype(ReportType reoporttype);
  }
  

  public interface DateStep {
    BuildStep date(Temporal.DateTime date);
  }
  

  public interface BuildStep {
    Report build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep doctorId(String doctorId);
    BuildStep meetingid(String meetingid);
    BuildStep summnaryname(String summnaryname);
    BuildStep summarydosage(String summarydosage);
    BuildStep summnaryinstr(String summnaryinstr);
    BuildStep summnaryreason(String summnaryreason);
    BuildStep rxname(String rxname);
    BuildStep rxdosage(String rxdosage);
    BuildStep rxinstr(String rxinstr);
    BuildStep rxreason(String rxreason);
    BuildStep labsname(String labsname);
    BuildStep labsdosage(String labsdosage);
    BuildStep labsinstr(String labsinstr);
    BuildStep labsreason(String labsreason);
    BuildStep visitnotes(String visitnotes);
  }
  

  public static class Builder implements UserIdStep, ReoporttypeStep, DateStep, BuildStep {
    private String id;
    private String userID;
    private ReportType reoporttype;
    private Temporal.DateTime date;
    private String doctorID;
    private String meetingid;
    private String summnaryname;
    private String summarydosage;
    private String summnaryinstr;
    private String summnaryreason;
    private String rxname;
    private String rxdosage;
    private String rxinstr;
    private String rxreason;
    private String labsname;
    private String labsdosage;
    private String labsinstr;
    private String labsreason;
    private String visitnotes;
    @Override
     public Report build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Report(
          id,
          userID,
          doctorID,
          meetingid,
          reoporttype,
          date,
          summnaryname,
          summarydosage,
          summnaryinstr,
          summnaryreason,
          rxname,
          rxdosage,
          rxinstr,
          rxreason,
          labsname,
          labsdosage,
          labsinstr,
          labsreason,
          visitnotes);
    }
    
    @Override
     public ReoporttypeStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.userID = userId;
        return this;
    }
    
    @Override
     public DateStep reoporttype(ReportType reoporttype) {
        Objects.requireNonNull(reoporttype);
        this.reoporttype = reoporttype;
        return this;
    }
    
    @Override
     public BuildStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }
    
    @Override
     public BuildStep doctorId(String doctorId) {
        this.doctorID = doctorId;
        return this;
    }
    
    @Override
     public BuildStep meetingid(String meetingid) {
        this.meetingid = meetingid;
        return this;
    }
    
    @Override
     public BuildStep summnaryname(String summnaryname) {
        this.summnaryname = summnaryname;
        return this;
    }
    
    @Override
     public BuildStep summarydosage(String summarydosage) {
        this.summarydosage = summarydosage;
        return this;
    }
    
    @Override
     public BuildStep summnaryinstr(String summnaryinstr) {
        this.summnaryinstr = summnaryinstr;
        return this;
    }
    
    @Override
     public BuildStep summnaryreason(String summnaryreason) {
        this.summnaryreason = summnaryreason;
        return this;
    }
    
    @Override
     public BuildStep rxname(String rxname) {
        this.rxname = rxname;
        return this;
    }
    
    @Override
     public BuildStep rxdosage(String rxdosage) {
        this.rxdosage = rxdosage;
        return this;
    }
    
    @Override
     public BuildStep rxinstr(String rxinstr) {
        this.rxinstr = rxinstr;
        return this;
    }
    
    @Override
     public BuildStep rxreason(String rxreason) {
        this.rxreason = rxreason;
        return this;
    }
    
    @Override
     public BuildStep labsname(String labsname) {
        this.labsname = labsname;
        return this;
    }
    
    @Override
     public BuildStep labsdosage(String labsdosage) {
        this.labsdosage = labsdosage;
        return this;
    }
    
    @Override
     public BuildStep labsinstr(String labsinstr) {
        this.labsinstr = labsinstr;
        return this;
    }
    
    @Override
     public BuildStep labsreason(String labsreason) {
        this.labsreason = labsreason;
        return this;
    }
    
    @Override
     public BuildStep visitnotes(String visitnotes) {
        this.visitnotes = visitnotes;
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
    private CopyOfBuilder(String id, String userId, String doctorId, String meetingid, ReportType reoporttype, Temporal.DateTime date, String summnaryname, String summarydosage, String summnaryinstr, String summnaryreason, String rxname, String rxdosage, String rxinstr, String rxreason, String labsname, String labsdosage, String labsinstr, String labsreason, String visitnotes) {
      super.id(id);
      super.userId(userId)
        .reoporttype(reoporttype)
        .date(date)
        .doctorId(doctorId)
        .meetingid(meetingid)
        .summnaryname(summnaryname)
        .summarydosage(summarydosage)
        .summnaryinstr(summnaryinstr)
        .summnaryreason(summnaryreason)
        .rxname(rxname)
        .rxdosage(rxdosage)
        .rxinstr(rxinstr)
        .rxreason(rxreason)
        .labsname(labsname)
        .labsdosage(labsdosage)
        .labsinstr(labsinstr)
        .labsreason(labsreason)
        .visitnotes(visitnotes);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder reoporttype(ReportType reoporttype) {
      return (CopyOfBuilder) super.reoporttype(reoporttype);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder doctorId(String doctorId) {
      return (CopyOfBuilder) super.doctorId(doctorId);
    }
    
    @Override
     public CopyOfBuilder meetingid(String meetingid) {
      return (CopyOfBuilder) super.meetingid(meetingid);
    }
    
    @Override
     public CopyOfBuilder summnaryname(String summnaryname) {
      return (CopyOfBuilder) super.summnaryname(summnaryname);
    }
    
    @Override
     public CopyOfBuilder summarydosage(String summarydosage) {
      return (CopyOfBuilder) super.summarydosage(summarydosage);
    }
    
    @Override
     public CopyOfBuilder summnaryinstr(String summnaryinstr) {
      return (CopyOfBuilder) super.summnaryinstr(summnaryinstr);
    }
    
    @Override
     public CopyOfBuilder summnaryreason(String summnaryreason) {
      return (CopyOfBuilder) super.summnaryreason(summnaryreason);
    }
    
    @Override
     public CopyOfBuilder rxname(String rxname) {
      return (CopyOfBuilder) super.rxname(rxname);
    }
    
    @Override
     public CopyOfBuilder rxdosage(String rxdosage) {
      return (CopyOfBuilder) super.rxdosage(rxdosage);
    }
    
    @Override
     public CopyOfBuilder rxinstr(String rxinstr) {
      return (CopyOfBuilder) super.rxinstr(rxinstr);
    }
    
    @Override
     public CopyOfBuilder rxreason(String rxreason) {
      return (CopyOfBuilder) super.rxreason(rxreason);
    }
    
    @Override
     public CopyOfBuilder labsname(String labsname) {
      return (CopyOfBuilder) super.labsname(labsname);
    }
    
    @Override
     public CopyOfBuilder labsdosage(String labsdosage) {
      return (CopyOfBuilder) super.labsdosage(labsdosage);
    }
    
    @Override
     public CopyOfBuilder labsinstr(String labsinstr) {
      return (CopyOfBuilder) super.labsinstr(labsinstr);
    }
    
    @Override
     public CopyOfBuilder labsreason(String labsreason) {
      return (CopyOfBuilder) super.labsreason(labsreason);
    }
    
    @Override
     public CopyOfBuilder visitnotes(String visitnotes) {
      return (CopyOfBuilder) super.visitnotes(visitnotes);
    }
  }
  
}
