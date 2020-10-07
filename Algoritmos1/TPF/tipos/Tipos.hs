module Tipos where

type Sala = Int
type Nombre = String
type Actor = String
type Espectadores = Int
type Es3D = Bool

data Genero = Aventura | Comedia | Drama | Romantica | Terror deriving (Show, Eq)
