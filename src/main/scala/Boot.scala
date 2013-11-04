import akka.actor.{Props, ActorSystem}
import spray.servlet.WebBoot

/**
 * @author Marcin Pieciukiewicz
 */
class Boot extends WebBoot {

  // we need an ActorSystem to host our application in
  val system = ActorSystem("example")

  // the service actor replies to incoming HttpRequests
  val serviceActor = system.actorOf(Props[DefaultListener], "listener")

  system.registerOnTermination {
    // put additional cleanup code here
    system.log.info("Application shut down")
  }
}