@main
def ejercicios():Unit = {
  println("Ejercicios programacion funcional scala");
//1. Escribir una función entreNumeros(inicio: Int, fin: Int): List[Int] que
//retorne una lista que incluya todos los números enteros entre inicio y
//fin incluyéndolo
  def entreNumeros(inicio:Int,fin:Int):List[Int] = (inicio to fin).toList
  println(entreNumeros(5,14))

  /*2. Escribir una función repetidos(lista1: List[Int], lista2: List[Int]): List[Int]
  que retorne una nueva lista que contenga los elementos que están presentes en ambas listas.*/
  def repetidos(l1:List[Int],l2:List[Int]):List[Int]= {
    return Nil;
  }
  /* 3. Escribir una función eliminarRepetidos(lista: List[Int]): List[Int] que retorne una nueva
    lista que contenga los mismos elementos que la original pero sin elementos repetidos. */

  
}