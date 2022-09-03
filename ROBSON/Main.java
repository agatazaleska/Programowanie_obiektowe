public class Main{
public static double wykonaj(){
double numer = 0;
double index = 0;
double x1 = 0;
double x2 = 0;
double temp = 0;
numer = 10.0;
if(numer<=2.0) {
return 1.0;
}
else{
x1 = 1.0;
x2 = 1.0;
index = 3.0;
while(index<=numer) {
temp = x1 + x2;
x1 = x2;
x2 = temp;
index = index + 1.0;
}
return x2;
}
}
public static void main(String[] args){
double wynik = wykonaj(); System.out.println(wynik);}
}