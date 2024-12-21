import java.util.Scanner;
import java.util.Random;
public class aventuraConversacional {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Random random = new Random();
		
		int diamantes = 0; //para contar los diamantes recolectados
		int decision = 0; //para las decisiones del menú principal, número que elegirá el jugador
		
		
		System.out.println("B I E N V E N I D O / A     A     'T H E   M A Z E   O F   D E C I S I O N S'");
		System.out.println();
		
		//Menú principal
		System.out.println("Despiertas en un laberinto oscuro sin recordar cómo has llegado aquí.");
		System.out.println("El aire es frío y húmedo, y el eco de pasos lejanos resuena en los pasillos…");
		System.out.println("Tu misión es encontrar la salida y conseguir los máximos diamantes.");
		
		while (decision != 5) { //mientras la decisión del usuario no sea 5, continuará el bucle
		
			
			
			System.out.println();
			
			System.out.println("1) Elegir dirección.");
			System.out.println("2) Ver la cantidad de diamantes recolectados.");
			System.out.println("3) Pedir ayuda.");
			System.out.println("4) Descansar.");
			System.out.println("5) Salir del juego.");
			
			System.out.println();
			
			System.out.print("Ingresa el número de la opción deseada y presiona 'Enter': ");
			decision = entrada.nextInt();
			entrada.nextLine(); //limpiar la entrada para evitar causar problemas en la siguiente entrada
			
			switch (decision) {
				case 1:
					System.out.print("Elege dirección (N , S, E, O): ");
					String direccion = entrada.nextLine().toUpperCase();
					
					switch (direccion) {
					case "N": //juego tres en raya
						System.out.println();
						System.out.println("Avanzas por el camino al Norte, las antorchas parpadean y el aire se hace más denso... ");
						System.out.println("De frente te encuentras a una mujer que se hace llamar 'La Cazadora de Sombras'. ");
						System.out.println("Te ofrece información sobre el laberinto y sus posibles salidas. ");
						System.out.println("¡Atención! Se la conoce por ser muy mentirosa, así que no te fíes de sus palabras.");
						System.out.println();
						System.out.println("¿Deseas conocer esa información? (S/N): ");
						String infoCazadora = entrada.next().toUpperCase();
						if (infoCazadora.equals("S")) {
							//juego tres en raya
							
							System.out.println("Si ganas a La Cazadora de Sombras, ella te podrá dar información muy valiosa.");
					        System.out.println("Ten cuidado, como ya te he dicho, puede ser muy mentirosa. Disfruta viendo sufrir a los demás.");
					        System.out.println("Y ahora, inicia el juego.");
					        System.out.println();
					        
					        char[][] tablero = {
					                {' ', ' ', ' '},
					                {' ', ' ', ' '},
					                {' ', ' ', ' '}
					            };

					            char jugador = 'X'; // jugador
					            char maquina = 'O'; // La Cazadora de Sombras
					            boolean ganador = false; // para ver si hay un ganador
					            int movimientos = 0; // contador de movimientos

					            System.out.println("¡Bienvenido/a al Tres en Raya!");
					            
					            while (!ganador && movimientos < 9) { // Mientras no hay ganador y se hayan hecho al menos de 9 movimientos
					                
					                mostrarTablero(tablero); //método del tablero

					                // turno del jugador
					                System.out.println("Tu turnno. Elige fila y columna (0, 1 o 2):");
					                int fila = entrada.nextInt();
					                int columna = entrada.nextInt();
					                
					             // comprobar si la posición es válida
					                if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
					                    tablero[fila][columna] = jugador; // marcar la posición
					                    
					                    movimientos++; 
					                    
					                    ganador = comprobarGanador(tablero, jugador); 
					                } else {
					                    System.out.println("Movimiento no válido, inténtalo de nuevo.");
					                    continue; // Volver al inicio del bucle del tres en raya
					                }
					                
					                // turno de La Cazadora de Sombras
					                if (!ganador) {
					                    int maquinaFila;
					                    int maquinaColumna;
					                    
					                    do {
					                        maquinaFila = random.nextInt(3); // elegir fila aleatoria
					                        maquinaColumna = random.nextInt(3); // elegir columna aleatoria
					                        
					                    } while (tablero[maquinaFila][maquinaColumna] != ' '); // asegurar posición vacía

					                    tablero[maquinaFila][maquinaColumna] = maquina; // marcar posición
					                    
					                    movimientos++; 
					                    
					                    ganador = comprobarGanador(tablero, maquina); 
					                }
					            }

					            mostrarTablero(tablero); //método de tablero

					            // mensaje final
					            if (ganador) {
					                if (tablero[0][0] == jugador || tablero[0][1] == jugador || tablero[0][2] == jugador || //comprueba si la X
					                    tablero[1][0] == jugador || tablero[1][1] == jugador || tablero[1][2] == jugador || //aparece en alguna
					                    tablero[2][0] == jugador || tablero[2][1] == jugador || tablero[2][2] == jugador) { //casilla del tablero
					                    System.out.println("¡Felicidades! Has ganado a La Cazadora de Sombras.");
					                    System.out.println("Como has ganado, te debe una pista: Debes seguir el camino hacia el Oeste.");
					                    System.out.println("El número que te puede salvar está entre el 300 y el 400. Utiliza bien esta información.");
					                    System.out.println();
					                    System.out.println("¿Qué quieres hacer ahora?");
					                } else {
					                    System.out.println("Ha ganado La Cazadora de Sombras.");
					                    System.out.println("Debes elegir otra dirección.");
					                }
					            } else {
					                System.out.println("¡Es un empate! Debes volver a elegir una dirección."); //vuelta al menú principal
					            }
					        
						} else if (infoCazadora.equals("N")) { //vuelta al menú principal
							System.out.println("Debes elegir otra dirección.");
						} else {
							System.out.println("E R R O R: Respuesta no válida."); 
						}
						break;
						
					case "S": //+1 diamante
						System.out.println();
						System.out.println("Avanzas por el camino iluminado por antorchas.");
						System.out.println("Después de pasar por un túnel, te encuentras un diamante.");
						diamantes++; 
						System.out.println("¿Qué quieres hacer ahora?");
						//vuelta al menú principal
						break;
						
					case "E": //juego de las puertas
						System.out.println();
						System.out.println("Sigues el camino al Este, donde una puerta alta y misteriosa te detiene.");
						System.out.println("Dentro, las paredes están cubiertas de espejos que reflejan tus movimientos.");
						System.out.println("¿Deseas jugar al Juego de las Puertas Misteriosas? (S/N)");
						String juegoPuertas = entrada.next().toUpperCase();
						
						if (juegoPuertas.equals("S")) { //juego de las puertas
							
							System.out.println();
							System.out.println("Unas flechas luminosas aparecen en el suelo, te señalan seguir hacia delante.");
							System.out.println("Las sigues sin pensar en los peligros a los que puede llevarte, pero sabiendo que tienes");
							System.out.println("que salir de una vez por todas de este oscuro laberinto.");
							System.out.println("Cuando las flechas se detienen, llegas a 4 puertas, cada una con un número.");
							System.out.println("Un papel misterioso aparece en tu visión, y sin pensarlo, lo agarras para ver qué es.");
							System.out.println();
							System.out.println("Debes elegir el número de una puerta. Tu camino solo depende de ti, así que elige bien.");
							System.out.println("Si eliges la puerta incorrecta, tienes que volver por donde has venido, pero si eliges la correcta,");
							System.out.println("podrás seguir adelante sin interrupciones.");
							System.out.println();
							System.out.println("Así que, ¿cuál es tu decisión? ¿1, 2, 3 o 4");

							int puertaIntento = entrada.nextInt();
							int puertaCorrecta = 2;
							
							System.out.println();
							if (puertaIntento > 4) {
								System.out.println("E R R O R: Respuesta no válida.");
							} else if (puertaIntento == puertaCorrecta) {
								System.out.println("¡Buena elección! Puedes seguir adelante.");
								System.out.println("La puerta número 2 se abre, dejándote ver el siguiente cruce.");
								System.out.println("Decide qué harás ahora:");
								
							} else if (puertaIntento != puertaCorrecta) {
								System.out.println("Mala elección. La puerta correcta era la segunda.");
								System.out.println("Debes volver por donde has venido.");
								System.out.println("Así que vuelves sobre tus pasos, pensando en la siguiente opción.");
								//vuelta al menú principal
							}
							
						} else if (juegoPuertas.equals("N")) {
							System.out.println("Tienes que cambiar de camino.");
							//vuelta al menú principal
							
						} else {
							System.out.println("E R R O R: Respuesta no válida.");
						}
						break;
						
					case "O": //adivinanza + minijuego con la Guardiana
						System.out.println();
						System.out.println("Avanzas por el camino iluminado por antorchas. En una de las paredes del laberinto,");
						System.out.println("te encuentras unas palabras que te pueden ayudar a encontrar el camino:");
						System.out.println();
						System.out.println("Soy pequeño y brillante, en la tierra estoy.");
						System.out.println("Si me encuentras a mí, feliz serás hoy.");
						System.out.println();
						System.out.println("Cuando intentas coger una antorcha para ver mejor el mensaje de la pared, el ambiente cambia.");
						System.out.println("Las pocas luces que hay, empiezan a parpadear y un eco suave de melodías suena en el aire.");
						System.out.println();
						System.out.println("Al fondo, una majestuosa puerta, cubierta con marcas antiguas, Lira, la Musa del Destino te observa.");
						System.out.println();
						System.out.println("Lira: Has llegado al sitio más importante del laberinto. Te invito a adivinar un número entre el  1 y el 500.");
						System.out.println("Solo tienes 5 intentos, así que, aprovecha bien tus oportunidades. ¿Deseas jugar? (S/N): ");
						String adivinarNumero = entrada.next().toUpperCase();
						
						if (adivinarNumero.equals("S")) { //adivina numero entre 1 y 500
							System.out.println("Lira: Buena elección. Estas son las instrucciones: como ya te he dicho, tienes que adivinar un número entre");
							System.out.println("el 1 y el 500. Si no lo aciertas, te diré si es mayor o menor que el correcto. Para eso, tienes 5 intentos.");
							System.out.println("El juego comienza ahora.");
							
							//juego de adivinanza
							final int NUMERO_CORRECTO = 367; //el número es una constante (si no se pone final, puede tener error de compilación)
							int intentos = 0;
							int numeroIntento = 0;
							
							boolean juegoTerminado = false; //variable para después poder salir del bucle principal
							
							do {
								System.out.print("Ingresa el número en el que estás pensando: ");
								numeroIntento = entrada.nextInt();
								intentos++;
								
								if (NUMERO_CORRECTO > numeroIntento) {
									System.out.println("El número que buscas es mayor.");
								}else if (NUMERO_CORRECTO < numeroIntento) {
									System.out.println("El número que buscas es menor");
								}
								
								if (NUMERO_CORRECTO == numeroIntento) { //fin de juego
									System.out.println();
									System.out.println("¡Has desvelado el secreto! La puerta está abierta ante ti. Adelante, cruza y descubre tu destino.");
									System.out.println("Enhorabuena, has ganado. Has terminado 'The Maze of Decisions' con " + diamantes + " diamantes.");
									System.out.println();
									System.out.println("G R A C I A S   P O R   J U G A R");
									juegoTerminado = true; //para poder salir del bucle while principal
									break;
									
								} else if (intentos == 5) {
									System.out.println("El eco del destino aún no ha resonado a tu favor. Debes regresar y prepararte para otro intento.");
									System.out.println("¡Mucha suerte! Nos volveremos a ver");
									break;
								}
							} while (NUMERO_CORRECTO != numeroIntento);
							
							if (juegoTerminado) {
								decision = 5; //si se ha adivinado el número, se sale del bucle while principal.
							}
							break;
		
							//fin juego de adivinanza
							
						} else if (adivinarNumero.equals("N")) {
							System.out.println("Lira: El eco del destino aún no ha resonado a tu favor. Debes regresar y prepararte para otro intento.");
							System.out.println("¡Suerte en tu viaje! Nos volveremos a ver.");
						} else {
							System.out.println("E R R O R: Respuesta no válida.");
						}
						break;
						//vuelta al menú principal
					default:
						System.out.println();
						System.out.println("E R R O R: Respuesta no válida.");
					}
					break;
					
				case 2: //ver diamantes
					System.out.println();
					System.out.println("Has elegido la opción de ver la cantidad de diamantes recolectados.");
					System.out.println();
					System.out.println("Diamantes: " + diamantes); //aquí aparecerán los diamantes recolectados
					break;
					
				case 3: //pedir ayuda
					System.out.println();
					System.out.println("Has pedido ayuda. Ahora puedes elegir llamar a: ");
					System.out.println();
					System.out.println("1) Elara, la Guardiana de la Sabiduría:  ");
					System.out.println("Fue una maga poderosa que descubrió los mejores secretos guardados del laberinto.");
					System.out.println("Puede darte información si ganas al Juego de Dados.");
					System.out.println();
					System.out.println("2)  Lyra, la Maestra del laberinto:");
					System.out.println("Conoce cada rincón del laberinto y sus secretos más oscuros. Ella se quedó atrapada ");
					System.out.println("aquí mismo mucho antes de que tú llegaras. Su misión inicial era escapar, ahora quiere ");
					System.out.println("ayudar a otros a hacerlo. Puede darte un pista, tú eliges cuál.");
					
					int ayuda = entrada.nextInt();
					
					if (ayuda == 1) { //ayuda de Elara
						//juego de dados
						System.out.println();
						System.out.println("¡Has elegido bien!");
						System.out.println("Estas son las instrucciones del juego: debes elegir un número entre el 1 y el 6, si el número de Elara es mayor, pierdes.");
						System.out.println("Pero si tu número es mayor al de Elara, ganas y te da una pista para encontrar la salida del laberinto.");
						System.out.println();
						System.out.println("El juego inicia.");
						System.out.print("Debes elegir un número entre el 1 y el 6: ");
						int numeroJugador = entrada.nextInt();
						int numeroElara = random.nextInt(6) + 1; //número aleatorio entre el 1 y el 6 

						if (numeroJugador < 1 || numeroJugador > 6) { //el número que ingrese el jugador tiene que estar entre el 1 y 6, si no, dará error
							System.out.println("E R R O R: respuesta no válida.");
						} else {
							System.out.println("El número de Elara es: " + numeroElara);
							System.out.println();
							
							if (numeroJugador == numeroElara) {
								System.out.println("E M P A T E");
								
							} else if (numeroJugador > numeroElara) {
								System.out.println("¡H A S   G A N A D O!");
								System.out.println();
								System.out.println("Elara te dará la pista: el número que te puede salvar la vida es el 367.");
								System.out.println();
								System.out.println("Elara: ¡Buen viaje! Espero que puedas salir del laberinto.");
								
							} else {
								System.out.println("H A S   P E R D I D O");
								System.out.println("Suerte en tu búsqueda de la salida.");
							}
						} 
						
					} else if (ayuda == 2) { //ayuda de Lyra
						System.out.println();
						System.out.println("1) Sobre direcciones.");
						System.out.println("2) Sobre la exploración. ");
						int ayudaMaestra = entrada.nextInt();
						
						//si el jugador elige la opción de la maestra, tendrá que elegir una vez más
						
						if (ayudaMaestra == 1) { //pista sobre las direcciones
							System.out.println();
							System.out.println("Sobre direcciones: Si quieres hallar el camino correcto, recuerda:");
							System.out.println("al Este el sol sale, pero al Oeste se esconden los tesoros.");
							System.out.println("El número que te puede salvar está entre el 300 y el 400. Utiliza bien esta información.");
							
							
						} else if (ayudaMaestra == 2) { //pista sobre la exploración
							System.out.println();
							System.out.println("Sobre la exploración: Cuidado con las puertas cerradas, a menudo ocultan");
							System.out.println("lo que más deseas. Pero solo el que es valiente podrá atravesarlas.");
							System.out.println("El número que te puede salvar es el 367. Utilízalo bien.");
							
						} else {
							System.out.println();
							System.out.println("E R R O R: Respuesta no válida.");
						}
						
					} else {
						System.out.println();
						System.out.println("E R R O R: Respuesta no válida.");
					}
					break;
					
				case 4: //descanso
					System.out.println();
					System.out.println("Te sientas a descansar un momento.");
					System.out.println();
					System.out.println(".........................................................................................");
					System.out.println();
					System.out.println(".........................................................................................");
					System.out.println();
					System.out.println(".........................................................................................");
					System.out.println();
					System.out.println(".........................................................................................");
					System.out.println();
					System.out.println(".........................................................................................");
					System.out.println();
					System.out.println("¡Sorpresa! Has recargado tu energía, así que te has ganado un diamante.");
					diamantes++;
					break;
				
				case 5: //salir del juego
					System.out.println();
					System.out.println("Saliendo del juego...."); //fin del juego
					System.out.println();
					System.out.println("G R A C I A S   P O R   J U G A R");
					break;
					
				default:
					System.out.println();
					System.out.println("E R R O R: Respuesta no válida.");
			}
		
		}
		
		entrada.close();
	}

	// Método para el tablero tres en raya
    public static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + tablero[i][0] + " | " + tablero[i][1] + " | " + tablero[i][2]);
            if (i < 2) {
                System.out.println("---|---|---");
            }
        }
    }

    // Método para comprobar si hay un ganador en el tres en raya
    public static boolean comprobarGanador(char[][] tablero, char jugador) {
        // comprobar filas y columnas
        for (int i = 0; i < 3; i++) {
            if ((tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) || // filas
                (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador)) { // columnas
                return true;
            }
        }
        // comprobar diagonales
        if ((tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) || // diagonal
            (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador)) { // diagonal
            return true;
        }
        return false; // si no hay ganador
    }
	
}
