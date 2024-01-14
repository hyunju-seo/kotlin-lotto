package stringcalculator

import stringcalculator.parser.ExpressionParser
import stringcalculator.parser.RegexExpressionParser

class StringCalculator(private val parser: ExpressionParser) {
    fun add(input: String): Operand {
        val operands = parser.getOperands(input)
        return addAll(operands)
    }

    private fun addAll(operands: List<Operand>): Operand {
        return operands.reduce { acc, operand -> acc + operand }
    }
}

fun main() {
    val calculator = StringCalculator(RegexExpressionParser)
    print("입력: ")
    val input = readln()
    val result = calculator.add(input)
    println("덧셈 결과: ${result.value}")
}