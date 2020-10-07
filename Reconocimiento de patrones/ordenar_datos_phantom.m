function ordenar_datos_phantom(phantom)

%eliminar bordes
im=eliminar_bordes(phantom);
im=eliminar_bordes(im);
im=eliminar_bordes(im);
im=im(2:339,2:639);


%Valor medio
mus=[1 2.3 1.34 ; 1.26 1.23 2.39 ; 8.0 1.47 .53 ; 2.01 1.99 .60 ; 1.88 1.52 .81 ; 2.39 1.24 .67];
%covarianza isotropicas e iguales entre si
sigma_iso_iguales1 = 0.5*[1 0 0 ; 0 1 0 ; 0 0 1];

sigma_iso_iguales2 = 20*[1 0 0 ; 0 1 0 ; 0 0 1];

%covarianza diagonales y diferentes para cada clase
sigma_iso_distintas1 = [1 0 0 ; 0 1 0 ; 0 0 1];
sigma_iso_distintas1(1,1)=0.5;
sigma_iso_distintas1(2,2)=0.4;
sigma_iso_distintas1(3,3)=0.7;

sigma_iso_distintas2 = [1 0 0 ; 0 1 0 ; 0 0 1];
sigma_iso_distintas2(1,1)=89.8;
sigma_iso_distintas2(2,2)=34;
sigma_iso_distintas2(3,3)=54.2;


%covarianza diferentes no-diagonales y diferentes para cada clase
sigma_nodiag1 = [.6 .3 .2 ; .3 .2 .15 ; .20 .15 .12];
sigma_nodiag2 = 20*sigma_nodiag1;


%generar y clasificar
phantomG = generar_imagen(im , mus, sigma_iso_iguales1);
figure(1), imshow(phantomG);
title('Imagen con covarianza isotropicas e iguales entre si (1)');
phantomC = clasificar(phantomG, mus, sigma_iso_iguales1);
phantomC= confusionmat(im(:), phantomC(:));
disp('Tabla de confusion del caso con covarianza isotropicas e iguales entre si. (1)');
disp(phantomC);


phantomG = generar_imagen(im , mus, sigma_iso_iguales2);
figure(2), imshow(phantomG);
title('Imagen con covarianza isotropicas e iguales entre si (2)');
phantomC = clasificar(phantomG, mus, sigma_iso_iguales2);
phantomC= confusionmat(im(:), phantomC(:));
disp('Tabla de confusion del caso con covarianza isotropicas e iguales entre si. (2)');
disp(phantomC);

phantomG = generar_imagen(im , mus, sigma_iso_distintas1);
figure(3), imshow(phantomG);
title('Imagen con covarianza diagonales y diferentes para cada clase (1)');
phantomC = clasificar(phantomG, mus, sigma_iso_distintas1);
phantomC= confusionmat(im(:), phantomC(:));
disp('Tabla de confusion del caso con covarianza diagonales y diferentes para cada clase. (1)');
disp(phantomC);

phantomG = generar_imagen(im , mus, sigma_iso_distintas2);
figure(4), imshow(phantomG);
title('Imagen con covarianza diagonales y diferentes para cada clase (2)');
phantomC = clasificar(phantomG, mus, sigma_iso_distintas2);
phantomC= confusionmat(im(:), phantomC(:));
disp('Tabla de confusion del caso con covarianza diagonales y diferentes para cada clase. (2)');
disp(phantomC);



phantomG = generar_imagen(im , mus, sigma_nodiag1);
figure(5), imshow(phantomG);
title('Imagen con covarianza no-diagonales y diferentes para cada clase (1)');
phantomC = clasificar(phantomG, mus, sigma_nodiag1);
phantomC= confusionmat(im(:), phantomC(:));
disp('Tabla de confusion del caso con covarianza no-diagonales y diferentes para cada clase. (1)');
disp(phantomC);

phantomG = generar_imagen(im , mus, sigma_nodiag2);
figure(6), imshow(phantomG);
title('Imagen con covarianza no-diagonales y no-diferentes para cada clase (2)');
phantomC = clasificar(phantomG, mus, sigma_nodiag2);
phantomC= confusionmat(im(:), phantomC(:));
disp('Tabla de confusion del caso con covarianza no-diagonales y diferentes para cada clase. (2)');
disp(phantomC);

end