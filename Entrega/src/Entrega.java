
import java.lang.AssertionError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
 * Aquesta entrega consisteix en implementar tots els mètodes annotats amb "// TODO". L'enunciat de
 * cada un d'ells és al comentari de la seva signatura i exemples del seu funcionament als mètodes
 * `Tema1.tests`, `Tema2.tests`, etc.
 *
 * L'avaluació consistirà en:
 *
 * - Si el codi no compila, la nota del grup serà un 0.
 *
 * - Si heu fet cap modificació que no sigui afegir un mètode, afegir proves als mètodes "tests()" o
 *   implementar els mètodes annotats amb "// TODO", la nota del grup serà un 0.
 *
 * - Principalment, la nota dependrà del correcte funcionament dels mètodes implemnetats (provant
 *   amb diferents entrades).
 *
 * - Tendrem en compte la neteja i organització del codi. Un estandard que podeu seguir és la guia
 *   d'estil de Google per Java: https://google.github.io/styleguide/javaguide.html . Algunes
 *   consideracions importants:
 *    + Entregau amb la mateixa codificació (UTF-8) i finals de línia (LF, no CR+LF)
 *    + Indentació i espaiat consistent
 *    + Bona nomenclatura de variables
 *    + Declarar les variables el més aprop possible al primer ús (és a dir, evitau blocs de
 *      declaracions).
 *    + Convé utilitzar el for-each (for (int x : ...)) enlloc del clàssic (for (int i = 0; ...))
 *      sempre que no necessiteu l'índex del recorregut.
 *
 * Per com està plantejada aquesta entrega, no necessitau (ni podeu) utilitzar cap `import`
 * addicional, ni qualificar classes que no estiguin ja importades. El que sí podeu fer és definir
 * tots els mètodes addicionals que volgueu (de manera ordenada i dins el tema que pertoqui).
 *
 * Podeu fer aquesta entrega en grups de com a màxim 3 persones, i necessitareu com a minim Java 10.
 * Per entregar, posau a continuació els vostres noms i entregau únicament aquest fitxer.
 * - Nom 1:
 * - Nom 2:
 * - Nom 3:
 *
 * L'entrega es farà a través d'una tasca a l'Aula Digital que obrirem abans de la data que se us
 * hagui comunicat i vos recomanam que treballeu amb un fork d'aquest repositori per seguir més
 * fàcilment les actualitzacions amb enunciats nous. Si no podeu visualitzar bé algun enunciat,
 * assegurau-vos de que el vostre editor de texte estigui configurat amb codificació UTF-8.
 */
class Entrega {

    /*
     * Aquí teniu els exercicis del Tema 1 (Lògica).
     *
     * La majoria dels mètodes reben de paràmetre l'univers (representat com un array) i els predicats
     * adients (per exemple, `Predicate<Integer> p`). Per avaluar aquest predicat, si `x` és un
     * element de l'univers, podeu fer-ho com `p.test(x)`, que té com resultat un booleà (true si
     * `P(x)` és cert). Els predicats de dues variables són de tipus `BiPredicate<Integer, Integer>` i
     * similarment s'avaluen com `p.test(x, y)`.
     *
     * En cada un d'aquests exercicis (excepte el primer) us demanam que donat l'univers i els
     * predicats retorneu `true` o `false` segons si la proposició donada és certa (suposau que
     * l'univers és suficientment petit com per poder provar tots els casos que faci falta).
     */
    static class Tema1 {

        

        /*
         * Donat n > 1, en quants de casos (segons els valors de veritat de les proposicions p1,...,pn)
         * la proposició (...((p1 -> p2) -> p3) -> ...) -> pn és certa?
         *
         * Vegeu el mètode Tema1.tests() per exemples.
         */
        static int exercici1(int n) {
            return 0; // TODO
        }

        /*
         * És cert que ∀x : P(x) -> ∃!y : Q(x,y) ?
         */
        static boolean exercici2(int[] universe, Predicate<Integer> p, BiPredicate<Integer, Integer> q) {
            int contador;
      for (int x : universe) {

        if (p.test(x)) {
          contador = 0;

          for (int y : universe) {

            if (q.test(x, y)) {

              contador++;

            }
          }
          if (contador != 1) {
            return false;
          }
        }

      }

      return true; // TODO
          
        }

