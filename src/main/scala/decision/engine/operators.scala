package decision.engine


object operators {

  sealed trait Operator extends Product with Serializable

  case class Equal() extends Operator

  case class NotEqual() extends Operator

  case class GreaterThan() extends Operator

  case class GreaterThanEquals() extends Operator

  case class LowerThan() extends Operator

  case class LowerThanEquals() extends Operator

}