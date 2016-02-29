#define STACK_SIZE 100
#include <stdio.h>
#include <math.h>

double stack[STACK_SIZE];
int sp = 0;

int push(double d){
  if (sp >= STACK_SIZE)
    return -1;
  stack[sp++] = d;
  return 0;
}
double pop(){
  if (sp ==0){
    return NAN;
  }
  return stack[--sp];
}

int isStackEmpty(){
  if (sp == 0)
    return 1;
  return 0;
}
int getStackSize(){
  return sp;
}
void emptyStack(){
  sp=0;
}