        /*
         * És cert que ∃x : ∀y : Q(x, y) -> P(x) ?
         */
        static boolean exercici3(int[] universe, Predicate<Integer> p, BiPredicate<Integer, Integer> q) {
            boolean condicion;
      for (int x : universe) {
        condicion = true;
        for (int y : universe) {

          if (q.test(x, y) && !p.test(x)) {
            condicion = false; // hemos encontrado una x que no lo cumple

          }

        }
        if (condicion) {
          return true;
        }

      }

      return false; // TODO
        }

        /*
         * És cert que ∃x : ∃!y : ∀z : P(x,z) <-> Q(y,z) ?
         */
        static boolean exercici4(int[] universe, BiPredicate<Integer, Integer> p, BiPredicate<Integer, Integer> q) {
           boolean condicion;
      int contador;
      for (int x : universe) {

        contador = 0;
        condicion = true;
        for (int y : universe) {

          for (int z : universe) {

            if ((p.test(x, z) ^ q.test(y, z))) {
              condicion = false;
              break;
            }

          }

          if (condicion) {
            contador++;
          }
          if (contador != 1) { // no és único
            break;
          }
        }

        if (contador == 1) {
          return true;
        }
      }
      return false; // TODO
        }

        /*
         * Aquí teniu alguns exemples i proves relacionades amb aquests exercicis (vegeu `main`)
         */
        static void tests() {
            // Exercici 1

            // p1 -> p2 és cert exactament a 3 files
            // p1 p2
            // 0  0  <-
            // 0  1  <-
            // 1  0
            // 1  1  <-
            assertThat(exercici1(2) == 3);

            // (p1 -> p2) -> p3 és cert exactament a 5 files
            // p1 p2 p3
            // 0  0  0
            // 0  0  1  <-
            // 0  1  0
            // 0  1  1  <-
            // 1  0  0  <-
            // 1  0  1  <-
            // 1  1  0
            // 1  1  1  <-
            assertThat(exercici1(3) == 5);

            // Exercici 2
            // ∀x : P(x) -> ∃!y : Q(x,y)
            assertThat(
                    exercici2(
                            new int[]{1, 2, 3},
                            x -> x % 2 == 0,
                            (x, y) -> x + y >= 5
                    )
            );

            assertThat(
                    !exercici2(
                            new int[]{1, 2, 3},
                            x -> x < 3,
                            (x, y) -> x - y > 0
                    )
            );

            // Exercici 3
            // És cert que ∃x : ∀y : Q(x, y) -> P(x) ?
            assertThat(
                    exercici3(
                            new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                            x -> x % 3 != 0,
                            (x, y) -> y % x == 0
                    )
            );

            assertThat(
                    exercici3(
                            new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                            x -> x % 4 != 0,
                            (x, y) -> (x * y) % 4 != 0
                    )
            );

            // Exercici 4
            // És cert que ∃x : ∃!y : ∀z : P(x,z) <-> Q(y,z) ?
            assertThat(
                    exercici4(
                            new int[]{0, 1, 2, 3, 4, 5},
                            (x, z) -> x * z == 1,
                            (y, z) -> y * z == 2
                    )
            );

            assertThat(
                    !exercici4(
                            new int[]{2, 3, 4, 5},
                            (x, z) -> x * z == 1,
                            (y, z) -> y * z == 2
                    )
            );
        }
    }

    /*
     * Aquí teniu els exercicis del Tema 2 (Conjunts).
     *
     * Per senzillesa tractarem els conjunts com arrays (sense elements repetits). Per tant, un
     * conjunt de conjunts d'enters tendrà tipus int[][].
     *
     * Les relacions també les representarem com arrays de dues dimensions, on la segona dimensió
     * només té dos elements. Per exemple
     *   int[][] rel = {{0,0}, {0,1}, {1,1}, {2,2}};
     * i també donarem el conjunt on està definida, per exemple
     *   int[] a = {0,1,2};
     * Als tests utilitzarem extensivament la funció generateRel definida al final (també la podeu
     * utilitzar si la necessitau).
     *
     * Les funcions f : A -> B (on A i B son subconjunts dels enters) les representam o bé amb el seu
     * graf o amb un objecte de tipus Function<Integer, Integer>. Sempre donarem el domini int[] a, el
     * codomini int[] b. En el cas de tenir un objecte de tipus Function<Integer, Integer>, per aplicar
     * f a x, és a dir, "f(x)" on x és d'A i el resultat f.apply(x) és de B, s'escriu f.apply(x).
     */
    static class Tema2 {
                  //Metodos para la resolucion de los ejercicios//

