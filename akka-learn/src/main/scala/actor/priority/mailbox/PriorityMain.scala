package actor.priority.mailbox

import actor.messaging.RandomNumberGenaratorActor
import akka.actor.{ActorSystem, Props}

object PriorityMain extends App {

  val actorSystem = ActorSystem("messagingSystem")
  val randomNumberGenaratorActorWithPriorityDispatcher = actorSystem.actorOf(Props[RandomNumberGenaratorActor].withDispatcher("prio-dispatcher"))
  randomNumberGenaratorActorWithPriorityDispatcher ! 6.0
  randomNumberGenaratorActorWithPriorityDispatcher ! 1
  randomNumberGenaratorActorWithPriorityDispatcher ! 5.0
  randomNumberGenaratorActorWithPriorityDispatcher ! 3
  randomNumberGenaratorActorWithPriorityDispatcher ! "hello aiser"
  randomNumberGenaratorActorWithPriorityDispatcher ! 5
  randomNumberGenaratorActorWithPriorityDispatcher ! "I am prio"
  randomNumberGenaratorActorWithPriorityDispatcher ! "I am prio, text first"
  randomNumberGenaratorActorWithPriorityDispatcher ! "I am prio, text first, other text"
}
