import com.adamldavis.chem.*

Chemistry.calc {
    println "water=" + H2O.elements
    println "molecular weight of H=" + H.weight
    println Na2
    println H2O + Na2 - O
    println "AgNO2: ${AgNO2.weight}"
    println "NiSO3: ${NiSO3.weight}"
    println "Ca3(PO4)2: " + (Ca3+(PO4)*2).weight
    println "${HgSO4}: ${HgSO4.weight}"
    println "%Oxygen of Fe(NO3)3 = ${(Fe&(NO3)*3) % O}"
    println "#Oxygen in Fe(NO3)3 = ${(Fe&(NO3)*3) / O}"
    println "Fe(NO3)3 - Fe = ${(Fe&(NO3)*3) - Fe}"
}