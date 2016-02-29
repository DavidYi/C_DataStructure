#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>
#include "intlist.h"

int main()
{
  int i;
  IntList *list1;
  IntList *list2;

  srand (1000);
  
  list1 = ilCreate();
  
  for (i=0; i< 10000; i++) {
    int val = (int)(rand()/(double)RAND_MAX * 100);
    ilAppend (list1, val);
   }

  if (ilFind (list1, 35) == 115)
    printf ("Passed 1.\n");
  else
    printf ("Failed 1.\n");
  
  if (ilGet (list1, 84) == 66)
    printf ("Passed 2.\n");
  else
    printf ("Failed 2.\n");
  
  ilInsert (list1, 14, 21);
  ilInsert (list1, 12, 25);
  
  if ((ilGet (list1, 12) == 25) && (ilGet (list1, 15) == 21))
    printf ("Passed 3.\n");
  else
    printf ("Failed 3.\n");
  
  ilDelete (list1, 2);

  if (ilSize(list1) == 10001)
    printf ("Passed 4.\n");
  else
    printf ("Failed 4.\n");


  
  if ((ilGet (list1, 11) == 25) && (ilGet (list1, 14) == 21))
    printf ("Passed 5.\n");
  else
    printf ("Failed 5.\n");

  if (ilGet(list1, 50000) == INT_MIN)
    printf ("Passed 6.\n");
  else
    printf ("Failed 6.\n");

  if (ilGet(list1, -10) == INT_MIN)
    printf ("Passed 7.\n");
  else
    printf ("Failed 7.\n");


  list2 = ilCopy(list1);

  for (i=0; i<9999; i++)
    ilDelete (list2, 0);

  if (ilSize (list2) == 2)
    printf ("Passed 8.\n");
  else
    printf ("Failed 8.\n");    

  if (ilGet(list2,0) == ilGet(list1,9999))
    printf ("Passed 9.\n");
  else
    printf ("Failed 9.\n");        


  if (ilInsert(list1, 50000, 5) == INT_MIN)
    printf ("Passed 10.\n");
  else
    printf ("Failed 10.\n");

  if (ilInsert(list1, -10, 5) == INT_MIN)
    printf ("Passed 11.\n");
  else
    printf ("Failed 11.\n");
}
  
