#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "stack.h"

int main ()
{
  Stack *stackA;
  Stack *stackB;

  stackA = createStack();
  stackB = createStack();

  push (stackA, 14);
  push (stackA, 25);
  push (stackA, 31);
  push (stackB, 99);

  if (pop (stackA) == 31)
    printf ("Passed 1\n");
  else
    printf ("Failed 1\n");

  if (pop (stackA) == 25)
    printf ("Passed 2\n");
  else
    printf ("Failed 2\n");

  if (getStackSize (stackA) == 1)
    printf ("Passed 3\n");
  else
    printf ("Failed 3\n");
  
  if (pop (stackA) == 14)
    printf ("Passed 4\n");
  else
    printf ("Failed 4\n");

  if (isStackEmpty (stackA))
    printf ("Passed 5\n");
  else
    printf ("Failed 5\n");
  
  if (pop (stackB) == 99)
    printf ("Passed 6\n");
  else
    printf ("Failed 6\n");

}  
  
  
