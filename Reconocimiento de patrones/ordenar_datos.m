%cargar imagen 'circular.jpg'.
im=imread('circular.jpg');
[r,c,b]=size(im);
figure(1), imshow(im);
title('Imagen original');

%extraer las bandas RGB de la imagen
R=im(:,:,1);
G=im(:,:,2);
B=im(:,:,3);

im_data = cast([R(:)';G(:)';B(:)'], 'double');
%cargar posiciones de los pixels correspondientes a las zonas para
%entrenamiento de las clases 'gris','gris oscuro','negro' y 'rojo'.
load posiciones.mat

%generar datos de entrenamiento para la zona gris: data_gris
data_gris_R=R(posiciones_gris);
data_gris_G=G(posiciones_gris);
data_gris_B=B(posiciones_gris);
data_gris=cast([data_gris_R';data_gris_G';data_gris_B'], 'double');

%generar datos de entrenamiento para la zona gris oscuro:
%data_gris_oscuro
data_gris_oscuro_R=R(posiciones_gris_oscuro);
data_gris_oscuro_G=G(posiciones_gris_oscuro);
data_gris_oscuro_B=B(posiciones_gris_oscuro);
data_gris_oscuro=cast([data_gris_oscuro_R';data_gris_oscuro_G';data_gris_oscuro_B'], 'double');

%generar datos de entrenamiento para la zona negro: data_negro
data_negro_R=R(posiciones_negro);
data_negro_G=G(posiciones_negro);
data_negro_B=B(posiciones_negro);
data_negro=cast([data_negro_R';data_negro_G';data_negro_B'], 'double');

%%generar datos de entrenamiento para la zona rojo: data_rojo
data_rojo_R=R(posiciones_rojo);
data_rojo_G=G(posiciones_rojo);
data_rojo_B=B(posiciones_rojo);
data_rojo=cast([data_rojo_R';data_rojo_G';data_rojo_B'], 'double');

%valores medios
disp('Valor medio clase gris');
mean_gris=mean(data_gris,2)
disp('Valor medio clase gris oscuro');
mean_gris_oscuro=mean(data_gris_oscuro,2)
disp('Valor medio clase negro');
mean_negro=mean(data_negro,2)
disp('Valor medio clase rojo');
mean_rojo=mean(data_rojo,2)

%matrices de covarianza
disp('Covarianza clase gris');
sigma_gris=cov(data_gris')
disp('Covarianza clase gris oscuro');
sigma_gris_oscuro=cov(data_gris_oscuro')
disp('Covarianza clase negro');
sigma_negro=cov(data_negro')
disp('Covarianza clase rojo');
sigma_rojo=cov(data_rojo')

mus=[mean_gris mean_gris_oscuro mean_rojo mean_negro]';
clas_data_gris=clasificarData(data_gris,mus, sigma_gris);
clas_data_gris_oscuro=clasificarData(data_gris_oscuro,mus, sigma_gris_oscuro);
clas_data_rojo=clasificarData(data_rojo,mus, sigma_rojo);
clas_data_negro=clasificarData(data_negro,mus, sigma_negro);

sigma = cov(im_data');
clas =  clasificar(im,mus,sigma);

conf=clas(posiciones_gris);
conf_gris=confusionmat(conf(:),clas_data_gris(:));
disp('Tabla de confusión data_gris');
disp(conf_gris);
clas_data_gris=clas_data_gris(1:4000,1);
conf=conf(1:4000,1);
conf_gris=confusionmat(conf(:),clas_data_gris(:));
disp('Tabla de confusión data_gris propio');
disp(conf_gris);

conf=clas(posiciones_gris_oscuro);
conf_gris_oscuro=confusionmat(conf(:),clas_data_gris_oscuro(:));
disp('Tabla de confusión data_gris_oscuro');
disp(conf_gris_oscuro);
clas_data_gris_oscuro=clas_data_gris_oscuro(1:4000,1);
conf=conf(1:4000,1);
conf_gris_oscuro=confusionmat(conf(:),clas_data_gris_oscuro(:));
disp('Tabla de confusión data_gris_oscuro propio');
disp(conf_gris_oscuro);

conf=clas(posiciones_rojo);
conf_rojo=confusionmat(conf(:),clas_data_rojo(:));
disp('Tabla de confusión data_rojo');
disp(conf_rojo);
clas_data_rojo=clas_data_rojo(1:1000,1);
conf=conf(1:1000,1);
conf_rojo=confusionmat(conf(:),clas_data_rojo(:));
disp('Tabla de confusión data_rojo propio');
disp(conf_rojo);

conf=clas(posiciones_negro);
conf_negro=confusionmat(conf(:),clas_data_negro(:));
disp('Tabla de confusión data_negro');
disp(conf_negro);
clas_data_negro=clas_data_negro(1:4000,1);
conf=conf(1:4000,1);
conf_negro=confusionmat(conf(:),clas_data_negro(:));
disp('Tabla de confusión data_negro propio');
disp(conf_negro);



%display imagen con zonas seleccionadas
R_zonas=R;
G_zonas=G;
B_zonas=B;

R_zonas(posiciones_gris)=255;
G_zonas(posiciones_gris)=255;
B_zonas(posiciones_gris)=255;

R_zonas(posiciones_gris_oscuro)=255;
G_zonas(posiciones_gris_oscuro)=255;
B_zonas(posiciones_gris_oscuro)=255;

R_zonas(posiciones_negro)=255;
G_zonas(posiciones_negro)=255;
B_zonas(posiciones_negro)=255;

R_zonas(posiciones_rojo)=255;
G_zonas(posiciones_rojo)=255;
B_zonas(posiciones_rojo)=255;

im_zonas=zeros([r,c,b]);
im_zonas(:,:,1)=R_zonas;
im_zonas(:,:,2)=G_zonas;
im_zonas(:,:,3)=B_zonas;
im_zonas=cast(im_zonas, 'uint8');

figure(2), imshow(im_zonas);
title('Imagen con zonas seleccionadas en blanco');



R_zonas(posiciones_gris)=mean_gris(1);
G_zonas(posiciones_gris)=mean_gris(2);
B_zonas(posiciones_gris)=mean_gris(3);
 
R_zonas(posiciones_gris_oscuro)=mean_gris_oscuro(1);
G_zonas(posiciones_gris_oscuro)=mean_gris_oscuro(2);
B_zonas(posiciones_gris_oscuro)=mean_gris_oscuro(3);
 
R_zonas(posiciones_negro)=mean_negro(1);
G_zonas(posiciones_negro)=mean_negro(2);
B_zonas(posiciones_negro)=mean_negro(3);
 
R_zonas(posiciones_rojo)=mean_rojo(1);
G_zonas(posiciones_rojo)=mean_rojo(2);
B_zonas(posiciones_rojo)=mean_rojo(3);

im_zonas=zeros([r,c,b]);
im_zonas(:,:,1)=R_zonas;
im_zonas(:,:,2)=G_zonas;
im_zonas(:,:,3)=B_zonas;
im_zonas=cast(im_zonas, 'uint8');

figure(8), imshow(im_zonas);
title('Imagen con zonas seleccionadas con el color adecuado');
