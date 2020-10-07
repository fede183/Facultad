%Valor medio
mus=[1 2.3 1.34 ; 1.26 1.23 2.39];
%Covarianza
sigma = [1 0 0 ; 0 1 0 ; 0 0 1];
sigma(1,1)=89.8;
sigma(2,2)=34;
sigma(3,3)=54.2;
%Pi
pi = [.5,.5];

for i = 1 to 1000
    Respon[n][2];
    for j = 1 to n
        N1 = N(X[j], mus[1], sigma[1]);
        N2 = N(X[j], mus[2], sigma[2]);
        Respon[j][1] = pi[1]*N1/(pi[1]*N1 + pi[2]*N2);
        Respon[j][2] = pi[2]*N1/(pi[1]*N1 + pi[2]*N2);
    end 
    Nk = [0, 0];
    musnew = [0, 0];
    for j = 1 to n
        Nk[1] = Nk[1] + Respon[j][1];
        Nk[2] = Nk[2] + Respon[j][2];
        musnew[1] = musnew[1] + Respon[j][1];
        musnew[2] = musnew[2] + Respon[j][2];
    end
    pinew[2];
    pinew[1] = Nk[1]/n;
    pinew[2] = Nk[2]/n;
    musnew[1] = musnew[1]/Nk[1];
    musnew[2] = musnew[2]/Nk[2];
    sigmanew = ceros(3,3);
    for j = 1 to n
        sigmanew[1] = sigmanew[1] + (Respon[1]*(X[j] - musnew[1])*((X[j] - musnew[1])')/Nk[1]);
        sigmanew[2] = sigmanew[2] + (Respon[2]*(X[j] - musnew[2])*((X[j] - musnew[2])')/Nk[2]);
    end
    pi = pinew;
    sigma = sigmanew;
    mus = musnew;
end