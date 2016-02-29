#include <stdio.h>
#define FREEZING 32
#define BOILING 212

double f_to_c(int f){
  double c = ((double) f - 32) * 5 / 9;
  return c;
}

main(){
  double c;
  int f;

    printf("%14s%14s\n", "Fahrenheit", "Celsius");

  for (f = FREEZING; f <= BOILING; f += 10){
    c = f_to_c(f);
    printf("%14d\t%12.1f\n", f, c);
  }
  
}
