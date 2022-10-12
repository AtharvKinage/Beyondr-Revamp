package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import java.util.Objects;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the BookMark type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "BookMarks")
public final class BookMark implements Model {
  public static final QueryField ID = field("BookMark", "id");
  public static final QueryField USERID = field("BookMark", "userid");
  public static final QueryField BOOKMARKTYPE = field("BookMark", "bookmarktype");
  public static final QueryField DISCUSSIONGROUPID = field("BookMark", "discussiongroupid");
  public static final QueryField LIVEBROADCASTINGID = field("BookMark", "livebroadcastingid");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String userid;
  private final @ModelField(targetType="BookMarkType", isRequired = true)
  BookMarkType bookmarktype;
  private final @ModelField(targetType="ID") String discussiongroupid;
  private final @ModelField(targetType="ID") String livebroadcastingid;
  public String getId() {
      return id;
  }

  public String getUserid() {
      return userid;
  }

  public BookMarkType getBookmarktype() {
      return bookmarktype;
  }

  public String getDiscussiongroupid() {
      return discussiongroupid;
  }

  public String getLivebroadcastingid() {
      return livebroadcastingid;
  }

  private BookMark(String id, String userid, BookMarkType bookmarktype, String discussiongroupid, String livebroadcastingid) {
    this.id = id;
    this.userid = userid;
    this.bookmarktype = bookmarktype;
    this.discussiongroupid = discussiongroupid;
    this.livebroadcastingid = livebroadcastingid;
  }

  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      BookMark bookMark = (BookMark) obj;
      return ObjectsCompat.equals(getId(), bookMark.getId()) &&
              ObjectsCompat.equals(getUserid(), bookMark.getUserid()) &&
              ObjectsCompat.equals(getBookmarktype(), bookMark.getBookmarktype()) &&
              ObjectsCompat.equals(getDiscussiongroupid(), bookMark.getDiscussiongroupid()) &&
              ObjectsCompat.equals(getLivebroadcastingid(), bookMark.getLivebroadcastingid());
      }
  }

  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUserid())
      .append(getBookmarktype())
      .append(getDiscussiongroupid())
      .append(getLivebroadcastingid())
      .toString()
      .hashCode();
  }

  @Override
   public String toString() {
    return new StringBuilder()
      .append("BookMark {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("userid=" + String.valueOf(getUserid()) + ", ")
      .append("bookmarktype=" + String.valueOf(getBookmarktype()) + ", ")
      .append("discussiongroupid=" + String.valueOf(getDiscussiongroupid()) + ", ")
      .append("livebroadcastingid=" + String.valueOf(getLivebroadcastingid()))
      .append("}")
      .toString();
  }

  public static UseridStep builder() {
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
  public static BookMark justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new BookMark(
      id,
      null,
      null,
      null,
      null
    );
  }

  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      userid,
      bookmarktype,
      discussiongroupid,
      livebroadcastingid);
  }
  public interface UseridStep {
    BookmarktypeStep userid(String userid);
  }


  public interface BookmarktypeStep {
    BuildStep bookmarktype(BookMarkType bookmarktype);
  }


  public interface BuildStep {
    BookMark build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep discussiongroupid(String discussiongroupid);
    BuildStep livebroadcastingid(String livebroadcastingid);
  }


  public static class Builder implements UseridStep, BookmarktypeStep, BuildStep {
    private String id;
    private String userid;
    private BookMarkType bookmarktype;
    private String discussiongroupid;
    private String livebroadcastingid;
    @Override
     public BookMark build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();

        return new BookMark(
          id,
          userid,
          bookmarktype,
          discussiongroupid,
          livebroadcastingid);
    }

    @Override
     public BookmarktypeStep userid(String userid) {
        Objects.requireNonNull(userid);
        this.userid = userid;
        return this;
    }

    @Override
     public BuildStep bookmarktype(BookMarkType bookmarktype) {
        Objects.requireNonNull(bookmarktype);
        this.bookmarktype = bookmarktype;
        return this;
    }

    @Override
     public BuildStep discussiongroupid(String discussiongroupid) {
        this.discussiongroupid = discussiongroupid;
        return this;
    }

    @Override
     public BuildStep livebroadcastingid(String livebroadcastingid) {
        this.livebroadcastingid = livebroadcastingid;
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
    private CopyOfBuilder(String id, String userid, BookMarkType bookmarktype, String discussiongroupid, String livebroadcastingid) {
      super.id(id);
      super.userid(userid)
        .bookmarktype(bookmarktype)
        .discussiongroupid(discussiongroupid)
        .livebroadcastingid(livebroadcastingid);
    }
    
    @Override
     public CopyOfBuilder userid(String userid) {
      return (CopyOfBuilder) super.userid(userid);
    }
    
    @Override
     public CopyOfBuilder bookmarktype(BookMarkType bookmarktype) {
      return (CopyOfBuilder) super.bookmarktype(bookmarktype);
    }
    
    @Override
     public CopyOfBuilder discussiongroupid(String discussiongroupid) {
      return (CopyOfBuilder) super.discussiongroupid(discussiongroupid);
    }
    
    @Override
     public CopyOfBuilder livebroadcastingid(String livebroadcastingid) {
      return (CopyOfBuilder) super.livebroadcastingid(livebroadcastingid);
    }
  }
  
}
