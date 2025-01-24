@main
def hola():Unit = {
  println("Hola scala!");

  println("1:Funciones de orden superior");
  def esPar(x:Int):Boolean = {
    return x%2==0;
  }
  println(esPar(2));
  println(esPar(3))
  val l:List[Int] = List(1,2,3,4,5,6,7,8,9,10,11,12,13,14);//lista original
  println(l);

  def filtrarLista(l:List[Int],f:(Int)=>Boolean) : List[Int] =l match {
    case Nil => List()
    case (xh::xt) if f(xh) => xh::filtrarLista(xt,f)
    case (xh::xt) => filtrarLista(xt,f)
  }

  val nl:List[Int]=filtrarLista(l,esPar);
  println(nl)
}

