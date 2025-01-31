@main
def ejercicios():Unit = {
  println("Ejercicios programacion funcional scala");
//1. Escribir una función entreNumeros(inicio: Int, fin: Int): List[Int] que
//retorne una lista que incluya todos los números enteros entre inicio y
//fin incluyéndolo
  //def entreNumeros(inicio:Int,fin:Int):List[Int] = (inicio to fin).toList forma facil

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
  def repetidoss(l1:List[Int],l2:List[Int]):List[Int]= {
    return Nil;
  }


  val numeros:List[Int] = List(29,9,96);
  println(numeros);

  val nombres:List[String] = List("Santiago","Luis","Ponce");
  println(nombres.map((s:String)=>{s.length()}))


  //Ejercicio practica: Escribir una funcion que reciba un numero y una lista de numeros y devuelva otra lista
  //con la diferencia entre cada elemento de la lista y el numero que son mayores a 10 solamente
  def f(n:Int,l:List[Int]):List[Int] = l.map((x:Int)=>math.abs(x-n)).filter((y:Int)=>y>10) //pipelining

  val l1:List[Int] = (5 to 50).by(5).toList;
  println(l1)
  println(f(10,l1))

  /*
  Escribir una funcion que reciba una lista de numeros y retorne otra con los 5 numeros mas frecuentes ordenada de mayor a menor
  * */
  val l2:List[Int] = List(1,2,3,3,3,3,3,4,6,6,7,2,3,1,4,6,7,3,2,8,22,4,5,7,8,9,3,2,34,5,63,13,4,3,22,356,8,5,2,1,1,1,2,3,4,5,2);
  def obtenerMasFrecuentes(l:List[Int],n:Int) : List[Int] = l.groupBy((x:Int)=>x).values.toList.sortBy((l:List[Int])=>l.length).reverse.map((l:List[Int])=>l.head).take(n)
  println(obtenerMasFrecuentes(l2,2))


  /*
  * Escribir una funcion que junte los numeros de una lista sin usar ordenamiento
  ejemplo  [1,2,3,5,4,2,3,1,7] -> [7,1,1,2,2,5,3,3,4]
  solucion:con gropuby  mequeda un mapa con key el valor y value lista de las ocurrencias
  ejemplo {(2,[2,2,2,2]),(5,[5,5,5,5,5])} luego obtengo los values con .values obtengo una lista de listas
  luego bajo y concateno con flatten
  * */

  def juntarNumeros(l:List[Int]):List[Int] = l.groupBy((x:Int)=>x).values.toList.flatten

  val l3:List[Int] = List(1,2,3,5,4,2,3,1,7)
  println(l3)
  println(juntarNumeros(l3))

  def esCapicua(s:String):Boolean = s.length match {
    case 0|1 => true
    case _ if (s.head == s.last) => esCapicua(s.substring(1,s.length-1))
    case _ => false
  }

  println(esCapicua("xyyyysx"))

  /*
  Escribir una funcion que retorne el maximo de una lista con match y sin
   */
  //precondicion no pasarle lista vacia
  def maximo(l:List[Int]):Int = l.length match  {
    case 1 => l.head
    case _ if(l.head > maximo(l.tail)) => l.head
    case _ => maximo(l.tail) //mal porque se llama 2 veces (muchas mas pues recursivo a la funcion recursiva) deberia guardarse en una variable
  }
  //precondicion lista no vacia
  def max(l:List[Int]):Int = l match {
    case x::Nil => x
    case xh::xt if(xh>xt.head) => max(xh::xt.tail)
    case xh::xt => max(l.tail)
  }

  val l4:List[Int] = List(2,4,6,7,3,44,5,7,1,8,99,56,4,3,2,444,3,22,333)
  println(maximo(l4))
  println(max(l4))

  /* 3. Escribir una función eliminarRepetidos(lista: List[Int]): List[Int] que retorne una nueva
    lista que contenga los mismos elementos que la original pero sin elementos repetidos. */
  def eliminarRepetidos(l:List[Int]):List[Int] = l.groupBy((e:Int) =>e).keys.toList
  val repetidos:List[Int] = List(1,2,3,4,5,6,7,8,1,1,1,2,3,4,5,4,3,2,3,4,5,4,2,5,6,33,55);
  println(repetidos)
  println(eliminarRepetidos(repetidos))

  /* 5:
  * escribir funcion suma  */

  def sumar(l:List[Int]):Int = l match {
    case xh::Nil => xh
    case xh::xt => xh + sumar(xt)
    case Nil => 0
  }

  val numerosAsumar:List[Int] = List(1,2,3,4,5,6,7)
  println(sumar(numerosAsumar))


  /*Ejercicio complejo 1 : .
  Escribir una función contar(palabras: List[String]): Map[String, Int]
  que retorne un mapa donde las claves sean las palabras de la lista pa-
  sada por parámetro y los valores la cantidad de apariciones que tiene
  dicha palabra en la lista
  */
  //importante para ver como mapear un MAPA
  def contar(palabras: List[String]): Map[String, Int] = {
    palabras.groupBy((palabra:String)=>palabra).map((k:String,v:List[String])=>(k,v.length))
  }

  val palabras :List[String] = List("Caballo","Rosa","Dios","Mate","Palo","Caballo","Auto");

  //println("santiago".equals("santiagos"))
  println(contar(palabras))



  /*
  * 2. Escribir una función topK(numeros: List[Int], k: Int, f: (Int, Int) =>Int):
  List[Int] que retorne una lista con los k elementos de números mas
  grandes según la función f. La respuesta debe estar ordenada segun el
  criterio de la función f.
  lembranca f(a,b) funcion de comparacion
  convencion a-b   f(a,b)= a-b si f(a,b)>0 a > b sino contrario 
  
  entonces deberias ordenarlos por la funcion f y retornar los 5 mayores
* */
  
  def topK(numeros: List[Int], k: Int, f: (Int, Int) =>Int):List[Int] = {
    numeros.sortWith((x:Int,y:Int)=>f(x,y) < 0).takeRight(k)
  }
  
  val numerosAordenar: List[Int] = List(3,4,5,6,3,1,3,4,6,7,8,44,32,45,3,21,2,67,4)
  println(topK(numerosAordenar,3,(x,y)=>x-y))
}