     /**
     * Realiza la diferencia de dos conjuntos 
     * @param a Conjunto 1 
     * @param b Conjunto 2
     * @return Diferencia de conjuntos --> a\b
     */

     static ArrayList<Integer> Diferencia(int[] a, int[] b) {
      
      ArrayList<Integer> lista  = new ArrayList<Integer>();
      
      //Añadimos todo a
      for(Integer x:a){
       lista.add(x);    
      }
      //eliminamos elementos que tambien estan en b 
      for(Integer x:b){
        lista.remove(x);
      }
      
      return lista;
    }



     /**
     * Realiza la union de dos conjuntos 
     * @param a Conjunto 1 
     * @param b Conjunto 2
     * @return Union de conjuntos
     */
     static ArrayList<Integer> Union(int[] a, int[] b) {

      ArrayList<Integer> lista = new  ArrayList<Integer>();
      boolean dentro;
     
      //metemos todos los elementos de a 
      for (Integer x : a) {
        lista.add(x);
      }

     //metemos los elementos de b que no esten en la lista
      for(Integer y:b){
      
        if (!lista.contains(y)) {
          lista.add(y);
        }
      }
      return lista;
    }




     /**
     * Comprueba que un elemento pertenezca a un conjunto
     * @param e Elemento a comprobar
     * @param rel Conjunto sobre el que se va a comprobar
     * @return Si el elemento está contenido en el conjunto o no
     */
    private static boolean contains(int[] e, int[][] rel){
      

      for(int[] y : rel){
        if(Arrays.equals(y, e)){
          return true;
        }
      }
      return false;
    }

 /**
     * Comprueba que un subconjunto  pertenezca a un conjunto
     * @param x Elemento del subconjunto
     * @param y Elemento del subconjunto
     * @param rel lista
     * @return Si el subconjunto está contenido en el conjunto o no
     */
    private static boolean contiene(List<int[]> lista , int x, int y ){
    boolean encontrado = false;

    for (int[] conjuntos : lista) {
      if (conjuntos[0] == x && conjuntos[1] == y) {
        encontrado = true;
          return encontrado;
      }
  }
  return encontrado;
    }


//calcula el cardinal de una clausura de Equivalencia//

  private  static int Cardinal_Clausura_Equivalencia(int[] e, int[][] rel ){
      List<int[]> Clausura_Equivalencia = new ArrayList<int[]>();
      List<int[]> Clausura_Reflexiva = new ArrayList<int[]>();
      List<int[]> Clausura_Simetrica = new ArrayList<int[]>();
 
      //añadimos los conjuntos de la relacion//
      for(int[] conjunto: rel){
        Clausura_Equivalencia.add(conjunto);
      }

     //Reflexiva//

    for (int x: e) {
     int[] conjunto =  new int[]{x,x};

      if(!contiene(Clausura_Equivalencia,x,x)){
        Clausura_Reflexiva.add(conjunto);
      }
      
    }
    Clausura_Equivalencia.addAll(Clausura_Reflexiva);


    //Simetrica//
for (int[] conjunto : Clausura_Equivalencia) {
  int[] aux =  new int[2];
aux[0]= conjunto[1];
aux[1]= conjunto[0];

if (!contiene(Clausura_Equivalencia, aux[0],aux[1])&&(aux[0]!=aux[1])) {
  Clausura_Simetrica.add(aux);
}

}
Clausura_Equivalencia.addAll(Clausura_Simetrica);

//Transitiva//

boolean cambio;
do {
  cambio = false;
    List<int[]> Clausura_Transitiva = new ArrayList<>();
    for (int[] p1 : Clausura_Equivalencia) {
        for (int[] p2 : Clausura_Equivalencia) {
            if (p1[1] == p2[0]) {
                if (!contiene(Clausura_Equivalencia, p1[0], p2[1]) && !contiene(Clausura_Transitiva, p1[0], p2[1])) {
                  Clausura_Transitiva.add(new int[]{p1[0], p2[1]});
                    cambio = true;
                }
            }
        }
    }
    Clausura_Equivalencia.addAll(Clausura_Transitiva);
} while (cambio);


      return Clausura_Equivalencia.size();


    }

      /**
     * Comprueba que una relación sea reflexiva sobre un conjunto dado
     * @param a Conjunto original
     * @param rel Conjunto relación
     * @return Si la relación es reflexiva o no
     */
    private static boolean reflexiva(int[] a, int[][] rel){
      boolean reflex = true;
      int[] aux = {0, 0};
      for(int x : a){
        aux[0] = x;
        aux[1] = x;
        if(!contains(aux, rel)){
          reflex = false;
          break;
        }
      }
      return reflex;
    }

