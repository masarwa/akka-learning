package actor.messaging

import akka.actor.{Actor, ActorRef}

class QueryActor extends Actor{
  import Messages._

  override def receive: Receive = {
    case Start(actorRef) =>
      println("send me the next int random number")
      actorRef ! GiveMeRandomNumber
    case Done(randomNumber) =>
      println(s"got random number $randomNumber")
    case msg =>
      println("******************")
      println(msg)
      println("******************")

  }
}
