package actor.messaging

import akka.actor.{ActorRef, ActorSystem}
import akka.dispatch.{MailboxType, MessageQueue, ProducesMessageQueue}
import com.typesafe.config.Config

class CustomUnboundedMailBox extends MailboxType with ProducesMessageQueue[CustomMessageQueue] {
  def this(settings: ActorSystem.Settings, config: Config) = {this()}

  final override def create(owner: Option[ActorRef], system: Option[ActorSystem]): MessageQueue = {
    new CustomMessageQueue()
  }
}
