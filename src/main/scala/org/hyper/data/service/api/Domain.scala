package org.hyper.data.service.api

trait DomainModel {
  case class User(name: String, age: Int, tags: Seq[String])

  val userRepo: UserRepository

  trait UserRepository {
    def add(user: User): Unit
    def findBy(name: String): Option[User]
    def list(): Seq[User]
  }
}

trait MemDomainModel extends DomainModel {
  import collection.mutable

  override lazy val userRepo = new MemUserRepository

  class MemUserRepository extends UserRepository {
    val users = new mutable.HashMap[String, User]
    add(User("ua", 23, Seq("java", "scala")))
    add(User("ub", 23, Seq("c#", ".net")))

    override def add(user: User): Unit = users += user.name -> user

    override def findBy(name: String): Option[User] = users.get(name)

    override def list(): Seq[User] = users.values.toSeq
  }
}
