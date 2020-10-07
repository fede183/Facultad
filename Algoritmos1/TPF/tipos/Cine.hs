module Cine (nuevoC, nombreC, peliculasC, salasC, espectadoresC, salaC, ticketsVendidosC,  abrirSalaC, agregarPeliculaC, cerrarSalaC, cerrarSalasC, cerrarSalasDeLaCadenaC, peliculaC, venderTicketC, ingresarASalaC, pasarA3DUnaPeliculaC ) where

import Tipos
import Pelicula
import Ticket

data Cine = C Nombre | 
			SalaSinPelicula Cine Sala | 
			SalaConPelicula Cine Sala Pelicula Int | 
			TicketVendido Cine Ticket deriving (Show)


nuevoC::Nombre->Cine
nuevoC n=C n

nombreC::Cine->Nombre
nombreC (C n)=n
nombreC (SalaSinPelicula c s)=nombreC c
nombreC (SalaConPelicula c s p i)=nombreC c
nombreC (TicketVendido  c t)=nombreC c

peliculasC::Cine->[Pelicula]
peliculasC (C n)=[]
peliculasC (SalaSinPelicula c s)=peliculasC c
peliculasC (SalaConPelicula c s p i)=(p:(peliculasC c))
peliculasC (TicketVendido  c t)=peliculasC c

salasC::Cine->[Sala]
salasC (C n)=[]
salasC (SalaSinPelicula c s)=(s:salasC c)
salasC (SalaConPelicula c s p i)=(s:(salasC c))
salasC (TicketVendido c t)= salasC c

salaC::Cine->Pelicula->Sala
salaC (SalaSinPelicula c s) p  = salaC c p
salaC (SalaConPelicula c s p1 i) p
	|(p1==p) = s
	|(p1/=p) = salaC c p 
salaC (TicketVendido  c t) p = salaC c p

espectadoresC::Cine->Sala->Int
espectadoresC (TicketVendido c t) s = (espectadoresC c s)
espectadoresC (SalaSinPelicula c s) s1
	|(s1==s) = 0
	|(s1/=s) = espectadoresC c s1
espectadoresC (SalaConPelicula c s p1 e) s1
	|(s1==s) = e
	|(s1/=s)= espectadoresC c s1
	

ticketsVendidosC::Cine->[Ticket]
ticketsVendidosC (C n)=[]
ticketsVendidosC (TicketVendido c t)=[t]++(ticketsVendidosC c)
ticketsVendidosC (SalaSinPelicula c s)= ticketsVendidosC c
ticketsVendidosC (SalaConPelicula c s p1 i)= ticketsVendidosC c

abrirSalaC::Cine->Sala->Cine
abrirSalaC c s 
	|elem s (salasC c)==False= (SalaSinPelicula c s)  

esSalaVacia::Cine->Sala->Bool
esSalaVacia (C n) s =True
esSalaVacia (TicketVendido c t) s1 = esSalaVacia c s1
esSalaVacia (SalaSinPelicula c s) s1
	|s==s1=True
	|otherwise= esSalaVacia c s1
esSalaVacia (SalaConPelicula c s p e) s1
	|s==s1=False
	|otherwise= esSalaVacia c s1

sinPeliculasConMismoNombre::Cine->Pelicula->Bool
sinPeliculasConMismoNombre (C n) p=True
sinPeliculasConMismoNombre (TicketVendido c t) p=sinPeliculasConMismoNombre c p
sinPeliculasConMismoNombre (SalaSinPelicula c s) p=sinPeliculasConMismoNombre c p
sinPeliculasConMismoNombre (SalaConPelicula c s p1 e) p= ((nombreP p)/=(nombreP p1))&&(sinPeliculasConMismoNombre c p)

agregarPeliculaC::Cine->Pelicula->Sala->Cine
agregarPeliculaC (C n) p1 s1 = (C n)
agregarPeliculaC (SalaConPelicula c s p e) p1 s1 = (SalaConPelicula (agregarPeliculaC c p1 s1) s p e)
agregarPeliculaC (SalaSinPelicula c s) p1 s1
	|s==s1 = (SalaConPelicula (agregarPeliculaC c p1 s1) s p1 0)
	|otherwise = (SalaSinPelicula (agregarPeliculaC c p1 s1) s)
agregarPeliculaC (TicketVendido c t) p1 s1 = (TicketVendido (agregarPeliculaC c p1 s1) t)

cerrarSalaC2::Cine->Sala->Cine
cerrarSalaC2 (C n) _ = (C n)
cerrarSalaC2 (SalaSinPelicula c s1) s
	|(s1==s)= cerrarSalaC2 c s 
	|(s1/=s) =SalaSinPelicula (cerrarSalaC2 c s) s1
