@main
def hola():Unit = {
  println("Hola scala!");
  println("Funciones como tipos primera clase");

  def cuadrado(x:Int):Int = return x*x;
  //ASIGNACION a var y val
  var cuadradoVar = cuadrado;
  val cuadradoVal = cuadrado;
  println(cuadradoVal(5));

  //Pasaje como argumento
  def multiply(x:Int,f:(Int)=>Int):Int = {
    return x*f(x);
  } //media rara, pero es para hacer sqr(x)*x= cube

  println(multiply(2,cuadrado));
}

