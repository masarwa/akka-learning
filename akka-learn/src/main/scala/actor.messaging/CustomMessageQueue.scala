package actor.messaging

import akka.actor.ActorRef
import akka.dispatch.{Envelope, MessageQueue}

import java.util.concurrent.ConcurrentLinkedQueue

class CustomMessageQueue extends MessageQueue{
  private final val queue = new ConcurrentLinkedQueue[Envelope]()

  override def enqueue(receiver: ActorRef, handle: Envelope): Unit = {
    if(handle.sender.path.name == "AiserActor"){
      handle.sender ! "hey aiser, processing your request"
      queue.offer(handle)
    }else{
      handle.sender ! "not known sender, not processing"
    }

  }

  override def dequeue(): Envelope = queue.poll

  override def numberOfMessages: Int = queue.size

  override def hasMessages: Boolean = !queue.isEmpty

  override def cleanUp(owner: ActorRef, deadLetters: MessageQueue): Unit = {
    while(hasMessages){
      deadLetters.enqueue(owner, dequeue())
    }
  }
}
