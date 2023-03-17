package ryancv.othello;

import com.mrjaffesclass.apcs.messenger.*;

public class Model implements MessageHandler {

  // Messaging system for the MVC
  private final Messenger mvcMessaging;


  public Model(Messenger messages) {
    mvcMessaging = messages;
  }
  
  /**
   * Initialize the model here and subscribe to any required messages
   */
  public void init() {
  }
  
  @Override
  public void messageHandler(String messageName, Object messagePayload) {
    
  }

  

}
