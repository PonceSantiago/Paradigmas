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



  println("Listas en Scala");
  //CONSTRUCTORES
  val numeros:List[Int] = List(1,2,3,4,5,6,7,8,9,10); //lista de numeros
  val nombres:List[String] = List("Aimara","Delfina","Dorosuc");//lista de nombres
  val rango:List[Int] = (1 to 3).toList;//Constructor por rango
  val rangoPaso:List[Int] = (1 to 10).by(2).toList;//Constructor por rango con un paso de 2
  val rangoHasta:List[Int]= (1 until 5).toList; //Constructor por rango HASTA 5

  println(numeros);
  println(nombres);
  println(rango);
  println(rangoPaso)
  println(rangoHasta)

  //head y tail
  println(nombres.head);
  println(nombres.tail);

  //Metodos
  numeros.drop(5); //DROP:Te devuelve una nueva lista sin los primeros 5 elementos DROPEA, la original no cambia
  println(numeros.drop(5))

  numeros.dropWhile(x=>{x%2==0});
  println((numeros.dropWhile(x=>{x%2==0})))

  println(numeros.filter(_<5))//filtro

  //concatenar listas
  var juegosPs1:List[String] = List("Metal Gear:Solid","Rayman:The great escape","Shadow Man");
  var jugosPs2:List[String] = List("God of war","Gun","Shadow of rome");

  println(juegosPs1)
  println(jugosPs2)

  var juegos:List[String] = juegosPs1:::jugosPs2; //concatenacion: los nodos se reutilizan en la nueva lista
  var jueguitos:List[String]= juegosPs1++jugosPs2;
  println(juegos)
  println(jueguitos)

  println(juegosPs1)
  println(jugosPs2)

  var juegosAgregados:List[String] = "Driver"::juegosPs1;//Agrego juego a lista (lista nueva realmente)
  println(juegosPs1)
  println(juegosAgregados);



  //FLATTEN (IMPORTANTE) BAJA UN NIVEL Y CONCATENA
  var matrix:List[List[Int]] = List(List(1,2,3,4),List(14,4),List(1,6,4))
  println(matrix);
  println(matrix.flatten);


  //Pattern Matching
  println("Pattern matching")

  //pattern matching por tipo
  def typeMatching(t:Any):String = t match {
    case i:Int => "Entero";
    case s:String => "String";
    case b:Boolean => "Boolean";
    case _ => "Other";
  }

  println(typeMatching('s'))
  println(typeMatching(true))
  println(typeMatching(2))


//Pattern matching por valor
  def valueMatching(v:Int):String = v match{
    case 0 => "Cero";
    case 1 => "Uno";
    case _ => "OTRO";
  }

  println(valueMatching(1))

  //Pattern matching por estructura
  def structureMatching(l:List[Int]):String = l match {
    case Nil => "Lista vacia";
    case xh::Nil => "Lista un solo elemento";
    case xh::xt => "Lista mas de un elemento"
  }

  println(structureMatching(List()))
  println(structureMatching(List(1)))
  println(structureMatching(List(2,3,4)))

  //recursividad
  var listaSuma:List[Int] = List(1,3,4,5,76,7)
  def suma(l:List[Int]):Int = l match{
    case Nil => 0;
    case xh::xt =>xh+suma(xt);
  }
  println(suma(listaSuma))

//  GUARDS
  var numeritos: List[Int] = List(1, 3, 4, 5, 76, 7)

  def sumarPares(l: List[Int]): Int = l match {
    case Nil => 0;
    case xh::xt if esPar(xh)=> xh + sumarPares(xt);//guard
    case xh::xt => sumarPares(xt)
  }
  println(sumarPares(numeritos))


  //Laziness
  //infinite:si la llamas EXPLOTA
  def infinite(): Int = {
    return 1 + infinite();
  }

  def duplicarPrimero(x: Int, y: Int): Int = {
    return 2 * x; //no utiliza el segundo param
  }

  //duplicarPrimero(2, infinite()); // y=infinite() no se utiliza pero se llama igual EXPLOTA!
  //call by value (llamada por valor) no se utiliza pero se evalua igual entonces estala

  def duplicarPrimeroByName(x: Int, y: => Int): Int = {
    return 2 * x; //no utiliza el segundo param
  }
  println(duplicarPrimeroByName(2,infinite()));


  lazy val inf = infinite();


  //Map y filter

  val pesos:List[Int] = List(45,55,68,45,66,33,44,56,78,34,62,45,21,55,55);
  def esPesado(peso:Int) : Boolean = peso>45

  println(pesos.filter(esPesado))
  println(pesos.filter((x:Int)=>x%2==0))//con funcion anonima como criterio

  println(pesos.map((x:Int)=>x*2))


  //For each
  println(pesos.foreach((x:Int)=>println(x)))
  println(pesos)

  //Group by
  val novias:List[String] = List("Angeles","Camila","Aimara","Rocio")
  println(novias)

  var mapa = novias.groupBy((nombre:String)=>nombre.length) //la key es el criterio, la funcion anonima devuelve el criterio que es la key
  println(mapa)

  //VECTOR
  var mascotas: Vector[String] = Vector("perro", "gato", "pato");
  var salvajes: Vector[String] = Vector("Leon", "Puma", "Elefante");

  //Direccionamiento: con () y no con []como es habitual en todos los lenguajes
  println(salvajes(0)); //Leon
  //Concatenacion
  val animales = mascotas ++ salvajes;
  println(animales)
  //Insercion al final
  val salvajesExtendido = salvajes :+ "Hipopotamo"

  println(salvajes)
  println(salvajesExtendido)

  //MAPA
  var cumpleaños:Map[String,String] = Map("Barbi"->"09-04-1994","Santiago"->"29-09-1996")
  println(cumpleaños)
  println(cumpleaños.get("Santiago"))
  cumpleaños = cumpleaños + ("Pepo"->"31-01-99")
  println(cumpleaños)


}

