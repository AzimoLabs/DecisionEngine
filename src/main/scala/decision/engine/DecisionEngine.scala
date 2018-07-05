package decision.engine

import decision.model.FactAboutUser

class DecisionEngine {

  /**
    * Run all test in test case against incoming facts.
    *
    * @param facts - list of all user facts
    * @param tests - list of test which we be run against facts
    * @return - If all tests passed then test case return some COUPON, if any test failed then test case fail
    */
  def check(
             facts: List[FactAboutUser],
             tests: List[Test]
           ): Option[String] = {
    val multipleTestResult = tests.map(testFact => {
      for {
        userFact <- facts.find(testFact.factType.unapply(_).isDefined)
      } yield Configuration.runTestAgainst(userFact, testFact.operator, testFact.valueForTest)
    }
    ).foldLeft(List.empty[Boolean])((acc, el) => acc :+ el.getOrElse(false))

    /**
      * All tests must pass (return true). If at least one didn't we do not match facts with test case.
      */
    if (!multipleTestResult.contains(false)) {
      Some("COUPON")
    } else {
      None
    }
  }

}
