package com.woodpigeon.perceptron

case class Input(vals: Seq[Float])

case class Output(vals: Seq[Float])

case class Perceptron(weights: Seq[Float]) {
	def speculate(input: Input): Output
		= ???

	def correct(ideal: Output, real: Output): Perceptron
		= ???

}
