@main
def ejercicios():Unit = {
  println("Ejercicios programacion funcional scala");
//1. Escribir una función entreNumeros(inicio: Int, fin: Int): List[Int] que
//retorne una lista que incluya todos los números enteros entre inicio y
//fin incluyéndolo
  //def entreNumeros(inicio:Int,fin:Int):List[Int] = (inicio to fin).toList si pero no

  def entreNumeros(inicio:Int,fin:Int):List[Int] = inicio match {
    case x if inicio==fin => fin::Nil
    case _ => inicio::entreNumeros(inicio+1,fin)
  }
/*
  El pattern matching es por tipo de dato, valor LITERAL!  o estructura
  si queres matchear por el valor de una variable de argumento no va a funcionar!!!!
  es por eso que esta funcion no sirve:
  def entreNumeros(inicio:Int,fin:Int):List[Int] = inicio match {
    case fin => fin::Nil //esto siempre va a ocurrr porque no compara el valor de inicio con el valor de fin!
    case _ => inicio::entreNumeros(inicio+1,fin) //como lo primero siempre ocurre a esto no llegas nunca
  }
  por eso tenes que usar si o si la guard... medio que esta hecho como el ogt SORPRESA!
* */

  println(entreNumeros(5,14))

  /*2. Escribir una función repetidos(lista1: List[Int], lista2: List[Int]): List[Int]
  que retorne una nueva lista que contenga los elementos que están presentes en ambas listas.*/
  def repetidos(l1:List[Int],l2:List[Int]):List[Int]= {
    return Nil;
  }
  /* 3. Escribir una función eliminarRepetidos(lista: List[Int]): List[Int] que retorne una nueva
    lista que contenga los mismos elementos que la original pero sin elementos repetidos. */

  val numeros:List[Int] = List(29,9,96);
  println(numeros);

  val nombres:List[String] = List("Santiago","Luis","Ponce");
  println(nombres.map((s:String)=>{s.length()}))
}