function im_out=clasificarData(im, mus, Sigma)
SigmaINV=inv(Sigma);
[r, c] =size(im);
im_out=zeros(c,1);
[m, n] =size(mus);
Z=1:m;
for i=1:c
      
        X=[im(1,i); im(2,i); im(3,i)];
        for k=1:m 
            Xz=double(X)-(mus(k,:)');
            Z(k)=norm(((Xz')*(SigmaINV*Xz)));
        end
        [minZ, ubicMin]=min(Z);
        im_out(i,1)=ubicMin;

   
end

