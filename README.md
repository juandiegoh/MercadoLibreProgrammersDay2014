Problema
========

La oficina de Mercadolibre puede definirse como una grilla de NxM.

La máquina de café, está en el punto (X1,Y1), la de golosinas en el (X2,Y2) y la zona donde se sientan las chicas, está comprendida por el rectángulo formado por los vértices [(X3,Y3),(X4,Y4)], hay una chica por celda. El área de visión del jefe, está comprendida por el rectángulo formado por los vértices [(X5,Y5),(X6,Y6)].

Calcular
========

Dada una posición de inicio (X0,Y0), crear una función caminoAChicas(N,M,X0,Y0,X1,Y1,X2,Y2,X3,Y3,X4,Y4,X5,Y5,X6,Y6) la cual devuelva un camino más corto y su distancia, para pasar primero a tomar un café, luego a buscar una golosina y finalmente regalársela a una de las chicas, sin pasar por el área de visión del jefe.

Mapa de ejemplo
===============

caminoAChicas(8,8,2,1,7,2,2,7,6,6,7,7,3,3,5,4)

![Screenshot](https://github.com/juandiegoh/MercadoLibreProgrammersDay2014/raw/master/resources/images/print1.png)

(Ejemplo en la hoja siguiente)
Nota: Si sos mujer, la función sería: caminoAChicos(N,M,X0,Y0,X1,Y1,X2,Y2,X3,Y3,X4,Y4,X5,Y5,X6,Y6)

Debería devolver
================

![Screenshot](https://github.com/juandiegoh/MercadoLibreProgrammersDay2014/raw/master/resources/images/print2.png)

Formato de Salida
=================

[(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(7,2),(7,3),(7,4),(7,5),(6,5),(5,5),(4,5),(3,5),(2,5),(2,6),(2,7),(3,7),(4,7),(5,7),(6,7)],21

Devolver un String en donde la primera parte es un array con las coordenadas y el número final (Ej: 21) es la cantidad de pasos al objetivo.

