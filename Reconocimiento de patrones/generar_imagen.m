function im_out=generar_imagen(phantom, mus, Sigma)
[r, c]=size(phantom);
im_out=zeros(r,c,3);
for i=1:r
    for j=1:c
        mu=mus(phantom(i,j),:);
        im_out(i,j,:)=mvnrnd(mu,Sigma,1);
    end
end
