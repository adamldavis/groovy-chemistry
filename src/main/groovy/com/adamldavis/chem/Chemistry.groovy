/** Copyright 2015, Adam L. Davis */
package com.adamldavis.chem

/**
 * @author adamldavis
 */
class Chemistry {

	public static void exec(Closure block) {
		block.delegate = new Chemistry()
		block()
	}

	public static void calc(Closure block) { exec(block) }

	def propertyMissing(String name) {
		def comp = new Compound(name)
		(comp.elements.size() == 1 && comp.elements.values()[0]==1) ? comp.elements.keySet()[0] : comp
	}

}
