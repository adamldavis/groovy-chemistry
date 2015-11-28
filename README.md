# groovy-chemistry

A Groovy library with DSL for computing atomic weights of compounds.

Call `Chemistry.calc` with a Closure. Chemistry uses `propertyMissing` to create either Element or Compound objects. 

A Compound is composed of elements. `Compound.elements` returns a Map of Element to Integer (the number of the given element in the compound):

	H2O.elements

The `weight` property gives the atomic weight of an element or compound:

	H.weight

You can add and subtract elements and compounds:

	H2O + Na2 - O

You can also multiply compounds by numbers:

	(Ca3+(PO4)*2).weight

Use `%` (mod) to determine the percentage by atomic weight of an element in a given compound:

	println "%Oxygen of Fe(NO3)3 = ${(Fe&(NO3)*3) % O}"

Use `/` (divide) to determine the number of an element in a given compound:

	println "#Oxygen in Fe(NO3)3 = ${(Fe&(NO3)*3) / O}"


