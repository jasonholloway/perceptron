package com.woodpigeon.perceptron2

import org.scalacheck.Prop.forAll
import org.scalacheck.Properties


object Perceptron {
  def perceive(weights: Any, input: Any) = ???
  def train(weights: Any, target: Any, input: Any) = ???
}


object PerceptronSpecification extends Properties("Perceptron") {

  import Perceptron.perceive
  import Perceptron.train

  type Weights = Array[Float]
  type Input = Array[Float]
  type Target = Array[Float]

  def getCost(target: Target)(attempt: Target) =
    (attempt,target).zipped.foldLeft(0F) {
      case (ac, (a, t)) => ac + Math.abs(t - a)
    }

  property("training weights gives better results") =
    forAll { (weights: Weights, input: Input, target: Target) =>
      val perceiveWith = (w: Weights) => perceive(w, input)
      val cost = getCost(target)(_)

      val betterWeights = train(weights, target, input)

      cost(perceiveWith(betterWeights)) < cost(perceiveWith(weights))
    }

}