cerrarSalaC2 (SalaConPelicula c s1 p e) s
	|s1==s= cerrarSalaC2 c s  
	|s1/=s= SalaConPelicula (cerrarSalaC2 c s) s1 p e
cerrarSalaC2 (TicketVendido c t) s = TicketVendido (cerrarSalaC2 c s) t

cerrarSalaC::Cine->Sala->Cine
carrarSalaC (C n) _ =error"Cine Vacio"
cerrarSalaC c s = cerrarSalaC2 c s

cerrarSalasC::Cine->Int->Cine
cerrarSalasC (C n) _ = (C n)
cerrarSalasC (SalaSinPelicula c s) e= SalaSinPelicula (cerrarSalasC c e) s
cerrarSalasC (TicketVendido c t) e = TicketVendido (cerrarSalasC c e) t
cerrarSalasC (SalaConPelicula c s p d) e
	|(d<e)= cerrarSalaC (cerrarSalasC c e) s
	|otherwise= (SalaConPelicula (cerrarSalasC c e) s p d) 

cerrarSalasDeLaCadenaC::[Cine]->Int->[Cine]
cerrarSalasDeLaCadenaC [] _ =[]
cerrarSalasDeLaCadenaC (c:cn) e =(cerrarSalasC c e):(cerrarSalasDeLaCadenaC cn e)

peliculaC::Cine->Sala->Pelicula
peliculaC (TicketVendido c t) s = peliculaC c s
peliculaC (SalaSinPelicula c s1) s = peliculaC c s
peliculaC (SalaConPelicula c s1 p e) s
	|(s==s1)= p
	|otherwise = peliculaC c s

venderTicketC::Cine->Pelicula->(Cine, Ticket)
venderTicketC c p 
	|elem p (peliculasC c)= (TicketVendido c (nuevoT p (salaC c p) False), nuevoT p (salaC c p) False)

sacarUnTicketC::Cine->Ticket->Cine
sacarUnTicketC (SalaSinPelicula c s) t=(SalaSinPelicula (sacarUnTicketC c t) s)
sacarUnTicketC (SalaConPelicula c s p e) t= SalaConPelicula (sacarUnTicketC c t) s p e
sacarUnTicketC (TicketVendido c t1) t
	|t1==t=c
	|t1/=t=TicketVendido (sacarUnTicketC c t) t1

incrementaEspectadores::Cine->Sala->Cine
incrementaEspectadores (SalaSinPelicula c s) s1 = (SalaSinPelicula (incrementaEspectadores c s1) s)
incrementaEspectadores (SalaConPelicula c s p e) s1
	|s==s1= SalaConPelicula c s p (e+1)
	|otherwise=(SalaConPelicula (incrementaEspectadores c s1) s p e)
incrementaEspectadores (TicketVendido c t) s= (TicketVendido (incrementaEspectadores c s) t) 

ingresarASalaC::Cine->Sala->Ticket->(Cine,Ticket)
ingresarASalaC c s t = (incrementaEspectadores (sacarUnTicketC c t) s,usarT t)

peliculasConNombre::Cine->Nombre->Pelicula
peliculasConNombre (SalaConPelicula c s p e) n
	|(nombreP p==n)=p
	|otherwise=peliculasConNombre c n
peliculasConNombre (SalaSinPelicula c s) n= peliculasConNombre c n
peliculasConNombre (TicketVendido c t) n= peliculasConNombre c n

modificaPeliculaYTickets3D::Cine->Pelicula->Cine
modificaPeliculaYTickets3D (C n) p= (C n)
modificaPeliculaYTickets3D (SalaSinPelicula c s) p = SalaSinPelicula (modificaPeliculaYTickets3D c p) s
modificaPeliculaYTickets3D (SalaConPelicula c s p1 e) p
	|p1==p = SalaConPelicula (modificaPeliculaYTickets3D c p) s (nuevaP (nombreP p) (generosP p) (actoresP p) (True)) e
	|otherwise= SalaConPelicula (modificaPeliculaYTickets3D c p) s p1 e
modificaPeliculaYTickets3D (TicketVendido c t) p 
	|(peliculaT t == p)= (TicketVendido (modificaPeliculaYTickets3D c p) (nuevoT p (salaT t) False))
	|otherwise= (TicketVendido (modificaPeliculaYTickets3D c p) t)
	
pasarA3DUnaPeliculaC::Cine->Nombre->(Cine,Pelicula)
pasarA3DUnaPeliculaC c n = (modificaPeliculaYTickets3D c (peliculasConNombre c n),nuevaP n (generosP (peliculasConNombre c n)) (actoresP (peliculasConNombre c n)) (True))
	
