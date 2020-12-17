package actor.messaging

import akka.actor.{ActorSystem, Props}

object MessagingMain extends App {
  import Messages._

  val actorSystem = ActorSystem("messagingSystem")
  val randomNumberGenaratorActor = actorSystem.actorOf(Props[RandomNumberGenaratorActor], "randomNumberActor")
  val queryActor = actorSystem.actorOf(Props[QueryActor], "queryActor")

  queryActor ! Start(randomNumberGenaratorActor)
  queryActor ! Start(randomNumberGenaratorActor)


  val randomNumberGenaratorActorWithCustomDispatcher = actorSystem.actorOf(Props[RandomNumberGenaratorActor].withDispatcher("custom-dispatcher"))
  val queryActorAiser = actorSystem.actorOf(Props[QueryActor],"AiserActor")
  queryActorAiser !  Start(randomNumberGenaratorActorWithCustomDispatcher)
  queryActor !  Start(randomNumberGenaratorActorWithCustomDispatcher)
}
