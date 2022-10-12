package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelProvider;
import com.amplifyframework.util.Immutable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  Contains the set of model classes that implement {@link Model}
 * interface.
 */

public final class AmplifyModelProvider implements ModelProvider {
  private static final String AMPLIFY_MODEL_VERSION = "521d690e5e9b884689a58964381fc5cc";
  private static AmplifyModelProvider amplifyGeneratedModelInstance;
  private AmplifyModelProvider() {
    
  }
  
  public static AmplifyModelProvider getInstance() {
    if (amplifyGeneratedModelInstance == null) {
      amplifyGeneratedModelInstance = new AmplifyModelProvider();
    }
    return amplifyGeneratedModelInstance;
  }
  
  /** 
   * Get a set of the model classes.
   * 
   * @return a set of the model classes.
   */
  @Override
   public Set<Class<? extends Model>> models() {
    final Set<Class<? extends Model>> modifiableSet = new HashSet<>(
          Arrays.<Class<? extends Model>>asList(User.class, Message.class, Appointment.class, UserDatabase.class, Doctor.class, Education.class, Experience.class, Certificates.class, Post.class, Likes.class, Comments.class, BookMark.class, PaymentRequest.class, PackagesBuy.class, Packages.class, BroadCast.class, Communities.class, ContactUs.class, Notifications.class, PaymentfromWallet.class, PaymentforWallet.class, PaymentforAppointment.class, WellnessPost.class, ReplyComments.class, Report.class, CoachPrescTask.class, ReportsShared.class, CommunityMessage.class, Allergies.class, Slots.class, Invite.class)
        );
    
        return Immutable.of(modifiableSet);
        
  }
  
  /** 
   * Get the version of the models.
   * 
   * @return the version string of the models.
   */
  @Override
   public String version() {
    return AMPLIFY_MODEL_VERSION;
  }
}
