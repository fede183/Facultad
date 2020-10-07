function im_out=clasificar(im, mus, Sigma)
SigmaINV=inv(Sigma);
[r, c, b] =size(im);
im_out=zeros(r,c);
[m, n] =size(mus);
Z=1:m;
for i=1:r
    for j=1:c        
        X=im(i,j,:);
        for k=1:m 
            Xz=double(X(:))-(mus(k,:)');
            Z(k)=norm(((Xz')*(SigmaINV*Xz)));
        end
        [minZ, ubicMin]=min(Z);
        im_out(i,j)=ubicMin;

    end
end

