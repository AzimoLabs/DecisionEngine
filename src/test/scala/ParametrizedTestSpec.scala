import decision.engine.operators.Equal
import decision.engine.values.ValueType
import decision.engine.{Test, DecisionEngine}
import decision.model.{HowManyTimesLoginLastMonth, LikeIceCream}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{FlatSpec, Inside, Matchers}
import shapeless.Coproduct

import scala.reflect.ClassTag

class ParametrizedTestSpec extends FlatSpec with ScalaFutures with Matchers with Inside {

  "Test case UserTransactionLastYear  " should " evaluate test case correctly" in {
    val enjoyIceCream = Test(ClassTag.apply(classOf[LikeIceCream]), Equal(), Coproduct[ValueType](true))
    val login10Times = Test(ClassTag.apply(classOf[HowManyTimesLoginLastMonth]), Equal(), Coproduct[ValueType](10))

    val validator = new DecisionEngine()

    val correctListOfFacts = List(LikeIceCream(true), HowManyTimesLoginLastMonth(10))
    val incorrectListOfFacts = List(HowManyTimesLoginLastMonth(11), LikeIceCream(false))

    val result = validator.check(correctListOfFacts, List(enjoyIceCream, login10Times))
    val result2 = validator.check(incorrectListOfFacts, List(enjoyIceCream, login10Times))

    result shouldEqual Some("COUPON")
    result2 shouldEqual None
  }
}