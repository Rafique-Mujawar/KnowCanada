package media.rafique.com.model.base;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 * Exectute inteface class. It works like ActionLisnte for Services.
 */
public interface ExecuteInterface<REQUEST> {
  /**
   * Common method to be called by All presenters.
   *
   * @param request Generic request
   */
  void executeService(REQUEST request);
}

