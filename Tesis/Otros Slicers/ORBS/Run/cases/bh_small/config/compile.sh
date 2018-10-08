cd $1 #Move to system directory
rm -f OLDEN.exe # Remove existing output
"C:\Users\Camilo\Desktop\Personal\prueba redes sociales\pruebaRedesSociales\pruebaRedesSociales\bin\roslyn\csc.exe" -deterministic -out:OLDEN.exe Program.cs BH\\BH.cs BH\\Body.cs BH\\BTree.cs BH\\Cell.cs BH\\HG.cs BH\\MathVector.cs BH\\Node.cs BiSort\\BiSort.cs BiSort\\Value.cs Em3d\\BiGraph.cs Em3d\\Em3d.cs Em3d\\ENode.cs Health\\Health.cs Health\\Hospital.cs Health\\List.cs Health\\Patient.cs Health\\Results.cs Health\\Village.cs MST\\BlueReturn.cs MST\\Graph.cs MST\\Hashtable.cs   MST\\MST.cs MST\\Vertex.cs Perimeter\\BlackNode.cs Perimeter\\NorthEast.cs Perimeter\\Perimeter.cs Perimeter\\QuadTreeNode.cs Perimeter\\SouthWest.cs Perimeter\\GreyNode.cs Perimeter\\NorthWest.cs Perimeter\\Quadrant.cs Perimeter\\SouthEast.cs Perimeter\\WhiteNode.cs Power\\Branch.cs Power\\Demand.cs Power\\Power.cs Power\\Root.cs Power\\Leaf.cs Power\\Lateral.cs TSP\\Tree.cs TSP\\TSP.cs 2>> compile.log #Build
if [ -f OLDEN.exe ]; then #check build
    echo `md5sum OLDEN.exe`
else
    echo FAIL
fi

