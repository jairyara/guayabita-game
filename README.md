## Guayabita en Java

El Juego Guayabita es un juego de apuestas muy popular, sus términos y reglas son las siguientes:

- Se define inicialmente el total de jugadores (≥ 2), cada jugador inicia con un monto inicial propio (no necesariamente la misma cantidad para todos).
- Se fija el valor de la apuesta y cada jugador aporta inicialmente este valor.
- La casa es un jugador especial que se encarga de administrar las apuestas. 

En cada jugada, un jugador lanza un dado dos veces: este jugador apuesta según el valor obtenido en el primer lanzamiento:

- Puede apostar solo lo pactado si considera que en el segundo lanzamiento puede obtener un numero menor al obtenido en el primer lanzamiento, en este caso entrega la apuesta a la casa y realiza el segundo lanzamiento (solo por el formalismo de lanzar). 
- Puede apostar el valor de la casa (en cuyo caso debe garantizar que su monto lo cubra), si considera que en el segundo lanzamiento va a superar el valor del primer lanzamiento. Este jugador lanmza el segundo dado y obtiene el valor de la casa si cumple, o le paga a la casa el monto apostado si pierde. 
- Los jugadores juegan de manera consecutiva hasta que exista un ganador. Un jugador se retira del juego si no se queda sin dinero.

Se espera obtener una aplicación que simule este sistema de juego
