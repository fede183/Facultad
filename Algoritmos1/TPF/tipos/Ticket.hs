module Ticket (Ticket, nuevoT, salaT, peliculaT, usadoT, usarT, peliculaMenosVistaT, todosLosTicketsParaLaMismaSalaT, cambiarSalaT) 	where

import Tipos
import Pelicula

data Ticket = TicketSinUsar Sala Pelicula | TicketUsado Ticket deriving (Show, Eq)

nuevoT :: Pelicula -> Sala -> Bool -> Ticket
nuevoT p s b
	|b == False = (TicketSinUsar s p)
	|b == True = (TicketUsado (TicketSinUsar s p))
	
peliculaT :: Ticket -> Pelicula
peliculaT (TicketSinUsar _ p) = p
peliculaT (TicketUsado (TicketSinUsar _ p)) = p

salaT :: Ticket -> Sala
salaT (TicketSinUsar s _) = s
salaT (TicketUsado (TicketSinUsar s _)) = s

usadoT :: Ticket -> Bool
usadoT (TicketSinUsar _ _) = False
usadoT (TicketUsado (TicketSinUsar _ _)) = True

usarT :: Ticket -> Ticket
usarT (TicketSinUsar s p) = (TicketUsado (TicketSinUsar s p))
usarT (TicketUsado (TicketSinUsar s p)) = TicketUsado (TicketSinUsar s p)

peliculaMenosVistaT :: [Ticket] -> Pelicula
peliculaMenosVistaT xs = menosVista xs 0

cantidadVistas :: [Ticket] -> Pelicula -> Int
cantidadVistas [] p = 0
cantidadVistas (x:xs) p
	|((peliculaT x) == p) && ((usadoT x) == True) = 1 + (cantidadVistas xs p)
	|otherwise = cantidadVistas xs p

esMenosVista :: [Ticket] -> Pelicula -> Int-> Bool
esMenosVista (x:xs) p 0 = ((cantidadVistas (x:xs) p) <= (cantidadVistas (x:xs) (peliculaT x)))
esMenosVista (x:xs) p i = (cantidadVistas (x:xs) p) <= (cantidadVistas (x:xs) (peliculaT (val i (x:xs)))) && (esMenosVista (x:xs) p (i-1))

menosVista :: [Ticket] -> Int -> Pelicula
menosVista xs i
	|esMenosVista xs (peliculaT (val i xs)) ((length xs)-1) == True = peliculaT (val i xs)
	|otherwise = menosVista xs (i+1)

val :: Int -> [a] -> a
val 0 (x:xs) = x
val i (x:xs) = val (i-1) xs

todosLosTicketsParaLaMismaSalaT :: [Ticket] -> Bool
todosLosTicketsParaLaMismaSalaT [] = True
todosLosTicketsParaLaMismaSalaT [a] = True
todosLosTicketsParaLaMismaSalaT (x:y:xs) = ((salaT x) == (salaT y)) && (todosLosTicketsParaLaMismaSalaT (y:xs))

cambiarSalaT :: [Ticket] -> Sala -> Sala -> [Ticket]
cambiarSalaT [] _ _ = []
cambiarSalaT (x:xs) v n
	|(salaT x) == v && ((usadoT x) == True) = ((TicketUsado (TicketSinUsar n (peliculaT x))):(cambiarSalaT xs v n))
	|(salaT x) == v && ((usadoT x) == False) = ((TicketSinUsar n (peliculaT x)):(cambiarSalaT xs v n))
	|otherwise = (x:(cambiarSalaT xs v n))
