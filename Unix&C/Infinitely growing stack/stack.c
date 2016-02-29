#include <math.h>
#include <stdio.h>

int stackSize = 0
double *stack = NULL;
int sp = 0;

void expandSize(){
  double *newStack;
  int newSize = sizeStack + 10;
  int i;

  newStack = malloc(newSize * sizeof(double));

  for (i = 0; i < stackSize; i++)
    newStack[i] = stack[i];

  if (stack != NULL)
    free(stack);
  
  stack = newStack;
  stackSize = newSize;
}

int push (double d)
{
  if (sp >= stackSize) {
    expandSize();
  }

  stack[sp] = d;
  sp++;

  return 0;
}

double pop ()
{
  double pop;
  if (sp == 0) {
    return NAN;
  }
  pop = stack[--sp];
  
  return pop;
}


int isStackEmpty ()
{
  if (sp == 0)
    return 1;
  else
    return 0;
}

int getStackSize()
{
  return sp;
}

void emptyStack()
{
  sp=0;
}
