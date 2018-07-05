package decision.engine

import decision.engine.operators._
import decision.engine.values.ValueType
import decision.model._
import shapeless.{Inl, Inr}

object Configuration {

  def runTestAgainst[UF <: FactAboutUser, TO <: Operator](
                                                           userFact: UF,
                                                           operator: TO,
                                                           toCompare: ValueType
                                                         ): Boolean = {
    (userFact, operator, toCompare) match {
      case (HowManyTimesLoginLastMonth(v), Equal(), Inl(v2)) => v == v2
      case (HowManyTimesLoginLastMonth(v), NotEqual(), Inl(v2)) => v != v2
      case (HowManyTimesLoginLastMonth(v), LowerThan(), Inl(v2)) => v < v2
      case (HowManyTimesLoginLastMonth(v), LowerThanEquals(), Inl(v2)) => v <= v2
      case (HowManyTimesLoginLastMonth(v), GreaterThan(), Inl(v2)) => v > v2
      case (HowManyTimesLoginLastMonth(v), GreaterThanEquals(), Inl(v2)) => v >= v2

      case (LikeIceCream(v), Equal(), Inr(Inr(Inl(v2)))) => v == v2
      case (LikeIceCream(v), NotEqual(), Inr(Inr(Inl(v2)))) => v != v2

      case (FromWhichCountry(v), Equal(), Inr(Inl(v2))) => v.equals(v2)
      case (FromWhichCountry(v), NotEqual(), Inr(Inl(v2))) => !v.equals(v2)

      case _ => false
    }
  }

}
