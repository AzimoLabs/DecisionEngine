package decision.engine

import java.time.LocalDateTime

import shapeless.{:+:, CNil}

object values {
  type ValueType = Int :+: String :+: Boolean :+: Long :+: Float :+: LocalDateTime :+: CNil
}