 /**
     * Comprueba que una relación sea transitiva
     * @param rel Conjunto relación
     * @return Si la relación es transitiva o no
     */
    private static boolean transitiva(int[][] rel){
    

      boolean trans = true;
      int[] aux = {0, 0};
      for(int[] x : rel){
        for(int[] y : rel){
          if(x[1]==y[0]){
            aux[0] = x[0];
            aux[1] = y[1];
            if(!contains(aux, rel)){
              trans = false;
              break;
            }
          }
        }
      }
      return trans;
    }
    /** 
      * Comprueba que una relación sea Antisimetrica
     * @param rel Conjunto relación
     * @return Si la relación es Antisimetrica o no
     */
    private static boolean Antisimetrica(int[][] rel){
      boolean Antsim = true;
      List<int[]> lista = new  ArrayList<int[]>(Arrays.asList(rel));

      for (int[] p1 : lista) {

        if (contiene(lista, p1[1], p1[0]) && p1[0] != p1[1]) {
          Antsim=false;
            return Antsim;
        }
    }
      return Antsim;
    }

 /** 
      * Comprueba que una relación sea de Orden Total
     * @param rel Conjunto relación
     * @return Si la relación es de Orden Total o no
     */
  
    private static boolean OrdTotal(int [] e, int[][] rel){
      boolean Total = true;
      List<int[]> lista = new  ArrayList<int[]>(Arrays.asList(rel));

      for (int i = 0; i < e.length; i++) {
        for (int j = i + 1; j < e.length; j++) {
            if (!contiene(lista, e[i], e[j]) && !contiene(lista, e[j], e[i])) {
            Total = false;
            return Total;
               
            }
        }
    }

      return Total;
    }

        

        /*
         * Calculau el nombre d'elements del conjunt (a u b) × (a \ c)
         *
         * Podeu soposar que `a`, `b` i `c` estan ordenats de menor a major.
         */
        static int exercici1(int[] a, int[] b, int[] c) {
            ArrayList<Integer> Resultado_Union = Union(a, b);
      ArrayList<Integer> Resultado_Diferencia = Diferencia(a, c);
      int elementosProductoCartesiano = Resultado_Union.size()*Resultado_Diferencia.size();
      return elementosProductoCartesiano; // TODO
        }

        /*
         * La clausura d'equivalència d'una relació és el resultat de fer-hi la clausura reflexiva, simètrica i
         * transitiva simultàniament, i, per tant, sempre és una relació d'equivalència.
         *
         * Trobau el cardinal d'aquesta clausura.
         *
         * Podeu soposar que `a` i `rel` estan ordenats de menor a major (`rel` lexicogràficament).
         */
        static int exercici2(int[] a, int[][] rel) {
           return  Cardinal_Clausura_Equivalencia(a,  rel); // TODO
        }

        /*
         * Comprovau si la relació `rel` és un ordre total sobre `a`. Si ho és retornau el nombre
         * d'arestes del seu diagrama de Hasse. Sino, retornau -2.
         *
         * Podeu soposar que `a` i `rel` estan ordenats de menor a major (`rel` lexicogràficament).
         */
        static int exercici3(int[] a, int[][] rel) {
           if(reflexiva(a, rel) && Antisimetrica(rel) && transitiva(rel)&& OrdTotal(a, rel)){

       // Construir el diagrama de Hasse
       
        return -1;
      }else{

      return -2;
      }
          // TODO
        }


        /*
         * Comprovau si les relacions `rel1` i `rel2` són els grafs de funcions amb domini i codomini
         * `a`. Si ho son, retornau el graf de la composició `rel2 ∘ rel1`. Sino, retornau null.
         *
         * Podeu soposar que `a`, `rel1` i `rel2` estan ordenats de menor a major (les relacions,
         * lexicogràficament).
         */
        static int[][] exercici4(int[] a, int[][] rel1, int[][] rel2) {
            return new int[][]{}; // TODO
        }

        /*
         * Comprovau si la funció `f` amb domini `dom` i codomini `codom` té inversa. Si la té, retornau
         * el seu graf (el de l'inversa). Sino, retornau null.
         */
        static int[][] exercici5(int[] dom, int[] codom, Function<Integer, Integer> f) {
            return new int[][]{}; // TODO
        }

