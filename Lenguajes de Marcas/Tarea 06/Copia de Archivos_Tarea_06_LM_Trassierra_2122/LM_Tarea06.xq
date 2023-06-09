"1-. Obtén el nombre de las películas que comiencen por la letra C, ordenadas alfabéticamente.""&#10;",
for $titulos in doc("cine.xml")//peliculas/pelicula/titulo
where starts-with($titulos, 'C')
order by $titulos descending
return $titulos/text(),
"&#10;2.-Obtén la media de duración de todas las películas del género Romance.""&#10;",

let $media := //peliculas/pelicula[@genero = "Romance"]
return concat("La media de duración es: ",avg($media/duracion)
),

"&#10;3.-Obtén el nombre de todas las películas que tengan una duración mayor de 100 minutos. Deberás mostrarlas de la siguiente forma:""&#10;",
for $titulos in doc("cine.xml")//peliculas/pelicula[duracion >100]
return
<pelicula>
    <titulo>{$titulos/titulo/text()}</titulo>
    <duracion>{$titulos/duracion/text()}</duracion>
</pelicula>,

"&#10;4.- Muestra todas las sesiones que tiene la película The Batman el sábado, indicando las horas y el número de butacas disponibles para cada sesión. Deberás mostrarlas de la siguiente forma:&#10;",

for $sesion in doc ("cine.xml")/cine/sesiones/sesion, 
    $sala in doc("cine.xml") /cine/salas/sala
where $sesion/pelicula/@ref="001" 
  and $sesion/dia="Sábado" 
  and $sesion/sala/@ref = $sala/@id
return 
<sesion>
  <hora>{$sesion/hora/text()}</hora>
  <butacasDisponibles>{$sala/n_butacas/text()}</butacasDisponibles>
</sesion>,

"&#10;5.- Muestra el nombre de todas las películas que empiezan a proyectarse en el cine la noche del viernes, entre las 21:00 y las 23:00 horas. Ordena el resultado alfabéticamente.""&#10;",
for $titulos in doc("cine.xml")//peliculas/pelicula,
    $sesiones in doc("cine.xml")//sesiones/sesion
where $sesiones/dia = "Viernes"
  and $sesiones/hora >= "21:00"
  and $sesiones/hora <= "23:00"
  and $sesiones/pelicula/@ref = $titulos/@id
  order by $titulos/titulo ascending
return $titulos/titulo/text(),

"&#10;6.- Muestra las películas que más minutos de proyección tienen a lo largo de todas las sesiones, así como dicha duración. Por ejemplo: si una película tiene una duración de 50 minutos y se emite 2 veces en la semana, tiene una proyección total de 100 minutos semanales. Ordena el resultado de mayor a menor según esta duración.""&#10;",
for $titulo in doc ("cine.xml")//peliculas/pelicula
let $numsesiones := count(doc("cine.xml")//sesiones/sesion/pelicula[@ref=$titulo/@id])
let $sesion := count(doc("cine.xml")//sesiones/sesion/pelicula[@ref=$titulo/@id])
let $total := //peliculas/pelicula
order by ($titulo/duracion * $sesion) descending
return concat("película: ", $titulo/titulo, " - con una duración de: ", $numsesiones * $titulo/duracion, " minutos, de un total de ", sum($total/duracion), " minutos proyectados en este cine", "&#10;"),

"&#10;7.- Muestra todas las películas que se proyectan el sábado, usando la siguiente estructura:",

for $titulos in doc("cine.xml")//peliculas/pelicula,
    $sesiones in doc("cine.xml")//sesiones/sesion
where $sesiones/dia = "Sábado"
and $titulos/@id = $sesiones/pelicula/@ref 
return
<pelicula>
   <titulo>{$titulos/titulo/text()}</titulo>
   <duracion>{$titulos/duracion/text()}</duracion>
   <horaSesion>{$sesiones/hora/text()}</horaSesion>
</pelicula>,

"&#10;8.- Obtén el nombre de todas las películas que se proyectan en la sala 05 a lo largo de la semana. Ordénalas alfabéticamente según el nombre de su director.",
for $titulos in doc("cine.xml")//peliculas/pelicula,
    $sesiones in doc("cine.xml")//sesiones/sesion
where $sesiones/sala/@ref = "05"
and $sesiones/pelicula/@ref = $titulos/@id
order by $titulos/director ascending
return $titulos/titulo/text(),

"&#10;9.-Muestra el nombre de todos los actores que forman parte del reparto de todas las películas que se emiten los domingos. Usa la siguiente estructura:",
for $titulos in doc("cine.xml")//peliculas/pelicula,
    $sesiones in doc("cine.xml")//sesiones/sesion
let $actores := //peliculas/pelicula/reparto_principal/actr
where $sesiones/dia = "Domingo"
and $sesiones/pelicula/@ref = $titulos/@id
return $titulos/reparto_principal/actr
,
"&#10;10.-Muestra el nombre de las películas y la hora de sus sesiones, que se proyectan en salas que están adaptadas para personas con movilidad reducida durante el sábado.",
for $discapacitados in doc("cine.xml")//salas/sala,
    $titulos in doc("cine.xml")//peliculas/pelicula,
    $sesiones in doc("cine.xml")//sesiones/sesion
where exists($discapacitados/discapacitados)
and $titulos/@id = $sesiones/pelicula/@ref
and $sesiones/dia = "Sábado"
and $discapacitados/@id = $sesiones/sala/@ref
return concat("pelicula: ",$titulos/titulo, " - empezando a las: ", $sesiones/hora, " horas")
