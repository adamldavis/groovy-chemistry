/** Copyright 2015, Adam L. Davis */
package com.adamldavis.chem

import groovy.transform.EqualsAndHashCode
import groovy.transform.TypeChecked

import java.util.regex.Matcher

/**
 * Represents an atomic element, ie Oxygen.
 * 
 * @author adamldavis
 */
@TypeChecked
@EqualsAndHashCode
class Element {

	final String symbol
	final String name
	final double weight
	
	static Map<String,String> names
	static Map<String,Double> weights
	
	Element(String symbol) {
		if (!names) {
			Element.init()
		}
		this.symbol = symbol
		this.name = names[symbol]
		this.weight = weights[symbol]
		if (!name) throw new IllegalArgumentException("$symbol not an Element")
	}
	
	String toString() {name}

	def plus(Compound other) { new Compound([(this):1] + other.elements) }

	def and(Compound other) { plus(other) }
	
	static List<Element> extractElementsFrom(String str) {
		if (!names) {
			Element.init()
		}
		List<Element> elements = []
		if (names.containsKey(str)) elements << new Element(str)
		else {
			Matcher matcher = str =~ /([A-Z][a-z]?)[1-9]?/
			while (matcher.find()) {
				//println "match=${matcher.group(1)}"
				elements << new Element(matcher.group(1))
			}
		}
		elements
	}
	
	static init() {
		names = [:]
		weights = [:]
		def tableStr = Element.getResourceAsStream('atomic.table')
		List<String> symbols = []
		List<String> values = []
		tableStr.eachLine { String line ->
			if (symbols.empty) symbols = line.tokenize(',')
			else {
				values = line.tokenize(',')
				for (int i in 0..values.size()-1) 
					weights[symbols[i]] = values[i] as double
					
				symbols.clear()
				values.clear()
			}
		}
		def nameStr = Element.getResourceAsStream('atomic.names')
		nameStr.eachLine {
			def split = it.split(' ')
			if (it.length() > 0) names.put(split[0], split[1])
		}
	}
}
