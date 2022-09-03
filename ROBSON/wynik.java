package wynik;
public class wynik{
public static double wykonaj(){
double numer = 10.0;
if(numer<=2.0) {
return 1.0;
}
else{
double x1 = 1.0;
double x2 = 1.0;
double index = 3.0;
while(index<=numer) {
double temp = x1 + x2;
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