package actor.messaging

import akka.actor.Actor

import scala.util.Random.nextInt

class RandomNumberGenaratorActor extends Actor{
  import Messages._

  override def receive: Receive = {
    case GiveMeRandomNumber =>
      println("received request for new random number")
      val randomNumber = nextInt
      sender ! Done(randomNumber)
    case msg =>
      println(msg)
  }
}
