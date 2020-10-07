module Pelicula (Pelicula, nuevaP, nombreP, generosP, actoresP, es3DP, agruparPelisPorGeneroP, generarSagaDePeliculasP) where

import Tipos

data Pelicula = P Nombre [Genero] [Actor] Bool deriving (Show, Eq)

nuevaP :: Nombre -> [Genero] -> [Actor] -> Bool -> Pelicula
nuevaP n g a b = (P n g a b)

nombreP :: Pelicula -> Nombre
nombreP (P n g a b) = n

generosP :: Pelicula -> [Genero]
generosP (P n g a b) = g

actoresP :: Pelicula -> [Actor]
actoresP (P n g a b) = a

es3DP :: Pelicula -> Bool
es3DP (P n g a b) = b

agruparPelisPorGeneroP :: [Pelicula] -> [(Genero,[Pelicula])]
agruparPelisPorGeneroP [] = []
agruparPelisPorGeneroP xs = (agruparPelis (sinRepetidos (sacarGenero xs)) xs)

generarSagaDePeliculasP :: [Actor] -> [Genero] -> [Nombre] -> [Pelicula]
generarSagaDePeliculasP _ _ [] = []
generarSagaDePeliculasP ass gss (n:nss) = (P n (sinRepetidos gss) (sinRepetidos ass) False):(generarSagaDePeliculasP ass gss nss)

sacarGenero :: [Pelicula] -> [Genero]
sacarGenero [] = []
sacarGenero (x:xs) = ((generosP x)++(sacarGenero xs))

sinRepetidos :: Eq a => [a] -> [a]
sinRepetidos [] = []
sinRepetidos (xs)
	|elem (last xs) (init xs) = sinRepetidos (init xs)
	|otherwise = (sinRepetidos (init xs)) ++ [last xs]

esDelGenero :: Pelicula -> Genero -> Bool
esDelGenero (P n g a b) gen = elem gen g

pelisDelGenero :: Genero -> [Pelicula] -> [Pelicula]
pelisDelGenero g [] = []
pelisDelGenero g (x:xs)
	|esDelGenero x g = (x:(pelisDelGenero g xs))
	|otherwise = pelisDelGenero g xs

generoPelis :: Genero -> [Pelicula] -> (Genero,[Pelicula])
generoPelis g (x:xs) = (g,pelisDelGenero g (x:xs))

agruparPelis :: [Genero] -> [Pelicula]  -> [(Genero,[Pelicula])]
agruparPelis [] _ = []
agruparPelis (x:xs) ys = (generoPelis x ys):(agruparPelis xs ys)
