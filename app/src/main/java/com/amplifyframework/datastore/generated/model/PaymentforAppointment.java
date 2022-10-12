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

/** This is an auto generated class representing the PaymentforAppointment type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "PaymentforAppointments")
public final class PaymentforAppointment implements Model {
  public static final QueryField ID = field("PaymentforAppointment", "id");
  public static final QueryField AMOUNT = field("PaymentforAppointment", "amount");
  public static final QueryField PAYMENTFROM = field("PaymentforAppointment", "paymentfrom");
  public static final QueryField CURRENCY = field("PaymentforAppointment", "currency");
  public static final QueryField DATE = field("PaymentforAppointment", "date");
  public static final QueryField PAYMENTTO = field("PaymentforAppointment", "paymentto");
  public static final QueryField APPOINTMENTID = field("PaymentforAppointment", "appointmentid");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String amount;
  private final @ModelField(targetType="ID", isRequired = true) String paymentfrom;
  private final @ModelField(targetType="String", isRequired = true) String currency;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  private final @ModelField(targetType="ID", isRequired = true) String paymentto;
  private final @ModelField(targetType="ID", isRequired = true) String appointmentid;
  public String getId() {
      return id;
  }
  
  public String getAmount() {
      return amount;
  }
  
  public String getPaymentfrom() {
      return paymentfrom;
  }
  
  public String getCurrency() {
      return currency;
  }
  
  public Temporal.DateTime getDate() {
      return date;
  }
  
  public String getPaymentto() {
      return paymentto;
  }
  
  public String getAppointmentid() {
      return appointmentid;
  }
  
  private PaymentforAppointment(String id, String amount, String paymentfrom, String currency, Temporal.DateTime date, String paymentto, String appointmentid) {
    this.id = id;
    this.amount = amount;
    this.paymentfrom = paymentfrom;
    this.currency = currency;
    this.date = date;
    this.paymentto = paymentto;
    this.appointmentid = appointmentid;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      PaymentforAppointment paymentforAppointment = (PaymentforAppointment) obj;
      return ObjectsCompat.equals(getId(), paymentforAppointment.getId()) &&
              ObjectsCompat.equals(getAmount(), paymentforAppointment.getAmount()) &&
              ObjectsCompat.equals(getPaymentfrom(), paymentforAppointment.getPaymentfrom()) &&
              ObjectsCompat.equals(getCurrency(), paymentforAppointment.getCurrency()) &&
              ObjectsCompat.equals(getDate(), paymentforAppointment.getDate()) &&
              ObjectsCompat.equals(getPaymentto(), paymentforAppointment.getPaymentto()) &&
              ObjectsCompat.equals(getAppointmentid(), paymentforAppointment.getAppointmentid());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getAmount())
      .append(getPaymentfrom())
      .append(getCurrency())
      .append(getDate())
      .append(getPaymentto())
      .append(getAppointmentid())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("PaymentforAppointment {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("amount=" + String.valueOf(getAmount()) + ", ")
      .append("paymentfrom=" + String.valueOf(getPaymentfrom()) + ", ")
      .append("currency=" + String.valueOf(getCurrency()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("paymentto=" + String.valueOf(getPaymentto()) + ", ")
      .append("appointmentid=" + String.valueOf(getAppointmentid()))
      .append("}")
      .toString();
  }
  
  public static AmountStep builder() {
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
  public static PaymentforAppointment justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new PaymentforAppointment(
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
      amount,
      paymentfrom,
      currency,
      date,
      paymentto,
      appointmentid);
  }
  public interface AmountStep {
    PaymentfromStep amount(String amount);
  }
  

  public interface PaymentfromStep {
    CurrencyStep paymentfrom(String paymentfrom);
  }
  

  public interface CurrencyStep {
    DateStep currency(String currency);
  }
  

  public interface DateStep {
    PaymenttoStep date(Temporal.DateTime date);
  }
  

  public interface PaymenttoStep {
    AppointmentidStep paymentto(String paymentto);
  }
  

  public interface AppointmentidStep {
    BuildStep appointmentid(String appointmentid);
  }
  

  public interface BuildStep {
    PaymentforAppointment build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements AmountStep, PaymentfromStep, CurrencyStep, DateStep, PaymenttoStep, AppointmentidStep, BuildStep {
    private String id;
    private String amount;
    private String paymentfrom;
    private String currency;
    private Temporal.DateTime date;
    private String paymentto;
    private String appointmentid;
    @Override
     public PaymentforAppointment build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new PaymentforAppointment(
          id,
          amount,
          paymentfrom,
          currency,
          date,
          paymentto,
          appointmentid);
    }
    
    @Override
     public PaymentfromStep amount(String amount) {
        Objects.requireNonNull(amount);
        this.amount = amount;
        return this;
    }
    
    @Override
     public CurrencyStep paymentfrom(String paymentfrom) {
        Objects.requireNonNull(paymentfrom);
        this.paymentfrom = paymentfrom;
        return this;
    }
    
    @Override
     public DateStep currency(String currency) {
        Objects.requireNonNull(currency);
        this.currency = currency;
        return this;
    }
    
    @Override
     public PaymenttoStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }
    
    @Override
     public AppointmentidStep paymentto(String paymentto) {
        Objects.requireNonNull(paymentto);
        this.paymentto = paymentto;
        return this;
    }
    
    @Override
     public BuildStep appointmentid(String appointmentid) {
        Objects.requireNonNull(appointmentid);
        this.appointmentid = appointmentid;
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
    private CopyOfBuilder(String id, String amount, String paymentfrom, String currency, Temporal.DateTime date, String paymentto, String appointmentid) {
      super.id(id);
      super.amount(amount)
        .paymentfrom(paymentfrom)
        .currency(currency)
        .date(date)
        .paymentto(paymentto)
        .appointmentid(appointmentid);
    }
    
    @Override
     public CopyOfBuilder amount(String amount) {
      return (CopyOfBuilder) super.amount(amount);
    }
    
    @Override
     public CopyOfBuilder paymentfrom(String paymentfrom) {
      return (CopyOfBuilder) super.paymentfrom(paymentfrom);
    }
    
    @Override
     public CopyOfBuilder currency(String currency) {
      return (CopyOfBuilder) super.currency(currency);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder paymentto(String paymentto) {
      return (CopyOfBuilder) super.paymentto(paymentto);
    }
    
    @Override
     public CopyOfBuilder appointmentid(String appointmentid) {
      return (CopyOfBuilder) super.appointmentid(appointmentid);
    }
  }
  
}
