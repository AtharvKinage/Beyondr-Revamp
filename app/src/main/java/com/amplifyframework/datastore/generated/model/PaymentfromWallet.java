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

/** This is an auto generated class representing the PaymentfromWallet type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "PaymentfromWallets")
public final class PaymentfromWallet implements Model {
  public static final QueryField ID = field("PaymentfromWallet", "id");
  public static final QueryField AMOUNT = field("PaymentfromWallet", "amount");
  public static final QueryField CURRENCY = field("PaymentfromWallet", "currency");
  public static final QueryField DATE = field("PaymentfromWallet", "date");
  public static final QueryField PAYMENTFROM = field("PaymentfromWallet", "paymentfrom");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String amount;
  private final @ModelField(targetType="String", isRequired = true) String currency;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime date;
  private final @ModelField(targetType="ID", isRequired = true) String paymentfrom;
  public String getId() {
      return id;
  }
  
  public String getAmount() {
      return amount;
  }
  
  public String getCurrency() {
      return currency;
  }
  
  public Temporal.DateTime getDate() {
      return date;
  }
  
  public String getPaymentfrom() {
      return paymentfrom;
  }
  
  private PaymentfromWallet(String id, String amount, String currency, Temporal.DateTime date, String paymentfrom) {
    this.id = id;
    this.amount = amount;
    this.currency = currency;
    this.date = date;
    this.paymentfrom = paymentfrom;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      PaymentfromWallet paymentfromWallet = (PaymentfromWallet) obj;
      return ObjectsCompat.equals(getId(), paymentfromWallet.getId()) &&
              ObjectsCompat.equals(getAmount(), paymentfromWallet.getAmount()) &&
              ObjectsCompat.equals(getCurrency(), paymentfromWallet.getCurrency()) &&
              ObjectsCompat.equals(getDate(), paymentfromWallet.getDate()) &&
              ObjectsCompat.equals(getPaymentfrom(), paymentfromWallet.getPaymentfrom());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getAmount())
      .append(getCurrency())
      .append(getDate())
      .append(getPaymentfrom())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("PaymentfromWallet {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("amount=" + String.valueOf(getAmount()) + ", ")
      .append("currency=" + String.valueOf(getCurrency()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("paymentfrom=" + String.valueOf(getPaymentfrom()))
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
  public static PaymentfromWallet justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new PaymentfromWallet(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      amount,
      currency,
      date,
      paymentfrom);
  }
  public interface AmountStep {
    CurrencyStep amount(String amount);
  }
  

  public interface CurrencyStep {
    DateStep currency(String currency);
  }
  

  public interface DateStep {
    PaymentfromStep date(Temporal.DateTime date);
  }
  

  public interface PaymentfromStep {
    BuildStep paymentfrom(String paymentfrom);
  }
  

  public interface BuildStep {
    PaymentfromWallet build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements AmountStep, CurrencyStep, DateStep, PaymentfromStep, BuildStep {
    private String id;
    private String amount;
    private String currency;
    private Temporal.DateTime date;
    private String paymentfrom;
    @Override
     public PaymentfromWallet build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new PaymentfromWallet(
          id,
          amount,
          currency,
          date,
          paymentfrom);
    }
    
    @Override
     public CurrencyStep amount(String amount) {
        Objects.requireNonNull(amount);
        this.amount = amount;
        return this;
    }
    
    @Override
     public DateStep currency(String currency) {
        Objects.requireNonNull(currency);
        this.currency = currency;
        return this;
    }
    
    @Override
     public PaymentfromStep date(Temporal.DateTime date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }
    
    @Override
     public BuildStep paymentfrom(String paymentfrom) {
        Objects.requireNonNull(paymentfrom);
        this.paymentfrom = paymentfrom;
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
    private CopyOfBuilder(String id, String amount, String currency, Temporal.DateTime date, String paymentfrom) {
      super.id(id);
      super.amount(amount)
        .currency(currency)
        .date(date)
        .paymentfrom(paymentfrom);
    }
    
    @Override
     public CopyOfBuilder amount(String amount) {
      return (CopyOfBuilder) super.amount(amount);
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
     public CopyOfBuilder paymentfrom(String paymentfrom) {
      return (CopyOfBuilder) super.paymentfrom(paymentfrom);
    }
  }
  
}