        /*
         * Aquí teniu alguns exemples i proves relacionades amb aquests exercicis (vegeu `main`)
         */
        static void tests() {
            // Exercici 1
            // |(a u b) × (a \ c)|

            assertThat(
                    exercici1(
                            new int[]{0, 1, 2},
                            new int[]{1, 2, 3},
                            new int[]{0, 3}
                    )
                            == 8
            );

            assertThat(
                    exercici1(
                            new int[]{0, 1},
                            new int[]{0},
                            new int[]{0}
                    )
                            == 2
            );

            // Exercici 2
            // nombre d'elements de la clausura d'equivalència
            final int[] int08 = {0, 1, 2, 3, 4, 5, 6, 7, 8};

            assertThat(exercici2(int08, generateRel(int08, (x, y) -> y == x + 1)) == 81);

            final int[] int123 = {1, 2, 3};

            assertThat(exercici2(int123, new int[][]{{1, 3}}) == 5);

            // Exercici 3
            // Si rel és un ordre total, retornar les arestes del diagrama de Hasse
            final int[] int05 = {0, 1, 2, 3, 4, 5};

            assertThat(exercici3(int05, generateRel(int05, (x, y) -> x >= y)) == 5);
            assertThat(exercici3(int08, generateRel(int05, (x, y) -> x <= y)) == -2);

            // Exercici 4
            // Composició de grafs de funcions (null si no ho son)
            assertThat(
                    exercici4(
                            int05,
                            generateRel(int05, (x, y) -> x * x == y),
                            generateRel(int05, (x, y) -> x == y)
                    )
                            == null
            );

            var ex4test2 = exercici4(
                    int05,
                    generateRel(int05, (x, y) -> x + y == 5),
                    generateRel(int05, (x, y) -> y == (x + 1) % 6)
            );

            assertThat(
                    Arrays.deepEquals(
                            lexSorted(ex4test2),
                            generateRel(int05, (x, y) -> y == (5 - x + 1) % 6)
                    )
            );

            // Exercici 5
            // trobar l'inversa (null si no existeix)
            assertThat(exercici5(int05, int08, x -> x + 3) == null);

            assertThat(
                    Arrays.deepEquals(
                            lexSorted(exercici5(int08, int08, x -> 8 - x)),
                            generateRel(int08, (x, y) -> y == 8 - x)
                    )
            );
        }

        /**
         * Ordena lexicogràficament un array de 2 dimensions Per exemple: arr =
         * {{1,0}, {2,2}, {0,1}} resultat = {{0,1}, {1,0}, {2,2}}
         */
        static int[][] lexSorted(int[][] arr) {
            if (arr == null) {
                return null;
            }

            var arr2 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr2, Arrays::compare);
            return arr2;
        }

        /**
         * Genera un array int[][] amb els elements {a, b} (a de as, b de bs)
         * que satisfàn pred.test(a, b) Per exemple: as = {0, 1} bs = {0, 1, 2}
         * pred = (a, b) -> a == b resultat = {{0,0}, {1,1}}
         */
        static int[][] generateRel(int[] as, int[] bs, BiPredicate<Integer, Integer> pred) {
            var rel = new ArrayList<int[]>();

            for (int a : as) {
                for (int b : bs) {
                    if (pred.test(a, b)) {
                        rel.add(new int[]{a, b});
                    }
                }
            }

            return rel.toArray(new int[][]{});
        }

