<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <xsl:text disable-output-escaping="yes"> &lt;!DOCTYPE html></xsl:text>
            <html lang="es" dir="ltr">
                <head>
                    <meta charset="utf-8"/>
                    <title><xsl:value-of select="cine/datos/nombre"/></title>
                    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
                    <!--reset de estilos y hoja de estilos -->
                    <link rel="stylesheet" type="text/css" href="css/reset.css" />
                    <link rel="stylesheet" href="css/cine.css"/>
                </head>
                <!--Plantilla para la tarea 5 de LM 2122-->
                <body>
                    <!--información del cine-->
                    <header>
                        <img src="img/logo.png" alt="logo"/>
                        <xsl:if test="cine/datos">
                            <h1><xsl:value-of select="cine/datos/nombre"/></h1>
                            <h3><xsl:value-of select="cine/datos/ubicacion/direccion"/> - <xsl:value-of select="cine/datos/ubicacion/localidad"/> (<xsl:value-of select="cine/datos/ubicacion/provincia"/>) - <xsl:value-of select="cine/datos/cif"/> - <xsl:value-of select="cine/datos/tlf"/></h3>
                        </xsl:if>
                    </header>

                    <main>

                        <!--capa que contiene los datos de las distintas peliculas-->
                        <div class="peliculas">
                            <xsl:for-each select="cine/peliculas/pelicula">
                                <xsl:sort select="titulo"/>
                                <section class="bloque">
                                    <h1>
                                        <xsl:value-of select="titulo"/>
                                    </h1>
                                    <div class="items">
                                        <div class="tipo">género
                                            <div class="item">
                                                <p>
                                                    <xsl:value-of select="./@genero"/>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="tipo">director
                                            <div class="item">
                                                <p>
                                                    <xsl:value-of select="director"/>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="tipo">duración
                                            <div class="item">
                                                <p>
                                                    <xsl:value-of select="duracion"/>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="tipo">reparto principal
                                        
                                            <xsl:for-each select="reparto_principal/actr">
                                                <div class="item">
                                                    <p>
                                                        <xsl:value-of select="."/>
                                                    </p>
                                                </div>
                                            </xsl:for-each>
                                        
                                        </div>
                                        <div class="tipo">sinopsis
                                            <div class="item">
                                                <p>
                                                    <xsl:value-of select="sinopsis"/>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </section>
                            </xsl:for-each>
                        </div>
                        
                        <!--capa que contiene las salas del cine y sus sesiones-->
                        <div class="salas">
                            <xsl:for-each select="/cine/salas/sala">
                                <section class="bloque">
                                    <h1>sala <xsl:value-of select="@id"/></h1>
                                
                                    <div class="items">
                                        <div class="item">
                                            <p>capacidad</p>
                                            <p>
                                                <xsl:value-of select="n_butacas"/>
                                            </p>
                                        </div>
                                        <div class="item">
                                            <p>Acceso discapacitados</p>
                                            <xsl:choose>
                                                <xsl:when test="discapacitados ">
                                                    <p>si</p>
                                                </xsl:when>
                                                <xsl:otherwise>
                                                    <p>no</p>
                                                </xsl:otherwise>
                                            </xsl:choose>

                                        </div>
                                        <div class="item">
                                            <p>3D</p>
                                            <xsl:choose>
                                                <xsl:when test="tresd ">
                                                    <p>si</p>
                                                </xsl:when>
                                                <xsl:otherwise>
                                                    <p>no</p>
                                                </xsl:otherwise>
                                            </xsl:choose>
                                        </div>

                                        <xsl:variable name="id_sala" select="@id"/>
                                        <xsl:for-each select="/cine/sesiones/sesion[sala/@ref=$id_sala]">
                                            <xsl:variable name="ref_pelicula" select="pelicula/@ref"/>
                                            <div class="item">
                                                <p><xsl:value-of select="position()" />.- <xsl:value-of select="/cine/peliculas/pelicula[@id=$ref_pelicula]/titulo"/></p>
                                                <p><xsl:value-of select="dia"/></p>
                                                <p><xsl:value-of select="hora"/></p>
                                            </div>
                                        </xsl:for-each>
                                    </div>
                                </section>
                            </xsl:for-each>
                        </div>
                    </main>

                    <!--pié de página-->
                    <xsl:variable name="direccion" select="/cine/datos/url"/>
                    <footer>
                        <p>Manuel- <a href="{/cine/datos/url}" target="_blank">nombre cine</a></p>
                    </footer>
                </body>
            </html>

    </xsl:template>

</xsl:stylesheet>
