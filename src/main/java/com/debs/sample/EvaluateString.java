package com.debs.sample;

import java.util.Stack;

public class EvaluateString {

	public static int evaluate(String expression) {
		char[] tokens = expression.toCharArray();

		Stack<Integer> intStack = new Stack<Integer>();
		Stack<Character> charStack = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == ' ')
				continue;
			else if (tokens[i] >= 0 && tokens[i] <= 9) {
				StringBuffer sb = new StringBuffer();
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sb.append(tokens[i++]);
				intStack.push(Integer.parseInt(sb.toString()));
			} else if (tokens[i] == '(') {
				charStack.push(tokens[i]);
			} else if (tokens[i] == ')') {
				char operator = charStack.pop();
				while (operator == '(')
					operator = charStack.pop();
				int operand2 = intStack.pop();
				int operand1 = intStack.pop();
				int result = operate(operand1, operand2, operator);
				intStack.push(result);
			} else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				while (!charStack.isEmpty() && hasPrecedence(tokens[i], charStack.peek())) {
					int operand2 = intStack.pop();
					int operand1 = intStack.pop();
					intStack.push(operate(operand1, operand2, charStack.pop()));
				}
				charStack.push(tokens[i]);
			}

			// Entire expression has been parsed at this point, apply remaining
			// ops to remaining values
			while (!charStack.empty()) {
				int operand2 = intStack.pop();
				int operand1 = intStack.pop();
				intStack.push(operate(operand1, operand2, charStack.pop()));
			}
		}
		return intStack.pop();

	}

	private static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	private static int operate(int operand1, int operand2, char operator) {
		if (operator == '+')
			return operand1 + operand2;
		else if (operator == '-')
			return operand1 - operand2;
		else if (operator == '*')
			return operand1 * operand2;
		else if (operator == '/') {
			if (operand2 == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return operand1 / operand2;
		}

		else
			return 0;
	}

}
