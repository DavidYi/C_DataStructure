#include <stdio.h>
#include <math.h>
#include "stack.h"

int main ()
{
  int i;
  double result;

  if (getStackSize() ==0)
    printf ("Passed 1\n");
  else
    printf ("Failed 1\n");

  /* Make sure a pop of an empty stack returns NAN.*/
  result = pop();
  if (isnan(result))
    printf ("Passed 2\n");
  else
    printf ("Failed 2\n");

  
  /* Check if an empty stack returns a non-zero (true) value. */
  emptyStack();

  if (isStackEmpty())
    printf ("Passed 3\n");
  else
    printf ("Failed 3\n");

  /************************************************
  /* Push 15 values on the stack -- 
     Check result, isStackEmpty, and getStackSize */
  for (i=0; i<15; i++)
    result = push (i);

  if (result == 0)
    printf ("Passed 4\n");
  else
    printf ("Failed 4\n");
  
  if (getStackSize() == 15)
    printf ("Passed 5\n");
  else
    printf ("Failed 5\n");

  if (!isStackEmpty())
    printf ("Passed 6\n");
  else
    printf ("Failed 6\n");

  /************************************************
  /* Check two pops */
  /* Then make sure stack size is now 13.
   */
  if (pop() == 14)
    printf ("Passed 6\n");
  else
    printf ("Failed 6\n");

  if (pop() == 13)
    printf ("Passed 7\n");
  else
    printf ("Failed 7\n");

  if (getStackSize() == 13)
    printf ("Passed 8\n");
  else
    printf ("Failed 8\n");

  /************************************************
  * Push 100 values on the stack -- 
  * All should have a result of 0.
  * Then push a 101th value and make sure the result is -1.  
  */
  emptyStack();
  
  for (i=0; i<100; i++) {
    result = push (i);
    if (result != 0) {
      printf("Push 100 failed on %d\n", i);
      break;
    }
  }
    
  result = push(101);
  if (result == 0) 
    printf ("Passed 9\n");
  else
    printf ("Failed 9\n");
}  
  
  
