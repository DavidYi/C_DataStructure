#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "stack.h"

int main ()
{
  int i;
  int val;
  double result;
  Stack *stackA;
  Stack *stackB;

  srand (50);
  
  stackA = createStack();
  stackB = createStack();

  push (stackA, 14);
  push (stackA, 25);
  push (stackA, 31);

  for (i=0; i<150; i++) {
    val = (int)(rand()/(double)RAND_MAX * 1000);
    push (stackA, val);

    val = (int)(rand()/(double)RAND_MAX * 100);
    push (stackB, val);  
  }


  if (getStackSize(stackA) == 153)
    printf ("Passed 1\n");
  else
    printf ("Failed 1\n");


  if (getStackSize(stackB) == 150)
    printf ("Passed 2\n");
  else
    printf ("Failed 2\n");  

  for (i=0; i<149; i++) {
    pop(stackA);
    pop(stackB);
  }

  printf ("Final pop B = %f\n", pop(stackB));

  if (isStackEmpty(stackB))     
    printf ("Passed 3\n");
  else
    printf ("Failed 3\n");

  if (!isStackEmpty(stackA))     
    printf ("Passed 4\n");
  else
    printf ("Failed 4\n");
  
  printf ("Pop A = %f\n", pop(stackA));
  printf ("Pop A = %f\n", pop(stackA));
  printf ("Pop A = %f\n", pop(stackA));
  printf ("Pop A = %f\n", pop(stackA));
      
  if (isStackEmpty(stackA))     
    printf ("Passed 5\n");
  else
    printf ("Failed 5\n");    
	  
}  
  
  
