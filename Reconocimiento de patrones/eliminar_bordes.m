function im_out = eliminar_bordes(im)
[r, c]=size(im);
for i=2:c-1
    for j=2:r-1
        if (im(j,i)==0)
            aux=sort([im(j-1,i-1), im(j-1,i), im(j-1,i+1), im(j,i+1), im(j+1,i+1), im(j+1,i), im(j+1,i-1), im(j,i-1)]);
            im(j,i)=aux(5);
        end
    end
end
im_out=im;