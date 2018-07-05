package decision.engine

import decision.engine.operators.Operator
import decision.engine.values.ValueType
import decision.model.FactAboutUser

import scala.reflect.ClassTag

case class Test(
                 factType: ClassTag[_ <: FactAboutUser],
                 operator: Operator,
                 valueForTest: ValueType
               )