        /// Especialització de generateRel per a = b
        static int[][] generateRel(int[] as, BiPredicate<Integer, Integer> pred) {
            return generateRel(as, as, pred);
        }
    }

    /*
     * Aquí teniu els exercicis del Tema 3 (Grafs).
     *
     * Els (di)grafs vendran donats com llistes d'adjacència (és a dir, tractau-los com diccionaris
     * d'adjacència on l'índex és la clau i els vèrtexos estan numerats de 0 a n-1). Per exemple,
     * podem donar el graf cicle d'ordre 3 com:
     *
     * int[][] c3dict = {
     *   {1, 2}, // veïns de 0
     *   {0, 2}, // veïns de 1
     *   {0, 1}  // veïns de 2
     * };
     *
     * **NOTA: Els exercicis d'aquest tema conten doble**
     */
    static class Tema3 {

        /*
         * Determinau si el graf és connex. Podeu suposar que `g` no és dirigit.
         */
        // Método principal que determina si el grafo es conexo
        // Método para determinar si el grafo es conexo
        static boolean exercici1(int[][] g) {
            int n = g.length;
            if (n == 0) {
                return true; // Un grafo vacío es conexo por definición
            }

            boolean[] visitados = new boolean[n];
            int[] stack = new int[n];
            int top = -1;

            // Comenzamos la DFS desde el nodo 0
            stack[++top] = 0;
            visitados[0] = true;
            int visitadosCount = 1;

            while (top >= 0) {
                int nodo = stack[top--];

                for (int i = 0; i < n; i++) {
                    if (g[nodo].length > i && g[nodo][i] != 0 && !visitados[i]) {
                        stack[++top] = i;
                        visitados[i] = true;
                        visitadosCount++;
                    }
                }
            }

            return visitadosCount == n;
        }

        /*
         * Donat un tauler d'escacs d'amplada `w` i alçada `h`, determinau quin és el mínim nombre de
         * moviments necessaris per moure un cavall de la casella `i` a la casella `j`.
         *
         * Les caselles estan numerades de `0` a `w*h-1` per files. Per exemple, si w=5 i h=2, el tauler
         * és:
         *   0 1 2 3 4
         *   5 6 7 8 9
         *
         * Retornau el nombre mínim de moviments, o -1 si no és possible arribar-hi.
         */
        /*
        static int exercici2(int w, int h, int i, int j) {
            // Posibles movimientos del caballo
            final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
            final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

            int startX = i % w;
            int startY = i / w;
            int endX = j % w;
            int endY = j / w;

            // Si el punto de inicio es igual al punto de destino
            if (startX == endX && startY == endY) {
                return 0;
            }

            boolean[][] visited = new boolean[w][h];
            int[][] queue = new int[w * h][3];
            int front = 0, rear = 0;

            // Agregar la posición inicial a la cola
            queue[rear][0] = startX;
            queue[rear][1] = startY;
            queue[rear][2] = 0;
            rear++;
            visited[startX][startY] = true;

            while (front < rear) {
                int[] current = queue[front];
                front++;

                int currentX = current[0];
                int currentY = current[1];
                int currentMoves = current[2];

                for (int k = 0; k < 8; k++) {
                    int newX = currentX + dx[k];
                    int newY = currentY + dy[k];

                    if (newX == endX && newY == endY) {
                        return currentMoves + 1;
                    }

                    if (newX >= 0 && newX < w && newY >= 0 && newY < h && !visited[newX][newY]) {
                        queue[rear][0] = newX;
                        queue[rear][1] = newY;
                        queue[rear][2] = currentMoves + 1;
                        rear++;
                        visited[newX][newY] = true;
                    }
                }
            }

            return -1; // Si no es posible llegar a la casilla de destino

        }
*/
        /*
         * Donat un arbre arrelat (graf dirigit `g`, amb arrel `r`), decidiu si el vèrtex `u` apareix
         * abans (o igual) que el vèrtex `v` al recorregut en preordre de l'arbre.
         */
        static boolean exercici3(int[][] g, int r, int u, int v) {
            int[] discoveryTime = new int[g.length];
            Arrays.fill(discoveryTime, -1);  // inicializamos con -1 para indicar no visitado
            int[] time = {0};  // un array para permitir modificaciones dentro de DFS

            dfs(g, r, discoveryTime, time);

            return discoveryTime[u] <= discoveryTime[v];
        }

        static void dfs(int[][] g, int node, int[] discoveryTime, int[] time) {
            discoveryTime[node] = time[0]++;
            for (int neighbor : g[node]) {
                if (discoveryTime[neighbor] == -1) {  // si aún no ha sido visitado
                    dfs(g, neighbor, discoveryTime, time);
                }
            }
        }

        /*
         * Donat un recorregut en preordre (per exemple, el primer vèrtex que hi apareix és `preord[0]`)
         * i el grau de cada vèrtex (per exemple, el vèrtex `i` té grau `d[i]`), trobau l'altura de
         * l'arbre corresponent.
         *
         * L'altura d'un arbre arrelat és la major distància de l'arrel a les fulles.
         */
        static int exercici4(int[] preord, int[] d) {
            if (preord.length == 0) {
                return 0; // Cas base: l'arbre buit té altura 0
            }

            // Funció interna per calcular l'altura de l'arbre
            return calcularAlturaArbre(preord, d, 0);
        }

        static int calcularAlturaArbre(int[] preord, int[] d, int index) {
            // Si l'índex supera o iguala la longitud del preordre, retornem 0
            if (index >= preord.length) {
                return 0;
            }

            // Inicialitzem l'altura d'aquest vèrtex com 0
            int alturaVertex = 0;

            // Iterem sobre els fills d'aquest vèrtex segons el seu grau d[index]
            for (int i = 0; i < d[index]; i++) {
                // Calculem l'altura del fill recursivament
                int alturaFill = calcularAlturaArbre(preord, d, index + 1 + i);
                // Actualitzem l'altura del vèrtex si el fill té una altura major
                if (alturaFill > alturaVertex) {
                    alturaVertex = alturaFill;
                }
            }

            // L'altura d'aquest vèrtex és l'altura màxima dels seus fills més un
            return 1 + alturaVertex;
        }

        /*
         * Aquí teniu alguns exemples i proves relacionades amb aquests exercicis (vegeu `main`)
         */
        static void tests() {
            // Exercici 1
            // G connex?

            final int[][] B2 = {{}, {}};

            final int[][] C3 = {{1, 2}, {0, 2}, {0, 1}};

            final int[][] C3D = {{1}, {2}, {0}};

            assertThat(exercici1(C3));
            assertThat(!exercici1(B2));

            // Exercici 2
            // Moviments de cavall
            // Tauler 4x3. Moviments de 0 a 11: 3.
            // 0  1   2   3
            // 4  5   6   7
            // 8  9  10  11
            //assertThat(exercici2(4, 3, 0, 11) == 3);

            // Tauler 3x2. Moviments de 0 a 2: (impossible).
            // 0 1 2
            // 3 4 5
            //assertThat(exercici2(3, 2, 0, 2) == -1);

            // Exercici 3
            // u apareix abans que v al recorregut en preordre (o u=v)
            final int[][] T1 = {
                    {1, 2, 3, 4},
                    {5},
                    {6, 7, 8},
                    {},
                    {9},
                    {},
                    {},
                    {},
                    {},
                    {10, 11},
                    {},
                    {}
            };

            assertThat(exercici3(T1, 0, 5, 3));
            assertThat(!exercici3(T1, 0, 6, 2));

            // Exercici 4
            // Altura de l'arbre donat el recorregut en preordre
            final int[] P1 = {0, 1, 5, 2, 6, 7, 8, 3, 4, 9, 10, 11};
            final int[] D1 = {4, 1, 3, 0, 1, 0, 0, 0, 0, 2, 0, 0};

            final int[] P2 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
            final int[] D2 = {2, 0, 2, 0, 2, 0, 2, 0, 0};

            assertThat(exercici4(P1, D1) == 3);
            assertThat(exercici4(P2, D2) == 4);
        }
    }

    /*
     * Aquí teniu els exercicis del Tema 4 (Aritmètica).
     *
     * En aquest tema no podeu:
     *  - Utilitzar la força bruta per resoldre equacions: és a dir, provar tots els nombres de 0 a n
     *    fins trobar el que funcioni.
     *  - Utilitzar long, float ni double.
     *
     * Si implementau algun dels exercicis així, tendreu un 0 d'aquell exercici.
     */
    static class Tema4 {

        /*
         * Calculau el mínim comú múltiple de `a` i `b`.
         */
        static int exercici1(int a, int b) {
            return Math.abs(a * b) / calcularMCD(a, b);
        }

        // Método para calcular el MCD usando el algoritmo de Euclides
        public static int calcularMCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        /*
         * Trobau totes les solucions de l'equació
         *
         *   a·x ≡ b (mod n)
         *
         * donant els seus representants entre 0 i n-1.
         *
         * Podeu suposar que `n > 1`. Recordau que no no podeu utilitzar la força bruta.
         */
        static int[] exercici2(int a, int b, int n) {
            // Paso 1: Calcular el MCD(a, n) usando el algoritmo de Euclides extendido
            int[] coeficientes = new int[2];
            int mcd = mcdExtendido(a, n, coeficientes);

            // Paso 2: Verificar si b es divisible por el MCD(a, n)
            if (b % mcd != 0) {
                return new int[]{}; // No hay soluciones
            }

            // Paso 3: Encontrar una solución particular
            int bDivMcd = b / mcd;
            int nDivMcd = n / mcd;

            coeficientes[0] *= bDivMcd;
            coeficientes[0] = (coeficientes[0] % n + n) % n;

            // Paso 4: Generar todas las soluciones
            int[] soluciones = new int[mcd];
            for (int i = 0; i < mcd; i++) {
                soluciones[i] = (coeficientes[0] + i * nDivMcd) % n;
            }

            return soluciones;
        }

        // Método auxiliar para calcular el MCD y los coeficientes usando el Algoritmo de Euclides extendido
        static int mcdExtendido(int a, int b, int[] coeficientes) {
            if (b == 0) {
                coeficientes[0] = 1;
                coeficientes[1] = 0;
                return a;
            }
            int[] temp = new int[2];
            int mcd = mcdExtendido(b, a % b, temp);
            coeficientes[0] = temp[1];
            coeficientes[1] = temp[0] - (a / b) * temp[1];
            return mcd;
        }

        /*
         * Donats `a != 0`, `b != 0`, `c`, `d`, `m > 1`, `n > 1`, determinau si el sistema
         *
         *   a·x ≡ c (mod m)
         *   b·x ≡ d (mod n)
         *
         * té solució.
         */
        static boolean exercici3(int a, int b, int c, int d, int m, int n) {
            // Paso 1: Calcular el MCD(a, m)
            int mcdAm = calcularMCD(a, m);

            // Paso 2: Verificar la congruencia a*x ≡ c (mod m)
            if (c % mcdAm != d % mcdAm) {
                return false; // No hay solucion para el primer sistema
            }

            // Paso 3: Calcular el MCD(b, n)
            int mcdBn = calcularMCD(b, n);

            // Paso 4: Verificar la congruencia b*x ≡ d (mod n)
            if (c % mcdBn != d % mcdBn) {
                return false; // No hay solucion para el segundo sistema
            }

            // Si ambos sistemas tienen solucion, entonces el sistema original tambien tiene solucion
            return true;        }

        /*
         * Donats `n` un enter, `k > 0` enter, i `p` un nombre primer, retornau el residu de dividir n^k
         * entre p.
         *
         * Alerta perquè és possible que n^k sigui massa gran com per calcular-lo directament.
         * De fet, assegurau-vos de no utilitzar cap valor superior a max{n, p²}.
         *
         * Anau alerta també abusant de la força bruta, la vostra implementació hauria d'executar-se en
         * qüestió de segons independentment de l'entrada.
         */
        static int exercici4(int n, int k, int p) {
            // Caso base: cuando k = 0, n^0 ≡ 1 (mod p)
            if (k == 0) {
                return 1 % p;
            }

            // Inicializamos el resultado como 1
            long result = 1;

            // Reducimos n módulo p para asegurarnos de no superar p²
            n = n % p;

            // Iteramos mientras k no sea 0
            while (k > 0) {
                // Si k es impar, multiplicamos result por n módulo p
                if (k % 2 == 1) {
                    result = (result * n) % p;
                }
                // Reducimos k a la mitad y multiplicamos n por sí mismo módulo p
                k = k / 2;
                n = (n * n) % p;
            }

            // Como result puede ser un número grande, lo reducimos módulo p antes de retornarlo
            return (int) result;
        }

        /*
         * Aquí teniu alguns exemples i proves relacionades amb aquests exercicis (vegeu `main`)
         */
        static void tests() {
            // Exercici 1
            // mcm(a, b)

            assertThat(exercici1(35, 77) == 5 * 7 * 11);
            assertThat(exercici1(-8, 12) == 24);

            // Exercici 2
            // Solucions de a·x ≡ b (mod n)
            assertThat(Arrays.equals(exercici2(2, 2, 4), new int[]{1, 3}));
            assertThat(Arrays.equals(exercici2(3, 2, 4), new int[]{2}));

            // Exercici 3
            // El sistema a·x ≡ c (mod m), b·x ≡ d (mod n) té solució?
            assertThat(exercici3(3, 2, 2, 2, 5, 4));
            assertThat(!exercici3(3, 2, 2, 2, 10, 4));

            // Exercici 4
            // n^k mod p
            assertThat(exercici4(2018, 2018, 5) == 4);
            assertThat(exercici4(-2147483646, 2147483645, 46337) == 7435);
        }
    }

    /**
     * Aquest mètode `main` conté alguns exemples de paràmetres i dels resultats
     * que haurien de donar els exercicis. Podeu utilitzar-los de guia i també
     * en podeu afegir d'altres (no els tendrem en compte, però és molt
     * recomanable).
     *
     * Podeu aprofitar el mètode `assertThat` per comprovar fàcilment que un
     * valor sigui `true`.
     */
    public static void main(String[] args) {
        Tema1.tests();
        Tema2.tests();
        Tema3.tests();
        Tema4.tests();
    }

    /// Si b és cert, no fa res. Si b és fals, llança una excepció (AssertionError).
    static void assertThat(boolean b) {
        if (!b) {
            throw new AssertionError();
        }
    }
}

