package decision.model

sealed trait FactAboutUser extends Product with Serializable

final case class LikeIceCream(isItTrue: Boolean) extends FactAboutUser

final case class FromWhichCountry(country: String) extends FactAboutUser

final case class HowManyTimesLoginLastMonth(amount: Int) extends FactAboutUser