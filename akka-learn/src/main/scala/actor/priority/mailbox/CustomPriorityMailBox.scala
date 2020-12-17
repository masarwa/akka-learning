package actor.priority.mailbox

import akka.actor.ActorSystem
import akka.dispatch.{PriorityGenerator, UnboundedPriorityMailbox}
import com.typesafe.config.Config

class CustomPriorityMailBox(settings: ActorSystem.Settings, config: Config) extends UnboundedPriorityMailbox (
    // Create a new PriorityGenerator, lower priority means more important
      PriorityGenerator {
      // Int Messages
      case x: Int => 1
      // String Messages
      case x: String => 0
      // Long messages
      case x: Long => 2
      // other messages
      case _ => 3
    }
)