#include <stdio.h>
#include <stdlib.h>

void swap (int *a, int *b){
  int c;
  
  c = *a;
  *a = *b;
  *b = c;
}

int main (){
  int a, b;
  
  a = 10;
  b = 5;

  swap (&a, &b);
  printf ("a = %d; b = %d\n", a, b);
}
